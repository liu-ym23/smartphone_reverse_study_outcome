package org.apache.http.impl.bootstrap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.config.SocketConfig;
import org.apache.http.protocol.HttpService;

/* JADX INFO: loaded from: classes4.dex */
class RequestListener implements Runnable {
    private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final ExecutorService executorService;
    private final HttpService httpService;
    private final ServerSocket serversocket;
    private final SocketConfig socketConfig;
    private final AtomicBoolean terminated;

    public RequestListener(SocketConfig r10, ServerSocket r11, HttpService r12, HttpConnectionFactory<? extends HttpServerConnection> r13, ExceptionLogger r14, ExecutorService r15) {
        this.socketConfig = r10;
        this.serversocket = r11;
        this.connectionFactory = r13;
        this.httpService = r12;
        this.exceptionLogger = r14;
        this.executorService = r15;
        this.terminated = new AtomicBoolean(false);
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    @Override // java.lang.Runnable
    public void run() {
    L21:
        if (isTerminated() == true) goto L27;
        if (Thread.interrupted() == true) goto L28;
        Socket r10 = this.serversocket.accept();     // Catch: Exception -> L9
        r10.setSoTimeout(this.socketConfig.getSoTimeout());     // Catch: Exception -> L9
        r10.setKeepAlive(this.socketConfig.isSoKeepAlive());     // Catch: Exception -> L9
        r10.setTcpNoDelay(this.socketConfig.isTcpNoDelay());     // Catch: Exception -> L9
        if (this.socketConfig.getRcvBufSize() <= 0) goto L12;
        r10.setReceiveBufferSize(this.socketConfig.getRcvBufSize());     // Catch: Exception -> L9
    L12:
        if (this.socketConfig.getSndBufSize() <= 0) goto L15;
        r10.setSendBufferSize(this.socketConfig.getSndBufSize());     // Catch: Exception -> L9
    L15:
        if (this.socketConfig.getSoLinger() < 0) goto L17;
        r10.setSoLinger(true, this.socketConfig.getSoLinger());     // Catch: Exception -> L9
    L17:
        HttpServerConnection r11 = (HttpServerConnection) this.connectionFactory.createConnection(r10);     // Catch: Exception -> L9
        Worker r12 = new Worker(this.httpService, r11, this.exceptionLogger);     // Catch: Exception -> L9
        this.executorService.execute(r12);     // Catch: Exception -> L9
        goto L21
    L28:
        return;
    L27:
        return;
    L9:
        e = move-exception;
        this.exceptionLogger.log(e);
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true) == false) goto L6;
        this.serversocket.close();
        return;
    }
}
