package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class z0 {

    @SerializedName("preview_delay")
    public long previewDelay;

    @SerializedName("preview_tab_release")
    public boolean previewTabRelease;

    @SerializedName("start_delay")
    public long startDelay;

    @SerializedName("start_live_release")
    public boolean startLiveRelease;

    public z0() {
        this.previewDelay = 0;
        this.startDelay = 0;
    }
}
