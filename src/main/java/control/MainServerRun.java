package control;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import webInterface.CustomHttpHandler;

/**
 * Starts RESTful server
 */
public class MainServerRun {

	public static void main(String[] args) {

		// Establish a local HTTP server
		HttpServer server = null;
		CustomHttpHandler customHandler = new CustomHttpHandler();
		
		try {
			server = HttpServer.create(new InetSocketAddress(8000), 0);
			customHandler.init();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error establishing local HTTP server & handler.");
			return;
		}

		server.createContext("/analyze", customHandler);
		server.start();

	}

}
