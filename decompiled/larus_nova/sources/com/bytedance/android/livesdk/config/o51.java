package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class o51 {

    @SerializedName("disable_backend_monitor")
    public boolean disable_backend_monitor;

    @SerializedName("disable_interaction_load_duration")
    public boolean disable_interaction_load_duration;

    @SerializedName("disable_mk")
    public boolean disable_mk;

    @SerializedName("disable_pix_shakehandle_widget")
    public boolean disable_pix_shakehandle_widget;

    @SerializedName("disable_rank_duration_monitor")
    public boolean disable_rank_duration_monitor;

    @SerializedName("disable_room_apm_stats")
    public boolean disable_room_apm_stats;

    @SerializedName("disable_room_format_log")
    public boolean disable_room_format_log;

    @SerializedName("disable_room_setting_observer")
    public boolean disable_room_setting_observer;

    @SerializedName("disable_widget_observer")
    public boolean disable_widget_observer;

    @SerializedName("live_log_delete_opt")
    public boolean liveLogDeleteOpt;

    public o51() {
        this.disable_mk = false;
        this.disable_room_setting_observer = false;
        this.disable_room_apm_stats = false;
        this.disable_interaction_load_duration = false;
        this.disable_rank_duration_monitor = false;
        this.disable_widget_observer = false;
        this.disable_pix_shakehandle_widget = false;
        this.disable_room_format_log = false;
        this.disable_backend_monitor = false;
        this.liveLogDeleteOpt = false;
    }
}
