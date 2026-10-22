package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveWatchRoomLimitSetting {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("limit_num")
    public long limitNum;

    @SerializedName("show_num")
    public String showNum;

    public LiveWatchRoomLimitSetting() {
        this.enable = true;
        this.limitNum = 1000000;
        this.showNum = "100";
    }
}
