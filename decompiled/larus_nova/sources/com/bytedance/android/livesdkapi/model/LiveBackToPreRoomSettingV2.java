package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveBackToPreRoomSettingV2 {
    public static int ENABLE_FIXED = 4;
    public static int ENABLE_ONLY_BACK_PRESS = 3;
    public static int ENABLE_ONLY_COUNT_DOWN = 2;

    @SerializedName("delay_time")
    public int delayTime;

    @SerializedName("enable_type")
    public int enableType;

    @SerializedName("total_time")
    public int totalTime;

    public boolean enable() {
        if (this.enableType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean enableFixed() {
        if (this.enableType != ENABLE_FIXED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean enableOnlyBackPress() {
        if (this.enableType != ENABLE_ONLY_BACK_PRESS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean enableOnlyDismiss() {
        if (this.enableType != ENABLE_ONLY_COUNT_DOWN) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveBackToPreRoomSettingV2() {
        this.totalTime = 60;
        this.delayTime = 3;
        this.enableType = 1;
    }
}
