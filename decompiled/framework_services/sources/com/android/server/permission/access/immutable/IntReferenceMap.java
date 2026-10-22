package com.android.server.permission.access.immutable;

import android.util.SparseArray;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntReferenceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IntReferenceMap<I extends Immutable<M>, M extends I> implements Immutable<MutableIntReferenceMap<I, M>> {
    private final SparseArray<MutableReference<I, M>> array;

    public /* synthetic */ IntReferenceMap(SparseArray r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IntReferenceMap(SparseArray<MutableReference<I, M>> r1) {
        this.array = r1;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final SparseArray<MutableReference<I, M>> getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.array;
    }

    public final int getSize() {
        return this.array.size();
    }

    public final boolean contains(int key) {
        return this.array.contains(key);
    }

    public final I get(int r2) {
        MutableReference<I, M> r0 = this.array.get(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (I) r0.get();
    }

    public final int indexOfKey(int key) {
        return this.array.indexOfKey(key);
    }

    public final int keyAt(int index) {
        return this.array.keyAt(index);
    }

    public final I valueAt(int r2) {
        return (I) this.array.valueAt(r2).get();
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIntReferenceMap<I, M> toMutable() {
        return new MutableIntReferenceMap(this);
    }

    public String toString() {
        return this.array.toString();
    }
}
