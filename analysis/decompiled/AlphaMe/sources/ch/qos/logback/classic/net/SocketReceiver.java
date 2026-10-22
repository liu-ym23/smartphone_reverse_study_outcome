package ch.qos.logback.classic.net;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.net.DefaultSocketConnector;
import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.util.CloseUtil;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import javax.net.SocketFactory;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class SocketReceiver extends ReceiverBase implements Runnable, SocketConnector.ExceptionHandler {
    private static final int DEFAULT_ACCEPT_CONNECTION_DELAY = 5000;
    private int acceptConnectionTimeout = 5000;
    private InetAddress address;
    private Future<Socket> connectorTask;
    private int port;
    private String receiverId;
    private int reconnectionDelay;
    private String remoteHost;
    private volatile Socket socket;

    private Future<Socket> activateConnector(SocketConnector socketConnector) {
        try {
            return getContext().getExecutorService().submit(socketConnector);
        } catch (RejectedExecutionException unused) {
            return null;
        }
    }

    private SocketConnector createConnector(InetAddress inetAddress, int i4, int i5, int i6) {
        SocketConnector socketConnectorNewConnector = newConnector(inetAddress, i4, i5, i6);
        socketConnectorNewConnector.setExceptionHandler(this);
        socketConnectorNewConnector.setSocketFactory(getSocketFactory());
        return socketConnectorNewConnector;
    }

    private void dispatchEvents(LoggerContext loggerContext) throws IOException {
        StringBuilder sb;
        try {
            try {
                this.socket.setSoTimeout(this.acceptConnectionTimeout);
                ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
                this.socket.setSoTimeout(0);
                addInfo(this.receiverId + "connection established");
                while (true) {
                    ILoggingEvent iLoggingEvent = (ILoggingEvent) objectInputStream.readObject();
                    Logger logger = loggerContext.getLogger(iLoggingEvent.getLoggerName());
                    if (logger.isEnabledFor(iLoggingEvent.getLevel())) {
                        logger.callAppenders(iLoggingEvent);
                    }
                }
            } catch (EOFException unused) {
                addInfo(this.receiverId + "end-of-stream detected");
                CloseUtil.closeQuietly(this.socket);
                this.socket = null;
                sb = new StringBuilder();
                sb.append(this.receiverId);
                sb.append("connection closed");
                addInfo(sb.toString());
            } catch (IOException e4) {
                addInfo(this.receiverId + "connection failed: " + e4);
                CloseUtil.closeQuietly(this.socket);
                this.socket = null;
                sb = new StringBuilder();
                sb.append(this.receiverId);
                sb.append("connection closed");
                addInfo(sb.toString());
            } catch (ClassNotFoundException e5) {
                addInfo(this.receiverId + "unknown event class: " + e5);
                CloseUtil.closeQuietly(this.socket);
                this.socket = null;
                sb = new StringBuilder();
                sb.append(this.receiverId);
                sb.append("connection closed");
                addInfo(sb.toString());
            }
        } catch (Throwable th) {
            CloseUtil.closeQuietly(this.socket);
            this.socket = null;
            addInfo(this.receiverId + "connection closed");
            throw th;
        }
    }

    private Socket waitForConnectorToReturnASocket() throws ExecutionException, InterruptedException {
        try {
            Socket socket = this.connectorTask.get();
            this.connectorTask = null;
            return socket;
        } catch (ExecutionException unused) {
            return null;
        }
    }

    @Override // ch.qos.logback.core.net.SocketConnector.ExceptionHandler
    public void connectionFailed(SocketConnector socketConnector, Exception exc) {
        if (exc instanceof InterruptedException) {
            addInfo("connector interrupted");
            return;
        }
        if (exc instanceof ConnectException) {
            addInfo(this.receiverId + "connection refused");
            return;
        }
        addInfo(this.receiverId + exc);
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public Runnable getRunnableTask() {
        return this;
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public SocketConnector newConnector(InetAddress inetAddress, int i4, int i5, int i6) {
        return new DefaultSocketConnector(inetAddress, i4, i5, i6);
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public void onStop() throws IOException {
        if (this.socket != null) {
            CloseUtil.closeQuietly(this.socket);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        try {
            LoggerContext loggerContext = (LoggerContext) getContext();
            while (!Thread.currentThread().isInterrupted()) {
                Future<Socket> futureActivateConnector = activateConnector(createConnector(this.address, this.port, 0, this.reconnectionDelay));
                this.connectorTask = futureActivateConnector;
                if (futureActivateConnector == null) {
                    break;
                }
                this.socket = waitForConnectorToReturnASocket();
                if (this.socket == null) {
                    break;
                } else {
                    dispatchEvents(loggerContext);
                }
            }
        } catch (InterruptedException unused) {
        }
        addInfo("shutting down");
    }

    public void setAcceptConnectionTimeout(int i4) {
        this.acceptConnectionTimeout = i4;
    }

    public void setPort(int i4) {
        this.port = i4;
    }

    public void setReconnectionDelay(int i4) {
        this.reconnectionDelay = i4;
    }

    public void setRemoteHost(String str) {
        this.remoteHost = str;
    }

    @Override // ch.qos.logback.classic.net.ReceiverBase
    public boolean shouldStart() {
        int i4;
        if (this.port == 0) {
            addError("No port was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_port");
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (this.remoteHost == null) {
            i4++;
            addError("No host name or address was configured for receiver. For more information, please visit http://logback.qos.ch/codes.html#receiver_no_host");
        }
        if (this.reconnectionDelay == 0) {
            this.reconnectionDelay = 30000;
        }
        if (i4 == 0) {
            try {
                this.address = InetAddress.getByName(this.remoteHost);
            } catch (UnknownHostException unused) {
                addError("unknown host: " + this.remoteHost);
                i4++;
            }
        }
        if (i4 == 0) {
            StringBuilder sb = new StringBuilder("receiver ");
            sb.append(this.remoteHost);
            sb.append(AwarenessDataItem.USERID_SPLITTER);
            this.receiverId = AbstractC0831a.d(sb, this.port, ": ");
        }
        return i4 == 0;
    }
}
