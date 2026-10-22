package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f125917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f125918b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f125919c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "VS_LIVE_INTERACTIVE_CONTAINER_SHOW_TYPE", "getVS_LIVE_INTERACTIVE_CONTAINER_SHOW_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "SEND_GIFT_OPEN_RECHARGE_OPT", "getSEND_GIFT_OPEN_RECHARGE_OPT()Z", 1))};
        f125917a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("vs_live_interactive_container_show_type", 0, Integer.TYPE, false);
        f125918b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_open_recharge_opt", Boolean.FALSE, Boolean.TYPE, false);
        f125919c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }
}
