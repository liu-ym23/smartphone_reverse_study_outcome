package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0259h implements Iterable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final C0261i f3480b = new C0261i(D.f3397b);

    /* renamed from: c, reason: collision with root package name */
    public static final E3.b f3481c;

    /* renamed from: a, reason: collision with root package name */
    public int f3482a;

    static {
        int i4 = 0;
        f3481c = AbstractC0251d.a() ? new E3.b(1, i4) : new E3.b(i4, i4);
    }

    public static int c(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) >= 0) {
            return i7;
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(B0.g.j("Beginning index: ", i4, " < 0"));
        }
        if (i5 < i4) {
            throw new IndexOutOfBoundsException(B0.g.k("Beginning index larger than ending index: ", i4, ", ", i5));
        }
        throw new IndexOutOfBoundsException(B0.g.k("End index: ", i5, " >= ", i6));
    }

    public static C0261i d(int i4, int i5, byte[] bArr) {
        byte[] bArrCopyOfRange;
        int i6 = i4 + i5;
        c(i4, i6, bArr.length);
        switch (f3481c.f411a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i4, i6);
                break;
            default:
                bArrCopyOfRange = new byte[i5];
                System.arraycopy(bArr, i4, bArrCopyOfRange, 0, i5);
                break;
        }
        return new C0261i(bArrCopyOfRange);
    }

    public abstract byte a(int i4);

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final int hashCode() {
        int i4 = this.f3482a;
        if (i4 == 0) {
            int size = size();
            C0261i c0261i = (C0261i) this;
            int iH = c0261i.h();
            int i5 = size;
            for (int i6 = iH; i6 < iH + size; i6++) {
                i5 = (i5 * 31) + c0261i.f3483d[i6];
            }
            i4 = i5 == 0 ? 1 : i5;
            this.f3482a = i4;
        }
        return i4;
    }

    public abstract byte f(int i4);

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0255f(this);
    }

    public abstract int size();
}
