package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b&\b\u0007\u0018\u0000 02\u00020\u0001:\u00010Bµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0016\u0010&\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0016\u0010(\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerShareConfig;", "", "enable", "", "shareOptimizerStrategy", "", "enableOptimizedShareRoute", "", "", "enableShareOptimizeStrategyScenes", "delayStopOrReleaseInterval", "", "resumeWithLastFrameBitmap", "disableShareToOtherScenes", "disableShareFromOtherScenes", "smoothLeaveRoom", "disableDelayStopOrReleaseScenes", "enableDirectStopWhenStream", "lynxSharePlayerAdapter", "checkShareSceneEnable", "clientDynamicUpdateInPool", "(ZILjava/util/List;Ljava/util/List;JZLjava/util/List;Ljava/util/List;ZLjava/util/List;ZZZZ)V", "getCheckShareSceneEnable", "()Z", "getClientDynamicUpdateInPool", "getDelayStopOrReleaseInterval", "()J", "getDisableDelayStopOrReleaseScenes", "()Ljava/util/List;", "getDisableShareFromOtherScenes", "getDisableShareToOtherScenes", "getEnable", "getEnableDirectStopWhenStream", "getEnableOptimizedShareRoute", "getEnableShareOptimizeStrategyScenes", "jumpSameStreamScenes", "getJumpSameStreamScenes", "getLynxSharePlayerAdapter", "optimizeDelayStop", "getOptimizeDelayStop", "previewSceneReleaseOpt", "getPreviewSceneReleaseOpt", "releaseShareFailedPlayer", "getReleaseShareFailedPlayer", "getResumeWithLastFrameBitmap", "getShareOptimizerStrategy", "()I", "getSmoothLeaveRoom", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerShareConfig {
    public static final Companion Companion = null;
    public static final int SHARE_FIRST_FRAME = 1;
    public static final int SHARE_NO_LIMIT = 2;
    public static final int SHARE_PLAYING = 0;

    @SerializedName("check_share_scene_enable")
    private final boolean checkShareSceneEnable;

    @SerializedName("client_dynamic_update_in_pool")
    private final boolean clientDynamicUpdateInPool;

    @SerializedName("delay_stop_or_release_interval")
    private final long delayStopOrReleaseInterval;

    @SerializedName("disable_delay_stop_or_release_scenes")
    private final List<String> disableDelayStopOrReleaseScenes;

    @SerializedName("disable_share_from_other_scenes")
    private final List<String> disableShareFromOtherScenes;

    @SerializedName("disable_share_to_other_scenes")
    private final List<String> disableShareToOtherScenes;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_direct_stop_when_stream")
    private final boolean enableDirectStopWhenStream;

    @SerializedName("enable_optimized_share_route")
    private final List<String> enableOptimizedShareRoute;

    @SerializedName("enable_share_optimize_strategy_scene")
    private final List<String> enableShareOptimizeStrategyScenes;

    @SerializedName("jump_same_stream_scene")
    private final List<String> jumpSameStreamScenes;

    @SerializedName("lynx_share_player_adapter")
    private final boolean lynxSharePlayerAdapter;

    @SerializedName("optimize_delay_stop")
    private final boolean optimizeDelayStop;

    @SerializedName("preview_scene_release_opt")
    private final boolean previewSceneReleaseOpt;

    @SerializedName("release_share_failed_player")
    private final boolean releaseShareFailedPlayer;

    @SerializedName("resume_with_last_frame_bitmap")
    private final boolean resumeWithLastFrameBitmap;

    @SerializedName("share_optimize_strategy")
    private final int shareOptimizerStrategy;

    @SerializedName("smooth_leave_room")
    private final boolean smoothLeaveRoom;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerShareConfig$Companion;", "", "()V", "SHARE_FIRST_FRAME", "", "SHARE_NO_LIMIT", "SHARE_PLAYING", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PlayerShareConfig() {
        this(false, 0, null, null, 0, false, null, null, false, null, false, false, false, false, 16383, null);
    }

    public final boolean getCheckShareSceneEnable() {
        return this.checkShareSceneEnable;
    }

    public final boolean getClientDynamicUpdateInPool() {
        return this.clientDynamicUpdateInPool;
    }

    public final long getDelayStopOrReleaseInterval() {
        return this.delayStopOrReleaseInterval;
    }

    public final List<String> getDisableDelayStopOrReleaseScenes() {
        return this.disableDelayStopOrReleaseScenes;
    }

    public final List<String> getDisableShareFromOtherScenes() {
        return this.disableShareFromOtherScenes;
    }

    public final List<String> getDisableShareToOtherScenes() {
        return this.disableShareToOtherScenes;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableDirectStopWhenStream() {
        return this.enableDirectStopWhenStream;
    }

    public final List<String> getEnableOptimizedShareRoute() {
        return this.enableOptimizedShareRoute;
    }

    public final List<String> getEnableShareOptimizeStrategyScenes() {
        return this.enableShareOptimizeStrategyScenes;
    }

    public final List<String> getJumpSameStreamScenes() {
        return this.jumpSameStreamScenes;
    }

    public final boolean getLynxSharePlayerAdapter() {
        return this.lynxSharePlayerAdapter;
    }

    public final boolean getOptimizeDelayStop() {
        return this.optimizeDelayStop;
    }

    public final boolean getPreviewSceneReleaseOpt() {
        return this.previewSceneReleaseOpt;
    }

    public final boolean getReleaseShareFailedPlayer() {
        return this.releaseShareFailedPlayer;
    }

    public final boolean getResumeWithLastFrameBitmap() {
        return this.resumeWithLastFrameBitmap;
    }

    public final int getShareOptimizerStrategy() {
        return this.shareOptimizerStrategy;
    }

    public final boolean getSmoothLeaveRoom() {
        return this.smoothLeaveRoom;
    }

    public PlayerShareConfig(boolean r100, int r101, List<String> r102, List<String> r103, long r110, boolean r111, List<String> r112, List<String> r113, boolean r114, List<String> r115, boolean r116, boolean r117, boolean r118, boolean r210) {
        Intrinsics.checkNotNullParameter(r102, "enableOptimizedShareRoute");
        Intrinsics.checkNotNullParameter(r103, "enableShareOptimizeStrategyScenes");
        this.enable = r100;
        this.shareOptimizerStrategy = r101;
        this.enableOptimizedShareRoute = r102;
        this.enableShareOptimizeStrategyScenes = r103;
        this.delayStopOrReleaseInterval = r110;
        this.resumeWithLastFrameBitmap = r111;
        this.disableShareToOtherScenes = r112;
        this.disableShareFromOtherScenes = r113;
        this.smoothLeaveRoom = r114;
        this.disableDelayStopOrReleaseScenes = r115;
        this.enableDirectStopWhenStream = r116;
        this.lynxSharePlayerAdapter = r117;
        this.checkShareSceneEnable = r118;
        this.clientDynamicUpdateInPool = r210;
        this.jumpSameStreamScenes = CollectionsKt.arrayListOf(new String[]{LivePlayerScene.INSTANCE.getPREVIEW_EXTRA_RENDER().getScene()});
        this.releaseShareFailedPlayer = true;
    }

    public /* synthetic */ PlayerShareConfig(boolean r110, int r111, List r112, List r210, long r211, boolean r212, List r213, List r214, boolean r215, List r216, boolean r217, boolean r218, boolean r310, boolean r311, int r312, DefaultConstructorMarker r313) {
        boolean r100 = true;
        if ((r312 & 1) == 0) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = false;
        if ((r312 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r312 & 4) == 0) goto L13;
        List r104 = new ArrayList();
    L15:
        if ((r312 & 8) == 0) goto L17;
        List r105 = new ArrayList();
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r106 = 100;
    L23:
        if ((r312 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r312 & 64) == 0) goto L29;
        List r113 = new ArrayList();
    L31:
        if ((r312 & 128) == 0) goto L33;
        List r114 = new ArrayList();
    L35:
        if ((r312 & 256) == 0) goto L37;
        boolean r115 = false;
    L39:
        if ((r312 & 512) == 0) goto L41;
        List r116 = new ArrayList();
    L43:
        if ((r312 & 1024) != 0) goto L47;
        r100 = r217;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        boolean r117 = false;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        boolean r118 = false;
    L55:
        if ((r312 & 8192) != 0) goto L58;
        r102 = r311;
    L58:
        this(r101, r103, r104, r105, r106, r107, r113, r114, r115, r116, r100, r117, r118, r102);
        return;
    L53:
        r118 = r310;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r107 = r212;
        goto L27
    L21:
        r106 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
