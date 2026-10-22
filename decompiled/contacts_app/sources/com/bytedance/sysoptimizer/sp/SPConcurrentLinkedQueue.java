package com.bytedance.sysoptimizer.sp;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class SPConcurrentLinkedQueue extends ConcurrentLinkedQueue {
    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object r1) {
        return true;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r1) {
        return true;
    }

    public SPConcurrentLinkedQueue() {
    }
}
