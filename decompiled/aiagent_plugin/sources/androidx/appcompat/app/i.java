package androidx.appcompat.app;

/* JADX INFO: compiled from: TwilightCalculator.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f263d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f266c;

    i() {
    }

    static i a() {
        if (f263d != null) goto L6;
        f263d = new i();
    L6:
        return f263d;
    }

    public void a(long r16, double r18, double r20) {
        float r3 = (r16 - 946728000000L) / 8.64E7f;
        float r4 = (0.01720197f * r3) + 6.24006f;
        double r5 = r4;
        double r7 = (((((Math.sin(r5) * 0.03341960161924362d) + r5) + (Math.sin(2.0f * r4) * 3.4906598739326E-4d)) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d)) + 1.796593063d) + 3.141592653589793d;
        double r9 = (-r20) / 360.0d;
        double r6 = ((((double) (Math.round(((double) (r3 - 9.0E-4f)) - r9) + 9.0E-4f)) + r9) + (Math.sin(r5) * 0.0053d)) + (Math.sin(2.0d * r7) * (-0.0069d));
        double r8 = Math.asin(Math.sin(r7) * Math.sin(0.4092797040939331d));
        double r10 = 0.01745329238474369d * r18;
        double r11 = (Math.sin(-0.10471975803375244d) - (Math.sin(r10) * Math.sin(r8))) / (Math.cos(r10) * Math.cos(r8));
        if (r11 < 1.0d) goto L7;
        this.f266c = 1;
        this.f264a = -1;
        this.f265b = -1;
        return;
    L7:
        if (r11 > (-1.0d)) goto L10;
        this.f266c = 0;
        this.f264a = -1;
        this.f265b = -1;
        return;
    L10:
        double r12 = (float) (Math.acos(r11) / 6.283185307179586d);
        this.f264a = Math.round((r6 + r12) * 8.64E7d) + 946728000000L;
        long r13 = Math.round((r6 - r12) * 8.64E7d) + 946728000000L;
        this.f265b = r13;
        if (r13 < r16) goto L13;
    L15:
        this.f266c = 1;
        return;
    L13:
        if (this.f264a <= r16) goto L15;
        this.f266c = 0;
    }
}
