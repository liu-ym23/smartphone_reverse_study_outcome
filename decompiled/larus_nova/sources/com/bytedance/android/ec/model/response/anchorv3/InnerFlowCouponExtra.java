package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowCouponExtra;", "Ljava/io/Serializable;", "()V", "couponUrgeInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/CouponUrgeInfo;", "getCouponUrgeInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/CouponUrgeInfo;", "toastDesc", "", "getToastDesc", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InnerFlowCouponExtra implements Serializable {

    @SerializedName("coupon_urge_info")
    private final CouponUrgeInfo couponUrgeInfo;

    @SerializedName("toast_desc")
    private final String toastDesc;

    public InnerFlowCouponExtra() {
        this.toastDesc = "";
    }

    public final CouponUrgeInfo getCouponUrgeInfo() {
        return this.couponUrgeInfo;
    }

    public final String getToastDesc() {
        return this.toastDesc;
    }
}
