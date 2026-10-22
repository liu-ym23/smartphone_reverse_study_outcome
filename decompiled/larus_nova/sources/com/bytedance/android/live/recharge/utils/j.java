package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.ai.api.model.RechargeCacheConfig;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class j {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f90465b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f90466c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f90467d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f90468e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f90469f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f90470g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f90471h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f90472i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f90473j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f90474k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f90475l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f90476m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f90477n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ClientABTestKey<Boolean> f90478o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f90479p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f90480q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f90481r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f90482s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f90483t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f90484u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f90485v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f90486w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f90487x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f90488y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f90489z = null;

    public static final boolean a() {
        return ((Boolean) E.getValue(null, f90464a[28])).booleanValue();
    }

    public static final int b() {
        return ((Number) f90466c.getValue(null, f90464a[1])).intValue();
    }

    public static final boolean c() {
        return ((Boolean) f90473j.getValue(null, f90464a[8])).booleanValue();
    }

    public static final RechargeCacheConfig d() {
        return (RechargeCacheConfig) f90475l.getValue(null, f90464a[10]);
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(j.class, "CASH_EXCHANGE_OPT_CONFIG", "getCASH_EXCHANGE_OPT_CONFIG()Lcom/bytedance/android/live/recharge/utils/LiveCashExchangeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_DIALOG_FREQUENCY", "getLIVE_EXCHANGE_DIALOG_FREQUENCY()I", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_BASE_POPUP_MANAGER_ENABLE", "getLIVE_BASE_POPUP_MANAGER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_WALLET_INFO_REQUEST_TIME", "getLIVE_WALLET_INFO_REQUEST_TIME()I", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_LYNX_EXCHANGE_DIALOG", "getLIVE_LYNX_EXCHANGE_DIALOG()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_REASON_MAP", "getLIVE_EXCHANGE_REASON_MAP()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "CHARGE_PROTOCOL", "getCHARGE_PROTOCOL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "CHARGE_SECURITY_PROTOCOL", "getCHARGE_SECURITY_PROTOCOL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_INCENTIVES_EXPERIMENT_ENABLE", "getLIVE_INCENTIVES_EXPERIMENT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_LYNX_EXCHANGE_DIALOG_SHORTCUT", "getLIVE_LYNX_EXCHANGE_DIALOG_SHORTCUT()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "RECHARGE_PANEL_USE_CACHE_DATA", "getRECHARGE_PANEL_USE_CACHE_DATA()Lcom/bytedance/android/live/ai/api/model/RechargeCacheConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_BALANCE_CACHE_UPDATE", "getLIVE_BALANCE_CACHE_UPDATE()Lcom/bytedance/android/live/recharge/utils/BalanceCacheUpdateConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_USER_CHANGE_SYNC_DISABLE", "getLIVE_USER_CHANGE_SYNC_DISABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_DIAMOND_PROCESS_OPTIMIZATION", "getLIVE_EXCHANGE_DIAMOND_PROCESS_OPTIMIZATION()Lcom/bytedance/android/live/recharge/utils/ExchangeDiamondProcessConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_TREASURE_BOX_SCHEMA", "getLIVE_OPEN_TREASURE_BOX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_COUNT_DOWN_TIME_REQUEST_ENABLE", "getLIVE_EXCHANGE_COUNT_DOWN_TIME_REQUEST_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_EXCHANGE_INTRO_SCHEMA", "getLIVE_OPEN_EXCHANGE_INTRO_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_EXCHANGE_INTRO_SCHEME_TAX_SAVING", "getLIVE_OPEN_EXCHANGE_INTRO_SCHEME_TAX_SAVING()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_CHECK_IAC_FINANCIAL_VISIBLE", "getLIVE_CHECK_IAC_FINANCIAL_VISIBLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_BANNER_USE_ANNIEX", "getLIVE_RECHARGE_BANNER_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_BANNER_USE_CACHE", "getLIVE_RECHARGE_BANNER_USE_CACHE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_GOOGLE_IAP_CONFIG", "getLIVE_RECHARGE_GOOGLE_IAP_CONFIG()Lcom/bytedance/android/live/wallet/pay/iap/LiveIAPSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_TRACE_CONFIG", "getLIVE_RECHARGE_TRACE_CONFIG()Lcom/bytedance/android/live/recharge/trace/RechargeTraceSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_CUSTOM_RECHARGE_DYNAMIC_CONFIG", "getLIVE_CUSTOM_RECHARGE_DYNAMIC_CONFIG()Lcom/bytedance/android/live/ai/api/model/CustomRechargeDynamicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_WALLET_LOG_USE_EVENT_TRACKER_SWITCH", "getLIVE_WALLET_LOG_USE_EVENT_TRACKER_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_ONE_STEP_PRELOAD_CONFIG", "getLIVE_RECHARGE_ONE_STEP_PRELOAD_CONFIG()J", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_PAD_UI_FIX", "getLIVE_RECHARGE_PANEL_PAD_UI_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_ONE_STEP_LOADING_BLOCK", "getLIVE_RECHARGE_PANEL_ONE_STEP_LOADING_BLOCK()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVESDK_CLIENT_AI_PREORDER_ENABLE", "getLIVESDK_CLIENT_AI_PREORDER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_SETTING_CONFIG", "getLIVE_RECHARGE_PANEL_SETTING_CONFIG()Lcom/bytedance/android/live/recharge/config/RechargePanelSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_BACKGROUND_TRANSPARENT", "getLIVE_RECHARGE_PANEL_BACKGROUND_TRANSPARENT()Z", 1))};
        f90464a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("cash_exchange_frequency_config", new d(), d.class, false);
        f90465b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r110 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_dialog_frequency", 0, r110, false);
        f90466c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r111 = Boolean.TRUE;
        Class r112 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_base_popup_manager_enable", r111, r112, false);
        f90467d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_info_request_time", 0, r110, false);
        f90468e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_exchange_dialog", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_saas%2Fpages%2Fexchange_panel%2Ftemplate.js%3FenterFrom%3Dgift_entrance&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1&initialProps=%5B%22setting%3Aaweme_lite_live_income_exchange%3Alive_show_income_exchange_reminder%3Alive_redeem_ploy_exchange%3Alive_trial_diamond_exchange%22%5D", String.class, false);
        f90469f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_reason_map", new LinkedHashMap(), wn3.a.f560463a, false);
        f90470g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        KmpEnv r107 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L5;
        String r108 = "sslocal://webcast_webview?url=https%3A%2F%2Fsf3-draftcdn-tos.pstatp.com%2Fobj%2Fies-hotsoon-draft%2Fdouyin%2F36ba590b-4606-410f-b035-bc38f7ef6a50.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("charge_protocol", r108, String.class, false);
        f90471h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_purchase_safe_remind_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fwallet_money_douyin%2Fpages%2Frecharge_safety_reminder%2Findex.html&hide_nav_bar=1", String.class, false);
        f90472i = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[7]);
        Boolean r114 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentives_experiment_enable", r114, r112, false);
        f90473j = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_exchange_dialog_shortcut", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fexchange_panel%2Ftemplate.js%3FenterFrom%3Dshortcut&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1&initialProps=%5B%22setting%3Aaweme_lite_live_income_exchange%3Alive_show_income_exchange_reminder%3Alive_redeem_ploy_exchange%22%5D", String.class, false);
        f90474k = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_use_cache_data", new RechargeCacheConfig(), RechargeCacheConfig.class, false);
        f90475l = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_balance_cache_update", new b(), b.class, false);
        f90476m = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_user_change_sync_disable", r114, r112, false);
        f90477n = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[12]);
        f90478o = new ClientABTestKey("live_recharge_enable_cache_precision", r112, r114, 1);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_diamond_process_optimization", new c(), c.class, false);
        f90479p = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_treasure_box_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Ftask_center_douyin_h5_douyin%2Fpages%2Ftask_panel%2Findex.html%3Forigin_page%3Dtool_bar_icon&enable_preload=all&type=popup&gravity=bottom&height_percent=56&add_safe_area_height=0&use_real_screen_height=1&radius=20", String.class, false);
        f90480q = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_count_down_time_request_enable", r114, r112, false);
        f90481r = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_exchange_intro_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf3-cdn-tos.draftstatic.com%2Fobj%2Fies-hotsoon-draft%2F2329_lite%2Fe0c7a0ed-8361-4f56-9e62-8e0ab46fc607.html&hide_nav_bar=0&hide_status_bar=0", String.class, false);
        f90482s = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_exchange_intro_scheme_tax_saving", "sslocal://webcast_webview?url=https%3A%2F%2Flf3-cdn-tos.draftstatic.com%2Fobj%2Fies-hotsoon-draft%2F2329_lite%2Fd319a114-9b06-4018-8fa9-64fb879838a5.html&hide_nav_bar=0&hide_status_bar=0", String.class, false);
        f90483t = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_iac_financial_visable", r114, r112, false);
        f90484u = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_banner_use_annix", r114, r112, false);
        f90485v = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_banner_use_cache", r111, r112, false);
        f90486w = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_google_iap_config", new com.bytedance.android.live.wallet.pay.iap.e(), com.bytedance.android.live.wallet.pay.iap.e.class, false);
        f90487x = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_trace_config", new com.bytedance.android.live.recharge.trace.g(), com.bytedance.android.live.recharge.trace.g.class, false);
        f90488y = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_custom_recharge_dynamic_config", zx.a.f573866a, zx.a.class, false);
        f90489z = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_log_use_event_tracker_switch", r111, r112, false);
        A = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_one_step_preload_config", -1L, Long.TYPE, false);
        B = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_pad_ui_fix", r111, r112, false);
        C = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_one_step_loading_block", r111, r112, false);
        D = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_clientAI_preorder_enable", r114, r112, false);
        E = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_setting_config", new com.bytedance.android.live.recharge.config.b(), com.bytedance.android.live.recharge.config.b.class, false);
        F = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_background_opt", r114, r112, false);
        G = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[30]);
        return;
    L5:
        r108 = "";
        goto L6
    }
}
