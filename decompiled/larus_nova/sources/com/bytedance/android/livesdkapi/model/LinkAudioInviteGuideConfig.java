package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LinkAudioInviteGuideConfig {

    @SerializedName("enabled")
    public int enabled;

    @SerializedName("threshold")
    public int threshold;

    public LinkAudioInviteGuideConfig() {
        this.enabled = 1;
        this.threshold = 5;
    }

    public LinkAudioInviteGuideConfig(int r100, int r101) {
        this.enabled = r100;
        this.threshold = r101;
    }
}
