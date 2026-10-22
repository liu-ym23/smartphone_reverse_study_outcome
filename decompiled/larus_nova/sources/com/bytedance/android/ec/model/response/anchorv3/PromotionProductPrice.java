package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "Ljava/io/Serializable;", "()V", "discountGroupPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductDiscountPrice;", "getDiscountGroupPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductDiscountPrice;", "discountPrice", "getDiscountPrice", "header", "", "getHeader", "()Ljava/lang/String;", "headerIcon", "getHeaderIcon", "marketPrice", "", "getMarketPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "maxPrice", "getMaxPrice", "minPrice", "getMinPrice", "typeText", "getTypeText", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPrice implements Serializable {

    @SerializedName("discount_group_price")
    private final ProductDiscountPrice discountGroupPrice;

    @SerializedName("discount_price")
    private final ProductDiscountPrice discountPrice;

    @SerializedName("header")
    private final String header;

    @SerializedName("header_icon")
    private final String headerIcon;

    @SerializedName("market_price")
    private final Long marketPrice;

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_price")
    private final Long minPrice;

    @SerializedName("type_text")
    private final String typeText;

    public PromotionProductPrice() {
    }

    public final ProductDiscountPrice getDiscountGroupPrice() {
        return this.discountGroupPrice;
    }

    public final ProductDiscountPrice getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getHeaderIcon() {
        return this.headerIcon;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final String getTypeText() {
        return this.typeText;
    }
}
