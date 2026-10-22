package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$styleable;

/* loaded from: classes3.dex */
public class SwimmingAnimationView extends View {
    private static final int ANIMATION_DOWN_DURATION = 450;
    private static final int ANIMATION_UP_DURATION = 520;
    private static final String TAG = "SwimmingAnimationView";
    private Animator mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private Paint mCirclePaint;
    private Context mContext;
    private int mDistance;
    private L6.a mDownInterpolator;
    private float mFirstPosition;
    private int mGap;
    private volatile boolean mIsAnimRun;
    private d mOnChangeListener;
    private int mRadius;
    private float mSecondPosition;
    private float mThirdPosition;
    private L6.a mUpInterpolator;

    public class a implements d {
        public a() {
        }

        @Override // com.stepos.common.widget.SwimmingAnimationView.d
        public void a(float f10, float f11, float f12) {
            SwimmingAnimationView.this.mFirstPosition = f10;
            SwimmingAnimationView.this.mSecondPosition = f11;
            SwimmingAnimationView.this.mThirdPosition = f12;
            SwimmingAnimationView.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            @TargetApi(17)
            public void run() {
                SwimmingAnimationView.this.mAnimator.start();
            }
        }

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (Settings.Global.getFloat(SwimmingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                SwimmingAnimationView.this.post(new a());
            } else {
                Log.d(SwimmingAnimationView.TAG, "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                SwimmingAnimationView.this.h();
            }
        }
    }

    public static class c implements ValueAnimator.AnimatorUpdateListener {
        private long firstDelay;
        private float firstDistance;
        private Interpolator firstDownInterpolator;
        private long firstDownTime;
        private Interpolator firstUpInterpolator;
        private long firstUpTime;
        private d mOnChangeListener;
        private long secondDelay;
        private float secondDistance;
        private Interpolator secondDownInterpolator;
        private long secondDownTime;
        private Interpolator secondUpInterpolator;
        private long secondUpTime;
        private long thirdDelay;
        private float thirdDistance;
        private Interpolator thirdDownInterpolator;
        private long thirdDownTime;
        private Interpolator thirdUpInterpolator;
        private long thirdUpTime;

        public final float a(float f10, long j10, long j11, long j12, float f11, Interpolator interpolator, Interpolator interpolator2) {
            float f12 = f10 - j10;
            if (f12 < 0.0f) {
                f12 += j11 + j12;
            }
            float f13 = j11;
            return f12 < f13 ? b(0.0f, f11, interpolator, f12 / f13) : b(f11, 0.0f, interpolator2, (f12 - f13) / j12);
        }

        public final float b(float f10, float f11, Interpolator interpolator, float f12) {
            return f10 + ((f11 - f10) * interpolator.getInterpolation(f12));
        }

        public void c(float f10, long j10, Interpolator interpolator, long j11, Interpolator interpolator2, long j12) {
            this.firstDistance = f10;
            this.firstDownTime = j10;
            this.firstDownInterpolator = interpolator;
            this.firstUpTime = j11;
            this.firstUpInterpolator = interpolator2;
            this.firstDelay = j12;
        }

        public void d(d dVar) {
            this.mOnChangeListener = dVar;
        }

        public void e(float f10, long j10, Interpolator interpolator, long j11, Interpolator interpolator2, long j12) {
            this.secondDistance = f10;
            this.secondDownTime = j10;
            this.secondDownInterpolator = interpolator;
            this.secondUpTime = j11;
            this.secondUpInterpolator = interpolator2;
            this.secondDelay = j12;
        }

        public void f(float f10, long j10, Interpolator interpolator, long j11, Interpolator interpolator2, long j12) {
            this.thirdDistance = f10;
            this.thirdDownTime = j10;
            this.thirdDownInterpolator = interpolator;
            this.thirdUpTime = j11;
            this.thirdUpInterpolator = interpolator2;
            this.thirdDelay = j12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.mOnChangeListener == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.mOnChangeListener.a(a(fFloatValue, this.firstDelay, this.firstDownTime, this.firstUpTime, this.firstDistance, this.firstDownInterpolator, this.firstUpInterpolator), a(fFloatValue, this.secondDelay, this.secondDownTime, this.secondUpTime, this.secondDistance, this.secondDownInterpolator, this.secondUpInterpolator), a(fFloatValue, this.thirdDelay, this.thirdDownTime, this.thirdUpTime, this.thirdDistance, this.thirdDownInterpolator, this.thirdUpInterpolator));
        }
    }

