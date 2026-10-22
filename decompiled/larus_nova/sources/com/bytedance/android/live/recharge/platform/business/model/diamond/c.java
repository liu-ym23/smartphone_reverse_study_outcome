package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/c;", "", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "I", "getEntrance", "()I", "diamond_id", "getDiamond_id", "", "custom_price", "J", "getCustom_price", "()J", "", "", "pre_calc_info", "Ljava/util/Map;", "getPre_calc_info", "()Ljava/util/Map;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/b;", "coupon_operate", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/b;", "getCoupon_operate", "()Lcom/bytedance/android/live/recharge/platform/business/model/diamond/b;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("coupon_operate")
    private final b coupon_operate;

    @SerializedName("custom_price")
    private final long custom_price;

    @SerializedName("diamond_id")
    private final int diamond_id;

    @SerializedName(SoloKtvContext.SOLO_PAGE_ENTRANCE)
    private final int entrance;

    @SerializedName("pre_calc_info_map")
    private final Map<Long, String> pre_calc_info;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.entrance == r101.entrance) goto L8;
        return false;
    L8:
        if (this.diamond_id == r101.diamond_id) goto L10;
        return false;
    L10:
        if (this.custom_price == r101.custom_price) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pre_calc_info, r101.pre_calc_info) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.coupon_operate, r101.coupon_operate) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.entrance * 31) + this.diamond_id) * 31;
        long r101 = this.custom_price;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Map<Long, String> r103 = this.pre_calc_info;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        b r107 = this.coupon_operate;
        if (r107 == null) goto L10;
        r104 = r107.hashCode();
    L10:
        return r106 + r104;
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "CouponPreCalcPriceBody(entrance=" + this.entrance + ", diamond_id=" + this.diamond_id + ", custom_price=" + this.custom_price + ", pre_calc_info=" + this.pre_calc_info + ", coupon_operate=" + this.coupon_operate + ")";
    }

    public c(int r100, int r101, long r102, Map<Long, String> r103, b r104) {
        Intrinsics.checkNotNullParameter(r103, "pre_calc_info");
        Intrinsics.checkNotNullParameter(r104, "coupon_operate");
        this.entrance = r100;
        this.diamond_id = r101;
        this.custom_price = r102;
        this.pre_calc_info = r103;
        this.coupon_operate = r104;
    }
}
