package com.bytedance.android.live.revlink.impl.settings.live;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.e;
import r11.g;
import r11.h;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f97580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f97581b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f97582c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f97583d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f97584e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f97585f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f97586g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f97587h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f97588i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f97589j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f97590k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f97591l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f97592m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f97593n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f97594o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f97595p = null;

    public b() {
    }

    public final h a() {
        return (h) f97589j.getValue(this, f97580a[8]);
    }

    public final e b() {
        return (e) f97584e.getValue(this, f97580a[3]);
    }

    public final double c() {
        return ((Number) f97592m.getValue(this, f97580a[11])).doubleValue();
    }

    public final w41.e d() {
        return (w41.e) f97594o.getValue(this, f97580a[13]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "livePkMixTypeDegradeEnable", "getLivePkMixTypeDegradeEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkPushStreamOptEnable", "getPkPushStreamOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorDebugEnable", "getMultiAnchorDebugEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkDegradeSetting", "getLiveLinkDegradeSetting()Lcom/bytedance/android/live/revlink/impl/config/LinkPerformanceSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkSingleViewEnable", "getPkSingleViewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultilinkerDoubleResolutionOptimize", "getLiveMultilinkerDoubleResolutionOptimize()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiAnchorSingleView", "getLiveMultiAnchorSingleView()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "anchorDataHandoverByPkIsStopEngine", "getAnchorDataHandoverByPkIsStopEngine()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkParamsDegrade", "getLinkParamsDegrade()Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkParamsAdjust", "getLinkParamsAdjust()Lcom/bytedance/android/live/revlink/impl/config/LinkPushAdjustSetting;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkEndEnableStreamMixerAnchorSelf", "getLivePkEndEnableStreamMixerAnchorSelf()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkRecordBigSmallRadio", "getLiveLinkRecordBigSmallRadio()D", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkRecordBigSmallOpt", "getLiveLinkRecordBigSmallOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRevlinkAudioAbnormalOpt", "getLiveRevlinkAudioAbnormalOpt()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevlinkAudioAbnormalCheckOptConfig;", 0))};
        f97580a = r100;
        f97595p = new b();
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_mix_type_degrade_enable", r110, r111, false);
        f97581b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_push_stream_opt_enable", r112, r111, false);
        f97582c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_debug_enable", r112, r111, false);
        f97583d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Class<?> r104 = ((JsonAdapter) e.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r105 = vh7.b.f554981a;
        Constructor r113 = r105.get(r104);
        if (r113 != null) goto L12;
        r113 = r104.getConstructor(new Class[0]);
        if (r113 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r105.putIfAbsent(r104, (Constructor<? extends SerializableObjectJsonAdapterBase>) r113);
        if (r106 == null) goto L12;
        r113 = r106;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r107 = ((SerializableObjectJsonAdapterBase) r113.newInstance(new Object[0])).createInstance();
        if (r107 == null) goto L59;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_degrade_setting", (e) r107, e.class, false);
        f97584e = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_single_view_enable", r110, r111, false);
        f97585f = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_double_resolution_optimize", r112, r111, false);
        f97586g = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_single_view", r110, r111, false);
        f97587h = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_data_handover_by_pk_is_stopengine", r110, r111, false);
        f97588i = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[7]);
        Class<?> r117 = ((JsonAdapter) h.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r118 = r105.get(r117);
        if (r118 != null) goto L24;
        r118 = r117.getConstructor(new Class[0]);
        if (r118 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r119 = r105.putIfAbsent(r117, r118);
        if (r119 == null) goto L24;
        r118 = r119;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r120 = r118.newInstance(new Object[0]).createInstance();
        if (r120 == null) goto L57;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_params_degrade", (h) r120, h.class, false);
        f97589j = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[8]);
        Class<?> r122 = ((JsonAdapter) g.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r123 = r105.get(r122);
        if (r123 != null) goto L36;
        r123 = r122.getConstructor(new Class[0]);
        if (r123 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r124 = r105.putIfAbsent(r122, r123);
        if (r124 == null) goto L36;
        r123 = r124;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r125 = r123.newInstance(new Object[0]).createInstance();
        if (r125 == null) goto L55;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_params_adjust", (g) r125, g.class, false);
        f97590k = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_end_enable_stream_mixer_anchor_self", r110, r111, false);
        f97591l = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_record_big_small_radio", Double.valueOf(0.24d), Double.TYPE, false);
        f97592m = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_record_big_small_opt", r110, r111, false);
        f97593n = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[12]);
        Class<?> r130 = ((JsonAdapter) w41.e.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r131 = r105.get(r130);
        if (r131 != null) goto L48;
        r131 = r130.getConstructor(new Class[0]);
        if (r131 == null) goto L47;
        Constructor<? extends SerializableObjectJsonAdapterBase> r132 = r105.putIfAbsent(r130, r131);
        if (r132 == null) goto L48;
        r131 = r132;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r133 = r131.newInstance(new Object[0]).createInstance();
        if (r133 == null) goto L53;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_audio_abnormal_opt", (w41.e) r133, w41.e.class, false);
        f97594o = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[13]);
        return;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevlinkAudioAbnormalCheckOptConfig");
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPushAdjustSetting");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPushDegradeSetting");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkPerformanceSetting");
    }
}
