package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bb {
    public static final boolean a(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean b(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void a(ba<? super T> r4, int r5) {
        boolean r1 = true;
        if (aq.a() == true) goto L5;
    L12:
        d.c.d<? super T> r0 = r4.c();
        if (r5 == 4) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
    L25:
        a(r4, r0, r1);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.m.class) == false) goto L25;
        if (a(r5) != a(r4.f39142a)) goto L25;
        ai r6 = ((kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin")).f39397b;
        d.c.g r2 = r0.getContext();
        if (r6.a(r2) == false) goto L24;
        r6.a(r2, (Runnable) ZeusTransformUtils.preCheckCast(r4, Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        a(r4);
        return;
    L5:
        if (r5 == (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    public static final <T> void a(ba<? super T> r3, d.c.d<? super T> r4, boolean r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r0 = r3.g();
        Throwable r2 = r3.c(r0);
        if (r2 == null) goto L5;
        d.n.a r7 = d.n.f38560a;
        Object r8 = d.o.a(r2);
    L6:
        Object r9 = d.n.f(r8);
        if (r5 == false) goto L23;
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.m r10 = (kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin");
        d.c.d<T> r11 = r10.f39398c;
        Object r1 = r10.f39400e;
        d.c.g r12 = r11.getContext();
        Object r13 = kotlinx.coroutines.internal.ap.a(r12, r1);
        if (r13 == kotlinx.coroutines.internal.ap.f39371a) goto L11;
        di<?> r14 = ah.a(r11, r12, r13);
    L25:
        r10.f39398c.resumeWith(r9);     // Catch: Throwable -> L17
        d.x r15 = d.x.f38692a;     // Catch: Throwable -> L17
        if (r14 != null) goto L15;
    L16:
        kotlinx.coroutines.internal.ap.b(r12, r13);
        return;
    L15:
        if (r14.g() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r14 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.ap.b(r12, r13);
    L22:
        throw th;
    L20:
        if (r14.g() == false) goto L22;
    L11:
        r14 = null;
        goto L25
    L23:
        r6.resumeWith(r9);
        return;
    L5:
        d.n.a r16 = d.n.f38560a;
        r8 = r3.b(r0);
        goto L6
    }

    private static final void a(ba<?> r4) {
        bj r0 = cz.f39215a.a();
        if (r0.h() == false) goto L5;
        r0.a(r4);
        return;
    L5:
        r0.a(true);
        a(r4, r4.c(), true);     // Catch: Throwable -> L10
    L7:
        if (r0.f() == true) goto L7;
    L13:
        r0.b(true);
        return;
    L10:
        th = move-exception;
        r4.a(th, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.b(true);
        throw th;
    }
}
