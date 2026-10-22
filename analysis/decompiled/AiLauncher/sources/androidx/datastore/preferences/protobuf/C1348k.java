package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1348k extends AbstractC1340c<Double> implements C1359w.b, RandomAccess, U {

    /* renamed from: d, reason: collision with root package name */
    public static final C1348k f13615d;

    /* renamed from: b, reason: collision with root package name */
    public double[] f13616b;

    /* renamed from: c, reason: collision with root package name */
    public int f13617c;

    static {
        C1348k c1348k = new C1348k(new double[0], 0);
        f13615d = c1348k;
        c1348k.makeImmutable();
    }

    public C1348k() {
        this(new double[10], 0);
    }

    private void i(int i10) {
        if (i10 < 0 || i10 >= this.f13617c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    private String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13617c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        b();
        C1359w.a(collection);
        if (!(collection instanceof C1348k)) {
            return super.addAll(collection);
        }
        C1348k c1348k = (C1348k) collection;
        int i10 = c1348k.f13617c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f13617c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f13616b;
        if (i12 > dArr.length) {
            this.f13616b = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy(c1348k.f13616b, 0, this.f13616b, this.f13617c, c1348k.f13617c);
        this.f13617c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addDouble(double d10) {
        b();
        int i10 = this.f13617c;
        double[] dArr = this.f13616b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f13616b = dArr2;
        }
        double[] dArr3 = this.f13616b;
        int i11 = this.f13617c;
        this.f13617c = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Double d10) {
        f(i10, d10.doubleValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d10) {
        addDouble(d10.doubleValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1348k)) {
            return super.equals(obj);
        }
        C1348k c1348k = (C1348k) obj;
        if (this.f13617c != c1348k.f13617c) {
            return false;
        }
        double[] dArr = c1348k.f13616b;
        for (int i10 = 0; i10 < this.f13617c; i10++) {
            if (Double.doubleToLongBits(this.f13616b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, double d10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f13617c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        double[] dArr = this.f13616b;
        if (i11 < dArr.length) {
            System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            System.arraycopy(this.f13616b, i10, dArr2, i10 + 1, this.f13617c - i10);
            this.f13616b = dArr2;
        }
        this.f13616b[i10] = d10;
        this.f13617c++;
        ((AbstractList) this).modCount++;
    }

    public double getDouble(int i10) {
        i(i10);
        return this.f13616b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i10 = 0; i10 < this.f13617c; i10++) {
            iF = (iF * 31) + C1359w.f(Double.doubleToLongBits(this.f13616b[i10]));
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Double get(int i10) {
        return Double.valueOf(getDouble(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C1359w.b mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13617c) {
            return new C1348k(Arrays.copyOf(this.f13616b, i10), this.f13617c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Double remove(int i10) {
        b();
        i(i10);
        double[] dArr = this.f13616b;
        double d10 = dArr[i10];
        if (i10 < this.f13617c - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f13617c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Double set(int i10, Double d10) {
        return Double.valueOf(setDouble(i10, d10.doubleValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f13616b;
        System.arraycopy(dArr, i11, dArr, i10, this.f13617c - i11);
        this.f13617c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public double setDouble(int i10, double d10) {
        b();
        i(i10);
        double[] dArr = this.f13616b;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13617c;
    }

    public C1348k(double[] dArr, int i10) {
        this.f13616b = dArr;
        this.f13617c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f13617c; i10++) {
            if (obj.equals(Double.valueOf(this.f13616b[i10]))) {
                double[] dArr = this.f13616b;
                System.arraycopy(dArr, i10 + 1, dArr, i10, (this.f13617c - i10) - 1);
                this.f13617c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
