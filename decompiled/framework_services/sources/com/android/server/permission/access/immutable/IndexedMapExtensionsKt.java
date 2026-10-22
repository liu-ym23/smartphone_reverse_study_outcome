package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndexedMapExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexedMapExtensionsKt {
    public static final <K, V> V getWithDefault(IndexedMap<K, V> r2, K r3, V r4) {
        if (r2 != null) goto L4;
        return r4;
    L4:
        int index = r2.indexOfKey(r3);
        if (index < 0) goto L8;
        return r2.valueAt(index);
    L8:
        return r4;
    }

    public static final <K, V> V putWithDefault(MutableIndexedMap<K, V> r3, K r4, V r5, V r6) {
        int index = r3.indexOfKey(r4);
        if (index < 0) goto L13;
        V r1 = r3.valueAt(index);
        if (Intrinsics.areEqual(r5, r1) == false) goto L7;
    L11:
        return r1;
    L7:
        if (Intrinsics.areEqual(r5, r6) == false) goto L9;
        r3.removeAt(index);
        goto L11
    L9:
        r3.putAt(index, r5);
        goto L11
    L13:
        if (Intrinsics.areEqual(r5, r6) == true) goto L15;
        r3.put(r4, r5);
    L15:
        return r6;
    }
}
