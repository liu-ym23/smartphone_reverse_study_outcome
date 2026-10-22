package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes8.dex */
public class gb1 {

    @SerializedName("enable_move_sampling")
    public boolean enableMoveSampling;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    public int interval;

    @SerializedName("policy")
    public int policy;

    public gb1() {
    }
}
