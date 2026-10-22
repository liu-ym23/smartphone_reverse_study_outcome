package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.GiftAfterSendConfig;
import com.bytedance.android.livesdk.gift.configmodel.GiftPanelOptConfig;
import com.bytedance.android.livesdk.gift.configmodel.c1;
import com.bytedance.android.livesdk.gift.configmodel.d1;
import com.bytedance.android.livesdk.gift.configmodel.e1;
import com.bytedance.android.livesdk.gift.configmodel.g0;
import com.bytedance.android.livesdk.gift.configmodel.i1;
import com.bytedance.android.livesdk.gift.configmodel.m2;
import com.bytedance.android.livesdk.gift.configmodel.n1;
import com.bytedance.android.livesdk.gift.configmodel.t;
import com.bytedance.android.livesdk.gift.configmodel.w0;
import com.bytedance.android.livesdk.gift.configmodel.x1;
import com.bytedance.android.livesdk.gift.configmodel.y0;
import com.bytedance.android.livesdk.gift.configmodel.z0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ReadOnlyProperty f126532J = null;
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
    public static final /* synthetic */ KProperty[] f126533a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ReadOnlyProperty f126534a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126535b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ReadOnlyProperty f126536b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f126537c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ReadOnlyProperty f126538c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f126539d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ReadOnlyProperty f126540d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f126541e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ReadOnlyProperty f126542e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f126543f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f126544g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f126545h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f126546i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f126547j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f126548k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f126549l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f126550m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f126551n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f126552o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f126553p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f126554q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f126555r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f126556s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f126557t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f126558u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f126559v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f126560w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f126561x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f126562y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f126563z = null;

    public static final boolean a() {
        return ((Boolean) f126546i.getValue(null, f126533a[7])).booleanValue();
    }

    public static final int b() {
        return ((Number) f126547j.getValue(null, f126533a[8])).intValue();
    }

    public static final GiftAfterSendConfig c() {
        return (GiftAfterSendConfig) K.getValue(null, f126533a[35]);
    }

    public static final boolean d() {
        return ((Boolean) P.getValue(null, f126533a[40])).booleanValue();
    }

    public static final boolean e() {
        return ((Boolean) V.getValue(null, f126533a[46])).booleanValue();
    }

    public static final w0 f() {
        return (w0) f126542e0.getValue(null, f126533a[55]);
    }

    public static final boolean g() {
        return ((Boolean) f126537c.getValue(null, f126533a[1])).booleanValue();
    }

    public static final y0 h() {
        return (y0) S.getValue(null, f126533a[43]);
    }

    public static final boolean i() {
        return ((Boolean) f126555r.getValue(null, f126533a[16])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_MATCH_ATMOSPHERE_EFFECT_IDS", "getLIVE_MATCH_ATMOSPHERE_EFFECT_IDS()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_REORDER_OPTIMIZE_ENABLE", "getLIVE_GIFT_REORDER_OPTIMIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SEND_TIMEOUT_REPORT_ENABLE", "getLIVE_GIFT_SEND_TIMEOUT_REPORT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_PROP_SEND_TIMEOUT_REPORT_ENABLE", "getLIVE_PROP_SEND_TIMEOUT_REPORT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_SEND_GIFT_ALERT_IN_GUEST_BATTLE", "getLIVE_ENABLE_SEND_GIFT_ALERT_IN_GUEST_BATTLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_REVENUE_GIFT_ICON_DEGRADE_CONFIG", "getLIVE_REVENUE_GIFT_ICON_DEGRADE_CONFIG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_EFFECT_PLAY_INTERVAL", "getLIVE_GIFT_EFFECT_PLAY_INTERVAL()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ANIMATOR_DURATION_SCALE_FIX", "getLIVE_ANIMATOR_DURATION_SCALE_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DEFAULT_SELECT_OPTIMIZE_FOR_ANDROID", "getLIVE_DEFAULT_SELECT_OPTIMIZE_FOR_ANDROID()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_PANEL_OPT_CONFIG", "getGIFT_PANEL_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_FRESCO_CACHE_OPT_ENABLE", "getGIFT_FRESCO_CACHE_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SCENE_GIFT_SYNC_CONFIG_SETTING", "getLIVE_SCENE_GIFT_SYNC_CONFIG_SETTING()Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TOOLBAR_COORDINARY_ANIMAITON_STYLE", "getLIVE_TOOLBAR_COORDINARY_ANIMAITON_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_AI_OPEN_GIFT_PANEL", "getLIVE_AI_OPEN_GIFT_PANEL()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENTER_ROOM_PRELOAD_ICON_COUNT", "getLIVE_ENTER_ROOM_PRELOAD_ICON_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_OPEN_PANEL_PRELOAD_ICON_COUNT", "getLIVE_OPEN_PANEL_PRELOAD_ICON_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_PROP_LIST_UPDATE_PANEL", "getLIVE_PROP_LIST_UPDATE_PANEL()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_OPT_FIND_GIFT", "getLIVE_OPT_FIND_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ASSETS_CLEAN_STRATEGY_CONFIG", "getASSETS_CLEAN_STRATEGY_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/AssetsCleanStrategyConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_PORTRAIT_CLEAN_ENABLE", "getLIVE_ASSET_PORTRAIT_CLEAN_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_RESOURCE_MANAGER_USE_NEW_QUEUE", "getLIVE_GIFT_RESOURCE_MANAGER_USE_NEW_QUEUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "YYH_INTERACT_DOWNGRADE_CONFIG", "getYYH_INTERACT_DOWNGRADE_CONFIG()Lcom/bytedance/android/livesdk/configmodel/InteractDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "SEND_GIFT_INTERCEPT_OFFLINE", "getSEND_GIFT_INTERCEPT_OFFLINE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_LANDSCAPE_TRAY_FIX", "getLIVE_LANDSCAPE_TRAY_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_JSON_OPT_ENABLE", "getLIVE_JSON_OPT_ENABLE()Lcom/bytedance/android/livesdk/gift/configmodel/LiveJsonOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_COUNTER_CONFIG", "getLIVE_GIFT_COUNTER_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveCounterShowConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_CURATED_USE_DEFAULT_CARD", "getLIVE_GIFT_CURATED_USE_DEFAULT_CARD()Lcom/bytedance/android/livesdk/gift/configmodel/LiveCuratedUseDefaultCard;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_RESOURCE_UNZIP_METHOD", "getGIFT_RESOURCE_UNZIP_METHOD()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_WIDGET_SP_OPT", "getGIFT_WIDGET_SP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DISABLE_GIFT_ITEM_COMPLETELY_VISIBLE_ACTION", "getLIVE_DISABLE_GIFT_ITEM_COMPLETELY_VISIBLE_ACTION()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "DOUYIN_CLEAN_APPASSET", "getDOUYIN_CLEAN_APPASSET()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_BIG_GIFT_COMBO_DEBOUNCE_OPTIMIZE", "getLIVE_BIG_GIFT_COMBO_DEBOUNCE_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_LRU_CLEAN_CONFIG", "getLIVE_ASSET_LRU_CLEAN_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveAssetLRUCleanConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SEND_GIFT_JSB_EXCHANGE_OPT", "getLIVE_SEND_GIFT_JSB_EXCHANGE_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/SendGiftJsbExchangeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_PREVIEW_DEBUG_WIDGET_LOAD_SWITCH", "getGIFT_PREVIEW_DEBUG_WIDGET_LOAD_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_AFTER_SEND_CONFIG", "getLIVE_GIFT_AFTER_SEND_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ACTIVITY_FLOAT_ASSET_DOWNLOAD_CONFIG", "getLIVE_ACTIVITY_FLOAT_ASSET_DOWNLOAD_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/PreDownloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_DIALOG_TOPIC_CONFIG", "getLIVE_GIFT_DIALOG_TOPIC_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftTopicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_OLD_DIALOG_TOPIC_ENABLE", "getLIVE_GIFT_OLD_DIALOG_TOPIC_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TOPIC_PAGING_FIX", "getLIVE_TOPIC_PAGING_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LOAD_IMAGE_OPTIMIZE", "getLIVE_GIFT_LOAD_IMAGE_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_ICON_PREFETCH_OPT", "getLIVE_GIFT_ICON_PREFETCH_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftIconPrefetchOpt;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ENABLE_DEFAULT_SELECT_RECHARGE_PREVIEW_GIFT", "getENABLE_DEFAULT_SELECT_RECHARGE_PREVIEW_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SORT_FOR_SCENE", "getLIVE_GIFT_SORT_FOR_SCENE()Lcom/bytedance/android/livesdk/gift/configmodel/GiftSortSceneOpt;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_FILTER_OPT_NEW", "getLIVE_GIFT_LIST_FILTER_OPT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_FILTER_OPT_FIXBUG", "getLIVE_GIFT_LIST_FILTER_OPT_FIXBUG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_INSERT_OPT", "getLIVE_GIFT_PANEL_INSERT_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GROUP_LIVE_ENABLE_SEND_PROP_TO_GROUP_MEMBER", "getLIVE_GROUP_LIVE_ENABLE_SEND_PROP_TO_GROUP_MEMBER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GROUP_LIVE_ENABLE_SEND_FANS_GIFT_TO_GROUP_MEMBER", "getLIVE_GROUP_LIVE_ENABLE_SEND_FANS_GIFT_TO_GROUP_MEMBER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_SEND_FANS_GIFT_TO_GUEST", "getLIVE_ENABLE_SEND_FANS_GIFT_TO_GUEST()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BANNER_LYNX_SCHEME", "getLIVE_GIFT_BANNER_LYNX_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_IS_LOADED_CHECK_OPT", "getLIVE_GIFT_LIST_IS_LOADED_CHECK_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_LIST_OHR", "getLIVE_GIFT_PANEL_LIST_OHR()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftPanelListOhrConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_HOTSOON_PROP_ASSET_NOT_IN_LIST_OPTIMIZE", "getLIVE_GIFT_HOTSOON_PROP_ASSET_NOT_IN_LIST_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BATTLE_TOOLBAR_CONFIG", "getLIVE_GIFT_BATTLE_TOOLBAR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftBattleToolbarConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PRICE_RECOMMEND_CONFIG", "getLIVE_GIFT_PRICE_RECOMMEND_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPriceRecommendConfig;", 1))};
        f126533a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_match_atmosphere_effect_ids", CollectionsKt.listOf(new Long[]{2723L, 2737L}), nn3.a.f519643l, false);
        f126535b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_reorder_optimize_enable", r110, r111, false);
        f126537c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_send_timeout_report_enable", r103, r111, false);
        f126539d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_prop_send_timeout_report_enable", r110, r111, false);
        f126541e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_send_gift_alert_in_guest_battle", r103, r111, false);
        f126543f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_gift_icon_degrade_config", r103, r111, false);
        f126544g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        Class r108 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_play_interval", 0, r108, false);
        f126545h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_animator_duration_scale_fix", r103, r111, false);
        f126546i = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_default_select_optimize_for_android", 0, r108, false);
        f126547j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fresco_cache_config", new GiftPanelOptConfig(), GiftPanelOptConfig.class, false);
        f126548k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fresco_cache_opt_enable", r110, r111, false);
        f126549l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        Class<?> r116 = ((JsonAdapter) ys1.b.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r117 = vh7.b.f554981a;
        Constructor r118 = r117.get(r116);
        if (r118 != null) goto L12;
        r118 = r116.getConstructor(new Class[0]);
        if (r118 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r119 = r117.putIfAbsent(r116, (Constructor<? extends SerializableObjectJsonAdapterBase>) r118);
        if (r119 == null) goto L12;
        r118 = r119;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r120 = ((SerializableObjectJsonAdapterBase) r118.newInstance(new Object[0])).createInstance();
        if (r120 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_scene_gift_sync_config_setting", (ys1.b) r120, ys1.b.class, false);
        f126550m = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_coordinary_animation_style", 0, r108, false);
        f126551n = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_open_gift_panel", r103, r111, false);
        f126552o = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enter_room_preload_icon_count", -1, r108, false);
        f126553p = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_panel_preload_icon_count", -1, r108, false);
        f126554q = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_prop_list_update_panel", r103, r111, false);
        f126555r = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_opt_find_gift", r110, r111, false);
        f126556s = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_clean_strategy_config", new com.bytedance.android.livesdk.gift.configmodel.i(), com.bytedance.android.livesdk.gift.configmodel.i.class, false);
        f126557t = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_portrait_clean_strategy_enable", r103, r111, false);
        f126558u = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_manager_use_new_queue", r110, r111, false);
        f126559v = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("yyh_interact_downgrade_config", new ys1.a(), ys1.a.class, false);
        f126560w = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_intercept_anchor_offline", r110, r111, false);
        f126561x = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_tray_fix", r110, r111, false);
        f126562y = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_json_opt_enable", new n1(), n1.class, false);
        f126563z = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_section_show_config", new d1(), d1.class, false);
        A = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_curated_use_default_card", new e1(), e1.class, false);
        B = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_resource_unzip_method", 0, r108, false);
        C = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_widget_sp_opt", r103, r111, false);
        D = UltraSettingsManager.a().a(r138.f271017a, r138.f271018b, r138.getType(), r138.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_gift_item_completely_visible_action", r110, r111, false);
        E = UltraSettingsManager.a().a(r139.f271017a, r139.f271018b, r139.getType(), r139.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("douyin_user_clean_appasset", r110, r111, false);
        F = UltraSettingsManager.a().a(r140.f271017a, r140.f271018b, r140.getType(), r140.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r141 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_debounce_optimize", r103, r111, false);
        G = UltraSettingsManager.a().a(r141.f271017a, r141.f271018b, r141.getType(), r141.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r142 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_lru_clean_config", new c1(), c1.class, false);
        H = UltraSettingsManager.a().a(r142.f271017a, r142.f271018b, r142.getType(), r142.f271020d, r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r143 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_jsb_exchange_opt", new m2(), m2.class, false);
        I = UltraSettingsManager.a().a(r143.f271017a, r143.f271018b, r143.getType(), r143.f271020d, r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r144 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_preview_debug_widget_load_switch", r103, r111, false);
        f126532J = UltraSettingsManager.a().a(r144.f271017a, r144.f271018b, r144.getType(), r144.f271020d, r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r145 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_after_send_config", new GiftAfterSendConfig(), GiftAfterSendConfig.class, false);
        K = UltraSettingsManager.a().a(r145.f271017a, r145.f271018b, r145.getType(), r145.f271020d, r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_activity_float_asset_download_config", new x1(), x1.class, false);
        L = UltraSettingsManager.a().a(r146.f271017a, r146.f271018b, r146.getType(), r146.f271020d, r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_topic_item_config", new z0(), z0.class, false);
        M = UltraSettingsManager.a().a(r147.f271017a, r147.f271018b, r147.getType(), r147.f271020d, r100[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r148 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_old_dialog_topic_enable", r103, r111, false);
        N = UltraSettingsManager.a().a(r148.f271017a, r148.f271018b, r148.getType(), r148.f271020d, r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r149 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_topic_paging_fix", r110, r111, false);
        O = UltraSettingsManager.a().a(r149.f271017a, r149.f271018b, r149.getType(), r149.f271020d, r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_load_image_optimize", r110, r111, false);
        P = UltraSettingsManager.a().a(r150.f271017a, r150.f271018b, r150.getType(), r150.f271020d, r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r151 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_icon_prefetch_opt", new g0(), g0.class, false);
        Q = UltraSettingsManager.a().a(r151.f271017a, r151.f271018b, r151.getType(), r151.f271020d, r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r152 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_default_select_recharge_preview_gift", r110, r111, false);
        R = UltraSettingsManager.a().a(r152.f271017a, r152.f271018b, r152.getType(), r152.f271020d, r100[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r153 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_request_config", new y0(), y0.class, false);
        S = UltraSettingsManager.a().a(r153.f271017a, r153.f271018b, r153.getType(), r153.f271020d, r100[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r154 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_filter_config_opt_new", r110, r111, false);
        T = UltraSettingsManager.a().a(r154.f271017a, r154.f271018b, r154.getType(), r154.f271020d, r100[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r155 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_filter_config_opt_fixbug", r103, r111, false);
        U = UltraSettingsManager.a().a(r155.f271017a, r155.f271018b, r155.getType(), r155.f271020d, r100[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r156 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_insert_opt", r103, r111, false);
        V = UltraSettingsManager.a().a(r156.f271017a, r156.f271018b, r156.getType(), r156.f271020d, r100[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r157 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_group_live_room_send_prop_to_group_member", r103, r111, false);
        W = UltraSettingsManager.a().a(r157.f271017a, r157.f271018b, r157.getType(), r157.f271020d, r100[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r158 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_group_live_room_send_fans_gift_to_group_member", r103, r111, false);
        X = UltraSettingsManager.a().a(r158.f271017a, r158.f271018b, r158.getType(), r158.f271020d, r100[48]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r159 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_send_fans_gift_to_guest", r103, r111, false);
        Y = UltraSettingsManager.a().a(r159.f271017a, r159.f271018b, r159.getType(), r159.f271020d, r100[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r160 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_banner_lynx_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fbanner%2Fprogress%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1", String.class, false);
        Z = UltraSettingsManager.a().a(r160.f271017a, r160.f271018b, r160.getType(), r160.f271020d, r100[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r161 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_is_loaded_check_opt", r103, r111, false);
        f126534a0 = UltraSettingsManager.a().a(r161.f271017a, r161.f271018b, r161.getType(), r161.f271020d, r100[51]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r162 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_list_ohr_config", new i1(), i1.class, false);
        f126536b0 = UltraSettingsManager.a().a(r162.f271017a, r162.f271018b, r162.getType(), r162.f271020d, r100[52]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r163 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_hotsoon_prop_asset_not_in_list_optimize", r103, r111, false);
        f126538c0 = UltraSettingsManager.a().a(r163.f271017a, r163.f271018b, r163.getType(), r163.f271020d, r100[53]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r164 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_battle_toolbar_config", new t(), t.class, false);
        f126540d0 = UltraSettingsManager.a().a(r164.f271017a, r164.f271018b, r164.getType(), r164.f271020d, r100[54]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r165 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_price_recommend_config", new w0(), w0.class, false);
        f126542e0 = UltraSettingsManager.a().a(r165.f271017a, r165.f271018b, r165.getType(), r165.f271020d, r100[55]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.configmodel.LiveSceneGiftSyncConfig");
    }
}
