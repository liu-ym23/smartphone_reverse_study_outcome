package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR \u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR \u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR \u0010/\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R \u00105\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\"\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\"\u0010;\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\b¨\u0006>"}, d2 = {"Lcom/bytedance/android/format/model/CommodityData;", "Ljava/io/Serializable;", "()V", "cardExpireTime", "", "getCardExpireTime", "()Ljava/lang/Integer;", "setCardExpireTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cardSource", "", "getCardSource", "()Ljava/lang/String;", "setCardSource", "(Ljava/lang/String;)V", "goodDetailSchema", "getGoodDetailSchema", "setGoodDetailSchema", "imgUrlList", "", "getImgUrlList", "()Ljava/util/List;", "setImgUrlList", "(Ljava/util/List;)V", "marketPrice", "getMarketPrice", "setMarketPrice", "middleTitle", "getMiddleTitle", "setMiddleTitle", "name", "getName", "setName", "price", "", "getPrice", "()Ljava/lang/Long;", "setPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "priceHeader", "getPriceHeader", "setPriceHeader", "productId", "getProductId", "setProductId", "saleText", "getSaleText", "setSaleText", "sellNum", "getSellNum", "setSellNum", "shortTitle", "getShortTitle", "setShortTitle", "status", "getStatus", "setStatus", "stockStatus", "getStockStatus", "setStockStatus", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityData implements Serializable {
    private Integer cardExpireTime;
    private String cardSource;

    @SerializedName("schema")
    private String goodDetailSchema;

    @SerializedName("img_url_list")
    private List<String> imgUrlList;

    @SerializedName("market_price")
    private Integer marketPrice;

    @SerializedName("middle_title")
    private String middleTitle;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private Long price;

    @SerializedName("price_header")
    private String priceHeader;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("sale_text")
    private String saleText;

    @SerializedName("sell_num")
    private Long sellNum;

    @SerializedName("short_title")
    private String shortTitle;

    @SerializedName("status")
    private Integer status;

    @SerializedName("stock_status")
    private Integer stockStatus;

    public CommodityData() {
    }

    public final Integer getCardExpireTime() {
        return this.cardExpireTime;
    }

    public final String getCardSource() {
        return this.cardSource;
    }

    public final String getGoodDetailSchema() {
        return this.goodDetailSchema;
    }

    public final List<String> getImgUrlList() {
        return this.imgUrlList;
    }

    public final Integer getMarketPrice() {
        return this.marketPrice;
    }

    public final String getMiddleTitle() {
        return this.middleTitle;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getPriceHeader() {
        return this.priceHeader;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSaleText() {
        return this.saleText;
    }

    public final Long getSellNum() {
        return this.sellNum;
    }

    public final String getShortTitle() {
        return this.shortTitle;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getStockStatus() {
        return this.stockStatus;
    }

    public final void setCardExpireTime(Integer r100) {
        this.cardExpireTime = r100;
    }

    public final void setCardSource(String r100) {
        this.cardSource = r100;
    }

    public final void setGoodDetailSchema(String r100) {
        this.goodDetailSchema = r100;
    }

    public final void setImgUrlList(List<String> r100) {
        this.imgUrlList = r100;
    }

    public final void setMarketPrice(Integer r100) {
        this.marketPrice = r100;
    }

    public final void setMiddleTitle(String r100) {
        this.middleTitle = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPrice(Long r100) {
        this.price = r100;
    }

    public final void setPriceHeader(String r100) {
        this.priceHeader = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setSaleText(String r100) {
        this.saleText = r100;
    }

    public final void setSellNum(Long r100) {
        this.sellNum = r100;
    }

    public final void setShortTitle(String r100) {
        this.shortTitle = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setStockStatus(Integer r100) {
        this.stockStatus = r100;
    }
}
