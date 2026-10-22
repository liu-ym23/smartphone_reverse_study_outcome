package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.GlobalProxyLancet;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ONestedScrollView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\u000eJ\b\u0010)\u001a\u00020 H\u0014J(\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\b\u0010/\u001a\u00020 H\u0002J\u0012\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H\u0016J0\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0016H\u0002J\u001e\u0010:\u001a\u0004\u0018\u00010\u00102\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceTop", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingBounceAbsorbed", "lastScrollerScrollY", "lastScrollerVelocity", "", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "computeScroll", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "getScrollRangeY", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isOverScrolling", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "tryAbsorbRunningFlingAtEdge", "scroller", "Landroid/widget/OverScroller;", MaterialConfigFormatNames.Y, "previousY", "rangeY", RealFpsTracer.SCROLL_VELOCITY, "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ONestedScrollView extends NestedScrollView implements IBounceTranslationView {
    public static final Companion Companion = null;
    public static final String TAG = "ONestedScrollView";
    private BounceEdgeEffect bounceBottom;
    private BounceEdgeEffect bounceTop;
    private boolean edgeEffectsInstalled;
    private Field edgeFieldBottom;
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private boolean flingBounceAbsorbed;
    private int lastScrollerScrollY;
    private float lastScrollerVelocity;
    private EdgeEffect originalBottomEffect;
    private EdgeEffect originalTopEffect;
    private final BounceOverscrollDelegate overscrollDelegate;
    private Field scrollerField;
    private final BounceTranslationDelegate translationDelegate;

    /* JADX INFO: compiled from: ONestedScrollView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ONestedScrollView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ONestedScrollView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ONestedScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(ONestedScrollView r0) {
        return r0.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(ONestedScrollView r0) {
        return r0.bounceTop;
    }

    public ONestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.overscrollDelegate = new BounceOverscrollDelegate(new ONestedScrollView$overscrollDelegate$1(this), new ONestedScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new ONestedScrollView$translationDelegate$1(this), new ONestedScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroidx/core/widget/NestedScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
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

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(OnBounceTranslationListener r1) {
        this.translationDelegate.setOnBounceTranslationListener(r1);
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.getDistance() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        BounceEdgeEffect r2 = this.bounceTop;
        Intrinsics.checkNotNull(r2);
        if (r2.isFinished() == true) goto L12;
    L11:
        boolean r3 = true;
    L13:
        BounceEdgeEffect r4 = this.bounceBottom;
        if (r4 == null) goto L23;
        Intrinsics.checkNotNull(r4);
        if (r4.getDistance() != 0.0f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        BounceEdgeEffect r6 = this.bounceBottom;
        Intrinsics.checkNotNull(r6);
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.overscrollDelegate.onSizeChanged();
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
        OverScroller r0 = null;
        Field r1 = this.scrollerField;     // Catch: Throwable -> L14
        if (r1 != null) goto L9;
        Object r2 = null;
    L11:
        if ((r2 instanceof OverScroller) == false) goto L15;
        r0 = (OverScroller) r2;     // Catch: Throwable -> L14
    L15:
        OverScroller r3 = r0;
        if (r3 != null) goto L18;
        return;
    L18:
        int r6 = getScrollRangeY();
        if (r6 > 0) goto L21;
        return;
    L21:
        int r4 = getScrollY();
        if (r3.isFinished() == true) goto L31;
        int r5 = this.lastScrollerScrollY;
        this.lastScrollerVelocity = r3.getCurrVelocity();
        BounceDebugLogger r7 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L27;
        BounceDebugLogger.log(this, "flingFrame", "y=" + r4 + " previousY=" + r5 + " range=" + r6 + " velocity=" + this.lastScrollerVelocity);
    L27:
        if (tryAbsorbRunningFlingAtEdge(r3, r4, r5, r6, this.lastScrollerVelocity) == false) goto L29;
        return;
    L29:
        this.lastScrollerScrollY = r4;
        return;
    L31:
        float r8 = this.lastScrollerVelocity;
        if (r8 > 0.0f) goto L34;
    L54:
        this.lastScrollerVelocity = 0.0f;
        this.flingBounceAbsorbed = false;
        return;
    L34:
        if (r4 == 0) goto L36;
    L44:
        if (r4 != r6) goto L54;
        if (this.lastScrollerScrollY >= r6) goto L54;
        BounceDebugLogger r9 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L50;
        BounceDebugLogger.log(this, "flingAbsorbBottomFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r8)));
    L50:
        BounceEdgeEffect r10 = this.bounceBottom;
        if (r10 == null) goto L54;
        r10.onAbsorb(-((int) r8));
        goto L54
    L36:
        if (this.lastScrollerScrollY <= 0) goto L44;
        BounceDebugLogger r11 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L40;
        BounceDebugLogger.log(this, "flingAbsorbTopFinished", Intrinsics.stringPlus("velocity=", Float.valueOf(r8)));
    L40:
        BounceEdgeEffect r12 = this.bounceTop;
        if (r12 == null) goto L54;
        r12.onAbsorb((int) r8);
        goto L54
    L9:
        r2 = r1.get(this);     // Catch: Throwable -> L14
    L14:
        OverScroller r13 = (OverScroller) null;
        goto L15
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r6, int r7, int r8, int r9, float r10) {
        boolean r1 = false;
        if (this.flingBounceAbsorbed == false) goto L5;
    L43:
        return r1;
    L5:
        if (r10 <= 0.0f) goto L43;
        if (r7 != 0) goto L25;
        if (r8 <= 0) goto L25;
        BounceEdgeEffect r4 = this.bounceTop;
        if (r4 != null) goto L14;
    L12:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L25;
        BounceDebugLogger r11 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        BounceDebugLogger.log(this, "flingAbsorbTop", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L20:
        BounceEdgeEffect r12 = this.bounceTop;
        if (r12 == null) goto L24;
        r12.onAbsorb((int) r10);
    L24:
        r1 = true;
    L41:
        if (r1 == false) goto L43;
        this.flingBounceAbsorbed = true;
        r6.abortAnimation();
        this.lastScrollerVelocity = 0.0f;
        invalidate();
        goto L43
    L14:
        if (r4.isFinished() != true) goto L12;
        r5 = true;
    L25:
        if (r7 != r9) goto L41;
        if (r8 >= r9) goto L41;
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 != null) goto L31;
    L29:
        boolean r14 = false;
    L33:
        if (r14 == false) goto L41;
        BounceDebugLogger r15 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L37;
        BounceDebugLogger.log(this, "flingAbsorbBottom", Intrinsics.stringPlus("velocity=", Float.valueOf(r10)));
    L37:
        BounceEdgeEffect r16 = this.bounceBottom;
        if (r16 == null) goto L24;
        r16.onAbsorb(-((int) r10));
        goto L24
    L31:
        if (r13.isFinished() != true) goto L29;
        r14 = true;
        goto L33
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r4) {
        if (r4 != null) goto L5;
        super.dispatchDraw(r4);
        return;
    L5:
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 != null) goto L8;
        float r1 = 0.0f;
    L9:
        BounceEdgeEffect r2 = this.bounceBottom;
        if (r2 != null) goto L12;
        float r3 = 0.0f;
    L13:
        float r5 = r1 + r3;
        if (r5 != 0.0f) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        int r7 = r4.save();
        r4.translate(0.0f, r5);
        super.dispatchDraw(r4);
        r4.restoreToCount(r7);
        return;
    L19:
        super.dispatchDraw(r4);
        return;
    L16:
        r6 = false;
        goto L17
    L12:
        r3 = r2.getTranslation();
        goto L13
    L8:
        r1 = r0.getTranslation();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        BounceEdgeEffect r0 = this.bounceTop;
        if (r0 == null) goto L6;
        r0.finish();
    L6:
        BounceEdgeEffect r1 = this.bounceBottom;
        if (r1 == null) goto L10;
        r1.finish();
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L35;
        Field r1 = this.edgeFieldTop;
        if (r1 != null) goto L10;
        return;
    L10:
        Field r2 = this.edgeFieldBottom;
        if (r2 != null) goto L32;
        return;
    L32:
        Object r5 = r1.get(this);     // Catch: Throwable -> L29
        if ((r5 instanceof EdgeEffect) == false) goto L17;
        EdgeEffect r6 = (EdgeEffect) r5;     // Catch: Throwable -> L29
    L18:
        Object r7 = r2.get(this);     // Catch: Throwable -> L29
        if ((r7 instanceof EdgeEffect) == false) goto L21;
        EdgeEffect r8 = (EdgeEffect) r7;     // Catch: Throwable -> L29
    L22:
        this.originalTopEffect = r6;     // Catch: Throwable -> L29
        this.originalBottomEffect = r8;     // Catch: Throwable -> L29
        Context r9 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r9, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r10 = new BounceEdgeEffect(r9, this, 0, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        Context r11 = getContext();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r11, "context");     // Catch: Throwable -> L29
        BounceEdgeEffect r12 = new BounceEdgeEffect(r11, this, 1, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L29
        if (getWidth() > 0) goto L25;
    L27:
        r1.set(this, r10);     // Catch: Throwable -> L29
        r2.set(this, r12);     // Catch: Throwable -> L29
        this.bounceTop = r10;     // Catch: Throwable -> L29
        this.bounceBottom = r12;     // Catch: Throwable -> L29
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L29
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L29
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L29
        return;
    L25:
        if (getHeight() <= 0) goto L27;
        r10.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        r12.setSize(getWidth(), getHeight());     // Catch: Throwable -> L29
        goto L27
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = null;
    L29:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to restore original edge effects", th);
    }

    private final Field tryGetField(Class<?> r1, String r2) {
        Field r0 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Failed to reflect edge effect fields", th);
        Field r3 = (Field) null;
        return null;
    }
}
