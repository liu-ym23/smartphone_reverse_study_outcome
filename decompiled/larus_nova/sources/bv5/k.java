package bv5;

import com.amap.api.col.s.ce;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f20925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f20926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double[] f20927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double[] f20928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double[] f20929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double[] f20930f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f20925a, r101.f20925a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20926b, r101.f20926b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20927c, r101.f20927c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f20928d, r101.f20928d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f20929e, r101.f20929e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f20930f, r101.f20930f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Arrays.hashCode(this.f20925a) * 31) + Arrays.hashCode(this.f20926b)) * 31) + Arrays.hashCode(this.f20927c)) * 31) + Arrays.hashCode(this.f20928d)) * 31) + Arrays.hashCode(this.f20929e)) * 31) + Arrays.hashCode(this.f20930f);
    }

    public final String toString() {
        return "NominalState(p=" + Arrays.toString(this.f20925a) + ", v=" + Arrays.toString(this.f20926b) + ", qWxyz=" + Arrays.toString(this.f20927c) + ", ba=" + Arrays.toString(this.f20928d) + ", bg=" + Arrays.toString(this.f20929e) + ", g=" + Arrays.toString(this.f20930f) + ")";
    }

    public k(double[] r100, double[] r101, double[] r102, double[] r103, double[] r104, double[] r105) {
        Intrinsics.checkNotNullParameter(r100, "p");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "qWxyz");
        Intrinsics.checkNotNullParameter(r103, "ba");
        Intrinsics.checkNotNullParameter(r104, "bg");
        Intrinsics.checkNotNullParameter(r105, ce.f26391f);
        this.f20925a = r100;
        this.f20926b = r101;
        this.f20927c = r102;
        this.f20928d = r103;
        this.f20929e = r104;
        this.f20930f = r105;
    }
}
