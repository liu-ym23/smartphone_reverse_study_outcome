package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveBackToPreRoomSetting {

    @SerializedName("delay_time")
    public int delayTime;

    @SerializedName("enable_type")
    public int enableType;

    @SerializedName("total_time")
    public int totalTime;

    public boolean enableHourRank() {
        int r100 = this.enableType;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean enableRoomNotify() {
        int r100 = this.enableType;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 3) goto L8;
        return false;
    }

    public LiveBackToPreRoomSetting() {
        this.totalTime = 60;
        this.delayTime = 3;
    }
}
