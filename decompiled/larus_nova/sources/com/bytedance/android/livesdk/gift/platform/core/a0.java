package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.configmodel.f1;
import com.bytedance.android.livesdk.gift.configmodel.j1;
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
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f130453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f130454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f130455c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f130456d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f130457e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f130458f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f130459g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f130460h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f130461i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f130462j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f130463k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f130464l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f130465m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f130466n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f130467o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f130468p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f130469q = null;

    public static final boolean a() {
        return ((Boolean) f130456d.getValue(null, f130453a[2])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) f130468p.getValue(null, f130453a[14])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f130466n.getValue(null, f130453a[12])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) f130469q.getValue(null, f130453a[15])).booleanValue();
    }

    public static final j1 e() {
        return (j1) f130455c.getValue(null, f130453a[1]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ENABLE_ASSETS_DOWNLOAD_CACHE_KEY", "getLIVE_GIFT_ENABLE_ASSETS_DOWNLOAD_CACHE_KEY()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_PANEL_STUTTER_OPT", "getLIVE_GIFT_PANEL_STUTTER_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftPanelStutterOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_EFFECTS_UPDATE_INCREMENT", "getLIVE_EFFECTS_UPDATE_INCREMENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GET_ASSET_FILE_SIZE_OPT", "getLIVE_GET_ASSET_FILE_SIZE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_IMAGE_FORMAT_WEBP_OPT", "getLIVE_GIFT_IMAGE_FORMAT_WEBP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_RESOURCE_CHECK_ANR_OPT", "getLIVE_GIFT_RESOURCE_CHECK_ANR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_SUPPORT_PK_EFFECT_GIFT", "getLIVE_SUPPORT_PK_EFFECT_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_ASSET_CACHE_DELETE_NEW_STRATEGY", "getLIVE_ASSET_CACHE_DELETE_NEW_STRATEGY()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_ASSET_ENTERROOM_DOWNLOAD_STATUS", "getLIVE_ASSET_ENTERROOM_DOWNLOAD_STATUS()I", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_GUEST_PRE_DOWNLOAD_ENABLE", "getLIVE_GIFT_GUEST_PRE_DOWNLOAD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "ENABLE_ASSETS_DELETE_TIME_LIMIT", "getENABLE_ASSETS_DELETE_TIME_LIMIT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GET_DISK_AVAILABLE_SIZE_OPT", "getLIVE_GET_DISK_AVAILABLE_SIZE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_BUFF_SHOW_NOW", "getLIVE_GIFT_BUFF_SHOW_NOW()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ASSET_RESPONSE_OPT", "getLIVE_GIFT_ASSET_RESPONSE_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/LiveEffectListOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_ASSET_FIND_FAIL_REPORT", "getLIVE_GIFT_ASSET_FIND_FAIL_REPORT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a0.class, "LIVE_GIFT_EFFECT_JSB_FORCE_RENDER_FILTER", "getLIVE_GIFT_EFFECT_JSB_FORCE_RENDER_FILTER()Z", 1))};
        f130453a = r100;
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_assets_download_cache_key", r110, r111, false);
        f130454b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class<?> r112 = ((JsonAdapter) j1.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r113 = vh7.b.f554981a;
        Constructor r114 = r113.get(r112);
        if (r114 != null) goto L11;
        Constructor<?> r115 = r112.getConstructor(new Class[0]);
        if (r115 == null) goto L10;
        r114 = r113.putIfAbsent(r112, (Constructor<? extends SerializableObjectJsonAdapterBase>) r115);
        if (r114 != null) goto L11;
        r114 = r115;
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L11:
        Object r116 = ((SerializableObjectJsonAdapterBase) r114.newInstance(new Object[0])).createInstance();
        if (r116 == null) goto L30;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_stutter_opt_config", (j1) r116, j1.class, false);
        f130455c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_effects_update_increment", r103, r111, false);
        f130456d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_get_asset_file_size_opt", r110, r111, false);
        f130457e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_image_format_use_webp", r110, r111, false);
        f130458f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_check_anr_opt", r110, r111, false);
        f130459g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_support_pk_effect_gift", r110, r111, false);
        f130460h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_cache_detele_new_strategy", r103, r111, false);
        f130461i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_enterroom_download_status", 0, Integer.TYPE, false);
        f130462j = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_guest_pre_download_enable", r103, r111, false);
        f130463k = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_assets_delete_time_limit", r103, r111, false);
        f130464l = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_get_disk_available_size_opt", r110, r111, false);
        f130465m = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_buff_show_now", r110, r111, false);
        f130466n = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[12]);
        Class<?> r122 = ((JsonAdapter) f1.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r123 = r113.get(r122);
        if (r123 != null) goto L23;
        r123 = r122.getConstructor(new Class[0]);
        if (r123 == null) goto L22;
        Constructor<? extends SerializableObjectJsonAdapterBase> r124 = r113.putIfAbsent(r122, r123);
        if (r124 == null) goto L23;
        r123 = r124;
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L23:
        Object r125 = r123.newInstance(new Object[0]).createInstance();
        if (r125 == null) goto L28;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_effect_list_api_opt_config", (f1) r125, f1.class, false);
        f130467o = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_asset_find_fail_report", r110, r111, false);
        f130468p = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_jsb_force_render_filter", r110, r111, false);
        f130469q = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[15]);
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveEffectListOptConfig");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.LiveGiftPanelStutterOptConfig");
    }
}
