package com.android.server.permission.access.immutable;

import android.util.ArrayMap;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndexedReferenceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IndexedReferenceMap<K, I extends Immutable<M>, M extends I> implements Immutable<MutableIndexedReferenceMap<K, I, M>> {
    private final ArrayMap<K, MutableReference<I, M>> map;

    public /* synthetic */ IndexedReferenceMap(ArrayMap r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IndexedReferenceMap(ArrayMap<K, MutableReference<I, M>> r1) {
        this.map = r1;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final ArrayMap<K, MutableReference<I, M>> getMap$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.map;
    }

    public final int getSize() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final I get(K r2) {
        MutableReference<I, M> r0 = this.map.get(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (I) r0.get();
    }

    public final int indexOfKey(K r2) {
        return this.map.indexOfKey(r2);
    }

    public final K keyAt(int index) {
        return this.map.keyAt(index);
    }

    public final I valueAt(int r2) {
        return (I) this.map.valueAt(r2).get();
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIndexedReferenceMap<K, I, M> toMutable() {
        return new MutableIndexedReferenceMap(this);
    }

    public String toString() {
        return this.map.toString();
    }
}
