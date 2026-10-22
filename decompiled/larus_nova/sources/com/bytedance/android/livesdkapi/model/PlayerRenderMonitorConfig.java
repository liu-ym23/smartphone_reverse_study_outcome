package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0016\u0010!\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerRenderMonitorConfig;", "", "()V", "centerInsideShitThreshold", "", "getCenterInsideShitThreshold", "()F", "checkDelayTime", "", "getCheckDelayTime", "()I", "commonShiftThreshold", "getCommonShiftThreshold", "enableScreenJumpCheck", "", "getEnableScreenJumpCheck", "()Z", "enableShiftCheck", "getEnableShiftCheck", "enableStretchCheck", "getEnableStretchCheck", "mockStretch", "getMockStretch", "screenJumpBlackList", "", "getScreenJumpBlackList", "()Ljava/lang/String;", "setScreenJumpBlackList", "(Ljava/lang/String;)V", "screenJumpThreshold", "getScreenJumpThreshold", "screenJumpVS", "getScreenJumpVS", "stretchThreshold", "getStretchThreshold", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerRenderMonitorConfig {

    @SerializedName("center_inside_shift_threshold")
    private final float centerInsideShitThreshold;

    @SerializedName("check_delay_time")
    private final int checkDelayTime;

    @SerializedName("common_shift_threshold")
    private final float commonShiftThreshold;

    @SerializedName("enable_screen_jump_check")
    private final boolean enableScreenJumpCheck;

    @SerializedName("enable_shift_check")
    private final boolean enableShiftCheck;

    @SerializedName("enable_stretch_check")
    private final boolean enableStretchCheck;

    @SerializedName("mock_stretch")
    private final boolean mockStretch;

    @SerializedName("screenJumpBlackList")
    private String screenJumpBlackList;

    @SerializedName("screen_jump_check_threshold")
    private final int screenJumpThreshold;

    @SerializedName("screen_jump_vs")
    private final boolean screenJumpVS;

    @SerializedName("stretch_threshold")
    private final float stretchThreshold;

    public PlayerRenderMonitorConfig() {
        this.centerInsideShitThreshold = 0.9f;
        this.commonShiftThreshold = 0.8f;
        this.stretchThreshold = 0.01f;
        this.checkDelayTime = 3;
        this.enableStretchCheck = true;
        this.screenJumpThreshold = 5;
        this.screenJumpBlackList = "homepage_follow-live_cover";
    }

    public final float getCenterInsideShitThreshold() {
        return this.centerInsideShitThreshold;
    }

    public final int getCheckDelayTime() {
        return this.checkDelayTime;
    }

    public final float getCommonShiftThreshold() {
        return this.commonShiftThreshold;
    }

    public final boolean getEnableScreenJumpCheck() {
        return this.enableScreenJumpCheck;
    }

    public final boolean getEnableShiftCheck() {
        return this.enableShiftCheck;
    }

    public final boolean getEnableStretchCheck() {
        return this.enableStretchCheck;
    }

    public final boolean getMockStretch() {
        return this.mockStretch;
    }

    public final String getScreenJumpBlackList() {
        return this.screenJumpBlackList;
    }

    public final int getScreenJumpThreshold() {
        return this.screenJumpThreshold;
    }

    public final boolean getScreenJumpVS() {
        return this.screenJumpVS;
    }

    public final float getStretchThreshold() {
        return this.stretchThreshold;
    }

    public final void setScreenJumpBlackList(String r100) {
        this.screenJumpBlackList = r100;
    }
}
