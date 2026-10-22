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
import android.graphics.Rect;
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
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.e;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
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

    @ColorInt
    private int containerColor;
    private boolean drawDebugEnabled;

    @IdRes
    private int drawingViewId;
    private boolean elevationShadowEnabled;

    @ColorInt
    private int endContainerColor;
    private float endElevation;

    @Nullable
    private ShapeAppearanceModel endShapeAppearanceModel;

    @Nullable
    private View endView;

    @IdRes
    private int endViewId;
    private int fadeMode;

    @Nullable
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;

    @Nullable
    private ProgressThresholds scaleMaskProgressThresholds;

    @Nullable
    private ProgressThresholds scaleProgressThresholds;

    @ColorInt
    private int scrimColor;

    @Nullable
    private ProgressThresholds shapeMaskProgressThresholds;

    @ColorInt
    private int startContainerColor;
    private float startElevation;

    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;

    @Nullable
    private View startView;

    @IdRes
    private int startViewId;
    private int transitionDirection;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float end;

        @FloatRange(from = 0.0d, to = 1.0d)
        private final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
            this.start = r10;
            this.end = r11;
        }

        public static /* synthetic */ float access$1000(ProgressThresholds r10) {
            return r10.start;
        }

        public static /* synthetic */ float access$1100(ProgressThresholds r10) {
            return r10.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    public static class ProgressThresholdsGroup {

        @NonNull
        private final ProgressThresholds fade;

        @NonNull
        private final ProgressThresholds scale;

        @NonNull
        private final ProgressThresholds scaleMask;

        @NonNull
        private final ProgressThresholds shapeMask;

        public /* synthetic */ ProgressThresholdsGroup(ProgressThresholds r10, ProgressThresholds r11, ProgressThresholds r12, ProgressThresholds r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        public static /* synthetic */ ProgressThresholds access$400(ProgressThresholdsGroup r10) {
            return r10.fade;
        }

        public static /* synthetic */ ProgressThresholds access$500(ProgressThresholdsGroup r10) {
            return r10.scale;
        }

        public static /* synthetic */ ProgressThresholds access$600(ProgressThresholdsGroup r10) {
            return r10.scaleMask;
        }

        public static /* synthetic */ ProgressThresholds access$700(ProgressThresholdsGroup r10) {
            return r10.shapeMask;
        }

        private ProgressThresholdsGroup(@NonNull ProgressThresholds r10, @NonNull ProgressThresholds r11, @NonNull ProgressThresholds r12, @NonNull ProgressThresholds r13) {
            this.fade = r10;
            this.scale = r11;
            this.scaleMask = r12;
            this.shapeMask = r13;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TransitionDirection {
    }

    public static final class TransitionDrawable extends Drawable {
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

        public /* synthetic */ TransitionDrawable(PathMotion r10, View r11, RectF r12, ShapeAppearanceModel r13, float r14, View r15, RectF r16, ShapeAppearanceModel r17, float r18, int r19, int r110, int r111, int r112, boolean r113, boolean r114, FadeModeEvaluator r115, FitModeEvaluator r116, ProgressThresholdsGroup r117, boolean r118, AnonymousClass1 r20) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        }

        public static /* synthetic */ void access$200(TransitionDrawable r10, float r11) {
            r10.setProgress(r11);
        }

        public static /* synthetic */ View access$800(TransitionDrawable r10) {
            return r10.startView;
        }

        public static /* synthetic */ View access$900(TransitionDrawable r10) {
            return r10.endView;
        }

        private static float calculateElevationDxMultiplier(RectF r10, float r11) {
            return ((r10.centerX() / (r11 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float calculateElevationDyMultiplier(RectF r10, float r11) {
            return (r10.centerY() / r11) * 1.5f;
        }

        private void drawDebugCumulativePath(Canvas r10, RectF r11, Path r12, @ColorInt int r13) {
            PointF r14 = getMotionPathPoint(r11);
            if (this.progress != 0.0f) goto L5;
            r12.reset();
            r12.moveTo(r14.x, r14.y);
            return;
        L5:
            r12.lineTo(r14.x, r14.y);
            this.debugPaint.setColor(r13);
            r10.drawPath(r12, this.debugPaint);
        }

        private void drawDebugRect(Canvas r10, RectF r11, @ColorInt int r12) {
            this.debugPaint.setColor(r12);
            r10.drawRect(r11, this.debugPaint);
        }

        private void drawElevationShadow(Canvas r10) {
            r10.save();
            r10.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
            drawElevationShadowWithPaintShadowLayer(r10);
            r10.restore();
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas r10) {
            MaterialShapeDrawable r11 = this.compatShadowDrawable;
            RectF r12 = this.currentMaskBounds;
            r11.setBounds((int) r12.left, (int) r12.top, (int) r12.right, (int) r12.bottom);
            this.compatShadowDrawable.setElevation(this.currentElevation);
            this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
            this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
            this.compatShadowDrawable.draw(r10);
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas r10) {
            ShapeAppearanceModel r11 = this.maskEvaluator.getCurrentShapeAppearanceModel();
            if (r11.isRoundRect(this.currentMaskBounds) == false) goto L5;
            float r12 = r11.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
            r10.drawRoundRect(this.currentMaskBounds, r12, r12, this.shadowPaint);
            return;
        L5:
            r10.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
        }

        private void drawEndView(Canvas r10) {
            maybeDrawContainerColor(r10, this.endContainerPaint);
            Rect r11 = getBounds();
            RectF r12 = this.currentEndBounds;
            TransitionUtils.transform(r10, r11, r12.left, r12.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new AnonymousClass2(this));
        }

        private void drawStartView(Canvas r10) {
            maybeDrawContainerColor(r10, this.startContainerPaint);
            Rect r11 = getBounds();
            RectF r12 = this.currentStartBounds;
            TransitionUtils.transform(r10, r11, r12.left, r12.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new AnonymousClass1(this));
        }

        private static PointF getMotionPathPoint(RectF r10) {
            return new PointF(r10.centerX(), r10.top);
        }

        private void maybeDrawContainerColor(Canvas r10, Paint r11) {
            if (r11.getColor() != 0) goto L5;
            return;
        L5:
            if (r11.getAlpha() <= 0) goto L9;
            r10.drawRect(getBounds(), r11);
            return;
        }

        private void setProgress(float r10) {
            if (this.progress == r10) goto L6;
            updateProgress(r10);
            return;
        }

        private void updateProgress(float r13) {
            this.progress = r13;
            Paint r10 = this.scrimPaint;
            if (this.entering == false) goto L5;
            float r11 = TransitionUtils.lerp(0.0f, 255.0f, r13);
        L6:
            r10.setAlpha((int) r11);
            this.motionPathMeasure.getPosTan(this.motionPathLength * r13, this.motionPathPosition, null);
            float[] r12 = this.motionPathPosition;
            float r14 = r12[0];
            float r15 = r12[1];
            if (r13 <= 1.0f) goto L9;
        L12:
            if (r13 <= 1.0f) goto L14;
            float r16 = (r13 - 1.0f) / 0.00999999f;
            float r17 = 0.99f;
        L15:
            this.motionPathMeasure.getPosTan(this.motionPathLength * r17, r12, null);
            float[] r18 = this.motionPathPosition;
            r14 = r14 + ((r14 - r18[0]) * r16);
            r15 = r15 + ((r15 - r18[1]) * r16);
        L11:
            float r19 = r14;
            float r110 = r15;
            FitModeResult r20 = this.fitModeEvaluator.evaluate(r13, ((Float) e.g(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), ((Float) e.g(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$500(this.progressThresholds))))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
            this.fitModeResult = r20;
            RectF r21 = this.currentStartBounds;
            float r22 = r20.currentStartWidth;
            r21.set(r19 - (r22 / 2.0f), r110, (r22 / 2.0f) + r19, r20.currentStartHeight + r110);
            RectF r23 = this.currentEndBounds;
            FitModeResult r24 = this.fitModeResult;
            float r25 = r24.currentEndWidth;
            r23.set(r19 - (r25 / 2.0f), r110, r19 + (r25 / 2.0f), r24.currentEndHeight + r110);
            this.currentStartBoundsMasked.set(this.currentStartBounds);
            this.currentEndBoundsMasked.set(this.currentEndBounds);
            float r26 = ((Float) e.g(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            float r27 = ((Float) e.g(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$600(this.progressThresholds))))).floatValue();
            boolean r28 = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
            if (r28 == false) goto L19;
            RectF r29 = this.currentStartBoundsMasked;
        L20:
            float r30 = TransitionUtils.lerp(0.0f, 1.0f, r26, r27, r13);
            if (r28 == true) goto L24;
            r30 = 1.0f - r30;
        L24:
            this.fitModeEvaluator.applyMask(r29, r30, this.fitModeResult);
            this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
            this.maskEvaluator.evaluate(r13, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, ProgressThresholdsGroup.access$700(this.progressThresholds));
            this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, r13);
            float r31 = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
            float r32 = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
            float r33 = this.currentElevation;
            float r34 = (int) (r32 * r33);
            this.currentElevationDy = r34;
            this.shadowPaint.setShadowLayer(r33, (int) (r31 * r33), r34, SHADOW_COLOR);
            this.fadeModeResult = this.fadeModeEvaluator.evaluate(r13, ((Float) e.g(Float.valueOf(ProgressThresholds.access$1000(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), ((Float) e.g(Float.valueOf(ProgressThresholds.access$1100(ProgressThresholdsGroup.access$400(this.progressThresholds))))).floatValue(), 0.35f);
            if (this.startContainerPaint.getColor() == 0) goto L28;
            this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
        L28:
            if (this.endContainerPaint.getColor() == 0) goto L30;
            this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
        L30:
            invalidateSelf();
            return;
        L19:
            r29 = this.currentEndBoundsMasked;
            goto L20
        L14:
            r17 = 0.01f;
            r16 = (r13 / 0.01f) * MaterialContainerTransform.ELEVATION_NOT_SET;
            goto L15
        L9:
            if (r13 >= 0.0f) goto L11;
        L5:
            r11 = TransitionUtils.lerp(255.0f, 0.0f, r13);
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r10) {
            if (this.scrimPaint.getAlpha() <= 0) goto L6;
            r10.drawRect(getBounds(), this.scrimPaint);
        L6:
            if (this.drawDebugEnabled == false) goto L8;
            int r11 = r10.save();
        L10:
            if (this.elevationShadowEnabled == true) goto L12;
        L14:
            this.maskEvaluator.clip(r10);
            maybeDrawContainerColor(r10, this.containerPaint);
            if (this.fadeModeResult.endOnTop == false) goto L17;
            drawStartView(r10);
            drawEndView(r10);
        L19:
            if (this.drawDebugEnabled == false) goto L22;
            r10.restoreToCount(r11);
            drawDebugCumulativePath(r10, this.currentStartBounds, this.debugPath, -65281);
            drawDebugRect(r10, this.currentStartBoundsMasked, -256);
            drawDebugRect(r10, this.currentStartBounds, -16711936);
            drawDebugRect(r10, this.currentEndBoundsMasked, -16711681);
            drawDebugRect(r10, this.currentEndBounds, -16776961);
            return;
        L22:
            return;
        L17:
            drawEndView(r10);
            drawStartView(r10);
            goto L19
        L12:
            if (this.currentElevation <= 0.0f) goto L14;
            drawElevationShadow(r10);
            goto L14
        L8:
            r11 = -1;
            goto L10
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r10) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter r10) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private TransitionDrawable(PathMotion r14, View r15, RectF r16, ShapeAppearanceModel r17, float r18, View r19, RectF r20, ShapeAppearanceModel r21, float r22, @ColorInt int r23, @ColorInt int r24, @ColorInt int r25, int r26, boolean r27, boolean r28, FadeModeEvaluator r29, FitModeEvaluator r30, ProgressThresholdsGroup r31, boolean r32) {
            Paint r10 = new Paint();
            this.containerPaint = r10;
            Paint r11 = new Paint();
            this.startContainerPaint = r11;
            Paint r12 = new Paint();
            this.endContainerPaint = r12;
            this.shadowPaint = new Paint();
            Paint r13 = new Paint();
            this.scrimPaint = r13;
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[]{r16.centerX(), r16.top};
            MaterialShapeDrawable r33 = new MaterialShapeDrawable();
            this.compatShadowDrawable = r33;
            Paint r34 = new Paint();
            this.debugPaint = r34;
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
            WindowManager r110 = (WindowManager) r15.getContext().getSystemService("window");
            DisplayMetrics r111 = new DisplayMetrics();
            r110.getDefaultDisplay().getMetrics(r111);
            this.displayWidth = r111.widthPixels;
            this.displayHeight = r111.heightPixels;
            r10.setColor(r23);
            r11.setColor(r24);
            r12.setColor(r25);
            r33.setFillColor(ColorStateList.valueOf(0));
            r33.setShadowCompatibilityMode(2);
            r33.setShadowBitmapDrawingEnable(false);
            r33.setShadowColor(COMPAT_SHADOW_COLOR);
            RectF r35 = new RectF(r16);
            this.currentStartBounds = r35;
            this.currentStartBoundsMasked = new RectF(r35);
            RectF r36 = new RectF(r35);
            this.currentEndBounds = r36;
            this.currentEndBoundsMasked = new RectF(r36);
            PointF r37 = getMotionPathPoint(r16);
            PointF r38 = getMotionPathPoint(r20);
            PathMeasure r39 = new PathMeasure(r14.getPath(r37.x, r37.y, r38.x, r38.y), false);
            this.motionPathMeasure = r39;
            this.motionPathLength = r39.getLength();
            r13.setStyle(Paint.Style.FILL);
            r13.setShader(TransitionUtils.createColorShader(r26));
            r34.setStyle(Paint.Style.STROKE);
            r34.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }
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

    public static /* synthetic */ boolean access$300(MaterialContainerTransform r10) {
        return r10.holdAtEndEnabled;
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean r10) {
        PathMotion r11 = getPathMotion();
        if ((r11 instanceof ArcMotion) == true) goto L10;
        if ((r11 instanceof MaterialArcMotion) == true) goto L10;
        return getThresholdsOrDefault(r10, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    L10:
        return getThresholdsOrDefault(r10, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
    }

    private static RectF calculateDrawableBounds(View r10, @Nullable View r11, float r12, float r13) {
        if (r11 == null) goto L6;
        RectF r14 = TransitionUtils.getLocationOnScreen(r11);
        r14.offset(r12, r13);
        return r14;
    L6:
        return new RectF(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View r10, @NonNull RectF r11, @Nullable ShapeAppearanceModel r12) {
        return TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(r10, r12), r11);
    }

    private static void captureValues(@NonNull TransitionValues r10, @Nullable View r11, @IdRes int r12, @Nullable ShapeAppearanceModel r13) {
        if (r12 == (-1)) goto L5;
        r10.view = TransitionUtils.findDescendantOrAncestorById(r10.view, r12);
    L10:
        View r14 = r10.view;
        if (ViewCompat.T(r14) == true) goto L17;
        if (r14.getWidth() != 0) goto L17;
        if (r14.getHeight() != 0) goto L17;
        return;
    L17:
        if (r14.getParent() != null) goto L19;
        RectF r15 = TransitionUtils.getRelativeBounds(r14);
    L20:
        r10.values.put(PROP_BOUNDS, r15);
        r10.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r14, r15, r13));
        return;
    L19:
        r15 = TransitionUtils.getLocationOnScreen(r14);
        goto L20
    L5:
        if (r11 == null) goto L7;
        r10.view = r11;
        goto L10
    L7:
        View r16 = r10.view;
        int r17 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if ((r16.getTag(r17) instanceof View) == false) goto L10;
        View r18 = (View) r10.view.getTag(r17);
        r10.view.setTag(r17, null);
        r10.view = r18;
        goto L10
    }

    private static float getElevationOrDefault(float r10, View r11) {
        if (r10 == ELEVATION_NOT_SET) goto L6;
        return r10;
    L6:
        return ViewCompat.v(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel getShapeAppearance(@NonNull View r10, @Nullable ShapeAppearanceModel r11) {
        if (r11 == null) goto L4;
        return r11;
    L4:
        int r12 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if ((r10.getTag(r12) instanceof ShapeAppearanceModel) == true) goto L7;
        Context r13 = r10.getContext();
        int r14 = getTransitionShapeAppearanceResId(r13);
        if (r14 == (-1)) goto L13;
        return ShapeAppearanceModel.builder(r13, r14, 0).build();
    L13:
        if ((r10 instanceof Shapeable) == false) goto L17;
        return ((Shapeable) r10).getShapeAppearanceModel();
    L17:
        return ShapeAppearanceModel.builder().build();
    L7:
        return (ShapeAppearanceModel) r10.getTag(r12);
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean r10, ProgressThresholdsGroup r11, ProgressThresholdsGroup r12) {
        if (r10 == true) goto L6;
        r11 = r12;
    L6:
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, ProgressThresholdsGroup.access$400(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, ProgressThresholdsGroup.access$500(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, ProgressThresholdsGroup.access$600(r11)), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, ProgressThresholdsGroup.access$700(r11)), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int r12 = r11.getResourceId(0, -1);
        r11.recycle();
        return r12;
    }

    private boolean isEntering(@NonNull RectF r10, @NonNull RectF r11) {
        int r12 = this.transitionDirection;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L6;
        return true;
    L6:
        if (r12 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (TransitionUtils.calculateArea(r11) > TransitionUtils.calculateArea(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    private void maybeApplyThemeValues(Context r10, boolean r11) {
        TransitionUtils.maybeApplyThemeInterpolator(this, r10, com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (r11 == false) goto L5;
        int r12 = com.google.android.material.R.attr.motionDurationLong1;
    L6:
        TransitionUtils.maybeApplyThemeDuration(this, r10, r12);
        if (this.pathMotionCustom == true) goto L10;
        TransitionUtils.maybeApplyThemePath(this, r10, com.google.android.material.R.attr.motionPath);
        return;
    L10:
        return;
    L5:
        r12 = com.google.android.material.R.attr.motionDurationMedium2;
        goto L6
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r30, @Nullable TransitionValues r31, @Nullable TransitionValues r32) {
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
        final View r12 = r31.view;
        final View r13 = r32.view;
        if (r13.getParent() == null) goto L17;
        View r16 = r13;
    L19:
        if (this.drawingViewId != r16.getId()) goto L21;
        final View r17 = (View) r16.getParent();
        View r18 = r16;
    L22:
        RectF r19 = TransitionUtils.getLocationOnScreen(r17);
        float r20 = -r19.left;
        float r21 = -r19.top;
        RectF r22 = calculateDrawableBounds(r17, r18, r20, r21);
        r10.offset(r20, r21);
        r14.offset(r20, r21);
        boolean r23 = isEntering(r10, r14);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues(r16.getContext(), r23);
    L25:
        final TransitionDrawable r24 = new TransitionDrawable(getPathMotion(), r12, r10, r11, getElevationOrDefault(this.startElevation, r12), r13, r14, r15, getElevationOrDefault(this.endElevation, r13), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r23, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, r23), FitModeEvaluators.get(this.fitMode, r23, r10, r14), buildThresholdsGroup(r23), this.drawDebugEnabled, null);
        r24.setBounds(Math.round(r22.left), Math.round(r22.top), Math.round(r22.right), Math.round(r22.bottom));
        ValueAnimator r25 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r25.addUpdateListener(new AnonymousClass1(this, r24));
        addListener(new AnonymousClass2(this, r17, r24, r12, r13));
        return r25;
    L21:
        r17 = TransitionUtils.findAncestorById(r16, this.drawingViewId);
        r18 = null;
        goto L22
    L17:
        r16 = r12;
    L27:
        Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
        return null;
    L29:
        Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
    L30:
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int r10) {
        this.containerColor = r10;
        this.startContainerColor = r10;
        this.endContainerColor = r10;
    }

    public void setContainerColor(@ColorInt int r10) {
        this.containerColor = r10;
    }

    public void setDrawDebugEnabled(boolean r10) {
        this.drawDebugEnabled = r10;
    }

    public void setDrawingViewId(@IdRes int r10) {
        this.drawingViewId = r10;
    }

    public void setElevationShadowEnabled(boolean r10) {
        this.elevationShadowEnabled = r10;
    }

    public void setEndContainerColor(@ColorInt int r10) {
        this.endContainerColor = r10;
    }

    public void setEndElevation(float r10) {
        this.endElevation = r10;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel r10) {
        this.endShapeAppearanceModel = r10;
    }

    public void setEndView(@Nullable View r10) {
        this.endView = r10;
    }

    public void setEndViewId(@IdRes int r10) {
        this.endViewId = r10;
    }

    public void setFadeMode(int r10) {
        this.fadeMode = r10;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds r10) {
        this.fadeProgressThresholds = r10;
    }

    public void setFitMode(int r10) {
        this.fitMode = r10;
    }

    public void setHoldAtEndEnabled(boolean r10) {
        this.holdAtEndEnabled = r10;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@Nullable PathMotion r10) {
        super.setPathMotion(r10);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds r10) {
        this.scaleMaskProgressThresholds = r10;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds r10) {
        this.scaleProgressThresholds = r10;
    }

    public void setScrimColor(@ColorInt int r10) {
        this.scrimColor = r10;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds r10) {
        this.shapeMaskProgressThresholds = r10;
    }

    public void setStartContainerColor(@ColorInt int r10) {
        this.startContainerColor = r10;
    }

    public void setStartElevation(float r10) {
        this.startElevation = r10;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel r10) {
        this.startShapeAppearanceModel = r10;
    }

    public void setStartView(@Nullable View r10) {
        this.startView = r10;
    }

    public void setStartViewId(@IdRes int r10) {
        this.startViewId = r10;
    }

    public void setTransitionDirection(int r10) {
        this.transitionDirection = r10;
    }

    public MaterialContainerTransform(@NonNull Context r10, boolean r11) {
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
        maybeApplyThemeValues(r10, r11);
        this.appliedThemeValues = true;
    }
}
