package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ONestedScrollView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ONestedScrollView extends NestedScrollView {
    public static final a Companion = null;
    public static final String TAG = "ONestedScrollView";
    private BounceEdgeEffect bounceBottom;
    private BounceEdgeEffect bounceTop;
    private final com.obric.oui.bouncelayout.b clickDuringOverScrollDelegate;
    private float downX;
    private float downY;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private boolean flingBounceAbsorbed;
    private Boolean isHorizontalGesture;
    private int lastScrollerScrollY;
    private float lastScrollerVelocity;
    private EdgeEffect originalBottomEffect;
    private EdgeEffect originalTopEffect;
    private final com.obric.oui.bouncelayout.e overscrollDelegate;
    private Field scrollerField;
    private final int touchSlop;
    private final com.obric.oui.bouncelayout.f translationDelegate;

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class b extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34118a;

        b(ONestedScrollView r1) {
            this.f34118a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34118a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class c extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34119a;

        c(ONestedScrollView r1) {
            this.f34119a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{ONestedScrollView.access$getBounceTop$p(this.f34119a), ONestedScrollView.access$getBounceBottom$p(this.f34119a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class d extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MotionEvent f34121b;

        d(ONestedScrollView r1, MotionEvent r2) {
            this.f34120a = r1;
            this.f34121b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(ONestedScrollView.access$handleDispatchTouchEvent(this.f34120a, this.f34121b));
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class e extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34122a;

        e(ONestedScrollView r1) {
            this.f34122a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f34122a.getHeight());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class f extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34123a;

        f(ONestedScrollView r1) {
            this.f34123a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{ONestedScrollView.access$getBounceTop$p(this.f34123a), ONestedScrollView.access$getBounceBottom$p(this.f34123a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class g extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34124a;

        g(ONestedScrollView r1) {
            this.f34124a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34124a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    static final class h extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ONestedScrollView f34125a;

        h(ONestedScrollView r1) {
            this.f34125a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{ONestedScrollView.access$getBounceTop$p(this.f34125a), ONestedScrollView.access$getBounceBottom$p(this.f34125a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public ONestedScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ONestedScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public /* synthetic */ ONestedScrollView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(ONestedScrollView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(ONestedScrollView r0) {
        return r0.bounceTop;
    }

    public static final /* synthetic */ boolean access$handleDispatchTouchEvent(ONestedScrollView r0, MotionEvent r1) {
        return r0.handleDispatchTouchEvent(r1);
    }

    public ONestedScrollView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.touchSlop = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.overscrollDelegate = new com.obric.oui.bouncelayout.e((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.translationDelegate = new com.obric.oui.bouncelayout.f((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.clickDuringOverScrollDelegate = new com.obric.oui.bouncelayout.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.a("Landroidx/core/widget/NestedScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        o.e(r6, "event");
        this.clickDuringOverScrollDelegate.a(r6);
        com.obric.oui.bouncelayout.b r0 = this.clickDuringOverScrollDelegate;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r1 != null) goto L6;
        return handleDispatchTouchEvent(r6);
    L6:
        return r1.booleanValue();
    }

    private final boolean handleDispatchTouchEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 == 0) goto L19;
        boolean r2 = true;
        if (r0 != 1) goto L7;
        this.isHorizontalGesture = null;
    L21:
        return super.dispatchTouchEvent(r6);
    L7:
        if (r0 != 2) goto L21;
        if (this.isHorizontalGesture != null) goto L21;
        float r1 = Math.abs(r6.getX() - this.downX);
        float r3 = Math.abs(r6.getY() - this.downY);
        if (Math.max(r1, r3) <= this.touchSlop) goto L21;
        if (r1 > r3) goto L17;
        r2 = false;
    L17:
        this.isHorizontalGesture = Boolean.valueOf(r2);
        goto L21
    L19:
        this.downX = r6.getX();
        this.downY = r6.getY();
        this.isHorizontalGesture = null;
        goto L21
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        o.e(r4, "event");
        if (r4.getActionMasked() != 0) goto L9;
        boolean r0 = super.onInterceptTouchEvent(r4);
        if (this.clickDuringOverScrollDelegate.b(r4) == false) goto L7;
        return false;
    L7:
        return r0;
    L9:
        if (o.a(this.isHorizontalGesture, true) == false) goto L12;
        return false;
    L12:
        if (this.clickDuringOverScrollDelegate.b(r4) == false) goto L14;
        return false;
    L14:
        boolean r5 = super.onInterceptTouchEvent(r4);
        if (r5 == false) goto L17;
        this.isHorizontalGesture = false;
    L17:
        return r5;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r1 = null;
        Field r2 = this.scrollerField;     // Catch: Throwable -> L14
        if (r2 != null) goto L9;
        Object r3 = null;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L15;
        r1 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L15:
        OverScroller r4 = r1;
        if (r4 != null) goto L18;
        return;
    L18:
        int r6 = getScrollRangeY();
        if (r6 > 0) goto L21;
        return;
    L21:
        int r5 = getScrollY();
        if (r4.isFinished() == true) goto L31;
        int r7 = this.lastScrollerScrollY;
        this.lastScrollerVelocity = r4.getCurrVelocity();
        com.obric.oui.bouncelayout.d r8 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L27;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingFrame", "y=" + r5 + " previousY=" + r7 + " range=" + r6 + " velocity=" + this.lastScrollerVelocity);
    L27:
        if (tryAbsorbRunningFlingAtEdge(r4, r5, r7, r6, this.lastScrollerVelocity) == false) goto L29;
        return;
    L29:
        this.lastScrollerScrollY = r5;
        return;
    L31:
        float r9 = this.lastScrollerVelocity;
        if (r9 > 0.0f) goto L34;
    L54:
        this.lastScrollerVelocity = 0.0f;
        this.flingBounceAbsorbed = false;
        return;
    L34:
        if (r5 == 0) goto L36;
    L44:
        if (r5 != r6) goto L54;
        if (this.lastScrollerScrollY >= r6) goto L54;
        com.obric.oui.bouncelayout.d r10 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L50;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbBottomFinished", o.a("velocity=", Float.valueOf(r9)));
    L50:
        BounceEdgeEffect r0 = this.bounceBottom;
        if (r0 == null) goto L54;
        r0.onAbsorb(-((int) r9));
        goto L54
    L36:
        if (this.lastScrollerScrollY <= 0) goto L44;
        com.obric.oui.bouncelayout.d r11 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L40;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbTopFinished", o.a("velocity=", Float.valueOf(r9)));
    L40:
        BounceEdgeEffect r12 = this.bounceTop;
        if (r12 == null) goto L54;
        r12.onAbsorb((int) r9);
        goto L54
    L9:
        r3 = r2.get(this);     // Catch: Throwable -> L14
    L14:
        r1 = (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.aiagent.plugin");
        goto L15
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r7, int r8, int r9, int r10, float r11) {
        boolean r1 = false;
        if (this.flingBounceAbsorbed == false) goto L5;
    L43:
        return r1;
    L5:
        if (r11 <= 0.0f) goto L43;
        if (r8 != 0) goto L25;
        if (r9 <= 0) goto L25;
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 != null) goto L14;
    L12:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L25;
        com.obric.oui.bouncelayout.d r12 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L20;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbTop", o.a("velocity=", Float.valueOf(r11)));
    L20:
        BounceEdgeEffect r13 = this.bounceTop;
        if (r13 == null) goto L24;
        r13.onAbsorb((int) r11);
    L24:
        r1 = true;
    L41:
        if (r1 == false) goto L43;
        this.flingBounceAbsorbed = true;
        r7.abortAnimation();
        this.lastScrollerVelocity = 0.0f;
        invalidate();
        goto L43
    L14:
        if (r5.isFinished() != true) goto L12;
        r6 = true;
    L25:
        if (r8 != r10) goto L41;
        if (r9 >= r10) goto L41;
        BounceEdgeEffect r14 = this.bounceBottom;
        if (r14 != null) goto L31;
    L29:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L41;
        com.obric.oui.bouncelayout.d r16 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L37;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbBottom", o.a("velocity=", Float.valueOf(r11)));
    L37:
        BounceEdgeEffect r17 = this.bounceBottom;
        if (r17 == null) goto L24;
        r17.onAbsorb(-((int) r11));
        goto L24
    L31:
        if (r14.isFinished() != true) goto L29;
        r15 = true;
        goto L33
    }

    @Override // android.view.ViewGroup, android.view.View
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.forceFinish$OUI_standardRelease();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
        if (r1 == null) goto L10;
        r1.forceFinish$OUI_standardRelease();
    L10:
        restoreOriginalEdgeEffects();
        super.onDetachedFromWindow();
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r1 = tryGetField(NestedScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = tryGetField(NestedScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.edgeFieldTop = r1;     // Catch: Throwable -> L14
        Field r2 = tryGetField(NestedScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = tryGetField(NestedScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.edgeFieldBottom = r2;     // Catch: Throwable -> L14
        this.scrollerField = tryGetField(NestedScrollView.class, "mScroller");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_ONestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L36;
        Field r1 = this.edgeFieldTop;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldBottom;
        if (r2 != null) goto L33;
        return;
    L33:
        Object r5 = r1.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r5, EdgeEffect.class) == false) goto L18;
        EdgeEffect r6 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r5, EdgeEffect.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L19:
        Object r7 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r7, EdgeEffect.class) == false) goto L22;
        EdgeEffect r8 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r7, EdgeEffect.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L23:
        this.originalTopEffect = r6;     // Catch: Throwable -> L30
        this.originalBottomEffect = r8;     // Catch: Throwable -> L30
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        o.c(r9, "context");     // Catch: Throwable -> L30
        BounceEdgeEffect r10 = new BounceEdgeEffect(r9, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 0, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        o.c(r11, "context");     // Catch: Throwable -> L30
        BounceEdgeEffect r12 = new BounceEdgeEffect(r11, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r1.set(this, r10);     // Catch: Throwable -> L30
        r2.set(this, r12);     // Catch: Throwable -> L30
        this.bounceTop = r10;     // Catch: Throwable -> L30
        this.bounceBottom = r12;     // Catch: Throwable -> L30
        this.overscrollDelegate.c();     // Catch: Throwable -> L30
        this.translationDelegate.a();     // Catch: Throwable -> L30
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r10.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r12.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L22:
        r8 = null;
        goto L23
    L18:
        r6 = null;
    L30:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_ONestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldTop;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.originalTopEffect);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.edgeFieldBottom;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.originalBottomEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_ONestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to restore original edge effects", th);
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_ONestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_bouncelayout_ONestedScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
