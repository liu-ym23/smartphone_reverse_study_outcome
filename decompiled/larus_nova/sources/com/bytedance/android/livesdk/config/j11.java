package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes8.dex */
public class j11 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    public long interval;

    public j11() {
        this.enable = false;
        this.interval = 10000;
    }
}
