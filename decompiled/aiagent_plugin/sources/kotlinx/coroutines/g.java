package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
final class g<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f39348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bj f39349c;

    @Override // kotlinx.coroutines.ci
    public boolean e() {
        return true;
    }

    public g(d.c.g r3, Thread r4, bj r5) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), true, true);
        this.f39348b = r4;
        this.f39349c = r5;
    }

    @Override // kotlinx.coroutines.ci
    public void d(Object r2) {
        if (d.h.b.o.a(Thread.currentThread(), this.f39348b) == true) goto L11;
        Thread r1 = this.f39348b;
        b r3 = c.a();
        if (r3 == null) goto L7;
        r3.a(r1);
        d.x r4 = d.x.f38692a;
    L8:
        if (r4 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final T p_() {
        b r0 = c.a();
        if (r0 == null) goto L49;
        r0.d();
    L49:
        bj r1 = this.f39349c;     // Catch: Throwable -> L44
        ab r3 = null;
        if (r1 == null) goto L50;
        bj.a(r1, false, 1, null);     // Catch: Throwable -> L44
    L50:
    L39:
        th = move-exception;
        bj r7 = this.f39349c;     // Catch: Throwable -> L44
        if (r7 == null) goto L43;
        bj.b(r7, false, 1, null);     // Catch: Throwable -> L44
    L43:
        throw th;     // Catch: Throwable -> L44
    L10:
        if (Thread.interrupted() == true) goto L37;
        bj r2 = this.f39349c;     // Catch: Throwable -> L39
        if (r2 == null) goto L14;
        long r5 = r2.c();     // Catch: Throwable -> L39
    L16:
        if (i() == true) goto L24;
        b r4 = c.a();     // Catch: Throwable -> L39
        if (r4 == null) goto L20;
        r4.a(this, r5);     // Catch: Throwable -> L39
        d.x r6 = d.x.f38692a;     // Catch: Throwable -> L39
    L21:
        if (r6 != null) goto L50;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L39
        goto L50
    L20:
        r6 = null;
        goto L21
    L24:
        bj r8 = this.f39349c;     // Catch: Throwable -> L44
        if (r8 == null) goto L27;
        bj.b(r8, false, 1, null);     // Catch: Throwable -> L44
    L27:
        b r9 = c.a();
        if (r9 == null) goto L30;
        r9.e();
    L30:
        T r10 = (T) cj.b(n());
        if (ZeusTransformUtils.instanceOf(r10, ab.class) == false) goto L33;
        r3 = (ab) ZeusTransformUtils.preCheckCast(r10, ab.class, "com.obric.aiagent.plugin");
    L33:
        if (r3 != null) goto L36;
        return r10;
    L36:
        throw r3.f38830a;
    L14:
        r5 = Long.MAX_VALUE;
        goto L16
    L37:
        InterruptedException r11 = new InterruptedException();     // Catch: Throwable -> L39
        d((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39
    L44:
        th = move-exception;
        b r12 = c.a();
        if (r12 == null) goto L48;
        r12.e();
    L48:
        throw th;
    }
}
