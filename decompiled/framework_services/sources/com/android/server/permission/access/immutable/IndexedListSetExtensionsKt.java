package com.android.server.permission.access.immutable;

/* JADX INFO: compiled from: IndexedListSetExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexedListSetExtensionsKt {
    public static final <T> MutableIndexedListSet<T> plus(IndexedListSet<T> r5, T r6) {
        MutableIndexedListSet<T> r0 = r5.toMutable();
        r0.add(r6);
        return r0;
    }
}
