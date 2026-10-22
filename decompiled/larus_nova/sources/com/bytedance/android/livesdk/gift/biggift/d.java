package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f125915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f125916b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(d.class, "bigGiftComboLimitSwitch", "getBigGiftComboLimitSwitch()Lcom/bytedance/android/livesdk/gift/biggift/BigGiftComboLimitSwitch;", 1))};
        f125915a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_big_gift_combo_limit_switch", new a(), a.class, false);
        f125916b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
