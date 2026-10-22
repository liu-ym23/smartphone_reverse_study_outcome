package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\n¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStoreEntryStruct;", "Ljava/io/Serializable;", "()V", "brandInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBrandStruct;", "getBrandInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBrandStruct;", "navLink", "", "getNavLink", "()Ljava/lang/String;", "promotionProductBannerStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", "getPromotionProductBannerStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBannerStruct;", "sellRatingInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/StoreExperienceDTO;", "getSellRatingInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/StoreExperienceDTO;", "shopAuthorId", "getShopAuthorId", "shopHeaderCoupons", "", "Lcom/bytedance/android/ec/model/response/anchorv3/ShopHeaderCouponDTO;", "getShopHeaderCoupons", "()Ljava/util/List;", "shopHeaderIconList", "Lcom/bytedance/android/ec/model/response/anchorv3/ShopHeaderIconDTO;", "getShopHeaderIconList", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "shopName", "getShopName", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductStoreEntryStruct implements Serializable {

    @SerializedName("brand_info")
    private final PromotionProductBrandStruct brandInfo;

    @SerializedName("nav_link")
    private final String navLink;

    @SerializedName("shop_banner")
    private final PromotionProductBannerStruct promotionProductBannerStruct;

    @SerializedName("sell_rating_info")
    private final StoreExperienceDTO sellRatingInfo;

    @SerializedName("shop_author_id")
    private final String shopAuthorId;

    @SerializedName("promotion_infos")
    private final List<ShopHeaderCouponDTO> shopHeaderCoupons;

    @SerializedName("shop_header_icon_list")
    private final List<ShopHeaderIconDTO> shopHeaderIconList;

    @SerializedName("shop_logo")
    private final ECUrlModel shopLogo;

    @SerializedName("shop_name")
    private final String shopName;

    public PromotionProductStoreEntryStruct() {
    }

    public final PromotionProductBrandStruct getBrandInfo() {
        return this.brandInfo;
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final PromotionProductBannerStruct getPromotionProductBannerStruct() {
        return this.promotionProductBannerStruct;
    }

    public final StoreExperienceDTO getSellRatingInfo() {
        return this.sellRatingInfo;
    }

    public final String getShopAuthorId() {
        return this.shopAuthorId;
    }

    public final List<ShopHeaderCouponDTO> getShopHeaderCoupons() {
        return this.shopHeaderCoupons;
    }

    public final List<ShopHeaderIconDTO> getShopHeaderIconList() {
        return this.shopHeaderIconList;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final String getShopName() {
        return this.shopName;
    }
}
