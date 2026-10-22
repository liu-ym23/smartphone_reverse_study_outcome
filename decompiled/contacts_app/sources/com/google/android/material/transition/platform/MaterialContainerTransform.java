package com.google.android.material.transition.platform;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialContainerTransform extends Transition {
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS = null;
    private static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC = null;
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;
    private boolean appliedThemeValues;
    private int containerColor;
    private boolean drawDebugEnabled;
    private int drawingViewId;
    private boolean elevationShadowEnabled;
    private int endContainerColor;
    private float endElevation;
    private ShapeAppearanceModel endShapeAppearanceModel;
    private View endView;
    private int endViewId;
    private int fadeMode;
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;
    private ProgressThresholds scaleMaskProgressThresholds;
    private ProgressThresholds scaleProgressThresholds;
    private int scrimColor;
    private ProgressThresholds shapeMaskProgressThresholds;
    private int startContainerColor;
    private float startElevation;
    private ShapeAppearanceModel startShapeAppearanceModel;
    private View startView;
    private int startViewId;
    private int transitionDirection;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    public static class ProgressThresholds {
        private final float end;
        private final float start;

        static /* synthetic */ float access$1000(ProgressThresholds r0) {
            return r0.start;
        }

        static /* synthetic */ float access$1100(ProgressThresholds r0) {
            return r0.end;
        }

        public ProgressThresholds(float r1, float r2) {
            this.start = r1;
            this.end = r2;
        }

        public float getStart() {
            return this.start;
        }

        public float getEnd() {
            return this.end;
        }
    }

    private static class ProgressThresholdsGroup {
        private final ProgressThresholds fade;
        private final ProgressThresholds scale;
        private final ProgressThresholds scaleMask;
        private final ProgressThresholds shapeMask;

        /* synthetic */ ProgressThresholdsGroup(ProgressThresholds r1, ProgressThresholds r2, ProgressThresholds r3, ProgressThresholds r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ ProgressThresholds access$400(ProgressThresholdsGroup r0) {
            return r0.fade;
        }

        static /* synthetic */ ProgressThresholds access$500(ProgressThresholdsGroup r0) {
            return r0.scale;
        }

        static /* synthetic */ ProgressThresholds access$600(ProgressThresholdsGroup r0) {
            return r0.scaleMask;
        }

        static /* synthetic */ ProgressThresholds access$700(ProgressThresholdsGroup r0) {
            return r0.shapeMask;
        }

        private ProgressThresholdsGroup(ProgressThresholds r1, ProgressThresholds r2, ProgressThresholds r3, ProgressThresholds r4) {
            this.fade = r1;
            this.scale = r2;
            this.scaleMask = r3;
            this.shapeMask = r4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    private static final class TransitionDrawable extends Drawable {
        private static final int COMPAT_SHADOW_COLOR = -7829368;
        private static final int SHADOW_COLOR = 754974720;
        private static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        private static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        private final MaterialShapeDrawable compatShadowDrawable;
        private final Paint containerPaint;
        private float currentElevation;
        private float currentElevationDy;
        private final RectF currentEndBounds;
        private final RectF currentEndBoundsMasked;
        private RectF currentMaskBounds;
        private final RectF currentStartBounds;
        private final RectF currentStartBoundsMasked;
        private final Paint debugPaint;
        private final Path debugPath;
        private final float displayHeight;
        private final float displayWidth;
        private final boolean drawDebugEnabled;
        private final boolean elevationShadowEnabled;
        private final RectF endBounds;
        private final Paint endContainerPaint;
        private final float endElevation;
        private final ShapeAppearanceModel endShapeAppearanceModel;
        private final View endView;
        private final boolean entering;
        private final FadeModeEvaluator fadeModeEvaluator;
        private FadeModeResult fadeModeResult;
        private final FitModeEvaluator fitModeEvaluator;
        private FitModeResult fitModeResult;
        private final MaskEvaluator maskEvaluator;
        private final float motionPathLength;
        private final PathMeasure motionPathMeasure;
        private final float[] motionPathPosition;
        private float progress;
        private final ProgressThresholdsGroup progressThresholds;
        private final Paint scrimPaint;
        private final Paint shadowPaint;
        private final RectF startBounds;
        private final Paint startContainerPaint;
        private final float startElevation;
        private final ShapeAppearanceModel startShapeAppearanceModel;
        private final View startView;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* synthetic */ TransitionDrawable(PathMotion r1, View r2, RectF r3, ShapeAppearanceModel r4, float r5, View r6, RectF r7, ShapeAppearanceModel r8, float r9, int r10, int r11, int r12, int r13, boolean r14, boolean r15, FadeModeEvaluator r16, FitModeEvaluator r17, ProgressThresholdsGroup r18, boolean r19, AnonymousClass1 r20) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        }

        static /* synthetic */ void access$200(TransitionDrawable r0, float r1) {
            r0.setProgress(r1);
        }

        static /* synthetic */ View access$800(TransitionDrawable r0) {
            return r0.startView;
        }

        static /* synthetic */ View access$900(TransitionDrawable r0) {
            return r0.endView;
        }

        private TransitionDrawable(PathMotion r14, View r15, RectF r16, ShapeAppearanceModel r17, float r18, View r19, RectF r20, ShapeAppearanceModel r21, float r22, int r23, int r24, int r25, int r26, boolean r27, boolean r28, FadeModeEvaluator r29, FitModeEvaluator r30, ProgressThresholdsGroup r31, boolean r32) {
            Paint r2 = new Paint();
            this.containerPaint = r2;
            Paint r3 = new Paint();
            this.startContainerPaint = r3;
            Paint r4 = new Paint();
            this.endContainerPaint = r4;
            this.shadowPaint = new Paint();
            Paint r5 = new Paint();
            this.scrimPaint = r5;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[]{r16.centerX(), r16.top};
            MaterialShapeDrawable r8 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r8;
            Paint r9 = new Paint();
            this.debugPaint = r9;
            this.debugPath = new Path();
            this.startView = r15;
            this.startBounds = r16;
            this.startShapeAppearanceModel = r17;
            this.startElevation = r18;
            this.endView = r19;
            this.endBounds = r20;
            this.endShapeAppearanceModel = r21;
            this.endElevation = r22;
            this.entering = r27;
            this.elevationShadowEnabled = r28;
            this.fadeModeEvaluator = r29;
            this.fitModeEvaluator = r30;
            this.progressThresholds = r31;
            this.drawDebugEnabled = r32;
            WindowManager r10 = (WindowManager) r15.getContext().getSystemService("window");
            DisplayMetrics r12 = new DisplayMetrics();
            r10.getDefaultDisplay().getMetrics(r12);
            this.displayWidth = r12.widthPixels;
            this.displayHeight = r12.heightPixels;
            r2.setColor(r23);
            r3.setColor(r24);
            r4.setColor(r25);
            r8.setFillColor(ColorStateList.valueOf(0));
            r8.setShadowCompatibilityMode(2);
            r8.setShadowBitmapDrawingEnable(false);
            r8.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r6 = new RectF(r16);
            this.currentStartBounds = r6;
            this.currentStartBoundsMasked = new RectF(r6);
            RectF r7 = new RectF(r6);
            this.currentEndBounds = r7;
            this.currentEndBoundsMasked = new RectF(r7);
            PointF r11 = getMotionPathPoint(r16);
            PointF r13 = getMotionPathPoint(r20);
            PathMeasure r33 = new PathMeasure(r14.getPath(r11.x, r11.y, r13.x, r13.y), false);
            this.motionPathMeasure = r33;
            this.motionPathLength = r33.getLength();
            r5.setStyle(Paint.Style.FILL);
            r5.setShader(TransitionUtils.createColorShader(r26));
            r9.setStyle(Paint.Style.STROKE);
            r9.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r4) {
            if (this.scrimPaint.getAlpha() <= 0) goto L6;
            r4.drawRect(getBounds(), this.scrimPaint);
        L6:
            if (this.drawDebugEnabled == false) goto L8;
            int r0 = r4.save();
        L10:
            if (this.elevationShadowEnabled == true) goto L12;
        L14:
            this.maskEvaluator.clip(r4);
            maybeDrawContainerColor(r4, this.containerPaint);
            if (this.fadeModeResult.endOnTop == false) goto L17;
            drawStartView(r4);
            drawEndView(r4);
        L19:
            if (this.drawDebugEnabled == false) goto L22;
            r4.restoreToCount(r0);
            drawDebugCumulativePath(r4, this.currentStartBounds, this.debugPath, -65281);
            drawDebugRect(r4, this.currentStartBoundsMasked, InputDeviceCompat.SOURCE_ANY);
            drawDebugRect(r4, this.currentStartBounds, -16711936);
            drawDebugRect(r4, this.currentEndBoundsMasked, -16711681);
            drawDebugRect(r4, this.currentEndBounds, -16776961);
            return;
        L22:
            return;
        L17:
            drawEndView(r4);
            drawStartView(r4);
            goto L19
        L12:
            if (this.currentElevation <= 0.0f) goto L14;
            drawElevationShadow(r4);
            goto L14
        L8:
            r0 = -1;
            goto L10
        }

        private void drawElevationShadow(Canvas r3) {
            r3.save();
            r3.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            drawElevationShadowWithPaintShadowLayer(r3);
            r3.restore();
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas r3) {
            ShapeAppearanceModel r0 = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (r0.isRoundRect(this.currentMaskBounds) == false) goto L5;
            float r1 = r0.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
            r3.drawRoundRect(this.currentMaskBounds, r1, r1, this.shadowPaint);
            return;
        L5:
            r3.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r6) {
            this.compatShadowDrawable.setBounds((int) this.currentMaskBounds.left, (int) this.currentMaskBounds.top, (int) this.currentMaskBounds.right, (int) this.currentMaskBounds.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(r6);
        }

        private void drawStartView(Canvas r9) {
            maybeDrawContainerColor(r9, this.startContainerPaint);
            TransitionUtils.transform(r9, getBounds(), this.currentStartBounds.left, this.currentStartBounds.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new AnonymousClass1(this));
        }

        private void drawEndView(Canvas r9) {
            maybeDrawContainerColor(r9, this.endContainerPaint);
            TransitionUtils.transform(r9, getBounds(), this.currentEndBounds.left, this.currentEndBounds.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new AnonymousClass2(this));
        }

        private void maybeDrawContainerColor(Canvas r2, Paint r3) {
            if (r3.getColor() != 0) goto L5;
            return;
        L5:
            if (r3.getAlpha() <= 0) goto L9;
            r2.drawRect(getBounds(), r3);
            return;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private void setProgress(float r2) {
            if (this.progress == r2) goto L6;
            updateProgress(r2);
            return;
        }

        private void updateProgress(float r13) {
            this.progress = r13;
            Paint r0 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r1 = TransitionUtils.lerp(0.0f, 255.0f, r13);
        L6:
            r0.setAlpha((int) r1);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r13, this.motionPathPosition, null);
            float[] r2 = this.motionPathPosition;
            float r3 = r2[0];
            float r5 = r2[1];
            if (r13 <= 1.0f) goto L9;
        L12:
            if (r13 <= 1.0f) goto L14;
            float r6 = (r13 - 1.0f) / 0.00999999f;
            float r7 = 0.99f;
        L15:
            this.motionPathMeasure.getPosTan(this.motionPathLength * r7, r2, null);
            float[] r4 = this.motionPathPosition;
            r3 = r3 + ((r3 - r4[0]) * r6);
            r5 = r5 + ((r5 - r4[1]) * r6);
        L11:
            float r10 = r3;
            float r11 = r5;
            FitModeResult r8 = this.fitModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r8;
            this.currentStartBounds.set(r10 - (r8.currentStartWidth / 2.0f), r11, (this.fitModeResult.currentStartWidth / 2.0f) + r10, this.fitModeResult.currentStartHeight + r11);
            this.currentEndBounds.set(r10 - (this.fitModeResult.currentEndWidth / 2.0f), r11, r10 + (this.fitModeResult.currentEndWidth / 2.0f), this.fitModeResult.currentEndHeight + r11);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r9 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            float r12 = ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            boolean r14 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            if (r14 == false) goto L19;
            RectF r15 = this.currentStartBoundsMasked;
        L20:
            float r16 = TransitionUtils.lerp(0.0f, 1.0f, r9, r12, r13);
            if (r14 == true) goto L24;
            r16 = 1.0f - r16;
        L24:
            this.fitModeEvaluator.applyMask(r15, r16, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(r13, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, ProgressThresholdsGroup.access$700(this.progressThresholds));
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, r13);
            float r17 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float r18 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float r19 = this.currentElevation;
            float r20 = (int) (r18 * r19);
            this.currentElevationDy = r20;
            this.shadowPaint.setShadowLayer(r19, (int) (r17 * r19), r20, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() == 0) goto L28;
            this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
        L28:
            if (this.endContainerPaint.getColor() == 0) goto L30;
            this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
        L30:
            invalidateSelf();
            return;
        L19:
            r15 = this.currentEndBoundsMasked;
            goto L20
        L14:
            r7 = 0.01f;
            r6 = (r13 / 0.01f) * MaterialContainerTransform.ELEVATION_NOT_SET;
            goto L15
        L9:
            if (r13 >= 0.0f) goto L11;
        L5:
            r1 = TransitionUtils.lerp(255.0f, 0.0f, r13);
            goto L6
        }

        private static PointF getMotionPathPoint(RectF r2) {
            return new PointF(r2.centerX(), r2.top);
        }

        private static float calculateElevationDxMultiplier(RectF r1, float r2) {
            return ((r1.centerX() / (r2 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float calculateElevationDyMultiplier(RectF r0, float r1) {
            return (r0.centerY() / r1) * SHADOW_DY_MULTIPLIER_ADJUSTMENT;
        }

        private void drawDebugCumulativePath(Canvas r3, RectF r4, Path r5, int r6) {
            PointF r7 = getMotionPathPoint(r4);
            if (this.progress != 0.0f) goto L5;
            r5.reset();
            r5.moveTo(r7.x, r7.y);
            return;
        L5:
            r5.lineTo(r7.x, r7.y);
            this.debugPaint.setColor(r6);
            r3.drawPath(r5, this.debugPaint);
        }

        private void drawDebugRect(Canvas r2, RectF r3, int r4) {
            this.debugPaint.setColor(r4);
            r2.drawRect(r3, this.debugPaint);
        }
    }

    static /* synthetic */ boolean access$300(MaterialContainerTransform r0) {
        return r0.holdAtEndEnabled;
    }

    static {
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = true;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
    }

    public MaterialContainerTransform(Context r3, boolean r4) {
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = true;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
        maybeApplyThemeValues(r3, r4);
        this.appliedThemeValues = true;
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    public void setStartViewId(int r1) {
        this.startViewId = r1;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public void setEndViewId(int r1) {
        this.endViewId = r1;
    }

    public View getStartView() {
        return this.startView;
    }

    public void setStartView(View r1) {
        this.startView = r1;
    }

    public View getEndView() {
        return this.endView;
    }

    public void setEndView(View r1) {
        this.endView = r1;
    }

    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public void setStartShapeAppearanceModel(ShapeAppearanceModel r1) {
        this.startShapeAppearanceModel = r1;
    }

    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public void setEndShapeAppearanceModel(ShapeAppearanceModel r1) {
        this.endShapeAppearanceModel = r1;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public void setElevationShadowEnabled(boolean r1) {
        this.elevationShadowEnabled = r1;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    public void setStartElevation(float r1) {
        this.startElevation = r1;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    public void setEndElevation(float r1) {
        this.endElevation = r1;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    public void setDrawingViewId(int r1) {
        this.drawingViewId = r1;
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public void setContainerColor(int r1) {
        this.containerColor = r1;
    }

    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public void setStartContainerColor(int r1) {
        this.startContainerColor = r1;
    }

    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public void setEndContainerColor(int r1) {
        this.endContainerColor = r1;
    }

    public void setAllContainerColors(int r1) {
        this.containerColor = r1;
        this.startContainerColor = r1;
        this.endContainerColor = r1;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    public void setScrimColor(int r1) {
        this.scrimColor = r1;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    public void setTransitionDirection(int r1) {
        this.transitionDirection = r1;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public void setFadeMode(int r1) {
        this.fadeMode = r1;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public void setFitMode(int r1) {
        this.fitMode = r1;
    }

    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public void setFadeProgressThresholds(ProgressThresholds r1) {
        this.fadeProgressThresholds = r1;
    }

    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public void setScaleProgressThresholds(ProgressThresholds r1) {
        this.scaleProgressThresholds = r1;
    }

    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public void setScaleMaskProgressThresholds(ProgressThresholds r1) {
        this.scaleMaskProgressThresholds = r1;
    }

    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public void setShapeMaskProgressThresholds(ProgressThresholds r1) {
        this.shapeMaskProgressThresholds = r1;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setHoldAtEndEnabled(boolean r1) {
        this.holdAtEndEnabled = r1;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public void setDrawDebugEnabled(boolean r1) {
        this.drawDebugEnabled = r1;
    }

    @Override // android.transition.Transition
    public void setPathMotion(PathMotion r1) {
        super.setPathMotion(r1);
        this.pathMotionCustom = true;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues r3) {
        captureValues(r3, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues r3) {
        captureValues(r3, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    private static void captureValues(TransitionValues r2, View r3, int r4, ShapeAppearanceModel r5) {
        if (r4 == (-1)) goto L5;
        r2.view = TransitionUtils.findDescendantOrAncestorById(r2.view, r4);
    L10:
        View r6 = r2.view;
        if (ViewCompat.isLaidOut(r6) == true) goto L17;
        if (r6.getWidth() != 0) goto L17;
        if (r6.getHeight() != 0) goto L17;
        return;
    L17:
        if (r6.getParent() != null) goto L19;
        RectF r7 = TransitionUtils.getRelativeBounds(r6);
    L20:
        r2.values.put(PROP_BOUNDS, r7);
        r2.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r6, r7, r5));
        return;
    L19:
        r7 = TransitionUtils.getLocationOnScreen(r6);
        goto L20
    L5:
        if (r3 == null) goto L8;
        r2.view = r3;
        goto L10
    L8:
        if ((r2.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) == false) goto L10;
        View r8 = (View) r2.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        r2.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
        r2.view = r8;
        goto L10
    }

    private static ShapeAppearanceModel captureShapeAppearance(View r0, RectF r1, ShapeAppearanceModel r2) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(r0, r2), r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(View r2, ShapeAppearanceModel r3) {
        if (r3 == null) goto L5;
        return r3;
    L5:
        if ((r2.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) == true) goto L7;
        Context r4 = r2.getContext();
        int r0 = getTransitionShapeAppearanceResId(r4);
        if (r0 == (-1)) goto L13;
        return ShapeAppearanceModel.builder(r4, r0, 0).build();
    L13:
        if ((r2 instanceof Shapeable) == false) goto L17;
        return ((Shapeable) r2).getShapeAppearanceModel();
    L17:
        return ShapeAppearanceModel.builder().build();
    L7:
        return (ShapeAppearanceModel) r2.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
    }

    private static int getTransitionShapeAppearanceResId(Context r3) {
        TypedArray r4 = r3.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int r0 = r4.getResourceId(0, -1);
        r4.recycle();
        return r0;
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup r30, TransitionValues r31, TransitionValues r32) {
        if (r31 == null) goto L30;
        if (r32 == null) goto L30;
        RectF r10 = (RectF) r31.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r11 = (ShapeAppearanceModel) r31.values.get(PROP_SHAPE_APPEARANCE);
        if (r10 == null) goto L29;
        if (r11 == null) goto L29;
        RectF r14 = (RectF) r32.values.get(PROP_BOUNDS);
        ShapeAppearanceModel r15 = (ShapeAppearanceModel) r32.values.get(PROP_SHAPE_APPEARANCE);
        if (r14 == null) goto L27;
        if (r15 == null) goto L27;
        final View r4 = r31.view;
        final View r5 = r32.view;
        if (r5.getParent() == null) goto L17;
        View r0 = r5;
    L19:
        if (this.drawingViewId != r0.getId()) goto L21;
        final View r2 = (View) r0.getParent();
        View r1 = r0;
    L22:
        RectF r3 = TransitionUtils.getLocationOnScreen(r2);
        float r7 = -r3.left;
        float r6 = -r3.top;
        RectF r8 = calculateDrawableBounds(r2, r1, r7, r6);
        r10.offset(r7, r6);
        r14.offset(r7, r6);
        boolean r9 = isEntering(r10, r14);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues(r0.getContext(), r9);
    L25:
        final TransitionDrawable r12 = new TransitionDrawable(getPathMotion(), r4, r10, r11, getElevationOrDefault(this.startElevation, r4), r5, r14, r15, getElevationOrDefault(this.endElevation, r5), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r9, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, r9), FitModeEvaluators.get(this.fitMode, r9, r10, r14), buildThresholdsGroup(r9), this.drawDebugEnabled, null);
        r12.setBounds(Math.round(r8.left), Math.round(r8.top), Math.round(r8.right), Math.round(r8.bottom));
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.addUpdateListener(new AnonymousClass1(this, r12));
        addListener(new AnonymousClass2(this, r2, r12, r4, r5));
        return r13;
    L21:
        r2 = TransitionUtils.findAncestorById(r0, this.drawingViewId);
        r1 = null;
        goto L22
    L17:
        r0 = r4;
    L27:
        Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
    L29:
        Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    L30:
        return null;
    }

    private void maybeApplyThemeValues(Context r3, boolean r4) {
        TransitionUtils.maybeApplyThemeInterpolator(this, r3, com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (r4 == false) goto L5;
        int r5 = com.google.android.material.R.attr.motionDurationLong2;
    L6:
        TransitionUtils.maybeApplyThemeDuration(this, r3, r5);
        if (this.pathMotionCustom == true) goto L10;
        TransitionUtils.maybeApplyThemePath(this, r3, com.google.android.material.R.attr.motionPath);
        return;
    L10:
        return;
    L5:
        r5 = com.google.android.material.R.attr.motionDurationMedium4;
        goto L6
    }

    private static float getElevationOrDefault(float r1, View r2) {
        if (r1 == ELEVATION_NOT_SET) goto L6;
        return r1;
    L6:
        return ViewCompat.getElevation(r2);
    }

    private static RectF calculateDrawableBounds(View r0, View r1, float r2, float r3) {
        if (r1 == null) goto L6;
        RectF r4 = TransitionUtils.getLocationOnScreen(r1);
        r4.offset(r2, r3);
        return r4;
    L6:
        return new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
    }

    private boolean isEntering(RectF r4, RectF r5) {
        int r0 = this.transitionDirection;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (TransitionUtils.calculateArea(r5) > TransitionUtils.calculateArea(r4)) goto L14;
        return false;
    L14:
        return true;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean r3) {
        PathMotion r0 = getPathMotion();
        if ((r0 instanceof ArcMotion) == true) goto L10;
        if ((r0 instanceof MaterialArcMotion) == true) goto L10;
        return getThresholdsOrDefault(r3, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    L10:
        return getThresholdsOrDefault(r3, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean r7, ProgressThresholdsGroup r8, ProgressThresholdsGroup r9) {
        if (r7 == true) goto L6;
        r8 = r9;
    L6:
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(r8)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(r8)), null);
    }
}
