package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f126526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f126527b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(c.class, "anchorPostEffectDurationConfig", "getAnchorPostEffectDurationConfig()Lcom/bytedance/android/livesdk/gift/platform/business/anchor/model/AnchorTrayPostEffectConfig;", 1))};
        f126526a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_anchor_post_effect_config", new lz1.a(), lz1.a.class, false);
        f126527b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public static final lz1.a a() {
        return (lz1.a) f126527b.getValue(null, f126526a[0]);
    }
}
