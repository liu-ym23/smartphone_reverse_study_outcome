package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000f¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "beltBackground", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBeltBackground", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setBeltBackground", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "logoBackground", "getLogoBackground", "setLogoBackground", "", "sellPrice", "Ljava/lang/Long;", "getSellPrice", "()Ljava/lang/Long;", "setSellPrice", "(Ljava/lang/Long;)V", "", "sellPriceDesc", "Ljava/lang/String;", "getSellPriceDesc", "()Ljava/lang/String;", "setSellPriceDesc", "(Ljava/lang/String;)V", "marketPriceDesc", "getMarketPriceDesc", "setMarketPriceDesc", "subsidizedPriceDesc", "getSubsidizedPriceDesc", "setSubsidizedPriceDesc", "maxSellPrice", "getMaxSellPrice", "setMaxSellPrice", "sellPriceIcon", "getSellPriceIcon", "setSellPriceIcon", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionSubsidizedActivity implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_SUBSIDIZED = 1;

    @SerializedName("belt_background")
    private ECUrlModel beltBackground;

    @SerializedName("logo_background")
    private ECUrlModel logoBackground;

    @SerializedName("market_price_desc")
    private String marketPriceDesc;

    @SerializedName("max_sell_price")
    private Long maxSellPrice;

    @SerializedName("sell_price")
    private Long sellPrice;

    @SerializedName("sell_price_desc")
    private String sellPriceDesc;

    @SerializedName("sell_price_icon")
    private ECUrlModel sellPriceIcon;

    @SerializedName("subsidized_price_desc")
    private String subsidizedPriceDesc;

    @SerializedName("type")
    private Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionSubsidizedActivity() {
    }

    public final ECUrlModel getBeltBackground() {
        return this.beltBackground;
    }

    public final ECUrlModel getLogoBackground() {
        return this.logoBackground;
    }

    public final String getMarketPriceDesc() {
        return this.marketPriceDesc;
    }

    public final Long getMaxSellPrice() {
        return this.maxSellPrice;
    }

    public final Long getSellPrice() {
        return this.sellPrice;
    }

    public final String getSellPriceDesc() {
        return this.sellPriceDesc;
    }

    public final ECUrlModel getSellPriceIcon() {
        return this.sellPriceIcon;
    }

    public final String getSubsidizedPriceDesc() {
        return this.subsidizedPriceDesc;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setBeltBackground(ECUrlModel r100) {
        this.beltBackground = r100;
    }

    public final void setLogoBackground(ECUrlModel r100) {
        this.logoBackground = r100;
    }

    public final void setMarketPriceDesc(String r100) {
        this.marketPriceDesc = r100;
    }

    public final void setMaxSellPrice(Long r100) {
        this.maxSellPrice = r100;
    }

    public final void setSellPrice(Long r100) {
        this.sellPrice = r100;
    }

    public final void setSellPriceDesc(String r100) {
        this.sellPriceDesc = r100;
    }

    public final void setSellPriceIcon(ECUrlModel r100) {
        this.sellPriceIcon = r100;
    }

    public final void setSubsidizedPriceDesc(String r100) {
        this.subsidizedPriceDesc = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
