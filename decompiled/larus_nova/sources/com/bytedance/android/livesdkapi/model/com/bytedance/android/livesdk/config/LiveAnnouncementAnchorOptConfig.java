package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAnnouncementAnchorOptConfig;", "", "()V", "closeMaxCount", "", "getCloseMaxCount", "()I", "setCloseMaxCount", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "publishDelayDuration", "getPublishDelayDuration", "setPublishDelayDuration", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnnouncementAnchorOptConfig {

    @SerializedName("close_max_count")
    private int closeMaxCount;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("publish_delay_duration")
    private int publishDelayDuration;

    public LiveAnnouncementAnchorOptConfig() {
        this.publishDelayDuration = 1;
        this.closeMaxCount = 3;
    }

    public final int getCloseMaxCount() {
        return this.closeMaxCount;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getPublishDelayDuration() {
        return this.publishDelayDuration;
    }

    public final void setCloseMaxCount(int r100) {
        this.closeMaxCount = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setPublishDelayDuration(int r100) {
        this.publishDelayDuration = r100;
    }
}
