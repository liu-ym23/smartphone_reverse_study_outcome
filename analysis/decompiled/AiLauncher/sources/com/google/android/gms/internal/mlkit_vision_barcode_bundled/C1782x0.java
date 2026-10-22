package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.x0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1782x0 extends V implements RandomAccess, K0 {

    /* renamed from: d, reason: collision with root package name */
    public static final C1782x0 f20148d = new C1782x0(new float[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public float[] f20149b;

    /* renamed from: c, reason: collision with root package name */
    public int f20150c;

    public C1782x0() {
        this(new float[10], 0, true);
    }

    public static C1782x0 e() {
        return f20148d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        float fFloatValue = ((Float) obj).floatValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f20150c)) {
            throw new IndexOutOfBoundsException(f(i10));
        }
        int i12 = i10 + 1;
        float[] fArr = this.f20149b;
        if (i11 < fArr.length) {
            System.arraycopy(fArr, i10, fArr, i12, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            System.arraycopy(this.f20149b, i10, fArr2, i12, this.f20150c - i10);
            this.f20149b = fArr2;
        }
        this.f20149b[i10] = fFloatValue;
        this.f20150c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = N0.f20038a;
        collection.getClass();
        if (!(collection instanceof C1782x0)) {
            return super.addAll(collection);
        }
        C1782x0 c1782x0 = (C1782x0) collection;
        int i10 = c1782x0.f20150c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f20150c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f20149b;
        if (i12 > fArr.length) {
            this.f20149b = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy(c1782x0.f20149b, 0, this.f20149b, this.f20150c, c1782x0.f20150c);
        this.f20150c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final float c(int i10) {
        i(i10);
        return this.f20149b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1782x0)) {
            return super.equals(obj);
        }
        C1782x0 c1782x0 = (C1782x0) obj;
        if (this.f20150c != c1782x0.f20150c) {
            return false;
        }
        float[] fArr = c1782x0.f20149b;
        for (int i10 = 0; i10 < this.f20150c; i10++) {
            if (Float.floatToIntBits(this.f20149b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f20150c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        i(i10);
        return Float.valueOf(this.f20149b[i10]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i10 = 0; i10 < this.f20150c; i10++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f20149b[i10]);
        }
        return iFloatToIntBits;
    }

    public final void i(int i10) {
        if (i10 < 0 || i10 >= this.f20150c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i10 = this.f20150c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f20149b[i11] == fFloatValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.V, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        i(i10);
        float[] fArr = this.f20149b;
        float f10 = fArr[i10];
        if (i10 < this.f20150c - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f20150c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f20149b;
        System.arraycopy(fArr, i11, fArr, i10, this.f20150c - i11);
        this.f20150c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final K0 g(int i10) {
        if (i10 >= this.f20150c) {
            return new C1782x0(Arrays.copyOf(this.f20149b, i10), this.f20150c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        b();
        i(i10);
        float[] fArr = this.f20149b;
        float f10 = fArr[i10];
        fArr[i10] = fFloatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20150c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.K0
    public final void w(float f10) {
        b();
        int i10 = this.f20150c;
        float[] fArr = this.f20149b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f20149b = fArr2;
        }
        float[] fArr3 = this.f20149b;
        int i11 = this.f20150c;
        this.f20150c = i11 + 1;
        fArr3[i11] = f10;
    }

    public C1782x0(float[] fArr, int i10, boolean z10) {
        super(z10);
        this.f20149b = fArr;
        this.f20150c = i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        w(((Float) obj).floatValue());
        return true;
    }
}
