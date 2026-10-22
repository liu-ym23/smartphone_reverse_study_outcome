package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewGuideExtra;", "", "()V", "couponAmount", "", "getCouponAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "couponMateId", "", "getCouponMateId", "()J", "setCouponMateId", "(J)V", "couponSchema", "", "getCouponSchema", "()Ljava/lang/String;", "ecomLiveParams", "getEcomLiveParams", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewGuideExtra {

    @SerializedName("coupon_amount")
    private final Integer couponAmount;

    @SerializedName("coupon_meta_id")
    private long couponMateId;

    @SerializedName(ILiveRoomPlayFragmentConstant.COUPON_SCHEMA)
    private final String couponSchema;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS)
    private final String ecomLiveParams;

    public PreviewGuideExtra() {
    }

    public final Integer getCouponAmount() {
        return this.couponAmount;
    }

    public final long getCouponMateId() {
        return this.couponMateId;
    }

    public final String getCouponSchema() {
        return this.couponSchema;
    }

    public final String getEcomLiveParams() {
        return this.ecomLiveParams;
    }

    public final void setCouponMateId(long r100) {
        this.couponMateId = r100;
    }
}
