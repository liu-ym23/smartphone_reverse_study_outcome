package ia;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class e0 extends w0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: o, reason: collision with root package name */
    public static final e0 f4949o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f4950p;

    static {
        Long l6;
        e0 e0Var = new e0();
        f4949o = e0Var;
        e0Var.X(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l6 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l6 = 1000L;
        }
        f4950p = timeUnit.toNanos(l6.longValue());
    }

    @Override // ia.w0, ia.j0
    public final p0 C(long j2, Runnable runnable, g7.l lVar) {
        long j4 = j2 > 0 ? j2 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j2 : 0L;
        if (j4 >= 4611686018427387903L) {
            return s1.f5001f;
        }
        long jNanoTime = System.nanoTime();
        t0 t0Var = new t0(j4 + jNanoTime, runnable);
        f0(jNanoTime, t0Var);
        return t0Var;
    }

    @Override // ia.x0
    public final Thread W() {
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
                thread.setContextClassLoader(f4949o.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // ia.x0
    public final void a0(long j2, u0 u0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // ia.w0
    public final void b0(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.b0(runnable);
    }

    public final synchronized void g0() {
        int i2 = debugStatus;
        if (i2 == 2 || i2 == 3) {
            debugStatus = 3;
            w0.f5018l.set(this, null);
            w0.f5019m.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zE0;
        z1.f5029a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 == 2 || i2 == 3) {
                    if (zE0) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jY = Y();
                    if (jY == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f4950p + jNanoTime;
                        }
                        long j4 = j2 - jNanoTime;
                        if (j4 <= 0) {
                            _thread = null;
                            g0();
                            if (e0()) {
                                return;
                            }
                            W();
                            return;
                        }
                        if (jY > j4) {
                            jY = j4;
                        }
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (jY > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            g0();
                            if (e0()) {
                                return;
                            }
                            W();
                            return;
                        }
                        LockSupport.parkNanos(this, jY);
                    }
                }
            }
        } finally {
            _thread = null;
            g0();
            if (!e0()) {
                W();
            }
        }
    }

    @Override // ia.w0, ia.x0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // ia.x
    public final String toString() {
        return "DefaultExecutor";
    }
}
