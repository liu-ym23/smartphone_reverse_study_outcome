package com.bytedance.platform.godzilla.anr.sp;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class LinkedListProxyForFinishers<E> extends LinkedList<E> {
    private LinkedList<Runnable> mRealList;

    public LinkedListProxyForFinishers(LinkedList<Runnable> r10) {
        this.mRealList = r10;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r10) {
        return this.mRealList.add((Runnable) r10);
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        return null;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r10) {
        return this.mRealList.remove(r10);
    }
}
