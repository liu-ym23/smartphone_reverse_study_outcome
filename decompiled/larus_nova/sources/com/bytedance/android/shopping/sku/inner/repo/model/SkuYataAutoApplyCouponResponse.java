package com.bytedance.android.shopping.sku.inner.repo.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.api.LogPbData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/repo/model/SkuYataAutoApplyCouponResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "couponIds", "", "getCouponIds", "()Ljava/lang/String;", "logPbData", "Lcom/bytedance/android/ec/model/api/LogPbData;", "getLogPbData", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "toast", "getToast", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataAutoApplyCouponResponse extends CommerceBaseResponse {

    @SerializedName("coupon_ids")
    private final String couponIds;

    @SerializedName("log_pb")
    private final LogPbData logPbData;

    @SerializedName("toast")
    private final String toast;

    public SkuYataAutoApplyCouponResponse() {
    }

    public final String getCouponIds() {
        return this.couponIds;
    }

    public final LogPbData getLogPbData() {
        return this.logPbData;
    }

    public final String getToast() {
        return this.toast;
    }
}
