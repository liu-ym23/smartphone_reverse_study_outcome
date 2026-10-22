package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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

/* loaded from: classes.dex */
public class SwimmingAnimationView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f14274a;

    /* renamed from: b, reason: collision with root package name */
    private int f14275b;

    /* renamed from: c, reason: collision with root package name */
    private int f14276c;

    /* renamed from: d, reason: collision with root package name */
    private int f14277d;

    /* renamed from: e, reason: collision with root package name */
    private float f14278e;

    /* renamed from: f, reason: collision with root package name */
    private float f14279f;

    /* renamed from: g, reason: collision with root package name */
    private float f14280g;

    /* renamed from: h, reason: collision with root package name */
    private Context f14281h;

    /* renamed from: i, reason: collision with root package name */
    private Animator f14282i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f14283j;

    /* renamed from: k, reason: collision with root package name */
    private K1.a f14284k;

    /* renamed from: l, reason: collision with root package name */
    private K1.a f14285l;

    /* renamed from: m, reason: collision with root package name */
    private d f14286m;

    /* renamed from: n, reason: collision with root package name */
    private Animator.AnimatorListener f14287n;

    class a implements d {
        a() {
        }

        @Override // com.stepos.common.widget.SwimmingAnimationView.d
        public void a(float f5, float f6, float f7) {
            SwimmingAnimationView.this.f14278e = f5;
            SwimmingAnimationView.this.f14279f = f6;
            SwimmingAnimationView.this.f14280g = f7;
            SwimmingAnimationView.this.invalidate();
        }
    }

    class b extends AnimatorListenerAdapter {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwimmingAnimationView.this.f14282i.start();
            }
        }

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (Settings.Global.getFloat(SwimmingAnimationView.this.getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                SwimmingAnimationView.this.post(new a());
            } else {
                Log.d("SwimmingAnimationView", "onAnimationEnd, animatorDurationScale == 0, stopAnimator");
                SwimmingAnimationView.this.h();
            }
        }
    }

    static class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private float f14291a;

        /* renamed from: b, reason: collision with root package name */
        private long f14292b;

        /* renamed from: c, reason: collision with root package name */
        private Interpolator f14293c;

        /* renamed from: d, reason: collision with root package name */
        private long f14294d;

        /* renamed from: e, reason: collision with root package name */
        private Interpolator f14295e;

        /* renamed from: f, reason: collision with root package name */
        private long f14296f;

        /* renamed from: g, reason: collision with root package name */
        private float f14297g;

        /* renamed from: h, reason: collision with root package name */
        private long f14298h;

        /* renamed from: i, reason: collision with root package name */
        private Interpolator f14299i;

        /* renamed from: j, reason: collision with root package name */
        private long f14300j;

        /* renamed from: k, reason: collision with root package name */
        private Interpolator f14301k;

        /* renamed from: l, reason: collision with root package name */
        private long f14302l;

        /* renamed from: m, reason: collision with root package name */
        private float f14303m;

        /* renamed from: n, reason: collision with root package name */
        private long f14304n;

        /* renamed from: o, reason: collision with root package name */
        private Interpolator f14305o;

        /* renamed from: p, reason: collision with root package name */
        private long f14306p;

        /* renamed from: q, reason: collision with root package name */
        private Interpolator f14307q;

        /* renamed from: r, reason: collision with root package name */
        private long f14308r;

        /* renamed from: s, reason: collision with root package name */
        private d f14309s;

        c() {
        }

        private float a(float f5, long j5, long j6, long j7, float f6, Interpolator interpolator, Interpolator interpolator2) {
            float f7 = f5 - j5;
            if (f7 < 0.0f) {
                f7 += j6 + j7;
            }
            float f8 = j6;
            return f7 < f8 ? b(0.0f, f6, interpolator, f7 / f8) : b(f6, 0.0f, interpolator2, (f7 - f8) / j7);
        }

        private float b(float f5, float f6, Interpolator interpolator, float f7) {
            return f5 + ((f6 - f5) * interpolator.getInterpolation(f7));
        }

        public void c(float f5, long j5, Interpolator interpolator, long j6, Interpolator interpolator2, long j7) {
            this.f14291a = f5;
            this.f14292b = j5;
            this.f14293c = interpolator;
            this.f14294d = j6;
            this.f14295e = interpolator2;
            this.f14296f = j7;
        }

        public void d(d dVar) {
            this.f14309s = dVar;
        }

        public void e(float f5, long j5, Interpolator interpolator, long j6, Interpolator interpolator2, long j7) {
            this.f14297g = f5;
            this.f14298h = j5;
            this.f14299i = interpolator;
            this.f14300j = j6;
            this.f14301k = interpolator2;
            this.f14302l = j7;
        }

        public void f(float f5, long j5, Interpolator interpolator, long j6, Interpolator interpolator2, long j7) {
            this.f14303m = f5;
            this.f14304n = j5;
            this.f14305o = interpolator;
            this.f14306p = j6;
            this.f14307q = interpolator2;
            this.f14308r = j7;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f14309s == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f14309s.a(a(fFloatValue, this.f14296f, this.f14292b, this.f14294d, this.f14291a, this.f14293c, this.f14295e), a(fFloatValue, this.f14302l, this.f14298h, this.f14300j, this.f14297g, this.f14299i, this.f14301k), a(fFloatValue, this.f14308r, this.f14304n, this.f14306p, this.f14303m, this.f14305o, this.f14307q));
        }
    }

    private interface d {
        void a(float f5, float f6, float f7);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Animator f() {
        c cVar = new c();
        cVar.d(this.f14286m);
        cVar.c(this.f14277d, 450L, this.f14284k, 520L, this.f14285l, 0L);
        cVar.e(this.f14277d, 450L, this.f14284k, 520L, this.f14285l, 83L);
        cVar.f(this.f14277d, 450L, this.f14284k, 520L, this.f14285l, 166L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 970);
        valueAnimatorOfFloat.setDuration(970L);
        valueAnimatorOfFloat.addUpdateListener(cVar);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        return valueAnimatorOfFloat;
    }

    private void i(int i5) {
        if (i5 == 0 && isShown()) {
            g();
        } else {
            h();
        }
    }

    public void e() {
        this.f14278e = 0.0f;
        this.f14279f = 0.0f;
        this.f14280g = 0.0f;
    }

    public void g() {
        if (this.f14283j) {
            return;
        }
        this.f14283j = true;
        this.f14282i.addListener(this.f14287n);
        this.f14282i.start();
        Log.d("SwimmingAnimationView", "startAnimator");
    }

    public void h() {
        if (this.f14283j) {
            this.f14283j = false;
            this.f14282i.removeAllListeners();
            this.f14282i.cancel();
            e();
            Log.d("SwimmingAnimationView", "stopAnimator");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i5 = this.f14275b;
        canvas.drawCircle(i5, i5 + this.f14278e, i5, this.f14274a);
        int i6 = this.f14275b;
        canvas.drawCircle((i6 * 3) + this.f14276c, i6 + this.f14279f, i6, this.f14274a);
        int i7 = this.f14275b;
        canvas.drawCircle((i7 * 5) + (this.f14276c * 2), i7 + this.f14280g, i7, this.f14274a);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7 = this.f14275b;
        int i8 = (i7 * 6) + (this.f14276c * 2);
        int i9 = (i7 * 2) + this.f14277d;
        setMeasuredDimension(View.resolveSizeAndState(i8 + getPaddingLeft() + getPaddingRight(), i5, 0), View.resolveSizeAndState(i9 + getPaddingTop() + getPaddingBottom(), i6, 0));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i5) {
        super.onVisibilityChanged(view, i5);
        Log.d("SwimmingAnimationView", "onVisibilityChanged=" + i5 + ", isShown=" + isShown() + ", getVisibility=" + getVisibility());
        i(i5);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        Log.d("SwimmingAnimationView", "onWindowVisibilityChanged:" + i5 + ", isShown=" + isShown());
        i(i5);
    }

    public SwimmingAnimationView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14283j = false;
        this.f14284k = new K1.a(0.66f, 0.0f, 0.67f, 1.0f);
        this.f14285l = new K1.a(0.33f, 0.0f, 0.27f, 1.0f);
        this.f14286m = new a();
        this.f14287n = new b();
        this.f14281h = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.E6);
        int color = typedArrayObtainStyledAttributes.getColor(H1.m.F6, context.getResources().getColor(H1.e.f2077E));
        this.f14275b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(H1.m.I6, getResources().getDimensionPixelOffset(H1.f.f2134b0));
        this.f14276c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(H1.m.H6, getResources().getDimensionPixelOffset(H1.f.f2132a0));
        this.f14277d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(H1.m.G6, getResources().getDimensionPixelOffset(H1.f.f2130Z));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f14274a = paint;
        paint.setAntiAlias(true);
        this.f14274a.setStyle(Paint.Style.FILL);
        this.f14274a.setColor(color);
        this.f14282i = f();
    }
}
