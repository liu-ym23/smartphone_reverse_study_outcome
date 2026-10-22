package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.e;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] ENABLED_STATE_SET = null;
    static final int[] FOCUSED_ENABLED_STATE_SET = null;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private int animState;

    @Nullable
    BorderDrawable borderDrawable;

    @Nullable
    Drawable contentBackground;

    @Nullable
    private Animator currentAnimator;

    @Nullable
    private MotionSpec defaultHideMotionSpec;

    @Nullable
    private MotionSpec defaultShowMotionSpec;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;

    @Nullable
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private float imageMatrixScale;
    private int maxImageSize;
    int minTouchTargetSize;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;

    @Nullable
    Drawable rippleDrawable;
    private float rotation;
    boolean shadowPaddingEnabled;
    final ShadowViewDelegate shadowViewDelegate;

    @Nullable
    ShapeAppearanceModel shapeAppearance;

    @Nullable
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;

    @Nullable
    private MotionSpec showMotionSpec;

    @NonNull
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements TypeEvaluator<Float> {
        FloatEvaluator floatEvaluator;
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public AnonymousClass4(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
            this.floatEvaluator = new FloatEvaluator();
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Float evaluate(float r10, Float r11, Float r12) {
            return evaluate2(r10, r11, r12);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Float evaluate2(float r10, Float r11, Float r12) {
            float r13 = this.floatEvaluator.evaluate(r10, r11, r12).floatValue();
            if (r13 >= 0.1f) goto L6;
            r13 = 0.0f;
        L6:
            return Float.valueOf(r13);
        }
    }

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public DisabledElevationAnimation(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r10 = this.this$0;
            return r10.elevation + r10.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r10 = this.this$0;
            return r10.elevation + r10.pressedTranslationZ;
        }
    }

    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ResetElevationAnimation(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return this.this$0.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        final /* synthetic */ FloatingActionButtonImpl this$0;
        private boolean validValues;

        private ShadowAnimatorImpl(FloatingActionButtonImpl r10) {
            this.this$0 = r10;
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            if (this.validValues == true) goto L9;
            MaterialShapeDrawable r11 = this.this$0.shapeDrawable;
            if (r11 != null) goto L7;
            float r12 = 0.0f;
        L8:
            this.shadowSizeStart = r12;
            this.shadowSizeEnd = getTargetShadowSize();
            this.validValues = true;
            goto L9
        L7:
            r12 = r11.getElevation();
        L9:
            FloatingActionButtonImpl r13 = this.this$0;
            float r14 = this.shadowSizeStart;
            r13.updateShapeElevation((int) (r14 + ((this.shadowSizeEnd - r14) * r10.getAnimatedFraction())));
        }

        public /* synthetic */ ShadowAnimatorImpl(FloatingActionButtonImpl r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        PRESSED_ENABLED_STATE_SET = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
        FOCUSED_ENABLED_STATE_SET = new int[]{R.attr.state_focused, R.attr.state_enabled};
        HOVERED_ENABLED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        ENABLED_STATE_SET = new int[]{R.attr.state_enabled};
        EMPTY_STATE_SET = new int[0];
    }

    public FloatingActionButtonImpl(FloatingActionButton r10, ShadowViewDelegate r11) {
        this.shadowPaddingEnabled = true;
        this.imageMatrixScale = 1.0f;
        this.animState = 0;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = r10;
        this.shadowViewDelegate = r11;
        StateListAnimator r12 = new StateListAnimator();
        this.stateListAnimator = r12;
        r12.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        r12.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r12.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r12.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r12.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        r12.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = r10.getRotation();
    }

    public static /* synthetic */ int access$002(FloatingActionButtonImpl r10, int r11) {
        r10.animState = r11;
        return r11;
    }

    public static /* synthetic */ Animator access$102(FloatingActionButtonImpl r10, Animator r11) {
        r10.currentAnimator = r11;
        return r11;
    }

    public static /* synthetic */ float access$202(FloatingActionButtonImpl r10, float r11) {
        r10.imageMatrixScale = r11;
        return r11;
    }

    private void calculateImageMatrixFromScale(float r10, @NonNull Matrix r11) {
        r11.reset();
        Drawable r12 = this.view.getDrawable();
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.maxImageSize == 0) goto L9;
        RectF r13 = this.tmpRectF1;
        RectF r14 = this.tmpRectF2;
        r13.set(0.0f, 0.0f, r12.getIntrinsicWidth(), r12.getIntrinsicHeight());
        int r15 = this.maxImageSize;
        r14.set(0.0f, 0.0f, r15, r15);
        r11.setRectToRect(r13, r14, Matrix.ScaleToFit.CENTER);
        int r16 = this.maxImageSize;
        r11.postScale(r10, r10, r16 / 2.0f, r16 / 2.0f);
        return;
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec r10, float r11, float r12, float r13) {
        ArrayList r14 = new ArrayList();
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{r11});
        r10.getTiming("opacity").apply(r15);
        r14.add(r15);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{r12});
        r10.getTiming("scale").apply(r16);
        workAroundOreoBug(r16);
        r14.add(r16);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{r12});
        r10.getTiming("scale").apply(r17);
        workAroundOreoBug(r17);
        r14.add(r17);
        calculateImageMatrixFromScale(r13, this.tmpMatrix);
        ObjectAnimator r18 = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new AnonymousClass3(this), new Matrix[]{new Matrix(this.tmpMatrix)});
        r10.getTiming("iconScale").apply(r18);
        r14.add(r18);
        AnimatorSet r19 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r19, r14);
        return r19;
    }

    @NonNull
    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl r10) {
        ValueAnimator r11 = new ValueAnimator();
        r11.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r11.setDuration(100);
        r11.addListener(r10);
        r11.addUpdateListener(r10);
        r11.setFloatValues(new float[]{0.0f, 1.0f});
        return r11;
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec != null) goto L6;
        this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
    L6:
        return (MotionSpec) e.g(this.defaultHideMotionSpec);
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec != null) goto L6;
        this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
    L6:
        return (MotionSpec) e.g(this.defaultShowMotionSpec);
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener != null) goto L6;
        this.preDrawListener = new AnonymousClass5(this);
    L6:
        return this.preDrawListener;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.T(this.view) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.view.isInEditMode() == true) goto L7;
        return true;
    }

    private void workAroundOreoBug(ObjectAnimator r10) {
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        if (this.hideListeners != null) goto L5;
        this.hideListeners = new ArrayList();
    L5:
        this.hideListeners.add(r10);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        if (this.showListeners != null) goto L5;
        this.showListeners = new ArrayList();
    L5:
        this.showListeners.add(r10);
    }

    public void addTransformationCallback(@NonNull InternalTransformationCallback r10) {
        if (this.transformationCallbacks != null) goto L5;
        this.transformationCallbacks = new ArrayList();
    L5:
        this.transformationCallbacks.add(r10);
    }

    public MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) e.g(this.shapeAppearance));
    }

    @Nullable
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    @Nullable
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(@NonNull Rect r10) {
        if (this.ensureMinTouchTargetSize == false) goto L5;
        int r11 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
    L7:
        if (this.shadowPaddingEnabled == false) goto L9;
        float r12 = getElevation() + this.pressedTranslationZ;
    L10:
        int r13 = Math.max(r11, (int) Math.ceil(r12));
        int r14 = Math.max(r11, (int) Math.ceil(r12 * 1.5f));
        r10.set(r13, r14, r13, r14);
        return;
    L9:
        r12 = 0.0f;
        goto L10
    L5:
        r11 = 0;
        goto L7
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @Nullable
    public final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    @Nullable
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void hide(@Nullable final InternalVisibilityChangedListener r10, final boolean r11) {
        if (isOrWillBeHidden() == false) goto L5;
        return;
    L5:
        Animator r12 = this.currentAnimator;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == false) goto L21;
        MotionSpec r13 = this.hideMotionSpec;
        if (r13 != null) goto L14;
        r13 = getDefaultHideMotionSpec();
    L14:
        AnimatorSet r14 = createAnimator(r13, 0.0f, 0.0f, 0.0f);
        r14.addListener(new AnonymousClass1(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r15 = this.hideListeners;
        if (r15 == null) goto L20;
        Iterator<Animator.AnimatorListener> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        r14.addListener(r16.next());
    L20:
        r14.start();
        return;
    L21:
        FloatingActionButton r17 = this.view;
        if (r11 == false) goto L24;
        int r18 = 8;
    L25:
        r17.internalSetVisibility(r18, r11);
        if (r10 == null) goto L31;
        r10.onHidden();
        return;
    L31:
        return;
    L24:
        r18 = 4;
        goto L25
    }

    public void initializeBackgroundDrawable(ColorStateList r10, @Nullable PorterDuff.Mode r11, ColorStateList r12, int r13) {
        MaterialShapeDrawable r14 = createShapeDrawable();
        this.shapeDrawable = r14;
        r14.setTintList(r10);
        if (r11 == null) goto L5;
        this.shapeDrawable.setTintMode(r11);
    L5:
        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        RippleDrawableCompat r15 = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        r15.setTintList(RippleUtils.sanitizeRippleDrawableColor(r12));
        this.rippleDrawable = r15;
        this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) e.g(this.shapeDrawable), r15});
    }

    public boolean isOrWillBeHidden() {
        if (this.view.getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isOrWillBeShown() {
        if (this.view.getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public void onAttachedToWindow() {
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this.view, r10);
    L6:
        if (requirePreDrawListener() == false) goto L9;
        this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
        return;
    }

    public void onCompatShadowChanged() {
    }

    public void onDetachedFromWindow() {
        ViewTreeObserver r10 = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r11 = this.preDrawListener;
        if (r11 == null) goto L6;
        r10.removeOnPreDrawListener(r11);
        this.preDrawListener = null;
        return;
    }

    public void onDrawableStateChanged(int[] r10) {
        this.stateListAnimator.setState(r10);
    }

    public void onElevationsChanged(float r10, float r11, float r12) {
        updatePadding();
        updateShapeElevation(r10);
    }

    public void onPaddingUpdated(@NonNull Rect r10) {
        e.h(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding() == false) goto L5;
        InsetDrawable r11 = new InsetDrawable(this.contentBackground, r10.left, r10.top, r10.right, r10.bottom);
        this.shadowViewDelegate.setBackgroundDrawable(r11);
        return;
    L5:
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    public void onPreDraw() {
        float r10 = this.view.getRotation();
        if (this.rotation == r10) goto L6;
        this.rotation = r10;
        updateFromViewRotation();
        return;
    }

    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> r10 = this.transformationCallbacks;
        if (r10 == null) goto L8;
        Iterator<InternalTransformationCallback> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().onScaleChanged();
        goto L6
    L10:
        return;
    }

    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> r10 = this.transformationCallbacks;
        if (r10 == null) goto L8;
        Iterator<InternalTransformationCallback> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().onTranslationChanged();
        goto L6
    L10:
        return;
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r10) {
        ArrayList<Animator.AnimatorListener> r11 = this.hideListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r10) {
        ArrayList<Animator.AnimatorListener> r11 = this.showListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void removeTransformationCallback(@NonNull InternalTransformationCallback r10) {
        ArrayList<InternalTransformationCallback> r11 = this.transformationCallbacks;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundTintList(@Nullable ColorStateList r10) {
        MaterialShapeDrawable r11 = this.shapeDrawable;
        if (r11 == null) goto L5;
        r11.setTintList(r10);
    L5:
        BorderDrawable r12 = this.borderDrawable;
        if (r12 == null) goto L9;
        r12.setBorderTint(r10);
        return;
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        MaterialShapeDrawable r11 = this.shapeDrawable;
        if (r11 == null) goto L6;
        r11.setTintMode(r10);
        return;
    }

    public final void setElevation(float r10) {
        if (this.elevation == r10) goto L6;
        this.elevation = r10;
        onElevationsChanged(r10, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        return;
    }

    public void setEnsureMinTouchTargetSize(boolean r10) {
        this.ensureMinTouchTargetSize = r10;
    }

    public final void setHideMotionSpec(@Nullable MotionSpec r10) {
        this.hideMotionSpec = r10;
    }

    public final void setHoveredFocusedTranslationZ(float r10) {
        if (this.hoveredFocusedTranslationZ == r10) goto L6;
        this.hoveredFocusedTranslationZ = r10;
        onElevationsChanged(this.elevation, r10, this.pressedTranslationZ);
        return;
    }

    public final void setImageMatrixScale(float r10) {
        this.imageMatrixScale = r10;
        Matrix r11 = this.tmpMatrix;
        calculateImageMatrixFromScale(r10, r11);
        this.view.setImageMatrix(r11);
    }

    public final void setMaxImageSize(int r10) {
        if (this.maxImageSize == r10) goto L6;
        this.maxImageSize = r10;
        updateImageMatrixScale();
        return;
    }

    public void setMinTouchTargetSize(int r10) {
        this.minTouchTargetSize = r10;
    }

    public final void setPressedTranslationZ(float r10) {
        if (this.pressedTranslationZ == r10) goto L6;
        this.pressedTranslationZ = r10;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, r10);
        return;
    }

    public void setRippleColor(@Nullable ColorStateList r10) {
        Drawable r11 = this.rippleDrawable;
        if (r11 == null) goto L6;
        a.i(r11, RippleUtils.sanitizeRippleDrawableColor(r10));
        return;
    }

    public void setShadowPaddingEnabled(boolean r10) {
        this.shadowPaddingEnabled = r10;
        updatePadding();
    }

    public final void setShapeAppearance(@NonNull ShapeAppearanceModel r10) {
        this.shapeAppearance = r10;
        MaterialShapeDrawable r11 = this.shapeDrawable;
        if (r11 == null) goto L5;
        r11.setShapeAppearanceModel(r10);
    L5:
        Object r12 = this.rippleDrawable;
        if ((r12 instanceof Shapeable) == false) goto L8;
        ((Shapeable) r12).setShapeAppearanceModel(r10);
    L8:
        BorderDrawable r13 = this.borderDrawable;
        if (r13 == null) goto L12;
        r13.setShapeAppearanceModel(r10);
        return;
    }

    public final void setShowMotionSpec(@Nullable MotionSpec r10) {
        this.showMotionSpec = r10;
    }

    public boolean shouldAddPadding() {
        return true;
    }

    public final boolean shouldExpandBoundsForA11y() {
        if (this.ensureMinTouchTargetSize == true) goto L5;
    L8:
        return true;
    L5:
        if (this.view.getSizeDimension() >= this.minTouchTargetSize) goto L8;
        return false;
    }

    public void show(@Nullable final InternalVisibilityChangedListener r10, final boolean r11) {
        if (isOrWillBeShown() == false) goto L5;
        return;
    L5:
        Animator r12 = this.currentAnimator;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == true) goto L11;
        this.view.internalSetVisibility(0, r11);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (r10 == null) goto L30;
        r10.onShown();
        return;
    L30:
        return;
    L11:
        if (this.view.getVisibility() == 0) goto L13;
        this.view.setAlpha(0.0f);
        this.view.setScaleY(0.0f);
        this.view.setScaleX(0.0f);
        setImageMatrixScale(0.0f);
    L13:
        MotionSpec r13 = this.showMotionSpec;
        if (r13 != null) goto L17;
        r13 = getDefaultShowMotionSpec();
    L17:
        AnimatorSet r14 = createAnimator(r13, 1.0f, 1.0f, 1.0f);
        r14.addListener(new AnonymousClass2(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r15 = this.showListeners;
        if (r15 == null) goto L23;
        Iterator<Animator.AnimatorListener> r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        r14.addListener(r16.next());
    L23:
        r14.start();
    }

    public void updateFromViewRotation() {
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L6;
        r10.setShadowCompatRotation((int) this.rotation);
        return;
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        Rect r10 = this.tmpRect;
        getPadding(r10);
        onPaddingUpdated(r10);
        this.shadowViewDelegate.setShadowPadding(r10.left, r10.top, r10.right, r10.bottom);
    }

    public void updateShapeElevation(float r10) {
        MaterialShapeDrawable r11 = this.shapeDrawable;
        if (r11 == null) goto L6;
        r11.setElevation(r10);
        return;
    }
}
