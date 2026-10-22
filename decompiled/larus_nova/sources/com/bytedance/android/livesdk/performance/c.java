package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    @SerializedName("animation_hide_list_common")
    @Nullable
    public List<String> animationHideListCommon;

    @SerializedName("down_limit_score")
    public float downLimitScore;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("enable_alogger_degrade")
    public boolean enableALoggerDegrade;

    @SerializedName("enable_community_opt")
    public boolean enableCommunityOpt;

    @SerializedName("enable_device_degrade_badly")
    public boolean enableDeviceDegradeBadly;

    @SerializedName("enable_device_degrade_common")
    public boolean enableDeviceDegradeCommon;

    @SerializedName("enable_interaction_monitor_degrade")
    public boolean enableInteractionMonitorDegrade;

    @SerializedName("enable_local_debug")
    public boolean enableLocalDebug;

    @SerializedName("enable_local_performance_debug")
    public boolean enableLocalPerformanceDebug;

    @SerializedName("enable_local_performance_level")
    public int enableLocalPerformanceLevel;

    @SerializedName("enable_move_sampling_degrade")
    public boolean enableMoveSamplingDegrade;

    @SerializedName("enable_perf_message")
    public boolean enablePerfMessage;

    @SerializedName("enable_recover_by_performance")
    public boolean enableRecoverByPerformance;

    @SerializedName("enable_revenue_opt")
    public boolean enableRevenueOpt;

    @SerializedName("force_enable")
    public boolean forceEnable;

    @SerializedName("interaction_delay_time_limit_badly")
    public long interactionDelayTimeLimitBadly;

    @SerializedName("interaction_delay_time_limit_common")
    public long interactionDelayTimeLimitCommon;

    @SerializedName("up_limit_score")
    public float upLimitScore;

    @SerializedName("widget_hide_list_badly")
    @Nullable
    public List<String> widgetHideListBadly;

    @SerializedName("widget_hide_list_common")
    @Nullable
    public List<String> widgetHideListCommon;

    public c() {
        this.enable = false;
        this.upLimitScore = 7.15f;
        this.downLimitScore = 0.0f;
        this.forceEnable = false;
        this.enableLocalDebug = false;
        this.enableLocalPerformanceDebug = false;
        this.enableLocalPerformanceLevel = 0;
        this.enableDeviceDegradeCommon = false;
        this.widgetHideListCommon = new ArrayList();
        this.animationHideListCommon = new ArrayList(Arrays.asList(new String[]{"animation_rank", "animation_gift_tray", "animation_merge_message", "animation_gift_panel"}));
        this.interactionDelayTimeLimitCommon = 1000;
        this.interactionDelayTimeLimitBadly = 3000;
        this.enableDeviceDegradeBadly = false;
        this.widgetHideListBadly = new ArrayList(Arrays.asList(new String[]{"widget_rank", "widget_vertical_rank", "widget_gift_tray", "widget_big_gift", "widget_merge_message"}));
        this.enableRevenueOpt = true;
        this.enableCommunityOpt = true;
        this.enablePerfMessage = false;
        this.enableALoggerDegrade = false;
        this.enableInteractionMonitorDegrade = false;
        this.enableMoveSamplingDegrade = false;
        this.enableRecoverByPerformance = true;
    }
}
