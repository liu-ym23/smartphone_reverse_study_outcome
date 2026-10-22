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
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class StepOSRatingBar extends RatingBar implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public int f3771a;
    public int b;
    public final float c;
    public final Drawable d;
    public int[] e;
    public boolean f;
    public final GestureDetector g;
    public ValueAnimator h;
    public final X4.a i;

    /* renamed from: j, reason: collision with root package name */
    public final X4.a f3772j;
    public int k;
    public final float[] l;
    public final float[] m;
    public final int n;
    public final int o;

    public StepOSRatingBar(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, R.attr.StepOSCommon_StepOSRatingBarStyle);
        int i = 0;
        this.f3771a = 0;
        this.b = 0;
        this.f = false;
        this.i = new X4.a(0.2f, 0.04f, 0.08f);
        this.f3772j = new X4.a(0.35f, 0.56f, 0.0f);
        this.k = 0;
        this.n = 220;
        this.o = 280;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.u, R.attr.StepOSCommon_StepOSRatingBarStyle, 0);
        this.e = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(0, R.array.mc_rating_bar_default_colors));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.d = drawable;
        if (drawable == null) {
            this.d = getResources().getDrawable(R.drawable.stepos_btn_big_star);
        }
        this.c = this.d.getIntrinsicWidth();
        typedArrayObtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.f3771a = rating;
            this.b = rating;
            this.f = true;
        }
        this.g = new GestureDetector(context, this);
        this.l = new float[getNumStars()];
        this.m = new float[getNumStars()];
        while (true) {
            float[] fArr = this.l;
            if (i >= fArr.length) {
                try {
                    break;
                } catch (Exception unused) {
                    Log.e("StepOSRatingBar", "NightMode methods reflected failed!");
                    return;
                }
            } else {
                fArr[i] = 0.0f;
                i++;
            }
        }
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", Boolean.TYPE).invoke(this.d, Boolean.FALSE);
        }
    }

    private int getProgressPos() {
        return getPaddingLeft() + ((int) ((getScale() * ((getWidth() - getPaddingLeft()) - getPaddingRight())) + 0.5f));
    }

    private float getScale() {
        int max = getMax();
        if (max > 0) {
            return getProgress() / max;
        }
        return 0.0f;
    }

    private void setEnd(int i) {
        for (int i6 = 0; i6 < i; i6++) {
            this.l[i6] = (i6 * 16) + this.n + this.o;
        }
    }

    public final void a(int i) {
        for (int i6 = 0; i6 < i; i6++) {
            this.m[i6] = this.l[i6];
        }
    }

    public final void b(int i, int i6) {
        if (i == i6) {
            return;
        }
        while (i < i6) {
            this.m[i] = 0.0f;
            i++;
        }
    }

    public final void c() {
        if (this.h == null) {
            this.k = (getNumStars() * 16) + this.n + this.o;
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.k);
            this.h = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(this.k);
            this.h.setInterpolator(new LinearInterpolator());
            this.h.addUpdateListener(new J4.c(this, 5));
        }
        this.h.start();
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        return this.f ? super.getRating() : (int) Math.ceil(r0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.f) {
            setEnd(Math.min(this.b, getNumStars()));
        }
        a(this.b);
        b(Math.min(this.b, getNumStars()), getNumStars());
        int iMin = Math.min((int) ((getProgressPos() / this.c) + 0.5f), getNumStars());
        this.f3771a = iMin;
        this.b = iMin;
        this.f = false;
        c();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i = 0;
            boolean z10 = getLayoutDirection() == 1;
            if (this.d != null && this.e != null) {
                canvas.save();
                if (z10) {
                    canvas.clipRect(getWidth() - ((this.f ? getRating() : this.f3771a) * this.c), 0.0f, getWidth(), getHeight());
                } else {
                    canvas.clipRect(0.0f, 0.0f, (this.f ? getRating() : this.f3771a) * this.c, getHeight());
                }
                int paddingLeft = !z10 ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.d.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i < getNumStars()) {
                    int[] iArr = this.e;
                    this.d.setColorFilter(i >= iArr.length ? iArr[iArr.length - 1] : iArr[i], PorterDuff.Mode.SRC_IN);
                    this.d.setBounds(new Rect(paddingLeft, paddingTop, this.d.getIntrinsicWidth() + paddingLeft, this.d.getIntrinsicHeight() + paddingTop));
                    paddingLeft = z10 ? paddingLeft - this.d.getIntrinsicWidth() : paddingLeft + this.d.getIntrinsicWidth();
                    canvas.save();
                    if (!this.f) {
                        float f = this.l[i];
                        float f7 = this.n;
                        float interpolation = f < f7 ? (this.i.getInterpolation(f / f7) * 0.92999995f) + 0.1f : B7.a.b(1.0f, this.f3772j.getInterpolation((f - f7) / this.o), 0.03f, 1.0f);
                        float f9 = 1.0f - interpolation;
                        canvas.translate((r5.width() * f9 * 0.5f) + ((z10 ? (this.l.length - 1) - i : i) * r5.width() * f9), r5.height() * f9 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.d.draw(canvas);
                    canvas.restore();
                    i++;
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f7) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f7) {
        int iMin = Math.min((int) ((getProgressPos() / this.c) + 0.5f), getNumStars());
        this.f3771a = iMin;
        int i = this.b;
        if (iMin - i > 0) {
            a(i);
            b(Math.min(this.f3771a - 1, getNumStars()), getNumStars());
            int i6 = 0;
            while (true) {
                float[] fArr = this.l;
                if (i6 >= fArr.length) {
                    break;
                }
                fArr[i6] = 0.0f;
                i6++;
            }
            this.h.cancel();
            c();
        } else {
            a(iMin);
            b(Math.min(this.b, getNumStars()), getNumStars());
        }
        this.b = this.f3771a;
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
        this.g.onTouchEvent(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f) {
        super.setRating(f);
        this.f = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(f));
        this.f3771a = iMin;
        this.b = iMin;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.e = iArr;
        }
    }
}
