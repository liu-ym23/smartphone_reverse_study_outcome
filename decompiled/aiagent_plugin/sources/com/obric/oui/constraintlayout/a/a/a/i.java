package com.obric.oui.constraintlayout.a.a.a;

/* JADX INFO: compiled from: Schlick.java */
/* JADX INFO: loaded from: classes4.dex */
public class i extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double f34628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f34629e;

    i(String r6) {
        this.f34593b = r6;
        int r0 = r6.indexOf(40);
        int r2 = r6.indexOf(44, r0);
        this.f34628d = Double.parseDouble(r6.substring(r0 + 1, r2).trim());
        int r3 = r2 + 1;
        this.f34629e = Double.parseDouble(r6.substring(r3, r6.indexOf(44, r3)).trim());
    }

    private double c(double r9) {
        double r0 = this.f34629e;
        if (r9 >= r0) goto L7;
        return (r0 * r9) / (r9 + (this.f34628d * (r0 - r9)));
    L7:
        return ((1.0d - r0) * (r9 - 1.0d)) / ((1.0d - r9) - (this.f34628d * (r0 - r9)));
    }

    private double d(double r13) {
        double r0 = this.f34629e;
        if (r13 >= r0) goto L6;
        double r2 = this.f34628d;
        return ((r2 * r0) * r0) / ((((r0 - r13) * r2) + r13) * ((r2 * (r0 - r13)) + r13));
    L6:
        double r3 = this.f34628d;
        return (((r0 - 1.0d) * r3) * (r0 - 1.0d)) / (((((-r3) * (r0 - r13)) - r13) + 1.0d) * ((((-r3) * (r0 - r13)) - r13) + 1.0d));
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.c
    public double b(double r1) {
        return d(r1);
    }

    @Override // com.obric.oui.constraintlayout.a.a.a.c
    public double a(double r1) {
        return c(r1);
    }
}
