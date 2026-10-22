package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = null;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase;

    static {
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public ConnectionPool(int r3, long r4, TimeUnit r6) {
        this.cleanupRunnable = new AnonymousClass1(this);
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = r3;
        this.keepAliveDurationNs = r6.toNanos(r4);
        if (r4 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + r4);
    }

    public synchronized int idleConnectionCount() {
        monitor-enter(this);
        Iterator<RealConnection> r0 = this.connections.iterator();     // Catch: Throwable -> L11
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().allocations.isEmpty() == false) goto L5;
        r1 = r1 + 1;
        goto L5
    L9:
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int connectionCount() {
        monitor-enter(this);
        int r0 = this.connections.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    RealConnection get(Address r3, StreamAllocation r4, Route r5) {
        Iterator<RealConnection> r2 = this.connections.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        RealConnection r0 = r2.next();
        if (r0.isEligible(r3, r5) == false) goto L4;
        r4.acquire(r0, true);
        return r0;
    L9:
        return null;
    }

    @Nullable
    Socket deduplicate(Address r3, StreamAllocation r4) {
        Iterator<RealConnection> r2 = this.connections.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        RealConnection r0 = r2.next();
        if (r0.isEligible(r3, null) == false) goto L4;
        if (r0.isMultiplexed() == false) goto L4;
        if (r0 == r4.connection()) goto L4;
        return r4.releaseAndAcquire(r0);
    L13:
        return null;
    }

    void put(RealConnection r3) {
        if (this.cleanupRunning == true) goto L5;
        this.cleanupRunning = true;
        executor.execute(this.cleanupRunnable);
    L5:
        this.connections.add(r3);
    }

    boolean connectionBecameIdle(RealConnection r2) {
        if (r2.noNewStreams == false) goto L5;
    L9:
        this.connections.remove(r2);
        return true;
    L5:
        if (this.maxIdleConnections == 0) goto L9;
        notifyAll();
        return false;
    }

    public void evictAll() {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<RealConnection> r1 = this.connections.iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L10;
        RealConnection r2 = r1.next();     // Catch: Throwable -> L16
        if (r2.allocations.isEmpty() == false) goto L6;
        r2.noNewStreams = true;     // Catch: Throwable -> L16
        r0.add(r2);     // Catch: Throwable -> L16
        r1.remove();     // Catch: Throwable -> L16
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L16
        Iterator r4 = r0.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        Util.closeQuietly(((RealConnection) r4.next()).socket());
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    long cleanup(long r12) {
        monitor-enter(this);
        Iterator<RealConnection> r0 = this.connections.iterator();     // Catch: Throwable -> L32
        RealConnection r2 = null;
        long r3 = Long.MIN_VALUE;
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r0.hasNext() == false) goto L12;
        RealConnection r7 = r0.next();     // Catch: Throwable -> L32
        if (pruneAndGetAllocationCount(r7, r12) > 0) goto L8;
        r5 = r5 + 1;     // Catch: Throwable -> L32
        long r8 = r12 - r7.idleAtNanos;     // Catch: Throwable -> L32
        if (r8 <= r3) goto L5;
        r2 = r7;
        r3 = r8;
        goto L5
    L8:
        r6 = r6 + 1;     // Catch: Throwable -> L32
        goto L5
    L12:
        long r13 = this.keepAliveDurationNs;     // Catch: Throwable -> L32
        if (r3 < r13) goto L15;
    L28:
        this.connections.remove(r2);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        Util.closeQuietly(r2.socket());
        return 0;
    L15:
        if (r5 > this.maxIdleConnections) goto L28;
        if (r5 <= 0) goto L21;
        long r14 = r13 - r3;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return r14;
    L21:
        if (r6 <= 0) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L32
        return r13;
    L24:
        this.cleanupRunning = false;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return -1;
    L32:
        th = move-exception;
        throw th;
    }

    private int pruneAndGetAllocationCount(RealConnection r7, long r8) {
        List<Reference<StreamAllocation>> r0 = r7.allocations;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L13;
        Reference<StreamAllocation> r3 = r0.get(r2);
        if (r3.get() != null) goto L7;
        Platform.get().logCloseableLeak("A connection to " + r7.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) r3).callStackTrace);
        r0.remove(r2);
        r7.noNewStreams = true;
        if (r0.isEmpty() == false) goto L4;
        r7.idleAtNanos = r8 - this.keepAliveDurationNs;
        return 0;
    L7:
        r2 = r2 + 1;
        goto L4
    L13:
        return r0.size();
    }
}
