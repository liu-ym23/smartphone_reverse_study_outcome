package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import com.bytedance.android.livesdkapi.depend.model.live.LabelInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelResult;", "", "()V", "labelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "getLabelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "status", "", "getStatus", "()J", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendLabelResult {

    @SerializedName("assist_label")
    private final LabelInfo labelInfo;

    @SerializedName("recommend_status")
    private final long status;

    public LiveRecommendLabelResult() {
    }

    public final LabelInfo getLabelInfo() {
        return this.labelInfo;
    }

    public final long getStatus() {
        return this.status;
    }
}
