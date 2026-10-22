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
import com.stepos.aiengine.R;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSRatingBar extends RatingBar implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public int f7061a;

    /* renamed from: b, reason: collision with root package name */
    public int f7062b;

    /* renamed from: c, reason: collision with root package name */
    public final float f7063c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f7064d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f7065e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final GestureDetector f7066j;

    /* renamed from: k, reason: collision with root package name */
    public ValueAnimator f7067k;

    /* renamed from: l, reason: collision with root package name */
    public final i8.a f7068l;

    /* renamed from: m, reason: collision with root package name */
    public final i8.a f7069m;

    /* renamed from: n, reason: collision with root package name */
    public int f7070n;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f7071o;

    /* renamed from: p, reason: collision with root package name */
    public final float[] f7072p;

    /* renamed from: q, reason: collision with root package name */
    public final int f7073q;
    public final int r;

    public StepOSRatingBar(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, R.attr.StepOSCommon_StepOSRatingBarStyle);
        int i10 = 0;
        this.f7061a = 0;
        this.f7062b = 0;
        this.h = false;
        this.f7068l = new i8.a(0.2f, 0.04f, 0.08f);
        this.f7069m = new i8.a(0.35f, 0.56f, 0.0f);
        this.f7070n = 0;
        this.f7073q = 220;
        this.r = 280;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9093u, R.attr.StepOSCommon_StepOSRatingBarStyle, 0);
        this.f7065e = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(0, R.array.mc_rating_bar_default_colors));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f7064d = drawable;
        if (drawable == null) {
            this.f7064d = getResources().getDrawable(R.drawable.stepos_btn_big_star);
        }
        this.f7063c = this.f7064d.getIntrinsicWidth();
        typedArrayObtainStyledAttributes.recycle();
        if (0.0f != getRating()) {
            int rating = (int) getRating();
            this.f7061a = rating;
            this.f7062b = rating;
            this.h = true;
        }
        this.f7066j = new GestureDetector(context, this);
        this.f7071o = new float[getNumStars()];
        this.f7072p = new float[getNumStars()];
        while (true) {
            float[] fArr = this.f7071o;
            if (i10 >= fArr.length) {
                try {
                    break;
                } catch (Exception unused) {
                    Log.e("StepOSRatingBar", "NightMode methods reflected failed!");
                    return;
                }
            } else {
                fArr[i10] = 0.0f;
                i10++;
            }
        }
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            BitmapDrawable.class.getDeclaredMethod("reverseInStepOSNightMode", Boolean.TYPE).invoke(this.f7064d, Boolean.FALSE);
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

    private void setEnd(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f7071o[i11] = (i11 * 16) + this.f7073q + this.r;
        }
    }

    public final void a(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f7072p[i11] = this.f7071o[i11];
        }
    }

    public final void b(int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        while (i10 < i11) {
            this.f7072p[i10] = 0.0f;
            i10++;
        }
    }

    public final void c() {
        if (this.f7067k == null) {
            this.f7070n = (getNumStars() * 16) + this.f7073q + this.r;
            new ValueAnimator();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.f7070n);
            this.f7067k = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(this.f7070n);
            this.f7067k.setInterpolator(new LinearInterpolator());
            this.f7067k.addUpdateListener(new z(this));
        }
        this.f7067k.start();
    }

    @Override // android.widget.RatingBar
    public float getRating() {
        return this.h ? super.getRating() : (int) Math.ceil(r0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (isIndicator()) {
            return false;
        }
        if (this.h) {
            setEnd(Math.min(this.f7062b, getNumStars()));
        }
        a(this.f7062b);
        b(Math.min(this.f7062b, getNumStars()), getNumStars());
        int iMin = Math.min((int) ((getProgressPos() / this.f7063c) + 0.5f), getNumStars());
        this.f7061a = iMin;
        this.f7062b = iMin;
        this.h = false;
        c();
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            int i10 = 0;
            boolean z = getLayoutDirection() == 1;
            if (this.f7064d != null && this.f7065e != null) {
                canvas.save();
                if (z) {
                    canvas.clipRect(getWidth() - ((this.h ? getRating() : this.f7061a) * this.f7063c), 0.0f, getWidth(), getHeight());
                } else {
                    canvas.clipRect(0.0f, 0.0f, (this.h ? getRating() : this.f7061a) * this.f7063c, getHeight());
                }
                int paddingLeft = !z ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f7064d.getIntrinsicWidth();
                int paddingTop = getPaddingTop();
                while (i10 < getNumStars()) {
                    int[] iArr = this.f7065e;
                    this.f7064d.setColorFilter(i10 >= iArr.length ? iArr[iArr.length - 1] : iArr[i10], PorterDuff.Mode.SRC_IN);
                    this.f7064d.setBounds(new Rect(paddingLeft, paddingTop, this.f7064d.getIntrinsicWidth() + paddingLeft, this.f7064d.getIntrinsicHeight() + paddingTop));
                    paddingLeft = z ? paddingLeft - this.f7064d.getIntrinsicWidth() : paddingLeft + this.f7064d.getIntrinsicWidth();
                    canvas.save();
                    if (!this.h) {
                        float f8 = this.f7071o[i10];
                        float f9 = this.f7073q;
                        float interpolation = f8 < f9 ? (this.f7068l.getInterpolation(f8 / f9) * 0.92999995f) + 0.1f : h0.e.a(1.0f, this.f7069m.getInterpolation((f8 - f9) / this.r), 0.03f, 1.0f);
                        float f10 = 1.0f - interpolation;
                        canvas.translate((r5.width() * f10 * 0.5f) + ((z ? (this.f7071o.length - 1) - i10 : i10) * r5.width() * f10), r5.height() * f10 * 0.5f);
                        canvas.scale(interpolation, interpolation);
                    }
                    this.f7064d.draw(canvas);
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
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        int iMin = Math.min((int) ((getProgressPos() / this.f7063c) + 0.5f), getNumStars());
        this.f7061a = iMin;
        int i10 = this.f7062b;
        if (iMin - i10 > 0) {
            a(i10);
            b(Math.min(this.f7061a - 1, getNumStars()), getNumStars());
            int i11 = 0;
            while (true) {
                float[] fArr = this.f7071o;
                if (i11 >= fArr.length) {
                    break;
                }
                fArr[i11] = 0.0f;
                i11++;
            }
            this.f7067k.cancel();
            c();
        } else {
            a(iMin);
            b(Math.min(this.f7062b, getNumStars()), getNumStars());
        }
        this.f7062b = this.f7061a;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        this.f7066j.onTouchEvent(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.RatingBar
    public void setRating(float f8) {
        super.setRating(f8);
        this.h = true;
        int iMin = Math.min(getNumStars(), (int) Math.ceil(f8));
        this.f7061a = iMin;
        this.f7062b = iMin;
    }

    public void setStarColors(int[] iArr) {
        if (iArr != null) {
            this.f7065e = iArr;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
