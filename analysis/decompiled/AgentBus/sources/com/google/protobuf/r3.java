package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class r3 extends d implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f2513i;

    /* renamed from: j, reason: collision with root package name */
    public static final r3 f2514j;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f2515g;

    /* renamed from: h, reason: collision with root package name */
    public int f2516h;

    static {
        Object[] objArr = new Object[0];
        f2513i = objArr;
        f2514j = new r3(objArr, 0, false);
    }

    public r3(Object[] objArr, int i2, boolean z4) {
        super(z4);
        this.f2515g = objArr;
        this.f2516h = i2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i2 = this.f2516h;
        Object[] objArr = this.f2515g;
        if (i2 == objArr.length) {
            this.f2515g = Arrays.copyOf(this.f2515g, a1.a.d(objArr.length, 3, 2, 1, 10));
        }
        Object[] objArr2 = this.f2515g;
        int i10 = this.f2516h;
        this.f2516h = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f2516h) {
            StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
            sbN.append(this.f2516h);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f(i2);
        return this.f2515g[i2];
    }

    @Override // com.google.protobuf.o2
    public final o2 mutableCopyWithCapacity(int i2) {
        if (i2 >= this.f2516h) {
            return new r3(i2 == 0 ? f2513i : Arrays.copyOf(this.f2515g, i2), this.f2516h, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        f(i2);
        Object[] objArr = this.f2515g;
        Object obj = objArr[i2];
        if (i2 < this.f2516h - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f2516h--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        f(i2);
        Object[] objArr = this.f2515g;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2516h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        a();
        if (i2 >= 0 && i2 <= (i10 = this.f2516h)) {
            Object[] objArr = this.f2515g;
            if (i10 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i10 - i2);
            } else {
                Object[] objArr2 = new Object[a1.a.d(objArr.length, 3, 2, 1, 10)];
                System.arraycopy(this.f2515g, 0, objArr2, 0, i2);
                System.arraycopy(this.f2515g, i2, objArr2, i2 + 1, this.f2516h - i2);
                this.f2515g = objArr2;
            }
            this.f2515g[i2] = obj;
            this.f2516h++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
        sbN.append(this.f2516h);
        throw new IndexOutOfBoundsException(sbN.toString());
    }
}
