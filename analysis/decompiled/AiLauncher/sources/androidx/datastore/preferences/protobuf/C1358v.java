package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1358v extends AbstractC1340c<Integer> implements C1359w.g, RandomAccess, U {

    /* renamed from: d, reason: collision with root package name */
    public static final C1358v f13639d;

    /* renamed from: b, reason: collision with root package name */
    public int[] f13640b;

    /* renamed from: c, reason: collision with root package name */
    public int f13641c;

    static {
        C1358v c1358v = new C1358v(new int[0], 0);
        f13639d = c1358v;
        c1358v.makeImmutable();
    }

    public C1358v() {
        this(new int[10], 0);
    }

    private void i(int i10) {
        if (i10 < 0 || i10 >= this.f13641c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    private String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13641c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        C1359w.a(collection);
        if (!(collection instanceof C1358v)) {
            return super.addAll(collection);
        }
        C1358v c1358v = (C1358v) collection;
        int i10 = c1358v.f13641c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f13641c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f13640b;
        if (i12 > iArr.length) {
            this.f13640b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(c1358v.f13640b, 0, this.f13640b, this.f13641c, c1358v.f13641c);
        this.f13641c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addInt(int i10) {
        b();
        int i11 = this.f13641c;
        int[] iArr = this.f13640b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f13640b = iArr2;
        }
        int[] iArr3 = this.f13640b;
        int i12 = this.f13641c;
        this.f13641c = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Integer num) {
        f(i10, num.intValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1358v)) {
            return super.equals(obj);
        }
        C1358v c1358v = (C1358v) obj;
        if (this.f13641c != c1358v.f13641c) {
            return false;
        }
        int[] iArr = c1358v.f13640b;
        for (int i10 = 0; i10 < this.f13641c; i10++) {
            if (this.f13640b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, int i11) {
        int i12;
        b();
        if (i10 < 0 || i10 > (i12 = this.f13641c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        int[] iArr = this.f13640b;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f13640b, i10, iArr2, i10 + 1, this.f13641c - i10);
            this.f13640b = iArr2;
        }
        this.f13640b[i10] = i11;
        this.f13641c++;
        ((AbstractList) this).modCount++;
    }

    public int getInt(int i10) {
        i(i10);
        return this.f13640b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f13641c; i11++) {
            i10 = (i10 * 31) + this.f13640b[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C1359w.g mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13641c) {
            return new C1358v(Arrays.copyOf(this.f13640b, i10), this.f13641c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i10) {
        b();
        i(i10);
        int[] iArr = this.f13640b;
        int i11 = iArr[i10];
        if (i10 < this.f13641c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f13641c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(setInt(i10, num.intValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f13640b;
        System.arraycopy(iArr, i11, iArr, i10, this.f13641c - i11);
        this.f13641c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public int setInt(int i10, int i11) {
        b();
        i(i10);
        int[] iArr = this.f13640b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13641c;
    }

    public C1358v(int[] iArr, int i10) {
        this.f13640b = iArr;
        this.f13641c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f13641c; i10++) {
            if (obj.equals(Integer.valueOf(this.f13640b[i10]))) {
                int[] iArr = this.f13640b;
                System.arraycopy(iArr, i10 + 1, iArr, i10, (this.f13641c - i10) - 1);
                this.f13641c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
