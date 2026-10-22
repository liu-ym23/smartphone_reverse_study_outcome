package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class C extends AbstractC1340c<Long> implements C1359w.h, RandomAccess, U {

    /* renamed from: d, reason: collision with root package name */
    public static final C f13419d;

    /* renamed from: b, reason: collision with root package name */
    public long[] f13420b;

    /* renamed from: c, reason: collision with root package name */
    public int f13421c;

    static {
        C c10 = new C(new long[0], 0);
        f13419d = c10;
        c10.makeImmutable();
    }

    public C() {
        this(new long[10], 0);
    }

    private void i(int i10) {
        if (i10 < 0 || i10 >= this.f13421c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    private String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13421c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        b();
        C1359w.a(collection);
        if (!(collection instanceof C)) {
            return super.addAll(collection);
        }
        C c10 = (C) collection;
        int i10 = c10.f13421c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f13421c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f13420b;
        if (i12 > jArr.length) {
            this.f13420b = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(c10.f13420b, 0, this.f13420b, this.f13421c, c10.f13421c);
        this.f13421c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addLong(long j10) {
        b();
        int i10 = this.f13421c;
        long[] jArr = this.f13420b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f13420b = jArr2;
        }
        long[] jArr3 = this.f13420b;
        int i11 = this.f13421c;
        this.f13421c = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Long l10) {
        f(i10, l10.longValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l10) {
        addLong(l10.longValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return super.equals(obj);
        }
        C c10 = (C) obj;
        if (this.f13421c != c10.f13421c) {
            return false;
        }
        long[] jArr = c10.f13420b;
        for (int i10 = 0; i10 < this.f13421c; i10++) {
            if (this.f13420b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, long j10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f13421c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        long[] jArr = this.f13420b;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f13420b, i10, jArr2, i10 + 1, this.f13421c - i10);
            this.f13420b = jArr2;
        }
        this.f13420b[i10] = j10;
        this.f13421c++;
        ((AbstractList) this).modCount++;
    }

    public long getLong(int i10) {
        i(i10);
        return this.f13420b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i10 = 0; i10 < this.f13421c; i10++) {
            iF = (iF * 31) + C1359w.f(this.f13420b[i10]);
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long get(int i10) {
        return Long.valueOf(getLong(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C1359w.h mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13421c) {
            return new C(Arrays.copyOf(this.f13420b, i10), this.f13421c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Long remove(int i10) {
        b();
        i(i10);
        long[] jArr = this.f13420b;
        long j10 = jArr[i10];
        if (i10 < this.f13421c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f13421c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long set(int i10, Long l10) {
        return Long.valueOf(setLong(i10, l10.longValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f13420b;
        System.arraycopy(jArr, i11, jArr, i10, this.f13421c - i11);
        this.f13421c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public long setLong(int i10, long j10) {
        b();
        i(i10);
        long[] jArr = this.f13420b;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13421c;
    }

    public C(long[] jArr, int i10) {
        this.f13420b = jArr;
        this.f13421c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f13421c; i10++) {
            if (obj.equals(Long.valueOf(this.f13420b[i10]))) {
                long[] jArr = this.f13420b;
                System.arraycopy(jArr, i10 + 1, jArr, i10, (this.f13421c - i10) - 1);
                this.f13421c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
