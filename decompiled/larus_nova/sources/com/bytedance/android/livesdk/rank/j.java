package com.bytedance.android.livesdk.rank;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f156967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f156968b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(j.class, "AUDIENCE_LIST_RL3_ROUTER_ENABLED", "getAUDIENCE_LIST_RL3_ROUTER_ENABLED()I", 1))};
        f156967a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("audience_list_rl3_router_enabled", 0, Integer.TYPE, false);
        f156968b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
