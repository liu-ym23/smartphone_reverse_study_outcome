package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductInstallmentStruct;", "Ljava/io/Serializable;", "()V", "mPromotionDiscountInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountInfo;", "getMPromotionDiscountInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountInfo;", "mPromotionOpenInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionOpenInfo;", "getMPromotionOpenInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionOpenInfo;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductInstallmentStruct implements Serializable {

    @SerializedName("discount_info")
    private final PromotionDiscountInfo mPromotionDiscountInfo;

    @SerializedName("open_info")
    private final PromotionOpenInfo mPromotionOpenInfo;

    public PromotionProductInstallmentStruct() {
    }

    public final PromotionDiscountInfo getMPromotionDiscountInfo() {
        return this.mPromotionDiscountInfo;
    }

    public final PromotionOpenInfo getMPromotionOpenInfo() {
        return this.mPromotionOpenInfo;
    }
}
