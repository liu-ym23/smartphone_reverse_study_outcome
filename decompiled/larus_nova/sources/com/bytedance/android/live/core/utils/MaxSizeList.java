package com.bytedance.android.live.core.utils;

import java.util.Collection;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes45.dex */
public class MaxSizeList<T> extends LinkedList<T> {
    private final int max;

    public MaxSizeList(int r100) {
        this.max = r100;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T r100) {
        boolean r101 = super.add(r100);
    L4:
        if (size() <= this.max) goto L6;
        removeFirst();
        goto L4
    L6:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends T> r101) {
        boolean r102 = super.addAll(r100, r101);
    L4:
        if (size() <= this.max) goto L6;
        removeFirst();
        goto L4
    L6:
        return r102;
    }
}
