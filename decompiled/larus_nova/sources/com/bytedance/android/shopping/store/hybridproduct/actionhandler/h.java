package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f184955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f184956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f184957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f184958d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f184955a, r101.f184955a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f184956b, r101.f184956b) == true) goto L10;
        return false;
    L10:
        if (this.f184957c == r101.f184957c) goto L12;
        return false;
    L12:
        if (this.f184958d == r101.f184958d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f184955a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f184956b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f184957c;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        boolean r108 = this.f184958d;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SubScribeVO(productId=" + this.f184955a + ", name=" + this.f184956b + ", startTime=" + this.f184957c + ", isAppointed=" + this.f184958d + ")";
    }

    public h(String r100, String r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f184955a = r100;
        this.f184956b = r101;
        this.f184957c = r102;
        this.f184958d = r103;
    }
}
