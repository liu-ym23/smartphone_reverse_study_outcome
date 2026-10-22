package W;

import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public double f1977a;

    /* renamed from: b, reason: collision with root package name */
    public double f1978b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1979c;

    /* renamed from: d, reason: collision with root package name */
    public double f1980d;

    /* renamed from: e, reason: collision with root package name */
    public double f1981e;

    /* renamed from: f, reason: collision with root package name */
    public double f1982f;

    /* renamed from: g, reason: collision with root package name */
    public double f1983g;

    /* renamed from: h, reason: collision with root package name */
    public double f1984h;

    /* renamed from: i, reason: collision with root package name */
    public double f1985i;

    /* renamed from: j, reason: collision with root package name */
    public final h f1986j;

    public n() {
        this.f1977a = Math.sqrt(1500.0d);
        this.f1978b = 0.5d;
        this.f1979c = false;
        this.f1985i = Double.MAX_VALUE;
        this.f1986j = new h();
    }

    public final void a(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f1978b = f4;
        this.f1979c = false;
    }

    public final void b(float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f1977a = Math.sqrt(f4);
        this.f1979c = false;
    }

    public final h c(long j4, double d4, double d5) {
        double dCos;
        double dPow;
        if (!this.f1979c) {
            if (this.f1985i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d6 = this.f1978b;
            if (d6 > 1.0d) {
                double d7 = this.f1977a;
                this.f1982f = (Math.sqrt((d6 * d6) - 1.0d) * d7) + ((-d6) * d7);
                double d8 = this.f1978b;
                double d9 = this.f1977a;
                this.f1983g = ((-d8) * d9) - (Math.sqrt((d8 * d8) - 1.0d) * d9);
            } else if (d6 >= 0.0d && d6 < 1.0d) {
                this.f1984h = Math.sqrt(1.0d - (d6 * d6)) * this.f1977a;
            }
            this.f1979c = true;
        }
        double d10 = j4 / 1000.0d;
        double d11 = d4 - this.f1985i;
        double d12 = this.f1978b;
        if (d12 > 1.0d) {
            double d13 = this.f1983g;
            double d14 = this.f1982f;
            double d15 = d11 - (((d13 * d11) - d5) / (d13 - d14));
            double d16 = ((d11 * d13) - d5) / (d13 - d14);
            dPow = (Math.pow(2.718281828459045d, this.f1982f * d10) * d16) + (Math.pow(2.718281828459045d, d13 * d10) * d15);
            double d17 = this.f1983g;
            double dPow2 = Math.pow(2.718281828459045d, d17 * d10) * d15 * d17;
            double d18 = this.f1982f;
            dCos = (Math.pow(2.718281828459045d, d18 * d10) * d16 * d18) + dPow2;
        } else if (d12 == 1.0d) {
            double d19 = this.f1977a;
            double d20 = (d19 * d11) + d5;
            double d21 = (d20 * d10) + d11;
            double dPow3 = Math.pow(2.718281828459045d, (-d19) * d10) * d21;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f1977a) * d10) * d21;
            double d22 = this.f1977a;
            dCos = (Math.pow(2.718281828459045d, (-d22) * d10) * d20) + (dPow4 * (-d22));
            dPow = dPow3;
        } else {
            double d23 = 1.0d / this.f1984h;
            double d24 = this.f1977a;
            double d25 = ((d12 * d24 * d11) + d5) * d23;
            double dSin = ((Math.sin(this.f1984h * d10) * d25) + (Math.cos(this.f1984h * d10) * d11)) * Math.pow(2.718281828459045d, (-d12) * d24 * d10);
            double d26 = this.f1977a;
            double d27 = this.f1978b;
            double d28 = (-d26) * dSin * d27;
            double dPow5 = Math.pow(2.718281828459045d, (-d27) * d26 * d10);
            double d29 = this.f1984h;
            double dSin2 = Math.sin(d29 * d10) * (-d29) * d11;
            double d30 = this.f1984h;
            dCos = (((Math.cos(d30 * d10) * d25 * d30) + dSin2) * dPow5) + d28;
            dPow = dSin;
        }
        float f4 = (float) (dPow + this.f1985i);
        h hVar = this.f1986j;
        hVar.f1951a = f4;
        hVar.f1952b = (float) dCos;
        return hVar;
    }

    public n(float f4) {
        this.f1977a = Math.sqrt(1500.0d);
        this.f1978b = 0.5d;
        this.f1979c = false;
        this.f1986j = new h();
        this.f1985i = f4;
    }
}
