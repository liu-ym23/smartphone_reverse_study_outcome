package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDepositPrice;", "Ljava/io/Serializable;", "()V", "depositPrice", "", "getDepositPrice", "()J", "discountMaxPrice", "getDiscountMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "discountMinPrice", "getDiscountMinPrice", "header", "", "getHeader", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionDepositPrice implements Serializable {

    @SerializedName("deposit_price")
    private final long depositPrice;

    @SerializedName("discount_max_amount")
    private final Long discountMaxPrice;

    @SerializedName("discount_min_amount")
    private final long discountMinPrice;

    @SerializedName("header")
    private final String header;

    public PromotionDepositPrice() {
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountMaxPrice() {
        return this.discountMaxPrice;
    }

    public final long getDiscountMinPrice() {
        return this.discountMinPrice;
    }

    public final String getHeader() {
        return this.header;
    }
}
