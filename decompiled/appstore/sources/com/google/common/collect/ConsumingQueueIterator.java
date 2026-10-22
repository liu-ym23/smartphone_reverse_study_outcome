package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> queue;

    public ConsumingQueueIterator(T... r10) {
        ArrayDeque r11 = new ArrayDeque(r10.length);
        this.queue = r11;
        Collections.addAll(r11, r10);
    }

    @Override // com.google.common.collect.AbstractIterator
    public T computeNext() {
        if (this.queue.isEmpty() == false) goto L6;
        return endOfData();
    L6:
        return this.queue.remove();
    }

    public ConsumingQueueIterator(Queue<T> r10) {
        this.queue = (Queue) Preconditions.checkNotNull(r10);
    }
}
