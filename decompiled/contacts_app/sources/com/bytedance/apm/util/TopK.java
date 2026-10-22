package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
public class TopK<E extends Comparable> {
    private int maxSize;
    private PriorityQueue<E> queue;

    public TopK(int r3) {
        if (r3 <= 0) goto L7;
        this.maxSize = r3;
        this.queue = new PriorityQueue(r3, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void add(E r3) {
        if (this.queue.size() >= this.maxSize) goto L6;
        this.queue.add(r3);
        return;
    L6:
        if (r3.compareTo(this.queue.peek()) <= 0) goto L10;
        this.queue.poll();
        this.queue.add(r3);
        return;
    }

    public List<E> toList() {
        return new ArrayList(this.queue);
    }

    public List<E> sortedList() {
        ArrayList r0 = new ArrayList(this.queue);
        Collections.sort(r0);
        return r0;
    }

    public int size() {
        return this.queue.size();
    }

    public void clear() {
        this.queue.clear();
    }
}
