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
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import j2.InterpolatorC0636a;
import java.lang.reflect.InvocationTargetException;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class StepOSRatingBar extends RatingBar implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public int f11806a;

    /* renamed from: b, reason: collision with root package name */
    public int f11807b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11808c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f11809d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f11810e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11811f;

    /* renamed from: g, reason: collision with root package name */
    public final GestureDetector f11812g;

    /* renamed from: h, reason: collision with root package name */
    public ValueAnimator f11813h;

    /* renamed from: i, reason: collision with root package name */
    public final InterpolatorC0636a f11814i;

    /* renamed from: j, reason: collision with root package name */
    public final InterpolatorC0636a f11815j;

    /* renamed from: k, reason: collision with root package name */
    public int f11816k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f11817l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f11818m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11819n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11820o;

    public StepOSRatingBar(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, R.attr.StepOSCommon_StepOSRatingBarStyle);
        this.f11806a = 0;
        this.f11807b = 0;
        this.f11811f = false;
        this.f11814i = new InterpolatorC0636a(0.2f, 0.04f, 0.08f);
        this.f11815j = new InterpolatorC0636a(0.35f, 0.56f, Property.DEFAULT_FLOAT_VALUE);
        this.f11816k = 0;
        this.f11819n = 220;
        this.f11820o = 280;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13039u, R.attr.StepOSCommon_StepOSRatingBarStyle, 0);
        this.f11810e = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(0, R.array.mc_rating_bar_default_colors));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f11809d = drawable;
        if (drawable == null) {
            this.f11809d = getResources().getDrawable(R.drawable.stepos_btn_big_star);
        }
        this.f11808c = this.f11809d.getIntrinsicWidth();
        typedArrayObtainStyledAttributes.recycle();
        if (Property.DEFAULT_FLOAT_VALUE != getRating()) {
            int rating = (int) getRating();
            this.f11806a = rating;
            this.f11807b = rating;
            this.f11811f = true;
        }
        this.f11812g = new GestureDetector(context, this);
        this.f11817l = new float[getNumStars()];
        this.f11818m = new float[getNumStars()];
        int i4 = 0;
        while (true) {
            float[] fArr = this.f11817l;
            if (i4 >= fArr.length) {
                try {
                    break;
                } catch (Exception unused) {
                    Log.e("StepOSRatingBar", "NightMode methods reflected failed!");
                    return;
                }
            } else {
                fArr[i4] = 0.0f;
                i4++;
            }
        }
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", Boolean.TYPE).invoke(this.f11809d, Boolean.FALSE);
        }
    }

    private int getProgressPos() {
        return getPaddingLeft() + ((int) ((getScale() * ((getWidth() - getPaddingLeft()) - getPaddingRight())) + 0.5f));
    }

    private float getScale() {
        int max = getMax();
        return max > 0 ? getProgress() / max : Property.DEFAULT_FLOAT_VALUE;
    }

    private void setEnd(int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            this.f11817l[i5] = (i5 * 16) + this.f11819n + this.f11820o;
        }
    }

    public final void a(int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            this.f11818m[i5] = this.f11817l[i5];
        }
    }

    public final void b(int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        while (i4 < i5) {
            this.f11818m[i4] = 0.0f;
            i4++;
        }
    }

    public final void c() {
        if (this.f11813h == null) {
            this.f11816k = (getNumStars() * 16) + this.f11819n + this.f11820o;
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f11816k);
            this.f11813h = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(this.f11816k);
            this.f11813h.setInterpolator(new LinearInterpolator());
            this.f11813h.addUpdateListener(new com.airbnb.lottie.q(4, this));
        }
        this.f11813h.start();
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        return this.f11811f ? super.getRating() : (int) Math.ceil(r0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.f11811f) {
            setEnd(Math.min(this.f11807b, getNumStars()));
        }
        a(this.f11807b);
        b(Math.min(this.f11807b, getNumStars()), getNumStars());
        int iMin = Math.min((int) ((getProgressPos() / this.f11808c) + 0.5f), getNumStars());
        this.f11806a = iMin;
        this.f11807b = iMin;
        this.f11811f = false;
        c();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i4 = 0;
            boolean z4 = getLayoutDirection() == 1;
            if (this.f11809d != null && this.f11810e != null) {
                canvas.save();
                if (z4) {
                    canvas.clipRect(getWidth() - ((this.f11811f ? getRating() : this.f11806a) * this.f11808c), Property.DEFAULT_FLOAT_VALUE, getWidth(), getHeight());
                } else {
                    canvas.clipRect(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, (this.f11811f ? getRating() : this.f11806a) * this.f11808c, getHeight());
                }
                int paddingLeft = !z4 ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f11809d.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i4 < getNumStars()) {
                    int[] iArr = this.f11810e;
                    this.f11809d.setColorFilter(i4 >= iArr.length ? iArr[iArr.length - 1] : iArr[i4], PorterDuff.Mode.SRC_IN);
                    this.f11809d.setBounds(new Rect(paddingLeft, paddingTop, this.f11809d.getIntrinsicWidth() + paddingLeft, this.f11809d.getIntrinsicHeight() + paddingTop));
                    paddingLeft = z4 ? paddingLeft - this.f11809d.getIntrinsicWidth() : paddingLeft + this.f11809d.getIntrinsicWidth();
                    canvas.save();
                    if (!this.f11811f) {
                        float f4 = this.f11817l[i4];
                        int i5 = this.f11819n;
                        float interpolation = f4 < ((float) i5) ? (this.f11814i.getInterpolation(f4 / i5) * 0.92999995f) + 0.1f : AbstractC0831a.c(1.0f, this.f11815j.getInterpolation((f4 - i5) / this.f11820o), 0.03f, 1.0f);
                        float f5 = 1.0f - interpolation;
                        canvas.translate((r5.width() * f5 * 0.5f) + ((z4 ? (this.f11817l.length - 1) - i4 : i4) * r5.width() * f5), r5.height() * f5 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.f11809d.draw(canvas);
                    canvas.restore();
                    i4++;
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        int iMin = Math.min((int) ((getProgressPos() / this.f11808c) + 0.5f), getNumStars());
        this.f11806a = iMin;
        int i4 = this.f11807b;
        if (iMin - i4 > 0) {
            a(i4);
            b(Math.min(this.f11806a - 1, getNumStars()), getNumStars());
            int i5 = 0;
            while (true) {
                float[] fArr = this.f11817l;
                if (i5 >= fArr.length) {
                    break;
                }
                fArr[i5] = 0.0f;
                i5++;
            }
            this.f11813h.cancel();
            c();
        } else {
            a(iMin);
            b(Math.min(this.f11807b, getNumStars()), getNumStars());
        }
        this.f11807b = this.f11806a;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        this.f11812g.onTouchEvent(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f4) {
        super.setRating(f4);
        this.f11811f = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(f4));
        this.f11806a = iMin;
        this.f11807b = iMin;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.f11810e = iArr;
        }
    }
}
