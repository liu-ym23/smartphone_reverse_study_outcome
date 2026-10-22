package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class HonorWallContent {

    @SerializedName("honor_wall_bg")
    HonorWallBg honorWallBg;

    @SerializedName("honor_wall_bottom_display")
    ProfileText honorWallBottomDisplay;

    @SerializedName("honor_wall_top_display")
    ProfileText honorWallTopDisplay;

    public HonorWallContent() {
    }

    public HonorWallBg getHonorWallBg() {
        return this.honorWallBg;
    }

    public ProfileText getHonorWallBottomDisplay() {
        return this.honorWallBottomDisplay;
    }

    public ProfileText getHonorWallTopDisplay() {
        return this.honorWallTopDisplay;
    }
}
