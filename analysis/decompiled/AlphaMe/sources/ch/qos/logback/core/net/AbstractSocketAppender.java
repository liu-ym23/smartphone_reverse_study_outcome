package ch.qos.logback.core.net;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import ch.qos.logback.core.util.CloseUtil;
import ch.qos.logback.core.util.Duration;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public abstract class AbstractSocketAppender<E> extends AppenderBase<E> implements Runnable, SocketConnector.ExceptionHandler {
    private static final int DEFAULT_ACCEPT_CONNECTION_DELAY = 5000;
    private static final int DEFAULT_EVENT_DELAY_TIMEOUT = 100;
    public static final int DEFAULT_PORT = 4560;
    public static final int DEFAULT_QUEUE_SIZE = 128;
    public static final int DEFAULT_RECONNECTION_DELAY = 30000;
    private InetAddress address;
    private Future<Socket> connectorTask;
    private String peerId;
    private BlockingQueue<E> queue;
    private String remoteHost;
    private volatile Socket socket;
    private Future<?> task;
    private int port = DEFAULT_PORT;
    private Duration reconnectionDelay = new Duration(30000);
    private int queueSize = 128;
    private int acceptConnectionTimeout = 5000;
    private Duration eventDelayLimit = new Duration(100);

    private Future<Socket> activateConnector(SocketConnector socketConnector) {
        try {
            return getContext().getExecutorService().submit(socketConnector);
        } catch (RejectedExecutionException unused) {
            return null;
        }
    }

    private SocketConnector createConnector(InetAddress inetAddress, int i4, int i5, long j4) {
        SocketConnector socketConnectorNewConnector = newConnector(inetAddress, i4, i5, j4);
        socketConnectorNewConnector.setExceptionHandler(this);
        socketConnectorNewConnector.setSocketFactory(getSocketFactory());
        return socketConnectorNewConnector;
    }

    private void dispatchEvents() throws InterruptedException, IOException {
        try {
            try {
                this.socket.setSoTimeout(this.acceptConnectionTimeout);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
                this.socket.setSoTimeout(0);
                addInfo(this.peerId + "connection established");
                while (true) {
                    int i4 = 0;
                    do {
                        E eTake = this.queue.take();
                        postProcessEvent(eTake);
                        objectOutputStream.writeObject(getPST().transform(eTake));
                        objectOutputStream.flush();
                        i4++;
                    } while (i4 < 70);
                    objectOutputStream.reset();
                }
            } catch (IOException e4) {
                addInfo(this.peerId + "connection failed: " + e4);
                CloseUtil.closeQuietly(this.socket);
                this.socket = null;
                addInfo(this.peerId + "connection closed");
            }
        } catch (Throwable th) {
            CloseUtil.closeQuietly(this.socket);
            this.socket = null;
            addInfo(this.peerId + "connection closed");
            throw th;
        }
    }

    @Deprecated
    public static InetAddress getAddressByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception unused) {
            return null;
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

    @Override // ch.qos.logback.core.AppenderBase
    public void append(E e4) {
        if (e4 == null || !isStarted()) {
            return;
        }
        try {
            if (this.queue.offer(e4, this.eventDelayLimit.getMilliseconds(), TimeUnit.MILLISECONDS)) {
                return;
            }
            addInfo("Dropping event due to timeout limit of [" + this.eventDelayLimit + "] milliseconds being exceeded");
        } catch (InterruptedException e5) {
            addError("Interrupted while appending event to SocketAppender", e5);
        }
    }

    @Override // ch.qos.logback.core.net.SocketConnector.ExceptionHandler
    public void connectionFailed(SocketConnector socketConnector, Exception exc) {
        if (exc instanceof InterruptedException) {
            addInfo("connector interrupted");
            return;
        }
        if (exc instanceof ConnectException) {
            addInfo(this.peerId + "connection refused");
            return;
        }
        addInfo(this.peerId + exc);
    }

    public Duration getEventDelayLimit() {
        return this.eventDelayLimit;
    }

    public abstract PreSerializationTransformer<E> getPST();

    public int getPort() {
        return this.port;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public Duration getReconnectionDelay() {
        return this.reconnectionDelay;
    }

    public String getRemoteHost() {
        return this.remoteHost;
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public BlockingQueue<E> newBlockingQueue(int i4) {
        return i4 <= 0 ? new SynchronousQueue() : new ArrayBlockingQueue(i4);
    }

    public SocketConnector newConnector(InetAddress inetAddress, int i4, long j4, long j5) {
        return new DefaultSocketConnector(inetAddress, i4, j4, j5);
    }

    public abstract void postProcessEvent(E e4);

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        signalEntryInRunMethod();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Future<Socket> futureActivateConnector = activateConnector(createConnector(this.address, this.port, 0, this.reconnectionDelay.getMilliseconds()));
                this.connectorTask = futureActivateConnector;
                if (futureActivateConnector == null) {
                    break;
                }
                this.socket = waitForConnectorToReturnASocket();
                if (this.socket == null) {
                    break;
                } else {
                    dispatchEvents();
                }
            } catch (InterruptedException unused) {
            }
        }
        addInfo("shutting down");
    }

    public void setAcceptConnectionTimeout(int i4) {
        this.acceptConnectionTimeout = i4;
    }

    public void setEventDelayLimit(Duration duration) {
        this.eventDelayLimit = duration;
    }

    public void setPort(int i4) {
        this.port = i4;
    }

    public void setQueueSize(int i4) {
        this.queueSize = i4;
    }

    public void setReconnectionDelay(Duration duration) {
        this.reconnectionDelay = duration;
    }

    public void setRemoteHost(String str) {
        this.remoteHost = str;
    }

    public void signalEntryInRunMethod() {
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int i4;
        if (isStarted()) {
            return;
        }
        if (this.port <= 0) {
            addError("No port was configured for appender" + this.name + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_port");
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (this.remoteHost == null) {
            i4++;
            addError("No remote host was configured for appender" + this.name + " For more information, please visit http://logback.qos.ch/codes.html#socket_no_host");
        }
        if (this.queueSize < 0) {
            i4++;
            addError("Queue size must be non-negative");
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
            this.queue = newBlockingQueue(this.queueSize);
            StringBuilder sb = new StringBuilder("remote peer ");
            sb.append(this.remoteHost);
            sb.append(AwarenessDataItem.USERID_SPLITTER);
            this.peerId = AbstractC0831a.d(sb, this.port, ": ");
            this.task = getContext().getExecutorService().submit(this);
            super.start();
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() throws IOException {
        if (isStarted()) {
            CloseUtil.closeQuietly(this.socket);
            this.task.cancel(true);
            Future<Socket> future = this.connectorTask;
            if (future != null) {
                future.cancel(true);
            }
            super.stop();
        }
    }
}
