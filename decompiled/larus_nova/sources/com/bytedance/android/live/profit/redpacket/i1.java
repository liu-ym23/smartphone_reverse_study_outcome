package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f88619b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f88620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f88621d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f88622e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f88623f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f88624g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f88625h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f88626i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f88627j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f88628k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f88629l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ClientABTestKey<Integer> f88630m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f88631n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f88632o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f88633p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f88634q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f88635r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f88636s = null;

    public static final int a() {
        return ((Number) f88627j.getValue(null, f88618a[8])).intValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_ENVELOPE_LYNX_SCHEMA", "getLIVE_RED_ENVELOPE_LYNX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_ENVELOPE_LYNX_OPTIMIZE_STRATEGY", "getLIVE_RED_ENVELOPE_LYNX_OPTIMIZE_STRATEGY()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_DEFAULT_AVATAR_URLS", "getLIVE_DEFAULT_AVATAR_URLS()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "SEND_RED_ENVELOPE_URL", "getSEND_RED_ENVELOPE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_PACKET_RULE_PAGE", "getLIVE_RED_PACKET_RULE_PAGE()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "RED_PACKET_COUNT_DOWN_BEHAVIOR", "getRED_PACKET_COUNT_DOWN_BEHAVIOR()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "RED_PACKET_OPT_STYLE", "getRED_PACKET_OPT_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_BAN_USER_CARD_ENABLE", "getLIVE_BAN_USER_CARD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_RED_PACKET_RUSH_OPTIMIZE", "getLIVE_RED_PACKET_RUSH_OPTIMIZE()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_SEND_LYNX_RED_ENVELOPE_ENABLE", "getLIVE_SEND_LYNX_RED_ENVELOPE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_SEND_LYNX_RED_ENVELOPE_URL", "getLIVE_SEND_LYNX_RED_ENVELOPE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_SCHEMA", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_SHARE_VIEW_URL", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_SHARE_VIEW_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "REVENUE_LUCKY_BOX_SHORT_TOUCH_ANI_SCHEMA", "getREVENUE_LUCKY_BOX_SHORT_TOUCH_ANI_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SERVICE_LAZY_LOAD", "getLIVE_REDPACKET_SERVICE_LAZY_LOAD()I", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SHORT_TOUCH_ENTRY_VIEW_NATIVE", "getLIVE_REDPACKET_SHORT_TOUCH_ENTRY_VIEW_NATIVE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i1.class, "LIVE_REDPACKET_SHORT_TOUCH_USE_SHARE_VIEW", "getLIVE_REDPACKET_SHORT_TOUCH_USE_SHARE_VIEW()Z", 1))};
        f88618a = r100;
        String r110 = "";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_envelope_lynx_schema", "", String.class, false);
        f88619b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r111 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_envelope_lynx_optimize_strategy", 1, r111, false);
        f88620c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_default_avatar_urls", new ArrayList(), un3.a.f550770a, false);
        f88621d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        KmpEnv r104 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L5;
        String r105 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/h5_revenue_red_packet_douyin/template/pages/index.html?web_bg_color=#ffffff00&appType=douyin&radius=8&background_color=161823&rate_height=488&type=popup&gravity=bottom&horizontal_width=400";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_red_envelope_url", r105, String.class, false);
        f88622e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        if (KmpEnv.a() == false) goto L9;
        r110 = "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fh5_revenue_red_packet_douyin%2Ftemplate%2Fpages%2Findex.html%3Fweb_bg_color%3D%23ffffff00%26appType%3ddouyin%26open_type%3Drules%26radius%3d8%26background_color%3d161823&rate_height=488&type=popup&gravity=bottom&horizontal_width=400";
    L9:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_packet_rule_page", r110, String.class, false);
        f88623f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("red_packet_count_down_behavior", 0, r111, false);
        f88624g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("red_packet_opt_style_2", 0, r111, false);
        f88625h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        Boolean r112 = Boolean.TRUE;
        Class r113 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ban_user_card_enable", r112, r113, false);
        f88626i = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_red_packet_rush_optimize", 0, r111, false);
        f88627j = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[8]);
        Boolean r116 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_lynx_red_envelope_enable", r116, r113, true);
        f88628k = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_lynx_red_envelope_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fsend_lucky_box%2Ftemplate.js&rate_height=532&type=popup&gravity=bottom&horizontal_width=400&radius=8&web_bg_color=ff161823", String.class, true);
        f88629l = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[10]);
        f88630m = new ClientABTestKey("live_red_envelope_precision_key", r111, 0, 1);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fred_envelope_shorttouch%2Ftemplate.js&group=webcast_revenue&use_storage_group=1", String.class, false);
        f88631n = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_share_view_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_short_touch_lynx_douyin/pages/red_envelope_shorttouch_rl3/template.js?forest_sync_load=1", String.class, false);
        f88632o = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_short_touch_ani_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_short_touch_lynx_douyin%2Fpages%2Fred_envelope_ani_shorttouch%2Ftemplate.js&group=webcast_revenue&use_storage_group=1", String.class, false);
        f88633p = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_service_lazy_load", 0, r111, false);
        f88634q = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_short_touch_entry_view_native", r112, r113, false);
        f88635r = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_short_touch_use_share_view", r116, r113, false);
        f88636s = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[16]);
        return;
    L5:
        r105 = "https://webcast.ixigua.com/falcon/webcast_xigua/page/red_packet/index.html?web_bg_color=%23ff16171c&appType=toutiao&radius=8&background_color=16171c&height=470&type=popup&gravity=bottom";
        goto L6
    }
}
