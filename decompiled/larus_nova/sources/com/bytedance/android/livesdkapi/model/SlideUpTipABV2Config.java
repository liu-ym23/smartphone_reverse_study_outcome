package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class SlideUpTipABV2Config {

    @SerializedName("live_room_guide_auto_dismiss_time")
    public int cancelTime;

    @SerializedName("live_room_guide_delay_time")
    public int delaySeconds;

    @SerializedName("live_room_guide_enable_click_dismiss")
    public boolean enableClickDismiss;

    @SerializedName("live_room_guide_show_count")
    public int maxTimes;

    public SlideUpTipABV2Config() {
    }
}
