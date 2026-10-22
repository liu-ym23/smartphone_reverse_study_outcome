package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelResponse;", "", "()V", "data", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelResult;", "getData", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelResult;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendLabelResponse {

    @SerializedName("data")
    private final LiveRecommendLabelResult data;

    public LiveRecommendLabelResponse() {
    }

    public final LiveRecommendLabelResult getData() {
        return this.data;
    }
}
