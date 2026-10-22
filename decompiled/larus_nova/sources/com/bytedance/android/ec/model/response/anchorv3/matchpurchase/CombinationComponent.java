package com.bytedance.android.ec.model.response.anchorv3.matchpurchase;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 ¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationComponent;", "Ljava/io/Serializable;", "()V", "channelInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationChannelInfo;", "getChannelInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationChannelInfo;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "imageTips", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageTips;", "getImageTips", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageTips;", "name", "", "getName", "()Ljava/lang/String;", "price", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "productId", "getProductId", "promotionId", "getPromotionId", "schema", "getSchema", "skuType", "", "getSkuType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "specInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/SingleSkuSpecInfo;", "getSpecInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/SingleSkuSpecInfo;", "status", "getStatus", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CombinationComponent implements Serializable {

    @SerializedName("channel_info")
    private final CombinationChannelInfo channelInfo;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("image_tips")
    private final ImageTips imageTips;

    @SerializedName("name")
    private final String name;

    @SerializedName("price")
    private final PromotionProductPrice price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("url")
    private final String schema;

    @SerializedName("sku_type")
    private final Integer skuType;

    @SerializedName("spec_info")
    private final SingleSkuSpecInfo specInfo;

    @SerializedName("product_status")
    private final Integer status;

    public CombinationComponent() {
    }

    public final CombinationChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final ImageTips getImageTips() {
        return this.imageTips;
    }

    public final String getName() {
        return this.name;
    }

    public final PromotionProductPrice getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getSkuType() {
        return this.skuType;
    }

    public final SingleSkuSpecInfo getSpecInfo() {
        return this.specInfo;
    }

    public final Integer getStatus() {
        return this.status;
    }
}
