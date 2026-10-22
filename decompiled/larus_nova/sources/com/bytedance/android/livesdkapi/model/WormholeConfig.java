package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class WormholeConfig {

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("enable_no_stream_check")
    public boolean mEnableNoStreamCheck;

    @SerializedName("enter_delay")
    public long mEnterDelay;

    @SerializedName("enter_success_limit")
    public boolean mEnterSuccessLimit;

    @SerializedName("first_frame_limit")
    public boolean mFistFrameLimit;

    @SerializedName("good_net_grade")
    public List<Integer> mGoodNetGrade;

    @SerializedName("no_stream_check_delay_time")
    public long mNoStreamCheckDelayTime;

    @SerializedName("no_stream_check_scene")
    public List<String> mNoStreamCheckScene;

    @SerializedName("stream_limit_end_time")
    public int mStreamLimitEndTime;

    @SerializedName("stream_limit_start_time")
    public int mStreamLimitStartTime;

    @SerializedName("support_type")
    public int mSupportType;

    @SerializedName("survive_time")
    public long mSurviveTime;

    @SerializedName("use_ai")
    public boolean mUseAI;

    @SerializedName("use_abr")
    public boolean mUseAbr;

    @SerializedName("widget_load_limit")
    public boolean mWidgetLoadLimit;

    public WormholeConfig() {
        this.mStreamLimitStartTime = 0;
        this.mStreamLimitEndTime = 0;
        this.mFistFrameLimit = false;
        this.mEnterSuccessLimit = false;
        this.mWidgetLoadLimit = false;
        this.mEnableNoStreamCheck = false;
        this.mNoStreamCheckDelayTime = 0;
        this.mNoStreamCheckScene = new ArrayList();
        this.mGoodNetGrade = new ArrayList(Arrays.asList(new Integer[]{7, 8}));
    }
}
