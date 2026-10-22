package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerBlackScreenMonitorConfig;", "", "blackScreenNormalReleaseCheckTime", "", "blackScreenKeepAliveInterval", "", "blackScreenMaxKeepAliveDetectCount", "(IJJ)V", "getBlackScreenKeepAliveInterval", "()J", "getBlackScreenMaxKeepAliveDetectCount", "getBlackScreenNormalReleaseCheckTime", "()I", "checkBeforeStopOrRelease", "", "getCheckBeforeStopOrRelease", "()Z", "checkInPause", "getCheckInPause", "checkInStopOrRelease", "getCheckInStopOrRelease", "checkedOnSceneChange", "getCheckedOnSceneChange", "noFirstFrameCheckThreshold", "getNoFirstFrameCheckThreshold", "skipCheckWhiteList", "", "", "getSkipCheckWhiteList", "()Ljava/util/List;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerBlackScreenMonitorConfig {

    @SerializedName("black_screen_keep_alive_interval_secs")
    private final long blackScreenKeepAliveInterval;

    @SerializedName("black_screen_max_keep_alive_detect_count")
    private final long blackScreenMaxKeepAliveDetectCount;

    @SerializedName("black_screen_normal_release_check_time_millis")
    private final int blackScreenNormalReleaseCheckTime;

    @SerializedName("check_before_stop_or_release")
    private final boolean checkBeforeStopOrRelease;

    @SerializedName("check_in_pause")
    private final boolean checkInPause;

    @SerializedName("check_in_stop_or_release")
    private final boolean checkInStopOrRelease;

    @SerializedName("checked_on_scene_changed")
    private final boolean checkedOnSceneChange;

    @SerializedName("no_first_frame_check_threshold")
    private final long noFirstFrameCheckThreshold;

    @SerializedName("skip_check_white_list")
    private final List<String> skipCheckWhiteList;

    public PlayerBlackScreenMonitorConfig() {
        this(0, 0, 0, 7, null);
    }

    public final long getBlackScreenKeepAliveInterval() {
        return this.blackScreenKeepAliveInterval;
    }

    public final long getBlackScreenMaxKeepAliveDetectCount() {
        return this.blackScreenMaxKeepAliveDetectCount;
    }

    public final int getBlackScreenNormalReleaseCheckTime() {
        return this.blackScreenNormalReleaseCheckTime;
    }

    public final boolean getCheckBeforeStopOrRelease() {
        return this.checkBeforeStopOrRelease;
    }

    public final boolean getCheckInPause() {
        return this.checkInPause;
    }

    public final boolean getCheckInStopOrRelease() {
        return this.checkInStopOrRelease;
    }

    public final boolean getCheckedOnSceneChange() {
        return this.checkedOnSceneChange;
    }

    public final long getNoFirstFrameCheckThreshold() {
        return this.noFirstFrameCheckThreshold;
    }

    public final List<String> getSkipCheckWhiteList() {
        return this.skipCheckWhiteList;
    }

    public PlayerBlackScreenMonitorConfig(int r100, long r101, long r102) {
        this.blackScreenNormalReleaseCheckTime = r100;
        this.blackScreenKeepAliveInterval = r101;
        this.blackScreenMaxKeepAliveDetectCount = r102;
        this.checkInStopOrRelease = true;
        this.noFirstFrameCheckThreshold = 1000;
        this.checkedOnSceneChange = true;
        this.skipCheckWhiteList = new ArrayList();
        this.checkInPause = true;
    }

    public /* synthetic */ PlayerBlackScreenMonitorConfig(int r100, long r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1000;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 5;
    L8:
        long r105 = r101;
        if ((r103 & 4) == 0) goto L11;
        r102 = 60;
    L11:
        int r106 = r100;
        this(r106, r105, r102);
    }
}
