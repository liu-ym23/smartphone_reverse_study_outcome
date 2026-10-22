package com.obric.autoaction.vdplayer.legacy.components;

import android.view.View;
import androidx.lifecycle.ab;
import androidx.lifecycle.p;
import com.obric.autoaction.a.h;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseVDPlayerComponent<S> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<s, S> f25685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f25686b;

    /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
    @f(b = "BaseVDPlayerStateComponent.kt", c = {44}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$observeState$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseVDPlayerComponent<S> f25689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f25690d;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
        @f(b = "BaseVDPlayerStateComponent.kt", c = {50}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$observeState$1$1")
        static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25691a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BaseVDPlayerComponent<S> f25692b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ u f25693c;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BaseVDPlayerStateComponent.kt */
            @f(b = "BaseVDPlayerStateComponent.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$observeState$1$1$2")
            static final class C06331 extends l implements m<d.m<? extends S, ? extends S>, d<? super x>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f25694a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                /* synthetic */ Object f25695b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ BaseVDPlayerComponent<S> f25696c;

                C06331(BaseVDPlayerComponent<S> r3, d<? super C06331> r4) {
                    d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                    this.f25696c = r3;
                    super(2, r5);
                }

                public final Object a(d.m<? extends S, ? extends S> r3, d<? super x> r4) {
                    return ((C06331) ZeusTransformUtils.preCheckCast(create(r3, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C06331.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d<x> create(Object r3, d<?> r4) {
                    d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                    C06331 r0 = new C06331(this.f25696c, r5);
                    r0.f25695b = r3;
                    return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(Object r3, d<? super x> r4) {
                    return a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    d.c.a.b.a();
                    if (this.f25694a != 0) goto L7;
                    o.a(r3);
                    d.m r4 = (d.m) ZeusTransformUtils.preCheckCast(this.f25695b, d.m.class, "com.obric.aiagent.plugin");
                    Object r0 = r4.c();
                    Object r5 = r4.d();
                    this.f25696c.a((S) r0, (S) r5);
                    return x.f38692a;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$a$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class C0634a implements kotlinx.coroutines.b.h<S> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f25697a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ BaseVDPlayerComponent f25698b;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$a$1$a$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class C06351<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f25699a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ BaseVDPlayerComponent f25700b;

                    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$a$1$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @f(b = "BaseVDPlayerStateComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent$observeState$1$1$invokeSuspend$$inlined$map$1$2")
                    public static final class C06361 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f25701a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f25702b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ C06351 f25703c;

                        public C06361(C06351 r3, d r4) {
                            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                            this.f25703c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f25701a = r3;
                            this.f25702b |= Integer.MIN_VALUE;
                            return this.f25703c.emit(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public C06351(i r3, BaseVDPlayerComponent r4) {
                        this.f25699a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                        this.f25700b = r4;
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d r7) {
                        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C06361.class) == false) goto L7;
                        C06361 r0 = (C06361) ZeusTransformUtils.preCheckCast(r8, C06361.class, "com.obric.aiagent.plugin");
                        if ((r0.f25702b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f25702b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f25701a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f25702b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r10 = this.f25699a;
                        d r4 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
                        S r5 = this.f25700b.a().invoke((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin"));
                        r0.f25702b = 1;
                        if (r10.emit(r5, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C06361(this, r8);
                        goto L8
                    }
                }

                public C0634a(kotlinx.coroutines.b.h r3, BaseVDPlayerComponent r4) {
                    this.f25697a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                    this.f25698b = r4;
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i r4, d r5) {
                    i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
                    d<? super x> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                    Object r3 = this.f25697a.collect((i) ZeusTransformUtils.preCheckCast(new C06351(r6, this.f25698b), i.class, "com.obric.aiagent.plugin"), r7);
                    if (r3 != d.c.a.b.a()) goto L6;
                    return r3;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass1(BaseVDPlayerComponent<S> r3, u r4, d<? super AnonymousClass1> r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                this.f25692b = r3;
                this.f25693c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r3, d<?> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25692b, this.f25693c, r5), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25691a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r7);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r7);
                kotlinx.coroutines.b.h r8 = com.obric.autoaction.vdplayer.legacy.components.a.a(this.f25692b.a(j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0634a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(this.f25693c.b(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), this.f25692b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"))));
                m r2 = (m) ZeusTransformUtils.preCheckCast(new C06331(this.f25692b, null), m.class, "com.obric.aiagent.plugin");
                d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f25691a = 1;
                if (j.a(r8, r2, r3) != r0) goto L12;
                return r0;
            }
        }

        a(com.obric.autoaction.a.c r3, BaseVDPlayerComponent<S> r4, u r5, d<? super a> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f25688b = r3;
            this.f25689c = r4;
            this.f25690d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f25688b, this.f25689c, this.f25690d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25687a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            p r9 = this.f25688b.b();
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2057d;
            m r3 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25689c, this.f25690d, null), m.class, "com.obric.aiagent.plugin");
            d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25687a = 1;
            if (ab.a(r9, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    public kotlinx.coroutines.b.h<S> a(kotlinx.coroutines.b.h<? extends S> r2) {
        kotlinx.coroutines.b.h<S> r1 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "<this>");
        return r1;
    }

    public void a(S r1) {
    }

    public BaseVDPlayerComponent(d.h.a.b<? super s, ? extends S> r3) {
        d.h.a.b<s, S> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "selector");
        this.f25685a = r4;
    }

    public final d.h.a.b<s, S> a() {
        return this.f25685a;
    }

    public final u b() {
        return this.f25686b;
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        d.h.b.o.e(r3, "componentHost");
        h.a.a(this, r3);
        this.f25686b = (u) ZeusTransformUtils.preCheckCast(r3.c().a(u.class), u.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.a.h
    public void a(View r2, com.obric.autoaction.a.c r3) {
        d.h.b.o.e(r2, "boundView");
        d.h.b.o.e(r3, "componentHost");
        h.a.a(this, r2, r3);
        b(r3);
    }

    public final void b(com.obric.autoaction.a.c r8) {
        d.h.b.o.e(r8, "componentHost");
        u r0 = this.f25686b;
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(r8.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r8, this, r0, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(r r3) {
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        u r2 = this.f25686b;
        if (r2 == null) goto L6;
        r2.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final S c() {
        u r0 = this.f25686b;
        if (r0 == null) goto L9;
        ak<s> r1 = r0.b();
        if (r1 == null) goto L9;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.c(), s.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        return this.f25685a.invoke(r2);
    L9:
        return null;
    }

    public void a(S r1, S r2) {
        a(r2);
    }
}
