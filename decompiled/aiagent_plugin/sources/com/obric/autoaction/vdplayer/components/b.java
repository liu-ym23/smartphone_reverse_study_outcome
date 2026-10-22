package com.obric.autoaction.vdplayer.components;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Emitters.kt */
    @f(b = "BaseVDPlayerStateComponent.kt", c = {36}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.BaseVDPlayerStateComponentKt$throttleLatest$$inlined$transform$1")
    public static final class a<T> extends l implements m<i<? super T>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f25357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f25358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f25359d;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.b$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i<T> f25360a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f25361b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.b$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @f(b = "BaseVDPlayerStateComponent.kt", c = {219, 220}, d = "emit", e = "com.obric.autoaction.vdplayer.components.BaseVDPlayerStateComponentKt$throttleLatest$$inlined$transform$1$1")
            public static final class C06191 extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f25362a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f25363b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f25364c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Object f25365d;

                public C06191(AnonymousClass1 r3, d.c.d r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f25364c = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f25362a = r3;
                    this.f25363b |= Integer.MIN_VALUE;
                    return this.f25364c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            public AnonymousClass1(i r3, long r4) {
                i<T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                this.f25361b = r4;
                this.f25360a = r5;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r7, d.c.d<? super x> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r9, C06191.class) == false) goto L7;
                C06191 r0 = (C06191) ZeusTransformUtils.preCheckCast(r9, C06191.class, "com.obric.aiagent.plugin");
                if ((r0.f25363b & Integer.MIN_VALUE) == 0) goto L7;
                r0.f25363b -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.f25362a;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f25363b;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                o.a(r10);
            L23:
                return x.f38692a;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                AnonymousClass1<T> this = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.f25365d, AnonymousClass1.class, "com.obric.aiagent.plugin");
                o.a(r10);
            L19:
                long r6 = this.f25361b;
                r0.f25365d = null;
                r0.f25363b = 2;
                if (ax.a(r6, r0) != r2) goto L23;
                return r2;
            L16:
                o.a(r10);
                i<T> r11 = this.f25360a;
                d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                r0.f25365d = this;
                r0.f25363b = 1;
                if (r11.emit(r7, r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new C06191(this, r9);
                goto L8
            }
        }

        public a(h r3, d.c.d r4, long r5) {
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25357b = r6;
            this.f25358c = r5;
            super(2, r7);
        }

        public final Object a(i<? super T> r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r6, d.c.d<?> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f25357b, r8, this.f25358c);
            r0.f25359d = r6;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25356a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            i r9 = (i) ZeusTransformUtils.preCheckCast(this.f25359d, i.class, "com.obric.aiagent.plugin");
            h r2 = this.f25357b;
            i<? super T> r10 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this.f25358c), i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25356a = 1;
            if (r2.collect(r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
    @f(b = "BaseVDPlayerStateComponent.kt", c = {84}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.BaseVDPlayerStateComponentKt$withPrevious$1")
    static final class C0620b<T> extends l implements m<i<? super d.m<? extends T, ? extends T>>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h<T> f25367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f25368c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.b$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
        static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i<d.m<? extends T, ? extends T>> f25369a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<T> f25370b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.b$b$1$a */
            /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
            @f(b = "BaseVDPlayerStateComponent.kt", c = {85}, d = "emit", e = "com.obric.autoaction.vdplayer.components.BaseVDPlayerStateComponentKt$withPrevious$1$1")
            static final class a extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f25371a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f25372b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f25373c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1<T> f25374d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f25375e;

                /* JADX WARN: Multi-variable type inference failed */
                a(AnonymousClass1<? super T> r3, d.c.d<? super a> r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f25374d = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f25373c = r3;
                    this.f25375e |= Integer.MIN_VALUE;
                    return this.f25374d.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            AnonymousClass1(i<? super d.m<? extends T, ? extends T>> r3, z.f<T> r4) {
                this.f25369a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                this.f25370b = r4;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r6, d.c.d<? super x> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
                a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
                if ((r0.f25375e & Integer.MIN_VALUE) == 0) goto L7;
                r0.f25375e -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.f25373c;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f25375e;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                r6 = (T) r0.f25372b;
                AnonymousClass1<T> this = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.f25371a, AnonymousClass1.class, "com.obric.aiagent.plugin");
                o.a(r9);
            L17:
                this.f25370b.f38504a = r6;
                return x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                o.a(r9);
                i<d.m<? extends T, ? extends T>> r10 = this.f25369a;
                d.m<? extends T, ? extends T> r1 = new d.m(this.f25370b.f38504a, r6);
                r0.f25371a = this;
                r0.f25372b = r6;
                r0.f25375e = 1;
                if (r10.emit(r1, r0) != r2) goto L17;
                return r2;
            L7:
                r0 = new a(this, r8);
                goto L8
            }
        }

        C0620b(h<? extends T> r3, d.c.d<? super C0620b> r4) {
            h<T> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25367b = r5;
            super(2, r6);
        }

        public final Object a(i<? super d.m<? extends T, ? extends T>> r3, d.c.d<? super x> r4) {
            return ((C0620b) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0620b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            C0620b r0 = new C0620b(this.f25367b, r5);
            r0.f25368c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25366a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(this.f25368c, i.class, "com.obric.aiagent.plugin");
            z.f r2 = new z.f();
            h<T> r4 = this.f25367b;
            i<? super T> r9 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r2), i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25366a = 1;
            if (r4.collect(r9, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final <T> h<d.m<T, T>> a(h<? extends T> r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return j.a((m) ZeusTransformUtils.preCheckCast(new C0620b(r4, null), m.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> h<T> a(h<? extends T> r3, long r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        return j.a((m) ZeusTransformUtils.preCheckCast(new a(j.a(r5), null, r4), m.class, "com.obric.aiagent.plugin"));
    }
}
