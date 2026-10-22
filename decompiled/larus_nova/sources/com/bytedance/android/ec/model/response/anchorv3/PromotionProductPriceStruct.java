package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00188FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u0018\u0010'\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u001a\u0010)\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u001aR\u0018\u0010+\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0012¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;", "Ljava/io/Serializable;", "()V", "depositPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDepositPrice;", "getDepositPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDepositPrice;", "discountPrice", "Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "getDiscountPrice", "()Lcom/bytedance/android/ec/model/PromotionDiscountPrice;", "groupBuyPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionGroupBuyPrice;", "getGroupBuyPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionGroupBuyPrice;", "header", "", "getHeader", "()Ljava/lang/String;", "headerIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getHeaderIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "maxPrice", "", "getMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "minPrice", "getMinPrice", "setMinPrice", "(Ljava/lang/Long;)V", "preferentialPrice", "getPreferentialPrice", "()J", "setPreferentialPrice", "(J)V", "priceLowLabel", "getPriceLowLabel", "priceTrackingInfo", "getPriceTrackingInfo", "regularPrice", "getRegularPrice", "seckillPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSeckillPrice;", "getSeckillPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSeckillPrice;", "suffix", "getSuffix", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPriceStruct implements Serializable {

    @SerializedName("deposit_price")
    private final PromotionDepositPrice depositPrice;

    @SerializedName("discount_price")
    private final PromotionDiscountPrice discountPrice;

    @SerializedName("group_buy_price")
    private final PromotionGroupBuyPrice groupBuyPrice;

    @SerializedName("header")
    private final String header;

    @SerializedName("header_icon")
    private final ECUrlModel headerIcon;

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_price")
    private Long minPrice;
    private long preferentialPrice;

    @SerializedName("price_low_label")
    private final String priceLowLabel;

    @SerializedName("price_tracking_info")
    private final String priceTrackingInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    private final Long regularPrice;

    @SerializedName("seckill_price")
    private final PromotionSeckillPrice seckillPrice;

    @SerializedName("suffix")
    private final String suffix;

    public final long getPreferentialPrice() {
        Long r100 = this.minPrice;
        long r101 = Long.MAX_VALUE;
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
    L6:
        PromotionDiscountPrice r103 = this.discountPrice;
        if (r103 == null) goto L13;
        Long r104 = r103.getMinPrice();
        if (r104 == null) goto L12;
        r101 = r104.longValue();
    L12:
        return r101;
    L13:
        return r102;
    L5:
        r102 = Long.MAX_VALUE;
        goto L6
    }

    public PromotionProductPriceStruct() {
        this.preferentialPrice = Long.MAX_VALUE;
    }

    public final PromotionDepositPrice getDepositPrice() {
        return this.depositPrice;
    }

    public final PromotionDiscountPrice getDiscountPrice() {
        return this.discountPrice;
    }

    public final PromotionGroupBuyPrice getGroupBuyPrice() {
        return this.groupBuyPrice;
    }

    public final String getHeader() {
        return this.header;
    }

    public final ECUrlModel getHeaderIcon() {
        return this.headerIcon;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final String getPriceLowLabel() {
        return this.priceLowLabel;
    }

    public final String getPriceTrackingInfo() {
        return this.priceTrackingInfo;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final PromotionSeckillPrice getSeckillPrice() {
        return this.seckillPrice;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final void setMinPrice(Long r100) {
        this.minPrice = r100;
    }

    public final void setPreferentialPrice(long r100) {
        this.preferentialPrice = r100;
    }
}
