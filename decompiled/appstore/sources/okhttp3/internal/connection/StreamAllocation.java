package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    protected int recycleCount;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        public StreamAllocationReference(StreamAllocation r10, Object r11) {
            super(r10);
            this.callStackTrace = r11;
        }
    }

    static {
    }

    public StreamAllocation(ConnectionPool r10, Address r11, Call r12, EventListener r13, Object r14) {
        this.connectionPool = r10;
        this.address = r11;
        this.call = r12;
        this.eventListener = r13;
        this.routeSelector = new RouteSelector(r11, routeDatabase(), r12, r13);
        this.callStackTrace = r14;
    }

    private Socket deallocate(boolean r10, boolean r11, boolean r12) {
        if (r12 == false) goto L6;
        this.codec = null;
    L6:
        if (r11 == false) goto L8;
        this.released = true;
    L8:
        RealConnection r13 = this.connection;
        if (r13 == null) goto L26;
        if (r10 == false) goto L13;
        r13.noNewStreams = true;
    L13:
        if (this.codec == null) goto L15;
        return null;
    L15:
        if (this.released == false) goto L17;
    L18:
        release(r13);
        if (this.connection.allocations.isEmpty() == false) goto L23;
        this.connection.idleAtNanos = System.nanoTime();
        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection) == false) goto L23;
        Socket r14 = this.connection.socket();
    L24:
        this.connection = null;
        return r14;
    L23:
        r14 = null;
        goto L24
    L17:
        if (r13.noNewStreams == true) goto L18;
        return null;
    L26:
        return null;
    }

    private RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws IOException {
        ConnectionPool r10 = this.connectionPool;
        monitor-enter(r10);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.released == true) goto L84;
        if (this.codec != null) goto L82;
        if (this.canceled == true) goto L80;
        RealConnection r11 = this.connection;     // Catch: Throwable -> L24
        Socket r12 = releaseIfNoNewStreams();     // Catch: Throwable -> L24
        RealConnection r13 = this.connection;     // Catch: Throwable -> L24
        Socket r14 = null;
        if (r13 == null) goto L13;
        r11 = null;
    L15:
        if (this.reportedAcquired == true) goto L18;
        r11 = null;
    L18:
        if (r13 != null) goto L26;
        Internal.instance.get(this.connectionPool, this.address, this, null);     // Catch: Throwable -> L24
        RealConnection r15 = this.connection;     // Catch: Throwable -> L24
        if (r15 == null) goto L22;
        boolean r16 = true;
        r13 = r15;
        Route r17 = null;
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L24
        Util.closeQuietly(r12);
        if (r11 == null) goto L31;
        this.eventListener.connectionReleased(this.call, r11);
    L31:
        if (r16 == false) goto L33;
        this.eventListener.connectionAcquired(this.call, r13);
    L33:
        if (r13 == null) goto L35;
        return r13;
    L35:
        if (r17 != null) goto L41;
        RouteSelector.Selection r18 = this.routeSelection;
        if (r18 != null) goto L39;
    L40:
        this.routeSelection = this.routeSelector.next();
        boolean r24 = true;
    L42:
        ConnectionPool r25 = this.connectionPool;
        monitor-enter(r25);
    L52:
        th = move-exception;
        throw th;
    L45:
        if (this.canceled == true) goto L76;
        if (r24 == false) goto L55;
        List<Route> r26 = this.routeSelection.getAll();     // Catch: Throwable -> L52
        int r27 = r26.size();     // Catch: Throwable -> L52
        int r110 = 0;
    L48:
        if (r110 >= r27) goto L55;
        Route r111 = r26.get(r110);     // Catch: Throwable -> L52
        Internal.instance.get(this.connectionPool, this.address, this, r111);     // Catch: Throwable -> L52
        RealConnection r112 = this.connection;     // Catch: Throwable -> L52
        if (r112 != null) goto L51;
        r110 = r110 + 1;     // Catch: Throwable -> L52
        goto L48
    L51:
        this.route = r111;     // Catch: Throwable -> L52
        r16 = true;
        r13 = r112;
    L55:
        if (r16 == true) goto L59;
        if (r17 != null) goto L58;
        r17 = this.routeSelection.next();     // Catch: Throwable -> L52
    L58:
        this.route = r17;     // Catch: Throwable -> L52
        this.refusedStreamCount = 0;     // Catch: Throwable -> L52
        r13 = new RealConnection(this.connectionPool, r17);     // Catch: Throwable -> L52
        acquire(r13, false);     // Catch: Throwable -> L52
    L59:
        monitor-exit(r25);     // Catch: Throwable -> L52
        if (r16 == false) goto L63;
        this.eventListener.connectionAcquired(this.call, r13);
        return r13;
    L63:
        r13.connect(r19, r20, r21, r22, r23, this.call, this.eventListener);
        routeDatabase().connected(r13.route());
        ConnectionPool r28 = this.connectionPool;
        monitor-enter(r28);
        this.reportedAcquired = true;     // Catch: Throwable -> L68
        Internal.instance.put(this.connectionPool, r13);     // Catch: Throwable -> L68
        if (r13.isMultiplexed() == false) goto L70;
        r14 = Internal.instance.deduplicate(this.connectionPool, this.address, this);     // Catch: Throwable -> L68
        r13 = this.connection;     // Catch: Throwable -> L68
    L70:
        monitor-exit(r28);     // Catch: Throwable -> L68
        Util.closeQuietly(r14);
        this.eventListener.connectionAcquired(this.call, r13);
        return r13;
    L68:
        th = move-exception;
        throw th;
    L76:
        throw new IOException("Canceled");     // Catch: Throwable -> L52
    L39:
        if (r18.hasNext() == false) goto L40;
    L41:
        r24 = false;
        goto L42
    L22:
        r17 = this.route;     // Catch: Throwable -> L24
    L23:
        r16 = false;
        goto L27
    L26:
        r17 = null;
        goto L23
    L13:
        r13 = null;
        goto L15
    L80:
        throw new IOException("Canceled");     // Catch: Throwable -> L24
    L82:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L24
    L84:
        throw new IllegalStateException("released");     // Catch: Throwable -> L24
    }

    private RealConnection findHealthyConnection(int r10, int r11, int r12, int r13, boolean r14, boolean r15) throws IOException {
    L2:
        RealConnection r16 = findConnection(r10, r11, r12, r13, r14);
        ConnectionPool r17 = this.connectionPool;
        monitor-enter(r17);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r16.successCount == 0) goto L6;
        monitor-exit(r17);     // Catch: Throwable -> L8
        if (r16.isHealthy(r15) == true) goto L14;
        noNewStreams();
        goto L2
    L14:
        return r16;
    L6:
        monitor-exit(r17);     // Catch: Throwable -> L8
        return r16;
    }

    private String getConnectionIpStr(RealConnection r10) {
        if (r10 != null) goto L11;
        if (r10.route() != null) goto L11;
        if (r10.route().d() != null) goto L11;
        return "";
    L11:
        return r10.route().d().getAddress().getHostAddress();
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection r10 = this.connection;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.noNewStreams == true) goto L7;
        return null;
    L7:
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    private void updateRequestIpInfo(RealConnection r10) {
        Request r11 = this.call.request();
        if (r11 == null) goto L6;
        r11.i(getConnectionIpStr(r10));
        return;
    }

    public void acquire(RealConnection r10, boolean r11) {
        if (this.connection != null) goto L7;
        this.connection = r10;
        this.reportedAcquired = r11;
        r10.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void cancel() {
        ConnectionPool r10 = this.connectionPool;
        monitor-enter(r10);
        this.canceled = true;     // Catch: Throwable -> L12
        HttpCodec r11 = this.codec;     // Catch: Throwable -> L12
        RealConnection r12 = this.connection;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    L9:
        if (r12 == null) goto L18;
        r12.cancel();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public HttpCodec codec() {
        ConnectionPool r10 = this.connectionPool;
        monitor-enter(r10);
        HttpCodec r11 = this.codec;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized RealConnection connection() {
        monitor-enter(this);
        RealConnection r10 = this.connection;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) goto L12;
        RouteSelector.Selection r10 = this.routeSelection;
        if (r10 == null) goto L9;
        if (r10.hasNext() == true) goto L12;
    L9:
        if (this.routeSelector.hasNext() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public HttpCodec newStream(OkHttpClient r10, Interceptor.Chain r11, boolean r12) {
        RealConnection r13 = findHealthyConnection(r11.connectTimeoutMillis(), r11.readTimeoutMillis(), r11.writeTimeoutMillis(), r10.q(), r10.w(), r12);     // Catch: IOException -> L14
        HttpCodec r14 = r13.newCodec(r10, r11, this);     // Catch: IOException -> L12
        updateRequestIpInfo(r13);     // Catch: IOException -> L12
        ConnectionPool r15 = this.connectionPool;     // Catch: IOException -> L12
        monitor-enter(r15);     // Catch: IOException -> L12
        this.codec = r14;     // Catch: Throwable -> L9
        monitor-exit(r15);     // Catch: Throwable -> L9
        return r14;
    L9:
        th = move-exception;
        throw th;     // Catch: IOException -> L12
    L12:
        e = e;
    L16:
        if (r13 == null) goto L19;
        updateRequestIpInfo(r13);
    L19:
        throw new RouteException(e);
    L14:
        e = e;
        r13 = null;
        goto L16
    }

    public void noNewStreams() {
        ConnectionPool r10 = this.connectionPool;
        monitor-enter(r10);
        RealConnection r11 = this.connection;     // Catch: Throwable -> L12
        Socket r12 = deallocate(true, false, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r11 = null;
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L12
        Util.closeQuietly(r12);
        if (r11 == null) goto L17;
        this.eventListener.connectionReleased(this.call, r11);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public int recycleCount() {
        return this.recycleCount;
    }

    public void release() {
        ConnectionPool r10 = this.connectionPool;
        monitor-enter(r10);
        RealConnection r11 = this.connection;     // Catch: Throwable -> L12
        Socket r12 = deallocate(false, true, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r11 = null;
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L12
        Util.closeQuietly(r12);
        if (r11 == null) goto L17;
        this.eventListener.connectionReleased(this.call, r11);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Socket releaseAndAcquire(RealConnection r10) {
        if (this.codec != null) goto L9;
        if (this.connection.allocations.size() != 1) goto L9;
        Reference<StreamAllocation> r11 = this.connection.allocations.get(0);
        Socket r12 = deallocate(true, false, false);
        this.connection = r10;
        r10.allocations.add(r11);
        return r12;
    L9:
        throw new IllegalStateException();
    }

    public Route route() {
        return this.route;
    }

    public void streamFailed(IOException r10) {
        ConnectionPool r11 = this.connectionPool;
        monitor-enter(r11);
        RealConnection r12 = null;
        if ((r10 instanceof StreamResetException) == false) goto L15;
        ErrorCode r13 = ((StreamResetException) r10).errorCode;     // Catch: Throwable -> L9
        ErrorCode r14 = ErrorCode.REFUSED_STREAM;     // Catch: Throwable -> L9
        if (r13 != r14) goto L11;
        this.refusedStreamCount++;     // Catch: Throwable -> L9
    L11:
        if (r13 == r14) goto L13;
    L14:
        this.route = null;     // Catch: Throwable -> L9
    L28:
        boolean r15 = true;
    L30:
        RealConnection r16 = this.connection;     // Catch: Throwable -> L9
        Socket r17 = deallocate(r15, false, true);     // Catch: Throwable -> L9
        if (this.connection == null) goto L33;
    L36:
        monitor-exit(r11);     // Catch: Throwable -> L9
        Util.closeQuietly(r17);
        if (r12 == null) goto L45;
        this.eventListener.connectionReleased(this.call, r12);
        return;
    L45:
        return;
    L33:
        if (this.reportedAcquired == false) goto L36;
        r12 = r16;
        goto L36
    L13:
        if (this.refusedStreamCount > 1) goto L14;
    L29:
        r15 = false;
        goto L30
    L15:
        RealConnection r18 = this.connection;     // Catch: Throwable -> L9
        if (r18 == null) goto L29;
        if (r18.isMultiplexed() == false) goto L22;
        if ((r10 instanceof ConnectionShutdownException) == false) goto L29;
    L22:
        if (this.connection.successCount != 0) goto L28;
        Route r19 = this.route;     // Catch: Throwable -> L9
        if (r19 == null) goto L27;
        if (r10 == null) goto L27;
        this.routeSelector.connectFailed(r19, r10);     // Catch: Throwable -> L9
    L27:
        this.route = null;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void streamFinished(boolean r10, HttpCodec r11, long r12, IOException r13) {
        this.eventListener.responseBodyEnd(this.call, r12);
        ConnectionPool r14 = this.connectionPool;
        monitor-enter(r14);
        if (r11 == null) goto L26;
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r11 != this.codec) goto L26;
        if (r10 == true) goto L12;
        RealConnection r15 = this.connection;     // Catch: Throwable -> L10
        int r16 = r15.successCount + 1;     // Catch: Throwable -> L10
        r15.successCount = r16;     // Catch: Throwable -> L10
        this.recycleCount = r16;     // Catch: Throwable -> L10
    L12:
        RealConnection r17 = this.connection;     // Catch: Throwable -> L10
        Socket r18 = deallocate(r10, false, true);     // Catch: Throwable -> L10
        if (this.connection == null) goto L15;
        r17 = null;
    L15:
        boolean r19 = this.released;     // Catch: Throwable -> L10
        monitor-exit(r14);     // Catch: Throwable -> L10
        Util.closeQuietly(r18);
        if (r17 == null) goto L20;
        this.eventListener.connectionReleased(this.call, r17);
    L20:
        if (r13 == null) goto L22;
        this.eventListener.callFailed(this.call, r13);
        return;
    L22:
        if (r19 == false) goto L31;
        this.eventListener.callEnd(this.call);
        return;
    L31:
        return;
    L26:
        throw new IllegalStateException("expected " + this.codec + " but was " + r11);     // Catch: Throwable -> L10
    }

    public String toString() {
        RealConnection r10 = connection();
        if (r10 == null) goto L6;
        return r10.toString();
    L6:
        return this.address.toString();
    }

    private void release(RealConnection r10) {
        int r11 = r10.allocations.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        if (r10.allocations.get(r12).get() == this) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r10.allocations.remove(r12);
        return;
    L10:
        throw new IllegalStateException();
    }
}
