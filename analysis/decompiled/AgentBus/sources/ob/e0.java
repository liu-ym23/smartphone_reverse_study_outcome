package ob;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class e0 implements j {

    /* renamed from: f, reason: collision with root package name */
    public final k0 f7964f;

    /* renamed from: g, reason: collision with root package name */
    public final h f7965g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7966h;

    public e0(k0 k0Var) {
        q7.k.e(k0Var, "source");
        this.f7964f = k0Var;
        this.f7965g = new h();
    }

    @Override // ob.j
    public final long A(i iVar) {
        h hVar;
        q7.k.e(iVar, "sink");
        long j2 = 0;
        while (true) {
            k0 k0Var = this.f7964f;
            hVar = this.f7965g;
            if (k0Var.read(hVar, 8192L) == -1) {
                break;
            }
            long jB = hVar.b();
            if (jB > 0) {
                j2 += jB;
                iVar.write(hVar, jB);
            }
        }
        long j4 = hVar.f7993g;
        if (j4 <= 0) {
            return j2;
        }
        long j10 = j2 + j4;
        iVar.write(hVar, j4);
        return j10;
    }

    @Override // ob.j
    public final int B(y yVar) throws EOFException {
        q7.k.e(yVar, "options");
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            h hVar = this.f7965g;
            int iC = pb.a.c(hVar, yVar, true);
            if (iC != -2) {
                if (iC != -1) {
                    hVar.skip(yVar.f8040f[iC].d());
                    return iC;
                }
            } else if (this.f7964f.read(hVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // ob.j
    public final long D(k kVar) {
        q7.k.e(kVar, "bytes");
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            h hVar = this.f7965g;
            long jK = hVar.k(jMax, kVar);
            if (jK != -1) {
                return jK;
            }
            long j2 = hVar.f7993g;
            if (this.f7964f.read(hVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, (j2 - kVar.d()) + 1);
        }
    }

    @Override // ob.j
    public final String F(long j2) throws EOFException {
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("limit < 0: ", j2).toString());
        }
        long j4 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
        long jB = b((byte) 10, 0L, j4);
        h hVar = this.f7965g;
        if (jB != -1) {
            return pb.a.b(hVar, jB);
        }
        if (j4 < Long.MAX_VALUE && p(j4) && hVar.g(j4 - 1) == 13 && p(j4 + 1) && hVar.g(j4) == 10) {
            return pb.a.b(hVar, j4);
        }
        h hVar2 = new h();
        hVar.d(hVar2, 0L, Math.min(32, hVar.f7993g));
        throw new EOFException("\\n not found: limit=" + Math.min(hVar.f7993g, j2) + " content=" + hVar2.j(hVar2.f7993g).e() + (char) 8230);
    }

    @Override // ob.j
    public final void J(h hVar, long j2) throws EOFException {
        h hVar2 = this.f7965g;
        try {
            L(j2);
            hVar2.J(hVar, j2);
        } catch (EOFException e10) {
            hVar.K(hVar2);
            throw e10;
        }
    }

    @Override // ob.j
    public final void L(long j2) {
        if (!p(j2)) {
            throw new EOFException();
        }
    }

    @Override // ob.j
    public final long O() {
        h hVar;
        byte bG;
        L(1L);
        int i2 = 0;
        while (true) {
            int i10 = i2 + 1;
            boolean zP = p(i10);
            hVar = this.f7965g;
            if (!zP) {
                break;
            }
            bG = hVar.g(i2);
            if ((bG < 48 || bG > 57) && ((bG < 97 || bG > 102) && (bG < 65 || bG > 70))) {
                break;
            }
            i2 = i10;
        }
        if (i2 == 0) {
            ib.c.o(16);
            String string = Integer.toString(bG, 16);
            q7.k.d(string, "toString(...)");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return hVar.O();
    }

    @Override // ob.j
    public final String P(Charset charset) {
        k0 k0Var = this.f7964f;
        h hVar = this.f7965g;
        hVar.K(k0Var);
        return hVar.t(hVar.f7993g, charset);
    }

    public final boolean a() {
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        h hVar = this.f7965g;
        return hVar.e() && this.f7964f.read(hVar, 8192L) == -1;
    }

    public final long b(byte b10, long j2, long j4) {
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        if (0 > j4) {
            throw new IllegalArgumentException(a1.a.h("fromIndex=0 toIndex=", j4).toString());
        }
        long jMax = 0;
        while (jMax < j4) {
            h hVar = this.f7965g;
            byte b11 = b10;
            long j10 = j4;
            long jI = hVar.i(b11, jMax, j10);
            if (jI != -1) {
                return jI;
            }
            long j11 = hVar.f7993g;
            if (j11 >= j10 || this.f7964f.read(hVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j11);
            b10 = b11;
            j4 = j10;
        }
        return -1L;
    }

    @Override // ob.j
    public final h c() {
        return this.f7965g;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f7966h) {
            return;
        }
        this.f7966h = true;
        this.f7964f.close();
        this.f7965g.a();
    }

    public final int d() {
        L(4L);
        int i2 = this.f7965g.readInt();
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public final long e() throws EOFException {
        L(8L);
        long j2 = this.f7965g.readLong();
        return ((j2 & 255) << 56) | (((-72057594037927936L) & j2) >>> 56) | ((71776119061217280L & j2) >>> 40) | ((280375465082880L & j2) >>> 24) | ((1095216660480L & j2) >>> 8) | ((4278190080L & j2) << 8) | ((16711680 & j2) << 24) | ((65280 & j2) << 40);
    }

    public final short g() {
        L(2L);
        return this.f7965g.s();
    }

    public final String i(long j2) {
        L(j2);
        h hVar = this.f7965g;
        hVar.getClass();
        return hVar.t(j2, ga.a.f4005a);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f7966h;
    }

    @Override // ob.j
    public final k j(long j2) {
        L(j2);
        return this.f7965g.j(j2);
    }

    @Override // ob.j
    public final boolean p(long j2) {
        h hVar;
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        do {
            hVar = this.f7965g;
            if (hVar.f7993g >= j2) {
                return true;
            }
        } while (this.f7964f.read(hVar, 8192L) != -1);
        return false;
    }

    @Override // ob.j
    public final e0 peek() {
        return b.c(new a0(this));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        q7.k.e(byteBuffer, "sink");
        h hVar = this.f7965g;
        if (hVar.f7993g == 0 && this.f7964f.read(hVar, 8192L) == -1) {
            return -1;
        }
        return hVar.read(byteBuffer);
    }

    @Override // ob.j
    public final byte readByte() {
        L(1L);
        return this.f7965g.readByte();
    }

    @Override // ob.j
    public final void readFully(byte[] bArr) throws EOFException {
        h hVar = this.f7965g;
        q7.k.e(bArr, "sink");
        try {
            L(bArr.length);
            hVar.readFully(bArr);
        } catch (EOFException e10) {
            int i2 = 0;
            while (true) {
                long j2 = hVar.f7993g;
                if (j2 <= 0) {
                    throw e10;
                }
                int i10 = hVar.read(bArr, i2, (int) j2);
                if (i10 == -1) {
                    throw new AssertionError();
                }
                i2 += i10;
            }
        }
    }

    @Override // ob.j
    public final int readInt() {
        L(4L);
        return this.f7965g.readInt();
    }

    @Override // ob.j
    public final long readLong() {
        L(8L);
        return this.f7965g.readLong();
    }

    @Override // ob.j
    public final short readShort() {
        L(2L);
        return this.f7965g.readShort();
    }

    @Override // ob.j
    public final void skip(long j2) {
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        while (j2 > 0) {
            h hVar = this.f7965g;
            if (hVar.f7993g == 0 && this.f7964f.read(hVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j2, hVar.f7993g);
            hVar.skip(jMin);
            j2 -= jMin;
        }
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f7964f.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f7964f + ')';
    }

    @Override // ob.j
    public final String w() {
        return F(Long.MAX_VALUE);
    }

    @Override // ob.j
    public final long y(k kVar) {
        q7.k.e(kVar, "targetBytes");
        if (this.f7966h) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            h hVar = this.f7965g;
            long jN = hVar.n(jMax, kVar);
            if (jN != -1) {
                return jN;
            }
            long j2 = hVar.f7993g;
            if (this.f7964f.read(hVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j2);
        }
    }

    @Override // ob.k0
    public final long read(h hVar, long j2) {
        q7.k.e(hVar, "sink");
        if (j2 >= 0) {
            if (!this.f7966h) {
                h hVar2 = this.f7965g;
                if (hVar2.f7993g == 0 && this.f7964f.read(hVar2, 8192L) == -1) {
                    return -1L;
                }
                return hVar2.read(hVar, Math.min(j2, hVar2.f7993g));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
    }
}
