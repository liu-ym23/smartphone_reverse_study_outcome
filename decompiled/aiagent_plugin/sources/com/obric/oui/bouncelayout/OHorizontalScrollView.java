package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OHorizontalScrollView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OHorizontalScrollView extends HorizontalScrollView {
    private static final int BOUNCE_EDGE_NONE = -1;
    public static final a Companion = null;
    public static final String TAG = "OHorizontalScrollView";
    private BounceEdgeEffect bounceLeft;
    private BounceEdgeEffect bounceRight;
    private boolean bounceStoppedForTouch;
    private final com.obric.oui.bouncelayout.b clickDuringOverScrollDelegate;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldLeft;
    private Field edgeFieldRight;
    private boolean edgeFieldsResolved;
    private EdgeEffect originalLeftEffect;
    private EdgeEffect originalRightEffect;
    private final com.obric.oui.bouncelayout.e overscrollDelegate;
    private Field scrollerField;
    private final com.obric.oui.bouncelayout.f translationDelegate;

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class b extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34091a;

        b(OHorizontalScrollView r1) {
            this.f34091a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34091a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class c extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34092a;

        c(OHorizontalScrollView r1) {
            this.f34092a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OHorizontalScrollView.access$getBounceLeft$p(this.f34092a), OHorizontalScrollView.access$getBounceRight$p(this.f34092a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class d extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MotionEvent f34094b;

        d(OHorizontalScrollView r1, MotionEvent r2) {
            this.f34093a = r1;
            this.f34094b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            return Boolean.valueOf(OHorizontalScrollView.m976access$dispatchTouchEvent$s1125439882(this.f34093a, this.f34094b));
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class e extends p implements d.h.a.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34095a;

        e(OHorizontalScrollView r1) {
            this.f34095a = r1;
            super(0);
        }

        public final Integer a() {
            return Integer.valueOf(this.f34095a.getWidth());
        }

        @Override // d.h.a.a
        public /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class f extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34096a;

        f(OHorizontalScrollView r1) {
            this.f34096a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OHorizontalScrollView.access$getBounceLeft$p(this.f34096a), OHorizontalScrollView.access$getBounceRight$p(this.f34096a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class g extends p implements d.h.a.a<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34097a;

        g(OHorizontalScrollView r1) {
            this.f34097a = r1;
            super(0);
        }

        public final Float a() {
            return Float.valueOf(this.f34097a.getBounceTranslation());
        }

        @Override // d.h.a.a
        public /* synthetic */ Float invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OHorizontalScrollView.kt */
    static final class h extends p implements d.h.a.a<BounceEdgeEffect[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OHorizontalScrollView f34098a;

        h(OHorizontalScrollView r1) {
            this.f34098a = r1;
            super(0);
        }

        public final BounceEdgeEffect[] a() {
            return new BounceEdgeEffect[]{OHorizontalScrollView.access$getBounceLeft$p(this.f34098a), OHorizontalScrollView.access$getBounceRight$p(this.f34098a)};
        }

        @Override // d.h.a.a
        public /* synthetic */ BounceEdgeEffect[] invoke() {
            return a();
        }
    }

    static {
        Companion = new a(null);
    }

    public OHorizontalScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OHorizontalScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public /* synthetic */ OHorizontalScrollView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    /* JADX INFO: renamed from: access$dispatchTouchEvent$s-1125439882, reason: not valid java name */
    public static final /* synthetic */ boolean m976access$dispatchTouchEvent$s1125439882(OHorizontalScrollView r0, MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceLeft$p(OHorizontalScrollView r0) {
        return r0.bounceLeft;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceRight$p(OHorizontalScrollView r0) {
        return r0.bounceRight;
    }

    public OHorizontalScrollView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.overscrollDelegate = new com.obric.oui.bouncelayout.e((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.translationDelegate = new com.obric.oui.bouncelayout.f((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.clickDuringOverScrollDelegate = new com.obric.oui.bouncelayout.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.a("Landroid/widget/HorizontalScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }

    public float getBounceTranslation() {
        BounceEdgeEffect r0 = this.bounceLeft;
        float r1 = 0.0f;
        if (r0 != null) goto L5;
        float r2 = 0.0f;
    L6:
        BounceEdgeEffect r3 = this.bounceRight;
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
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 == null) goto L12;
        o.a(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceLeft;
        o.a(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 == null) goto L23;
        o.a(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceRight;
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
        o.e(r6, "ev");
        this.clickDuringOverScrollDelegate.a(r6);
        com.obric.oui.bouncelayout.b r0 = this.clickDuringOverScrollDelegate;
        Boolean r1 = r0.a(r6, -r0.b(), 0.0f, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
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

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r3) {
        o.e(r3, "ev");
        if (r3.getActionMasked() != 0) goto L16;
        if (stopBounceIfNeeded() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        this.bounceStoppedForTouch = r0;
        boolean r1 = super.onInterceptTouchEvent(r3);
        if (this.clickDuringOverScrollDelegate.b(r3) == false) goto L14;
        return false;
    L14:
        return r1;
    L7:
        if (this.bounceStoppedForTouch == true) goto L10;
        r0 = false;
        goto L11
    L16:
        if (this.clickDuringOverScrollDelegate.b(r3) == false) goto L19;
        return false;
    L19:
        return super.onInterceptTouchEvent(r3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        o.e(r3, "ev");
        int r0 = r3.getActionMasked();
        boolean r1 = true;
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
    L8:
        BounceEdgeEffect r2 = this.bounceLeft;
        if (r2 == null) goto L12;
        r2.updateTouchDeltaX(0.0f);
    L12:
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 == null) goto L16;
        r4.updateTouchDeltaX(0.0f);
    L16:
        releaseStoppedBounceIfNeeded();
    L25:
        return super.onTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L18:
        if (stopBounceIfNeeded() == false) goto L20;
    L23:
        this.bounceStoppedForTouch = r1;
        goto L25
    L20:
        if (this.bounceStoppedForTouch == true) goto L23;
        r1 = false;
        goto L23
    }

    @Override // android.view.View
    public boolean overScrollBy(int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, boolean r15) {
        if (r15 == true) goto L4;
    L13:
        boolean r16 = super.overScrollBy(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        if (r15 == false) goto L16;
    L64:
        return r16;
    L16:
        if (this.edgeEffectsInstalled == false) goto L64;
        if (r11 <= 0) goto L64;
        int r17 = r9 + r7;
        com.obric.oui.bouncelayout.d r18 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L21;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "overScrollFlingFrame", "scrollX=" + r9 + " deltaX=" + r7 + " finalScrollX=" + r17 + " range=" + r11);
    L21:
        boolean r19 = false;
        if (r17 > 0) goto L43;
        if (r7 >= 0) goto L43;
        BounceEdgeEffect r1 = this.bounceLeft;
        if (r1 != null) goto L28;
    L26:
        boolean r2 = false;
    L30:
        if (r2 == false) goto L43;
        float r3 = getCurrentFlingVelocity();
        int r4 = Math.abs(r17);
        BounceEdgeEffect r5 = this.bounceLeft;
        if (r5 == null) goto L35;
        r5.onPull(r4 / getWidth(), 0.5f);
    L35:
        com.obric.oui.bouncelayout.d r6 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L38;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbLeft", "velocity=" + r3 + " overscroll=" + r4);
    L38:
        BounceEdgeEffect r20 = this.bounceLeft;
        if (r20 == null) goto L42;
        r20.onAbsorb((int) r3);
    L42:
        abortCurrentFling();
        goto L43
    L28:
        if (r1.isFinished() != true) goto L26;
        r2 = true;
    L43:
        if (r17 < r11) goto L64;
        if (r7 <= 0) goto L64;
        BounceEdgeEffect r21 = this.bounceRight;
        if (r21 != null) goto L49;
    L51:
        if (r19 == false) goto L64;
        float r22 = getCurrentFlingVelocity();
        int r110 = r17 - r11;
        BounceEdgeEffect r111 = this.bounceRight;
        if (r111 == null) goto L56;
        r111.onPull(r110 / getWidth(), 0.5f);
    L56:
        com.obric.oui.bouncelayout.d r112 = com.obric.oui.bouncelayout.d.f34149a;
        if (com.obric.oui.bouncelayout.d.a() == false) goto L59;
        com.obric.oui.bouncelayout.d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), "flingAbsorbRight", "velocity=" + r22 + " overscroll=" + r110);
    L59:
        BounceEdgeEffect r23 = this.bounceRight;
        if (r23 == null) goto L63;
        r23.onAbsorb(-((int) r22));
    L63:
        abortCurrentFling();
        goto L64
    L49:
        if (r21.isFinished() != true) goto L51;
        r19 = true;
        goto L51
    L4:
        if (this.edgeEffectsInstalled == false) goto L13;
        float r0 = r7;
        BounceEdgeEffect r24 = this.bounceLeft;
        if (r24 == null) goto L9;
        r24.updateTouchDeltaX(r0);
    L9:
        BounceEdgeEffect r25 = this.bounceRight;
        if (r25 == null) goto L13;
        r25.updateTouchDeltaX(r0);
        goto L13
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L10:
        if (r1 != 0.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L25;
        BounceEdgeEffect r3 = this.bounceRight;
        if (r3 != null) goto L17;
        float r4 = 0.0f;
    L19:
        if (r4 != 0.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L25;
        boolean r6 = false;
    L26:
        BounceEdgeEffect r7 = this.bounceLeft;
        if (r7 != null) goto L30;
    L28:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L42;
        BounceEdgeEffect r9 = this.bounceRight;
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
        Field r12 = this.scrollerField;
        OverScroller r13 = null;
        if (r12 != null) goto L50;
        Object r14 = null;
    L52:
        if (ZeusTransformUtils.instanceOf(r14, OverScroller.class) == false) goto L54;
        r13 = (OverScroller) ZeusTransformUtils.preCheckCast(r14, OverScroller.class, "com.obric.aiagent.plugin");
    L54:
        if (r13 == null) goto L57;
        r13.abortAnimation();
    L57:
        BounceEdgeEffect r15 = this.bounceLeft;
        if (r15 == null) goto L61;
        r15.stopAnimationForTouch();
    L61:
        BounceEdgeEffect r16 = this.bounceRight;
        if (r16 == null) goto L65;
        r16.stopAnimationForTouch();
    L65:
        invalidate();
        return true;
    L50:
        r14 = r12.get(this);
        goto L52
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

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r0 = resolveStoppedBounceReleaseEdge();
        if (r0 != 2) goto L8;
        BounceEdgeEffect r1 = this.bounceLeft;
        if (r1 == null) goto L18;
        r1.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r0 != 3) goto L18;
        BounceEdgeEffect r2 = this.bounceRight;
        if (r2 == null) goto L18;
        r2.onRelease();
        goto L18
    }

    private final int resolveStoppedBounceReleaseEdge() {
        boolean r0 = isBounceEffectActive(this.bounceLeft);
        boolean r1 = isBounceEffectActive(this.bounceRight);
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
    L25:
        return 2;
    L6:
        if (r1 == false) goto L9;
        if (r0 == true) goto L9;
        return 3;
    L9:
        BounceEdgeEffect r2 = this.bounceLeft;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L14:
        if (r3 > 0.0f) goto L25;
        BounceEdgeEffect r4 = this.bounceRight;
        if (r4 != null) goto L19;
        float r5 = 0.0f;
    L21:
        if (r5 < 0.0f) goto L27;
        return -1;
    L27:
        return 3;
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.edgeEffectsInstalled == true) goto L8;
        super.dispatchDraw(r4);
        return;
    L8:
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 != null) goto L11;
        float r1 = 0.0f;
    L12:
        BounceEdgeEffect r2 = this.bounceRight;
        if (r2 != null) goto L15;
        float r3 = 0.0f;
    L16:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L22;
        int r7 = r4.save();
        r4.translate(r5, 0.0f);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L22:
        super.dispatchDraw(r4);
        return;
    L19:
        r6 = false;
        goto L20
    L15:
        r3 = r2.getTranslation();
        goto L16
    L11:
        r1 = r0.getTranslation();
        goto L12
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.b();
        BounceEdgeEffect r5 = this.bounceLeft;
        if (r5 == null) goto L6;
        r5.setSize(r1, r2);
    L6:
        BounceEdgeEffect r0 = this.bounceRight;
        if (r0 == null) goto L11;
        r0.setSize(r1, r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r0 = this.bounceLeft;
        if (r0 == null) goto L6;
        r0.forceFinish$OUI_standardRelease();
    L6:
        BounceEdgeEffect r1 = this.bounceRight;
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
        Field r1 = tryGetField(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = tryGetField(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        r1 = tryGetField(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L18
    L11:
        this.edgeFieldLeft = r1;     // Catch: Throwable -> L18
        Field r2 = tryGetField(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = tryGetField(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L18
        if (r2 != null) goto L16;
        r2 = tryGetField(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L18
    L16:
        this.edgeFieldRight = r2;     // Catch: Throwable -> L18
        this.scrollerField = tryGetField(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OHorizontalScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to reflect fields", th);
        this.edgeFieldLeft = null;
        this.edgeFieldRight = null;
        this.scrollerField = null;
    }

    private final float getCurrentFlingVelocity() {
        Field r1 = this.scrollerField;     // Catch: Throwable -> L14
        OverScroller r2 = null;
        if (r1 != null) goto L6;
        Object r3 = null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, OverScroller.class) == false) goto L10;
        r2 = (OverScroller) ZeusTransformUtils.preCheckCast(r3, OverScroller.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L10:
        if (r2 != null) goto L12;
        return 1000.0f;
    L12:
        return r2.getCurrVelocity();
    L6:
        r3 = r1.get(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OHorizontalScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    private final void abortCurrentFling() {
        Field r0 = this.scrollerField;     // Catch: Throwable -> L13
        OverScroller r1 = null;
        if (r0 != null) goto L5;
        Object r2 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, OverScroller.class) == false) goto L9;
        r1 = (OverScroller) ZeusTransformUtils.preCheckCast(r2, OverScroller.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L9:
        if (r1 == null) goto L16;
        r1.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r2 = r0.get(this);     // Catch: Throwable -> L13
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceLeft == null) goto L5;
        return;
    L5:
        if (this.bounceRight != null) goto L36;
        this.overscrollDelegate.b();
        Field r1 = this.edgeFieldLeft;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldRight;
        if (r2 != null) goto L33;
        return;
    L33:
        Object r4 = r1.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r4, EdgeEffect.class) == false) goto L18;
        EdgeEffect r5 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r4, EdgeEffect.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L19:
        this.originalLeftEffect = r5;     // Catch: Throwable -> L30
        Object r6 = r2.get(this);     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r6, EdgeEffect.class) == false) goto L22;
        EdgeEffect r7 = (EdgeEffect) ZeusTransformUtils.preCheckCast(r6, EdgeEffect.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L23:
        this.originalRightEffect = r7;     // Catch: Throwable -> L30
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        o.c(r8, "context");     // Catch: Throwable -> L30
        BounceEdgeEffect r9 = new BounceEdgeEffect(r8, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        r9.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L30
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        o.c(r10, "context");     // Catch: Throwable -> L30
        BounceEdgeEffect r11 = new BounceEdgeEffect(r10, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 3, this.overscrollDelegate.a());     // Catch: Throwable -> L30
        r11.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L30
        if (getWidth() > 0) goto L26;
    L28:
        r1.set(this, r9);     // Catch: Throwable -> L30
        r2.set(this, r11);     // Catch: Throwable -> L30
        this.bounceLeft = r9;     // Catch: Throwable -> L30
        this.bounceRight = r11;     // Catch: Throwable -> L30
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L30
        this.overscrollDelegate.c();     // Catch: Throwable -> L30
        this.translationDelegate.a();     // Catch: Throwable -> L30
        return;
    L26:
        if (getHeight() <= 0) goto L28;
        r9.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        r11.setSize(getWidth(), getHeight());     // Catch: Throwable -> L30
        goto L28
    L22:
        r7 = null;
        goto L23
    L18:
        r5 = null;
    L30:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OHorizontalScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceLeft = null;
        this.bounceRight = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r0 = this.edgeFieldLeft;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        r0.set(this, this.originalLeftEffect);     // Catch: Throwable -> L11
    L6:
        Field r1 = this.edgeFieldRight;     // Catch: Throwable -> L11
        if (r1 == null) goto L16;
        r1.set(this, this.originalRightEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        INVOKESTATIC_com_obric_oui_bouncelayout_OHorizontalScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to restore original edge effects", th);
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L5:
        return (Field) ZeusTransformUtils.preCheckCast(null, Field.class, "com.obric.aiagent.plugin");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_bouncelayout_OHorizontalScrollView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
