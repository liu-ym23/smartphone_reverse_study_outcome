package com.android.server.timezonedetector;

import android.os.SystemClock;
import android.os.TimestampedValue;
import android.util.IndentingPrintWriter;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class ReferenceWithHistory<V> {
    private final int mMaxHistorySize;
    private int mSetCount;
    private ArrayDeque<TimestampedValue<V>> mValues;

    public ReferenceWithHistory(int maxHistorySize) {
        if (maxHistorySize < 1) goto L7;
        this.mMaxHistorySize = maxHistorySize;
        return;
    L7:
        throw new IllegalArgumentException("maxHistorySize < 1: " + maxHistorySize);
    }

    public V get() {
        if (this.mValues != null) goto L5;
        return null;
    L5:
        if (this.mValues.isEmpty() == false) goto L8;
        return null;
    L8:
        return (V) this.mValues.getFirst().getValue();
    }

    public V set(V newValue) {
        if (this.mValues != null) goto L6;
        this.mValues = new ArrayDeque(this.mMaxHistorySize);
    L6:
        if (this.mValues.size() < this.mMaxHistorySize) goto L8;
        this.mValues.removeLast();
    L8:
        V previous = get();
        TimestampedValue<V> valueHolder = new TimestampedValue(SystemClock.elapsedRealtime(), newValue);
        this.mValues.addFirst(valueHolder);
        this.mSetCount++;
        return previous;
    }

    public void dump(IndentingPrintWriter ipw) {
        if (this.mValues != null) goto L5;
        ipw.println("{Empty}");
    L9:
        ipw.flush();
        return;
    L5:
        int i = this.mSetCount - this.mValues.size();
        Iterator<TimestampedValue<V>> reverseIterator = this.mValues.descendingIterator();
    L7:
        if (reverseIterator.hasNext() == false) goto L9;
        TimestampedValue<V> valueHolder = reverseIterator.next();
        int i2 = i + 1;
        ipw.print(i);
        ipw.print("@");
        ipw.print(Duration.ofMillis(valueHolder.getReferenceTimeMillis()).toString());
        ipw.print(": ");
        ipw.println(valueHolder.getValue());
        i = i2;
        goto L7
    }

    public int getHistoryCount() {
        if (this.mValues != null) goto L6;
        return 0;
    L6:
        return this.mValues.size();
    }

    public String toString() {
        return String.valueOf(get());
    }
}
