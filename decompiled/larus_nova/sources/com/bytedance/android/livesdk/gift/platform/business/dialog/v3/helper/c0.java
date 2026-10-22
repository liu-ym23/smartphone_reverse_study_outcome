package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a f127388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f127389d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c0.class, "giftPanelUILoadOptConfig", "getGiftPanelUILoadOptConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelUILoadOptConfig;", 0))};
        f127386a = r100;
        f127389d = new c0();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_ui_load_opt_config", new f0(), f0.class, false);
        f127387b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        f127388c = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a) GiftPreloadSettingsKt.f128178b.getValue(null, GiftPreloadSettingsKt.f128177a[0]);
    }

    public c0() {
    }

    public static boolean a() {
        return f127388c.g();
    }
}
