package kc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends o0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: m, reason: collision with root package name */
    public static final x f7499m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f7500n;

    static {
        Long l2;
        x xVar = new x();
        f7499m = xVar;
        xVar.S(false);
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f7500n = TimeUnit.MILLISECONDS.toNanos(l2.longValue());
    }

    @Override // kc.o0
    public final void V(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.V(runnable);
    }

    @Override // kc.o0
    public final Thread Y() {
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
                thread.setContextClassLoader(f7499m.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // kc.o0
    public final void a0(long j10, m0 m0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void c0() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            o0.f7466j.set(this, null);
            o0.f7467k.set(this, null);
            notifyAll();
        }
    }

    @Override // kc.o0, kc.a0
    public final g0 n(long j10, o1 o1Var, nb.g gVar) {
        long j11 = j10 > 0 ? j10 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j10 : 0L;
        if (j11 >= 4611686018427387903L) {
            return i1.f7443c;
        }
        long jNanoTime = System.nanoTime();
        l0 l0Var = new l0(j11 + jNanoTime);
        l0Var.f7449g = o1Var;
        VarHandle.storeStoreFence();
        b0(jNanoTime, l0Var);
        return l0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean Z;
        l1.f7450a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (Z) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jT = T();
                    if (jT == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f7500n + jNanoTime;
                        }
                        long j11 = j10 - jNanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            c0();
                            if (Z()) {
                                return;
                            }
                            Y();
                            return;
                        }
                        if (jT > j11) {
                            jT = j11;
                        }
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (jT > 0) {
                        int i3 = debugStatus;
                        if (i3 == 2 || i3 == 3) {
                            _thread = null;
                            c0();
                            if (Z()) {
                                return;
                            }
                            Y();
                            return;
                        }
                        LockSupport.parkNanos(this, jT);
                    }
                }
            }
        } finally {
            _thread = null;
            c0();
            if (!Z()) {
                Y();
            }
        }
    }

    @Override // kc.o0, kc.j0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kc.p
    public final String toString() {
        return "DefaultExecutor";
    }
}
