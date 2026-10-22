package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0505z extends AbstractC0483c<Integer> implements A.g, RandomAccess, b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final C0505z f10281d;

    /* renamed from: b, reason: collision with root package name */
    private int[] f10282b;

    /* renamed from: c, reason: collision with root package name */
    private int f10283c;

    static {
        C0505z c0505z = new C0505z(new int[0], 0);
        f10281d = c0505z;
        c0505z.b();
    }

    C0505z() {
        this(new int[10], 0);
    }

    private void i(int i5, int i6) {
        int i7;
        a();
        if (i5 < 0 || i5 > (i7 = this.f10283c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        int[] iArr = this.f10282b;
        if (i7 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i7 - i5);
        } else {
            int[] iArr2 = new int[((i7 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.f10282b, i5, iArr2, i5 + 1, this.f10283c - i5);
            this.f10282b = iArr2;
        }
        this.f10282b[i5] = i6;
        this.f10283c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f10283c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f10283c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        A.a(collection);
        if (!(collection instanceof C0505z)) {
            return super.addAll(collection);
        }
        C0505z c0505z = (C0505z) collection;
        int i5 = c0505z.f10283c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f10283c;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        int[] iArr = this.f10282b;
        if (i7 > iArr.length) {
            this.f10282b = Arrays.copyOf(iArr, i7);
        }
        System.arraycopy(c0505z.f10282b, 0, this.f10282b, this.f10283c, c0505z.f10283c);
        this.f10283c = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, Integer num) {
        i(i5, num.intValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0505z)) {
            return super.equals(obj);
        }
        C0505z c0505z = (C0505z) obj;
        if (this.f10283c != c0505z.f10283c) {
            return false;
        }
        int[] iArr = c0505z.f10282b;
        for (int i5 = 0; i5 < this.f10283c; i5++) {
            if (this.f10282b[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        h(num.intValue());
        return true;
    }

    public void h(int i5) {
        a();
        int i6 = this.f10283c;
        int[] iArr = this.f10282b;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f10282b = iArr2;
        }
        int[] iArr3 = this.f10282b;
        int i7 = this.f10283c;
        this.f10283c = i7 + 1;
        iArr3[i7] = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.f10283c; i6++) {
            i5 = (i5 * 31) + this.f10282b[i6];
        }
        return i5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer get(int i5) {
        return Integer.valueOf(o(i5));
    }

    public int o(int i5) {
        m(i5);
        return this.f10282b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.g d(int i5) {
        if (i5 >= this.f10283c) {
            return new C0505z(Arrays.copyOf(this.f10282b, i5), this.f10283c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i5) {
        a();
        m(i5);
        int[] iArr = this.f10282b;
        int i6 = iArr[i5];
        if (i5 < this.f10283c - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (r2 - i5) - 1);
        }
        this.f10283c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        a();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f10282b;
        System.arraycopy(iArr, i6, iArr, i5, this.f10283c - i6);
        this.f10283c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer set(int i5, Integer num) {
        return Integer.valueOf(t(i5, num.intValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10283c;
    }

    public int t(int i5, int i6) {
        a();
        m(i5);
        int[] iArr = this.f10282b;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }

    private C0505z(int[] iArr, int i5) {
        this.f10282b = iArr;
        this.f10283c = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i5 = 0; i5 < this.f10283c; i5++) {
            if (obj.equals(Integer.valueOf(this.f10282b[i5]))) {
                int[] iArr = this.f10282b;
                System.arraycopy(iArr, i5 + 1, iArr, i5, (this.f10283c - i5) - 1);
                this.f10283c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