    public interface d {
        void a(float f10, float f11, float f12);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void e() {
        this.mFirstPosition = 0.0f;
        this.mSecondPosition = 0.0f;
        this.mThirdPosition = 0.0f;
    }

    public final Animator f() {
        c cVar = new c();
        cVar.d(this.mOnChangeListener);
        cVar.c(this.mDistance, 450L, this.mDownInterpolator, 520L, this.mUpInterpolator, 0L);
        cVar.e(this.mDistance, 450L, this.mDownInterpolator, 520L, this.mUpInterpolator, 83L);
        cVar.f(this.mDistance, 450L, this.mDownInterpolator, 520L, this.mUpInterpolator, 166L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 970);
        valueAnimatorOfFloat.setDuration(970L);
        valueAnimatorOfFloat.addUpdateListener(cVar);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        return valueAnimatorOfFloat;
    }

    public void g() {
        if (this.mIsAnimRun) {
            return;
        }
        this.mIsAnimRun = true;
        this.mAnimator.addListener(this.mAnimatorListener);
        this.mAnimator.start();
        Log.d(TAG, "startAnimator");
    }

    public void h() {
        if (this.mIsAnimRun) {
            this.mIsAnimRun = false;
            this.mAnimator.removeAllListeners();
            this.mAnimator.cancel();
            e();
            Log.d(TAG, "stopAnimator");
        }
    }

    public final void i(int i10) {
        if (i10 == 0 && isShown()) {
            g();
        } else {
            h();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10 = this.mRadius;
        canvas.drawCircle(i10, i10 + this.mFirstPosition, i10, this.mCirclePaint);
        int i11 = this.mRadius;
        canvas.drawCircle((i11 * 3) + this.mGap, i11 + this.mSecondPosition, i11, this.mCirclePaint);
        int i12 = this.mRadius;
        canvas.drawCircle((i12 * 5) + (this.mGap * 2), i12 + this.mThirdPosition, i12, this.mCirclePaint);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.mRadius;
        int i13 = (i12 * 6) + (this.mGap * 2);
        int i14 = (i12 * 2) + this.mDistance;
        setMeasuredDimension(View.resolveSizeAndState(i13 + getPaddingLeft() + getPaddingRight(), i10, 0), View.resolveSizeAndState(i14 + getPaddingTop() + getPaddingBottom(), i11, 0));
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        Log.d(TAG, "onVisibilityChanged=" + i10 + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        i(i10);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        Log.d(TAG, "onWindowVisibilityChanged:" + i10 + ", isShown=" + isShown());
        i(i10);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsAnimRun = false;
        this.mDownInterpolator = new L6.a(0.66f, 0.0f, 0.67f, 1.0f);
        this.mUpInterpolator = new L6.a(0.33f, 0.0f, 0.27f, 1.0f);
        this.mOnChangeListener = new a();
        this.mAnimatorListener = new b();
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwimmingAnimationView);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SwimmingAnimationView_steposCircleColor, context.getResources().getColor(R$color.stepos_theme_color_blue));
        this.mRadius = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SwimmingAnimationView_steposCircleRadius, getResources().getDimensionPixelOffset(R$dimen.stepos_swimming_circle_radius));
        this.mGap = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SwimmingAnimationView_steposCircleGap, getResources().getDimensionPixelOffset(R$dimen.stepos_swimming_circle_gap));
        this.mDistance = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SwimmingAnimationView_steposCircleDistance, getResources().getDimensionPixelOffset(R$dimen.stepos_swimming_circle_distance));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        this.mCirclePaint.setColor(color);
        this.mAnimator = f();
    }
}
