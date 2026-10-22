package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonShopEntryItemsStruct;", "Ljava/io/Serializable;", "()V", "detailSchema", "", "getDetailSchema", "()Ljava/lang/String;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "minPrice", "", "getMinPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "promotionId", "getPromotionId", "title", "getTitle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductHotsoonShopEntryItemsStruct implements Serializable {

    @SerializedName("detail_schema")
    private final String detailSchema;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("min_price")
    private final Long minPrice;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("title")
    private final String title;

    public PromotionProductHotsoonShopEntryItemsStruct() {
    }

    public final String getDetailSchema() {
        return this.detailSchema;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final Long getMinPrice() {
        return this.minPrice;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getTitle() {
        return this.title;
    }
}
