package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionGroupBuyPrice;", "Ljava/io/Serializable;", "()V", "header", "", "getHeader", "()Ljava/lang/String;", "originMaxPrice", "", "getOriginMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "originMinPrice", "getOriginMinPrice", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionGroupBuyPrice implements Serializable {

    @SerializedName("header")
    private final String header;

    @SerializedName("origin_max_price")
    private final Long originMaxPrice;

    @SerializedName("origin_min_price")
    private final Long originMinPrice;

    public PromotionGroupBuyPrice() {
    }

    public final String getHeader() {
        return this.header;
    }

    public final Long getOriginMaxPrice() {
        return this.originMaxPrice;
    }

    public final Long getOriginMinPrice() {
        return this.originMinPrice;
    }
}
