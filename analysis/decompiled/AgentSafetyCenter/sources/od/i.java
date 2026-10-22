package od;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements k, j, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    public d0 f9453c;

    /* renamed from: f, reason: collision with root package name */
    public long f9454f;

    public final boolean A() {
        return this.f9454f == 0;
    }

    public final byte C(long j10) {
        a.a.m(this.f9454f, j10, 1L);
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        long j11 = this.f9454f;
        if (j11 - j10 < j10) {
            while (j11 > j10) {
                d0Var = d0Var.f9443g;
                d0Var.getClass();
                j11 -= d0Var.f9439c - d0Var.f9438b;
            }
            return d0Var.f9437a[(int) ((d0Var.f9438b + j10) - j11)];
        }
        long j12 = 0;
        while (true) {
            int i = d0Var.f9439c;
            int i3 = d0Var.f9438b;
            long j13 = (i - i3) + j12;
            if (j13 > j10) {
                return d0Var.f9437a[(int) ((i3 + j10) - j12)];
            }
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j12 = j13;
        }
    }

    @Override // od.k
    public final String D() {
        return q(Long.MAX_VALUE);
    }

    @Override // od.k
    public final int E(y yVar) throws EOFException {
        yVar.getClass();
        int iB = pd.a.b(this, yVar, false);
        if (iB == -1) {
            return -1;
        }
        W(yVar.f9495f[iB].c());
        return iB;
    }

    public final long F(byte b10, long j10, long j11) {
        d0 d0Var;
        long j12 = 0;
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("size=" + this.f9454f + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        long j13 = this.f9454f;
        if (j11 > j13) {
            j11 = j13;
        }
        if (j10 == j11 || (d0Var = this.f9453c) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                d0Var = d0Var.f9443g;
                d0Var.getClass();
                j13 -= d0Var.f9439c - d0Var.f9438b;
            }
            while (j13 < j11) {
                byte[] bArr = d0Var.f9437a;
                int iMin = (int) Math.min(d0Var.f9439c, (d0Var.f9438b + j11) - j13);
                for (int i = (int) ((d0Var.f9438b + j10) - j13); i < iMin; i++) {
                    if (bArr[i] == b10) {
                        return (i - d0Var.f9438b) + j13;
                    }
                }
                j13 += d0Var.f9439c - d0Var.f9438b;
                d0Var = d0Var.f9442f;
                d0Var.getClass();
                j10 = j13;
            }
            return -1L;
        }
        while (true) {
            long j14 = (d0Var.f9439c - d0Var.f9438b) + j12;
            if (j14 > j10) {
                break;
            }
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j12 = j14;
        }
        while (j12 < j11) {
            byte[] bArr2 = d0Var.f9437a;
            int iMin2 = (int) Math.min(d0Var.f9439c, (d0Var.f9438b + j11) - j12);
            for (int i3 = (int) ((d0Var.f9438b + j10) - j12); i3 < iMin2; i3++) {
                if (bArr2[i3] == b10) {
                    return (i3 - d0Var.f9438b) + j12;
                }
            }
            j12 += d0Var.f9439c - d0Var.f9438b;
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j10 = j12;
        }
        return -1L;
    }

    public final long H(l lVar) {
        int i;
        int i3;
        lVar.getClass();
        d0 d0Var = this.f9453c;
        if (d0Var == null) {
            return -1L;
        }
        long j10 = this.f9454f;
        long j11 = 0;
        if (j10 < 0) {
            while (j10 > 0) {
                d0Var = d0Var.f9443g;
                d0Var.getClass();
                j10 -= d0Var.f9439c - d0Var.f9438b;
            }
            if (lVar.c() == 2) {
                byte bH = lVar.h(0);
                byte bH2 = lVar.h(1);
                while (j10 < this.f9454f) {
                    byte[] bArr = d0Var.f9437a;
                    i = (int) ((d0Var.f9438b + j11) - j10);
                    int i10 = d0Var.f9439c;
                    while (i < i10) {
                        byte b10 = bArr[i];
                        if (b10 == bH || b10 == bH2) {
                            i3 = d0Var.f9438b;
                        } else {
                            i++;
                        }
                    }
                    j11 = (d0Var.f9439c - d0Var.f9438b) + j10;
                    d0Var = d0Var.f9442f;
                    d0Var.getClass();
                    j10 = j11;
                }
                return -1L;
            }
            byte[] bArrG = lVar.g();
            while (j10 < this.f9454f) {
                byte[] bArr2 = d0Var.f9437a;
                i = (int) ((d0Var.f9438b + j11) - j10);
                int i11 = d0Var.f9439c;
                while (i < i11) {
                    byte b11 = bArr2[i];
                    for (byte b12 : bArrG) {
                        if (b11 == b12) {
                            i3 = d0Var.f9438b;
                        }
                    }
                    i++;
                }
                j11 = (d0Var.f9439c - d0Var.f9438b) + j10;
                d0Var = d0Var.f9442f;
                d0Var.getClass();
                j10 = j11;
            }
            return -1L;
        }
        j10 = 0;
        while (true) {
            long j12 = (d0Var.f9439c - d0Var.f9438b) + j10;
            if (j12 > 0) {
                break;
            }
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j10 = j12;
        }
        if (lVar.c() == 2) {
            byte bH3 = lVar.h(0);
            byte bH4 = lVar.h(1);
            while (j10 < this.f9454f) {
                byte[] bArr3 = d0Var.f9437a;
                i = (int) ((d0Var.f9438b + j11) - j10);
                int i12 = d0Var.f9439c;
                while (i < i12) {
                    byte b13 = bArr3[i];
                    if (b13 == bH3 || b13 == bH4) {
                        i3 = d0Var.f9438b;
                    } else {
                        i++;
                    }
                }
                j11 = (d0Var.f9439c - d0Var.f9438b) + j10;
                d0Var = d0Var.f9442f;
                d0Var.getClass();
                j10 = j11;
            }
            return -1L;
        }
        byte[] bArrG2 = lVar.g();
        while (j10 < this.f9454f) {
            byte[] bArr4 = d0Var.f9437a;
            i = (int) ((d0Var.f9438b + j11) - j10);
            int i13 = d0Var.f9439c;
            while (i < i13) {
                byte b14 = bArr4[i];
                for (byte b15 : bArrG2) {
                    if (b14 == b15) {
                        i3 = d0Var.f9438b;
                    }
                }
                i++;
            }
            j11 = (d0Var.f9439c - d0Var.f9438b) + j10;
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j10 = j11;
        }
        return -1L;
        return (i - i3) + j10;
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j I(long j10) {
        c0(j10);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    @Override // od.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long J() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f9454f
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            od.d0 r7 = r15.f9453c
            r7.getClass()
            byte[] r8 = r7.f9437a
            int r9 = r7.f9438b
            int r10 = r7.f9439c
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
            od.i r15 = new od.i
            r15.<init>()
            r15.d0(r4)
            r15.b0(r11)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.U()
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
            char[] r2 = pd.b.f9998a
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
            od.d0 r8 = r7.a()
            r15.f9453c = r8
            od.e0.a(r7)
            goto L9c
        L9a:
            r7.f9438b = r9
        L9c:
            if (r6 != 0) goto La2
            od.d0 r7 = r15.f9453c
            if (r7 != 0) goto Lc
        La2:
            long r2 = r15.f9454f
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f9454f = r2
            return r4
        La9:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: od.i.J():long");
    }

    @Override // od.k
    public final InputStream L() {
        return new g(this, 0);
    }

    public final boolean M(l lVar) {
        lVar.getClass();
        int iC = lVar.c();
        if (iC >= 0 && this.f9454f >= iC && lVar.c() >= iC) {
            for (int i = 0; i < iC; i++) {
                if (C(i) == lVar.h(i)) {
                }
            }
            return true;
        }
        return false;
    }

    public final byte N() {
        if (this.f9454f == 0) {
            throw new EOFException();
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        int i = d0Var.f9438b;
        int i3 = d0Var.f9439c;
        int i10 = i + 1;
        byte b10 = d0Var.f9437a[i];
        this.f9454f--;
        if (i10 != i3) {
            d0Var.f9438b = i10;
            return b10;
        }
        this.f9453c = d0Var.a();
        e0.a(d0Var);
        return b10;
    }

    public final byte[] O(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            f.c(k0.a.m("byteCount: ", j10));
            return null;
        }
        if (this.f9454f < j10) {
            throw new EOFException();
        }
        int i = (int) j10;
        byte[] bArr = new byte[i];
        int i3 = 0;
        while (i3 < i) {
            int i10 = read(bArr, i3, i - i3);
            if (i10 == -1) {
                throw new EOFException();
            }
            i3 += i10;
        }
        return bArr;
    }

    public final l P(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            f.c(k0.a.m("byteCount: ", j10));
            return null;
        }
        if (this.f9454f < j10) {
            throw new EOFException();
        }
        if (j10 >= 4096) {
            l lVarX = X((int) j10);
            W(j10);
            return lVarX;
        }
        byte[] bArrO = O(j10);
        l lVar = new l();
        lVar.f9460c = bArrO;
        return lVar;
    }

    public final int Q() throws EOFException {
        if (this.f9454f < 4) {
            throw new EOFException();
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        int i = d0Var.f9438b;
        int i3 = d0Var.f9439c;
        if (i3 - i < 4) {
            return (N() & 255) | ((N() & 255) << 24) | ((N() & 255) << 16) | ((N() & 255) << 8);
        }
        byte[] bArr = d0Var.f9437a;
        int i10 = i + 3;
        int i11 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i12 = i + 4;
        int i13 = (bArr[i10] & 255) | i11;
        this.f9454f -= 4;
        if (i12 != i3) {
            d0Var.f9438b = i12;
            return i13;
        }
        this.f9453c = d0Var.a();
        e0.a(d0Var);
        return i13;
    }

    public final short R() throws EOFException {
        if (this.f9454f < 2) {
            throw new EOFException();
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        int i = d0Var.f9438b;
        int i3 = d0Var.f9439c;
        if (i3 - i < 2) {
            return (short) ((N() & 255) | ((N() & 255) << 8));
        }
        byte[] bArr = d0Var.f9437a;
        int i10 = i + 1;
        int i11 = (bArr[i] & 255) << 8;
        int i12 = i + 2;
        int i13 = (bArr[i10] & 255) | i11;
        this.f9454f -= 2;
        if (i12 == i3) {
            this.f9453c = d0Var.a();
            e0.a(d0Var);
        } else {
            d0Var.f9438b = i12;
        }
        return (short) i13;
    }

    public final short S() throws EOFException {
        short sR = R();
        return (short) (((sR & 255) << 8) | ((65280 & sR) >>> 8));
    }

    public final String T(long j10, Charset charset) throws EOFException {
        charset.getClass();
        if (j10 < 0 || j10 > 2147483647L) {
            f.c(k0.a.m("byteCount: ", j10));
            return null;
        }
        if (this.f9454f < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        int i = d0Var.f9438b;
        if (i + j10 > d0Var.f9439c) {
            return new String(O(j10), charset);
        }
        int i3 = (int) j10;
        String str = new String(d0Var.f9437a, i, i3, charset);
        int i10 = d0Var.f9438b + i3;
        d0Var.f9438b = i10;
        this.f9454f -= j10;
        if (i10 == d0Var.f9439c) {
            this.f9453c = d0Var.a();
            e0.a(d0Var);
        }
        return str;
    }

    public final String U() {
        return T(this.f9454f, hc.a.f5448a);
    }

    public final int V() {
        int i;
        int i3;
        int i10;
        if (this.f9454f == 0) {
            throw new EOFException();
        }
        byte bC = C(0L);
        if ((bC & 128) == 0) {
            i = bC & 127;
            i10 = 0;
            i3 = 1;
        } else if ((bC & 224) == 192) {
            i = bC & 31;
            i3 = 2;
            i10 = 128;
        } else if ((bC & 240) == 224) {
            i = bC & 15;
            i3 = 3;
            i10 = RecyclerView.ItemAnimator.FLAG_MOVED;
        } else {
            if ((bC & 248) != 240) {
                W(1L);
                return 65533;
            }
            i = bC & 7;
            i3 = 4;
            i10 = 65536;
        }
        long j10 = i3;
        if (this.f9454f < j10) {
            StringBuilder sbT = k0.a.t(i3, "size < ", ": ");
            sbT.append(this.f9454f);
            sbT.append(" (to read code point prefixed 0x");
            char[] cArr = pd.b.f9998a;
            sbT.append(new String(new char[]{cArr[(bC >> 4) & 15], cArr[bC & 15]}));
            sbT.append(')');
            throw new EOFException(sbT.toString());
        }
        for (int i11 = 1; i11 < i3; i11++) {
            long j11 = i11;
            byte bC2 = C(j11);
            if ((bC2 & 192) != 128) {
                W(j11);
                return 65533;
            }
            i = (i << 6) | (bC2 & 63);
        }
        W(j10);
        if (i <= 1114111 && ((55296 > i || i >= 57344) && i >= i10)) {
            return i;
        }
        return 65533;
    }

    public final void W(long j10) throws EOFException {
        while (j10 > 0) {
            d0 d0Var = this.f9453c;
            if (d0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, d0Var.f9439c - d0Var.f9438b);
            long j11 = iMin;
            this.f9454f -= j11;
            j10 -= j11;
            int i = d0Var.f9438b + iMin;
            d0Var.f9438b = i;
            if (i == d0Var.f9439c) {
                this.f9453c = d0Var.a();
                e0.a(d0Var);
            }
        }
    }

    public final l X(int i) {
        if (i == 0) {
            return l.f9459h;
        }
        a.a.m(this.f9454f, 0L, i);
        d0 d0Var = this.f9453c;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            d0Var.getClass();
            int i12 = d0Var.f9439c;
            int i13 = d0Var.f9438b;
            if (i12 == i13) {
                throw new AssertionError("s.limit == s.pos");
            }
            i10 += i12 - i13;
            i11++;
            d0Var = d0Var.f9442f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        d0 d0Var2 = this.f9453c;
        int i14 = 0;
        while (i3 < i) {
            d0Var2.getClass();
            bArr[i14] = d0Var2.f9437a;
            i3 += d0Var2.f9439c - d0Var2.f9438b;
            iArr[i14] = Math.min(i3, i);
            iArr[i14 + i11] = d0Var2.f9438b;
            d0Var2.f9440d = true;
            i14++;
            d0Var2 = d0Var2.f9442f;
        }
        return new f0(bArr, iArr);
    }

    public final d0 Y(int i) {
        if (i < 1 || i > 8192) {
            g5.f.s("unexpected capacity");
            return null;
        }
        d0 d0Var = this.f9453c;
        if (d0Var == null) {
            d0 d0VarB = e0.b();
            this.f9453c = d0VarB;
            d0VarB.f9443g = d0VarB;
            d0VarB.f9442f = d0VarB;
            return d0VarB;
        }
        d0 d0Var2 = d0Var.f9443g;
        d0Var2.getClass();
        if (d0Var2.f9439c + i <= 8192 && d0Var2.f9441e) {
            return d0Var2;
        }
        d0 d0VarB2 = e0.b();
        d0Var2.b(d0VarB2);
        return d0VarB2;
    }

    public final void Z(l lVar) {
        lVar.getClass();
        lVar.q(this, lVar.c());
    }

    public final long a0(i0 i0Var) {
        i0Var.getClass();
        long j10 = 0;
        while (true) {
            long jL = i0Var.l(this, 8192L);
            if (jL == -1) {
                return j10;
            }
            j10 += jL;
        }
    }

    @Override // od.i0
    public final k0 b() {
        return k0.f9455d;
    }

    public final void b0(int i) {
        d0 d0VarY = Y(1);
        byte[] bArr = d0VarY.f9437a;
        int i3 = d0VarY.f9439c;
        d0VarY.f9439c = i3 + 1;
        bArr[i3] = (byte) i;
        this.f9454f++;
    }

    public final void c0(long j10) {
        boolean z10;
        if (j10 == 0) {
            b0(48);
            return;
        }
        int i = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                g0("-9223372036854775808");
                return;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i = 2;
        }
        if (z10) {
            i++;
        }
        d0 d0VarY = Y(i);
        byte[] bArr = d0VarY.f9437a;
        int i3 = d0VarY.f9439c + i;
        while (j10 != 0) {
            long j11 = 10;
            i3--;
            bArr[i3] = pd.a.f9997a[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i3 - 1] = 45;
        }
        d0VarY.f9439c += i;
        this.f9454f += i;
    }

    public final void d() throws EOFException {
        W(this.f9454f);
    }

    public final void d0(long j10) {
        if (j10 == 0) {
            b0(48);
            return;
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        d0 d0VarY = Y(i);
        byte[] bArr = d0VarY.f9437a;
        int i3 = d0VarY.f9439c;
        for (int i10 = (i3 + i) - 1; i10 >= i3; i10--) {
            bArr[i10] = pd.a.f9997a[(int) (15 & j10)];
            j10 >>>= 4;
        }
        d0VarY.f9439c += i;
        this.f9454f += i;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final i clone() {
        i iVar = new i();
        if (this.f9454f == 0) {
            return iVar;
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        d0 d0VarC = d0Var.c();
        iVar.f9453c = d0VarC;
        d0VarC.f9443g = d0VarC;
        d0VarC.f9442f = d0VarC;
        for (d0 d0Var2 = d0Var.f9442f; d0Var2 != d0Var; d0Var2 = d0Var2.f9442f) {
            d0 d0Var3 = d0VarC.f9443g;
            d0Var3.getClass();
            d0Var2.getClass();
            d0Var3.b(d0Var2.c());
        }
        iVar.f9454f = this.f9454f;
        return iVar;
    }

    public final void e0(int i) {
        d0 d0VarY = Y(4);
        byte[] bArr = d0VarY.f9437a;
        int i3 = d0VarY.f9439c;
        bArr[i3] = (byte) ((i >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i & 255);
        d0VarY.f9439c = i3 + 4;
        this.f9454f += 4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        long j10 = this.f9454f;
        i iVar = (i) obj;
        if (j10 != iVar.f9454f) {
            return false;
        }
        if (j10 == 0) {
            return true;
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        d0 d0Var2 = iVar.f9453c;
        d0Var2.getClass();
        int i = d0Var.f9438b;
        int i3 = d0Var2.f9438b;
        long j11 = 0;
        while (j11 < this.f9454f) {
            long jMin = Math.min(d0Var.f9439c - i, d0Var2.f9439c - i3);
            long j12 = 0;
            while (j12 < jMin) {
                int i10 = i + 1;
                int i11 = i3 + 1;
                if (d0Var.f9437a[i] != d0Var2.f9437a[i3]) {
                    return false;
                }
                j12++;
                i = i10;
                i3 = i11;
            }
            if (i == d0Var.f9439c) {
                d0Var = d0Var.f9442f;
                d0Var.getClass();
                i = d0Var.f9438b;
            }
            if (i3 == d0Var2.f9439c) {
                d0Var2 = d0Var2.f9442f;
                d0Var2.getClass();
                i3 = d0Var2.f9438b;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // od.g0
    public final void f(i iVar, long j10) {
        d0 d0VarB;
        iVar.getClass();
        if (iVar == this) {
            g5.f.s("source == this");
            return;
        }
        a.a.m(iVar.f9454f, 0L, j10);
        while (j10 > 0) {
            d0 d0Var = iVar.f9453c;
            d0Var.getClass();
            int i = d0Var.f9439c;
            d0 d0Var2 = iVar.f9453c;
            d0Var2.getClass();
            long j11 = i - d0Var2.f9438b;
            int i3 = 0;
            if (j10 < j11) {
                d0 d0Var3 = this.f9453c;
                d0 d0Var4 = d0Var3 != null ? d0Var3.f9443g : null;
                if (d0Var4 != null && d0Var4.f9441e) {
                    if ((d0Var4.f9439c + j10) - (d0Var4.f9440d ? 0 : d0Var4.f9438b) <= 8192) {
                        d0 d0Var5 = iVar.f9453c;
                        d0Var5.getClass();
                        d0Var5.d(d0Var4, (int) j10);
                        iVar.f9454f -= j10;
                        this.f9454f += j10;
                        return;
                    }
                }
                d0 d0Var6 = iVar.f9453c;
                d0Var6.getClass();
                int i10 = (int) j10;
                if (i10 <= 0 || i10 > d0Var6.f9439c - d0Var6.f9438b) {
                    g5.f.s("byteCount out of range");
                    return;
                }
                if (i10 >= 1024) {
                    d0VarB = d0Var6.c();
                } else {
                    d0VarB = e0.b();
                    byte[] bArr = d0Var6.f9437a;
                    byte[] bArr2 = d0VarB.f9437a;
                    int i11 = d0Var6.f9438b;
                    kb.k.g0(bArr, 0, i11, bArr2, i11 + i10);
                }
                d0VarB.f9439c = d0VarB.f9438b + i10;
                d0Var6.f9438b += i10;
                d0 d0Var7 = d0Var6.f9443g;
                d0Var7.getClass();
                d0Var7.b(d0VarB);
                iVar.f9453c = d0VarB;
            }
            d0 d0Var8 = iVar.f9453c;
            d0Var8.getClass();
            long j12 = d0Var8.f9439c - d0Var8.f9438b;
            iVar.f9453c = d0Var8.a();
            d0 d0Var9 = this.f9453c;
            if (d0Var9 == null) {
                this.f9453c = d0Var8;
                d0Var8.f9443g = d0Var8;
                d0Var8.f9442f = d0Var8;
            } else {
                d0 d0Var10 = d0Var9.f9443g;
                d0Var10.getClass();
                d0Var10.b(d0Var8);
                d0 d0Var11 = d0Var8.f9443g;
                if (d0Var11 == d0Var8) {
                    f.e("cannot compact");
                    return;
                }
                d0Var11.getClass();
                if (d0Var11.f9441e) {
                    int i12 = d0Var8.f9439c - d0Var8.f9438b;
                    d0 d0Var12 = d0Var8.f9443g;
                    d0Var12.getClass();
                    int i13 = 8192 - d0Var12.f9439c;
                    d0 d0Var13 = d0Var8.f9443g;
                    d0Var13.getClass();
                    if (!d0Var13.f9440d) {
                        d0 d0Var14 = d0Var8.f9443g;
                        d0Var14.getClass();
                        i3 = d0Var14.f9438b;
                    }
                    if (i12 <= i13 + i3) {
                        d0 d0Var15 = d0Var8.f9443g;
                        d0Var15.getClass();
                        d0Var8.d(d0Var15, i12);
                        d0Var8.a();
                        e0.a(d0Var8);
                    }
                }
            }
            iVar.f9454f -= j12;
            this.f9454f += j12;
            j10 -= j12;
        }
    }

    public final void f0(int i, int i3, String str) {
        char cCharAt;
        str.getClass();
        if (i < 0) {
            f.c(k0.a.j(i, "beginIndex < 0: "));
            return;
        }
        if (i3 < i) {
            f.c(androidx.activity.b.i("endIndex < beginIndex: ", i3, " < ", i));
            return;
        }
        if (i3 > str.length()) {
            StringBuilder sbT = k0.a.t(i3, "endIndex > string.length: ", " > ");
            sbT.append(str.length());
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        while (i < i3) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                d0 d0VarY = Y(1);
                byte[] bArr = d0VarY.f9437a;
                int i10 = d0VarY.f9439c - i;
                int iMin = Math.min(i3, 8192 - i10);
                int i11 = i + 1;
                bArr[i + i10] = (byte) cCharAt2;
                while (true) {
                    i = i11;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i11 = i + 1;
                    bArr[i + i10] = (byte) cCharAt;
                }
                int i12 = d0VarY.f9439c;
                int i13 = (i10 + i) - i12;
                d0VarY.f9439c = i12 + i13;
                this.f9454f += i13;
            } else {
                if (cCharAt2 < 2048) {
                    d0 d0VarY2 = Y(2);
                    byte[] bArr2 = d0VarY2.f9437a;
                    int i14 = d0VarY2.f9439c;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    d0VarY2.f9439c = i14 + 2;
                    this.f9454f += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    d0 d0VarY3 = Y(3);
                    byte[] bArr3 = d0VarY3.f9437a;
                    int i15 = d0VarY3.f9439c;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    d0VarY3.f9439c = i15 + 3;
                    this.f9454f += 3;
                } else {
                    int i16 = i + 1;
                    char cCharAt3 = i16 < i3 ? str.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        b0(63);
                        i = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        d0 d0VarY4 = Y(4);
                        byte[] bArr4 = d0VarY4.f9437a;
                        int i18 = d0VarY4.f9439c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        d0VarY4.f9439c = i18 + 4;
                        this.f9454f += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void g0(String str) {
        str.getClass();
        f0(0, str.length(), str);
    }

    public final void h0(int i) {
        if (i < 128) {
            b0(i);
            return;
        }
        if (i < 2048) {
            d0 d0VarY = Y(2);
            byte[] bArr = d0VarY.f9437a;
            int i3 = d0VarY.f9439c;
            bArr[i3] = (byte) ((i >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i & 63) | 128);
            d0VarY.f9439c = i3 + 2;
            this.f9454f += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            b0(63);
            return;
        }
        if (i < 65536) {
            d0 d0VarY2 = Y(3);
            byte[] bArr2 = d0VarY2.f9437a;
            int i10 = d0VarY2.f9439c;
            bArr2[i10] = (byte) ((i >> 12) | 224);
            bArr2[i10 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i10 + 2] = (byte) ((i & 63) | 128);
            d0VarY2.f9439c = i10 + 3;
            this.f9454f += 3;
            return;
        }
        if (i > 1114111) {
            g5.f.s("Unexpected code point: 0x".concat(a.a.X(i)));
            return;
        }
        d0 d0VarY3 = Y(4);
        byte[] bArr3 = d0VarY3.f9437a;
        int i11 = d0VarY3.f9439c;
        bArr3[i11] = (byte) ((i >> 18) | 240);
        bArr3[i11 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i11 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i11 + 3] = (byte) ((i & 63) | 128);
        d0VarY3.f9439c = i11 + 4;
        this.f9454f += 4;
    }

    public final int hashCode() {
        d0 d0Var = this.f9453c;
        if (d0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i3 = d0Var.f9439c;
            for (int i10 = d0Var.f9438b; i10 < i3; i10++) {
                i = (i * 31) + d0Var.f9437a[i10];
            }
            d0Var = d0Var.f9442f;
            d0Var.getClass();
        } while (d0Var != this.f9453c);
        return i;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // od.k
    public final long k(j jVar) {
        long j10 = this.f9454f;
        if (j10 > 0) {
            jVar.f(this, j10);
        }
        return j10;
    }

    @Override // od.i0
    public final long l(i iVar, long j10) {
        iVar.getClass();
        if (j10 < 0) {
            f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        long j11 = this.f9454f;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        iVar.f(this, j10);
        return j10;
    }

    public final long n() {
        long j10 = this.f9454f;
        if (j10 == 0) {
            return 0L;
        }
        d0 d0Var = this.f9453c;
        d0Var.getClass();
        d0 d0Var2 = d0Var.f9443g;
        d0Var2.getClass();
        return (d0Var2.f9439c >= 8192 || !d0Var2.f9441e) ? j10 : j10 - (r2 - d0Var2.f9438b);
    }

    @Override // od.k
    public final String q(long j10) throws EOFException {
        if (j10 < 0) {
            f.c(k0.a.m("limit < 0: ", j10));
            return null;
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jF = F((byte) 10, 0L, j11);
        if (jF != -1) {
            return pd.a.a(this, jF);
        }
        if (j11 < this.f9454f && C(j11 - 1) == 13 && C(j11) == 10) {
            return pd.a.a(this, j11);
        }
        i iVar = new i();
        r(iVar, 0L, Math.min(32, this.f9454f));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f9454f, j10) + " content=" + iVar.P(iVar.f9454f).d() + (char) 8230);
    }

    public final void r(i iVar, long j10, long j11) {
        iVar.getClass();
        long j12 = j10;
        a.a.m(this.f9454f, j12, j11);
        if (j11 == 0) {
            return;
        }
        iVar.f9454f += j11;
        d0 d0Var = this.f9453c;
        while (true) {
            d0Var.getClass();
            long j13 = d0Var.f9439c - d0Var.f9438b;
            if (j12 < j13) {
                break;
            }
            j12 -= j13;
            d0Var = d0Var.f9442f;
        }
        long j14 = j11;
        while (j14 > 0) {
            d0Var.getClass();
            d0 d0VarC = d0Var.c();
            int i = d0VarC.f9438b + ((int) j12);
            d0VarC.f9438b = i;
            d0VarC.f9439c = Math.min(i + ((int) j14), d0VarC.f9439c);
            d0 d0Var2 = iVar.f9453c;
            if (d0Var2 == null) {
                d0VarC.f9443g = d0VarC;
                d0VarC.f9442f = d0VarC;
                iVar.f9453c = d0VarC;
            } else {
                d0 d0Var3 = d0Var2.f9443g;
                d0Var3.getClass();
                d0Var3.b(d0VarC);
            }
            j14 -= d0VarC.f9439c - d0VarC.f9438b;
            d0Var = d0Var.f9442f;
            j12 = 0;
        }
    }

    public final int read(byte[] bArr, int i, int i3) {
        a.a.m(bArr.length, i, i3);
        d0 d0Var = this.f9453c;
        if (d0Var == null) {
            return -1;
        }
        int iMin = Math.min(i3, d0Var.f9439c - d0Var.f9438b);
        byte[] bArr2 = d0Var.f9437a;
        int i10 = d0Var.f9438b;
        kb.k.g0(bArr2, i, i10, bArr, i10 + iMin);
        int i11 = d0Var.f9438b + iMin;
        d0Var.f9438b = i11;
        this.f9454f -= iMin;
        if (i11 == d0Var.f9439c) {
            this.f9453c = d0Var.a();
            e0.a(d0Var);
        }
        return iMin;
    }

    @Override // od.k
    public final boolean request(long j10) {
        return this.f9454f >= j10;
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j t(l lVar) {
        Z(lVar);
        return this;
    }

    public final String toString() {
        long j10 = this.f9454f;
        if (j10 <= 2147483647L) {
            return X((int) j10).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f9454f).toString());
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j u(int i, byte[] bArr) {
        write(bArr, 0, i);
        return this;
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j v(String str) {
        g0(str);
        return this;
    }

    public final void write(byte[] bArr, int i, int i3) {
        bArr.getClass();
        long j10 = i3;
        a.a.m(bArr.length, i, j10);
        int i10 = i3 + i;
        while (i < i10) {
            d0 d0VarY = Y(1);
            int iMin = Math.min(i10 - i, 8192 - d0VarY.f9439c);
            int i11 = i + iMin;
            kb.k.g0(bArr, d0VarY.f9439c, i, d0VarY.f9437a, i11);
            d0VarY.f9439c += iMin;
            i = i11;
        }
        this.f9454f += j10;
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j writeByte(int i) {
        b0(i);
        return this;
    }

    @Override // od.k
    public final String x(Charset charset) {
        return T(this.f9454f, charset);
    }

    @Override // od.j
    public final /* bridge */ /* synthetic */ j y(long j10) {
        d0(j10);
        return this;
    }

    @Override // od.k
    public final i a() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, od.g0
    public final void close() {
    }

    @Override // od.j, od.g0, java.io.Flushable
    public final void flush() {
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            d0 d0VarY = Y(1);
            int iMin = Math.min(i, 8192 - d0VarY.f9439c);
            byteBuffer.get(d0VarY.f9437a, d0VarY.f9439c, iMin);
            i -= iMin;
            d0VarY.f9439c += iMin;
        }
        this.f9454f += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        d0 d0Var = this.f9453c;
        if (d0Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), d0Var.f9439c - d0Var.f9438b);
        byteBuffer.put(d0Var.f9437a, d0Var.f9438b, iMin);
        int i = d0Var.f9438b + iMin;
        d0Var.f9438b = i;
        this.f9454f -= iMin;
        if (i == d0Var.f9439c) {
            this.f9453c = d0Var.a();
            e0.a(d0Var);
        }
        return iMin;
    }

    @Override // od.j
    public final j write(byte[] bArr) {
        bArr.getClass();
        write(bArr, 0, bArr.length);
        return this;
    }
}
