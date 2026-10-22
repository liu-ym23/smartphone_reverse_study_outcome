package com.bytedance.android.anniex.scene.next;

import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f41284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Pair<Integer, Double>> f41285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f41286d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f41283a, r101.f41283a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f41284b, r101.f41284b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f41285c, r101.f41285c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f41286d, r101.f41286d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f41283a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f41284b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Map<String, Pair<Integer, Double>> r103 = this.f41285c;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        Map<String, Object> r107 = this.f41286d;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "SceneSwitchInput(currentSceneId=" + this.f41283a + ", avgDuration=" + this.f41284b + ", transitions=" + this.f41285c + ", extraParams=" + this.f41286d + ')';
    }

    public g(String r100, double r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "currentSceneId");
        this.f41283a = r100;
        this.f41284b = r101;
        this.f41285c = r102;
        this.f41286d = null;
    }
}
