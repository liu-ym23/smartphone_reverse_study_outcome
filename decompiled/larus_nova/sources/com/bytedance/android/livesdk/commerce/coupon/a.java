package com.bytedance.android.livesdk.commerce.coupon;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f119604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f119605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f119606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f119607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f119608e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.commerce.coupon.a$a, reason: collision with other inner class name */
    public static final class C1765a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f119604a == r101.f119604a) goto L8;
        return false;
    L8:
        if (this.f119605b == r101.f119605b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f119606c, r101.f119606c) == true) goto L12;
        return false;
    L12:
        if (this.f119607d == r101.f119607d) goto L14;
        return false;
    L14:
        if (this.f119608e == r101.f119608e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f119604a * 31;
        long r101 = this.f119605b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f119606c;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L6:
        int r105 = (((r102 + r104) * 31) + this.f119607d) * 31;
        long r106 = this.f119608e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "CouponMessage(msgType=" + this.f119604a + ", serverTime=" + this.f119605b + ", activity=" + this.f119606c + ", couponType=" + this.f119607d + ", metaId=" + this.f119608e + ")";
    }

    public final String getActivity() {
        return this.f119606c;
    }

    public a(int r100, long r101, String r102, int r103, long r104) {
        this.f119604a = r100;
        this.f119605b = r101;
        this.f119606c = r102;
        this.f119607d = r103;
        this.f119608e = r104;
    }
}
