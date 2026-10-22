package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class FlyingStarBroadcastConfig {

    @SerializedName("disable_toast")
    public String disableToast;

    @SerializedName("enable_broadcast")
    public boolean enableBroadcast;

    public FlyingStarBroadcastConfig() {
        this.enableBroadcast = true;
        this.disableToast = "";
    }
}
