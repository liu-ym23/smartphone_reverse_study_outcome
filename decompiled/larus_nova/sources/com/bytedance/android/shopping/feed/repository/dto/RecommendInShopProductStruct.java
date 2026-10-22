package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/RecommendInShopProductStruct;", "Ljava/io/Serializable;", "()V", "additionalInfo", "Lcom/bytedance/android/shopping/feed/repository/dto/AdditionalInfoStruct;", "getAdditionalInfo", "()Lcom/bytedance/android/shopping/feed/repository/dto/AdditionalInfoStruct;", "setAdditionalInfo", "(Lcom/bytedance/android/shopping/feed/repository/dto/AdditionalInfoStruct;)V", "baseInfo", "Lcom/bytedance/android/shopping/feed/repository/dto/PromotionReInShopProductStruct;", "getBaseInfo", "()Lcom/bytedance/android/shopping/feed/repository/dto/PromotionReInShopProductStruct;", "setBaseInfo", "(Lcom/bytedance/android/shopping/feed/repository/dto/PromotionReInShopProductStruct;)V", "price", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendInShopProductStruct implements Serializable {

    @SerializedName("additional_info")
    private AdditionalInfoStruct additionalInfo;

    @SerializedName("base_info")
    private PromotionReInShopProductStruct baseInfo;

    @SerializedName("price")
    private final PromotionProductPrice price;

    public RecommendInShopProductStruct() {
    }

    public final AdditionalInfoStruct getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final PromotionReInShopProductStruct getBaseInfo() {
        return this.baseInfo;
    }

    public final PromotionProductPrice getPrice() {
        return this.price;
    }

    public final void setAdditionalInfo(AdditionalInfoStruct r100) {
        this.additionalInfo = r100;
    }

    public final void setBaseInfo(PromotionReInShopProductStruct r100) {
        this.baseInfo = r100;
    }
}
