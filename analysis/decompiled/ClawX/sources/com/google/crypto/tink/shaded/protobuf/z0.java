package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z0 extends b implements RandomAccess {
    public static final z0 d;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1543b;

    /* renamed from: c, reason: collision with root package name */
    public int f1544c;

    static {
        z0 z0Var = new z0(new Object[0], 0);
        d = z0Var;
        z0Var.f1433a = false;
    }

    public z0(Object[] objArr, int i8) {
        this.f1543b = objArr;
        this.f1544c = i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final z a(int i8) {
        if (i8 >= this.f1544c) {
            return new z0(Arrays.copyOf(this.f1543b, i8), this.f1544c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i8 = this.f1544c;
        Object[] objArr = this.f1543b;
        if (i8 == objArr.length) {
            this.f1543b = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1543b;
        int i9 = this.f1544c;
        this.f1544c = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void g(int i8) {
        if (i8 < 0 || i8 >= this.f1544c) {
            StringBuilder sbS = a8.b.s(i8, "Index:", ", Size:");
            sbS.append(this.f1544c);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        g(i8);
        return this.f1543b[i8];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        f();
        g(i8);
        Object[] objArr = this.f1543b;
        Object obj = objArr[i8];
        if (i8 < this.f1544c - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.f1544c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        f();
        g(i8);
        Object[] objArr = this.f1543b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1544c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        f();
        if (i8 >= 0 && i8 <= (i9 = this.f1544c)) {
            Object[] objArr = this.f1543b;
            if (i9 < objArr.length) {
                System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
            } else {
                Object[] objArr2 = new Object[((i9 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i8);
                System.arraycopy(this.f1543b, i8, objArr2, i8 + 1, this.f1544c - i8);
                this.f1543b = objArr2;
            }
            this.f1543b[i8] = obj;
            this.f1544c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbS = a8.b.s(i8, "Index:", ", Size:");
        sbS.append(this.f1544c);
        throw new IndexOutOfBoundsException(sbS.toString());
    }
}
