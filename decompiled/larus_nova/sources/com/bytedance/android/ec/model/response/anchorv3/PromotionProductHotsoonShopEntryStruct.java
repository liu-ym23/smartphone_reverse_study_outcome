package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonShopEntryStruct;", "Ljava/io/Serializable;", "()V", "authorReputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "getAuthorReputation", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "experScore", "", "getExperScore", "()Ljava/util/List;", "items", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonShopEntryItemsStruct;", "getItems", "navLink", "", "getNavLink", "()Ljava/lang/String;", "navText", "getNavText", "productCount", "", "getProductCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "shopAvatar", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "shopName", "getShopName", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductHotsoonShopEntryStruct implements Serializable {

    @SerializedName("author_reputation")
    private final AuthorReputationDTO authorReputation;

    @SerializedName("exper_score")
    private final List<AuthorReputationDTO> experScore;

    @SerializedName("items")
    private final List<PromotionProductHotsoonShopEntryItemsStruct> items;

    @SerializedName("nav_link")
    private final String navLink;

    @SerializedName("nav_text")
    private final String navText;

    @SerializedName("product_count")
    private final Integer productCount;

    @SerializedName("shop_avatar")
    private final ECUrlModel shopAvatar;

    @SerializedName("shop_name")
    private final String shopName;

    public PromotionProductHotsoonShopEntryStruct() {
    }

    public final AuthorReputationDTO getAuthorReputation() {
        return this.authorReputation;
    }

    public final List<AuthorReputationDTO> getExperScore() {
        return this.experScore;
    }

    public final List<PromotionProductHotsoonShopEntryItemsStruct> getItems() {
        return this.items;
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final String getNavText() {
        return this.navText;
    }

    public final Integer getProductCount() {
        return this.productCount;
    }

    public final ECUrlModel getShopAvatar() {
        return this.shopAvatar;
    }

    public final String getShopName() {
        return this.shopName;
    }
}
