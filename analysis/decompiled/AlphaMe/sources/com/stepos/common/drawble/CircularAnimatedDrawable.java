package com.stepos.common.drawble;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class CircularAnimatedDrawable extends Drawable implements Animatable {
    public static final String START_ANGLE_PROPERTY = "startAngle";
    public static final String SWEEP_ANGLE_PROPERTY = "sweepAngle";
    private final long LOADING_ANIM_DURATION = 1760;
    private final RectF fBounds = new RectF();
    private boolean mAllowLoading = true;
    private float mBorderWidth;
    private Animator mLoadingAnimator;
    private Paint mPaint;
    private boolean mRunning;
    private float mStartAngle;
    private float mSweepAngle;

    public CircularAnimatedDrawable(int i4, float f4) {
        this.mLoadingAnimator = null;
        this.mBorderWidth = f4;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f4);
        this.mPaint.setColor(i4);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mLoadingAnimator = createLoadingAnimator();
    }

    private Animator createLoadingAnimator() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(START_ANGLE_PROPERTY, Keyframe.ofFloat(Property.DEFAULT_FLOAT_VALUE, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(SWEEP_ANGLE_PROPERTY, Property.DEFAULT_FLOAT_VALUE, -120.0f, Property.DEFAULT_FLOAT_VALUE));
        objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawArc(this.fBounds, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.fBounds;
        float f4 = rect.left;
        float f5 = this.mBorderWidth;
        rectF.left = (f5 / 2.0f) + f4;
        rectF.right = rect.right - (f5 / 2.0f);
        rectF.top = (f5 / 2.0f) + rect.top;
        rectF.bottom = rect.bottom - (f5 / 2.0f);
    }

    public void setAllowLoading(boolean z4) {
        this.mAllowLoading = z4;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.mPaint.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setIndicatorColor(int i4) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i4);
        }
    }

    public void setStartAngle(float f4) {
        this.mStartAngle = f4;
        if (this.mAllowLoading) {
            invalidateSelf();
        }
    }

    public void setStrokeWidth(int i4) {
        if (i4 <= 0 || ((int) this.mBorderWidth) == i4) {
            return;
        }
        this.mBorderWidth = i4;
        onBoundsChange(getBounds());
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mBorderWidth);
        }
    }

    public void setSweepAngle(float f4) {
        this.mSweepAngle = f4;
        if (this.mAllowLoading) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.mRunning = true;
        this.mLoadingAnimator.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.mRunning = false;
            this.mLoadingAnimator.cancel();
            invalidateSelf();
        }
    }
}
