package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.gift.configmodel.RevGiftConsumerRemindConfig;
import com.bytedance.android.livesdk.gift.configmodel.a2;
import com.bytedance.android.livesdk.gift.configmodel.d2;
import com.bytedance.android.livesdk.gift.configmodel.e2;
import com.bytedance.android.livesdk.gift.configmodel.j0;
import com.bytedance.android.livesdk.gift.configmodel.j2;
import com.bytedance.android.livesdk.gift.configmodel.l2;
import com.bytedance.android.livesdk.gift.configmodel.m0;
import com.bytedance.android.livesdk.gift.configmodel.n2;
import com.bytedance.android.livesdk.gift.configmodel.p0;
import com.bytedance.android.livesdk.gift.configmodel.p2;
import com.bytedance.android.livesdk.gift.configmodel.r0;
import com.bytedance.android.livesdk.gift.configmodel.r1;
import com.bytedance.android.livesdk.gift.configmodel.u0;
import com.bytedance.android.livesdk.gift.configmodel.u1;
import com.bytedance.android.livesdk.gift.configmodel.w1;
import com.bytedance.android.livesdk.gift.configmodel.x2;
import com.bytedance.android.livesdk.gift.configmodel.y1;
import com.bytedance.android.livesdk.gift.configmodel.y2;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty A0 = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty B0 = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty C0 = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty D0 = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty E0 = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty F0 = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty G0 = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty H0 = null;
    public static final ReadOnlyProperty I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ReadOnlyProperty f130638J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final ReadOnlyProperty N = null;
    public static final ReadOnlyProperty O = null;
    public static final ReadOnlyProperty P = null;
    public static final ReadOnlyProperty Q = null;
    public static final ReadOnlyProperty R = null;
    public static final ReadOnlyProperty S = null;
    public static final ReadOnlyProperty T = null;
    public static final ReadOnlyProperty U = null;
    public static final ReadOnlyProperty V = null;
    public static final ReadOnlyProperty W = null;
    public static final ReadOnlyProperty X = null;
    public static final ReadOnlyProperty Y = null;
    public static final ReadOnlyProperty Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f130639a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ReadOnlyProperty f130640a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f130641b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ReadOnlyProperty f130642b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f130643c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ReadOnlyProperty f130644c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f130645d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ReadOnlyProperty f130646d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f130647e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ReadOnlyProperty f130648e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f130649f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final ReadOnlyProperty f130650f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f130651g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final ReadOnlyProperty f130652g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f130653h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final ReadOnlyProperty f130654h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f130655i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final ReadOnlyProperty f130656i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f130657j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final ReadOnlyProperty f130658j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f130659k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final ReadOnlyProperty f130660k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f130661l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final ReadOnlyProperty f130662l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f130663m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final ReadOnlyProperty f130664m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f130665n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final ReadOnlyProperty f130666n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f130667o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final ReadOnlyProperty f130668o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f130669p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final ReadOnlyProperty f130670p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f130671q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final ReadOnlyProperty f130672q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f130673r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final ReadOnlyProperty f130674r0 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f130675s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final ReadOnlyProperty f130676s0 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f130677t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final ReadOnlyProperty f130678t0 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f130679u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final ReadOnlyProperty f130680u0 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f130681v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final ReadOnlyProperty f130682v0 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f130683w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final ReadOnlyProperty f130684w0 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f130685x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final ReadOnlyProperty f130686x0 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f130687y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final ReadOnlyProperty f130688y0 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f130689z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final ReadOnlyProperty f130690z0 = null;

    public static final com.bytedance.android.livesdk.gift.configmodel.j a() {
        return (com.bytedance.android.livesdk.gift.configmodel.j) f130649f.getValue(null, f130639a[4]);
    }

    public static final boolean b() {
        return ((Boolean) f130671q.getValue(null, f130639a[15])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f130640a0.getValue(null, f130639a[51])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) A0.getValue(null, f130639a[77])).booleanValue();
    }

    public static final boolean e() {
        return ((Boolean) V.getValue(null, f130639a[46])).booleanValue();
    }

    public static final boolean f() {
        return ((Boolean) f130647e.getValue(null, f130639a[3])).booleanValue();
    }

    public static final a2 g() {
        return (a2) f130660k0.getValue(null, f130639a[61]);
    }

    public static final p0 h() {
        return (p0) Q.getValue(null, f130639a[41]);
    }

    public static final boolean i() {
        return ((Boolean) F0.getValue(null, f130639a[82])).booleanValue();
    }

    public static final com.bytedance.android.livesdk.gift.configmodel.c0 j() {
        return (com.bytedance.android.livesdk.gift.configmodel.c0) f130674r0.getValue(null, f130639a[68]);
    }

    public static final com.bytedance.android.livesdk.gift.configmodel.a0 k() {
        return (com.bytedance.android.livesdk.gift.configmodel.a0) f130672q0.getValue(null, f130639a[67]);
    }

    public static final j0 l() {
        return (j0) f130670p0.getValue(null, f130639a[66]);
    }

    public static final u1 m() {
        return (u1) Y.getValue(null, f130639a[49]);
    }

    public static final u0 n() {
        return (u0) f130644c0.getValue(null, f130639a[53]);
    }

    public static final List<String> o() {
        return (List) f130680u0.getValue(null, f130639a[71]);
    }

    public static final boolean p() {
        return ((Boolean) C.getValue(null, f130639a[27])).booleanValue();
    }

    public static final boolean q() {
        return ((Boolean) X.getValue(null, f130639a[48])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MONITOR_OPTIMIZE", "getLIVE_GIFT_MONITOR_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_HOTROOM_OPTIMIZE_SWITCH", "getLIVE_GIFT_HOTROOM_OPTIMIZE_SWITCH()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SYNC_MAX_COUNT_STATUS", "getLIVE_GIFT_SYNC_MAX_COUNT_STATUS()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_DOWNLOAD_BY_PCDN", "getLIVE_GIFT_DOWNLOAD_BY_PCDN()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "BIG_GIFT_FREQUENCY_CONFIG_SETTING", "getBIG_GIFT_FREQUENCY_CONFIG_SETTING()Lcom/bytedance/android/livesdk/gift/configmodel/BigGiftFrequencyConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SEND_REQUEST_WITH_CLOUD_ROOM_PARAMS", "getLIVE_GIFT_SEND_REQUEST_WITH_CLOUD_ROOM_PARAMS()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SHOW_NOW_STATUS", "getLIVE_GIFT_SHOW_NOW_STATUS()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MONITOR_DIR_SIZE_ENABLE", "getLIVE_GIFT_MONITOR_DIR_SIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_DOWNLOAD_PCDN_CFG", "getLIVE_GIFT_DOWNLOAD_PCDN_CFG()Lcom/bytedance/android/livesdk/gift/configmodel/PcdnConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MESSAGE_NEED_RETRY", "getLIVE_GIFT_MESSAGE_NEED_RETRY()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_MATCH_ATMOSPHERE_DEGRADE_CONFIG", "getLIVE_MATCH_ATMOSPHERE_DEGRADE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/MatchAtmosphereDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "GIFT_TRAY_USE_SMALL_UI_IN_MULTI_SCENE", "getGIFT_TRAY_USE_SMALL_UI_IN_MULTI_SCENE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MP4_MESSAGE_EXPIRED_TIME_SECONDS", "getLIVE_GIFT_MP4_MESSAGE_EXPIRED_TIME_SECONDS()J", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_ENABLE_OPEN_ASSET_MESSAGE_INTO_ENTER_QUEUE", "getLIVE_ENABLE_OPEN_ASSET_MESSAGE_INTO_ENTER_QUEUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_REPORT_HOT_ROOM_EVENT", "getLIVE_GIFT_REPORT_HOT_ROOM_EVENT()Lcom/bytedance/android/livesdk/gift/configmodel/ReportHotRoomSettings;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "EFFECT_DOWNLOAD_OPT", "getEFFECT_DOWNLOAD_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "EFFECT_DOWNLOAD_FREQUENCY_LIMIT", "getEFFECT_DOWNLOAD_FREQUENCY_LIMIT()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "EFFECT_SYNC_LIMIT_INTERVAL", "getEFFECT_SYNC_LIMIT_INTERVAL()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_ANCHOR_GIFT_DOWNGRADE_CONFIG", "getLIVE_ANCHOR_GIFT_DOWNGRADE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/AnchorGiftDowngradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_AUDIENCE_DEGRADE_CONFIG", "getLIVE_GIFT_AUDIENCE_DEGRADE_CONFIG()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "DOODLE_PRE_DOWNLOAD", "getDOODLE_PRE_DOWNLOAD()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "VS_SUPPORT_GIFT_CONFIG", "getVS_SUPPORT_GIFT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/VSSupportGiftConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MSG_CONSUME_MAX_REPORT_COUNT", "getLIVE_GIFT_MSG_CONSUME_MAX_REPORT_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MSG_CONSUME_TRACE_LOG", "getLIVE_GIFT_MSG_CONSUME_TRACE_LOG()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MSG_CONSUME_EXIT_GAP_TM", "getLIVE_GIFT_MSG_CONSUME_EXIT_GAP_TM()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MSG_CONSUME_STAGE_TRACE_ENABLE", "getLIVE_GIFT_MSG_CONSUME_STAGE_TRACE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_FIRST_FRAME_OPTIMIZE_SWITCH", "getLIVE_GIFT_FIRST_FRAME_OPTIMIZE_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_MONITOR_SEND_GIFT_TIME_STATUS", "getLIVE_MONITOR_SEND_GIFT_TIME_STATUS()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "GIFT_PANEL_OPEN_MONITOR_ENABLE", "getGIFT_PANEL_OPEN_MONITOR_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "FAST_GIFT_CACEL_FILTER_ENABLE", "getFAST_GIFT_CACEL_FILTER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "GIFT_FILTER_OPT_ENABLE", "getGIFT_FILTER_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_EFFECT_CANCEL_SHOW_TIME", "getLIVE_GIFT_EFFECT_CANCEL_SHOW_TIME()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_CLEAR_SCREEN_GIFT_HALF_SCREEN", "getLIVE_CLEAR_SCREEN_GIFT_HALF_SCREEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_VS_CLEAR_SCREEN_GIFT_HALF_SCREEN", "getLIVE_VS_CLEAR_SCREEN_GIFT_HALF_SCREEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_STYLE", "getLIVE_GIFT_PANEL_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_DEGRADE_STRATEGY_SDK_ENABLE", "getLIVE_DEGRADE_STRATEGY_SDK_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "IS_LOAD_GIFT_RESOURCE_AFTER_FIRST_FRAME", "getIS_LOAD_GIFT_RESOURCE_AFTER_FIRST_FRAME()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_CONSUME_REMIND_CONFIG", "getLIVE_GIFT_CONSUME_REMIND_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevGiftConsumerRemindConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MATCH_ROOM_ASSET_LOAD_ENABLE", "getLIVE_GIFT_MATCH_ROOM_ASSET_LOAD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_RESOURCE_DELAY_DOWNLOAD_THRESHOLD_VALUE", "getLIVE_GIFT_RESOURCE_DELAY_DOWNLOAD_THRESHOLD_VALUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_EFFECT_SKIP_SCORE", "getLIVE_GIFT_EFFECT_SKIP_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_LOAD_LOCAL_MORE_TAB_ENABLE", "getLIVE_GIFT_LOAD_LOCAL_MORE_TAB_ENABLE()Lcom/bytedance/android/livesdk/gift/configmodel/GiftLoadLocalConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_LOAD_LOCAL_WTO_ENABLE", "getLIVE_GIFT_LOAD_LOCAL_WTO_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SAR_NATIVE_PAGE_SWITCH", "getLIVE_GIFT_SAR_NATIVE_PAGE_SWITCH()Lcom/bytedance/android/livesdk/gift/configmodel/SarNativeSwitchConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SEND_GROUP_OPT", "getLIVE_GIFT_SEND_GROUP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_IMAGE_REFRESH", "getLIVE_GIFT_PANEL_IMAGE_REFRESH()I", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_AI_ASSET_FEATURE_ENABLE", "getLIVE_GIFT_AI_ASSET_FEATURE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_LYNX_EFFECT_SINGLE_EVENT", "getLIVE_GIFT_LYNX_EFFECT_SINGLE_EVENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_NEW_PK_EFFECT_ENABLE", "getLIVE_NEW_PK_EFFECT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_NEW_STRUCTURE", "getLIVE_GIFT_PANEL_NEW_STRUCTURE()Lcom/bytedance/android/livesdk/gift/configmodel/NewGiftPanelConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_TOPIC_ENABLE_VIEW_PAGER", "getLIVE_GIFT_TOPIC_ENABLE_VIEW_PAGER()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_ENABLE_SELECT_SUB_TAB", "getLIVE_ENABLE_SELECT_SUB_TAB()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_FANS_CLUB_LYNX", "getLIVE_GIFT_PANEL_FANS_CLUB_LYNX()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_OPEN_OPT", "getLIVE_GIFT_PANEL_OPEN_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelOpenOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_PROP_CARD_HIDE_DIALOG", "getLIVE_PROP_CARD_HIDE_DIALOG()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_SEND_GIFT_ROOM_OPT", "getLIVE_SEND_GIFT_ROOM_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_DOWNLOAD_WITH_SELECT", "getLIVE_GIFT_DOWNLOAD_WITH_SELECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PAGE_GIFT_COUNT_MIN", "getLIVE_GIFT_PAGE_GIFT_COUNT_MIN()Lcom/bytedance/android/livesdk/gift/configmodel/GiftListCountConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_LIST_SORT_CONFIG", "getLIVE_GIFT_LIST_SORT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveGiftSortConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_ASSET_DOWNLOAD_AI", "getLIVE_GIFT_ASSET_DOWNLOAD_AI()Lcom/bytedance/android/livesdk/gift/configmodel/SendGiftPredictConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_INFO_SEI_ENABLE", "getLIVE_GIFT_INFO_SEI_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_DOWNLOAD_DURATION_CONFIG", "getLIVE_GIFT_DOWNLOAD_DURATION_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevGiftDownloadDurationConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_ENABLE_VS_SCHEMA", "getLIVE_GIFT_ENABLE_VS_SCHEMA()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_FAST_TASK_DESTROY_OPT", "getLIVE_GIFT_FAST_TASK_DESTROY_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SCENE_MARKETING_CONFIG", "getLIVE_GIFT_SCENE_MARKETING_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevSceneMarketingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_API_REQUEST_USE_UPLINK", "getLIVE_GIFT_API_REQUEST_USE_UPLINK()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_INTERACT_PAGE_GUIDE_CONFIG", "getLIVE_GIFT_PANEL_INTERACT_PAGE_GUIDE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftInteractPageGuideConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_DYNAMIZATION", "getLIVE_GIFT_PANEL_DYNAMIZATION()Lcom/bytedance/android/livesdk/gift/configmodel/GiftDynamicPanelConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_NEW_EFFECT_SWITCH_CONFIG", "getLIVE_GIFT_NEW_EFFECT_SWITCH_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftEffectSoundAndVibrationConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_LOW_PRIORITY_OPERATION_LIST", "getLIVE_GIFT_LOW_PRIORITY_OPERATION_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_ENABLE_VIEW_PAGER_INTERCEPT", "getLIVE_GIFT_ENABLE_VIEW_PAGER_INTERCEPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_RECOMMEND_INSERT_SCENE", "getLIVE_GIFT_RECOMMEND_INSERT_SCENE()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_SMALL_GIFT_SPECIAL_EFFECT", "getLIVE_SMALL_GIFT_SPECIAL_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_STICKER_MATCH_GIFT_CONFIG", "getLIVE_STICKER_MATCH_GIFT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/StickerMatchGiftConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PANEL_CONTAINER_CONFIG", "getLIVE_GIFT_PANEL_CONTAINER_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelContainerConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "DOWN_LOAD_ASSETS_FORCE_ANCHOR", "getDOWN_LOAD_ASSETS_FORCE_ANCHOR()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_AI_GIFT_LIST_PRELOAD_CONFIG", "getLIVE_AI_GIFT_LIST_PRELOAD_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveGiftListPreloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_FAST_GIFT_IMAGE_OPT", "getLIVE_FAST_GIFT_IMAGE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_WHITE_SNAKE_CONFIG", "getLIVE_GIFT_WHITE_SNAKE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/WhiteSnakeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_SP_CACHE_FIX", "getLIVE_GIFT_SP_CACHE_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_PAGE_EXTRA_FREQUENCY_CONTROL", "getLIVE_GIFT_PAGE_EXTRA_FREQUENCY_CONTROL()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_SEND_GROUP_GIFT_LOG_FIXED", "getLIVE_SEND_GROUP_GIFT_LOG_FIXED()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_MESSAGE_INTERCEPTOR_ORDER", "getLIVE_GIFT_MESSAGE_INTERCEPTOR_ORDER()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_ANCHOR_SUPPORT_CLOUD_ROOM_GIFT", "getLIVE_GIFT_ANCHOR_SUPPORT_CLOUD_ROOM_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(h.class, "LIVE_GIFT_FETCH_STRATEGY_OPT", "getLIVE_GIFT_FETCH_STRATEGY_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftFetchStrategyConfig;", 1))};
        f130639a = r100;
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_minitor_optimize", r110, r111, false);
        f130641b = UltraSettingsManager.a().a(r101.b(), r101.a(), r101.getType(), r101.c(), r100[0]);
        Class r112 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_hotroom_optimize_switch", 0, r112, false);
        f130643c = UltraSettingsManager.a().a(r102.b(), r102.a(), r102.getType(), r102.c(), r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sync_max_count_status", 0, r112, false);
        f130645d = UltraSettingsManager.a().a(r103.b(), r103.a(), r103.getType(), r103.c(), r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_download_by_pcdn", r110, r111, false);
        f130647e = UltraSettingsManager.a().a(r104.b(), r104.a(), r104.getType(), r104.c(), r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("big_gift_frequency_config_setting", new com.bytedance.android.livesdk.gift.configmodel.j(), com.bytedance.android.livesdk.gift.configmodel.j.class, false);
        f130649f = UltraSettingsManager.a().a(r105.b(), r105.a(), r105.getType(), r105.c(), r100[4]);
        Boolean r106 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_send_request_with_cloud_room_params", r106, r111, false);
        f130651g = UltraSettingsManager.a().a(r107.b(), r107.a(), r107.getType(), r107.c(), r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_display_free", -1, r112, false);
        f130653h = UltraSettingsManager.a().a(r108.b(), r108.a(), r108.getType(), r108.c(), r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_minitor_dir_size_enable", r106, r111, false);
        f130655i = UltraSettingsManager.a().a(r109.b(), r109.a(), r109.getType(), r109.c(), r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_download_pcdn_cfg", new w1(), w1.class, false);
        f130657j = UltraSettingsManager.a().a(r113.b(), r113.a(), r113.getType(), r113.c(), r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_message_need_retry", r110, r111, false);
        f130659k = UltraSettingsManager.a().a(r114.b(), r114.a(), r114.getType(), r114.c(), r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_match_atmosphere_degrade_config", new r1(), r1.class, false);
        f130661l = UltraSettingsManager.a().a(r115.b(), r115.a(), r115.getType(), r115.c(), r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_tray_use_small_ui_in_multi_scene", r106, r111, false);
        f130663m = UltraSettingsManager.a().a(r116.b(), r116.a(), r116.getType(), r116.c(), r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_mp4_message_expired_time_seconds", 600L, Long.TYPE, false);
        f130665n = UltraSettingsManager.a().a(r117.b(), r117.a(), r117.getType(), r117.c(), r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_functional_user_enter_asset", r106, r111, false);
        f130667o = UltraSettingsManager.a().a(r118.b(), r118.a(), r118.getType(), r118.c(), r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_report_hot_room_event", new y1(), y1.class, false);
        f130669p = UltraSettingsManager.a().a(r119.b(), r119.a(), r119.getType(), r119.c(), r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("effect_download_opt", r106, r111, false);
        f130671q = UltraSettingsManager.a().a(r120.b(), r120.a(), r120.getType(), r120.c(), r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("effect_download_frequency_limit", 3, r112, false);
        f130673r = UltraSettingsManager.a().a(r121.b(), r121.a(), r121.getType(), r121.c(), r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("effect_sync_limit_interval", 0, r112, false);
        f130675s = UltraSettingsManager.a().a(r122.b(), r122.a(), r122.getType(), r122.c(), r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_gift_downgrade_config", new com.bytedance.android.livesdk.gift.configmodel.b(), com.bytedance.android.livesdk.gift.configmodel.b.class, false);
        f130677t = UltraSettingsManager.a().a(r123.b(), r123.a(), r123.getType(), r123.c(), r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_audience_degrade_config", r110, r111, false);
        f130679u = UltraSettingsManager.a().a(r124.b(), r124.a(), r124.getType(), r124.c(), r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("doodle_pre_download", r106, r111, false);
        f130681v = UltraSettingsManager.a().a(r125.b(), r125.a(), r125.getType(), r125.c(), r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("vs_support_gift_config", new x2(), x2.class, false);
        f130683w = UltraSettingsManager.a().a(r126.b(), r126.a(), r126.getType(), r126.c(), r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_msg_consume_max_report_count", 5, r112, false);
        f130685x = UltraSettingsManager.a().a(r127.b(), r127.a(), r127.getType(), r127.c(), r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_msg_consume_trace_log", r110, r111, false);
        f130687y = UltraSettingsManager.a().a(r128.b(), r128.a(), r128.getType(), r128.c(), r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_msg_consume_exit_gap_tm", 5, r112, false);
        f130689z = UltraSettingsManager.a().a(r129.b(), r129.a(), r129.getType(), r129.c(), r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_msg_consume_stage_trace_enable", r110, r111, false);
        A = UltraSettingsManager.a().a(r130.b(), r130.a(), r130.getType(), r130.c(), r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_first_frame_optimize_switch", r106, r111, false);
        B = UltraSettingsManager.a().a(r131.b(), r131.a(), r131.getType(), r131.c(), r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_send_gift_time", r106, r111, false);
        C = UltraSettingsManager.a().a(r132.b(), r132.a(), r132.getType(), r132.c(), r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_open_monitor_enable", r106, r111, false);
        D = UltraSettingsManager.a().a(r133.b(), r133.a(), r133.getType(), r133.c(), r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fast_gift_cancel_filter_enable", r106, r111, false);
        E = UltraSettingsManager.a().a(r134.b(), r134.a(), r134.getType(), r134.c(), r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_filter_opt_enable", r106, r111, false);
        F = UltraSettingsManager.a().a(r135.b(), r135.a(), r135.getType(), r135.c(), r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_cancel_show_time", 0, r112, false);
        G = UltraSettingsManager.a().a(r136.b(), r136.a(), r136.getType(), r136.c(), r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_clear_screen_gift_half_screen", r110, r111, false);
        H = UltraSettingsManager.a().a(r137.b(), r137.a(), r137.getType(), r137.c(), r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vs_clear_screen_gift_half_screen", r110, r111, false);
        I = UltraSettingsManager.a().a(r138.b(), r138.a(), r138.getType(), r138.c(), r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a(LiveInitSettingKeys.LIVE_GIFT_PANEL_STYLE, 2, r112, false);
        f130638J = UltraSettingsManager.a().a(r139.b(), r139.a(), r139.getType(), r139.c(), r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a(LiveInitSettingKeys.LIVE_DEGRADE_STRATEGY_SDK_ENABLE, r106, r111, false);
        K = UltraSettingsManager.a().a(r140.b(), r140.a(), r140.getType(), r140.c(), r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r141 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("is_load_gift_resource_after_first_frame", r110, r111, false);
        L = UltraSettingsManager.a().a(r141.b(), r141.a(), r141.getType(), r141.c(), r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r142 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_consume_remind_config", new RevGiftConsumerRemindConfig(false, 0, null, 7, null), RevGiftConsumerRemindConfig.class, false);
        M = UltraSettingsManager.a().a(r142.b(), r142.a(), r142.getType(), r142.c(), r100[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r143 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_match_room_asset_load_enable", r110, r111, false);
        N = UltraSettingsManager.a().a(r143.b(), r143.a(), r143.getType(), r143.c(), r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r144 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_delay_download_threshold_value", r110, r111, false);
        O = UltraSettingsManager.a().a(r144.b(), r144.a(), r144.getType(), r144.c(), r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r145 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_skip_score", Float.valueOf(7.0f), Float.TYPE, false);
        P = UltraSettingsManager.a().a(r145.b(), r145.a(), r145.getType(), r145.c(), r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_load_local_more_tab_enable", new p0(), p0.class, false);
        Q = UltraSettingsManager.a().a(r146.b(), r146.a(), r146.getType(), r146.c(), r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_load_local_wto_enable", r110, r111, false);
        R = UltraSettingsManager.a().a(r147.b(), r147.a(), r147.getType(), r147.c(), r100[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r148 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sar_native_page_switch", new l2(), l2.class, false);
        S = UltraSettingsManager.a().a(r148.b(), r148.a(), r148.getType(), r148.c(), r100[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r149 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_group_opt", r110, r111, false);
        T = UltraSettingsManager.a().a(r149.b(), r149.a(), r149.getType(), r149.c(), r100[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_image_refresh", 0, r112, false);
        U = UltraSettingsManager.a().a(r150.b(), r150.a(), r150.getType(), r150.c(), r100[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r151 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_ai_asset_feature_enable", r106, r111, false);
        V = UltraSettingsManager.a().a(r151.b(), r151.a(), r151.getType(), r151.c(), r100[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r152 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_effect_single_event", r106, r111, false);
        W = UltraSettingsManager.a().a(r152.b(), r152.a(), r152.getType(), r152.c(), r100[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r153 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_new_pk_effect_enable", r106, r111, false);
        X = UltraSettingsManager.a().a(r153.b(), r153.a(), r153.getType(), r153.c(), r100[48]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r154 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_new_architecture", new u1(), u1.class, false);
        Y = UltraSettingsManager.a().a(r154.b(), r154.a(), r154.getType(), r154.c(), r100[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r155 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_scroll_sub_tab_content", r110, r111, false);
        Z = UltraSettingsManager.a().a(r155.b(), r155.a(), r155.getType(), r155.c(), r100[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r156 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_select_sub_tab", r106, r111, false);
        f130640a0 = UltraSettingsManager.a().a(r156.b(), r156.a(), r156.getType(), r156.c(), r100[51]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r157 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_fans_club_lynx", r106, r111, false);
        f130642b0 = UltraSettingsManager.a().a(r157.b(), r157.a(), r157.getType(), r157.c(), r100[52]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r158 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_open_opt", new u0(), u0.class, false);
        f130644c0 = UltraSettingsManager.a().a(r158.b(), r158.a(), r158.getType(), r158.c(), r100[53]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r159 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_prop_card_hide_dialog", r110, r111, false);
        f130646d0 = UltraSettingsManager.a().a(r159.b(), r159.a(), r159.getType(), r159.c(), r100[54]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r160 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_room_opt", r106, r111, false);
        f130648e0 = UltraSettingsManager.a().a(r160.b(), r160.a(), r160.getType(), r160.c(), r100[55]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r161 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_download_with_select", r110, r111, false);
        f130650f0 = UltraSettingsManager.a().a(r161.b(), r161.a(), r161.getType(), r161.c(), r100[56]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r162 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_page_gift_count_min", new m0(), m0.class, false);
        f130652g0 = UltraSettingsManager.a().a(r162.b(), r162.a(), r162.getType(), r162.c(), r100[57]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r163 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_sort_config", new e2(), e2.class, false);
        f130654h0 = UltraSettingsManager.a().a(r163.b(), r163.a(), r163.getType(), r163.c(), r100[58]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r164 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_download_ai", new n2(), n2.class, false);
        f130656i0 = UltraSettingsManager.a().a(r164.b(), r164.a(), r164.getType(), r164.c(), r100[59]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r165 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_gift_info_sei", r110, r111, false);
        f130658j0 = UltraSettingsManager.a().a(r165.b(), r165.a(), r165.getType(), r165.c(), r100[60]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r166 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_download_duration_config", new a2(), a2.class, false);
        f130660k0 = UltraSettingsManager.a().a(r166.b(), r166.a(), r166.getType(), r166.c(), r100[61]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r167 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_schema", r106, r111, false);
        f130662l0 = UltraSettingsManager.a().a(r167.b(), r167.a(), r167.getType(), r167.c(), r100[62]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r168 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fast_task_destroy_opt", r110, r111, false);
        f130664m0 = UltraSettingsManager.a().a(r168.b(), r168.a(), r168.getType(), r168.c(), r100[63]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r169 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_scene_marketing_config", new j2(), j2.class, false);
        f130666n0 = UltraSettingsManager.a().a(r169.b(), r169.a(), r169.getType(), r169.c(), r100[64]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r170 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_api_request_use_uplink", r110, r111, false);
        f130668o0 = UltraSettingsManager.a().a(r170.b(), r170.a(), r170.getType(), r170.c(), r100[65]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r171 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_interact_page_guide_config", new j0(), j0.class, false);
        f130670p0 = UltraSettingsManager.a().a(r171.b(), r171.a(), r171.getType(), r171.c(), r100[66]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r172 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_dynamization", new com.bytedance.android.livesdk.gift.configmodel.a0(), com.bytedance.android.livesdk.gift.configmodel.a0.class, false);
        f130672q0 = UltraSettingsManager.a().a(r172.b(), r172.a(), r172.getType(), r172.c(), r100[67]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r173 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sound_and_vibration_switch_config", new com.bytedance.android.livesdk.gift.configmodel.c0(), com.bytedance.android.livesdk.gift.configmodel.c0.class, false);
        f130674r0 = UltraSettingsManager.a().a(r173.b(), r173.a(), r173.getType(), r173.c(), r100[68]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r174 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_low_priority_operation_list", CollectionsKt.listOf(512), nn3.a.f519633b, false);
        f130676s0 = UltraSettingsManager.a().a(r174.b(), r174.a(), r174.getType(), r174.c(), r100[69]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r175 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_view_pager_intercept", r106, r111, false);
        f130678t0 = UltraSettingsManager.a().a(r175.b(), r175.a(), r175.getType(), r175.c(), r100[70]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r176 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_recommend_insert_scene", new ArrayList(), nn3.a.f519645n, false);
        f130680u0 = UltraSettingsManager.a().a(r176.b(), r176.a(), r176.getType(), r176.c(), r100[71]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r177 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_small_gift_special_effect", r106, r111, false);
        f130682v0 = UltraSettingsManager.a().a(r177.b(), r177.a(), r177.getType(), r177.c(), r100[72]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r178 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_match_gift_config", new p2(), p2.class, false);
        f130684w0 = UltraSettingsManager.a().a(r178.b(), r178.a(), r178.getType(), r178.c(), r100[73]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r179 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_container_config", new r0(), r0.class, false);
        f130686x0 = UltraSettingsManager.a().a(r179.b(), r179.a(), r179.getType(), r179.c(), r100[74]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r180 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("download_assets_force_anchor", r106, r111, false);
        f130688y0 = UltraSettingsManager.a().a(r180.b(), r180.a(), r180.getType(), r180.c(), r100[75]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r181 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_gift_list_preload_config", new d2(), d2.class, false);
        f130690z0 = UltraSettingsManager.a().a(r181.b(), r181.a(), r181.getType(), r181.c(), r100[76]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r182 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fast_gift_image_opt", r110, r111, false);
        A0 = UltraSettingsManager.a().a(r182.b(), r182.a(), r182.getType(), r182.c(), r100[77]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r183 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_white_snake_config", new y2(), y2.class, false);
        B0 = UltraSettingsManager.a().a(r183.b(), r183.a(), r183.getType(), r183.c(), r100[78]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r184 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sp_cache_fix", r106, r111, false);
        C0 = UltraSettingsManager.a().a(r184.b(), r184.a(), r184.getType(), r184.c(), r100[79]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r185 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_page_extra_frequency_control", r106, r111, false);
        D0 = UltraSettingsManager.a().a(r185.b(), r185.a(), r185.getType(), r185.c(), r100[80]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r186 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_group_log_fixed", r106, r111, false);
        E0 = UltraSettingsManager.a().a(r186.b(), r186.a(), r186.getType(), r186.c(), r100[81]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r187 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_message_interceptor_order", r106, r111, false);
        F0 = UltraSettingsManager.a().a(r187.b(), r187.a(), r187.getType(), r187.c(), r100[82]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r188 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_anchor_support_cloud_room_gift", r106, r111, false);
        G0 = UltraSettingsManager.a().a(r188.b(), r188.a(), r188.getType(), r188.c(), r100[83]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r189 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_request_enter_room_opt", new com.bytedance.android.livesdk.gift.configmodel.d0(), com.bytedance.android.livesdk.gift.configmodel.d0.class, false);
        H0 = UltraSettingsManager.a().a(r189.b(), r189.a(), r189.getType(), r189.c(), r100[84]);
    }
}
