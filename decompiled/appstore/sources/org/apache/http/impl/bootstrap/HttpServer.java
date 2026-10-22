package org.apache.http.impl.bootstrap;

import androidx.lifecycle.p;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import kotlinx.coroutines.channels.Channel;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.protocol.HttpService;

/* JADX INFO: loaded from: classes4.dex */
public class HttpServer {
    private final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpService;
    private final InetAddress ifAddress;
    private final ThreadPoolExecutor listenerExecutorService;
    private final int port;
    private volatile RequestListener requestListener;
    private volatile ServerSocket serverSocket;
    private final ServerSocketFactory serverSocketFactory;
    private final SocketConfig socketConfig;
    private final SSLServerSetupHandler sslSetupHandler;
    private final AtomicReference<Status> status;
    private final WorkerPoolExecutor workerExecutorService;
    private final ThreadGroup workerThreads;

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACTIVE = null;
        public static final Status READY = null;
        public static final Status STOPPING = null;

        static {
            Status r10 = new Status("READY", 0);
            READY = r10;
            Status r11 = new Status("ACTIVE", 1);
            ACTIVE = r11;
            Status r12 = new Status("STOPPING", 2);
            STOPPING = r12;
            $VALUES = new Status[]{r10, r11, r12};
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public HttpServer(int r10, InetAddress r11, SocketConfig r12, ServerSocketFactory r13, HttpService r14, HttpConnectionFactory<? extends DefaultBHttpServerConnection> r15, SSLServerSetupHandler r16, ExceptionLogger r17) {
        this.port = r10;
        this.ifAddress = r11;
        this.socketConfig = r12;
        this.serverSocketFactory = r13;
        this.httpService = r14;
        this.connectionFactory = r15;
        this.sslSetupHandler = r16;
        this.exceptionLogger = r17;
        this.listenerExecutorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-listener-" + r10));
        ThreadGroup r18 = new ThreadGroup("HTTP-workers");
        this.workerThreads = r18;
        this.workerExecutorService = new WorkerPoolExecutor(0, Channel.UNLIMITED, 1, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-worker", r18));
        this.status = new AtomicReference(Status.READY);
    }

    public void awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
        this.workerExecutorService.awaitTermination(r10, r11);
    }

    public InetAddress getInetAddress() {
        ServerSocket r10 = this.serverSocket;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getInetAddress();
    }

    public int getLocalPort() {
        ServerSocket r10 = this.serverSocket;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getLocalPort();
    }

    public void shutdown(long r10, TimeUnit r11) {
        stop();
        if (r10 > 0) goto L18;
    L7:
        Iterator<Worker> r12 = this.workerExecutorService.getWorkers().iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        r12.next().getConnection().shutdown();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        this.exceptionLogger.log(e);
        goto L9
    L15:
        return;
    L18:
        awaitTermination(r10, r11);     // Catch: InterruptedException -> L6
    L6:
        Thread.currentThread().interrupt();
        goto L7
    }

    public void start() throws IOException {
        if (p.a(this.status, Status.READY, Status.ACTIVE) == false) goto L14;
        this.serverSocket = this.serverSocketFactory.createServerSocket(this.port, this.socketConfig.getBacklogSize(), this.ifAddress);
        this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
        if (this.socketConfig.getRcvBufSize() <= 0) goto L8;
        this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
    L8:
        if (this.sslSetupHandler != null) goto L10;
    L12:
        this.requestListener = new RequestListener(this.socketConfig, this.serverSocket, this.httpService, this.connectionFactory, this.exceptionLogger, this.workerExecutorService);
        this.listenerExecutorService.execute(this.requestListener);
        return;
    L10:
        if ((this.serverSocket instanceof SSLServerSocket) == false) goto L12;
        this.sslSetupHandler.initialize((SSLServerSocket) this.serverSocket);
        goto L12
    }

    public void stop() {
        if (p.a(this.status, Status.ACTIVE, Status.STOPPING) == false) goto L14;
        this.listenerExecutorService.shutdown();
        this.workerExecutorService.shutdown();
        RequestListener r10 = this.requestListener;
        if (r10 != null) goto L12;
    L10:
        this.workerThreads.interrupt();
        return;
    L12:
        r10.terminate();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        this.exceptionLogger.log(e);
        goto L10
    }
}
