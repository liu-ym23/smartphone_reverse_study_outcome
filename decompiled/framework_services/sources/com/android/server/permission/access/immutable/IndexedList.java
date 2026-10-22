package com.android.server.permission.access.immutable;

import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.ArrayList;

/* JADX INFO: compiled from: IndexedList.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IndexedList<T> implements Immutable<MutableIndexedList<T>> {
    private final ArrayList<T> list;

    public /* synthetic */ IndexedList(ArrayList r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private IndexedList(ArrayList<T> r1) {
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

    public final T get(int index) {
        return this.list.get(index);
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableIndexedList<T> toMutable() {
        return new MutableIndexedList(this);
    }

    public String toString() {
        return this.list.toString();
    }
}
