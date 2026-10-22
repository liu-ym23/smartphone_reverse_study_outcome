package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/PromotionProductDetailResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "detailStruct", "Lcom/bytedance/android/shopping/feed/repository/dto/PromotionProductDetailStruct;", "getDetailStruct", "()Lcom/bytedance/android/shopping/feed/repository/dto/PromotionProductDetailStruct;", "setDetailStruct", "(Lcom/bytedance/android/shopping/feed/repository/dto/PromotionProductDetailStruct;)V", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "isValid", "", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductDetailResponse extends CommerceBaseResponse {

    @SerializedName("detail_info")
    private PromotionProductDetailStruct detailStruct;

    @SerializedName("log_pb")
    private final PromotionLogPbData logPb;

    public final boolean isValid() {
        if (getStatusCode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.detailStruct == null) goto L7;
        return true;
    }

    public PromotionProductDetailResponse() {
    }

    public final PromotionProductDetailStruct getDetailStruct() {
        return this.detailStruct;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final void setDetailStruct(PromotionProductDetailStruct r100) {
        this.detailStruct = r100;
    }
}
