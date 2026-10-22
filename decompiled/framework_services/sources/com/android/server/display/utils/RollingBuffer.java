package com.android.server.display.utils;

/* JADX INFO: loaded from: classes2.dex */
public class RollingBuffer {
    private static final int INITIAL_SIZE = 50;
    private int mCount;
    private int mEnd;
    private int mSize;
    private int mStart;
    private long[] mTimes;
    private float[] mValues;

    public RollingBuffer() {
        this.mSize = 50;
        this.mTimes = new long[50];
        this.mValues = new float[50];
        clear();
    }

    public void add(long time, float value) {
        if (this.mCount < this.mSize) goto L5;
        expandBuffer();
    L5:
        this.mTimes[this.mEnd] = time;
        this.mValues[this.mEnd] = value;
        this.mEnd = (this.mEnd + 1) % this.mSize;
        this.mCount++;
    }

    public int size() {
        return this.mCount;
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long getTime(int index) {
        return this.mTimes[offsetOf(index)];
    }

    public float getValue(int index) {
        return this.mValues[offsetOf(index)];
    }

    public void truncate(long minTime) {
        if (isEmpty() == false) goto L5;
        return;
    L5:
        if (getTime(0) >= minTime) goto L10;
        int index = getLatestIndexBefore(minTime);
        this.mStart = offsetOf(index);
        this.mCount -= index;
        this.mTimes[this.mStart] = minTime;
        return;
    }

    public void clear() {
        this.mCount = 0;
        this.mStart = 0;
        this.mEnd = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
    L4:
        if (i >= this.mCount) goto L9;
        int index = offsetOf(i);
        sb.append(this.mValues[index] + " @ " + this.mTimes[index]);
        if ((i + 1) == this.mCount) goto L8;
        sb.append(", ");
    L8:
        i = i + 1;
        goto L4
    L9:
        sb.append("]");
        return sb.toString();
    }

    private int offsetOf(int index) {
        if (index < 0) goto L8;
        if (index >= this.mCount) goto L8;
        return (this.mStart + index) % this.mSize;
    L8:
        throw new ArrayIndexOutOfBoundsException("invalid index: " + index + ", mCount= " + this.mCount);
    }

    private void expandBuffer() {
        int size = this.mSize * 2;
        long[] times = new long[size];
        float[] values = new float[size];
        System.arraycopy(this.mTimes, this.mStart, times, 0, this.mCount - this.mStart);
        System.arraycopy(this.mTimes, 0, times, this.mCount - this.mStart, this.mStart);
        System.arraycopy(this.mValues, this.mStart, values, 0, this.mCount - this.mStart);
        System.arraycopy(this.mValues, 0, values, this.mCount - this.mStart, this.mStart);
        this.mSize = size;
        this.mStart = 0;
        this.mEnd = this.mCount;
        this.mTimes = times;
        this.mValues = values;
    }

    private int getLatestIndexBefore(long time) {
        int i = 1;
    L4:
        if (i >= this.mCount) goto L10;
        if (this.mTimes[offsetOf(i)] > time) goto L8;
        i = i + 1;
        goto L4
    L8:
        return i - 1;
    L10:
        int i2 = this.mCount;
        return i2 - 1;
    }
}
