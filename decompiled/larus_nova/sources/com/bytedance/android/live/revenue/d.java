package com.bytedance.android.live.revenue;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91042b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_KMP_INITIALIZER_ENABLE_SWITCH", "getLIVE_KMP_INITIALIZER_ENABLE_SWITCH()Z", 1))};
        f91041a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_kmp_initializer_enable_switch", Boolean.TRUE, Boolean.TYPE, false);
        f91042b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
