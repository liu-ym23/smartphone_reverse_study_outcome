package com.bytedance.android.livesdk.rank;

import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f156973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f156974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f156975c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f156976d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f156977e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f156978f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f156979g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f156980h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f156981i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f156982j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f156983k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f156984l = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_USE_VERTICAL_RANK_ENTRANCE", "getLIVE_USE_VERTICAL_RANK_ENTRANCE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_HOUR_RANK_ENTRANCE_LYNX_ENABLE", "getLIVE_HOUR_RANK_ENTRANCE_LYNX_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_HOUR_RANK_ENTRANCE_LYNX_SCHEMA", "getLIVE_HOUR_RANK_ENTRANCE_LYNX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_HOUR_RANK_ENTRANCE_AIR_LYNX_SCHEMA", "getLIVE_HOUR_RANK_ENTRANCE_AIR_LYNX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_HOUR_RANK_ENTRANCE_DEGRADE_ENABLE", "getLIVE_HOUR_RANK_ENTRANCE_DEGRADE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_HOUR_RANK_ENTRANCE_USE_ANNIX", "getLIVE_HOUR_RANK_ENTRANCE_USE_ANNIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_RANK_SCORE_DEGRADE_CONFIG", "getLIVE_RANK_SCORE_DEGRADE_CONFIG()Lcom/bytedance/android/livesdk/rank/config/RankScoreDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "USER_RANK_LYNX_SCHEME", "getUSER_RANK_LYNX_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "SAAS_USER_RANK_LYNX_SCHEME", "getSAAS_USER_RANK_LYNX_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_AUDIENCE_LIST_OPT", "getLIVE_AUDIENCE_LIST_OPT()Lcom/bytedance/android/livesdk/rank/config/LiveAudienceListOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_KTV_SINGING_RANK_CONFIG", "getLIVE_KTV_SINGING_RANK_CONFIG()Lcom/bytedance/android/livesdk/config/KtvSingRankConfig;", 1))};
        f156973a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_use_vertical_rank", r110, r111, false);
        f156974b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hour_rank_entrance_lynx_enable", r110, r111, false);
        f156975c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        boolean r103 = tb1.c.f545229a;
        Object r112 = bi1.a(Boolean.valueOf(r103), "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_douyin%2Fpages%2Fhour%2Fentrance%2Ftemplate.js&initialProps=%5B%22setting%3Alive_device_model_overall_score%3Alive_rank_score_degrade_config%22%5D");
        if (r112 != null) goto L5;
        r112 = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_huoshan%2Fpages%2Fhour%2Fentrance%2Ftemplate.js&initialProps=%5B%22setting%3Alive_device_model_overall_score%3Alive_rank_score_degrade_config%22%5D";
    L5:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hour_rank_entrance_lynx_schema", r112, String.class, false);
        f156976d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hour_rank_entrance_air_lynx_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_douyin%2Fpages%2Fhour%2Fentrance_air%2Ftemplate.js&initialProps=%5B%22setting%3Alive_device_model_overall_score%3Alive_rank_score_degrade_config%22%5D&air_strict_mode=1", String.class, false);
        f156977e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hour_rank_entrance_degrade_enable", r110, r111, false);
        f156978f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        Boolean r107 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_hour_rank_entrance_use_annix", r107, r111, false);
        f156979g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rank_score_degrade_config", new op2.b(), op2.b.class, false);
        f156980h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        Object r113 = bi1.a(Boolean.valueOf(r103), "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_douyin%2Fpages%2Faudiencelist%2Ftemplate.js%3FinitialProps%3D%255B%2522current_room%2522%252C%2522current_user%2522%252C%2522linkmic%2522%252C%2522setting%253Alive_audience_list_combine_config%253Alive_audience_list_combine_style%253Alive_anchor_perception_of_fans_badge_enable%253Alive_audience_list_new_rights_config%253Alive_enable_visibility_scope_share%253Alive_anchor_local_badge_enable%2522%255D%26defaultTab%3Dweekrank%26include_offline%3D0&load_taro=0&gravity=bottom&type=popup&lynx_thread=2&window_floating=0&rate_height=450&landscape_custom_width=1&abandon_coordinate=1&enable_lynx_bg=1");
        Object r114 = bi1.a(r107, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_huoshan%2Fpages%2Faudiencelist%2Ftemplate.js%3FinitialProps%3D%255B%2522current_room%2522%252C%2522current_user%2522%252C%2522linkmic%2522%252C%2522setting%253Alive_audience_list_combine_config%253Alive_audience_list_combine_style%253Alive_anchor_perception_of_fans_badge_enable%253Alive_audience_list_new_rights_config%253Alive_enable_visibility_scope_share%253Alive_anchor_local_badge_enable%2522%255D%26defaultTab%3Dweekrank%26include_offline%3D0&load_taro=0&gravity=bottom&type=popup&lynx_thread=2&window_floating=0&rate_height=450&landscape_custom_width=1&abandon_coordinate=1&enable_lynx_bg=1");
        if (r114 != null) goto L8;
        r114 = "";
    L8:
        if (r113 != null) goto L10;
        r113 = r114;
    L10:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("audience_list_lynx_scheme", r113, String.class, false);
        f156981i = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("saas_audience_list_lynx_scheme", "", String.class, false);
        f156982j = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_audience_list_opt", new op2.a(), op2.a.class, false);
        f156983k = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ktv_singing_rank_config", new f9(), f9.class, false);
        f156984l = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[10]);
    }
}
