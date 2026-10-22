package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f implements Iterable, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final f f1105g = new f(x.f1219b);

    /* renamed from: h, reason: collision with root package name */
    public static final d f1106h;

    /* renamed from: c, reason: collision with root package name */
    public int f1107c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f1108f;

    static {
        f1106h = b.a() ? new d(1) : new d(0);
    }

    public f(byte[] bArr) {
        bArr.getClass();
        this.f1108f = bArr;
    }

    public static int b(int i, int i3, int i10) {
        int i11 = i3 - i;
        if ((i | i3 | i11 | (i10 - i3)) >= 0) {
            return i11;
        }
        if (i < 0) {
            g5.f.q(k0.a.k(i, "Beginning index: ", " < 0"));
            return 0;
        }
        if (i3 < i) {
            g5.f.q(androidx.activity.b.i("Beginning index larger than ending index: ", i, ", ", i3));
            return 0;
        }
        g5.f.q(androidx.activity.b.i("End index: ", i3, " >= ", i10));
        return 0;
    }

    public static f c(int i, int i3, byte[] bArr) {
        byte[] bArrCopyOfRange;
        b(i, i + i3, bArr.length);
        switch (f1106h.f1094a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i3 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i3];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i3);
                break;
        }
        return new f(bArrCopyOfRange);
    }

    public byte a(int i) {
        return this.f1108f[i];
    }

    public void d(int i, byte[] bArr) {
        System.arraycopy(this.f1108f, 0, bArr, 0, i);
    }

    public int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f) || size() != ((f) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof f)) {
            return obj.equals(this);
        }
        f fVar = (f) obj;
        int i = this.f1107c;
        int i3 = fVar.f1107c;
        if (i != 0 && i3 != 0 && i != i3) {
            return false;
        }
        int size = size();
        if (size > fVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > fVar.size()) {
            StringBuilder sbT = k0.a.t(size, "Ran off end of other: 0, ", ", ");
            sbT.append(fVar.size());
            throw new IllegalArgumentException(sbT.toString());
        }
        byte[] bArr = fVar.f1108f;
        int iE = e() + size;
        int iE2 = e();
        int iE3 = fVar.e();
        while (iE2 < iE) {
            if (this.f1108f[iE2] != bArr[iE3]) {
                return false;
            }
            iE2++;
            iE3++;
        }
        return true;
    }

    public byte f(int i) {
        return this.f1108f[i];
    }

    public final int hashCode() {
        int i = this.f1107c;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iE = e();
        int i3 = size;
        for (int i10 = iE; i10 < iE + size; i10++) {
            i3 = (i3 * 31) + this.f1108f[i10];
        }
        if (i3 == 0) {
            i3 = 1;
        }
        this.f1107c = i3;
        return i3;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        c cVar = new c();
        cVar.f1093g = this;
        cVar.f1091c = 0;
        cVar.f1092f = size();
        VarHandle.storeStoreFence();
        return cVar;
    }

    public int size() {
        return this.f1108f.length;
    }

    public final String toString() {
        f fVar;
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strConcat = com.stepos.statsrpk.h.o(this);
        } else {
            int iB = b(0, 47, size());
            if (iB == 0) {
                fVar = f1105g;
            } else {
                int iE = e();
                byte[] bArr = this.f1108f;
                e eVar = new e(bArr);
                b(iE, iE + iB, bArr.length);
                eVar.i = iE;
                eVar.f1103j = iB;
                VarHandle.storeStoreFence();
                fVar = eVar;
            }
            strConcat = com.stepos.statsrpk.h.o(fVar).concat("...");
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(size);
        sb2.append(" contents=\"");
        return androidx.activity.b.n(sb2, strConcat, "\">");
    }
}
