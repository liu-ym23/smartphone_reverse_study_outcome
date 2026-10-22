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
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class StepOSRatingBar extends RatingBar implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    private int f14258a;

    /* renamed from: b, reason: collision with root package name */
    private int f14259b;

    /* renamed from: c, reason: collision with root package name */
    private float f14260c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f14261d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f14262e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14263f;

    /* renamed from: g, reason: collision with root package name */
    private GestureDetector f14264g;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f14265h;

    /* renamed from: i, reason: collision with root package name */
    private K1.a f14266i;

    /* renamed from: j, reason: collision with root package name */
    private K1.a f14267j;

    /* renamed from: k, reason: collision with root package name */
    private int f14268k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f14269l;

    /* renamed from: m, reason: collision with root package name */
    private float[] f14270m;

    /* renamed from: n, reason: collision with root package name */
    private int f14271n;

    /* renamed from: o, reason: collision with root package name */
    private int f14272o;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            for (int i5 = 0; i5 < StepOSRatingBar.this.getNumStars(); i5++) {
                StepOSRatingBar.this.f14269l[i5] = Math.min(Math.max(0.0f, (StepOSRatingBar.this.f14270m[i5] + fIntValue) - (i5 * 16.0f)), StepOSRatingBar.this.f14271n + StepOSRatingBar.this.f14272o);
            }
            StepOSRatingBar.this.invalidate();
        }
    }

    public StepOSRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2059f);
    }

    private void e(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            this.f14270m[i6] = this.f14269l[i6];
        }
    }

    private int f() {
        return Math.min((int) ((getProgressPos() / this.f14260c) + 0.5f), getNumStars());
    }

    private void g() {
        int i5 = 0;
        while (true) {
            float[] fArr = this.f14269l;
            if (i5 >= fArr.length) {
                return;
            }
            fArr[i5] = 0.0f;
            i5++;
        }
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

    private void h(int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        while (i5 < i6) {
            this.f14270m[i5] = 0.0f;
            i5++;
        }
    }

    private void i() {
        if (this.f14265h == null) {
            this.f14268k = this.f14271n + this.f14272o + (getNumStars() * 16);
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f14268k);
            this.f14265h = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(this.f14268k);
            this.f14265h.setInterpolator(new LinearInterpolator());
            this.f14265h.addUpdateListener(new a());
        }
        this.f14265h.start();
    }

    private void setEnd(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            this.f14269l[i6] = this.f14271n + this.f14272o + (i6 * 16);
        }
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        return this.f14263f ? super.getRating() : (int) Math.ceil(r0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.f14263f) {
            setEnd(Math.min(this.f14259b, getNumStars()));
        }
        e(this.f14259b);
        h(Math.min(this.f14259b, getNumStars()), getNumStars());
        int iF = f();
        this.f14258a = iF;
        this.f14259b = iF;
        this.f14263f = false;
        i();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i5 = 0;
            boolean z5 = getLayoutDirection() == 1;
            if (this.f14261d != null && this.f14262e != null) {
                canvas.save();
                if (z5) {
                    canvas.clipRect(getWidth() - ((this.f14263f ? getRating() : this.f14258a) * this.f14260c), 0.0f, getWidth(), getHeight());
                } else {
                    canvas.clipRect(0.0f, 0.0f, (this.f14263f ? getRating() : this.f14258a) * this.f14260c, getHeight());
                }
                int paddingLeft = !z5 ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f14261d.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i5 < getNumStars()) {
                    int[] iArr = this.f14262e;
                    this.f14261d.setColorFilter(i5 >= iArr.length ? iArr[iArr.length - 1] : iArr[i5], PorterDuff.Mode.SRC_IN);
                    this.f14261d.setBounds(new Rect(paddingLeft, paddingTop, this.f14261d.getIntrinsicWidth() + paddingLeft, this.f14261d.getIntrinsicHeight() + paddingTop));
                    paddingLeft = z5 ? paddingLeft - this.f14261d.getIntrinsicWidth() : paddingLeft + this.f14261d.getIntrinsicWidth();
                    canvas.save();
                    if (!this.f14263f) {
                        float f5 = this.f14269l[i5];
                        int i6 = this.f14271n;
                        float interpolation = f5 < ((float) i6) ? (this.f14266i.getInterpolation(f5 / i6) * 0.92999995f) + 0.1f : ((1.0f - this.f14267j.getInterpolation((f5 - i6) / this.f14272o)) * 0.03f) + 1.0f;
                        float f6 = 1.0f - interpolation;
                        canvas.translate(((z5 ? (this.f14269l.length - 1) - i5 : i5) * r5.width() * f6) + (r5.width() * f6 * 0.5f), r5.height() * f6 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.f14261d.draw(canvas);
                    canvas.restore();
                    i5++;
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        int iF = f();
        this.f14258a = iF;
        int i5 = this.f14259b;
        if (iF - i5 > 0) {
            e(i5);
            h(Math.min(this.f14258a - 1, getNumStars()), getNumStars());
            g();
            this.f14265h.cancel();
            i();
        } else {
            e(iF);
            h(Math.min(this.f14259b, getNumStars()), getNumStars());
        }
        this.f14259b = this.f14258a;
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
        this.f14264g.onTouchEvent(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f5) {
        super.setRating(f5);
        this.f14263f = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(f5));
        this.f14258a = iMin;
        this.f14259b = iMin;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.f14262e = iArr;
        }
    }

    public StepOSRatingBar(Context context, AttributeSet attributeSet, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i5);
        this.f14258a = 0;
        this.f14259b = 0;
        this.f14263f = false;
        this.f14266i = new K1.a(0.2f, 0.04f, 0.08f, 1.0f);
        this.f14267j = new K1.a(0.35f, 0.56f, 0.0f, 1.0f);
        this.f14268k = 0;
        this.f14271n = 220;
        this.f14272o = 280;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.z6, i5, 0);
        this.f14262e = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(H1.m.A6, H1.b.f2053d));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(H1.m.B6);
        this.f14261d = drawable;
        if (drawable == null) {
            this.f14261d = getResources().getDrawable(H1.g.f2195k);
        }
        this.f14260c = this.f14261d.getIntrinsicWidth();
        typedArrayObtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.f14258a = rating;
            this.f14259b = rating;
            this.f14263f = true;
        }
        this.f14264g = new GestureDetector(context, this);
        this.f14269l = new float[getNumStars()];
        this.f14270m = new float[getNumStars()];
        g();
        try {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                BitmapDrawable.class.getDeclaredMethod("reverseInMzNightMode", Boolean.TYPE).invoke(this.f14261d, Boolean.FALSE);
            }
        } catch (Exception unused) {
            Log.e("StepOSRatingBar", "NightMode methods reflected failed!");
        }
    }
}
