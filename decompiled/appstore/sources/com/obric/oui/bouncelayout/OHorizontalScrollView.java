package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\u0012\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010(\u001a\u00020\u000eJ\b\u0010)\u001a\u00020\u001dH\u0014J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016J(\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0014J\u0010\u00102\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0016JP\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u000eH\u0014J\b\u0010=\u001a\u00020\u001dH\u0002J\b\u0010>\u001a\u00020\bH\u0002J\b\u0010?\u001a\u00020\u001dH\u0002J\u0012\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u000eH\u0002J\u001e\u0010D\u001a\u0004\u0018\u00010\u00112\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F2\u0006\u0010G\u001a\u00020HH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lcom/obric/oui/bouncelayout/IBounceTranslationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounceLeft", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "bounceRight", "bounceStoppedForTouch", "", "edgeEffectsInstalled", "edgeFieldLeft", "Ljava/lang/reflect/Field;", "edgeFieldRight", "edgeFieldsResolved", "originalLeftEffect", "Landroid/widget/EdgeEffect;", "originalRightEffect", "overscrollDelegate", "Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "scrollerField", "translationDelegate", "Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "abortCurrentFling", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "getBounceTranslation", "", "getCurrentFlingVelocity", "initEdgeEffectReflection", "installBounceEdgeEffectsIfPossible", "isBounceEffectActive", "effect", "isOverScrolling", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "releaseStoppedBounceIfNeeded", "resolveStoppedBounceReleaseEdge", "restoreOriginalEdgeEffects", "setOnBounceTranslationListener", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "stopBounceIfNeeded", "tryGetField", "clazz", "Ljava/lang/Class;", "name", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OHorizontalScrollView extends HorizontalScrollView implements IBounceTranslationView {
    private static final int BOUNCE_EDGE_NONE = -1;

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    public static final String TAG = "OHorizontalScrollView";

    @Nullable
    private BounceEdgeEffect bounceLeft;

    @Nullable
    private BounceEdgeEffect bounceRight;
    private boolean bounceStoppedForTouch;
    private boolean edgeEffectsInstalled;

    @Nullable
    private Field edgeFieldLeft;

    @Nullable
    private Field edgeFieldRight;
    private boolean edgeFieldsResolved;

    @Nullable
    private EdgeEffect originalLeftEffect;

    @Nullable
    private EdgeEffect originalRightEffect;

    @NotNull
    private final BounceOverscrollDelegate overscrollDelegate;

    @Nullable
    private Field scrollerField;

    @NotNull
    private final BounceTranslationDelegate translationDelegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/bouncelayout/OHorizontalScrollView$Companion;", "", "()V", "BOUNCE_EDGE_NONE", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public OHorizontalScrollView(@NotNull Context r10) {
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

    public static final /* synthetic */ BounceEdgeEffect access$getBounceLeft$p(OHorizontalScrollView r10) {
        return r10.bounceLeft;
    }

    public static final /* synthetic */ BounceEdgeEffect access$getBounceRight$p(OHorizontalScrollView r10) {
        return r10.bounceRight;
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

    private final void initEdgeEffectReflection() {
        if (this.edgeFieldsResolved == false) goto L5;
        return;
    L5:
        this.edgeFieldsResolved = true;
        Field r10 = tryGetField(HorizontalScrollView.class, "mEdgeGlowLeft");     // Catch: Throwable -> L11
        if (r10 != null) goto L13;
        r10 = tryGetField(HorizontalScrollView.class, "mLeftGlow");     // Catch: Throwable -> L11
        if (r10 != null) goto L13;
        r10 = tryGetField(HorizontalScrollView.class, "mEdgeEffectLeft");     // Catch: Throwable -> L11
    L13:
        this.edgeFieldLeft = r10;     // Catch: Throwable -> L11
        Field r11 = tryGetField(HorizontalScrollView.class, "mEdgeGlowRight");     // Catch: Throwable -> L11
        if (r11 != null) goto L18;
        r11 = tryGetField(HorizontalScrollView.class, "mRightGlow");     // Catch: Throwable -> L11
        if (r11 != null) goto L18;
        r11 = tryGetField(HorizontalScrollView.class, "mEdgeEffectRight");     // Catch: Throwable -> L11
    L18:
        this.edgeFieldRight = r11;     // Catch: Throwable -> L11
        this.scrollerField = tryGetField(HorizontalScrollView.class, "mScroller");     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Log.w(TAG, "Failed to reflect fields", th);
        this.edgeFieldLeft = null;
        this.edgeFieldRight = null;
        this.scrollerField = null;
    }

    private final void installBounceEdgeEffectsIfPossible() {
        if (this.bounceLeft == null) goto L5;
        return;
    L5:
        if (this.bounceRight != null) goto L36;
        this.overscrollDelegate.onSizeChanged();
        Field r10 = this.edgeFieldLeft;
        if (r10 != null) goto L10;
        return;
    L10:
        Field r11 = this.edgeFieldRight;
        if (r11 != null) goto L33;
        return;
    L33:
        Object r12 = r10.get(this);     // Catch: Throwable -> L17
        if ((r12 instanceof EdgeEffect) == false) goto L19;
        EdgeEffect r13 = (EdgeEffect) r12;     // Catch: Throwable -> L17
    L20:
        this.originalLeftEffect = r13;     // Catch: Throwable -> L17
        Object r14 = r11.get(this);     // Catch: Throwable -> L17
        if ((r14 instanceof EdgeEffect) == false) goto L23;
        EdgeEffect r15 = (EdgeEffect) r14;     // Catch: Throwable -> L17
    L24:
        this.originalRightEffect = r15;     // Catch: Throwable -> L17
        Context r16 = getContext();     // Catch: Throwable -> L17
        q.f(r16, "context");     // Catch: Throwable -> L17
        BounceEdgeEffect r17 = new BounceEdgeEffect(r16, this, 2, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L17
        r17.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L17
        Context r18 = getContext();     // Catch: Throwable -> L17
        q.f(r18, "context");     // Catch: Throwable -> L17
        BounceEdgeEffect r19 = new BounceEdgeEffect(r18, this, 3, this.overscrollDelegate.getMaxOverscrollPx());     // Catch: Throwable -> L17
        r19.setUseHeightForHorizontalSize(true);     // Catch: Throwable -> L17
        if (getWidth() > 0) goto L27;
    L29:
        r10.set(this, r17);     // Catch: Throwable -> L17
        r11.set(this, r19);     // Catch: Throwable -> L17
        this.bounceLeft = r17;     // Catch: Throwable -> L17
        this.bounceRight = r19;     // Catch: Throwable -> L17
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
        this.bounceLeft = null;
        this.bounceRight = null;
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

    private final void releaseStoppedBounceIfNeeded() {
        if (this.bounceStoppedForTouch == true) goto L5;
        return;
    L5:
        int r10 = resolveStoppedBounceReleaseEdge();
        if (r10 != 2) goto L8;
        BounceEdgeEffect r11 = this.bounceLeft;
        if (r11 == null) goto L18;
        r11.onRelease();
    L18:
        this.bounceStoppedForTouch = false;
        invalidate();
        return;
    L8:
        if (r10 != 3) goto L18;
        BounceEdgeEffect r12 = this.bounceRight;
        if (r12 == null) goto L18;
        r12.onRelease();
        goto L18
    }

    private final int resolveStoppedBounceReleaseEdge() {
        boolean r10 = isBounceEffectActive(this.bounceLeft);
        boolean r11 = isBounceEffectActive(this.bounceRight);
        if (r10 == false) goto L7;
        if (r11 == true) goto L7;
        return 2;
    L7:
        if (r11 == false) goto L10;
        if (r10 == true) goto L10;
    L26:
        return 3;
    L10:
        BounceEdgeEffect r12 = this.bounceLeft;
        if (r12 != null) goto L13;
        float r13 = 0.0f;
    L15:
        if (r13 > 0.0f) goto L28;
        BounceEdgeEffect r14 = this.bounceRight;
        if (r14 != null) goto L20;
        float r15 = 0.0f;
    L22:
        if (r15 < 0.0f) goto L26;
        return -1;
    L20:
        r15 = r14.getTranslation();
        goto L22
    L28:
        return 2;
    L13:
        r13 = r12.getTranslation();
        goto L15
    }

    private final void restoreOriginalEdgeEffects() {
        Field r10 = this.edgeFieldLeft;     // Catch: Throwable -> L11
        if (r10 == null) goto L6;
        r10.set(this, this.originalLeftEffect);     // Catch: Throwable -> L11
    L6:
        Field r11 = this.edgeFieldRight;     // Catch: Throwable -> L11
        if (r11 == null) goto L16;
        r11.set(this, this.originalRightEffect);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        Log.w(TAG, "Failed to restore original edge effects", th);
    }

    private final boolean stopBounceIfNeeded() {
        if (this.edgeEffectsInstalled == true) goto L5;
        return false;
    L5:
        BounceEdgeEffect r10 = this.bounceLeft;
        if (r10 != null) goto L8;
        float r11 = 0.0f;
    L10:
        if (r11 != 0.0f) goto L18;
        BounceEdgeEffect r12 = this.bounceRight;
        if (r12 != null) goto L14;
        float r13 = 0.0f;
    L16:
        if (r13 != 0.0f) goto L18;
        boolean r14 = false;
    L19:
        BounceEdgeEffect r15 = this.bounceLeft;
        if (r15 != null) goto L23;
    L25:
        BounceEdgeEffect r16 = this.bounceRight;
        if (r16 != null) goto L29;
    L31:
        boolean r17 = false;
    L32:
        if (r14 == true) goto L36;
        if (r17 == true) goto L36;
        return false;
    L36:
        Field r18 = this.scrollerField;
        OverScroller r19 = null;
        if (r18 != null) goto L39;
        Object r20 = null;
    L41:
        if ((r20 instanceof OverScroller) == false) goto L43;
        r19 = (OverScroller) r20;
    L43:
        if (r19 == null) goto L46;
        r19.abortAnimation();
    L46:
        BounceEdgeEffect r21 = this.bounceLeft;
        if (r21 == null) goto L50;
        r21.stopAnimationForTouch();
    L50:
        BounceEdgeEffect r22 = this.bounceRight;
        if (r22 == null) goto L54;
        r22.stopAnimationForTouch();
    L54:
        invalidate();
        return true;
    L39:
        r20 = r18.get(this);
        goto L41
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
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@Nullable Canvas r10) {
        if (r10 != null) goto L4;
    L19:
        super.dispatchDraw(r10);
        return;
    L4:
        if (this.edgeEffectsInstalled == false) goto L19;
        BounceEdgeEffect r11 = this.bounceLeft;
        if (r11 != null) goto L9;
        float r12 = 0.0f;
    L10:
        BounceEdgeEffect r13 = this.bounceRight;
        if (r13 != null) goto L13;
        float r14 = 0.0f;
    L14:
        float r15 = r12 + r14;
        if (r15 != 0.0f) goto L17;
        super.dispatchDraw(r10);
        return;
    L17:
        int r16 = r10.save();
        r10.translate(r15, 0.0f);
        super.dispatchDraw(r10);
        r10.restoreToCount(r16);
        return;
    L13:
        r14 = r13.getTranslation();
        goto L14
    L9:
        r12 = r11.getTranslation();
        goto L10
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public float getBounceTranslation() {
        BounceEdgeEffect r10 = this.bounceLeft;
        float r11 = 0.0f;
        if (r10 != null) goto L5;
        float r12 = 0.0f;
    L6:
        BounceEdgeEffect r13 = this.bounceRight;
        if (r13 == null) goto L11;
        r11 = r13.getTranslation();
    L11:
        return r12 + r11;
    L5:
        r12 = r10.getTranslation();
        goto L6
    }

    public final boolean isOverScrolling() {
        BounceEdgeEffect r10 = this.bounceLeft;
        if (r10 == null) goto L9;
        q.d(r10);
        if (r10.getDistance() != 0.0f) goto L8;
        BounceEdgeEffect r11 = this.bounceLeft;
        q.d(r11);
        if (r11.isFinished() == true) goto L9;
    L8:
        boolean r12 = true;
    L10:
        BounceEdgeEffect r13 = this.bounceRight;
        if (r13 == null) goto L17;
        q.d(r13);
        if (r13.getDistance() != 0.0f) goto L16;
        BounceEdgeEffect r14 = this.bounceRight;
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
        super.onDetachedFromWindow();
        BounceEdgeEffect r10 = this.bounceLeft;
        if (r10 == null) goto L6;
        r10.finish();
    L6:
        BounceEdgeEffect r11 = this.bounceRight;
        if (r11 == null) goto L10;
        r11.finish();
    L10:
        restoreOriginalEdgeEffects();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        if (r10.getActionMasked() != 0) goto L6;
        this.bounceStoppedForTouch = stopBounceIfNeeded();
    L6:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        this.overscrollDelegate.onSizeChanged();
        BounceEdgeEffect r14 = this.bounceLeft;
        if (r14 == null) goto L6;
        r14.setSize(r10, r11);
    L6:
        BounceEdgeEffect r15 = this.bounceRight;
        if (r15 == null) goto L11;
        r15.setSize(r10, r11);
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent r10) {
        q.g(r10, "ev");
        int r11 = r10.getActionMasked();
        boolean r12 = true;
        if (r11 == 0) goto L18;
        if (r11 != 1) goto L6;
    L8:
        BounceEdgeEffect r13 = this.bounceLeft;
        if (r13 == null) goto L12;
        r13.updateTouchDeltaX(0.0f);
    L12:
        BounceEdgeEffect r14 = this.bounceRight;
        if (r14 == null) goto L16;
        r14.updateTouchDeltaX(0.0f);
    L16:
        releaseStoppedBounceIfNeeded();
    L25:
        return super.onTouchEvent(r10);
    L6:
        if (r11 == 3) goto L8;
    L18:
        if (stopBounceIfNeeded() == false) goto L20;
    L23:
        this.bounceStoppedForTouch = r12;
        goto L25
    L20:
        if (this.bounceStoppedForTouch == true) goto L23;
        r12 = false;
        goto L23
    }

    @Override // android.view.View
    public boolean overScrollBy(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, boolean r18) {
        if (r18 == true) goto L4;
    L13:
        boolean r19 = super.overScrollBy(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        if (r18 == false) goto L16;
    L60:
        return r19;
    L16:
        if (this.edgeEffectsInstalled == false) goto L60;
        if (r14 <= 0) goto L60;
        int r20 = r12 + r10;
        if (BounceDebugLogger.getEnabled() == false) goto L22;
        BounceDebugLogger.log(this, "overScrollFlingFrame", "scrollX=" + r12 + " deltaX=" + r10 + " finalScrollX=" + r20 + " range=" + r14);
    L22:
        if (r20 > 0) goto L41;
        if (r10 >= 0) goto L41;
        BounceEdgeEffect r110 = this.bounceLeft;
        if (r110 == null) goto L41;
        if (r110.isFinished() != true) goto L41;
        float r111 = getCurrentFlingVelocity();
        int r21 = Math.abs(r20);
        BounceEdgeEffect r22 = this.bounceLeft;
        if (r22 == null) goto L34;
        r22.onPull(r21 / getWidth(), 0.5f);
    L34:
        if (BounceDebugLogger.getEnabled() == false) goto L36;
        BounceDebugLogger.log(this, "flingAbsorbLeft", "velocity=" + r111 + " overscroll=" + r21);
    L36:
        BounceEdgeEffect r23 = this.bounceLeft;
        if (r23 == null) goto L40;
        r23.onAbsorb((int) r111);
    L40:
        abortCurrentFling();
    L41:
        if (r20 < r14) goto L60;
        if (r10 <= 0) goto L60;
        BounceEdgeEffect r24 = this.bounceRight;
        if (r24 == null) goto L60;
        if (r24.isFinished() != true) goto L60;
        float r25 = getCurrentFlingVelocity();
        int r26 = r20 - r14;
        BounceEdgeEffect r27 = this.bounceRight;
        if (r27 == null) goto L53;
        r27.onPull(r26 / getWidth(), 0.5f);
    L53:
        if (BounceDebugLogger.getEnabled() == false) goto L55;
        BounceDebugLogger.log(this, "flingAbsorbRight", "velocity=" + r25 + " overscroll=" + r26);
    L55:
        BounceEdgeEffect r28 = this.bounceRight;
        if (r28 == null) goto L59;
        r28.onAbsorb(-((int) r25));
    L59:
        abortCurrentFling();
        goto L60
    L4:
        if (this.edgeEffectsInstalled == false) goto L13;
        float r29 = r10;
        BounceEdgeEffect r30 = this.bounceLeft;
        if (r30 == null) goto L9;
        r30.updateTouchDeltaX(r29);
    L9:
        BounceEdgeEffect r31 = this.bounceRight;
        if (r31 == null) goto L13;
        r31.updateTouchDeltaX(r29);
        goto L13
    }

    @Override // com.obric.oui.bouncelayout.IBounceTranslationView
    public void setOnBounceTranslationListener(@Nullable OnBounceTranslationListener r10) {
        this.translationDelegate.setOnBounceTranslationListener(r10);
    }

    @JvmOverloads
    public OHorizontalScrollView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OHorizontalScrollView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OHorizontalScrollView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.overscrollDelegate = new BounceOverscrollDelegate(new OHorizontalScrollView$overscrollDelegate$1(this), new OHorizontalScrollView$overscrollDelegate$2(this));
        this.translationDelegate = new BounceTranslationDelegate(new OHorizontalScrollView$translationDelegate$1(this), new OHorizontalScrollView$translationDelegate$2(this));
        setOverScrollMode(0);
        BounceEdgeEffect.Companion.bypassHiddenApi("Landroid/widget/HorizontalScrollView;");
        initEdgeEffectReflection();
        installBounceEdgeEffectsIfPossible();
    }
}
