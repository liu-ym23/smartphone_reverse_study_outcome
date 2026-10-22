package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Transform.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f39104a;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.u$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f39105a;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.u$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @d.c.b.a.f(b = "Transform.kt", c = {219}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2")
            public static final class C10541 extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f39106a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f39107b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f39108c;

                public C10541(AnonymousClass1 r3, d.c.d r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f39108c = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f39106a = r3;
                    this.f39107b |= Integer.MIN_VALUE;
                    return this.f39108c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            public AnonymousClass1(i r3) {
                this.f39105a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r6, d.c.d<? super d.x> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r8, C10541.class) == false) goto L7;
                C10541 r0 = (C10541) ZeusTransformUtils.preCheckCast(r8, C10541.class, "com.obric.aiagent.plugin");
                if ((r0.f39107b & Integer.MIN_VALUE) == 0) goto L7;
                r0.f39107b -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.f39106a;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f39107b;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                d.o.a(r9);
            L20:
                return d.x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                d.o.a(r9);
                i r5 = this.f39105a;
                d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                if (r6 == null) goto L20;
                r0.f39107b = 1;
                if (r5.emit(r6, r0) != r2) goto L20;
                return r2;
            L7:
                r0 = new C10541(this, r8);
                goto L8
            }
        }

        public a(h r3) {
            this.f39104a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i r3, d.c.d r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            Object r2 = this.f39104a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f39109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.m f39110b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.u$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f39111a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.m f39112b;

            /* JADX INFO: renamed from: kotlinx.coroutines.b.u$b$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @d.c.b.a.f(b = "Transform.kt", c = {219, 220}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2")
            public static final class C10551 extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f39113a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f39114b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f39115c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Object f39116d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                Object f39117e;

                public C10551(AnonymousClass1 r3, d.c.d r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f39115c = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f39113a = r3;
                    this.f39114b |= Integer.MIN_VALUE;
                    return this.f39115c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            public AnonymousClass1(i r3, d.h.a.m r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
                this.f39111a = r5;
                this.f39112b = r6;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r7, d.c.d<? super d.x> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r9, C10551.class) == false) goto L7;
                C10551 r0 = (C10551) ZeusTransformUtils.preCheckCast(r9, C10551.class, "com.obric.aiagent.plugin");
                if ((r0.f39114b & Integer.MIN_VALUE) == 0) goto L7;
                r0.f39114b -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.f39113a;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f39114b;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                d.o.a(r10);
            L24:
                return d.x.f38692a;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                i r6 = (i) ZeusTransformUtils.preCheckCast(r0.f39117e, i.class, "com.obric.aiagent.plugin");
                r7 = (T) r0.f39116d;
                d.o.a(r10);
            L20:
                r0.f39116d = null;
                r0.f39117e = null;
                r0.f39114b = 2;
                if (r6.emit(r7, r0) != r2) goto L24;
                return r2;
            L16:
                d.o.a(r10);
                i r11 = this.f39111a;
                d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                d.h.a.m r12 = this.f39112b;
                r0.f39116d = r7;
                r0.f39117e = r11;
                r0.f39114b = 1;
                d.h.b.m.a(6);
                Object r13 = r12.invoke(r7, r0);
                d.h.b.m.a(7);
                if (r13 != r2) goto L19;
                return r2;
            L19:
                r6 = r11;
            L7:
                r0 = new C10551(this, r9);
                goto L8
            }
        }

        public b(h r3, d.h.a.m r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
            this.f39109a = r5;
            this.f39110b = r6;
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i r4, d.c.d r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            Object r3 = this.f39109a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f39110b), i.class, "com.obric.aiagent.plugin"), r7);
            if (r3 != d.c.a.b.a()) goto L6;
            return r3;
        L6:
            return d.x.f38692a;
        }
    }

    public static final <T> h<T> a(h<? extends T> r2) {
        return (h) ZeusTransformUtils.preCheckCast(new a((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> a(h<? extends T> r2, d.h.a.m<? super T, ? super d.c.d<? super d.x>, ? extends Object> r3) {
        return (h) ZeusTransformUtils.preCheckCast(new b((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin");
    }
}
