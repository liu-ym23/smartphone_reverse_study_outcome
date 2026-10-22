package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001YB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0012\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u00103\u001a\u00020\rJ\b\u00104\u001a\u00020%H\u0014J\u0010\u00105\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0016J(\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0014J\u0010\u0010;\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0016JP\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0014J\u0010\u0010F\u001a\u00020%2\u0006\u0010>\u001a\u00020\u0017H\u0002J\b\u0010G\u001a\u00020%H\u0002J\b\u0010H\u001a\u00020%H\u0002J\b\u0010I\u001a\u00020\bH\u0002J\b\u0010J\u001a\u00020%H\u0002J\u0012\u0010K\u001a\u00020%2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020\rH\u0002J\u0010\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u0017H\u0002J\b\u0010Q\u001a\u00020\rH\u0002J\u001e\u0010R\u001a\u0004\u0018\u00010\u00112\n\u0010S\u001a\u0006\u0012\u0002\b\u00030T2\u0006\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView;", "Landroid/widget/ScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceStoppedForTouch", "", "bounceTop", "edgeEffectsInstalled", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "manualBounceActiveEdge", "manualBounceActivePointerId", "manualBounceDownY", "", "manualBounceDragging", "manualBounceLastY", "manualBounceTouchActive", "originalBottomEffect", "Landroid/widget/EdgeEffect;", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchSlop", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "getCurrentFlingVelocity", "getScrollRangeY", "handleManualBouncePointerUp", "ev", "Landroid/view/MotionEvent;", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "pullManualBounce", "releaseManualBounce", "releaseStoppedBounceIfNeeded", "resolveManualBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "shouldHandleManualBounce", "shouldStartManualBounce", "totalDeltaY", "stopBounceIfNeeded", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "updateManualBounceActivePointer", "pointerIndex", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OScrollView extends ScrollView implements IBounceTranslationView {

    @NotNull
    public static final Companion Companion = null;
    private static final int INVALID_POINTER_ID = -1;
    private static final int MANUAL_BOUNCE_BOTTOM = 2;
    private static final int MANUAL_BOUNCE_NONE = 0;
    private static final int MANUAL_BOUNCE_TOP = 1;

    @NotNull
    public static final String TAG = "OScrollView";

    @Nullable
    private BounceEdgeEffect bounceBottom;
    private boolean bounceStoppedForTouch;

    @Nullable
    private BounceEdgeEffect bounceTop;
    private boolean edgeEffectsInstalled;

    @Nullable
    private Field edgeFieldBottom;

    @Nullable
    private Field edgeFieldTop;
    private boolean edgeFieldsResolved;
    private int manualBounceActiveEdge;
    private int manualBounceActivePointerId;
    private float manualBounceDownY;
    private boolean manualBounceDragging;
    private float manualBounceLastY;
    private boolean manualBounceTouchActive;

    @Nullable
    private EdgeEffect originalBottomEffect;

    @Nullable
    private EdgeEffect originalTopEffect;

    @NotNull
    private final BounceOverscrollDelegate overscrollDelegate;

    @Nullable
    private Field scrollerField;
    private final int touchSlop;

    @NotNull
    private final BounceTranslationDelegate translationDelegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/bouncelayout/OScrollView$Companion;", "", "()V", "INVALID_POINTER_ID", "", "MANUAL_BOUNCE_BOTTOM", "MANUAL_BOUNCE_NONE", "MANUAL_BOUNCE_TOP", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public OScrollView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void abortCurrentFling() {
        Field r10 = this.scrollerField;     // Catch: Throwable -> L13
        OverScroller r11 = null;
        if (r10 != null) goto L5;
        Object r12 = null;
    L7:
        if ((r12 instanceof OverScroller) == false) goto L9;
        r11 = (OverScroller) r12;     // Catch: Throwable -> L13
    L9:
        if (r11 == null) goto L16;
        r11.abortAnimation();     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L5:
        r12 = r10.get(this);     // Catch: Throwable -> L13
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OScrollView r10) {
        return r10.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OScrollView r10) {
        return r10.bounceTop;
    }

    private final float getCurrentFlingVelocity() {
        Field r10 = this.scrollerField;     // Catch: Throwable -> L10
        OverScroller r11 = null;
        if (r10 != null) goto L6;
        Object r12 = null;
    L8:
        if ((r12 instanceof OverScroller) == false) goto L12;
        r11 = (OverScroller) r12;     // Catch: Throwable -> L10
    L12:
        if (r11 != null) goto L14;
        return 1000.0f;
    L14:
        return r11.getCurrVelocity();
    L6:
        r12 = r10.get(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Log.w(TAG, "Failed to get scroller velocity", th);
        return 1000.0f;
    }

    private final int getScrollRangeY() {
        View r10 = getChildAt(0);
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        return Math.max(0, r10.getHeight() - r11);
    }

    private final void handleManualBouncePointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r11 >= 0) goto L5;
        return;
    L5:
        if (r11 < r10.getPointerCount()) goto L8;
        return;
    L8:
        if (r10.getPointerId(r11) == this.manualBounceActivePointerId) goto L10;
        return;
    L10:
        if (r11 != 0) goto L12;
        int r12 = 1;
    L14:
        if (r12 >= r10.getPointerCount()) goto L16;
        updateManualBounceActivePointer(r12, r10);
        return;
    L16:
        this.manualBounceActivePointerId = -1;
        return;
    L12:
        r12 = 0;
        goto L14
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r10 = tryGetField(ScrollView.class, "mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = tryGetField(ScrollView.class, "mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.edgeFieldTop = r10;     // Catch: Throwable -> L9
        Field r11 = tryGetField(ScrollView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r11 != null) goto L14;
        r11 = tryGetField(ScrollView.class, "mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.edgeFieldBottom = r11;     // Catch: Throwable -> L9
        this.scrollerField = tryGetField(ScrollView.class, "mScroller");     // Catch: Throwable -> L9
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
        this.overscrollDelegate.onSizeChanged();
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
        this.originalTopEffect = r13;     // Catch: Throwable -> L17
        Object r14 = r11.get(this);     // Catch: Throwable -> L17
        if ((r14 instanceof EdgeEffect) == false) goto L23;
        EdgeEffect r15 = (EdgeEffect) r14;     // Catch: Throwable -> L17
    L24:
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
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L17
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L17
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L17
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

    private final boolean isBounceEffectActive(BounceEdgeEffect r10) {
        if (r10 != null) goto L4;
    L10:
        return false;
    L4:
        if (r10.getDistance() == 0.0f) goto L6;
    L9:
        return true;
    L6:
        if (r10.getTranslation() != 0.0f) goto L9;
        if (r10.isFinished() == true) goto L10;
        goto L9
    }

    private final void pullManualBounce(float r10) {
        if (getHeight() > 0) goto L5;
        return;
    L5:
        float r11 = r10 / getHeight();
        boolean r12 = isBounceEffectActive(this.bounceTop);
        boolean r13 = isBounceEffectActive(this.bounceBottom);
        if (r12 == false) goto L12;
        this.manualBounceActiveEdge = 1;
        BounceEdgeEffect r14 = this.bounceTop;
        if (r14 == null) goto L29;
        r14.onPull(r11, 0.5f);
    L29:
        invalidate();
        return;
    L12:
        if (r13 == false) goto L18;
        this.manualBounceActiveEdge = 2;
        BounceEdgeEffect r15 = this.bounceBottom;
        if (r15 == null) goto L29;
        r15.onPull(-r11, 0.5f);
        goto L29
    L18:
        if (r10 <= 0.0f) goto L24;
        this.manualBounceActiveEdge = 1;
        BounceEdgeEffect r16 = this.bounceTop;
        if (r16 == null) goto L29;
        r16.onPull(r11, 0.5f);
        goto L29
    L24:
        if (r10 >= 0.0f) goto L29;
        this.manualBounceActiveEdge = 2;
        BounceEdgeEffect r17 = this.bounceBottom;
        if (r17 == null) goto L29;
        r17.onPull(-r11, 0.5f);
        goto L29
    }

    private final void releaseManualBounce() {
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActivePointerId = -1;
        this.bounceStoppedForTouch = false;
        if (BounceDebugLogger.getEnabled() == false) goto L5;
        BounceDebugLogger.log(this, "manualBounceRelease", "translation=" + getBounceTranslation() + " range=" + getScrollRangeY() + " activeEdge=" + this.manualBounceActiveEdge);
    L5:
        int r10 = resolveManualBounceReleaseEdge();
        if (r10 != 1) goto L8;
        BounceEdgeEffect r11 = this.bounceTop;
        if (r11 == null) goto L18;
        r11.onRelease();
    L18:
        this.manualBounceActiveEdge = 0;
        invalidate();
        return;
    L8:
        if (r10 != 2) goto L18;
        BounceEdgeEffect r12 = this.bounceBottom;
        if (r12 == null) goto L18;
        r12.onRelease();
        goto L18
    }

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r10 = resolveManualBounceReleaseEdge();
        if (r10 != 1) goto L8;
        BounceEdgeEffect r11 = this.bounceTop;
        if (r11 == null) goto L18;
        r11.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r10 != 2) goto L18;
        BounceEdgeEffect r12 = this.bounceBottom;
        if (r12 == null) goto L18;
        r12.onRelease();
        goto L18
    }

    private final int resolveManualBounceReleaseEdge() {
        int r10 = this.manualBounceActiveEdge;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        boolean r11 = isBounceEffectActive(this.bounceTop);
        boolean r12 = isBounceEffectActive(this.bounceBottom);
        if (r11 == false) goto L10;
        if (r12 == true) goto L10;
        return 1;
    L10:
        if (r12 == false) goto L13;
        if (r11 == true) goto L13;
    L29:
        return 2;
    L13:
        BounceEdgeEffect r13 = this.bounceTop;
        if (r13 != null) goto L16;
        float r14 = 0.0f;
    L18:
        if (r14 > 0.0f) goto L31;
        BounceEdgeEffect r15 = this.bounceBottom;
        if (r15 != null) goto L23;
        float r16 = 0.0f;
    L25:
        if (r16 < 0.0f) goto L29;
        return 0;
    L23:
        r16 = r15.getTranslation();
        goto L25
    L31:
        return 1;
    L16:
        r14 = r13.getTranslation();
        goto L18
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

    private final boolean shouldStartManualBounce(float r10) {
        if (Math.abs(r10) > this.touchSlop) goto L6;
        return false;
    L6:
        if (isBounceEffectActive(this.bounceTop) == false) goto L8;
    L19:
        return true;
    L8:
        if (isBounceEffectActive(this.bounceBottom) == true) goto L19;
        if (r10 <= 0.0f) goto L16;
        if (canScrollVertically(-1) == false) goto L20;
        return false;
    L20:
        return true;
    L16:
        if (canScrollVertically(1) == false) goto L20;
        return false;
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L10:
        if (r11 != 0.0f) goto L18;
        BounceEdgeEffect r12 = this.bounceBottom;
        if (r12 != null) goto L14;
        float r13 = 0.0f;
    L16:
        if (r13 != 0.0f) goto L18;
        boolean r14 = false;
    L19:
        BounceEdgeEffect r15 = this.bounceTop;
        if (r15 != null) goto L23;
    L25:
        BounceEdgeEffect r16 = this.bounceBottom;
        if (r16 != null) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r14 == true) goto L36;
        if (r17 == true) goto L36;
        return false;
    L36:
        abortCurrentFling();
        BounceEdgeEffect r18 = this.bounceTop;
        if (r18 == null) goto L40;
        r18.stopAnimationForTouch();
    L40:
        BounceEdgeEffect r19 = this.bounceBottom;
        if (r19 == null) goto L44;
        r19.stopAnimationForTouch();
    L44:
        invalidate();
        return true;
    L29:
        if (r16.isFinished() == true) goto L31;
    L30:
        r17 = true;
        goto L32
    L23:
        if (r15.isFinished() == true) goto L25;
    L14:
        r13 = r12.getTranslation();
    L18:
        r14 = true;
        goto L19
    L8:
        r11 = r10.getTranslation();
        goto L10
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

    private final void updateManualBounceActivePointer(int r10, MotionEvent r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= r11.getPointerCount()) goto L9;
        this.manualBounceActivePointerId = r11.getPointerId(r10);
        this.manualBounceLastY = r11.getY(r10);
        return;
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

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 == null) goto L6;
        r10.finish();
    L6:
        BounceEdgeEffect r11 = this.bounceBottom;
        if (r11 == null) goto L10;
        r11.finish();
    L10:
        restoreOriginalEdgeEffects();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        this.bounceStoppedForTouch = stopBounceIfNeeded();
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r10.getPointerId(0);
        float r12 = r10.getY(0);
        this.manualBounceDownY = r12;
        this.manualBounceLastY = r12;
    L38:
        return super.onInterceptTouchEvent(r10);
    L5:
        if (r11 != 1) goto L7;
    L35:
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = -1;
        releaseStoppedBounceIfNeeded();
        goto L38
    L7:
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L35;
        if (r11 == 5) goto L20;
        if (r11 != 6) goto L38;
        if (this.manualBounceTouchActive == false) goto L38;
        handleManualBouncePointerUp(r10);
        return true;
    L20:
        if (this.manualBounceTouchActive == false) goto L38;
        updateManualBounceActivePointer(r10.getActionIndex(), r10);
        return true;
    L24:
        if (shouldHandleManualBounce() == false) goto L38;
        int r13 = r10.findPointerIndex(this.manualBounceActivePointerId);
        if (r13 >= 0) goto L29;
        return false;
    L29:
        if (shouldStartManualBounce(r10.getY(r13) - this.manualBounceDownY) == false) goto L38;
        this.manualBounceTouchActive = true;
        this.manualBounceDragging = true;
        this.bounceStoppedForTouch = false;
        this.manualBounceLastY = this.manualBounceDownY;
        ViewParent r14 = getParent();
        if (r14 == null) goto L34;
        r14.requestDisallowInterceptTouchEvent(true);
    L34:
        return true;
    }

    @Override // android.widget.ScrollView, android.view.View
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

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        int r11 = r10.getActionMasked();
        boolean r12 = true;
        if (r11 == 0) goto L42;
        if (r11 == 1) goto L37;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L37;
        if (r11 == 5) goto L19;
        if (r11 != 6) goto L49;
        if (this.manualBounceTouchActive == false) goto L49;
        handleManualBouncePointerUp(r10);
        return true;
    L49:
        return super.onTouchEvent(r10);
    L19:
        if (this.manualBounceTouchActive == false) goto L49;
        updateManualBounceActivePointer(r10.getActionIndex(), r10);
        return true;
    L23:
        if (this.manualBounceTouchActive == false) goto L49;
        int r13 = r10.findPointerIndex(this.manualBounceActivePointerId);
        if (r13 >= 0) goto L28;
        releaseManualBounce();
        return true;
    L28:
        float r14 = r10.getY(r13);
        float r15 = r14 - this.manualBounceLastY;
        if (this.manualBounceDragging == true) goto L31;
    L34:
        this.manualBounceLastY = r14;
        return true;
    L31:
        if (r15 == 0.0f) goto L34;
        pullManualBounce(r15);
    L37:
        if (this.manualBounceTouchActive == false) goto L40;
        releaseManualBounce();
        return true;
    L40:
        releaseStoppedBounceIfNeeded();
        goto L49
    L42:
        if (stopBounceIfNeeded() == false) goto L44;
    L47:
        this.bounceStoppedForTouch = r12;
        this.manualBounceTouchActive = false;
        this.manualBounceDragging = false;
        this.manualBounceActiveEdge = 0;
        this.manualBounceActivePointerId = r10.getPointerId(0);
        float r16 = r10.getY(0);
        this.manualBounceDownY = r16;
        this.manualBounceLastY = r16;
        goto L49
    L44:
        if (this.bounceStoppedForTouch == true) goto L47;
        r12 = false;
        goto L47
    }

    @Override // android.view.View
    public boolean overScrollBy(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, boolean r18) {
        boolean r19 = super.overScrollBy(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        if (r18 == false) goto L5;
    L53:
        return r19;
    L5:
        if (this.edgeEffectsInstalled == false) goto L53;
        if (r15 <= 0) goto L53;
        int r20 = r13 + r11;
        if (BounceDebugLogger.getEnabled() == false) goto L11;
        BounceDebugLogger.log(this, "overScrollFlingFrame", "scrollY=" + r13 + " deltaY=" + r11 + " finalScrollY=" + r20 + " range=" + r15);
    L11:
        if (r20 > 0) goto L32;
        if (r11 >= 0) goto L32;
        BounceEdgeEffect r110 = this.bounceTop;
        if (r110 == null) goto L32;
        if (r110.isFinished() != true) goto L32;
        float r111 = getCurrentFlingVelocity();
        int r21 = Math.abs(r20);
        if (getHeight() <= 0) goto L25;
        BounceEdgeEffect r22 = this.bounceTop;
        if (r22 == null) goto L25;
        r22.onPull(r21 / getHeight(), 0.5f);
    L25:
        if (BounceDebugLogger.getEnabled() == false) goto L27;
        BounceDebugLogger.log(this, "flingAbsorbTop", "velocity=" + r111 + " overscroll=" + r21);
    L27:
        BounceEdgeEffect r23 = this.bounceTop;
        if (r23 == null) goto L31;
        r23.onAbsorb((int) r111);
    L31:
        abortCurrentFling();
    L32:
        if (r20 < r15) goto L53;
        if (r11 <= 0) goto L53;
        BounceEdgeEffect r24 = this.bounceBottom;
        if (r24 == null) goto L53;
        if (r24.isFinished() != true) goto L53;
        float r25 = getCurrentFlingVelocity();
        int r26 = r20 - r15;
        if (getHeight() <= 0) goto L46;
        BounceEdgeEffect r112 = this.bounceBottom;
        if (r112 == null) goto L46;
        r112.onPull(r26 / getHeight(), 0.5f);
    L46:
        if (BounceDebugLogger.getEnabled() == false) goto L48;
        BounceDebugLogger.log(this, "flingAbsorbBottom", "velocity=" + r25 + " overscroll=" + r26);
    L48:
        BounceEdgeEffect r27 = this.bounceBottom;
        if (r27 == null) goto L52;
        r27.onAbsorb(-((int) r25));
    L52:
        abortCurrentFling();
        goto L53
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(@Nullable OnBounceTranslationListener r10) {
        this.translationDelegate.setOnBounceTranslationListener(r10);
    }

    @JvmOverloads
    public OScrollView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OScrollView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OScrollView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.touchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.manualBounceActivePointerId = -1;
        this.overscrollDelegate = new BounceOverscrollDelegate(new OScrollView$overscrollDelegate$1(this), new OScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OScrollView$translationDelegate$1(this), new OScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/ScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }
}
