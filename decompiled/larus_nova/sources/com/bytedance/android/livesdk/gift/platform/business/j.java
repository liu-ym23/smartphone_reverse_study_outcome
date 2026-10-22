package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.w2;
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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f129672b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f129673c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f129674d = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_SPECIAL_COMBO_RANGE", "getLIVE_GIFT_TRAY_SPECIAL_COMBO_RANGE()Lcom/bytedance/android/livesdk/gift/configmodel/TraySpecialComboRangeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_UNIQUEPREKEY_SUPPORT_TOUSER", "getLIVE_GIFT_TRAY_UNIQUEPREKEY_SUPPORT_TOUSER()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_GIFT_TRAY_GROUP_MODE_SERVER_CONTROL", "getLIVE_GIFT_TRAY_GROUP_MODE_SERVER_CONTROL()Z", 1))};
        f129671a = r100;
        Class<?> r101 = ((JsonAdapter) w2.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L12;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L12;
        r103 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_new_combo_and_tray_style_config", (w2) r105, w2.class, false);
        f129672b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        Boolean r107 = Boolean.TRUE;
        Class r108 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_uniqueprekey_support_touser", r107, r108, false);
        f129673c = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r110 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_tray_group_mode_server_control", Boolean.FALSE, r108, false);
        f129674d = UltraSettingsManager.a().a(r110.f271017a, r110.f271018b, r110.getType(), r110.f271020d, r100[2]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.TraySpecialComboRangeConfig");
    }

    public static final boolean a() {
        return ((Boolean) f129674d.getValue(null, f129671a[2])).booleanValue();
    }

    public static final w2 b() {
        return (w2) f129672b.getValue(null, f129671a[0]);
    }
}
