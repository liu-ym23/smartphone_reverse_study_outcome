package y2;

import a3.i;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicReference;
import z2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends w2.b {
    public static final int Z = JsonParser.Feature.ALLOW_TRAILING_COMMA.f3573b;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f13990a0 = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.f3573b;
    public static final int b0 = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.f3573b;
    public static final int c0 = JsonParser.Feature.ALLOW_MISSING_VALUES.f3573b;

    /* renamed from: d0, reason: collision with root package name */
    public static final int f13991d0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.f3573b;

    /* renamed from: e0, reason: collision with root package name */
    public static final int f13992e0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.f3573b;

    /* renamed from: f0, reason: collision with root package name */
    public static final int f13993f0 = JsonParser.Feature.ALLOW_COMMENTS.f3573b;

    /* renamed from: g0, reason: collision with root package name */
    public static final int f13994g0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.f3573b;

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f13995h0 = x2.a.f13705c;
    public Reader P;
    public char[] Q;
    public final boolean R;
    public final v2.c S;
    public final z2.b T;
    public final int U;
    public boolean V;
    public long W;
    public int X;
    public int Y;

    public e(x2.b bVar, int i10, v2.c cVar, z2.b bVar2, char[] cArr, int i11) {
        super(bVar, i10);
        this.P = null;
        this.Q = cArr;
        this.r = 0;
        this.f13561s = i11;
        this.S = cVar;
        this.T = bVar2;
        this.U = bVar2.f14241c;
        this.R = true;
    }

    public final int A2() {
        int i10 = this.r;
        if (i10 + 4 >= this.f13561s) {
            return B2(false);
        }
        char[] cArr = this.Q;
        char c9 = cArr[i10];
        if (c9 == ':') {
            int i11 = i10 + 1;
            this.r = i11;
            char c10 = cArr[i11];
            if (c10 > ' ') {
                if (c10 == '/' || c10 == '#') {
                    return B2(true);
                }
                this.r = i10 + 2;
                return c10;
            }
            if (c10 == ' ' || c10 == '\t') {
                int i12 = i10 + 2;
                this.r = i12;
                char c11 = cArr[i12];
                if (c11 > ' ') {
                    if (c11 == '/' || c11 == '#') {
                        return B2(true);
                    }
                    this.r = i10 + 3;
                    return c11;
                }
            }
            return B2(true);
        }
        if (c9 == ' ' || c9 == '\t') {
            int i13 = i10 + 1;
            this.r = i13;
            c9 = cArr[i13];
        }
        if (c9 != ':') {
            return B2(false);
        }
        int i14 = this.r;
        int i15 = i14 + 1;
        this.r = i15;
        char c12 = cArr[i15];
        if (c12 > ' ') {
            if (c12 == '/' || c12 == '#') {
                return B2(true);
            }
            this.r = i14 + 2;
            return c12;
        }
        if (c12 == ' ' || c12 == '\t') {
            int i16 = i14 + 2;
            this.r = i16;
            char c13 = cArr[i16];
            if (c13 > ' ') {
                if (c13 == '/' || c13 == '#') {
                    return B2(true);
                }
                this.r = i14 + 3;
                return c13;
            }
        }
        return B2(true);
    }

    public final int B2(boolean z) {
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                C1(" within/between " + this.z.h() + " entries");
                throw null;
            }
            char[] cArr = this.Q;
            int i10 = this.r;
            int i11 = i10 + 1;
            this.r = i11;
            char c9 = cArr[i10];
            if (c9 > ' ') {
                if (c9 == '/') {
                    D2();
                } else if (c9 == '#' && (this.f3558a & f13994g0) != 0) {
                    E2();
                } else {
                    if (z) {
                        return c9;
                    }
                    if (c9 != ':') {
                        E1(c9, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z = true;
                }
            } else if (c9 >= ' ') {
                continue;
            } else if (c9 == '\n') {
                this.f13563u++;
                this.f13564v = i11;
            } else if (c9 == '\r') {
                z2();
            } else if (c9 != '\t') {
                F1(c9);
                throw null;
            }
        }
    }

    public final int C2(int i10) {
        if (i10 != 44) {
            E1(i10, "was expecting comma to separate " + this.z.h() + " entries");
            throw null;
        }
        while (true) {
            int i11 = this.r;
            if (i11 >= this.f13561s) {
                return y2();
            }
            char[] cArr = this.Q;
            int i12 = i11 + 1;
            this.r = i12;
            char c9 = cArr[i11];
            if (c9 > ' ') {
                if (c9 != '/' && c9 != '#') {
                    return c9;
                }
                this.r = i11;
                return y2();
            }
            if (c9 < ' ') {
                if (c9 == '\n') {
                    this.f13563u++;
                    this.f13564v = i12;
                } else if (c9 == '\r') {
                    z2();
                } else if (c9 != '\t') {
                    F1(c9);
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        C1(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D2() {
        /*
            r7 = this;
            int r0 = r7.f3558a
            int r1 = y2.e.f13993f0
            r0 = r0 & r1
            r1 = 0
            r2 = 47
            if (r0 == 0) goto L8f
            int r0 = r7.r
            int r3 = r7.f13561s
            java.lang.String r4 = " in a comment"
            if (r0 < r3) goto L1d
            boolean r0 = r7.i2()
            if (r0 == 0) goto L19
            goto L1d
        L19:
            r7.C1(r4)
            throw r1
        L1d:
            char[] r0 = r7.Q
            int r3 = r7.r
            int r5 = r3 + 1
            r7.r = r5
            char r0 = r0[r3]
            if (r0 != r2) goto L2d
            r7.E2()
            return
        L2d:
            r3 = 42
            if (r0 != r3) goto L89
        L31:
            int r0 = r7.r
            int r5 = r7.f13561s
            if (r0 < r5) goto L3d
            boolean r0 = r7.i2()
            if (r0 == 0) goto L56
        L3d:
            char[] r0 = r7.Q
            int r5 = r7.r
            int r6 = r5 + 1
            r7.r = r6
            char r0 = r0[r5]
            if (r0 > r3) goto L31
            if (r0 != r3) goto L67
            int r0 = r7.f13561s
            if (r6 < r0) goto L5a
            boolean r0 = r7.i2()
            if (r0 == 0) goto L56
            goto L5a
        L56:
            r7.C1(r4)
            throw r1
        L5a:
            char[] r0 = r7.Q
            int r5 = r7.r
            char r0 = r0[r5]
            if (r0 != r2) goto L31
            int r5 = r5 + 1
            r7.r = r5
            return
        L67:
            r5 = 32
            if (r0 >= r5) goto L31
            r5 = 10
            if (r0 != r5) goto L78
            int r0 = r7.f13563u
            int r0 = r0 + 1
            r7.f13563u = r0
            r7.f13564v = r6
            goto L31
        L78:
            r5 = 13
            if (r0 != r5) goto L80
            r7.z2()
            goto L31
        L80:
            r5 = 9
            if (r0 != r5) goto L85
            goto L31
        L85:
            r7.F1(r0)
            throw r1
        L89:
            java.lang.String r2 = "was expecting either '*' or '/' for a comment"
            r7.E1(r0, r2)
            throw r1
        L8f:
            java.lang.String r0 = "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)"
            r7.E1(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.D2():void");
    }

    public final void E2() {
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                return;
            }
            char[] cArr = this.Q;
            int i10 = this.r;
            int i11 = i10 + 1;
            this.r = i11;
            char c9 = cArr[i10];
            if (c9 < ' ') {
                if (c9 == '\n') {
                    this.f13563u++;
                    this.f13564v = i11;
                    return;
                } else if (c9 == '\r') {
                    z2();
                    return;
                } else if (c9 != '\t') {
                    F1(c9);
                    throw null;
                }
            }
        }
    }

    public final void F2() {
        this.V = false;
        int i10 = this.r;
        int i11 = this.f13561s;
        char[] cArr = this.Q;
        while (true) {
            if (i10 >= i11) {
                this.r = i10;
                if (!i2()) {
                    JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                    C1(": was expecting closing quote for a string value");
                    throw null;
                }
                i10 = this.r;
                i11 = this.f13561s;
            }
            int i12 = i10 + 1;
            char c9 = cArr[i10];
            if (c9 <= '\\') {
                if (c9 == '\\') {
                    this.r = i12;
                    N1();
                    i10 = this.r;
                    i11 = this.f13561s;
                } else if (c9 <= '\"') {
                    if (c9 == '\"') {
                        this.r = i12;
                        return;
                    } else if (c9 < ' ') {
                        this.r = i12;
                        V1(c9, "string value");
                    }
                }
            }
            i10 = i12;
        }
    }

    public final int G2() {
        if (this.r >= this.f13561s && !i2()) {
            x1();
            return -1;
        }
        char[] cArr = this.Q;
        int i10 = this.r;
        int i11 = i10 + 1;
        this.r = i11;
        char c9 = cArr[i10];
        if (c9 > ' ') {
            if (c9 != '/' && c9 != '#') {
                return c9;
            }
            this.r = i10;
            return H2();
        }
        if (c9 != ' ') {
            if (c9 == '\n') {
                this.f13563u++;
                this.f13564v = i11;
            } else if (c9 == '\r') {
                z2();
            } else if (c9 != '\t') {
                F1(c9);
                throw null;
            }
        }
        while (true) {
            int i12 = this.r;
            if (i12 >= this.f13561s) {
                return H2();
            }
            char[] cArr2 = this.Q;
            int i13 = i12 + 1;
            this.r = i13;
            char c10 = cArr2[i12];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    return c10;
                }
                this.r = i12;
                return H2();
            }
            if (c10 != ' ') {
                if (c10 == '\n') {
                    this.f13563u++;
                    this.f13564v = i13;
                } else if (c10 == '\r') {
                    z2();
                } else if (c10 != '\t') {
                    F1(c10);
                    throw null;
                }
            }
        }
    }

    public final int H2() {
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                x1();
                return -1;
            }
            char[] cArr = this.Q;
            int i10 = this.r;
            int i11 = i10 + 1;
            this.r = i11;
            char c9 = cArr[i10];
            if (c9 > ' ') {
                if (c9 == '/') {
                    D2();
                } else {
                    if (c9 != '#') {
                        return c9;
                    }
                    if ((this.f3558a & f13994g0) == 0) {
                        return c9;
                    }
                    E2();
                }
            } else if (c9 == ' ') {
                continue;
            } else if (c9 == '\n') {
                this.f13563u++;
                this.f13564v = i11;
            } else if (c9 == '\r') {
                z2();
            } else if (c9 != '\t') {
                F1(c9);
                throw null;
            }
        }
    }

    public final void I2() {
        int i10 = this.r;
        this.f13565w = this.f13562t + i10;
        this.f13566x = this.f13563u;
        this.f13567y = i10 - this.f13564v;
    }

    public final void J2(int i10) {
        int i11 = this.r + 1;
        this.r = i11;
        if (i10 != 9) {
            if (i10 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i10 == 13) {
                z2();
            } else {
                if (i10 == 32) {
                    return;
                }
                E1(i10, "Expected space separating root-level values");
                throw null;
            }
        }
    }

    @Override // w2.b
    public final void K1() throws IOException {
        if (this.P != null) {
            if (this.f13559p.f13715c || JsonParser.Feature.AUTO_CLOSE_SOURCE.a(this.f3558a)) {
                this.P.close();
            }
            this.P = null;
        }
    }

    public final char K2(String str) {
        if (this.r >= this.f13561s && !i2()) {
            C1(str);
            throw null;
        }
        char[] cArr = this.Q;
        int i10 = this.r;
        this.r = i10 + 1;
        return cArr[i10];
    }

    @Override // w2.b
    public final char N1() {
        if (this.r >= this.f13561s && !i2()) {
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            C1(" in character escape sequence");
            throw null;
        }
        char[] cArr = this.Q;
        int i10 = this.r;
        this.r = i10 + 1;
        char c9 = cArr[i10];
        if (c9 == '\"' || c9 == '/' || c9 == '\\') {
            return c9;
        }
        if (c9 == 'b') {
            return '\b';
        }
        if (c9 == 'f') {
            return '\f';
        }
        if (c9 == 'n') {
            return '\n';
        }
        if (c9 == 'r') {
            return '\r';
        }
        if (c9 == 't') {
            return '\t';
        }
        if (c9 != 'u') {
            Q1(c9);
            return c9;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            if (this.r >= this.f13561s && !i2()) {
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                C1(" in character escape sequence");
                throw null;
            }
            char[] cArr2 = this.Q;
            int i13 = this.r;
            this.r = i13 + 1;
            char c10 = cArr2[i13];
            int i14 = x2.a.f13710i[c10 & 255];
            if (i14 < 0) {
                E1(c10, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i11 = (i11 << 4) | i14;
        }
        return (char) i11;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final byte[] S(Base64Variant base64Variant) throws JsonParseException {
        byte[] bArr;
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == JsonToken.VALUE_EMBEDDED_OBJECT && (bArr = this.F) != null) {
            return bArr;
        }
        if (jsonToken != JsonToken.VALUE_STRING) {
            A1("Current token (" + this.f13576c + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
            throw null;
        }
        if (this.V) {
            try {
                this.F = d2(base64Variant);
                this.V = false;
            } catch (IllegalArgumentException e10) {
                throw new JsonParseException(this, "Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e10.getMessage());
            }
        } else if (this.F == null) {
            a3.c cVarO1 = O1();
            try {
                base64Variant.b(V0(), cVarO1);
                this.F = cVarO1.P();
            } catch (IllegalArgumentException e11) {
                A1(e11.getMessage());
                throw null;
            }
        }
        return this.F;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final a3.f<StreamReadCapability> T0() {
        return w2.b.O;
    }

    @Override // w2.b
    public final void T1() {
        char[] cArr;
        z2.b bVar;
        this.B.n();
        char[] cArr2 = this.C;
        x2.b bVar2 = this.f13559p;
        if (cArr2 != null) {
            this.C = null;
            char[] cArr3 = bVar2.f13721j;
            if (cArr2 != cArr3 && cArr2.length < cArr3.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            bVar2.f13721j = null;
            bVar2.f13716d.f11b.set(3, cArr2);
        }
        z2.b bVar3 = this.T;
        if (!bVar3.f14249l && (bVar = bVar3.f14239a) != null && bVar3.f14243e) {
            b.C0180b c0180b = new b.C0180b(bVar3);
            AtomicReference<b.C0180b> atomicReference = bVar.f14240b;
            b.C0180b c0180b2 = atomicReference.get();
            int i10 = c0180b2.f14254a;
            int i11 = c0180b.f14254a;
            if (i11 != i10) {
                if (i11 > 12000) {
                    c0180b = new b.C0180b(new String[64], new b.a[32]);
                }
                while (!atomicReference.compareAndSet(c0180b2, c0180b) && atomicReference.get() == c0180b2) {
                }
            }
            bVar3.f14249l = true;
        }
        if (!this.R || (cArr = this.Q) == null) {
            return;
        }
        this.Q = null;
        char[] cArr4 = bVar2.h;
        if (cArr != cArr4 && cArr.length < cArr4.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        bVar2.h = null;
        bVar2.f13716d.f11b.set(0, cArr);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String V0() {
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.VALUE_STRING;
        i iVar = this.B;
        if (jsonToken == jsonToken2) {
            if (this.V) {
                this.V = false;
                e2();
            }
            return iVar.h();
        }
        if (jsonToken == null) {
            return null;
        }
        int i10 = jsonToken.f3597d;
        return i10 != 5 ? (i10 == 6 || i10 == 7 || i10 == 8) ? iVar.h() : jsonToken.f3594a : this.z.f13982f;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final char[] W0() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == null) {
            return null;
        }
        int i10 = jsonToken.f3597d;
        if (i10 != 5) {
            if (i10 != 6) {
                if (i10 != 7 && i10 != 8) {
                    return jsonToken.f3595b;
                }
            } else if (this.V) {
                this.V = false;
                e2();
            }
            return this.B.m();
        }
        if (!this.D) {
            String str = this.z.f13982f;
            int length = str.length();
            char[] cArr = this.C;
            if (cArr == null) {
                x2.b bVar = this.f13559p;
                x2.b.a(bVar.f13721j);
                char[] cArrB = bVar.f13716d.b(3, length);
                bVar.f13721j = cArrB;
                this.C = cArrB;
            } else if (cArr.length < length) {
                this.C = new char[length];
            }
            str.getChars(0, length, this.C, 0);
            this.D = true;
        }
        return this.C;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int X0() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken == null) {
            return 0;
        }
        int i10 = jsonToken.f3597d;
        if (i10 == 5) {
            return this.z.f13982f.length();
        }
        if (i10 != 6) {
            if (i10 != 7 && i10 != 8) {
                return jsonToken.f3595b.length;
            }
        } else if (this.V) {
            this.V = false;
            e2();
        }
        return this.B.p();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int Y0() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != null) {
            int i10 = jsonToken.f3597d;
            if (i10 != 6) {
                if (i10 == 7 || i10 == 8) {
                }
            } else if (this.V) {
                this.V = false;
                e2();
            }
            int i11 = this.B.f26c;
            if (i11 >= 0) {
                return i11;
            }
        }
        return 0;
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final JsonLocation Z0() {
        if (this.f13576c != JsonToken.FIELD_NAME) {
            Object objP1 = P1();
            return new JsonLocation(this.f13566x, -1L, this.f13565w - 1, this.f13567y, objP1);
        }
        return new JsonLocation(this.X, -1L, (this.W - 1) + this.f13562t, this.Y, P1());
    }

    public final void c2(int i10) {
        if (i10 == 93) {
            I2();
            if (!this.z.d()) {
                U1('}', i10);
                throw null;
            }
            c cVar = this.z;
            cVar.f13983g = null;
            this.z = cVar.f13979c;
            this.f13576c = JsonToken.END_ARRAY;
        }
        if (i10 == 125) {
            I2();
            if (!this.z.e()) {
                U1(']', i10);
                throw null;
            }
            c cVar2 = this.z;
            cVar2.f13983g = null;
            this.z = cVar2.f13979c;
            this.f13576c = JsonToken.END_OBJECT;
        }
    }

    public final byte[] d2(Base64Variant base64Variant) {
        a3.c cVarO1 = O1();
        while (true) {
            if (this.r >= this.f13561s) {
                j2();
            }
            char[] cArr = this.Q;
            int i10 = this.r;
            this.r = i10 + 1;
            char c9 = cArr[i10];
            if (c9 > ' ') {
                int iC = base64Variant.c(c9);
                char c10 = base64Variant.f3509e;
                boolean z = base64Variant.f3510j;
                if (iC < 0) {
                    if (c9 == '\"') {
                        return cVarO1.P();
                    }
                    iC = L1(base64Variant, c9, 0);
                    if (iC < 0) {
                        continue;
                    }
                }
                if (this.r >= this.f13561s) {
                    j2();
                }
                char[] cArr2 = this.Q;
                int i11 = this.r;
                this.r = i11 + 1;
                char c11 = cArr2[i11];
                int iC2 = base64Variant.c(c11);
                if (iC2 < 0) {
                    iC2 = L1(base64Variant, c11, 1);
                }
                int i12 = (iC << 6) | iC2;
                if (this.r >= this.f13561s) {
                    j2();
                }
                char[] cArr3 = this.Q;
                int i13 = this.r;
                this.r = i13 + 1;
                char c12 = cArr3[i13];
                int iC3 = base64Variant.c(c12);
                if (iC3 < 0) {
                    if (iC3 != -2) {
                        if (c12 == '\"') {
                            cVarO1.o(i12 >> 4);
                            if (!z) {
                                return cVarO1.P();
                            }
                            this.r--;
                            A1(base64Variant.j());
                            throw null;
                        }
                        iC3 = L1(base64Variant, c12, 2);
                    }
                    if (iC3 == -2) {
                        if (this.r >= this.f13561s) {
                            j2();
                        }
                        char[] cArr4 = this.Q;
                        int i14 = this.r;
                        this.r = i14 + 1;
                        char c13 = cArr4[i14];
                        if (c13 != c10 && L1(base64Variant, c13, 3) != -2) {
                            throw w2.b.Z1(base64Variant, c13, 3, "expected padding character '" + c10 + "'");
                        }
                        cVarO1.o(i12 >> 4);
                    }
                }
                int i15 = (i12 << 6) | iC3;
                if (this.r >= this.f13561s) {
                    j2();
                }
                char[] cArr5 = this.Q;
                int i16 = this.r;
                this.r = i16 + 1;
                char c14 = cArr5[i16];
                int iC4 = base64Variant.c(c14);
                if (iC4 < 0) {
                    if (iC4 != -2) {
                        if (c14 == '\"') {
                            cVarO1.C(i15 >> 2);
                            if (!z) {
                                return cVarO1.P();
                            }
                            this.r--;
                            A1(base64Variant.j());
                            throw null;
                        }
                        iC4 = L1(base64Variant, c14, 3);
                    }
                    if (iC4 == -2) {
                        cVarO1.C(i15 >> 2);
                    }
                }
                cVarO1.w((i15 << 6) | iC4);
            }
        }
    }

    public final void e2() {
        int i10 = this.r;
        int i11 = this.f13561s;
        int[] iArr = f13995h0;
        i iVar = this.B;
        if (i10 < i11) {
            int length = iArr.length;
            while (true) {
                char[] cArr = this.Q;
                char c9 = cArr[i10];
                if (c9 >= length || iArr[c9] == 0) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                } else if (c9 == '\"') {
                    int i12 = this.r;
                    iVar.o(cArr, i12, i10 - i12);
                    this.r = i10 + 1;
                    return;
                }
            }
        }
        char[] cArr2 = this.Q;
        int i13 = this.r;
        int i14 = i10 - i13;
        iVar.f25b = null;
        iVar.f26c = -1;
        iVar.f27d = 0;
        iVar.f32j = null;
        iVar.f33k = null;
        if (iVar.f29f) {
            iVar.d();
        } else if (iVar.h == null) {
            iVar.h = iVar.c(i14);
        }
        iVar.f30g = 0;
        iVar.f31i = 0;
        iVar.b(cArr2, i13, i14);
        this.r = i10;
        char[] cArrL = iVar.l();
        int i15 = iVar.f31i;
        int length2 = iArr.length;
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                C1(": was expecting closing quote for a string value");
                throw null;
            }
            char[] cArr3 = this.Q;
            int i16 = this.r;
            this.r = i16 + 1;
            char cN1 = cArr3[i16];
            if (cN1 < length2 && iArr[cN1] != 0) {
                if (cN1 == '\"') {
                    iVar.f31i = i15;
                    return;
                } else if (cN1 == '\\') {
                    cN1 = N1();
                } else if (cN1 < ' ') {
                    V1(cN1, "string value");
                }
            }
            if (i15 >= cArrL.length) {
                cArrL = iVar.k();
                i15 = 0;
            }
            cArrL[i15] = cN1;
            i15++;
        }
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final String f1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? C0() : super.g1();
        }
        if (this.V) {
            this.V = false;
            e2();
        }
        return this.B.h();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r11v0 ??, r11v1 ??, r11v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final com.fasterxml.jackson.core.JsonToken f2(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r11v0 ??, r11v1 ??, r11v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    @Override // com.fasterxml.jackson.core.JsonParser
    public final v2.c g0() {
        return this.S;
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final String g1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? C0() : super.g1();
        }
        if (this.V) {
            this.V = false;
            e2();
        }
        return this.B.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g2(int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.g2(int):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.core.JsonToken h2(int r9) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.h2(int):com.fasterxml.jackson.core.JsonToken");
    }

    public final boolean i2() throws IOException {
        Reader reader = this.P;
        if (reader != null) {
            char[] cArr = this.Q;
            int i10 = reader.read(cArr, 0, cArr.length);
            if (i10 > 0) {
                int i11 = this.f13561s;
                long j10 = i11;
                this.f13562t += j10;
                this.f13564v -= i11;
                this.W -= j10;
                this.r = 0;
                this.f13561s = i10;
                return true;
            }
            K1();
            if (i10 == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f13561s);
            }
        }
        return false;
    }

    public final void j2() {
        if (i2()) {
            return;
        }
        B1();
        throw null;
    }

    public final void k2() throws JsonParseException {
        int i10;
        char c9;
        int i11 = this.r;
        if (i11 + 4 < this.f13561s) {
            char[] cArr = this.Q;
            if (cArr[i11] == 'a' && cArr[i11 + 1] == 'l' && cArr[i11 + 2] == 's' && cArr[i11 + 3] == 'e' && ((c9 = cArr[(i10 = i11 + 4)]) < '0' || c9 == ']' || c9 == '}')) {
                this.r = i10;
                return;
            }
        }
        m2(1, "false");
    }

    public final void l2() throws JsonParseException {
        int i10;
        char c9;
        int i11 = this.r;
        if (i11 + 3 < this.f13561s) {
            char[] cArr = this.Q;
            if (cArr[i11] == 'u' && cArr[i11 + 1] == 'l' && cArr[i11 + 2] == 'l' && ((c9 = cArr[(i10 = i11 + 3)]) < '0' || c9 == ']' || c9 == '}')) {
                this.r = i10;
                return;
            }
        }
        m2(1, "null");
    }

    public final void m2(int i10, String str) throws JsonParseException {
        int i11;
        char c9;
        int length = str.length();
        if (this.r + length < this.f13561s) {
            while (this.Q[this.r] == str.charAt(i10)) {
                int i12 = this.r + 1;
                this.r = i12;
                i10++;
                if (i10 >= length) {
                    char c10 = this.Q[i12];
                    if (c10 < '0' || c10 == ']' || c10 == '}' || !Character.isJavaIdentifierPart(c10)) {
                        return;
                    }
                    x2(str.substring(0, i10), W1());
                    throw null;
                }
            }
            x2(str.substring(0, i10), W1());
            throw null;
        }
        int length2 = str.length();
        do {
            if ((this.r >= this.f13561s && !i2()) || this.Q[this.r] != str.charAt(i10)) {
                x2(str.substring(0, i10), W1());
                throw null;
            }
            i11 = this.r + 1;
            this.r = i11;
            i10++;
        } while (i10 < length2);
        if ((i11 < this.f13561s || i2()) && (c9 = this.Q[this.r]) >= '0' && c9 != ']' && c9 != '}' && Character.isJavaIdentifierPart(c9)) {
            x2(str.substring(0, i10), W1());
            throw null;
        }
    }

    public final void n2() throws JsonParseException {
        int i10;
        char c9;
        int i11 = this.r;
        if (i11 + 3 < this.f13561s) {
            char[] cArr = this.Q;
            if (cArr[i11] == 'r' && cArr[i11 + 1] == 'u' && cArr[i11 + 2] == 'e' && ((c9 = cArr[(i10 = i11 + 3)]) < '0' || c9 == ']' || c9 == '}')) {
                this.r = i10;
                return;
            }
        }
        m2(1, "true");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String o1() throws JsonParseException {
        JsonToken jsonTokenT2;
        this.G = 0;
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            o2();
            return null;
        }
        if (this.V) {
            F2();
        }
        int iG2 = G2();
        if (iG2 < 0) {
            close();
            this.f13576c = null;
            return null;
        }
        this.F = null;
        if (iG2 == 93 || iG2 == 125) {
            c2(iG2);
            return null;
        }
        if (this.z.k()) {
            iG2 = C2(iG2);
            if ((this.f3558a & Z) != 0 && (iG2 == 93 || iG2 == 125)) {
                c2(iG2);
                return null;
            }
        }
        if (this.z.e()) {
            int i10 = this.r;
            this.W = i10;
            this.X = this.f13563u;
            this.Y = i10 - this.f13564v;
            String strR2 = iG2 == 34 ? r2() : g2(iG2);
            this.z.l(strR2);
            this.f13576c = jsonToken2;
            int iA2 = A2();
            I2();
            if (iA2 == 34) {
                this.V = true;
                this.A = JsonToken.VALUE_STRING;
                return strR2;
            }
            if (iA2 == 45) {
                jsonTokenT2 = t2();
            } else if (iA2 == 46) {
                jsonTokenT2 = q2();
            } else if (iA2 == 91) {
                jsonTokenT2 = JsonToken.START_ARRAY;
            } else if (iA2 == 102) {
                k2();
                jsonTokenT2 = JsonToken.VALUE_FALSE;
            } else if (iA2 == 110) {
                l2();
                jsonTokenT2 = JsonToken.VALUE_NULL;
            } else if (iA2 == 116) {
                n2();
                jsonTokenT2 = JsonToken.VALUE_TRUE;
            } else if (iA2 != 123) {
                switch (iA2) {
                    case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                    case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                    case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                    case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                    case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                    case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        jsonTokenT2 = v2(iA2);
                        break;
                    default:
                        jsonTokenT2 = h2(iA2);
                        break;
                }
            } else {
                jsonTokenT2 = JsonToken.START_OBJECT;
            }
            this.A = jsonTokenT2;
            return strR2;
        }
        I2();
        if (iG2 == 34) {
            this.V = true;
            this.f13576c = JsonToken.VALUE_STRING;
            return null;
        }
        if (iG2 == 91) {
            this.z = this.z.i(this.f13566x, this.f13567y);
            this.f13576c = JsonToken.START_ARRAY;
            return null;
        }
        if (iG2 == 102) {
            m2(1, "false");
            this.f13576c = JsonToken.VALUE_FALSE;
            return null;
        }
        if (iG2 == 110) {
            m2(1, "null");
            this.f13576c = JsonToken.VALUE_NULL;
            return null;
        }
        if (iG2 == 116) {
            m2(1, "true");
            this.f13576c = JsonToken.VALUE_TRUE;
            return null;
        }
        if (iG2 == 123) {
            this.z = this.z.j(this.f13566x, this.f13567y);
            this.f13576c = JsonToken.START_OBJECT;
            return null;
        }
        switch (iG2) {
            case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                if (!this.z.f() && (this.f3558a & c0) != 0) {
                    this.r--;
                    this.f13576c = JsonToken.VALUE_NULL;
                    return null;
                }
                break;
            case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                this.f13576c = t2();
                return null;
            case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                this.f13576c = q2();
                return null;
            default:
                switch (iG2) {
                    case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                    case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                    case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                    case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                    case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                    case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        this.f13576c = v2(iG2);
                        break;
                }
                return null;
        }
        this.f13576c = h2(iG2);
        return null;
    }

    public final JsonToken o2() {
        this.D = false;
        JsonToken jsonToken = this.A;
        this.A = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.z = this.z.i(this.f13566x, this.f13567y);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.z = this.z.j(this.f13566x, this.f13567y);
        }
        this.f13576c = jsonToken;
        return jsonToken;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String p1() {
        if (this.f13576c == JsonToken.FIELD_NAME) {
            this.D = false;
            JsonToken jsonToken = this.A;
            this.A = null;
            this.f13576c = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this.V) {
                    this.V = false;
                    e2();
                }
                return this.B.h();
            }
            if (jsonToken == JsonToken.START_ARRAY) {
                this.z = this.z.i(this.f13566x, this.f13567y);
                return null;
            }
            if (jsonToken == JsonToken.START_OBJECT) {
                this.z = this.z.j(this.f13566x, this.f13567y);
                return null;
            }
        } else if (q1() == JsonToken.VALUE_STRING) {
            return V0();
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v14 ??, r9v9 ??, r9v5 ??, r9v4 ??, r9v3 ??, r9v8 ??, r9v7 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public final com.fasterxml.jackson.core.JsonToken p2(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v14 ??, r9v9 ??, r9v5 ??, r9v4 ??, r9v3 ??, r9v8 ??, r9v7 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken q1() throws JsonParseException {
        JsonToken jsonTokenT2;
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return o2();
        }
        this.G = 0;
        if (this.V) {
            F2();
        }
        int iG2 = G2();
        if (iG2 < 0) {
            close();
            this.f13576c = null;
            return null;
        }
        this.F = null;
        if (iG2 == 93 || iG2 == 125) {
            c2(iG2);
            return this.f13576c;
        }
        if (this.z.k()) {
            iG2 = C2(iG2);
            if ((this.f3558a & Z) != 0 && (iG2 == 93 || iG2 == 125)) {
                c2(iG2);
                return this.f13576c;
            }
        }
        boolean zE = this.z.e();
        if (zE) {
            int i10 = this.r;
            this.W = i10;
            this.X = this.f13563u;
            this.Y = i10 - this.f13564v;
            this.z.l(iG2 == 34 ? r2() : g2(iG2));
            this.f13576c = jsonToken2;
            iG2 = A2();
        }
        I2();
        if (iG2 == 34) {
            this.V = true;
            jsonTokenT2 = JsonToken.VALUE_STRING;
        } else if (iG2 == 91) {
            if (!zE) {
                this.z = this.z.i(this.f13566x, this.f13567y);
            }
            jsonTokenT2 = JsonToken.START_ARRAY;
        } else if (iG2 == 102) {
            k2();
            jsonTokenT2 = JsonToken.VALUE_FALSE;
        } else if (iG2 == 110) {
            l2();
            jsonTokenT2 = JsonToken.VALUE_NULL;
        } else if (iG2 == 116) {
            n2();
            jsonTokenT2 = JsonToken.VALUE_TRUE;
        } else if (iG2 == 123) {
            if (!zE) {
                this.z = this.z.j(this.f13566x, this.f13567y);
            }
            jsonTokenT2 = JsonToken.START_OBJECT;
        } else {
            if (iG2 == 125) {
                E1(iG2, "expected a value");
                throw null;
            }
            if (iG2 == 45) {
                jsonTokenT2 = t2();
            } else if (iG2 != 46) {
                switch (iG2) {
                    case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                    case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                    case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                    case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                    case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                    case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        jsonTokenT2 = v2(iG2);
                        break;
                    default:
                        jsonTokenT2 = h2(iG2);
                        break;
                }
            } else {
                jsonTokenT2 = q2();
            }
        }
        if (zE) {
            this.A = jsonTokenT2;
            return this.f13576c;
        }
        this.f13576c = jsonTokenT2;
        return jsonTokenT2;
    }

    public final JsonToken q2() {
        if (!JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.f3618b.a(this.f3558a)) {
            return h2(46);
        }
        int i10 = this.r;
        return p2(46, i10 - 1, i10, 0, false);
    }

    public final String r2() {
        int i10 = this.r;
        int i11 = this.U;
        while (true) {
            if (i10 >= this.f13561s) {
                break;
            }
            char[] cArr = this.Q;
            char c9 = cArr[i10];
            int[] iArr = f13995h0;
            if (c9 >= iArr.length || iArr[c9] == 0) {
                i11 = (i11 * 33) + c9;
                i10++;
            } else if (c9 == '\"') {
                int i12 = this.r;
                this.r = i10 + 1;
                return this.T.b(i12, i10 - i12, i11, cArr);
            }
        }
        int i13 = this.r;
        this.r = i10;
        return s2(i13, i11, 34);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int s1(Base64Variant base64Variant, q3.f fVar) throws IOException {
        if (!this.V || this.f13576c != JsonToken.VALUE_STRING) {
            byte[] bArrS = S(base64Variant);
            fVar.write(bArrS);
            return bArrS.length;
        }
        x2.b bVar = this.f13559p;
        byte[] bArrB = bVar.b();
        try {
            return w2(base64Variant, fVar, bArrB);
        } finally {
            bVar.c(bArrB);
        }
    }

    public final String s2(int i10, int i11, int i12) {
        char[] cArr = this.Q;
        int i13 = this.r - i10;
        i iVar = this.B;
        iVar.o(cArr, i10, i13);
        char[] cArrL = iVar.l();
        int i14 = iVar.f31i;
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                C1(" in field name");
                throw null;
            }
            char[] cArr2 = this.Q;
            int i15 = this.r;
            this.r = i15 + 1;
            char cN1 = cArr2[i15];
            if (cN1 <= '\\') {
                if (cN1 == '\\') {
                    cN1 = N1();
                } else if (cN1 <= i12) {
                    if (cN1 == i12) {
                        iVar.f31i = i14;
                        char[] cArrM = iVar.m();
                        int i16 = iVar.f26c;
                        return this.T.b(i16 >= 0 ? i16 : 0, iVar.p(), i11, cArrM);
                    }
                    if (cN1 < ' ') {
                        V1(cN1, "name");
                    }
                }
            }
            i11 = (i11 * 33) + cN1;
            int i17 = i14 + 1;
            cArrL[i14] = cN1;
            if (i17 >= cArrL.length) {
                cArrL = iVar.k();
                i14 = 0;
            } else {
                i14 = i17;
            }
        }
    }

    public final JsonToken t2() {
        int i10 = this.r;
        int i11 = i10 - 1;
        int i12 = this.f13561s;
        if (i10 >= i12) {
            return u2(i11, true);
        }
        int i13 = i10 + 1;
        char c9 = this.Q[i10];
        char c10 = '9';
        if (c9 > '9' || c9 < '0') {
            this.r = i13;
            return f2(c9, true);
        }
        if (c9 == '0') {
            return u2(i11, true);
        }
        int i14 = 1;
        while (i13 < i12) {
            char c11 = c10;
            int i15 = i13 + 1;
            char c12 = this.Q[i13];
            if (c12 < '0' || c12 > c11) {
                if (c12 == '.' || c12 == 'e' || c12 == 'E') {
                    this.r = i15;
                    return p2(c12, i11, i15, i14, true);
                }
                this.r = i13;
                if (this.z.f()) {
                    J2(c12);
                }
                this.B.o(this.Q, i11, i13 - i11);
                return b2(i14, true);
            }
            i14++;
            i13 = i15;
            c10 = c11;
        }
        return u2(i11, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[EDGE_INSN: B:21:0x004a->B:47:0x0090 BREAK  A[LOOP:0: B:34:0x006c->B:143:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.core.JsonToken u2(int r17, boolean r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.u2(int, boolean):com.fasterxml.jackson.core.JsonToken");
    }

    public final JsonToken v2(int i10) {
        int i11 = this.r;
        int i12 = i11 - 1;
        int i13 = this.f13561s;
        char c9 = '0';
        if (i10 == 48) {
            return u2(i12, false);
        }
        int i14 = 1;
        while (i11 < i13) {
            char c10 = c9;
            int i15 = i11 + 1;
            char c11 = this.Q[i11];
            if (c11 < c10 || c11 > '9') {
                if (c11 == '.' || c11 == 'e' || c11 == 'E') {
                    this.r = i15;
                    return p2(c11, i12, i15, i14, false);
                }
                this.r = i11;
                if (this.z.f()) {
                    J2(c11);
                }
                this.B.o(this.Q, i12, i11 - i12);
                return b2(i14, false);
            }
            i14++;
            i11 = i15;
            c9 = c10;
        }
        this.r = i12;
        return u2(i12, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0118, code lost:
    
        r18.V = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011a, code lost:
    
        if (r7 <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011c, code lost:
    
        r8 = r8 + r7;
        r20.write(r21, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0120, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [q3.f] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w2(com.fasterxml.jackson.core.Base64Variant r19, q3.f r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.w2(com.fasterxml.jackson.core.Base64Variant, q3.f, byte[]):int");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonLocation x0() {
        return new JsonLocation(this.f13563u, -1L, this.f13562t + this.r, (this.r - this.f13564v) + 1, P1());
    }

    public final void x2(String str, String str2) throws JsonParseException {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                break;
            }
            char c9 = this.Q[this.r];
            if (!Character.isJavaIdentifierPart(c9)) {
                break;
            }
            this.r++;
            sb2.append(c9);
            if (sb2.length() >= 256) {
                sb2.append("...");
                break;
            }
        }
        throw new JsonParseException(this, "Unrecognized token '" + ((Object) sb2) + "': was expecting " + str2);
    }

    public final int y2() throws JsonParseException {
        while (true) {
            if (this.r >= this.f13561s && !i2()) {
                throw new JsonParseException(this, "Unexpected end-of-input within/between " + this.z.h() + " entries");
            }
            char[] cArr = this.Q;
            int i10 = this.r;
            int i11 = i10 + 1;
            this.r = i11;
            char c9 = cArr[i10];
            if (c9 > ' ') {
                if (c9 == '/') {
                    D2();
                } else {
                    if (c9 != '#') {
                        return c9;
                    }
                    if ((this.f3558a & f13994g0) == 0) {
                        return c9;
                    }
                    E2();
                }
            } else if (c9 >= ' ') {
                continue;
            } else if (c9 == '\n') {
                this.f13563u++;
                this.f13564v = i11;
            } else if (c9 == '\r') {
                z2();
            } else if (c9 != '\t') {
                F1(c9);
                throw null;
            }
        }
    }

    public final void z2() {
        if (this.r < this.f13561s || i2()) {
            char[] cArr = this.Q;
            int i10 = this.r;
            if (cArr[i10] == '\n') {
                this.r = i10 + 1;
            }
        }
        this.f13563u++;
        this.f13564v = this.r;
    }

    public e(x2.b bVar, int i10, Reader reader, v2.c cVar, z2.b bVar2) {
        super(bVar, i10);
        this.P = reader;
        x2.b.a(bVar.h);
        char[] cArrB = bVar.f13716d.b(0, 0);
        bVar.h = cArrB;
        this.Q = cArrB;
        this.r = 0;
        this.f13561s = 0;
        this.S = cVar;
        this.T = bVar2;
        this.U = bVar2.f14241c;
        this.R = true;
    }
}
