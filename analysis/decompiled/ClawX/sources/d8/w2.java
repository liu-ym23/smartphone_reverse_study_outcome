package d8;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class w2 implements Cloneable, Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final DecimalFormat f2194e;

    /* renamed from: a, reason: collision with root package name */
    public x1 f2195a;

    /* renamed from: b, reason: collision with root package name */
    public int f2196b;

    /* renamed from: c, reason: collision with root package name */
    public int f2197c;
    public long d;

    static {
        z7.d.b(w2.class);
        DecimalFormat decimalFormat = new DecimalFormat();
        f2194e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public w2(x1 x1Var, int i8, int i9) {
        if (!x1Var.isAbsolute()) {
            throw new x0(x1Var);
        }
        f4.a(i8);
        q.a(i9);
        b8.h.e(0L);
        this.f2195a = x1Var;
        this.f2196b = i8;
        this.f2197c = i9;
        this.d = 0L;
    }

    public static String a(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(AbstractJsonLexerKt.STRING);
        }
        for (byte b9 : bArr) {
            int i8 = b9 & 255;
            if (i8 < 32 || i8 >= 127) {
                sb.append(AbstractJsonLexerKt.STRING_ESC);
                sb.append(f2194e.format(i8));
            } else if (i8 == 34 || i8 == 92) {
                sb.append(AbstractJsonLexerKt.STRING_ESC);
                sb.append((char) i8);
            } else {
                sb.append((char) i8);
            }
        }
        if (z) {
            sb.append(AbstractJsonLexerKt.STRING);
        }
        return sb.toString();
    }

    public static void b(String str, x1 x1Var) {
        if (x1Var.isAbsolute()) {
            return;
        }
        throw new x0("'" + x1Var + "' on field " + str + " is not an absolute name");
    }

    public static void c(int i8, String str) {
        if (i8 < 0 || i8 > 65535) {
            throw new IllegalArgumentException("\"" + str + "\" " + i8 + " must be an unsigned 16 bit value");
        }
    }

    public static w2 e(u uVar, int i8, boolean z) throws l4 {
        int i9 = uVar.f2173c;
        ByteBuffer byteBuffer = uVar.f2171a;
        x1 x1Var = new x1(uVar);
        int iD = uVar.d();
        int iD2 = uVar.d();
        if (i8 == 0) {
            return h(x1Var, iD, iD2, 0L);
        }
        long jE = uVar.e();
        int iD3 = uVar.d();
        if (iD3 == 0 && z && (i8 == 1 || i8 == 2)) {
            return h(x1Var, iD, iD2, jE);
        }
        w2 w2VarF = f(x1Var, iD, iD2, jE, true);
        if (byteBuffer.remaining() < iD3) {
            throw new l4("truncated record");
        }
        if (iD3 > i9 - byteBuffer.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        byteBuffer.limit(byteBuffer.position() + iD3);
        w2VarF.j(uVar);
        if (byteBuffer.remaining() > 0) {
            throw new l4("invalid record length");
        }
        byteBuffer.limit(i9);
        return w2VarF;
    }

    public static w2 f(x1 x1Var, int i8, int i9, long j4, boolean z) {
        w2 e0Var;
        if (z) {
            l3 l3Var = f4.f1995a;
            l3Var.getClass();
            f4.a(i8);
            Supplier supplier = (Supplier) l3Var.f2074h.get(Integer.valueOf(i8));
            e0Var = supplier != null ? (w2) supplier.get() : new i4();
        } else {
            e0Var = new e0();
        }
        e0Var.f2195a = x1Var;
        e0Var.f2196b = i8;
        e0Var.f2197c = i9;
        e0Var.d = j4;
        return e0Var;
    }

    public static w2 h(x1 x1Var, int i8, int i9, long j4) {
        if (!x1Var.isAbsolute()) {
            throw new x0(x1Var);
        }
        f4.a(i8);
        q.a(i9);
        b8.h.e(j4);
        return f(x1Var, i8, i9, j4, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int length;
        int length2;
        w2 w2Var = (w2) obj;
        int i8 = 0;
        if (this == w2Var) {
            return 0;
        }
        int iD = this.f2195a.compareTo(w2Var.f2195a);
        if (iD != 0) {
            return iD;
        }
        int i9 = this.f2197c - w2Var.f2197c;
        if (i9 != 0) {
            return i9;
        }
        int i10 = this.f2196b - w2Var.f2196b;
        if (i10 != 0) {
            return i10;
        }
        byte[] bArrI = i();
        byte[] bArrI2 = w2Var.i();
        int iMin = Math.min(bArrI.length, bArrI2.length);
        while (true) {
            if (i8 >= iMin) {
                length = bArrI.length;
                length2 = bArrI2.length;
                break;
            }
            byte b9 = bArrI[i8];
            byte b10 = bArrI2[i8];
            if (b9 != b10) {
                length = b9 & 255;
                length2 = b10 & 255;
                break;
            }
            i8++;
        }
        return length - length2;
    }

    public final w2 d() {
        try {
            return (w2) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w2)) {
            return false;
        }
        w2 w2Var = (w2) obj;
        if (this.f2196b == w2Var.f2196b && this.f2197c == w2Var.f2197c && this.f2195a.equals(w2Var.f2195a)) {
            return Arrays.equals(i(), w2Var.i());
        }
        return false;
    }

    public int g() {
        return this.f2196b;
    }

    public int hashCode() {
        int i8 = 0;
        for (byte b9 : n(true)) {
            i8 += (i8 << 3) + (b9 & 255);
        }
        return i8;
    }

    public final byte[] i() {
        b0.j jVar = new b0.j(2);
        l(jVar, null, true);
        return jVar.f();
    }

    public abstract void j(u uVar);

    public abstract String k();

    public abstract void l(b0.j jVar, n nVar, boolean z);

    public final void m(b0.j jVar, int i8, n nVar) {
        this.f2195a.i(jVar, nVar);
        jVar.j(this.f2196b);
        jVar.j(this.f2197c);
        if (i8 == 0) {
            return;
        }
        jVar.l(this.d);
        int i9 = jVar.f832a;
        jVar.j(0);
        l(jVar, nVar, false);
        jVar.k((jVar.f832a - i9) - 2, i9);
    }

    public final byte[] n(boolean z) {
        b0.j jVar = new b0.j(2);
        this.f2195a.k(jVar);
        jVar.j(this.f2196b);
        jVar.j(this.f2197c);
        if (z) {
            jVar.l(0L);
        } else {
            jVar.l(this.d);
        }
        int i8 = jVar.f832a;
        jVar.j(0);
        l(jVar, null, true);
        jVar.k((jVar.f832a - i8) - 2, i8);
        return jVar.f();
    }

    public String toString() {
        HashMap map;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2195a);
        if (sb.length() < 8) {
            sb.append("\t");
        }
        if (sb.length() < 16) {
            sb.append("\t");
        }
        sb.append("\t");
        HashMap map2 = p2.f2117a;
        if (map2 == null || map2.get("BINDTTL".toLowerCase()) == null) {
            sb.append(this.d);
        } else {
            long j4 = this.d;
            b8.h.e(j4);
            StringBuilder sb2 = new StringBuilder();
            long j8 = j4 % 60;
            long j9 = j4 / 60;
            long j10 = j9 % 60;
            long j11 = j9 / 60;
            long j12 = j11 % 24;
            long j13 = j11 / 24;
            long j14 = j13 % 7;
            long j15 = j13 / 7;
            if (j15 > 0) {
                sb2.append(j15);
                sb2.append("W");
            }
            if (j14 > 0) {
                sb2.append(j14);
                sb2.append("D");
            }
            if (j12 > 0) {
                sb2.append(j12);
                sb2.append("H");
            }
            if (j10 > 0) {
                sb2.append(j10);
                sb2.append("M");
            }
            if (j8 > 0 || (j15 == 0 && j14 == 0 && j12 == 0 && j10 == 0)) {
                sb2.append(j8);
                sb2.append("S");
            }
            sb.append(sb2.toString());
        }
        sb.append("\t");
        if (this.f2197c != 1 || (map = p2.f2117a) == null || map.get("noPrintIN".toLowerCase()) == null) {
            sb.append(q.f2118a.d(this.f2197c));
            sb.append("\t");
        }
        sb.append(f4.f1995a.d(this.f2196b));
        String strK = k();
        if (!strK.isEmpty()) {
            sb.append("\t");
            sb.append(strK);
        }
        return sb.toString();
    }
}
