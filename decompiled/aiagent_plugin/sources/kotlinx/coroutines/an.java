package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: CoroutineScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class an {
    public static final am a() {
        return (am) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.h(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"))), am.class, "com.obric.aiagent.plugin");
    }

    public static final boolean a(am r3) {
        ca r4 = (ca) ZeusTransformUtils.preCheckCast(((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin")).a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return true;
    L7:
        return r4.b();
    }

    public static final <R> Object a(d.h.a.m<? super am, ? super d.c.d<? super R>, ? extends Object> r2, d.c.d<? super R> r3) {
        d.h.a.m r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.internal.ah r0 = new kotlinx.coroutines.internal.ah(r5.getContext(), r5);
        Object r6 = kotlinx.coroutines.c.b.a(r0, r0, r4);
        if (r6 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r5);
    L5:
        return r6;
    }

    public static final am a(d.c.g r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        if (r5.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")) != null) goto L7;
        r5 = r5.plus((d.c.g) ZeusTransformUtils.preCheckCast(ce.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin"));
    L7:
        return (am) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.h(r5), am.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void a(am r1, CancellationException r2, int r3, Object r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r1, am.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        a(r5, r2);
    }

    public static final void a(am r4, CancellationException r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.aiagent.plugin");
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(r6.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.a(r5);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r6).toString());
    }

    public static final void a(am r2, String r3, Throwable r4) {
        a((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.aiagent.plugin"), bo.a(r3, r4));
    }

    public static /* synthetic */ void a(am r1, String r2, Throwable r3, int r4, Object r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r1, am.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        a(r6, r2, r3);
    }

    public static final void b(am r2) {
        ce.b(((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.aiagent.plugin")).a());
    }
}
