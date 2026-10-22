package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
interface ReferenceEntry<K, V> {
    long getAccessTime();

    int getHash();

    @NullableDecl
    K getKey();

    @NullableDecl
    ReferenceEntry<K, V> getNext();

    ReferenceEntry<K, V> getNextInAccessQueue();

    ReferenceEntry<K, V> getNextInWriteQueue();

    ReferenceEntry<K, V> getPreviousInAccessQueue();

    ReferenceEntry<K, V> getPreviousInWriteQueue();

    LocalCache.ValueReference<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long r10);

    void setNextInAccessQueue(ReferenceEntry<K, V> r10);

    void setNextInWriteQueue(ReferenceEntry<K, V> r10);

    void setPreviousInAccessQueue(ReferenceEntry<K, V> r10);

    void setPreviousInWriteQueue(ReferenceEntry<K, V> r10);

    void setValueReference(LocalCache.ValueReference<K, V> r10);

    void setWriteTime(long r10);
}
