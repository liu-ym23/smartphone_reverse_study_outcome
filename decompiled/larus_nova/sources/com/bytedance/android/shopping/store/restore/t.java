package com.bytedance.android.shopping.store.restore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t {
    public static final ej3.f a(ej3.f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$detachCallbacks");
        ej3.f r101 = new ej3.f();
        List<com.bytedance.android.ec.store.repository.vo.r> r102 = r100.f472859a;
        List<com.bytedance.android.ec.store.repository.dto.c> r103 = null;
        if (r102 == null) goto L8;
        List<com.bytedance.android.ec.store.repository.vo.r> r104 = r102;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L9;
        r105.add(((com.bytedance.android.ec.store.repository.vo.r) r106.next()).b());
    L9:
        r101.f472859a = r105;
        List<com.bytedance.android.ec.store.repository.vo.r> r107 = r100.f472860b;
        if (r107 == null) goto L15;
        List<com.bytedance.android.ec.store.repository.vo.r> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L13:
        if (r110.hasNext() == false) goto L16;
        r109.add(((com.bytedance.android.ec.store.repository.vo.r) r110.next()).b());
    L16:
        r101.f472860b = r109;
        r101.f472861c = r100.f472861c;
        List<com.bytedance.android.ec.store.repository.dto.c> r111 = r100.f472862d;
        if (r111 == null) goto L19;
        r103 = CollectionsKt.toList(r111);
    L19:
        r101.f472862d = r103;
        r101.f472863e = r100.f472863e;
        r101.f472864f = r100.f472864f;
        return r101;
    L15:
        r109 = null;
        goto L16
    L8:
        r105 = null;
        goto L9
    }
}
