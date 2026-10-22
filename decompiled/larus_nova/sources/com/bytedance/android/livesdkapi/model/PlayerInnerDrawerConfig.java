package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b0\b\u0007\u0018\u00002\u00020\u0001Bë\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\"R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010\"R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010\"R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010\"R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u0016\u00109\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u001e\u0010\u001b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010\"R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\u0016\u0010?\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001eR\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010\"R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010\"¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerInnerDrawerConfig;", "", "stopPreviewSharePlayer", "", "forceRemoveStaticFrame", "forceRemoveStaticFrameDelayTime", "", "fixPaidLifeCycleError", "livePlayerWidgetResumeFix", "livePlayerViewFitVrLandscape", "livePlayerSearchResumeBlackScreenFix", "lynxSharePlayerAdapter", "playerReleaseCheck", "optimizePullStreamTask", "optimizeConfig", "fixPlayerWidgetDatacenterCrash", "optUpdateLiveRequestQuality", "vrRecenterEnable", "ugcPublicScreenHeightOptimize", "fixPhoneCallUnmuteWhenLostFocus", "optShareOuterFloatWindowResolutionStrategy", "", "forceRemoveStaticFrameV2", "fixSharePlayerMixedAudio", "fixPlayerViewClientAbnormal", "disableGonePlayerViewWhenScrolled", "gameResolutionOptimize", "platformLeakOptimize", "(ZZJZZZZZZZZZZZZZIZZZZZZ)V", "getDisableGonePlayerViewWhenScrolled", "()Z", "getFixPaidLifeCycleError", "getFixPhoneCallUnmuteWhenLostFocus", "setFixPhoneCallUnmuteWhenLostFocus", "(Z)V", "getFixPlayerViewClientAbnormal", "getFixPlayerWidgetDatacenterCrash", "setFixPlayerWidgetDatacenterCrash", "getFixSharePlayerMixedAudio", "getForceRemoveStaticFrame", "getForceRemoveStaticFrameDelayTime", "()J", "getForceRemoveStaticFrameV2", "getGameResolutionOptimize", "setGameResolutionOptimize", "getLivePlayerSearchResumeBlackScreenFix", "getLivePlayerViewFitVrLandscape", "getLivePlayerWidgetResumeFix", "getLynxSharePlayerAdapter", "getOptShareOuterFloatWindowResolutionStrategy", "()I", "setOptShareOuterFloatWindowResolutionStrategy", "(I)V", "getOptUpdateLiveRequestQuality", "setOptUpdateLiveRequestQuality", "getOptimizeConfig", "getOptimizePullStreamTask", "phoneRingCallMixedFix", "getPhoneRingCallMixedFix", "getPlatformLeakOptimize", "setPlatformLeakOptimize", "getPlayerReleaseCheck", "getStopPreviewSharePlayer", "systemFloatWindowBlackFix", "getSystemFloatWindowBlackFix", "getUgcPublicScreenHeightOptimize", "setUgcPublicScreenHeightOptimize", "getVrRecenterEnable", "setVrRecenterEnable", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerInnerDrawerConfig {

    @SerializedName("disable_gone_player_view_when_scrolled")
    private final boolean disableGonePlayerViewWhenScrolled;

    @SerializedName("fix_paid_lifecycle_error")
    private final boolean fixPaidLifeCycleError;

    @SerializedName("fix_phone_call_unmute_when_lost_focus")
    private boolean fixPhoneCallUnmuteWhenLostFocus;

    @SerializedName("fix_player_view_client_abnormal")
    private final boolean fixPlayerViewClientAbnormal;

    @SerializedName("fix_player_widget_datacenter_crash")
    private boolean fixPlayerWidgetDatacenterCrash;

    @SerializedName("fix_share_player_mixed_audio")
    private final boolean fixSharePlayerMixedAudio;

    @SerializedName("force_remove_static_frame")
    private final boolean forceRemoveStaticFrame;

    @SerializedName("force_remove_static_frame_delay_time")
    private final long forceRemoveStaticFrameDelayTime;

    @SerializedName("force_remove_static_frame_safe_v2")
    private final boolean forceRemoveStaticFrameV2;

    @SerializedName("game_resolution_optimize")
    private boolean gameResolutionOptimize;

    @SerializedName("live_player_search_resume_black_screen_fix")
    private final boolean livePlayerSearchResumeBlackScreenFix;

    @SerializedName("live_player_view_fit_vr_landscape")
    private final boolean livePlayerViewFitVrLandscape;

    @SerializedName("live_player_widget_resume_fix")
    private final boolean livePlayerWidgetResumeFix;

    @SerializedName("lynx_share_player_adapter")
    private final boolean lynxSharePlayerAdapter;

    @SerializedName("opt_share_outer_float_window_resolution_strategy")
    private int optShareOuterFloatWindowResolutionStrategy;

    @SerializedName("opt_update_live_request_quality")
    private boolean optUpdateLiveRequestQuality;

    @SerializedName("optimize_config")
    private final boolean optimizeConfig;

    @SerializedName("optimize_pull_stream_task")
    private final boolean optimizePullStreamTask;

    @SerializedName("phone_ring_call_mixed_fix")
    private final boolean phoneRingCallMixedFix;

    @SerializedName("platform_leak_optimize")
    private boolean platformLeakOptimize;

    @SerializedName("player_release_check")
    private final boolean playerReleaseCheck;

    @SerializedName("stop_preview_share_player")
    private final boolean stopPreviewSharePlayer;

    @SerializedName("system_float_window_black_fix")
    private final boolean systemFloatWindowBlackFix;

    @SerializedName("ugc_public_screen_height_optimize")
    private boolean ugcPublicScreenHeightOptimize;

    @SerializedName("vr_recenter_enable")
    private boolean vrRecenterEnable;

    public PlayerInnerDrawerConfig() {
        this(false, false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, false, false, false, false, false, false, 8388607, null);
    }

    public final boolean getDisableGonePlayerViewWhenScrolled() {
        return this.disableGonePlayerViewWhenScrolled;
    }

    public final boolean getFixPaidLifeCycleError() {
        return this.fixPaidLifeCycleError;
    }

    public final boolean getFixPhoneCallUnmuteWhenLostFocus() {
        return this.fixPhoneCallUnmuteWhenLostFocus;
    }

    public final boolean getFixPlayerViewClientAbnormal() {
        return this.fixPlayerViewClientAbnormal;
    }

    public final boolean getFixPlayerWidgetDatacenterCrash() {
        return this.fixPlayerWidgetDatacenterCrash;
    }

    public final boolean getFixSharePlayerMixedAudio() {
        return this.fixSharePlayerMixedAudio;
    }

    public final boolean getForceRemoveStaticFrame() {
        return this.forceRemoveStaticFrame;
    }

    public final long getForceRemoveStaticFrameDelayTime() {
        return this.forceRemoveStaticFrameDelayTime;
    }

    public final boolean getForceRemoveStaticFrameV2() {
        return this.forceRemoveStaticFrameV2;
    }

    public final boolean getGameResolutionOptimize() {
        return this.gameResolutionOptimize;
    }

    public final boolean getLivePlayerSearchResumeBlackScreenFix() {
        return this.livePlayerSearchResumeBlackScreenFix;
    }

    public final boolean getLivePlayerViewFitVrLandscape() {
        return this.livePlayerViewFitVrLandscape;
    }

    public final boolean getLivePlayerWidgetResumeFix() {
        return this.livePlayerWidgetResumeFix;
    }

    public final boolean getLynxSharePlayerAdapter() {
        return this.lynxSharePlayerAdapter;
    }

    public final int getOptShareOuterFloatWindowResolutionStrategy() {
        return this.optShareOuterFloatWindowResolutionStrategy;
    }

    public final boolean getOptUpdateLiveRequestQuality() {
        return this.optUpdateLiveRequestQuality;
    }

    public final boolean getOptimizeConfig() {
        return this.optimizeConfig;
    }

    public final boolean getOptimizePullStreamTask() {
        return this.optimizePullStreamTask;
    }

    public final boolean getPhoneRingCallMixedFix() {
        return this.phoneRingCallMixedFix;
    }

    public final boolean getPlatformLeakOptimize() {
        return this.platformLeakOptimize;
    }

    public final boolean getPlayerReleaseCheck() {
        return this.playerReleaseCheck;
    }

    public final boolean getStopPreviewSharePlayer() {
        return this.stopPreviewSharePlayer;
    }

    public final boolean getSystemFloatWindowBlackFix() {
        return this.systemFloatWindowBlackFix;
    }

    public final boolean getUgcPublicScreenHeightOptimize() {
        return this.ugcPublicScreenHeightOptimize;
    }

    public final boolean getVrRecenterEnable() {
        return this.vrRecenterEnable;
    }

    public final void setFixPhoneCallUnmuteWhenLostFocus(boolean r100) {
        this.fixPhoneCallUnmuteWhenLostFocus = r100;
    }

    public final void setFixPlayerWidgetDatacenterCrash(boolean r100) {
        this.fixPlayerWidgetDatacenterCrash = r100;
    }

    public final void setGameResolutionOptimize(boolean r100) {
        this.gameResolutionOptimize = r100;
    }

    public final void setOptShareOuterFloatWindowResolutionStrategy(int r100) {
        this.optShareOuterFloatWindowResolutionStrategy = r100;
    }

    public final void setOptUpdateLiveRequestQuality(boolean r100) {
        this.optUpdateLiveRequestQuality = r100;
    }

    public final void setPlatformLeakOptimize(boolean r100) {
        this.platformLeakOptimize = r100;
    }

    public final void setUgcPublicScreenHeightOptimize(boolean r100) {
        this.ugcPublicScreenHeightOptimize = r100;
    }

    public final void setVrRecenterEnable(boolean r100) {
        this.vrRecenterEnable = r100;
    }

    public PlayerInnerDrawerConfig(boolean r100, boolean r101, long r102, boolean r103, boolean r104, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, int r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217) {
        this.stopPreviewSharePlayer = r100;
        this.forceRemoveStaticFrame = r101;
        this.forceRemoveStaticFrameDelayTime = r102;
        this.fixPaidLifeCycleError = r103;
        this.livePlayerWidgetResumeFix = r104;
        this.livePlayerViewFitVrLandscape = r110;
        this.livePlayerSearchResumeBlackScreenFix = r111;
        this.lynxSharePlayerAdapter = r112;
        this.playerReleaseCheck = r113;
        this.optimizePullStreamTask = r114;
        this.optimizeConfig = r115;
        this.fixPlayerWidgetDatacenterCrash = r116;
        this.optUpdateLiveRequestQuality = r117;
        this.vrRecenterEnable = r118;
        this.ugcPublicScreenHeightOptimize = r119;
        this.fixPhoneCallUnmuteWhenLostFocus = r210;
        this.optShareOuterFloatWindowResolutionStrategy = r211;
        this.forceRemoveStaticFrameV2 = r212;
        this.fixSharePlayerMixedAudio = r213;
        this.fixPlayerViewClientAbnormal = r214;
        this.disableGonePlayerViewWhenScrolled = r215;
        this.gameResolutionOptimize = r216;
        this.platformLeakOptimize = r217;
        this.phoneRingCallMixedFix = true;
        this.systemFloatWindowBlackFix = true;
    }

    public /* synthetic */ PlayerInnerDrawerConfig(boolean r210, boolean r211, long r212, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, int r413, boolean r414, boolean r415, boolean r416, boolean r417, boolean r418, boolean r419, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r510 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r510 & 4) == 0) goto L13;
        long r102 = 300;
    L15:
        if ((r510 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r510 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r510 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r510 & 64) == 0) goto L29;
        boolean r106 = true;
    L31:
        if ((r510 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r510 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r510 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        boolean r113 = true;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        boolean r114 = true;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        boolean r107 = true;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        boolean r115 = true;
    L58:
        boolean r116 = r115;
        if ((r510 & 16384) == 0) goto L61;
        boolean r117 = true;
    L63:
        if ((r510 & 32768) == 0) goto L65;
        boolean r118 = true;
    L67:
        if ((r510 & 65536) == 0) goto L69;
        int r119 = -1;
    L71:
        if ((r510 & 131072) == 0) goto L73;
        boolean r120 = false;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        boolean r213 = false;
    L79:
        if ((r510 & 524288) == 0) goto L81;
        boolean r214 = true;
    L83:
        if ((r510 & 1048576) == 0) goto L85;
        boolean r215 = false;
    L87:
        if ((r510 & 2097152) == 0) goto L89;
        boolean r216 = true;
    L91:
        if ((r510 & 4194304) == 0) goto L93;
        boolean r108 = true;
    L94:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107, r116, r117, r118, r119, r120, r213, r214, r215, r216, r108);
        return;
    L93:
        r108 = r419;
        goto L94
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r213 = r415;
        goto L79
    L73:
        r120 = r414;
        goto L75
    L69:
        r119 = r413;
        goto L71
    L65:
        r118 = r412;
        goto L67
    L61:
        r117 = r411;
        goto L63
    L57:
        r115 = r410;
        goto L58
    L53:
        r107 = r319;
        goto L55
    L49:
        r114 = r318;
        goto L51
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L25:
        r105 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
