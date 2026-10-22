package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Yield.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class dm {
    public static final Object a(d.c.d<? super d.x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r0 = r6.getContext();
        ce.b(r0);
        d.c.d r2 = d.c.a.b.a(r6);
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.m.class) == false) goto L5;
        kotlinx.coroutines.internal.m r3 = (kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 != null) goto L9;
        Object r1 = d.x.f38692a;
    L19:
        if (r1 != d.c.a.b.a()) goto L22;
        d.c.b.a.h.c(r6);
    L22:
        if (r1 != d.c.a.b.a()) goto L25;
        return r1;
    L25:
        return d.x.f38692a;
    L9:
        if (r3.f39397b.a(r0) == false) goto L11;
        r3.a(r0, d.x.f38692a);
    L17:
        r1 = d.c.a.b.a();
        goto L19
    L11:
        dl r4 = new dl();
        r3.a(r0.plus((d.c.g) ZeusTransformUtils.preCheckCast(r4, d.c.g.class, "com.obric.aiagent.plugin")), d.x.f38692a);
        if (r4.f39268b == false) goto L17;
        if (kotlinx.coroutines.internal.n.a(r3) == false) goto L16;
        r1 = d.c.a.b.a();
        goto L19
    L16:
        r1 = d.x.f38692a;
        goto L19
    L5:
        r3 = null;
        goto L6
    }
}
