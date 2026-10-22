package d8;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x1 implements Comparable, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final x1 f2208g;

    /* renamed from: h, reason: collision with root package name */
    public static final x1 f2209h;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2211a;

    /* renamed from: b, reason: collision with root package name */
    public long f2212b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f2213c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public static final z7.b f2206e = z7.d.b(x1.class);

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f2207f = {0};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f2210j = new byte[256];

    static {
        int i8 = 0;
        while (true) {
            byte[] bArr = f2210j;
            if (i8 >= bArr.length) {
                x1 x1Var = new x1();
                f2208g = x1Var;
                x1Var.f2211a = f2207f;
                x1Var.d = 1;
                x1 x1Var2 = new x1();
                f2209h = x1Var2;
                x1Var2.f2211a = new byte[0];
                return;
            }
            if (i8 < 65 || i8 > 90) {
                bArr[i8] = (byte) i8;
            } else {
                bArr[i8] = (byte) (i8 + 32);
            }
            i8++;
        }
    }

    public x1(u uVar) throws l4 {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int iF = uVar.f();
            int i8 = uVar.f2172b;
            ByteBuffer byteBuffer = uVar.f2171a;
            int i9 = iF & BERTags.PRIVATE;
            if (i9 != 0) {
                if (i9 != 192) {
                    throw new l4("bad label type");
                }
                int iF2 = uVar.f() + ((iF & (-193)) << 8);
                Integer numValueOf = Integer.valueOf(byteBuffer.position() - i8);
                Integer numValueOf2 = Integer.valueOf(iF2);
                z7.b bVar = f2206e;
                bVar.f("currently {}, pointer to {}", numValueOf, numValueOf2);
                if (iF2 >= (byteBuffer.position() - i8) - 2) {
                    throw new l4("bad compression");
                }
                if (!z2) {
                    uVar.d = byteBuffer.position();
                    uVar.f2174e = byteBuffer.limit();
                    z2 = true;
                }
                int i10 = i8 + iF2;
                int i11 = uVar.f2173c;
                if (i10 >= i11) {
                    throw new IllegalArgumentException("cannot jump past end of input");
                }
                byteBuffer.position(i10);
                byteBuffer.limit(i11);
                bVar.f("current name '{}', seeking to {}", this, Integer.valueOf(iF2));
            } else if (iF == 0) {
                a(f2207f, 1);
                z = true;
            } else {
                bArr[0] = (byte) iF;
                uVar.g(iF);
                byteBuffer.get(bArr, 1, iF);
                a(bArr, 1);
            }
        }
        if (z2) {
            ByteBuffer byteBuffer2 = uVar.f2171a;
            int i12 = uVar.d;
            if (i12 < 0) {
                throw new IllegalStateException("no previous state");
            }
            byteBuffer2.position(i12);
            byteBuffer2.limit(uVar.f2174e);
            uVar.d = -1;
            uVar.f2174e = -1;
        }
    }

    public static void e(x1 x1Var, x1 x1Var2) {
        x1Var2.f2211a = x1Var.f2211a;
        x1Var2.f2212b = x1Var.f2212b;
        x1Var2.d = x1Var.d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d8.x1 f(java.lang.String r16, d8.x1 r17) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.x1.f(java.lang.String, d8.x1):d8.x1");
    }

    public final void a(byte[] bArr, int i8) throws y1 {
        byte[] bArr2 = this.f2211a;
        int length = bArr2 == null ? 0 : bArr2.length;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = bArr[i10] + 1;
            i10 += i12;
            i9 += i12;
        }
        int i13 = length + i9;
        if (i13 > 255) {
            throw new y1();
        }
        byte[] bArr3 = this.f2211a;
        byte[] bArrCopyOf = bArr3 != null ? Arrays.copyOf(bArr3, i13) : new byte[i13];
        System.arraycopy(bArr, 0, bArrCopyOf, length, i9);
        this.f2211a = bArrCopyOf;
        for (int i14 = 0; i14 < i8 && i14 < 9; i14++) {
            h(this.d + i14, length);
            length += bArrCopyOf[length] + 1;
        }
        this.d += i8;
    }

    public final void b(char[] cArr, int i8) throws y1 {
        byte[] bArr = this.f2211a;
        int length = bArr == null ? 0 : bArr.length;
        int i9 = length + 1;
        int i10 = i9 + i8;
        if (i10 > 255) {
            throw new y1();
        }
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, i10) : new byte[i10];
        bArrCopyOf[length] = (byte) i8;
        this.f2211a = bArrCopyOf;
        h(this.d, length);
        this.d++;
        for (int i11 = 0; i11 < i8; i11++) {
            this.f2211a[i9 + i11] = (byte) cArr[i11];
        }
    }

    public final void c(String str, char[] cArr, int i8) throws c4 {
        try {
            b(cArr, i8);
        } catch (y1 e9) {
            throw new c4(m0.f.d("'", str, "': Name too long"), e9);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final int compareTo(x1 x1Var) {
        if (this == x1Var) {
            return 0;
        }
        int i8 = x1Var.d;
        int iMin = Math.min(this.d, i8);
        for (int i9 = 1; i9 <= iMin; i9++) {
            int iG = g(this.d - i9);
            int iG2 = x1Var.g(i8 - i9);
            byte b9 = this.f2211a[iG];
            byte b10 = x1Var.f2211a[iG2];
            for (int i10 = 0; i10 < b9 && i10 < b10; i10++) {
                int i11 = this.f2211a[i10 + iG + 1] & 255;
                byte[] bArr = f2210j;
                int i12 = (bArr[i11] & 255) - (bArr[x1Var.f2211a[(i10 + iG2) + 1] & 255] & 255);
                if (i12 != 0) {
                    return i12;
                }
            }
            if (b9 != b10) {
                return b9 - b10;
            }
        }
        return this.d - i8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        if (x1Var.d != this.d || x1Var.hashCode() != hashCode()) {
            return false;
        }
        byte[] bArr = x1Var.f2211a;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.d; i10++) {
            byte b9 = this.f2211a[i8];
            if (b9 == bArr[i9]) {
                i8++;
                i9++;
                int i11 = 0;
                while (i11 < b9) {
                    int i12 = i8 + 1;
                    int i13 = this.f2211a[i8] & 255;
                    byte[] bArr2 = f2210j;
                    int i14 = i9 + 1;
                    if (bArr2[i13] == bArr2[bArr[i9] & 255]) {
                        i11++;
                        i8 = i12;
                        i9 = i14;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int g(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 < 1 || i8 >= this.d) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i8 < 9) {
            return ((int) (this.f2212b >>> ((i8 - 1) * 8))) & 255;
        }
        int i9 = ((int) (this.f2212b >>> 56)) & 255;
        for (int i10 = 8; i10 < i8; i10++) {
            i9 += this.f2211a[i9] + 1;
        }
        return i9;
    }

    public final void h(int i8, int i9) {
        if (i8 == 0 || i8 >= 9) {
            return;
        }
        int i10 = (i8 - 1) * 8;
        this.f2212b = (i9 << i10) | (this.f2212b & (~(255 << i10)));
    }

    public final int hashCode() {
        int i8 = this.f2213c;
        if (i8 != 0) {
            return i8;
        }
        int i9 = 0;
        int iG = g(0);
        while (true) {
            byte[] bArr = this.f2211a;
            if (iG >= bArr.length) {
                this.f2213c = i9;
                return i9;
            }
            i9 += (i9 << 3) + (f2210j[bArr[iG] & 255] & 255);
            iG++;
        }
    }

    public final void i(b0.j jVar, n nVar) {
        x1 x1Var;
        int i8;
        if (!isAbsolute()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int i9 = 0;
        while (true) {
            int i10 = this.d;
            if (i9 >= i10 - 1) {
                jVar.m(0);
                return;
            }
            if (i9 == 0) {
                x1Var = this;
            } else {
                x1Var = new x1();
                if (i9 > i10) {
                    throw new IllegalArgumentException("attempted to remove too many labels");
                }
                if (i9 == i10) {
                    e(f2209h, x1Var);
                } else {
                    x1Var.d = i10 - i9;
                    x1Var.f2211a = Arrays.copyOfRange(this.f2211a, g(i9), this.f2211a.length);
                    int iG = g(i9);
                    for (int i11 = 1; i11 < 9 && i11 < x1Var.d; i11++) {
                        x1Var.h(i11, g(i11 + i9) - iG);
                    }
                }
            }
            int i12 = -1;
            if (nVar != null) {
                for (m mVar = nVar.f2091a[(x1Var.hashCode() & Integer.MAX_VALUE) % 17]; mVar != null; mVar = (m) mVar.d) {
                    if (((x1) mVar.f2077c).equals(x1Var)) {
                        i12 = mVar.f2076b;
                    }
                }
                n.f2090b.f("Looking for {}, found {}", x1Var, Integer.valueOf(i12));
            }
            if (i12 >= 0) {
                jVar.j(49152 | i12);
                return;
            }
            if (nVar != null && (i8 = jVar.f832a) <= 16383) {
                int iHashCode = (Integer.MAX_VALUE & x1Var.hashCode()) % 17;
                m mVar2 = new m();
                mVar2.f2077c = x1Var;
                mVar2.f2076b = i8;
                m[] mVarArr = nVar.f2091a;
                mVar2.d = mVarArr[iHashCode];
                mVarArr[iHashCode] = mVar2;
                n.f2090b.f("Adding {} at {}", x1Var, Integer.valueOf(i8));
            }
            int iG2 = g(i9);
            byte[] bArr = this.f2211a;
            jVar.g(iG2, bArr[iG2] + 1, bArr);
            i9++;
        }
    }

    public final boolean isAbsolute() {
        int i8 = this.d;
        return i8 != 0 && this.f2211a[g(i8 - 1)] == 0;
    }

    public final void j(b0.j jVar, n nVar, boolean z) {
        if (z) {
            k(jVar);
        } else {
            i(jVar, nVar);
        }
    }

    public final void k(b0.j jVar) {
        byte[] bArr;
        if (this.d == 0) {
            bArr = new byte[0];
        } else {
            byte[] bArr2 = new byte[this.f2211a.length];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.d; i10++) {
                byte b9 = this.f2211a[i8];
                i8++;
                bArr2[i9] = b9;
                i9++;
                int i11 = 0;
                while (i11 < b9) {
                    bArr2[i9] = f2210j[this.f2211a[i8] & 255];
                    i11++;
                    i9++;
                    i8++;
                }
            }
            bArr = bArr2;
        }
        jVar.getClass();
        jVar.g(0, bArr.length, bArr);
    }

    public final String toString() {
        int i8 = this.d;
        if (i8 == 0) {
            return "@";
        }
        int i9 = 0;
        if (i8 == 1 && this.f2211a[0] == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (true) {
            if (i9 >= this.d) {
                break;
            }
            byte b9 = this.f2211a[i10];
            if (b9 == 0) {
                sb.append('.');
                break;
            }
            if (i9 > 0) {
                sb.append('.');
            }
            byte[] bArr = this.f2211a;
            StringBuilder sb2 = new StringBuilder();
            int i11 = i10 + 1;
            byte b10 = bArr[i10];
            for (int i12 = i11; i12 < i11 + b10; i12++) {
                int i13 = bArr[i12] & 255;
                if (i13 <= 32 || i13 >= 127) {
                    sb2.append(AbstractJsonLexerKt.STRING_ESC);
                    if (i13 < 10) {
                        sb2.append("00");
                    } else if (i13 < 100) {
                        sb2.append('0');
                    }
                    sb2.append(i13);
                } else if (i13 == 34 || i13 == 40 || i13 == 41 || i13 == 46 || i13 == 59 || i13 == 92 || i13 == 64 || i13 == 36) {
                    sb2.append(AbstractJsonLexerKt.STRING_ESC);
                    sb2.append((char) i13);
                } else {
                    sb2.append((char) i13);
                }
            }
            sb.append(sb2.toString());
            i10 += b9 + 1;
            i9++;
        }
        return sb.toString();
    }
}
