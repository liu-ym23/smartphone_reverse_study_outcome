package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 extends r0 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f0 f21422i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f21423j = 0;

    static {
        f0 r10 = new f0();
        f21422i = r10;
        q0.k(r10, false, 1, null);
        TimeUnit r11 = TimeUnit.MILLISECONDS;
        Long r12 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f21423j = r11.toNanos(r12.longValue());
        return;
    L5:
        r12 = 1000L;
        goto L6
    }

    public f0() {
    }

    public final synchronized void G() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (J() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        A();     // Catch: Throwable -> L11
        kotlin.jvm.internal.q.e(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L11
        notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final synchronized Thread H() {
        monitor-enter(this);
        Thread r10 = _thread;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        r10 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L7
        _thread = r10;     // Catch: Throwable -> L7
        r10.setDaemon(true);     // Catch: Throwable -> L7
        r10.start();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean I() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean J() {
        int r10 = debugStatus;
        if (r10 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 3) goto L8;
        return false;
    }

    public final synchronized boolean K() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (J() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        kotlin.jvm.internal.q.e(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    public final void L() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.r0, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r10, Runnable r11, CoroutineContext r12) {
        return D(r10, r11);
    }

    @Override // kotlinx.coroutines.s0
    public Thread q() {
        Thread r10 = _thread;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return H();
    }

    @Override // kotlinx.coroutines.s0
    public void r(long r10, r0.c r11) {
        L();
    }

    @Override // java.lang.Runnable
    public void run() {
        z1.f21774a.setEventLoop$kotlinx_coroutines_core(this);
        c.a();
    L16:
        th = move-exception;
        _thread = null;
        G();
        c.a();
        if (y() == true) goto L39;
        q();
    L39:
        throw th;
    L4:
        if (K() == true) goto L9;
        _thread = null;
        G();
        c.a();
        if (y() == true) goto L48;
        q();
        return;
    L48:
        return;
    L9:
        long r10 = Long.MAX_VALUE;
    L10:
        Thread.interrupted();     // Catch: Throwable -> L16
        long r11 = n();     // Catch: Throwable -> L16
        if (r11 != Long.MAX_VALUE) goto L25;
        c.a();     // Catch: Throwable -> L16
        long r12 = System.nanoTime();     // Catch: Throwable -> L16
        if (r10 == Long.MAX_VALUE) goto L15;
    L18:
        long r13 = r10 - r12;
        if (r13 <= 0) goto L20;
        r11 = bg.h.h(r11, r13);     // Catch: Throwable -> L16
    L27:
        if (r11 <= 0) goto L10;
        if (J() == true) goto L30;
        c.a();     // Catch: Throwable -> L16
        LockSupport.parkNanos(this, r11);     // Catch: Throwable -> L16
        goto L10
    L30:
        _thread = null;
        G();
        c.a();
        if (y() == true) goto L50;
        q();
        return;
    L50:
        return;
    L20:
        _thread = null;
        G();
        c.a();
        if (y() == true) goto L49;
        q();
        return;
    L49:
        return;
    L15:
        r10 = f21423j + r12;
        goto L18
    L25:
        r10 = Long.MAX_VALUE;
        goto L27
    }

    @Override // kotlinx.coroutines.r0, kotlinx.coroutines.q0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.r0
    public void w(Runnable r10) {
        if (I() == false) goto L5;
        L();
    L5:
        super.w(r10);
    }
}
