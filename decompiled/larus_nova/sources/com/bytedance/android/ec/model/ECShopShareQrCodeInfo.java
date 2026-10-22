package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0010J\b\u0010\"\u001a\u0004\u0018\u00010\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR&\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/model/ECShopShareQrCodeInfo;", "Ljava/io/Serializable;", "()V", "scoreInfo", "Lcom/bytedance/android/ec/model/ShopScoreInfo;", "getScoreInfo", "()Lcom/bytedance/android/ec/model/ShopScoreInfo;", "setScoreInfo", "(Lcom/bytedance/android/ec/model/ShopScoreInfo;)V", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "shopName", "", "getShopName", "()Ljava/lang/String;", "setShopName", "(Ljava/lang/String;)V", "shopProductList", "", "getShopProductList", "()Ljava/util/List;", "setShopProductList", "(Ljava/util/List;)V", "shopSellingPoint", "getShopSellingPoint", "setShopSellingPoint", "tagList", "getTagList", "setTagList", "getShopSellPointText", "getShopTagIcon", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECShopShareQrCodeInfo implements Serializable {

    @SerializedName("score_info")
    private ShopScoreInfo scoreInfo;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("shop_product_list")
    private List<String> shopProductList;

    @SerializedName("shop_selling_point_tags")
    private List<String> shopSellingPoint;

    @SerializedName("tag_list")
    private List<? extends ECUrlModel> tagList;

    public ECShopShareQrCodeInfo() {
    }

    public final String getShopSellPointText() {
        List<String> r100 = this.shopSellingPoint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.firstOrNull(r100);
    }

    public final ECUrlModel getShopTagIcon() {
        List<? extends ECUrlModel> r100 = this.tagList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (ECUrlModel) CollectionsKt.firstOrNull(r100);
    }

    public final ShopScoreInfo getScoreInfo() {
        return this.scoreInfo;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final List<String> getShopProductList() {
        return this.shopProductList;
    }

    public final List<String> getShopSellingPoint() {
        return this.shopSellingPoint;
    }

    public final List<ECUrlModel> getTagList() {
        return this.tagList;
    }

    public final void setScoreInfo(ShopScoreInfo r100) {
        this.scoreInfo = r100;
    }

    public final void setShopLogo(ECUrlModel r100) {
        this.shopLogo = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setShopProductList(List<String> r100) {
        this.shopProductList = r100;
    }

    public final void setShopSellingPoint(List<String> r100) {
        this.shopSellingPoint = r100;
    }

    public final void setTagList(List<? extends ECUrlModel> r100) {
        this.tagList = r100;
    }
}
