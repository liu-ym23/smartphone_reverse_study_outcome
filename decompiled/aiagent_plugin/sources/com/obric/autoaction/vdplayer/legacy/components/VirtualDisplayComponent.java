package com.obric.autoaction.vdplayer.legacy.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ab;
import androidx.lifecycle.p;
import com.obric.autoaction.a.g;
import com.obric.autoaction.vdplayer.legacy.d.r;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.vdplayer.a.h;
import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: compiled from: VirtualDisplayComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VirtualDisplayComponent implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f25776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IVirtualDisplayApi f25778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u f25779d;

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    @f(b = "VirtualDisplayComponent.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$onViewCreated$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VirtualDisplayComponent f25782c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
        @f(b = "VirtualDisplayComponent.kt", c = {83}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$onViewCreated$1$1")
        static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25783a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ VirtualDisplayComponent f25784b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$a$1$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class C0638a implements kotlinx.coroutines.b.h<Boolean> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f25786a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$a$1$a$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class C06391<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f25787a;

                    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$a$1$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @f(b = "VirtualDisplayComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent$onViewCreated$1$1$invokeSuspend$$inlined$map$1$2")
                    public static final class C06401 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f25788a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f25789b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ C06391 f25790c;

                        public C06401(C06391 r3, d r4) {
                            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                            this.f25790c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f25788a = r3;
                            this.f25789b |= Integer.MIN_VALUE;
                            return this.f25790c.emit(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public C06391(i r3) {
                        this.f25787a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d r7) {
                        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C06401.class) == false) goto L7;
                        C06401 r0 = (C06401) ZeusTransformUtils.preCheckCast(r8, C06401.class, "com.obric.aiagent.plugin");
                        if ((r0.f25789b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f25789b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f25788a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f25789b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r5 = this.f25787a;
                        d r10 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
                        Boolean r11 = d.c.b.a.b.a(((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).g());
                        r0.f25789b = 1;
                        if (r5.emit(r11, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C06401(this, r8);
                        goto L8
                    }
                }

                public C0638a(kotlinx.coroutines.b.h r3) {
                    this.f25786a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i<? super Boolean> r3, d r4) {
                    i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    d<? super x> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                    Object r2 = this.f25786a.collect((i) ZeusTransformUtils.preCheckCast(new C06391(r5), i.class, "com.obric.aiagent.plugin"), r6);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass1(VirtualDisplayComponent r3, d<? super AnonymousClass1> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f25784b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r2, d<?> r3) {
                d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25784b, r4), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25783a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L18:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                u r7 = VirtualDisplayComponent.a(this.f25784b);
                if (r7 == null) goto L18;
                ak<s> r8 = r7.b();
                if (r8 == null) goto L18;
                kotlinx.coroutines.b.h r9 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0638a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
                if (r9 == null) goto L18;
                final VirtualDisplayComponent r4 = this.f25784b;
                i r2 = (i) ZeusTransformUtils.preCheckCast(new C06371(r4), i.class, "com.obric.aiagent.plugin");
                d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
                this.f25783a = 1;
                if (r9.collect(r2, r3) != r0) goto L18;
                return r0;
            }
        }

        a(com.obric.autoaction.a.c r3, VirtualDisplayComponent r4, d<? super a> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f25781b = r3;
            this.f25782c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f25781b, this.f25782c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25780a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            p r8 = this.f25781b.b();
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2058e;
            m r3 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25782c, null), m.class, "com.obric.aiagent.plugin");
            d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25780a = 1;
            if (ab.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    public static final class b implements IVirtualDisplayApi.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualDisplayComponent f25791a;

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a(MotionEvent r1) {
            d.h.b.o.e(r1, "e");
        }

        b(VirtualDisplayComponent r1) {
            this.f25791a = r1;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a() {
            Loog.INSTANCE.d(VirtualDisplayComponent.b(this.f25791a), "onSurfaceViewTouched");
            u r3 = VirtualDisplayComponent.a(this.f25791a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.j.f25954a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void b() {
            u r3 = VirtualDisplayComponent.a(this.f25791a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.j.f25954a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void c() {
            u r3 = VirtualDisplayComponent.a(this.f25791a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.j.f25954a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void d() {
            u r3 = VirtualDisplayComponent.a(this.f25791a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.j.f25954a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void e() {
            u r3 = VirtualDisplayComponent.a(this.f25791a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.j.f25954a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    public static /* synthetic */ x lambda$gYYcE2wLWkhxpAjW03uCCaF5wbY(VirtualDisplayComponent r0, View r1) {
        return a(r0, r1);
    }

    public VirtualDisplayComponent() {
        this.f25777b = "VirtualDisplayComponent";
    }

    public static final /* synthetic */ u a(VirtualDisplayComponent r0) {
        return r0.f25779d;
    }

    public static final /* synthetic */ void a(VirtualDisplayComponent r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ String b(VirtualDisplayComponent r0) {
        return r0.f25777b;
    }

    private final String a() {
        h r7 = this.f25776a;
        if (r7 == null) goto L17;
        SurfaceView r8 = r7.f31619a;
        if (r8 == null) goto L19;
        SurfaceHolder r0 = r8.getHolder();
        Surface r1 = r0.getSurface();
        int r2 = System.identityHashCode(r0);
        if (r1 == null) goto L10;
        String r4 = Integer.toString(System.identityHashCode(r1), d.o.a.a(16));
        d.h.b.o.c(r4, "toString(...)");
    L11:
        StringBuilder r5 = new StringBuilder().append("surfaceView@");
        String r9 = Integer.toString(System.identityHashCode(r8), d.o.a.a(16));
        d.h.b.o.c(r9, "toString(...)");
        StringBuilder r10 = r5.append(r9).append(", holder@");
        String r3 = Integer.toString(r2, d.o.a.a(16));
        d.h.b.o.c(r3, "toString(...)");
        StringBuilder r11 = r10.append(r3).append(", surface@").append(r4).append(", surfaceValid=");
        if (r1 == null) goto L14;
        Boolean r6 = Boolean.valueOf(r1.isValid());
    L16:
        return r11.append(r6).toString();
    L14:
        r6 = null;
        goto L16
    L10:
        r4 = "null";
        goto L11
    L19:
        return "surfaceView=null";
    L17:
        return "surfaceView=null";
    }

    private final void a(String r7) {
        h r0 = this.f25776a;
        if (r0 == null) goto L12;
        SurfaceView r1 = r0.f31619a;
        if (r1 == null) goto L12;
        Loog.INSTANCE.i(this.f25777b, r7 + ": before unbind, " + a());
        IVirtualDisplayApi r2 = this.f25778c;
        if (r2 == null) goto L10;
        r2.unbind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"));
    L10:
        Loog.INSTANCE.i(this.f25777b, r7 + ": after unbind, " + a());
        return;
    L12:
        VirtualDisplayComponent r6 = (VirtualDisplayComponent) ZeusTransformUtils.preCheckCast(this, VirtualDisplayComponent.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(r6.f25777b, r7 + ": skip unbind, " + r6.a());
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        d.h.b.o.e(r3, "componentHost");
        IVirtualDisplayApi r4 = (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtualDisplayApi.class), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
        this.f25778c = r4;
        if (r4 != null) goto L6;
        Loog.INSTANCE.e(this.f25777b, "Failed to get IVirtualDisplayApi service");
        return;
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r4, com.obric.autoaction.a.c r5) {
        d.h.b.o.e(r4, "container");
        d.h.b.o.e(r5, "componentHost");
        h r6 = h.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r6, "inflate(...)");
        this.f25776a = r6;
        this.f25779d = (u) ZeusTransformUtils.preCheckCast(r5.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        SurfaceView r3 = r6.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.a.h
    public void a(View r8, com.obric.autoaction.a.c r9) {
        d.h.b.o.e(r8, "boundView");
        d.h.b.o.e(r9, "componentHost");
        g.a.a(this, r8, r9);
        kotlinx.coroutines.i.a(r9.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r9, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        h r10 = this.f25776a;
        if (r10 == null) goto L8;
        SurfaceView r11 = r10.f31619a;
        if (r11 == null) goto L9;
        com.obric.autoaction.view.a.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$VirtualDisplayComponent$gYYcE2wLWkhxpAjW03uCCaF5wbY(this), 1, null);
        return;
    L9:
        return;
    }

    private static final x a(VirtualDisplayComponent r2, View r3) {
        d.h.b.o.e(r3, "it");
        u r4 = r2.f25779d;
        if (r4 == null) goto L6;
        r4.a((com.obric.autoaction.vdplayer.legacy.b.b) ZeusTransformUtils.preCheckCast(r.p.f25960a, com.obric.autoaction.vdplayer.legacy.b.b.class, "com.obric.aiagent.plugin"));
    L6:
        return x.f38692a;
    }

    private final void a(boolean r5) {
        h r0 = this.f25776a;
        if (r0 == null) goto L16;
        SurfaceView r1 = r0.f31619a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5 == false) goto L12;
        IVirtualDisplayApi r6 = this.f25778c;
        if (r6 == null) goto L17;
        r6.enableCallUser(true, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"), (IVirtualDisplayApi.b) ZeusTransformUtils.preCheckCast(new b(this), IVirtualDisplayApi.b.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        return;
    L12:
        IVirtualDisplayApi r4 = this.f25778c;
        if (r4 == null) goto L19;
        r4.enableCallUser(false, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"), null);
        return;
    L19:
        return;
    }

    @Override // androidx.lifecycle.d
    public void b(p r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "owner");
        super.b(r6);
        Loog.INSTANCE.i(this.f25777b, "onStart: before bind, " + a());
        h r7 = this.f25776a;
        if (r7 == null) goto L14;
        SurfaceView r8 = r7.f31619a;
        if (r8 == null) goto L15;
        IVirtualDisplayApi r0 = this.f25778c;
        if (r0 == null) goto L9;
        r0.bind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r8), DisplayHost.class, "com.obric.aiagent.plugin"));
    L9:
        Loog.INSTANCE.i(this.f25777b, "onStart: after bind, " + a());
        IVirtualDisplayApi r9 = this.f25778c;
        if (r9 == null) goto L12;
        r9.mute(false);
    L12:
        Loog.INSTANCE.i(this.f25777b, "onStart: after mute(false), " + a());
        return;
    L15:
        return;
    }

    @Override // androidx.lifecycle.d
    public void d(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "owner");
        super.d(r5);
        Loog.INSTANCE.i(this.f25777b, "onStop: before mute(true), " + a());
        IVirtualDisplayApi r6 = this.f25778c;
        if (r6 == null) goto L5;
        r6.mute(true);
    L5:
        Loog.INSTANCE.i(this.f25777b, "onStop: after mute(true), " + a());
        a("onStop");
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.e(r4);
        a("onDestroy");
        this.f25776a = null;
    }
}
