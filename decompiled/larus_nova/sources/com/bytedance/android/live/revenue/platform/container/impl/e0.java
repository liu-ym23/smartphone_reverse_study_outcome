package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91244b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e0.class, "LIVE_AIOLINK_V1_SEND_EVENT_PARAM_JSON", "getLIVE_AIOLINK_V1_SEND_EVENT_PARAM_JSON()Z", 1))};
        f91243a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_aiolink_v1_send_event_param_json", Boolean.TRUE, Boolean.TYPE, false);
        f91244b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
