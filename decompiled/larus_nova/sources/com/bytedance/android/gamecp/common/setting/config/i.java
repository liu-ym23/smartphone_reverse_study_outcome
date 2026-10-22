package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.livehostapi.business.IHostShare;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/i;", "", "", "enable", "Z", "getEnable", "()Z", "enableMoveTask", "getEnableMoveTask", "", "screenShotInterval", "J", "getScreenShotInterval", "()J", "", "shareLynxSchema", "Ljava/lang/String;", "getShareLynxSchema", "()Ljava/lang/String;", "hwCameraPath", "getHwCameraPath", "", "cameraSnapShotKeyWords", "Ljava/util/List;", "getCameraSnapShotKeyWords", "()Ljava/util/List;", "screenShotKeyWords", "getScreenShotKeyWords", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("camera_snapshot_keywords")
    private final List<String> cameraSnapShotKeyWords;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_move_task")
    private final boolean enableMoveTask;

    @SerializedName("hw_camera_path")
    private final String hwCameraPath;

    @SerializedName("screen_shot_interval")
    private final long screenShotInterval;

    @SerializedName("screen_shot_keywords")
    private final List<String> screenShotKeyWords;

    @SerializedName("share_lynx_schema")
    private final String shareLynxSchema;

    public i() {
        this.enable = true;
        this.enableMoveTask = true;
        this.screenShotInterval = 5000;
        this.shareLynxSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Finstant_play_douyin%2Fpages%2Fshare_picture%2Ftemplate.js%3Fbusiness_type%3Dgamecp_group&bdhm_bid=instant_play&bdhm_pid=instant_play_share_picture&enable_latch=1&mix_container_type=annie";
        this.hwCameraPath = "/dcim/camera/";
        this.cameraSnapShotKeyWords = CollectionsKt.listOf("tmp.png");
        this.screenShotKeyWords = CollectionsKt.listOf(new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截屏录屏"});
    }
}
