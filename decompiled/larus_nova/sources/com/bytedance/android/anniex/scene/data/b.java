package com.bytedance.android.anniex.scene.data;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f41183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Pair<Integer, Double>> f41184d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f41181a == r101.f41181a) goto L12;
        return false;
    L12:
        if (this.f41182b == r101.f41182b) goto L15;
        return false;
    L15:
        if (Double.compare(this.f41183c, r101.f41183c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f41184d, r101.f41184d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f41181a * 31) + this.f41182b) * 31;
        long r101 = Double.doubleToLongBits(this.f41183c);
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f41184d.hashCode();
    }

    public final String toString() {
        return "SceneQueryInfo(currentCount=" + this.f41181a + ", repeatCount=" + this.f41182b + ", avgDuration=" + this.f41183c + ", transitions=" + this.f41184d + ')';
    }

    public b(int r100, int r101, double r102, Map<String, Pair<Integer, Double>> r103) {
        Intrinsics.checkNotNullParameter(r103, "transitions");
        this.f41181a = r100;
        this.f41182b = r101;
        this.f41183c = r102;
        this.f41184d = r103;
    }
}
