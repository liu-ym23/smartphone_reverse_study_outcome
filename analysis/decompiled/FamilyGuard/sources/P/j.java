package P;

import P.e;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    double f4523a;

    /* renamed from: b, reason: collision with root package name */
    double f4524b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4525c;

    /* renamed from: d, reason: collision with root package name */
    private double f4526d;

    /* renamed from: e, reason: collision with root package name */
    private double f4527e;

    /* renamed from: f, reason: collision with root package name */
    private double f4528f;

    /* renamed from: g, reason: collision with root package name */
    private double f4529g;

    /* renamed from: h, reason: collision with root package name */
    private double f4530h;

    /* renamed from: i, reason: collision with root package name */
    private double f4531i;

    /* renamed from: j, reason: collision with root package name */
    private final e.p f4532j;

    public j() {
        this.f4523a = Math.sqrt(1500.0d);
        this.f4524b = 0.5d;
        this.f4525c = false;
        this.f4531i = Double.MAX_VALUE;
        this.f4532j = new e.p();
    }

    private void d() {
        if (this.f4525c) {
            return;
        }
        if (this.f4531i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d6 = this.f4524b;
        if (d6 > 1.0d) {
            double d7 = this.f4523a;
            this.f4528f = ((-d6) * d7) + (d7 * Math.sqrt((d6 * d6) - 1.0d));
            double d8 = this.f4524b;
            double d9 = this.f4523a;
            this.f4529g = ((-d8) * d9) - (d9 * Math.sqrt((d8 * d8) - 1.0d));
        } else if (d6 >= 0.0d && d6 < 1.0d) {
            this.f4530h = this.f4523a * Math.sqrt(1.0d - (d6 * d6));
        }
        this.f4525c = true;
    }

    public float a() {
        return (float) this.f4524b;
    }

    public float b() {
        return (float) this.f4531i;
    }

    public float c() {
        double d6 = this.f4523a;
        return (float) (d6 * d6);
    }

    public boolean e(float f5, float f6) {
        return ((double) Math.abs(f6)) < this.f4527e && ((double) Math.abs(f5 - b())) < this.f4526d;
    }

    public j f(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f4524b = f5;
        this.f4525c = false;
        return this;
    }

    public j g(float f5) {
        this.f4531i = f5;
        return this;
    }

    public j h(float f5) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f4523a = Math.sqrt(f5);
        this.f4525c = false;
        return this;
    }

    void i(double d6) {
        double dAbs = Math.abs(d6);
        this.f4526d = dAbs;
        this.f4527e = dAbs * 62.5d;
    }

    e.p j(double d6, double d7, long j5) {
        double dPow;
        double dCos;
        d();
        double d8 = j5 / 1000.0d;
        double d9 = d6 - this.f4531i;
        double d10 = this.f4524b;
        if (d10 > 1.0d) {
            double d11 = this.f4529g;
            double d12 = this.f4528f;
            double d13 = d9 - (((d11 * d9) - d7) / (d11 - d12));
            double d14 = ((d9 * d11) - d7) / (d11 - d12);
            dPow = (Math.pow(2.718281828459045d, d11 * d8) * d13) + (Math.pow(2.718281828459045d, this.f4528f * d8) * d14);
            double d15 = this.f4529g;
            double dPow2 = d13 * d15 * Math.pow(2.718281828459045d, d15 * d8);
            double d16 = this.f4528f;
            dCos = dPow2 + (d14 * d16 * Math.pow(2.718281828459045d, d16 * d8));
        } else if (d10 == 1.0d) {
            double d17 = this.f4523a;
            double d18 = d7 + (d17 * d9);
            double d19 = d9 + (d18 * d8);
            dPow = Math.pow(2.718281828459045d, (-d17) * d8) * d19;
            double dPow3 = d19 * Math.pow(2.718281828459045d, (-this.f4523a) * d8);
            double d20 = this.f4523a;
            dCos = (d18 * Math.pow(2.718281828459045d, (-d20) * d8)) + (dPow3 * (-d20));
        } else {
            double d21 = 1.0d / this.f4530h;
            double d22 = this.f4523a;
            double d23 = d21 * ((d10 * d22 * d9) + d7);
            dPow = Math.pow(2.718281828459045d, (-d10) * d22 * d8) * ((Math.cos(this.f4530h * d8) * d9) + (Math.sin(this.f4530h * d8) * d23));
            double d24 = this.f4523a;
            double d25 = this.f4524b;
            double dPow4 = Math.pow(2.718281828459045d, (-d25) * d24 * d8);
            double d26 = this.f4530h;
            double dSin = (-d26) * d9 * Math.sin(d26 * d8);
            double d27 = this.f4530h;
            dCos = ((-d24) * dPow * d25) + (dPow4 * (dSin + (d23 * d27 * Math.cos(d27 * d8))));
        }
        e.p pVar = this.f4532j;
        pVar.f4516a = (float) (dPow + this.f4531i);
        pVar.f4517b = (float) dCos;
        return pVar;
    }

    public j(float f5) {
        this.f4523a = Math.sqrt(1500.0d);
        this.f4524b = 0.5d;
        this.f4525c = false;
        this.f4531i = Double.MAX_VALUE;
        this.f4532j = new e.p();
        this.f4531i = f5;
    }
}
