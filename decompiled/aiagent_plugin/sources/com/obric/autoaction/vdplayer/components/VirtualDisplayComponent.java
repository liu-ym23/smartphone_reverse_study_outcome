package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ab;
import androidx.lifecycle.p;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.autoaction.a.g;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.s;
import com.obric.autoaction.vdplayer.d.u;
import com.obric.autoaction.vdplayer.tracking.VDPlayerSurfaceRenderMonitor;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.vdplayer.a.h;
import com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
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
    private static final a f25333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f25334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IVirtualDisplayApi f25336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u f25337e;
    private VDPlayerSurfaceRenderMonitor f;
    private FpsTracer g;
    private long h;
    private boolean i;
    private b j;
    private long k;

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f25338a;

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
            if (this.f25338a == r6.f25338a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f25338a);
        }

        public String toString() {
            return "VirtualDisplayTouchState(isUserOperating=" + this.f25338a + ')';
        }

        public b(boolean r1) {
            this.f25338a = r1;
        }

        public /* synthetic */ b(boolean r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f25338a;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    @f(b = "VirtualDisplayComponent.kt", c = {101}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$onViewCreated$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.a.c f25340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ VirtualDisplayComponent f25341c;

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$c$1, reason: invalid class name */
        /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
        @f(b = "VirtualDisplayComponent.kt", c = {107}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$onViewCreated$1$1")
        static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25342a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ VirtualDisplayComponent f25343b;

            /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$c$1$a */
            /* JADX INFO: compiled from: SafeCollector.common.kt */
            public static final class a implements kotlinx.coroutines.b.h<b> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.h f25345a;

                /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$c$1$a$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                public static final class C06161<T> implements i {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ i f25346a;

                    /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$c$1$a$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @f(b = "VirtualDisplayComponent.kt", c = {219}, d = "emit", e = "com.obric.autoaction.vdplayer.components.VirtualDisplayComponent$onViewCreated$1$1$invokeSuspend$$inlined$map$1$2")
                    public static final class C06171 extends d.c.b.a.d {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f25347a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f25348b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ C06161 f25349c;

                        public C06171(C06161 r3, d.c.d r4) {
                            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                            this.f25349c = r3;
                            super(r5);
                        }

                        @Override // d.c.b.a.a
                        public final Object invokeSuspend(Object r3) {
                            this.f25347a = r3;
                            this.f25348b |= Integer.MIN_VALUE;
                            return this.f25349c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                        }
                    }

                    public C06161(i r3) {
                        this.f25346a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    }

                    @Override // kotlinx.coroutines.b.i
                    public final Object emit(Object r6, d.c.d r7) {
                        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                        if (ZeusTransformUtils.instanceOf(r8, C06171.class) == false) goto L7;
                        C06171 r0 = (C06171) ZeusTransformUtils.preCheckCast(r8, C06171.class, "com.obric.aiagent.plugin");
                        if ((r0.f25348b & Integer.MIN_VALUE) == 0) goto L7;
                        r0.f25348b -= Integer.MIN_VALUE;
                    L8:
                        Object r9 = r0.f25347a;
                        Object r2 = d.c.a.b.a();
                        int r3 = r0.f25348b;
                        if (r3 == 0) goto L14;
                        if (r3 != 1) goto L13;
                        o.a(r9);
                    L18:
                        return x.f38692a;
                    L13:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L14:
                        o.a(r9);
                        i r5 = this.f25346a;
                        d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                        b r11 = new b(((s) ZeusTransformUtils.preCheckCast(r6, s.class, "com.obric.aiagent.plugin")).g());
                        r0.f25348b = 1;
                        if (r5.emit(r11, r0) != r2) goto L18;
                        return r2;
                    L7:
                        r0 = new C06171(this, r8);
                        goto L8
                    }
                }

                public a(kotlinx.coroutines.b.h r3) {
                    this.f25345a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.h
                public Object collect(i<? super b> r3, d.c.d r4) {
                    i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                    d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    Object r2 = this.f25345a.collect((i) ZeusTransformUtils.preCheckCast(new C06161(r5), i.class, "com.obric.aiagent.plugin"), r6);
                    if (r2 != d.c.a.b.a()) goto L6;
                    return r2;
                L6:
                    return x.f38692a;
                }
            }

            AnonymousClass1(VirtualDisplayComponent r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25343b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25343b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f25342a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L18:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                u r7 = VirtualDisplayComponent.a(this.f25343b);
                if (r7 == null) goto L18;
                ak<s> r8 = r7.b();
                if (r8 == null) goto L18;
                kotlinx.coroutines.b.h r9 = j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
                if (r9 == null) goto L18;
                final VirtualDisplayComponent r4 = this.f25343b;
                i r2 = (i) ZeusTransformUtils.preCheckCast(new C06151(r4), i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f25342a = 1;
                if (r9.collect(r2, r3) != r0) goto L18;
                return r0;
            }
        }

        c(com.obric.autoaction.a.c r3, VirtualDisplayComponent r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25340b = r3;
            this.f25341c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f25340b, this.f25341c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25339a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            p r8 = this.f25340b.b();
            androidx.lifecycle.i.b r2 = androidx.lifecycle.i.b.f2058e;
            m r3 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f25341c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25339a = 1;
            if (ab.a(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayComponent.kt */
    public static final class d implements IVirtualDisplayApi.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirtualDisplayComponent f25350a;

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a(MotionEvent r1) {
            d.h.b.o.e(r1, "e");
        }

        d(VirtualDisplayComponent r1) {
            this.f25350a = r1;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void a() {
            Loog.INSTANCE.d(VirtualDisplayComponent.c(this.f25350a), "onSurfaceViewTouched");
            u r3 = VirtualDisplayComponent.a(this.f25350a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void b() {
            u r3 = VirtualDisplayComponent.a(this.f25350a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void c() {
            u r3 = VirtualDisplayComponent.a(this.f25350a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void d() {
            u r3 = VirtualDisplayComponent.a(this.f25350a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // com.obric.autogui.vdplayer.api.virtualdisplay.IVirtualDisplayApi.b
        public void e() {
            u r3 = VirtualDisplayComponent.a(this.f25350a);
            if (r3 == null) goto L6;
            r3.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.l.f25551a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    static {
        f25333a = new a(null);
    }

    public static /* synthetic */ String lambda$1gSaUw9iYqVXFm56K0SZUsOIYbE(VirtualDisplayComponent r0) {
        return e(r0);
    }

    public static /* synthetic */ boolean lambda$3UgGCNWeEngJbLMS7lUF012mrzU(VirtualDisplayComponent r0) {
        return d(r0);
    }

    public static /* synthetic */ x lambda$68KXZQVOdeokyDYwT602CvqxsGA(VirtualDisplayComponent r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$c9do9ItUWXvZRl0bDNCWo6bqCNY(GestureDetector r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public VirtualDisplayComponent() {
        this.f25335c = "VirtualDisplayComponent";
        this.j = new b(false, 1, null);
    }

    public static final /* synthetic */ u a(VirtualDisplayComponent r0) {
        return r0.f25337e;
    }

    public static final /* synthetic */ void a(VirtualDisplayComponent r0, long r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(VirtualDisplayComponent r0, b r1) {
        r0.j = r1;
    }

    public static final /* synthetic */ void a(VirtualDisplayComponent r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ long b(VirtualDisplayComponent r2) {
        return r2.k;
    }

    public static final /* synthetic */ String c(VirtualDisplayComponent r0) {
        return r0.f25335c;
    }

    private final String a() {
        h r7 = this.f25334b;
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
        h r0 = this.f25334b;
        if (r0 == null) goto L12;
        SurfaceView r1 = r0.f31619a;
        if (r1 == null) goto L12;
        Loog.INSTANCE.i(this.f25335c, r7 + ": before unbind, " + a());
        IVirtualDisplayApi r2 = this.f25336d;
        if (r2 == null) goto L10;
        r2.unbind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"));
    L10:
        Loog.INSTANCE.i(this.f25335c, r7 + ": after unbind, " + a());
        return;
    L12:
        VirtualDisplayComponent r6 = (VirtualDisplayComponent) ZeusTransformUtils.preCheckCast(this, VirtualDisplayComponent.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(r6.f25335c, r7 + ": skip unbind, " + r6.a());
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r3) {
        d.h.b.o.e(r3, "componentHost");
        IVirtualDisplayApi r4 = (IVirtualDisplayApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVirtualDisplayApi.class), IVirtualDisplayApi.class, "com.obric.aiagent.plugin");
        this.f25336d = r4;
        if (r4 != null) goto L6;
        Loog.INSTANCE.e(this.f25335c, "Failed to get IVirtualDisplayApi service");
        return;
    }

    @Override // androidx.lifecycle.d
    public void a(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.a(r4);
        this.h = SystemClock.elapsedRealtime();
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r4, com.obric.autoaction.a.c r5) {
        d.h.b.o.e(r4, "container");
        d.h.b.o.e(r5, "componentHost");
        h r6 = h.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r6, "inflate(...)");
        this.f25334b = r6;
        this.f25337e = (u) ZeusTransformUtils.preCheckCast(r5.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        SurfaceView r3 = r6.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
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
        h r0 = this.f25334b;
        if (r0 == null) goto L9;
        SurfaceView r1 = r0.f31619a;
        if (r1 == null) goto L10;
        final GestureDetector r2 = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(new VirtualDisplayComponent$bindSurfaceTapListener$gestureDetector$1(this), GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin"));
        r1.setOnTouchListener(new $$Lambda$VirtualDisplayComponent$c9do9ItUWXvZRl0bDNCWo6bqCNY(r2));
        return;
    L10:
        return;
    }

    private static final boolean a(GestureDetector r1, View r2, MotionEvent r3) {
        boolean r4 = r1.onTouchEvent(r3);
        if (r3.getActionMasked() != 1) goto L5;
        r2.performClick();
    L5:
        return r4;
    }

    private final void a(boolean r5) {
        h r0 = this.f25334b;
        if (r0 == null) goto L17;
        SurfaceView r1 = r0.f31619a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5 == false) goto L12;
        IVirtualDisplayApi r6 = this.f25336d;
        if (r6 == null) goto L18;
        r6.enableCallUser(true, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"), (IVirtualDisplayApi.b) ZeusTransformUtils.preCheckCast(new d(this), IVirtualDisplayApi.b.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        return;
    L12:
        IVirtualDisplayApi r7 = this.f25336d;
        if (r7 == null) goto L15;
        r7.enableCallUser(false, (DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r1), DisplayHost.class, "com.obric.aiagent.plugin"), null);
    L15:
        b();
        return;
    }

    @Override // androidx.lifecycle.d
    public void b(p r10) {
        p r11 = (p) ZeusTransformUtils.wrapperContextForParams(r10, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "owner");
        super.b(r11);
        Loog.INSTANCE.i(this.f25335c, "onStart: before bind, " + a());
        h r12 = this.f25334b;
        if (r12 == null) goto L33;
        SurfaceView r3 = r12.f31619a;
        if (r3 == null) goto L34;
        IVirtualDisplayApi r13 = this.f25336d;
        if (r13 == null) goto L9;
        r13.bind((DisplayHost) ZeusTransformUtils.preCheckCast(new DisplayHost.Surface(r3), DisplayHost.class, "com.obric.aiagent.plugin"));
    L9:
        Loog.INSTANCE.i(this.f25335c, "onStart: after bind, " + a());
        IVirtualDisplayApi r14 = this.f25336d;
        if (r14 == null) goto L12;
        r14.mute(false);
    L12:
        Loog.INSTANCE.i(this.f25335c, "onStart: after mute(false), " + a());
        if (this.i == false) goto L15;
    L29:
        c();
        return;
    L15:
        if (this.f != null) goto L29;
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_vdplayer_surface_render_monitor", true) == false) goto L29;
        n.a r15 = n.f38560a;     // Catch: Throwable -> L20
        final VirtualDisplayComponent r16 = (VirtualDisplayComponent) ZeusTransformUtils.preCheckCast(this, VirtualDisplayComponent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        VDPlayerSurfaceRenderMonitor r0 = new VDPlayerSurfaceRenderMonitor(r3, r16.h, new $$Lambda$VirtualDisplayComponent$3UgGCNWeEngJbLMS7lUF012mrzU(r16), new $$Lambda$VirtualDisplayComponent$1gSaUw9iYqVXFm56K0SZUsOIYbE(r16), new $$Lambda$VirtualDisplayComponent$68KXZQVOdeokyDYwT602CvqxsGA(r16));     // Catch: Throwable -> L20
        r0.start();     // Catch: Throwable -> L20
        Object r17 = n.f(r0);     // Catch: Throwable -> L20
    L22:
        Throwable r1 = n.c(r17);
        if (r1 == null) goto L26;
        Loog.INSTANCE.e(this.f25335c, "Failed to start Surface render monitor", r1);
    L26:
        if (n.b(r17) == false) goto L28;
        r17 = null;
    L28:
        this.f = (VDPlayerSurfaceRenderMonitor) ZeusTransformUtils.preCheckCast(r17, VDPlayerSurfaceRenderMonitor.class, "com.obric.aiagent.plugin");
    L20:
        th = move-exception;
        n.a r2 = n.f38560a;
        r17 = n.f(o.a(th));
        goto L22
    L34:
        return;
    }

    private static final boolean d(VirtualDisplayComponent r2) {
        IVirtualDisplayApi r3 = r2.f25336d;
        if (r3 == null) goto L8;
        if (r3.getIsSecureLayer() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private static final String e(VirtualDisplayComponent r2) {
        u r3 = r2.f25337e;
        if (r3 == null) goto L11;
        ak<s> r4 = r3.b();
        if (r4 == null) goto L11;
        s r5 = (s) ZeusTransformUtils.preCheckCast(r4.c(), s.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L11;
        com.obric.autoaction.vdplayer.d.h r6 = r5.c();
        if (r6 == null) goto L11;
        String r7 = r6.c();
    L12:
        if (r7 != null) goto L15;
        return "";
    L15:
        return r7;
    L11:
        r7 = null;
        goto L12
    }

    private static final x f(VirtualDisplayComponent r1) {
        r1.i = true;
        r1.f = null;
        return x.f38692a;
    }

    @Override // androidx.lifecycle.d
    public void d(p r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "owner");
        super.d(r6);
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        VDPlayerSurfaceRenderMonitor r1 = ((VirtualDisplayComponent) ZeusTransformUtils.preCheckCast(this, VirtualDisplayComponent.class, "com.obric.aiagent.plugin")).f;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.stop("on_stop");     // Catch: Throwable -> L9
        x r2 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r3 = n.f(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = n.c(r3);
        if (r4 == null) goto L14;
        Loog.INSTANCE.e(this.f25335c, "Failed to stop Surface render monitor", r4);
    L14:
        this.f = null;
        d();
        Loog.INSTANCE.i(this.f25335c, "onStop: before mute(true), " + a());
        IVirtualDisplayApi r7 = this.f25336d;
        if (r7 == null) goto L17;
        r7.mute(true);
    L17:
        Loog.INSTANCE.i(this.f25335c, "onStop: after mute(true), " + a());
        a("onStop");
        return;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        n.a r8 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L11
    }

    @Override // androidx.lifecycle.d
    public void e(p r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "owner");
        super.e(r6);
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        VDPlayerSurfaceRenderMonitor r1 = ((VirtualDisplayComponent) ZeusTransformUtils.preCheckCast(this, VirtualDisplayComponent.class, "com.obric.aiagent.plugin")).f;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.stop("on_destroy");     // Catch: Throwable -> L9
        x r2 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r3 = n.f(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = n.c(r3);
        if (r4 == null) goto L14;
        Loog.INSTANCE.e(this.f25335c, "Failed to destroy Surface render monitor", r4);
    L14:
        this.f = null;
        d();
        a("onDestroy");
        this.f25334b = null;
        return;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        n.a r7 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L11
    }

    private final void c() {
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_vdplayer_surface_render_monitor", true) == true) goto L5;
        return;
    L5:
        FpsTracer r0 = new FpsTracer("obric_vdplayer_virtual_display");
        this.g = r0;
        if (r0 == null) goto L9;
        r0.a();
        return;
    }

    private final void d() {
        FpsTracer r0 = this.g;
        if (r0 == null) goto L6;
        r0.b();
        this.g = null;
        return;
    }
}
