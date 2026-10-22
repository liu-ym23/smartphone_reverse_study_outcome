package com.bytedance.android.live.profit.taskcenter;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f89032b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f89033c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f89034d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f89035e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f89036f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f89037g = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_DAILY_LIMIT_ENABLE", "getLIVE_TASK_PANEL_DAILY_LIMIT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_LIFETIME_LIMIT_ENABLE", "getLIVE_TASK_PANEL_LIFETIME_LIMIT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_API_PRELOAD_CONFIG", "getLIVE_TASK_API_PRELOAD_CONFIG()Lcom/bytedance/android/live/profit/taskcenter/preload/PreloadSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_READY_TIMEOUT", "getLIVE_TASK_PANEL_READY_TIMEOUT()J", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_PANEL_FLEXIBLY_LOWER_FREQ", "getLIVE_PANEL_FLEXIBLY_LOWER_FREQ()Lcom/bytedance/android/live/profit/taskcenter/FlexiblyLowerFreqConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_INCENTIVE_PANEL_FEEDBACK_OPT", "getLIVE_INCENTIVE_PANEL_FEEDBACK_OPT()Lcom/bytedance/android/live/profit/taskcenter/IncentivePanelFeedbackOptConfig;", 1))};
        f89031a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_daily_limit_enable", r101, r102, false);
        f89032b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_lifetime_limit_enable", r101, r102, false);
        f89033c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_panel_access_intelligence", new com.bytedance.android.live.profit.taskcenter.preload.b(), com.bytedance.android.live.profit.taskcenter.preload.b.class, false);
        f89034d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_ready_timeout", 5L, Long.TYPE, false);
        f89035e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_panel_flexibly_lower_freq", new a(), a.class, false);
        f89036f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_panel_feedback_opt", new d(), d.class, false);
        f89037g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
    }
}
