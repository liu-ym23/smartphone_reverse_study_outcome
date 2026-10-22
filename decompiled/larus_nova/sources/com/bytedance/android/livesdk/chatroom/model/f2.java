package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class f2 {

    @SerializedName("highlight_header_time")
    private long highlightHeaderTime;

    @SerializedName("hour_rank")
    private int hourRank;

    @SerializedName("rank_list_bottom_button_text")
    private String rankListBottomButtonText;

    @SerializedName("region_enable")
    private boolean regionEnable;

    @SerializedName("region_type")
    private int regionType;

    @SerializedName("reward_bubble_text")
    private String rewardBubbleText;

    @SerializedName("reward_divider_text")
    private String rewardDividerText;

    public f2() {
    }

    public f2(int r100) {
        this.regionEnable = true;
    }
}
