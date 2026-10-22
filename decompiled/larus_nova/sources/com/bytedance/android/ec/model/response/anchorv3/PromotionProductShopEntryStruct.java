package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductShopEntryStruct;", "Ljava/io/Serializable;", "()V", "brandInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBrandStruct;", "getBrandInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBrandStruct;", "mvpAuthorized", "", "getMvpAuthorized", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "navLink", "", "getNavLink", "()Ljava/lang/String;", "recommendProductCount", "", "getRecommendProductCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "shopAuthorId", "getShopAuthorId", "xiaodianProductCount", "getXiaodianProductCount", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductShopEntryStruct implements Serializable {

    @SerializedName("brand_info")
    private final PromotionProductBrandStruct brandInfo;

    @SerializedName("mvp_authorized")
    private final Boolean mvpAuthorized;

    @SerializedName("nav_link")
    private final String navLink;

    @SerializedName("recommend_product_count")
    private final Long recommendProductCount;

    @SerializedName("shop_author_id")
    private final String shopAuthorId;

    @SerializedName("xiaodian_product_count")
    private final Long xiaodianProductCount;

    public PromotionProductShopEntryStruct() {
    }

    public final PromotionProductBrandStruct getBrandInfo() {
        return this.brandInfo;
    }

    public final Boolean getMvpAuthorized() {
        return this.mvpAuthorized;
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final Long getRecommendProductCount() {
        return this.recommendProductCount;
    }

    public final String getShopAuthorId() {
        return this.shopAuthorId;
    }

    public final Long getXiaodianProductCount() {
        return this.xiaodianProductCount;
    }
}
