package Ua;

import Ua.AbstractC1055f0;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0005R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010'\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010\u0005R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020\u001d8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u001fR\u0014\u00100\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\"R\u0014\u00102\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\"¨\u00063"}, d2 = {"LUa/O;", "LUa/f0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "task", "LY8/t;", "L1", "(Ljava/lang/Runnable;)V", "", "now", "LUa/f0$c;", "delayedTask", "G1", "(JLUa/f0$c;)V", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/d;", "context", "LUa/a0;", "U", "(JLjava/lang/Runnable;Lkotlin/coroutines/d;)LUa/a0;", "run", "", "toString", "()Ljava/lang/String;", "e2", "Ljava/lang/Thread;", SdCardDbCreator.FIELD_LASTLOC_INFO, "()Ljava/lang/Thread;", "", "d2", "()Z", "Z1", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "F1", "thread", "b2", "isShutDown", "c2", "isShutdownRequested", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class O extends AbstractC1055f0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h, reason: collision with root package name */
    public static final O f6337h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final long KEEP_ALIVE_NANOS;

    static {
        Long l10;
        O o10 = new O();
        f6337h = o10;
        AbstractC1053e0.A1(o10, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l10.longValue());
    }

    @Override // Ua.AbstractC1057g0
    /* renamed from: F1 */
    public Thread getThread() {
        Thread thread = _thread;
        return thread == null ? a2() : thread;
    }

    @Override // Ua.AbstractC1057g0
    public void G1(long now, AbstractC1055f0.c delayedTask) {
        e2();
    }

    @Override // Ua.AbstractC1055f0
    public void L1(Runnable task) {
        if (b2()) {
            e2();
        }
        super.L1(task);
    }

    @Override // Ua.AbstractC1055f0, Ua.T
    public InterfaceC1045a0 U(long timeMillis, Runnable block, kotlin.coroutines.d context) {
        return W1(timeMillis, block);
    }

    public final synchronized void Z1() {
        if (c2()) {
            debugStatus = 3;
            T1();
            kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread a2() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(f6337h.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean b2() {
        return debugStatus == 4;
    }

    public final boolean c2() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    public final synchronized boolean d2() {
        if (c2()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void e2() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zR1;
        O0.f6339a.d(this);
        C1046b.a();
        try {
            if (!d2()) {
                if (zR1) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jD1 = D1();
                if (jD1 == Long.MAX_VALUE) {
                    C1046b.a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = KEEP_ALIVE_NANOS + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        Z1();
                        C1046b.a();
                        if (R1()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    jD1 = C5685n.k(jD1, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jD1 > 0) {
                    if (c2()) {
                        _thread = null;
                        Z1();
                        C1046b.a();
                        if (R1()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    C1046b.a();
                    LockSupport.parkNanos(this, jD1);
                }
            }
        } finally {
            _thread = null;
            Z1();
            C1046b.a();
            if (!R1()) {
                getThread();
            }
        }
    }

    @Override // Ua.AbstractC1055f0, Ua.AbstractC1053e0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // Ua.I
    /* renamed from: toString */
    public String getName() {
        return "DefaultExecutor";
    }
}
