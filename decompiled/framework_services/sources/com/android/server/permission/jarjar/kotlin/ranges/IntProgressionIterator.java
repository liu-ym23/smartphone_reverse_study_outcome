package com.android.server.permission.jarjar.kotlin.ranges;

import com.android.server.permission.jarjar.kotlin.collections.IntIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntProgressionIterator extends IntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public IntProgressionIterator(int first, int last, int step) {
        this.step = step;
        this.finalElement = last;
        boolean r1 = false;
        if (this.step <= 0) goto L6;
        if (first > last) goto L8;
    L5:
        r1 = true;
    L8:
        this.hasNext = r1;
        if (this.hasNext == false) goto L11;
        int r0 = first;
    L12:
        this.next = r0;
        return;
    L11:
        r0 = this.finalElement;
        goto L12
    L6:
        if (first < last) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // com.android.server.permission.jarjar.kotlin.collections.IntIterator
    public int nextInt() {
        int value = this.next;
        if (value == this.finalElement) goto L5;
        this.next += this.step;
    L10:
        return value;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
