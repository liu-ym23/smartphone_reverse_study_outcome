package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ShopHeaderCouponDTO;", "Ljava/io/Serializable;", "()V", "couponInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionGeneralStructDTO;", "getCouponInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionGeneralStructDTO;", "couponTitle", "", "getCouponTitle", "()Ljava/lang/String;", "couponType", "", "getCouponType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "promotionPicUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getPromotionPicUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderCouponDTO implements Serializable {

    @SerializedName("promotion_general")
    private final PromotionGeneralStructDTO couponInfo;

    @SerializedName("title")
    private final String couponTitle;

    @SerializedName("promotion_type")
    private final Integer couponType;

    @SerializedName("promotion_pic_url")
    private final ECUrlModel promotionPicUrl;

    public ShopHeaderCouponDTO() {
    }

    public final PromotionGeneralStructDTO getCouponInfo() {
        return this.couponInfo;
    }

    public final String getCouponTitle() {
        return this.couponTitle;
    }

    public final Integer getCouponType() {
        return this.couponType;
    }

    public final ECUrlModel getPromotionPicUrl() {
        return this.promotionPicUrl;
    }
}
