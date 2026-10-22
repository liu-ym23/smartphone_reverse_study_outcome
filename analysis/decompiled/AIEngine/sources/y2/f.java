package y2;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.stepos.core.common.util.TraceIdKeys;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: p, reason: collision with root package name */
    public final a3.c f13997p;

    /* renamed from: q, reason: collision with root package name */
    public final byte f13998q;
    public byte[] r;

    /* renamed from: s, reason: collision with root package name */
    public int f13999s;

    /* renamed from: t, reason: collision with root package name */
    public final int f14000t;

    /* renamed from: u, reason: collision with root package name */
    public final int f14001u;

    /* renamed from: v, reason: collision with root package name */
    public char[] f14002v;

    /* renamed from: w, reason: collision with root package name */
    public final int f14003w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f14004x;

    /* renamed from: y, reason: collision with root package name */
    public static final byte[] f13996y = (byte[]) x2.a.f13704b.clone();
    public static final byte[] z = {110, 117, 108, 108};
    public static final byte[] A = {116, 114, 117, 101};
    public static final byte[] B = {102, 97, 108, 115, 101};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(x2.b bVar, int i10, v2.c cVar, a3.c cVar2, char c9) {
        super(bVar, i10, cVar);
        a3.a aVar = bVar.f13716d;
        this.f13997p = cVar2;
        this.f13998q = (byte) c9;
        if (c9 != '\"') {
            this.f13975k = x2.a.a(c9);
        }
        this.f14004x = true;
        x2.b.a(bVar.f13718f);
        byte[] bArrA = aVar.a(1);
        bVar.f13718f = bArrA;
        this.r = bArrA;
        int length = bArrA.length;
        this.f14000t = length;
        this.f14001u = length >> 3;
        x2.b.a(bVar.f13720i);
        char[] cArrB = aVar.b(1, 0);
        bVar.f13720i = cArrB;
        this.f14002v = cArrB;
        this.f14003w = cArrB.length;
        if (P(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            o1(127);
        }
    }

    public static int s1(q3.e eVar, byte[] bArr, int i10, int i11, int i12) {
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

    public final void A1(char[] cArr, int i10, int i11) {
        char c9;
        int i12 = i11 + i10;
        int i13 = this.f13999s;
        byte[] bArr = this.r;
        int[] iArr = this.f13975k;
        while (i10 < i12 && (c9 = cArr[i10]) <= 127 && iArr[c9] == 0) {
            bArr[i13] = (byte) c9;
            i10++;
            i13++;
        }
        this.f13999s = i13;
        if (i10 < i12) {
            int i14 = this.f13976l;
            int i15 = this.f14000t;
            if (i14 == 0) {
                if (((i12 - i10) * 6) + i13 > i15) {
                    p1();
                }
                int iQ1 = this.f13999s;
                byte[] bArr2 = this.r;
                int[] iArr2 = this.f13975k;
                while (i10 < i12) {
                    int i16 = i10 + 1;
                    char c10 = cArr[i10];
                    if (c10 <= 127) {
                        int i17 = iArr2[c10];
                        if (i17 == 0) {
                            bArr2[iQ1] = (byte) c10;
                            i10 = i16;
                            iQ1++;
                        } else if (i17 > 0) {
                            int i18 = iQ1 + 1;
                            bArr2[iQ1] = 92;
                            iQ1 += 2;
                            bArr2[i18] = (byte) i17;
                        } else {
                            iQ1 = w1(c10, iQ1);
                        }
                    } else if (c10 <= 2047) {
                        int i19 = iQ1 + 1;
                        bArr2[iQ1] = (byte) ((c10 >> 6) | 192);
                        iQ1 += 2;
                        bArr2[i19] = (byte) ((c10 & '?') | TraceIdKeys.MAX_LENGTH);
                    } else {
                        iQ1 = q1(c10, iQ1);
                    }
                    i10 = i16;
                }
                this.f13999s = iQ1;
                return;
            }
            if (((i12 - i10) * 6) + i13 > i15) {
                p1();
            }
            int iQ12 = this.f13999s;
            byte[] bArr3 = this.r;
            int[] iArr3 = this.f13975k;
            int i20 = this.f13976l;
            while (i10 < i12) {
                int i21 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 <= 127) {
                    int i22 = iArr3[c11];
                    if (i22 == 0) {
                        bArr3[iQ12] = (byte) c11;
                        i10 = i21;
                        iQ12++;
                    } else if (i22 > 0) {
                        int i23 = iQ12 + 1;
                        bArr3[iQ12] = 92;
                        iQ12 += 2;
                        bArr3[i23] = (byte) i22;
                    } else {
                        iQ12 = w1(c11, iQ12);
                    }
                } else if (c11 > i20) {
                    iQ12 = w1(c11, iQ12);
                } else if (c11 <= 2047) {
                    int i24 = iQ12 + 1;
                    bArr3[iQ12] = (byte) ((c11 >> 6) | 192);
                    iQ12 += 2;
                    bArr3[i24] = (byte) ((c11 & '?') | TraceIdKeys.MAX_LENGTH);
                } else {
                    iQ12 = q1(c11, iQ12);
                }
                i10 = i21;
            }
            this.f13999s = iQ12;
        }
    }

    public final void B1(String str, boolean z3) {
        byte b10 = this.f13998q;
        int i10 = this.f14000t;
        if (z3) {
            if (this.f13999s >= i10) {
                p1();
            }
            byte[] bArr = this.r;
            int i11 = this.f13999s;
            this.f13999s = i11 + 1;
            bArr[i11] = b10;
        }
        int length = str.length();
        int i12 = 0;
        while (length > 0) {
            int iMin = Math.min(this.f14001u, length);
            if (this.f13999s + iMin > i10) {
                p1();
            }
            z1(i12, iMin, str);
            i12 += iMin;
            length -= iMin;
        }
        if (z3) {
            if (this.f13999s >= i10) {
                p1();
            }
            byte[] bArr2 = this.r;
            int i13 = this.f13999s;
            this.f13999s = i13 + 1;
            bArr2[i13] = b10;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void C0() throws JsonGenerationException {
        if (!this.f13558e.d()) {
            a("Current context not Array but ".concat(this.f13558e.h()));
            throw null;
        }
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.e(this, this.f13558e.f13376b + 1);
        } else {
            if (this.f13999s >= this.f14000t) {
                p1();
            }
            byte[] bArr = this.r;
            int i10 = this.f13999s;
            this.f13999s = i10 + 1;
            bArr[i10] = 93;
        }
        d dVar2 = this.f13558e;
        dVar2.f13989g = null;
        this.f13558e = dVar2.f13985c;
    }

    public final void C1(char[] cArr, int i10, int i11) {
        do {
            int iMin = Math.min(this.f14001u, i11);
            if (this.f13999s + iMin > this.f14000t) {
                p1();
            }
            A1(cArr, i10, iMin);
            i10 += iMin;
            i11 -= iMin;
        } while (i11 > 0);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void G0() throws JsonGenerationException {
        if (!this.f13558e.e()) {
            a("Current context not Object but ".concat(this.f13558e.h()));
            throw null;
        }
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.i(this, this.f13558e.f13376b + 1);
        } else {
            if (this.f13999s >= this.f14000t) {
                p1();
            }
            byte[] bArr = this.r;
            int i10 = this.f13999s;
            this.f13999s = i10 + 1;
            bArr[i10] = 125;
        }
        d dVar2 = this.f13558e;
        dVar2.f13989g = null;
        this.f13558e = dVar2.f13985c;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void H0(String str) throws JsonGenerationException {
        v2.d dVar = this.f3540a;
        int i10 = this.f14003w;
        int i11 = this.f14001u;
        byte b10 = this.f13998q;
        int i12 = 0;
        int i13 = this.f14000t;
        if (dVar != null) {
            int iM = this.f13558e.m(str);
            if (iM == 4) {
                a("Can not write a field name, expecting a value");
                throw null;
            }
            if (iM == 1) {
                this.f3540a.c(this);
            } else {
                this.f3540a.b(this);
            }
            if (this.f13978n) {
                B1(str, false);
                return;
            }
            int length = str.length();
            if (length > i10) {
                B1(str, true);
                return;
            }
            if (this.f13999s >= i13) {
                p1();
            }
            byte[] bArr = this.r;
            int i14 = this.f13999s;
            this.f13999s = i14 + 1;
            bArr[i14] = b10;
            str.getChars(0, length, this.f14002v, 0);
            if (length <= i11) {
                if (this.f13999s + length > i13) {
                    p1();
                }
                A1(this.f14002v, 0, length);
            } else {
                C1(this.f14002v, 0, length);
            }
            if (this.f13999s >= i13) {
                p1();
            }
            byte[] bArr2 = this.r;
            int i15 = this.f13999s;
            this.f13999s = i15 + 1;
            bArr2[i15] = b10;
            return;
        }
        int iM2 = this.f13558e.m(str);
        if (iM2 == 4) {
            a("Can not write a field name, expecting a value");
            throw null;
        }
        if (iM2 == 1) {
            if (this.f13999s >= i13) {
                p1();
            }
            byte[] bArr3 = this.r;
            int i16 = this.f13999s;
            this.f13999s = i16 + 1;
            bArr3[i16] = 44;
        }
        if (this.f13978n) {
            B1(str, false);
            return;
        }
        int length2 = str.length();
        if (length2 > i10) {
            B1(str, true);
            return;
        }
        if (this.f13999s >= i13) {
            p1();
        }
        byte[] bArr4 = this.r;
        int i17 = this.f13999s;
        int i18 = i17 + 1;
        this.f13999s = i18;
        bArr4[i17] = b10;
        if (length2 <= i11) {
            if (i18 + length2 > i13) {
                p1();
            }
            z1(0, length2, str);
        } else {
            do {
                int iMin = Math.min(i11, length2);
                if (this.f13999s + iMin > i13) {
                    p1();
                }
                z1(i12, iMin, str);
                i12 += iMin;
                length2 -= iMin;
            } while (length2 > 0);
        }
        if (this.f13999s >= i13) {
            p1();
        }
        byte[] bArr5 = this.r;
        int i19 = this.f13999s;
        this.f13999s = i19 + 1;
        bArr5[i19] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void I0(v2.e eVar) throws JsonGenerationException {
        v2.d dVar = this.f3540a;
        byte b10 = this.f13998q;
        int i10 = this.f14000t;
        if (dVar != null) {
            int iM = this.f13558e.m(eVar.getValue());
            if (iM == 4) {
                a("Can not write a field name, expecting a value");
                throw null;
            }
            if (iM == 1) {
                this.f3540a.c(this);
            } else {
                this.f3540a.b(this);
            }
            boolean z3 = this.f13978n;
            if (!z3) {
                if (this.f13999s >= i10) {
                    p1();
                }
                byte[] bArr = this.r;
                int i11 = this.f13999s;
                this.f13999s = i11 + 1;
                bArr[i11] = b10;
            }
            int iD = eVar.d(this.r, this.f13999s);
            if (iD < 0) {
                v1(eVar.c());
            } else {
                this.f13999s += iD;
            }
            if (z3) {
                return;
            }
            if (this.f13999s >= i10) {
                p1();
            }
            byte[] bArr2 = this.r;
            int i12 = this.f13999s;
            this.f13999s = i12 + 1;
            bArr2[i12] = b10;
            return;
        }
        int iM2 = this.f13558e.m(eVar.getValue());
        if (iM2 == 4) {
            a("Can not write a field name, expecting a value");
            throw null;
        }
        if (iM2 == 1) {
            if (this.f13999s >= i10) {
                p1();
            }
            byte[] bArr3 = this.r;
            int i13 = this.f13999s;
            this.f13999s = i13 + 1;
            bArr3[i13] = 44;
        }
        if (this.f13978n) {
            int iD2 = eVar.d(this.r, this.f13999s);
            if (iD2 < 0) {
                v1(eVar.c());
                return;
            } else {
                this.f13999s += iD2;
                return;
            }
        }
        if (this.f13999s >= i10) {
            p1();
        }
        byte[] bArr4 = this.r;
        int i14 = this.f13999s;
        int i15 = i14 + 1;
        this.f13999s = i15;
        bArr4[i14] = b10;
        int iD3 = eVar.d(bArr4, i15);
        if (iD3 < 0) {
            v1(eVar.c());
        } else {
            this.f13999s += iD3;
        }
        if (this.f13999s >= i10) {
            p1();
        }
        byte[] bArr5 = this.r;
        int i16 = this.f13999s;
        this.f13999s = i16 + 1;
        bArr5[i16] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void J0() throws JsonGenerationException {
        k1("write a null");
        x1();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void K0(double d8) throws JsonGenerationException {
        if (!this.f13557d) {
            String str = x2.e.f13727a;
            if ((!Double.isNaN(d8) && !Double.isInfinite(d8)) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.a(this.f13556c)) {
                k1("write a number");
                U0(String.valueOf(d8));
                return;
            }
        }
        f1(String.valueOf(d8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void L0(float f8) throws JsonGenerationException {
        if (!this.f13557d) {
            String str = x2.e.f13727a;
            if ((!Float.isNaN(f8) && !Float.isInfinite(f8)) || !JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS.a(this.f13556c)) {
                k1("write a number");
                U0(String.valueOf(f8));
                return;
            }
        }
        f1(String.valueOf(f8));
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void M0(int i10) throws JsonGenerationException {
        k1("write a number");
        int i11 = this.f13999s + 11;
        int i12 = this.f14000t;
        if (i11 >= i12) {
            p1();
        }
        if (!this.f13557d) {
            this.f13999s = x2.e.g(this.r, i10, this.f13999s);
            return;
        }
        if (this.f13999s + 13 >= i12) {
            p1();
        }
        byte[] bArr = this.r;
        int i13 = this.f13999s;
        int i14 = i13 + 1;
        this.f13999s = i14;
        byte b10 = this.f13998q;
        bArr[i13] = b10;
        int iG = x2.e.g(bArr, i10, i14);
        byte[] bArr2 = this.r;
        this.f13999s = iG + 1;
        bArr2[iG] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void N0(long j10) throws JsonGenerationException {
        k1("write a number");
        boolean z3 = this.f13557d;
        int i10 = this.f14000t;
        if (!z3) {
            if (this.f13999s + 21 >= i10) {
                p1();
            }
            this.f13999s = x2.e.i(j10, this.r, this.f13999s);
            return;
        }
        if (this.f13999s + 23 >= i10) {
            p1();
        }
        byte[] bArr = this.r;
        int i11 = this.f13999s;
        int i12 = i11 + 1;
        this.f13999s = i12;
        byte b10 = this.f13998q;
        bArr[i11] = b10;
        int i13 = x2.e.i(j10, bArr, i12);
        byte[] bArr2 = this.r;
        this.f13999s = i13 + 1;
        bArr2[i13] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void O0(String str) throws JsonGenerationException {
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
    public final void P0(BigDecimal bigDecimal) throws JsonGenerationException {
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
    public final void Q0(BigInteger bigInteger) throws JsonGenerationException {
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
    public final void R0(short s8) throws JsonGenerationException {
        k1("write a number");
        int i10 = this.f13999s + 6;
        int i11 = this.f14000t;
        if (i10 >= i11) {
            p1();
        }
        if (!this.f13557d) {
            this.f13999s = x2.e.g(this.r, s8, this.f13999s);
            return;
        }
        if (this.f13999s + 8 >= i11) {
            p1();
        }
        byte[] bArr = this.r;
        int i12 = this.f13999s;
        int i13 = i12 + 1;
        this.f13999s = i13;
        byte b10 = this.f13998q;
        bArr[i12] = b10;
        int iG = x2.e.g(bArr, s8, i13);
        byte[] bArr2 = this.r;
        this.f13999s = iG + 1;
        bArr2[iG] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final int S(Base64Variant base64Variant, q3.e eVar, int i10) throws JsonGenerationException {
        k1("write a binary value");
        int i11 = this.f13999s;
        int i12 = this.f14000t;
        if (i11 >= i12) {
            p1();
        }
        byte[] bArr = this.r;
        int i13 = this.f13999s;
        this.f13999s = i13 + 1;
        byte b10 = this.f13998q;
        bArr[i13] = b10;
        x2.b bVar = this.f13974j;
        byte[] bArrB = bVar.b();
        try {
            if (i10 < 0) {
                i10 = t1(base64Variant, eVar, bArrB);
            } else {
                int iU1 = u1(base64Variant, eVar, bArrB, i10);
                if (iU1 > 0) {
                    a("Too few bytes available: missing " + iU1 + " bytes (out of " + i10 + ")");
                    throw null;
                }
            }
            bVar.c(bArrB);
            if (this.f13999s >= i12) {
                p1();
            }
            byte[] bArr2 = this.r;
            int i14 = this.f13999s;
            this.f13999s = i14 + 1;
            bArr2[i14] = b10;
            return i10;
        } catch (Throwable th) {
            bVar.c(bArrB);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void T0(char c9) throws JsonGenerationException {
        if (this.f13999s + 3 >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        if (c9 <= 127) {
            int i10 = this.f13999s;
            this.f13999s = i10 + 1;
            bArr[i10] = (byte) c9;
        } else {
            if (c9 >= 2048) {
                r1(c9, 0, 0, null);
                return;
            }
            int i11 = this.f13999s;
            int i12 = i11 + 1;
            this.f13999s = i12;
            bArr[i11] = (byte) ((c9 >> 6) | 192);
            this.f13999s = i11 + 2;
            bArr[i12] = (byte) ((c9 & '?') | TraceIdKeys.MAX_LENGTH);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void U0(String str) throws JsonGenerationException {
        char c9;
        int length = str.length();
        char[] cArr = this.f14002v;
        if (length <= cArr.length) {
            str.getChars(0, length, cArr, 0);
            W0(cArr, length);
            return;
        }
        int length2 = cArr.length;
        if (length <= length2) {
            str.getChars(0, length, cArr, 0);
            W0(cArr, length);
            return;
        }
        int i10 = this.f14000t;
        int iMin = Math.min(length2, (i10 >> 2) + (i10 >> 4));
        int i11 = iMin * 3;
        int i12 = 0;
        while (length > 0) {
            int iMin2 = Math.min(iMin, length);
            str.getChars(i12, i12 + iMin2, cArr, 0);
            if (this.f13999s + i11 > i10) {
                p1();
            }
            if (iMin2 > 1 && (c9 = cArr[iMin2 - 1]) >= 55296 && c9 <= 56319) {
                iMin2--;
            }
            int iR1 = 0;
            while (iR1 < iMin2) {
                do {
                    char c10 = cArr[iR1];
                    if (c10 > 127) {
                        iR1++;
                        if (c10 < 2048) {
                            byte[] bArr = this.r;
                            int i13 = this.f13999s;
                            int i14 = i13 + 1;
                            this.f13999s = i14;
                            bArr[i13] = (byte) ((c10 >> 6) | 192);
                            this.f13999s = i13 + 2;
                            bArr[i14] = (byte) ((c10 & '?') | TraceIdKeys.MAX_LENGTH);
                        } else {
                            iR1 = r1(c10, iR1, iMin2, cArr);
                        }
                    } else {
                        byte[] bArr2 = this.r;
                        int i15 = this.f13999s;
                        this.f13999s = i15 + 1;
                        bArr2[i15] = (byte) c10;
                        iR1++;
                    }
                } while (iR1 < iMin2);
                i12 += iMin2;
                length -= iMin2;
            }
            i12 += iMin2;
            length -= iMin2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void V0(v2.e eVar) {
        int iF = eVar.f(this.r, this.f13999s);
        if (iF < 0) {
            v1(eVar.g());
        } else {
            this.f13999s += iF;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void W0(char[] cArr, int i10) throws JsonGenerationException {
        int i11 = i10 + i10 + i10;
        int i12 = this.f13999s + i11;
        int iR1 = 0;
        int i13 = this.f14000t;
        if (i12 > i13) {
            if (i13 < i11) {
                byte[] bArr = this.r;
                while (iR1 < i10) {
                    do {
                        char c9 = cArr[iR1];
                        if (c9 >= 128) {
                            if (this.f13999s + 3 >= i13) {
                                p1();
                            }
                            int iR12 = iR1 + 1;
                            char c10 = cArr[iR1];
                            if (c10 < 2048) {
                                int i14 = this.f13999s;
                                int i15 = i14 + 1;
                                this.f13999s = i15;
                                bArr[i14] = (byte) ((c10 >> 6) | 192);
                                this.f13999s = i14 + 2;
                                bArr[i15] = (byte) ((c10 & '?') | TraceIdKeys.MAX_LENGTH);
                            } else {
                                iR12 = r1(c10, iR12, i10, cArr);
                            }
                            iR1 = iR12;
                        } else {
                            if (this.f13999s >= i13) {
                                p1();
                            }
                            int i16 = this.f13999s;
                            this.f13999s = i16 + 1;
                            bArr[i16] = (byte) c9;
                            iR1++;
                        }
                    } while (iR1 < i10);
                    return;
                }
                return;
            }
            p1();
        }
        while (iR1 < i10) {
            do {
                char c11 = cArr[iR1];
                if (c11 > 127) {
                    iR1++;
                    if (c11 < 2048) {
                        byte[] bArr2 = this.r;
                        int i17 = this.f13999s;
                        int i18 = i17 + 1;
                        this.f13999s = i18;
                        bArr2[i17] = (byte) ((c11 >> 6) | 192);
                        this.f13999s = i17 + 2;
                        bArr2[i18] = (byte) ((c11 & '?') | TraceIdKeys.MAX_LENGTH);
                    } else {
                        iR1 = r1(c11, iR1, i10, cArr);
                    }
                } else {
                    byte[] bArr3 = this.r;
                    int i19 = this.f13999s;
                    this.f13999s = i19 + 1;
                    bArr3[i19] = (byte) c11;
                    iR1++;
                }
            } while (iR1 < i10);
            return;
        }
    }

    @Override // w2.a, com.fasterxml.jackson.core.JsonGenerator
    public final void Y0(v2.e eVar) throws JsonGenerationException {
        k1("write a raw (unencoded) value");
        int iF = eVar.f(this.r, this.f13999s);
        if (iF < 0) {
            v1(eVar.g());
        } else {
            this.f13999s += iF;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Z0() throws JsonGenerationException {
        k1("start an array");
        this.f13558e = this.f13558e.i();
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void a1(Object obj) throws JsonGenerationException {
        k1("start an array");
        this.f13558e = this.f13558e.j(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void b1(Object obj) throws JsonGenerationException {
        k1("start an array");
        this.f13558e = this.f13558e.j(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.j(this);
            return;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = 91;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c0(Base64Variant base64Variant, byte[] bArr, int i10, int i11) throws JsonGenerationException {
        int iF;
        k1("write a binary value");
        int i12 = this.f13999s;
        int i13 = this.f14000t;
        if (i12 >= i13) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i14 = this.f13999s;
        this.f13999s = i14 + 1;
        byte b10 = this.f13998q;
        bArr2[i14] = b10;
        int i15 = i11 + i10;
        int i16 = i15 - 3;
        int i17 = i13 - 6;
        int i18 = base64Variant.h;
        loop0: while (true) {
            int i19 = i18 >> 2;
            while (i10 <= i16) {
                if (this.f13999s > i17) {
                    p1();
                }
                int i20 = i10 + 2;
                int i21 = ((bArr[i10 + 1] & 255) | (bArr[i10] << 8)) << 8;
                i10 += 3;
                iF = base64Variant.f(this.r, i21 | (bArr[i20] & 255), this.f13999s);
                this.f13999s = iF;
                i19--;
                if (i19 <= 0) {
                    break;
                }
            }
            byte[] bArr3 = this.r;
            int i22 = iF + 1;
            this.f13999s = i22;
            bArr3[iF] = 92;
            this.f13999s = iF + 2;
            bArr3[i22] = 110;
            i18 = base64Variant.h;
        }
        int i23 = i15 - i10;
        if (i23 > 0) {
            if (this.f13999s > i17) {
                p1();
            }
            int i24 = i10 + 1;
            int i25 = bArr[i10] << 16;
            if (i23 == 2) {
                i25 |= (bArr[i24] & 255) << 8;
            }
            this.f13999s = base64Variant.i(this.r, i25, i23, this.f13999s);
        }
        if (this.f13999s >= i13) {
            p1();
        }
        byte[] bArr4 = this.r;
        int i26 = this.f13999s;
        this.f13999s = i26 + 1;
        bArr4[i26] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void c1() throws JsonGenerationException {
        k1("start an object");
        this.f13558e = this.f13558e.k();
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.d(this);
            return;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = 123;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws JsonGenerationException {
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
        p1();
        this.f13999s = 0;
        x2.b bVar = this.f13974j;
        if (this.f13997p != null && !bVar.f13715c && !P(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
            P(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM);
        }
        byte[] bArr = this.r;
        if (bArr != null && this.f14004x) {
            this.r = null;
            byte[] bArr2 = bVar.f13718f;
            if (bArr != bArr2 && bArr.length < bArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            bVar.f13718f = null;
            bVar.f13716d.f10a.set(1, bArr);
        }
        char[] cArr = this.f14002v;
        if (cArr != null) {
            this.f14002v = null;
            char[] cArr2 = bVar.f13720i;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            bVar.f13720i = null;
            bVar.f13716d.f11b.set(1, cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void d1(Object obj) throws JsonGenerationException {
        k1("start an object");
        this.f13558e = this.f13558e.l(obj);
        v2.d dVar = this.f3540a;
        if (dVar != null) {
            dVar.d(this);
            return;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = 123;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void f1(String str) throws JsonGenerationException {
        k1("write a string");
        if (str == null) {
            x1();
            return;
        }
        int length = str.length();
        if (length > this.f14001u) {
            B1(str, true);
            return;
        }
        int i10 = this.f13999s + length;
        int i11 = this.f14000t;
        if (i10 >= i11) {
            p1();
        }
        byte[] bArr = this.r;
        int i12 = this.f13999s;
        this.f13999s = i12 + 1;
        byte b10 = this.f13998q;
        bArr[i12] = b10;
        z1(0, length, str);
        if (this.f13999s >= i11) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i13 = this.f13999s;
        this.f13999s = i13 + 1;
        bArr2[i13] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() {
        p1();
        if (this.f13997p != null) {
            P(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g0(boolean z3) throws JsonGenerationException {
        k1("write a boolean value");
        if (this.f13999s + 5 >= this.f14000t) {
            p1();
        }
        byte[] bArr = z3 ? A : B;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.r, this.f13999s, length);
        this.f13999s += length;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void g1(v2.e eVar) throws JsonGenerationException {
        k1("write a string");
        int i10 = this.f13999s;
        int i11 = this.f14000t;
        if (i10 >= i11) {
            p1();
        }
        byte[] bArr = this.r;
        int i12 = this.f13999s;
        int i13 = i12 + 1;
        this.f13999s = i13;
        byte b10 = this.f13998q;
        bArr[i12] = b10;
        int iD = eVar.d(bArr, i13);
        if (iD < 0) {
            v1(eVar.c());
        } else {
            this.f13999s += iD;
        }
        if (this.f13999s >= i11) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i14 = this.f13999s;
        this.f13999s = i14 + 1;
        bArr2[i14] = b10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void h1(char[] cArr, int i10, int i11) throws JsonGenerationException {
        k1("write a string");
        int i12 = this.f13999s;
        int i13 = this.f14000t;
        if (i12 >= i13) {
            p1();
        }
        byte[] bArr = this.r;
        int i14 = this.f13999s;
        int i15 = i14 + 1;
        this.f13999s = i15;
        byte b10 = this.f13998q;
        bArr[i14] = b10;
        if (i11 <= this.f14001u) {
            if (i15 + i11 > i13) {
                p1();
            }
            A1(cArr, i10, i11);
        } else {
            C1(cArr, i10, i11);
        }
        if (this.f13999s >= i13) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i16 = this.f13999s;
        this.f13999s = i16 + 1;
        bArr2[i16] = b10;
    }

    @Override // w2.a
    public final void k1(String str) throws JsonGenerationException {
        byte b10;
        int iN = this.f13558e.n();
        if (this.f3540a != null) {
            m1(iN, str);
            return;
        }
        if (iN == 1) {
            b10 = 44;
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
                    byte[] bArrG = eVar.g();
                    if (bArrG.length > 0) {
                        v1(bArrG);
                        return;
                    }
                    return;
                }
                return;
            }
            b10 = 58;
        }
        if (this.f13999s >= this.f14000t) {
            p1();
        }
        byte[] bArr = this.r;
        int i10 = this.f13999s;
        this.f13999s = i10 + 1;
        bArr[i10] = b10;
    }

    public final void p1() {
        int i10 = this.f13999s;
        if (i10 > 0) {
            this.f13999s = 0;
            this.f13997p.write(this.r, 0, i10);
        }
    }

    public final int q1(int i10, int i11) {
        byte[] bArr = this.r;
        if (i10 < 55296 || i10 > 57343) {
            bArr[i11] = (byte) ((i10 >> 12) | 224);
            int i12 = i11 + 2;
            bArr[i11 + 1] = (byte) (((i10 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
            int i13 = i11 + 3;
            bArr[i12] = (byte) ((i10 & 63) | TraceIdKeys.MAX_LENGTH);
            return i13;
        }
        bArr[i11] = 92;
        bArr[i11 + 1] = 117;
        byte[] bArr2 = f13996y;
        bArr[i11 + 2] = bArr2[(i10 >> 12) & 15];
        bArr[i11 + 3] = bArr2[(i10 >> 8) & 15];
        int i14 = i11 + 5;
        bArr[i11 + 4] = bArr2[(i10 >> 4) & 15];
        int i15 = i11 + 6;
        bArr[i14] = bArr2[i10 & 15];
        return i15;
    }

    public final int r1(int i10, int i11, int i12, char[] cArr) throws JsonGenerationException {
        if (i10 < 55296 || i10 > 57343) {
            byte[] bArr = this.r;
            int i13 = this.f13999s;
            int i14 = i13 + 1;
            this.f13999s = i14;
            bArr[i13] = (byte) ((i10 >> 12) | 224);
            int i15 = i13 + 2;
            this.f13999s = i15;
            bArr[i14] = (byte) (((i10 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
            this.f13999s = i13 + 3;
            bArr[i15] = (byte) ((i10 & 63) | TraceIdKeys.MAX_LENGTH);
            return i11;
        }
        if (i11 >= i12 || cArr == null) {
            a(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i10)));
            throw null;
        }
        char c9 = cArr[i11];
        if (c9 < 56320 || c9 > 57343) {
            a("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(c9));
            throw null;
        }
        int i16 = (c9 - 56320) + ((i10 - 55296) << 10) + 65536;
        if (this.f13999s + 4 > this.f14000t) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i17 = this.f13999s;
        int i18 = i17 + 1;
        this.f13999s = i18;
        bArr2[i17] = (byte) ((i16 >> 18) | 240);
        int i19 = i17 + 2;
        this.f13999s = i19;
        bArr2[i18] = (byte) (((i16 >> 12) & 63) | TraceIdKeys.MAX_LENGTH);
        int i20 = i17 + 3;
        this.f13999s = i20;
        bArr2[i19] = (byte) (((i16 >> 6) & 63) | TraceIdKeys.MAX_LENGTH);
        this.f13999s = i17 + 4;
        bArr2[i20] = (byte) ((i16 & 63) | TraceIdKeys.MAX_LENGTH);
        return i11 + 1;
    }

    public final int t1(Base64Variant base64Variant, q3.e eVar, byte[] bArr) {
        int i10 = this.f14000t - 6;
        int i11 = 2;
        int i12 = base64Variant.h >> 2;
        int i13 = -3;
        int i14 = 0;
        int iS1 = 0;
        int i15 = 0;
        while (true) {
            if (i14 > i13) {
                iS1 = s1(eVar, bArr, i14, iS1, bArr.length);
                if (iS1 < 3) {
                    break;
                }
                i13 = iS1 - 3;
                i14 = 0;
            }
            if (this.f13999s > i10) {
                p1();
            }
            int i16 = i14 + 2;
            int i17 = ((bArr[i14 + 1] & 255) | (bArr[i14] << 8)) << 8;
            i14 += 3;
            i15 += 3;
            int iF = base64Variant.f(this.r, (bArr[i16] & 255) | i17, this.f13999s);
            this.f13999s = iF;
            i12--;
            if (i12 <= 0) {
                byte[] bArr2 = this.r;
                int i18 = iF + 1;
                this.f13999s = i18;
                bArr2[iF] = 92;
                this.f13999s = iF + 2;
                bArr2[i18] = 110;
                i12 = base64Variant.h >> 2;
            }
        }
        if (iS1 <= 0) {
            return i15;
        }
        if (this.f13999s > i10) {
            p1();
        }
        int i19 = bArr[0] << 16;
        if (1 < iS1) {
            i19 |= (bArr[1] & 255) << 8;
        } else {
            i11 = 1;
        }
        int i20 = i15 + i11;
        this.f13999s = base64Variant.i(this.r, i19, i11, this.f13999s);
        return i20;
    }

    public final int u1(Base64Variant base64Variant, q3.e eVar, byte[] bArr, int i10) {
        int iS1;
        int i11 = this.f14000t - 6;
        int i12 = 2;
        int i13 = base64Variant.h >> 2;
        int i14 = -3;
        int i15 = 0;
        int iS12 = 0;
        while (true) {
            if (i10 <= 2) {
                break;
            }
            if (i15 > i14) {
                iS12 = s1(eVar, bArr, i15, iS12, i10);
                if (iS12 < 3) {
                    i15 = 0;
                    break;
                }
                i14 = iS12 - 3;
                i15 = 0;
            }
            if (this.f13999s > i11) {
                p1();
            }
            int i16 = i15 + 2;
            int i17 = ((bArr[i15 + 1] & 255) | (bArr[i15] << 8)) << 8;
            i15 += 3;
            i10 -= 3;
            int iF = base64Variant.f(this.r, (bArr[i16] & 255) | i17, this.f13999s);
            this.f13999s = iF;
            i13--;
            if (i13 <= 0) {
                byte[] bArr2 = this.r;
                int i18 = iF + 1;
                this.f13999s = i18;
                bArr2[iF] = 92;
                this.f13999s = iF + 2;
                bArr2[i18] = 110;
                i13 = base64Variant.h >> 2;
            }
        }
        if (i10 <= 0 || (iS1 = s1(eVar, bArr, i15, iS12, i10)) <= 0) {
            return i10;
        }
        if (this.f13999s > i11) {
            p1();
        }
        int i19 = bArr[0] << 16;
        if (1 < iS1) {
            i19 |= (bArr[1] & 255) << 8;
        } else {
            i12 = 1;
        }
        this.f13999s = base64Variant.i(this.r, i19, i12, this.f13999s);
        return i10 - i12;
    }

    public final void v1(byte[] bArr) {
        int length = bArr.length;
        if (this.f13999s + length > this.f14000t) {
            p1();
            if (length > 512) {
                this.f13997p.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.r, this.f13999s, length);
        this.f13999s += length;
    }

    public final int w1(int i10, int i11) {
        int i12;
        byte[] bArr = this.r;
        bArr[i11] = 92;
        int i13 = i11 + 2;
        bArr[i11 + 1] = 117;
        byte[] bArr2 = f13996y;
        if (i10 > 255) {
            int i14 = i10 >> 8;
            int i15 = i11 + 3;
            bArr[i13] = bArr2[(i14 & 255) >> 4];
            i12 = i11 + 4;
            bArr[i15] = bArr2[i14 & 15];
            i10 &= 255;
        } else {
            int i16 = i11 + 3;
            bArr[i13] = 48;
            i12 = i11 + 4;
            bArr[i16] = 48;
        }
        int i17 = i12 + 1;
        bArr[i12] = bArr2[i10 >> 4];
        int i18 = i12 + 2;
        bArr[i17] = bArr2[i10 & 15];
        return i18;
    }

    public final void x1() {
        if (this.f13999s + 4 >= this.f14000t) {
            p1();
        }
        System.arraycopy(z, 0, this.r, this.f13999s, 4);
        this.f13999s += 4;
    }

    public final void y1(String str) throws JsonGenerationException {
        int i10 = this.f13999s;
        int i11 = this.f14000t;
        if (i10 >= i11) {
            p1();
        }
        byte[] bArr = this.r;
        int i12 = this.f13999s;
        this.f13999s = i12 + 1;
        byte b10 = this.f13998q;
        bArr[i12] = b10;
        U0(str);
        if (this.f13999s >= i11) {
            p1();
        }
        byte[] bArr2 = this.r;
        int i13 = this.f13999s;
        this.f13999s = i13 + 1;
        bArr2[i13] = b10;
    }

    public final void z1(int i10, int i11, String str) {
        char cCharAt;
        int i12 = i11 + i10;
        int i13 = this.f13999s;
        byte[] bArr = this.r;
        int[] iArr = this.f13975k;
        while (i10 < i12 && (cCharAt = str.charAt(i10)) <= 127 && iArr[cCharAt] == 0) {
            bArr[i13] = (byte) cCharAt;
            i10++;
            i13++;
        }
        this.f13999s = i13;
        if (i10 < i12) {
            int i14 = this.f13976l;
            int i15 = this.f14000t;
            if (i14 == 0) {
                if (((i12 - i10) * 6) + i13 > i15) {
                    p1();
                }
                int iQ1 = this.f13999s;
                byte[] bArr2 = this.r;
                int[] iArr2 = this.f13975k;
                while (i10 < i12) {
                    int i16 = i10 + 1;
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 <= 127) {
                        int i17 = iArr2[cCharAt2];
                        if (i17 == 0) {
                            bArr2[iQ1] = (byte) cCharAt2;
                            i10 = i16;
                            iQ1++;
                        } else if (i17 > 0) {
                            int i18 = iQ1 + 1;
                            bArr2[iQ1] = 92;
                            iQ1 += 2;
                            bArr2[i18] = (byte) i17;
                        } else {
                            iQ1 = w1(cCharAt2, iQ1);
                        }
                    } else if (cCharAt2 <= 2047) {
                        int i19 = iQ1 + 1;
                        bArr2[iQ1] = (byte) ((cCharAt2 >> 6) | 192);
                        iQ1 += 2;
                        bArr2[i19] = (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH);
                    } else {
                        iQ1 = q1(cCharAt2, iQ1);
                    }
                    i10 = i16;
                }
                this.f13999s = iQ1;
                return;
            }
            if (((i12 - i10) * 6) + i13 > i15) {
                p1();
            }
            int iQ12 = this.f13999s;
            byte[] bArr3 = this.r;
            int[] iArr3 = this.f13975k;
            int i20 = this.f13976l;
            while (i10 < i12) {
                int i21 = i10 + 1;
                char cCharAt3 = str.charAt(i10);
                if (cCharAt3 <= 127) {
                    int i22 = iArr3[cCharAt3];
                    if (i22 == 0) {
                        bArr3[iQ12] = (byte) cCharAt3;
                        i10 = i21;
                        iQ12++;
                    } else if (i22 > 0) {
                        int i23 = iQ12 + 1;
                        bArr3[iQ12] = 92;
                        iQ12 += 2;
                        bArr3[i23] = (byte) i22;
                    } else {
                        iQ12 = w1(cCharAt3, iQ12);
                    }
                } else if (cCharAt3 > i20) {
                    iQ12 = w1(cCharAt3, iQ12);
                } else if (cCharAt3 <= 2047) {
                    int i24 = iQ12 + 1;
                    bArr3[iQ12] = (byte) ((cCharAt3 >> 6) | 192);
                    iQ12 += 2;
                    bArr3[i24] = (byte) ((cCharAt3 & '?') | TraceIdKeys.MAX_LENGTH);
                } else {
                    iQ12 = q1(cCharAt3, iQ12);
                }
                i10 = i21;
            }
            this.f13999s = iQ12;
        }
    }
}
