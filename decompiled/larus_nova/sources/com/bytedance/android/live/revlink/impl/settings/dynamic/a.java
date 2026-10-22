package com.bytedance.android.live.revlink.impl.settings.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final a H = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f97530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f97531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f97532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f97533d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f97534e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f97535f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f97536g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f97537h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f97538i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f97539j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f97540k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f97541l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f97542m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f97543n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f97544o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f97545p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f97546q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f97547r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f97548s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f97549t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f97550u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f97551v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f97552w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f97553x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f97554y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f97555z = null;

    public a() {
    }

    public final String[] a() {
        return (String[]) f97534e.getValue(this, f97530a[3]);
    }

    public final boolean b() {
        return ((Boolean) f97549t.getValue(this, f97530a[18])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) C.getValue(this, f97530a[27])).booleanValue();
    }

    public final long d() {
        return ((Number) f97539j.getValue(this, f97530a[8])).longValue();
    }

    public final boolean e() {
        return ((Boolean) f97536g.getValue(this, f97530a[5])).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f97531b.getValue(this, f97530a[0])).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f97548s.getValue(this, f97530a[17])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePreviewPkDynamicHubLoadEnable", "getLivePreviewPkDynamicHubLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkLynxControlTeamTaskEnable", "getLivePkLynxControlTeamTaskEnable()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDynamicHubLynxParams", "getLivePkDynamicHubLynxParams()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveFeedEventBlockList", "getLiveFeedEventBlockList()[Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDynamicHubLoadTraceEnable", "getLivePkDynamicHubLoadTraceEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkLynxControlNativeViewEnable", "getLivePkLynxControlNativeViewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveFeedHybridMeasureOpt", "getLiveFeedHybridMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkHybridJsGroupShare", "getLivePkHybridJsGroupShare()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedInitDelay", "getLivePkFeedInitDelay()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveKtvInitDelay", "getLiveKtvInitDelay()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiTestDynamicLoadEnable", "getLiveMultiTestDynamicLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubLynxParams", "getLiveMultiDynamicHubLynxParams()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveDoubleDynamicHubUseAnnieX", "getLiveDoubleDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubUseAnnieX", "getLiveMultiDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiFeedDynamicHubUseAnnieX", "getLiveMultiFeedDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePKHybridUseAnnieX", "getLivePKHybridUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAnnieXExecuteLoadFailed", "getLiveAnnieXExecuteLoadFailed()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "revnueInteractDataFormat", "getRevnueInteractDataFormat()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkEnableLynxAnchorMicPanel", "getLivePkEnableLynxAnchorMicPanel()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiAnnieXExecuteLoadFailed", "getLiveMultiAnnieXExecuteLoadFailed()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDoubleLynxMicEnable", "getLivePkDoubleLynxMicEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkLynxLoadEnable", "getCreateLinkLynxLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkControlCenterLynxGroupName", "getLinkControlCenterLynxGroupName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDoubleLinkScoreLynxEnable", "getLivePkDoubleLinkScoreLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkHubUrl", "getCreateLinkHubUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkHubAnineX", "getCreateLinkHubAnineX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkInteractCommentLynxEnable", "getLivePkInteractCommentLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkEnablePanelListOpt", "getLivePkEnablePanelListOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveDynamicHubLynxV2Opt", "getLiveDynamicHubLynxV2Opt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubLynxParamsV2", "getLiveMultiDynamicHubLynxParamsV2()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAiAssistantCellularConfig", "getLiveAiAssistantCellularConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/AiAssistantCellularConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkMatchBellDialogUrl", "getLivePkMatchBellDialogUrl()Ljava/lang/String;", 0))};
        f97530a = r100;
        H = new a();
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_preview_stream_support_dynamic_enable", r110, r111, false);
        f97531b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_lynx_control_team_task_enable", 0, Integer.TYPE, false);
        f97532c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        b03.a r112 = b03.a.f16857a;
        if (b03.a.b() == false) goto L5;
        String r113 = "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central%2Ftemplate.js\",\"tag\":\"dynamic_central\",\"height\":50,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":1,\"margin_top\":100,\"observer\":[\"pk_status\",\"change_screen\"]}";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_dynamic_hub_lynx_params", r113, String.class, false);
        f97533d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_feed_event_block_list", new String[0], zn3.a.f572926l, false);
        f97534e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_dynamic_hub_load_trace_enable", r110, r111, false);
        f97535f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        Boolean r106 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_lynx_control_native_view_enable", r106, r111, true);
        f97536g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_feed_hybrid_measure_opt", r106, r111, false);
        f97537h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_hybrid_share_group", r106, r111, false);
        f97538i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_init_delay", -1L, Long.TYPE, false);
        f97539j = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_ktv_init_delay", r106, r111, false);
        f97540k = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_change_background_image_enable", r110, r111, false);
        f97541l = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_change_background_image_centre_url", "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fmulti_dynamic_demo%2Ftemplate.js\",\"tag\":\"dynamic_central\",\"height_radio\":1.0,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":1,\"margin_top\":0,\"observer\":[\"pk_status\",\"change_screen\"]}", String.class, false);
        f97542m = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_double_dynamic_hub_use_annie_x", r110, r111, false);
        f97543n = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_hub_use_annie_x", r110, r111, false);
        f97544o = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_feed_dynamic_hub_use_annie_x", r110, r111, false);
        f97545p = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_hybrid_use_annie_x", r110, r111, false);
        f97546q = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_annie_x_execute_load_failed", r110, r111, false);
        f97547r = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_dynamic_data_format", r110, r111, false);
        f97548s = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_anchor_mic_panel", r110, r111, false);
        f97549t = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_annie_x_execute_load_failed", r110, r111, false);
        f97550u = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_double_lynx_mic_enable", r106, r111, false);
        f97551v = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_control_center_enable", r110, r111, true);
        f97552w = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_control_center_lynx_group_name", "link_control_center", String.class, true);
        f97553x = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_double_link_score", r110, r111, false);
        f97554y = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_control_center_url", "sslocal://webcast_lynxview?bdhm_pid=link_control_center&business_type=link_control_center&group=link_control_center&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_saas%2Fpages%2Flink_control_center%2Ftemplate.js", String.class, false);
        f97555z = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("create_link_hub_anniex_enable", r110, r111, false);
        A = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_interact_comment", r110, r111, false);
        B = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_panel_list_opt", r110, r111, false);
        C = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dynamic_hub_lynx_v2_opt", r106, r111, false);
        D = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_hub_lynx_params_v2", "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central_opt_v5%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1%26live_pk_enable_lynx_center_anim%3D1%26live_pk_enable_team_pk_bar%3D1%26live_pk_time_tik_sync_update%3D0%26score_ver_flag%3D1%26score_report_diff%3D800%26live_lynx_timer_correct%3D1%26live_pk_enable_lynx_mic%3D1%26use_regex_opt%3D1%26load_scene%3D7%26business_type%3Drev_link&business_type=rev_link&bdhm_pid=multi_dynamic_central\",\"tag\":\"multi_dynamic_central\",\"height_radio\":1.6,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":2,\"observer\":[\"channel_id\",\"link_anchor_list\",\"guest_info\",\"sei\",\"screen_info\",\"interact_timer_count\",\"clean_screen\",\"play_status\",\"play_remain_time\",\"team_task\",\"survival_remain_time\",\"survival_stage_index\",\"show_last_result\",\"intercom_data\",\"pk_status\",\"pk_score\",\"pk_result\",\"team_task\",\"remain_time\",\"clean_screen\",\"change_screen\",\"link_anchor_info\",\"sei_data\",\"survival_remain_time\",\"survival_stage_index\",\"interact_start_time\", \"need_last_result\", \"double_mute_status\", \"ai_anchor_list\"],\"init_data\":[],  \"to_front\":1, \"super_view\":1}", String.class, false);
        E = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[29]);
        Class<?> r136 = ((JsonAdapter) r41.a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r137 = vh7.b.f554981a;
        Constructor r138 = r137.get(r136);
        if (r138 != null) goto L16;
        r138 = r136.getConstructor(new Class[0]);
        if (r138 == null) goto L15;
        Constructor<? extends SerializableObjectJsonAdapterBase> r139 = r137.putIfAbsent(r136, (Constructor<? extends SerializableObjectJsonAdapterBase>) r138);
        if (r139 == null) goto L16;
        r138 = r139;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L16:
        Object r140 = ((SerializableObjectJsonAdapterBase) r138.newInstance(new Object[0])).createInstance();
        if (r140 == null) goto L21;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r141 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_ai_assistant_cellular_config", (r41.a) r140, r41.a.class, true);
        F = UltraSettingsManager.a().a(r141.f271017a, r141.f271018b, r141.getType(), r141.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r142 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_pk_match_bell_dialog_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_saas%2Fpages%2Fmatch_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=300&radius=8&pull_down_close=1&pull_down_indicator_not_show=1&compat_lynx_foldview=1&business_type=rev_link&panel_list_opt_backup=1", String.class, false);
        G = UltraSettingsManager.a().a(r142.f271017a, r142.f271018b, r142.getType(), r142.f271020d, r100[31]);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.AiAssistantCellularConfig");
    L5:
        r113 = "{\"lynx_url\":\"sslocal://webcast_lynxview?bdhm_pid=dynamic_central&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1\",\"tag\":\"dynamic_central\",\"height_radio\":1.0,\"width_radio\":1.0, \"margin_top\": -75, \"horizontal_align\":2,\"vertical_align\":1, \"super_view\":2, \"observer\":[\"pk_status\",\"change_screen\", \"remain_time\",\"team_task\",\"interact_start_time\",\"sei_data\"],\"init_data\":[\"remain_time\",\"interact_start_time\"]}";
        goto L6
    }
}
