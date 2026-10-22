package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LinkAudioGuideConfig {

    @SerializedName("anchor_rate_limit")
    public int anchorRateLimit;

    @SerializedName("audience_rate_limit")
    public int audienceRateLimit;

    @SerializedName("repeat_count")
    public int repeatCount;

    public LinkAudioGuideConfig(int r100, int r101, int r102) {
        this.repeatCount = r100;
        this.anchorRateLimit = r101;
        this.audienceRateLimit = r102;
    }
}
