package com.bytedance.android.live.profit.lottery;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/b;", "", "", "couponType", "I", "getCouponType", "()I", "", "couponId", "J", "getCouponId", "()J", "", "isLifeLottery", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("coupon_id")
    private final long couponId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private final int couponType;

    @SerializedName("is_life_lottery")
    private final Boolean isLifeLottery;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.couponType == r101.couponType) goto L8;
        return false;
    L8:
        if (this.couponId == r101.couponId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.isLifeLottery, r101.isLifeLottery) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.couponType * 31;
        long r101 = this.couponId;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Boolean r103 = this.isLifeLottery;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L7:
        return r102 + r104;
    L5:
        r104 = 0;
        goto L7
    }

    public final String toString() {
        return "EcommerceCoupon(couponType=" + this.couponType + ", couponId=" + this.couponId + ", isLifeLottery=" + this.isLifeLottery + ")";
    }

    public b() {
        this.couponType = 0;
        this.couponId = 0;
        this.isLifeLottery = null;
    }

    public final Boolean a() {
        return this.isLifeLottery;
    }
}
