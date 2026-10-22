package com.android.internal.util.jobs;

/* JADX INFO: loaded from: classes.dex */
public class RingBufferIndices {
    private final int mCapacity;
    private int mSize;
    private int mStart;

    public RingBufferIndices(int capacity) {
        this.mCapacity = capacity;
    }

    public int add() {
        if (this.mSize >= this.mCapacity) goto L6;
        int pos = this.mSize;
        this.mSize++;
        return pos;
    L6:
        int pos2 = this.mStart;
        this.mStart++;
        if (this.mStart != this.mCapacity) goto L9;
        this.mStart = 0;
    L9:
        return pos2;
    }

    public void clear() {
        this.mStart = 0;
        this.mSize = 0;
    }

    public int size() {
        return this.mSize;
    }

    public int indexOf(int pos) {
        int index = this.mStart + pos;
        if (index >= this.mCapacity) goto L5;
        return index;
    L5:
        return index - this.mCapacity;
    }
}
