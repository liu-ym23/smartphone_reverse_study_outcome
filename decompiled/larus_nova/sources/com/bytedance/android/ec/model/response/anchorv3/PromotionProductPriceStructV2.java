package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStructV2;", "Ljava/io/Serializable;", "()V", "mainPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PriceV2;", "getMainPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PriceV2;", "priceDescription", "Lcom/bytedance/android/ec/model/response/anchorv3/PriceDescription;", "getPriceDescription", "()Lcom/bytedance/android/ec/model/response/anchorv3/PriceDescription;", "subPrice", "getSubPrice", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductPriceStructV2 implements Serializable {

    @SerializedName("main_price")
    private final PriceV2 mainPrice;

    @SerializedName("price_description")
    private final PriceDescription priceDescription;

    @SerializedName("sub_price")
    private final PriceV2 subPrice;

    public PromotionProductPriceStructV2() {
    }

    public final PriceV2 getMainPrice() {
        return this.mainPrice;
    }

    public final PriceDescription getPriceDescription() {
        return this.priceDescription;
    }

    public final PriceV2 getSubPrice() {
        return this.subPrice;
    }
}
