package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class BroadcastRecordTipConfig {

    @SerializedName("long_press_tip_time")
    public int longPressTime;

    @SerializedName("record_popup_time")
    public int recordPopupTime;

    public BroadcastRecordTipConfig() {
        this.longPressTime = 300;
        this.recordPopupTime = 600;
    }
}
