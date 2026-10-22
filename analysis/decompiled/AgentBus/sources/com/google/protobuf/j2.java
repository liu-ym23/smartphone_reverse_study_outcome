package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class j2 extends d implements Internal$IntList, RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2412i;

    /* renamed from: j, reason: collision with root package name */
    public static final j2 f2413j;

    /* renamed from: g, reason: collision with root package name */
    public int[] f2414g;

    /* renamed from: h, reason: collision with root package name */
    public int f2415h;

    static {
        int[] iArr = new int[0];
        f2412i = iArr;
        f2413j = new j2(iArr, 0, false);
    }

    public j2(int[] iArr, int i2, boolean z4) {
        super(z4);
        this.f2414g = iArr;
        this.f2415h = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i2 < 0 || i2 > (i10 = this.f2415h)) {
            StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
            sbN.append(this.f2415h);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        int[] iArr = this.f2414g;
        if (i10 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i10 - i2);
        } else {
            int[] iArr2 = new int[a1.a.d(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f2414g, 0, iArr2, 0, i2);
            System.arraycopy(this.f2414g, i2, iArr2, i2 + 1, this.f2415h - i2);
            this.f2414g = iArr2;
        }
        this.f2414g[i2] = iIntValue;
        this.f2415h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = p2.f2495a;
        collection.getClass();
        if (!(collection instanceof j2)) {
            return super.addAll(collection);
        }
        j2 j2Var = (j2) collection;
        int i2 = j2Var.f2415h;
        if (i2 == 0) {
            return false;
        }
        int i10 = this.f2415h;
        if (Integer.MAX_VALUE - i10 < i2) {
            throw new OutOfMemoryError();
        }
        int i11 = i10 + i2;
        int[] iArr = this.f2414g;
        if (i11 > iArr.length) {
            this.f2414g = Arrays.copyOf(iArr, i11);
        }
        System.arraycopy(j2Var.f2414g, 0, this.f2414g, this.f2415h, j2Var.f2415h);
        this.f2415h = i11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.Internal$IntList
    public final void addInt(int i2) {
        a();
        int i10 = this.f2415h;
        int[] iArr = this.f2414g;
        if (i10 == iArr.length) {
            int[] iArr2 = new int[a1.a.d(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f2414g, 0, iArr2, 0, this.f2415h);
            this.f2414g = iArr2;
        }
        int[] iArr3 = this.f2414g;
        int i11 = this.f2415h;
        this.f2415h = i11 + 1;
        iArr3[i11] = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return super.equals(obj);
        }
        j2 j2Var = (j2) obj;
        if (this.f2415h != j2Var.f2415h) {
            return false;
        }
        int[] iArr = j2Var.f2414g;
        for (int i2 = 0; i2 < this.f2415h; i2++) {
            if (this.f2414g[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f2415h) {
            StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
            sbN.append(this.f2415h);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    @Override // com.google.protobuf.Internal$IntList
    public final int getInt(int i2) {
        f(i2);
        return this.f2414g[i2];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i10 = 0; i10 < this.f2415h; i10++) {
            i2 = (i2 * 31) + this.f2414g[i10];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f2415h;
        for (int i10 = 0; i10 < i2; i10++) {
            if (this.f2414g[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        f(i2);
        int[] iArr = this.f2414g;
        int i10 = iArr[i2];
        if (i2 < this.f2415h - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (r2 - i2) - 1);
        }
        this.f2415h--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i10) {
        a();
        if (i10 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f2414g;
        System.arraycopy(iArr, i10, iArr, i2, this.f2415h - i10);
        this.f2415h -= i10 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        return Integer.valueOf(setInt(i2, ((Integer) obj).intValue()));
    }

    @Override // com.google.protobuf.Internal$IntList
    public final int setInt(int i2, int i10) {
        a();
        f(i2);
        int[] iArr = this.f2414g;
        int i11 = iArr[i2];
        iArr[i2] = i10;
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2415h;
    }

    @Override // com.google.protobuf.o2
    public final Internal$IntList mutableCopyWithCapacity(int i2) {
        if (i2 >= this.f2415h) {
            return new j2(i2 == 0 ? f2412i : Arrays.copyOf(this.f2414g, i2), this.f2415h, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addInt(((Integer) obj).intValue());
        return true;
    }
}
