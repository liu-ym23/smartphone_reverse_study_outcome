package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPackDynamicResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "promotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "isValid", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionPackDynamicResponse extends CommerceBaseResponse {

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    @SerializedName("promotion")
    private PromotionProductStruct promotion;

    public final boolean isValid() {
        if (getStatusCode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.promotion == null) goto L7;
        return true;
    }

    public PromotionPackDynamicResponse() {
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final PromotionProductStruct getPromotion() {
        return this.promotion;
    }

    public final void setPromotion(PromotionProductStruct r100) {
        this.promotion = r100;
    }
}
