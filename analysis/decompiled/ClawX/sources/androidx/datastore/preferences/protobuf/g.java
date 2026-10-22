package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class g implements Iterable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final g f473c = new g(x.f580b);
    public static final e d;

    /* renamed from: a, reason: collision with root package name */
    public int f474a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f475b;

    static {
        d = c.a() ? new e(1) : new e(0);
    }

    public g(byte[] bArr) {
        bArr.getClass();
        this.f475b = bArr;
    }

    public static int g(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException(a8.b.k(i8, "Beginning index: ", " < 0"));
        }
        if (i9 < i8) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(a8.b.i(i9, i10, "End index: ", " >= "));
    }

    public static g h(int i8, int i9, byte[] bArr) {
        byte[] bArrCopyOfRange;
        g(i8, i8 + i9, bArr.length);
        switch (d.f464a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i8, i9 + i8);
                break;
            default:
                bArrCopyOfRange = new byte[i9];
                System.arraycopy(bArr, i8, bArrCopyOfRange, 0, i9);
                break;
        }
        return new g(bArrCopyOfRange);
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
        int i8 = this.f474a;
        int i9 = gVar.f474a;
        if (i8 != 0 && i9 != 0 && i8 != i9) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            StringBuilder sbS = a8.b.s(size, "Ran off end of other: 0, ", ", ");
            sbS.append(gVar.size());
            throw new IllegalArgumentException(sbS.toString());
        }
        byte[] bArr = gVar.f475b;
        int iJ = j() + size;
        int iJ2 = j();
        int iJ3 = gVar.j();
        while (iJ2 < iJ) {
            if (this.f475b[iJ2] != bArr[iJ3]) {
                return false;
            }
            iJ2++;
            iJ3++;
        }
        return true;
    }

    public byte f(int i8) {
        return this.f475b[i8];
    }

    public final int hashCode() {
        int i8 = this.f474a;
        if (i8 != 0) {
            return i8;
        }
        int size = size();
        int iJ = j();
        int i9 = size;
        for (int i10 = iJ; i10 < iJ + size; i10++) {
            i9 = (i9 * 31) + this.f475b[i10];
        }
        if (i9 == 0) {
            i9 = 1;
        }
        this.f474a = i9;
        return i9;
    }

    public void i(byte[] bArr, int i8) {
        System.arraycopy(this.f475b, 0, bArr, 0, i8);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this);
    }

    public int j() {
        return 0;
    }

    public byte k(int i8) {
        return this.f475b[i8];
    }

    public int size() {
        return this.f475b.length;
    }

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = b8.h.n(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iG = g(0, 47, size());
            sb.append(b8.h.n(iG == 0 ? f473c : new f(this.f475b, j(), iG)));
            sb.append("...");
            string = sb.toString();
        }
        return m0.f.f(a8.b.u("<ByteString@", size, hexString, " size=", " contents=\""), string, "\">");
    }
}
