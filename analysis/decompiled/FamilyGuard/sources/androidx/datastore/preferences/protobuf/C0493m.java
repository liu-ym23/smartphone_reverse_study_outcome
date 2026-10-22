package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0493m extends AbstractC0483c<Double> implements A.b, RandomAccess, b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final C0493m f10093d;

    /* renamed from: b, reason: collision with root package name */
    private double[] f10094b;

    /* renamed from: c, reason: collision with root package name */
    private int f10095c;

    static {
        C0493m c0493m = new C0493m(new double[0], 0);
        f10093d = c0493m;
        c0493m.b();
    }

    C0493m() {
        this(new double[10], 0);
    }

    private void i(int i5, double d6) {
        int i6;
        a();
        if (i5 < 0 || i5 > (i6 = this.f10095c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        double[] dArr = this.f10094b;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i5 + 1, i6 - i5);
        } else {
            double[] dArr2 = new double[((i6 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.f10094b, i5, dArr2, i5 + 1, this.f10095c - i5);
            this.f10094b = dArr2;
        }
        this.f10094b[i5] = d6;
        this.f10095c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f10095c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f10095c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        A.a(collection);
        if (!(collection instanceof C0493m)) {
            return super.addAll(collection);
        }
        C0493m c0493m = (C0493m) collection;
        int i5 = c0493m.f10095c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f10095c;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        double[] dArr = this.f10094b;
        if (i7 > dArr.length) {
            this.f10094b = Arrays.copyOf(dArr, i7);
        }
        System.arraycopy(c0493m.f10094b, 0, this.f10094b, this.f10095c, c0493m.f10095c);
        this.f10095c = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, Double d6) {
        i(i5, d6.doubleValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0493m)) {
            return super.equals(obj);
        }
        C0493m c0493m = (C0493m) obj;
        if (this.f10095c != c0493m.f10095c) {
            return false;
        }
        double[] dArr = c0493m.f10094b;
        for (int i5 = 0; i5 < this.f10095c; i5++) {
            if (Double.doubleToLongBits(this.f10094b[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d6) {
        h(d6.doubleValue());
        return true;
    }

    public void h(double d6) {
        a();
        int i5 = this.f10095c;
        double[] dArr = this.f10094b;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[((i5 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.f10094b = dArr2;
        }
        double[] dArr3 = this.f10094b;
        int i6 = this.f10095c;
        this.f10095c = i6 + 1;
        dArr3[i6] = d6;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i5 = 0; i5 < this.f10095c; i5++) {
            iF = (iF * 31) + A.f(Double.doubleToLongBits(this.f10094b[i5]));
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Double get(int i5) {
        return Double.valueOf(o(i5));
    }

    public double o(int i5) {
        m(i5);
        return this.f10094b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.b d(int i5) {
        if (i5 >= this.f10095c) {
            return new C0493m(Arrays.copyOf(this.f10094b, i5), this.f10095c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Double remove(int i5) {
        a();
        m(i5);
        double[] dArr = this.f10094b;
        double d6 = dArr[i5];
        if (i5 < this.f10095c - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (r3 - i5) - 1);
        }
        this.f10095c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d6);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        a();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f10094b;
        System.arraycopy(dArr, i6, dArr, i5, this.f10095c - i6);
        this.f10095c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Double set(int i5, Double d6) {
        return Double.valueOf(t(i5, d6.doubleValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10095c;
    }

    public double t(int i5, double d6) {
        a();
        m(i5);
        double[] dArr = this.f10094b;
        double d7 = dArr[i5];
        dArr[i5] = d6;
        return d7;
    }

    private C0493m(double[] dArr, int i5) {
        this.f10094b = dArr;
        this.f10095c = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i5 = 0; i5 < this.f10095c; i5++) {
            if (obj.equals(Double.valueOf(this.f10094b[i5]))) {
                double[] dArr = this.f10094b;
                System.arraycopy(dArr, i5 + 1, dArr, i5, (this.f10095c - i5) - 1);
                this.f10095c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
