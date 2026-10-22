package m9;

import androidx.compose.animation.core.AnimationKt;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* renamed from: m9.B, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1684B extends AbstractC1700S implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final RunnableC1684B h;
    public static final long i;

    static {
        Long l;
        RunnableC1684B runnableC1684B = new RunnableC1684B();
        h = runnableC1684B;
        runnableC1684B.H(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        i = timeUnit.toNanos(l.longValue());
    }

    @Override // m9.AbstractC1701T
    public final Thread G() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(h.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // m9.AbstractC1701T
    public final void K(long j5, AbstractRunnableC1698P abstractRunnableC1698P) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // m9.AbstractC1700S
    public final void L(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.L(runnable);
    }

    public final synchronized void Q() {
        int i6 = debugStatus;
        if (i6 == 2 || i6 == 3) {
            debugStatus = 3;
            AbstractC1700S.e.set(this, null);
            AbstractC1700S.f.set(this, null);
            notifyAll();
        }
    }

    @Override // m9.AbstractC1700S, m9.InterfaceC1688F
    public final InterfaceC1693K l(long j5, Runnable runnable, H7.h hVar) {
        long j6 = j5 > 0 ? j5 >= 9223372036854L ? Long.MAX_VALUE : AnimationKt.MillisToNanos * j5 : 0L;
        if (j6 >= 4611686018427387903L) {
            return n0.f5331a;
        }
        long jNanoTime = System.nanoTime();
        C1697O c1697o = new C1697O(runnable, j6 + jNanoTime);
        P(jNanoTime, c1697o);
        return c1697o;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zO;
        t0.f5334a.set(this);
        try {
            synchronized (this) {
                int i6 = debugStatus;
                if (i6 == 2 || i6 == 3) {
                    if (zO) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j5 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jI = I();
                    if (jI == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j5 == Long.MAX_VALUE) {
                            j5 = i + jNanoTime;
                        }
                        long j6 = j5 - jNanoTime;
                        if (j6 <= 0) {
                            _thread = null;
                            Q();
                            if (O()) {
                                return;
                            }
                            G();
                            return;
                        }
                        if (jI > j6) {
                            jI = j6;
                        }
                    } else {
                        j5 = Long.MAX_VALUE;
                    }
                    if (jI > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            Q();
                            if (O()) {
                                return;
                            }
                            G();
                            return;
                        }
                        LockSupport.parkNanos(this, jI);
                    }
                }
            }
        } finally {
            _thread = null;
            Q();
            if (!O()) {
                G();
            }
        }
    }

    @Override // m9.AbstractC1700S, m9.AbstractC1701T
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return "DefaultExecutor";
    }
}
