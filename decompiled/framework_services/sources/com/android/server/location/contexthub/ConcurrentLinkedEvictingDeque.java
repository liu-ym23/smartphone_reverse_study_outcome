package com.android.server.location.contexthub;

import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentLinkedEvictingDeque<E> extends ConcurrentLinkedDeque<E> {
    private int mSize;

    ConcurrentLinkedEvictingDeque(int size) {
        this.mSize = size;
    }

    @Override // java.util.concurrent.ConcurrentLinkedDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    public boolean add(E elem) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (size() != this.mSize) goto L8;
        poll();     // Catch: Throwable -> L6
    L8:
        boolean r0 = super.add(elem);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }
}
