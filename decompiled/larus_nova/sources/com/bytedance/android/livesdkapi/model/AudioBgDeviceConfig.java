package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class AudioBgDeviceConfig {

    @SerializedName("anchor_score")
    public float anchorScore;

    @SerializedName("audience_score")
    public float audienceScore;

    public static AudioBgDeviceConfig defaultConfig() {
        return new AudioBgDeviceConfig(7.41f, 5.5f);
    }

    public AudioBgDeviceConfig(float r100, float r101) {
        this.anchorScore = r100;
        this.audienceScore = r101;
    }
}
