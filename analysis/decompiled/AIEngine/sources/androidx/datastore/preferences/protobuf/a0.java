package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a0 extends c<Long> implements RandomAccess, r0 {

    /* renamed from: b, reason: collision with root package name */
    public long[] f1781b;

    /* renamed from: c, reason: collision with root package name */
    public int f1782c;

    static {
        new a0(0, new long[0]).f1793a = false;
    }

    public a0() {
        this(0, new long[10]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i10 < 0 || i10 > (i11 = this.f1782c)) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
            sbK.append(this.f1782c);
            throw new IndexOutOfBoundsException(sbK.toString());
        }
        long[] jArr = this.f1781b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f1781b, i10, jArr2, i10 + 1, this.f1782c - i10);
            this.f1781b = jArr2;
        }
        this.f1781b[i10] = jLongValue;
        this.f1782c++;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        Charset charset = u.f1888a;
        collection.getClass();
        if (!(collection instanceof a0)) {
            return super.addAll(collection);
        }
        a0 a0Var = (a0) collection;
        int i10 = a0Var.f1782c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f1782c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f1781b;
        if (i12 > jArr.length) {
            this.f1781b = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(a0Var.f1781b, 0, this.f1781b, this.f1782c, a0Var.f1782c);
        this.f1782c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(long j10) {
        a();
        int i10 = this.f1782c;
        long[] jArr = this.f1781b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f1781b = jArr2;
        }
        long[] jArr3 = this.f1781b;
        int i11 = this.f1782c;
        this.f1782c = i11 + 1;
        jArr3[i11] = j10;
    }

    public final void c(int i10) {
        if (i10 < 0 || i10 >= this.f1782c) {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Index:", ", Size:");
            sbK.append(this.f1782c);
            throw new IndexOutOfBoundsException(sbK.toString());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.u.c
    public final u.c c0(int i10) {
        if (i10 < this.f1782c) {
            throw new IllegalArgumentException();
        }
        return new a0(this.f1782c, Arrays.copyOf(this.f1781b, i10));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return super.equals(obj);
        }
        a0 a0Var = (a0) obj;
        if (this.f1782c != a0Var.f1782c) {
            return false;
        }
        long[] jArr = a0Var.f1781b;
        for (int i10 = 0; i10 < this.f1782c; i10++) {
            if (this.f1781b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        c(i10);
        return Long.valueOf(this.f1781b[i10]);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i10 = 0; i10 < this.f1782c; i10++) {
            iB = (iB * 31) + u.b(this.f1781b[i10]);
        }
        return iB;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i10 = 0; i10 < this.f1782c; i10++) {
            if (obj.equals(Long.valueOf(this.f1781b[i10]))) {
                long[] jArr = this.f1781b;
                System.arraycopy(jArr, i10 + 1, jArr, i10, (this.f1782c - i10) - 1);
                this.f1782c--;
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
        long[] jArr = this.f1781b;
        System.arraycopy(jArr, i11, jArr, i10, this.f1782c - i11);
        this.f1782c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        c(i10);
        long[] jArr = this.f1781b;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1782c;
    }

    public a0(int i10, long[] jArr) {
        this.f1781b = jArr;
        this.f1782c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        a();
        c(i10);
        long[] jArr = this.f1781b;
        long j10 = jArr[i10];
        if (i10 < this.f1782c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f1782c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Long) obj).longValue());
        return true;
    }
}
