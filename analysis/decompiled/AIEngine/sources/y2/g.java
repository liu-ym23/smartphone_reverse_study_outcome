package y2;

import a3.i;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import z2.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends w2.b {
    public static final int Y = JsonParser.Feature.ALLOW_TRAILING_COMMA.f3573b;
    public static final int Z = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.f3573b;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f14005a0 = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.f3573b;
    public static final int b0 = JsonParser.Feature.ALLOW_MISSING_VALUES.f3573b;
    public static final int c0 = JsonParser.Feature.ALLOW_SINGLE_QUOTES.f3573b;

    /* renamed from: d0, reason: collision with root package name */
    public static final int f14006d0 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.f3573b;

    /* renamed from: e0, reason: collision with root package name */
    public static final int f14007e0 = JsonParser.Feature.ALLOW_COMMENTS.f3573b;

    /* renamed from: f0, reason: collision with root package name */
    public static final int f14008f0 = JsonParser.Feature.ALLOW_YAML_COMMENTS.f3573b;

    /* renamed from: g0, reason: collision with root package name */
    public static final int[] f14009g0 = x2.a.f13706d;

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f14010h0 = x2.a.f13705c;
    public final v2.c P;
    public final z2.a Q;
    public int[] R;
    public boolean S;
    public int T;
    public int U;
    public int V;
    public byte[] W;
    public final boolean X;

    public g(x2.b bVar, int i10, v2.c cVar, z2.a aVar, byte[] bArr, int i11, int i12, int i13, boolean z) {
        super(bVar, i10);
        this.R = new int[16];
        this.P = cVar;
        this.Q = aVar;
        this.W = bArr;
        this.r = i11;
        this.f13561s = i12;
        this.f13564v = i11 - i13;
        this.f13562t = (-i11) + i13;
        this.X = z;
    }

    public static final int w2(int i10, int i11) {
        return i11 == 4 ? i10 : i10 | ((-1) << (i11 << 3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r9 == 46) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r9 == 101) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r9 != 69) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        r11.r = r8;
        r0.f31i = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        if (r11.z.f() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        Y2(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        return b2(r6, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        return x2(r2, r7, r9, true, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.core.JsonToken A2() {
        /*
            r11 = this;
            a3.i r0 = r11.B
            char[] r2 = r0.i()
            r1 = 45
            r3 = 0
            r2[r3] = r1
            int r1 = r11.r
            int r3 = r11.f13561s
            if (r1 >= r3) goto L90
            byte[] r3 = r11.W
            int r4 = r1 + 1
            r11.r = r4
            r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r3 = 57
            r4 = 48
            r5 = 1
            if (r1 > r4) goto L2e
            if (r1 == r4) goto L29
            com.fasterxml.jackson.core.JsonToken r11 = r11.n2(r1, r5)
            return r11
        L29:
            int r1 = r11.X2()
            goto L35
        L2e:
            if (r1 <= r3) goto L35
            com.fasterxml.jackson.core.JsonToken r11 = r11.n2(r1, r5)
            return r11
        L35:
            char r1 = (char) r1
            r2[r5] = r1
            int r1 = r11.f13561s
            int r6 = r11.r
            int r7 = r2.length
            int r6 = r6 + r7
            r7 = 2
            int r6 = r6 - r7
            int r1 = java.lang.Math.min(r1, r6)
            r6 = r5
        L45:
            int r8 = r11.r
            if (r8 < r1) goto L4e
            com.fasterxml.jackson.core.JsonToken r11 = r11.B2(r2, r7, r5, r6)
            return r11
        L4e:
            byte[] r9 = r11.W
            int r10 = r8 + 1
            r11.r = r10
            r9 = r9[r8]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r9 < r4) goto L66
            if (r9 <= r3) goto L5d
            goto L66
        L5d:
            int r6 = r6 + 1
            int r8 = r7 + 1
            char r9 = (char) r9
            r2[r7] = r9
            r7 = r8
            goto L45
        L66:
            r1 = 46
            if (r9 == r1) goto L87
            r1 = 101(0x65, float:1.42E-43)
            if (r9 == r1) goto L87
            r1 = 69
            if (r9 != r1) goto L73
            goto L87
        L73:
            r11.r = r8
            r0.f31i = r7
            y2.c r0 = r11.z
            boolean r0 = r0.f()
            if (r0 == 0) goto L82
            r11.Y2(r9)
        L82:
            com.fasterxml.jackson.core.JsonToken r11 = r11.b2(r6, r5)
            return r11
        L87:
            r5 = 1
            r1 = r11
            r3 = r7
            r4 = r9
            com.fasterxml.jackson.core.JsonToken r11 = r1.x2(r2, r3, r4, r5, r6)
            return r11
        L90:
            r1 = r11
            r1.B1()
            r11 = 0
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.g.A2():com.fasterxml.jackson.core.JsonToken");
    }

    public final JsonToken B2(char[] cArr, int i10, boolean z, int i11) {
        int i12;
        i iVar;
        int i13;
        char[] cArrK = cArr;
        int i14 = i10;
        int i15 = i11;
        while (true) {
            i12 = this.r;
            int i16 = this.f13561s;
            iVar = this.B;
            if (i12 >= i16) {
                iVar.f31i = i14;
                return b2(i15, z);
            }
            byte[] bArr = this.W;
            this.r = i12 + 1;
            i13 = bArr[i12] & 255;
            if (i13 > 57 || i13 < 48) {
                break;
            }
            if (i14 >= cArrK.length) {
                i14 = 0;
                cArrK = iVar.k();
            }
            cArrK[i14] = (char) i13;
            i15++;
            i14++;
        }
        if (i13 == 46 || i13 == 101 || i13 == 69) {
            return x2(cArrK, i14, i13, z, i15);
        }
        this.r = i12;
        iVar.f31i = i14;
        if (this.z.f()) {
            Y2(this.W[this.r] & 255);
        }
        return b2(i15, z);
    }

    public final JsonToken C2(int i10) {
        int i11;
        int i12;
        i iVar = this.B;
        char[] cArrI = iVar.i();
        if (i10 == 48) {
            i10 = X2();
        }
        cArrI[0] = (char) i10;
        int i13 = 1;
        int iMin = Math.min(this.f13561s, (this.r + cArrI.length) - 1);
        int i14 = 1;
        while (true) {
            i11 = this.r;
            if (i11 >= iMin) {
                return B2(cArrI, i13, false, i14);
            }
            byte[] bArr = this.W;
            this.r = i11 + 1;
            i12 = bArr[i11] & 255;
            if (i12 < 48 || i12 > 57) {
                break;
            }
            i14++;
            cArrI[i13] = (char) i12;
            i13++;
        }
        if (i12 == 46 || i12 == 101 || i12 == 69) {
            return x2(cArrI, i13, i12, false, i14);
        }
        this.r = i11;
        iVar.f31i = i13;
        if (this.z.f()) {
            Y2(i12);
        }
        return b2(i14, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010d, code lost:
    
        r18.S = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
    
        if (r7 <= 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0111, code lost:
    
        r8 = r8 + r7;
        r20.write(r21, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
    
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
    public final int D2(com.fasterxml.jackson.core.Base64Variant r19, q3.f r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.g.D2(com.fasterxml.jackson.core.Base64Variant, q3.f, byte[]):int");
    }

    public final void E2(int i10) {
        if (i10 < 32) {
            F1(i10);
            throw null;
        }
        F2(i10);
        throw null;
    }

    public final void F2(int i10) {
        A1("Invalid UTF-8 start byte 0x" + Integer.toHexString(i10));
        throw null;
    }

    public final void G2(int i10) {
        A1("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i10));
        throw null;
    }

    public final void H2(int i10, int i11) {
        this.r = i11;
        G2(i10);
        throw null;
    }

    public final void I2(String str, String str2) throws JsonParseException {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                break;
            }
            byte[] bArr = this.W;
            this.r = i10 + 1;
            char cF2 = (char) f2(bArr[i10]);
            if (!Character.isJavaIdentifierPart(cF2)) {
                break;
            }
            sb2.append(cF2);
            if (sb2.length() >= 256) {
                sb2.append("...");
                break;
            }
        }
        throw new JsonParseException(this, "Unrecognized token '" + ((Object) sb2) + "': was expecting " + str2);
    }

    public final void J2() {
        int i10 = this.r;
        if (i10 < this.f13561s && this.W[i10] == 10) {
            this.r = i10 + 1;
        }
        this.f13563u++;
        this.f13564v = this.r;
    }

    public final int K2() {
        int i10 = this.r;
        if (i10 + 4 >= this.f13561s) {
            return L2(false);
        }
        byte[] bArr = this.W;
        byte b10 = bArr[i10];
        if (b10 == 58) {
            int i11 = i10 + 1;
            this.r = i11;
            byte b11 = bArr[i11];
            if (b11 > 32) {
                if (b11 == 47 || b11 == 35) {
                    return L2(true);
                }
                this.r = i10 + 2;
                return b11;
            }
            if (b11 == 32 || b11 == 9) {
                int i12 = i10 + 2;
                this.r = i12;
                byte b12 = bArr[i12];
                if (b12 > 32) {
                    if (b12 == 47 || b12 == 35) {
                        return L2(true);
                    }
                    this.r = i10 + 3;
                    return b12;
                }
            }
            return L2(true);
        }
        if (b10 == 32 || b10 == 9) {
            int i13 = i10 + 1;
            this.r = i13;
            b10 = bArr[i13];
        }
        if (b10 != 58) {
            return L2(false);
        }
        int i14 = this.r;
        int i15 = i14 + 1;
        this.r = i15;
        byte b13 = bArr[i15];
        if (b13 > 32) {
            if (b13 == 47 || b13 == 35) {
                return L2(true);
            }
            this.r = i14 + 2;
            return b13;
        }
        if (b13 == 32 || b13 == 9) {
            int i16 = i14 + 2;
            this.r = i16;
            byte b14 = bArr[i16];
            if (b14 > 32) {
                if (b14 == 47 || b14 == 35) {
                    return L2(true);
                }
                this.r = i14 + 3;
                return b14;
            }
        }
        return L2(true);
    }

    public final int L2(boolean z) {
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                C1(" within/between " + this.z.h() + " entries");
                throw null;
            }
            byte[] bArr = this.W;
            int i11 = i10 + 1;
            this.r = i11;
            int i12 = bArr[i10] & 255;
            if (i12 > 32) {
                if (i12 == 47) {
                    M2();
                } else if (i12 == 35 && (this.f3558a & f14008f0) != 0) {
                    N2();
                } else {
                    if (z) {
                        return i12;
                    }
                    if (i12 != 58) {
                        E1(i12, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                    z = true;
                }
            } else if (i12 == 32) {
                continue;
            } else if (i12 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i12 == 13) {
                J2();
            } else if (i12 != 9) {
                F1(i12);
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        C1(" in a comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M2() {
        /*
            r13 = this;
            int r0 = r13.f3558a
            int r1 = y2.g.f14007e0
            r0 = r0 & r1
            r1 = 0
            r2 = 47
            if (r0 == 0) goto L84
            int r0 = r13.r
            int r3 = r13.f13561s
            java.lang.String r4 = " in a comment"
            if (r0 >= r3) goto L80
            byte[] r3 = r13.W
            int r5 = r0 + 1
            r13.r = r5
            r0 = r3[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 != r2) goto L22
            r13.N2()
            return
        L22:
            r3 = 42
            if (r0 != r3) goto L7a
            int[] r0 = x2.a.f13709g
        L28:
            int r5 = r13.r
            int r6 = r13.f13561s
            if (r5 >= r6) goto L76
            byte[] r7 = r13.W
            int r8 = r5 + 1
            r13.r = r8
            r9 = r7[r5]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r10 = r0[r9]
            if (r10 == 0) goto L28
            r11 = 2
            if (r10 == r11) goto L72
            r12 = 3
            if (r10 == r12) goto L6e
            r12 = 4
            if (r10 == r12) goto L6a
            r12 = 10
            if (r10 == r12) goto L61
            r12 = 13
            if (r10 == r12) goto L5d
            if (r10 != r3) goto L59
            if (r8 >= r6) goto L76
            r6 = r7[r8]
            if (r6 != r2) goto L28
            int r5 = r5 + r11
            r13.r = r5
            return
        L59:
            r13.E2(r9)
            throw r1
        L5d:
            r13.J2()
            goto L28
        L61:
            int r5 = r13.f13563u
            int r5 = r5 + 1
            r13.f13563u = r5
            r13.f13564v = r8
            goto L28
        L6a:
            r13.R2()
            goto L28
        L6e:
            r13.Q2()
            goto L28
        L72:
            r13.P2()
            goto L28
        L76:
            r13.C1(r4)
            throw r1
        L7a:
            java.lang.String r2 = "was expecting either '*' or '/' for a comment"
            r13.E1(r0, r2)
            throw r1
        L80:
            r13.C1(r4)
            throw r1
        L84:
            java.lang.String r0 = "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)"
            r13.E1(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.g.M2():void");
    }

    @Override // w2.b
    public final char N1() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            C1(" in character escape sequence");
            throw null;
        }
        byte[] bArr = this.W;
        this.r = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 == 34 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return '\r';
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            char cF2 = (char) f2(b10);
            Q1(cF2);
            return cF2;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            int i13 = this.r;
            if (i13 >= this.f13561s) {
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                C1(" in character escape sequence");
                throw null;
            }
            byte[] bArr2 = this.W;
            this.r = i13 + 1;
            int i14 = bArr2[i13] & 255;
            int i15 = x2.a.f13710i[i14];
            if (i15 < 0) {
                E1(i14, "expected a hex-digit for character escape sequence");
                throw null;
            }
            i11 = (i11 << 4) | i15;
        }
        return (char) i11;
    }

    public final void N2() {
        int[] iArr = x2.a.f13709g;
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                return;
            }
            byte[] bArr = this.W;
            int i11 = i10 + 1;
            this.r = i11;
            int i12 = bArr[i10] & 255;
            int i13 = iArr[i12];
            if (i13 != 0) {
                if (i13 == 2) {
                    P2();
                } else if (i13 == 3) {
                    Q2();
                } else if (i13 == 4) {
                    R2();
                } else if (i13 == 10) {
                    this.f13563u++;
                    this.f13564v = i11;
                    return;
                } else if (i13 == 13) {
                    J2();
                    return;
                } else if (i13 != 42 && i13 < 0) {
                    E2(i12);
                    throw null;
                }
            }
        }
    }

    public final void O2() {
        this.S = false;
        byte[] bArr = this.W;
        while (true) {
            int i10 = this.r;
            int i11 = this.f13561s;
            if (i10 >= i11) {
                B1();
                throw null;
            }
            while (true) {
                if (i10 >= i11) {
                    this.r = i10;
                    break;
                }
                int i12 = i10 + 1;
                int i13 = bArr[i10] & 255;
                int i14 = f14009g0[i13];
                if (i14 != 0) {
                    this.r = i12;
                    if (i13 == 34) {
                        return;
                    }
                    if (i14 == 1) {
                        N1();
                    } else if (i14 == 2) {
                        P2();
                    } else if (i14 == 3) {
                        Q2();
                    } else if (i14 == 4) {
                        R2();
                    } else {
                        if (i13 >= 32) {
                            E2(i13);
                            throw null;
                        }
                        V1(i13, "string value");
                    }
                } else {
                    i10 = i12;
                }
            }
        }
    }

    public final void P2() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        int i11 = i10 + 1;
        this.r = i11;
        byte b10 = bArr[i10];
        if ((b10 & 192) == 128) {
            return;
        }
        H2(b10 & 255, i11);
        throw null;
    }

    public final void Q2() {
        int i10 = this.r;
        int i11 = this.f13561s;
        if (i10 >= i11) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        int i12 = i10 + 1;
        this.r = i12;
        byte b10 = bArr[i10];
        if ((b10 & 192) != 128) {
            H2(b10 & 255, i12);
            throw null;
        }
        if (i12 >= i11) {
            B1();
            throw null;
        }
        int i13 = i10 + 2;
        this.r = i13;
        byte b11 = bArr[i12];
        if ((b11 & 192) == 128) {
            return;
        }
        H2(b11 & 255, i13);
        throw null;
    }

    public final void R2() {
        int i10 = this.r;
        int i11 = this.f13561s;
        if (i10 >= i11) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        int i12 = i10 + 1;
        this.r = i12;
        byte b10 = bArr[i10];
        if ((b10 & 192) != 128) {
            H2(b10 & 255, i12);
            throw null;
        }
        if (i12 >= i11) {
            B1();
            throw null;
        }
        int i13 = i10 + 2;
        this.r = i13;
        byte b11 = bArr[i12];
        if ((b11 & 192) != 128) {
            H2(b11 & 255, i13);
            throw null;
        }
        if (i13 >= i11) {
            B1();
            throw null;
        }
        int i14 = i10 + 3;
        this.r = i14;
        byte b12 = bArr[i13];
        if ((b12 & 192) == 128) {
            return;
        }
        H2(b12 & 255, i14);
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final byte[] S(Base64Variant base64Variant) throws JsonParseException {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_STRING && (jsonToken != JsonToken.VALUE_EMBEDDED_OBJECT || this.F == null)) {
            A1("Current token (" + this.f13576c + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
            throw null;
        }
        if (this.S) {
            try {
                this.F = e2(base64Variant);
                this.S = false;
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

    public final int S2() {
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                return T2();
            }
            byte[] bArr = this.W;
            int i11 = i10 + 1;
            this.r = i11;
            int i12 = bArr[i10] & 255;
            if (i12 > 32) {
                if (i12 != 47 && i12 != 35) {
                    return i12;
                }
                this.r = i10;
                return T2();
            }
            if (i12 != 32) {
                if (i12 == 10) {
                    this.f13563u++;
                    this.f13564v = i11;
                } else if (i12 == 13) {
                    J2();
                } else if (i12 != 9) {
                    F1(i12);
                    throw null;
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final a3.f<StreamReadCapability> T0() {
        return w2.b.O;
    }

    @Override // w2.b
    public final void T1() {
        byte[] bArr;
        byte[] bArr2;
        this.B.n();
        char[] cArr = this.C;
        x2.b bVar = this.f13559p;
        if (cArr != null) {
            this.C = null;
            char[] cArr2 = bVar.f13721j;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            bVar.f13721j = null;
            bVar.f13716d.f11b.set(3, cArr);
        }
        z2.a aVar = this.Q;
        z2.a aVar2 = aVar.f14218a;
        if (aVar2 != null && !aVar.f14231o) {
            a.C0179a c0179a = new a.C0179a(aVar);
            AtomicReference<a.C0179a> atomicReference = aVar2.f14219b;
            a.C0179a c0179a2 = atomicReference.get();
            int i10 = c0179a2.f14233b;
            int i11 = c0179a.f14233b;
            if (i11 != i10) {
                if (i11 > 6000) {
                    c0179a = new a.C0179a(64, 4, new int[VadSessionManager.FRAME_BYTES], new String[TraceIdKeys.MAX_LENGTH], 448, VadSessionManager.FRAME_BYTES);
                }
                while (!atomicReference.compareAndSet(c0179a2, c0179a) && atomicReference.get() == c0179a2) {
                }
            }
            aVar.f14231o = true;
        }
        if (!this.X || (bArr = this.W) == null || bArr == (bArr2 = w2.c.f13568d)) {
            return;
        }
        this.W = bArr2;
        bVar.d(bArr);
    }

    public final int T2() throws JsonParseException {
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                throw new JsonParseException(this, "Unexpected end-of-input within/between " + this.z.h() + " entries");
            }
            byte[] bArr = this.W;
            int i11 = i10 + 1;
            this.r = i11;
            int i12 = bArr[i10] & 255;
            if (i12 > 32) {
                if (i12 == 47) {
                    M2();
                } else {
                    if (i12 != 35) {
                        return i12;
                    }
                    if ((this.f3558a & f14008f0) == 0) {
                        return i12;
                    }
                    N2();
                }
            } else if (i12 == 32) {
                continue;
            } else if (i12 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i12 == 13) {
                J2();
            } else if (i12 != 9) {
                F1(i12);
                throw null;
            }
        }
    }

    public final int U2() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            x1();
            return -1;
        }
        byte[] bArr = this.W;
        int i11 = i10 + 1;
        this.r = i11;
        int i12 = bArr[i10] & 255;
        if (i12 > 32) {
            if (i12 != 47 && i12 != 35) {
                return i12;
            }
            this.r = i10;
            return V2();
        }
        if (i12 != 32) {
            if (i12 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i12 == 13) {
                J2();
            } else if (i12 != 9) {
                F1(i12);
                throw null;
            }
        }
        while (true) {
            int i13 = this.r;
            if (i13 >= this.f13561s) {
                return V2();
            }
            byte[] bArr2 = this.W;
            int i14 = i13 + 1;
            this.r = i14;
            int i15 = bArr2[i13] & 255;
            if (i15 > 32) {
                if (i15 != 47 && i15 != 35) {
                    return i15;
                }
                this.r = i13;
                return V2();
            }
            if (i15 != 32) {
                if (i15 == 10) {
                    this.f13563u++;
                    this.f13564v = i14;
                } else if (i15 == 13) {
                    J2();
                } else if (i15 != 9) {
                    F1(i15);
                    throw null;
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String V0() {
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.VALUE_STRING;
        i iVar = this.B;
        if (jsonToken == jsonToken2) {
            if (!this.S) {
                return iVar.h();
            }
            this.S = false;
            return k2();
        }
        if (jsonToken == null) {
            return null;
        }
        int i10 = jsonToken.f3597d;
        return i10 != 5 ? (i10 == 6 || i10 == 7 || i10 == 8) ? iVar.h() : jsonToken.f3594a : this.z.f13982f;
    }

    public final int V2() {
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                x1();
                return -1;
            }
            byte[] bArr = this.W;
            int i11 = i10 + 1;
            this.r = i11;
            int i12 = bArr[i10] & 255;
            if (i12 > 32) {
                if (i12 == 47) {
                    M2();
                } else {
                    if (i12 != 35) {
                        return i12;
                    }
                    if ((this.f3558a & f14008f0) == 0) {
                        return i12;
                    }
                    N2();
                }
            } else if (i12 == 32) {
                continue;
            } else if (i12 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i12 == 13) {
                J2();
            } else if (i12 != 9) {
                F1(i12);
                throw null;
            }
        }
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
            } else if (this.S) {
                this.S = false;
                l2();
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

    public final void W2() {
        this.f13566x = this.f13563u;
        int i10 = this.r;
        this.f13565w = this.f13562t + i10;
        this.f13567y = i10 - this.f13564v;
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
        } else if (this.S) {
            this.S = false;
            l2();
        }
        return this.B.p();
    }

    public final int X2() {
        int i10;
        int i11 = this.r;
        if (i11 < this.f13561s && (i10 = this.W[i11] & 255) >= 48 && i10 <= 57) {
            if ((this.f3558a & Z) == 0) {
                A1("Invalid numeric value: Leading zeroes not allowed");
                throw null;
            }
            this.r = i11 + 1;
            if (i10 == 48) {
                do {
                    int i12 = this.r;
                    if (i12 >= this.f13561s) {
                        return i10;
                    }
                    i10 = this.W[i12] & 255;
                    if (i10 >= 48 && i10 <= 57) {
                        this.r = i12 + 1;
                    }
                } while (i10 == 48);
            }
            return i10;
        }
        return 48;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int Y0() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != null) {
            int i10 = jsonToken.f3597d;
            if (i10 != 6) {
                if (i10 == 7 || i10 == 8) {
                }
            } else if (this.S) {
                this.S = false;
                l2();
            }
            int i11 = this.B.f26c;
            if (i11 >= 0) {
                return i11;
            }
        }
        return 0;
    }

    public final void Y2(int i10) {
        int i11 = this.r + 1;
        this.r = i11;
        if (i10 != 9) {
            if (i10 == 10) {
                this.f13563u++;
                this.f13564v = i11;
            } else if (i10 == 13) {
                J2();
            } else {
                if (i10 == 32) {
                    return;
                }
                E1(i10, "Expected space separating root-level values");
                throw null;
            }
        }
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final JsonLocation Z0() {
        if (this.f13576c == JsonToken.FIELD_NAME) {
            return new JsonLocation(this.U, this.f13562t + (this.T - 1), -1L, this.V, P1());
        }
        return new JsonLocation(this.f13566x, this.f13565w - 1, -1L, this.f13567y, P1());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Z2(int r20, int r21, int[] r22) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.g.Z2(int, int, int[]):java.lang.String");
    }

    public final String a3(int i10, int i11) {
        int iW2 = w2(i10, i11);
        String strJ = this.Q.j(iW2);
        if (strJ != null) {
            return strJ;
        }
        int[] iArr = this.R;
        iArr[0] = iW2;
        return Z2(1, i11, iArr);
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final int b1() throws InputCoercionException {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.c1();
        }
        int i10 = this.G;
        int i11 = i10 & 1;
        if (i11 == 0) {
            if (i10 == 0) {
                return R1();
            }
            if (i11 == 0) {
                X1();
            }
        }
        return this.H;
    }

    public final String b3(int i10, int i11, int i12) {
        int iW2 = w2(i11, i12);
        String strK = this.Q.k(i10, iW2);
        if (strK != null) {
            return strK;
        }
        int[] iArr = this.R;
        iArr[0] = i10;
        iArr[1] = iW2;
        return Z2(2, i12, iArr);
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final int c1() throws InputCoercionException {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.c1();
        }
        int i10 = this.G;
        int i11 = i10 & 1;
        if (i11 == 0) {
            if (i10 == 0) {
                return R1();
            }
            if (i11 == 0) {
                X1();
            }
        }
        return this.H;
    }

    public final void c2() {
        W2();
        if (!this.z.d()) {
            U1('}', 93);
            throw null;
        }
        c cVar = this.z;
        cVar.f13983g = null;
        this.z = cVar.f13979c;
    }

    public final String c3(int i10, int i11, int i12, int i13) {
        int iW2 = w2(i12, i13);
        String strL = this.Q.l(i10, i11, iW2);
        if (strL != null) {
            return strL;
        }
        int[] iArr = this.R;
        iArr[0] = i10;
        iArr[1] = i11;
        iArr[2] = w2(iW2, i13);
        return Z2(3, i13, iArr);
    }

    public final void d2() {
        W2();
        if (!this.z.e()) {
            U1(']', 125);
            throw null;
        }
        c cVar = this.z;
        cVar.f13983g = null;
        this.z = cVar.f13979c;
    }

    public final String d3(int[] iArr, int i10, int i11, int i12) {
        if (i10 >= iArr.length) {
            iArr = w2.b.Y1(iArr, iArr.length);
            this.R = iArr;
        }
        int i13 = i10 + 1;
        iArr[i10] = w2(i11, i12);
        String strM = this.Q.m(iArr, i13);
        return strM == null ? Z2(i13, i12, iArr) : strM;
    }

    public final byte[] e2(Base64Variant base64Variant) {
        a3.c cVarO1 = O1();
        while (true) {
            int i10 = this.r;
            if (i10 >= this.f13561s) {
                B1();
                throw null;
            }
            byte[] bArr = this.W;
            this.r = i10 + 1;
            int i11 = bArr[i10] & 255;
            if (i11 > 32) {
                int iD = base64Variant.d(i11);
                char c9 = base64Variant.f3509e;
                boolean z = base64Variant.f3510j;
                if (iD < 0) {
                    if (i11 == 34) {
                        return cVarO1.P();
                    }
                    iD = M1(base64Variant, i11, 0);
                    if (iD < 0) {
                        continue;
                    }
                }
                int i12 = this.r;
                if (i12 >= this.f13561s) {
                    B1();
                    throw null;
                }
                byte[] bArr2 = this.W;
                this.r = i12 + 1;
                int i13 = bArr2[i12] & 255;
                int iD2 = base64Variant.d(i13);
                if (iD2 < 0) {
                    iD2 = M1(base64Variant, i13, 1);
                }
                int i14 = (iD << 6) | iD2;
                int i15 = this.r;
                if (i15 >= this.f13561s) {
                    B1();
                    throw null;
                }
                byte[] bArr3 = this.W;
                this.r = i15 + 1;
                int i16 = bArr3[i15] & 255;
                int iD3 = base64Variant.d(i16);
                if (iD3 < 0) {
                    if (iD3 != -2) {
                        if (i16 == 34) {
                            cVarO1.o(i14 >> 4);
                            if (!z) {
                                return cVarO1.P();
                            }
                            this.r--;
                            A1(base64Variant.j());
                            throw null;
                        }
                        iD3 = M1(base64Variant, i16, 2);
                    }
                    if (iD3 == -2) {
                        int i17 = this.r;
                        if (i17 >= this.f13561s) {
                            B1();
                            throw null;
                        }
                        byte[] bArr4 = this.W;
                        this.r = i17 + 1;
                        int i18 = bArr4[i17] & 255;
                        if (i18 != c9 && M1(base64Variant, i18, 3) != -2) {
                            throw w2.b.Z1(base64Variant, i18, 3, "expected padding character '" + c9 + "'");
                        }
                        cVarO1.o(i14 >> 4);
                    }
                }
                int i19 = (i14 << 6) | iD3;
                int i20 = this.r;
                if (i20 >= this.f13561s) {
                    B1();
                    throw null;
                }
                byte[] bArr5 = this.W;
                this.r = i20 + 1;
                int i21 = bArr5[i20] & 255;
                int iD4 = base64Variant.d(i21);
                if (iD4 < 0) {
                    if (iD4 != -2) {
                        if (i21 == 34) {
                            cVarO1.C(i19 >> 2);
                            if (!z) {
                                return cVarO1.P();
                            }
                            this.r--;
                            A1(base64Variant.j());
                            throw null;
                        }
                        iD4 = M1(base64Variant, i21, 3);
                    }
                    if (iD4 == -2) {
                        cVarO1.C(i19 >> 2);
                    }
                }
                cVarO1.w((i19 << 6) | iD4);
            }
        }
    }

    public final int e3() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        this.r = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final String f1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? C0() : super.g1();
        }
        if (!this.S) {
            return this.B.h();
        }
        this.S = false;
        return k2();
    }

    public final int f2(int i10) {
        int i11;
        char c9;
        int i12 = i10 & 255;
        if (i12 <= 127) {
            return i12;
        }
        if ((i10 & 224) == 192) {
            i11 = i10 & 31;
            c9 = 1;
        } else if ((i10 & 240) == 224) {
            i11 = i10 & 15;
            c9 = 2;
        } else {
            if ((i10 & 248) != 240) {
                F2(i10 & 255);
                throw null;
            }
            i11 = i10 & 7;
            c9 = 3;
        }
        int iE3 = e3();
        if ((iE3 & 192) != 128) {
            G2(iE3 & 255);
            throw null;
        }
        int i13 = (i11 << 6) | (iE3 & 63);
        if (c9 <= 1) {
            return i13;
        }
        int iE32 = e3();
        if ((iE32 & 192) != 128) {
            G2(iE32 & 255);
            throw null;
        }
        int i14 = (i13 << 6) | (iE32 & 63);
        if (c9 <= 2) {
            return i14;
        }
        int iE33 = e3();
        if ((iE33 & 192) == 128) {
            return (i14 << 6) | (iE33 & 63);
        }
        G2(iE33 & 255);
        throw null;
    }

    public final String f3(int i10, int i11, int i12, int i13, int[] iArr) {
        while (true) {
            if (f14010h0[i12] != 0) {
                if (i12 == 34) {
                    if (i13 > 0) {
                        if (i10 >= iArr.length) {
                            iArr = w2.b.Y1(iArr, iArr.length);
                            this.R = iArr;
                        }
                        iArr[i10] = w2(i11, i13);
                        i10++;
                    }
                    String strM = this.Q.m(iArr, i10);
                    return strM == null ? Z2(i10, i13, iArr) : strM;
                }
                if (i12 != 92) {
                    V1(i12, "name");
                } else {
                    i12 = N1();
                }
                if (i12 > 127) {
                    int i14 = 0;
                    if (i13 >= 4) {
                        if (i10 >= iArr.length) {
                            iArr = w2.b.Y1(iArr, iArr.length);
                            this.R = iArr;
                        }
                        iArr[i10] = i11;
                        i10++;
                        i11 = 0;
                        i13 = 0;
                    }
                    if (i12 < 2048) {
                        i11 = (i11 << 8) | (i12 >> 6) | 192;
                        i13++;
                    } else {
                        int i15 = (i11 << 8) | (i12 >> 12) | 224;
                        int i16 = i13 + 1;
                        if (i16 >= 4) {
                            if (i10 >= iArr.length) {
                                iArr = w2.b.Y1(iArr, iArr.length);
                                this.R = iArr;
                            }
                            iArr[i10] = i15;
                            i10++;
                            i16 = 0;
                        } else {
                            i14 = i15;
                        }
                        i11 = (i14 << 8) | ((i12 >> 6) & 63) | TraceIdKeys.MAX_LENGTH;
                        i13 = i16 + 1;
                    }
                    i12 = (i12 & 63) | TraceIdKeys.MAX_LENGTH;
                }
            }
            if (i13 < 4) {
                i13++;
                i11 = (i11 << 8) | i12;
            } else {
                if (i10 >= iArr.length) {
                    iArr = w2.b.Y1(iArr, iArr.length);
                    this.R = iArr;
                }
                iArr[i10] = i11;
                i11 = i12;
                i10++;
                i13 = 1;
            }
            int i17 = this.r;
            if (i17 >= this.f13561s) {
                JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                C1(" in field name");
                throw null;
            }
            byte[] bArr = this.W;
            this.r = i17 + 1;
            i12 = bArr[i17] & 255;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final v2.c g0() {
        return this.P;
    }

    @Override // w2.c, com.fasterxml.jackson.core.JsonParser
    public final String g1() {
        JsonToken jsonToken = this.f13576c;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? C0() : super.g1();
        }
        if (!this.S) {
            return this.B.h();
        }
        this.S = false;
        return k2();
    }

    public final int g2(int i10) {
        int i11 = this.r;
        if (i11 >= this.f13561s) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        int i12 = i11 + 1;
        this.r = i12;
        byte b10 = bArr[i11];
        if ((b10 & 192) == 128) {
            return ((i10 & 31) << 6) | (b10 & 63);
        }
        H2(b10 & 255, i12);
        throw null;
    }

    public final String g3(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.R;
        iArr[0] = i10;
        iArr[1] = i11;
        return f3(2, i12, i13, i14, iArr);
    }

    public final int h2(int i10) {
        int i11 = this.r;
        int i12 = this.f13561s;
        if (i11 >= i12) {
            B1();
            throw null;
        }
        int i13 = i10 & 15;
        byte[] bArr = this.W;
        int i14 = i11 + 1;
        this.r = i14;
        byte b10 = bArr[i11];
        if ((b10 & 192) != 128) {
            H2(b10 & 255, i14);
            throw null;
        }
        int i15 = (i13 << 6) | (b10 & 63);
        if (i14 >= i12) {
            B1();
            throw null;
        }
        int i16 = i11 + 2;
        this.r = i16;
        byte b11 = bArr[i14];
        if ((b11 & 192) == 128) {
            return (i15 << 6) | (b11 & 63);
        }
        H2(b11 & 255, i16);
        throw null;
    }

    public final int i2(int i10) {
        int i11 = i10 & 15;
        byte[] bArr = this.W;
        int i12 = this.r;
        int i13 = i12 + 1;
        this.r = i13;
        byte b10 = bArr[i12];
        if ((b10 & 192) != 128) {
            H2(b10 & 255, i13);
            throw null;
        }
        int i14 = (i11 << 6) | (b10 & 63);
        int i15 = i12 + 2;
        this.r = i15;
        byte b11 = bArr[i13];
        if ((b11 & 192) == 128) {
            return (i14 << 6) | (b11 & 63);
        }
        H2(b11 & 255, i15);
        throw null;
    }

    public final int j2(int i10) {
        int i11 = this.r;
        int i12 = this.f13561s;
        if (i11 >= i12) {
            B1();
            throw null;
        }
        byte[] bArr = this.W;
        int i13 = i11 + 1;
        this.r = i13;
        byte b10 = bArr[i11];
        if ((b10 & 192) != 128) {
            H2(b10 & 255, i13);
            throw null;
        }
        int i14 = ((i10 & 7) << 6) | (b10 & 63);
        if (i13 >= i12) {
            B1();
            throw null;
        }
        int i15 = i11 + 2;
        this.r = i15;
        byte b11 = bArr[i13];
        if ((b11 & 192) != 128) {
            H2(b11 & 255, i15);
            throw null;
        }
        int i16 = (i14 << 6) | (b11 & 63);
        if (i15 >= i12) {
            B1();
            throw null;
        }
        int i17 = i11 + 3;
        this.r = i17;
        byte b12 = bArr[i15];
        if ((b12 & 192) == 128) {
            return ((i16 << 6) | (b12 & 63)) - 65536;
        }
        H2(b12 & 255, i17);
        throw null;
    }

    public final String k2() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            B1();
            throw null;
        }
        i iVar = this.B;
        char[] cArrI = iVar.i();
        int iMin = Math.min(this.f13561s, cArrI.length + i10);
        byte[] bArr = this.W;
        int i11 = 0;
        while (true) {
            if (i10 >= iMin) {
                break;
            }
            int i12 = bArr[i10] & 255;
            if (f14009g0[i12] == 0) {
                i10++;
                cArrI[i11] = (char) i12;
                i11++;
            } else if (i12 == 34) {
                this.r = i10 + 1;
                iVar.f31i = i11;
                if (iVar.f30g > 0) {
                    return iVar.h();
                }
                String str = i11 == 0 ? "" : new String(iVar.h, 0, i11);
                iVar.f32j = str;
                return str;
            }
        }
        this.r = i10;
        m2(cArrI, i11);
        return iVar.h();
    }

    public final void l2() {
        int i10 = this.r;
        if (i10 >= this.f13561s) {
            B1();
            throw null;
        }
        i iVar = this.B;
        char[] cArrI = iVar.i();
        int iMin = Math.min(this.f13561s, cArrI.length + i10);
        byte[] bArr = this.W;
        int i11 = 0;
        while (true) {
            if (i10 >= iMin) {
                break;
            }
            int i12 = bArr[i10] & 255;
            if (f14009g0[i12] == 0) {
                i10++;
                cArrI[i11] = (char) i12;
                i11++;
            } else if (i12 == 34) {
                this.r = i10 + 1;
                iVar.f31i = i11;
                return;
            }
        }
        this.r = i10;
        m2(cArrI, i11);
    }

    public final void m2(char[] cArr, int i10) {
        byte[] bArr = this.W;
        while (true) {
            int i11 = this.r;
            if (i11 >= this.f13561s) {
                B1();
                throw null;
            }
            int length = cArr.length;
            int i12 = 0;
            i iVar = this.B;
            if (i10 >= length) {
                cArr = iVar.k();
                i10 = 0;
            }
            int iMin = Math.min(this.f13561s, (cArr.length - i10) + i11);
            while (true) {
                if (i11 >= iMin) {
                    this.r = i11;
                    break;
                }
                int i13 = i11 + 1;
                int iN1 = bArr[i11] & 255;
                int i14 = f14009g0[iN1];
                if (i14 != 0) {
                    this.r = i13;
                    if (iN1 == 34) {
                        iVar.f31i = i10;
                        return;
                    }
                    if (i14 == 1) {
                        iN1 = N1();
                    } else if (i14 == 2) {
                        iN1 = g2(iN1);
                    } else if (i14 == 3) {
                        iN1 = this.f13561s - i13 >= 2 ? i2(iN1) : h2(iN1);
                    } else if (i14 == 4) {
                        int iJ2 = j2(iN1);
                        int i15 = i10 + 1;
                        cArr[i10] = (char) ((iJ2 >> 10) | 55296);
                        if (i15 >= cArr.length) {
                            cArr = iVar.k();
                            i10 = 0;
                        } else {
                            i10 = i15;
                        }
                        iN1 = (iJ2 & 1023) | 56320;
                    } else {
                        if (iN1 >= 32) {
                            E2(iN1);
                            throw null;
                        }
                        V1(iN1, "string value");
                    }
                    if (i10 >= cArr.length) {
                        cArr = iVar.k();
                    } else {
                        i12 = i10;
                    }
                    i10 = i12 + 1;
                    cArr[i12] = (char) iN1;
                } else {
                    cArr[i10] = (char) iN1;
                    i11 = i13;
                    i10++;
                }
            }
        }
    }

    public final JsonToken n2(int i10, boolean z) throws JsonParseException {
        String str;
        if (i10 == 73) {
            int i11 = this.r;
            if (i11 >= this.f13561s) {
                D1(JsonToken.VALUE_NUMBER_FLOAT);
                throw null;
            }
            byte[] bArr = this.W;
            this.r = i11 + 1;
            i10 = bArr[i11];
            if (i10 == 78) {
                str = z ? "-INF" : "+INF";
            } else if (i10 == 110) {
                str = z ? "-Infinity" : "+Infinity";
            }
            r2(3, str);
            if ((this.f3558a & f14005a0) != 0) {
                return a2(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            throw new JsonParseException(this, a0.a.k("Non-standard token '", str, "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"));
        }
        J1(i10, "expected digit (0-9) to follow minus sign, for valid numeric value");
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String o1() throws JsonParseException {
        JsonToken jsonTokenA2;
        this.G = 0;
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            u2();
            return null;
        }
        if (this.S) {
            O2();
        }
        int iU2 = U2();
        if (iU2 < 0) {
            close();
            this.f13576c = null;
            return null;
        }
        this.F = null;
        if (iU2 == 93) {
            c2();
            this.f13576c = JsonToken.END_ARRAY;
            return null;
        }
        if (iU2 == 125) {
            d2();
            this.f13576c = JsonToken.END_OBJECT;
            return null;
        }
        if (this.z.k()) {
            if (iU2 != 44) {
                E1(iU2, "was expecting comma to separate " + this.z.h() + " entries");
                throw null;
            }
            iU2 = S2();
            if ((this.f3558a & Y) != 0 && (iU2 == 93 || iU2 == 125)) {
                if (iU2 == 125) {
                    d2();
                    this.f13576c = JsonToken.END_OBJECT;
                    return null;
                }
                c2();
                this.f13576c = JsonToken.END_ARRAY;
                return null;
            }
        }
        if (!this.z.e()) {
            W2();
            v2(iU2);
            return null;
        }
        this.U = this.f13563u;
        int i10 = this.r;
        this.T = i10;
        this.V = i10 - this.f13564v;
        String strZ2 = z2(iU2);
        this.z.l(strZ2);
        this.f13576c = jsonToken2;
        int iK2 = K2();
        W2();
        if (iK2 == 34) {
            this.S = true;
            this.A = JsonToken.VALUE_STRING;
            return strZ2;
        }
        if (iK2 == 45) {
            jsonTokenA2 = A2();
        } else if (iK2 == 46) {
            jsonTokenA2 = y2();
        } else if (iK2 == 91) {
            jsonTokenA2 = JsonToken.START_ARRAY;
        } else if (iK2 == 102) {
            p2();
            jsonTokenA2 = JsonToken.VALUE_FALSE;
        } else if (iK2 == 110) {
            q2();
            jsonTokenA2 = JsonToken.VALUE_NULL;
        } else if (iK2 == 116) {
            t2();
            jsonTokenA2 = JsonToken.VALUE_TRUE;
        } else if (iK2 != 123) {
            switch (iK2) {
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
                    jsonTokenA2 = C2(iK2);
                    break;
                default:
                    jsonTokenA2 = o2(iK2);
                    break;
            }
        } else {
            jsonTokenA2 = JsonToken.START_OBJECT;
        }
        this.A = jsonTokenA2;
        return strZ2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r13 != 44) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r12.z.d() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r12.z.f() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if ((r12.f3558a & y2.g.b0) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        r12.r--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        return com.fasterxml.jackson.core.JsonToken.VALUE_NULL;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.core.JsonToken o2(int r13) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.g.o2(int):com.fasterxml.jackson.core.JsonToken");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String p1() {
        if (this.f13576c == JsonToken.FIELD_NAME) {
            this.D = false;
            JsonToken jsonToken = this.A;
            this.A = null;
            this.f13576c = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (!this.S) {
                    return this.B.h();
                }
                this.S = false;
                return k2();
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

    public final void p2() throws JsonParseException {
        int i10;
        int i11 = this.r;
        if (i11 + 4 < this.f13561s) {
            byte[] bArr = this.W;
            int i12 = i11 + 1;
            if (bArr[i11] == 97) {
                int i13 = i11 + 2;
                if (bArr[i12] == 108) {
                    int i14 = i11 + 3;
                    if (bArr[i13] == 115) {
                        int i15 = i11 + 4;
                        if (bArr[i14] == 101 && ((i10 = bArr[i15] & 255) < 48 || i10 == 93 || i10 == 125)) {
                            this.r = i15;
                            return;
                        }
                    }
                }
            }
        }
        s2(1, "false");
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken q1() throws JsonParseException {
        JsonToken jsonTokenA2;
        JsonToken jsonToken = this.f13576c;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return u2();
        }
        this.G = 0;
        if (this.S) {
            O2();
        }
        int iU2 = U2();
        if (iU2 < 0) {
            close();
            this.f13576c = null;
            return null;
        }
        this.F = null;
        if (iU2 == 93) {
            c2();
            JsonToken jsonToken3 = JsonToken.END_ARRAY;
            this.f13576c = jsonToken3;
            return jsonToken3;
        }
        if (iU2 == 125) {
            d2();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            this.f13576c = jsonToken4;
            return jsonToken4;
        }
        if (this.z.k()) {
            if (iU2 != 44) {
                E1(iU2, "was expecting comma to separate " + this.z.h() + " entries");
                throw null;
            }
            iU2 = S2();
            if ((this.f3558a & Y) != 0 && (iU2 == 93 || iU2 == 125)) {
                if (iU2 == 125) {
                    d2();
                    JsonToken jsonToken5 = JsonToken.END_OBJECT;
                    this.f13576c = jsonToken5;
                    return jsonToken5;
                }
                c2();
                JsonToken jsonToken6 = JsonToken.END_ARRAY;
                this.f13576c = jsonToken6;
                return jsonToken6;
            }
        }
        if (!this.z.e()) {
            W2();
            return v2(iU2);
        }
        this.U = this.f13563u;
        int i10 = this.r;
        this.T = i10;
        this.V = i10 - this.f13564v;
        this.z.l(z2(iU2));
        this.f13576c = jsonToken2;
        int iK2 = K2();
        W2();
        if (iK2 == 34) {
            this.S = true;
            this.A = JsonToken.VALUE_STRING;
            return this.f13576c;
        }
        if (iK2 == 45) {
            jsonTokenA2 = A2();
        } else if (iK2 == 46) {
            jsonTokenA2 = y2();
        } else if (iK2 == 91) {
            jsonTokenA2 = JsonToken.START_ARRAY;
        } else if (iK2 == 102) {
            p2();
            jsonTokenA2 = JsonToken.VALUE_FALSE;
        } else if (iK2 == 110) {
            q2();
            jsonTokenA2 = JsonToken.VALUE_NULL;
        } else if (iK2 == 116) {
            t2();
            jsonTokenA2 = JsonToken.VALUE_TRUE;
        } else if (iK2 != 123) {
            switch (iK2) {
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
                    jsonTokenA2 = C2(iK2);
                    break;
                default:
                    jsonTokenA2 = o2(iK2);
                    break;
            }
        } else {
            jsonTokenA2 = JsonToken.START_OBJECT;
        }
        this.A = jsonTokenA2;
        return this.f13576c;
    }

    public final void q2() throws JsonParseException {
        int i10;
        int i11 = this.r;
        if (i11 + 3 < this.f13561s) {
            byte[] bArr = this.W;
            int i12 = i11 + 1;
            if (bArr[i11] == 117) {
                int i13 = i11 + 2;
                if (bArr[i12] == 108) {
                    int i14 = i11 + 3;
                    if (bArr[i13] == 108 && ((i10 = bArr[i14] & 255) < 48 || i10 == 93 || i10 == 125)) {
                        this.r = i14;
                        return;
                    }
                }
            }
        }
        s2(1, "null");
    }

    public final void r2(int i10, String str) throws JsonParseException {
        int length = str.length();
        if (this.r + length >= this.f13561s) {
            s2(i10, str);
            return;
        }
        while (this.W[this.r] == str.charAt(i10)) {
            int i11 = this.r + 1;
            this.r = i11;
            i10++;
            if (i10 >= length) {
                int i12 = this.W[i11] & 255;
                if (i12 < 48 || i12 == 93 || i12 == 125 || !Character.isJavaIdentifierPart((char) f2(i12))) {
                    return;
                }
                I2(str.substring(0, i10), W1());
                throw null;
            }
        }
        I2(str.substring(0, i10), W1());
        throw null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int s1(Base64Variant base64Variant, q3.f fVar) throws IOException {
        if (!this.S || this.f13576c != JsonToken.VALUE_STRING) {
            byte[] bArrS = S(base64Variant);
            fVar.write(bArrS);
            return bArrS.length;
        }
        x2.b bVar = this.f13559p;
        byte[] bArrB = bVar.b();
        try {
            return D2(base64Variant, fVar, bArrB);
        } finally {
            bVar.c(bArrB);
        }
    }

    public final void s2(int i10, String str) throws JsonParseException {
        int i11;
        int i12;
        int length = str.length();
        do {
            int i13 = this.r;
            if (i13 >= this.f13561s || this.W[i13] != str.charAt(i10)) {
                I2(str.substring(0, i10), W1());
                throw null;
            }
            i11 = this.r + 1;
            this.r = i11;
            i10++;
        } while (i10 < length);
        if (i11 < this.f13561s && (i12 = this.W[i11] & 255) >= 48 && i12 != 93 && i12 != 125 && Character.isJavaIdentifierPart((char) f2(i12))) {
            I2(str.substring(0, i10), W1());
            throw null;
        }
    }

    public final void t2() throws JsonParseException {
        int i10;
        int i11 = this.r;
        if (i11 + 3 < this.f13561s) {
            byte[] bArr = this.W;
            int i12 = i11 + 1;
            if (bArr[i11] == 114) {
                int i13 = i11 + 2;
                if (bArr[i12] == 117) {
                    int i14 = i11 + 3;
                    if (bArr[i13] == 101 && ((i10 = bArr[i14] & 255) < 48 || i10 == 93 || i10 == 125)) {
                        this.r = i14;
                        return;
                    }
                }
            }
        }
        s2(1, "true");
    }

    public final JsonToken u2() {
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

    public final JsonToken v2(int i10) throws JsonParseException {
        if (i10 == 34) {
            this.S = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.f13576c = jsonToken;
            return jsonToken;
        }
        if (i10 == 45) {
            JsonToken jsonTokenA2 = A2();
            this.f13576c = jsonTokenA2;
            return jsonTokenA2;
        }
        if (i10 == 46) {
            JsonToken jsonTokenY2 = y2();
            this.f13576c = jsonTokenY2;
            return jsonTokenY2;
        }
        if (i10 == 91) {
            this.z = this.z.i(this.f13566x, this.f13567y);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this.f13576c = jsonToken2;
            return jsonToken2;
        }
        if (i10 == 102) {
            p2();
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this.f13576c = jsonToken3;
            return jsonToken3;
        }
        if (i10 == 110) {
            q2();
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this.f13576c = jsonToken4;
            return jsonToken4;
        }
        if (i10 == 116) {
            t2();
            JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
            this.f13576c = jsonToken5;
            return jsonToken5;
        }
        if (i10 == 123) {
            this.z = this.z.j(this.f13566x, this.f13567y);
            JsonToken jsonToken6 = JsonToken.START_OBJECT;
            this.f13576c = jsonToken6;
            return jsonToken6;
        }
        switch (i10) {
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
                JsonToken jsonTokenC2 = C2(i10);
                this.f13576c = jsonTokenC2;
                return jsonTokenC2;
            default:
                JsonToken jsonTokenO2 = o2(i10);
                this.f13576c = jsonTokenO2;
                return jsonTokenO2;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonLocation x0() {
        return new JsonLocation(this.f13563u, this.f13562t + this.r, -1L, (this.r - this.f13564v) + 1, P1());
    }

    public final JsonToken x2(char[] cArr, int i10, int i11, boolean z, int i12) {
        boolean z3;
        i iVar = this.B;
        if (i11 == 46) {
            if (i10 >= cArr.length) {
                cArr = iVar.k();
                i10 = 0;
            }
            cArr[i10] = (char) i11;
            i10++;
            int i13 = 0;
            while (true) {
                int i14 = this.r;
                if (i14 >= this.f13561s) {
                    z3 = true;
                    break;
                }
                byte[] bArr = this.W;
                this.r = i14 + 1;
                i11 = bArr[i14] & 255;
                if (i11 < 48 || i11 > 57) {
                    break;
                }
                i13++;
                if (i10 >= cArr.length) {
                    cArr = iVar.k();
                    i10 = 0;
                }
                cArr[i10] = (char) i11;
                i10++;
            }
            z3 = false;
            if (i13 == 0) {
                J1(i11, "Decimal point not followed by a digit");
                throw null;
            }
        } else {
            z3 = false;
        }
        if (i11 == 101 || i11 == 69) {
            if (i10 >= cArr.length) {
                cArr = iVar.k();
                i10 = 0;
            }
            int i15 = i10 + 1;
            cArr[i10] = (char) i11;
            int i16 = this.r;
            if (i16 >= this.f13561s) {
                B1();
                throw null;
            }
            byte[] bArr2 = this.W;
            this.r = i16 + 1;
            int i17 = bArr2[i16] & 255;
            if (i17 == 45 || i17 == 43) {
                if (i15 >= cArr.length) {
                    cArr = iVar.k();
                    i15 = 0;
                }
                int i18 = i15 + 1;
                cArr[i15] = (char) i17;
                int i19 = this.r;
                if (i19 >= this.f13561s) {
                    B1();
                    throw null;
                }
                byte[] bArr3 = this.W;
                this.r = i19 + 1;
                i17 = bArr3[i19] & 255;
                i15 = i18;
            }
            i11 = i17;
            int i20 = 0;
            while (true) {
                if (i11 < 48 || i11 > 57) {
                    break;
                }
                i20++;
                if (i15 >= cArr.length) {
                    cArr = iVar.k();
                    i15 = 0;
                }
                int i21 = i15 + 1;
                cArr[i15] = (char) i11;
                int i22 = this.r;
                if (i22 >= this.f13561s) {
                    z3 = true;
                    i15 = i21;
                    break;
                }
                byte[] bArr4 = this.W;
                this.r = i22 + 1;
                i11 = bArr4[i22] & 255;
                i15 = i21;
            }
            if (i20 == 0) {
                J1(i11, "Exponent indicator not followed by a digit");
                throw null;
            }
            i10 = i15;
        }
        if (!z3) {
            this.r--;
            if (this.z.f()) {
                Y2(i11);
            }
        }
        iVar.f31i = i10;
        this.M = z;
        this.N = i12;
        this.G = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final JsonToken y2() {
        return !JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.f3618b.a(this.f3558a) ? o2(46) : x2(this.B.i(), 0, 46, false, 0);
    }

    public final String z2(int i10) {
        int i11 = i10;
        int[] iArr = f14010h0;
        if (i11 != 34) {
            z2.a aVar = this.Q;
            if (i11 == 39 && (this.f3558a & c0) != 0) {
                int i12 = this.r;
                if (i12 >= this.f13561s) {
                    JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                    C1(": was expecting closing ''' for field name");
                    throw null;
                }
                byte[] bArr = this.W;
                this.r = i12 + 1;
                int iN1 = bArr[i12] & 255;
                if (iN1 == 39) {
                    return "";
                }
                int[] iArrY1 = this.R;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (iN1 != 39) {
                    if (iArr[iN1] != 0 && iN1 != 34) {
                        if (iN1 != 92) {
                            V1(iN1, "name");
                        } else {
                            iN1 = N1();
                        }
                        if (iN1 > 127) {
                            if (i13 >= 4) {
                                if (i14 >= iArrY1.length) {
                                    iArrY1 = w2.b.Y1(iArrY1, iArrY1.length);
                                    this.R = iArrY1;
                                }
                                iArrY1[i14] = i15;
                                i14++;
                                i13 = 0;
                                i15 = 0;
                            }
                            if (iN1 < 2048) {
                                i15 = (i15 << 8) | (iN1 >> 6) | 192;
                                i13++;
                            } else {
                                int i16 = (i15 << 8) | (iN1 >> 12) | 224;
                                int i17 = i13 + 1;
                                if (i17 >= 4) {
                                    if (i14 >= iArrY1.length) {
                                        iArrY1 = w2.b.Y1(iArrY1, iArrY1.length);
                                        this.R = iArrY1;
                                    }
                                    iArrY1[i14] = i16;
                                    i14++;
                                    i17 = 0;
                                    i16 = 0;
                                }
                                i15 = (i16 << 8) | ((iN1 >> 6) & 63) | TraceIdKeys.MAX_LENGTH;
                                i13 = i17 + 1;
                            }
                            iN1 = (iN1 & 63) | TraceIdKeys.MAX_LENGTH;
                        }
                    }
                    if (i13 < 4) {
                        i13++;
                        iN1 |= i15 << 8;
                    } else {
                        if (i14 >= iArrY1.length) {
                            iArrY1 = w2.b.Y1(iArrY1, iArrY1.length);
                            this.R = iArrY1;
                        }
                        iArrY1[i14] = i15;
                        i14++;
                        i13 = 1;
                    }
                    i15 = iN1;
                    int i18 = this.r;
                    if (i18 >= this.f13561s) {
                        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                        C1(" in field name");
                        throw null;
                    }
                    byte[] bArr2 = this.W;
                    this.r = i18 + 1;
                    iN1 = bArr2[i18] & 255;
                }
                if (i13 > 0) {
                    if (i14 >= iArrY1.length) {
                        iArrY1 = w2.b.Y1(iArrY1, iArrY1.length);
                        this.R = iArrY1;
                    }
                    iArrY1[i14] = w2(i15, i13);
                    i14++;
                }
                String strM = aVar.m(iArrY1, i14);
                return strM == null ? Z2(i14, i13, iArrY1) : strM;
            }
            int i19 = 0;
            if ((this.f3558a & f14006d0) == 0) {
                E1((char) f2(i10), "was expecting double-quote to start field name");
                throw null;
            }
            int[] iArr2 = x2.a.f13708f;
            if (iArr2[i11] != 0) {
                E1(i11, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
                throw null;
            }
            int[] iArrY12 = this.R;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (i20 < 4) {
                    i20++;
                    i11 |= i19 << 8;
                } else {
                    if (i21 >= iArrY12.length) {
                        iArrY12 = w2.b.Y1(iArrY12, iArrY12.length);
                        this.R = iArrY12;
                    }
                    iArrY12[i21] = i19;
                    i21++;
                    i20 = 1;
                }
                i19 = i11;
                int i22 = this.r;
                if (i22 >= this.f13561s) {
                    JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                    C1(" in field name");
                    throw null;
                }
                int i23 = this.W[i22] & 255;
                if (iArr2[i23] != 0) {
                    if (i20 > 0) {
                        if (i21 >= iArrY12.length) {
                            iArrY12 = w2.b.Y1(iArrY12, iArrY12.length);
                            this.R = iArrY12;
                        }
                        iArrY12[i21] = i19;
                        i21++;
                    }
                    String strM2 = aVar.m(iArrY12, i21);
                    return strM2 == null ? Z2(i21, i20, iArrY12) : strM2;
                }
                this.r = i22 + 1;
                i11 = i23;
            }
        } else {
            int i24 = this.r;
            int i25 = i24 + 13;
            int i26 = this.f13561s;
            if (i25 > i26) {
                if (i24 >= i26) {
                    JsonToken jsonToken4 = JsonToken.NOT_AVAILABLE;
                    C1(": was expecting closing '\"' for name");
                    throw null;
                }
                byte[] bArr3 = this.W;
                this.r = i24 + 1;
                int i27 = bArr3[i24] & 255;
                return i27 == 34 ? "" : f3(0, 0, i27, 0, this.R);
            }
            byte[] bArr4 = this.W;
            int i28 = i24 + 1;
            this.r = i28;
            int i29 = bArr4[i24] & 255;
            if (iArr[i29] != 0) {
                return i29 == 34 ? "" : f3(0, 0, i29, 0, this.R);
            }
            int i30 = i24 + 2;
            this.r = i30;
            int i31 = bArr4[i28] & 255;
            if (iArr[i31] != 0) {
                return i31 == 34 ? a3(i29, 1) : f3(0, i29, i31, 1, this.R);
            }
            int i32 = i31 | (i29 << 8);
            int i33 = i24 + 3;
            this.r = i33;
            int i34 = bArr4[i30] & 255;
            if (iArr[i34] != 0) {
                return i34 == 34 ? a3(i32, 2) : f3(0, i32, i34, 2, this.R);
            }
            int i35 = (i32 << 8) | i34;
            int i36 = i24 + 4;
            this.r = i36;
            int i37 = bArr4[i33] & 255;
            if (iArr[i37] != 0) {
                return i37 == 34 ? a3(i35, 3) : f3(0, i35, i37, 3, this.R);
            }
            int i38 = (i35 << 8) | i37;
            int i39 = i24 + 5;
            this.r = i39;
            int i40 = bArr4[i36] & 255;
            if (iArr[i40] != 0) {
                return i40 == 34 ? a3(i38, 4) : f3(0, i38, i40, 4, this.R);
            }
            int i41 = i24 + 6;
            this.r = i41;
            int i42 = bArr4[i39] & 255;
            if (iArr[i42] != 0) {
                if (i42 == 34) {
                    return b3(i38, i40, 1);
                }
                int[] iArr3 = this.R;
                iArr3[0] = i38;
                return f3(1, i40, i42, 1, iArr3);
            }
            int i43 = (i40 << 8) | i42;
            int i44 = i24 + 7;
            this.r = i44;
            int i45 = bArr4[i41] & 255;
            if (iArr[i45] != 0) {
                if (i45 == 34) {
                    return b3(i38, i43, 2);
                }
                int[] iArr4 = this.R;
                iArr4[0] = i38;
                return f3(1, i43, i45, 2, iArr4);
            }
            int i46 = (i43 << 8) | i45;
            int i47 = i24 + 8;
            this.r = i47;
            int i48 = bArr4[i44] & 255;
            if (iArr[i48] != 0) {
                if (i48 == 34) {
                    return b3(i38, i46, 3);
                }
                int[] iArr5 = this.R;
                iArr5[0] = i38;
                return f3(1, i46, i48, 3, iArr5);
            }
            int i49 = (i46 << 8) | i48;
            int i50 = i24 + 9;
            this.r = i50;
            int i51 = bArr4[i47] & 255;
            if (iArr[i51] != 0) {
                if (i51 == 34) {
                    return b3(i38, i49, 4);
                }
                int[] iArr6 = this.R;
                iArr6[0] = i38;
                return f3(1, i49, i51, 4, iArr6);
            }
            int i52 = i24 + 10;
            this.r = i52;
            int i53 = bArr4[i50] & 255;
            if (iArr[i53] != 0) {
                return i53 == 34 ? c3(i38, i49, i51, 1) : g3(i38, i49, i51, i53, 1);
            }
            int i54 = (i51 << 8) | i53;
            int i55 = i24 + 11;
            this.r = i55;
            int i56 = bArr4[i52] & 255;
            if (iArr[i56] != 0) {
                return i56 == 34 ? c3(i38, i49, i54, 2) : g3(i38, i49, i54, i56, 2);
            }
            int i57 = (i54 << 8) | i56;
            int i58 = i24 + 12;
            this.r = i58;
            int i59 = bArr4[i55] & 255;
            if (iArr[i59] != 0) {
                return i59 == 34 ? c3(i38, i49, i57, 3) : g3(i38, i49, i57, i59, 3);
            }
            int i60 = (i57 << 8) | i59;
            this.r = i25;
            int i61 = bArr4[i58] & 255;
            if (iArr[i61] != 0) {
                return i61 == 34 ? c3(i38, i49, i60, 4) : g3(i38, i49, i60, i61, 4);
            }
            int[] iArr7 = this.R;
            iArr7[0] = i38;
            iArr7[1] = i49;
            iArr7[2] = i60;
            int i62 = i61;
            int i63 = 3;
            while (true) {
                int i64 = this.r;
                int i65 = i64 + 4;
                if (i65 > this.f13561s) {
                    return f3(i63, 0, i62, 0, this.R);
                }
                int i66 = i64 + 1;
                this.r = i66;
                int i67 = bArr4[i64] & 255;
                if (iArr[i67] != 0) {
                    return i67 == 34 ? d3(this.R, i63, i62, 1) : f3(i63, i62, i67, 1, this.R);
                }
                int i68 = (i62 << 8) | i67;
                int i69 = i64 + 2;
                this.r = i69;
                int i70 = bArr4[i66] & 255;
                if (iArr[i70] != 0) {
                    return i70 == 34 ? d3(this.R, i63, i68, 2) : f3(i63, i68, i70, 2, this.R);
                }
                int i71 = (i68 << 8) | i70;
                int i72 = i64 + 3;
                this.r = i72;
                int i73 = bArr4[i69] & 255;
                if (iArr[i73] != 0) {
                    return i73 == 34 ? d3(this.R, i63, i71, 3) : f3(i63, i71, i73, 3, this.R);
                }
                int i74 = (i71 << 8) | i73;
                this.r = i65;
                int i75 = bArr4[i72] & 255;
                if (iArr[i75] != 0) {
                    return i75 == 34 ? d3(this.R, i63, i74, 4) : f3(i63, i74, i75, 4, this.R);
                }
                int[] iArr8 = this.R;
                if (i63 >= iArr8.length) {
                    this.R = w2.b.Y1(iArr8, i63);
                }
                this.R[i63] = i74;
                i62 = i75;
                i63++;
            }
        }
    }

    @Override // w2.b
    public final void K1() {
    }
}
