package com.android.server.permission.access.immutable;

import android.util.SparseArray;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IntMap<T> implements Immutable<MutableIntMap<T>> {
    private final SparseArray<T> array;

    public /* synthetic */ IntMap(SparseArray r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IntMap(SparseArray<T> r1) {
        this.array = r1;
    }

    public final SparseArray<T> getArray$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.array;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final int getSize() {
        return this.array.size();
    }

    public final T get(int key) {
        return this.array.get(key);
    }

    public final int keyAt(int index) {
        return this.array.keyAt(index);
    }

    public final T valueAt(int index) {
        return this.array.valueAt(index);
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIntMap<T> toMutable() {
        return new MutableIntMap(this);
    }

    public String toString() {
        return this.array.toString();
    }
}
