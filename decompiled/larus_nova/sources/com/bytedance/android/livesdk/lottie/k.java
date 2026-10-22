package com.bytedance.android.livesdk.lottie;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f153476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f153478c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L12;
        k r101 = (k) r100;
        if (this.f153476a == r101.f153476a) goto L8;
        return false;
    L8:
        if (this.f153477b == r101.f153477b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f153478c, r101.f153478c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f153476a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f153477b;
        ?? r103 = r102;
        if (r102 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r101 + r103) * 31;
        j r105 = this.f153478c;
        if (r105 == null) goto L8;
        int r106 = r105.hashCode();
    L10:
        return r104 + r106;
    L8:
        r106 = 0;
        goto L10
    }

    public final String toString() {
        return "LottieAnimationEvent(assetId=" + this.f153476a + ", autoFinish=" + this.f153477b + ", callback=" + this.f153478c + ")";
    }

    public k(long r100, boolean r101, LottieService.a r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f153476a = r100;
        this.f153477b = r101;
        this.f153478c = r102;
    }
}
