package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0016\u0010$\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0016\u0010&\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006R\u0016\u0010(\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0016\u0010*\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u0016\u0010,\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0016\u0010.\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0016\u00100\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u0016\u00102\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0016\u00104\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0016\u00106\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0016\u00108\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0016\u0010:\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0016\u0010<\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0016\u0010>\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0016\u0010@\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u0016\u0010B\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0006R\u0016\u0010D\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0006R\u0016\u0010F\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0006R\u0016\u0010H\u001a\u00020I8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0006R\u0016\u0010N\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0006R\u0016\u0010P\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0006R\u0016\u0010R\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u0016\u0010T\u001a\u00020U8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020U8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bY\u0010WR\u0016\u0010Z\u001a\u00020I8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b[\u0010KR\u0016\u0010\\\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0006R\u0016\u0010^\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0006R\u0016\u0010`\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0006R\u0016\u0010b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u0006R\u0016\u0010d\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0006R\u0016\u0010f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0006R\u0016\u0010h\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0006R\u0016\u0010j\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0006R\u0016\u0010l\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0006¨\u0006n"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerOptimizeConfig;", "", "()V", "assembleLivePlayerParams", "", "getAssembleLivePlayerParams", "()Z", "assembleNQEParams", "getAssembleNQEParams", "asyncSendAppLog", "getAsyncSendAppLog", "audioFocusAsync", "getAudioFocusAsync", "catchExceptionForAudioController", "getCatchExceptionForAudioController", "cdnDisasterTolerance", "getCdnDisasterTolerance", "closeAsyncSetSurface", "getCloseAsyncSetSurface", "disableLiveIoLog", "getDisableLiveIoLog", "disableStreamSwitchLog", "getDisableStreamSwitchLog", "disableVoiceBalanceOpt", "getDisableVoiceBalanceOpt", "setDisableVoiceBalanceOpt", "(Z)V", "enableAsyncStreamOpt", "getEnableAsyncStreamOpt", "enableAsyncStreamOptScenes", "", "", "getEnableAsyncStreamOptScenes", "()Ljava/util/List;", "enableHubbleAudioFocusAutoRelease", "getEnableHubbleAudioFocusAutoRelease", "enablePlayerThreadDynamic", "getEnablePlayerThreadDynamic", "enableRemoveResolution", "getEnableRemoveResolution", "enableWifiCellularSwitch", "getEnableWifiCellularSwitch", "eventLeakFix", "getEventLeakFix", "jatoCpuBigCore", "getJatoCpuBigCore", "jatoCpuBoost", "getJatoCpuBoost", "jatoCpuCoreRest", "getJatoCpuCoreRest", "optNpThParams", "getOptNpThParams", "optPlayHelper", "getOptPlayHelper", "optPullControlMessage", "getOptPullControlMessage", "optStopInPreparing", "getOptStopInPreparing", "optWorkThread", "getOptWorkThread", "optimizeSameStream", "getOptimizeSameStream", "optimizeStartStreamSize", "getOptimizeStartStreamSize", "playerBitmapLeakFix", "getPlayerBitmapLeakFix", "playerLoggerSimplify", "getPlayerLoggerSimplify", "playerLoggerSimplifyV2", "getPlayerLoggerSimplifyV2", "playerMsgExecuteCheck", "getPlayerMsgExecuteCheck", "playerMsgExecuteMaxInterval", "", "getPlayerMsgExecuteMaxInterval", "()J", "playerSendMsgDirectInMainThread", "getPlayerSendMsgDirectInMainThread", "playerSendMsgRunProtected", "getPlayerSendMsgRunProtected", "playerSendMsgSafely", "getPlayerSendMsgSafely", "playerStabilityOpt", "getPlayerStabilityOpt", "playerThreadPriority", "", "getPlayerThreadPriority", "()I", "playerThreadPriorityAfterFrame", "getPlayerThreadPriorityAfterFrame", "playingEventReportInterval", "getPlayingEventReportInterval", "resolutionFallback", "getResolutionFallback", "sameStreamLoginOpt", "getSameStreamLoginOpt", "setVideoSizeWithSharePlayer", "getSetVideoSizeWithSharePlayer", "startPlayReportAfterCreateLiveStreamData", "getStartPlayReportAfterCreateLiveStreamData", "startPullObserveFix", "getStartPullObserveFix", "startPullWithMute", "getStartPullWithMute", "surfaceFixedSize", "getSurfaceFixedSize", "useHandlerThreadLogger", "getUseHandlerThreadLogger", "vqosLoggerAssemblerOpt", "getVqosLoggerAssemblerOpt", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerOptimizeConfig {

    @SerializedName("assemble_live_player_params")
    private final boolean assembleLivePlayerParams;

    @SerializedName("assemble_nqe_params")
    private final boolean assembleNQEParams;

    @SerializedName("async_send_applog")
    private final boolean asyncSendAppLog;

    @SerializedName("audio_focus_async")
    private final boolean audioFocusAsync;

    @SerializedName("catch_exception_for_audio_controller")
    private final boolean catchExceptionForAudioController;

    @SerializedName("cdn_disaster_tolerance")
    private final boolean cdnDisasterTolerance;

    @SerializedName("close_async_set_surface")
    private final boolean closeAsyncSetSurface;

    @SerializedName("disable_live_io_log")
    private final boolean disableLiveIoLog;

    @SerializedName("disable_stream_switch_log")
    private final boolean disableStreamSwitchLog;

    @SerializedName("disable_voice_balance_opt")
    private boolean disableVoiceBalanceOpt;

    @SerializedName("enable_async_stream_opt")
    private final boolean enableAsyncStreamOpt;

    @SerializedName("enable_async_stream_opt_scenes")
    private final List<String> enableAsyncStreamOptScenes;

    @SerializedName("live_player_enable_audio_focus_auto_release")
    private final boolean enableHubbleAudioFocusAutoRelease;

    @SerializedName("enable_player_thread_dynamic_priority")
    private final boolean enablePlayerThreadDynamic;

    @SerializedName("enable_remove_resolution")
    private final boolean enableRemoveResolution;

    @SerializedName("enable_wifi_cellular_switch")
    private final boolean enableWifiCellularSwitch;

    @SerializedName("event_leak_fix")
    private final boolean eventLeakFix;

    @SerializedName("jato_cpu_big_core")
    private final boolean jatoCpuBigCore;

    @SerializedName("jato_cpu_boost")
    private final boolean jatoCpuBoost;

    @SerializedName("jato_cpu_core_reset")
    private final boolean jatoCpuCoreRest;

    @SerializedName("opt_npth_params")
    private final boolean optNpThParams;

    @SerializedName("opt_play_helper")
    private final boolean optPlayHelper;

    @SerializedName("opt_pull_control_message")
    private final boolean optPullControlMessage;

    @SerializedName("opt_stop_in_preparing")
    private final boolean optStopInPreparing;

    @SerializedName("opt_work_thread")
    private final boolean optWorkThread;

    @SerializedName("optimize_same_stream")
    private final boolean optimizeSameStream;

    @SerializedName("optimize_start_stream_size")
    private final boolean optimizeStartStreamSize;

    @SerializedName("player_bitmap_leak_fix")
    private final boolean playerBitmapLeakFix;

    @SerializedName("player_logger_simplify")
    private final boolean playerLoggerSimplify;

    @SerializedName("player_logger_simplify_v2")
    private final boolean playerLoggerSimplifyV2;

    @SerializedName("player_msg_execute_check")
    private final boolean playerMsgExecuteCheck;

    @SerializedName("player_msg_execute_max_interval")
    private final long playerMsgExecuteMaxInterval;

    @SerializedName("player_send_msg_direct_in_main_thread")
    private final boolean playerSendMsgDirectInMainThread;

    @SerializedName("player_send_msg_run_protected")
    private final boolean playerSendMsgRunProtected;

    @SerializedName("player_send_msg_safely")
    private final boolean playerSendMsgSafely;

    @SerializedName("player_stability_opt")
    private final boolean playerStabilityOpt;

    @SerializedName("player_thread_priority")
    private final int playerThreadPriority;

    @SerializedName("player_thread_priority_after_first_frame")
    private final int playerThreadPriorityAfterFrame;

    @SerializedName("playing_event_report_interval")
    private final long playingEventReportInterval;

    @SerializedName("resolution_fallback")
    private final boolean resolutionFallback;

    @SerializedName("same_stream_logic_opt")
    private final boolean sameStreamLoginOpt;

    @SerializedName("set_video_size_with_share_player")
    private final boolean setVideoSizeWithSharePlayer;

    @SerializedName("start_play_report_after_create_live_stream_data")
    private final boolean startPlayReportAfterCreateLiveStreamData;

    @SerializedName("start_pull_observe_fix")
    private final boolean startPullObserveFix;

    @SerializedName("start_pull_with_mute")
    private final boolean startPullWithMute;

    @SerializedName("surface_fixed_size")
    private final boolean surfaceFixedSize;

    @SerializedName("use_handler_thread_logger")
    private final boolean useHandlerThreadLogger;

    @SerializedName("vqos_logger_assembler_opt")
    private final boolean vqosLoggerAssemblerOpt;

    public PlayerOptimizeConfig() {
        this.playerThreadPriority = 10;
        this.playerThreadPriorityAfterFrame = 10;
        this.optimizeSameStream = true;
        this.playerSendMsgSafely = true;
        this.playerSendMsgRunProtected = true;
        this.playerMsgExecuteCheck = true;
        this.playerMsgExecuteMaxInterval = 1000;
        this.assembleLivePlayerParams = true;
        this.playerBitmapLeakFix = true;
        this.optPullControlMessage = true;
        this.enableRemoveResolution = true;
        this.disableLiveIoLog = true;
        this.startPullObserveFix = true;
        this.useHandlerThreadLogger = true;
        this.optStopInPreparing = true;
        this.playerLoggerSimplify = true;
        this.playerLoggerSimplifyV2 = true;
        this.playingEventReportInterval = 20;
        this.enableAsyncStreamOptScenes = CollectionsKt.emptyList();
    }

    public final boolean getAssembleLivePlayerParams() {
        return this.assembleLivePlayerParams;
    }

    public final boolean getAssembleNQEParams() {
        return this.assembleNQEParams;
    }

    public final boolean getAsyncSendAppLog() {
        return this.asyncSendAppLog;
    }

    public final boolean getAudioFocusAsync() {
        return this.audioFocusAsync;
    }

    public final boolean getCatchExceptionForAudioController() {
        return this.catchExceptionForAudioController;
    }

    public final boolean getCdnDisasterTolerance() {
        return this.cdnDisasterTolerance;
    }

    public final boolean getCloseAsyncSetSurface() {
        return this.closeAsyncSetSurface;
    }

    public final boolean getDisableLiveIoLog() {
        return this.disableLiveIoLog;
    }

    public final boolean getDisableStreamSwitchLog() {
        return this.disableStreamSwitchLog;
    }

    public final boolean getDisableVoiceBalanceOpt() {
        return this.disableVoiceBalanceOpt;
    }

    public final boolean getEnableAsyncStreamOpt() {
        return this.enableAsyncStreamOpt;
    }

    public final List<String> getEnableAsyncStreamOptScenes() {
        return this.enableAsyncStreamOptScenes;
    }

    public final boolean getEnableHubbleAudioFocusAutoRelease() {
        return this.enableHubbleAudioFocusAutoRelease;
    }

    public final boolean getEnablePlayerThreadDynamic() {
        return this.enablePlayerThreadDynamic;
    }

    public final boolean getEnableRemoveResolution() {
        return this.enableRemoveResolution;
    }

    public final boolean getEnableWifiCellularSwitch() {
        return this.enableWifiCellularSwitch;
    }

    public final boolean getEventLeakFix() {
        return this.eventLeakFix;
    }

    public final boolean getJatoCpuBigCore() {
        return this.jatoCpuBigCore;
    }

    public final boolean getJatoCpuBoost() {
        return this.jatoCpuBoost;
    }

    public final boolean getJatoCpuCoreRest() {
        return this.jatoCpuCoreRest;
    }

    public final boolean getOptNpThParams() {
        return this.optNpThParams;
    }

    public final boolean getOptPlayHelper() {
        return this.optPlayHelper;
    }

    public final boolean getOptPullControlMessage() {
        return this.optPullControlMessage;
    }

    public final boolean getOptStopInPreparing() {
        return this.optStopInPreparing;
    }

    public final boolean getOptWorkThread() {
        return this.optWorkThread;
    }

    public final boolean getOptimizeSameStream() {
        return this.optimizeSameStream;
    }

    public final boolean getOptimizeStartStreamSize() {
        return this.optimizeStartStreamSize;
    }

    public final boolean getPlayerBitmapLeakFix() {
        return this.playerBitmapLeakFix;
    }

    public final boolean getPlayerLoggerSimplify() {
        return this.playerLoggerSimplify;
    }

    public final boolean getPlayerLoggerSimplifyV2() {
        return this.playerLoggerSimplifyV2;
    }

    public final boolean getPlayerMsgExecuteCheck() {
        return this.playerMsgExecuteCheck;
    }

    public final long getPlayerMsgExecuteMaxInterval() {
        return this.playerMsgExecuteMaxInterval;
    }

    public final boolean getPlayerSendMsgDirectInMainThread() {
        return this.playerSendMsgDirectInMainThread;
    }

    public final boolean getPlayerSendMsgRunProtected() {
        return this.playerSendMsgRunProtected;
    }

    public final boolean getPlayerSendMsgSafely() {
        return this.playerSendMsgSafely;
    }

    public final boolean getPlayerStabilityOpt() {
        return this.playerStabilityOpt;
    }

    public final int getPlayerThreadPriority() {
        return this.playerThreadPriority;
    }

    public final int getPlayerThreadPriorityAfterFrame() {
        return this.playerThreadPriorityAfterFrame;
    }

    public final long getPlayingEventReportInterval() {
        return this.playingEventReportInterval;
    }

    public final boolean getResolutionFallback() {
        return this.resolutionFallback;
    }

    public final boolean getSameStreamLoginOpt() {
        return this.sameStreamLoginOpt;
    }

    public final boolean getSetVideoSizeWithSharePlayer() {
        return this.setVideoSizeWithSharePlayer;
    }

    public final boolean getStartPlayReportAfterCreateLiveStreamData() {
        return this.startPlayReportAfterCreateLiveStreamData;
    }

    public final boolean getStartPullObserveFix() {
        return this.startPullObserveFix;
    }

    public final boolean getStartPullWithMute() {
        return this.startPullWithMute;
    }

    public final boolean getSurfaceFixedSize() {
        return this.surfaceFixedSize;
    }

    public final boolean getUseHandlerThreadLogger() {
        return this.useHandlerThreadLogger;
    }

    public final boolean getVqosLoggerAssemblerOpt() {
        return this.vqosLoggerAssemblerOpt;
    }

    public final void setDisableVoiceBalanceOpt(boolean r100) {
        this.disableVoiceBalanceOpt = r100;
    }
}
