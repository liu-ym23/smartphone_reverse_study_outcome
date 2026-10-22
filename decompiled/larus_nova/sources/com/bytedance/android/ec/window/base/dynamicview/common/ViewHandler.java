package com.bytedance.android.ec.window.base.dynamicview.common;

import android.view.View;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public abstract class ViewHandler {
    public ViewHandler() {
    }

    public abstract List<com.bytedance.android.ec.window.base.dynamicview.virtualview.i<? extends View>> c();

    public final Map<String, Function4<String, String, com.bytedance.android.ec.window.base.dynamicview.virtualview.j, e, k<?, ?>>> a() {
        List<com.bytedance.android.ec.window.base.dynamicview.virtualview.i<? extends View>> r100 = c();
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        com.bytedance.android.ec.window.base.dynamicview.virtualview.i r103 = (com.bytedance.android.ec.window.base.dynamicview.virtualview.i) r102.next();
        final String r104 = r103.f49305a;
        final vo.a<V> r105 = r103.f49306b;
        Pair r106 = TuplesKt.to(r104, new ViewHandler$getCreators$$inlined$associate$lambda$1(r104, r105, this));
        r101.put(r106.getFirst(), r106.getSecond());
        goto L4
    L6:
        return r101;
    }

    public static com.bytedance.android.ec.window.base.dynamicview.virtualview.g b(e r100) {
        if ((r100 instanceof oo.c) == false) goto L6;
        return new com.bytedance.android.ec.window.base.dynamicview.virtualview.b((oo.c) r100);
    L6:
        if ((r100 instanceof qo.c) == false) goto L9;
        return new com.bytedance.android.ec.window.base.dynamicview.virtualview.h((qo.c) r100);
    L9:
        if ((r100 instanceof po.b) == false) goto L12;
        return new com.bytedance.android.ec.window.base.dynamicview.virtualview.e((po.b) r100);
    L12:
        return com.bytedance.android.ec.window.base.dynamicview.virtualview.d.f49300a;
    }
}
