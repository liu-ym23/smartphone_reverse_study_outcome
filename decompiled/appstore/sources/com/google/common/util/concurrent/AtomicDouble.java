package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble(double r10) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(r10));
    }

    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        this.value = new AtomicLong();
        set(r10.readDouble());
    }

    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        r10.writeDouble(get());
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double r10) {
    L2:
        long r11 = this.value.get();
        double r12 = Double.longBitsToDouble(r11) + r10;
        long r13 = Double.doubleToRawLongBits(r12);
        if (this.value.compareAndSet(r11, r13) == false) goto L2;
        return r12;
    }

    public final boolean compareAndSet(double r10, double r11) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(r10), Double.doubleToRawLongBits(r11));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double r10) {
    L2:
        long r11 = this.value.get();
        double r12 = Double.longBitsToDouble(r11);
        long r13 = Double.doubleToRawLongBits(r12 + r10);
        if (this.value.compareAndSet(r11, r13) == false) goto L2;
        return r12;
    }

    public final double getAndSet(double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        return Double.longBitsToDouble(this.value.getAndSet(r11));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        this.value.lazySet(r11);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double r10) {
        long r11 = Double.doubleToRawLongBits(r10);
        this.value.set(r11);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double r10, double r11) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(r10), Double.doubleToRawLongBits(r11));
    }

    public AtomicDouble() {
        this(0.0d);
    }
}
