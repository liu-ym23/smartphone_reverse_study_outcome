package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class WindowFpsConfig {

    @SerializedName("activity_fps")
    public int mActivityFps;

    @SerializedName("half_fps_commerce")
    public int mCommerceHalfFps;

    @SerializedName("duration_anim_delay")
    public long mDurationAnimDelay;

    @SerializedName("duration_enter_room_delay")
    public long mDurationEnterRoomDelay;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("enable_full_disable_draw")
    public boolean mEnableFullDisableDraw;

    @SerializedName("half_fps_local_life")
    public int mLocalLifeHalfFps;

    public WindowFpsConfig() {
        this.mEnable = false;
        this.mEnableFullDisableDraw = true;
        this.mCommerceHalfFps = -1;
        this.mLocalLifeHalfFps = -1;
        this.mActivityFps = -1;
        this.mDurationEnterRoomDelay = -1;
        this.mDurationAnimDelay = -1;
    }
}
