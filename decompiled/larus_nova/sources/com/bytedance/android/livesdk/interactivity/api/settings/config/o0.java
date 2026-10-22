package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class o0 {

    @SerializedName("check_layout_while_update_data")
    public boolean checkLayoutWhileUpdateData;

    @SerializedName("interactivity_monitor_helper_opt")
    public boolean interactivityMonitorHelperOpt;

    @SerializedName("loop_check_computing_layout")
    public boolean loopCheckComputingLayout;

    @SerializedName("loop_max_check_times")
    public int loopMaxTimes;

    @SerializedName("post_update_during_layout")
    public boolean postUpdateDuringLayout;

    public o0() {
        this.interactivityMonitorHelperOpt = false;
        this.checkLayoutWhileUpdateData = true;
        this.postUpdateDuringLayout = true;
        this.loopCheckComputingLayout = true;
        this.loopMaxTimes = 20;
    }
}
