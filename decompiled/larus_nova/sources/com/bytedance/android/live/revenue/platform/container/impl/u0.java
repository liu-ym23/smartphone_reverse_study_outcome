package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91350a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91351b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(u0.class, "aioLinkCallJsOnComputationThread", "getAioLinkCallJsOnComputationThread()Z", 1))};
        f91350a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("aiolink_call_js_on_computation_thread", Boolean.TRUE, Boolean.TYPE, false);
        f91351b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
