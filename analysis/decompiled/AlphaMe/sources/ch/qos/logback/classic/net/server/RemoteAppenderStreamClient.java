package ch.qos.logback.classic.net.server;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.util.CloseUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/* loaded from: classes.dex */
class RemoteAppenderStreamClient implements RemoteAppenderClient {
    private final String id;
    private final InputStream inputStream;
    private LoggerContext lc;
    private Logger logger;
    private final Socket socket;

    public RemoteAppenderStreamClient(String str, Socket socket) {
        this.id = str;
        this.socket = socket;
        this.inputStream = null;
    }

    private ObjectInputStream createObjectInputStream() throws IOException {
        return this.inputStream != null ? new ObjectInputStream(this.inputStream) : new ObjectInputStream(this.socket.getInputStream());
    }

    @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Socket socket = this.socket;
        if (socket == null) {
            return;
        }
        CloseUtil.closeQuietly(socket);
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        Logger logger;
        StringBuilder sb;
        this.logger.info(this + ": connected");
        ObjectInputStream objectInputStreamCreateObjectInputStream = null;
        try {
            try {
                try {
                    objectInputStreamCreateObjectInputStream = createObjectInputStream();
                    while (true) {
                        ILoggingEvent iLoggingEvent = (ILoggingEvent) objectInputStreamCreateObjectInputStream.readObject();
                        Logger logger2 = this.lc.getLogger(iLoggingEvent.getLoggerName());
                        if (logger2.isEnabledFor(iLoggingEvent.getLevel())) {
                            logger2.callAppenders(iLoggingEvent);
                        }
                    }
                } catch (EOFException unused) {
                    if (objectInputStreamCreateObjectInputStream != null) {
                        CloseUtil.closeQuietly(objectInputStreamCreateObjectInputStream);
                    }
                    close();
                    logger = this.logger;
                    sb = new StringBuilder();
                    sb.append(this);
                    sb.append(": connection closed");
                    logger.info(sb.toString());
                } catch (ClassNotFoundException unused2) {
                    this.logger.error(this + ": unknown event class");
                    if (objectInputStreamCreateObjectInputStream != null) {
                        CloseUtil.closeQuietly(objectInputStreamCreateObjectInputStream);
                    }
                    close();
                    logger = this.logger;
                    sb = new StringBuilder();
                    sb.append(this);
                    sb.append(": connection closed");
                    logger.info(sb.toString());
                }
            } catch (IOException e4) {
                this.logger.info(this + ": " + e4);
                if (objectInputStreamCreateObjectInputStream != null) {
                    CloseUtil.closeQuietly(objectInputStreamCreateObjectInputStream);
                }
                close();
                logger = this.logger;
                sb = new StringBuilder();
                sb.append(this);
                sb.append(": connection closed");
                logger.info(sb.toString());
            } catch (RuntimeException e5) {
                this.logger.error(this + ": " + e5);
                if (objectInputStreamCreateObjectInputStream != null) {
                    CloseUtil.closeQuietly(objectInputStreamCreateObjectInputStream);
                }
                close();
                logger = this.logger;
                sb = new StringBuilder();
                sb.append(this);
                sb.append(": connection closed");
                logger.info(sb.toString());
            }
        } catch (Throwable th) {
            if (objectInputStreamCreateObjectInputStream != null) {
                CloseUtil.closeQuietly(objectInputStreamCreateObjectInputStream);
            }
            close();
            this.logger.info(this + ": connection closed");
            throw th;
        }
    }

    @Override // ch.qos.logback.classic.net.server.RemoteAppenderClient
    public void setLoggerContext(LoggerContext loggerContext) {
        this.lc = loggerContext;
        this.logger = loggerContext.getLogger(getClass().getPackage().getName());
    }

    public String toString() {
        return "client " + this.id;
    }

    public RemoteAppenderStreamClient(String str, InputStream inputStream) {
        this.id = str;
        this.socket = null;
        this.inputStream = inputStream;
    }
}
