package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes4.dex */
final class aj implements ah {

    /* JADX INFO: compiled from: SharingStarted.kt */
    @d.c.b.a.f(b = "SharingStarted.kt", c = {151}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.StartedLazily$command$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<i<? super af>, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ak<Integer> f38986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f38987c;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.aj$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: SharingStarted.kt */
        static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.a f38988a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i<af> f38989b;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.aj$a$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SharingStarted.kt */
            @d.c.b.a.f(b = "SharingStarted.kt", c = {154}, d = "emit", e = "kotlinx.coroutines.flow.StartedLazily$command$1$1")
            static final class C1051a extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f38990a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1<T> f38991b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                int f38992c;

                /* JADX WARN: Multi-variable type inference failed */
                C1051a(AnonymousClass1<? super T> r3, d.c.d<? super C1051a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f38991b = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f38990a = r3;
                    this.f38992c |= Integer.MIN_VALUE;
                    return this.f38991b.a(0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            AnonymousClass1(d.h.b.z.a r3, i<? super af> r4) {
                i<af> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
                this.f38988a = r3;
                this.f38989b = r5;
            }

            public final Object a(int r5, d.c.d<? super d.x> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r7, C1051a.class) == false) goto L7;
                C1051a r0 = (C1051a) ZeusTransformUtils.preCheckCast(r7, C1051a.class, "com.obric.aiagent.plugin");
                if ((r0.f38992c & Integer.MIN_VALUE) == 0) goto L7;
                r0.f38992c -= Integer.MIN_VALUE;
            L8:
                Object r8 = r0.f38990a;
                Object r1 = d.c.a.b.a();
                int r2 = r0.f38992c;
                if (r2 == 0) goto L14;
                if (r2 != 1) goto L13;
                d.o.a(r8);
            L22:
                return d.x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                d.o.a(r8);
                if (r5 <= 0) goto L24;
                if (this.f38988a.f38499a == true) goto L24;
                this.f38988a.f38499a = true;
                i<af> r4 = this.f38989b;
                af r9 = af.f38972a;
                r0.f38992c = 1;
                if (r4.emit(r9, r0) != r1) goto L22;
                return r1;
            L24:
                return d.x.f38692a;
            L7:
                r0 = new C1051a(this, r7);
                goto L8
            }

            @Override // kotlinx.coroutines.b.i
            public /* synthetic */ Object emit(Object r3, d.c.d r4) {
                d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), r5);
            }
        }

        a(ak<Integer> r3, d.c.d<? super a> r4) {
            ak<Integer> r5 = (ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38986b = r5;
            super(2, r6);
        }

        public final Object a(i<? super af> r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f38986b, r5);
            r0.f38987c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super af> r3, d.c.d<? super d.x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f38985a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r7);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(this.f38987c, i.class, "com.obric.aiagent.plugin");
            d.h.b.z.a r2 = new d.h.b.z.a();
            ak<Integer> r4 = this.f38986b;
            i<? super Integer> r9 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r8), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f38985a = 1;
            if (r4.collect(r9, r3) != r0) goto L12;
            return r0;
        }
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }

    public aj() {
    }

    @Override // kotlinx.coroutines.b.ah
    public h<af> a(ak<Integer> r3) {
        return j.a((d.h.a.m) ZeusTransformUtils.preCheckCast(new a((ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.aiagent.plugin"), null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }
}
