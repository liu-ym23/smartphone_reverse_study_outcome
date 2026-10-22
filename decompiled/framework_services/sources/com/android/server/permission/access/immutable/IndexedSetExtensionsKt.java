package com.android.server.permission.access.immutable;

import android.util.ArraySet;
import com.android.server.permission.jarjar.kotlin.collections.ArraysKt;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: IndexedSetExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexedSetExtensionsKt {
    public static final <T> IndexedSet<T> indexedSetOf(T... r3) {
        return new MutableIndexedSet(new ArraySet(ArraysKt.asList(r3)));
    }

    public static final <T> void plusAssign(MutableIndexedSet<T> r8, Collection<? extends T> r9) {
        Iterator<T> r2 = r9.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r8.add(r2.next());
        goto L4
    }
}
