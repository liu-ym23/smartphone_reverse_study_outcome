package com.bytedance.android.window.shop.innerflow.repo;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.JsonElement;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import up3.g;

/* JADX INFO: loaded from: classes14.dex */
public final class b<E, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Pair<Class<?>, Function1<Object, T>>> f189191a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<Integer, ? extends Pair<? extends Class<?>, ? extends Function1<Object, ? extends T>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f189191a = r100;
    }

    public final Object a(g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r100.a() == null) goto L5;
    L7:
        Pair<Class<?>, Function1<Object, T>> r101 = this.f189191a.get(r100.b());
        if (r101 != null) goto L10;
        return null;
    L10:
        Class<?> r102 = r101.component1();
        Function1<Object, T> r103 = r101.component2();
        JsonElement r104 = r100.a();
        if (r102 == null) goto L14;
        if (r104 == null) goto L14;
        Object r105 = com.bytedance.android.window.shop.repository.dto.d.a(r104, r102);
    L16:
        if (r105 != null) goto L19;
        return null;
    L19:
        return r103.invoke(r105);
    L14:
        r105 = null;
        goto L16
    L5:
        if (r100.b() != null) goto L7;
        return null;
    }
}
