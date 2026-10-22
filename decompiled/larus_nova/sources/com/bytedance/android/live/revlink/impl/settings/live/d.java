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

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f97622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f97623b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f97624c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f97625d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f97626e = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(d.class, "roomLoadOptConfig", "getRoomLoadOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkRoomLoadOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "linkAnchorProfilePreciseExperiment", "getLinkAnchorProfilePreciseExperiment()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "linkAnchorProfileOptConsumeLevel", "getLinkAnchorProfileOptConsumeLevel()I", 0))};
        f97622a = r100;
        f97626e = new d();
        Class<?> r101 = ((JsonAdapter) w41.b.class.getAnnotation(JsonAdapter.class)).value();
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
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_room_load_opt_config", (w41.b) r105, w41.b.class, false);
        f97623b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_anchor_profile_precise_experiment", Boolean.FALSE, Boolean.TYPE, false);
        f97624c = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_anchor_profile_opt_consume_level", -100, Integer.TYPE, false);
        f97625d = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[2]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.live.model.RevLinkRoomLoadOptConfig");
    }

    public d() {
    }
}
