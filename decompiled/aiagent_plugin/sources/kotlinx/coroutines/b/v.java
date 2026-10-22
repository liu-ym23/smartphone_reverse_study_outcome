package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Zip.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class v {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<R> implements h<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h[] f39118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.r f39119b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.v$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Zip.kt */
        @d.c.b.a.f(b = "Zip.kt", c = {329, 258}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2")
        public static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.q<i<? super R>, Object[], d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f39120a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f39121b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d.h.a.r f39122c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f39123d;

            public AnonymousClass1(d.c.d r3, d.h.a.r r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39122c = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.r.class, "com.obric.aiagent.plugin");
                super(3, r5);
            }

            public final Object a(i<? super R> r3, Object[] r4, d.c.d<? super d.x> r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"), this.f39122c);
                r0.f39123d = r6;
                r0.f39121b = r4;
                return r0.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(Object r3, Object[] r4, d.c.d<? super d.x> r5) {
                return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f39120a;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                d.o.a(r9);
            L17:
                return d.x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                i r2 = (i) ZeusTransformUtils.preCheckCast(this.f39123d, i.class, "com.obric.aiagent.plugin");
                d.o.a(r9);
            L13:
                d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39123d = null;
                this.f39120a = 2;
                if (r2.emit(r9, r3) != r0) goto L17;
                return r0;
            L10:
                d.o.a(r9);
                r2 = (i) ZeusTransformUtils.preCheckCast(this.f39123d, i.class, "com.obric.aiagent.plugin");
                Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(this.f39121b, Object[].class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                d.h.a.r r6 = this.f39122c;
                Object r7 = r10[0];
                Object r8 = r10[1];
                Object r11 = r10[2];
                this.f39123d = r2;
                this.f39120a = 1;
                d.h.b.m.a(6);
                r9 = r6.a(r7, r8, r11, this);
                d.h.b.m.a(7);
                if (r9 != r0) goto L13;
                return r0;
            }
        }

        public a(h[] r3, d.h.a.r r4) {
            d.h.a.r r5 = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.r.class, "com.obric.aiagent.plugin");
            this.f39118a = r3;
            this.f39119b = r5;
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i r6, d.c.d r7) {
            i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            Object r5 = kotlinx.coroutines.b.a.l.a(r8, this.f39118a, v.a(), (d.h.a.q) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null, this.f39119b), d.h.a.q.class, "com.obric.aiagent.plugin"), r9);
            if (r5 != d.c.a.b.a()) goto L6;
            return r5;
        L6:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b<R> implements h<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h[] f39124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.t f39125b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.v$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: Zip.kt */
        @d.c.b.a.f(b = "Zip.kt", c = {329, 258}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2")
        public static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.q<i<? super R>, Object[], d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f39126a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f39127b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d.h.a.t f39128c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f39129d;

            public AnonymousClass1(d.c.d r3, d.h.a.t r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39128c = (d.h.a.t) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.t.class, "com.obric.aiagent.plugin");
                super(3, r5);
            }

            public final Object a(i<? super R> r3, Object[] r4, d.c.d<? super d.x> r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1((d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"), this.f39128c);
                r0.f39129d = r6;
                r0.f39127b = r4;
                return r0.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(Object r3, Object[] r4, d.c.d<? super d.x> r5) {
                return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r14) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f39126a;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                d.o.a(r14);
            L17:
                return d.x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                i r2 = (i) ZeusTransformUtils.preCheckCast(this.f39129d, i.class, "com.obric.aiagent.plugin");
                d.o.a(r14);
            L13:
                d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39129d = null;
                this.f39126a = 2;
                if (r2.emit(r14, r3) != r0) goto L17;
                return r0;
            L10:
                d.o.a(r14);
                r2 = (i) ZeusTransformUtils.preCheckCast(this.f39129d, i.class, "com.obric.aiagent.plugin");
                Object[] r15 = (Object[]) ZeusTransformUtils.preCheckCast(this.f39127b, Object[].class, "com.obric.aiagent.plugin");
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                d.h.a.t r6 = this.f39128c;
                Object r7 = r15[0];
                Object r8 = r15[1];
                Object r9 = r15[2];
                Object r10 = r15[3];
                Object r11 = r15[4];
                this.f39129d = r2;
                this.f39126a = 1;
                d.h.b.m.a(6);
                r14 = r6.a(r7, r8, r9, r10, r11, this);
                d.h.b.m.a(7);
                if (r14 != r0) goto L13;
                return r0;
            }
        }

        public b(h[] r3, d.h.a.t r4) {
            d.h.a.t r5 = (d.h.a.t) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.t.class, "com.obric.aiagent.plugin");
            this.f39124a = r3;
            this.f39125b = r5;
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i r6, d.c.d r7) {
            i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            Object r5 = kotlinx.coroutines.b.a.l.a(r8, this.f39124a, v.a(), (d.h.a.q) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null, this.f39125b), d.h.a.q.class, "com.obric.aiagent.plugin"), r9);
            if (r5 != d.c.a.b.a()) goto L6;
            return r5;
        L6:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class c<R> implements h<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f39130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f39131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.q f39132c;

        public c(h r3, h r4, d.h.a.q r5) {
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
            d.h.a.q r8 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.q.class, "com.obric.aiagent.plugin");
            this.f39130a = r6;
            this.f39131b = r7;
            this.f39132c = r8;
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i<? super R> r6, d.c.d<? super d.x> r7) {
            i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r6, i.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            Object r5 = kotlinx.coroutines.b.a.l.a(r8, new h[]{this.f39130a, this.f39131b}, v.a(), (d.h.a.q) ZeusTransformUtils.preCheckCast(new d(this.f39132c, null), d.h.a.q.class, "com.obric.aiagent.plugin"), r9);
            if (r5 != d.c.a.b.a()) goto L6;
            return r5;
        L6:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: Zip.kt */
    @d.c.b.a.f(b = "Zip.kt", c = {29, 29}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1")
    static final class d<R> extends d.c.b.a.l implements d.h.a.q<i<? super R>, Object[], d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.q<T1, T2, d.c.d<? super R>, Object> f39135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f39136d;

        d(d.h.a.q<? super T1, ? super T2, ? super d.c.d<? super R>, ? extends Object> r3, d.c.d<? super d> r4) {
            d.h.a.q<T1, T2, d.c.d<? super R>, Object> r5 = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39135c = r5;
            super(3, r6);
        }

        public final Object a(i<? super R> r3, Object[] r4, d.c.d<? super d.x> r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f39135c, r7);
            r0.f39136d = r6;
            r0.f39134b = r4;
            return r0.invokeSuspend(d.x.f38692a);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(Object r3, Object[] r4, d.c.d<? super d.x> r5) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.b.v$d<R> for r7v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            java.lang.Object r0 = d.c.a.b.a();
            int r1 = r7.f39133a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            d.o.a(r8);
        L16:
            d.x r7 = d.x.f38692a;
            return r7;
        L7:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r7;
        L9:
            java.lang.Object r1 = r7.f39136d;
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) r1;
            d.o.a(r8);
        L13:
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) r3;
            r7.f39136d = null;
            r7.f39133a = 2;
            java.lang.Object r7 = r1.emit(r8, r3);
            if (r7 != r0) goto L16;
            return r0;
        L10:
            d.o.a(r8);
            java.lang.Object r8 = r7.f39136d;
            java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            r1 = (kotlinx.coroutines.b.i) r8;
            java.lang.Object r8 = r7.f39134b;
            java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, java.lang.Object[].class, "com.obric.aiagent.plugin");
            java.lang.Object[] r8 = (java.lang.Object[]) r8;
            d.h.a.q<T1, T2, d.c.d<? super R>, java.lang.Object> r5 = r7.f39135c;
            java.lang.Object r6 = r8[0];
            java.lang.Object r8 = r8[1];
            r7.f39136d = r1;
            r7.f39133a = 1;
            T1 r6 = (T1) r6;
            T2 r8 = (T2) r8;
            java.lang.Object r7 = (d.c.d<? super R>) r7;
            r8 = r5.invoke(r6, r8, r7);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: Zip.kt */
    static final class e extends d.h.b.p implements d.h.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f39137a = null;

        static {
            f39137a = new e();
        }

        e() {
            super(0);
        }

        public final Void a() {
            return null;
        }

        @Override // d.h.a.a
        public /* synthetic */ Object invoke() {
            return a();
        }
    }

    public static final /* synthetic */ d.h.a.a a() {
        return b();
    }

    public static final <T1, T2, R> h<R> b(h<? extends T1> r2, h<? extends T2> r3, d.h.a.q<? super T1, ? super T2, ? super d.c.d<? super R>, ? extends Object> r4) {
        return j.a((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.q.class, "com.obric.aiagent.plugin"));
    }

    private static final <T> d.h.a.a<T[]> b() {
        return (d.h.a.a) ZeusTransformUtils.preCheckCast(e.f39137a, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public static final <T1, T2, R> h<R> a(h<? extends T1> r2, h<? extends T2> r3, d.h.a.q<? super T1, ? super T2, ? super d.c.d<? super R>, ? extends Object> r4) {
        return (h) ZeusTransformUtils.preCheckCast(new c((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin"), (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.q.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T1, T2, T3, R> h<R> a(h<? extends T1> r3, h<? extends T2> r4, h<? extends T3> r5, d.h.a.r<? super T1, ? super T2, ? super T3, ? super d.c.d<? super R>, ? extends Object> r6) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        return (h) ZeusTransformUtils.preCheckCast(new a(new h[]{r7, r8, r9}, (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.r.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T1, T2, T3, T4, T5, R> h<R> a(h<? extends T1> r3, h<? extends T2> r4, h<? extends T3> r5, h<? extends T4> r6, h<? extends T5> r7, d.h.a.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super d.c.d<? super R>, ? extends Object> r8) {
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        h r11 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.aiagent.plugin");
        h r12 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.aiagent.plugin");
        h r13 = (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.aiagent.plugin");
        return (h) ZeusTransformUtils.preCheckCast(new b(new h[]{r9, r10, r11, r12, r13}, (d.h.a.t) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.t.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }
}
