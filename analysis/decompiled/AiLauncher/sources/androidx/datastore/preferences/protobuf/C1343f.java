package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1343f extends AbstractC1340c<Boolean> implements C1359w.a, RandomAccess, U {

    /* renamed from: d, reason: collision with root package name */
    public static final C1343f f13546d;

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f13547b;

    /* renamed from: c, reason: collision with root package name */
    public int f13548c;

    static {
        C1343f c1343f = new C1343f(new boolean[0], 0);
        f13546d = c1343f;
        c1343f.makeImmutable();
    }

    public C1343f() {
        this(new boolean[10], 0);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        C1359w.a(collection);
        if (!(collection instanceof C1343f)) {
            return super.addAll(collection);
        }
        C1343f c1343f = (C1343f) collection;
        int i10 = c1343f.f13548c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f13548c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f13547b;
        if (i12 > zArr.length) {
            this.f13547b = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy(c1343f.f13547b, 0, this.f13547b, this.f13548c, c1343f.f13548c);
        this.f13548c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addBoolean(boolean z10) {
        b();
        int i10 = this.f13548c;
        boolean[] zArr = this.f13547b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f13547b = zArr2;
        }
        boolean[] zArr3 = this.f13547b;
        int i11 = this.f13548c;
        this.f13548c = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Boolean bool) {
        f(i10, bool.booleanValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1343f)) {
            return super.equals(obj);
        }
        C1343f c1343f = (C1343f) obj;
        if (this.f13548c != c1343f.f13548c) {
            return false;
        }
        boolean[] zArr = c1343f.f13547b;
        for (int i10 = 0; i10 < this.f13548c; i10++) {
            if (this.f13547b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, boolean z10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f13548c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        boolean[] zArr = this.f13547b;
        if (i11 < zArr.length) {
            System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            System.arraycopy(this.f13547b, i10, zArr2, i10 + 1, this.f13548c - i10);
            this.f13547b = zArr2;
        }
        this.f13547b[i10] = z10;
        this.f13548c++;
        ((AbstractList) this).modCount++;
    }

    public boolean getBoolean(int i10) {
        i(i10);
        return this.f13547b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i10 = 0; i10 < this.f13548c; i10++) {
            iC = (iC * 31) + C1359w.c(this.f13547b[i10]);
        }
        return iC;
    }

    public final void i(int i10) {
        if (i10 < 0 || i10 >= this.f13548c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i10) {
        return Boolean.valueOf(getBoolean(i10));
    }

    public final String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13548c;
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C1359w.a mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13548c) {
            return new C1343f(Arrays.copyOf(this.f13547b, i10), this.f13548c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i10) {
        b();
        i(i10);
        boolean[] zArr = this.f13547b;
        boolean z10 = zArr[i10];
        if (i10 < this.f13548c - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f13548c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(setBoolean(i10, bool.booleanValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f13547b;
        System.arraycopy(zArr, i11, zArr, i10, this.f13548c - i11);
        this.f13548c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public boolean setBoolean(int i10, boolean z10) {
        b();
        i(i10);
        boolean[] zArr = this.f13547b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13548c;
    }

    public C1343f(boolean[] zArr, int i10) {
        this.f13547b = zArr;
        this.f13548c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f13548c; i10++) {
            if (obj.equals(Boolean.valueOf(this.f13547b[i10]))) {
                boolean[] zArr = this.f13547b;
                System.arraycopy(zArr, i10 + 1, zArr, i10, (this.f13548c - i10) - 1);
                this.f13548c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
