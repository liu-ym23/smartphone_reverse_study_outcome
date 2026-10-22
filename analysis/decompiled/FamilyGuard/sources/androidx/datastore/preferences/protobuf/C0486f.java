package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0486f extends AbstractC0483c<Boolean> implements A.a, RandomAccess, b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final C0486f f10002d;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f10003b;

    /* renamed from: c, reason: collision with root package name */
    private int f10004c;

    static {
        C0486f c0486f = new C0486f(new boolean[0], 0);
        f10002d = c0486f;
        c0486f.b();
    }

    C0486f() {
        this(new boolean[10], 0);
    }

    private void h(int i5, boolean z5) {
        int i6;
        a();
        if (i5 < 0 || i5 > (i6 = this.f10004c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        boolean[] zArr = this.f10003b;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.f10003b, i5, zArr2, i5 + 1, this.f10004c - i5);
            this.f10003b = zArr2;
        }
        this.f10003b[i5] = z5;
        this.f10004c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f10004c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f10004c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        A.a(collection);
        if (!(collection instanceof C0486f)) {
            return super.addAll(collection);
        }
        C0486f c0486f = (C0486f) collection;
        int i5 = c0486f.f10004c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f10004c;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        boolean[] zArr = this.f10003b;
        if (i7 > zArr.length) {
            this.f10003b = Arrays.copyOf(zArr, i7);
        }
        System.arraycopy(c0486f.f10003b, 0, this.f10003b, this.f10004c, c0486f.f10004c);
        this.f10004c = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, Boolean bool) {
        h(i5, bool.booleanValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0486f)) {
            return super.equals(obj);
        }
        C0486f c0486f = (C0486f) obj;
        if (this.f10004c != c0486f.f10004c) {
            return false;
        }
        boolean[] zArr = c0486f.f10003b;
        for (int i5 = 0; i5 < this.f10004c; i5++) {
            if (this.f10003b[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i5 = 0; i5 < this.f10004c; i5++) {
            iC = (iC * 31) + A.c(this.f10003b[i5]);
        }
        return iC;
    }

    public void i(boolean z5) {
        a();
        int i5 = this.f10004c;
        boolean[] zArr = this.f10003b;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.f10003b = zArr2;
        }
        boolean[] zArr3 = this.f10003b;
        int i6 = this.f10004c;
        this.f10004c = i6 + 1;
        zArr3[i6] = z5;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i5) {
        return Boolean.valueOf(o(i5));
    }

    public boolean o(int i5) {
        m(i5);
        return this.f10003b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.a d(int i5) {
        if (i5 >= this.f10004c) {
            return new C0486f(Arrays.copyOf(this.f10003b, i5), this.f10004c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i5) {
        a();
        m(i5);
        boolean[] zArr = this.f10003b;
        boolean z5 = zArr[i5];
        if (i5 < this.f10004c - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (r2 - i5) - 1);
        }
        this.f10004c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        a();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f10003b;
        System.arraycopy(zArr, i6, zArr, i5, this.f10004c - i6);
        this.f10004c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i5, Boolean bool) {
        return Boolean.valueOf(t(i5, bool.booleanValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10004c;
    }

    public boolean t(int i5, boolean z5) {
        a();
        m(i5);
        boolean[] zArr = this.f10003b;
        boolean z6 = zArr[i5];
        zArr[i5] = z5;
        return z6;
    }

    private C0486f(boolean[] zArr, int i5) {
        this.f10003b = zArr;
        this.f10004c = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i5 = 0; i5 < this.f10004c; i5++) {
            if (obj.equals(Boolean.valueOf(this.f10003b[i5]))) {
                boolean[] zArr = this.f10003b;
                System.arraycopy(zArr, i5 + 1, zArr, i5, (this.f10004c - i5) - 1);
                this.f10004c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
