package com.bytedance.android.live.core.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes45.dex */
public class NoNullRepeatList<T> extends CopyOnWriteArrayList<T> {
    public NoNullRepeatList() {
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean add(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (contains(r100) == false) goto L9;
        return false;
    L9:
        return super.add(r100);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
        Iterator<? extends T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        add(r101.next());
        goto L4
    L6:
        return true;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public boolean remove(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return super.remove(r100);
    }
}
