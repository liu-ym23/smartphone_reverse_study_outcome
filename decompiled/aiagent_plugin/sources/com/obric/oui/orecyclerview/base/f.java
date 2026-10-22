package com.obric.oui.orecyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: OverScrollerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35534a = null;
    private static boolean j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Interpolator f35536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.f f35537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f35538e;
    private final d.f f;
    private boolean g;
    private long h;
    private long i;

    /* JADX INFO: compiled from: OverScrollerAdapter.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OverScrollerAdapter.kt */
    static final class b extends p implements d.h.a.a<com.obric.oui.orecyclerview.base.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35539a = null;

        static {
            f35539a = new b();
        }

        b() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.obric.oui.orecyclerview.base.c invoke() {
            return a();
        }

        public final com.obric.oui.orecyclerview.base.c a() {
            return new com.obric.oui.orecyclerview.base.c(0.0f, 1, null);
        }
    }

    /* JADX INFO: compiled from: OverScrollerAdapter.kt */
    static final class c extends p implements d.h.a.a<com.obric.oui.orecyclerview.base.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f35540a = null;

        static {
            f35540a = new c();
        }

        c() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ com.obric.oui.orecyclerview.base.c invoke() {
            return a();
        }

        public final com.obric.oui.orecyclerview.base.c a() {
            return new com.obric.oui.orecyclerview.base.c(0.0f, 1, null);
        }
    }

    /* JADX INFO: compiled from: OverScrollerAdapter.kt */
    static final class d extends p implements d.h.a.a<OverScroller> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f35541a;

        d(f r1) {
            this.f35541a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ OverScroller invoke() {
            return a();
        }

        public final OverScroller a() {
            return new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f.a(this.f35541a), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), f.b(this.f35541a));
        }
    }

    public f(Context r3, Interpolator r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Interpolator r6 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "interpolator");
        this.f35535b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35536c = r6;
        this.f35537d = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.f35538e = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(b.f35539a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.f = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(c.f35540a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.g = j;
        this.h = -1;
        this.i = -1;
    }

    public static final /* synthetic */ Context a(f r0) {
        return r0.f35535b;
    }

    public static final /* synthetic */ Interpolator b(f r0) {
        return r0.f35536c;
    }

    private final OverScroller i() {
        return (OverScroller) ZeusTransformUtils.preCheckCast(this.f35537d.b(), OverScroller.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.oui.orecyclerview.base.c j() {
        return (com.obric.oui.orecyclerview.base.c) ZeusTransformUtils.preCheckCast(this.f35538e.b(), com.obric.oui.orecyclerview.base.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.oui.orecyclerview.base.c k() {
        return (com.obric.oui.orecyclerview.base.c) ZeusTransformUtils.preCheckCast(this.f.b(), com.obric.oui.orecyclerview.base.c.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        if (this.g == false) goto L7;
        return i().computeScrollOffset();
    L7:
        if (this.h != (-1)) goto L10;
        return false;
    L10:
        this.i = AnimationUtils.currentAnimationTimeMillis() - this.h;
        return !h();
    }

    public final void a(int r8, int r9, int r10, int r11, int r12) {
        this.g = true;
        i().startScroll(r8, r9, r10, r11, r12);
    }

    public final void a(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (j == false) goto L6;
        i().fling(r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L6:
        this.g = false;
        float r4 = 1000;
        j().a(r12, r14 / r4);
        k().a(r13, r15 / r4);
        this.h = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void b() {
        if (this.g == false) goto L5;
        i().abortAnimation();
        return;
    L5:
        this.h = -1;
    }

    public final int c() {
        if (this.g == false) goto L7;
        return i().getCurrX();
    L7:
        return (int) j().a(this.i).a();
    }

    public final int d() {
        if (this.g == false) goto L7;
        return i().getCurrY();
    L7:
        return (int) k().a(this.i).a();
    }

    public final float e() {
        if (this.g == false) goto L7;
        return i().getCurrVelocity();
    L7:
        return ((float) Math.hypot(j().a(this.i).b(), k().a(this.i).b())) * 1000;
    }

    public final int f() {
        if (this.g == false) goto L7;
        return i().getFinalX();
    L7:
        return (int) j().a();
    }

    public final int g() {
        if (this.g == false) goto L7;
        return i().getFinalY();
    L7:
        return (int) k().a();
    }

    public final boolean h() {
        if (this.g == true) goto L5;
        com.obric.oui.orecyclerview.base.c.b r0 = j().a(this.i);
        com.obric.oui.orecyclerview.base.c.b r4 = k().a(this.i);
        if (r0.c() == true) goto L9;
    L11:
        return false;
    L9:
        if (r4.c() == false) goto L11;
        return true;
    L5:
        return i().isFinished();
    }

    static {
        f35534a = new a(null);
        j = true;
    }
}
