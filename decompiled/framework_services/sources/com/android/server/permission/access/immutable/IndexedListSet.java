package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.ArrayList;

/* JADX INFO: compiled from: IndexedListSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IndexedListSet<T> implements Immutable<MutableIndexedListSet<T>> {
    private final ArrayList<T> list;

    public /* synthetic */ IndexedListSet(ArrayList r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IndexedListSet(ArrayList<T> r1) {
        this.list = r1;
    }

    public final ArrayList<T> getList$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.list;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ Object toMutable() {
        return toMutable();
    }

    public final int getSize() {
        return this.list.size();
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean contains(T r2) {
        return this.list.contains(r2);
    }

    public final T elementAt(int index) {
        return this.list.get(index);
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIndexedListSet<T> toMutable() {
        return new MutableIndexedListSet(this);
    }

    public String toString() {
        return this.list.toString();
    }
}
