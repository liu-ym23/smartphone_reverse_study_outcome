package com.bytedance.android.live.base.model.user;

import com.facebook.keyframes.model.KFGradient;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class HonorWallBg {

    @SerializedName("border_color")
    String borderColor;

    @SerializedName(KFGradient.COLOR_END_JSON_FIELD)
    String colorEnd;

    @SerializedName(KFGradient.COLOR_START_JSON_FIELD)
    String colorStart;

    @SerializedName("icon")
    py.k icon;

    public HonorWallBg() {
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public String getColorEnd() {
        return this.colorEnd;
    }

    public String getColorStart() {
        return this.colorStart;
    }

    public py.k getIcon() {
        return this.icon;
    }
}
