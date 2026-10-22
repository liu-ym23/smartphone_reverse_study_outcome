package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.recharge.util.GiftToRechargeParamsKey;
import com.bytedance.android.live.revenue.common.KmpMapPropertyDelegateKt;
import com.bytedance.android.live.revenue.common.s;
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
public final class a implements Map<String, String>, KMutableMap {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89999d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f90000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f90001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f90002c;

    static {
        f89999d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "giftNoBalanceScene", "getGiftNoBalanceScene()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "chargeReason", "getChargeReason()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "giftPanelSessionId", "getGiftPanelSessionId()Ljava/lang/String;", 0))};
    }

    public a() {
        this(0);
    }

    @Override // java.util.Map
    public final void clear() {
        this.f90002c.clear();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f90002c.isEmpty();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f90002c.putAll(r100);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.f90002c.entrySet();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f90002c.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f90002c.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.f90002c.values();
    }

    public a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f90002c = r100;
        this.f90000a = KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_GIFT_NO_BALANCE_SCENE.getKeyName());
        KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_SEND_GIFT_CHARGE_REASON.getKeyName());
        this.f90001b = KmpMapPropertyDelegateKt.a(this, GiftToRechargeParamsKey.KEY_GIFT_PANEL_SESSION_ID.getKeyName());
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90002c.containsKey(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f90002c.containsValue(r101);
    }

    @Override // java.util.Map
    public final String get(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90002c.get(r101);
    }

    @Override // java.util.Map
    public final String remove(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f90002c.remove(r101);
    }

    public /* synthetic */ a(int r100) {
        this(new LinkedHashMap());
    }

    @Override // java.util.Map
    public final String put(String r100, String r101) {
        String r102 = r100;
        String r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        return this.f90002c.put(r102, r103);
    }
}
