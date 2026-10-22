package z3;

import r.l0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public double f16372a;

    /* renamed from: b, reason: collision with root package name */
    public double f16373b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16374c;

    /* renamed from: d, reason: collision with root package name */
    public double f16375d;

    /* renamed from: e, reason: collision with root package name */
    public double f16376e;

    /* renamed from: f, reason: collision with root package name */
    public double f16377f;

    /* renamed from: g, reason: collision with root package name */
    public double f16378g;

    /* renamed from: h, reason: collision with root package name */
    public double f16379h;
    public double i;

    /* renamed from: j, reason: collision with root package name */
    public final l0 f16380j;

    public h() {
        this.f16372a = Math.sqrt(1500.0d);
        this.f16373b = 0.5d;
        this.f16374c = false;
        this.i = Double.MAX_VALUE;
        this.f16380j = new l0();
    }

    public final void a(float f5) {
        if (f5 < 0.0f) {
            g5.f.s("Damping ratio must be non-negative");
        } else {
            this.f16373b = f5;
            this.f16374c = false;
        }
    }

    public final void b(float f5) {
        if (f5 <= 0.0f) {
            g5.f.s("Spring stiffness constant must be positive.");
        } else {
            this.f16372a = Math.sqrt(f5);
            this.f16374c = false;
        }
    }

    public final l0 c(double d7, double d10, long j10) {
        double dSin;
        double dCos;
        if (!this.f16374c) {
            if (this.i == Double.MAX_VALUE) {
                od.f.e("Error: Final position of the spring must be set before the animation starts");
                return null;
            }
            double d11 = this.f16373b;
            if (d11 > 1.0d) {
                double d12 = this.f16372a;
                this.f16377f = (Math.sqrt((d11 * d11) - 1.0d) * d12) + ((-d11) * d12);
                double d13 = this.f16373b;
                double d14 = this.f16372a;
                this.f16378g = ((-d13) * d14) - (Math.sqrt((d13 * d13) - 1.0d) * d14);
            } else if (d11 >= 0.0d && d11 < 1.0d) {
                this.f16379h = Math.sqrt(1.0d - (d11 * d11)) * this.f16372a;
            }
            this.f16374c = true;
        }
        double d15 = j10 / 1000.0d;
        double d16 = d7 - this.i;
        double d17 = this.f16373b;
        if (d17 > 1.0d) {
            double d18 = this.f16378g;
            double d19 = ((d18 * d16) - d10) / (d18 - this.f16377f);
            double d20 = d16 - d19;
            dSin = (Math.pow(2.718281828459045d, this.f16377f * d15) * d19) + (Math.pow(2.718281828459045d, d18 * d15) * d20);
            double d21 = this.f16378g;
            double dPow = Math.pow(2.718281828459045d, d21 * d15) * d20 * d21;
            double d22 = this.f16377f;
            dCos = (Math.pow(2.718281828459045d, d22 * d15) * d19 * d22) + dPow;
        } else if (d17 == 1.0d) {
            double d23 = this.f16372a;
            double d24 = (d23 * d16) + d10;
            double d25 = (d24 * d15) + d16;
            double dPow2 = Math.pow(2.718281828459045d, (-d23) * d15) * d25;
            double dPow3 = Math.pow(2.718281828459045d, (-this.f16372a) * d15) * d25;
            double d26 = -this.f16372a;
            dCos = (Math.pow(2.718281828459045d, d26 * d15) * d24) + (dPow3 * d26);
            dSin = dPow2;
        } else {
            double d27 = 1.0d / this.f16379h;
            double d28 = this.f16372a;
            double d29 = ((d17 * d28 * d16) + d10) * d27;
            dSin = ((Math.sin(this.f16379h * d15) * d29) + (Math.cos(this.f16379h * d15) * d16)) * Math.pow(2.718281828459045d, (-d17) * d28 * d15);
            double d30 = this.f16372a;
            double d31 = this.f16373b;
            double d32 = (-d30) * dSin * d31;
            double dPow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d15);
            double d33 = this.f16379h;
            double dSin2 = Math.sin(d33 * d15) * (-d33) * d16;
            double d34 = this.f16379h;
            dCos = (((Math.cos(d34 * d15) * d29 * d34) + dSin2) * dPow4) + d32;
        }
        float f5 = (float) (dSin + this.i);
        l0 l0Var = this.f16380j;
        l0Var.f10313a = f5;
        l0Var.f10314b = (float) dCos;
        return l0Var;
    }

    public h(float f5) {
        this.f16372a = Math.sqrt(1500.0d);
        this.f16373b = 0.5d;
        this.f16374c = false;
        this.f16380j = new l0();
        this.i = f5;
    }
}
