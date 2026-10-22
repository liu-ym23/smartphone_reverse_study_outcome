package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class a extends c {
    protected static int DEFAULT_READ_BUFFER_SIZE = 65536;
    private ScheduledFuture<?> connectionLostCheckerFuture;
    private ScheduledExecutorService connectionLostCheckerService;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private final vc.c log = vc.e.l(a.class);
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60);
    private boolean websocketRunning = false;
    private boolean daemon = false;
    private final Object syncConnectionLost = new Object();
    private int receiveBufferSize = 0;

    /* renamed from: org.java_websocket.a$a, reason: collision with other inner class name */
    public class RunnableC0488a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<b> f37809a = new ArrayList<>();

        public RunnableC0488a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jNanoTime;
            this.f37809a.clear();
            try {
                this.f37809a.addAll(a.this.u());
                synchronized (a.this.syncConnectionLost) {
                    jNanoTime = (long) (System.nanoTime() - (a.this.connectionLostTimeout * 1.5d));
                }
                Iterator<b> it = this.f37809a.iterator();
                while (it.hasNext()) {
                    a.this.t(it.next(), jNanoTime);
                }
            } catch (Exception unused) {
            }
            this.f37809a.clear();
        }
    }

    public void A(boolean z10) {
        this.reuseAddr = z10;
    }

    public void B(boolean z10) {
        this.tcpNoDelay = z10;
    }

    public void C() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostTimeout <= 0) {
                    this.log.trace("Connection lost timer deactivated");
                    return;
                }
                this.log.trace("Connection lost timer started");
                this.websocketRunning = true;
                z();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void D() {
        synchronized (this.syncConnectionLost) {
            try {
                if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                    this.websocketRunning = false;
                    this.log.trace("Connection lost timer stopped");
                    s();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
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

    public final void t(b bVar, long j10) throws NullPointerException {
        if (bVar instanceof d) {
            d dVar = (d) bVar;
            if (dVar.q() < j10) {
                this.log.m("Closing connection due to no pong received: {}", dVar);
                dVar.e(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (dVar.v()) {
                dVar.A();
            } else {
                this.log.m("Trying to ping a non open connection: {}", dVar);
            }
        }
    }

    public abstract Collection<b> u();

    public int v() {
        return this.receiveBufferSize;
    }

    public boolean w() {
        return this.daemon;
    }

    public boolean x() {
        return this.reuseAddr;
    }

    public boolean y() {
        return this.tcpNoDelay;
    }

    public final void z() {
        s();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new pc.d("connectionLostChecker", this.daemon));
        RunnableC0488a runnableC0488a = new RunnableC0488a();
        ScheduledExecutorService scheduledExecutorService = this.connectionLostCheckerService;
        long j10 = this.connectionLostTimeout;
        this.connectionLostCheckerFuture = scheduledExecutorService.scheduleAtFixedRate(runnableC0488a, j10, j10, TimeUnit.NANOSECONDS);
    }
}
