package okhttp3;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionPool {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Executor f22672g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f22675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Deque f22676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RouteDatabase f22677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22678f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConnectionPool f22679a;

        public a(ConnectionPool r10) {
            this.f22679a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            long r10 = this.f22679a.a(System.nanoTime());
            if (r10 == (-1)) goto L4;
            if (r10 <= 0) goto L2;
            long r11 = r10 / BatteryFactorConfig.WIFI_BPS;
            long r12 = r10 - (BatteryFactorConfig.WIFI_BPS * r11);
            ConnectionPool r13 = this.f22679a;
            monitor-enter(r13);
            this.f22679a.wait(r11, (int) r12);     // Catch: Throwable -> L11 InterruptedException -> L17
        L11:
            th = move-exception;
            throw th;
        L13:
            monitor-exit(r13);     // Catch: Throwable -> L11
            goto L2
        }
    }

    static {
        f22672g = new ThreadPoolExecutor(0, Channel.UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public long a(long r12) {
        monitor-enter(this);
        Iterator r10 = this.f22676d.iterator();     // Catch: Throwable -> L12
        RealConnection r11 = null;
        long r13 = Long.MIN_VALUE;
        int r14 = 0;
        int r15 = 0;
    L5:
        if (r10.hasNext() == false) goto L14;
        RealConnection r16 = (RealConnection) r10.next();     // Catch: Throwable -> L12
        if (e(r16, r12) > 0) goto L8;
        r14 = r14 + 1;     // Catch: Throwable -> L12
        long r17 = r12 - r16.idleAtNanos;     // Catch: Throwable -> L12
        if (r17 <= r13) goto L5;
        r11 = r16;
        r13 = r17;
        goto L5
    L8:
        r15 = r15 + 1;     // Catch: Throwable -> L12
        goto L5
    L14:
        long r18 = this.f22674b;     // Catch: Throwable -> L12
        if (r13 < r18) goto L17;
    L30:
        this.f22676d.remove(r11);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        Util.closeQuietly(r11.socket());
        return 0;
    L17:
        if (r14 > this.f22673a) goto L30;
        if (r14 <= 0) goto L23;
        long r19 = r18 - r13;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r19;
    L23:
        if (r15 <= 0) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L12
        return r18;
    L26:
        this.f22678f = false;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return -1;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean b(RealConnection r10) {
        if (r10.noNewStreams == false) goto L5;
    L9:
        this.f22676d.remove(r10);
        return true;
    L5:
        if (this.f22673a == 0) goto L9;
        notifyAll();
        return false;
    }

    public Socket c(Address r10, StreamAllocation r11) {
        Iterator r12 = this.f22676d.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        RealConnection r13 = (RealConnection) r12.next();
        if (r13.isEligible(r10, null) == false) goto L4;
        if (r13.isMultiplexed() == false) goto L4;
        if (r13 == r11.connection()) goto L4;
        return r11.releaseAndAcquire(r13);
    L13:
        return null;
    }

    public RealConnection d(Address r10, StreamAllocation r11, Route r12) {
        Iterator r13 = this.f22676d.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        RealConnection r14 = (RealConnection) r13.next();
        if (r14.isEligible(r10, r12) == false) goto L4;
        r11.acquire(r14, true);
        return r14;
    L9:
        return null;
    }

    public final int e(RealConnection r10, long r11) {
        List<Reference<StreamAllocation>> r12 = r10.allocations;
        int r13 = 0;
    L4:
        if (r13 >= r12.size()) goto L13;
        Reference<StreamAllocation> r14 = r12.get(r13);
        if (r14.get() != null) goto L7;
        Platform.get().logCloseableLeak("A connection to " + r10.route().a().l() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) r14).callStackTrace);
        r12.remove(r13);
        r10.noNewStreams = true;
        if (r12.isEmpty() == false) goto L4;
        r10.idleAtNanos = r11 - this.f22674b;
        return 0;
    L7:
        r13 = r13 + 1;
        goto L4
    L13:
        return r12.size();
    }

    public void f(RealConnection r10) {
        if (this.f22678f == true) goto L5;
        this.f22678f = true;
        f22672g.execute(this.f22675c);
    L5:
        this.f22676d.add(r10);
    }

    public ConnectionPool(int r10, long r11, TimeUnit r12) {
        this.f22675c = new a(this);
        this.f22676d = new ArrayDeque();
        this.f22677e = new RouteDatabase();
        this.f22673a = r10;
        this.f22674b = r12.toNanos(r11);
        if (r11 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + r11);
    }
}
