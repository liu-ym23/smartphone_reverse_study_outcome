package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAudiencePanelConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "likeDismissDuration", "", "getLikeDismissDuration", "()J", "setLikeDismissDuration", "(J)V", "localStoreSize", "", "getLocalStoreSize", "()I", "setLocalStoreSize", "(I)V", "messageShowThreshold", "getMessageShowThreshold", "setMessageShowThreshold", "panelShowThreshold", "getPanelShowThreshold", "setPanelShowThreshold", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAudiencePanelConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("like_dismiss_duration")
    private long likeDismissDuration;

    @SerializedName("local_store_size")
    private int localStoreSize;

    @SerializedName("message_like_show_threshold")
    private int messageShowThreshold;

    @SerializedName("panel_like_show_threshold")
    private long panelShowThreshold;

    public LiveAudiencePanelConfig() {
        this.enable = true;
        this.likeDismissDuration = 2000;
        this.localStoreSize = 300;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final long getLikeDismissDuration() {
        return this.likeDismissDuration;
    }

    public final int getLocalStoreSize() {
        return this.localStoreSize;
    }

    public final int getMessageShowThreshold() {
        return this.messageShowThreshold;
    }

    public final long getPanelShowThreshold() {
        return this.panelShowThreshold;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setLikeDismissDuration(long r100) {
        this.likeDismissDuration = r100;
    }

    public final void setLocalStoreSize(int r100) {
        this.localStoreSize = r100;
    }

    public final void setMessageShowThreshold(int r100) {
        this.messageShowThreshold = r100;
    }

    public final void setPanelShowThreshold(long r100) {
        this.panelShowThreshold = r100;
    }
}
