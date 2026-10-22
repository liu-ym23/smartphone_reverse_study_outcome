package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f91935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f91936b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f91937c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f91938d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f91939e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f91940f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f91941g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f91942h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f91943i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f91944j = null;

    public k() {
    }

    public final boolean a() {
        return ((Boolean) f91942h.getValue(this, f91935a[6])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(k.class, "anchorLinkMixType", "getAnchorLinkMixType()I", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveLinkScreenRecordVolFix", "getLiveLinkScreenRecordVolFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "linkLiveCoreUpdateAfterMixEnable", "getLinkLiveCoreUpdateAfterMixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveMonitorRtcResolutionRedundancyThreshold", "getLiveMonitorRtcResolutionRedundancyThreshold()F", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveLinkAnotherLiveCoreWrite", "getLiveLinkAnotherLiveCoreWrite()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveEnableMixInterceptor", "getLiveEnableMixInterceptor()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveEnableUnMuteAudioByLeave", "getLiveEnableUnMuteAudioByLeave()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "linkSetVolumeReasonEnable", "getLinkSetVolumeReasonEnable()Z", 0))};
        f91935a = r100;
        f91944j = new k();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_mix_type", -1, Integer.TYPE, false);
        f91936b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_screen_record_vol_fix", r110, r111, false);
        f91937c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_mix_start_success_optimize", r103, r111, false);
        f91938d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_rtc_resolutio_redundancy_threshold", Float.valueOf(0.1f), Float.TYPE, false);
        f91939e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_core_another_live_core_write", r110, r111, false);
        f91940f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_mix_interceptor_enable", r110, r111, false);
        f91941g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_unmute_audio_on_leave_enable", r110, r111, false);
        f91942h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_set_volume_reason_enable", r103, r111, false);
        f91943i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
    }
}
