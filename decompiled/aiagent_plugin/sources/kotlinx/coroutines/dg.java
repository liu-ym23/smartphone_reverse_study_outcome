package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class dg {

    /* JADX INFO: compiled from: Timeout.kt */
    @d.c.b.a.f(b = "Timeout.kt", c = {101}, d = "withTimeoutOrNull", e = "kotlinx.coroutines.TimeoutKt")
    static final class a<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f39259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f39260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f39261c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f39262d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f39263e;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f39262d = r3;
            this.f39263e |= Integer.MIN_VALUE;
            return dg.b(0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final <T> Object a(long r2, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r4, d.c.d<? super T> r5) {
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (r2 <= 0) goto L9;
        Object r3 = a(new df(r2, r7), r6);
        if (r3 != d.c.a.b.a()) goto L7;
        d.c.b.a.h.c(r7);
    L7:
        return r3;
    L9:
        throw new de("Timed out immediately");
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, kotlinx.coroutines.df] */
    public static final <T> Object b(long r8, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r10, d.c.d<? super T> r11) {
        d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        if ((r0.f39263e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f39263e -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f39262d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f39263e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        long r9 = r0.f39259a;
        d.h.b.z.f r15 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r0.f39261c, d.h.b.z.f.class, "com.obric.aiagent.plugin");
        d.h.a.m r16 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0.f39260b, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.o.a(r14);     // Catch: de -> L14
        return r14;
    L14:
        e = e;
    L32:
        if (e.f39257a != r15.f38504a) goto L34;
        return null;
    L34:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r14);
        if (r8 > 0) goto L21;
        return null;
    L21:
        d.h.b.z.f r17 = new d.h.b.z.f();
        r0.f39260b = r12;     // Catch: de -> L29
        r0.f39261c = r17;     // Catch: de -> L29
        r0.f39259a = r8;     // Catch: de -> L29
        r0.f39263e = 1;     // Catch: de -> L29
        ?? r5 = (T) new df(r8, (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));
        r17.f38504a = r5;     // Catch: de -> L29
        Object r18 = a(r5, r12);     // Catch: de -> L29
        if (r18 != d.c.a.b.a()) goto L25;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: de -> L29
    L25:
        if (r18 != r2) goto L28;
        return r2;
    L28:
        return r18;
    L29:
        e = e;
        r15 = r17;
    L7:
        r0 = new a(r13);
        goto L8
    }

    private static final <U, T extends U> Object a(df<U, ? super T> r7, d.h.a.m<? super am, ? super d.c.d<? super T>, ? extends Object> r8) {
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.g r0 = r7.f39362c.getContext();
        ce.a((ca) ZeusTransformUtils.preCheckCast(r7, ca.class, "com.obric.aiagent.plugin"), ax.a(r0).a(r7.f39258b, (Runnable) ZeusTransformUtils.preCheckCast(r7, Runnable.class, "com.obric.aiagent.plugin"), r7.getContext()));
        return kotlinx.coroutines.c.b.b((kotlinx.coroutines.internal.ah) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.internal.ah.class, "com.obric.aiagent.plugin"), r7, r9);
    }

    public static final de a(long r2, aw r4, ca r5) {
        aw r6 = (aw) ZeusTransformUtils.wrapperContextForParams(r4, aw.class, "com.obric.aiagent.plugin");
        ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r5, ca.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ay.class) == false) goto L5;
        ay r8 = (ay) ZeusTransformUtils.preCheckCast(r6, ay.class, "com.obric.aiagent.plugin");
    L6:
        if (r8 == null) goto L9;
        d.p.a.C1042a r0 = d.p.a.f38671a;
        String r9 = r8.a(d.p.c.a(r2, d.p.d.f38680c));
        if (r9 == null) goto L9;
    L11:
        return new de(r9, r7);
    L9:
        r9 = "Timed out waiting for " + r2 + " ms";
        goto L11
    L5:
        r8 = null;
        goto L6
    }
}
