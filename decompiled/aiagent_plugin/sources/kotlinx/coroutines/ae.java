package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ae {
    public static /* synthetic */ Object a(Object r1, d.h.a.b r2, int r3, Object r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = null;
    L6:
        return a(r1, r5);
    }

    public static final <T> Object a(Object r3, d.h.a.b<? super Throwable, d.x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        Throwable r0 = d.n.c(r3);
        if (r0 != null) goto L7;
        if (r5 != null) goto L9;
        return r3;
    L9:
        return new ac(r3, r5);
    L7:
        return new ab(r0, false, 2, null);
    }

    public static final <T> Object a(Object r4, n<?> r5) {
        n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
        Throwable r0 = d.n.c(r4);
        if (r0 != null) goto L6;
    L12:
        return r4;
    L6:
        if (aq.c() == true) goto L8;
    L11:
        r4 = new ab(r0, false, 2, null);
        goto L12
    L8:
        if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == false) goto L11;
        r0 = kotlinx.coroutines.internal.ak.a(r0, (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
        goto L11
    }

    public static final <T> Object a(Object r2, d.c.d<? super T> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L11;
        d.n.a r0 = d.n.f38560a;
        Throwable r5 = ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin")).f38830a;
        if (aq.c() == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, d.c.b.a.e.class) == false) goto L13;
        r5 = kotlinx.coroutines.internal.ak.a(r5, (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r4, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L13:
        return d.n.f(d.o.a(r5));
    L11:
        d.n.a r6 = d.n.f38560a;
        return d.n.f(r2);
    }
}
