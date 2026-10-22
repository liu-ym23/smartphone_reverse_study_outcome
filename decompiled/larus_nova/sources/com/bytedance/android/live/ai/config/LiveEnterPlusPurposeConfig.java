package com.bytedance.android.live.ai.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ai/config/LiveEnterPlusPurposeConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableSync", "getEnableSync", "setEnableSync", "predictInterval", "", "getPredictInterval", "()I", "setPredictInterval", "(I)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEnterPlusPurposeConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_sync")
    private boolean enableSync;

    @SerializedName("predict_interval")
    private int predictInterval;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public LiveEnterPlusPurposeConfig() {
        this.enable = true;
        this.enableSync = true;
        this.predictInterval = 5000;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableSync() {
        return this.enableSync;
    }

    public final int getPredictInterval() {
        return this.predictInterval;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableSync(boolean r100) {
        this.enableSync = r100;
    }

    public final void setPredictInterval(int r100) {
        this.predictInterval = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }
}
