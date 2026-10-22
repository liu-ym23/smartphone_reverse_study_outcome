package b5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class o implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f907a = 4;

    /* renamed from: b, reason: collision with root package name */
    public int f908b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f909c;

    public o(Object[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        this.f909c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f907a) {
            case 0:
                if (this.f908b < ((byte[]) this.f909c).length) {
                }
                break;
            case 1:
                if (this.f908b < ((int[]) this.f909c).length) {
                }
                break;
            case 2:
                if (this.f908b < ((long[]) this.f909c).length) {
                }
                break;
            case 3:
                if (this.f908b < ((short[]) this.f909c).length) {
                }
                break;
            case 4:
                if (this.f908b < ((c5.f) this.f909c).f()) {
                }
                break;
            default:
                if (this.f908b < ((Object[]) this.f909c).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f907a) {
            case 0:
                int i8 = this.f908b;
                byte[] bArr = (byte[]) this.f909c;
                if (i8 >= bArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f908b));
                }
                this.f908b = i8 + 1;
                return new n(bArr[i8]);
            case 1:
                int i9 = this.f908b;
                int[] iArr = (int[]) this.f909c;
                if (i9 >= iArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f908b));
                }
                this.f908b = i9 + 1;
                return new r(iArr[i9]);
            case 2:
                int i10 = this.f908b;
                long[] jArr = (long[]) this.f909c;
                if (i10 >= jArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f908b));
                }
                this.f908b = i10 + 1;
                return new u(jArr[i10]);
            case 3:
                int i11 = this.f908b;
                short[] sArr = (short[]) this.f909c;
                if (i11 >= sArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f908b));
                }
                this.f908b = i11 + 1;
                return new y(sArr[i11]);
            case 4:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                c5.f fVar = (c5.f) this.f909c;
                int i12 = this.f908b;
                this.f908b = i12 + 1;
                return fVar.get(i12);
            default:
                try {
                    Object[] objArr = (Object[]) this.f909c;
                    int i13 = this.f908b;
                    this.f908b = i13 + 1;
                    return objArr[i13];
                } catch (ArrayIndexOutOfBoundsException e9) {
                    this.f908b--;
                    throw new NoSuchElementException(e9.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f907a) {
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
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o(byte[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        this.f909c = array;
    }

    public o(int[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        this.f909c = array;
    }

    public o(long[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        this.f909c = array;
    }

    public o(short[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        this.f909c = array;
    }

    public o(c5.f fVar) {
        this.f909c = fVar;
    }
}
