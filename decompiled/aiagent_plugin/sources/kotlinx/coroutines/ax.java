package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ax {
    public static final Object a(long r4, d.c.d<? super d.x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (r4 <= 0) goto L5;
        o r0 = new o(d.c.a.b.a(r7), 1);
        r0.e();
        n<? super d.x> r1 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        if (r4 >= Long.MAX_VALUE) goto L9;
        a(r1.getContext()).a(r4, r1);
    L9:
        Object r5 = r0.h();
        if (r5 != d.c.a.b.a()) goto L13;
        d.c.b.a.h.c(r7);
    L13:
        if (r5 != d.c.a.b.a()) goto L16;
        return r5;
    L16:
        return d.x.f38692a;
    L5:
        return d.x.f38692a;
    }

    public static final aw a(d.c.g r3) {
        d.c.g.b r4 = ((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin")).get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"));
        if (ZeusTransformUtils.instanceOf(r4, aw.class) == false) goto L5;
        aw r5 = (aw) ZeusTransformUtils.preCheckCast(r4, aw.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return at.a();
    L5:
        r5 = null;
        goto L6
    }
}
