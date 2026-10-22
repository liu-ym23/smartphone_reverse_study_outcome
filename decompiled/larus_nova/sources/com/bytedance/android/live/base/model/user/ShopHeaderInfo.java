package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ShopHeaderInfo {

    @SerializedName("brand_tag")
    py.k brandTag;

    @SerializedName("heart_diamond_info")
    HeartDiamondInfo heartDiamondInfo;

    @SerializedName("icon_show_type")
    int iconShowType;

    @SerializedName("jump_guide_info")
    ProfileText jumpGuideInfo;

    @SerializedName("shop_header_icon_list")
    List<ShopHeaderIcon> shopHeaderIconList;

    @SerializedName("shop_name")
    String shopName;

    @SerializedName("shop_reputation")
    AuthorReputation shopReputation;

    @SerializedName("store_url")
    String storeUrl;

    public ShopHeaderInfo() {
    }

    public py.k getBrandTag() {
        return this.brandTag;
    }

    public HeartDiamondInfo getHeartDiamondInfo() {
        return this.heartDiamondInfo;
    }

    public ProfileText getJumpGuideInfo() {
        return this.jumpGuideInfo;
    }

    public List<ShopHeaderIcon> getShopHeaderIconList() {
        return this.shopHeaderIconList;
    }

    public String getShopName() {
        return this.shopName;
    }

    public AuthorReputation getShopReputation() {
        return this.shopReputation;
    }

    public String getStoreUrl() {
        return this.storeUrl;
    }
}
