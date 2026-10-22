package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class VcdOpenAuthConfig {

    @SerializedName("lottery_open_auth")
    public boolean lotteryOpenAuth;

    @SerializedName("lottery_toast")
    public String lotteryToast;

    @SerializedName("lucky_box_toast")
    public String luckyBoxToast;

    @SerializedName("lucky_box_open_auth")
    public boolean luckyOpenAuth;

    @SerializedName("userpreview_toast")
    public String userpreviewToast;

    public VcdOpenAuthConfig() {
        this.luckyOpenAuth = false;
        this.luckyBoxToast = "本直播在抖音和火山分发红包记录火山可见";
        this.lotteryOpenAuth = false;
        this.lotteryToast = "本直播在抖音和火山分发福袋记录火山可见";
        this.userpreviewToast = "可前往抖音火山版查看";
    }
}
