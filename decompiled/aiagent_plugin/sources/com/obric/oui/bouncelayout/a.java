package com.obric.oui.bouncelayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.AbsListView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: AbsListBounceGestureDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0928a f34134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AbsListView f34135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Boolean> f34136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<BounceEdgeEffect> f34137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<BounceEdgeEffect> f34138e;
    private final d.h.a.a<x> f;
    private final d.h.a.a<x> g;
    private final d.h.a.a<Float> h;
    private final int i;
    private final int j;
    private final int k;
    private boolean l;
    private boolean m;
    private float n;
    private float o;
    private boolean p;
    private int q;
    private float r;
    private float s;
    private VelocityTracker t;
    private long u;

    /* JADX INFO: renamed from: com.obric.oui.bouncelayout.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsListBounceGestureDelegate.kt */
    private static final class C0928a {
        public /* synthetic */ C0928a(h r1) {
            this();
        }

        private C0928a() {
        }
    }

    static {
        f34134a = new C0928a(null);
    }

    private final int c(int r1) {
        if (r1 >= 0) goto L4;
        return 0;
    L4:
        if (r1 <= 0) goto L6;
        return 1;
    L6:
        return -1;
    }

    public a(AbsListView r3, d.h.a.a<Boolean> r4, d.h.a.a<BounceEdgeEffect> r5, d.h.a.a<BounceEdgeEffect> r6, d.h.a.a<x> r7, d.h.a.a<x> r8, d.h.a.a<Float> r9) {
        d.h.a.a<Boolean> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<BounceEdgeEffect> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<BounceEdgeEffect> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Float> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "target");
        o.e(r10, "edgeEffectsInstalledProvider");
        o.e(r11, "bounceTopProvider");
        o.e(r12, "bounceBottomProvider");
        o.e(r13, "stopBounceIfNeeded");
        o.e(r14, "resetAbsListViewTouchMode");
        o.e(r15, "getBounceTranslation");
        this.f34135b = r3;
        this.f34136c = r10;
        this.f34137d = r11;
        this.f34138e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledTouchSlop();
        this.j = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledMinimumFlingVelocity();
        this.k = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledMaximumFlingVelocity();
        this.q = -1;
        this.u = -1;
    }

    public final void a(MotionEvent r3) {
        o.e(r3, "event");
        this.l = false;
        this.m = false;
        this.p = false;
        this.q = r3.getPointerId(0);
        float r0 = r3.getY(0);
        this.r = r0;
        this.s = r0;
        this.u = -1;
        b();
        k(r3);
    }

    public final boolean b(MotionEvent r2) {
        o.e(r2, "event");
        return i(r2);
    }

    public final boolean c(MotionEvent r2) {
        o.e(r2, "event");
        if (this.p == true) goto L6;
        return false;
    L6:
        a(r2.getActionIndex(), r2);
        return true;
    }

    public final boolean d(MotionEvent r2) {
        o.e(r2, "event");
        if (this.p == true) goto L6;
        return false;
    L6:
        j(r2);
        return true;
    }

    public final void a() {
        this.p = false;
        this.q = -1;
        this.u = -1;
        c();
    }

    public final boolean e(MotionEvent r3) {
        o.e(r3, "event");
        if (h(r3) == false) goto L6;
        this.l = true;
        this.m = false;
        this.n = r3.getY();
        this.o = r3.getY();
        return true;
    L6:
        a(r3);
        return false;
    }

    public final boolean f(MotionEvent r9) {
        o.e(r9, "event");
        boolean r2 = false;
        if (this.p == false) goto L19;
        if (r9.getEventTime() != this.u) goto L7;
        return true;
    L7:
        int r0 = r9.findPointerIndex(this.q);
        if (r0 >= 0) goto L11;
        e();
        return true;
    L11:
        float r1 = r9.getY(r0);
        float r4 = r1 - this.s;
        if (r4 != 0.0f) goto L14;
        r2 = true;
    L14:
        if (r2 == true) goto L16;
        k(r9);
        a(r4);
    L16:
        this.s = r1;
        return true;
    L19:
        if (i(r9) == false) goto L22;
        return true;
    L22:
        if (this.l == false) goto L37;
        float r10 = r9.getY();
        float r3 = r10 - this.n;
        float r5 = r10 - this.o;
        if (this.m == true) goto L29;
        if (Math.abs(r3) <= this.i) goto L29;
        this.m = true;
    L29:
        if (this.m == true) goto L31;
    L35:
        this.o = r10;
        return true;
    L31:
        if (r5 != 0.0f) goto L33;
        r2 = true;
    L33:
        if (r2 == true) goto L35;
        b(r5);
        goto L35
    L37:
        return false;
    }

    public final boolean g(MotionEvent r3) {
        o.e(r3, "event");
        if (this.p == false) goto L7;
        k(r3);
        e();
        return true;
    L7:
        if (this.l == false) goto L10;
        h();
        return true;
    L10:
        return false;
    }

    private final boolean h(MotionEvent r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f34136c.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L5;
        return false;
    L5:
        if (this.f34135b.getHeight() > 0) goto L8;
        return false;
    L8:
        if (this.f34135b.pointToPosition((int) r4.getX(), (int) r4.getY()) != (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean i(MotionEvent r7) {
        boolean r1 = false;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f34136c.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L5;
    L25:
        return r1;
    L5:
        if (this.f34135b.getHeight() <= 0) goto L25;
        if (a((BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin")) == false) goto L10;
    L12:
        int r0 = r7.findPointerIndex(this.q);
        if (r0 >= 0) goto L15;
        return false;
    L15:
        float r3 = r7.getY(r0) - this.r;
        if (Math.abs(r3) > this.i) goto L18;
        return false;
    L18:
        this.f.invoke();
        k(r7);
        r1 = true;
        this.p = true;
        this.s = this.r;
        a(r7.getY(r0) - this.s);
        this.s = r7.getY(r0);
        this.u = r7.getEventTime();
        ViewParent r8 = this.f34135b.getParent();
        if (r8 == null) goto L22;
        r8.requestDisallowInterceptTouchEvent(true);
    L22:
        d r9 = d.f34149a;
        if (d.a() == false) goto L25;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragStart", "dy=" + r3 + " translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.aiagent.plugin")).floatValue());
        goto L25
    L10:
        if (a((BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin")) == true) goto L12;
        return false;
    }

    private final void a(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.q = r3.getPointerId(r2);
        this.s = r3.getY(r2);
        return;
    }

    private final void j(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.q) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        a(r1, r4);
        return;
    L16:
        this.q = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    private final void b() {
        VelocityTracker r0 = this.t;
        if (r0 != null) goto L5;
        this.t = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private final void k(MotionEvent r1) {
        VelocityTracker r0 = this.t;
        if (r0 == null) goto L7;
        r0.addMovement(r1);
        return;
    }

    private final void c() {
        VelocityTracker r0 = this.t;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.t = null;
    }

    private final void a(float r3) {
        if (this.f34135b.getHeight() > 0) goto L6;
        return;
    L6:
        if (c(r3 / this.f34135b.getHeight()) == false) goto L8;
    L13:
        this.f34135b.invalidate();
        return;
    L8:
        if (r3 <= 0.0f) goto L11;
        a(d.i.a.a(-r3));
        goto L13
    L11:
        if (r3 >= 0.0f) goto L13;
        a(d.i.a.a(-r3));
        goto L13
    }

    private final void b(float r3) {
        if (this.f34135b.getHeight() > 0) goto L6;
        return;
    L6:
        if (c(r3 / this.f34135b.getHeight()) == false) goto L8;
    L13:
        this.f34135b.invalidate();
        return;
    L8:
        if (r3 <= 0.0f) goto L11;
        a(d.i.a.a(-r3));
        goto L13
    L11:
        if (r3 >= 0.0f) goto L13;
        a(d.i.a.a(-r3));
        goto L13
    }

    private final boolean c(float r8) {
        BounceEdgeEffect r0 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        BounceEdgeEffect r1 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        boolean r2 = a(r0);
        boolean r3 = a(r1);
        if (r2 == false) goto L11;
        if (r0 != null) goto L6;
        float r4 = 0.0f;
    L7:
        float r9 = r8 - r4;
        if (r9 >= 0.0f) goto L19;
        a(d.i.a.a((-r9) * this.f34135b.getHeight()), 1);
    L19:
        return true;
    L6:
        r4 = r0.onPullDistance(r8, 0.5f);
        goto L7
    L11:
        if (r3 == false) goto L20;
        float r10 = -r8;
        if (r1 != null) goto L15;
        float r5 = 0.0f;
    L16:
        float r11 = r10 - r5;
        if (r11 >= 0.0f) goto L19;
        a(d.i.a.a(r11 * this.f34135b.getHeight()), 0);
        goto L19
    L15:
        r5 = r1.onPullDistance(r10, 0.5f);
        goto L16
    L20:
        return false;
    }

    private final void a(int r8, int r9) {
        if (r8 != 0) goto L4;
        return;
    L4:
        if (this.f34135b.getHeight() <= 0) goto L32;
        int r0 = d(r8);
        d r1 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragContentScroll", "oppositeEdge=" + r9 + " scrollDeltaY=" + r8 + " consumed=" + (r8 - r0) + " unconsumed=" + r0);
    L9:
        if (r0 != 0) goto L11;
        return;
    L11:
        d r2 = d.f34149a;
        if (d.a() == false) goto L14;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragDirectReverse", "edge=" + r9 + " scrollDeltaY=" + r8 + " unconsumed=" + r0);
    L14:
        if (r9 != 0) goto L21;
        if (r0 >= 0) goto L21;
        BounceEdgeEffect r10 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L33;
        r10.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease((-r0) / this.f34135b.getHeight());
        return;
    L33:
        return;
    L21:
        if (r9 != 1) goto L30;
        if (r0 <= 0) goto L31;
        BounceEdgeEffect r11 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L34;
        r11.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease(r0 / this.f34135b.getHeight());
        return;
    L34:
        return;
    L31:
        return;
    L30:
        return;
    }

    private final void a(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        if (this.f34135b.getHeight() <= 0) goto L12;
        int r0 = d(r5);
        d r1 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragContentScroll", "oppositeEdge=" + c(r0) + " scrollDeltaY=" + r5 + " consumed=" + (r5 - r0) + " unconsumed=" + r0);
    L9:
        b(r0);
        return;
    }

    private final void b(int r6) {
        if (r6 < 0) goto L5;
    L13:
        if (r6 > 0) goto L15;
        return;
    L15:
        if (this.f34135b.getHeight() <= 0) goto L26;
        d r2 = d.f34149a;
        if (d.a() == false) goto L19;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragDirectReverse", o.a("edge=1 unconsumed=", Integer.valueOf(r6)));
    L19:
        BounceEdgeEffect r0 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L28;
        r0.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease(r6 / this.f34135b.getHeight());
        return;
    L28:
        return;
    L26:
        return;
    L5:
        if (this.f34135b.getHeight() <= 0) goto L13;
        d r3 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragDirectReverse", o.a("edge=0 unconsumed=", Integer.valueOf(r6)));
    L9:
        BounceEdgeEffect r1 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L27;
        r1.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease((-r6) / this.f34135b.getHeight());
        return;
    }

    private final int d(int r10) {
        if (r10 != 0) goto L4;
    L35:
        return r10;
    L4:
        if (this.f34135b.getChildCount() == 0) goto L35;
        if (this.f34135b.canScrollList(r10) == false) goto L35;
        int r0 = d();
        int r2 = 0;
    L9:
        if (r10 == 0) goto L35;
        if (this.f34135b.canScrollList(r10) == false) goto L35;
        if (r10 <= 0) goto L14;
        int r3 = n.d(r10, r0);
    L15:
        int r4 = this.f34135b.getChildCount();
        int[] r5 = new int[r4];
        int r6 = 0;
    L16:
        if (r6 >= r4) goto L18;
        r5[r6] = this.f34135b.getFirstVisiblePosition() + r6;
        r6 = r6 + 1;
        goto L16
    L18:
        int[] r7 = new int[r4];
        int r8 = 0;
    L19:
        if (r8 >= r4) goto L21;
        r7[r8] = this.f34135b.getChildAt(r8).getTop();
        r8 = r8 + 1;
        goto L19
    L21:
        this.f34135b.scrollListBy(r3);
        Integer r9 = a(r5, r7);
        if (r9 == null) goto L23;
        r2 = r2 + 1;
        if (r3 <= 0) goto L29;
        int r11 = n.a(r9.intValue(), 0, r3);
    L30:
        if (r11 == 0) goto L35;
        r10 = r10 - r11;
        if (r2 <= ((this.f34135b.getCount() + this.f34135b.getChildCount()) + 1)) goto L9;
        return 0;
    L29:
        r11 = n.a(r9.intValue(), r3, 0);
        goto L30
    L23:
        d r1 = d.f34149a;
        if (d.a() == false) goto L35;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragScrollMeasureMiss", "step=" + r3 + " remaining=" + r10 + " childCountBefore=" + r4 + " childCountAfter=" + this.f34135b.getChildCount());
        goto L35
    L14:
        r3 = n.c(r10, -r0);
        goto L15
    }

    private final int d() {
        int r0 = n.c(((this.f34135b.getHeight() - this.f34135b.getListPaddingTop()) - this.f34135b.getListPaddingBottom()) - 1, 1);
        int r2 = this.f34135b.getChildCount();
        int r4 = 0;
        int r5 = Integer.MAX_VALUE;
    L3:
        if (r4 >= r2) goto L9;
        int r6 = r4 + 1;
        int r7 = this.f34135b.getChildAt(r4).getHeight();
        if (r7 <= 0) goto L8;
        if (r7 >= r5) goto L8;
        r5 = r7;
    L8:
        r4 = r6;
        goto L3
    L9:
        if (r5 != Integer.MAX_VALUE) goto L12;
        return r0;
    L12:
        return n.d(n.c(r5 / 2, 1), r0);
    }

    private final Integer a(int[] r5, int[] r6) {
        int r0 = this.f34135b.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        int r3 = i.b(r5, this.f34135b.getFirstVisiblePosition() + r1);
        if (r3 >= 0) goto L7;
        r1 = r2;
        goto L3
    L7:
        return Integer.valueOf(r6[r3] - this.f34135b.getChildAt(r1).getTop());
    L9:
        return null;
    }

    private final void e() {
        this.p = false;
        int r0 = f();
        int r1 = g();
        this.q = -1;
        this.u = -1;
        d r2 = d.f34149a;
        if (d.a() == false) goto L6;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragRelease", "translation=" + ((Number) ZeusTransformUtils.preCheckCast(this.h.invoke(), Number.class, "com.obric.aiagent.plugin")).floatValue() + " velocityY=" + r0);
    L6:
        if (b(r1, r0) == true) goto L8;
        this.g.invoke();
    L8:
        c();
        this.f34135b.invalidate();
    }

    private final int f() {
        int r0 = this.q;
        VelocityTracker r1 = this.t;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != (-1)) goto L8;
        return 0;
    L8:
        r1.computeCurrentVelocity(1000, this.k);
        float r2 = r1.getYVelocity(r0);
        if (Math.abs(r2) >= this.j) goto L12;
        return 0;
    L12:
        return d.i.a.a(-r2);
    }

    private final boolean b(int r10, int r11) {
        BounceEdgeEffect r0 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        BounceEdgeEffect r1 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r11 == 0) goto L58;
        if (r10 != 0) goto L10;
        if (r11 >= 0) goto L10;
        if (r0 == null) goto L9;
        r0.onAbsorb(r11);
    L9:
        return false;
    L10:
        if (r10 != 1) goto L17;
        if (r11 <= 0) goto L17;
        if (r1 == null) goto L15;
        r1.onAbsorb(r11);
    L15:
        return false;
    L17:
        if (r11 <= 0) goto L26;
        if (this.f34135b.canScrollList(1) == false) goto L26;
        d r12 = d.f34149a;
        if (d.a() == false) goto L23;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragContentFling", "velocityY=" + r11 + " direction=1");
    L23:
        this.f34135b.fling(r11);
        return true;
    L26:
        if (r11 < 0) goto L28;
    L34:
        if (r10 != 1) goto L40;
        if (r11 >= 0) goto L40;
        if (r1 == null) goto L39;
        r1.onRelease();
    L39:
        return false;
    L40:
        if (r10 != 0) goto L46;
        if (r11 <= 0) goto L46;
        if (r0 == null) goto L45;
        r0.onRelease();
    L45:
        return false;
    L46:
        if (r10 != (-1)) goto L52;
        if (r11 <= 0) goto L52;
        if (r1 == null) goto L51;
        r1.onAbsorb(r11);
    L51:
        return false;
    L52:
        if (r10 != (-1)) goto L58;
        if (r11 >= 0) goto L58;
        if (r0 == null) goto L57;
        r0.onAbsorb(r11);
    L57:
        return false;
    L28:
        if (this.f34135b.canScrollList(-1) == false) goto L34;
        d r13 = d.f34149a;
        if (d.a() == false) goto L32;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "bounceDragContentFling", "velocityY=" + r11 + " direction=-1");
    L32:
        this.f34135b.fling(r11);
        return true;
    L58:
        if (r10 == 0) goto L64;
        if (r10 != 1) goto L67;
        if (r1 == null) goto L67;
        r1.onRelease();
    L67:
        return false;
    L64:
        if (r0 == null) goto L67;
        r0.onRelease();
        goto L67
    }

    private final int g() {
        BounceEdgeEffect r0 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        BounceEdgeEffect r1 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        boolean r2 = a(r0);
        boolean r5 = a(r1);
        if (r2 == false) goto L6;
        if (r5 == true) goto L6;
    L24:
        return 0;
    L6:
        if (r5 == false) goto L10;
        if (r2 == true) goto L10;
        return 1;
    L10:
        if (r0 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L24;
        if (r1 != null) goto L18;
        float r4 = 0.0f;
    L20:
        if (r4 < 0.0f) goto L26;
        return -1;
    L26:
        return 1;
    L18:
        r4 = r1.getTranslation();
        goto L20
    L12:
        r3 = r0.getTranslation();
        goto L14
    }

    private final void h() {
        this.l = false;
        this.m = false;
        d r0 = d.f34149a;
        if (d.a() == false) goto L5;
        d.a((View) ZeusTransformUtils.preCheckCast(this.f34135b, View.class, "com.obric.aiagent.plugin"), "emptyAreaRelease", o.a("translation=", this.h.invoke()));
    L5:
        BounceEdgeEffect r1 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34137d.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        r1.onRelease();
    L9:
        BounceEdgeEffect r2 = (BounceEdgeEffect) ZeusTransformUtils.preCheckCast(this.f34138e.invoke(), BounceEdgeEffect.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        r2.onRelease();
    L13:
        this.f34135b.invalidate();
    }

    private final boolean a(BounceEdgeEffect r4) {
        if (r4 == null) goto L18;
        if (r4.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        if (r4.getTranslation() != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        return true;
    L15:
        if (r4.isFinished() == true) goto L18;
        return true;
    L12:
        r2 = false;
        goto L13
    L7:
        r1 = false;
    L18:
        return false;
    }
}
