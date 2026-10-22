package org.java_websocket;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.java_websocket.util.NamedThreadFactory;

/* loaded from: classes4.dex */
public abstract class AbstractWebSocket extends WebSocketAdapter {
    protected static int DEFAULT_READ_BUFFER_SIZE = 65536;
    private ScheduledFuture<?> connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private final InterfaceC0315b log = AbstractC0317d.b(AbstractWebSocket.class);
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60);
    private boolean websocketRunning = false;
    private boolean daemon = false;
    private final Object syncConnectionLost = new Object();
    private int receiveBufferSize = 0;

    private void cancelConnectionLostTimer() {
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        ScheduledFuture<?> scheduledFuture = this.connectionLostCheckerFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeConnectionLostDetection(WebSocket webSocket, long j5) throws NullPointerException {
        if (webSocket instanceof WebSocketImpl) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
            if (webSocketImpl.getLastPong() < j5) {
                this.log.g(webSocketImpl, "Closing connection due to no pong received: {}");
                webSocketImpl.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (webSocketImpl.isOpen()) {
                webSocketImpl.sendPing();
            } else {
                this.log.g(webSocketImpl, "Trying to ping a non open connection: {}");
            }
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("connectionLostChecker", this.daemon));
        Runnable runnable = new Runnable() { // from class: org.java_websocket.AbstractWebSocket.1
            private ArrayList<WebSocket> connections = new ArrayList<>();

            @Override // java.lang.Runnable
            public void run() {
                long jNanoTime;
                this.connections.clear();
                try {
                    this.connections.addAll(AbstractWebSocket.this.getConnections());
                    synchronized (AbstractWebSocket.this.syncConnectionLost) {
                        jNanoTime = (long) (System.nanoTime() - (AbstractWebSocket.this.connectionLostTimeout * 1.5d));
                    }
                    Iterator<WebSocket> it = this.connections.iterator();
                    while (it.hasNext()) {
                        AbstractWebSocket.this.executeConnectionLostDetection(it.next(), jNanoTime);
                    }
                } catch (Exception unused) {
                }
                this.connections.clear();
            }
        };
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long j5 = this.connectionLostTimeout;
        this.connectionLostCheckerFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, j5, j5, TimeUnit.NANOSECONDS);
    }

    public int getConnectionLostTimeout() {
        int seconds;
        synchronized (this.syncConnectionLost) {
            seconds = (int) TimeUnit.NANOSECONDS.toSeconds(this.connectionLostTimeout);
        }
        return seconds;
    }

    public abstract Collection<WebSocket> getConnections();

    public int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    public boolean isDaemon() {
        return this.daemon;
    }

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i) {
        synchronized (this.syncConnectionLost) {
            try {
                long nanos = TimeUnit.SECONDS.toNanos(i);
                this.connectionLostTimeout = nanos;
                if (nanos <= 0) {
                    this.log.trace("Connection lost timer stopped");
                    cancelConnectionLostTimer();
                    return;
                }
                if (this.websocketRunning) {
                    this.log.trace("Connection lost timer restarted");
                    try {
                        Iterator it = new ArrayList(getConnections()).iterator();
                        while (it.hasNext()) {
                            WebSocket webSocket = (WebSocket) it.next();
                            if (webSocket instanceof WebSocketImpl) {
                                ((WebSocketImpl) webSocket).updateLastPong();
                            }
                        }
                    } catch (Exception e) {
                        this.log.error("Exception during connection lost restart", e);
                    }
                    restartConnectionLostTimer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDaemon(boolean z10) {
        this.daemon = z10;
    }

    public void setReceiveBufferSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("buffer size < 0");
        }
        this.receiveBufferSize = i;
    }

    public void setReuseAddr(boolean z10) {
        this.reuseAddr = z10;
    }

    public void setTcpNoDelay(boolean z10) {
        this.tcpNoDelay = z10;
    }

    public void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostTimeout <= 0) {
                    this.log.trace("Connection lost timer deactivated");
                    return;
                }
                this.log.trace("Connection lost timer started");
                this.websocketRunning = true;
                restartConnectionLostTimer();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                    this.websocketRunning = false;
                    this.log.trace("Connection lost timer stopped");
                    cancelConnectionLostTimer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
