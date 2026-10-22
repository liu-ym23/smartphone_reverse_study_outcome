package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class HeartDiamondInfo {

    @SerializedName("heart_diamond_icon")
    py.k heartDiamondIcon;

    @SerializedName("percent")
    String heartPercent;

    @SerializedName("level")
    int level;

    public HeartDiamondInfo() {
    }

    public py.k getHeartDiamondIcon() {
        return this.heartDiamondIcon;
    }

    public String getHeartPercent() {
        return this.heartPercent;
    }

    public int getLevel() {
        return this.level;
    }
}
