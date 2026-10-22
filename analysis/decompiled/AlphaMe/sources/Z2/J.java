package Z2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class J extends AbstractC0115a0 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h, reason: collision with root package name */
    public static final J f2181h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f2182i;

    static {
        Long l4;
        J j4 = new J();
        f2181h = j4;
        j4.m(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f2182i = timeUnit.toNanos(l4.longValue());
    }

    @Override // Z2.AbstractC0115a0, Z2.V
    public final void D() {
        debugStatus = 4;
        super.D();
    }

    @Override // Z2.AbstractC0117b0
    public final Thread I() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // Z2.AbstractC0117b0
    public final void N(long j4, Y y4) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // Z2.AbstractC0115a0
    public final void O(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.O(runnable);
    }

    public final synchronized void S() {
        int i4 = debugStatus;
        if (i4 == 2 || i4 == 3) {
            debugStatus = 3;
            AbstractC0115a0.f2204e.set(this, null);
            AbstractC0115a0.f2205f.set(this, null);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // Z2.AbstractC0115a0, Z2.L
    public final T invokeOnTimeout(long j4, Runnable runnable, CoroutineContext coroutineContext) {
        long j5 = j4 > 0 ? j4 >= 9223372036854L ? LongCompanionObject.MAX_VALUE : 1000000 * j4 : 0L;
        if (j5 >= DurationKt.MAX_MILLIS) {
            return A0.f2162a;
        }
        long jNanoTime = System.nanoTime();
        X x4 = new X(runnable, j5 + jNanoTime);
        R(jNanoTime, x4);
        return x4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zQ;
        G0.f2166a.set(this);
        try {
            synchronized (this) {
                int i4 = debugStatus;
                if (i4 != 2 && i4 != 3) {
                    debugStatus = 1;
                    Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    notifyAll();
                    long j4 = Long.MAX_VALUE;
                    while (true) {
                        Thread.interrupted();
                        long jW = w();
                        if (jW == LongCompanionObject.MAX_VALUE) {
                            long jNanoTime = System.nanoTime();
                            if (j4 == LongCompanionObject.MAX_VALUE) {
                                j4 = f2182i + jNanoTime;
                            }
                            long j5 = j4 - jNanoTime;
                            if (j5 <= 0) {
                                _thread = null;
                                S();
                                if (Q()) {
                                    return;
                                }
                                I();
                                return;
                            }
                            jW = RangesKt.coerceAtMost(jW, j5);
                        } else {
                            j4 = Long.MAX_VALUE;
                        }
                        if (jW > 0) {
                            int i5 = debugStatus;
                            if (i5 == 2 || i5 == 3) {
                                break;
                            } else {
                                LockSupport.parkNanos(this, jW);
                            }
                        }
                    }
                    if (zQ) {
                        return;
                    } else {
                        return;
                    }
                }
                _thread = null;
                S();
                if (Q()) {
                    return;
                }
                I();
            }
        } finally {
            _thread = null;
            S();
            if (!Q()) {
                I();
            }
        }
    }
}
