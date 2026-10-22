package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.OverScroller;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OGridView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OGridView extends GridView {
    public static final a Companion = null;
    private static final int STOPPED_BOUNCE_NONE = -1;
    public static final String TAG = "OGridView";
    private static final int TOUCH_MODE_REST = -1;
    private BounceEdgeEffect bounceBottom;
    private final com.obric.oui.bouncelayout.a bounceGestureDelegate;
    private boolean bounceStoppedForTouch;
    private BounceEdgeEffect bounceTop;
    private final com.obric.oui.bouncelayout.b clickDuringOverScrollDelegate;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private Field flingRunnableField;
    private Field flingRunnableScrollerField;
    private int lastScrollDirection;
    private float lastScrollerVelocity;
    private int lastVerticalScrollOffset;
    private Object originalBottomEffect;
    private Object originalTopEffect;
    private final com.obric.oui.bouncelayout.e overscrollDelegate;
    private Field scrollerField;
    private Field touchModeField;
    private final com.obric.oui.bouncelayout.f translationDelegate;

    /* JADX INFO: compiled from: OGridView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class b extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34077a;

        b(OGridView r1) {
            this.f34077a = r1;
            super(0);
        }

        public final Boolean a() {
            return Boolean.valueOf(OGridView.access$getEdgeEffectsInstalled$p(this.f34077a));
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class c extends p implements d.h.a.a<BounceEdgeEffect> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34078a;

        c(OGridView r1) {
            this.f34078a = r1;
            super(0);
        }

        public final BounceEdgeEffect a() {
            return OGridView.access$getBounceTop$p(this.f34078a);
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class d extends p implements d.h.a.a<BounceEdgeEffect> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34079a;

        d(OGridView r1) {
            this.f34079a = r1;
            super(0);
        }

        public final BounceEdgeEffect a() {
            return OGridView.access$getBounceBottom$p(this.f34079a);
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34080a;

        e(OGridView r1) {
            this.f34080a = r1;
            super(0);
        }

        public final void a() {
            OGridView.access$stopBounceIfNeeded(this.f34080a);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class f extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34081a;

        f(OGridView r1) {
            this.f34081a = r1;
            super(0);
        }

        public final void a() {
            OGridView.access$resetAbsListViewTouchMode(this.f34081a);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class g extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34082a;

        g(OGridView r1) {
            this.f34082a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34082a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class h extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34083a;

        h(OGridView r1) {
            this.f34083a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34083a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class i extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34084a;

        i(OGridView r1) {
            this.f34084a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OGridView.access$getBounceTop$p(this.f34084a), OGridView.access$getBounceBottom$p(this.f34084a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class j extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MotionEvent f34086b;

        j(OGridView r1, MotionEvent r2) {
            this.f34085a = r1;
            this.f34086b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(OGridView.access$dispatchTouchEvent$s382765867(this.f34085a, this.f34086b));
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class k extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34087a;

        k(OGridView r1) {
            this.f34087a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f34087a.getHeight());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class l extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34088a;

        l(OGridView r1) {
            this.f34088a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OGridView.access$getBounceTop$p(this.f34088a), OGridView.access$getBounceBottom$p(this.f34088a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class m extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34089a;

        m(OGridView r1) {
            this.f34089a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34089a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OGridView.kt */
    static final class n extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OGridView f34090a;

        n(OGridView r1) {
            this.f34090a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OGridView.access$getBounceTop$p(this.f34090a), OGridView.access$getBounceBottom$p(this.f34090a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public OGridView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OGridView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public /* synthetic */ OGridView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = R.attr.gridViewStyle;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ boolean access$dispatchTouchEvent$s382765867(OGridView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OGridView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OGridView r0) {
        return r0.bounceTop;
    }

    public static final /* synthetic */ boolean access$getEdgeEffectsInstalled$p(OGridView r0) {
        return r0.edgeEffectsInstalled;
    }

    public static final /* synthetic */ void access$resetAbsListViewTouchMode(OGridView r0) {
        r0.resetAbsListViewTouchMode();
    }

    public static final /* synthetic */ boolean access$stopBounceIfNeeded(OGridView r0) {
        return r0.stopBounceIfNeeded();
    }

    public OGridView(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14, r15, r13);
        this.overscrollDelegate = new com.obric.oui.bouncelayout.e((d.h.a.a) ZeusTransformUtils.preCheckCast(new k(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new l(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.translationDelegate = new com.obric.oui.bouncelayout.f((d.h.a.a) ZeusTransformUtils.preCheckCast(new m(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new n(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.clickDuringOverScrollDelegate = new com.obric.oui.bouncelayout.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.bounceGestureDelegate = new com.obric.oui.bouncelayout.a((AbsListView) ZeusTransformUtils.preCheckCast(this, AbsListView.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.a("Landroid/widget/AbsListView;");
        initEdgeEffectReflection();
        installBounceEdgeEffects();
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.bounceTop;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.bounceBottom;
        if (r3 == null) goto L11;
        r1 = r3.getTranslation();
    L11:
        return r2 + r1;
    L5:
        r2 = r0.getTranslation();
        goto L6
    }

    public void setOnBounceTranslationListener(com.obric.oui.bouncelayout.g r3) {
        com.obric.oui.bouncelayout.g r4 = (com.obric.oui.bouncelayout.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.bouncelayout.g.class, "com.obric.aiagent.plugin");
        this.translationDelegate.a(r4);
    }

    public void allowClickDuringOverScroll(boolean r1) {
        this.clickDuringOverScrollDelegate.a(r1);
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L12;
        o.a(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceTop;
        o.a(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L23;
        o.a(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceBottom;
        o.a(r6);
        if (r6.isFinished() == true) goto L23;
    L22:
        boolean r7 = true;
    L24:
        if (r3 == true) goto L29;
        if (r7 == false) goto L28;
        return true;
    L28:
        return false;
    L29:
        return true;
    L18:
        r5 = false;
    L23:
        r7 = false;
        goto L24
    L7:
        r1 = false;
    L12:
        r3 = false;
        goto L13
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.b();
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r0 = this.bounceBottom;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        o.e(r6, "ev");
        this.clickDuringOverScrollDelegate.a(r6);
        com.obric.oui.bouncelayout.b r0 = this.clickDuringOverScrollDelegate;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new j(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r1 != null) goto L5;
        boolean r2 = super.dispatchTouchEvent(r6);
    L7:
        if (r6.getActionMasked() != 1) goto L9;
    L10:
        releaseStoppedBounceIfNeeded();
    L11:
        return r2;
    L9:
        if (r6.getActionMasked() != 3) goto L11;
    L5:
        r2 = r1.booleanValue();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        o.e(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r2 = true;
        if (r0 == 0) goto L31;
        if (r0 != 1) goto L6;
    L27:
        this.bounceGestureDelegate.a();
        releaseStoppedBounceIfNeeded();
    L29:
        return super.onInterceptTouchEvent(r5);
    L6:
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L27;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L29;
        if (this.bounceGestureDelegate.d(r5) == false) goto L29;
        return true;
    L18:
        if (this.bounceGestureDelegate.c(r5) == false) goto L29;
        return true;
    L21:
        if (this.clickDuringOverScrollDelegate.b(r5) == false) goto L24;
        return false;
    L24:
        if (this.bounceGestureDelegate.b(r5) == false) goto L29;
        this.bounceStoppedForTouch = false;
        return true;
    L31:
        if (stopBounceIfNeeded() == false) goto L33;
    L36:
        this.bounceStoppedForTouch = r2;
        this.bounceGestureDelegate.a(r5);
        boolean r1 = super.onInterceptTouchEvent(r5);
        if (this.clickDuringOverScrollDelegate.b(r5) == false) goto L39;
        return false;
    L39:
        return r1;
    L33:
        if (this.bounceStoppedForTouch == true) goto L36;
        r2 = false;
        goto L36
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        o.e(r5, "ev");
        int r0 = r5.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L30;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L25;
        if (r0 == 5) goto L18;
        if (r0 != 6) goto L38;
        if (this.bounceGestureDelegate.d(r5) == false) goto L38;
        return true;
    L38:
        return super.onTouchEvent(r5);
    L18:
        if (this.bounceGestureDelegate.c(r5) == false) goto L38;
        return true;
    L21:
        if (this.bounceGestureDelegate.f(r5) == false) goto L38;
        this.bounceStoppedForTouch = false;
        return true;
    L25:
        if (this.bounceGestureDelegate.g(r5) == false) goto L28;
        this.bounceStoppedForTouch = false;
        return true;
    L28:
        releaseStoppedBounceIfNeeded();
        goto L38
    L30:
        if (stopBounceIfNeeded() == false) goto L32;
    L33:
        r1 = true;
    L34:
        this.bounceStoppedForTouch = r1;
        if (this.bounceGestureDelegate.e(r5) == false) goto L38;
        return true;
    L32:
        if (this.bounceStoppedForTouch == false) goto L34;
        goto L33
    }

    private final void resetAbsListViewTouchMode() {
        Field r0 = this.touchModeField;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setInt(this, -1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r0 = computeVerticalScrollOffset();
        OverScroller r1 = getOverScrollerOrNull();
        if (r1 != null) goto L11;
    L23:
        float r2 = this.lastScrollerVelocity;
        if (r2 <= 0.0f) goto L38;
        boolean r3 = !canScrollList(-1);
        boolean r4 = true ^ canScrollList(1);
        int r5 = this.lastScrollDirection;
        if (r5 >= 0) goto L32;
        if (r3 == false) goto L32;
        BounceEdgeEffect r6 = this.bounceTop;
        if (r6 == null) goto L38;
        r6.onAbsorb((int) r2);
    L32:
        if (r5 <= 0) goto L38;
        if (r4 == false) goto L38;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 == null) goto L38;
        r7.onAbsorb(-((int) r2));
    L38:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = r0;
        return;
    L11:
        if (r1.isFinished() == true) goto L23;
        this.lastScrollerVelocity = r1.getCurrVelocity();
        int r8 = r0 - this.lastVerticalScrollOffset;
        if (r8 <= 0) goto L15;
        this.lastScrollDirection = 1;
    L17:
        com.obric.oui.bouncelayout.d r9 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L20;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingFrame", "offset=" + r0 + " delta=" + r8 + " velocity=" + this.lastScrollerVelocity + " direction=" + this.lastScrollDirection);
    L20:
        this.lastVerticalScrollOffset = r0;
        if (tryAbsorbRunningFlingAtEdge(r1, this.lastScrollerVelocity) == true) goto L22;
    L22:
        return;
    L15:
        if (r8 >= 0) goto L17;
        this.lastScrollDirection = -1;
        goto L17
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r9, float r10) {
        if (r10 > 0.0f) goto L5;
        return false;
    L5:
        boolean r1 = !canScrollList(-1);
        boolean r4 = !canScrollList(1);
        if (this.lastScrollDirection >= 0) goto L24;
        if (r1 == false) goto L24;
        BounceEdgeEffect r2 = this.bounceTop;
        if (r2 != null) goto L12;
    L10:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L24;
        com.obric.oui.bouncelayout.d r5 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L18;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbTop", o.a("velocity=", Float.valueOf(r10)));
    L18:
        BounceEdgeEffect r6 = this.bounceTop;
        if (r6 == null) goto L22;
        r6.onAbsorb((int) r10);
    L22:
        boolean r11 = true;
    L41:
        if (r11 == false) goto L43;
        r9.abortAnimation();
        removeCurrentFlingRunnable$default(this, null, 1, null);
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        invalidate();
    L43:
        return r11;
    L12:
        if (r2.isFinished() != true) goto L10;
        r3 = true;
    L24:
        if (this.lastScrollDirection <= 0) goto L40;
        if (r4 == false) goto L40;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == false) goto L40;
        com.obric.oui.bouncelayout.d r12 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L36;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbBottom", o.a("velocity=", Float.valueOf(r10)));
    L36:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L22;
        r13.onAbsorb(-((int) r10));
        goto L22
    L30:
        if (r7.isFinished() != true) goto L28;
        r8 = true;
    L40:
        r11 = false;
        goto L41
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        OverScroller r1 = getOverScrollerOrNull();
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 != null) goto L8;
        float r4 = 0.0f;
    L10:
        if (r4 != 0.0f) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L25;
        BounceEdgeEffect r6 = this.bounceBottom;
        if (r6 != null) goto L17;
        float r7 = 0.0f;
    L19:
        if (r7 != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L25;
        boolean r9 = false;
    L26:
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 != null) goto L30;
    L28:
        boolean r11 = false;
    L32:
        if (r11 == true) goto L42;
        BounceEdgeEffect r12 = this.bounceBottom;
        if (r12 != null) goto L37;
    L35:
        boolean r13 = false;
    L39:
        if (r13 == true) goto L42;
        boolean r14 = false;
    L43:
        if (r9 == true) goto L48;
        if (r14 == true) goto L48;
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = computeVerticalScrollOffset();
        return false;
    L48:
        if (r1 != null) goto L51;
    L49:
        boolean r15 = false;
    L53:
        if (r15 == false) goto L57;
        if (r1 == null) goto L57;
        r1.abortAnimation();
    L57:
        Runnable r2 = null;
        Field r16 = this.flingRunnableField;     // Catch: Throwable -> L66
        if (r16 != null) goto L61;
        Object r17 = null;
    L63:
        if (ZeusTransformUtils.instanceOf(r17, Runnable.class) == false) goto L67;
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(r17, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
    L67:
        removeCurrentFlingRunnable(r2);
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L71;
        r0.stopAnimationForTouch();
    L71:
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 == null) goto L75;
        r18.stopAnimationForTouch();
    L75:
        invalidate();
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = computeVerticalScrollOffset();
        return true;
    L61:
        r17 = r16.get(this);     // Catch: Throwable -> L66
    L66:
        r2 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.aiagent.plugin");
        goto L67
    L51:
        if (r1.isFinished() == true) goto L49;
        r15 = true;
        goto L53
    L37:
        if (r12.isFinished() == true) goto L35;
        r13 = true;
    L42:
        r14 = true;
        goto L43
    L30:
        if (r10.isFinished() == true) goto L28;
        r11 = true;
        goto L32
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = r6.getTranslation();
    L25:
        r9 = true;
        goto L26
    L12:
        r5 = false;
        goto L13
    L8:
        r4 = r3.getTranslation();
        goto L10
    }

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r0 = resolveStoppedBounceReleaseEdge();
        if (r0 != 0) goto L8;
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r0 != 1) goto L18;
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    private final int resolveStoppedBounceReleaseEdge() {
        boolean r0 = isBounceEffectActive(this.bounceTop);
        boolean r1 = isBounceEffectActive(this.bounceBottom);
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
    L25:
        return 0;
    L6:
        if (r1 == false) goto L9;
        if (r0 == true) goto L9;
        return 1;
    L9:
        BounceEdgeEffect r2 = this.bounceTop;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L25;
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 != null) goto L19;
        float r5 = 0.0f;
    L21:
        if (r5 < 0.0f) goto L27;
        return -1;
    L27:
        return 1;
    L19:
        r5 = r4.getTranslation();
        goto L21
    L12:
        r3 = r2.getTranslation();
        goto L14
    }

    private final boolean isBounceEffectActive(BounceEdgeEffect r4) {
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

    static /* synthetic */ void removeCurrentFlingRunnable$default(OGridView r2, Runnable r3, int r4, Object r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L7;
        r6 = null;
    L7:
        r2.removeCurrentFlingRunnable(r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCurrentFlingRunnable");
    }

    private final void removeCurrentFlingRunnable(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        r5 = null;
        Field r0 = this.flingRunnableField;     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        Object r1 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Runnable.class) == false) goto L14;
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        goto L14
    L8:
        r1 = r0.get(this);     // Catch: Throwable -> L13
    L13:
        r5 = (Runnable) ZeusTransformUtils.preCheckCast(null, Runnable.class, "com.obric.aiagent.plugin");
    L14:
        if (r5 == null) goto L19;
        removeCallbacks(r5);
        return;
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r2 = this.scrollerField;     // Catch: Throwable -> L32
        if (r2 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L11;
        OverScroller r4 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
    L12:
        if (r4 == null) goto L38;
        return r4;
    L11:
        r4 = null;
        goto L12
    L6:
        r3 = r2.get(this);     // Catch: Throwable -> L32
    L38:
        Field r5 = this.flingRunnableField;     // Catch: Throwable -> L33
        if (r5 == null) goto L19;
        Object r6 = r5.get(this);     // Catch: Throwable -> L33
    L20:
        if (r6 != null) goto L36;
        return null;
    L36:
        Field r7 = this.flingRunnableScrollerField;     // Catch: Throwable -> L30
        if (r7 != null) goto L25;
        Object r8 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, OverScroller.class) == false) goto L40;
        return (OverScroller) ZeusTransformUtils.preCheckCast(r8, OverScroller.class, "com.obric.aiagent.plugin");
    L40:
        return null;
    L25:
        r8 = r7.get(r6);     // Catch: Throwable -> L30
    L31:
        return (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.aiagent.plugin");
    L19:
        r6 = null;
        goto L20
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r3 = tryGetField(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L21
        if (r3 != null) goto L9;
        r3 = tryGetField(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L21
    L9:
        this.edgeFieldTop = r3;     // Catch: Throwable -> L21
        Field r4 = tryGetField(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L21
        if (r4 != null) goto L12;
        r4 = tryGetField(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L21
    L12:
        this.edgeFieldBottom = r4;     // Catch: Throwable -> L21
        this.scrollerField = tryGetField(AbsListView.class, "mScroller");     // Catch: Throwable -> L21
        Field r5 = tryGetField(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L21
        this.flingRunnableField = r5;     // Catch: Throwable -> L21
        if (r5 != null) goto L15;
    L14:
        Field r0 = null;
    L19:
        this.flingRunnableScrollerField = r0;     // Catch: Throwable -> L21
        this.touchModeField = tryGetField(AbsListView.class, "mTouchMode");     // Catch: Throwable -> L21
        return;
    L15:
        Class<?> r6 = r5.getType();     // Catch: Throwable -> L21
        if (r6 == null) goto L14;
        r0 = tryGetField(r6, "mScroller");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OGridView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
        this.flingRunnableField = null;
        this.flingRunnableScrollerField = null;
        this.touchModeField = null;
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OGridView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.aiagent.plugin");
    }

    private final void installBounceEdgeEffects() {
        Field r2 = this.edgeFieldTop;
        Field r3 = this.edgeFieldBottom;
        if (r2 == null) goto L24;
        if (r3 == null) goto L25;
    L19:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OGridView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        return;
    L7:
        if (this.originalTopEffect != null) goto L10;
        this.originalTopEffect = r2.get(this);     // Catch: Throwable -> L19
    L10:
        if (this.originalBottomEffect != null) goto L12;
        this.originalBottomEffect = r3.get(this);     // Catch: Throwable -> L19
    L12:
        this.overscrollDelegate.b();     // Catch: Throwable -> L19
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        o.c(r5, "context");     // Catch: Throwable -> L19
        BounceEdgeEffect r4 = new BounceEdgeEffect(r5, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0, this.overscrollDelegate.a());     // Catch: Throwable -> L19
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        o.c(r6, "context");     // Catch: Throwable -> L19
        BounceEdgeEffect r7 = new BounceEdgeEffect(r6, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1, this.overscrollDelegate.a());     // Catch: Throwable -> L19
        if (getWidth() > 0) goto L15;
    L17:
        r2.set(this, r4);     // Catch: Throwable -> L19
        r3.set(this, r7);     // Catch: Throwable -> L19
        this.bounceTop = r4;     // Catch: Throwable -> L19
        this.bounceBottom = r7;     // Catch: Throwable -> L19
        this.overscrollDelegate.c();     // Catch: Throwable -> L19
        this.translationDelegate.a();     // Catch: Throwable -> L19
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L19
        return;
    L15:
        if (getHeight() <= 0) goto L17;
        r4.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        r7.setSize(getWidth(), getHeight());     // Catch: Throwable -> L19
        goto L17
    L25:
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldTop;
        Field r1 = this.edgeFieldBottom;
        if (r0 != null) goto L29;
    L7:
        if (r1 == null) goto L19;
        Object r2 = this.originalBottomEffect;     // Catch: Throwable -> L12
        if (r2 == null) goto L19;
        r1.set(this, r2);     // Catch: Throwable -> L12
    L12:
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 == null) goto L16;
        r3.forceFinish$OUI_standardRelease();
    L16:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L27;
    L26:
        r4.forceFinish$OUI_standardRelease();
    L27:
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    L19:
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L23;
        r5.forceFinish$OUI_standardRelease();
    L23:
        r4 = this.bounceBottom;
        if (r4 != null) goto L26;
    L29:
        Object r6 = this.originalTopEffect;     // Catch: Throwable -> L12
        if (r6 == null) goto L7;
        r0.set(this, r6);     // Catch: Throwable -> L12
        goto L7
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.forceFinish$OUI_standardRelease();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
        if (r1 == null) goto L11;
        r1.forceFinish$OUI_standardRelease();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L7;
        float r1 = 0.0f;
    L8:
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 != null) goto L11;
        float r3 = 0.0f;
    L12:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L18:
        super.dispatchDraw(r4);
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r3 = r2.getTranslation();
        goto L12
    L7:
        r1 = r0.getTranslation();
        goto L8
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_bouncelayout_OGridView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
