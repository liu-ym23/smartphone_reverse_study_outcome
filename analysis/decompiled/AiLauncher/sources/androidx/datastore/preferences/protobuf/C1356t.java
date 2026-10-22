package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1359w;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1356t extends AbstractC1340c<Float> implements C1359w.f, RandomAccess, U {

    /* renamed from: d, reason: collision with root package name */
    public static final C1356t f13635d;

    /* renamed from: b, reason: collision with root package name */
    public float[] f13636b;

    /* renamed from: c, reason: collision with root package name */
    public int f13637c;

    static {
        C1356t c1356t = new C1356t(new float[0], 0);
        f13635d = c1356t;
        c1356t.makeImmutable();
    }

    public C1356t() {
        this(new float[10], 0);
    }

    private void i(int i10) {
        if (i10 < 0 || i10 >= this.f13637c) {
            throw new IndexOutOfBoundsException(k(i10));
        }
    }

    private String k(int i10) {
        return "Index:" + i10 + ", Size:" + this.f13637c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        b();
        C1359w.a(collection);
        if (!(collection instanceof C1356t)) {
            return super.addAll(collection);
        }
        C1356t c1356t = (C1356t) collection;
        int i10 = c1356t.f13637c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f13637c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f13636b;
        if (i12 > fArr.length) {
            this.f13636b = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(c1356t.f13636b, 0, this.f13636b, this.f13637c, c1356t.f13637c);
        this.f13637c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public void addFloat(float f10) {
        b();
        int i10 = this.f13637c;
        float[] fArr = this.f13636b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f13636b = fArr2;
        }
        float[] fArr3 = this.f13636b;
        int i11 = this.f13637c;
        this.f13637c = i11 + 1;
        fArr3[i11] = f10;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Float f10) {
        f(i10, f10.floatValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f10) {
        addFloat(f10.floatValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1356t)) {
            return super.equals(obj);
        }
        C1356t c1356t = (C1356t) obj;
        if (this.f13637c != c1356t.f13637c) {
            return false;
        }
        float[] fArr = c1356t.f13636b;
        for (int i10 = 0; i10 < this.f13637c; i10++) {
            if (Float.floatToIntBits(this.f13636b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, float f10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f13637c)) {
            throw new IndexOutOfBoundsException(k(i10));
        }
        float[] fArr = this.f13636b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f13636b, i10, fArr2, i10 + 1, this.f13637c - i10);
            this.f13636b = fArr2;
        }
        this.f13636b[i10] = f10;
        this.f13637c++;
        ((AbstractList) this).modCount++;
    }

    public float getFloat(int i10) {
        i(i10);
        return this.f13636b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.f13637c; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f13636b[i10]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Float get(int i10) {
        return Float.valueOf(getFloat(i10));
    }

    @Override // androidx.datastore.preferences.protobuf.C1359w.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C1359w.f mutableCopyWithCapacity(int i10) {
        if (i10 >= this.f13637c) {
            return new C1356t(Arrays.copyOf(this.f13636b, i10), this.f13637c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Float remove(int i10) {
        b();
        i(i10);
        float[] fArr = this.f13636b;
        float f10 = fArr[i10];
        if (i10 < this.f13637c - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f13637c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Float set(int i10, Float f10) {
        return Float.valueOf(setFloat(i10, f10.floatValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f13636b;
        System.arraycopy(fArr, i11, fArr, i10, this.f13637c - i11);
        this.f13637c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    public float setFloat(int i10, float f10) {
        b();
        i(i10);
        float[] fArr = this.f13636b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13637c;
    }

    public C1356t(float[] fArr, int i10) {
        this.f13636b = fArr;
        this.f13637c = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1340c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f13637c; i10++) {
            if (obj.equals(Float.valueOf(this.f13636b[i10]))) {
                float[] fArr = this.f13636b;
                System.arraycopy(fArr, i10 + 1, fArr, i10, (this.f13637c - i10) - 1);
                this.f13637c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
