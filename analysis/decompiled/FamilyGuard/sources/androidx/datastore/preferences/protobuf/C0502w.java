package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0502w extends AbstractC0483c<Float> implements A.f, RandomAccess, b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final C0502w f10259d;

    /* renamed from: b, reason: collision with root package name */
    private float[] f10260b;

    /* renamed from: c, reason: collision with root package name */
    private int f10261c;

    static {
        C0502w c0502w = new C0502w(new float[0], 0);
        f10259d = c0502w;
        c0502w.b();
    }

    C0502w() {
        this(new float[10], 0);
    }

    private void i(int i5, float f5) {
        int i6;
        a();
        if (i5 < 0 || i5 > (i6 = this.f10261c)) {
            throw new IndexOutOfBoundsException(p(i5));
        }
        float[] fArr = this.f10260b;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
        } else {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.f10260b, i5, fArr2, i5 + 1, this.f10261c - i5);
            this.f10260b = fArr2;
        }
        this.f10260b[i5] = f5;
        this.f10261c++;
        ((AbstractList) this).modCount++;
    }

    private void m(int i5) {
        if (i5 < 0 || i5 >= this.f10261c) {
            throw new IndexOutOfBoundsException(p(i5));
        }
    }

    private String p(int i5) {
        return "Index:" + i5 + ", Size:" + this.f10261c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        A.a(collection);
        if (!(collection instanceof C0502w)) {
            return super.addAll(collection);
        }
        C0502w c0502w = (C0502w) collection;
        int i5 = c0502w.f10261c;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.f10261c;
        if (Integer.MAX_VALUE - i6 < i5) {
            throw new OutOfMemoryError();
        }
        int i7 = i6 + i5;
        float[] fArr = this.f10260b;
        if (i7 > fArr.length) {
            this.f10260b = Arrays.copyOf(fArr, i7);
        }
        System.arraycopy(c0502w.f10260b, 0, this.f10260b, this.f10261c, c0502w.f10261c);
        this.f10261c = i7;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i5, Float f5) {
        i(i5, f5.floatValue());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0502w)) {
            return super.equals(obj);
        }
        C0502w c0502w = (C0502w) obj;
        if (this.f10261c != c0502w.f10261c) {
            return false;
        }
        float[] fArr = c0502w.f10260b;
        for (int i5 = 0; i5 < this.f10261c; i5++) {
            if (Float.floatToIntBits(this.f10260b[i5]) != Float.floatToIntBits(fArr[i5])) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f5) {
        h(f5.floatValue());
        return true;
    }

    public void h(float f5) {
        a();
        int i5 = this.f10261c;
        float[] fArr = this.f10260b;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[((i5 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            this.f10260b = fArr2;
        }
        float[] fArr3 = this.f10260b;
        int i6 = this.f10261c;
        this.f10261c = i6 + 1;
        fArr3[i6] = f5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i5 = 0; i5 < this.f10261c; i5++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f10260b[i5]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Float get(int i5) {
        return Float.valueOf(o(i5));
    }

    public float o(int i5) {
        m(i5);
        return this.f10260b[i5];
    }

    @Override // androidx.datastore.preferences.protobuf.A.i
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public A.f d(int i5) {
        if (i5 >= this.f10261c) {
            return new C0502w(Arrays.copyOf(this.f10260b, i5), this.f10261c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float remove(int i5) {
        a();
        m(i5);
        float[] fArr = this.f10260b;
        float f5 = fArr[i5];
        if (i5 < this.f10261c - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (r2 - i5) - 1);
        }
        this.f10261c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f5);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        a();
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f10260b;
        System.arraycopy(fArr, i6, fArr, i5, this.f10261c - i6);
        this.f10261c -= i6 - i5;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Float set(int i5, Float f5) {
        return Float.valueOf(t(i5, f5.floatValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10261c;
    }

    public float t(int i5, float f5) {
        a();
        m(i5);
        float[] fArr = this.f10260b;
        float f6 = fArr[i5];
        fArr[i5] = f5;
        return f6;
    }

    private C0502w(float[] fArr, int i5) {
        this.f10260b = fArr;
        this.f10261c = i5;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0483c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i5 = 0; i5 < this.f10261c; i5++) {
            if (obj.equals(Float.valueOf(this.f10260b[i5]))) {
                float[] fArr = this.f10260b;
                System.arraycopy(fArr, i5 + 1, fArr, i5, (this.f10261c - i5) - 1);
                this.f10261c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
