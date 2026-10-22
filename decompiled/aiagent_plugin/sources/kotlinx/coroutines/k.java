package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class k {
    public static /* synthetic */ ca a(am r1, d.c.g r2, ao r3, d.h.a.m r4, int r5, Object r6) {
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r1, am.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r8 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = ao.f38851a;
    L9:
        return i.a(r7, r8, r3, r9);
    }

    public static final ca a(am r2, d.c.g r3, ao r4, d.h.a.m<? super am, ? super d.c.d<? super d.x>, ? extends Object> r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.aiagent.plugin");
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.g r9 = ah.a(r6, r7);
        if (r4.a() == false) goto L5;
        cv r10 = (cv) ZeusTransformUtils.preCheckCast(new cl(r9, r8), cv.class, "com.obric.aiagent.plugin");
    L6:
        r10.a(r4, r10, r8);
        return (ca) ZeusTransformUtils.preCheckCast(r10, ca.class, "com.obric.aiagent.plugin");
    L5:
        r10 = new cv(r9, true);
        goto L6
    }

    public static /* synthetic */ au b(am r1, d.c.g r2, ao r3, d.h.a.m r4, int r5, Object r6) {
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r1, am.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r8 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = ao.f38851a;
    L9:
        return i.b(r7, r8, r3, r9);
    }

    public static final <T> au<T> b(am r2, d.c.g r3, ao r4, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.aiagent.plugin");
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.g r9 = ah.a(r6, r7);
        if (r4.a() == false) goto L5;
        av r10 = (av) ZeusTransformUtils.preCheckCast(new ck(r9, r8), av.class, "com.obric.aiagent.plugin");
    L6:
        r10.a(r4, r10, r8);
        return (au) ZeusTransformUtils.preCheckCast(r10, au.class, "com.obric.aiagent.plugin");
    L5:
        r10 = new av(r9, true);
        goto L6
    }

    public static final <T> Object a(d.c.g r8, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r9, d.c.d<? super T> r10) {
        d.c.g r11 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r8, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r13 = r12.getContext();
        d.c.g r14 = ah.a(r13, r11);
        ce.b(r14);
        if (r14 != r13) goto L6;
        kotlinx.coroutines.internal.ah r15 = new kotlinx.coroutines.internal.ah(r14, r12);
        Object r16 = kotlinx.coroutines.c.b.a(r15, r15, r2);
    L15:
        if (r16 != d.c.a.b.a()) goto L17;
        d.c.b.a.h.c(r12);
    L17:
        return r16;
    L6:
        if (d.h.b.o.a(r14.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")), r13.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        di r17 = new di(r14, r12);
        d.c.g r18 = r17.getContext();
        Object r0 = kotlinx.coroutines.internal.ap.a(r18, null);
        Object r19 = kotlinx.coroutines.c.b.a((kotlinx.coroutines.internal.ah) ZeusTransformUtils.preCheckCast(r17, kotlinx.coroutines.internal.ah.class, "com.obric.aiagent.plugin"), r17, r2);     // Catch: Throwable -> L10
        kotlinx.coroutines.internal.ap.b(r18, r0);
        r16 = r19;
    L10:
        th = move-exception;
        kotlinx.coroutines.internal.ap.b(r18, r0);
        throw th;
    L13:
        az r110 = new az(r14, r12);
        kotlinx.coroutines.c.a.a(r2, r110, (d.c.d) ZeusTransformUtils.preCheckCast(r110, d.c.d.class, "com.obric.aiagent.plugin"), null, 4, null);
        r16 = r110.f();
        goto L15
    }
}
