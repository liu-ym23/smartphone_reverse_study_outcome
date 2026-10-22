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

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    public CircularAnimatedDrawable(int i10, float f8) {
        this.mLoadingAnimator = null;
        this.mBorderWidth = f8;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(f8);
        this.mPaint.setColor(i10);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mLoadingAnimator = createLoadingAnimator();
    }

    private Animator createLoadingAnimator() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(START_ANGLE_PROPERTY, Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(SWEEP_ANGLE_PROPERTY, 0.0f, -120.0f, 0.0f));
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
        float f8 = rect.left;
        float f9 = this.mBorderWidth;
        rectF.left = (f9 / 2.0f) + f8;
        rectF.right = rect.right - (f9 / 2.0f);
        rectF.top = (f9 / 2.0f) + rect.top;
        rectF.bottom = rect.bottom - (f9 / 2.0f);
    }

    public void setAllowLoading(boolean z) {
        this.mAllowLoading = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mPaint.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setIndicatorColor(int i10) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i10);
        }
    }

    public void setStartAngle(float f8) {
        this.mStartAngle = f8;
        if (this.mAllowLoading) {
            invalidateSelf();
        }
    }

    public void setStrokeWidth(int i10) {
        if (i10 <= 0 || ((int) this.mBorderWidth) == i10) {
            return;
        }
        this.mBorderWidth = i10;
        onBoundsChange(getBounds());
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mBorderWidth);
        }
    }

    public void setSweepAngle(float f8) {
        this.mSweepAngle = f8;
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
