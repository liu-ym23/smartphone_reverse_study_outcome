package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/RecommendLogInfo;", "Ljava/io/Serializable;", "()V", "commodityType", "", "getCommodityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "recommendInfo", "", "getRecommendInfo", "()Ljava/lang/String;", "requestId", "getRequestId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendLogInfo implements Serializable {

    @SerializedName(a.KEY_COMMODITY_TYPE)
    private final Integer commodityType;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("request_id")
    private final String requestId;

    public RecommendLogInfo() {
    }

    public final Integer getCommodityType() {
        return this.commodityType;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestId() {
        return this.requestId;
    }
}
