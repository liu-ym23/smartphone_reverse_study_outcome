package com.stepos.common.widget;

import O6.s;
import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$styleable;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class LoadingView extends View {
    private static final int LOADING_ANIMATION = 1;
    private static final int PROGRESS_ANIMATION = 2;
    public static final String START_ANGLE_PROPERTY = "startAngle";
    public static final String SWEEP_ANGLE_PROPERTY = "sweepAngle";
    private final long LOADING_ANIM_DURATION;
    private int mBackgroundColor;
    private float mCentX;
    private float mCentY;
    private RectF mCircleBounds;
    private Context mContext;
    private Paint mDotPaint;
    private int mForegroundColor;
    private Animator mLoadingAnimator;
    private int mLoadingState;
    private Paint mPaint;
    private Paint mPaintArc;
    private Paint mPaintArcBack;
    private int mPaintWidth;
    private float mRadius;
    private float mRingWidth;
    private float mStartAngle;
    private float mSweepAngle;
    private int mThemeColor;

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.StepOSCommon_LoadingViewStyle);
    }

    public final Animator a() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("startAngle", Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat("sweepAngle", 0.0f, -144.0f, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public final void b(Canvas canvas) {
        canvas.drawArc(this.mCircleBounds, -90.0f, 360.0f, false, this.mPaintArcBack);
        canvas.drawArc(this.mCircleBounds, this.mStartAngle, this.mSweepAngle, false, this.mPaintArc);
        float fWidth = this.mCircleBounds.width() / 2.0f;
        float fHeight = this.mCircleBounds.height() / 2.0f;
        float strokeWidth = this.mPaintArc.getStrokeWidth() / 2.0f;
        canvas.drawCircle(this.mCircleBounds.right - (((float) (1.0d - Math.cos(Math.toRadians(this.mStartAngle)))) * fWidth), this.mCircleBounds.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.mStartAngle)))) * fHeight), strokeWidth, this.mDotPaint);
        canvas.drawCircle(this.mCircleBounds.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.mSweepAngle + this.mStartAngle))))), this.mCircleBounds.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.mSweepAngle + this.mStartAngle))))), strokeWidth, this.mDotPaint);
    }

    public final void c() {
        this.mCentX = getX() + getPaddingLeft() + this.mRadius + (this.mPaintWidth * 2) + this.mRingWidth;
        this.mCentY = getY() + getPaddingTop() + this.mRadius + (this.mPaintWidth * 2) + this.mRingWidth;
        RectF rectF = new RectF();
        this.mCircleBounds = rectF;
        float f10 = this.mCentX;
        float f11 = this.mRadius;
        int i10 = this.mPaintWidth;
        float f12 = this.mRingWidth;
        rectF.left = ((f10 - f11) - (i10 / 2)) - (f12 / 2.0f);
        float f13 = this.mCentY;
        rectF.top = ((f13 - f11) - (i10 / 2)) - (f12 / 2.0f);
        rectF.right = f10 + f11 + (i10 / 2) + (f12 / 2.0f);
        rectF.bottom = f13 + f11 + (i10 / 2) + (f12 / 2.0f);
    }

    public void d() {
        e();
    }

    public final void e() {
        Animator animator = this.mLoadingAnimator;
        if (animator == null || !animator.isRunning()) {
            this.mLoadingState = 1;
            Animator animatorA = a();
            this.mLoadingAnimator = animatorA;
            animatorA.start();
        }
    }

    public void f() {
        Animator animator = this.mLoadingAnimator;
        if (animator != null) {
            animator.cancel();
            this.mLoadingAnimator = null;
        }
    }

    public int getBarBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBarColor() {
        return this.mForegroundColor;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mLoadingAnimator;
        if (animator != null) {
            animator.cancel();
            this.mLoadingAnimator = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.translate(((getWidth() / 2) - this.mRadius) - this.mRingWidth, ((getHeight() / 2) - this.mRadius) - this.mRingWidth);
        if (this.mForegroundColor == this.mBackgroundColor) {
            this.mPaintArcBack.setAlpha(26);
        }
        if (this.mLoadingState == 1) {
            b(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = (int) ((this.mRadius + this.mRingWidth + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingLeft() + getPaddingRight() + i12, i10, 0), View.resolveSizeAndState(i12 + getPaddingTop() + getPaddingBottom(), i11, 0));
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (1 != this.mLoadingState) {
            return;
        }
        if (i10 == 0) {
            if (isShown()) {
                e();
            }
        } else {
            Animator animator = this.mLoadingAnimator;
            if (animator != null) {
                animator.cancel();
                this.mLoadingAnimator = null;
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (1 != this.mLoadingState) {
            return;
        }
        if (i10 == 0) {
            if (isShown()) {
                e();
            }
        } else {
            Animator animator = this.mLoadingAnimator;
            if (animator != null) {
                animator.cancel();
                this.mLoadingAnimator = null;
            }
        }
    }

    public void setBarBackgroundColor(int i10) {
        Paint paint = this.mPaintArcBack;
        if (paint == null || paint.getColor() == i10) {
            return;
        }
        this.mPaintArcBack.setColor(i10);
        this.mBackgroundColor = i10;
        postInvalidate();
    }

    public void setBarColor(int i10) {
        Paint paint = this.mPaintArc;
        if (paint == null || paint.getColor() == i10) {
            return;
        }
        this.mPaintArc.setColor(i10);
        this.mDotPaint.setColor(i10);
        this.mForegroundColor = i10;
        postInvalidate();
    }

    public void setStartAngle(float f10) {
        this.mStartAngle = f10;
        invalidate();
    }

    public void setSweepAngle(float f10) {
        this.mSweepAngle = f10;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        Animator animator;
        super.setVisibility(i10);
        if (i10 == 0) {
            e();
        } else if ((i10 == 4 || i10 == 8) && (animator = this.mLoadingAnimator) != null) {
            animator.cancel();
            this.mLoadingAnimator = null;
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = null;
        this.mPaintArc = null;
        this.mPaintArcBack = null;
        this.mDotPaint = null;
        this.mLoadingAnimator = null;
        this.LOADING_ANIM_DURATION = 1760L;
        this.mCircleBounds = null;
        this.mPaintWidth = 0;
        this.mLoadingState = 1;
        this.mContext = context;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(36.0f);
        int iC = s.c(R$attr.colorPrimary, context);
        this.mForegroundColor = context.getResources().getColor(iC == 0 ? R$color.fd_sys_color_primary_blue : iC);
        int iC2 = s.c(R$attr.colorPrimaryContainer, context);
        this.mBackgroundColor = context.getResources().getColor(iC2 == 0 ? R$color.fd_sys_color_primary_container_blue : iC2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LoadingView, R$attr.StepOSCommon_LoadingStyle, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.LoadingView_mcLoadingRadius, 24);
        this.mRingWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.LoadingView_mcRingWidth, 10);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.LoadingView_mcLBackground, this.mBackgroundColor);
        this.mForegroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.LoadingView_mcLForeground, this.mForegroundColor);
        this.mLoadingState = typedArrayObtainStyledAttributes.getInt(R$styleable.LoadingView_mcLoadingState, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.mPaintArc = paint2;
        paint2.setAntiAlias(true);
        this.mPaintArc.setColor(this.mForegroundColor);
        Paint paint3 = this.mPaintArc;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint paint4 = new Paint(this.mPaintArc);
        this.mDotPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.mPaintArcBack = paint5;
        paint5.setAntiAlias(true);
        this.mPaintArcBack.setColor(this.mBackgroundColor);
        this.mPaintArcBack.setStyle(style);
        this.mPaintArc.setStrokeWidth(this.mRingWidth - this.mPaintWidth);
        this.mPaintArcBack.setStrokeWidth(this.mRingWidth - this.mPaintWidth);
        c();
    }
}
