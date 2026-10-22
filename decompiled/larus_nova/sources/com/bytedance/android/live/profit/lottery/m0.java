package com.bytedance.android.live.profit.lottery;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes47.dex */
public class m0 {

    @SerializedName("live_lottery_anchor_create_page")
    public String anchorLotteryCreateUri;

    @SerializedName("live_lottery_anchor_result")
    public String anchorLotteryDetailUri;

    @SerializedName("live_lottery_asset_id")
    public long assetId;

    @SerializedName("live_lottery_assume_participated")
    public int assumeParticipated;

    @SerializedName("live_lottery_audience_result")
    public String audienceLotteryResultUri;

    @SerializedName("live_lottery_audience_home")
    public String audienceLotteryWaitUri;

    @SerializedName("live_lottery_enable_draw_animation")
    public int enableDrawAnimation;

    @SerializedName("live_lottery_enable")
    public int enabled;

    @SerializedName("live_lottery_icon_url")
    public String iconUrl;

    @SerializedName("live_lottery_net_error_toast")
    public String lotteryNetworkErrorString;

    @SerializedName("live_lottery_title")
    public String lotteryString;

    @SerializedName("show_first_reddot")
    public int redDotEnabled;

    @SerializedName("live_lottery_rejected_message")
    public String rejectedMessageString;

    @SerializedName("live_lottery_rejected_title")
    public String rejectedTitleString;

    @SerializedName("live_lottery_reviewing_toast")
    public String reviewingString;

    @SerializedName("live_lottery_toolbar_icon_url")
    public String toolbarIconUrl;

    public static class a {

        @SerializedName("live_life_lottery_anchor_result")
        public String anchorLotteryDetailUri;

        @SerializedName("live_life_lottery_audience_result")
        public String audienceLotteryResultUri;

        @SerializedName("live_life_lottery_audience_candidate_page")
        public String audienceLotteryWaitUri;

        public a() {
        }
    }

    public m0() {
    }
}
