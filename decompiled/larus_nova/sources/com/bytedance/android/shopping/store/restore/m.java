package com.bytedance.android.shopping.store.restore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f185817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f185818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f185819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f185820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, com.bytedance.android.ec.hybrid.list.entity.k> f185821e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L16;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f185817a, r101.f185817a) == true) goto L8;
        return false;
    L8:
        if (this.f185818b == r101.f185818b) goto L10;
        return false;
    L10:
        if (this.f185819c == r101.f185819c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f185820d, r101.f185820d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f185821e, r101.f185821e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        n r100 = this.f185817a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f185818b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f185819c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        s r107 = this.f185820d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        Map<Integer, com.bytedance.android.ec.hybrid.list.entity.k> r110 = this.f185821e;
        if (r110 == null) goto L14;
        r101 = r110.hashCode();
    L14:
        return r109 + r101;
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopPageFullData(key=" + this.f185817a + ", createdAtMs=" + this.f185818b + ", ttlMs=" + this.f185819c + ", shopPageStatus=" + this.f185820d + ", productTabData=" + this.f185821e + ")";
    }

    public m(n r100, long r101, s r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "shopPageStatus");
        Intrinsics.checkNotNullParameter(r103, "productTabData");
        this.f185817a = r100;
        this.f185818b = r101;
        this.f185819c = com.heytap.mcssdk.constant.a.f276320g;
        this.f185820d = r102;
        this.f185821e = r103;
    }
}
