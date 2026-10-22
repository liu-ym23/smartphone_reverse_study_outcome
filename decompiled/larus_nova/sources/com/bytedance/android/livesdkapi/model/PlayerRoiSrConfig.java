package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class PlayerRoiSrConfig {

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("check_link_state")
    public boolean checkLinkState;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("log_enable")
    public boolean logFilterEnable;

    @SerializedName("scene")
    public String scene;

    @SerializedName("ver")
    public String ver;

    public PlayerRoiSrConfig() {
        this.bgColor = "1F212CFF";
        this.checkLinkState = true;
    }
}
