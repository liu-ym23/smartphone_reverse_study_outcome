package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129178c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_GIFT_TOP_EFFECT_USE_ANNIEX", "getLIVE_GIFT_TOP_EFFECT_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(d.class, "LIVE_GIFT_TOP_EFFECT_LOAD_AMAZING", "getLIVE_GIFT_TOP_EFFECT_LOAD_AMAZING()Z", 1))};
        f129176a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_top_effect_use_anniex", r101, r102, false);
        f129177b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_top_effect_load_amazing", Boolean.TRUE, r102, false);
        f129178c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }
}
