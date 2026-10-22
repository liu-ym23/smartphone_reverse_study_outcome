package ch.qos.logback.classic.net;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.net.ServerSocketFactory;
import n3.AbstractC0782c;
import n3.InterfaceC0781b;

/* loaded from: classes.dex */
public class SimpleSocketServer extends Thread {
    private boolean closed;
    private CountDownLatch latch;
    private final LoggerContext lc;
    InterfaceC0781b logger;
    private final int port;
    private ServerSocket serverSocket;
    private List<SocketNode> socketNodeList;

    public SimpleSocketServer(LoggerContext loggerContext, int i4) {
        int i5 = AbstractC0782c.f13664a;
        this.logger = AbstractC0782c.e(SimpleSocketServer.class.getName());
        this.closed = false;
        this.socketNodeList = new ArrayList();
        this.lc = loggerContext;
        this.port = i4;
    }

    public static void configureLC(LoggerContext loggerContext, String str) throws Throwable {
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        loggerContext.reset();
        joranConfigurator.setContext(loggerContext);
        joranConfigurator.doConfigure(str);
    }

    public static void doMain(Class<? extends SimpleSocketServer> cls, String[] strArr) throws Exception {
        int portNumber;
        if (strArr.length == 2) {
            portNumber = parsePortNumber(strArr[0]);
        } else {
            usage("Wrong number of arguments.");
            portNumber = -1;
        }
        String str = strArr[1];
        LoggerContext loggerContext = (LoggerContext) AbstractC0782c.c();
        configureLC(loggerContext, str);
        new SimpleSocketServer(loggerContext, portNumber).start();
    }

    public static void main(String[] strArr) throws Exception {
        doMain(SimpleSocketServer.class, strArr);
    }

    public static int parsePortNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            usage("Could not interpret port number [" + str + "].");
            return -1;
        }
    }

    public static void usage(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Usage: java " + SimpleSocketServer.class.getName() + " port configFile");
        System.exit(1);
    }

    public void close() {
        this.closed = true;
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            try {
                try {
                    serverSocket.close();
                } catch (IOException e4) {
                    this.logger.error("Failed to close serverSocket", e4);
                }
            } finally {
                this.serverSocket = null;
            }
        }
        this.logger.info("closing this server");
        synchronized (this.socketNodeList) {
            try {
                Iterator<SocketNode> it = this.socketNodeList.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.socketNodeList.size() != 0) {
            this.logger.warn("Was expecting a 0-sized socketNodeList after server shutdown");
        }
    }

    public String getClientThreadName(Socket socket) {
        return String.format("Logback SocketNode (client: %s)", socket.getRemoteSocketAddress());
    }

    public CountDownLatch getLatch() {
        return this.latch;
    }

    public ServerSocketFactory getServerSocketFactory() {
        return ServerSocketFactory.getDefault();
    }

    public String getServerThreadName() {
        return String.format("Logback %s (port %d)", getClass().getSimpleName(), Integer.valueOf(this.port));
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            try {
                Thread.currentThread().setName(getServerThreadName());
                this.logger.info("Listening on port " + this.port);
                this.serverSocket = getServerSocketFactory().createServerSocket(this.port);
                while (!this.closed) {
                    this.logger.info("Waiting to accept a new client.");
                    signalAlmostReadiness();
                    Socket socketAccept = this.serverSocket.accept();
                    this.logger.info("Connected to client at " + socketAccept.getInetAddress());
                    this.logger.info("Starting new socket node.");
                    SocketNode socketNode = new SocketNode(this, socketAccept, this.lc);
                    synchronized (this.socketNodeList) {
                        this.socketNodeList.add(socketNode);
                    }
                    new Thread(socketNode, getClientThreadName(socketAccept)).start();
                }
            } catch (Exception e4) {
                if (this.closed) {
                    this.logger.info("Exception in run method for a closed server. This is normal.");
                } else {
                    this.logger.error("Unexpected failure in run method", e4);
                }
            }
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    public void setLatch(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    public void signalAlmostReadiness() {
        CountDownLatch countDownLatch = this.latch;
        if (countDownLatch == null || countDownLatch.getCount() == 0) {
            return;
        }
        this.latch.countDown();
    }

    public void socketNodeClosing(SocketNode socketNode) {
        this.logger.debug("Removing {}", socketNode);
        synchronized (this.socketNodeList) {
            this.socketNodeList.remove(socketNode);
        }
    }
}
