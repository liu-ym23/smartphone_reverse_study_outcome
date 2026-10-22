package com.android.server.accessibility.autoclick;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes.dex */
public class AutoclickIndicatorView extends View {
    static final int MINIMAL_ANIMATION_DURATION = 50;
    static final int SHOW_INDICATOR_DELAY_TIME = 150;
    private static final String TAG = null;
    private int mAnimationDuration;
    private final ValueAnimator mAnimator;
    private final Paint mPaint;
    private int mRadius;
    private final RectF mRingRect;
    private float mSweepAngle;
    private float mX;
    private float mY;
    private boolean showIndicator;

    public static /* synthetic */ void $r8$lambda$XCCBzXrVTtNEH0J0yQGwsCL9wM0(AutoclickIndicatorView r0, ValueAnimator r1) {
        r0.lambda$new$0(r1);
    }

    @Override // android.view.View
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams getLayoutParams() {
        return getLayoutParams();
    }

    static {
        TAG = AutoclickIndicatorView.class.getSimpleName();
    }

    public AutoclickIndicatorView(Context context) {
        super(context);
        this.mRadius = 60;
        this.mAnimationDuration = 600;
        this.showIndicator = false;
        this.mPaint = new Paint();
        this.mPaint.setColor(context.getColor(R.color.primary_dark_material_light));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(10.0f);
        this.mAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.mAnimator.setDuration(this.mAnimationDuration);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new AutoclickIndicatorView$$ExternalSyntheticLambda0(this));
        this.mRingRect = new RectF();
    }

    private /* synthetic */ void lambda$new$0(ValueAnimator animation) {
        this.mSweepAngle = ((Float) animation.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public final WindowManager.LayoutParams getLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2015;
        layoutParams.flags = FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS;
        layoutParams.privateFlags |= 16;
        layoutParams.setFitInsetsTypes(WindowInsets.Type.statusBars());
        layoutParams.layoutInDisplayCutoutMode = 3;
        layoutParams.format = -3;
        layoutParams.setTitle(AutoclickIndicatorView.class.getSimpleName());
        layoutParams.inputFeatures |= 1;
        return layoutParams;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.showIndicator == false) goto L6;
        this.mRingRect.set(this.mX - this.mRadius, this.mY - this.mRadius, this.mX + this.mRadius, this.mY + this.mRadius);
        canvas.drawArc(this.mRingRect, -90.0f, this.mSweepAngle, false, this.mPaint);
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        setMeasuredDimension(screenWidth, screenHeight);
    }

    public void setCoordination(float x, float y) {
        this.mX = x;
        this.mY = y;
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
    }

    int getRadiusForTesting() {
        return this.mRadius;
    }

    public void redrawIndicator() {
        this.showIndicator = true;
        invalidate();
        this.mAnimator.start();
    }

    public void clearIndicator() {
        this.showIndicator = false;
        this.mAnimator.cancel();
        invalidate();
    }

    public void setAnimationDuration(int duration) {
        this.mAnimationDuration = Math.max(duration, 50);
        this.mAnimator.setDuration(this.mAnimationDuration);
    }
}
