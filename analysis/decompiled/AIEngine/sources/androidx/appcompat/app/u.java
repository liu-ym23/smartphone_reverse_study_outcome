package androidx.appcompat.app;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: d, reason: collision with root package name */
    public static u f362d;

    /* renamed from: a, reason: collision with root package name */
    public long f363a;

    /* renamed from: b, reason: collision with root package name */
    public long f364b;

    /* renamed from: c, reason: collision with root package name */
    public int f365c;

    public final void a(double d8, double d10, long j10) {
        double d11 = (0.01720197f * ((j10 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(d11) * 0.03341960161924362d) + d11 + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d11) * 0.0053d) + Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d10) / 360.0d);
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d12 = 0.01745329238474369d * d8;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d12))) / (Math.cos(dAsin) * Math.cos(d12));
        if (dSin3 >= 1.0d) {
            this.f365c = 1;
            this.f363a = -1L;
            this.f364b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f365c = 0;
                this.f363a = -1L;
                this.f364b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f363a = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f364b = jRound;
            if (jRound >= j10 || this.f363a <= j10) {
                this.f365c = 1;
            } else {
                this.f365c = 0;
            }
        }
    }
}
