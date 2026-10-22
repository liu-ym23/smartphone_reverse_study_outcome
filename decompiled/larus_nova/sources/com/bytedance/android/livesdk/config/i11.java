package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class i11 {

    @SerializedName("delayMillis")
    public long delayMillis;

    @SerializedName("enableEnterToExit")
    public boolean enableEnterToExit;

    @SerializedName("enableScroll")
    public boolean enableScroll;

    public i11() {
        this.delayMillis = 3000;
    }
}
