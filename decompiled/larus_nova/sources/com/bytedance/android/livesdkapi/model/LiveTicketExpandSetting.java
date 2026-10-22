package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveTicketExpandSetting {

    @SerializedName("enter_room_daily_show_limit")
    public int enterRoomDailyShowLimit;

    @SerializedName("enter_room_total_show_limit")
    public int enterRoomTotalShowLimit;

    @SerializedName("exit_room_daily_show_limit")
    public int exitRoomDailyShowLimit;

    @SerializedName("exit_room_total_show_limit")
    public int exitRoomTotalShowLimit;

    @SerializedName("frequency_control_enable")
    public boolean freqControlEnable;

    public LiveTicketExpandSetting() {
        this.enterRoomDailyShowLimit = 3;
        this.enterRoomTotalShowLimit = 7;
        this.exitRoomDailyShowLimit = 3;
        this.exitRoomTotalShowLimit = 7;
    }
}
