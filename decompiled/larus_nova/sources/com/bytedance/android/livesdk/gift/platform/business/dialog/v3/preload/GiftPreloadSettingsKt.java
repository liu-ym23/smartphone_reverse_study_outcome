package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload;

import com.bytedance.android.livesdk.gift.configmodel.g0;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPreloadSettingsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f128177a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f128178b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f128179c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f128180d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f128181e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f128182f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(GiftPreloadSettingsKt.class, "panelUIPreloadConfig", "getPanelUIPreloadConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPanelUIPreloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(GiftPreloadSettingsKt.class, "giftNewPreloaderConfig", "getGiftNewPreloaderConfig()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/GiftPreloaderConfig;", 1))};
        f128177a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_ui_preload_config", new a(), a.class, false);
        f128178b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        f128179c = LazyKt.lazy(GiftPreloadSettingsKt$prefetchImageOpt$2.INSTANCE);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_new_preloader_config", new d(0), d.class, false);
        f128180d = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        f128181e = LazyKt.lazy(GiftPreloadSettingsKt$giftPreloaderConfig$2.INSTANCE);
        f128182f = LazyKt.lazy(GiftPreloadSettingsKt$enableNewGiftPreloader$2.INSTANCE);
    }

    public static final d a() {
        return (d) f128180d.getValue(null, f128177a[1]);
    }

    public static final g0 b() {
        return (g0) f128179c.getValue();
    }
}
