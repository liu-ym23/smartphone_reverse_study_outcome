package com.obric.oui.bouncelayout;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\u0006\u0010/\u001a\u00020\u000eJ\b\u00100\u001a\u00020#H\u0014J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J(\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0014J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0016J\u0014\u00108\u001a\u00020#2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020#H\u0002J\u0012\u0010<\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020#H\u0002J\u0018\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u0017H\u0002J\u001e\u0010C\u001a\u0004\u0018\u00010\u00102\n\u0010D\u001a\u0006\u0012\u0002\b\u00030E2\u0006\u0010F\u001a\u00020GH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/bouncelayout/OGridView;", "Landroid/widget/GridView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceBottom", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceTop", "edgeEffectsInstalled", "", "edgeFieldBottom", "Ljava/lang/reflect/Field;", "edgeFieldTop", "edgeFieldsResolved", "flingRunnableField", "flingRunnableScrollerField", "lastScrollDirection", "lastScrollerVelocity", "", "lastVerticalScrollOffset", "originalBottomEffect", "", "originalTopEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "touchDownTranslationY", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "computeScroll", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getBounceTranslation", "getOverScrollerOrNull", "Landroid/widget/OverScroller;", "initEdgeEffectReflection", "installBounceEdgeEffects", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "removeCurrentFlingRunnable", "flingRunnable", "Ljava/lang/Runnable;", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryAbsorbRunningFlingAtEdge", "scroller", "velocity", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OGridView extends GridView implements IBounceTranslationView {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    public static final String TAG = "OGridView";

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

    @Nullable
    private Field flingRunnableField;

    @Nullable
    private Field flingRunnableScrollerField;
    private int lastScrollDirection;
    private float lastScrollerVelocity;
    private int lastVerticalScrollOffset;

    @Nullable
    private Object originalBottomEffect;

    @Nullable
    private Object originalTopEffect;

    @NotNull
    private final BounceOverscrollDelegate overscrollDelegate;

    @Nullable
    private Field scrollerField;
    private float touchDownTranslationY;

    @NotNull
    private final BounceTranslationDelegate translationDelegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/bouncelayout/OGridView$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public OGridView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceBottom$p(OGridView r10) {
        return r10.bounceBottom;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceTop$p(OGridView r10) {
        return r10.bounceTop;
    }

    private final OverScroller getOverScrollerOrNull() {
        Field r10 = this.scrollerField;     // Catch: Throwable -> L31
        if (r10 != null) goto L6;
        Object r11 = null;
    L8:
        if ((r11 instanceof OverScroller) == false) goto L11;
        OverScroller r12 = (OverScroller) r11;     // Catch: Throwable -> L31
    L12:
        if (r12 == null) goto L34;
        return r12;
    L11:
        r12 = null;
        goto L12
    L6:
        r11 = r10.get(this);     // Catch: Throwable -> L31
    L34:
        Field r13 = this.flingRunnableField;     // Catch: Throwable -> L33
        if (r13 == null) goto L19;
        Object r14 = r13.get(this);     // Catch: Throwable -> L33
    L20:
        if (r14 != null) goto L36;
        return null;
    L36:
        Field r15 = this.flingRunnableScrollerField;     // Catch: Throwable -> L32
        if (r15 != null) goto L25;
        Object r16 = null;
    L27:
        if ((r16 instanceof OverScroller) == false) goto L40;
        return (OverScroller) r16;
    L40:
        return null;
    L25:
        r16 = r15.get(r14);     // Catch: Throwable -> L32
    L41:
        return null;
    L19:
        r14 = null;
        goto L20
    }

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r10 = tryGetField(AbsListView.class, "mEdgeGlowTop");     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = tryGetField(AbsListView.class, "mTopGlow");     // Catch: Throwable -> L9
    L11:
        this.edgeFieldTop = r10;     // Catch: Throwable -> L9
        Field r11 = tryGetField(AbsListView.class, "mEdgeGlowBottom");     // Catch: Throwable -> L9
        if (r11 != null) goto L14;
        r11 = tryGetField(AbsListView.class, "mBottomGlow");     // Catch: Throwable -> L9
    L14:
        this.edgeFieldBottom = r11;     // Catch: Throwable -> L9
        this.scrollerField = tryGetField(AbsListView.class, "mScroller");     // Catch: Throwable -> L9
        Field r12 = tryGetField(AbsListView.class, "mFlingRunnable");     // Catch: Throwable -> L9
        this.flingRunnableField = r12;     // Catch: Throwable -> L9
        if (r12 != null) goto L17;
    L16:
        Field r13 = null;
    L21:
        this.flingRunnableScrollerField = r13;     // Catch: Throwable -> L9
        return;
    L17:
        Class<?> r14 = r12.getType();     // Catch: Throwable -> L9
        if (r14 == null) goto L16;
        r13 = tryGetField(r14, "mScroller");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.w(TAG, "Failed to reflect edge effect fields", th);
        this.edgeFieldTop = null;
        this.edgeFieldBottom = null;
        this.scrollerField = null;
        this.flingRunnableField = null;
        this.flingRunnableScrollerField = null;
    }

    private final void installBounceEdgeEffects() {
        Field r10 = this.edgeFieldTop;
        Field r11 = this.edgeFieldBottom;
        if (r10 == null) goto L25;
        if (r11 == null) goto L26;
    L9:
        th = move-exception;
        Log.w(TAG, "Failed to install BounceEdgeEffects, restoring original.", th);
        restoreOriginalEdgeEffects();
        return;
    L7:
        if (this.originalTopEffect != null) goto L12;
        this.originalTopEffect = r10.get(this);     // Catch: Throwable -> L9
    L12:
        if (this.originalBottomEffect != null) goto L14;
        this.originalBottomEffect = r11.get(this);     // Catch: Throwable -> L9
    L14:
        this.overscrollDelegate.onSizeChanged();     // Catch: Throwable -> L9
        Context r12 = getContext();     // Catch: Throwable -> L9
        q.f(r12, "context");     // Catch: Throwable -> L9
        BounceEdgeEffect r13 = new BounceEdgeEffect(r12, this, 0, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L9
        Context r14 = getContext();     // Catch: Throwable -> L9
        q.f(r14, "context");     // Catch: Throwable -> L9
        BounceEdgeEffect r15 = new BounceEdgeEffect(r14, this, 1, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L9
        if (getWidth() > 0) goto L17;
    L19:
        r10.set(this, r13);     // Catch: Throwable -> L9
        r11.set(this, r15);     // Catch: Throwable -> L9
        this.bounceTop = r13;     // Catch: Throwable -> L9
        this.bounceBottom = r15;     // Catch: Throwable -> L9
        this.overscrollDelegate.applyMaxToEffects();     // Catch: Throwable -> L9
        this.translationDelegate.updateBounceListeners();     // Catch: Throwable -> L9
        this.edgeEffectsInstalled = true;     // Catch: Throwable -> L9
        return;
    L17:
        if (getHeight() <= 0) goto L19;
        r13.setSize(getWidth(), getHeight());     // Catch: Throwable -> L9
        r15.setSize(getWidth(), getHeight());     // Catch: Throwable -> L9
        goto L19
    L26:
        return;
    }

    private final void removeCurrentFlingRunnable(Runnable r10) {
        if (r10 != null) goto L12;
        r10 = null;
        Field r11 = this.flingRunnableField;     // Catch: Throwable -> L15
        if (r11 != null) goto L7;
        Object r12 = null;
    L9:
        if ((r12 instanceof Runnable) == false) goto L12;
        r10 = (Runnable) r12;     // Catch: Throwable -> L15
        goto L12
    L7:
        r12 = r11.get(this);     // Catch: Throwable -> L15
    L12:
        if (r10 == null) goto L18;
        removeCallbacks(r10);
        return;
    }

    public static /* synthetic */ void removeCurrentFlingRunnable$default(OGridView r10, Runnable r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        r10.removeCurrentFlingRunnable(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCurrentFlingRunnable");
    }

    private final void restoreOriginalEdgeEffects() {
        Field r10 = this.edgeFieldTop;
        Field r11 = this.edgeFieldBottom;
        if (r10 != null) goto L29;
    L7:
        if (r11 == null) goto L21;
        Object r12 = this.originalBottomEffect;     // Catch: Throwable -> L12
        if (r12 == null) goto L21;
        r11.set(this, r12);     // Catch: Throwable -> L12
    L12:
        BounceEdgeEffect r13 = this.bounceTop;
        if (r13 == null) goto L16;
        r13.finish();
    L16:
        BounceEdgeEffect r14 = this.bounceBottom;
        if (r14 == null) goto L20;
    L19:
        r14.finish();
    L20:
        this.bounceTop = null;
        this.bounceBottom = null;
        this.edgeEffectsInstalled = false;
        return;
    L21:
        BounceEdgeEffect r15 = this.bounceTop;
        if (r15 == null) goto L25;
        r15.finish();
    L25:
        r14 = this.bounceBottom;
        if (r14 != null) goto L19;
    L29:
        Object r16 = this.originalTopEffect;     // Catch: Throwable -> L12
        if (r16 == null) goto L7;
        r10.set(this, r16);     // Catch: Throwable -> L12
        goto L7
    }

    private final void stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return;
    L5:
        OverScroller r10 = getOverScrollerOrNull();
        BounceEdgeEffect r11 = this.bounceTop;
        if (r11 != null) goto L8;
        float r12 = 0.0f;
    L9:
        boolean r13 = true;
        if (r12 != 0.0f) goto L18;
        BounceEdgeEffect r14 = this.bounceBottom;
        if (r14 != null) goto L14;
        float r15 = 0.0f;
    L16:
        if (r15 != 0.0f) goto L18;
        boolean r16 = false;
    L19:
        BounceEdgeEffect r17 = this.bounceTop;
        if (r17 != null) goto L23;
    L25:
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 != null) goto L29;
    L31:
        r13 = false;
    L32:
        if (r16 == true) goto L34;
        if (r13 == true) goto L34;
    L59:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = computeVerticalScrollOffset();
        return;
    L34:
        if (r10 != null) goto L37;
    L41:
        Runnable r19 = null;
        Field r20 = this.flingRunnableField;     // Catch: Throwable -> L61
        if (r20 != null) goto L45;
        Object r21 = null;
    L47:
        if ((r21 instanceof Runnable) == false) goto L50;
        r19 = (Runnable) r21;     // Catch: Throwable -> L61
        goto L50
    L45:
        r21 = r20.get(this);     // Catch: Throwable -> L61
    L50:
        removeCurrentFlingRunnable(r19);
        BounceEdgeEffect r22 = this.bounceTop;
        if (r22 == null) goto L54;
        r22.stopAnimationForTouch();
    L54:
        BounceEdgeEffect r23 = this.bounceBottom;
        if (r23 == null) goto L58;
        r23.stopAnimationForTouch();
    L58:
        invalidate();
        goto L59
    L37:
        if (r10.isFinished() == true) goto L41;
        if (r10 == null) goto L41;
        r10.abortAnimation();
        goto L41
    L29:
        if (r18.isFinished() == true) goto L31;
    L23:
        if (r17.isFinished() == true) goto L25;
    L14:
        r15 = r14.getTranslation();
    L18:
        r16 = true;
        goto L19
    L8:
        r12 = r11.getTranslation();
        goto L9
    }

    private final boolean tryAbsorbRunningFlingAtEdge(OverScroller r10, float r11) {
        if (r11 > 0.0f) goto L5;
        return false;
    L5:
        boolean r12 = canScrollList(-1);
        boolean r13 = canScrollList(1);
        if (this.lastScrollDirection >= 0) goto L22;
        if (r12 == true) goto L22;
        BounceEdgeEffect r14 = this.bounceTop;
        if (r14 == null) goto L22;
        if (r14.isFinished() != true) goto L22;
        if (BounceDebugLogger.getEnabled() == false) goto L16;
        BounceDebugLogger.log(this, "flingAbsorbTop", q.p("velocity=", Float.valueOf(r11)));
    L16:
        BounceEdgeEffect r15 = this.bounceTop;
        if (r15 == null) goto L20;
        r15.onAbsorb((int) r11);
    L20:
        boolean r16 = true;
    L37:
        if (r16 == false) goto L39;
        r10.abortAnimation();
        removeCurrentFlingRunnable$default(this, null, 1, null);
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        invalidate();
    L39:
        return r16;
    L22:
        if (this.lastScrollDirection <= 0) goto L36;
        if (r13 == true) goto L36;
        BounceEdgeEffect r17 = this.bounceBottom;
        if (r17 == null) goto L36;
        if (r17.isFinished() != true) goto L36;
        if (BounceDebugLogger.getEnabled() == false) goto L32;
        BounceDebugLogger.log(this, "flingAbsorbBottom", q.p("velocity=", Float.valueOf(r11)));
    L32:
        BounceEdgeEffect r18 = this.bounceBottom;
        if (r18 == null) goto L20;
        r18.onAbsorb(-((int) r11));
    L36:
        r16 = false;
        goto L37
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

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.edgeEffectsInstalled == true) goto L6;
        return;
    L6:
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) goto L8;
        return;
    L8:
        int r10 = computeVerticalScrollOffset();
        OverScroller r11 = getOverScrollerOrNull();
        if (r11 != null) goto L11;
    L22:
        float r12 = this.lastScrollerVelocity;
        if (r12 <= 0.0f) goto L37;
        boolean r13 = canScrollList(-1);
        boolean r14 = canScrollList(1);
        int r15 = this.lastScrollDirection;
        if (r15 >= 0) goto L31;
        if (r13 == true) goto L31;
        BounceEdgeEffect r16 = this.bounceTop;
        if (r16 == null) goto L37;
        r16.onAbsorb((int) r12);
    L31:
        if (r15 <= 0) goto L37;
        if (r14 == true) goto L37;
        BounceEdgeEffect r17 = this.bounceBottom;
        if (r17 == null) goto L37;
        r17.onAbsorb(-((int) r12));
    L37:
        this.lastScrollerVelocity = 0.0f;
        this.lastScrollDirection = 0;
        this.lastVerticalScrollOffset = r10;
        return;
    L11:
        if (r11.isFinished() == true) goto L22;
        this.lastScrollerVelocity = r11.getCurrVelocity();
        int r18 = r10 - this.lastVerticalScrollOffset;
        if (r18 <= 0) goto L15;
        this.lastScrollDirection = 1;
    L18:
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        BounceDebugLogger.log(this, "flingFrame", "offset=" + r10 + " delta=" + r18 + " velocity=" + this.lastScrollerVelocity + " direction=" + this.lastScrollDirection);
    L20:
        this.lastVerticalScrollOffset = r10;
        tryAbsorbRunningFlingAtEdge(r11, this.lastScrollerVelocity);
        return;
    L15:
        if (r18 >= 0) goto L18;
        this.lastScrollDirection = -1;
        goto L18
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        if (r10.getActionMasked() != 0) goto L5;
        this.touchDownTranslationY = getBounceTranslation();
    L5:
        float r11 = this.touchDownTranslationY;
        if (r11 == 0.0f) goto L8;
        r10.offsetLocation(0.0f, -r11);
        boolean r12 = super.dispatchTouchEvent(r10);
        r10.offsetLocation(0.0f, r11);
        if (r10.getActionMasked() != 1) goto L17;
    L18:
        this.touchDownTranslationY = 0.0f;
    L19:
        return r12;
    L17:
        if (r10.getActionMasked() != 3) goto L19;
    L8:
        if (r10.getActionMasked() != 1) goto L10;
    L11:
        this.touchDownTranslationY = 0.0f;
    L13:
        return super.dispatchTouchEvent(r10);
    L10:
        if (r10.getActionMasked() != 3) goto L13;
        goto L11
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

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BounceEdgeEffect r10 = this.bounceTop;
        if (r10 == null) goto L6;
        r10.finish();
    L6:
        BounceEdgeEffect r11 = this.bounceBottom;
        if (r11 == null) goto L11;
        r11.finish();
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        if (r10.getActionMasked() != 0) goto L6;
        stopBounceIfNeeded();
    L6:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.widget.AbsListView, android.view.View
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

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        if (r10.getActionMasked() != 0) goto L6;
        stopBounceIfNeeded();
    L6:
        return super.onTouchEvent(r10);
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(@Nullable OnBounceTranslationListener r10) {
        this.translationDelegate.setOnBounceTranslationListener(r10);
    }

    @JvmOverloads
    public OGridView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OGridView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = R.attr.gridViewStyle;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OGridView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.overscrollDelegate = new BounceOverscrollDelegate(new OGridView$overscrollDelegate$1(this), new OGridView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OGridView$translationDelegate$1(this), new OGridView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/AbsListView;");
        initEdgeEffectReflection();
        installBounceEdgeEffects();
    }
}
