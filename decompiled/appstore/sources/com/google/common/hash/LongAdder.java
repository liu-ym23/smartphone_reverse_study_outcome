package com.google.common.hash;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    public LongAdder() {
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = r10.readLong();
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeLong(sum());
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long r10) {
        Striped64.Cell[] r11 = this.cells;
        if (r11 != null) goto L6;
        long r12 = this.base;
        if (casBase(r12, r12 + r10) == false) goto L6;
        return;
    L6:
        int[] r13 = Striped64.threadHashCode.get();
        boolean r14 = true;
        if (r13 == null) goto L15;
        if (r11 == null) goto L15;
        int r15 = r11.length;
        if (r15 < 1) goto L15;
        Striped64.Cell r16 = r11[(r15 - 1) & r13[0]];
        if (r16 == null) goto L15;
        long r17 = r16.value;
        r14 = r16.cas(r17, r17 + r10);
        if (r14 == false) goto L15;
        return;
    L15:
        retryUpdate(r10, r13, r14);
    }

    public void decrement() {
        add(-1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // com.google.common.hash.Striped64
    public final long fn(long r10, long r11) {
        return r10 + r11;
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long r10 = this.base;
        Striped64.Cell[] r11 = this.cells;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        Striped64.Cell r14 = r11[r13];
        if (r14 == null) goto L9;
        r10 = r10 + r14.value;
    L9:
        r13 = r13 + 1;
    L10:
        return r10;
    }

    public long sumThenReset() {
        long r10 = this.base;
        Striped64.Cell[] r11 = this.cells;
        this.base = 0;
        if (r11 == null) goto L10;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        Striped64.Cell r14 = r11[r13];
        if (r14 == null) goto L9;
        r10 = r10 + r14.value;
        r14.value = 0;
    L9:
        r13 = r13 + 1;
    L10:
        return r10;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
