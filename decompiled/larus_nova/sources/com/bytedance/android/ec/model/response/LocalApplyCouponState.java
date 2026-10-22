package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/LocalApplyCouponState;", "Ljava/io/Serializable;", "()V", "couponId", "", "getCouponId", "()Ljava/lang/Long;", "setCouponId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "hasShownToast", "", "getHasShownToast", "()Z", "setHasShownToast", "(Z)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LocalApplyCouponState implements Serializable {

    @SerializedName("coupon_id")
    private Long couponId;

    @SerializedName("has_shown_toast")
    private boolean hasShownToast;

    public LocalApplyCouponState() {
    }

    public final Long getCouponId() {
        return this.couponId;
    }

    public final boolean getHasShownToast() {
        return this.hasShownToast;
    }

    public final void setCouponId(Long r100) {
        this.couponId = r100;
    }

    public final void setHasShownToast(boolean r100) {
        this.hasShownToast = r100;
    }
}
