package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePullStreamDelayConfig;", "", "()V", "innerPullStream", "Lcom/bytedance/android/livesdkapi/model/LivePullStreamDelaySceneConfig;", "getInnerPullStream", "()Lcom/bytedance/android/livesdkapi/model/LivePullStreamDelaySceneConfig;", "setInnerPullStream", "(Lcom/bytedance/android/livesdkapi/model/LivePullStreamDelaySceneConfig;)V", "previewPullStream", "getPreviewPullStream", "setPreviewPullStream", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePullStreamDelayConfig {

    @SerializedName("inroom_prepull")
    private LivePullStreamDelaySceneConfig innerPullStream;

    @SerializedName("legacy")
    private LivePullStreamDelaySceneConfig previewPullStream;

    public LivePullStreamDelayConfig() {
        this.previewPullStream = new LivePullStreamDelaySceneConfig(0, 0.0f);
        this.innerPullStream = new LivePullStreamDelaySceneConfig(0, 0.0f);
    }

    public final LivePullStreamDelaySceneConfig getInnerPullStream() {
        return this.innerPullStream;
    }

    public final LivePullStreamDelaySceneConfig getPreviewPullStream() {
        return this.previewPullStream;
    }

    public final void setInnerPullStream(LivePullStreamDelaySceneConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.innerPullStream = r100;
    }

    public final void setPreviewPullStream(LivePullStreamDelaySceneConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.previewPullStream = r100;
    }
}
