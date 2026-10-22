package com.bytedance.android.live.revlink.impl.settings.live;

import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f97570a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f97571b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f97572c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f97573d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f97574e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f97575f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f97576g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f97577h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f97578i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f97579j = null;

    public a() {
    }

    public final float a() {
        return ((Number) f97573d.getValue(this, f97570a[2])).floatValue();
    }

    public final float b() {
        return ((Number) f97571b.getValue(this, f97570a[0])).floatValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "pkTopMarginRatio", "getPkTopMarginRatio()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveJumpFromLivePlayActivityFalseAsNoTransparent", "getLiveJumpFromLivePlayActivityFalseAsNoTransparent()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePcAnchorInteractVideoMarginTop", "getLivePcAnchorInteractVideoMarginTop()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveWangzheGameLinkMarginTop", "getLiveWangzheGameLinkMarginTop()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pushSizeMap", "getPushSizeMap()Ljava/util/HashMap;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pushStreamSizeOpt", "getPushStreamSizeOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePlayerLayoutOpt", "getLivePlayerLayoutOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveScreenRecrodJudgeLiveCore", "getLiveScreenRecrodJudgeLiveCore()Z", 0))};
        f97570a = r100;
        f97579j = new a();
        Float r110 = Float.valueOf(0.02f);
        Class r111 = Float.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_top_spacing_ratio_addition", r110, r111, false);
        f97571b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.TRUE;
        Class r113 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_jump_from_live_play_activity_false_as_no_transparent", r112, r113, false);
        f97572c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_anchor_interact_video_margin_top", Float.valueOf(0.19f), r111, false);
        f97573d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wang_zhe_game_link_margin_top", Float.valueOf(0.16f), r111, false);
        f97574e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_map", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("1920", "1088"), TuplesKt.to("1280", "720"), TuplesKt.to("960", "544"), TuplesKt.to("864", "480")}), zn3.a.f572925k, false);
        f97575f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        Boolean r106 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_opt", r106, r113, false);
        f97576g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a(LiveInitSettingKeys.LIVE_PLAYER_LAYOUT_OPT_V1, r106, r113, false);
        f97577h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_screen_record_judge_live_core_param", r106, r113, false);
        f97578i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
    }
}
