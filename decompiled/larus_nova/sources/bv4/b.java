package bv4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f20833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f20834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f20835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20836d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f20833a, r101.f20833a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20834b, r101.f20834b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20835c, r101.f20835c) == true) goto L18;
        return false;
    L18:
        if (this.f20836d == r101.f20836d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f20833a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f20834b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.f20835c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f20836d;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CpuInfo(pid=" + this.f20833a + ", cpuRate=" + this.f20834b + ", cpuSpeed=" + this.f20835c + ", cpuNum=" + this.f20836d + ')';
    }

    public b(Integer r100, Double r101, Double r102, int r103) {
        this.f20833a = r100;
        this.f20834b = r101;
        this.f20835c = r102;
        this.f20836d = r103;
    }
}
