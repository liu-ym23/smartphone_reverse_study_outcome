package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.q1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1756q1 extends V implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final C1756q1 f20126d = new C1756q1(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f20127b;

    /* renamed from: c, reason: collision with root package name */
    public int f20128c;

    public C1756q1(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f20127b = objArr;
        this.f20128c = i10;
    }

    public static C1756q1 c() {
        return f20126d;
    }

    private final void f(int i10) {
        if (i10 < 0 || i10 >= this.f20128c) {
            throw new IndexOutOfBoundsException(e(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f20128c)) {
            throw new IndexOutOfBoundsException(e(i10));
        }
        int i12 = i10 + 1;
        Object[] objArr = this.f20127b;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i12, i11 - i10);
        } else {
            Object[] objArr2 = new Object[((i11 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f20127b, i10, objArr2, i12, this.f20128c - i10);
            this.f20127b = objArr2;
        }
        this.f20127b[i10] = obj;
        this.f20128c++;
        ((AbstractList) this).modCount++;
    }

    public final String e(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20128c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    public final /* bridge */ /* synthetic */ M0 g(int i10) {
        if (i10 >= this.f20128c) {
            return new C1756q1(Arrays.copyOf(this.f20127b, i10), this.f20128c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        f(i10);
        return this.f20127b[i10];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        b();
        f(i10);
        Object[] objArr = this.f20127b;
        Object obj = objArr[i10];
        if (i10 < this.f20128c - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f20128c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        b();
        f(i10);
        Object[] objArr = this.f20127b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20128c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i10 = this.f20128c;
        Object[] objArr = this.f20127b;
        if (i10 == objArr.length) {
            this.f20127b = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f20127b;
        int i11 = this.f20128c;
        this.f20128c = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
