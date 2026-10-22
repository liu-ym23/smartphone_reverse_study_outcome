package com.bytedance.android.shopping.abscontainer.arch.core.lifecycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends LifecycleImp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<LifecycleEnum, s33.c> f164145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<LifecycleEnum, ? extends List<? extends s33.b<?, ?>>> f164146b;

    public e(s33.a<?, ?> r110) {
        Intrinsics.checkNotNullParameter(r110, "bizModule");
        this.f164145a = MapsKt.emptyMap();
        this.f164146b = MapsKt.emptyMap();
        Iterable r100 = r110.f540456b;
        Map<LifecycleEnum, s33.c> r111 = r110.f540455a;
        this.f164145a = r111;
        LinkedHashMap r101 = new LinkedHashMap();
        LifecycleEnum[] r102 = LifecycleEnum.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.put(r102[r104], r100);
        r104 = r104 + 1;
        goto L3
    L5:
        Iterator<Map.Entry<LifecycleEnum, s33.c>> r112 = r111.entrySet().iterator();
    L7:
        if (r112.hasNext() == false) goto L32;
        Map.Entry<LifecycleEnum, s33.c> r105 = r112.next();
        LifecycleEnum r106 = r105.getKey();
        s33.c r107 = r105.getValue();
        Iterable r108 = r100;
        ArrayList r109 = new ArrayList();
        Iterator r113 = r108.iterator();
    L10:
        if (r113.hasNext() == false) goto L14;
        Object r114 = r113.next();
        if (r107.f540458a.contains(((s33.b) r114).j()) == false) goto L10;
        r109.add(r114);
        goto L10
    L14:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r108.iterator();
    L16:
        if (r116.hasNext() == false) goto L20;
        Object r117 = r116.next();
        if (r107.f540459b.contains(((s33.b) r117).j()) == false) goto L16;
        r115.add(r117);
        goto L16
    L20:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r108.iterator();
    L22:
        if (r119.hasNext() == false) goto L31;
        Object r120 = r119.next();
        s33.b r121 = (s33.b) r120;
        if (r107.f540458a.contains(r121.j()) == false) goto L26;
    L28:
        boolean r122 = false;
    L29:
        if (r122 == false) goto L22;
        r118.add(r120);
        goto L22
    L26:
        if (r107.f540459b.contains(r121.j()) == true) goto L28;
        r122 = true;
        goto L29
    L31:
        r101.put(r106, CollectionsKt.plus(CollectionsKt.plus(r109, r118), r115));
        goto L7
    L32:
        this.f164146b = r101;
    }

    @Override // com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.LifecycleImp
    public final List<s33.b<?, ?>> i(LifecycleEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        List<s33.b<?, ?>> r101 = (List) this.f164146b.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }
}
