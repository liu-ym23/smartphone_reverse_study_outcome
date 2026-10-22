package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.n1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0970n1 extends AbstractC0940g implements InterfaceC0982q1, RandomAccess, InterfaceC0959k2 {
    public static final C0970n1 d = new C0970n1(new int[0], 0, false);
    public int[] b;
    public int c;

    public C0970n1(int[] iArr, int i, boolean z10) {
        super(z10);
        this.b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i < 0 || i > (i6 = this.c)) {
            StringBuilder sbU = B7.a.u(i, "Index:", ", Size:");
            sbU.append(this.c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        int[] iArr = this.b;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i6 - i);
        } else {
            int[] iArr2 = new int[androidx.constraintlayout.core.dsl.a.b(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i + 1, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = iIntValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = AbstractC0989s1.f2940a;
        collection.getClass();
        if (!(collection instanceof C0970n1)) {
            return super.addAll(collection);
        }
        C0970n1 c0970n1 = (C0970n1) collection;
        int i = c0970n1.c;
        if (i == 0) {
            return false;
        }
        int i6 = this.c;
        if (Integer.MAX_VALUE - i6 < i) {
            throw new OutOfMemoryError();
        }
        int i10 = i6 + i;
        int[] iArr = this.b;
        if (i10 > iArr.length) {
            this.b = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(c0970n1.b, 0, this.b, this.c, c0970n1.c);
        this.c = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addInt(int i) {
        b();
        int i6 = this.c;
        int[] iArr = this.b;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[androidx.constraintlayout.core.dsl.a.b(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.b = iArr2;
        }
        int[] iArr3 = this.b;
        int i10 = this.c;
        this.c = i10 + 1;
        iArr3[i10] = i;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.c) {
            StringBuilder sbU = B7.a.u(i, "Index:", ", Size:");
            sbU.append(this.c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0970n1)) {
            return super.equals(obj);
        }
        C0970n1 c0970n1 = (C0970n1) obj;
        if (this.c != c0970n1.c) {
            return false;
        }
        int[] iArr = c0970n1.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        c(i);
        return this.b[i];
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.c; i6++) {
            i = (i * 31) + this.b[i6];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.c;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.b[i6] == iIntValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.InterfaceC0985r1
    public final InterfaceC0985r1 mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new C0970n1(Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        c(i);
        int[] iArr = this.b;
        int i6 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        b();
        if (i6 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.b;
        System.arraycopy(iArr, i6, iArr, i, this.c - i6);
        this.c -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        c(i);
        int[] iArr = this.b;
        int i6 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addInt(((Integer) obj).intValue());
        return true;
    }
}
