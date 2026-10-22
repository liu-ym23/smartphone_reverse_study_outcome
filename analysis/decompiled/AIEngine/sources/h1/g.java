package h1;

import h1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public double f9244a;

    /* renamed from: b, reason: collision with root package name */
    public double f9245b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9246c;

    /* renamed from: d, reason: collision with root package name */
    public double f9247d;

    /* renamed from: e, reason: collision with root package name */
    public double f9248e;

    /* renamed from: f, reason: collision with root package name */
    public double f9249f;

    /* renamed from: g, reason: collision with root package name */
    public double f9250g;
    public double h;

    /* renamed from: i, reason: collision with root package name */
    public double f9251i;

    /* renamed from: j, reason: collision with root package name */
    public final d.j f9252j;

    public g() {
        this.f9244a = Math.sqrt(1500.0d);
        this.f9245b = 0.5d;
        this.f9246c = false;
        this.f9251i = Double.MAX_VALUE;
        this.f9252j = new d.j();
    }

    public final void a(float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f9245b = f8;
        this.f9246c = false;
    }

    public final void b(float f8) {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f9244a = Math.sqrt(f8);
        this.f9246c = false;
    }

    public final d.j c(double d8, double d10, long j10) {
        double dSin;
        double dCos;
        if (!this.f9246c) {
            if (this.f9251i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d11 = this.f9245b;
            if (d11 > 1.0d) {
                double d12 = this.f9244a;
                this.f9249f = (Math.sqrt((d11 * d11) - 1.0d) * d12) + ((-d11) * d12);
                double d13 = this.f9245b;
                double d14 = this.f9244a;
                this.f9250g = ((-d13) * d14) - (Math.sqrt((d13 * d13) - 1.0d) * d14);
            } else if (d11 >= 0.0d && d11 < 1.0d) {
                this.h = Math.sqrt(1.0d - (d11 * d11)) * this.f9244a;
            }
            this.f9246c = true;
        }
        double d15 = j10 / 1000.0d;
        double d16 = d8 - this.f9251i;
        double d17 = this.f9245b;
        if (d17 > 1.0d) {
            double d18 = this.f9250g;
            double d19 = ((d18 * d16) - d10) / (d18 - this.f9249f);
            double d20 = d16 - d19;
            dSin = (Math.pow(2.718281828459045d, this.f9249f * d15) * d19) + (Math.pow(2.718281828459045d, d18 * d15) * d20);
            double d21 = this.f9250g;
            double dPow = Math.pow(2.718281828459045d, d21 * d15) * d20 * d21;
            double d22 = this.f9249f;
            dCos = (Math.pow(2.718281828459045d, d22 * d15) * d19 * d22) + dPow;
        } else if (d17 == 1.0d) {
            double d23 = this.f9244a;
            double d24 = (d23 * d16) + d10;
            double d25 = (d24 * d15) + d16;
            double dPow2 = Math.pow(2.718281828459045d, (-d23) * d15) * d25;
            double dPow3 = Math.pow(2.718281828459045d, (-this.f9244a) * d15) * d25;
            double d26 = -this.f9244a;
            dCos = (Math.pow(2.718281828459045d, d26 * d15) * d24) + (dPow3 * d26);
            dSin = dPow2;
        } else {
            double d27 = 1.0d / this.h;
            double d28 = this.f9244a;
            double d29 = ((d17 * d28 * d16) + d10) * d27;
            dSin = ((Math.sin(this.h * d15) * d29) + (Math.cos(this.h * d15) * d16)) * Math.pow(2.718281828459045d, (-d17) * d28 * d15);
            double d30 = this.f9244a;
            double d31 = this.f9245b;
            double d32 = (-d30) * dSin * d31;
            double dPow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d15);
            double d33 = this.h;
            double dSin2 = Math.sin(d33 * d15) * (-d33) * d16;
            double d34 = this.h;
            dCos = (((Math.cos(d34 * d15) * d29 * d34) + dSin2) * dPow4) + d32;
        }
        float f8 = (float) (dSin + this.f9251i);
        d.j jVar = this.f9252j;
        jVar.f9238a = f8;
        jVar.f9239b = (float) dCos;
        return jVar;
    }

    public g(float f8) {
        this.f9244a = Math.sqrt(1500.0d);
        this.f9245b = 0.5d;
        this.f9246c = false;
        this.f9252j = new d.j();
        this.f9251i = f8;
    }
}
