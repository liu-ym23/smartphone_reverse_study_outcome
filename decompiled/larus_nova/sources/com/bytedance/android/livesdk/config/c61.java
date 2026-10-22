package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class c61 {

    @SerializedName("audio")
    public String audio;

    @SerializedName("video")
    public String video;

    public c61() {
        this.video = "表演中";
        this.audio = "演唱中";
    }
}
