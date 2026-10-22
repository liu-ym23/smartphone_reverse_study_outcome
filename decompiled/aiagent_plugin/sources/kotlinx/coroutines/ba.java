package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ba<T> extends kotlinx.coroutines.d.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39142a;

    public void a(Object r1, Throwable r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T b(Object r1) {
        return r1;
    }

    public abstract d.c.d<T> c();

    public abstract Object g();

    public ba(int r1) {
        this.f39142a = r1;
    }

    public Throwable c(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L5;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.f38830a;
    L5:
        r2 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (aq.a() == true) goto L5;
    L12:
        kotlinx.coroutines.d.i r1 = this.g;
        d.c.d<T> r2 = c();     // Catch: Throwable -> L54
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");     // Catch: Throwable -> L54
        kotlinx.coroutines.internal.m r3 = (kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        d.c.d<T> r4 = r3.f39398c;     // Catch: Throwable -> L54
        Object r5 = r3.f39400e;     // Catch: Throwable -> L54
        d.c.g r6 = r4.getContext();     // Catch: Throwable -> L54
        Object r7 = kotlinx.coroutines.internal.ap.a(r6, r5);     // Catch: Throwable -> L54
        if (r7 == kotlinx.coroutines.internal.ap.f39371a) goto L17;
        di<?> r8 = ah.a(r4, r6, r7);     // Catch: Throwable -> L54
    L64:
        d.c.g r9 = r4.getContext();     // Catch: Throwable -> L48
        Object r10 = g();     // Catch: Throwable -> L48
        Throwable r11 = c(r10);     // Catch: Throwable -> L48
        if (r11 == null) goto L21;
    L23:
        ca r12 = null;
    L24:
        if (r12 != null) goto L26;
    L35:
        if (r11 == null) goto L37;
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L48
        r4.resumeWith(d.n.f(d.o.a(r11)));     // Catch: Throwable -> L48
    L38:
        d.x r14 = d.x.f38692a;     // Catch: Throwable -> L48
        if (r8 != null) goto L41;
    L42:
        kotlinx.coroutines.internal.ap.b(r6, r7);     // Catch: Throwable -> L54
    L61:
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L45
        ba r0 = (ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        r1.b();     // Catch: Throwable -> L45
        Object r16 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L45
    L47:
        a(null, d.n.c(r16));
        return;
    L45:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r16 = d.n.f(d.o.a(th));
        goto L47
    L41:
        if (r8.g() == false) goto L61;
    L37:
        d.n.a r18 = d.n.f38560a;     // Catch: Throwable -> L48
        r4.resumeWith(d.n.f(b(r10)));     // Catch: Throwable -> L48
        goto L38
    L26:
        if (r12.b() == true) goto L35;
        CancellationException r19 = r12.k();     // Catch: Throwable -> L48
        a(r10, (Throwable) ZeusTransformUtils.preCheckCast(r19, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L48
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L48
        if (aq.c() == true) goto L30;
    L33:
        Throwable r21 = (Throwable) ZeusTransformUtils.preCheckCast(r19, Throwable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
    L34:
        r4.resumeWith(d.n.f(d.o.a(r21)));     // Catch: Throwable -> L48
        goto L38
    L30:
        if (ZeusTransformUtils.instanceOf(r4, d.c.b.a.e.class) == false) goto L33;
        r21 = kotlinx.coroutines.internal.ak.a((Throwable) ZeusTransformUtils.preCheckCast(r19, Throwable.class, "com.obric.aiagent.plugin"), (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r4, d.c.b.a.e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L48
        goto L34
    L21:
        if (bb.a(this.f39142a) == false) goto L23;
        r12 = (ca) ZeusTransformUtils.preCheckCast(r9.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if (r8 != null) goto L51;
    L52:
        kotlinx.coroutines.internal.ap.b(r6, r7);     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L51:
        if (r8.g() == false) goto L53;
    L17:
        r8 = null;
    L54:
        th = move-exception;
        d.n.a r22 = d.n.f38560a;     // Catch: Throwable -> L57
        r1.b();     // Catch: Throwable -> L57
        Object r23 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L57
    L59:
        a(th, d.n.c(r23));
        return;
    L57:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r23 = d.n.f(d.o.a(th));
        goto L59
    L5:
        if (this.f39142a == (-1)) goto L7;
        boolean r25 = true;
    L8:
        if (r25 == true) goto L12;
        throw new AssertionError();
    L7:
        r25 = false;
        goto L8
    }

    public final void a(Throwable r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        d.a.a(r3, r4);
    L8:
        if (r3 != null) goto L10;
        r3 = r4;
    L10:
        d.h.b.o.a(r3);
        aj.a(c().getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new ap("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", r3), Throwable.class, "com.obric.aiagent.plugin"));
    }
}
