package com.google.common.util.concurrent;

import com.android.contacts.common.list.DefaultContactListAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int r2) {
        this.longs = new AtomicLongArray(r2);
    }

    public AtomicDoubleArray(double[] r6) {
        int r0 = r6.length;
        long[] r1 = new long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = Double.doubleToRawLongBits(r6[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r1);
    }

    public final int length() {
        return this.longs.length();
    }

    public final double get(int r1) {
        return Double.longBitsToDouble(this.longs.get(r1));
    }

    public final void set(int r1, double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        this.longs.set(r1, r3);
    }

    public final void lazySet(int r1, double r2) {
        set(r1, r2);
    }

    public final double getAndSet(int r1, double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        return Double.longBitsToDouble(this.longs.getAndSet(r1, r3));
    }

    public final boolean compareAndSet(int r7, double r8, double r10) {
        return this.longs.compareAndSet(r7, Double.doubleToRawLongBits(r8), Double.doubleToRawLongBits(r10));
    }

    public final boolean weakCompareAndSet(int r7, double r8, double r10) {
        return this.longs.weakCompareAndSet(r7, Double.doubleToRawLongBits(r8), Double.doubleToRawLongBits(r10));
    }

    public final double getAndAdd(int r10, double r11) {
    L2:
        long r3 = this.longs.get(r10);
        double r7 = Double.longBitsToDouble(r3);
        long r5 = Double.doubleToRawLongBits(r7 + r11);
        if (this.longs.compareAndSet(r10, r3, r5) == false) goto L2;
        return r7;
    }

    public double addAndGet(int r10, double r11) {
    L2:
        long r3 = this.longs.get(r10);
        double r7 = Double.longBitsToDouble(r3) + r11;
        long r5 = Double.doubleToRawLongBits(r7);
        if (this.longs.compareAndSet(r10, r3, r5) == false) goto L2;
        return r7;
    }

    public String toString() {
        int r0 = length() - 1;
        if (r0 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r1 = new StringBuilder((r0 + 1) * 19);
        r1.append(DefaultContactListAdapter.SNIPPET_START_MATCH);
        int r2 = 0;
    L7:
        r1.append(Double.longBitsToDouble(this.longs.get(r2)));
        if (r2 == r0) goto L10;
        r1.append(", ");
        r2 = r2 + 1;
        goto L7
    L10:
        return r1.append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        int r0 = length();
        r5.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.writeDouble(get(r1));
        r1 = r1 + 1;
        goto L3
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r0 = r5.readInt();
        this.longs = new AtomicLongArray(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        set(r1, r5.readDouble());
        r1 = r1 + 1;
        goto L3
    }
}
