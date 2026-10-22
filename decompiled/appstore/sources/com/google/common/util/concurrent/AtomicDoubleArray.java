package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int r10) {
        this.longs = new AtomicLongArray(r10);
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = r10.readInt();
        ImmutableLongArray.Builder r12 = ImmutableLongArray.builder();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12.add(Double.doubleToRawLongBits(r10.readDouble()));
        r13 = r13 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r12.build().toArray());
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        int r11 = length();
        r10.writeInt(r11);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.writeDouble(get(r12));
        r12 = r12 + 1;
        goto L3
    }

    @CanIgnoreReturnValue
    public double addAndGet(int r10, double r11) {
    L2:
        long r12 = this.longs.get(r10);
        double r13 = Double.longBitsToDouble(r12) + r11;
        long r14 = Double.doubleToRawLongBits(r13);
        if (this.longs.compareAndSet(r10, r12, r14) == false) goto L2;
        return r13;
    }

    public final boolean compareAndSet(int r10, double r11, double r12) {
        return this.longs.compareAndSet(r10, Double.doubleToRawLongBits(r11), Double.doubleToRawLongBits(r12));
    }

    public final double get(int r10) {
        return Double.longBitsToDouble(this.longs.get(r10));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int r10, double r11) {
    L2:
        long r12 = this.longs.get(r10);
        double r13 = Double.longBitsToDouble(r12);
        long r14 = Double.doubleToRawLongBits(r13 + r11);
        if (this.longs.compareAndSet(r10, r12, r14) == false) goto L2;
        return r13;
    }

    public final double getAndSet(int r10, double r11) {
        long r12 = Double.doubleToRawLongBits(r11);
        return Double.longBitsToDouble(this.longs.getAndSet(r10, r12));
    }

    public final void lazySet(int r10, double r11) {
        long r12 = Double.doubleToRawLongBits(r11);
        this.longs.lazySet(r10, r12);
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int r10, double r11) {
        long r12 = Double.doubleToRawLongBits(r11);
        this.longs.set(r10, r12);
    }

    public String toString() {
        int r10 = length();
        int r11 = r10 - 1;
        if (r11 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r12 = new StringBuilder(r10 * 19);
        r12.append('[');
        int r13 = 0;
    L7:
        r12.append(Double.longBitsToDouble(this.longs.get(r13)));
        if (r13 == r11) goto L9;
        r12.append(',');
        r12.append(TokenParser.SP);
        r13 = r13 + 1;
        goto L7
    L9:
        r12.append(']');
        return r12.toString();
    }

    public final boolean weakCompareAndSet(int r10, double r11, double r12) {
        return this.longs.weakCompareAndSet(r10, Double.doubleToRawLongBits(r11), Double.doubleToRawLongBits(r12));
    }

    public AtomicDoubleArray(double[] r10) {
        int r11 = r10.length;
        long[] r12 = new long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = Double.doubleToRawLongBits(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r12);
    }
}
