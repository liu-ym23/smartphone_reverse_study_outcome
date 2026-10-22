package V9;

import D7.AbstractC0214f;
import D7.C0211c;
import androidx.collection.SieveCacheKt;
import androidx.compose.animation.core.AnimationKt;
import j9.AbstractC1607a;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;
import okio.SegmentedByteString;

/* loaded from: classes4.dex */
public final class g implements i, h, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public s f1418a;
    public long b;

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h A(ByteString byteString) {
        K(byteString);
        return this;
    }

    @Override // V9.h
    public final long B(w source) {
        kotlin.jvm.internal.k.f(source, "source");
        long j5 = 0;
        while (true) {
            long jE = source.e(this, 8192L);
            if (jE == -1) {
                return j5;
            }
            j5 += jE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // V9.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long C() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            V9.s r7 = r15.f1418a
            kotlin.jvm.internal.k.c(r7)
            byte[] r8 = r7.f1426a
            int r9 = r7.b
            int r10 = r7.c
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
            V9.g r15 = new V9.g
            r15.<init>()
            r15.N(r4)
            r15.L(r11)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.G()
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
            char[] r2 = W9.b.f1497a
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
            V9.s r8 = r7.a()
            r15.f1418a = r8
            V9.t.a(r7)
            goto L9c
        L9a:
            r7.b = r9
        L9c:
            if (r6 != 0) goto La2
            V9.s r7 = r15.f1418a
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.b = r2
            return r4
        La9:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: V9.g.C():long");
    }

    @Override // V9.i
    public final InputStream D() {
        return new e(this, 0);
    }

    public final byte[] E(long j5) throws EOFException {
        if (j5 < 0 || j5 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount: ").toString());
        }
        if (this.b < j5) {
            throw new EOFException();
        }
        int i = (int) j5;
        byte[] bArr = new byte[i];
        int i6 = 0;
        while (i6 < i) {
            int i10 = read(bArr, i6, i - i6);
            if (i10 == -1) {
                throw new EOFException();
            }
            i6 += i10;
        }
        return bArr;
    }

    public final String F(long j5, Charset charset) throws EOFException {
        kotlin.jvm.internal.k.f(charset, "charset");
        if (j5 < 0 || j5 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount: ").toString());
        }
        if (this.b < j5) {
            throw new EOFException();
        }
        if (j5 == 0) {
            return "";
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        int i = sVar.b;
        if (i + j5 > sVar.c) {
            return new String(E(j5), charset);
        }
        int i6 = (int) j5;
        String str = new String(sVar.f1426a, i, i6, charset);
        int i10 = sVar.b + i6;
        sVar.b = i10;
        this.b -= j5;
        if (i10 == sVar.c) {
            this.f1418a = sVar.a();
            t.a(sVar);
        }
        return str;
    }

    public final String G() {
        return F(this.b, AbstractC1607a.f4778a);
    }

    public final int H() {
        int i;
        int i6;
        int i10;
        if (this.b == 0) {
            throw new EOFException();
        }
        byte bR = r(0L);
        if ((bR & 128) == 0) {
            i = bR & 127;
            i10 = 0;
            i6 = 1;
        } else if ((bR & 224) == 192) {
            i = bR & 31;
            i6 = 2;
            i10 = 128;
        } else if ((bR & 240) == 224) {
            i = bR & 15;
            i6 = 3;
            i10 = 2048;
        } else {
            if ((bR & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bR & 7;
            i6 = 4;
            i10 = 65536;
        }
        long j5 = i6;
        if (this.b < j5) {
            StringBuilder sbU = B7.a.u(i6, "size < ", ": ");
            sbU.append(this.b);
            sbU.append(" (to read code point prefixed 0x");
            char[] cArr = W9.b.f1497a;
            sbU.append(new String(new char[]{cArr[(bR >> 4) & 15], cArr[bR & 15]}));
            sbU.append(')');
            throw new EOFException(sbU.toString());
        }
        for (int i11 = 1; i11 < i6; i11++) {
            long j6 = i11;
            byte bR2 = r(j6);
            if ((bR2 & 192) != 128) {
                skip(j6);
                return 65533;
            }
            i = (i << 6) | (bR2 & 63);
        }
        skip(j5);
        if (i <= 1114111 && ((55296 > i || i >= 57344) && i >= i10)) {
            return i;
        }
        return 65533;
    }

    public final ByteString I(int i) {
        if (i == 0) {
            return ByteString.d;
        }
        H4.o.t(this.b, 0L, i);
        s sVar = this.f1418a;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            kotlin.jvm.internal.k.c(sVar);
            int i12 = sVar.c;
            int i13 = sVar.b;
            if (i12 == i13) {
                throw new AssertionError("s.limit == s.pos");
            }
            i10 += i12 - i13;
            i11++;
            sVar = sVar.f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        s sVar2 = this.f1418a;
        int i14 = 0;
        while (i6 < i) {
            kotlin.jvm.internal.k.c(sVar2);
            bArr[i14] = sVar2.f1426a;
            i6 += sVar2.c - sVar2.b;
            iArr[i14] = Math.min(i6, i);
            iArr[i14 + i11] = sVar2.b;
            sVar2.d = true;
            i14++;
            sVar2 = sVar2.f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public final s J(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        s sVar = this.f1418a;
        if (sVar == null) {
            s sVarB = t.b();
            this.f1418a = sVarB;
            sVarB.g = sVarB;
            sVarB.f = sVarB;
            return sVarB;
        }
        s sVar2 = sVar.g;
        kotlin.jvm.internal.k.c(sVar2);
        if (sVar2.c + i <= 8192 && sVar2.e) {
            return sVar2;
        }
        s sVarB2 = t.b();
        sVar2.b(sVarB2);
        return sVarB2;
    }

    public final void K(ByteString byteString) {
        kotlin.jvm.internal.k.f(byteString, "byteString");
        byteString.k(this, byteString.c());
    }

    public final void L(int i) {
        s sVarJ = J(1);
        byte[] bArr = sVarJ.f1426a;
        int i6 = sVarJ.c;
        sVarJ.c = i6 + 1;
        bArr[i6] = (byte) i;
        this.b++;
    }

    public final void M(long j5) {
        boolean z10;
        if (j5 == 0) {
            L(48);
            return;
        }
        int i = 1;
        if (j5 < 0) {
            j5 = -j5;
            if (j5 < 0) {
                R("-9223372036854775808");
                return;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j5 >= 100000000) {
            i = j5 < 1000000000000L ? j5 < 10000000000L ? j5 < 1000000000 ? 9 : 10 : j5 < 100000000000L ? 11 : 12 : j5 < 1000000000000000L ? j5 < 10000000000000L ? 13 : j5 < 100000000000000L ? 14 : 15 : j5 < 100000000000000000L ? j5 < 10000000000000000L ? 16 : 17 : j5 < 1000000000000000000L ? 18 : 19;
        } else if (j5 >= 10000) {
            i = j5 < AnimationKt.MillisToNanos ? j5 < 100000 ? 5 : 6 : j5 < 10000000 ? 7 : 8;
        } else if (j5 >= 100) {
            i = j5 < 1000 ? 3 : 4;
        } else if (j5 >= 10) {
            i = 2;
        }
        if (z10) {
            i++;
        }
        s sVarJ = J(i);
        byte[] bArr = sVarJ.f1426a;
        int i6 = sVarJ.c + i;
        while (j5 != 0) {
            long j6 = 10;
            i6--;
            bArr[i6] = W9.a.f1496a[(int) (j5 % j6)];
            j5 /= j6;
        }
        if (z10) {
            bArr[i6 - 1] = 45;
        }
        sVarJ.c += i;
        this.b += i;
    }

    public final void N(long j5) {
        if (j5 == 0) {
            L(48);
            return;
        }
        long j6 = (j5 >>> 1) | j5;
        long j10 = j6 | (j6 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + 3) / 4);
        s sVarJ = J(i);
        byte[] bArr = sVarJ.f1426a;
        int i6 = sVarJ.c;
        for (int i10 = (i6 + i) - 1; i10 >= i6; i10--) {
            bArr[i10] = W9.a.f1496a[(int) (15 & j5)];
            j5 >>>= 4;
        }
        sVarJ.c += i;
        this.b += i;
    }

    public final void O(int i) {
        s sVarJ = J(4);
        byte[] bArr = sVarJ.f1426a;
        int i6 = sVarJ.c;
        bArr[i6] = (byte) ((i >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i & 255);
        sVarJ.c = i6 + 4;
        this.b += 4;
    }

    public final void P(int i) {
        s sVarJ = J(2);
        byte[] bArr = sVarJ.f1426a;
        int i6 = sVarJ.c;
        bArr[i6] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i & 255);
        sVarJ.c = i6 + 2;
        this.b += 2;
    }

    public final void Q(int i, int i6, String string) {
        char cCharAt;
        kotlin.jvm.internal.k.f(string, "string");
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "beginIndex < 0: ").toString());
        }
        if (i6 < i) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(i6, i, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i6 > string.length()) {
            StringBuilder sbU = B7.a.u(i6, "endIndex > string.length: ", " > ");
            sbU.append(string.length());
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        while (i < i6) {
            char cCharAt2 = string.charAt(i);
            if (cCharAt2 < 128) {
                s sVarJ = J(1);
                byte[] bArr = sVarJ.f1426a;
                int i10 = sVarJ.c - i;
                int iMin = Math.min(i6, 8192 - i10);
                int i11 = i + 1;
                bArr[i + i10] = (byte) cCharAt2;
                while (true) {
                    i = i11;
                    if (i >= iMin || (cCharAt = string.charAt(i)) >= 128) {
                        break;
                    }
                    i11 = i + 1;
                    bArr[i + i10] = (byte) cCharAt;
                }
                int i12 = sVarJ.c;
                int i13 = (i10 + i) - i12;
                sVarJ.c = i12 + i13;
                this.b += i13;
            } else {
                if (cCharAt2 < 2048) {
                    s sVarJ2 = J(2);
                    byte[] bArr2 = sVarJ2.f1426a;
                    int i14 = sVarJ2.c;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    sVarJ2.c = i14 + 2;
                    this.b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    s sVarJ3 = J(3);
                    byte[] bArr3 = sVarJ3.f1426a;
                    int i15 = sVarJ3.c;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    sVarJ3.c = i15 + 3;
                    this.b += 3;
                } else {
                    int i16 = i + 1;
                    char cCharAt3 = i16 < i6 ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        L(63);
                        i = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        s sVarJ4 = J(4);
                        byte[] bArr4 = sVarJ4.f1426a;
                        int i18 = sVarJ4.c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        sVarJ4.c = i18 + 4;
                        this.b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void R(String string) {
        kotlin.jvm.internal.k.f(string, "string");
        Q(0, string.length(), string);
    }

    public final void S(int i) {
        String str;
        if (i < 128) {
            L(i);
            return;
        }
        if (i < 2048) {
            s sVarJ = J(2);
            byte[] bArr = sVarJ.f1426a;
            int i6 = sVarJ.c;
            bArr[i6] = (byte) ((i >> 6) | 192);
            bArr[i6 + 1] = (byte) ((i & 63) | 128);
            sVarJ.c = i6 + 2;
            this.b += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            L(63);
            return;
        }
        if (i < 65536) {
            s sVarJ2 = J(3);
            byte[] bArr2 = sVarJ2.f1426a;
            int i10 = sVarJ2.c;
            bArr2[i10] = (byte) ((i >> 12) | 224);
            bArr2[i10 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i10 + 2] = (byte) ((i & 63) | 128);
            sVarJ2.c = i10 + 3;
            this.b += 3;
            return;
        }
        if (i <= 1114111) {
            s sVarJ3 = J(4);
            byte[] bArr3 = sVarJ3.f1426a;
            int i11 = sVarJ3.c;
            bArr3[i11] = (byte) ((i >> 18) | 240);
            bArr3[i11 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i11 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i11 + 3] = (byte) ((i & 63) | 128);
            sVarJ3.c = i11 + 4;
            this.b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = W9.b.f1497a;
            int i12 = 0;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            while (i12 < 8 && cArr2[i12] == '0') {
                i12++;
            }
            AbstractC0214f.Companion.getClass();
            C0211c.a(i12, 8, 8);
            str = new String(cArr2, i12, 8 - i12);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // V9.i, V9.h
    public final g a() {
        return this;
    }

    public final void b() throws EOFException {
        skip(this.b);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final g clone() {
        g gVar = new g();
        if (this.b == 0) {
            return gVar;
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        s sVarC = sVar.c();
        gVar.f1418a = sVarC;
        sVarC.g = sVarC;
        sVarC.f = sVarC;
        for (s sVar2 = sVar.f; sVar2 != sVar; sVar2 = sVar2.f) {
            s sVar3 = sVarC.g;
            kotlin.jvm.internal.k.c(sVar3);
            kotlin.jvm.internal.k.c(sVar2);
            sVar3.b(sVar2.c());
        }
        gVar.b = this.b;
        return gVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, V9.u
    public final void close() {
    }

    @Override // V9.i
    public final g d() {
        return this;
    }

    @Override // V9.w
    public final long e(g sink, long j5) {
        kotlin.jvm.internal.k.f(sink, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount < 0: ").toString());
        }
        long j6 = this.b;
        if (j6 == 0) {
            return -1L;
        }
        if (j5 > j6) {
            j5 = j6;
        }
        sink.write(this, j5);
        return j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        long j5 = this.b;
        g gVar = (g) obj;
        if (j5 != gVar.b) {
            return false;
        }
        if (j5 == 0) {
            return true;
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        s sVar2 = gVar.f1418a;
        kotlin.jvm.internal.k.c(sVar2);
        int i = sVar.b;
        int i6 = sVar2.b;
        long j6 = 0;
        while (j6 < this.b) {
            long jMin = Math.min(sVar.c - i, sVar2.c - i6);
            long j10 = 0;
            while (j10 < jMin) {
                int i10 = i + 1;
                int i11 = i6 + 1;
                if (sVar.f1426a[i] != sVar2.f1426a[i6]) {
                    return false;
                }
                j10++;
                i = i10;
                i6 = i11;
            }
            if (i == sVar.c) {
                sVar = sVar.f;
                kotlin.jvm.internal.k.c(sVar);
                i = sVar.b;
            }
            if (i6 == sVar2.c) {
                sVar2 = sVar2.f;
                kotlin.jvm.internal.k.c(sVar2);
                i6 = sVar2.b;
            }
            j6 += jMin;
        }
        return true;
    }

    public final long f() {
        long j5 = this.b;
        if (j5 == 0) {
            return 0L;
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        s sVar2 = sVar.g;
        kotlin.jvm.internal.k.c(sVar2);
        return (sVar2.c >= 8192 || !sVar2.e) ? j5 : j5 - (r2 - sVar2.b);
    }

    @Override // V9.h, V9.u, java.io.Flushable
    public final void flush() {
    }

    @Override // V9.i
    public final long h(ByteString targetBytes) {
        kotlin.jvm.internal.k.f(targetBytes, "targetBytes");
        return w(targetBytes, 0L);
    }

    public final int hashCode() {
        s sVar = this.f1418a;
        if (sVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i6 = sVar.c;
            for (int i10 = sVar.b; i10 < i6; i10++) {
                i = (i * 31) + sVar.f1426a[i10];
            }
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
        } while (sVar != this.f1418a);
        return i;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // V9.i
    public final String j(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "limit < 0: ").toString());
        }
        long j6 = j5 != Long.MAX_VALUE ? j5 + 1 : Long.MAX_VALUE;
        long jS = s((byte) 10, 0L, j6);
        if (jS != -1) {
            return W9.a.a(this, jS);
        }
        if (j6 < this.b && r(j6 - 1) == 13 && r(j6) == 10) {
            return W9.a.a(this, j6);
        }
        g gVar = new g();
        k(gVar, 0L, Math.min(32, this.b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b, j5) + " content=" + gVar.v(gVar.b).d() + (char) 8230);
    }

    public final void k(g out, long j5, long j6) {
        kotlin.jvm.internal.k.f(out, "out");
        long j10 = j5;
        H4.o.t(this.b, j10, j6);
        if (j6 == 0) {
            return;
        }
        out.b += j6;
        s sVar = this.f1418a;
        while (true) {
            kotlin.jvm.internal.k.c(sVar);
            long j11 = sVar.c - sVar.b;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            sVar = sVar.f;
        }
        long j12 = j6;
        while (j12 > 0) {
            kotlin.jvm.internal.k.c(sVar);
            s sVarC = sVar.c();
            int i = sVarC.b + ((int) j10);
            sVarC.b = i;
            sVarC.c = Math.min(i + ((int) j12), sVarC.c);
            s sVar2 = out.f1418a;
            if (sVar2 == null) {
                sVarC.g = sVarC;
                sVarC.f = sVarC;
                out.f1418a = sVarC;
            } else {
                s sVar3 = sVar2.g;
                kotlin.jvm.internal.k.c(sVar3);
                sVar3.b(sVarC);
            }
            j12 -= sVarC.c - sVarC.b;
            sVar = sVar.f;
            j10 = 0;
        }
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h m(String str) {
        R(str);
        return this;
    }

    public final boolean n() {
        return this.b == 0;
    }

    @Override // V9.i
    public final long o(g gVar) {
        long j5 = this.b;
        if (j5 > 0) {
            gVar.write(this, j5);
        }
        return j5;
    }

    @Override // V9.i
    public final void p(g gVar, long j5) throws EOFException {
        long j6 = this.b;
        if (j6 >= j5) {
            gVar.write(this, j5);
        } else {
            gVar.write(this, j6);
            throw new EOFException();
        }
    }

    @Override // V9.i
    public final String q() {
        return j(Long.MAX_VALUE);
    }

    public final byte r(long j5) {
        H4.o.t(this.b, j5, 1L);
        s sVar = this.f1418a;
        if (sVar == null) {
            kotlin.jvm.internal.k.c(null);
            throw null;
        }
        long j6 = this.b;
        if (j6 - j5 < j5) {
            while (j6 > j5) {
                sVar = sVar.g;
                kotlin.jvm.internal.k.c(sVar);
                j6 -= sVar.c - sVar.b;
            }
            return sVar.f1426a[(int) ((sVar.b + j5) - j6)];
        }
        long j10 = 0;
        while (true) {
            int i = sVar.c;
            int i6 = sVar.b;
            long j11 = (i - i6) + j10;
            if (j11 > j5) {
                return sVar.f1426a[(int) ((i6 + j5) - j10)];
            }
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
            j10 = j11;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.f(sink, "sink");
        s sVar = this.f1418a;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), sVar.c - sVar.b);
        sink.put(sVar.f1426a, sVar.b, iMin);
        int i = sVar.b + iMin;
        sVar.b = i;
        this.b -= iMin;
        if (i == sVar.c) {
            this.f1418a = sVar.a();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // V9.i
    public final byte readByte() throws EOFException {
        if (this.b == 0) {
            throw new EOFException();
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        int i = sVar.b;
        int i6 = sVar.c;
        int i10 = i + 1;
        byte b = sVar.f1426a[i];
        this.b--;
        if (i10 != i6) {
            sVar.b = i10;
            return b;
        }
        this.f1418a = sVar.a();
        t.a(sVar);
        return b;
    }

    @Override // V9.i
    public final int readInt() throws EOFException {
        if (this.b < 4) {
            throw new EOFException();
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        int i = sVar.b;
        int i6 = sVar.c;
        if (i6 - i < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = sVar.f1426a;
        int i10 = i + 3;
        int i11 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i12 = i + 4;
        int i13 = (bArr[i10] & 255) | i11;
        this.b -= 4;
        if (i12 != i6) {
            sVar.b = i12;
            return i13;
        }
        this.f1418a = sVar.a();
        t.a(sVar);
        return i13;
    }

    @Override // V9.i
    public final short readShort() throws EOFException {
        if (this.b < 2) {
            throw new EOFException();
        }
        s sVar = this.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        int i = sVar.b;
        int i6 = sVar.c;
        if (i6 - i < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = sVar.f1426a;
        int i10 = i + 1;
        int i11 = (bArr[i] & 255) << 8;
        int i12 = i + 2;
        int i13 = (bArr[i10] & 255) | i11;
        this.b -= 2;
        if (i12 == i6) {
            this.f1418a = sVar.a();
            t.a(sVar);
        } else {
            sVar.b = i12;
        }
        return (short) i13;
    }

    @Override // V9.i
    public final boolean request(long j5) {
        return this.b >= Long.MAX_VALUE;
    }

    public final long s(byte b, long j5, long j6) {
        s sVar;
        long j10 = 0;
        if (0 > j5 || j5 > j6) {
            StringBuilder sb = new StringBuilder("size=");
            sb.append(this.b);
            androidx.compose.foundation.b.y(j5, " fromIndex=", " toIndex=", sb);
            sb.append(j6);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        long j11 = this.b;
        if (j6 > j11) {
            j6 = j11;
        }
        if (j5 == j6 || (sVar = this.f1418a) == null) {
            return -1L;
        }
        if (j11 - j5 < j5) {
            while (j11 > j5) {
                sVar = sVar.g;
                kotlin.jvm.internal.k.c(sVar);
                j11 -= sVar.c - sVar.b;
            }
            while (j11 < j6) {
                byte[] bArr = sVar.f1426a;
                int iMin = (int) Math.min(sVar.c, (sVar.b + j6) - j11);
                for (int i = (int) ((sVar.b + j5) - j11); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return (i - sVar.b) + j11;
                    }
                }
                j11 += sVar.c - sVar.b;
                sVar = sVar.f;
                kotlin.jvm.internal.k.c(sVar);
                j5 = j11;
            }
            return -1L;
        }
        while (true) {
            long j12 = (sVar.c - sVar.b) + j10;
            if (j12 > j5) {
                break;
            }
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
            j10 = j12;
        }
        while (j10 < j6) {
            byte[] bArr2 = sVar.f1426a;
            int iMin2 = (int) Math.min(sVar.c, (sVar.b + j6) - j10);
            for (int i6 = (int) ((sVar.b + j5) - j10); i6 < iMin2; i6++) {
                if (bArr2[i6] == b) {
                    return (i6 - sVar.b) + j10;
                }
            }
            j10 += sVar.c - sVar.b;
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
            j5 = j10;
        }
        return -1L;
    }

    @Override // V9.i
    public final void skip(long j5) throws EOFException {
        while (j5 > 0) {
            s sVar = this.f1418a;
            if (sVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j5, sVar.c - sVar.b);
            long j6 = iMin;
            this.b -= j6;
            j5 -= j6;
            int i = sVar.b + iMin;
            sVar.b = i;
            if (i == sVar.c) {
                this.f1418a = sVar.a();
                t.a(sVar);
            }
        }
    }

    @Override // V9.i
    public final void t(long j5) throws EOFException {
        if (this.b < j5) {
            throw new EOFException();
        }
    }

    @Override // V9.w
    public final y timeout() {
        return y.d;
    }

    public final String toString() {
        long j5 = this.b;
        if (j5 <= SieveCacheKt.NodeLinkMask) {
            return I((int) j5).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.b).toString());
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h u(long j5) {
        M(j5);
        return this;
    }

    @Override // V9.i
    public final ByteString v(long j5) throws EOFException {
        if (j5 < 0 || j5 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount: ").toString());
        }
        if (this.b < j5) {
            throw new EOFException();
        }
        if (j5 < 4096) {
            return new ByteString(E(j5));
        }
        ByteString byteStringI = I((int) j5);
        skip(j5);
        return byteStringI;
    }

    public final long w(ByteString targetBytes, long j5) {
        kotlin.jvm.internal.k.f(targetBytes, "targetBytes");
        long j6 = 0;
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "fromIndex < 0: ").toString());
        }
        s sVar = this.f1418a;
        if (sVar == null) {
            return -1L;
        }
        long j10 = this.b;
        if (j10 - j5 < j5) {
            while (j10 > j5) {
                sVar = sVar.g;
                kotlin.jvm.internal.k.c(sVar);
                j10 -= sVar.c - sVar.b;
            }
            if (targetBytes.c() == 2) {
                byte bF = targetBytes.f(0);
                byte bF2 = targetBytes.f(1);
                while (j10 < this.b) {
                    byte[] bArr = sVar.f1426a;
                    int i = sVar.c;
                    for (int i6 = (int) ((sVar.b + j5) - j10); i6 < i; i6++) {
                        byte b = bArr[i6];
                        if (b == bF || b == bF2) {
                            return (i6 - sVar.b) + j10;
                        }
                    }
                    j10 += sVar.c - sVar.b;
                    sVar = sVar.f;
                    kotlin.jvm.internal.k.c(sVar);
                    j5 = j10;
                }
            } else {
                byte[] bArrE = targetBytes.getCom.stepos.taskrobot.settingsprovider.SettingsConfig.KEY_DATA java.lang.String();
                while (j10 < this.b) {
                    byte[] bArr2 = sVar.f1426a;
                    int i10 = sVar.c;
                    for (int i11 = (int) ((sVar.b + j5) - j10); i11 < i10; i11++) {
                        byte b5 = bArr2[i11];
                        for (byte b10 : bArrE) {
                            if (b5 == b10) {
                                return (i11 - sVar.b) + j10;
                            }
                        }
                    }
                    j10 += sVar.c - sVar.b;
                    sVar = sVar.f;
                    kotlin.jvm.internal.k.c(sVar);
                    j5 = j10;
                }
            }
            return -1L;
        }
        while (true) {
            long j11 = (sVar.c - sVar.b) + j6;
            if (j11 > j5) {
                break;
            }
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
            j6 = j11;
        }
        if (targetBytes.c() == 2) {
            byte bF3 = targetBytes.f(0);
            byte bF4 = targetBytes.f(1);
            while (j6 < this.b) {
                byte[] bArr3 = sVar.f1426a;
                int i12 = sVar.c;
                for (int i13 = (int) ((sVar.b + j5) - j6); i13 < i12; i13++) {
                    byte b11 = bArr3[i13];
                    if (b11 == bF3 || b11 == bF4) {
                        return (i13 - sVar.b) + j6;
                    }
                }
                j6 += sVar.c - sVar.b;
                sVar = sVar.f;
                kotlin.jvm.internal.k.c(sVar);
                j5 = j6;
            }
        } else {
            byte[] bArrE2 = targetBytes.getCom.stepos.taskrobot.settingsprovider.SettingsConfig.KEY_DATA java.lang.String();
            while (j6 < this.b) {
                byte[] bArr4 = sVar.f1426a;
                int i14 = sVar.c;
                for (int i15 = (int) ((sVar.b + j5) - j6); i15 < i14; i15++) {
                    byte b12 = bArr4[i15];
                    for (byte b13 : bArrE2) {
                        if (b12 == b13) {
                            return (i15 - sVar.b) + j6;
                        }
                    }
                }
                j6 += sVar.c - sVar.b;
                sVar = sVar.f;
                kotlin.jvm.internal.k.c(sVar);
                j5 = j6;
            }
        }
        return -1L;
    }

    @Override // V9.h
    public final h write(byte[] source) {
        kotlin.jvm.internal.k.f(source, "source");
        m1write(source, 0, source.length);
        return this;
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h writeByte(int i) {
        L(i);
        return this;
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h writeInt(int i) {
        O(i);
        return this;
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h writeShort(int i) {
        P(i);
        return this;
    }

    @Override // V9.i
    public final String x(Charset charset) {
        kotlin.jvm.internal.k.f(charset, "charset");
        return F(this.b, charset);
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h y(long j5) {
        N(j5);
        return this;
    }

    @Override // V9.i
    public final int z(p options) throws EOFException {
        kotlin.jvm.internal.k.f(options, "options");
        int iB = W9.a.b(this, options, false);
        if (iB == -1) {
            return -1;
        }
        skip(options.f1423a[iB].c());
        return iB;
    }

    @Override // V9.h
    public final /* bridge */ /* synthetic */ h write(byte[] bArr, int i, int i6) {
        m1write(bArr, i, i6);
        return this;
    }

    @Override // V9.u
    public final void write(g source, long j5) {
        s sVarB;
        kotlin.jvm.internal.k.f(source, "source");
        if (source != this) {
            H4.o.t(source.b, 0L, j5);
            while (j5 > 0) {
                s sVar = source.f1418a;
                kotlin.jvm.internal.k.c(sVar);
                int i = sVar.c;
                s sVar2 = source.f1418a;
                kotlin.jvm.internal.k.c(sVar2);
                long j6 = i - sVar2.b;
                int i6 = 0;
                if (j5 < j6) {
                    s sVar3 = this.f1418a;
                    s sVar4 = sVar3 != null ? sVar3.g : null;
                    if (sVar4 != null && sVar4.e) {
                        if ((sVar4.c + j5) - (sVar4.d ? 0 : sVar4.b) <= 8192) {
                            s sVar5 = source.f1418a;
                            kotlin.jvm.internal.k.c(sVar5);
                            sVar5.d(sVar4, (int) j5);
                            source.b -= j5;
                            this.b += j5;
                            return;
                        }
                    }
                    s sVar6 = source.f1418a;
                    kotlin.jvm.internal.k.c(sVar6);
                    int i10 = (int) j5;
                    if (i10 > 0 && i10 <= sVar6.c - sVar6.b) {
                        if (i10 >= 1024) {
                            sVarB = sVar6.c();
                        } else {
                            sVarB = t.b();
                            byte[] bArr = sVar6.f1426a;
                            byte[] bArr2 = sVarB.f1426a;
                            int i11 = sVar6.b;
                            D7.q.S(bArr, 0, i11, bArr2, i11 + i10);
                        }
                        sVarB.c = sVarB.b + i10;
                        sVar6.b += i10;
                        s sVar7 = sVar6.g;
                        kotlin.jvm.internal.k.c(sVar7);
                        sVar7.b(sVarB);
                        source.f1418a = sVarB;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range");
                    }
                }
                s sVar8 = source.f1418a;
                kotlin.jvm.internal.k.c(sVar8);
                long j10 = sVar8.c - sVar8.b;
                source.f1418a = sVar8.a();
                s sVar9 = this.f1418a;
                if (sVar9 == null) {
                    this.f1418a = sVar8;
                    sVar8.g = sVar8;
                    sVar8.f = sVar8;
                } else {
                    s sVar10 = sVar9.g;
                    kotlin.jvm.internal.k.c(sVar10);
                    sVar10.b(sVar8);
                    s sVar11 = sVar8.g;
                    if (sVar11 != sVar8) {
                        kotlin.jvm.internal.k.c(sVar11);
                        if (sVar11.e) {
                            int i12 = sVar8.c - sVar8.b;
                            s sVar12 = sVar8.g;
                            kotlin.jvm.internal.k.c(sVar12);
                            int i13 = 8192 - sVar12.c;
                            s sVar13 = sVar8.g;
                            kotlin.jvm.internal.k.c(sVar13);
                            if (!sVar13.d) {
                                s sVar14 = sVar8.g;
                                kotlin.jvm.internal.k.c(sVar14);
                                i6 = sVar14.b;
                            }
                            if (i12 <= i13 + i6) {
                                s sVar15 = sVar8.g;
                                kotlin.jvm.internal.k.c(sVar15);
                                sVar8.d(sVar15, i12);
                                sVar8.a();
                                t.a(sVar8);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact");
                    }
                }
                source.b -= j10;
                this.b += j10;
                j5 -= j10;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public final int read(byte[] bArr, int i, int i6) {
        H4.o.t(bArr.length, i, i6);
        s sVar = this.f1418a;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(i6, sVar.c - sVar.b);
        byte[] bArr2 = sVar.f1426a;
        int i10 = sVar.b;
        D7.q.S(bArr2, i, i10, bArr, i10 + iMin);
        int i11 = sVar.b + iMin;
        sVar.b = i11;
        this.b -= iMin;
        if (i11 == sVar.c) {
            this.f1418a = sVar.a();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.k.f(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            s sVarJ = J(1);
            int iMin = Math.min(i, 8192 - sVarJ.c);
            source.get(sVarJ.f1426a, sVarJ.c, iMin);
            i -= iMin;
            sVarJ.c += iMin;
        }
        this.b += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m1write(byte[] source, int i, int i6) {
        kotlin.jvm.internal.k.f(source, "source");
        long j5 = i6;
        H4.o.t(source.length, i, j5);
        int i10 = i6 + i;
        while (i < i10) {
            s sVarJ = J(1);
            int iMin = Math.min(i10 - i, 8192 - sVarJ.c);
            int i11 = i + iMin;
            D7.q.S(source, sVarJ.c, i, sVarJ.f1426a, i11);
            sVarJ.c += iMin;
            i = i11;
        }
        this.b += j5;
    }
}
