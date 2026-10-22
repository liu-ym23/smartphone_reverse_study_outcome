package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class j {
    public static /* synthetic */ Object a(d.c.g r1, d.h.a.m r2, int r3, Object r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r1, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        return i.a(r5, r6);
    }

    public static final <T> T a(d.c.g r5, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r6) {
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        Thread r0 = Thread.currentThread();
        d.c.e r2 = (d.c.e) ZeusTransformUtils.preCheckCast(r7.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")), d.c.e.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        bj r3 = cz.f39215a.a();
        d.c.g r9 = ah.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), r7.plus((d.c.g) ZeusTransformUtils.preCheckCast(r3, d.c.g.class, "com.obric.aiagent.plugin")));
    L18:
        g r1 = new g(r9, r0, r3);
        r1.a(ao.f38851a, r1, r8);
        return (T) r1.p_();
    L5:
        bj r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, bj.class) == false) goto L8;
        bj r10 = (bj) ZeusTransformUtils.preCheckCast(r2, bj.class, "com.obric.aiagent.plugin");
    L9:
        if (r10 != null) goto L11;
    L16:
        r3 = cz.f39215a.b();
    L17:
        r9 = ah.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), r7);
        goto L18
    L11:
        if (r10.g() == false) goto L13;
        r4 = r10;
    L13:
        if (r4 == null) goto L16;
        r3 = r4;
        goto L17
    L8:
        r10 = null;
        goto L9
    }
}
