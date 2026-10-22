package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: compiled from: ExponentialGeometricAverage.java */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f8057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f8059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8060d;

    public c(double r3) {
        this.f8059c = -1.0d;
        this.f8057a = r3;
        if (r3 != 0.0d) goto L5;
        int r4 = Integer.MAX_VALUE;
    L6:
        this.f8058b = r4;
        return;
    L5:
        r4 = (int) Math.ceil(1.0d / r3);
        goto L6
    }

    public void a(double r8) {
        double r0 = 1.0d - this.f8057a;
        int r4 = this.f8060d;
        if (r4 <= this.f8058b) goto L5;
        this.f8059c = Math.exp((r0 * Math.log(this.f8059c)) + (this.f8057a * Math.log(r8)));
    L8:
        this.f8060d++;
        return;
    L5:
        if (r4 <= 0) goto L7;
        double r1 = (r0 * ((double) r4)) / (((double) r4) + 1.0d);
        this.f8059c = Math.exp((r1 * Math.log(this.f8059c)) + ((1.0d - r1) * Math.log(r8)));
        goto L8
    L7:
        this.f8059c = r8;
        goto L8
    }

    public double a() {
        return this.f8059c;
    }
}
