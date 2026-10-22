package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f127390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f127391b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f127392c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f127393d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f127394e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f127395f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f127396g = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(d.class, "GIFT_ASSETS_FREQUENT_CALL_OPT", "getGIFT_ASSETS_FREQUENT_CALL_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftAssetsFrequentCallOpt;", 0))};
        f127390a = r100;
        d r101 = new d();
        f127396g = r101;
        Class<?> r102 = ((JsonAdapter) e.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r103 = vh7.b.f554981a;
        Constructor r104 = r103.get(r102);
        if (r104 != null) goto L12;
        r104 = r102.getConstructor(new Class[0]);
        if (r104 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r105 = r103.putIfAbsent(r102, (Constructor<? extends SerializableObjectJsonAdapterBase>) r104);
        if (r105 == null) goto L12;
        r104 = r105;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r106 = ((SerializableObjectJsonAdapterBase) r104.newInstance(new Object[0])).createInstance();
        if (r106 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_assets_frequent_call_opt", (e) r106, e.class, false);
        ReadOnlyProperty r108 = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[0]);
        f127391b = r108;
        e r109 = (e) r108.getValue(r101, r100[0]);
        f127392c = r109;
        f127393d = r109.r2();
        f127394e = r109.u0();
        f127395f = r109.M8();
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftAssetsFrequentCallOpt");
    }

    public d() {
    }
}
