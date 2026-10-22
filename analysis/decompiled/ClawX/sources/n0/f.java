package n0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public double f3965a;

    /* renamed from: b, reason: collision with root package name */
    public double f3966b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3967c;
    public double d;

    /* renamed from: e, reason: collision with root package name */
    public double f3968e;

    /* renamed from: f, reason: collision with root package name */
    public double f3969f;

    /* renamed from: g, reason: collision with root package name */
    public double f3970g;

    /* renamed from: h, reason: collision with root package name */
    public double f3971h;

    /* renamed from: i, reason: collision with root package name */
    public double f3972i;

    /* renamed from: j, reason: collision with root package name */
    public final k1.e f3973j;

    public f() {
        this.f3965a = Math.sqrt(1500.0d);
        this.f3966b = 0.5d;
        this.f3967c = false;
        this.f3972i = Double.MAX_VALUE;
        this.f3973j = new k1.e();
    }

    public final k1.e a(double d, double d9, long j4) {
        double dSin;
        double dCos;
        if (!this.f3967c) {
            if (this.f3972i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d10 = this.f3966b;
            if (d10 > 1.0d) {
                double d11 = this.f3965a;
                this.f3969f = (Math.sqrt((d10 * d10) - 1.0d) * d11) + ((-d10) * d11);
                double d12 = this.f3966b;
                double d13 = this.f3965a;
                this.f3970g = ((-d12) * d13) - (Math.sqrt((d12 * d12) - 1.0d) * d13);
            } else if (d10 >= 0.0d && d10 < 1.0d) {
                this.f3971h = Math.sqrt(1.0d - (d10 * d10)) * this.f3965a;
            }
            this.f3967c = true;
        }
        double d14 = j4 / 1000.0d;
        double d15 = d - this.f3972i;
        double d16 = this.f3966b;
        if (d16 > 1.0d) {
            double d17 = this.f3970g;
            double d18 = ((d17 * d15) - d9) / (d17 - this.f3969f);
            double d19 = d15 - d18;
            dSin = (Math.pow(2.718281828459045d, this.f3969f * d14) * d18) + (Math.pow(2.718281828459045d, d17 * d14) * d19);
            double d20 = this.f3970g;
            double dPow = Math.pow(2.718281828459045d, d20 * d14) * d19 * d20;
            double d21 = this.f3969f;
            dCos = (Math.pow(2.718281828459045d, d21 * d14) * d18 * d21) + dPow;
        } else if (d16 == 1.0d) {
            double d22 = this.f3965a;
            double d23 = (d22 * d15) + d9;
            double d24 = (d23 * d14) + d15;
            double dPow2 = Math.pow(2.718281828459045d, (-d22) * d14) * d24;
            double dPow3 = Math.pow(2.718281828459045d, (-this.f3965a) * d14) * d24;
            double d25 = -this.f3965a;
            dCos = (Math.pow(2.718281828459045d, d25 * d14) * d23) + (dPow3 * d25);
            dSin = dPow2;
        } else {
            double d26 = 1.0d / this.f3971h;
            double d27 = this.f3965a;
            double d28 = ((d16 * d27 * d15) + d9) * d26;
            dSin = ((Math.sin(this.f3971h * d14) * d28) + (Math.cos(this.f3971h * d14) * d15)) * Math.pow(2.718281828459045d, (-d16) * d27 * d14);
            double d29 = this.f3965a;
            double d30 = this.f3966b;
            double d31 = (-d29) * dSin * d30;
            double dPow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d14);
            double d32 = this.f3971h;
            double dSin2 = Math.sin(d32 * d14) * (-d32) * d15;
            double d33 = this.f3971h;
            dCos = (((Math.cos(d33 * d14) * d28 * d33) + dSin2) * dPow4) + d31;
        }
        float f3 = (float) (dSin + this.f3972i);
        k1.e eVar = this.f3973j;
        eVar.f3546a = f3;
        eVar.f3547b = (float) dCos;
        return eVar;
    }

    public f(float f3) {
        this.f3965a = Math.sqrt(1500.0d);
        this.f3966b = 0.5d;
        this.f3967c = false;
        this.f3973j = new k1.e();
        this.f3972i = f3;
    }
}
