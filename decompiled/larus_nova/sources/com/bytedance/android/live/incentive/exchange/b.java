package com.bytedance.android.live.incentive.exchange;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f69344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f69345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f69346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f69347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f69348e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_UI_STYLE", "getLIVE_INCENTIVE_INCOME_EXCHANGE_UI_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_PANEL_SCHEME", "getLIVE_INCENTIVE_INCOME_EXCHANGE_PANEL_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_TAX_SAVING", "getLIVE_INCENTIVE_INCOME_EXCHANGE_TAX_SAVING()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_NEW_STRUCTURE", "getLIVE_GIFT_PANEL_NEW_STRUCTURE()Lcom/bytedance/android/live/incentive/exchange/NewArchitectureGiftPanelConfig;", 1))};
        f69344a = r100;
        Class r101 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_ui_style", 0, r101, false);
        f69345b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_panel_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fexchange_panel%2Ftemplate.js&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1", String.class, false);
        f69346c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_tax_saving", 0, r101, false);
        f69347d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_new_architecture", new k(), k.class, false);
        f69348e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
    }
}
