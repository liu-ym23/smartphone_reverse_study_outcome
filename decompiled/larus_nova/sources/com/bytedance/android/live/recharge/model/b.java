package com.bytedance.android.live.recharge.model;

import com.bytedance.android.livesdk.gift.platform.core.model.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f90005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f90006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f90007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f90008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f90009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v f90010h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f90003a, r101.f90003a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90004b, r101.f90004b) == true) goto L10;
        return false;
    L10:
        if (this.f90005c == r101.f90005c) goto L12;
        return false;
    L12:
        if (this.f90006d == r101.f90006d) goto L14;
        return false;
    L14:
        if (this.f90007e == r101.f90007e) goto L16;
        return false;
    L16:
        if (this.f90008f == r101.f90008f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f90009g, r101.f90009g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f90010h, r101.f90010h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f90003a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f90004b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f90005c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f90006d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f90007e;
        int r112 = (((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f90008f) * 31;
        a r113 = this.f90009g;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        v r116 = this.f90010h;
        if (r116 == null) goto L18;
        r101 = r116.hashCode();
    L18:
        return r115 + r101;
    L13:
        r114 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftRechargeParams(giftRequestId=" + this.f90003a + ", giftSendType=" + this.f90004b + ", giftPayMoney=" + this.f90005c + ", giftPrice=" + this.f90006d + ", giftId=" + this.f90007e + ", giftCount=" + this.f90008f + ", extraGiftParams=" + this.f90009g + ", originGiftParams=" + this.f90010h + ")";
    }

    public /* synthetic */ b(String r110, String r111, long r112, long r113, long r210, int r211, a r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 64) == 0) goto L9;
        a r114 = new a(0);
    L10:
        this(r100, r111, r112, r113, r210, r211, r114, null);
        return;
    L9:
        r114 = r212;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, long r102, long r103, long r104, int r110, a r111, v r112) {
        Intrinsics.checkNotNullParameter(r100, "giftRequestId");
        Intrinsics.checkNotNullParameter(r101, "giftSendType");
        this.f90003a = r100;
        this.f90004b = r101;
        this.f90005c = r102;
        this.f90006d = r103;
        this.f90007e = r104;
        this.f90008f = r110;
        this.f90009g = r111;
        this.f90010h = r112;
    }
}
