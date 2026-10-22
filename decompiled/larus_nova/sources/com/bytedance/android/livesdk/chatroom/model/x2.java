package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class x2 {

    @SerializedName("enable_slide_optimize")
    public boolean enableSlideOptimize;

    @SerializedName("large_screen")
    public int largeScreenAvoidWidth;

    @SerializedName("small_screen")
    public int smallScreenAvoidWidth;

    public x2() {
        this.largeScreenAvoidWidth = 45;
        this.smallScreenAvoidWidth = 45;
        this.enableSlideOptimize = false;
    }
}
