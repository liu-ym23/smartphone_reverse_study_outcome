package com.android.server.alarm;

/* JADX INFO: loaded from: classes.dex */
public class AlarmRingBuffer {
    private static final int DEFAULT_BUFFER_SIZE = 128;
    private int[] elements;
    private int end;
    private boolean full;
    private int maxSize;
    private int start;

    public AlarmRingBuffer() {
        this(128);
    }

    public AlarmRingBuffer(int capacity) {
        if (capacity <= 0) goto L7;
        this.elements = new int[capacity];
        this.maxSize = this.elements.length;
        return;
    L7:
        throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    }

    public int size() {
        if (this.end >= this.start) goto L5;
        int size = (this.maxSize - this.start) + this.end;
        return size;
    L5:
        int size2 = this.end;
        if (size2 == this.start) goto L8;
        int size3 = this.end;
        return size3 - this.start;
    L8:
        if (this.full == false) goto L10;
        int size4 = this.maxSize;
        return size4;
    L10:
        return 0;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFull() {
        if (size() != this.maxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean add(int item) {
        if (isFull() == false) goto L5;
        removeFront();
    L5:
        int[] r0 = this.elements;
        int r1 = this.end;
        this.end = r1 + 1;
        r0[r1] = item;
        if (this.end < this.maxSize) goto L9;
        this.end = 0;
    L9:
        if (this.end != this.start) goto L11;
        this.full = true;
    L11:
        return true;
    }

    public int removeFront() {
        if (isEmpty() == true) goto L10;
        int element = this.elements[this.start];
        int r1 = this.start + 1;
        this.start = r1;
        if (r1 < this.maxSize) goto L7;
        this.start = 0;
    L7:
        this.full = false;
        return element;
    L10:
        throw new RuntimeException("The buffer is already empty");
    }

    public boolean removeFront(int count) {
        if (count > size()) goto L7;
        this.start = (this.start + count) % this.maxSize;
        this.full = false;
        return true;
    L7:
        throw new IndexOutOfBoundsException("The buffer does not has count:" + count + ", size=" + size());
    }

    public int get(int index) {
        if (index >= size()) goto L7;
        return this.elements[(this.start + index) % this.maxSize];
    L7:
        throw new IndexOutOfBoundsException("index=" + index + ", size=" + size());
    }

    public int capacity() {
        return this.maxSize;
    }
}
