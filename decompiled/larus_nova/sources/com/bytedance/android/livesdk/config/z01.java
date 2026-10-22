package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class z01 {

    @SerializedName("consume_timer_push")
    public boolean consumeTimerPush;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("fatal_rollback_limit")
    public int fatalRollbackLimit;

    @SerializedName("intercept_all_old_version")
    public boolean interceptOldVersion;

    @SerializedName("monitor_version_rollback")
    public boolean monitorVersionRollback;

    @SerializedName("monitor_zero_version")
    public boolean monitorZeroVersion;

    @SerializedName("use_join_channel_list")
    public boolean useJoinChannelList;

    @SerializedName("zero_version_limit")
    public int zeroVersionLimit;

    public z01() {
        this.enable = true;
        this.interceptOldVersion = true;
        this.fatalRollbackLimit = 5;
        this.zeroVersionLimit = 10;
        this.monitorVersionRollback = true;
        this.monitorZeroVersion = true;
        this.useJoinChannelList = true;
        this.consumeTimerPush = true;
    }
}
