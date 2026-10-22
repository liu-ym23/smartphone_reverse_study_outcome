package sd;

import androidx.datastore.preferences.protobuf.b1;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;
import sd.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z implements h {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f11986a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11987b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11988c;

    public z(e0 source) {
        kotlin.jvm.internal.g.f(source, "source");
        this.f11986a = source;
        this.f11987b = new e();
    }

    public final short C() throws EOFException {
        T(2L);
        return this.f11987b.H0();
    }

    @Override // sd.h
    public final long E0() throws EOFException {
        e eVar;
        byte bS;
        T(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            boolean zM = M(i11);
            eVar = this.f11987b;
            if (!zM) {
                break;
            }
            bS = eVar.S(i10);
            if ((bS < 48 || bS > 57) && ((bS < 97 || bS > 102) && (bS < 65 || bS > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            b1.l(16);
            String string = Integer.toString(bS, 16);
            kotlin.jvm.internal.g.e(string, "toString(...)");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return eVar.E0();
    }

    @Override // sd.h
    public final InputStream F0() {
        return new a();
    }

    @Override // sd.h
    public final void I(e sink, long j10) throws EOFException {
        e eVar = this.f11987b;
        kotlin.jvm.internal.g.f(sink, "sink");
        try {
            T(j10);
            eVar.I(sink, j10);
        } catch (EOFException e10) {
            sink.u(eVar);
            throw e10;
        }
    }

    public final String K(long j10) throws EOFException {
        T(j10);
        e eVar = this.f11987b;
        eVar.getClass();
        return eVar.I0(j10, gc.a.f9106b);
    }

    @Override // sd.h
    public final boolean M(long j10) {
        e eVar;
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
        }
        if (this.f11988c) {
            throw new IllegalStateException("closed");
        }
        do {
            eVar = this.f11987b;
            if (eVar.f11926b >= j10) {
                return true;
            }
        } while (this.f11986a.read(eVar, 8192L) != -1);
        return false;
    }

    @Override // sd.h
    public final String N() {
        return x(Long.MAX_VALUE);
    }

    @Override // sd.h
    public final int R(w options) throws EOFException {
        kotlin.jvm.internal.g.f(options, "options");
        if (this.f11988c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            e eVar = this.f11987b;
            int iB = td.a.b(eVar, options, true);
            if (iB != -2) {
                if (iB != -1) {
                    eVar.skip(options.f11979a[iB].d());
                    return iB;
                }
            } else if (this.f11986a.read(eVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // sd.h
    public final void T(long j10) throws EOFException {
        if (!M(j10)) {
            throw new EOFException();
        }
    }

    @Override // sd.h
    public final ByteString X(long j10) throws EOFException {
        T(j10);
        return this.f11987b.X(j10);
    }

    public final long a(byte b10, long j10, long j11) {
        if (this.f11988c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j11) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j11, "fromIndex=0 toIndex=").toString());
        }
        long jMax = 0;
        while (jMax < j11) {
            byte b11 = b10;
            long j12 = j11;
            long jC0 = this.f11987b.c0(b11, jMax, j12);
            if (jC0 != -1) {
                return jC0;
            }
            e eVar = this.f11987b;
            long j13 = eVar.f11926b;
            if (j13 >= j12 || this.f11986a.read(eVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j13);
            b10 = b11;
            j11 = j12;
        }
        return -1L;
    }

    @Override // sd.h, sd.g
    public final e c() {
        return this.f11987b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f11988c) {
            return;
        }
        this.f11988c = true;
        this.f11986a.close();
        this.f11987b.o();
    }

    @Override // sd.h
    public final long d0(e eVar) {
        e eVar2;
        long j10 = 0;
        while (true) {
            e0 e0Var = this.f11986a;
            eVar2 = this.f11987b;
            if (e0Var.read(eVar2, 8192L) == -1) {
                break;
            }
            long jC = eVar2.C();
            if (jC > 0) {
                j10 += jC;
                eVar.j0(eVar2, jC);
            }
        }
        long j11 = eVar2.f11926b;
        if (j11 <= 0) {
            return j10;
        }
        long j12 = j10 + j11;
        eVar.j0(eVar2, j11);
        return j12;
    }

    @Override // sd.h
    public final boolean f0() {
        if (this.f11988c) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.f11987b;
        return eVar.f0() && this.f11986a.read(eVar, 8192L) == -1;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f11988c;
    }

    public final int o() throws EOFException {
        T(4L);
        return sd.a.d(this.f11987b.readInt());
    }

    @Override // sd.h
    public final String p0(Charset charset) {
        kotlin.jvm.internal.g.f(charset, "charset");
        e0 e0Var = this.f11986a;
        e eVar = this.f11987b;
        eVar.u(e0Var);
        return eVar.p0(charset);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        e eVar = this.f11987b;
        if (eVar.f11926b == 0 && this.f11986a.read(eVar, 8192L) == -1) {
            return -1;
        }
        return eVar.read(sink);
    }

    @Override // sd.h
    public final byte readByte() throws EOFException {
        T(1L);
        return this.f11987b.readByte();
    }

    @Override // sd.h
    public final void readFully(byte[] sink) throws EOFException {
        e eVar = this.f11987b;
        kotlin.jvm.internal.g.f(sink, "sink");
        try {
            T(sink.length);
            eVar.readFully(sink);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                long j10 = eVar.f11926b;
                if (j10 <= 0) {
                    throw e10;
                }
                int i11 = eVar.read(sink, i10, (int) j10);
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
        }
    }

    @Override // sd.h
    public final int readInt() throws EOFException {
        T(4L);
        return this.f11987b.readInt();
    }

    @Override // sd.h
    public final long readLong() throws EOFException {
        T(8L);
        return this.f11987b.readLong();
    }

    @Override // sd.h
    public final short readShort() throws EOFException {
        T(2L);
        return this.f11987b.readShort();
    }

    @Override // sd.h
    public final void skip(long j10) throws EOFException {
        if (this.f11988c) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            e eVar = this.f11987b;
            if (eVar.f11926b == 0 && this.f11986a.read(eVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, eVar.f11926b);
            eVar.skip(jMin);
            j10 -= jMin;
        }
    }

    @Override // sd.e0
    public final f0 timeout() {
        return this.f11986a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f11986a + ')';
    }

    @Override // sd.h
    public final String v() {
        long jA = a((byte) 10, 0L, Long.MAX_VALUE);
        e eVar = this.f11987b;
        if (jA != -1) {
            return td.a.a(eVar, jA);
        }
        long j10 = eVar.f11926b;
        if (j10 != 0) {
            return K(j10);
        }
        return null;
    }

    public final long w() throws EOFException {
        T(8L);
        long j10 = this.f11987b.readLong();
        e.a aVar = sd.a.f11899a;
        return ((j10 & 255) << 56) | (((-72057594037927936L) & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    @Override // sd.h
    public final String x(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "limit < 0: ").toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jA = a((byte) 10, 0L, j11);
        e eVar = this.f11987b;
        if (jA != -1) {
            return td.a.a(eVar, jA);
        }
        if (j11 < Long.MAX_VALUE && M(j11) && eVar.S(j11 - 1) == 13 && M(j11 + 1) && eVar.S(j11) == 10) {
            return td.a.a(eVar, j11);
        }
        e eVar2 = new e();
        eVar.P(eVar2, 0L, Math.min(32, eVar.f11926b));
        throw new EOFException("\\n not found: limit=" + Math.min(eVar.f11926b, j10) + " content=" + eVar2.X(eVar2.f11926b).e() + (char) 8230);
    }

    @Override // sd.e0
    public final long read(e sink, long j10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        if (j10 >= 0) {
            if (!this.f11988c) {
                e eVar = this.f11987b;
                if (eVar.f11926b == 0 && this.f11986a.read(eVar, 8192L) == -1) {
                    return -1L;
                }
                return eVar.read(sink, Math.min(j10, eVar.f11926b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public final int available() throws IOException {
            z zVar = z.this;
            if (zVar.f11988c) {
                throw new IOException("closed");
            }
            return (int) Math.min(zVar.f11987b.f11926b, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            z.this.close();
        }

        @Override // java.io.InputStream
        public final int read() throws IOException {
            z zVar = z.this;
            e eVar = zVar.f11987b;
            if (zVar.f11988c) {
                throw new IOException("closed");
            }
            if (eVar.f11926b == 0 && zVar.f11986a.read(eVar, 8192L) == -1) {
                return -1;
            }
            return eVar.readByte() & 255;
        }

        public final String toString() {
            return z.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public final int read(byte[] data, int i10, int i11) throws IOException {
            kotlin.jvm.internal.g.f(data, "data");
            z zVar = z.this;
            e eVar = zVar.f11987b;
            if (!zVar.f11988c) {
                sd.a.b(data.length, i10, i11);
                if (eVar.f11926b == 0 && zVar.f11986a.read(eVar, 8192L) == -1) {
                    return -1;
                }
                return eVar.read(data, i10, i11);
            }
            throw new IOException("closed");
        }
    }
}
