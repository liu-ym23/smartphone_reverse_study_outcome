package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionRecommendResponse;", "Ljava/io/Serializable;", "()V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "products", "", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/RecommendInShopProductStruct;", "getProducts", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "shopUrl", "", "getShopUrl", "()Ljava/lang/String;", "statusCode", "", "getStatusCode", "()Ljava/lang/Integer;", "setStatusCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionRecommendResponse implements Serializable {

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    @SerializedName("products")
    private List<RecommendInShopProductStruct> products;

    @SerializedName("shop_url")
    private final String shopUrl;

    @SerializedName("status_code")
    private Integer statusCode;

    public PromotionRecommendResponse() {
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final List<RecommendInShopProductStruct> getProducts() {
        return this.products;
    }

    public final String getShopUrl() {
        return this.shopUrl;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final void setProducts(List<RecommendInShopProductStruct> r100) {
        this.products = r100;
    }

    public final void setStatusCode(Integer r100) {
        this.statusCode = r100;
    }
}
