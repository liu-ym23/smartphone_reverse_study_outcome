package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class G0 extends V implements RandomAccess, L0 {

    /* renamed from: d, reason: collision with root package name */
    public static final G0 f20023d = new G0(new int[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public int[] f20024b;

    /* renamed from: c, reason: collision with root package name */
    public int f20025c;

    public G0() {
        this(new int[10], 0, true);
    }

    public static G0 e() {
        return f20023d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f20025c)) {
            throw new IndexOutOfBoundsException(i(i10));
        }
        int i12 = i10 + 1;
        int[] iArr = this.f20024b;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i12, i11 - i10);
        } else {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f20024b, i10, iArr2, i12, this.f20025c - i10);
            this.f20024b = iArr2;
        }
        this.f20024b[i10] = iIntValue;
        this.f20025c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = N0.f20038a;
        collection.getClass();
        if (!(collection instanceof G0)) {
            return super.addAll(collection);
        }
        G0 g02 = (G0) collection;
        int i10 = g02.f20025c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20025c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f20024b;
        if (i12 > iArr.length) {
            this.f20024b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(g02.f20024b, 0, this.f20024b, this.f20025c, g02.f20025c);
        this.f20025c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final int c(int i10) {
        j(i10);
        return this.f20024b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G0)) {
            return super.equals(obj);
        }
        G0 g02 = (G0) obj;
        if (this.f20025c != g02.f20025c) {
            return false;
        }
        int[] iArr = g02.f20024b;
        for (int i10 = 0; i10 < this.f20025c; i10++) {
            if (this.f20024b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        b();
        int i11 = this.f20025c;
        int[] iArr = this.f20024b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f20024b = iArr2;
        }
        int[] iArr3 = this.f20024b;
        int i12 = this.f20025c;
        this.f20025c = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    public final /* bridge */ /* synthetic */ M0 g(int i10) {
        if (i10 >= this.f20025c) {
            return new G0(Arrays.copyOf(this.f20024b, i10), this.f20025c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        j(i10);
        return Integer.valueOf(this.f20024b[i10]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f20025c; i11++) {
            i10 = (i10 * 31) + this.f20024b[i11];
        }
        return i10;
    }

    public final String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20025c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i10 = this.f20025c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f20024b[i11] == iIntValue) {
                return i11;
            }
        }
        return -1;
    }

    public final void j(int i10) {
        if (i10 < 0 || i10 >= this.f20025c) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        j(i10);
        int[] iArr = this.f20024b;
        int i11 = iArr[i10];
        if (i10 < this.f20025c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f20025c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f20024b;
        System.arraycopy(iArr, i11, iArr, i10, this.f20025c - i11);
        this.f20025c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        j(i10);
        int[] iArr = this.f20024b;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20025c;
    }

    public G0(int[] iArr, int i10, boolean z10) {
        super(z10);
        this.f20024b = iArr;
        this.f20025c = i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Integer) obj).intValue());
        return true;
    }
}
