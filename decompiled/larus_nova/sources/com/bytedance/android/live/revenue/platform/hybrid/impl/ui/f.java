package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91477b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "REVENUE_HYBRID_CARD_MEM_LEAK_SETTING", "getREVENUE_HYBRID_CARD_MEM_LEAK_SETTING()Z", 1))};
        f91476a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_hybrid_card_mem_leak_setting", Boolean.TRUE, Boolean.TYPE, false);
        f91477b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
