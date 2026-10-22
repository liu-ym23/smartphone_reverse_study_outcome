package com.obric.oui.constraintlayout.a.a.a;

/* JADX INFO: compiled from: SpringStopEngine.java */
/* JADX INFO: loaded from: classes4.dex */
public class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f34635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f34637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f34638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f34639e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;

    @Override // com.obric.oui.constraintlayout.a.a.a.m
    public float a() {
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.m
    public String a(String r1, float r2) {
        return null;
    }

    public k() {
        this.f34635a = 0.5d;
        this.f34636b = false;
        this.k = 0;
    }

    public void a(float r3, float r4, float r5, float r6, float r7, float r8, float r9, int r10) {
        this.f34638d = r4;
        this.f34635a = r8;
        this.f34636b = false;
        this.g = r3;
        this.f34639e = r5;
        this.f34637c = r7;
        this.i = r6;
        this.j = r9;
        this.k = r10;
        this.f = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.m
    public float a(float r1) {
        return this.h;
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.m
    public float b(float r3) {
        a(r3 - this.f);
        this.f = r3;
        if (b() == false) goto L6;
        this.g = (float) this.f34638d;
    L6:
        return this.g;
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.m
    public boolean b() {
        double r0 = ((double) this.g) - this.f34638d;
        double r2 = this.f34637c;
        double r4 = this.h;
        if (Math.sqrt((((r4 * r4) * ((double) this.i)) + ((r2 * r0) * r0)) / r2) > this.j) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(double r25) {
        if (r25 > 0.0d) goto L5;
        return;
    L5:
        double r1 = this.f34637c;
        double r3 = this.f34635a;
        int r5 = (int) ((9.0d / ((Math.sqrt(r1 / ((double) this.i)) * r25) * 4.0d)) + 1.0d);
        double r6 = r25 / ((double) r5);
        int r8 = 0;
    L6:
        if (r8 >= r5) goto L20;
        float r9 = this.g;
        double r12 = this.f34638d;
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
        float r13 = r10 + ((float) r11);
        this.h = r13;
        float r20 = r9 + ((float) (r7 * r6));
        this.g = r20;
        int r21 = this.k;
        if (r21 <= 0) goto L19;
        if (r20 < 0.0f) goto L12;
    L14:
        float r22 = this.g;
        if (r22 <= 1.0f) goto L19;
        if ((r21 & 2) != 2) goto L19;
        this.g = 2.0f - r22;
        this.h = -this.h;
        goto L19
    L12:
        if ((r21 & 1) != 1) goto L14;
        this.g = -r20;
        this.h = -r13;
    L19:
        r8 = r8 + 1;
        r1 = r16;
        r3 = r18;
        goto L6
    }
}
