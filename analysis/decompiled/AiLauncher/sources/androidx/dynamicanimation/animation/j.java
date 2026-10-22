package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.e;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public double f13725a;

    /* renamed from: b, reason: collision with root package name */
    public double f13726b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13727c;

    /* renamed from: d, reason: collision with root package name */
    public double f13728d;

    /* renamed from: e, reason: collision with root package name */
    public double f13729e;

    /* renamed from: f, reason: collision with root package name */
    public double f13730f;

    /* renamed from: g, reason: collision with root package name */
    public double f13731g;

    /* renamed from: h, reason: collision with root package name */
    public double f13732h;

    /* renamed from: i, reason: collision with root package name */
    public double f13733i;

    /* renamed from: j, reason: collision with root package name */
    public final e.p f13734j;

    public j() {
        this.f13725a = Math.sqrt(1500.0d);
        this.f13726b = 0.5d;
        this.f13727c = false;
        this.f13733i = Double.MAX_VALUE;
        this.f13734j = new e.p();
    }

    public float a() {
        return (float) this.f13726b;
    }

    public float b() {
        return (float) this.f13733i;
    }

    public float c() {
        double d10 = this.f13725a;
        return (float) (d10 * d10);
    }

    public final void d() {
        if (this.f13727c) {
            return;
        }
        if (this.f13733i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.f13726b;
        if (d10 > 1.0d) {
            double d11 = this.f13725a;
            this.f13730f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.f13726b;
            double d13 = this.f13725a;
            this.f13731g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= 0.0d && d10 < 1.0d) {
            this.f13732h = this.f13725a * Math.sqrt(1.0d - (d10 * d10));
        }
        this.f13727c = true;
    }

    public boolean e(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f13729e && ((double) Math.abs(f10 - b())) < this.f13728d;
    }

    public j f(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f13726b = f10;
        this.f13727c = false;
        return this;
    }

    public j g(float f10) {
        this.f13733i = f10;
        return this;
    }

    public j h(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f13725a = Math.sqrt(f10);
        this.f13727c = false;
        return this;
    }

    public void i(double d10) {
        double dAbs = Math.abs(d10);
        this.f13728d = dAbs;
        this.f13729e = dAbs * 62.5d;
    }

    public e.p j(double d10, double d11, long j10) {
        double dPow;
        double dCos;
        d();
        double d12 = j10 / 1000.0d;
        double d13 = d10 - this.f13733i;
        double d14 = this.f13726b;
        if (d14 > 1.0d) {
            double d15 = this.f13731g;
            double d16 = this.f13730f;
            double d17 = d13 - (((d15 * d13) - d11) / (d15 - d16));
            double d18 = ((d13 * d15) - d11) / (d15 - d16);
            dPow = (Math.pow(2.718281828459045d, d15 * d12) * d17) + (Math.pow(2.718281828459045d, this.f13730f * d12) * d18);
            double d19 = this.f13731g;
            double dPow2 = d17 * d19 * Math.pow(2.718281828459045d, d19 * d12);
            double d20 = this.f13730f;
            dCos = dPow2 + (d18 * d20 * Math.pow(2.718281828459045d, d20 * d12));
        } else if (d14 == 1.0d) {
            double d21 = this.f13725a;
            double d22 = d11 + (d21 * d13);
            double d23 = d13 + (d22 * d12);
            dPow = Math.pow(2.718281828459045d, (-d21) * d12) * d23;
            double dPow3 = d23 * Math.pow(2.718281828459045d, (-this.f13725a) * d12);
            double d24 = this.f13725a;
            dCos = (d22 * Math.pow(2.718281828459045d, (-d24) * d12)) + (dPow3 * (-d24));
        } else {
            double d25 = 1.0d / this.f13732h;
            double d26 = this.f13725a;
            double d27 = d25 * ((d14 * d26 * d13) + d11);
            dPow = Math.pow(2.718281828459045d, (-d14) * d26 * d12) * ((Math.cos(this.f13732h * d12) * d13) + (Math.sin(this.f13732h * d12) * d27));
            double d28 = this.f13725a;
            double d29 = this.f13726b;
            double dPow4 = Math.pow(2.718281828459045d, (-d29) * d28 * d12);
            double d30 = this.f13732h;
            double dSin = (-d30) * d13 * Math.sin(d30 * d12);
            double d31 = this.f13732h;
            dCos = ((-d28) * dPow * d29) + (dPow4 * (dSin + (d27 * d31 * Math.cos(d31 * d12))));
        }
        e.p pVar = this.f13734j;
        pVar.f13718a = (float) (dPow + this.f13733i);
        pVar.f13719b = (float) dCos;
        return pVar;
    }

    public j(float f10) {
        this.f13725a = Math.sqrt(1500.0d);
        this.f13726b = 0.5d;
        this.f13727c = false;
        this.f13733i = Double.MAX_VALUE;
        this.f13734j = new e.p();
        this.f13733i = f10;
    }
}
