package com.bytedance.android.anniex.scene.core;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f41153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f41154b;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Double.compare(this.f41153a, r101.f41153a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f41154b, r101.f41154b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f41153a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f41154b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ScoreModel(alpha=" + this.f41153a + ", beta=" + this.f41154b + ')';
    }

    public /* synthetic */ j(int r100) {
        this(1.1d, 0.9d);
    }

    public j(double r100, double r101) {
        this.f41153a = r100;
        this.f41154b = r101;
    }
}
