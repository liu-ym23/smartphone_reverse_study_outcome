package y2;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: w, reason: collision with root package name */
    public static final char[] f14011w = (char[]) x2.a.f13703a.clone();

    /* renamed from: p, reason: collision with root package name */
    public final Writer f14012p;

    /* renamed from: q, reason: collision with root package name */
    public final char f14013q;
    public char[] r;

    /* renamed from: s, reason: collision with root package name */
    public int f14014s;

    /* renamed from: t, reason: collision with root package name */
    public int f14015t;

    /* renamed from: u, reason: collision with root package name */
    public final int f14016u;

    /* renamed from: v, reason: collision with root package name */
    public char[] f14017v;

    public h(x2.b bVar, int i10, v2.c cVar, Writer writer, char c9) {
        super(bVar, i10, cVar);
        this.f14012p = writer;
        x2.b.a(bVar.f13720i);
        char[] cArrB = bVar.f13716d.b(1, 0);
        bVar.f13720i = cArrB;
        this.r = cArrB;
        this.f14016u = cArrB.length;
        this.f14013q = c9;
        if (c9 != '\"') {
            this.f13975k = x2.a.a(c9);
        }
    }

    public static int u1(q3.e eVar, byte[] bArr, int i10, int i11, int i12) {
        int i13;
        int i14 = 0;
        while (i10 < i11) {
            bArr[i14] = bArr[i10];
            i14++;
            i10++;
        }
        int iMin = Math.min(i12, bArr.length);
        do {
            int i15 = iMin - i14;
            if (i15 == 0 || (i13 = eVar.read(bArr, i14, i15)) < 0) {
                return i14;
            }
            i14 += i13;
        } while (i14 < 3);
        return i14;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void C0() throws IOException {
        if (!this.f13558e.d()) {
            a("Current context not Array but ".concat(this.f13558e.h()));
            throw null;
        }
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.e(this, this.f13558e.f13376b + 1);
        } else {
            if (this.f14015t >= this.f14016u) {
                r1();
            }
            char[] cArr = this.r;
            int i10 = this.f14015t;
            this.f14015t = i10 + 1;
            cArr[i10] = ']';
        }
        d dVar2 = this.f13558e;
        dVar2.f13989g = null;
        this.f13558e = dVar2.f13985c;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void G0() throws IOException {
        if (!this.f13558e.e()) {
            a("Current context not Object but ".concat(this.f13558e.h()));
            throw null;
        }
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.i(this, this.f13558e.f13376b + 1);
        } else {
            if (this.f14015t >= this.f14016u) {
                r1();
            }
            char[] cArr = this.r;
            int i10 = this.f14015t;
            this.f14015t = i10 + 1;
            cArr[i10] = '}';
        }
        d dVar2 = this.f13558e;
        dVar2.f13989g = null;
        this.f13558e = dVar2.f13985c;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void H0(String str) throws IOException {
        int iM = this.f13558e.m(str);
        if (iM == 4) {
            a("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z = iM == 1;
        v2.d dVar = this.f3540a;
        int i10 = this.f14016u;
        char c9 = this.f14013q;
        if (dVar != null) {
            if (z) {
                dVar.c(this);
            } else {
                dVar.b(this);
            }
            if (this.f13978n) {
                z1(str);
                return;
            }
            if (this.f14015t >= i10) {
                r1();
            }
            char[] cArr = this.r;
            int i11 = this.f14015t;
            this.f14015t = i11 + 1;
            cArr[i11] = c9;
            z1(str);
            if (this.f14015t >= i10) {
                r1();
            }
            char[] cArr2 = this.r;
            int i12 = this.f14015t;
            this.f14015t = i12 + 1;
            cArr2[i12] = c9;
            return;
        }
        if (this.f14015t + 1 >= i10) {
            r1();
        }
        if (z) {
            char[] cArr3 = this.r;
            int i13 = this.f14015t;
            this.f14015t = i13 + 1;
            cArr3[i13] = ',';
        }
        if (this.f13978n) {
            z1(str);
            return;
        }
        char[] cArr4 = this.r;
        int i14 = this.f14015t;
        this.f14015t = i14 + 1;
        cArr4[i14] = c9;
        z1(str);
        if (this.f14015t >= i10) {
            r1();
        }
        char[] cArr5 = this.r;
        int i15 = this.f14015t;
        this.f14015t = i15 + 1;
        cArr5[i15] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void I0(v2.e eVar) throws IOException {
        int iM = this.f13558e.m(eVar.getValue());
        if (iM == 4) {
            a("Can not write a field name, expecting a value");
            throw null;
        }
        boolean z = iM == 1;
        v2.d dVar = this.f3540a;
        int i10 = this.f14016u;
        char c9 = this.f14013q;
        if (dVar != null) {
            if (z) {
                dVar.c(this);
            } else {
                dVar.b(this);
            }
            char[] cArrB = eVar.b();
            if (this.f13978n) {
                W0(cArrB, cArrB.length);
                return;
            }
            if (this.f14015t >= i10) {
                r1();
            }
            char[] cArr = this.r;
            int i11 = this.f14015t;
            this.f14015t = i11 + 1;
            cArr[i11] = c9;
            W0(cArrB, cArrB.length);
            if (this.f14015t >= i10) {
                r1();
            }
            char[] cArr2 = this.r;
            int i12 = this.f14015t;
            this.f14015t = i12 + 1;
            cArr2[i12] = c9;
            return;
        }
        if (this.f14015t + 1 >= i10) {
            r1();
        }
        if (z) {
            char[] cArr3 = this.r;
            int i13 = this.f14015t;
            this.f14015t = i13 + 1;
            cArr3[i13] = ',';
        }
        if (this.f13978n) {
            char[] cArrB2 = eVar.b();
            W0(cArrB2, cArrB2.length);
            return;
        }
        char[] cArr4 = this.r;
        int i14 = this.f14015t;
        int i15 = i14 + 1;
        this.f14015t = i15;
        cArr4[i14] = c9;
        int iA = eVar.a(cArr4, i15);
        if (iA < 0) {
            char[] cArrB3 = eVar.b();
            W0(cArrB3, cArrB3.length);
            if (this.f14015t >= i10) {
                r1();
            }
            char[] cArr5 = this.r;
            int i16 = this.f14015t;
            this.f14015t = i16 + 1;
            cArr5[i16] = c9;
            return;
        }
        int i17 = this.f14015t + iA;
        this.f14015t = i17;
        if (i17 >= i10) {
            r1();
        }
        char[] cArr6 = this.r;
        int i18 = this.f14015t;
        this.f14015t = i18 + 1;
        cArr6[i18] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void J0() throws IOException {
        k1("write a null");
        x1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void K0(double d8) throws IOException {
        if (!this.f13557d) {
            String str = x2.e.f13727a;
            if ((!Double.isNaN(d8) && !Double.isInfinite(d8)) || !P(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) {
                k1("write a number");
                U0(String.valueOf(d8));
                return;
            }
        }
        f1(String.valueOf(d8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void L0(float f8) throws IOException {
        if (!this.f13557d) {
            String str = x2.e.f13727a;
            if ((!Float.isNaN(f8) && !Float.isInfinite(f8)) || !P(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) {
                k1("write a number");
                U0(String.valueOf(f8));
                return;
            }
        }
        f1(String.valueOf(f8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void M0(int i10) throws IOException {
        k1("write a number");
        boolean z = this.f13557d;
        int i11 = this.f14016u;
        if (!z) {
            if (this.f14015t + 11 >= i11) {
                r1();
            }
            this.f14015t = x2.e.h(this.r, i10, this.f14015t);
            return;
        }
        if (this.f14015t + 13 >= i11) {
            r1();
        }
        char[] cArr = this.r;
        int i12 = this.f14015t;
        int i13 = i12 + 1;
        this.f14015t = i13;
        char c9 = this.f14013q;
        cArr[i12] = c9;
        int iH = x2.e.h(cArr, i10, i13);
        char[] cArr2 = this.r;
        this.f14015t = iH + 1;
        cArr2[iH] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void N0(long j10) throws IOException {
        k1("write a number");
        boolean z = this.f13557d;
        int i10 = this.f14016u;
        if (!z) {
            if (this.f14015t + 21 >= i10) {
                r1();
            }
            this.f14015t = x2.e.j(j10, this.r, this.f14015t);
            return;
        }
        if (this.f14015t + 23 >= i10) {
            r1();
        }
        char[] cArr = this.r;
        int i11 = this.f14015t;
        int i12 = i11 + 1;
        this.f14015t = i12;
        char c9 = this.f14013q;
        cArr[i11] = c9;
        int iJ = x2.e.j(j10, cArr, i12);
        char[] cArr2 = this.r;
        this.f14015t = iJ + 1;
        cArr2[iJ] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void O0(String str) throws IOException {
        k1("write a number");
        if (str == null) {
            x1();
        } else if (this.f13557d) {
            y1(str);
        } else {
            U0(str);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void P0(BigDecimal bigDecimal) throws IOException {
        k1("write a number");
        if (bigDecimal == null) {
            x1();
        } else if (this.f13557d) {
            y1(j1(bigDecimal));
        } else {
            U0(j1(bigDecimal));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Q0(BigInteger bigInteger) throws IOException {
        k1("write a number");
        if (bigInteger == null) {
            x1();
        } else if (this.f13557d) {
            y1(bigInteger.toString());
        } else {
            U0(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void R0(short s8) throws IOException {
        k1("write a number");
        boolean z = this.f13557d;
        int i10 = this.f14016u;
        if (!z) {
            if (this.f14015t + 6 >= i10) {
                r1();
            }
            this.f14015t = x2.e.h(this.r, s8, this.f14015t);
            return;
        }
        if (this.f14015t + 8 >= i10) {
            r1();
        }
        char[] cArr = this.r;
        int i11 = this.f14015t;
        int i12 = i11 + 1;
        this.f14015t = i12;
        char c9 = this.f14013q;
        cArr[i11] = c9;
        int iH = x2.e.h(cArr, s8, i12);
        char[] cArr2 = this.r;
        this.f14015t = iH + 1;
        cArr2[iH] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final int S(Base64Variant base64Variant, q3.e eVar, int i10) throws IOException {
        k1("write a binary value");
        int i11 = this.f14015t;
        int i12 = this.f14016u;
        if (i11 >= i12) {
            r1();
        }
        char[] cArr = this.r;
        int i13 = this.f14015t;
        this.f14015t = i13 + 1;
        char c9 = this.f14013q;
        cArr[i13] = c9;
        x2.b bVar = this.f13974j;
        byte[] bArrB = bVar.b();
        try {
            if (i10 < 0) {
                i10 = v1(base64Variant, eVar, bArrB);
            } else {
                int iW1 = w1(base64Variant, eVar, bArrB, i10);
                if (iW1 > 0) {
                    a("Too few bytes available: missing " + iW1 + " bytes (out of " + i10 + ")");
                    throw null;
                }
            }
            bVar.c(bArrB);
            if (this.f14015t >= i12) {
                r1();
            }
            char[] cArr2 = this.r;
            int i14 = this.f14015t;
            this.f14015t = i14 + 1;
            cArr2[i14] = c9;
            return i10;
        } catch (Throwable th) {
            bVar.c(bArrB);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void T0(char c9) throws IOException {
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void U0(String str) throws IOException {
        int length = str.length();
        int i10 = this.f14015t;
        int i11 = this.f14016u;
        int i12 = i11 - i10;
        if (i12 == 0) {
            r1();
            i12 = i11 - this.f14015t;
        }
        if (i12 >= length) {
            str.getChars(0, length, this.r, this.f14015t);
            this.f14015t += length;
            return;
        }
        int i13 = this.f14015t;
        int i14 = i11 - i13;
        str.getChars(0, i14, this.r, i13);
        this.f14015t += i14;
        r1();
        int length2 = str.length() - i14;
        while (length2 > i11) {
            int i15 = i14 + i11;
            str.getChars(i14, i15, this.r, 0);
            this.f14014s = 0;
            this.f14015t = i11;
            r1();
            length2 -= i11;
            i14 = i15;
        }
        str.getChars(i14, i14 + length2, this.r, 0);
        this.f14014s = 0;
        this.f14015t = length2;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void V0(v2.e eVar) throws IOException {
        int iE = eVar.e(this.r, this.f14015t);
        if (iE < 0) {
            U0(eVar.getValue());
        } else {
            this.f14015t += iE;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void W0(char[] cArr, int i10) throws IOException {
        if (i10 >= 32) {
            r1();
            this.f14012p.write(cArr, 0, i10);
        } else {
            if (i10 > this.f14016u - this.f14015t) {
                r1();
            }
            System.arraycopy(cArr, 0, this.r, this.f14015t, i10);
            this.f14015t += i10;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Z0() throws IOException {
        k1("start an array");
        this.f13558e = this.f13558e.i();
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a1(Object obj) throws IOException {
        k1("start an array");
        this.f13558e = this.f13558e.j(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void b1(Object obj) throws IOException {
        k1("start an array");
        this.f13558e = this.f13558e.j(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c0(Base64Variant base64Variant, byte[] bArr, int i10, int i11) throws IOException {
        int iG;
        k1("write a binary value");
        int i12 = this.f14015t;
        int i13 = this.f14016u;
        if (i12 >= i13) {
            r1();
        }
        char[] cArr = this.r;
        int i14 = this.f14015t;
        this.f14015t = i14 + 1;
        char c9 = this.f14013q;
        cArr[i14] = c9;
        int i15 = i11 + i10;
        int i16 = i15 - 3;
        int i17 = i13 - 6;
        int i18 = base64Variant.h;
        loop0: while (true) {
            int i19 = i18 >> 2;
            while (i10 <= i16) {
                if (this.f14015t > i17) {
                    r1();
                }
                int i20 = i10 + 2;
                int i21 = ((bArr[i10 + 1] & 255) | (bArr[i10] << 8)) << 8;
                i10 += 3;
                iG = base64Variant.g(this.r, i21 | (bArr[i20] & 255), this.f14015t);
                this.f14015t = iG;
                i19--;
                if (i19 <= 0) {
                    break;
                }
            }
            char[] cArr2 = this.r;
            int i22 = iG + 1;
            this.f14015t = i22;
            cArr2[iG] = '\\';
            this.f14015t = iG + 2;
            cArr2[i22] = 'n';
            i18 = base64Variant.h;
        }
        int i23 = i15 - i10;
        if (i23 > 0) {
            if (this.f14015t > i17) {
                r1();
            }
            int i24 = i10 + 1;
            int i25 = bArr[i10] << 16;
            if (i23 == 2) {
                i25 |= (bArr[i24] & 255) << 8;
            }
            this.f14015t = base64Variant.h(i25, i23, this.f14015t, this.r);
        }
        if (this.f14015t >= i13) {
            r1();
        }
        char[] cArr3 = this.r;
        int i26 = this.f14015t;
        this.f14015t = i26 + 1;
        cArr3[i26] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c1() throws IOException {
        k1("start an object");
        this.f13558e = this.f13558e.k();
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.d(this);
            return;
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = '{';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.r != null && P(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                d dVar = this.f13558e;
                if (!dVar.d()) {
                    if (!dVar.e()) {
                        break;
                    } else {
                        G0();
                    }
                } else {
                    C0();
                }
            }
        }
        r1();
        this.f14014s = 0;
        this.f14015t = 0;
        x2.b bVar = this.f13974j;
        Writer writer = this.f14012p;
        if (writer != null) {
            if (bVar.f13715c || P(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                writer.close();
            } else if (P(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                writer.flush();
            }
        }
        char[] cArr = this.r;
        if (cArr != null) {
            this.r = null;
            char[] cArr2 = bVar.f13720i;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            bVar.f13720i = null;
            bVar.f13716d.f11b.set(1, cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void d1(Object obj) throws IOException {
        k1("start an object");
        this.f13558e = this.f13558e.l(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.d(this);
            return;
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void f1(String str) throws IOException {
        k1("write a string");
        if (str == null) {
            x1();
            return;
        }
        int i10 = this.f14015t;
        int i11 = this.f14016u;
        if (i10 >= i11) {
            r1();
        }
        char[] cArr = this.r;
        int i12 = this.f14015t;
        this.f14015t = i12 + 1;
        char c9 = this.f14013q;
        cArr[i12] = c9;
        z1(str);
        if (this.f14015t >= i11) {
            r1();
        }
        char[] cArr2 = this.r;
        int i13 = this.f14015t;
        this.f14015t = i13 + 1;
        cArr2[i13] = c9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        r1();
        Writer writer = this.f14012p;
        if (writer == null || !P(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        writer.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g0(boolean z) throws IOException {
        int i10;
        k1("write a boolean value");
        if (this.f14015t + 5 >= this.f14016u) {
            r1();
        }
        int i11 = this.f14015t;
        char[] cArr = this.r;
        if (z) {
            cArr[i11] = 't';
            cArr[i11 + 1] = 'r';
            cArr[i11 + 2] = 'u';
            i10 = i11 + 3;
            cArr[i10] = 'e';
        } else {
            cArr[i11] = 'f';
            cArr[i11 + 1] = 'a';
            cArr[i11 + 2] = 'l';
            cArr[i11 + 3] = 's';
            i10 = i11 + 4;
            cArr[i10] = 'e';
        }
        this.f14015t = i10 + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g1(v2.e eVar) throws IOException {
        k1("write a string");
        int i10 = this.f14015t;
        int i11 = this.f14016u;
        if (i10 >= i11) {
            r1();
        }
        char[] cArr = this.r;
        int i12 = this.f14015t;
        int i13 = i12 + 1;
        this.f14015t = i13;
        char c9 = this.f14013q;
        cArr[i12] = c9;
        int iA = eVar.a(cArr, i13);
        if (iA >= 0) {
            int i14 = this.f14015t + iA;
            this.f14015t = i14;
            if (i14 >= i11) {
                r1();
            }
            char[] cArr2 = this.r;
            int i15 = this.f14015t;
            this.f14015t = i15 + 1;
            cArr2[i15] = c9;
            return;
        }
        char[] cArrB = eVar.b();
        int length = cArrB.length;
        if (length < 32) {
            if (length > i11 - this.f14015t) {
                r1();
            }
            System.arraycopy(cArrB, 0, this.r, this.f14015t, length);
            this.f14015t += length;
        } else {
            r1();
            this.f14012p.write(cArrB, 0, length);
        }
        if (this.f14015t >= i11) {
            r1();
        }
        char[] cArr3 = this.r;
        int i16 = this.f14015t;
        this.f14015t = i16 + 1;
        cArr3[i16] = c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[PHI: r11
      0x0045: PHI (r11v6 int) = (r11v3 int), (r11v7 int) binds: [B:15:0x0041, B:13:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fasterxml.jackson.core.JsonGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h1(char[] r17, int r18, int r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.h.h1(char[], int, int):void");
    }

    @Override // w2.a
    public final void k1(String str) throws IOException {
        char c9;
        int iN = this.f13558e.n();
        if (this.f3540a != null) {
            m1(iN, str);
            return;
        }
        if (iN == 1) {
            c9 = ',';
        } else {
            if (iN != 2) {
                if (iN != 3) {
                    if (iN != 5) {
                        return;
                    }
                    l1(str);
                    throw null;
                }
                v2.e eVar = this.f13977m;
                if (eVar != null) {
                    U0(eVar.getValue());
                    return;
                }
                return;
            }
            c9 = ':';
        }
        if (this.f14015t >= this.f14016u) {
            r1();
        }
        char[] cArr = this.r;
        int i10 = this.f14015t;
        this.f14015t = i10 + 1;
        cArr[i10] = c9;
    }

    public final char[] p1() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.f14017v = cArr;
        return cArr;
    }

    public final void q1(char c9, int i10) throws IOException {
        int i11;
        int i12 = this.f14016u;
        if (i10 >= 0) {
            if (this.f14015t + 2 > i12) {
                r1();
            }
            char[] cArr = this.r;
            int i13 = this.f14015t;
            int i14 = i13 + 1;
            this.f14015t = i14;
            cArr[i13] = '\\';
            this.f14015t = i13 + 2;
            cArr[i14] = (char) i10;
            return;
        }
        if (i10 == -2) {
            throw null;
        }
        if (this.f14015t + 5 >= i12) {
            r1();
        }
        int i15 = this.f14015t;
        char[] cArr2 = this.r;
        cArr2[i15] = '\\';
        int i16 = i15 + 2;
        cArr2[i15 + 1] = 'u';
        char[] cArr3 = f14011w;
        if (c9 > 255) {
            int i17 = c9 >> '\b';
            int i18 = i15 + 3;
            cArr2[i16] = cArr3[(i17 & 255) >> 4];
            i11 = i15 + 4;
            cArr2[i18] = cArr3[i17 & 15];
            c9 = (char) (c9 & 255);
        } else {
            int i19 = i15 + 3;
            cArr2[i16] = '0';
            i11 = i15 + 4;
            cArr2[i19] = '0';
        }
        cArr2[i11] = cArr3[c9 >> 4];
        cArr2[i11 + 1] = cArr3[c9 & 15];
        this.f14015t = i11 + 2;
    }

    public final void r1() throws IOException {
        int i10 = this.f14015t;
        int i11 = this.f14014s;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f14014s = 0;
            this.f14015t = 0;
            this.f14012p.write(this.r, i11, i12);
        }
    }

    public final int s1(char[] cArr, int i10, int i11, char c9, int i12) throws IOException {
        int i13;
        Writer writer = this.f14012p;
        if (i12 >= 0) {
            if (i10 > 1 && i10 < i11) {
                int i14 = i10 - 2;
                cArr[i14] = '\\';
                cArr[i10 - 1] = (char) i12;
                return i14;
            }
            char[] cArrP1 = this.f14017v;
            if (cArrP1 == null) {
                cArrP1 = p1();
            }
            cArrP1[1] = (char) i12;
            writer.write(cArrP1, 0, 2);
            return i10;
        }
        if (i12 == -2) {
            throw null;
        }
        char[] cArr2 = f14011w;
        if (i10 <= 5 || i10 >= i11) {
            char[] cArrP12 = this.f14017v;
            if (cArrP12 == null) {
                cArrP12 = p1();
            }
            this.f14014s = this.f14015t;
            if (c9 <= 255) {
                cArrP12[6] = cArr2[c9 >> 4];
                cArrP12[7] = cArr2[c9 & 15];
                writer.write(cArrP12, 2, 6);
                return i10;
            }
            int i15 = c9 >> '\b';
            cArrP12[10] = cArr2[(i15 & 255) >> 4];
            cArrP12[11] = cArr2[i15 & 15];
            cArrP12[12] = cArr2[(c9 & 255) >> 4];
            cArrP12[13] = cArr2[c9 & 15];
            writer.write(cArrP12, 8, 6);
            return i10;
        }
        cArr[i10 - 6] = '\\';
        int i16 = i10 - 4;
        cArr[i10 - 5] = 'u';
        if (c9 > 255) {
            int i17 = c9 >> '\b';
            int i18 = i10 - 3;
            cArr[i16] = cArr2[(i17 & 255) >> 4];
            i13 = i10 - 2;
            cArr[i18] = cArr2[i17 & 15];
            c9 = (char) (c9 & 255);
        } else {
            int i19 = i10 - 3;
            cArr[i16] = '0';
            i13 = i10 - 2;
            cArr[i19] = '0';
        }
        cArr[i13] = cArr2[c9 >> 4];
        cArr[i13 + 1] = cArr2[c9 & 15];
        return i13 - 4;
    }

    public final void t1(char c9, int i10) throws IOException {
        int i11;
        Writer writer = this.f14012p;
        if (i10 >= 0) {
            int i12 = this.f14015t;
            if (i12 >= 2) {
                int i13 = i12 - 2;
                this.f14014s = i13;
                char[] cArr = this.r;
                cArr[i13] = '\\';
                cArr[i12 - 1] = (char) i10;
                return;
            }
            char[] cArrP1 = this.f14017v;
            if (cArrP1 == null) {
                cArrP1 = p1();
            }
            this.f14014s = this.f14015t;
            cArrP1[1] = (char) i10;
            writer.write(cArrP1, 0, 2);
            return;
        }
        if (i10 == -2) {
            throw null;
        }
        int i14 = this.f14015t;
        char[] cArr2 = f14011w;
        if (i14 < 6) {
            char[] cArrP12 = this.f14017v;
            if (cArrP12 == null) {
                cArrP12 = p1();
            }
            this.f14014s = this.f14015t;
            if (c9 <= 255) {
                cArrP12[6] = cArr2[c9 >> 4];
                cArrP12[7] = cArr2[c9 & 15];
                writer.write(cArrP12, 2, 6);
                return;
            } else {
                int i15 = c9 >> '\b';
                cArrP12[10] = cArr2[(i15 & 255) >> 4];
                cArrP12[11] = cArr2[i15 & 15];
                cArrP12[12] = cArr2[(c9 & 255) >> 4];
                cArrP12[13] = cArr2[c9 & 15];
                writer.write(cArrP12, 8, 6);
                return;
            }
        }
        char[] cArr3 = this.r;
        int i16 = i14 - 6;
        this.f14014s = i16;
        cArr3[i16] = '\\';
        cArr3[i14 - 5] = 'u';
        if (c9 > 255) {
            int i17 = c9 >> '\b';
            cArr3[i14 - 4] = cArr2[(i17 & 255) >> 4];
            i11 = i14 - 3;
            cArr3[i11] = cArr2[i17 & 15];
            c9 = (char) (c9 & 255);
        } else {
            cArr3[i14 - 4] = '0';
            i11 = i14 - 3;
            cArr3[i11] = '0';
        }
        cArr3[i11 + 1] = cArr2[c9 >> 4];
        cArr3[i11 + 2] = cArr2[c9 & 15];
    }

    public final int v1(Base64Variant base64Variant, q3.e eVar, byte[] bArr) throws IOException {
        int i10 = this.f14016u - 6;
        int i11 = 2;
        int i12 = base64Variant.h >> 2;
        int i13 = -3;
        int i14 = 0;
        int iU1 = 0;
        int i15 = 0;
        while (true) {
            if (i14 > i13) {
                iU1 = u1(eVar, bArr, i14, iU1, bArr.length);
                if (iU1 < 3) {
                    break;
                }
                i13 = iU1 - 3;
                i14 = 0;
            }
            if (this.f14015t > i10) {
                r1();
            }
            int i16 = i14 + 2;
            int i17 = ((bArr[i14 + 1] & 255) | (bArr[i14] << 8)) << 8;
            i14 += 3;
            i15 += 3;
            int iG = base64Variant.g(this.r, (bArr[i16] & 255) | i17, this.f14015t);
            this.f14015t = iG;
            i12--;
            if (i12 <= 0) {
                char[] cArr = this.r;
                int i18 = iG + 1;
                this.f14015t = i18;
                cArr[iG] = '\\';
                this.f14015t = iG + 2;
                cArr[i18] = 'n';
                i12 = base64Variant.h >> 2;
            }
        }
        if (iU1 <= 0) {
            return i15;
        }
        if (this.f14015t > i10) {
            r1();
        }
        int i19 = bArr[0] << 16;
        if (1 < iU1) {
            i19 |= (bArr[1] & 255) << 8;
        } else {
            i11 = 1;
        }
        int i20 = i15 + i11;
        this.f14015t = base64Variant.h(i19, i11, this.f14015t, this.r);
        return i20;
    }

    public final int w1(Base64Variant base64Variant, q3.e eVar, byte[] bArr, int i10) throws IOException {
        int iU1;
        int i11 = this.f14016u - 6;
        int i12 = 2;
        int i13 = base64Variant.h >> 2;
        int i14 = -3;
        int i15 = 0;
        int iU12 = 0;
        while (true) {
            if (i10 <= 2) {
                break;
            }
            if (i15 > i14) {
                iU12 = u1(eVar, bArr, i15, iU12, i10);
                if (iU12 < 3) {
                    i15 = 0;
                    break;
                }
                i14 = iU12 - 3;
                i15 = 0;
            }
            if (this.f14015t > i11) {
                r1();
            }
            int i16 = i15 + 2;
            int i17 = ((bArr[i15 + 1] & 255) | (bArr[i15] << 8)) << 8;
            i15 += 3;
            i10 -= 3;
            int iG = base64Variant.g(this.r, (bArr[i16] & 255) | i17, this.f14015t);
            this.f14015t = iG;
            i13--;
            if (i13 <= 0) {
                char[] cArr = this.r;
                int i18 = iG + 1;
                this.f14015t = i18;
                cArr[iG] = '\\';
                this.f14015t = iG + 2;
                cArr[i18] = 'n';
                i13 = base64Variant.h >> 2;
            }
        }
        if (i10 <= 0 || (iU1 = u1(eVar, bArr, i15, iU12, i10)) <= 0) {
            return i10;
        }
        if (this.f14015t > i11) {
            r1();
        }
        int i19 = bArr[0] << 16;
        if (1 < iU1) {
            i19 |= (bArr[1] & 255) << 8;
        } else {
            i12 = 1;
        }
        this.f14015t = base64Variant.h(i19, i12, this.f14015t, this.r);
        return i10 - i12;
    }

    public final void x1() throws IOException {
        if (this.f14015t + 4 >= this.f14016u) {
            r1();
        }
        int i10 = this.f14015t;
        char[] cArr = this.r;
        cArr[i10] = 'n';
        cArr[i10 + 1] = 'u';
        cArr[i10 + 2] = 'l';
        cArr[i10 + 3] = 'l';
        this.f14015t = i10 + 4;
    }

    public final void y1(String str) throws IOException {
        int i10 = this.f14015t;
        int i11 = this.f14016u;
        if (i10 >= i11) {
            r1();
        }
        char[] cArr = this.r;
        int i12 = this.f14015t;
        this.f14015t = i12 + 1;
        char c9 = this.f14013q;
        cArr[i12] = c9;
        U0(str);
        if (this.f14015t >= i11) {
            r1();
        }
        char[] cArr2 = this.r;
        int i13 = this.f14015t;
        this.f14015t = i13 + 1;
        cArr2[i13] = c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[PHI: r16
      0x004b: PHI (r16v3 int) = (r16v0 int), (r16v4 int) binds: [B:18:0x0046, B:16:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z1(java.lang.String r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.h.z1(java.lang.String):void");
    }
}
