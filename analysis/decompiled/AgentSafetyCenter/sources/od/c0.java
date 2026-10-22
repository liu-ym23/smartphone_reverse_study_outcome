package od;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements k {

    /* renamed from: c, reason: collision with root package name */
    public final i0 f9427c;

    /* renamed from: f, reason: collision with root package name */
    public final i f9428f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9429g;

    public c0(i0 i0Var) {
        i0Var.getClass();
        this.f9427c = i0Var;
        this.f9428f = new i();
    }

    public final short A() {
        H(2L);
        return this.f9428f.R();
    }

    public final short C() {
        H(2L);
        return this.f9428f.S();
    }

    @Override // od.k
    public final String D() {
        return q(Long.MAX_VALUE);
    }

    @Override // od.k
    public final int E(y yVar) throws EOFException {
        yVar.getClass();
        if (this.f9429g) {
            f.e("closed");
            return 0;
        }
        while (true) {
            i iVar = this.f9428f;
            int iB = pd.a.b(iVar, yVar, true);
            if (iB != -2) {
                if (iB != -1) {
                    iVar.W(yVar.f9495f[iB].c());
                    return iB;
                }
            } else if (this.f9427c.l(iVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    public final String F(long j10) {
        H(j10);
        return this.f9428f.T(j10, hc.a.f5448a);
    }

    public final void H(long j10) {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // od.k
    public final long J() {
        i iVar;
        byte bC;
        H(1L);
        int i = 0;
        while (true) {
            int i3 = i + 1;
            boolean zRequest = request(i3);
            iVar = this.f9428f;
            if (!zRequest) {
                break;
            }
            bC = iVar.C(i);
            if ((bC < 48 || bC > 57) && ((bC < 97 || bC > 102) && (bC < 65 || bC > 70))) {
                break;
            }
            i = i3;
        }
        if (i == 0) {
            com.stepos.statsrpk.h.f(16);
            String string = Integer.toString(bC, 16);
            string.getClass();
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return iVar.J();
    }

    @Override // od.k
    public final InputStream L() {
        return new g(this, 1);
    }

    public final void M(long j10) {
        if (this.f9429g) {
            f.e("closed");
            return;
        }
        while (j10 > 0) {
            i iVar = this.f9428f;
            if (iVar.f9454f == 0 && this.f9427c.l(iVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, iVar.f9454f);
            iVar.W(jMin);
            j10 -= jMin;
        }
    }

    @Override // od.k
    public final i a() {
        return this.f9428f;
    }

    @Override // od.i0
    public final k0 b() {
        return this.f9427c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f9429g) {
            return;
        }
        this.f9429g = true;
        this.f9427c.close();
        this.f9428f.d();
    }

    public final boolean d() {
        if (this.f9429g) {
            f.e("closed");
            return false;
        }
        i iVar = this.f9428f;
        return iVar.A() && this.f9427c.l(iVar, 8192L) == -1;
    }

    public final long e(byte b10, long j10, long j11) {
        if (this.f9429g) {
            f.e("closed");
            return 0L;
        }
        if (0 > j11) {
            f.c(k0.a.m("fromIndex=0 toIndex=", j11));
            return 0L;
        }
        long jMax = 0;
        while (jMax < j11) {
            i iVar = this.f9428f;
            byte b11 = b10;
            long j12 = j11;
            long jF = iVar.F(b11, jMax, j12);
            if (jF != -1) {
                return jF;
            }
            long j13 = iVar.f9454f;
            if (j13 >= j12 || this.f9427c.l(iVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j13);
            b10 = b11;
            j11 = j12;
        }
        return -1L;
    }

    public final byte g() {
        H(1L);
        return this.f9428f.N();
    }

    public final l i(long j10) {
        H(j10);
        return this.f9428f.P(j10);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f9429g;
    }

    @Override // od.k
    public final long k(j jVar) {
        i iVar;
        long j10 = 0;
        while (true) {
            i0 i0Var = this.f9427c;
            iVar = this.f9428f;
            if (i0Var.l(iVar, 8192L) == -1) {
                break;
            }
            long jN = iVar.n();
            if (jN > 0) {
                j10 += jN;
                jVar.f(iVar, jN);
            }
        }
        long j11 = iVar.f9454f;
        if (j11 <= 0) {
            return j10;
        }
        long j12 = j10 + j11;
        jVar.f(iVar, j11);
        return j12;
    }

    @Override // od.i0
    public final long l(i iVar, long j10) {
        iVar.getClass();
        if (j10 < 0) {
            f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        if (this.f9429g) {
            f.e("closed");
            return 0L;
        }
        i iVar2 = this.f9428f;
        if (iVar2.f9454f == 0 && this.f9427c.l(iVar2, 8192L) == -1) {
            return -1L;
        }
        return iVar2.l(iVar, Math.min(j10, iVar2.f9454f));
    }

    public final int n() {
        H(4L);
        return this.f9428f.Q();
    }

    public final int o() {
        H(4L);
        int iQ = this.f9428f.Q();
        return ((iQ & 255) << 24) | (((-16777216) & iQ) >>> 24) | ((16711680 & iQ) >>> 8) | ((65280 & iQ) << 8);
    }

    @Override // od.k
    public final String q(long j10) throws EOFException {
        if (j10 < 0) {
            f.c(k0.a.m("limit < 0: ", j10));
            return null;
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jE = e((byte) 10, 0L, j11);
        i iVar = this.f9428f;
        if (jE != -1) {
            return pd.a.a(iVar, jE);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && iVar.C(j11 - 1) == 13 && request(j11 + 1) && iVar.C(j11) == 10) {
            return pd.a.a(iVar, j11);
        }
        i iVar2 = new i();
        iVar.r(iVar2, 0L, Math.min(32, iVar.f9454f));
        throw new EOFException("\\n not found: limit=" + Math.min(iVar.f9454f, j10) + " content=" + iVar2.P(iVar2.f9454f).d() + (char) 8230);
    }

    public final long r() throws EOFException {
        char c9;
        char c10;
        long jQ;
        H(8L);
        i iVar = this.f9428f;
        if (iVar.f9454f < 8) {
            throw new EOFException();
        }
        d0 d0Var = iVar.f9453c;
        d0Var.getClass();
        int i = d0Var.f9438b;
        int i3 = d0Var.f9439c;
        if (i3 - i < 8) {
            jQ = ((iVar.Q() & 4294967295L) << 32) | (4294967295L & iVar.Q());
            c9 = 24;
            c10 = '(';
        } else {
            byte[] bArr = d0Var.f9437a;
            c9 = 24;
            c10 = '(';
            int i10 = i + 7;
            long j10 = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
            int i11 = i + 8;
            long j11 = j10 | (bArr[i10] & 255);
            iVar.f9454f -= 8;
            if (i11 == i3) {
                iVar.f9453c = d0Var.a();
                e0.a(d0Var);
            } else {
                d0Var.f9438b = i11;
            }
            jQ = j11;
        }
        return ((jQ & 255) << 56) | (((-72057594037927936L) & jQ) >>> 56) | ((71776119061217280L & jQ) >>> c10) | ((280375465082880L & jQ) >>> c9) | ((1095216660480L & jQ) >>> 8) | ((4278190080L & jQ) << 8) | ((16711680 & jQ) << c9) | ((65280 & jQ) << c10);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        i iVar = this.f9428f;
        if (iVar.f9454f == 0 && this.f9427c.l(iVar, 8192L) == -1) {
            return -1;
        }
        return iVar.read(byteBuffer);
    }

    @Override // od.k
    public final boolean request(long j10) {
        i iVar;
        if (j10 < 0) {
            f.c(k0.a.m("byteCount < 0: ", j10));
            return false;
        }
        if (this.f9429g) {
            f.e("closed");
            return false;
        }
        do {
            iVar = this.f9428f;
            if (iVar.f9454f >= j10) {
                return true;
            }
        } while (this.f9427c.l(iVar, 8192L) != -1);
        return false;
    }

    public final String toString() {
        return "buffer(" + this.f9427c + ')';
    }

    @Override // od.k
    public final String x(Charset charset) {
        i0 i0Var = this.f9427c;
        i iVar = this.f9428f;
        iVar.a0(i0Var);
        return iVar.T(iVar.f9454f, charset);
    }
}
