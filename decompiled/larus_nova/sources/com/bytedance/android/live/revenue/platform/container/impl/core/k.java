package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91204a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91205b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f91206c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f91207d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_SERVICE_CENTER_REUSE", "getLIVE_SERVICE_CENTER_REUSE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_SERVICE_CENTER_AIOLINK_ASYNC", "getLIVE_SERVICE_CENTER_AIOLINK_ASYNC()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_REDPACKET_SERVICE_LAZY_LOAD", "getLIVE_REDPACKET_SERVICE_LAZY_LOAD()Z", 1))};
        f91204a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_service_center_reuse", r101, r102, false);
        f91205b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_service_center_aiolink_async", r101, r102, false);
        f91206c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_service_lazy_load", r101, r102, false);
        f91207d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
    }

    public static final boolean a() {
        return ((Boolean) f91205b.getValue(null, f91204a[0])).booleanValue();
    }
}
