package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OScrollView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OScrollView extends ScrollView {
    public static final a Companion = null;
    private static final int INVALID_POINTER_ID = -1;
    private static final int MANUAL_BOUNCE_BOTTOM = 2;
    private static final int MANUAL_BOUNCE_NONE = 0;
    private static final int MANUAL_BOUNCE_TOP = 1;
    public static final String TAG = "OScrollView";
    private BounceEdgeEffect bounceBottom;
    private boolean bounceStoppedForTouch;
    private BounceEdgeEffect bounceTop;
    private final com.obric.oui.bouncelayout.b clickDuringOverScrollDelegate;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private boolean flingBounceAbsorbed;
    private int lastScrollerScrollY;
    private float lastScrollerVelocity;
    private int manualBounceActiveEdge;
    private int manualBounceActivePointerId;
    private float manualBounceDownY;
    private boolean manualBounceDragging;
    private long manualBounceLastHandledEventTime;
    private float manualBounceLastY;
    private boolean manualBounceTouchActive;
    private VelocityTracker manualBounceVelocityTracker;
    private final int maximumFlingVelocity;
    private final int minimumFlingVelocity;
    private EdgeEffect originalBottomEffect;
    private EdgeEffect originalTopEffect;
    private final com.obric.oui.bouncelayout.e overscrollDelegate;
    private Field scrollerField;
    private final int touchSlop;
    private final com.obric.oui.bouncelayout.f translationDelegate;

    /* JADX INFO: compiled from: OScrollView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class b extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34126a;

        b(OScrollView r1) {
            this.f34126a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34126a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class c extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34127a;

        c(OScrollView r1) {
            this.f34127a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OScrollView.access$getBounceTop$p(this.f34127a), OScrollView.access$getBounceBottom$p(this.f34127a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class d extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MotionEvent f34129b;

        d(OScrollView r1, MotionEvent r2) {
            this.f34128a = r1;
            this.f34129b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(OScrollView.access$dispatchTouchEvent$s2059813682(this.f34128a, this.f34129b));
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class e extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34130a;

        e(OScrollView r1) {
            this.f34130a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f34130a.getHeight());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class f extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34131a;

        f(OScrollView r1) {
            this.f34131a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OScrollView.access$getBounceTop$p(this.f34131a), OScrollView.access$getBounceBottom$p(this.f34131a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class g extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34132a;

        g(OScrollView r1) {
            this.f34132a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34132a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OScrollView.kt */
    static final class h extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OScrollView f34133a;

        h(OScrollView r1) {
            this.f34133a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OScrollView.access$getBounceTop$p(this.f34133a), OScrollView.access$getBounceBottom$p(this.f34133a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public OScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    private final int resolveEdgeForUnconsumedScrollDelta(int r1) {
        if (r1 < 0) goto L9;
        if (r1 <= 0) goto L8;
        return 1;
    L8:
        return 0;
    L9:
        return 0;
    }

    public /* synthetic */ OScrollView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public static final /* synthetic */ boolean access$dispatchTouchEvent$s2059813682(OScrollView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OScrollView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OScrollView r0) {
        return r0.bounceTop;
    }

    public OScrollView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.touchSlop = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.minimumFlingVelocity = ViewConfiguration.get(r7).getScaledMinimumFlingVelocity();
        this.maximumFlingVelocity = ViewConfiguration.get(r7).getScaledMaximumFlingVelocity();
        this.manualBounceActivePointerId = -1;
        this.manualBounceLastHandledEventTime = -1;
        this.overscrollDelegate = new com.obric.oui.bouncelayout.e((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.translationDelegate = new com.obric.oui.bouncelayout.f((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.clickDuringOverScrollDelegate = new com.obric.oui.bouncelayout.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.a("Landroid/widget/ScrollView;");
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

    @Override // android.widget.ScrollView, android.view.View
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

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r2 = getScrollerOrNull();
        if (r2 != null) goto L8;
        return;
    L8:
        int r5 = getScrollRangeY();
        if (r5 > 0) goto L11;
        return;
    L11:
        int r0 = getScrollY();
        if (r2.isFinished() == true) goto L21;
        int r4 = this.lastScrollerScrollY;
        this.lastScrollerVelocity = r2.getCurrVelocity();
        com.obric.oui.bouncelayout.d r1 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L17;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingFrame", "y=" + r0 + " previousY=" + r4 + " range=" + r5 + " velocity=" + this.lastScrollerVelocity);
    L17:
        if (tryAbsorbRunningFlingAtEdge(r2, r0, r4, r5, this.lastScrollerVelocity) == false) goto L19;
        return;
    L19:
        this.lastScrollerScrollY = r0;
        return;
    L21:
        float r3 = this.lastScrollerVelocity;
        if (r3 <= 0.0f) goto L57;
        boolean r7 = true;
        if (r0 == 0) goto L26;
    L41:
        if (r0 != r5) goto L57;
        if (this.lastScrollerScrollY >= r5) goto L57;
        BounceEdgeEffect r6 = this.bounceBottom;
        if (r6 != null) goto L48;
    L46:
        r7 = false;
    L49:
        if (r7 == false) goto L57;
        com.obric.oui.bouncelayout.d r8 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L53;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbBottomFinished", o.a("velocity=", Float.valueOf(r3)));
    L53:
        BounceEdgeEffect r9 = this.bounceBottom;
        if (r9 == null) goto L57;
        r9.onAbsorb(-((int) r3));
        goto L57
    L48:
        if (r6.isFinished() != true) goto L46;
    L26:
        if (this.lastScrollerScrollY <= 0) goto L41;
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 != null) goto L31;
    L29:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L41;
        com.obric.oui.bouncelayout.d r12 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L37;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbTopFinished", o.a("velocity=", Float.valueOf(r3)));
    L37:
        BounceEdgeEffect r13 = this.bounceTop;
        if (r13 == null) goto L57;
        r13.onAbsorb((int) r3);
        goto L57
    L31:
        if (r10.isFinished() != true) goto L29;
        r11 = true;
    L57:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollerScrollY = r0;
        this.flingBounceAbsorbed = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        o.e(r6, "ev");
        this.clickDuringOverScrollDelegate.a(r6);
        com.obric.oui.bouncelayout.b r0 = this.clickDuringOverScrollDelegate;
        Boolean r1 = r0.a(r6, 0.0f, -r0.b(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
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

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        o.e(r7, "ev");
        int r0 = r7.getActionMasked();
        boolean r3 = true;
        if (r0 == 0) goto L36;
        if (r0 != 1) goto L6;
    L29:
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = -1;
        this.manualBounceLastHandledEventTime = -1;
        recycleManualBounceVelocityTracker();
        releaseStoppedBounceIfNeeded();
    L31:
        if (this.clickDuringOverScrollDelegate.b(r7) == false) goto L34;
        return false;
    L34:
        return super.onInterceptTouchEvent(r7);
    L6:
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L29;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L31;
        if (this.manualBounceTouchActive == false) goto L31;
        handleManualBouncePointerUp(r7);
        return true;
    L19:
        if (this.manualBounceTouchActive == false) goto L31;
        updateManualBounceActivePointer(r7.getActionIndex(), r7);
        return true;
    L23:
        if (this.clickDuringOverScrollDelegate.b(r7) == false) goto L26;
        return false;
    L26:
        if (tryStartManualBounceFromMove(r7) == false) goto L31;
        this.bounceStoppedForTouch = false;
        return true;
    L36:
        if (stopBounceIfNeeded() == false) goto L38;
    L41:
        this.bounceStoppedForTouch = r3;
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r7.getPointerId(0);
        float r1 = r7.getY(0);
        this.manualBounceDownY = r1;
        this.manualBounceLastY = r1;
        this.manualBounceLastHandledEventTime = -1;
        initOrResetManualBounceVelocityTracker();
        addManualBounceMovement(r7);
        boolean r2 = super.onInterceptTouchEvent(r7);
        if (this.clickDuringOverScrollDelegate.b(r7) == false) goto L44;
        return false;
    L44:
        return r2;
    L38:
        if (this.bounceStoppedForTouch == true) goto L41;
        r3 = false;
        goto L41
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        o.e(r8, "ev");
        int r0 = r8.getActionMasked();
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == 0) goto L50;
        if (r0 == 1) goto L45;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L45;
        if (r0 == 5) goto L19;
        if (r0 != 6) goto L57;
        if (this.manualBounceTouchActive == false) goto L57;
        handleManualBouncePointerUp(r8);
        return true;
    L57:
        return super.onTouchEvent(r8);
    L19:
        if (this.manualBounceTouchActive == false) goto L57;
        updateManualBounceActivePointer(r8.getActionIndex(), r8);
        return true;
    L23:
        if (this.manualBounceTouchActive == false) goto L41;
        if (r8.getEventTime() != this.manualBounceLastHandledEventTime) goto L27;
        return true;
    L27:
        int r3 = r8.findPointerIndex(this.manualBounceActivePointerId);
        if (r3 >= 0) goto L31;
        releaseManualBounce();
        return true;
    L31:
        float r4 = r8.getY(r3);
        float r5 = r4 - this.manualBounceLastY;
        if (this.manualBounceDragging == true) goto L34;
    L38:
        this.manualBounceLastY = r4;
        return true;
    L34:
        if (r5 != 0.0f) goto L36;
        r1 = true;
    L36:
        if (r1 == true) goto L38;
        addManualBounceMovement(r8);
        pullManualBounce(r5);
        goto L38
    L41:
        if (tryStartManualBounceFromMove(r8) == false) goto L57;
        this.bounceStoppedForTouch = false;
        return true;
    L45:
        if (this.manualBounceTouchActive == false) goto L48;
        addManualBounceMovement(r8);
        releaseManualBounce();
        return true;
    L48:
        releaseStoppedBounceIfNeeded();
        recycleManualBounceVelocityTracker();
        goto L57
    L50:
        if (stopBounceIfNeeded() == false) goto L52;
    L55:
        this.bounceStoppedForTouch = r2;
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r8.getPointerId(0);
        float r6 = r8.getY(0);
        this.manualBounceDownY = r6;
        this.manualBounceLastY = r6;
        this.manualBounceLastHandledEventTime = -1;
        initOrResetManualBounceVelocityTracker();
        addManualBounceMovement(r8);
        goto L57
    L52:
        if (this.bounceStoppedForTouch == true) goto L55;
        r2 = false;
        goto L55
    }

    private final void updateManualBounceActivePointer(int r2, MotionEvent r3) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= r3.getPointerCount()) goto L9;
        this.manualBounceActivePointerId = r3.getPointerId(r2);
        this.manualBounceLastY = r3.getY(r2);
        return;
    }

    private final void handleManualBouncePointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 < r4.getPointerCount()) goto L8;
        return;
    L8:
        if (r4.getPointerId(r0) == this.manualBounceActivePointerId) goto L10;
        return;
    L10:
        if (r0 != 0) goto L12;
        int r1 = 1;
    L14:
        if (r1 >= r4.getPointerCount()) goto L16;
        updateManualBounceActivePointer(r1, r4);
        return;
    L16:
        this.manualBounceActivePointerId = -1;
        return;
    L12:
        r1 = 0;
        goto L14
    }

    private final void initOrResetManualBounceVelocityTracker() {
        VelocityTracker r0 = this.manualBounceVelocityTracker;
        if (r0 != null) goto L5;
        this.manualBounceVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private final void addManualBounceMovement(MotionEvent r1) {
        VelocityTracker r0 = this.manualBounceVelocityTracker;
        if (r0 == null) goto L7;
        r0.addMovement(r1);
        return;
    }

    private final void recycleManualBounceVelocityTracker() {
        VelocityTracker r0 = this.manualBounceVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.manualBounceVelocityTracker = null;
    }

    @Override // android.view.View
    public boolean overScrollBy(int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, boolean r15) {
        boolean r16 = super.overScrollBy(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        if (r15 == false) goto L5;
    L57:
        return r16;
    L5:
        if (this.edgeEffectsInstalled == false) goto L57;
        if (r12 <= 0) goto L57;
        int r17 = r10 + r8;
        com.obric.oui.bouncelayout.d r18 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L10;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "overScrollFlingFrame", "scrollY=" + r10 + " deltaY=" + r8 + " finalScrollY=" + r17 + " range=" + r12);
    L10:
        boolean r19 = false;
        if (r17 > 0) goto L34;
        if (r8 >= 0) goto L34;
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 != null) goto L17;
    L15:
        boolean r2 = false;
    L19:
        if (r2 == false) goto L34;
        float r3 = getCurrentFlingVelocity();
        int r4 = Math.abs(r17);
        if (getHeight() <= 0) goto L26;
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L26;
        r5.onPull(r4 / getHeight(), 0.5f);
    L26:
        com.obric.oui.bouncelayout.d r6 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L29;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbTop", "velocity=" + r3 + " overscroll=" + r4);
    L29:
        BounceEdgeEffect r20 = this.bounceTop;
        if (r20 == null) goto L33;
        r20.onAbsorb((int) r3);
    L33:
        abortCurrentFling();
        goto L34
    L17:
        if (r1.isFinished() != true) goto L15;
        r2 = true;
    L34:
        if (r17 < r12) goto L57;
        if (r8 <= 0) goto L57;
        BounceEdgeEffect r21 = this.bounceBottom;
        if (r21 != null) goto L40;
    L42:
        if (r19 == false) goto L57;
        float r22 = getCurrentFlingVelocity();
        int r23 = r17 - r12;
        if (getHeight() <= 0) goto L49;
        BounceEdgeEffect r110 = this.bounceBottom;
        if (r110 == null) goto L49;
        r110.onPull(r23 / getHeight(), 0.5f);
    L49:
        com.obric.oui.bouncelayout.d r111 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L52;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbBottom", "velocity=" + r22 + " overscroll=" + r23);
    L52:
        BounceEdgeEffect r24 = this.bounceBottom;
        if (r24 == null) goto L56;
        r24.onAbsorb(-((int) r22));
    L56:
        abortCurrentFling();
        goto L57
    L40:
        if (r21.isFinished() != true) goto L42;
        r19 = true;
        goto L42
    }

    private final boolean shouldHandleManualBounce() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        if (getHeight() > 0) goto L8;
        return false;
    L8:
        if (getScrollRangeY() > 0) goto L11;
        return true;
    L11:
        if (isBounceEffectActive(this.bounceTop) == true) goto L15;
        if (isBounceEffectActive(this.bounceBottom) == true) goto L15;
        return false;
    L15:
        return true;
    }

    private final boolean shouldStartManualBounce(float r4) {
        if (Math.abs(r4) > this.touchSlop) goto L6;
        return false;
    L6:
        if (isBounceEffectActive(this.bounceTop) == false) goto L8;
    L19:
        return true;
    L8:
        if (isBounceEffectActive(this.bounceBottom) == true) goto L19;
        if (r4 <= 0.0f) goto L16;
        if (canScrollVertically(-1) == false) goto L18;
        return false;
    L18:
        return true;
    L16:
        if (canScrollVertically(1) == false) goto L18;
        return false;
    }

    private final boolean tryStartManualBounceFromMove(MotionEvent r7) {
        if (shouldHandleManualBounce() == true) goto L5;
        return false;
    L5:
        int r0 = r7.findPointerIndex(this.manualBounceActivePointerId);
        if (r0 >= 0) goto L8;
        return false;
    L8:
        addManualBounceMovement(r7);
        float r1 = r7.getY(r0);
        float r2 = r1 - this.manualBounceDownY;
        if (shouldStartManualBounce(r2) == true) goto L11;
        return false;
    L11:
        stopBounceIfNeeded();
        com.obric.oui.bouncelayout.d r3 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L14;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "manualBounceStart", "dy=" + r2 + " translation=" + getBounceTranslation() + " scrollY=" + getScrollY() + " range=" + getScrollRangeY());
    L14:
        this.manualBounceTouchActive = true;
        this.manualBounceDragging = true;
        this.bounceStoppedForTouch = false;
        float r4 = this.manualBounceDownY;
        this.manualBounceLastY = r4;
        pullManualBounce(r1 - r4);
        this.manualBounceLastY = r1;
        this.manualBounceLastHandledEventTime = r7.getEventTime();
        ViewParent r6 = getParent();
        if (r6 == null) goto L18;
        r6.requestDisallowInterceptTouchEvent(true);
    L18:
        return true;
    }

    private final void pullManualBounce(float r7) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r0 = r7 / getHeight();
        boolean r1 = isBounceEffectActive(this.bounceTop);
        boolean r2 = isBounceEffectActive(this.bounceBottom);
        if (r1 == false) goto L17;
        this.manualBounceActiveEdge = 1;
        BounceEdgeEffect r8 = this.bounceTop;
        if (r8 != null) goto L10;
        float r9 = 0.0f;
    L11:
        float r3 = r0 - r9;
        if (r3 >= 0.0f) goto L15;
        pullBottomOrScrollContent(d.i.a.a((-r3) * getHeight()));
    L34:
        invalidate();
        return;
    L15:
        if (isBounceEffectActive(this.bounceTop) == true) goto L34;
        this.manualBounceActiveEdge = 0;
        goto L34
    L10:
        r9 = r8.onPullDistance(r0, 0.5f);
        goto L11
    L17:
        if (r2 == false) goto L29;
        this.manualBounceActiveEdge = 2;
        float r10 = -r0;
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 != null) goto L21;
        float r5 = 0.0f;
    L22:
        float r11 = r10 - r5;
        if (r11 >= 0.0f) goto L26;
        pullTopOrScrollContent(d.i.a.a(r11 * getHeight()));
        goto L34
    L26:
        if (isBounceEffectActive(this.bounceBottom) == true) goto L34;
        this.manualBounceActiveEdge = 0;
        goto L34
    L21:
        r5 = r4.onPullDistance(r10, 0.5f);
        goto L22
    L29:
        if (r7 <= 0.0f) goto L32;
        pullEdgeForUnconsumedScrollDelta(d.i.a.a(-r7));
        goto L34
    L32:
        if (r7 >= 0.0f) goto L34;
        pullEdgeForUnconsumedScrollDelta(d.i.a.a(-r7));
        goto L34
    }

    private final void pullBottomOrScrollContent(int r4) {
        int r0 = consumeScrollDeltaY(r4);
        logManualContentScroll(1, r4, r0);
        if (r0 <= 0) goto L11;
        if (getHeight() <= 0) goto L11;
        this.manualBounceActiveEdge = 2;
        logManualDirectReverse(1, r4, r0);
        BounceEdgeEffect r5 = this.bounceBottom;
        if (r5 == null) goto L16;
        r5.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease(r0 / getHeight());
        return;
    L16:
        return;
    L11:
        if (isBounceEffectActive(this.bounceTop) == true) goto L15;
        this.manualBounceActiveEdge = 0;
        return;
    }

    private final void pullTopOrScrollContent(int r4) {
        int r0 = consumeScrollDeltaY(r4);
        logManualContentScroll(0, r4, r0);
        if (r0 >= 0) goto L11;
        if (getHeight() <= 0) goto L11;
        this.manualBounceActiveEdge = 1;
        logManualDirectReverse(0, r4, r0);
        BounceEdgeEffect r5 = this.bounceTop;
        if (r5 == null) goto L16;
        r5.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease((-r0) / getHeight());
        return;
    L16:
        return;
    L11:
        if (isBounceEffectActive(this.bounceBottom) == true) goto L15;
        this.manualBounceActiveEdge = 0;
        return;
    }

    private final void pullEdgeForUnconsumedScrollDelta(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        if (getHeight() <= 0) goto L26;
        int r0 = consumeScrollDeltaY(r5);
        logManualContentScroll(resolveEdgeForUnconsumedScrollDelta(r0), r5, r0);
        if (r0 < 0) goto L9;
    L14:
        if (r0 > 0) goto L16;
    L21:
        this.manualBounceActiveEdge = 0;
        return;
    L16:
        if (getHeight() <= 0) goto L21;
        this.manualBounceActiveEdge = 2;
        logManualDirectReverse(1, r5, r0);
        BounceEdgeEffect r6 = this.bounceBottom;
        if (r6 == null) goto L28;
        r6.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease(r0 / getHeight());
        return;
    L28:
        return;
    L9:
        if (getHeight() <= 0) goto L14;
        this.manualBounceActiveEdge = 1;
        logManualDirectReverse(0, r5, r0);
        BounceEdgeEffect r7 = this.bounceTop;
        if (r7 == null) goto L27;
        r7.onPullDistanceAfterContentScrollExhausted$OUI_standardRelease((-r0) / getHeight());
        return;
    L27:
        return;
    }

    private final void logManualContentScroll(int r3, int r4, int r5) {
        com.obric.oui.bouncelayout.d r0 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L6;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "bounceDragContentScroll", "oppositeEdge=" + r3 + " scrollDeltaY=" + r4 + " consumed=" + (r4 - r5) + " unconsumed=" + r5);
        return;
    }

    private final void logManualDirectReverse(int r3, int r4, int r5) {
        com.obric.oui.bouncelayout.d r0 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L6;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "bounceDragDirectReverse", "edge=" + r3 + " scrollDeltaY=" + r4 + " unconsumed=" + r5);
        return;
    }

    private final int consumeScrollDeltaY(int r3) {
        if (r3 != 0) goto L4;
        return r3;
    L4:
        if (getScrollRangeY() <= 0) goto L9;
        int r0 = getScrollY();
        scrollBy(0, r3);
        return r3 - (getScrollY() - r0);
    L9:
        return r3;
    }

    private final void releaseManualBounce() {
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        int r1 = getManualBounceContentVelocityY();
        int r2 = resolveManualBounceReleaseEdge();
        this.manualBounceActivePointerId = -1;
        this.manualBounceLastHandledEventTime = -1;
        this.bounceStoppedForTouch = false;
        com.obric.oui.bouncelayout.d r3 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L5;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "manualBounceRelease", "translation=" + getBounceTranslation() + " range=" + getScrollRangeY() + " activeEdge=" + this.manualBounceActiveEdge + " velocityY=" + r1);
    L5:
        finishManualBounceGesture(r2, r1);
        this.manualBounceActiveEdge = 0;
        recycleManualBounceVelocityTracker();
        invalidate();
    }

    private final int getManualBounceContentVelocityY() {
        int r0 = this.manualBounceActivePointerId;
        VelocityTracker r1 = this.manualBounceVelocityTracker;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != (-1)) goto L8;
        return 0;
    L8:
        r1.computeCurrentVelocity(1000, this.maximumFlingVelocity);
        float r2 = r1.getYVelocity(r0);
        if (Math.abs(r2) >= this.minimumFlingVelocity) goto L12;
        return 0;
    L12:
        return d.i.a.a(-r2);
    }

    private final void finishManualBounceGesture(int r5, int r6) {
        if (r6 == 0) goto L42;
        if (r5 != 1) goto L11;
        if (r6 >= 0) goto L11;
        BounceEdgeEffect r4 = this.bounceTop;
        if (r4 == null) goto L54;
        r4.onAbsorb(r6);
        return;
    L54:
        return;
    L11:
        if (r5 != 2) goto L18;
        if (r6 <= 0) goto L18;
        BounceEdgeEffect r7 = this.bounceBottom;
        if (r7 == null) goto L55;
        r7.onAbsorb(r6);
        return;
    L55:
        return;
    L18:
        if (r6 > 0) goto L20;
    L23:
        if (r6 < 0) goto L25;
    L28:
        if (r5 != 0) goto L35;
        if (r6 <= 0) goto L35;
        BounceEdgeEffect r8 = this.bounceBottom;
        if (r8 == null) goto L56;
        r8.onAbsorb(r6);
        return;
    L56:
        return;
    L35:
        if (r5 != 0) goto L42;
        if (r6 >= 0) goto L42;
        BounceEdgeEffect r9 = this.bounceTop;
        if (r9 == null) goto L57;
        r9.onAbsorb(r6);
        return;
    L57:
        return;
    L25:
        if (canScrollVertically(-1) == false) goto L28;
        startContentFling(r6, -1);
        return;
    L20:
        if (canScrollVertically(1) == false) goto L23;
        startContentFling(r6, 1);
        return;
    L42:
        if (r5 == 1) goto L49;
        if (r5 != 2) goto L59;
        BounceEdgeEffect r10 = this.bounceBottom;
        if (r10 == null) goto L60;
        r10.onRelease();
        return;
    L60:
        return;
    L59:
        return;
    L49:
        BounceEdgeEffect r11 = this.bounceTop;
        if (r11 == null) goto L61;
        r11.onRelease();
        return;
    }

    private final void startContentFling(int r4, int r5) {
        this.lastScrollerScrollY = getScrollY();
        this.lastScrollerVelocity = Math.abs(r4);
        this.flingBounceAbsorbed = false;
        com.obric.oui.bouncelayout.d r0 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L5;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "bounceDragContentFling", "velocityY=" + r4 + " direction=" + r5);
    L5:
        fling(r4);
        postInvalidateOnAnimation();
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

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r0 = resolveManualBounceReleaseEdge();
        if (r0 != 1) goto L8;
        BounceEdgeEffect r1 = this.bounceTop;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r0 != 2) goto L18;
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    private final int resolveManualBounceReleaseEdge() {
        int r0 = this.manualBounceActiveEdge;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        boolean r1 = isBounceEffectActive(this.bounceTop);
        boolean r2 = isBounceEffectActive(this.bounceBottom);
        if (r1 == false) goto L9;
        if (r2 == true) goto L9;
    L28:
        return 1;
    L9:
        if (r2 == false) goto L12;
        if (r1 == true) goto L12;
        return 2;
    L12:
        BounceEdgeEffect r3 = this.bounceTop;
        if (r3 != null) goto L15;
        float r4 = 0.0f;
    L17:
        if (r4 > 0.0f) goto L28;
        BounceEdgeEffect r5 = this.bounceBottom;
        if (r5 != null) goto L22;
        float r6 = 0.0f;
    L24:
        if (r6 < 0.0f) goto L30;
        return 0;
    L30:
        return 2;
    L22:
        r6 = r5.getTranslation();
        goto L24
    L15:
        r4 = r3.getTranslation();
        goto L17
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

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        BounceEdgeEffect r3 = this.bounceBottom;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        BounceEdgeEffect r7 = this.bounceTop;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        BounceEdgeEffect r9 = this.bounceBottom;
        if (r9 != null) goto L37;
    L35:
        boolean r10 = false;
    L39:
        if (r10 == true) goto L42;
        boolean r11 = false;
    L43:
        if (r6 == true) goto L47;
        if (r11 == true) goto L47;
        return false;
    L47:
        abortCurrentFling();
        BounceEdgeEffect r12 = this.bounceTop;
        if (r12 == null) goto L51;
        r12.stopAnimationForTouch();
    L51:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L55;
        r13.stopAnimationForTouch();
    L55:
        invalidate();
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollerScrollY = getScrollY();
        this.flingBounceAbsorbed = false;
        return true;
    L37:
        if (r9.isFinished() == true) goto L35;
        r10 = true;
    L42:
        r11 = true;
        goto L43
    L30:
        if (r7.isFinished() == true) goto L28;
        r8 = true;
        goto L32
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = r3.getTranslation();
    L25:
        r6 = true;
        goto L26
    L12:
        r2 = false;
        goto L13
    L8:
        r1 = r0.getTranslation();
        goto L10
    }

    private final int getScrollRangeY() {
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return 0;
    L5:
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r1.getHeight() - r2);
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

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.forceFinish$OUI_standardRelease();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
        if (r1 == null) goto L10;
        r1.forceFinish$OUI_standardRelease();
    L10:
        restoreOriginalEdgeEffects();
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r1 = tryGetField(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        r1 = tryGetField(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L14
    L9:
        this.edgeFieldTop = r1;     // Catch: Throwable -> L14
        Field r2 = tryGetField(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        r2 = tryGetField(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L14
    L12:
        this.edgeFieldBottom = r2;     // Catch: Throwable -> L14
        this.scrollerField = tryGetField(ScrollView.class, "mScroller");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L36;
        this.overscrollDelegate.b();
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
        this.originalTopEffect = r6;     // Catch: Throwable -> L30
        Object r7 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r7, EdgeEffect.class) == false) goto L22;
        EdgeEffect r8 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r7, EdgeEffect.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L23:
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
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L30
        this.overscrollDelegate.c();     // Catch: Throwable -> L30
        this.translationDelegate.a();     // Catch: Throwable -> L30
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
        INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final float getCurrentFlingVelocity() {
        OverScroller r3 = getScrollerOrNull();     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return 1000.0f;
    L6:
        return r3.getCurrVelocity();
    L8:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    private final OverScroller getScrollerOrNull() {
        Field r2 = this.scrollerField;     // Catch: Throwable -> L11
        if (r2 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L15;
        return (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    L6:
        r3 = r2.get(this);     // Catch: Throwable -> L11
    L12:
        return (OverScroller) ZeusTransformUtils.preCheckCast(null, OverScroller.class, "com.obric.aiagent.plugin");
    }

    private final void abortCurrentFling() {
        OverScroller r0 = getScrollerOrNull();     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.abortAnimation();     // Catch: Throwable -> L7
        return;
    L10:
        return;
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
        INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to restore original edge effects", th);
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect edge effect fields", th);
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_bouncelayout_OScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
