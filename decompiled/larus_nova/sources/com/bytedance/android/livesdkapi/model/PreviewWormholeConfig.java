package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class PreviewWormholeConfig {

    @SerializedName("ai_enable")
    public boolean aiEnable;

    @SerializedName("disable_enter_from_list")
    public List<String> disableEnterFromList;

    @SerializedName("enable_fix_video_task_params_return")
    public boolean enableFixVideoTaskParamsReturn;

    @SerializedName("enable_log_video_task_params_return")
    public boolean enableLogVideoTaskParamsReturn;

    @SerializedName("opt_remove_feature_listener_enable_on_exit_wormhole")
    public boolean enableRemoveFeatureListenerOnExitWormhole;

    @SerializedName("opt_remove_feature_listener_enable_on_enter_current_room")
    public boolean enableRemoveFeatureListeneronEnterCurrentRoom;

    @SerializedName("limit_enter_from_with_position_list")
    public List<String> limitEnterFromToPositionList;

    @SerializedName("disable_ad_stream_limit")
    public boolean mDisableAdStreamLimit;

    @SerializedName("disable_bandwidth_limit_tab_list")
    public List<String> mDisableBandwidthLimitTabList;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("enable_bandwidth_limit")
    public boolean mEnableBandwidthLimit;

    @SerializedName("enter_delay")
    public long mEnterDelay;

    @SerializedName("limit_end_time")
    public String mLimitEndTime;

    @SerializedName("limit_start_time")
    public String mLimitStartTime;

    @SerializedName("stream_limit_end_time")
    public int mStreamLimitEndTime;

    @SerializedName("stream_limit_start_time")
    public int mStreamLimitStartTime;

    @SerializedName("support_room_type")
    public int mSupportRoomType;

    @SerializedName("survive_time")
    public long mSurviveTime;

    @SerializedName("survive_time_in_limit_time")
    public long mSurviveTimeInLimitTime;

    @SerializedName("type")
    public int mType;

    @SerializedName("refresh_feature_list")
    public List<String> refreshFeatureList;

    public PreviewWormholeConfig() {
        this.aiEnable = true;
        this.mDisableBandwidthLimitTabList = null;
        this.mLimitStartTime = "";
        this.mLimitEndTime = "";
        this.mStreamLimitStartTime = 0;
        this.mStreamLimitEndTime = 0;
        this.mDisableAdStreamLimit = false;
        this.refreshFeatureList = null;
        this.limitEnterFromToPositionList = null;
        this.enableFixVideoTaskParamsReturn = false;
        this.enableLogVideoTaskParamsReturn = false;
        this.disableEnterFromList = null;
        this.enableRemoveFeatureListeneronEnterCurrentRoom = true;
        this.enableRemoveFeatureListenerOnExitWormhole = false;
    }
}
