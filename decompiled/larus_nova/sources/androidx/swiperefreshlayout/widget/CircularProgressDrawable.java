package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = null;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final Interpolator MATERIAL_INTERPOLATOR = null;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds;

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public float getArrowHeight() {
            return this.mArrowHeight;
        }

        public float getArrowWidth() {
            return this.mArrowWidth;
        }

        public int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public Ring() {
            this.mTempBounds = new RectF();
            Paint r100 = new Paint();
            this.mPaint = r100;
            Paint r101 = new Paint();
            this.mArrowPaint = r101;
            Paint r102 = new Paint();
            this.mCirclePaint = r102;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            r100.setStrokeCap(Paint.Cap.SQUARE);
            r100.setAntiAlias(true);
            r100.setStyle(Paint.Style.STROKE);
            r101.setStyle(Paint.Style.FILL);
            r101.setAntiAlias(true);
            r102.setColor(0);
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public float getArrowScale() {
            return this.mArrowScale;
        }

        public float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public int[] getColors() {
            return this.mColors;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public boolean getShowArrow() {
            return this.mShowArrow;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setAlpha(int r100) {
            this.mAlpha = r100;
        }

        public void setArrowScale(float r100) {
            if (r100 == this.mArrowScale) goto L6;
            this.mArrowScale = r100;
            return;
        }

        public void setBackgroundColor(int r100) {
            this.mCirclePaint.setColor(r100);
        }

        public void setCenterRadius(float r100) {
            this.mRingCenterRadius = r100;
        }

        public void setColor(int r100) {
            this.mCurrentColor = r100;
        }

        public void setColorFilter(ColorFilter r100) {
            this.mPaint.setColorFilter(r100);
        }

        public void setColorIndex(int r100) {
            this.mColorIndex = r100;
            this.mCurrentColor = this.mColors[r100];
        }

        public void setColors(int[] r100) {
            this.mColors = r100;
            setColorIndex(0);
        }

        public void setEndTrim(float r100) {
            this.mEndTrim = r100;
        }

        public void setRotation(float r100) {
            this.mRotation = r100;
        }

        public void setShowArrow(boolean r100) {
            if (this.mShowArrow == r100) goto L6;
            this.mShowArrow = r100;
            return;
        }

        public void setStartTrim(float r100) {
            this.mStartTrim = r100;
        }

        public void setStrokeCap(Paint.Cap r100) {
            this.mPaint.setStrokeCap(r100);
        }

        public void setStrokeWidth(float r100) {
            this.mStrokeWidth = r100;
            this.mPaint.setStrokeWidth(r100);
        }

        public void draw(Canvas r100, Rect r110) {
            RectF r101 = this.mTempBounds;
            float r102 = this.mRingCenterRadius;
            float r103 = (this.mStrokeWidth / 2.0f) + r102;
            if (r102 > 0.0f) goto L5;
            r103 = (Math.min(r110.width(), r110.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
        L5:
            r101.set(r110.centerX() - r103, r110.centerY() - r103, r110.centerX() + r103, r110.centerY() + r103);
            float r111 = this.mStartTrim;
            float r104 = this.mRotation;
            float r112 = (r111 + r104) * 360.0f;
            float r105 = ((this.mEndTrim + r104) * 360.0f) - r112;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float r106 = this.mStrokeWidth / 2.0f;
            r101.inset(r106, r106);
            r100.drawCircle(r101.centerX(), r101.centerY(), r101.width() / 2.0f, this.mCirclePaint);
            float r107 = -r106;
            r101.inset(r107, r107);
            r100.drawArc(r101, r112, r105, false, this.mPaint);
            drawTriangle(r100, r112, r105, r101);
        }

        public void setArrowDimensions(float r100, float r101) {
            this.mArrowWidth = (int) r100;
            this.mArrowHeight = (int) r101;
        }

        public void drawTriangle(Canvas r100, float r101, float r110, RectF r111) {
            if (this.mShowArrow == false) goto L10;
            Path r102 = this.mArrow;
            if (r102 != null) goto L7;
            Path r103 = new Path();
            this.mArrow = r103;
            r103.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r104 = Math.min(r111.width(), r111.height()) / 2.0f;
            float r105 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
            this.mArrow.moveTo(0.0f, 0.0f);
            this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
            Path r106 = this.mArrow;
            float r107 = this.mArrowWidth;
            float r108 = this.mArrowScale;
            r106.lineTo((r107 * r108) / 2.0f, this.mArrowHeight * r108);
            this.mArrow.offset((r104 + r111.centerX()) - r105, r111.centerY() + (this.mStrokeWidth / 2.0f));
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            this.mArrowPaint.setAlpha(this.mAlpha);
            r100.save();
            r100.rotate(r101 + r110, r111.centerX(), r111.centerY());
            r100.drawPath(this.mArrow, this.mArrowPaint);
            r100.restore();
            return;
        L7:
            r102.reset();
            goto L8
        }
    }

    private int evaluateColorChange(float r100, int r101, int r102) {
        int r103 = (r101 >> 24) & 255;
        int r104 = (r101 >> 16) & 255;
        int r105 = (r101 >> 8) & 255;
        int r106 = r101 & 255;
        return ((((r103 + ((int) ((((r102 >> 24) & 255) - r103) * r100))) << 24) | ((r104 + ((int) ((((r102 >> 16) & 255) - r104) * r100))) << 16)) | ((r105 + ((int) ((((r102 >> 8) & 255) - r105) * r100))) << 8)) | (r106 + ((int) (r100 * ((r102 & 255) - r106))));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{-16777216};
    }

    private void setupAnimators() {
        final Ring r100 = this.mRing;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.addUpdateListener(new AnonymousClass1(this, r100));
        r101.setRepeatCount(-1);
        r101.setRepeatMode(1);
        r101.setInterpolator(LINEAR_INTERPOLATOR);
        r101.addListener(new AnonymousClass2(this, r100));
        this.mAnimator = r101;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() == this.mRing.getStartTrim()) goto L5;
        this.mFinishing = true;
        this.mAnimator.setDuration(666);
        this.mAnimator.start();
        return;
    L5:
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    private float getRotation() {
        return this.mRotation;
    }

    public CircularProgressDrawable(Context r100) {
        this.mResources = ((Context) Preconditions.checkNotNull(r100)).getResources();
        Ring r101 = new Ring();
        this.mRing = r101;
        r101.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_CircularProgressDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void setRotation(float r100) {
        this.mRotation = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Rect r101 = getBounds();
        r100.save();
        r100.rotate(this.mRotation, r101.exactCenterX(), r101.exactCenterY());
        this.mRing.draw(r100, r101);
        r100.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mRing.setAlpha(r100);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean r100) {
        this.mRing.setShowArrow(r100);
        invalidateSelf();
    }

    public void setArrowScale(float r100) {
        this.mRing.setArrowScale(r100);
        invalidateSelf();
    }

    public void setBackgroundColor(int r100) {
        this.mRing.setBackgroundColor(r100);
        invalidateSelf();
    }

    public void setCenterRadius(float r100) {
        this.mRing.setCenterRadius(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mRing.setColorFilter(r100);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... r100) {
        this.mRing.setColors(r100);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float r100) {
        this.mRing.setRotation(r100);
        invalidateSelf();
    }

    public void setStrokeCap(Paint.Cap r100) {
        this.mRing.setStrokeCap(r100);
        invalidateSelf();
    }

    public void setStrokeWidth(float r100) {
        this.mRing.setStrokeWidth(r100);
        invalidateSelf();
    }

    public void setStyle(int r100) {
        if (r100 != 0) goto L4;
        setSizeParameters(CENTER_RADIUS_LARGE, 3.0f, 12.0f, 6.0f);
    L5:
        invalidateSelf();
        return;
    L4:
        setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        goto L5
    }

    private void applyFinishTranslation(float r100, Ring r101) {
        updateRingColor(r100, r101);
        float r102 = (float) (Math.floor(r101.getStartingRotation() / 0.8f) + 1.0d);
        r101.setStartTrim(r101.getStartingStartTrim() + (((r101.getStartingEndTrim() - 0.01f) - r101.getStartingStartTrim()) * r100));
        r101.setEndTrim(r101.getStartingEndTrim());
        r101.setRotation(r101.getStartingRotation() + ((r102 - r101.getStartingRotation()) * r100));
    }

    public void setArrowDimensions(float r100, float r101) {
        this.mRing.setArrowDimensions(r100, r101);
        invalidateSelf();
    }

    public void setStartEndTrim(float r100, float r101) {
        this.mRing.setStartTrim(r100);
        this.mRing.setEndTrim(r101);
        invalidateSelf();
    }

    public void updateRingColor(float r100, Ring r101) {
        if (r100 <= 0.75f) goto L5;
        r101.setColor(evaluateColorChange((r100 - 0.75f) / 0.25f, r101.getStartingColor(), r101.getNextColor()));
        return;
    L5:
        r101.setColor(r101.getStartingColor());
    }

    public void applyTransformation(float r100, Ring r101, boolean r110) {
        if (this.mFinishing == false) goto L6;
        applyFinishTranslation(r100, r101);
        return;
    L6:
        if (r100 != 1.0f) goto L8;
        if (r110 == true) goto L8;
        return;
    L8:
        float r111 = r101.getStartingRotation();
        if (r100 >= 0.5f) goto L11;
        float r102 = r101.getStartingStartTrim();
        Interpolator r103 = MATERIAL_INTERPOLATOR;
        float r104 = ((r103.getInterpolation(r100 / 0.5f) * 0.79f) + 0.01f) + r102;
    L12:
        float r112 = r111 + (RING_ROTATION * r100);
        float r105 = (r100 + this.mRotationCount) * GROUP_FULL_ROTATION;
        r101.setStartTrim(r102);
        r101.setEndTrim(r104);
        r101.setRotation(r112);
        setRotation(r105);
        return;
    L11:
        float r106 = r101.getStartingStartTrim() + 0.79f;
        Interpolator r107 = MATERIAL_INTERPOLATOR;
        r102 = r106 - (((1.0f - r107.getInterpolation((r100 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
        r104 = r106;
        goto L12
    }

    private void setSizeParameters(float r100, float r101, float r102, float r103) {
        Ring r104 = this.mRing;
        float r105 = INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_CircularProgressDrawable_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mResources).density;
        r104.setStrokeWidth(r101 * r105);
        r104.setCenterRadius(r100 * r105);
        r104.setColorIndex(0);
        r104.setArrowDimensions(r102 * r105, r103 * r105);
    }
}
