package androidx.constraintlayout.a.a.a;

/* JADX INFO: compiled from: SpringStopEngine.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f662e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;

    @Override // androidx.constraintlayout.a.a.a.m
    public float a() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public String a(String r1, float r2) {
        return null;
    }

    public k() {
        this.f658a = 0.5d;
        this.f659b = false;
        this.k = 0;
    }

    public void a(float r3, float r4, float r5, float r6, float r7, float r8, float r9, int r10) {
        this.f661d = r4;
        this.f658a = r8;
        this.f659b = false;
        this.g = r3;
        this.f662e = r5;
        this.f660c = r7;
        this.i = r6;
        this.j = r9;
        this.k = r10;
        this.f = 0.0f;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public float a(float r1) {
        return this.h;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public float b(float r3) {
        a(r3 - this.f);
        this.f = r3;
        return this.g;
    }

    @Override // androidx.constraintlayout.a.a.a.m
    public boolean b() {
        double r0 = ((double) this.g) - this.f661d;
        double r2 = this.f660c;
        double r4 = this.h;
        if (Math.sqrt((((r4 * r4) * ((double) this.i)) + ((r2 * r0) * r0)) / r2) > this.j) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(double r25) {
        double r1 = this.f660c;
        double r3 = this.f658a;
        int r5 = (int) ((9.0d / ((Math.sqrt(r1 / ((double) this.i)) * r25) * 4.0d)) + 1.0d);
        double r6 = r25 / ((double) r5);
        int r8 = 0;
    L3:
        if (r8 >= r5) goto L17;
        float r9 = this.g;
        double r12 = this.f661d;
        double r14 = -r1;
        double r15 = r14 * (((double) r9) - r12);
        float r10 = this.h;
        double r16 = r1;
        double r17 = r15 - (((double) r10) * r3);
        float r2 = this.i;
        double r18 = r3;
        double r19 = r17 / ((double) r2);
        double r4 = ((double) r10) + ((r19 * r6) / 2.0d);
        double r11 = ((((-((((double) r9) + ((r6 * r4) / 2.0d)) - r12)) * r16) - (r4 * r18)) / ((double) r2)) * r6;
        double r7 = ((double) r10) + (r11 / 2.0d);
        float r13 = (float) (((double) r10) + r11);
        this.h = r13;
        float r20 = (float) (((double) r9) + (r7 * r6));
        this.g = r20;
        int r21 = this.k;
        if (r21 <= 0) goto L16;
        if (r20 < 0.0f) goto L9;
    L11:
        float r22 = this.g;
        if (r22 <= 1.0f) goto L16;
        if ((r21 & 2) != 2) goto L16;
        this.g = 2.0f - r22;
        this.h = -this.h;
        goto L16
    L9:
        if ((r21 & 1) != 1) goto L11;
        this.g = -r20;
        this.h = -r13;
    L16:
        r8 = r8 + 1;
        r1 = r16;
        r3 = r18;
        goto L3
    }
}
