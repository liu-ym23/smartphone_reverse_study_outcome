package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/MultiLinkBaseDegradeConfig;", "", "()V", "liveAudioSimpleDataEnable", "", "getLiveAudioSimpleDataEnable", "()Z", "setLiveAudioSimpleDataEnable", "(Z)V", "seiConsumeDebounceTime", "", "getSeiConsumeDebounceTime", "()I", "setSeiConsumeDebounceTime", "(I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkBaseDegradeConfig {

    @SerializedName("live_audio_subtitle_delete_redundant_data")
    private boolean liveAudioSimpleDataEnable;

    @SerializedName("live_sei_under_clock_time")
    private int seiConsumeDebounceTime;

    public MultiLinkBaseDegradeConfig() {
    }

    public final boolean getLiveAudioSimpleDataEnable() {
        return this.liveAudioSimpleDataEnable;
    }

    public final int getSeiConsumeDebounceTime() {
        return this.seiConsumeDebounceTime;
    }

    public final void setLiveAudioSimpleDataEnable(boolean r100) {
        this.liveAudioSimpleDataEnable = r100;
    }

    public final void setSeiConsumeDebounceTime(int r100) {
        this.seiConsumeDebounceTime = r100;
    }
}
