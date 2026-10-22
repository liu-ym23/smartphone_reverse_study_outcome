package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean addAll(Collection<? super T> r4, Iterable<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "elements");
        if ((r5 instanceof Collection) == true) goto L5;
        boolean result = false;
        Iterator<? extends T> r1 = r5.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object item = r1.next();
        if (r4.add(item) == false) goto L8;
        result = true;
        goto L8
    L12:
        return result;
    L5:
        return r4.addAll((Collection) r5);
    }
}
