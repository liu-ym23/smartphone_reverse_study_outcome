package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t extends c<Integer> implements RandomAccess, r0 {

    /* renamed from: b, reason: collision with root package name */
    public int[] f1883b;

    /* renamed from: c, reason: collision with root package name */
    public int f1884c;

    static {
        new t(new int[0], 0).f1793a = false;
    }

    public t() {
        this(new int[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i10 < 0 || i10 > (i11 = this.f1884c)) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
            sbK.append(this.f1884c);
            throw new IndexOutOfBoundsException(sbK.toString());
        }
        int[] iArr = this.f1883b;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i11 - i10);
        } else {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f1883b, i10, iArr2, i10 + 1, this.f1884c - i10);
            this.f1883b = iArr2;
        }
        this.f1883b[i10] = iIntValue;
        this.f1884c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        Charset charset = u.f1888a;
        collection.getClass();
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i10 = tVar.f1884c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f1884c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f1883b;
        if (i12 > iArr.length) {
            this.f1883b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(tVar.f1883b, 0, this.f1883b, this.f1884c, tVar.f1884c);
        this.f1884c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i10) {
        a();
        int i11 = this.f1884c;
        int[] iArr = this.f1883b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f1883b = iArr2;
        }
        int[] iArr3 = this.f1883b;
        int i12 = this.f1884c;
        this.f1884c = i12 + 1;
        iArr3[i12] = i10;
    }

    public final void c(int i10) {
        if (i10 < 0 || i10 >= this.f1884c) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
            sbK.append(this.f1884c);
            throw new IndexOutOfBoundsException(sbK.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.u.c
    public final u.c c0(int i10) {
        if (i10 >= this.f1884c) {
            return new t(Arrays.copyOf(this.f1883b, i10), this.f1884c);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.f1884c != tVar.f1884c) {
            return false;
        }
        int[] iArr = tVar.f1883b;
        for (int i10 = 0; i10 < this.f1884c; i10++) {
            if (this.f1883b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        c(i10);
        return Integer.valueOf(this.f1883b[i10]);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f1884c; i11++) {
            i10 = (i10 * 31) + this.f1883b[i11];
        }
        return i10;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i10 = 0; i10 < this.f1884c; i10++) {
            if (obj.equals(Integer.valueOf(this.f1883b[i10]))) {
                int[] iArr = this.f1883b;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.f1884c - i10) - 1);
                this.f1884c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f1883b;
        System.arraycopy(iArr, i11, iArr, i10, this.f1884c - i11);
        this.f1884c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        c(i10);
        int[] iArr = this.f1883b;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1884c;
    }

    public t(int[] iArr, int i10) {
        this.f1883b = iArr;
        this.f1884c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        a();
        c(i10);
        int[] iArr = this.f1883b;
        int i11 = iArr[i10];
        if (i10 < this.f1884c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f1884c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Integer) obj).intValue());
        return true;
    }
}
