package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;", "Ljava/io/Serializable;", "productId", "", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "price", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;", "statusText", "goodRatio", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;Ljava/lang/String;Ljava/lang/String;)V", "getGoodRatio", "()Ljava/lang/String;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;", "getProductId", "getStatusText", "getTitle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionShopCommentProductCard implements Serializable {

    @SerializedName("good_ratio")
    private final String goodRatio;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("price")
    private final PromotionProductPriceStruct price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("status_text")
    private final String statusText;

    @SerializedName("title")
    private final String title;

    public final String getGoodRatio() {
        return this.goodRatio;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final PromotionProductPriceStruct getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getTitle() {
        return this.title;
    }

    public PromotionShopCommentProductCard(String r100, ECUrlModel r101, String r102, PromotionProductPriceStruct r103, String r104, String r105) {
        this.productId = r100;
        this.icon = r101;
        this.title = r102;
        this.price = r103;
        this.statusText = r104;
        this.goodRatio = r105;
    }
}
