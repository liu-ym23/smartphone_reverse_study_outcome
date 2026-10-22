package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R,\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionPriceInfo;", "Ljava/io/Serializable;", "()V", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "maxPrice", "", "getMaxPrice", "()J", "setMaxPrice", "(J)V", "minPrice", "getMinPrice", "setMinPrice", "minPriceStr", "getMinPriceStr", "()Ljava/lang/String;", "setMinPriceStr", "(Ljava/lang/String;)V", "priceHeader", "getPriceHeader", "setPriceHeader", "productId", "getProductId", "setProductId", "regularPrice", "getRegularPrice", "()Ljava/lang/Long;", "setRegularPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "updatedEventParam", "getUpdatedEventParam", "setUpdatedEventParam", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionPriceInfo implements Serializable {

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("max_price")
    private long maxPrice;

    @SerializedName("min_price")
    private long minPrice;

    @SerializedName("min_price_str")
    private String minPriceStr;

    @SerializedName("price_header")
    private String priceHeader;

    @SerializedName("product_id")
    private long productId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    private Long regularPrice;

    @SerializedName("updated_event_param")
    private Map<String, String> updatedEventParam;

    public PromotionPriceInfo() {
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final long getMaxPrice() {
        return this.maxPrice;
    }

    public final long getMinPrice() {
        return this.minPrice;
    }

    public final String getMinPriceStr() {
        return this.minPriceStr;
    }

    public final String getPriceHeader() {
        return this.priceHeader;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final Map<String, String> getUpdatedEventParam() {
        return this.updatedEventParam;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setMaxPrice(long r100) {
        this.maxPrice = r100;
    }

    public final void setMinPrice(long r100) {
        this.minPrice = r100;
    }

    public final void setMinPriceStr(String r100) {
        this.minPriceStr = r100;
    }

    public final void setPriceHeader(String r100) {
        this.priceHeader = r100;
    }

    public final void setProductId(long r100) {
        this.productId = r100;
    }

    public final void setRegularPrice(Long r100) {
        this.regularPrice = r100;
    }

    public final void setUpdatedEventParam(Map<String, String> r100) {
        this.updatedEventParam = r100;
    }
}
