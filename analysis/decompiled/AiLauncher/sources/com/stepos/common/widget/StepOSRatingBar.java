package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.RatingBar;
import com.stepos.agentframework.chatui.view.AssistantImageCardView;
import com.stepos.common.R$array;
import com.stepos.common.R$attr;
import com.stepos.common.R$drawable;
import com.stepos.common.R$styleable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class StepOSRatingBar extends RatingBar implements GestureDetector.OnGestureListener {
    private int currentIndex;
    private boolean hasInitialNum;
    private int lastIndex;
    private ValueAnimator mAnimaotr;
    private float[] mBackScales;
    private GestureDetector mDector;
    private int mLastLayoutDirection;
    private L6.a mScaleDownInt;
    private L6.a mScaleUpInt;
    private float[] mScales;
    private int[] mStarColors;
    private Drawable mStarDrawable;
    private int scaleDownTime;
    private int scaleUpTime;
    private float starWidth;
    private int sumTime;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            for (int i10 = 0; i10 < StepOSRatingBar.this.getNumStars(); i10++) {
                StepOSRatingBar.this.mScales[i10] = Math.min(Math.max(0.0f, (StepOSRatingBar.this.mBackScales[i10] + fIntValue) - (i10 * 16.0f)), StepOSRatingBar.this.scaleUpTime + StepOSRatingBar.this.scaleDownTime);
            }
            StepOSRatingBar.this.invalidate();
        }
    }

    public StepOSRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.StepOSCommon_StepOSRatingBarStyle);
    }

    private int getProgressPos() {
        return ((int) ((getScale() * ((getWidth() - getPaddingLeft()) - getPaddingRight())) + 0.5f)) + getPaddingLeft();
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return getProgress() / max;
        }
        return 0.0f;
    }

    private void setEnd(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.mScales[i11] = this.scaleUpTime + this.scaleDownTime + (i11 * 16);
        }
    }

    public final void e(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.mBackScales[i11] = this.mScales[i11];
        }
    }

    public final int f() {
        return Math.min((int) ((getProgressPos() / this.starWidth) + 0.5f), getNumStars());
    }

    public final void g() {
        int i10 = 0;
        while (true) {
            float[] fArr = this.mScales;
            if (i10 >= fArr.length) {
                return;
            }
            fArr[i10] = 0.0f;
            i10++;
        }
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        return this.hasInitialNum ? super.getRating() : (int) Math.ceil(r0);
    }

    public final void h(int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        while (i10 < i11) {
            this.mBackScales[i10] = 0.0f;
            i10++;
        }
    }

    public final void i() {
        if (this.mAnimaotr == null) {
            this.sumTime = this.scaleUpTime + this.scaleDownTime + (getNumStars() * 16);
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.sumTime);
            this.mAnimaotr = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(this.sumTime);
            this.mAnimaotr.setInterpolator(new LinearInterpolator());
            this.mAnimaotr.addUpdateListener(new a());
        }
        this.mAnimaotr.start();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.hasInitialNum) {
            setEnd(Math.min(this.lastIndex, getNumStars()));
        }
        e(this.lastIndex);
        h(Math.min(this.lastIndex, getNumStars()), getNumStars());
        int iF = f();
        this.currentIndex = iF;
        this.lastIndex = iF;
        this.hasInitialNum = false;
        i();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i10 = 0;
            boolean z10 = getLayoutDirection() == 1;
            if (this.mStarDrawable != null && this.mStarColors != null) {
                canvas.save();
                if (z10) {
                    canvas.clipRect(getWidth() - ((this.hasInitialNum ? getRating() : this.currentIndex) * this.starWidth), 0.0f, getWidth(), getHeight());
                } else {
                    canvas.clipRect(0.0f, 0.0f, (this.hasInitialNum ? getRating() : this.currentIndex) * this.starWidth, getHeight());
                }
                int paddingLeft = !z10 ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mStarDrawable.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i10 < getNumStars()) {
                    int[] iArr = this.mStarColors;
                    this.mStarDrawable.setColorFilter(i10 >= iArr.length ? iArr[iArr.length - 1] : iArr[i10], PorterDuff.Mode.SRC_IN);
                    this.mStarDrawable.setBounds(new Rect(paddingLeft, paddingTop, this.mStarDrawable.getIntrinsicWidth() + paddingLeft, this.mStarDrawable.getIntrinsicHeight() + paddingTop));
                    paddingLeft = z10 ? paddingLeft - this.mStarDrawable.getIntrinsicWidth() : paddingLeft + this.mStarDrawable.getIntrinsicWidth();
                    canvas.save();
                    if (!this.hasInitialNum) {
                        float f10 = this.mScales[i10];
                        int i11 = this.scaleUpTime;
                        float interpolation = f10 < ((float) i11) ? (this.mScaleUpInt.getInterpolation(f10 / i11) * 0.92999995f) + 0.1f : ((1.0f - this.mScaleDownInt.getInterpolation((f10 - i11) / this.scaleDownTime)) * 0.03f) + 1.0f;
                        float f11 = 1.0f - interpolation;
                        canvas.translate(((z10 ? (this.mScales.length - 1) - i10 : i10) * r5.width() * f11) + (r5.width() * f11 * 0.5f), r5.height() * f11 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.mStarDrawable.draw(canvas);
                    canvas.restore();
                    i10++;
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        int iF = f();
        this.currentIndex = iF;
        int i10 = this.lastIndex;
        if (iF - i10 > 0) {
            e(i10);
            h(Math.min(this.currentIndex - 1, getNumStars()), getNumStars());
            g();
            this.mAnimaotr.cancel();
            i();
        } else {
            e(iF);
            h(Math.min(this.lastIndex, getNumStars()), getNumStars());
        }
        this.lastIndex = this.currentIndex;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        this.mDector.onTouchEvent(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f10) {
        super.setRating(f10);
        this.hasInitialNum = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(f10));
        this.currentIndex = iMin;
        this.lastIndex = iMin;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.mStarColors = iArr;
        }
    }

    public StepOSRatingBar(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i10);
        this.currentIndex = 0;
        this.lastIndex = 0;
        this.hasInitialNum = false;
        this.mScaleUpInt = new L6.a(0.2f, 0.04f, 0.08f, 1.0f);
        this.mScaleDownInt = new L6.a(0.35f, 0.56f, 0.0f, 1.0f);
        this.sumTime = 0;
        this.scaleUpTime = 220;
        this.scaleDownTime = AssistantImageCardView.MAX_WIDTH_DP;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SteposRatingBar, i10, 0);
        this.mStarColors = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(R$styleable.SteposRatingBar_mcStarColors, R$array.mc_rating_bar_default_colors));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.SteposRatingBar_mcStarDrawable);
        this.mStarDrawable = drawable;
        if (drawable == null) {
            this.mStarDrawable = getResources().getDrawable(R$drawable.stepos_btn_big_star);
        }
        this.starWidth = this.mStarDrawable.getIntrinsicWidth();
        typedArrayObtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.currentIndex = rating;
            this.lastIndex = rating;
            this.hasInitialNum = true;
        }
        this.mDector = new GestureDetector(context, this);
        this.mScales = new float[getNumStars()];
        this.mBackScales = new float[getNumStars()];
        g();
        try {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", Boolean.TYPE).invoke(this.mStarDrawable, Boolean.FALSE);
            }
        } catch (Exception unused) {
            Log.e("StepOSRatingBar", "NightMode methods reflected failed!");
        }
    }
}
