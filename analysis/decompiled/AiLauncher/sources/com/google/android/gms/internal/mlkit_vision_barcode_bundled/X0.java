package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class X0 extends V implements RandomAccess, M0 {

    /* renamed from: b, reason: collision with root package name */
    public long[] f20069b;

    /* renamed from: c, reason: collision with root package name */
    public int f20070c;

    static {
        new X0(new long[0], 0, false);
    }

    public X0() {
        this(new long[10], 0, true);
    }

    private final String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20070c;
    }

    private final void i(int i10) {
        if (i10 < 0 || i10 >= this.f20070c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f20070c)) {
            throw new IndexOutOfBoundsException(f(i10));
        }
        int i12 = i10 + 1;
        long[] jArr = this.f20069b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i12, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f20069b, i10, jArr2, i12, this.f20070c - i10);
            this.f20069b = jArr2;
        }
        this.f20069b[i10] = jLongValue;
        this.f20070c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = N0.f20038a;
        collection.getClass();
        if (!(collection instanceof X0)) {
            return super.addAll(collection);
        }
        X0 x02 = (X0) collection;
        int i10 = x02.f20070c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20070c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f20069b;
        if (i12 > jArr.length) {
            this.f20069b = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(x02.f20069b, 0, this.f20069b, this.f20070c, x02.f20070c);
        this.f20070c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final long c(int i10) {
        i(i10);
        return this.f20069b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(long j10) {
        b();
        int i10 = this.f20070c;
        long[] jArr = this.f20069b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f20069b = jArr2;
        }
        long[] jArr3 = this.f20069b;
        int i11 = this.f20070c;
        this.f20070c = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X0)) {
            return super.equals(obj);
        }
        X0 x02 = (X0) obj;
        if (this.f20070c != x02.f20070c) {
            return false;
        }
        long[] jArr = x02.f20069b;
        for (int i10 = 0; i10 < this.f20070c; i10++) {
            if (this.f20069b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    public final /* bridge */ /* synthetic */ M0 g(int i10) {
        if (i10 >= this.f20070c) {
            return new X0(Arrays.copyOf(this.f20069b, i10), this.f20070c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        i(i10);
        return Long.valueOf(this.f20069b[i10]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20070c; i11++) {
            long j10 = this.f20069b[i11];
            Charset charset = N0.f20038a;
            i10 = (i10 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i10 = this.f20070c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f20069b[i11] == jLongValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        i(i10);
        long[] jArr = this.f20069b;
        long j10 = jArr[i10];
        if (i10 < this.f20070c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f20070c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f20069b;
        System.arraycopy(jArr, i11, jArr, i10, this.f20070c - i11);
        this.f20070c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        i(i10);
        long[] jArr = this.f20069b;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20070c;
    }

    public X0(long[] jArr, int i10, boolean z10) {
        super(z10);
        this.f20069b = jArr;
        this.f20070c = i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Long) obj).longValue());
        return true;
    }
}
