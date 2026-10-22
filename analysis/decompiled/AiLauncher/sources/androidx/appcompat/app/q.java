package androidx.appcompat.app;

/* loaded from: classes.dex */
public class q {

    /* renamed from: d, reason: collision with root package name */
    public static q f8468d;

    /* renamed from: a, reason: collision with root package name */
    public long f8469a;

    /* renamed from: b, reason: collision with root package name */
    public long f8470b;

    /* renamed from: c, reason: collision with root package name */
    public int f8471c;

    public static q b() {
        if (f8468d == null) {
            f8468d = new q();
        }
        return f8468d;
    }

    public void a(long j10, double d10, double d11) {
        double d12 = (0.01720197f * ((j10 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d12) * 0.03341960161924362d) + d12 + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d11) / 360.0d) + (Math.sin(d12) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d13 = 0.01745329238474369d * d10;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d13) * Math.sin(dAsin))) / (Math.cos(d13) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f8471c = 1;
            this.f8469a = -1L;
            this.f8470b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f8471c = 0;
                this.f8469a = -1L;
                this.f8470b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f8469a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f8470b = jRound;
            if (jRound >= j10 || this.f8469a <= j10) {
                this.f8471c = 1;
            } else {
                this.f8471c = 0;
            }
        }
    }
}
