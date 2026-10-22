package androidx.appcompat.app;

/* loaded from: classes.dex */
class p {

    /* renamed from: d, reason: collision with root package name */
    private static p f7656d;

    /* renamed from: a, reason: collision with root package name */
    public long f7657a;

    /* renamed from: b, reason: collision with root package name */
    public long f7658b;

    /* renamed from: c, reason: collision with root package name */
    public int f7659c;

    p() {
    }

    static p b() {
        if (f7656d == null) {
            f7656d = new p();
        }
        return f7656d;
    }

    public void a(long j5, double d6, double d7) {
        double d8 = (0.01720197f * ((j5 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d8) * 0.03341960161924362d) + d8 + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d7) / 360.0d) + (Math.sin(d8) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d9 = 0.01745329238474369d * d6;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d9) * Math.sin(dAsin))) / (Math.cos(d9) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f7659c = 1;
            this.f7657a = -1L;
            this.f7658b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f7659c = 0;
                this.f7657a = -1L;
                this.f7658b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f7657a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f7658b = jRound;
            if (jRound >= j5 || this.f7657a <= j5) {
                this.f7659c = 1;
            } else {
                this.f7659c = 0;
            }
        }
    }
}
