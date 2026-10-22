package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static l f386d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f389c;

    public l() {
    }

    public static l b() {
        if (f386d != null) goto L6;
        f386d = new l();
    L6:
        return f386d;
    }

    public void a(long r16, double r18, double r20) {
        float r10 = (r16 - 946728000000L) / 8.64E7f;
        float r11 = (0.01720197f * r10) + 6.24006f;
        double r12 = r11;
        double r13 = (((((Math.sin(r12) * 0.03341960161924362d) + r12) + (Math.sin(2.0f * r11) * 3.4906598739326E-4d)) + (Math.sin(r11 * 3.0f) * 5.236000106378924E-6d)) + 1.796593063d) + 3.141592653589793d;
        double r14 = (-r20) / 360.0d;
        double r15 = ((((double) (Math.round(((double) (r10 - 9.0E-4f)) - r14) + 9.0E-4f)) + r14) + (Math.sin(r12) * 0.0053d)) + (Math.sin(2.0d * r13) * (-0.0069d));
        double r17 = Math.asin(Math.sin(r13) * Math.sin(0.4092797040939331d));
        double r19 = 0.01745329238474369d * r18;
        double r21 = (Math.sin(-0.10471975803375244d) - (Math.sin(r19) * Math.sin(r17))) / (Math.cos(r19) * Math.cos(r17));
        if (r21 < 1.0d) goto L7;
        this.f389c = 1;
        this.f387a = -1;
        this.f388b = -1;
        return;
    L7:
        if (r21 > (-1.0d)) goto L10;
        this.f389c = 0;
        this.f387a = -1;
        this.f388b = -1;
        return;
    L10:
        double r22 = (float) (Math.acos(r21) / 6.283185307179586d);
        this.f387a = Math.round((r15 + r22) * 8.64E7d) + 946728000000L;
        long r23 = Math.round((r15 - r22) * 8.64E7d) + 946728000000L;
        this.f388b = r23;
        if (r23 < r16) goto L13;
    L15:
        this.f389c = 1;
        return;
    L13:
        if (this.f387a <= r16) goto L15;
        this.f389c = 0;
    }
}
