package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class as extends bk implements Runnable {
    private static volatile Thread _thread;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final as f38861a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f38862d = 0;
    private static volatile int debugStatus;

    private as() {
    }

    static {
        as r0 = new as();
        f38861a = r0;
        bj.a((bj) ZeusTransformUtils.preCheckCast(r0, bj.class, "com.obric.aiagent.plugin"), false, 1, null);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f38862d = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    @Override // kotlinx.coroutines.bl
    public Thread a() {
        Thread r0 = _thread;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return o();
    }

    private final boolean l() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean m() {
        int r1 = debugStatus;
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.bk
    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (l() == false) goto L5;
        n();
    L5:
        super.a(r4);
    }

    @Override // kotlinx.coroutines.bl
    public void a(long r1, bk.c r3) {
        n();
    }

    private final void n() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.bk, kotlinx.coroutines.bj
    public void b() {
        debugStatus = 4;
        super.b();
    }

    @Override // kotlinx.coroutines.bk, kotlinx.coroutines.aw
    public bf a(long r3, Runnable r5, d.c.g r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.class, "com.obric.aiagent.plugin");
        return a(r3, r7);
    }

    @Override // java.lang.Runnable
    public void run() {
        cz.f39215a.a((bj) ZeusTransformUtils.preCheckCast(this, bj.class, "com.obric.aiagent.plugin"));
        b r0 = c.a();
        if (r0 == null) goto L63;
        r0.d();
    L63:
    L55:
        th = move-exception;
        _thread = null;
        q();
        b r1 = c.a();
        if (r1 == null) goto L60;
        r1.e();
    L60:
        if (d() == true) goto L62;
        a();
    L62:
        throw th;
    L7:
        if (p() == true) goto L15;
        _thread = null;
        q();
        b r2 = c.a();
        if (r2 == null) goto L12;
        r2.e();
    L12:
        if (d() == true) goto L73;
        a();
        return;
    L73:
        return;
    L15:
        long r3 = Long.MAX_VALUE;
    L16:
        Thread.interrupted();     // Catch: Throwable -> L55
        long r5 = c();     // Catch: Throwable -> L55
        if (r5 != Long.MAX_VALUE) goto L36;
        b r7 = c.a();     // Catch: Throwable -> L55
        if (r7 == null) goto L21;
        long r10 = r7.a();     // Catch: Throwable -> L55
    L23:
        if (r3 == Long.MAX_VALUE) goto L25;
    L26:
        long r11 = r3 - r10;
        if (r11 <= 0) goto L28;
        r5 = d.l.n.b(r5, r11);     // Catch: Throwable -> L55
    L38:
        if (r5 <= 0) goto L16;
        if (m() == true) goto L41;
        b r8 = c.a();     // Catch: Throwable -> L55
        if (r8 == null) goto L51;
        r8.a(this, r5);     // Catch: Throwable -> L55
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L55
    L52:
        if (r9 != null) goto L16;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L55
        goto L16
    L51:
        r9 = null;
        goto L52
    L41:
        _thread = null;
        q();
        b r4 = c.a();
        if (r4 == null) goto L45;
        r4.e();
    L45:
        if (d() == true) goto L75;
        a();
        return;
    L75:
        return;
    L28:
        _thread = null;
        q();
        b r6 = c.a();
        if (r6 == null) goto L32;
        r6.e();
    L32:
        if (d() == true) goto L74;
        a();
        return;
    L74:
        return;
    L25:
        r3 = f38862d + r10;
        goto L26
    L21:
        r10 = System.nanoTime();     // Catch: Throwable -> L55
        goto L23
    L36:
        r3 = Long.MAX_VALUE;
        goto L38
    }

    private final synchronized Thread o() {
        monitor-enter(this);
        Thread r0 = _thread;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L8
        _thread = r0;     // Catch: Throwable -> L8
        r0.setContextClassLoader(getClass().getClassLoader());     // Catch: Throwable -> L8
        r0.setDaemon(true);     // Catch: Throwable -> L8
        r0.start();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private final synchronized boolean p() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (m() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        d.h.b.o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    private final synchronized void q() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (m() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        j();     // Catch: Throwable -> L11
        d.h.b.o.a(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L11
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.aiagent.plugin").notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
