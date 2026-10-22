package com.bytedance.android.live.revenue.common;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f90821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f90822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f90823d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f90824e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f90825f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f90826g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f90827h = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_MEDIA_SPILT_MODE_ENABLE", "getLIVE_MEDIA_SPILT_MODE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LOCAL_TEST_USE_ONLINE_GECKO", "getLOCAL_TEST_USE_ONLINE_GECKO()Z", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_ANCHOR_DEVICE_RECORD_SCORE", "getLIVE_ANCHOR_DEVICE_RECORD_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_AUDIENCE_DEVICE_OVERALL_SCORE", "getLIVE_AUDIENCE_DEVICE_OVERALL_SCORE()F", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "LIVE_REVENUE_MIGRATE_ANNIEX", "getLIVE_REVENUE_MIGRATE_ANNIEX()Lcom/bytedance/android/live/revenue/common/settings/LiveRevenueAnnieXConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "REVENUE_LUCKY_BOX_SERVICE_SCHEMA", "getREVENUE_LUCKY_BOX_SERVICE_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b0.class, "REVENUE_DYNAMIC_SWITCHES", "getREVENUE_DYNAMIC_SWITCHES()Lcom/bytedance/android/live/revenue/common/settings/RevenueDynamicSwitches;", 1))};
        f90820a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_media_spilt_mode_enable", r101, r110, false);
        f90821b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("local_test_use_online_gecko", Boolean.FALSE, r110, false);
        f90822c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        Float r104 = Float.valueOf(7.5f);
        Class r105 = Float.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_device_model_record_score", r104, r105, false);
        f90823d = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_device_model_overall_score", r104, r105, false);
        f90824e = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_migrate_anniex", new ay0.b(), ay0.b.class, false);
        f90825f = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_lucky_box_service_schema", "https://10.79.163.16:8787/services/main.js", String.class, false);
        f90826g = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[5]);
        Class<?> r111 = ((JsonAdapter) ay0.d.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r112 = vh7.b.f554981a;
        Constructor r113 = r112.get(r111);
        if (r113 != null) goto L12;
        r113 = r111.getConstructor(new Class[0]);
        if (r113 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r114 = r112.putIfAbsent(r111, (Constructor<? extends SerializableObjectJsonAdapterBase>) r113);
        if (r114 == null) goto L12;
        r113 = r114;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r115 = ((SerializableObjectJsonAdapterBase) r113.newInstance(new Object[0])).createInstance();
        if (r115 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_dynamic_switches", (ay0.d) r115, ay0.d.class, false);
        f90827h = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[6]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.common.settings.RevenueDynamicSwitches");
    }

    public static final ay0.b a() {
        return (ay0.b) f90825f.getValue(null, f90820a[4]);
    }

    public static final ay0.d b() {
        return (ay0.d) f90827h.getValue(null, f90820a[6]);
    }
}
