package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126597b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_BANNER_REV_CONTAINER_SWITCH", "getLIVE_GIFT_BANNER_REV_CONTAINER_SWITCH()I", 1))};
        f126596a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_banner_rev_container_switch", 0, Integer.TYPE, false);
        f126597b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
