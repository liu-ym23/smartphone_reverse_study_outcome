package V9;

import ca.AbstractC0897f;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class r implements i {

    /* renamed from: a, reason: collision with root package name */
    public final w f1425a;
    public final g b;
    public boolean c;

    public r(w source) {
        kotlin.jvm.internal.k.f(source, "source");
        this.f1425a = source;
        this.b = new g();
    }

    @Override // V9.i
    public final long C() throws EOFException {
        g gVar;
        byte bR;
        t(1L);
        int i = 0;
        while (true) {
            int i6 = i + 1;
            boolean zRequest = request(i6);
            gVar = this.b;
            if (!zRequest) {
                break;
            }
            bR = gVar.r(i);
            if ((bR < 48 || bR > 57) && ((bR < 97 || bR > 102) && (bR < 65 || bR > 70))) {
                break;
            }
            i = i6;
        }
        if (i == 0) {
            AbstractC0897f.r(16);
            AbstractC0897f.r(16);
            String string = Integer.toString(bR, 16);
            kotlin.jvm.internal.k.e(string, "toString(this, checkRadix(radix))");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return gVar.C();
    }

    @Override // V9.i
    public final InputStream D() {
        return new e(this, 1);
    }

    @Override // V9.i, V9.h
    public final g a() {
        return this.b;
    }

    public final boolean b() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        g gVar = this.b;
        return gVar.n() && this.f1425a.e(gVar, 8192L) == -1;
    }

    public final long c(byte b, long j5, long j6) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j6) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j6, "fromIndex=0 toIndex=").toString());
        }
        long jMax = 0;
        while (jMax < j6) {
            g gVar = this.b;
            byte b5 = b;
            long j10 = j6;
            long jS = gVar.s(b5, jMax, j10);
            if (jS != -1) {
                return jS;
            }
            long j11 = gVar.b;
            if (j11 >= j10 || this.f1425a.e(gVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j11);
            b = b5;
            j6 = j10;
        }
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f1425a.close();
        this.b.b();
    }

    @Override // V9.i
    public final g d() {
        return this.b;
    }

    @Override // V9.w
    public final long e(g sink, long j5) {
        kotlin.jvm.internal.k.f(sink, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount < 0: ").toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        g gVar = this.b;
        if (gVar.b == 0 && this.f1425a.e(gVar, 8192L) == -1) {
            return -1L;
        }
        return gVar.e(sink, Math.min(j5, gVar.b));
    }

    public final int f() throws EOFException {
        t(4L);
        int i = this.b.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // V9.i
    public final long h(ByteString targetBytes) {
        kotlin.jvm.internal.k.f(targetBytes, "targetBytes");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            g gVar = this.b;
            long jW = gVar.w(targetBytes, jMax);
            if (jW != -1) {
                return jW;
            }
            long j5 = gVar.b;
            if (this.f1425a.e(gVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j5);
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // V9.i
    public final String j(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "limit < 0: ").toString());
        }
        long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
        long jC = c((byte) 10, 0L, j6);
        g gVar = this.b;
        if (jC != -1) {
            return W9.a.a(gVar, jC);
        }
        if (j6 < Long.MAX_VALUE && request(j6) && gVar.r(j6 - 1) == 13 && request(j6 + 1) && gVar.r(j6) == 10) {
            return W9.a.a(gVar, j6);
        }
        g gVar2 = new g();
        gVar.k(gVar2, 0L, Math.min(32, gVar.b));
        throw new EOFException("\\n not found: limit=" + Math.min(gVar.b, j5) + " content=" + gVar2.v(gVar2.b).d() + (char) 8230);
    }

    @Override // V9.i
    public final long o(g gVar) {
        g gVar2;
        long j5 = 0;
        while (true) {
            w wVar = this.f1425a;
            gVar2 = this.b;
            if (wVar.e(gVar2, 8192L) == -1) {
                break;
            }
            long jF = gVar2.f();
            if (jF > 0) {
                j5 += jF;
                gVar.write(gVar2, jF);
            }
        }
        long j6 = gVar2.b;
        if (j6 <= 0) {
            return j5;
        }
        long j10 = j5 + j6;
        gVar.write(gVar2, j6);
        return j10;
    }

    @Override // V9.i
    public final void p(g gVar, long j5) throws EOFException {
        g gVar2 = this.b;
        try {
            t(j5);
            gVar2.p(gVar, j5);
        } catch (EOFException e) {
            gVar.B(gVar2);
            throw e;
        }
    }

    @Override // V9.i
    public final String q() {
        return j(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.f(sink, "sink");
        g gVar = this.b;
        if (gVar.b == 0 && this.f1425a.e(gVar, 8192L) == -1) {
            return -1;
        }
        return gVar.read(sink);
    }

    @Override // V9.i
    public final byte readByte() {
        t(1L);
        return this.b.readByte();
    }

    @Override // V9.i
    public final int readInt() throws EOFException {
        t(4L);
        return this.b.readInt();
    }

    @Override // V9.i
    public final short readShort() throws EOFException {
        t(2L);
        return this.b.readShort();
    }

    @Override // V9.i
    public final boolean request(long j5) {
        g gVar;
        if (j5 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.p(j5, "byteCount < 0: ").toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            gVar = this.b;
            if (gVar.b >= j5) {
                return true;
            }
        } while (this.f1425a.e(gVar, 8192L) != -1);
        return false;
    }

    @Override // V9.i
    public final void skip(long j5) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j5 > 0) {
            g gVar = this.b;
            if (gVar.b == 0 && this.f1425a.e(gVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j5, gVar.b);
            gVar.skip(jMin);
            j5 -= jMin;
        }
    }

    @Override // V9.i
    public final void t(long j5) throws EOFException {
        if (!request(j5)) {
            throw new EOFException();
        }
    }

    @Override // V9.w
    public final y timeout() {
        return this.f1425a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f1425a + ')';
    }

    @Override // V9.i
    public final ByteString v(long j5) throws EOFException {
        t(j5);
        return this.b.v(j5);
    }

    @Override // V9.i
    public final String x(Charset charset) {
        w wVar = this.f1425a;
        g gVar = this.b;
        gVar.B(wVar);
        return gVar.x(charset);
    }

    @Override // V9.i
    public final int z(p options) throws EOFException {
        kotlin.jvm.internal.k.f(options, "options");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            g gVar = this.b;
            int iB = W9.a.b(gVar, options, true);
            if (iB != -2) {
                if (iB != -1) {
                    gVar.skip(options.f1423a[iB].c());
                    return iB;
                }
            } else if (this.f1425a.e(gVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }
}
