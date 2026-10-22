package ob;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class h implements j, i, Cloneable, ByteChannel {

    /* renamed from: f, reason: collision with root package name */
    public f0 f7992f;

    /* renamed from: g, reason: collision with root package name */
    public long f7993g;

    @Override // ob.j
    public final long A(i iVar) {
        q7.k.e(iVar, "sink");
        long j2 = this.f7993g;
        if (j2 > 0) {
            iVar.write(this, j2);
        }
        return j2;
    }

    @Override // ob.j
    public final int B(y yVar) throws EOFException {
        q7.k.e(yVar, "options");
        int iC = pb.a.c(this, yVar, false);
        if (iC == -1) {
            return -1;
        }
        skip(yVar.f8040f[iC].d());
        return iC;
    }

    public final k C(int i2) {
        if (i2 == 0) {
            return k.f7997i;
        }
        b.e(this.f7993g, 0L, i2);
        f0 f0Var = this.f7992f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i2) {
            q7.k.b(f0Var);
            int i13 = f0Var.f7977c;
            int i14 = f0Var.f7976b;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            f0Var = f0Var.f7980f;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        f0 f0Var2 = this.f7992f;
        int i15 = 0;
        while (i10 < i2) {
            q7.k.b(f0Var2);
            bArr[i15] = f0Var2.f7975a;
            i10 += f0Var2.f7977c - f0Var2.f7976b;
            iArr[i15] = Math.min(i10, i2);
            iArr[i15 + i12] = f0Var2.f7976b;
            f0Var2.f7978d = true;
            i15++;
            f0Var2 = f0Var2.f7980f;
        }
        return new h0(bArr, iArr);
    }

    @Override // ob.j
    public final long D(k kVar) {
        q7.k.e(kVar, "bytes");
        return k(0L, kVar);
    }

    public final f0 E(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            f0 f0VarB = g0.b();
            this.f7992f = f0VarB;
            f0VarB.f7981g = f0VarB;
            f0VarB.f7980f = f0VarB;
            return f0VarB;
        }
        f0 f0Var2 = f0Var.f7981g;
        q7.k.b(f0Var2);
        if (f0Var2.f7977c + i2 <= 8192 && f0Var2.f7979e) {
            return f0Var2;
        }
        f0 f0VarB2 = g0.b();
        f0Var2.b(f0VarB2);
        return f0VarB2;
    }

    @Override // ob.j
    public final String F(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("limit < 0: ", j2).toString());
        }
        long j4 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
        long jI = i((byte) 10, 0L, j4);
        if (jI != -1) {
            return pb.a.b(this, jI);
        }
        if (j4 < this.f7993g && g(j4 - 1) == 13 && g(j4) == 10) {
            return pb.a.b(this, j4);
        }
        h hVar = new h();
        d(hVar, 0L, Math.min(32, this.f7993g));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f7993g, j2) + " content=" + hVar.j(hVar.f7993g).e() + (char) 8230);
    }

    public final void H(k kVar) {
        q7.k.e(kVar, "byteString");
        kVar.s(this, kVar.d());
    }

    @Override // ob.j
    public final void J(h hVar, long j2) throws EOFException {
        long j4 = this.f7993g;
        if (j4 >= j2) {
            hVar.write(this, j2);
        } else {
            hVar.write(this, j4);
            throw new EOFException();
        }
    }

    public final void K(k0 k0Var) {
        q7.k.e(k0Var, "source");
        while (k0Var.read(this, 8192L) != -1) {
        }
    }

    @Override // ob.j
    public final void L(long j2) throws EOFException {
        if (this.f7993g < j2) {
            throw new EOFException();
        }
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i M(String str) {
        U(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // ob.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long O() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f7993g
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            ob.f0 r7 = r15.f7992f
            q7.k.b(r7)
            byte[] r8 = r7.f7975a
            int r9 = r7.f7976b
            int r10 = r7.f7977c
        L17:
            if (r9 >= r10) goto L8e
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L26
            r12 = 57
            if (r11 > r12) goto L26
            int r12 = r11 + (-48)
            goto L3b
        L26:
            r12 = 97
            if (r11 < r12) goto L31
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L31
            int r12 = r11 + (-87)
            goto L3b
        L31:
            r12 = 65
            if (r11 < r12) goto L66
            r12 = 70
            if (r11 > r12) goto L66
            int r12 = r11 + (-55)
        L3b:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r13 = r13 & r4
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L4b
            r11 = 4
            long r4 = r4 << r11
            long r11 = (long) r12
            long r4 = r4 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            goto L17
        L4b:
            ob.h r15 = new ob.h
            r15.<init>()
            r15.R(r4)
            r15.Q(r11)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.z()
            java.lang.String r1 = "Number too large: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        L66:
            r6 = 1
            if (r1 == 0) goto L6a
            goto L8e
        L6a:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            int r1 = r11 >> 4
            r1 = r1 & 15
            char[] r2 = pb.b.f8577a
            char r1 = r2[r1]
            r3 = r11 & 15
            char r2 = r2[r3]
            r3 = 2
            char[] r3 = new char[r3]
            r3[r0] = r1
            r3[r6] = r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r1.concat(r0)
            r15.<init>(r0)
            throw r15
        L8e:
            if (r9 != r10) goto L9a
            ob.f0 r8 = r7.a()
            r15.f7992f = r8
            ob.g0.a(r7)
            goto L9c
        L9a:
            r7.f7976b = r9
        L9c:
            if (r6 != 0) goto La2
            ob.f0 r7 = r15.f7992f
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.f7993g
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f7993g = r2
            return r4
        La9:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.h.O():long");
    }

    @Override // ob.j
    public final String P(Charset charset) {
        return t(this.f7993g, charset);
    }

    public final void Q(int i2) {
        f0 f0VarE = E(1);
        byte[] bArr = f0VarE.f7975a;
        int i10 = f0VarE.f7977c;
        f0VarE.f7977c = i10 + 1;
        bArr[i10] = (byte) i2;
        this.f7993g++;
    }

    public final void R(long j2) {
        if (j2 == 0) {
            Q(48);
            return;
        }
        long j4 = (j2 >>> 1) | j2;
        long j10 = j4 | (j4 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i2 = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + 3) / 4);
        f0 f0VarE = E(i2);
        byte[] bArr = f0VarE.f7975a;
        int i10 = f0VarE.f7977c;
        for (int i11 = (i10 + i2) - 1; i11 >= i10; i11--) {
            bArr[i11] = pb.a.f8576a[(int) (15 & j2)];
            j2 >>>= 4;
        }
        f0VarE.f7977c += i2;
        this.f7993g += i2;
    }

    public final void S(int i2) {
        f0 f0VarE = E(4);
        byte[] bArr = f0VarE.f7975a;
        int i10 = f0VarE.f7977c;
        bArr[i10] = (byte) ((i2 >>> 24) & 255);
        bArr[i10 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i10 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i10 + 3] = (byte) (i2 & 255);
        f0VarE.f7977c = i10 + 4;
        this.f7993g += 4;
    }

    public final void T(int i2) {
        f0 f0VarE = E(2);
        byte[] bArr = f0VarE.f7975a;
        int i10 = f0VarE.f7977c;
        bArr[i10] = (byte) ((i2 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i2 & 255);
        f0VarE.f7977c = i10 + 2;
        this.f7993g += 2;
    }

    public final void U(String str) {
        q7.k.e(str, "string");
        V(str, 0, str.length());
    }

    public final void V(String str, int i2, int i10) {
        char cCharAt;
        q7.k.e(str, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException(n.f.c(i2, "beginIndex < 0: ").toString());
        }
        if (i10 < i2) {
            throw new IllegalArgumentException(m.x.k("endIndex < beginIndex: ", i10, i2, " < ").toString());
        }
        if (i10 > str.length()) {
            StringBuilder sbN = a1.a.n(i10, "endIndex > string.length: ", " > ");
            sbN.append(str.length());
            throw new IllegalArgumentException(sbN.toString().toString());
        }
        while (i2 < i10) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                f0 f0VarE = E(1);
                byte[] bArr = f0VarE.f7975a;
                int i11 = f0VarE.f7977c - i2;
                int iMin = Math.min(i10, 8192 - i11);
                int i12 = i2 + 1;
                bArr[i2 + i11] = (byte) cCharAt2;
                while (true) {
                    i2 = i12;
                    if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                        break;
                    }
                    i12 = i2 + 1;
                    bArr[i2 + i11] = (byte) cCharAt;
                }
                int i13 = f0VarE.f7977c;
                int i14 = (i11 + i2) - i13;
                f0VarE.f7977c = i13 + i14;
                this.f7993g += i14;
            } else {
                if (cCharAt2 < 2048) {
                    f0 f0VarE2 = E(2);
                    byte[] bArr2 = f0VarE2.f7975a;
                    int i15 = f0VarE2.f7977c;
                    bArr2[i15] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i15 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    f0VarE2.f7977c = i15 + 2;
                    this.f7993g += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    f0 f0VarE3 = E(3);
                    byte[] bArr3 = f0VarE3.f7975a;
                    int i16 = f0VarE3.f7977c;
                    bArr3[i16] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i16 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i16 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    f0VarE3.f7977c = i16 + 3;
                    this.f7993g += 3;
                } else {
                    int i17 = i2 + 1;
                    char cCharAt3 = i17 < i10 ? str.charAt(i17) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        Q(63);
                        i2 = i17;
                    } else {
                        int i18 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        f0 f0VarE4 = E(4);
                        byte[] bArr4 = f0VarE4.f7975a;
                        int i19 = f0VarE4.f7977c;
                        bArr4[i19] = (byte) ((i18 >> 18) | 240);
                        bArr4[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                        bArr4[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                        bArr4[i19 + 3] = (byte) ((i18 & 63) | 128);
                        f0VarE4.f7977c = i19 + 4;
                        this.f7993g += 4;
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    public final void W(int i2) {
        String str;
        if (i2 < 128) {
            Q(i2);
            return;
        }
        if (i2 < 2048) {
            f0 f0VarE = E(2);
            byte[] bArr = f0VarE.f7975a;
            int i10 = f0VarE.f7977c;
            bArr[i10] = (byte) ((i2 >> 6) | 192);
            bArr[i10 + 1] = (byte) ((i2 & 63) | 128);
            f0VarE.f7977c = i10 + 2;
            this.f7993g += 2;
            return;
        }
        if (55296 <= i2 && i2 < 57344) {
            Q(63);
            return;
        }
        if (i2 < 65536) {
            f0 f0VarE2 = E(3);
            byte[] bArr2 = f0VarE2.f7975a;
            int i11 = f0VarE2.f7977c;
            bArr2[i11] = (byte) ((i2 >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((i2 & 63) | 128);
            f0VarE2.f7977c = i11 + 3;
            this.f7993g += 3;
            return;
        }
        if (i2 <= 1114111) {
            f0 f0VarE3 = E(4);
            byte[] bArr3 = f0VarE3.f7975a;
            int i12 = f0VarE3.f7977c;
            bArr3[i12] = (byte) ((i2 >> 18) | 240);
            bArr3[i12 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i12 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i12 + 3] = (byte) ((i2 & 63) | 128);
            f0VarE3.f7977c = i12 + 4;
            this.f7993g += 4;
            return;
        }
        StringBuilder sb2 = new StringBuilder("Unexpected code point: 0x");
        if (i2 != 0) {
            char[] cArr = pb.b.f8577a;
            int i13 = 0;
            char[] cArr2 = {cArr[(i2 >> 28) & 15], cArr[(i2 >> 24) & 15], cArr[(i2 >> 20) & 15], cArr[(i2 >> 16) & 15], cArr[(i2 >> 12) & 15], cArr[(i2 >> 8) & 15], cArr[(i2 >> 4) & 15], cArr[i2 & 15]};
            while (i13 < 8 && cArr2[i13] == '0') {
                i13++;
            }
            if (i13 < 0) {
                throw new IndexOutOfBoundsException("startIndex: " + i13 + ", endIndex: 8, size: 8");
            }
            if (i13 > 8) {
                throw new IllegalArgumentException(m.x.k("startIndex: ", i13, 8, " > endIndex: "));
            }
            str = new String(cArr2, i13, 8 - i13);
        } else {
            str = "0";
        }
        sb2.append(str);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final void a() throws EOFException {
        skip(this.f7993g);
    }

    public final long b() {
        long j2 = this.f7993g;
        if (j2 == 0) {
            return 0L;
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        f0 f0Var2 = f0Var.f7981g;
        q7.k.b(f0Var2);
        return (f0Var2.f7977c >= 8192 || !f0Var2.f7979e) ? j2 : j2 - (r2 - f0Var2.f7976b);
    }

    @Override // ob.j
    public final h c() {
        return this;
    }

    public final Object clone() {
        h hVar = new h();
        if (this.f7993g == 0) {
            return hVar;
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        f0 f0VarC = f0Var.c();
        hVar.f7992f = f0VarC;
        f0VarC.f7981g = f0VarC;
        f0VarC.f7980f = f0VarC;
        for (f0 f0Var2 = f0Var.f7980f; f0Var2 != f0Var; f0Var2 = f0Var2.f7980f) {
            f0 f0Var3 = f0VarC.f7981g;
            q7.k.b(f0Var3);
            q7.k.b(f0Var2);
            f0Var3.b(f0Var2.c());
        }
        hVar.f7993g = this.f7993g;
        return hVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, ob.i0
    public final void close() {
    }

    public final void d(h hVar, long j2, long j4) {
        q7.k.e(hVar, "out");
        long j10 = j2;
        b.e(this.f7993g, j10, j4);
        if (j4 == 0) {
            return;
        }
        hVar.f7993g += j4;
        f0 f0Var = this.f7992f;
        while (true) {
            q7.k.b(f0Var);
            long j11 = f0Var.f7977c - f0Var.f7976b;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            f0Var = f0Var.f7980f;
        }
        long j12 = j4;
        while (j12 > 0) {
            q7.k.b(f0Var);
            f0 f0VarC = f0Var.c();
            int i2 = f0VarC.f7976b + ((int) j10);
            f0VarC.f7976b = i2;
            f0VarC.f7977c = Math.min(i2 + ((int) j12), f0VarC.f7977c);
            f0 f0Var2 = hVar.f7992f;
            if (f0Var2 == null) {
                f0VarC.f7981g = f0VarC;
                f0VarC.f7980f = f0VarC;
                hVar.f7992f = f0VarC;
            } else {
                f0 f0Var3 = f0Var2.f7981g;
                q7.k.b(f0Var3);
                f0Var3.b(f0VarC);
            }
            j12 -= f0VarC.f7977c - f0VarC.f7976b;
            f0Var = f0Var.f7980f;
            j10 = 0;
        }
    }

    public final boolean e() {
        return this.f7993g == 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        long j2 = this.f7993g;
        h hVar = (h) obj;
        if (j2 != hVar.f7993g) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        f0 f0Var2 = hVar.f7992f;
        q7.k.b(f0Var2);
        int i2 = f0Var.f7976b;
        int i10 = f0Var2.f7976b;
        long j4 = 0;
        while (j4 < this.f7993g) {
            long jMin = Math.min(f0Var.f7977c - i2, f0Var2.f7977c - i10);
            long j10 = 0;
            while (j10 < jMin) {
                int i11 = i2 + 1;
                int i12 = i10 + 1;
                if (f0Var.f7975a[i2] != f0Var2.f7975a[i10]) {
                    return false;
                }
                j10++;
                i2 = i11;
                i10 = i12;
            }
            if (i2 == f0Var.f7977c) {
                f0Var = f0Var.f7980f;
                q7.k.b(f0Var);
                i2 = f0Var.f7976b;
            }
            if (i10 == f0Var2.f7977c) {
                f0Var2 = f0Var2.f7980f;
                q7.k.b(f0Var2);
                i10 = f0Var2.f7976b;
            }
            j4 += jMin;
        }
        return true;
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i f(String str, int i2, int i10) {
        V(str, i2, i10);
        return this;
    }

    @Override // ob.i, ob.i0, java.io.Flushable
    public final void flush() {
    }

    public final byte g(long j2) {
        b.e(this.f7993g, j2, 1L);
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            q7.k.b(null);
            throw null;
        }
        long j4 = this.f7993g;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                f0Var = f0Var.f7981g;
                q7.k.b(f0Var);
                j4 -= f0Var.f7977c - f0Var.f7976b;
            }
            return f0Var.f7975a[(int) ((f0Var.f7976b + j2) - j4)];
        }
        long j10 = 0;
        while (true) {
            int i2 = f0Var.f7977c;
            int i10 = f0Var.f7976b;
            long j11 = (i2 - i10) + j10;
            if (j11 > j2) {
                return f0Var.f7975a[(int) ((i10 + j2) - j10)];
            }
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j10 = j11;
        }
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i h(long j2) {
        R(j2);
        return this;
    }

    public final int hashCode() {
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i10 = f0Var.f7977c;
            for (int i11 = f0Var.f7976b; i11 < i10; i11++) {
                i2 = (i2 * 31) + f0Var.f7975a[i11];
            }
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
        } while (f0Var != this.f7992f);
        return i2;
    }

    public final long i(byte b10, long j2, long j4) {
        f0 f0Var;
        long j10 = 0;
        if (0 > j2 || j2 > j4) {
            throw new IllegalArgumentException(("size=" + this.f7993g + " fromIndex=" + j2 + " toIndex=" + j4).toString());
        }
        long j11 = this.f7993g;
        if (j4 > j11) {
            j4 = j11;
        }
        if (j2 == j4 || (f0Var = this.f7992f) == null) {
            return -1L;
        }
        if (j11 - j2 < j2) {
            while (j11 > j2) {
                f0Var = f0Var.f7981g;
                q7.k.b(f0Var);
                j11 -= f0Var.f7977c - f0Var.f7976b;
            }
            while (j11 < j4) {
                byte[] bArr = f0Var.f7975a;
                int iMin = (int) Math.min(f0Var.f7977c, (f0Var.f7976b + j4) - j11);
                for (int i2 = (int) ((f0Var.f7976b + j2) - j11); i2 < iMin; i2++) {
                    if (bArr[i2] == b10) {
                        return (i2 - f0Var.f7976b) + j11;
                    }
                }
                j11 += f0Var.f7977c - f0Var.f7976b;
                f0Var = f0Var.f7980f;
                q7.k.b(f0Var);
                j2 = j11;
            }
            return -1L;
        }
        while (true) {
            long j12 = (f0Var.f7977c - f0Var.f7976b) + j10;
            if (j12 > j2) {
                break;
            }
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j10 = j12;
        }
        while (j10 < j4) {
            byte[] bArr2 = f0Var.f7975a;
            int iMin2 = (int) Math.min(f0Var.f7977c, (f0Var.f7976b + j4) - j10);
            for (int i10 = (int) ((f0Var.f7976b + j2) - j10); i10 < iMin2; i10++) {
                if (bArr2[i10] == b10) {
                    return (i10 - f0Var.f7976b) + j10;
                }
            }
            j10 += f0Var.f7977c - f0Var.f7976b;
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j2 = j10;
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // ob.j
    public final k j(long j2) throws EOFException {
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(a1.a.h("byteCount: ", j2).toString());
        }
        if (this.f7993g < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new k(r(j2));
        }
        k kVarC = C((int) j2);
        skip(j2);
        return kVarC;
    }

    public final long k(long j2, k kVar) {
        q7.k.e(kVar, "bytes");
        if (kVar.d() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j4 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("fromIndex < 0: ", j2).toString());
        }
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            return -1L;
        }
        long j10 = this.f7993g;
        if (j10 - j2 < j2) {
            while (j10 > j2) {
                f0Var = f0Var.f7981g;
                q7.k.b(f0Var);
                j10 -= f0Var.f7977c - f0Var.f7976b;
            }
            byte[] bArrH = kVar.h();
            byte b10 = bArrH[0];
            int iD = kVar.d();
            long j11 = (this.f7993g - iD) + 1;
            while (j10 < j11) {
                byte[] bArr = f0Var.f7975a;
                int iMin = (int) Math.min(f0Var.f7977c, (f0Var.f7976b + j11) - j10);
                for (int i2 = (int) ((f0Var.f7976b + j2) - j10); i2 < iMin; i2++) {
                    if (bArr[i2] == b10 && pb.a.a(f0Var, i2 + 1, bArrH, iD)) {
                        return (i2 - f0Var.f7976b) + j10;
                    }
                }
                j10 += f0Var.f7977c - f0Var.f7976b;
                f0Var = f0Var.f7980f;
                q7.k.b(f0Var);
                j2 = j10;
            }
            return -1L;
        }
        while (true) {
            long j12 = (f0Var.f7977c - f0Var.f7976b) + j4;
            if (j12 > j2) {
                break;
            }
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j4 = j12;
        }
        byte[] bArrH2 = kVar.h();
        byte b11 = bArrH2[0];
        int iD2 = kVar.d();
        long j13 = (this.f7993g - iD2) + 1;
        while (j4 < j13) {
            byte[] bArr2 = f0Var.f7975a;
            int iMin2 = (int) Math.min(f0Var.f7977c, (f0Var.f7976b + j13) - j4);
            for (int i10 = (int) ((f0Var.f7976b + j2) - j4); i10 < iMin2; i10++) {
                if (bArr2[i10] == b11 && pb.a.a(f0Var, i10 + 1, bArrH2, iD2)) {
                    return (i10 - f0Var.f7976b) + j4;
                }
            }
            j4 += f0Var.f7977c - f0Var.f7976b;
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j2 = j4;
        }
        return -1L;
    }

    @Override // ob.i
    public final i m() {
        return this;
    }

    public final long n(long j2, k kVar) {
        q7.k.e(kVar, "targetBytes");
        long j4 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("fromIndex < 0: ", j2).toString());
        }
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            return -1L;
        }
        long j10 = this.f7993g;
        if (j10 - j2 < j2) {
            while (j10 > j2) {
                f0Var = f0Var.f7981g;
                q7.k.b(f0Var);
                j10 -= f0Var.f7977c - f0Var.f7976b;
            }
            if (kVar.d() == 2) {
                byte bI = kVar.i(0);
                byte bI2 = kVar.i(1);
                while (j10 < this.f7993g) {
                    byte[] bArr = f0Var.f7975a;
                    int i2 = f0Var.f7977c;
                    for (int i10 = (int) ((f0Var.f7976b + j2) - j10); i10 < i2; i10++) {
                        byte b10 = bArr[i10];
                        if (b10 == bI || b10 == bI2) {
                            return (i10 - f0Var.f7976b) + j10;
                        }
                    }
                    j10 += f0Var.f7977c - f0Var.f7976b;
                    f0Var = f0Var.f7980f;
                    q7.k.b(f0Var);
                    j2 = j10;
                }
            } else {
                byte[] bArrH = kVar.h();
                while (j10 < this.f7993g) {
                    byte[] bArr2 = f0Var.f7975a;
                    int i11 = f0Var.f7977c;
                    for (int i12 = (int) ((f0Var.f7976b + j2) - j10); i12 < i11; i12++) {
                        byte b11 = bArr2[i12];
                        for (byte b12 : bArrH) {
                            if (b11 == b12) {
                                return (i12 - f0Var.f7976b) + j10;
                            }
                        }
                    }
                    j10 += f0Var.f7977c - f0Var.f7976b;
                    f0Var = f0Var.f7980f;
                    q7.k.b(f0Var);
                    j2 = j10;
                }
            }
            return -1L;
        }
        while (true) {
            long j11 = (f0Var.f7977c - f0Var.f7976b) + j4;
            if (j11 > j2) {
                break;
            }
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j4 = j11;
        }
        if (kVar.d() == 2) {
            byte bI3 = kVar.i(0);
            byte bI4 = kVar.i(1);
            while (j4 < this.f7993g) {
                byte[] bArr3 = f0Var.f7975a;
                int i13 = f0Var.f7977c;
                for (int i14 = (int) ((f0Var.f7976b + j2) - j4); i14 < i13; i14++) {
                    byte b13 = bArr3[i14];
                    if (b13 == bI3 || b13 == bI4) {
                        return (i14 - f0Var.f7976b) + j4;
                    }
                }
                j4 += f0Var.f7977c - f0Var.f7976b;
                f0Var = f0Var.f7980f;
                q7.k.b(f0Var);
                j2 = j4;
            }
        } else {
            byte[] bArrH2 = kVar.h();
            while (j4 < this.f7993g) {
                byte[] bArr4 = f0Var.f7975a;
                int i15 = f0Var.f7977c;
                for (int i16 = (int) ((f0Var.f7976b + j2) - j4); i16 < i15; i16++) {
                    byte b14 = bArr4[i16];
                    for (byte b15 : bArrH2) {
                        if (b14 == b15) {
                            return (i16 - f0Var.f7976b) + j4;
                        }
                    }
                }
                j4 += f0Var.f7977c - f0Var.f7976b;
                f0Var = f0Var.f7980f;
                q7.k.b(f0Var);
                j2 = j4;
            }
        }
        return -1L;
    }

    public final boolean o(long j2, k kVar) {
        q7.k.e(kVar, "bytes");
        int iD = kVar.d();
        if (j2 >= 0 && iD >= 0 && this.f7993g - j2 >= iD && kVar.d() >= iD) {
            for (int i2 = 0; i2 < iD; i2++) {
                if (g(i2 + j2) == kVar.i(i2)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // ob.j
    public final boolean p(long j2) {
        return this.f7993g >= j2;
    }

    @Override // ob.j
    public final e0 peek() {
        return b.c(new a0(this));
    }

    public final g q(g gVar) {
        q7.k.e(gVar, "unsafeCursor");
        byte[] bArr = pb.a.f8576a;
        if (gVar == b.f7952a) {
            gVar = new g();
        }
        if (gVar.f7982f != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        gVar.f7982f = this;
        gVar.f7983g = true;
        return gVar;
    }

    public final byte[] r(long j2) throws EOFException {
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(a1.a.h("byteCount: ", j2).toString());
        }
        if (this.f7993g < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        readFully(bArr);
        return bArr;
    }

    @Override // ob.k0
    public final long read(h hVar, long j2) {
        q7.k.e(hVar, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        long j4 = this.f7993g;
        if (j4 == 0) {
            return -1L;
        }
        if (j2 > j4) {
            j2 = j4;
        }
        hVar.write(this, j2);
        return j2;
    }

    @Override // ob.j
    public final byte readByte() throws EOFException {
        if (this.f7993g == 0) {
            throw new EOFException();
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        int i2 = f0Var.f7976b;
        int i10 = f0Var.f7977c;
        int i11 = i2 + 1;
        byte b10 = f0Var.f7975a[i2];
        this.f7993g--;
        if (i11 != i10) {
            f0Var.f7976b = i11;
            return b10;
        }
        this.f7992f = f0Var.a();
        g0.a(f0Var);
        return b10;
    }

    @Override // ob.j
    public final void readFully(byte[] bArr) throws EOFException {
        q7.k.e(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int i10 = read(bArr, i2, bArr.length - i2);
            if (i10 == -1) {
                throw new EOFException();
            }
            i2 += i10;
        }
    }

    @Override // ob.j
    public final int readInt() throws EOFException {
        if (this.f7993g < 4) {
            throw new EOFException();
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        int i2 = f0Var.f7976b;
        int i10 = f0Var.f7977c;
        if (i10 - i2 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = f0Var.f7975a;
        int i11 = i2 + 3;
        int i12 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i13 = i2 + 4;
        int i14 = (bArr[i11] & 255) | i12;
        this.f7993g -= 4;
        if (i13 != i10) {
            f0Var.f7976b = i13;
            return i14;
        }
        this.f7992f = f0Var.a();
        g0.a(f0Var);
        return i14;
    }

    @Override // ob.j
    public final long readLong() throws EOFException {
        if (this.f7993g < 8) {
            throw new EOFException();
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        int i2 = f0Var.f7976b;
        int i10 = f0Var.f7977c;
        if (i10 - i2 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = f0Var.f7975a;
        int i11 = i2 + 7;
        long j2 = ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
        int i12 = i2 + 8;
        long j4 = j2 | (bArr[i11] & 255);
        this.f7993g -= 8;
        if (i12 != i10) {
            f0Var.f7976b = i12;
            return j4;
        }
        this.f7992f = f0Var.a();
        g0.a(f0Var);
        return j4;
    }

    @Override // ob.j
    public final short readShort() throws EOFException {
        if (this.f7993g < 2) {
            throw new EOFException();
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        int i2 = f0Var.f7976b;
        int i10 = f0Var.f7977c;
        if (i10 - i2 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = f0Var.f7975a;
        int i11 = i2 + 1;
        int i12 = (bArr[i2] & 255) << 8;
        int i13 = i2 + 2;
        int i14 = (bArr[i11] & 255) | i12;
        this.f7993g -= 2;
        if (i13 == i10) {
            this.f7992f = f0Var.a();
            g0.a(f0Var);
        } else {
            f0Var.f7976b = i13;
        }
        return (short) i14;
    }

    public final short s() throws EOFException {
        short s10 = readShort();
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    @Override // ob.j
    public final void skip(long j2) throws EOFException {
        while (j2 > 0) {
            f0 f0Var = this.f7992f;
            if (f0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, f0Var.f7977c - f0Var.f7976b);
            long j4 = iMin;
            this.f7993g -= j4;
            j2 -= j4;
            int i2 = f0Var.f7976b + iMin;
            f0Var.f7976b = i2;
            if (i2 == f0Var.f7977c) {
                this.f7992f = f0Var.a();
                g0.a(f0Var);
            }
        }
    }

    public final String t(long j2, Charset charset) throws EOFException {
        q7.k.e(charset, "charset");
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(a1.a.h("byteCount: ", j2).toString());
        }
        if (this.f7993g < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        f0 f0Var = this.f7992f;
        q7.k.b(f0Var);
        int i2 = f0Var.f7976b;
        if (i2 + j2 > f0Var.f7977c) {
            return new String(r(j2), charset);
        }
        int i10 = (int) j2;
        String str = new String(f0Var.f7975a, i2, i10, charset);
        int i11 = f0Var.f7976b + i10;
        f0Var.f7976b = i11;
        this.f7993g -= j2;
        if (i11 == f0Var.f7977c) {
            this.f7992f = f0Var.a();
            g0.a(f0Var);
        }
        return str;
    }

    @Override // ob.k0
    public final m0 timeout() {
        return m0.f8007d;
    }

    public final String toString() {
        long j2 = this.f7993g;
        if (j2 <= 2147483647L) {
            return C((int) j2).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f7993g).toString());
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i v(k kVar) {
        H(kVar);
        return this;
    }

    @Override // ob.j
    public final String w() {
        return F(Long.MAX_VALUE);
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i write(byte[] bArr) {
        m22write(bArr);
        return this;
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i writeByte(int i2) {
        Q(i2);
        return this;
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i writeInt(int i2) {
        S(i2);
        return this;
    }

    @Override // ob.i
    public final /* bridge */ /* synthetic */ i writeShort(int i2) {
        T(i2);
        return this;
    }

    @Override // ob.j
    public final long y(k kVar) {
        q7.k.e(kVar, "targetBytes");
        return n(0L, kVar);
    }

    public final String z() {
        return t(this.f7993g, ga.a.f4005a);
    }

    @Override // ob.i0
    public final void write(h hVar, long j2) {
        f0 f0VarB;
        q7.k.e(hVar, "source");
        if (hVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        b.e(hVar.f7993g, 0L, j2);
        while (j2 > 0) {
            f0 f0Var = hVar.f7992f;
            q7.k.b(f0Var);
            int i2 = f0Var.f7977c;
            f0 f0Var2 = hVar.f7992f;
            q7.k.b(f0Var2);
            long j4 = i2 - f0Var2.f7976b;
            int i10 = 0;
            if (j2 < j4) {
                f0 f0Var3 = this.f7992f;
                f0 f0Var4 = f0Var3 != null ? f0Var3.f7981g : null;
                if (f0Var4 != null && f0Var4.f7979e) {
                    if ((f0Var4.f7977c + j2) - (f0Var4.f7978d ? 0 : f0Var4.f7976b) <= 8192) {
                        f0 f0Var5 = hVar.f7992f;
                        q7.k.b(f0Var5);
                        f0Var5.d(f0Var4, (int) j2);
                        hVar.f7993g -= j2;
                        this.f7993g += j2;
                        return;
                    }
                }
                f0 f0Var6 = hVar.f7992f;
                q7.k.b(f0Var6);
                int i11 = (int) j2;
                if (i11 <= 0 || i11 > f0Var6.f7977c - f0Var6.f7976b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i11 >= 1024) {
                    f0VarB = f0Var6.c();
                } else {
                    f0VarB = g0.b();
                    byte[] bArr = f0Var6.f7975a;
                    byte[] bArr2 = f0VarB.f7975a;
                    int i12 = f0Var6.f7976b;
                    d7.n.V(0, i12, i12 + i11, bArr, bArr2);
                }
                f0VarB.f7977c = f0VarB.f7976b + i11;
                f0Var6.f7976b += i11;
                f0 f0Var7 = f0Var6.f7981g;
                q7.k.b(f0Var7);
                f0Var7.b(f0VarB);
                hVar.f7992f = f0VarB;
            }
            f0 f0Var8 = hVar.f7992f;
            q7.k.b(f0Var8);
            long j10 = f0Var8.f7977c - f0Var8.f7976b;
            hVar.f7992f = f0Var8.a();
            f0 f0Var9 = this.f7992f;
            if (f0Var9 == null) {
                this.f7992f = f0Var8;
                f0Var8.f7981g = f0Var8;
                f0Var8.f7980f = f0Var8;
            } else {
                f0 f0Var10 = f0Var9.f7981g;
                q7.k.b(f0Var10);
                f0Var10.b(f0Var8);
                f0 f0Var11 = f0Var8.f7981g;
                if (f0Var11 == f0Var8) {
                    throw new IllegalStateException("cannot compact");
                }
                q7.k.b(f0Var11);
                if (f0Var11.f7979e) {
                    int i13 = f0Var8.f7977c - f0Var8.f7976b;
                    f0 f0Var12 = f0Var8.f7981g;
                    q7.k.b(f0Var12);
                    int i14 = 8192 - f0Var12.f7977c;
                    f0 f0Var13 = f0Var8.f7981g;
                    q7.k.b(f0Var13);
                    if (!f0Var13.f7978d) {
                        f0 f0Var14 = f0Var8.f7981g;
                        q7.k.b(f0Var14);
                        i10 = f0Var14.f7976b;
                    }
                    if (i13 <= i14 + i10) {
                        f0 f0Var15 = f0Var8.f7981g;
                        q7.k.b(f0Var15);
                        f0Var8.d(f0Var15, i13);
                        f0Var8.a();
                        g0.a(f0Var8);
                    }
                }
            }
            hVar.f7993g -= j10;
            this.f7993g += j10;
            j2 -= j10;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        q7.k.e(byteBuffer, "sink");
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), f0Var.f7977c - f0Var.f7976b);
        byteBuffer.put(f0Var.f7975a, f0Var.f7976b, iMin);
        int i2 = f0Var.f7976b + iMin;
        f0Var.f7976b = i2;
        this.f7993g -= iMin;
        if (i2 == f0Var.f7977c) {
            this.f7992f = f0Var.a();
            g0.a(f0Var);
        }
        return iMin;
    }

    public final int read(byte[] bArr, int i2, int i10) {
        q7.k.e(bArr, "sink");
        b.e(bArr.length, i2, i10);
        f0 f0Var = this.f7992f;
        if (f0Var == null) {
            return -1;
        }
        int iMin = Math.min(i10, f0Var.f7977c - f0Var.f7976b);
        byte[] bArr2 = f0Var.f7975a;
        int i11 = f0Var.f7976b;
        d7.n.V(i2, i11, i11 + iMin, bArr2, bArr);
        int i12 = f0Var.f7976b + iMin;
        f0Var.f7976b = i12;
        this.f7993g -= iMin;
        if (i12 == f0Var.f7977c) {
            this.f7992f = f0Var.a();
            g0.a(f0Var);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        q7.k.e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            f0 f0VarE = E(1);
            int iMin = Math.min(i2, 8192 - f0VarE.f7977c);
            byteBuffer.get(f0VarE.f7975a, f0VarE.f7977c, iMin);
            i2 -= iMin;
            f0VarE.f7977c += iMin;
        }
        this.f7993g += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m22write(byte[] bArr) {
        q7.k.e(bArr, "source");
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i2, int i10) {
        q7.k.e(bArr, "source");
        long j2 = i10;
        b.e(bArr.length, i2, j2);
        int i11 = i10 + i2;
        while (i2 < i11) {
            f0 f0VarE = E(1);
            int iMin = Math.min(i11 - i2, 8192 - f0VarE.f7977c);
            int i12 = i2 + iMin;
            d7.n.V(f0VarE.f7977c, i2, i12, bArr, f0VarE.f7975a);
            f0VarE.f7977c += iMin;
            i2 = i12;
        }
        this.f7993g += j2;
    }
}
