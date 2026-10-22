package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class k0 {

    @SerializedName("enter_room_acu_cold_threshold")
    public int acuColdThreshold;

    @SerializedName("enter_room_acu_hot_threshold")
    public int acuHotThreshold;

    @SerializedName("chat_count_duration")
    public int chatCountDuration;

    @SerializedName("message_cold_status_count_threshold")
    public int coldStatusChatCountThreshold;

    @SerializedName("heat_state_mock_value")
    public int heatStateMockValue;

    @SerializedName("message_heat_status_calculate_interval")
    public int heatStatusCalculateInterval;

    @SerializedName("message_heat_status_change_threshold")
    public int heatStatusChangeThreshold;

    @SerializedName("message_hot_status_chat_count_threshold")
    public int hotStatusChatCountThreshold;

    @SerializedName("public_screen_heat_enable")
    public boolean publicScreenHeatEnable;

    public k0() {
        this.publicScreenHeatEnable = false;
        this.acuHotThreshold = 10000;
        this.acuColdThreshold = 100;
        this.chatCountDuration = 15;
        this.heatStatusCalculateInterval = 5;
        this.hotStatusChatCountThreshold = 75;
        this.coldStatusChatCountThreshold = 3;
        this.heatStatusChangeThreshold = 3;
        this.heatStateMockValue = 0;
    }
}
