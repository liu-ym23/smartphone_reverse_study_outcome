package com.bytedance.android.live.profit.util;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f89097b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_TEMP_SHORT_TOUCH_COUNT_DOWN_TRIGGER_TIME", "getLIVE_TEMP_SHORT_TOUCH_COUNT_DOWN_TRIGGER_TIME()I", 1))};
        f89096a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_temp_short_touch_count_down_trigger_time", 10, Integer.TYPE, false);
        f89097b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
