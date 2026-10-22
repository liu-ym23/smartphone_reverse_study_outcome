package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class ac1 {

    @SerializedName("enable_request_failed_check")
    public boolean enableReqFailedCheck;

    @SerializedName("enable_silence_when_mute")
    public boolean enableSilenceWhenMute;

    @SerializedName("enable_version_mute_check")
    public boolean enableVersionResetMute;

    public ac1() {
        this.enableReqFailedCheck = true;
        this.enableVersionResetMute = true;
        this.enableSilenceWhenMute = true;
    }
}
