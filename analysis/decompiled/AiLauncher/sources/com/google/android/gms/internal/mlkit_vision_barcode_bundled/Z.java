package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Z extends V implements RandomAccess, M0 {

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f20073b;

    /* renamed from: c, reason: collision with root package name */
    public int f20074c;

    static {
        new Z(new boolean[0], 0, false);
    }

    public Z() {
        this(new boolean[10], 0, true);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f20074c)) {
            throw new IndexOutOfBoundsException(f(i10));
        }
        int i12 = i10 + 1;
        boolean[] zArr = this.f20073b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i12, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f20073b, i10, zArr2, i12, this.f20074c - i10);
            this.f20073b = zArr2;
        }
        this.f20073b[i10] = zBooleanValue;
        this.f20074c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = N0.f20038a;
        collection.getClass();
        if (!(collection instanceof Z)) {
            return super.addAll(collection);
        }
        Z z10 = (Z) collection;
        int i10 = z10.f20074c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20074c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f20073b;
        if (i12 > zArr.length) {
            this.f20073b = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(z10.f20073b, 0, this.f20073b, this.f20074c, z10.f20074c);
        this.f20074c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(boolean z10) {
        b();
        int i10 = this.f20074c;
        boolean[] zArr = this.f20073b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f20073b = zArr2;
        }
        boolean[] zArr3 = this.f20073b;
        int i11 = this.f20074c;
        this.f20074c = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean e(int i10) {
        i(i10);
        return this.f20073b[i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z)) {
            return super.equals(obj);
        }
        Z z10 = (Z) obj;
        if (this.f20074c != z10.f20074c) {
            return false;
        }
        boolean[] zArr = z10.f20073b;
        for (int i10 = 0; i10 < this.f20074c; i10++) {
            if (this.f20073b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20074c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    public final /* bridge */ /* synthetic */ M0 g(int i10) {
        if (i10 >= this.f20074c) {
            return new Z(Arrays.copyOf(this.f20073b, i10), this.f20074c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        i(i10);
        return Boolean.valueOf(this.f20073b[i10]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i10 = 0; i10 < this.f20074c; i10++) {
            iA = (iA * 31) + N0.a(this.f20073b[i10]);
        }
        return iA;
    }

    public final void i(int i10) {
        if (i10 < 0 || i10 >= this.f20074c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i10 = this.f20074c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f20073b[i11] == zBooleanValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        i(i10);
        boolean[] zArr = this.f20073b;
        boolean z10 = zArr[i10];
        if (i10 < this.f20074c - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f20074c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f20073b;
        System.arraycopy(zArr, i11, zArr, i10, this.f20074c - i11);
        this.f20074c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        b();
        i(i10);
        boolean[] zArr = this.f20073b;
        boolean z10 = zArr[i10];
        zArr[i10] = zBooleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20074c;
    }

    public Z(boolean[] zArr, int i10, boolean z10) {
        super(z10);
        this.f20073b = zArr;
        this.f20074c = i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        c(((Boolean) obj).booleanValue());
        return true;
    }
}
