package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.o0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1747o0 extends V implements RandomAccess, M0 {

    /* renamed from: b, reason: collision with root package name */
    public double[] f20117b;

    /* renamed from: c, reason: collision with root package name */
    public int f20118c;

    static {
        new C1747o0(new double[0], 0, false);
    }

    public C1747o0() {
        this(new double[10], 0, true);
    }

    private final String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20118c;
    }

    private final void i(int i10) {
        if (i10 < 0 || i10 >= this.f20118c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f20118c)) {
            throw new IndexOutOfBoundsException(f(i10));
        }
        int i12 = i10 + 1;
        double[] dArr = this.f20117b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i12, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f20117b, i10, dArr2, i12, this.f20118c - i10);
            this.f20117b = dArr2;
        }
        this.f20117b[i10] = dDoubleValue;
        this.f20118c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = N0.f20038a;
        collection.getClass();
        if (!(collection instanceof C1747o0)) {
            return super.addAll(collection);
        }
        C1747o0 c1747o0 = (C1747o0) collection;
        int i10 = c1747o0.f20118c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20118c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f20117b;
        if (i12 > dArr.length) {
            this.f20117b = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(c1747o0.f20117b, 0, this.f20117b, this.f20118c, c1747o0.f20118c);
        this.f20118c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final double c(int i10) {
        i(i10);
        return this.f20117b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(double d10) {
        b();
        int i10 = this.f20118c;
        double[] dArr = this.f20117b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f20117b = dArr2;
        }
        double[] dArr3 = this.f20117b;
        int i11 = this.f20118c;
        this.f20118c = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1747o0)) {
            return super.equals(obj);
        }
        C1747o0 c1747o0 = (C1747o0) obj;
        if (this.f20118c != c1747o0.f20118c) {
            return false;
        }
        double[] dArr = c1747o0.f20117b;
        for (int i10 = 0; i10 < this.f20118c; i10++) {
            if (Double.doubleToLongBits(this.f20117b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    public final /* bridge */ /* synthetic */ M0 g(int i10) {
        if (i10 >= this.f20118c) {
            return new C1747o0(Arrays.copyOf(this.f20117b, i10), this.f20118c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        i(i10);
        return Double.valueOf(this.f20117b[i10]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20118c; i11++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f20117b[i11]);
            Charset charset = N0.f20038a;
            i10 = (i10 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i10 = this.f20118c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f20117b[i11] == dDoubleValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        i(i10);
        double[] dArr = this.f20117b;
        double d10 = dArr[i10];
        if (i10 < this.f20118c - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f20118c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f20117b;
        System.arraycopy(dArr, i11, dArr, i10, this.f20118c - i11);
        this.f20118c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        b();
        i(i10);
        double[] dArr = this.f20117b;
        double d10 = dArr[i10];
        dArr[i10] = dDoubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20118c;
    }

    public C1747o0(double[] dArr, int i10, boolean z10) {
        super(z10);
        this.f20117b = dArr;
        this.f20118c = i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Double) obj).doubleValue());
        return true;
    }
}
