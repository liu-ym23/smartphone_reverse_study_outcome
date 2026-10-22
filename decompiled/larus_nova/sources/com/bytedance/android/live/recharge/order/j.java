package com.bytedance.android.live.recharge.order;

import com.bytedance.android.live.revenue.common.MapPropertyDelegateKt;
import com.bytedance.android.live.revenue.common.w;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements Map<String, String>, KMutableMap {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f90109i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f90110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f90111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f90112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f90113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f90114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f90115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f90116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f90117h;

    static {
        f90109i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "chargeScene", "getChargeScene()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "chargeReason", "getChargeReason()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "eventModule", "getEventModule()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "promotionSource", "getPromotionSource()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "diamondExchangeOptimize", "getDiamondExchangeOptimize()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "guideSource", "getGuideSource()Ljava/lang/String;", 0))};
    }

    public final String a() {
        return (String) this.f90112c.a(this, f90109i[2]);
    }

    public final String b() {
        return (String) this.f90110a.a(this, f90109i[0]);
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f90112c.b(this, f90109i[2], r100);
    }

    @Override // java.util.Map
    public final void clear() {
        this.f90117h.clear();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f90111b.b(this, f90109i[1], r100);
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f90110a.b(this, f90109i[0], r100);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f90117h.isEmpty();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f90117h.putAll(r100);
    }

    public j() {
        this(new LinkedHashMap());
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.f90117h.entrySet();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f90117h.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f90117h.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.f90117h.values();
    }

    public j(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f90117h = r100;
        this.f90110a = MapPropertyDelegateKt.a(this, "request_page");
        this.f90111b = MapPropertyDelegateKt.a(this, "charge_scene");
        this.f90112c = MapPropertyDelegateKt.a(this, "charge_reason");
        this.f90113d = MapPropertyDelegateKt.a(this, "event_module");
        this.f90114e = MapPropertyDelegateKt.a(this, PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
        this.f90115f = MapPropertyDelegateKt.a(this, "diamond_exchange_optimize");
        this.f90116g = MapPropertyDelegateKt.a(this, "guide_source");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90117h.containsKey(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f90117h.containsValue(r101);
    }

    @Override // java.util.Map
    public final String get(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90117h.get(r101);
    }

    @Override // java.util.Map
    public final String remove(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90117h.remove(r101);
    }

    @Override // java.util.Map
    public final String put(String r100, String r101) {
        String r102 = r100;
        String r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        return this.f90117h.put(r102, r103);
    }
}
