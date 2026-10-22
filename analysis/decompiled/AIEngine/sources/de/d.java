package de;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d extends Drawable {

    /* renamed from: s, reason: collision with root package name */
    public static final PathInterpolator f8493s = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);

    /* renamed from: t, reason: collision with root package name */
    public static final PathInterpolator f8494t = new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<View> f8495a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f8496b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f8497c;

    /* renamed from: d, reason: collision with root package name */
    public int f8498d;

    /* renamed from: e, reason: collision with root package name */
    public int f8499e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8500f;

    /* renamed from: g, reason: collision with root package name */
    public int f8501g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8502i;

    /* renamed from: j, reason: collision with root package name */
    public int f8503j;

    /* renamed from: k, reason: collision with root package name */
    public int f8504k;

    /* renamed from: l, reason: collision with root package name */
    public int f8505l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8506m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8507n;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f8508o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8509p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8510q;
    public boolean r;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f8511a;

        public a(float f8) {
            this.f8511a = f8;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            d dVar = d.this;
            if (dVar.r) {
                dVar.f8498d = iIntValue;
            }
            if (dVar.f8499e >= iIntValue) {
                dVar.f8500f = false;
            }
            if (dVar.f8506m) {
                float f8 = this.f8511a;
                int i10 = (int) (dVar.f8505l * (((iIntValue / dVar.f8501g) - f8) / (1.0f - f8)));
                dVar.f8496b.setAlpha(i10);
                dVar.f8497c.setAlpha(i10 / 2);
            }
            dVar.invalidateSelf();
        }
    }

    public static void a(d dVar) {
        View view = dVar.f8495a.get();
        if (view == null) {
            return;
        }
        dVar.h = view.getWidth();
        dVar.f8502i = view.getHeight();
        new Rect(0, 0, dVar.h, dVar.f8502i);
        if (dVar.f8501g <= 0) {
            dVar.f8501g = ((int) Math.hypot(dVar.h, dVar.f8502i)) / 2;
        }
        if (dVar.f8499e < 0) {
            dVar.f8499e = (int) (dVar.f8501g * 0.825f);
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f8508o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.f8508o.isRunning())) {
            this.f8508o.cancel();
        }
        this.f8496b.setAlpha(this.f8505l);
        this.f8500f = true;
        int i10 = this.f8501g;
        this.f8498d = i10;
        int i11 = this.f8499e;
        float f8 = i11 / i10;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        this.f8508o = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new a(f8));
        this.f8508o.setDuration(this.f8504k);
        this.f8508o.setInterpolator(f8494t);
        this.f8508o.start();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (Build.MODEL.equals("vivo X3t")) {
            int i10 = this.f8501g;
            int i11 = (this.h / 2) + i10;
            int i12 = (this.f8502i / 2) + i10;
            setBounds(-i11, -i12, i11, i12);
        }
        if (this.f8500f || this.f8507n) {
            if (this.f8509p) {
                canvas.drawCircle(this.h / 2, this.f8502i / 2, this.f8501g, this.f8497c);
            }
            canvas.drawCircle(this.h / 2, this.f8502i / 2, this.f8498d, this.f8496b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f8505l;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        boolean z = false;
        boolean z3 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z = true;
            }
            if (i10 == 16842919) {
                z3 = true;
            }
        }
        if (!z || !z3) {
            if (this.f8507n) {
                this.f8507n = false;
                invalidateSelf();
                if (!this.f8500f && this.f8510q) {
                    b();
                }
            }
            return zOnStateChange;
        }
        this.f8507n = true;
        ValueAnimator valueAnimator = this.f8508o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.f8508o.isRunning())) {
            this.f8508o.cancel();
        }
        this.f8496b.setAlpha(this.f8505l);
        this.f8497c.setAlpha(this.f8505l / 2);
        this.f8500f = true;
        int i11 = this.f8499e;
        this.f8498d = i11;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, this.f8501g);
        this.f8508o = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new c(this));
        this.f8508o.setDuration(this.f8503j);
        this.f8508o.setInterpolator(f8493s);
        this.f8508o.start();
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f8505l = i10;
        this.f8496b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f8496b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
    }
}
