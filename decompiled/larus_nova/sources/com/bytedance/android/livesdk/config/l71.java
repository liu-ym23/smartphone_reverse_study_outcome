package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class l71 {

    @SerializedName("less_30_second_tips")
    public String mPopTitleLess;

    @SerializedName("plus_30_second_tips")
    public String mPopTitlePlus;

    @SerializedName("zero_second_tips")
    public String mPopTitleZero;

    @SerializedName("unexcept_time_subTitle")
    public String mWaitedSubTitle;

    @SerializedName("unexcept_time_title")
    public String mWaitedTitle;

    @SerializedName("except_time_subTitle")
    public String mWaitingSubTile;

    @SerializedName("except_time_title")
    public String mWaitingTile;

    public l71() {
        this.mWaitingTile = "预计%s匹配到对手";
        this.mWaitingSubTile = "正在努力为你寻找匹配主播，再等一下吧";
        this.mWaitedTitle = "已等待%s秒，放弃好可惜！";
        this.mWaitedSubTitle = "即将匹配到合适的主播，若重新匹配可能需要等待更长时间";
        this.mPopTitlePlus = " 寻找合适对手需要一点时间，请耐心等待 ";
        this.mPopTitleLess = " 寻找合适对手中请稍等... ";
        this.mPopTitleZero = "调整状态，PK马上开始";
    }
}
