package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010=\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020\u0007J\u0006\u0010A\u001a\u00020\u0007J\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020+0\u0004J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020\u0007J\u0006\u0010J\u001a\u00020\u0007J\u0006\u0010K\u001a\u00020\u0007J\u0006\u0010L\u001a\u00020\u0007J\u0006\u0010M\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007J\u0006\u00101\u001a\u00020\u0007J\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\u0007J\u0006\u00105\u001a\u00020+J\u0006\u00106\u001a\u00020\u0007J\u0006\u00107\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiLinkFirstFrameOptConfig;", "", "()V", "byteLinkWrdsIgnoreSceneList", "", "", "byteLinkWrdsPreload", "", "clearRxBus", "disableAnchorFS", "disableInitEnterRoomInfo", "disableNotMultiLinkPreload", "disableNotMultiLinkPreloadV2", "disableRoomCache", "disable_preload_render", "effectJsb", "enableOptFloatWindowSeiMergeData", "enableOptMessageManagerInit", "enablePassedThroughAudioStageData", "enablePreAdjustLivePlayerView", "enablePreFetchOnlineList", "fallbackLogType", "feedLogRoom", "fixSmallWindow", "functionTypeLogFallBack", "gsonObjectOpt", "initFastModeEnable", "innerPreload", "installFix", "installFix2", "lastLayoutSei", "linkMapSizeExceptionOpt", "listV2PreloadDelayTime", "", "listV2PreloadOpt", "logFallback", "logPageSelect", "logPreloadStart", "lynxFirstScreen", "mockEnlargeLayout", "mockEnlargeLayoutWhenAB", "optAudienceRoomOpenStatusUpdateTime", "playModesInterceptList", "", "playModesSwitchEnable", "playerSeiOpt", "preloadALog", "preloadEnterRoomInteractDurationOpt", "preloadFinishUploadOpt", "preloadLeaveFeedViewUpdateFirstFrameOpt", "preloadLynxGuestSeatListDurationOpt", "publicScreenOpt", "smoothEnter", "smoothEnterPostTime", "smoothLeave", "startEventRoomOpt", "statusBarOpt", "totalEnable", "unloadDynamicWidget", "useServerLinkTypeWhenPreload", "wrdsPreloadDurationLog", "disableInitEnterRoomInfoOpt", "disablePreloadRenderWidget", "enableEffectJSBOnly", "enableFloatWindowSeiMergeDataOpt", "enableInitMessageManagerOpt", "enableLinkMapSizeExceptionOpt", "enableOptAudienceRoomOpenStatusUpdateTime", "enablePreAdjustRenderView", "enablePreFetchListData", "getByteLinkWrdsIgnoreSceneList", "getPlayModeInterceptList", "isDisableNotMultiLinkPreload", "isDisableNotMultiLinkPreloadV2", "isEnablePassedThroughAudioStageData", "isInitFastModeEnable", "isPlayModesInterceptEnable", "isTotalEnable", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkFirstFrameOptConfig {

    @SerializedName("bytelink_wrds_ignore_scene_list")
    private List<String> byteLinkWrdsIgnoreSceneList;

    @SerializedName("bytelink_wrds_preload")
    private boolean byteLinkWrdsPreload;

    @SerializedName("clear_rx_bus")
    private boolean clearRxBus;

    @SerializedName("disable_anchor_first_screen")
    private boolean disableAnchorFS;

    @SerializedName("disable_init_enter_room_info")
    private boolean disableInitEnterRoomInfo;

    @SerializedName("disable_not_multi_link_preload")
    private boolean disableNotMultiLinkPreload;

    @SerializedName("disable_not_multi_link_preload_v2")
    private boolean disableNotMultiLinkPreloadV2;

    @SerializedName("disable_room_cache")
    private boolean disableRoomCache;

    @SerializedName("disable_preload_render")
    private boolean disable_preload_render;

    @SerializedName("effect_jsb")
    private boolean effectJsb;

    @SerializedName("enable_opt_float_window_sei_merge_data")
    private boolean enableOptFloatWindowSeiMergeData;

    @SerializedName("enable_opt_message_manager_init")
    private boolean enableOptMessageManagerInit;

    @SerializedName("enable_passed_through_audio_stage_data")
    private boolean enablePassedThroughAudioStageData;

    @SerializedName("enable_pre_adjust_live_player_view")
    private boolean enablePreAdjustLivePlayerView;

    @SerializedName("enable_pre_fetch_online_list")
    private boolean enablePreFetchOnlineList;

    @SerializedName("fallback_log_type")
    private String fallbackLogType;

    @SerializedName("feed_log_room")
    private boolean feedLogRoom;

    @SerializedName("fix_small_window")
    private boolean fixSmallWindow;

    @SerializedName("function_type_log")
    private boolean functionTypeLogFallBack;

    @SerializedName("gson_object_opt")
    private boolean gsonObjectOpt;

    @SerializedName("init_fast_mode_enable")
    private boolean initFastModeEnable;

    @SerializedName("inner_preload")
    private boolean innerPreload;

    @SerializedName("install_fix")
    private boolean installFix;

    @SerializedName("install_fix2")
    private boolean installFix2;

    @SerializedName("last_layout_sei")
    private boolean lastLayoutSei;

    @SerializedName("link_map_size_exception_opt")
    private boolean linkMapSizeExceptionOpt;

    @SerializedName("list_v2_preload_delay_time")
    private int listV2PreloadDelayTime;

    @SerializedName("list_v2_preload_opt")
    private boolean listV2PreloadOpt;

    @SerializedName("log_fallback")
    private boolean logFallback;

    @SerializedName("log_page_select")
    private boolean logPageSelect;

    @SerializedName("log_preload_start")
    private boolean logPreloadStart;

    @SerializedName("lynx_first_screen")
    private boolean lynxFirstScreen;

    @SerializedName("mock_enlarge_layout")
    private boolean mockEnlargeLayout;

    @SerializedName("mock_enlarge_layout_when_ab")
    private boolean mockEnlargeLayoutWhenAB;

    @SerializedName("opt_audience_room_open_status_update_time")
    private boolean optAudienceRoomOpenStatusUpdateTime;

    @SerializedName("play_modes_intercept_list")
    private List<Long> playModesInterceptList;

    @SerializedName("play_modes_intercept_enable")
    private boolean playModesSwitchEnable;

    @SerializedName("player_sei_opt")
    private boolean playerSeiOpt;

    @SerializedName("preload_alog")
    private boolean preloadALog;

    @SerializedName("preload_enter_room_interact_duration_opt")
    private boolean preloadEnterRoomInteractDurationOpt;

    @SerializedName("preload_finish_upload_opt")
    private boolean preloadFinishUploadOpt;

    @SerializedName("preload_leave_feed_view_upload_first_frame_opt")
    private boolean preloadLeaveFeedViewUpdateFirstFrameOpt;

    @SerializedName("preload_lynx_guest_seat_list_duration_opt")
    private boolean preloadLynxGuestSeatListDurationOpt;

    @SerializedName("public_screen_opt")
    private boolean publicScreenOpt;

    @SerializedName("smooth_enter")
    private boolean smoothEnter;

    @SerializedName("smooth_enter_post_time")
    private long smoothEnterPostTime;

    @SerializedName("smooth_leave")
    private boolean smoothLeave;

    @SerializedName("start_event_room_opt")
    private boolean startEventRoomOpt;

    @SerializedName("status_bar_opt")
    private boolean statusBarOpt;

    @SerializedName("total_enable")
    private boolean totalEnable;

    @SerializedName("unload_dynamic_widget")
    private boolean unloadDynamicWidget;

    @SerializedName("server_link_type_preload")
    private boolean useServerLinkTypeWhenPreload;

    @SerializedName("wrds_preload_duration_log")
    private boolean wrdsPreloadDurationLog;

    public final boolean disableInitEnterRoomInfoOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.disableInitEnterRoomInfo == false) goto L7;
        return true;
    }

    public final boolean enableFloatWindowSeiMergeDataOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableOptFloatWindowSeiMergeData == false) goto L7;
        return true;
    }

    public final boolean enableInitMessageManagerOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableOptMessageManagerInit == false) goto L7;
        return true;
    }

    public final boolean enableLinkMapSizeExceptionOpt() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.linkMapSizeExceptionOpt == false) goto L7;
        return true;
    }

    public final boolean enableOptAudienceRoomOpenStatusUpdateTime() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.optAudienceRoomOpenStatusUpdateTime == false) goto L7;
        return true;
    }

    public final boolean enablePreAdjustRenderView() {
        if (this.totalEnable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enablePreAdjustLivePlayerView == false) goto L7;
        return true;
    }

    public final boolean enablePreFetchListData() {
        if (this.totalEnable == true) goto L5;
    L11:
        return false;
    L5:
        if (this.enablePreFetchOnlineList == false) goto L11;
        a50.a r100 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r100 == null) goto L11;
        if (r100.i() != true) goto L11;
        return true;
    }

    public final String fallbackLogType() {
        String r100 = this.fallbackLogType;
        if (r100 != null) goto L6;
        return "multi_link_ui_log";
    L6:
        return r100;
    }

    public MultiLinkFirstFrameOptConfig() {
        this.initFastModeEnable = true;
        this.logPreloadStart = true;
        this.functionTypeLogFallBack = true;
        this.installFix = true;
        this.installFix2 = true;
        this.fixSmallWindow = true;
        this.logPageSelect = true;
        this.fallbackLogType = "multi_link_ui_log";
        this.logFallback = true;
        this.clearRxBus = true;
        this.preloadEnterRoomInteractDurationOpt = true;
        this.preloadLynxGuestSeatListDurationOpt = true;
        this.preloadLeaveFeedViewUpdateFirstFrameOpt = true;
        this.wrdsPreloadDurationLog = true;
        this.preloadFinishUploadOpt = true;
        this.feedLogRoom = true;
        this.preloadALog = true;
        this.unloadDynamicWidget = true;
        this.publicScreenOpt = true;
        this.gsonObjectOpt = true;
        this.playerSeiOpt = true;
        this.disable_preload_render = true;
        this.smoothLeave = true;
        this.smoothEnter = true;
        this.smoothEnterPostTime = 300;
        this.statusBarOpt = true;
        this.effectJsb = true;
        this.lastLayoutSei = true;
        this.startEventRoomOpt = true;
        this.disableRoomCache = true;
        this.lynxFirstScreen = true;
        this.useServerLinkTypeWhenPreload = true;
        this.listV2PreloadOpt = true;
        this.listV2PreloadDelayTime = 5;
        this.byteLinkWrdsIgnoreSceneList = CollectionsKt.mutableListOf(new String[]{"WebcastAudioBGImgMessage", RoomLinkMicSyncData.SYNC_KEY});
        this.mockEnlargeLayout = true;
        this.mockEnlargeLayoutWhenAB = true;
        this.playModesSwitchEnable = true;
        this.playModesInterceptList = CollectionsKt.mutableListOf(new Long[]{Long.valueOf(5), Long.valueOf(7), Long.valueOf(14), Long.valueOf(16), Long.valueOf(29), Long.valueOf(34)});
        this.enablePreFetchOnlineList = true;
        this.enablePreAdjustLivePlayerView = true;
        this.enableOptFloatWindowSeiMergeData = true;
        this.enableOptMessageManagerInit = true;
        this.disableInitEnterRoomInfo = true;
        this.optAudienceRoomOpenStatusUpdateTime = true;
        this.linkMapSizeExceptionOpt = true;
        this.enablePassedThroughAudioStageData = true;
    }

    public final boolean byteLinkWrdsPreload() {
        return this.byteLinkWrdsPreload;
    }

    public final boolean clearRxBus() {
        return this.clearRxBus;
    }

    public final boolean disableAnchorFS() {
        return this.disableAnchorFS;
    }

    public final boolean disablePreloadRenderWidget() {
        return this.disable_preload_render;
    }

    public final boolean disableRoomCache() {
        return this.disableRoomCache;
    }

    public final boolean enableEffectJSBOnly() {
        return this.effectJsb;
    }

    public final boolean feedLogRoom() {
        return this.feedLogRoom;
    }

    public final boolean fixSmallWindow() {
        return this.fixSmallWindow;
    }

    public final boolean functionTypeLogFallBack() {
        return this.functionTypeLogFallBack;
    }

    public final List<String> getByteLinkWrdsIgnoreSceneList() {
        return this.byteLinkWrdsIgnoreSceneList;
    }

    public final List<Long> getPlayModeInterceptList() {
        return this.playModesInterceptList;
    }

    public final boolean gsonObjectOpt() {
        return this.gsonObjectOpt;
    }

    public final boolean innerPreload() {
        return this.innerPreload;
    }

    public final boolean installFix() {
        return this.installFix;
    }

    public final boolean installFix2() {
        return this.installFix2;
    }

    public final boolean isDisableNotMultiLinkPreload() {
        return this.disableNotMultiLinkPreload;
    }

    public final boolean isDisableNotMultiLinkPreloadV2() {
        return this.disableNotMultiLinkPreloadV2;
    }

    public final boolean isEnablePassedThroughAudioStageData() {
        return this.enablePassedThroughAudioStageData;
    }

    public final boolean isInitFastModeEnable() {
        return this.initFastModeEnable;
    }

    public final boolean isPlayModesInterceptEnable() {
        return this.playModesSwitchEnable;
    }

    public final boolean isTotalEnable() {
        return this.totalEnable;
    }

    public final boolean lastLayoutSei() {
        return this.lastLayoutSei;
    }

    public final int listV2PreloadDelayTime() {
        return this.listV2PreloadDelayTime;
    }

    public final boolean listV2PreloadOpt() {
        return this.listV2PreloadOpt;
    }

    public final boolean logFallback() {
        return this.logFallback;
    }

    public final boolean logPageSelect() {
        return this.logPageSelect;
    }

    public final boolean logPreloadStart() {
        return this.logPreloadStart;
    }

    public final boolean lynxFirstScreen() {
        return this.lynxFirstScreen;
    }

    public final boolean mockEnlargeLayout() {
        return this.mockEnlargeLayout;
    }

    public final boolean mockEnlargeLayoutWhenAB() {
        return this.mockEnlargeLayoutWhenAB;
    }

    public final boolean playerSeiOpt() {
        return this.playerSeiOpt;
    }

    public final boolean preloadALog() {
        return this.preloadALog;
    }

    public final boolean preloadEnterRoomInteractDurationOpt() {
        return this.preloadEnterRoomInteractDurationOpt;
    }

    public final boolean preloadFinishUploadOpt() {
        return this.preloadFinishUploadOpt;
    }

    public final boolean preloadLeaveFeedViewUpdateFirstFrameOpt() {
        return this.preloadLeaveFeedViewUpdateFirstFrameOpt;
    }

    public final boolean preloadLynxGuestSeatListDurationOpt() {
        return this.preloadLynxGuestSeatListDurationOpt;
    }

    public final boolean publicScreenOpt() {
        return this.publicScreenOpt;
    }

    public final boolean smoothEnter() {
        return this.smoothEnter;
    }

    public final long smoothEnterPostTime() {
        return this.smoothEnterPostTime;
    }

    public final boolean smoothLeave() {
        return this.smoothLeave;
    }

    public final boolean startEventRoomOpt() {
        return this.startEventRoomOpt;
    }

    public final boolean statusBarOpt() {
        return this.statusBarOpt;
    }

    public final boolean unloadDynamicWidget() {
        return this.unloadDynamicWidget;
    }

    public final boolean useServerLinkTypeWhenPreload() {
        return this.useServerLinkTypeWhenPreload;
    }

    public final boolean wrdsPreloadDurationLog() {
        return this.wrdsPreloadDurationLog;
    }
}
