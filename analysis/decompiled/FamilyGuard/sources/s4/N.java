package s4;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import s4.AbstractC1063b0;

/* loaded from: classes.dex */
public final class N extends AbstractC1063b0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: i, reason: collision with root package name */
    public static final N f20317i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f20318j;

    static {
        Long l5;
        N n5 = new N();
        f20317i = n5;
        AbstractC1061a0.o0(n5, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l5 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l5 = 1000L;
        }
        f20318j = timeUnit.toNanos(l5.longValue());
    }

    private N() {
    }

    private final synchronized void T0() {
        if (W0()) {
            debugStatus = 3;
            O0();
            j4.k.e(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread U0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(N.class.getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean V0() {
        return debugStatus == 4;
    }

    private final boolean W0() {
        int i5 = debugStatus;
        return i5 == 2 || i5 == 3;
    }

    private final synchronized boolean X0() {
        if (W0()) {
            return false;
        }
        debugStatus = 1;
        j4.k.e(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void Y0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // s4.AbstractC1065c0
    protected Thread A0() {
        Thread thread = _thread;
        return thread == null ? U0() : thread;
    }

    @Override // s4.AbstractC1065c0
    protected void B0(long j5, AbstractC1063b0.b bVar) {
        Y0();
    }

    @Override // s4.AbstractC1063b0
    public void G0(Runnable runnable) {
        if (V0()) {
            Y0();
        }
        super.G0(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zM0;
        H0.f20303a.d(this);
        C1064c.a();
        try {
            if (!X0()) {
                if (zM0) {
                    return;
                } else {
                    return;
                }
            }
            long j5 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jU0 = u0();
                if (jU0 == Long.MAX_VALUE) {
                    C1064c.a();
                    long jNanoTime = System.nanoTime();
                    if (j5 == Long.MAX_VALUE) {
                        j5 = f20318j + jNanoTime;
                    }
                    long j6 = j5 - jNanoTime;
                    if (j6 <= 0) {
                        _thread = null;
                        T0();
                        C1064c.a();
                        if (M0()) {
                            return;
                        }
                        A0();
                        return;
                    }
                    jU0 = kotlin.ranges.l.f(jU0, j6);
                } else {
                    j5 = Long.MAX_VALUE;
                }
                if (jU0 > 0) {
                    if (W0()) {
                        _thread = null;
                        T0();
                        C1064c.a();
                        if (M0()) {
                            return;
                        }
                        A0();
                        return;
                    }
                    C1064c.a();
                    LockSupport.parkNanos(this, jU0);
                }
            }
        } finally {
            _thread = null;
            T0();
            C1064c.a();
            if (!M0()) {
                A0();
            }
        }
    }

    @Override // s4.AbstractC1063b0, s4.AbstractC1061a0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
