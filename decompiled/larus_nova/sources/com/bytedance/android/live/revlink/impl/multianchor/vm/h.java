package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRivalRankRecommendResponse f95052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f95053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f95054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f95055d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f95052a, r101.f95052a) == true) goto L8;
        return false;
    L8:
        if (this.f95053b == r101.f95053b) goto L10;
        return false;
    L10:
        if (this.f95054c == r101.f95054c) goto L12;
        return false;
    L12:
        if (this.f95055d == r101.f95055d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        IRivalRankRecommendResponse r100 = this.f95052a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f95053b) * 31;
        long r103 = this.f95054c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f95055d;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendPreloadData(resp=" + this.f95052a + ", tabType=" + this.f95053b + ", startLoadingTs=" + this.f95054c + ", loadedTs=" + this.f95055d + ")";
    }

    public h(IRivalRankRecommendResponse r100, int r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "resp");
        this.f95052a = r100;
        this.f95053b = r101;
        this.f95054c = r102;
        this.f95055d = r103;
    }
}
