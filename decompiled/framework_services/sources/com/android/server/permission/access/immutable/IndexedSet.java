package com.android.server.permission.access.immutable;

import android.util.ArraySet;
import com.android.server.permission.jarjar.kotlin.collections.CollectionsKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IndexedSet<T> implements Immutable<MutableIndexedSet<T>> {
    private final ArraySet<T> set;

    public /* synthetic */ IndexedSet(ArraySet r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IndexedSet(ArraySet<T> r1) {
        this.set = r1;
    }

    public final ArraySet<T> getSet$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.set;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final int getSize() {
        return this.set.size();
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean contains(T r2) {
        return this.set.contains(r2);
    }

    public final T elementAt(int r2) {
        return (T) CollectionsKt.elementAt(this.set, r2);
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIndexedSet<T> toMutable() {
        return new MutableIndexedSet(this);
    }

    public String toString() {
        return this.set.toString();
    }
}
