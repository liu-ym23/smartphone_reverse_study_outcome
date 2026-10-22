package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f88231b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f88232c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f88233d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f88234e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f88235f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f88236g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f88237h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f88238i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f88239j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f88240k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f88241l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f88242m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f88243n = null;

    public static final boolean a() {
        return ((Boolean) f88242m.getValue(null, f88230a[11])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) f88241l.getValue(null, f88230a[10])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f88235f.getValue(null, f88230a[4])).booleanValue();
    }

    public static final long d() {
        return ((Number) f88237h.getValue(null, f88230a[6])).longValue();
    }

    public static final m0 e() {
        return (m0) f88231b.getValue(null, f88230a[0]);
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(w2.class, "LOTTERY_CONFIG", "getLOTTERY_CONFIG()Lcom/bytedance/android/live/profit/lottery/LotteryConfig;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LOTTERY_STI_FINISH_WEBP_URL", "getLOTTERY_STI_FINISH_WEBP_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIFE_LOTTERY_CONFIG", "getLIFE_LOTTERY_CONFIG()Lcom/bytedance/android/live/profit/lottery/LotteryConfig$LifeLotteryConfig;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DYNAMIC_TYPE_CONFIG", "getLIVE_LOTTERY_DYNAMIC_TYPE_CONFIG()Ljava/util/ArrayList;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAWING_DISAPPEARABLE", "getLIVE_LOTTERY_DRAWING_DISAPPEARABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_MAX_COUNTDOWN_DISMISS", "getLIVE_LOTTERY_MAX_COUNTDOWN_DISMISS()J", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAW_RESULT_DELAY", "getLIVE_LOTTERY_DRAW_RESULT_DELAY()J", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_HOT_DRAW_OPT", "getLIVE_LOTTERY_HOT_DRAW_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAW_BIGCARD_FIX", "getLIVE_LOTTERY_DRAW_BIGCARD_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAWING_DIALOG_FIX", "getLIVE_LOTTERY_DRAWING_DIALOG_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_ATMOSPHERE", "getLIVE_LOTTERY_ATMOSPHERE()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_ENABLE_SHORTTOUCH_TERM_STRATEGY", "getLIVE_ENABLE_SHORTTOUCH_TERM_STRATEGY()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_LOCALINFO_CACHE_ENABLE", "getLIVE_LOTTERY_LOCALINFO_CACHE_ENABLE()Z", 1))};
        f88230a = r100;
        m0 r110 = new m0();
        r110.enabled = 0;
        r110.anchorLotteryCreateUri = "";
        r110.anchorLotteryDetailUri = "";
        r110.audienceLotteryWaitUri = "";
        r110.audienceLotteryResultUri = "";
        r110.lotteryNetworkErrorString = "";
        r110.reviewingString = "";
        r110.rejectedTitleString = "";
        r110.rejectedMessageString = "";
        r110.redDotEnabled = 0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_config", r110, m0.class, false);
        f88231b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_sti_finish_webp_url", com.bytedance.android.live.revenue.common.v0.a("obj/live-android/ttlive_lottery_sti_finish.webp"), String.class, false);
        f88232c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        m0.a r103 = new m0.a();
        r103.anchorLotteryDetailUri = "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Flottery%2Fanchor_detail%2Findex.html%3Fweb_bg_color%3Dff000000&height=440&type=popup&gravity=bottom&radius=8";
        r103.audienceLotteryWaitUri = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fmp_live_lynx_entry_coupon%2Flottery_involve%2Findex%2Ftemplate.js&load_taro=0&height_percent=100&width_percent=100&open_animate=0&mask_click_disable=0&lottery_from_source=icon";
        r103.audienceLotteryResultUri = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fmp_live_lynx_entry_coupon%2Flottery_result%2Findex%2Ftemplate.js&load_taro=0&height_percent=100&width_percent=100&open_animate=0&mask_click_disable=1&top_level=1&allowing_state_loss=1";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_life_lottery_config", r103, m0.a.class, false);
        f88233d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_common_config", new ArrayList(), un3.a.f550771b, false);
        f88234e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        Boolean r106 = Boolean.TRUE;
        Class r107 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_drawing_disappearable", r106, r107, false);
        f88235f = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[4]);
        Class r109 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_max_countdown_dismiss", 90000L, r109, false);
        f88236g = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_draw_result_delay", 0L, r109, false);
        f88237h = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[6]);
        Boolean r113 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_hot_draw_opt", r113, r107, false);
        f88238i = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_draw_bigcard_fix", r113, r107, false);
        f88239j = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_drawing_dialog_fix", r113, r107, false);
        f88240k = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_atmosphere", r106, r107, false);
        f88241l = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_shorttouch_term_strategy", r106, r107, false);
        f88242m = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_localinfo_cache_enable", r106, r107, false);
        f88243n = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[12]);
    }
}
