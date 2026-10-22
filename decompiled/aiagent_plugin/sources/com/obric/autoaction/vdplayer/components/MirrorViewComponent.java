package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ab;
import androidx.lifecycle.p;
import com.obric.autoaction.a.g;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autoaction.vdplayer.d.u;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCDataResult;
import com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.k;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;

/* JADX INFO: compiled from: MirrorViewComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MirrorViewComponent implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f25274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f25275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IVirtualDisplayApi f25277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u f25278e;
    private long f;

    /* JADX INFO: compiled from: MirrorViewComponent.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MirrorViewComponent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25279a;

        public b() {
            this(false, 1, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f25279a == r6.f25279a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f25279a);
        }

        public String toString() {
            return "MirrorViewTouchState(isUserOperating=" + this.f25279a + ')';
        }

        public b(boolean r1) {
            this.f25279a = r1;
        }

        public /* synthetic */ b(boolean r1, int r2, h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f25279a;
        }
    }

    /* JADX INFO: compiled from: MirrorViewComponent.kt */
    @f(b = "MirrorViewComponent.kt", c = {76}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.MirrorViewComponent$onViewCreated$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MirrorViewComponent f25282c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.MirrorViewComponent$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: MirrorViewComponent.kt */
        @f(b = "MirrorViewComponent.kt", c = {82}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.MirrorViewComponent$onViewCreated$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25283a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MirrorViewComponent f25284b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.MirrorViewComponent$c$1$a */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class a implements kotlinx.coroutines.b.h<b> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f25286a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.MirrorViewComponent$c$1$a$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class C06121<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f25287a;

                    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.MirrorViewComponent$c$1$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @f(b = "MirrorViewComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.components.MirrorViewComponent$onViewCreated$1$1$invokeSuspend$$inlined$map$1$2")
                    public static final class C06131 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f25288a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f25289b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ C06121 f25290c;

                        public C06131(C06121 r3, d.c.d r4) {
                            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                            this.f25290c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f25288a = r3;
                            this.f25289b |= Integer.MIN_VALUE;
                            return this.f25290c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public C06121(i r3) {
                        this.f25287a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d.c.d r7) {
                        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C06131.class) == false) goto L7;
                        C06131 r0 = (C06131) ZeusTransformUtils.preCheckCast(r8, C06131.class, "com.obric.aiagent.plugin");
                        if ((r0.f25289b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f25289b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f25288a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f25289b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r5 = this.f25287a;
                        d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                        b r11 = new b(((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).g());
                        r0.f25289b = 1;
                        if (r5.emit(r11, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C06131(this, r8);
                        goto L8
                    }
                }

                public a(kotlinx.coroutines.b.h r3) {
                    this.f25286a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i<? super b> r3, d.c.d r4) {
                    i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    Object r2 = this.f25286a.collect((i) ZeusTransformUtils.preCheckCast(new C06121(r5), i.class, "com.obric.aiagent.plugin"), r6);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass1(MirrorViewComponent r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25284b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25284b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25283a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L18:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                u r7 = MirrorViewComponent.a(this.f25284b);
                if (r7 == null) goto L18;
                ak<s> r8 = r7.b();
                if (r8 == null) goto L18;
                kotlinx.coroutines.b.h r9 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
                if (r9 == null) goto L18;
                final MirrorViewComponent r4 = this.f25284b;
                i r2 = (i) ZeusTransformUtils.preCheckCast(new C06111(r4), i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25283a = 1;
                if (r9.collect(r2, r3) != r0) goto L18;
                return r0;
            }
        }

        c(com.obric.autoaction.a.c r3, MirrorViewComponent r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25281b = r3;
            this.f25282c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25281b, this.f25282c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25280a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            p r8 = this.f25281b.b();
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2058e;
            m r3 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25282c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25280a = 1;
            if (ab.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MirrorViewComponent.kt */
    public static final class d implements IVirtualDisplayApi.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MirrorViewComponent f25291a;

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a(MotionEvent r1) {
            d.h.b.o.e(r1, "e");
        }

        d(MirrorViewComponent r1) {
            this.f25291a = r1;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a() {
            u r3 = MirrorViewComponent.a(this.f25291a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void b() {
            u r3 = MirrorViewComponent.a(this.f25291a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void c() {
            u r3 = MirrorViewComponent.a(this.f25291a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void d() {
            u r3 = MirrorViewComponent.a(this.f25291a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void e() {
            u r3 = MirrorViewComponent.a(this.f25291a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    static {
        f25274a = new a(null);
    }

    public static /* synthetic */ boolean lambda$KMwEFjOfiCb2LJjWI08I5dKs3S0(GestureDetector r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public MirrorViewComponent() {
        this.f25276c = "MirrorViewComponent";
    }

    public static final /* synthetic */ u a(MirrorViewComponent r0) {
        return r0.f25278e;
    }

    public static final /* synthetic */ void a(MirrorViewComponent r0, long r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ void a(MirrorViewComponent r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ long b(MirrorViewComponent r2) {
        return r2.f;
    }

    private final String a() {
        View r3 = this.f25275b;
        if (r3 != null) goto L6;
        return "mirrorView=null";
    L6:
        StringBuilder r0 = new StringBuilder().append("mirrorView@");
        String r1 = Integer.toString(System.identityHashCode(r3), d.o.a.a(16));
        d.h.b.o.c(r1, "toString(...)");
        return r0.append(r1).append(", attached=").append(r3.isAttachedToWindow()).append(", visibility=").append(r3.getVisibility()).toString();
    }

    private final void a(String r7) {
        View r0 = this.f25275b;
        if (r0 != null) goto L6;
        MirrorViewComponent r6 = (MirrorViewComponent) ZeusTransformUtils.preCheckCast(this, MirrorViewComponent.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(r6.f25276c, r7 + ": skip unbind, " + r6.a());
        return;
    L6:
        Loog.INSTANCE.i(this.f25276c, r7 + ": before unbind, " + a());
        IVirtualDisplayApi r2 = this.f25277d;
        if (r2 == null) goto L9;
        r2.unbind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Mirror(r0), DisplayHost.class, "com.obric.aiagent.plugin"));
    L9:
        Loog.INSTANCE.i(this.f25276c, r7 + ": after unbind, " + a());
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        d.h.b.o.e(r3, "componentHost");
        IVirtualDisplayApi r4 = (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtualDisplayApi.class), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
        this.f25277d = r4;
        if (r4 != null) goto L6;
        Loog.INSTANCE.e(this.f25276c, "Failed to get IVirtualDisplayApi service");
        return;
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r7, com.obric.autoaction.a.c r8) {
        d.h.b.o.e(r7, "container");
        d.h.b.o.e(r8, "componentHost");
        IComputerControlApi r0 = AOPlatformTools.INSTANCE.computerControl();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r1, "getContext(...)");
        CCDataResult<View> r2 = r0.createMirrorView(r1);
        if (ZeusTransformUtils.instanceOf(r2, CCDataResult.Success.class) == false) goto L6;
        View r9 = (View) ZeusTransformUtils.preCheckCast(((CCDataResult.Success) ZeusTransformUtils.preCheckCast(r2, CCDataResult.Success.class, "com.obric.aiagent.plugin")).getData(), View.class, "com.obric.aiagent.plugin");
    L8:
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f25275b = r9;
        this.f25278e = (u) ZeusTransformUtils.preCheckCast(r8.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        return r9;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, CCDataResult.Failed.class) == false) goto L11;
        Loog.INSTANCE.e(this.f25276c, "Failed to create MirrorView: " + r2);
        r9 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        goto L8
    L11:
        throw new k();
    }

    @Override // com.obric.autoaction.a.h
    public void a(View r8, com.obric.autoaction.a.c r9) {
        d.h.b.o.e(r8, "boundView");
        d.h.b.o.e(r9, "componentHost");
        g.a.a(this, r8, r9);
        kotlinx.coroutines.i.a(r9.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r9, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        b();
    }

    private final void b() {
        View r0 = this.f25275b;
        if (r0 != null) goto L5;
        return;
    L5:
        final GestureDetector r1 = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(new MirrorViewComponent$bindMirrorTapListener$gestureDetector$1(this), GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"));
        r0.setOnTouchListener(new $$Lambda$MirrorViewComponent$KMwEFjOfiCb2LJjWI08I5dKs3S0(r1));
    }

    private static final boolean a(GestureDetector r1, View r2, MotionEvent r3) {
        boolean r4 = r1.onTouchEvent(r3);
        if (r3.getActionMasked() != 1) goto L5;
        r2.performClick();
    L5:
        return r4;
    }

    private final void c() {
        View r1 = this.f25275b;
        if (r1 == null) goto L6;
        r1.setOnTouchListener(null);
        return;
    }

    private final void a(boolean r5) {
        View r0 = this.f25275b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r5 == false) goto L10;
        c();
        IVirtualDisplayApi r6 = this.f25277d;
        if (r6 == null) goto L15;
        r6.enableCallUser(true, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Mirror(r0), DisplayHost.class, "com.obric.aiagent.plugin"), (IVirtualDisplayApi.b) ZeusTransformUtils.preCheckCast(new d(this), IVirtualDisplayApi.b.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        return;
    L10:
        IVirtualDisplayApi r7 = this.f25277d;
        if (r7 == null) goto L13;
        r7.enableCallUser(false, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Mirror(r0), DisplayHost.class, "com.obric.aiagent.plugin"), null);
    L13:
        b();
    }

    @Override // androidx.lifecycle.d
    public void b(p r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "owner");
        super.b(r6);
        Loog.INSTANCE.i(this.f25276c, "onStart: before bind, " + a());
        View r7 = this.f25275b;
        if (r7 == null) goto L12;
        IVirtualDisplayApi r0 = this.f25277d;
        if (r0 == null) goto L7;
        r0.bind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Mirror(r7), DisplayHost.class, "com.obric.aiagent.plugin"));
    L7:
        Loog.INSTANCE.i(this.f25276c, "onStart: after bind, " + a());
        IVirtualDisplayApi r8 = this.f25277d;
        if (r8 == null) goto L10;
        r8.mute(false);
    L10:
        Loog.INSTANCE.i(this.f25276c, "onStart: after mute(false), " + a());
        return;
    }

    @Override // androidx.lifecycle.d
    public void d(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "owner");
        super.d(r5);
        Loog.INSTANCE.i(this.f25276c, "onStop: before mute(true), " + a());
        IVirtualDisplayApi r6 = this.f25277d;
        if (r6 == null) goto L5;
        r6.mute(true);
    L5:
        Loog.INSTANCE.i(this.f25276c, "onStop: after mute(true), " + a());
        a("onStop");
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.e(r4);
        a("onDestroy");
        c();
        this.f25275b = null;
    }
}
