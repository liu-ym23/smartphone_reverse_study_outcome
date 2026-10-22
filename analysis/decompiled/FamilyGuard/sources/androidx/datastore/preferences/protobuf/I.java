package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class I extends AbstractC0483c<Long> implements A.h, RandomAccess, b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final I f9939d;

    /* renamed from: b, reason: collision with root package name */
    private long[] f9940b;

    /* renamed from: c, reason: collision with root package name */
    private int f9941c;

    static {
        I i5 = new I(new long[0], 0);
        f9939d = i5;
        i5.b();
    }

    I() {
        this(new long[10], 0);
    }

    private void h(int i5, long j5) {
        int i6;
        a();
        if (i5 < 0 || i5 > (i6 = this.f9941c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        long[] jArr = this.f9940b;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
        } else {
            long[] jArr2 = new long[((i6 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.f9940b, i5, jArr2, i5 + 1, this.f9941c - i5);
            this.f9940b = jArr2;
        }
        this.f9940b[i5] = j5;
        this.f9941c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f9941c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f9941c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        A.a(collection);
        if (!(collection instanceof I)) {
            return super.addAll(collection);
        }
        I i5 = (I) collection;
        int i6 = i5.f9941c;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.f9941c;
        if (Integer.MAX_VALUE - i7 < i6) {
            throw new OutOfMemoryError();
        }
        int i8 = i7 + i6;
        long[] jArr = this.f9940b;
        if (i8 > jArr.length) {
            this.f9940b = Arrays.copyOf(jArr, i8);
        }
        System.arraycopy(i5.f9940b, 0, this.f9940b, this.f9941c, i5.f9941c);
        this.f9941c = i8;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, Long l5) {
        h(i5, l5.longValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return super.equals(obj);
        }
        I i5 = (I) obj;
        if (this.f9941c != i5.f9941c) {
            return false;
        }
        long[] jArr = i5.f9940b;
        for (int i6 = 0; i6 < this.f9941c; i6++) {
            if (this.f9940b[i6] != jArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l5) {
        i(l5.longValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i5 = 0; i5 < this.f9941c; i5++) {
            iF = (iF * 31) + A.f(this.f9940b[i5]);
        }
        return iF;
    }

    public void i(long j5) {
        a();
        int i5 = this.f9941c;
        long[] jArr = this.f9940b;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[((i5 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.f9940b = jArr2;
        }
        long[] jArr3 = this.f9940b;
        int i6 = this.f9941c;
        this.f9941c = i6 + 1;
        jArr3[i6] = j5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long get(int i5) {
        return Long.valueOf(o(i5));
    }

    public long o(int i5) {
        m(i5);
        return this.f9940b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.h d(int i5) {
        if (i5 >= this.f9941c) {
            return new I(Arrays.copyOf(this.f9940b, i5), this.f9941c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Long remove(int i5) {
        a();
        m(i5);
        long[] jArr = this.f9940b;
        long j5 = jArr[i5];
        if (i5 < this.f9941c - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (r3 - i5) - 1);
        }
        this.f9941c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        a();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f9940b;
        System.arraycopy(jArr, i6, jArr, i5, this.f9941c - i6);
        this.f9941c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Long set(int i5, Long l5) {
        return Long.valueOf(t(i5, l5.longValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9941c;
    }

    public long t(int i5, long j5) {
        a();
        m(i5);
        long[] jArr = this.f9940b;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }

    private I(long[] jArr, int i5) {
        this.f9940b = jArr;
        this.f9941c = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i5 = 0; i5 < this.f9941c; i5++) {
            if (obj.equals(Long.valueOf(this.f9940b[i5]))) {
                long[] jArr = this.f9940b;
                System.arraycopy(jArr, i5 + 1, jArr, i5, (this.f9941c - i5) - 1);
                this.f9941c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
