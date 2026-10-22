package C7;

import B9.C0194v;
import D7.AbstractC0214f;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class i implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f308a;
    public int b;
    public final Object c;

    public /* synthetic */ i(Object obj, int i) {
        this.f308a = i;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f308a) {
            case 0:
                if (this.b < ((byte[]) this.c).length) {
                }
                break;
            case 1:
                if (this.b < ((int[]) this.c).length) {
                }
                break;
            case 2:
                if (this.b < ((long[]) this.c).length) {
                }
                break;
            case 3:
                if (this.b < ((short[]) this.c).length) {
                }
                break;
            case 4:
                if (this.b < ((AbstractC0214f) this.c).size()) {
                }
                break;
            case 5:
                if (this.b < ((double[]) this.c).length) {
                }
                break;
            case 6:
                if (this.b < ((float[]) this.c).length) {
                }
                break;
            case 7:
                if (this.b < ((Object[]) this.c).length) {
                }
                break;
            default:
                if (this.b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f308a) {
            case 0:
                int i = this.b;
                byte[] bArr = (byte[]) this.c;
                if (i >= bArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i + 1;
                return new h(bArr[i]);
            case 1:
                int i6 = this.b;
                int[] iArr = (int[]) this.c;
                if (i6 >= iArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i6 + 1;
                return new k(iArr[i6]);
            case 2:
                int i10 = this.b;
                long[] jArr = (long[]) this.c;
                if (i10 >= jArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i10 + 1;
                return new m(jArr[i10]);
            case 3:
                int i11 = this.b;
                short[] sArr = (short[]) this.c;
                if (i11 >= sArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i11 + 1;
                return new p(sArr[i11]);
            case 4:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                AbstractC0214f abstractC0214f = (AbstractC0214f) this.c;
                int i12 = this.b;
                this.b = i12 + 1;
                return abstractC0214f.get(i12);
            case 5:
                try {
                    double[] dArr = (double[]) this.c;
                    int i13 = this.b;
                    this.b = i13 + 1;
                    return Double.valueOf(dArr[i13]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 6:
                try {
                    float[] fArr = (float[]) this.c;
                    int i14 = this.b;
                    this.b = i14 + 1;
                    return Float.valueOf(fArr[i14]);
                } catch (ArrayIndexOutOfBoundsException e6) {
                    this.b--;
                    throw new NoSuchElementException(e6.getMessage());
                }
            case 7:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i15 = this.b;
                    this.b = i15 + 1;
                    return objArr[i15];
                } catch (ArrayIndexOutOfBoundsException e9) {
                    this.b--;
                    throw new NoSuchElementException(e9.getMessage());
                }
            default:
                C0194v c0194v = (C0194v) this.c;
                int i16 = c0194v.c;
                int i17 = this.b;
                this.b = i17 - 1;
                return c0194v.e[i16 - i17];
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f308a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 5:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 6:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 7:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(Object[] array) {
        this.f308a = 7;
        kotlin.jvm.internal.k.f(array, "array");
        this.c = array;
    }

    public i(float[] array) {
        this.f308a = 6;
        kotlin.jvm.internal.k.f(array, "array");
        this.c = array;
    }

    public i(double[] array) {
        this.f308a = 5;
        kotlin.jvm.internal.k.f(array, "array");
        this.c = array;
    }

    public i(C0194v c0194v) {
        this.f308a = 8;
        this.c = c0194v;
        this.b = c0194v.c;
    }
}
