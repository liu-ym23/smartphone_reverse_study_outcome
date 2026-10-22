package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/s;", "", "", "promotionId", "J", "getPromotionId", "()J", "productId", "getProductId", "explainTime", "getExplainTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("explain_time")
    private final long explainTime;

    @SerializedName("product_id")
    private final long productId;

    @SerializedName("promotion_id")
    private final long promotionId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L12;
        s r101 = (s) r100;
        if (this.promotionId == r101.promotionId) goto L8;
        return false;
    L8:
        if (this.productId == r101.productId) goto L10;
        return false;
    L10:
        if (this.explainTime == r101.explainTime) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.promotionId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.productId;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.explainTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "ECPopProductInfo(promotionId=" + this.promotionId + ", productId=" + this.productId + ", explainTime=" + this.explainTime + ")";
    }

    public s(long r100, long r101, long r102) {
        this.promotionId = r100;
        this.productId = r101;
        this.explainTime = r102;
    }
}
