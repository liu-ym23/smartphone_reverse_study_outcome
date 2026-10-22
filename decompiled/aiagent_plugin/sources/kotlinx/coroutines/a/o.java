package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: compiled from: Produce.kt */
    @d.c.b.a.f(b = "Produce.kt", c = {150}, d = "awaitClose", e = "kotlinx.coroutines.channels.ProduceKt")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f38819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f38820d;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f38819c = r2;
            this.f38820d |= Integer.MIN_VALUE;
            return o.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Produce.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<x> f38821a;

        b(kotlinx.coroutines.n<? super x> r3) {
            this.f38821a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r2) {
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f38821a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(x.f38692a));
        }
    }

    public static final Object a(q<?> r6, d.h.a.a<x> r7, d.c.d<? super x> r8) {
        q r9 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if ((r0.f38820d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f38820d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f38819c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f38820d;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r10 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r0.f38818b, d.h.a.a.class, "com.obric.aiagent.plugin");
        q r13 = (q) ZeusTransformUtils.preCheckCast(r0.f38817a, q.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L14
    L28:
        r10.invoke();
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r12);
        if (r0.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")) != r9) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L33;
        r0.f38817a = r9;     // Catch: Throwable -> L14
        r0.f38818b = r10;     // Catch: Throwable -> L14
        r0.f38820d = 1;     // Catch: Throwable -> L14
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L14
        r4.e();     // Catch: Throwable -> L14
        r9.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        Object r15 = r4.h();     // Catch: Throwable -> L14
        if (r15 != d.c.a.b.a()) goto L26;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L26:
        if (r15 != r2) goto L28;
        return r2;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r14 = false;
    L14:
        th = move-exception;
        r10.invoke();
        throw th;
    L7:
        r0 = new a(r11);
        goto L8
    }

    public static final <E> s<E> a(am r9, d.c.g r10, int r11, d.h.a.m<? super q<? super E>, ? super d.c.d<? super x>, ? extends Object> r12) {
        am r2 = (am) ZeusTransformUtils.wrapperContextForParams(r9, am.class, "com.obric.aiagent.plugin");
        d.c.g r3 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r10, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.m.class, "com.obric.aiagent.plugin");
        return a(r2, r3, r11, kotlinx.coroutines.a.a.f38771a, ao.f38851a, null, r8);
    }

    public static /* synthetic */ s a(am r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6, ao r7, d.h.a.b r8, d.h.a.m r9, int r10, Object r11) {
        am r12 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.c.g r13 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r15 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
        if ((r10 & 1) == 0) goto L5;
        r13 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L5:
        d.c.g r16 = r13;
        if ((r10 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        int r0 = r5;
        if ((r10 & 4) == 0) goto L11;
        r6 = kotlinx.coroutines.a.a.f38771a;
    L11:
        kotlinx.coroutines.a.a r1 = r6;
        if ((r10 & 8) == 0) goto L14;
        r7 = ao.f38851a;
    L14:
        ao r2 = r7;
        if ((r10 & 16) == 0) goto L17;
        d.h.a.b r17 = null;
    L19:
        return a(r12, r16, r0, r1, r2, r17, r15);
    L17:
        r17 = r14;
        goto L19
    }

    public static final <E> s<E> a(am r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6, ao r7, d.h.a.b<? super Throwable, x> r8, d.h.a.m<? super q<? super E>, ? super d.c.d<? super x>, ? extends Object> r9) {
        am r10 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.c.g r11 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Throwable, x> r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m r13 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
        d r14 = g.a(r5, r6, null, 4, null);
        p r15 = new p(ah.a(r10, r11), r14);
        if (r12 == null) goto L5;
        r15.a_(r12);
    L5:
        r15.a(r7, r15, r13);
        return (s) ZeusTransformUtils.preCheckCast(r15, s.class, "com.obric.aiagent.plugin");
    }
}
