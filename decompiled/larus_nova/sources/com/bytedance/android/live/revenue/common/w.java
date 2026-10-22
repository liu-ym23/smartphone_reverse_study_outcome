package com.bytedance.android.live.revenue.common;

import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class w<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f91010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<V> f91011b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(K r100, Function0<? extends V> r101) {
        Intrinsics.checkNotNullParameter(r101, "fallbackValue");
        this.f91010a = r100;
        this.f91011b = r101;
    }

    public final V a(Map<K, ? extends V> r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        V r102 = r100.get(this.f91010a);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return this.f91011b.invoke();
    }

    public final void b(Map<K, V> r100, KProperty<?> r101, V r102) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        r100.put(this.f91010a, r102);
    }
}
