package com.obric.autoaction.vdplayer.legacy.components;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
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
public final class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Emitters.kt */
    @f(b = "BaseVDPlayerStateComponent.kt", c = {36}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerStateComponentKt$throttleLatest$$inlined$transform$1")
    public static final class C0641a<T> extends l implements m<i<? super T>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f25793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f25794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f25795d;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.a$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i<T> f25796a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f25797b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.a$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @f(b = "BaseVDPlayerStateComponent.kt", c = {219, 220}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerStateComponentKt$throttleLatest$$inlined$transform$1$1")
            public static final class C06421 extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f25798a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f25799b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f25800c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Object f25801d;

                public C06421(AnonymousClass1 r3, d r4) {
                    d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                    this.f25800c = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f25798a = r3;
                    this.f25799b |= Integer.MIN_VALUE;
                    return this.f25800c.emit(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
                }
            }

            public AnonymousClass1(i r3, long r4) {
                i<T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                this.f25797b = r4;
                this.f25796a = r5;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r7, d<? super x> r8) {
                d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r9, C06421.class) == false) goto L7;
                C06421 r0 = (C06421) ZeusTransformUtils.preCheckCast(r9, C06421.class, "com.obric.aiagent.plugin");
                if ((r0.f25799b & Integer.MIN_VALUE) == 0) goto L7;
                r0.f25799b -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.f25798a;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f25799b;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                o.a(r10);
            L23:
                return x.f38692a;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                AnonymousClass1<T> this = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.f25801d, AnonymousClass1.class, "com.obric.aiagent.plugin");
                o.a(r10);
            L19:
                long r6 = this.f25797b;
                r0.f25801d = null;
                r0.f25799b = 2;
                if (ax.a(r6, r0) != r2) goto L23;
                return r2;
            L16:
                o.a(r10);
                i<T> r11 = this.f25796a;
                d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
                r0.f25801d = this;
                r0.f25799b = 1;
                if (r11.emit(r7, r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new C06421(this, r9);
                goto L8
            }
        }

        public C0641a(h r3, d r4, long r5) {
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f25793b = r6;
            this.f25794c = r5;
            super(2, r7);
        }

        public final Object a(i<? super T> r3, d<? super x> r4) {
            return ((C0641a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0641a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r6, d<?> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            C0641a r0 = new C0641a(this.f25793b, r8, this.f25794c);
            r0.f25795d = r6;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25792a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            i r9 = (i) ZeusTransformUtils.preCheckCast(this.f25795d, i.class, "com.obric.aiagent.plugin");
            h r2 = this.f25793b;
            i<? super T> r10 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this.f25794c), i.class, "com.obric.aiagent.plugin");
            d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25792a = 1;
            if (r2.collect(r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
    @f(b = "BaseVDPlayerStateComponent.kt", c = {84}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerStateComponentKt$withPrevious$1")
    static final class b<T> extends l implements m<i<? super d.m<? extends T, ? extends T>>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h<T> f25803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f25804c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.a$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
        static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i<d.m<? extends T, ? extends T>> f25805a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z.f<T> f25806b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.a$b$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
            @f(b = "BaseVDPlayerStateComponent.kt", c = {85}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerStateComponentKt$withPrevious$1$1")
            static final class C0643a extends d.c.b.a.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Object f25807a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                Object f25808b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f25809c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1<T> f25810d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f25811e;

                /* JADX WARN: Multi-variable type inference failed */
                C0643a(AnonymousClass1<? super T> r3, d<? super C0643a> r4) {
                    d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                    this.f25810d = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f25809c = r3;
                    this.f25811e |= Integer.MIN_VALUE;
                    return this.f25810d.emit(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
                }
            }

            AnonymousClass1(i<? super d.m<? extends T, ? extends T>> r3, z.f<T> r4) {
                this.f25805a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                this.f25806b = r4;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(T r6, d<? super x> r7) {
                d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r8, C0643a.class) == false) goto L7;
                C0643a r0 = (C0643a) ZeusTransformUtils.preCheckCast(r8, C0643a.class, "com.obric.aiagent.plugin");
                if ((r0.f25811e & Integer.MIN_VALUE) == 0) goto L7;
                r0.f25811e -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.f25809c;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f25811e;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                r6 = (T) r0.f25808b;
                AnonymousClass1<T> this = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0.f25807a, AnonymousClass1.class, "com.obric.aiagent.plugin");
                o.a(r9);
            L17:
                this.f25806b.f38504a = r6;
                return x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                o.a(r9);
                i<d.m<? extends T, ? extends T>> r10 = this.f25805a;
                d.m<? extends T, ? extends T> r1 = new d.m(this.f25806b.f38504a, r6);
                r0.f25807a = this;
                r0.f25808b = r6;
                r0.f25811e = 1;
                if (r10.emit(r1, r0) != r2) goto L17;
                return r2;
            L7:
                r0 = new C0643a(this, r8);
                goto L8
            }
        }

        b(h<? extends T> r3, d<? super b> r4) {
            h<T> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f25803b = r5;
            super(2, r6);
        }

        public final Object a(i<? super d.m<? extends T, ? extends T>> r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f25803b, r5);
            r0.f25804c = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25802a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(this.f25804c, i.class, "com.obric.aiagent.plugin");
            z.f r2 = new z.f();
            h<T> r4 = this.f25803b;
            i<? super T> r9 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r2), i.class, "com.obric.aiagent.plugin");
            d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25802a = 1;
            if (r4.collect(r9, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final <T> h<d.m<T, T>> a(h<? extends T> r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return j.a((m) ZeusTransformUtils.preCheckCast(new b(r4, null), m.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> h<T> a(h<? extends T> r3, long r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        return j.a((m) ZeusTransformUtils.preCheckCast(new C0641a(j.a(r5), null, r4), m.class, "com.obric.aiagent.plugin"));
    }
}
