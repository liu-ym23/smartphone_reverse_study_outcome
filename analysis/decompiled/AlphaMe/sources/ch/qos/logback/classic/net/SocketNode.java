package ch.qos.logback.classic.net;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

/* loaded from: classes.dex */
public class SocketNode implements Runnable {
    boolean closed = false;
    LoggerContext context;
    Logger logger;
    ObjectInputStream ois;
    SocketAddress remoteSocketAddress;
    Socket socket;
    SimpleSocketServer socketServer;

    public SocketNode(SimpleSocketServer simpleSocketServer, Socket socket, LoggerContext loggerContext) {
        this.socketServer = simpleSocketServer;
        this.socket = socket;
        this.remoteSocketAddress = socket.getRemoteSocketAddress();
        this.context = loggerContext;
        this.logger = loggerContext.getLogger(SocketNode.class);
    }

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        ObjectInputStream objectInputStream = this.ois;
        if (objectInputStream != null) {
            try {
                try {
                    objectInputStream.close();
                } catch (IOException e4) {
                    this.logger.warn("Could not close connection.", (Throwable) e4);
                }
            } finally {
                this.ois = null;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.ois = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
        } catch (Exception e4) {
            this.logger.error("Could not open ObjectInputStream to " + this.socket, (Throwable) e4);
            this.closed = true;
        }
        while (!this.closed) {
            try {
                ILoggingEvent iLoggingEvent = (ILoggingEvent) this.ois.readObject();
                Logger logger = this.context.getLogger(iLoggingEvent.getLoggerName());
                if (logger.isEnabledFor(iLoggingEvent.getLevel())) {
                    logger.callAppenders(iLoggingEvent);
                }
            } catch (EOFException unused) {
                this.logger.info("Caught java.io.EOFException closing connection.");
            } catch (SocketException unused2) {
                this.logger.info("Caught java.net.SocketException closing connection.");
            } catch (IOException e5) {
                this.logger.info("Caught java.io.IOException: " + e5);
                this.logger.info("Closing connection.");
            } catch (Exception e6) {
                this.logger.error("Unexpected exception. Closing connection.", (Throwable) e6);
            }
        }
        this.socketServer.socketNodeClosing(this);
        close();
    }

    public String toString() {
        return getClass().getName() + this.remoteSocketAddress.toString();
    }
}
