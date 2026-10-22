package com.bytedance.android.livesdk.gift.platform.business.effect;

import com.bytedance.android.livesdk.gift.configmodel.h1;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129187c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f129188d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f129189e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f129190f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f129191g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f129192h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f129193i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f129194j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f129195k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f129196l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f129197m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f129198n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f129199o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f129200p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f129201q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f129202r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f129203s = null;

    public static final boolean a() {
        return ((Boolean) f129188d.getValue(null, f129185a[2])).booleanValue();
    }

    public static final long b() {
        return ((Number) f129199o.getValue(null, f129185a[13])).longValue();
    }

    public static final long c() {
        return ((Number) f129202r.getValue(null, f129185a[16])).longValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSETS_MANAGER_READ_SETTING_OPTIMIZE", "getLIVE_ASSETS_MANAGER_READ_SETTING_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_MULTI_ASSET_FAST_PLAY_ENABLE", "getLIVE_GIFT_MULTI_ASSET_FAST_PLAY_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_H265_RESOURCE_ENABLE", "getLIVE_GIFT_H265_RESOURCE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SUPER_IMAGE_RESOLUTION_ENABLE", "getLIVE_GIFT_SUPER_IMAGE_RESOLUTION_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_CANCEL_DOWNLOAD_STORAGE_POOL", "getLIVE_ASSET_CANCEL_DOWNLOAD_STORAGE_POOL()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_DURATION_OPT", "getLIVE_STICKER_EFFECT_DURATION_OPT()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_TRACE_OPT", "getLIVE_STICKER_EFFECT_TRACE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_CANCEL_CREATE_PNG", "getLIVE_STICKER_EFFECT_CANCEL_CREATE_PNG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_ISSUE_REPORT_GIFT_INFO", "getLIVE_GIFT_ISSUE_REPORT_GIFT_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_EFFECT_FIRST_FRAME", "getLIVE_STICKER_EFFECT_FIRST_FRAME()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_STICKER_EFFECT_OPT_CONFIG", "getLIVE_GIFT_STICKER_EFFECT_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/core/sticker/GiftStickerSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_EFFECT_MESSAGE_LISTENER_ENABLE", "getLIVE_GIFT_EFFECT_MESSAGE_LISTENER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DISABLE_GUEST_FACE_GIFT", "getLIVE_DISABLE_GUEST_FACE_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_STICKER_MESSAGE_EXPIRED_TIME_SECONDS", "getLIVE_GIFT_STICKER_MESSAGE_EXPIRED_TIME_SECONDS()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_GIFT_SUPPORT_RESET_TIME", "getLIVE_STICKER_GIFT_SUPPORT_RESET_TIME()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TALK_LINK_VIEW_LEAK_OPT", "getLIVE_TALK_LINK_VIEW_LEAK_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_STICKER_GIFT_EFFECT_PLAY_INTERVAL", "getLIVE_STICKER_GIFT_EFFECT_PLAY_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SEND_TO_EFFECT_CONFIG", "getLIVE_GIFT_SEND_TO_EFFECT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftEffectCommunicateConfig;", 1))};
        f129185a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_assets_manager_read_setting_optimize", r110, r111, false);
        f129186b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_multi_asset_fast_play_enable", r112, r111, false);
        f129187c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_h265_resource_enable", r112, r111, false);
        f129188d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_265_super_resource_enable", r112, r111, false);
        f129189e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_cancel_download_storage_pool", -1, Integer.TYPE, false);
        f129190f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        Long r106 = Long.valueOf(1000);
        Class r107 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_duration_opt", r106, r107, false);
        f129191g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_trace_opt", r110, r111, false);
        f129192h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_cancel_create_png", r110, r111, false);
        f129193i = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_issue_report_gift_info", r110, r111, false);
        f129194j = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_effect_first_frame_log", r110, r111, false);
        f129195k = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[9]);
        Class<?> r116 = ((JsonAdapter) com.bytedance.android.livesdk.gift.platform.core.sticker.a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r117 = vh7.b.f554981a;
        Constructor r118 = r117.get(r116);
        if (r118 != null) goto L12;
        r118 = r116.getConstructor(new Class[0]);
        if (r118 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r119 = r117.putIfAbsent(r116, (Constructor<? extends SerializableObjectJsonAdapterBase>) r118);
        if (r119 == null) goto L12;
        r118 = r119;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r120 = ((SerializableObjectJsonAdapterBase) r118.newInstance(new Object[0])).createInstance();
        if (r120 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sticker_effect_opt_config", (com.bytedance.android.livesdk.gift.platform.core.sticker.a) r120, com.bytedance.android.livesdk.gift.platform.core.sticker.a.class, false);
        f129196l = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_message_listener_enable", r110, r111, false);
        f129197m = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_guest_face_gift", r112, r111, false);
        f129198n = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sticker_message_expired_time_seconds", Long.valueOf(300), r107, false);
        f129199o = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_face_sticker_reset_time_enable", r112, r111, false);
        f129200p = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_talk_link_view_leak_opt", r110, r111, false);
        f129201q = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sticker_gift_effect_play_interval", Long.valueOf(0), r107, false);
        f129202r = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[16]);
        Class<?> r128 = ((JsonAdapter) h1.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r129 = r117.get(r128);
        if (r129 != null) goto L24;
        r129 = r128.getConstructor(new Class[0]);
        if (r129 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r130 = r117.putIfAbsent(r128, r129);
        if (r130 == null) goto L24;
        r129 = r130;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r131 = r129.newInstance(new Object[0]).createInstance();
        if (r131 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_communication_config", (h1) r131, h1.class, false);
        f129203s = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[17]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveGiftEffectCommunicateConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.sticker.GiftStickerSettingConfig");
    }
}
