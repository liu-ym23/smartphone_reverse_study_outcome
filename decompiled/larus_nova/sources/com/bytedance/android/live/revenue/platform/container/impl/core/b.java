package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91184b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f91185c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f91186d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "serviceCenterExitTimeout", "getServiceCenterExitTimeout()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "revenueServiceCenterSchema", "getRevenueServiceCenterSchema()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "revenueServiceUrls", "getRevenueServiceUrls()Ljava/util/List;", 1))};
        f91183a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_service_center_exit_timeout", 3000L, Long.TYPE, false);
        f91184b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_service_center_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_douyin%2Fpages%2Fservice_center%2Ftemplate.js&group=webcast_revenue", String.class, false);
        f91185c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_service_urls", CollectionsKt.emptyList(), hn3.a.f486091a, false);
        f91186d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
    }
}
