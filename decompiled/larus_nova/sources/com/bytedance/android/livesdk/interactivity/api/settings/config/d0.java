package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class d0 {

    @SerializedName("heat_strategy_enable")
    public boolean heatStrategyEnable;

    @SerializedName("message_valid_time")
    public int messageValidTime;

    @SerializedName("unexpeceted_message_report_enable")
    public boolean reportUnexpectedMessage;

    public d0() {
        this.heatStrategyEnable = false;
        this.messageValidTime = 10;
        this.reportUnexpectedMessage = false;
    }
}
