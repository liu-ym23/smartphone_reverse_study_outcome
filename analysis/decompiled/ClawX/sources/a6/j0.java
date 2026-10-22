package a6;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j0 extends z0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: k, reason: collision with root package name */
    public static final j0 f182k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f183l;

    static {
        Long l3;
        j0 j0Var = new j0();
        f182k = j0Var;
        j0Var.K(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f183l = timeUnit.toNanos(l3.longValue());
    }

    @Override // a6.a1
    public final Thread J() {
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
                thread.setContextClassLoader(f182k.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // a6.a1
    public final void N(long j4, x0 x0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // a6.z0
    public final void O(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.O(runnable);
    }

    public final synchronized void T() {
        int i8 = debugStatus;
        if (i8 == 2 || i8 == 3) {
            debugStatus = 3;
            z0.f230g.set(this, null);
            z0.f231h.set(this, null);
            notifyAll();
        }
    }

    @Override // a6.z0, a6.n0
    public final s0 b(long j4, b2 b2Var, f5.h hVar) {
        long j8 = j4 > 0 ? j4 >= 9223372036854L ? Util.VLI_MAX : 1000000 * j4 : 0L;
        if (j8 >= 4611686018427387903L) {
            return s1.f213a;
        }
        long jNanoTime = System.nanoTime();
        w0 w0Var = new w0(j8 + jNanoTime, b2Var);
        S(jNanoTime, w0Var);
        return w0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zR;
        z1.f233a.set(this);
        try {
            synchronized (this) {
                int i8 = debugStatus;
                if (i8 == 2 || i8 == 3) {
                    if (zR) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j4 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jL = L();
                    if (jL == Util.VLI_MAX) {
                        long jNanoTime = System.nanoTime();
                        if (j4 == Util.VLI_MAX) {
                            j4 = f183l + jNanoTime;
                        }
                        long j8 = j4 - jNanoTime;
                        if (j8 <= 0) {
                            _thread = null;
                            T();
                            if (R()) {
                                return;
                            }
                            J();
                            return;
                        }
                        if (jL > j8) {
                            jL = j8;
                        }
                    } else {
                        j4 = Long.MAX_VALUE;
                    }
                    if (jL > 0) {
                        int i9 = debugStatus;
                        if (i9 == 2 || i9 == 3) {
                            _thread = null;
                            T();
                            if (R()) {
                                return;
                            }
                            J();
                            return;
                        }
                        LockSupport.parkNanos(this, jL);
                    }
                }
            }
        } finally {
            _thread = null;
            T();
            if (!R()) {
                J();
            }
        }
    }

    @Override // a6.z0, a6.a1
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // a6.b0
    public final String toString() {
        return "DefaultExecutor";
    }
}
