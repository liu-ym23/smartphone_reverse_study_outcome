package com.bytedance.android.live.revenuelink;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91711b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ENABLE_NEW_GAME_RECORD_LINK", "getLIVE_ENABLE_NEW_GAME_RECORD_LINK()Z", 1))};
        f91710a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_screen_cast_link_opt", Boolean.FALSE, Boolean.TYPE, false);
        f91711b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
