package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f125910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f125911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f125912c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f125913d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SHOW_NOW_URGENT_DOWNLOAD", "getLIVE_GIFT_SHOW_NOW_URGENT_DOWNLOAD()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BIG_GIFT_ENABLE_LONG_CLICK", "getLIVE_GIFT_BIG_GIFT_ENABLE_LONG_CLICK()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "carnivalComboTrayLynxInfo", "getCarnivalComboTrayLynxInfo()Lcom/bytedance/android/livesdk/gift/biggift/configmodel/GiftCarnivalComboTrayViewConfig;", 1))};
        f125910a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_show_now_urgent_download", r101, r102, false);
        f125911b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_big_gift_enable_long_click", Boolean.FALSE, r102, false);
        f125912c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_carnival_combo_tray_lynx_info", new dy1.a(), dy1.a.class, false);
        f125913d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
    }
}
