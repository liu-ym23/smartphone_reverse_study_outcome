package c7;

import com.stepos.stepclaw.SecurePrefs;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import org.bouncycastle.asn1.BERTags;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements h, g, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public q f1163a;

    /* renamed from: b, reason: collision with root package name */
    public long f1164b;

    public final void A(int i8) {
        q qVarT = t(1);
        byte[] bArr = qVarT.f1187a;
        int i9 = qVarT.f1189c;
        qVarT.f1189c = i9 + 1;
        bArr[i9] = (byte) i8;
        this.f1164b++;
    }

    @Override // c7.g
    public final /* bridge */ /* synthetic */ g B(String str) {
        I(str);
        return this;
    }

    public final void C(long j4) {
        boolean z;
        if (j4 == 0) {
            A(48);
            return;
        }
        if (j4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                I("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        byte[] bArr = d7.a.f1924a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j4)) * 10) >>> 5;
        int i8 = iNumberOfLeadingZeros + (j4 > d7.a.f1925b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z) {
            i8++;
        }
        q qVarT = t(i8);
        byte[] bArr2 = qVarT.f1187a;
        int i9 = qVarT.f1189c + i8;
        while (j4 != 0) {
            long j8 = 10;
            i9--;
            bArr2[i9] = d7.a.f1924a[(int) (j4 % j8)];
            j4 /= j8;
        }
        if (z) {
            bArr2[i9 - 1] = 45;
        }
        qVarT.f1189c += i8;
        this.f1164b += i8;
    }

    @Override // c7.h
    public final void D(long j4, f fVar) throws EOFException {
        long j8 = this.f1164b;
        if (j8 >= j4) {
            fVar.x(j4, this);
        } else {
            fVar.x(j8, this);
            throw new EOFException();
        }
    }

    public final void E(long j4) {
        if (j4 == 0) {
            A(48);
            return;
        }
        long j8 = (j4 >>> 1) | j4;
        long j9 = j8 | (j8 >>> 2);
        long j10 = j9 | (j9 >>> 4);
        long j11 = j10 | (j10 >>> 8);
        long j12 = j11 | (j11 >>> 16);
        long j13 = j12 | (j12 >>> 32);
        long j14 = j13 - ((j13 >>> 1) & 6148914691236517205L);
        long j15 = ((j14 >>> 2) & 3689348814741910323L) + (j14 & 3689348814741910323L);
        long j16 = ((j15 >>> 4) + j15) & 1085102592571150095L;
        long j17 = j16 + (j16 >>> 8);
        long j18 = j17 + (j17 >>> 16);
        int i8 = (int) ((((j18 & 63) + ((j18 >>> 32) & 63)) + 3) / 4);
        q qVarT = t(i8);
        byte[] bArr = qVarT.f1187a;
        int i9 = qVarT.f1189c;
        for (int i10 = (i9 + i8) - 1; i10 >= i9; i10--) {
            bArr[i10] = d7.a.f1924a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        qVarT.f1189c += i8;
        this.f1164b += i8;
    }

    public final void F(int i8) {
        q qVarT = t(4);
        byte[] bArr = qVarT.f1187a;
        int i9 = qVarT.f1189c;
        bArr[i9] = (byte) ((i8 >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((i8 >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 3] = (byte) (i8 & 255);
        qVarT.f1189c = i9 + 4;
        this.f1164b += 4;
    }

    public final void G(int i8) {
        q qVarT = t(2);
        byte[] bArr = qVarT.f1187a;
        int i9 = qVarT.f1189c;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 1] = (byte) (i8 & 255);
        qVarT.f1189c = i9 + 2;
        this.f1164b += 2;
    }

    public final void H(int i8, int i9, String string) {
        char cCharAt;
        kotlin.jvm.internal.p.e(string, "string");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "beginIndex < 0: ").toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(a8.b.i(i9, i8, "endIndex < beginIndex: ", " < ").toString());
        }
        if (i9 > string.length()) {
            StringBuilder sbS = a8.b.s(i9, "endIndex > string.length: ", " > ");
            sbS.append(string.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        while (i8 < i9) {
            char cCharAt2 = string.charAt(i8);
            if (cCharAt2 < 128) {
                q qVarT = t(1);
                byte[] bArr = qVarT.f1187a;
                int i10 = qVarT.f1189c - i8;
                int iMin = Math.min(i9, 8192 - i10);
                int i11 = i8 + 1;
                bArr[i8 + i10] = (byte) cCharAt2;
                while (true) {
                    i8 = i11;
                    if (i8 >= iMin || (cCharAt = string.charAt(i8)) >= 128) {
                        break;
                    }
                    i11 = i8 + 1;
                    bArr[i8 + i10] = (byte) cCharAt;
                }
                int i12 = qVarT.f1189c;
                int i13 = (i10 + i8) - i12;
                qVarT.f1189c = i12 + i13;
                this.f1164b += i13;
            } else {
                if (cCharAt2 < 2048) {
                    q qVarT2 = t(2);
                    byte[] bArr2 = qVarT2.f1187a;
                    int i14 = qVarT2.f1189c;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | BERTags.PRIVATE);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    qVarT2.f1189c = i14 + 2;
                    this.f1164b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    q qVarT3 = t(3);
                    byte[] bArr3 = qVarT3.f1187a;
                    int i15 = qVarT3.f1189c;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | BERTags.FLAGS);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    qVarT3.f1189c = i15 + 3;
                    this.f1164b += 3;
                } else {
                    int i16 = i8 + 1;
                    char cCharAt3 = i16 < i9 ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        A(63);
                        i8 = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        q qVarT4 = t(4);
                        byte[] bArr4 = qVarT4.f1187a;
                        int i18 = qVarT4.f1189c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        qVarT4.f1189c = i18 + 4;
                        this.f1164b += 4;
                        i8 += 2;
                    }
                }
                i8++;
            }
        }
    }

    public final void I(String string) {
        kotlin.jvm.internal.p.e(string, "string");
        H(0, string.length(), string);
    }

    public final void J(int i8) {
        if (i8 < 128) {
            A(i8);
            return;
        }
        if (i8 < 2048) {
            q qVarT = t(2);
            byte[] bArr = qVarT.f1187a;
            int i9 = qVarT.f1189c;
            bArr[i9] = (byte) ((i8 >> 6) | BERTags.PRIVATE);
            bArr[i9 + 1] = (byte) ((i8 & 63) | 128);
            qVarT.f1189c = i9 + 2;
            this.f1164b += 2;
            return;
        }
        if (55296 <= i8 && i8 < 57344) {
            A(63);
            return;
        }
        if (i8 < 65536) {
            q qVarT2 = t(3);
            byte[] bArr2 = qVarT2.f1187a;
            int i10 = qVarT2.f1189c;
            bArr2[i10] = (byte) ((i8 >> 12) | BERTags.FLAGS);
            bArr2[i10 + 1] = (byte) (((i8 >> 6) & 63) | 128);
            bArr2[i10 + 2] = (byte) ((i8 & 63) | 128);
            qVarT2.f1189c = i10 + 3;
            this.f1164b += 3;
            return;
        }
        if (i8 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(b.e(i8)));
        }
        q qVarT3 = t(4);
        byte[] bArr3 = qVarT3.f1187a;
        int i11 = qVarT3.f1189c;
        bArr3[i11] = (byte) ((i8 >> 18) | 240);
        bArr3[i11 + 1] = (byte) (((i8 >> 12) & 63) | 128);
        bArr3[i11 + 2] = (byte) (((i8 >> 6) & 63) | 128);
        bArr3[i11 + 3] = (byte) ((i8 & 63) | 128);
        qVarT3.f1189c = i11 + 4;
        this.f1164b += 4;
    }

    public final void a(f out, long j4, long j8) {
        kotlin.jvm.internal.p.e(out, "out");
        long j9 = j4;
        b.d(this.f1164b, j9, j8);
        if (j8 == 0) {
            return;
        }
        out.f1164b += j8;
        q qVar = this.f1163a;
        while (true) {
            kotlin.jvm.internal.p.b(qVar);
            long j10 = qVar.f1189c - qVar.f1188b;
            if (j9 < j10) {
                break;
            }
            j9 -= j10;
            qVar = qVar.f1191f;
        }
        long j11 = j8;
        while (j11 > 0) {
            kotlin.jvm.internal.p.b(qVar);
            q qVarC = qVar.c();
            int i8 = qVarC.f1188b + ((int) j9);
            qVarC.f1188b = i8;
            qVarC.f1189c = Math.min(i8 + ((int) j11), qVarC.f1189c);
            q qVar2 = out.f1163a;
            if (qVar2 == null) {
                qVarC.f1192g = qVarC;
                qVarC.f1191f = qVarC;
                out.f1163a = qVarC;
            } else {
                q qVar3 = qVar2.f1192g;
                kotlin.jvm.internal.p.b(qVar3);
                qVar3.b(qVarC);
            }
            j11 -= qVarC.f1189c - qVarC.f1188b;
            qVar = qVar.f1191f;
            j9 = 0;
        }
    }

    public final byte b(long j4) {
        b.d(this.f1164b, j4, 1L);
        q qVar = this.f1163a;
        if (qVar == null) {
            kotlin.jvm.internal.p.b(null);
            throw null;
        }
        long j8 = this.f1164b;
        if (j8 - j4 < j4) {
            while (j8 > j4) {
                qVar = qVar.f1192g;
                kotlin.jvm.internal.p.b(qVar);
                j8 -= qVar.f1189c - qVar.f1188b;
            }
            return qVar.f1187a[(int) ((qVar.f1188b + j4) - j8)];
        }
        long j9 = 0;
        while (true) {
            int i8 = qVar.f1189c;
            int i9 = qVar.f1188b;
            long j10 = (i8 - i9) + j9;
            if (j10 > j4) {
                return qVar.f1187a[(int) ((i9 + j4) - j9)];
            }
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
            j9 = j10;
        }
    }

    public final Object clone() {
        f fVar = new f();
        if (this.f1164b == 0) {
            return fVar;
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        q qVarC = qVar.c();
        fVar.f1163a = qVarC;
        qVarC.f1192g = qVarC;
        qVarC.f1191f = qVarC;
        for (q qVar2 = qVar.f1191f; qVar2 != qVar; qVar2 = qVar2.f1191f) {
            q qVar3 = qVarC.f1192g;
            kotlin.jvm.internal.p.b(qVar3);
            kotlin.jvm.internal.p.b(qVar2);
            qVar3.b(qVar2.c());
        }
        fVar.f1164b = this.f1164b;
        return fVar;
    }

    @Override // c7.v, c7.t
    public final x d() {
        return x.d;
    }

    public final long e(byte b9, long j4, long j8) {
        q qVar;
        long j9 = 0;
        if (0 > j4 || j4 > j8) {
            throw new IllegalArgumentException(("size=" + this.f1164b + " fromIndex=" + j4 + " toIndex=" + j8).toString());
        }
        long j10 = this.f1164b;
        if (j8 > j10) {
            j8 = j10;
        }
        if (j4 == j8 || (qVar = this.f1163a) == null) {
            return -1L;
        }
        if (j10 - j4 < j4) {
            while (j10 > j4) {
                qVar = qVar.f1192g;
                kotlin.jvm.internal.p.b(qVar);
                j10 -= qVar.f1189c - qVar.f1188b;
            }
            while (j10 < j8) {
                byte[] bArr = qVar.f1187a;
                int iMin = (int) Math.min(qVar.f1189c, (qVar.f1188b + j8) - j10);
                for (int i8 = (int) ((qVar.f1188b + j4) - j10); i8 < iMin; i8++) {
                    if (bArr[i8] == b9) {
                        return (i8 - qVar.f1188b) + j10;
                    }
                }
                j10 += qVar.f1189c - qVar.f1188b;
                qVar = qVar.f1191f;
                kotlin.jvm.internal.p.b(qVar);
                j4 = j10;
            }
            return -1L;
        }
        while (true) {
            long j11 = (qVar.f1189c - qVar.f1188b) + j9;
            if (j11 > j4) {
                break;
            }
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
            j9 = j11;
        }
        while (j9 < j8) {
            byte[] bArr2 = qVar.f1187a;
            int iMin2 = (int) Math.min(qVar.f1189c, (qVar.f1188b + j8) - j9);
            for (int i9 = (int) ((qVar.f1188b + j4) - j9); i9 < iMin2; i9++) {
                if (bArr2[i9] == b9) {
                    return (i9 - qVar.f1188b) + j9;
                }
            }
            j9 += qVar.f1189c - qVar.f1188b;
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
            j4 = j9;
        }
        return -1L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        long j4 = this.f1164b;
        f fVar = (f) obj;
        if (j4 != fVar.f1164b) {
            return false;
        }
        if (j4 == 0) {
            return true;
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        q qVar2 = fVar.f1163a;
        kotlin.jvm.internal.p.b(qVar2);
        int i8 = qVar.f1188b;
        int i9 = qVar2.f1188b;
        long j8 = 0;
        while (j8 < this.f1164b) {
            long jMin = Math.min(qVar.f1189c - i8, qVar2.f1189c - i9);
            long j9 = 0;
            while (j9 < jMin) {
                int i10 = i8 + 1;
                int i11 = i9 + 1;
                if (qVar.f1187a[i8] != qVar2.f1187a[i9]) {
                    return false;
                }
                j9++;
                i8 = i10;
                i9 = i11;
            }
            if (i8 == qVar.f1189c) {
                qVar = qVar.f1191f;
                kotlin.jvm.internal.p.b(qVar);
                i8 = qVar.f1188b;
            }
            if (i9 == qVar2.f1189c) {
                qVar2 = qVar2.f1191f;
                kotlin.jvm.internal.p.b(qVar2);
                i9 = qVar2.f1188b;
            }
            j8 += jMin;
        }
        return true;
    }

    @Override // c7.h
    public final void f(long j4) throws EOFException {
        if (this.f1164b < j4) {
            throw new EOFException();
        }
    }

    public final e g(e unsafeCursor) {
        kotlin.jvm.internal.p.e(unsafeCursor, "unsafeCursor");
        byte[] bArr = d7.a.f1924a;
        if (unsafeCursor == b.f1147a) {
            unsafeCursor = new e();
        }
        if (unsafeCursor.f1157a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f1157a = this;
        unsafeCursor.f1158b = true;
        return unsafeCursor;
    }

    @Override // c7.v
    public final long h(long j4, f sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount < 0: ").toString());
        }
        long j8 = this.f1164b;
        if (j8 == 0) {
            return -1L;
        }
        if (j4 > j8) {
            j4 = j8;
        }
        sink.x(j4, this);
        return j4;
    }

    public final int hashCode() {
        q qVar = this.f1163a;
        if (qVar == null) {
            return 0;
        }
        int i8 = 1;
        do {
            int i9 = qVar.f1189c;
            for (int i10 = qVar.f1188b; i10 < i9; i10++) {
                i8 = (i8 * 31) + qVar.f1187a[i10];
            }
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
        } while (qVar != this.f1163a);
        return i8;
    }

    @Override // c7.h
    public final i i(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        if (this.f1164b < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new i(j(j4));
        }
        i iVarS = s((int) j4);
        skip(j4);
        return iVarS;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final byte[] j(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        if (this.f1164b < j4) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j4];
        readFully(bArr);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f1164b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            c7.q r7 = r15.f1163a
            kotlin.jvm.internal.p.b(r7)
            byte[] r8 = r7.f1187a
            int r9 = r7.f1188b
            int r10 = r7.f1189c
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
            c7.f r15 = new c7.f
            r15.<init>()
            r15.E(r4)
            r15.A(r11)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.o()
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
            char[] r1 = d7.b.f1926a
            int r2 = r11 >> 4
            r2 = r2 & 15
            char r2 = r1[r2]
            r3 = r11 & 15
            char r1 = r1[r3]
            r3 = 2
            char[] r3 = new char[r3]
            r3[r0] = r2
            r3[r6] = r1
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r1.concat(r0)
            r15.<init>(r0)
            throw r15
        L8e:
            if (r9 != r10) goto L9a
            c7.q r8 = r7.a()
            r15.f1163a = r8
            c7.r.a(r7)
            goto L9c
        L9a:
            r7.f1188b = r9
        L9c:
            if (r6 != 0) goto La2
            c7.q r7 = r15.f1163a
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.f1164b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f1164b = r2
            return r4
        La9:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: c7.f.l():long");
    }

    public final String n(long j4, Charset charset) throws EOFException {
        kotlin.jvm.internal.p.e(charset, "charset");
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        if (this.f1164b < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        int i8 = qVar.f1188b;
        if (i8 + j4 > qVar.f1189c) {
            return new String(j(j4), charset);
        }
        int i9 = (int) j4;
        String str = new String(qVar.f1187a, i8, i9, charset);
        int i10 = qVar.f1188b + i9;
        qVar.f1188b = i10;
        this.f1164b -= j4;
        if (i10 == qVar.f1189c) {
            this.f1163a = qVar.a();
            r.a(qVar);
        }
        return str;
    }

    public final String o() {
        return n(this.f1164b, x5.a.f6276a);
    }

    public final boolean q() {
        return this.f1164b == 0;
    }

    @Override // c7.g
    public final /* bridge */ /* synthetic */ g r(i iVar) {
        u(iVar);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        q qVar = this.f1163a;
        if (qVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), qVar.f1189c - qVar.f1188b);
        sink.put(qVar.f1187a, qVar.f1188b, iMin);
        int i8 = qVar.f1188b + iMin;
        qVar.f1188b = i8;
        this.f1164b -= iMin;
        if (i8 == qVar.f1189c) {
            this.f1163a = qVar.a();
            r.a(qVar);
        }
        return iMin;
    }

    @Override // c7.h
    public final byte readByte() throws EOFException {
        if (this.f1164b == 0) {
            throw new EOFException();
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        int i8 = qVar.f1188b;
        int i9 = qVar.f1189c;
        int i10 = i8 + 1;
        byte b9 = qVar.f1187a[i8];
        this.f1164b--;
        if (i10 != i9) {
            qVar.f1188b = i10;
            return b9;
        }
        this.f1163a = qVar.a();
        r.a(qVar);
        return b9;
    }

    @Override // c7.h
    public final void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.p.e(sink, "sink");
        int i8 = 0;
        while (i8 < sink.length) {
            int i9 = read(sink, i8, sink.length - i8);
            if (i9 == -1) {
                throw new EOFException();
            }
            i8 += i9;
        }
    }

    @Override // c7.h
    public final int readInt() throws EOFException {
        if (this.f1164b < 4) {
            throw new EOFException();
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        int i8 = qVar.f1188b;
        int i9 = qVar.f1189c;
        if (i9 - i8 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = qVar.f1187a;
        int i10 = i8 + 3;
        int i11 = ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8] & 255) << 24) | ((bArr[i8 + 2] & 255) << 8);
        int i12 = i8 + 4;
        int i13 = (bArr[i10] & 255) | i11;
        this.f1164b -= 4;
        if (i12 != i9) {
            qVar.f1188b = i12;
            return i13;
        }
        this.f1163a = qVar.a();
        r.a(qVar);
        return i13;
    }

    @Override // c7.h
    public final long readLong() throws EOFException {
        if (this.f1164b < 8) {
            throw new EOFException();
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        int i8 = qVar.f1188b;
        int i9 = qVar.f1189c;
        if (i9 - i8 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = qVar.f1187a;
        int i10 = i8 + 7;
        long j4 = ((bArr[i8] & 255) << 56) | ((bArr[i8 + 1] & 255) << 48) | ((bArr[i8 + 2] & 255) << 40) | ((bArr[i8 + 3] & 255) << 32) | ((bArr[i8 + 4] & 255) << 24) | ((bArr[i8 + 5] & 255) << 16) | ((bArr[i8 + 6] & 255) << 8);
        int i11 = i8 + 8;
        long j8 = j4 | (bArr[i10] & 255);
        this.f1164b -= 8;
        if (i11 != i9) {
            qVar.f1188b = i11;
            return j8;
        }
        this.f1163a = qVar.a();
        r.a(qVar);
        return j8;
    }

    @Override // c7.h
    public final short readShort() throws EOFException {
        if (this.f1164b < 2) {
            throw new EOFException();
        }
        q qVar = this.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        int i8 = qVar.f1188b;
        int i9 = qVar.f1189c;
        if (i9 - i8 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = qVar.f1187a;
        int i10 = i8 + 1;
        int i11 = (bArr[i8] & 255) << 8;
        int i12 = i8 + 2;
        int i13 = (bArr[i10] & 255) | i11;
        this.f1164b -= 2;
        if (i12 == i9) {
            this.f1163a = qVar.a();
            r.a(qVar);
        } else {
            qVar.f1188b = i12;
        }
        return (short) i13;
    }

    public final i s(int i8) {
        if (i8 == 0) {
            return i.d;
        }
        b.d(this.f1164b, 0L, i8);
        q qVar = this.f1163a;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            kotlin.jvm.internal.p.b(qVar);
            int i12 = qVar.f1189c;
            int i13 = qVar.f1188b;
            if (i12 == i13) {
                throw new AssertionError("s.limit == s.pos");
            }
            i10 += i12 - i13;
            i11++;
            qVar = qVar.f1191f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        q qVar2 = this.f1163a;
        int i14 = 0;
        while (i9 < i8) {
            kotlin.jvm.internal.p.b(qVar2);
            bArr[i14] = qVar2.f1187a;
            i9 += qVar2.f1189c - qVar2.f1188b;
            iArr[i14] = Math.min(i9, i8);
            iArr[i14 + i11] = qVar2.f1188b;
            qVar2.d = true;
            i14++;
            qVar2 = qVar2.f1191f;
        }
        return new s(bArr, iArr);
    }

    @Override // c7.h
    public final void skip(long j4) throws EOFException {
        while (j4 > 0) {
            q qVar = this.f1163a;
            if (qVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j4, qVar.f1189c - qVar.f1188b);
            long j8 = iMin;
            this.f1164b -= j8;
            j4 -= j8;
            int i8 = qVar.f1188b + iMin;
            qVar.f1188b = i8;
            if (i8 == qVar.f1189c) {
                this.f1163a = qVar.a();
                r.a(qVar);
            }
        }
    }

    public final q t(int i8) {
        if (i8 < 1 || i8 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        q qVar = this.f1163a;
        if (qVar == null) {
            q qVarB = r.b();
            this.f1163a = qVarB;
            qVarB.f1192g = qVarB;
            qVarB.f1191f = qVarB;
            return qVarB;
        }
        q qVar2 = qVar.f1192g;
        kotlin.jvm.internal.p.b(qVar2);
        if (qVar2.f1189c + i8 <= 8192 && qVar2.f1190e) {
            return qVar2;
        }
        q qVarB2 = r.b();
        qVar2.b(qVarB2);
        return qVarB2;
    }

    public final String toString() {
        long j4 = this.f1164b;
        if (j4 <= 2147483647L) {
            return s((int) j4).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f1164b).toString());
    }

    public final void u(i byteString) {
        kotlin.jvm.internal.p.e(byteString, "byteString");
        byteString.m(this, byteString.c());
    }

    public final void v(byte[] source, int i8) {
        kotlin.jvm.internal.p.e(source, "source");
        int i9 = 0;
        long j4 = i8;
        b.d(source.length, 0, j4);
        while (i9 < i8) {
            q qVarT = t(1);
            int iMin = Math.min(i8 - i9, 8192 - qVarT.f1189c);
            int i10 = i9 + iMin;
            c5.l.U(qVarT.f1189c, source, i9, qVarT.f1187a, i10);
            qVarT.f1189c += iMin;
            i9 = i10;
        }
        this.f1164b += j4;
    }

    @Override // c7.h
    public final String w(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "limit < 0: ").toString());
        }
        long j8 = Util.VLI_MAX;
        if (j4 != Util.VLI_MAX) {
            j8 = j4 + 1;
        }
        long j9 = j8;
        long jE = e((byte) 10, 0L, j9);
        if (jE != -1) {
            return d7.a.b(jE, this);
        }
        if (j9 < this.f1164b && b(j9 - 1) == 13 && b(j9) == 10) {
            return d7.a.b(j9, this);
        }
        f fVar = new f();
        a(fVar, 0L, Math.min(32, this.f1164b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f1164b, j4) + " content=" + fVar.i(fVar.f1164b).d() + (char) 8230);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.p.e(source, "source");
        int iRemaining = source.remaining();
        int i8 = iRemaining;
        while (i8 > 0) {
            q qVarT = t(1);
            int iMin = Math.min(i8, 8192 - qVarT.f1189c);
            source.get(qVarT.f1187a, qVarT.f1189c, iMin);
            i8 -= iMin;
            qVarT.f1189c += iMin;
        }
        this.f1164b += iRemaining;
        return iRemaining;
    }

    @Override // c7.g
    public final /* bridge */ /* synthetic */ g writeByte(int i8) {
        A(i8);
        return this;
    }

    @Override // c7.g
    public final /* bridge */ /* synthetic */ g writeInt(int i8) {
        F(i8);
        return this;
    }

    @Override // c7.g
    public final /* bridge */ /* synthetic */ g writeShort(int i8) {
        G(i8);
        return this;
    }

    @Override // c7.t
    public final void x(long j4, f source) {
        q qVarB;
        kotlin.jvm.internal.p.e(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        b.d(source.f1164b, 0L, j4);
        while (j4 > 0) {
            q qVar = source.f1163a;
            kotlin.jvm.internal.p.b(qVar);
            int i8 = qVar.f1189c;
            q qVar2 = source.f1163a;
            kotlin.jvm.internal.p.b(qVar2);
            long j8 = i8 - qVar2.f1188b;
            int i9 = 0;
            if (j4 < j8) {
                q qVar3 = this.f1163a;
                q qVar4 = qVar3 != null ? qVar3.f1192g : null;
                if (qVar4 != null && qVar4.f1190e) {
                    if ((qVar4.f1189c + j4) - (qVar4.d ? 0 : qVar4.f1188b) <= 8192) {
                        q qVar5 = source.f1163a;
                        kotlin.jvm.internal.p.b(qVar5);
                        qVar5.d(qVar4, (int) j4);
                        source.f1164b -= j4;
                        this.f1164b += j4;
                        return;
                    }
                }
                q qVar6 = source.f1163a;
                kotlin.jvm.internal.p.b(qVar6);
                int i10 = (int) j4;
                if (i10 <= 0 || i10 > qVar6.f1189c - qVar6.f1188b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i10 >= 1024) {
                    qVarB = qVar6.c();
                } else {
                    qVarB = r.b();
                    byte[] bArr = qVar6.f1187a;
                    byte[] bArr2 = qVarB.f1187a;
                    int i11 = qVar6.f1188b;
                    c5.l.U(0, bArr, i11, bArr2, i11 + i10);
                }
                qVarB.f1189c = qVarB.f1188b + i10;
                qVar6.f1188b += i10;
                q qVar7 = qVar6.f1192g;
                kotlin.jvm.internal.p.b(qVar7);
                qVar7.b(qVarB);
                source.f1163a = qVarB;
            }
            q qVar8 = source.f1163a;
            kotlin.jvm.internal.p.b(qVar8);
            long j9 = qVar8.f1189c - qVar8.f1188b;
            source.f1163a = qVar8.a();
            q qVar9 = this.f1163a;
            if (qVar9 == null) {
                this.f1163a = qVar8;
                qVar8.f1192g = qVar8;
                qVar8.f1191f = qVar8;
            } else {
                q qVar10 = qVar9.f1192g;
                kotlin.jvm.internal.p.b(qVar10);
                qVar10.b(qVar8);
                q qVar11 = qVar8.f1192g;
                if (qVar11 == qVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                kotlin.jvm.internal.p.b(qVar11);
                if (qVar11.f1190e) {
                    int i12 = qVar8.f1189c - qVar8.f1188b;
                    q qVar12 = qVar8.f1192g;
                    kotlin.jvm.internal.p.b(qVar12);
                    int i13 = 8192 - qVar12.f1189c;
                    q qVar13 = qVar8.f1192g;
                    kotlin.jvm.internal.p.b(qVar13);
                    if (!qVar13.d) {
                        q qVar14 = qVar8.f1192g;
                        kotlin.jvm.internal.p.b(qVar14);
                        i9 = qVar14.f1188b;
                    }
                    if (i12 <= i13 + i9) {
                        q qVar15 = qVar8.f1192g;
                        kotlin.jvm.internal.p.b(qVar15);
                        qVar8.d(qVar15, i12);
                        qVar8.a();
                        r.a(qVar8);
                    }
                }
            }
            source.f1164b -= j9;
            this.f1164b += j9;
            j4 -= j9;
        }
    }

    public final void z(v vVar) {
        while (vVar.h(8192L, this) != -1) {
        }
    }

    @Override // c7.g
    public final g write(byte[] bArr) {
        v(bArr, bArr.length);
        return this;
    }

    public final int read(byte[] sink, int i8, int i9) {
        kotlin.jvm.internal.p.e(sink, "sink");
        b.d(sink.length, i8, i9);
        q qVar = this.f1163a;
        if (qVar == null) {
            return -1;
        }
        int iMin = Math.min(i9, qVar.f1189c - qVar.f1188b);
        byte[] bArr = qVar.f1187a;
        int i10 = qVar.f1188b;
        c5.l.U(i8, bArr, i10, sink, i10 + iMin);
        int i11 = qVar.f1188b + iMin;
        qVar.f1188b = i11;
        this.f1164b -= iMin;
        if (i11 == qVar.f1189c) {
            this.f1163a = qVar.a();
            r.a(qVar);
        }
        return iMin;
    }

    @Override // c7.g
    public final f c() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, c7.t
    public final void close() {
    }

    @Override // c7.g, c7.t, java.io.Flushable
    public final void flush() {
    }
}
