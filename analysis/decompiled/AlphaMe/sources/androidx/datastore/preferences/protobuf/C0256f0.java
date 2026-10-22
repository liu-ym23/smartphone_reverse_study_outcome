package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0256f0 extends AbstractC0249c implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final C0256f0 f3473d;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f3474b;

    /* renamed from: c, reason: collision with root package name */
    public int f3475c;

    static {
        C0256f0 c0256f0 = new C0256f0(new Object[0], 0);
        f3473d = c0256f0;
        c0256f0.f3464a = false;
    }

    public C0256f0(Object[] objArr, int i4) {
        this.f3474b = objArr;
        this.f3475c = i4;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0249c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i4 = this.f3475c;
        Object[] objArr = this.f3474b;
        if (i4 == objArr.length) {
            this.f3474b = Arrays.copyOf(objArr, ((i4 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f3474b;
        int i5 = this.f3475c;
        this.f3475c = i5 + 1;
        objArr2[i5] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.C
    public final C b(int i4) {
        if (i4 >= this.f3475c) {
            return new C0256f0(Arrays.copyOf(this.f3474b, i4), this.f3475c);
        }
        throw new IllegalArgumentException();
    }

    public final void c(int i4) {
        if (i4 < 0 || i4 >= this.f3475c) {
            StringBuilder sbT = B0.g.t("Index:", i4, ", Size:");
            sbT.append(this.f3475c);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        c(i4);
        return this.f3474b[i4];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i4) {
        a();
        c(i4);
        Object[] objArr = this.f3474b;
        Object obj = objArr[i4];
        if (i4 < this.f3475c - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (r2 - i4) - 1);
        }
        this.f3475c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        a();
        c(i4);
        Object[] objArr = this.f3474b;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3475c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        a();
        if (i4 >= 0 && i4 <= (i5 = this.f3475c)) {
            Object[] objArr = this.f3474b;
            if (i5 < objArr.length) {
                System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
            } else {
                Object[] objArr2 = new Object[((i5 * 3) / 2) + 1];
                System.arraycopy(objArr, 0, objArr2, 0, i4);
                System.arraycopy(this.f3474b, i4, objArr2, i4 + 1, this.f3475c - i4);
                this.f3474b = objArr2;
            }
            this.f3474b[i4] = obj;
            this.f3475c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbT = B0.g.t("Index:", i4, ", Size:");
        sbT.append(this.f3475c);
        throw new IndexOutOfBoundsException(sbT.toString());
    }
}
