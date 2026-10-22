package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.m2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0967m2 extends AbstractC0940g implements RandomAccess {
    public static final C0967m2 d = new C0967m2(new Object[0], 0, false);
    public Object[] b;
    public int c;

    public C0967m2(Object[] objArr, int i, boolean z10) {
        super(z10);
        this.b = objArr;
        this.c = i;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.b;
        int i6 = this.c;
        this.c = i6 + 1;
        objArr2[i6] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.c) {
            StringBuilder sbU = B7.a.u(i, "Index:", ", Size:");
            sbU.append(this.c);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return this.b[i];
    }

    @Override // com.google.protobuf.InterfaceC0985r1
    public final InterfaceC0985r1 mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new C0967m2(Arrays.copyOf(this.b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        c(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        c(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        b();
        if (i >= 0 && i <= (i6 = this.c)) {
            Object[] objArr = this.b;
            if (i6 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i6 - i);
            } else {
                Object[] objArr2 = new Object[androidx.constraintlayout.core.dsl.a.b(i6, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.b, i, objArr2, i + 1, this.c - i);
                this.b = objArr2;
            }
            this.b[i] = obj;
            this.c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbU = B7.a.u(i, "Index:", ", Size:");
        sbU.append(this.c);
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
