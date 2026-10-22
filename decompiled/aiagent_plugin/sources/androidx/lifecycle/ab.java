package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: RepeatOnLifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
    @d.c.b.a.f(b = "RepeatOnLifecycle.kt", c = {84}, d = "invokeSuspend", e = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f1980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.b f1981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> f1982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f1983e;

        /* JADX INFO: renamed from: androidx.lifecycle.ab$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
        @d.c.b.a.f(b = "RepeatOnLifecycle.kt", c = {166}, d = "invokeSuspend", e = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f1984a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f1985b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f1986c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f1987d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f1988e;
            Object f;
            int g;
            final /* synthetic */ i h;
            final /* synthetic */ i.b i;
            final /* synthetic */ kotlinx.coroutines.am j;
            final /* synthetic */ d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> k;

            AnonymousClass1(i r3, i.b r4, kotlinx.coroutines.am r5, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super d.x>, ? extends Object> r6, d.c.d<? super AnonymousClass1> r7) {
                kotlinx.coroutines.am r8 = (kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
                d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r3;
                this.i = r4;
                this.j = r8;
                this.k = r9;
                super(2, r10);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.h, this.i, this.j, this.k, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r8v1, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r19) {
                Object r0 = d.c.a.b.a();
                int r2 = this.g;
                if (r2 == 0) goto L12;
                if (r2 != 1) goto L11;
                d.h.a.m r1 = (d.h.a.m) ZeusTransformUtils.preCheckCast(this.f, d.h.a.m.class, "com.obric.aiagent.plugin");
                kotlinx.coroutines.am r3 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f1988e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
                i r4 = (i) ZeusTransformUtils.preCheckCast(this.f1987d, i.class, "com.obric.aiagent.plugin");
                i.b r5 = (i.b) ZeusTransformUtils.preCheckCast(this.f1986c, i.b.class, "com.obric.aiagent.plugin");
                d.h.b.z.f r6 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f1985b, d.h.b.z.f.class, "com.obric.aiagent.plugin");
                d.h.b.z.f r7 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f1984a, d.h.b.z.f.class, "com.obric.aiagent.plugin");
                d.o.a(r19);     // Catch: Throwable -> L8
            L23:
                ca r8 = (ca) ZeusTransformUtils.preCheckCast(r7.f38504a, ca.class, "com.obric.aiagent.plugin");
                if (r8 == null) goto L26;
                ca.a.a(r8, null, 1, null);
            L26:
                m r9 = (m) ZeusTransformUtils.preCheckCast(r6.f38504a, m.class, "com.obric.aiagent.plugin");
                if (r9 == null) goto L30;
                this.h.b((o) ZeusTransformUtils.preCheckCast(r9, o.class, "com.obric.aiagent.plugin"));
            L30:
                return d.x.f38692a;
            L8:
                th = th;
            L33:
                ca r10 = (ca) ZeusTransformUtils.preCheckCast(r7.f38504a, ca.class, "com.obric.aiagent.plugin");
                if (r10 == null) goto L36;
                ca.a.a(r10, null, 1, null);
            L36:
                m r11 = (m) ZeusTransformUtils.preCheckCast(r6.f38504a, m.class, "com.obric.aiagent.plugin");
                if (r11 == null) goto L39;
                this.h.b((o) ZeusTransformUtils.preCheckCast(r11, o.class, "com.obric.aiagent.plugin"));
            L39:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                d.o.a(r19);
                if (this.h.b() == i.b.f2054a) goto L15;
                final d.h.b.z.f r12 = new d.h.b.z.f();
                d.h.b.z.f r14 = new d.h.b.z.f();
                i.b r13 = this.i;     // Catch: Throwable -> L31
                i r15 = this.h;     // Catch: Throwable -> L31
                final kotlinx.coroutines.am r16 = this.j;     // Catch: Throwable -> L31
                final d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> r17 = this.k;     // Catch: Throwable -> L31
                this.f1984a = r12;     // Catch: Throwable -> L31
                this.f1985b = r14;     // Catch: Throwable -> L31
                this.f1986c = r13;     // Catch: Throwable -> L31
                this.f1987d = r15;     // Catch: Throwable -> L31
                this.f1988e = r16;     // Catch: Throwable -> L31
                this.f = r17;     // Catch: Throwable -> L31
                this.g = 1;     // Catch: Throwable -> L31
                kotlinx.coroutines.o r18 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L31
                r18.e();     // Catch: Throwable -> L31
                final kotlinx.coroutines.n r110 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r18, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
                final i.a r20 = i.a.Companion.c(r13);     // Catch: Throwable -> L31
                final i.a r111 = i.a.Companion.a(r13);     // Catch: Throwable -> L31
                final kotlinx.coroutines.f.a r112 = kotlinx.coroutines.f.c.a(false, 1, null);     // Catch: Throwable -> L31
                r14.f38504a = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r20, r12, r16, r111, r110, r112, r17);     // Catch: Throwable -> L31
                T r21 = r14.f38504a;     // Catch: Throwable -> L31
                d.h.b.o.a(r21, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
                r15.a((o) ZeusTransformUtils.preCheckCast((m) ZeusTransformUtils.preCheckCast(r21, m.class, "com.obric.aiagent.plugin"), o.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
                Object r22 = r18.h();     // Catch: Throwable -> L31
                if (r22 != d.c.a.b.a()) goto L20;
                d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
            L20:
                if (r22 != r0) goto L22;
                return r0;
            L22:
                r7 = r12;
                r6 = r14;
            L31:
                th = th;
                r7 = r12;
                r6 = r14;
                goto L33
            L15:
                return d.x.f38692a;
            }
        }

        a(i r3, i.b r4, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super d.x>, ? extends Object> r5, d.c.d<? super a> r6) {
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1980b = r3;
            this.f1981c = r4;
            this.f1982d = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f1980b, this.f1981c, this.f1982d, r7);
            r0.f1983e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f1979a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            kotlinx.coroutines.am r7 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f1983e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.c.g r12 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b().a(), d.c.g.class, "com.obric.aiagent.plugin");
            d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f1980b, this.f1981c, r7, this.f1982d, null), d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1979a = 1;
            if (kotlinx.coroutines.i.a(r12, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final Object a(i r3, i.b r4, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super d.x>, ? extends Object> r5, d.c.d<? super d.x> r6) {
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (r4 == i.b.f2055b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        if (r3.b() == i.b.f2054a) goto L10;
        Object r9 = kotlinx.coroutines.an.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, r4, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
        if (r9 != d.c.a.b.a()) goto L15;
        return r9;
    L15:
        return d.x.f38692a;
    L10:
        return d.x.f38692a;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Object a(p r2, i.b r3, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super d.x>, ? extends Object> r4, d.c.d<? super d.x> r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r2, p.class, "com.obric.aiagent.plugin");
        d.h.a.m r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Object r9 = a(r6.getLifecycle(), r3, r7, r8);
        if (r9 != d.c.a.b.a()) goto L6;
        return r9;
    L6:
        return d.x.f38692a;
    }
}
