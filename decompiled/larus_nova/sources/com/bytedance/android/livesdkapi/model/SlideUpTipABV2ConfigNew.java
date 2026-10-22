package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class SlideUpTipABV2ConfigNew {

    @SerializedName("live_room_guide_enable_click_dismiss")
    public boolean enableClickDismiss;

    @SerializedName("live_room_guide_new_delay_seconds")
    public int newDelaySeconds;

    @SerializedName("live_room_guide_new_dismiss_seconds")
    public int newDismissSeconds;

    @SerializedName("live_room_guide_new_max_time")
    public int newMaxTimes;

    @SerializedName("live_room_guide_refresh_days")
    public int refreshDays;

    public SlideUpTipABV2ConfigNew() {
        this.newMaxTimes = 3;
        this.refreshDays = 7;
        this.newDelaySeconds = 3;
        this.newDismissSeconds = 7;
        this.enableClickDismiss = true;
    }
}
