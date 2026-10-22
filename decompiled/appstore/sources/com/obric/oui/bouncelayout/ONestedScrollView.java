package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\u0006\u0010(\u001a\u00020\u000eJ\b\u0010)\u001a\u00020 H\u0014J(\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\b\u0010/\u001a\u00020 H\u0002J\u0012\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H\u0016J0\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0016H\u0002J\u001e\u0010:\u001a\u0004\u0018\u00010\u00102\n\u0010;\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceTop", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingBounceAbsorbed", "lastScrollerScrollY", "lastScrollerVelocity", "", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "computeScroll", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "getScrollRangeY", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isOverScrolling", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "tryAbsorbRunningFlingAtEdge", "scroller", "Landroid/widget/OverScroller;", FixCard.FixStyle.KEY_Y, "previousY", "rangeY", "velocity", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ONestedScrollView extends NestedScrollView implements IBounceTranslationView {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    public static final String TAG = "ONestedScrollView";

    @Nullable
    private BounceEdgeEffect bounceBottom;

    @Nullable
    private BounceEdgeEffect bounceTop;
    private boolean edgeEffectsInstalled;

    @Nullable
    private Field edgeFieldBottom;

    @Nullable
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private boolean flingBounceAbsorbed;
    private int lastScrollerScrollY;
    private float lastScrollerVelocity;

    @Nullable
    private EdgeEffect originalBottomEffect;

    @Nullable
    private EdgeEffect originalTopEffect;

    @NotNull
    private final BounceOverscrollDelegate overscrollDelegate;

    @Nullable
    private Field scrollerField;

    @NotNull
    private final BounceTranslationDelegate translationDelegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/bouncelayout/ONestedScrollView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmOverloads
    public ONestedScrollView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(ONestedScrollView r10) {
        return r10.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(ONestedScrollView r10) {
        return r10.bounceTop;
    }

    private final int getScrollRangeY() {
        View r10 = getChildAt(0);
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r10.getHeight() - r11);
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r10 = tryGetField(NestedScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = tryGetField(NestedScrollView.class, "mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.edgeFieldTop = r10;     // Catch: Throwable -> L9
        Field r11 = tryGetField(NestedScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r11 != null) goto L14;
        r11 = tryGetField(NestedScrollView.class, "mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.edgeFieldBottom = r11;     // Catch: Throwable -> L9
        this.scrollerField = tryGetField(NestedScrollView.class, "mScroller");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceTop == null) goto L5;
        return;
    L5:
        if (this.bounceBottom != null) goto L36;
        Field r10 = this.edgeFieldTop;
        if (r10 != null) goto L10;
        return;
    L10:
        Field r11 = this.edgeFieldBottom;
        if (r11 != null) goto L33;
        return;
    L33:
        Object r12 = r10.get(this);     // Catch: Throwable -> L17
        if ((r12 instanceof EdgeEffect) == false) goto L19;
        EdgeEffect r13 = (EdgeEffect) r12;     // Catch: Throwable -> L17
    L20:
        Object r14 = r11.get(this);     // Catch: Throwable -> L17
        if ((r14 instanceof EdgeEffect) == false) goto L23;
        EdgeEffect r15 = (EdgeEffect) r14;     // Catch: Throwable -> L17
    L24:
        this.originalTopEffect = r13;     // Catch: Throwable -> L17
        this.originalBottomEffect = r15;     // Catch: Throwable -> L17
        Context r16 = getContext();     // Catch: Throwable -> L17
        q.f(r16, "context");     // Catch: Throwable -> L17
        BounceEdgeEffect r17 = new BounceEdgeEffect(r16, this, 0, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L17
        Context r18 = getContext();     // Catch: Throwable -> L17
        q.f(r18, "context");     // Catch: Throwable -> L17
        BounceEdgeEffect r19 = new BounceEdgeEffect(r18, this, 1, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L17
        if (getWidth() > 0) goto L27;
    L29:
        r10.set(this, r17);     // Catch: Throwable -> L17
        r11.set(this, r19);     // Catch: Throwable -> L17
        this.bounceTop = r17;     // Catch: Throwable -> L17
        this.bounceBottom = r19;     // Catch: Throwable -> L17
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L17
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L17
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L17
        return;
    L27:
        if (getHeight() <= 0) goto L29;
        r17.setSize(getWidth(), getHeight());     // Catch: Throwable -> L17
        r19.setSize(getWidth(), getHeight());     // Catch: Throwable -> L17
        goto L29
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
    L17:
        th = move-exception;
        Log.w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    }

    private final void restoreOriginalEdgeEffects() {
        Field r10 = this.edgeFieldTop;     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
        r10.set(this, this.originalTopEffect);     // Catch: Throwable -> L11
    L6:
        Field r11 = this.edgeFieldBottom;     // Catch: Throwable -> L11
        if (r11 == null) goto L16;
        r11.set(this, this.originalBottomEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w(TAG, "Failed to restore original edge effects", th);
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r10, int r11, int r12, int r13, float r14) {
        boolean r15 = false;
        if (this.flingBounceAbsorbed == false) goto L5;
    L39:
        return r15;
    L5:
        if (r14 <= 0.0f) goto L39;
        if (r11 != 0) goto L23;
        if (r12 <= 0) goto L23;
        BounceEdgeEffect r16 = this.bounceTop;
        if (r16 == null) goto L23;
        if (r16.isFinished() != true) goto L23;
        if (BounceDebugLogger.getEnabled() == false) goto L18;
        BounceDebugLogger.log(this, "flingAbsorbTop", q.p("velocity=", Float.valueOf(r14)));
    L18:
        BounceEdgeEffect r17 = this.bounceTop;
        if (r17 == null) goto L22;
        r17.onAbsorb((int) r14);
    L22:
        r15 = true;
    L37:
        if (r15 == false) goto L39;
        this.flingBounceAbsorbed = true;
        r10.abortAnimation();
        this.lastScrollerVelocity = 0.0f;
        invalidate();
    L23:
        if (r11 != r13) goto L37;
        if (r12 >= r13) goto L37;
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 == null) goto L37;
        if (r18.isFinished() != true) goto L37;
        if (BounceDebugLogger.getEnabled() == false) goto L33;
        BounceDebugLogger.log(this, "flingAbsorbBottom", q.p("velocity=", Float.valueOf(r14)));
    L33:
        BounceEdgeEffect r19 = this.bounceBottom;
        if (r19 == null) goto L22;
        r19.onAbsorb(-((int) r14));
        goto L22
    }

    private final Field tryGetField(Class<?> r10, String r11) {
        Field r12 = r10.getDeclaredField(r11);     // Catch: Throwable -> L4
        r12.setAccessible(true);     // Catch: Throwable -> L4
        return r12;
    L4:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        return null;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r10 = null;
        Field r11 = this.scrollerField;     // Catch: Throwable -> L55
        if (r11 != null) goto L9;
        Object r12 = null;
    L11:
        if ((r12 instanceof OverScroller) == false) goto L14;
        r10 = (OverScroller) r12;     // Catch: Throwable -> L55
        goto L14
    L9:
        r12 = r11.get(this);     // Catch: Throwable -> L55
    L14:
        OverScroller r13 = r10;
        if (r13 != null) goto L17;
        return;
    L17:
        int r14 = getScrollRangeY();
        if (r14 > 0) goto L20;
        return;
    L20:
        int r15 = getScrollY();
        if (r13.isFinished() == true) goto L30;
        int r16 = this.lastScrollerScrollY;
        this.lastScrollerVelocity = r13.getCurrVelocity();
        if (BounceDebugLogger.getEnabled() == false) goto L26;
        BounceDebugLogger.log(this, "flingFrame", "y=" + r15 + " previousY=" + r16 + " range=" + r14 + " velocity=" + this.lastScrollerVelocity);
    L26:
        if (tryAbsorbRunningFlingAtEdge(r13, r15, r16, r14, this.lastScrollerVelocity) == false) goto L28;
        return;
    L28:
        this.lastScrollerScrollY = r15;
        return;
    L30:
        float r17 = this.lastScrollerVelocity;
        if (r17 > 0.0f) goto L33;
    L53:
        this.lastScrollerVelocity = 0.0f;
        this.flingBounceAbsorbed = false;
        return;
    L33:
        if (r15 == 0) goto L35;
    L43:
        if (r15 != r14) goto L53;
        if (this.lastScrollerScrollY >= r14) goto L53;
        if (BounceDebugLogger.getEnabled() == false) goto L49;
        BounceDebugLogger.log(this, "flingAbsorbBottomFinished", q.p("velocity=", Float.valueOf(r17)));
    L49:
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 == null) goto L53;
        r18.onAbsorb(-((int) r17));
        goto L53
    L35:
        if (this.lastScrollerScrollY <= 0) goto L43;
        if (BounceDebugLogger.getEnabled() == false) goto L39;
        BounceDebugLogger.log(this, "flingAbsorbTopFinished", q.p("velocity=", Float.valueOf(r17)));
    L39:
        BounceEdgeEffect r19 = this.bounceTop;
        if (r19 == null) goto L53;
        r19.onAbsorb((int) r17);
        goto L53
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@Nullable Canvas r10) {
        if (r10 != null) goto L5;
        super.dispatchDraw(r10);
        return;
    L5:
        BounceEdgeEffect r11 = this.bounceTop;
        if (r11 != null) goto L8;
        float r12 = 0.0f;
    L9:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 != null) goto L12;
        float r14 = 0.0f;
    L13:
        float r15 = r12 + r14;
        if (r15 != 0.0f) goto L16;
        super.dispatchDraw(r10);
        return;
    L16:
        int r16 = r10.save();
        r10.translate(0.0f, r15);
        super.dispatchDraw(r10);
        r10.restoreToCount(r16);
        return;
    L12:
        r14 = r13.getTranslation();
        goto L13
    L8:
        r12 = r11.getTranslation();
        goto L9
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public float getBounceTranslation() {
        BounceEdgeEffect r10 = this.bounceTop;
        float r11 = 0.0f;
        if (r10 != null) goto L5;
        float r12 = 0.0f;
    L6:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L11;
        r11 = r13.getTranslation();
    L11:
        return r12 + r11;
    L5:
        r12 = r10.getTranslation();
        goto L6
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 == null) goto L9;
        q.d(r10);
        if (r10.getDistance() != 0.0f) goto L8;
        BounceEdgeEffect r11 = this.bounceTop;
        q.d(r11);
        if (r11.isFinished() == true) goto L9;
    L8:
        boolean r12 = true;
    L10:
        BounceEdgeEffect r13 = this.bounceBottom;
        if (r13 == null) goto L17;
        q.d(r13);
        if (r13.getDistance() != 0.0f) goto L16;
        BounceEdgeEffect r14 = this.bounceBottom;
        q.d(r14);
        if (r14.isFinished() == true) goto L17;
    L16:
        boolean r15 = true;
    L18:
        if (r12 == true) goto L21;
        if (r15 == true) goto L21;
        return false;
    L21:
        return true;
    L17:
        r15 = false;
    L9:
        r12 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 == null) goto L6;
        r10.finish();
    L6:
        BounceEdgeEffect r11 = this.bounceBottom;
        if (r11 == null) goto L10;
        r11.finish();
    L10:
        restoreOriginalEdgeEffects();
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        this.overscrollDelegate.onSizeChanged();
        BounceEdgeEffect r14 = this.bounceTop;
        if (r14 == null) goto L6;
        r14.setSize(r10, r11);
    L6:
        BounceEdgeEffect r15 = this.bounceBottom;
        if (r15 == null) goto L11;
        r15.setSize(r10, r11);
        return;
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(@Nullable OnBounceTranslationListener r10) {
        this.translationDelegate.setOnBounceTranslationListener(r10);
    }

    @JvmOverloads
    public ONestedScrollView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ONestedScrollView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ONestedScrollView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.overscrollDelegate = new BounceOverscrollDelegate(new ONestedScrollView$overscrollDelegate$1(this), new ONestedScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new ONestedScrollView$translationDelegate$1(this), new ONestedScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroidx/core/widget/NestedScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }
}
