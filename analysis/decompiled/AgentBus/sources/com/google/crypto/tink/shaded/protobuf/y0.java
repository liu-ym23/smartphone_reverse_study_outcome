package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class y0 extends b implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    public static final y0 f2293i;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f2294g;

    /* renamed from: h, reason: collision with root package name */
    public int f2295h;

    static {
        y0 y0Var = new y0(0, new Object[0]);
        f2293i = y0Var;
        y0Var.f2176f = false;
    }

    public y0(int i2, Object[] objArr) {
        this.f2294g = objArr;
        this.f2295h = i2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i2 = this.f2295h;
        Object[] objArr = this.f2294g;
        if (i2 == objArr.length) {
            this.f2294g = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f2294g;
        int i10 = this.f2295h;
        this.f2295h = i10 + 1;
        objArr2[i10] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void f(int i2) {
        if (i2 < 0 || i2 >= this.f2295h) {
            StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
            sbN.append(this.f2295h);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f(i2);
        return this.f2294g[i2];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.y
    public final y mutableCopyWithCapacity(int i2) {
        if (i2 < this.f2295h) {
            throw new IllegalArgumentException();
        }
        return new y0(this.f2295h, Arrays.copyOf(this.f2294g, i2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        f(i2);
        Object[] objArr = this.f2294g;
        Object obj = objArr[i2];
        if (i2 < this.f2295h - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (r2 - i2) - 1);
        }
        this.f2295h--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        f(i2);
        Object[] objArr = this.f2294g;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2295h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        a();
        if (i2 >= 0 && i2 <= (i10 = this.f2295h)) {
            Object[] objArr = this.f2294g;
            if (i10 < objArr.length) {
                System.arraycopy(objArr, i2, objArr, i2 + 1, i10 - i2);
            } else {
                Object[] objArr2 = new Object[((i10 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                System.arraycopy(this.f2294g, i2, objArr2, i2 + 1, this.f2295h - i2);
                this.f2294g = objArr2;
            }
            this.f2294g[i2] = obj;
            this.f2295h++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbN = a1.a.n(i2, "Index:", ", Size:");
        sbN.append(this.f2295h);
        throw new IndexOutOfBoundsException(sbN.toString());
    }
}
