package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f91391c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f91392d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f91393e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f91394f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f91395g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f91396h = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewMinServiceCenterVersion", "getShareViewMinServiceCenterVersion()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewTriggerServiceCenterLoad", "getShareViewTriggerServiceCenterLoad()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewSharerSchema", "getShareViewSharerSchema()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewImmediateCreateStandaloneSharer", "getShareViewImmediateCreateStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewEnableStandaloneSharer", "getShareViewEnableStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewForceEnableStandaloneSharer", "getShareViewForceEnableStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewEnableFirstScreen", "getShareViewEnableFirstScreen()Z", 1))};
        f91389a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_min_service_center_version", "1.0.0.3745", String.class, false);
        f91390b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r102 = Boolean.FALSE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_trigger_service_center_load", r102, r110, false);
        f91391c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_sharer_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_douyin%2Fpages%2Fshare_view_sharer_speedy_v2%2Ftemplate.js&group=webcast_revenue&use_storage_group=1&mix_container_type=annie", String.class, false);
        f91392d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        Boolean r105 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_immediate_create_standalone_sharer", r105, r110, false);
        f91393e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_enable_standalone", r102, r110, false);
        f91394f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_force_enable_standalone", r102, r110, false);
        f91395g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enableShareViewFirstScreen", r105, r110, false);
        f91396h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
    }
}
