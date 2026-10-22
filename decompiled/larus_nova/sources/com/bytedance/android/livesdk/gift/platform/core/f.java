package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.configmodel.g2;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f130510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f130511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f130512c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f130513d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f130514e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f130515f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f130516g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f130517h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f130518i = null;

    public static final g2 a() {
        return (g2) f130514e.getValue(null, f130510a[3]);
    }

    public static final boolean b() {
        return ((Boolean) f130511b.getValue(null, f130510a[0])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "SEND_GIFT_TRACE_LOG_ENABLE", "getSEND_GIFT_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "SEND_GIFT_ACTION_TRACE_LOG_ENABLE", "getSEND_GIFT_ACTION_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "RECEIVE_GIFT_TRACE_LOG_ENABLE", "getRECEIVE_GIFT_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_SEND_PLAY_NOW_CONFIG", "getLIVE_GIFT_SEND_PLAY_NOW_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveSendGiftPlayNowConfig;", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_ENABLE_RECEIVER_ANR_OPT", "getLIVE_GIFT_ENABLE_RECEIVER_ANR_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_NEW_VIDEO_LINK_MODE_SUPPORT_ALLMIC", "getLIVE_GIFT_NEW_VIDEO_LINK_MODE_SUPPORT_ALLMIC()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_ALLMIC_RECEIVER_CHANGE_SUPPORT_CALLBACK", "getLIVE_GIFT_ALLMIC_RECEIVER_CHANGE_SUPPORT_CALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "LIVE_GIFT_CHANGE_RECEIVER_LIST_SUPPORT_CALLBACK", "getLIVE_GIFT_CHANGE_RECEIVER_LIST_SUPPORT_CALLBACK()Z", 1))};
        f130510a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_gift_full_link_monitor", r110, r111, false);
        f130511b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_monitro_send_gift_action", r110, r111, false);
        f130512c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_receiver_full_link", r110, r111, false);
        f130513d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Class<?> r104 = ((JsonAdapter) g2.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r105 = vh7.b.f554981a;
        Constructor r112 = r105.get(r104);
        if (r112 != null) goto L12;
        r112 = r104.getConstructor(new Class[0]);
        if (r112 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r105.putIfAbsent(r104, (Constructor<? extends SerializableObjectJsonAdapterBase>) r112);
        if (r106 == null) goto L12;
        r112 = r106;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r107 = ((SerializableObjectJsonAdapterBase) r112.newInstance(new Object[0])).createInstance();
        if (r107 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_send_play_now_config", (g2) r107, g2.class, false);
        f130514e = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[3]);
        Boolean r109 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_receiver_anr_opt", r109, r111, false);
        f130515f = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_social_video_link_allmic", r109, r111, false);
        f130516g = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_allmic_receiver_change_support_callback", r110, r111, false);
        f130517h = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_change_receiver_list_support_callback", r110, r111, false);
        f130518i = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[7]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.configmodel.RevLiveSendGiftPlayNowConfig");
    }
}
