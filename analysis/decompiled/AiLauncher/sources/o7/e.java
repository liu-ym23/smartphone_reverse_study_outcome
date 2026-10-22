package o7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.FloatProperty;
import android.view.Display;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class e {

    /* renamed from: s, reason: collision with root package name */
    public static final Interpolator f37471s = new LinearInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public final Context f37472a;

    /* renamed from: b, reason: collision with root package name */
    public float f37473b;

    /* renamed from: c, reason: collision with root package name */
    public float f37474c;

    /* renamed from: i, reason: collision with root package name */
    public double f37480i;

    /* renamed from: j, reason: collision with root package name */
    public double f37481j;

    /* renamed from: k, reason: collision with root package name */
    public double f37482k;

    /* renamed from: l, reason: collision with root package name */
    public double f37483l;

    /* renamed from: m, reason: collision with root package name */
    public double f37484m;

    /* renamed from: n, reason: collision with root package name */
    public double f37485n;

    /* renamed from: o, reason: collision with root package name */
    public double f37486o;

    /* renamed from: p, reason: collision with root package name */
    public double f37487p;

    /* renamed from: r, reason: collision with root package name */
    public final DisplayManager f37489r;

    /* renamed from: d, reason: collision with root package name */
    public float f37475d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f37476e = 1500.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f37477f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    public float f37478g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f37479h = false;

    /* renamed from: q, reason: collision with root package name */
    public float f37488q = 0.0f;

    public class a extends AbstractC5010a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f37490b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f37491c;

        public a(FloatProperty floatProperty, Object obj) {
            this.f37490b = floatProperty;
            this.f37491c = obj;
        }

        @Override // o7.AbstractC5010a
        public void a(Animator animator) {
            this.f37490b.set((FloatProperty) this.f37491c, Float.valueOf(e.this.f37474c));
        }
    }

    public e(Context context) {
        this.f37472a = context;
        this.f37489r = (DisplayManager) context.getSystemService(DisplayManager.class);
    }

    public <T> ValueAnimator c(final T t10, final FloatProperty<T> floatProperty) {
        d();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.f37488q);
        valueAnimatorOfFloat.setDuration(i()).setInterpolator(f37471s);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o7.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f37468a.n(floatProperty, t10, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a(floatProperty, t10));
        return valueAnimatorOfFloat;
    }

    public e d() {
        int iK = k();
        double dSqrt = Math.sqrt(this.f37476e);
        float f10 = this.f37477f;
        double dSqrt2 = Math.sqrt(1.0f - (f10 * f10)) * dSqrt;
        double d10 = this.f37477f * 2.0f * dSqrt;
        this.f37480i = d10;
        this.f37481j = dSqrt2;
        double d11 = this.f37473b - this.f37474c;
        this.f37482k = d11;
        double d12 = ((d10 * d11) / (dSqrt2 * 2.0d)) + (this.f37475d / dSqrt2);
        this.f37483l = d12;
        this.f37484m = ((d11 * d10) / 2.0d) - (d12 * dSqrt2);
        this.f37485n = (dSqrt2 * d11) + ((d10 * d12) / 2.0d);
        double d13 = this.f37478g * 0.65f;
        this.f37486o = d13;
        double d14 = iK;
        this.f37487p = (d13 * 1000.0d) / d14;
        double dAtan2 = Math.atan2(-d11, d12);
        double d15 = this.f37481j;
        double d16 = dAtan2 / d15;
        double d17 = 3.141592653589793d / d15;
        while (true) {
            if (d16 >= 0.0d && Math.abs(h(d16) * f(d16)) < this.f37487p) {
                break;
            }
            d16 += d17;
        }
        double dMax = this.f37479h ? 0.0d : Math.max(0.0d, d16 - (d17 / 2.0d));
        double d18 = d14 / 2000.0d;
        while (d16 - dMax >= d18) {
            double d19 = (dMax + d16) / 2.0d;
            if (m(d19)) {
                d16 = d19;
            } else {
                dMax = d19;
            }
        }
        this.f37488q = (float) d16;
        return this;
    }

    public final double e(double d10, double d11, double d12) {
        double d13 = d10 * this.f37481j;
        return (d11 * Math.cos(d13)) + (d12 * Math.sin(d13));
    }

    public final double f(double d10) {
        return e(d10, this.f37484m, this.f37485n);
    }

    public final double g(double d10) {
        return e(d10, this.f37482k, this.f37483l);
    }

    public final double h(double d10) {
        return Math.pow(2.718281828459045d, ((-this.f37480i) * d10) / 2.0d);
    }

    public long i() {
        return (long) (this.f37488q * 1000.0d);
    }

    public float j(float f10) {
        return l(this.f37488q * f10);
    }

    public final int k() {
        Display display = this.f37489r.getDisplay(0);
        if (display != null) {
            float refreshRate = display.getRefreshRate();
            if (refreshRate > 0.0f) {
                return (int) (1000.0f / refreshRate);
            }
        }
        return 16;
    }

    public final float l(float f10) {
        double d10 = f10;
        return ((float) (h(d10) * g(d10))) + this.f37474c;
    }

    public final boolean m(double d10) {
        double dH = h(d10);
        return Math.abs(g(d10) * dH) < this.f37486o && Math.abs(dH * f(d10)) < this.f37487p;
    }

    public final /* synthetic */ void n(FloatProperty floatProperty, Object obj, ValueAnimator valueAnimator) {
        floatProperty.set((FloatProperty) obj, Float.valueOf(j(valueAnimator.getAnimatedFraction())));
    }

    public e o(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("Damping ratio must be between 0 and 1");
        }
        this.f37477f = f10;
        return this;
    }

    public e p(float f10) {
        this.f37474c = f10;
        return this;
    }

    public e q(boolean z10) {
        this.f37479h = z10;
        return this;
    }

    public e r(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f37478g = f10;
        return this;
    }

    public e s(float f10) {
        this.f37473b = f10;
        return this;
    }

    public e t(float f10) {
        this.f37475d = f10;
        return this;
    }

    public e u(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f37476e = f10;
        return this;
    }
}
