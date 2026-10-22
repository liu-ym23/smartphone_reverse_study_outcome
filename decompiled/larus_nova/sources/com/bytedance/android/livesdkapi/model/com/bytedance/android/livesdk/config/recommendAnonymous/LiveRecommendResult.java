package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import com.bytedance.android.livesdkapi.depend.model.live.LabelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRecommendSubmitExtra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendResult;", "", "()V", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra;", "getExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra;", "setExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra;)V", "labelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "getLabelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LabelInfo;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendResult {

    @SerializedName("extra")
    private LiveRecommendSubmitExtra extra;

    @SerializedName("data")
    private final LabelInfo labelInfo;

    public LiveRecommendResult() {
    }

    public final LiveRecommendSubmitExtra getExtra() {
        return this.extra;
    }

    public final LabelInfo getLabelInfo() {
        return this.labelInfo;
    }

    public final void setExtra(LiveRecommendSubmitExtra r100) {
        this.extra = r100;
    }
}
