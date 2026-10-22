package com.android.server.display.utils;

import java.time.Clock;

/* JADX INFO: loaded from: classes2.dex */
public class History {
    private Clock mClock;
    private int mCount;
    private int mEnd;
    private int mSize;
    private int mStart;
    private long[] mTimes;
    private float[] mValues;

    public History(int size) {
        this(size, Clock.systemUTC());
    }

    public History(int size, Clock clock) {
        this.mSize = size;
        this.mCount = 0;
        this.mStart = 0;
        this.mEnd = 0;
        this.mTimes = new long[size];
        this.mValues = new float[size];
        this.mClock = clock;
    }

    public void add(float value) {
        this.mTimes[this.mEnd] = this.mClock.millis();
        this.mValues[this.mEnd] = value;
        if (this.mCount >= this.mSize) goto L5;
        this.mCount++;
    L6:
        this.mEnd = (this.mEnd + 1) % this.mSize;
        return;
    L5:
        this.mStart = (this.mStart + 1) % this.mSize;
        goto L6
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
    L4:
        if (i >= this.mCount) goto L9;
        int index = (this.mStart + i) % this.mSize;
        long time = this.mTimes[index];
        float value = this.mValues[index];
        sb.append(value + " @ " + time);
        if ((i + 1) == this.mCount) goto L8;
        sb.append(", ");
    L8:
        i = i + 1;
        goto L4
    L9:
        sb.append("]");
        return sb.toString();
    }
}
