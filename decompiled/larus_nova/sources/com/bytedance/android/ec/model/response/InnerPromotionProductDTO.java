package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/InnerPromotionProductDTO;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "promotionData", "getPromotionData", "setPromotionData", "promotionProductStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotionProductStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setPromotionProductStruct", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "recommendInfo", "getRecommendInfo", "setRecommendInfo", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InnerPromotionProductDTO implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f47911id;

    @SerializedName("promotion_data")
    private String promotionData;

    @SerializedName("promotion_info")
    private PromotionProductStruct promotionProductStruct;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private String recommendInfo;

    public InnerPromotionProductDTO() {
    }

    public final String getId() {
        return this.f47911id;
    }

    public final String getPromotionData() {
        return this.promotionData;
    }

    public final PromotionProductStruct getPromotionProductStruct() {
        return this.promotionProductStruct;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final void setId(String r100) {
        this.f47911id = r100;
    }

    public final void setPromotionData(String r100) {
        this.promotionData = r100;
    }

    public final void setPromotionProductStruct(PromotionProductStruct r100) {
        this.promotionProductStruct = r100;
    }

    public final void setRecommendInfo(String r100) {
        this.recommendInfo = r100;
    }
}
