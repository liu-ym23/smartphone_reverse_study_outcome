package D7;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class M extends AbstractC0214f implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f398a;
    public final int b;
    public int c;
    public int d;

    public M(Object[] objArr, int i) {
        this.f398a = objArr;
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "ring buffer filled size should not be negative but it is ").toString());
        }
        if (i <= objArr.length) {
            this.b = objArr.length;
            this.d = i;
        } else {
            StringBuilder sbU = B7.a.u(i, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
            sbU.append(objArr.length);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
    }

    public final void b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "n shouldn't be negative but it is ").toString());
        }
        if (i > size()) {
            StringBuilder sbU = B7.a.u(i, "n shouldn't be greater than the buffer size: n = ", ", size = ");
            sbU.append(size());
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        if (i > 0) {
            int i6 = this.c;
            int i10 = this.b;
            int i11 = (i6 + i) % i10;
            Object[] objArr = this.f398a;
            if (i6 > i11) {
                Arrays.fill(objArr, i6, i10, (Object) null);
                Arrays.fill(objArr, 0, i11, (Object) null);
            } else {
                Arrays.fill(objArr, i6, i11, (Object) null);
            }
            this.c = i11;
            this.d = size() - i;
        }
    }

    @Override // D7.AbstractC0214f, java.util.List
    public final Object get(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.b(i, size);
        return this.f398a[(this.c + i) % this.b];
    }

    @Override // D7.AbstractC0214f, D7.AbstractC0209a
    /* renamed from: getSize */
    public final int get_size() {
        return this.d;
    }

    @Override // D7.AbstractC0214f, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new L(this);
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        Object[] objArr;
        kotlin.jvm.internal.k.f(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            kotlin.jvm.internal.k.e(array, "copyOf(...)");
        }
        int size = size();
        int i = this.c;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            objArr = this.f398a;
            if (i10 >= size || i >= this.b) {
                break;
            }
            array[i10] = objArr[i];
            i10++;
            i++;
        }
        while (i10 < size) {
            array[i10] = objArr[i6];
            i10++;
            i6++;
        }
        if (size < array.length) {
            array[size] = null;
        }
        return array;
    }

    @Override // D7.AbstractC0209a, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
