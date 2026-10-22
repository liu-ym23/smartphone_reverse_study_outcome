package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveRevLinkPanelPreloadAiConfig;", "", "()V", "consumeResult", "", "getConsumeResult", "()Z", "setConsumeResult", "(Z)V", "enable", "getEnable", "setEnable", "predictInterval", "", "getPredictInterval", "()J", "setPredictInterval", "(J)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRevLinkPanelPreloadAiConfig {

    @SerializedName("pitaya_enable")
    private boolean consumeResult;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("prediction_interval")
    private long predictInterval;

    public LiveRevLinkPanelPreloadAiConfig() {
        this.predictInterval = 120;
    }

    public final boolean getConsumeResult() {
        return this.consumeResult;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final long getPredictInterval() {
        return this.predictInterval;
    }

    public final void setConsumeResult(boolean r100) {
        this.consumeResult = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setPredictInterval(long r100) {
        this.predictInterval = r100;
    }
}
