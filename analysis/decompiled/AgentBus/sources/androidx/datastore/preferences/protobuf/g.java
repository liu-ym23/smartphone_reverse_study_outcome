package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class g implements Iterable, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final g f850h = new g(y.f969b);

    /* renamed from: i, reason: collision with root package name */
    public static final e f851i;

    /* renamed from: f, reason: collision with root package name */
    public int f852f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f853g;

    static {
        f851i = c.a() ? new e(1) : new e(0);
    }

    public g(byte[] bArr) {
        bArr.getClass();
        this.f853g = bArr;
    }

    public static int f(int i2, int i10, int i11) {
        int i12 = i10 - i2;
        if ((i2 | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a1.a.f(i2, "Beginning index: ", " < 0"));
        }
        if (i10 < i2) {
            throw new IndexOutOfBoundsException(m.x.k("Beginning index larger than ending index: ", i2, i10, ", "));
        }
        throw new IndexOutOfBoundsException(m.x.k("End index: ", i10, i11, " >= "));
    }

    public static g h(byte[] bArr, int i2, int i10) {
        byte[] bArrCopyOfRange;
        f(i2, i2 + i10, bArr.length);
        switch (f851i.f841a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i10 + i2);
                break;
            default:
                bArrCopyOfRange = new byte[i10];
                System.arraycopy(bArr, i2, bArrCopyOfRange, 0, i10);
                break;
        }
        return new g(bArrCopyOfRange);
    }

    public byte a(int i2) {
        return this.f853g[i2];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g) || size() != ((g) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj.equals(this);
        }
        g gVar = (g) obj;
        int i2 = this.f852f;
        int i10 = gVar.f852f;
        if (i2 != 0 && i10 != 0 && i2 != i10) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            StringBuilder sbN = a1.a.n(size, "Ran off end of other: 0, ", ", ");
            sbN.append(gVar.size());
            throw new IllegalArgumentException(sbN.toString());
        }
        byte[] bArr = gVar.f853g;
        int iJ = j() + size;
        int iJ2 = j();
        int iJ3 = gVar.j();
        while (iJ2 < iJ) {
            if (this.f853g[iJ2] != bArr[iJ3]) {
                return false;
            }
            iJ2++;
            iJ3++;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f852f;
        if (i2 != 0) {
            return i2;
        }
        int size = size();
        int iJ = j();
        int i10 = size;
        for (int i11 = iJ; i11 < iJ + size; i11++) {
            i10 = (i10 * 31) + this.f853g[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f852f = i10;
        return i10;
    }

    public void i(int i2, byte[] bArr) {
        System.arraycopy(this.f853g, 0, bArr, 0, i2);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this);
    }

    public int j() {
        return 0;
    }

    public byte k(int i2) {
        return this.f853g[i2];
    }

    public int size() {
        return this.f853g.length;
    }

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = e1.c(this);
        } else {
            StringBuilder sb2 = new StringBuilder();
            int iF = f(0, 47, size());
            sb2.append(e1.c(iF == 0 ? f850h : new f(this.f853g, j(), iF)));
            sb2.append("...");
            string = sb2.toString();
        }
        return a1.a.m(a1.a.o("<ByteString@", hexString, " size=", size, " contents=\""), string, "\">");
    }
}
