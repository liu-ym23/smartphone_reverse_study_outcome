package L4;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class s implements g {

    /* renamed from: a, reason: collision with root package name */
    public final e f3969a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3970b;

    /* renamed from: c, reason: collision with root package name */
    public final y f3971c;

    public s(y yVar) {
        j4.k.h(yVar, "source");
        this.f3971c = yVar;
        this.f3969a = new e();
    }

    @Override // L4.g
    public int J(p pVar) throws EOFException {
        j4.k.h(pVar, "options");
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        do {
            int iU = this.f3969a.U(pVar, true);
            if (iU != -2) {
                if (iU == -1) {
                    return -1;
                }
                this.f3969a.skip(pVar.f()[iU].w());
                return iU;
            }
        } while (this.f3971c.e(this.f3969a, 8192) != -1);
        return -1;
    }

    @Override // L4.g
    public String K(Charset charset) {
        j4.k.h(charset, "charset");
        this.f3969a.k0(this.f3971c);
        return this.f3969a.K(charset);
    }

    public long a(byte b6) {
        return c(b6, 0L, Long.MAX_VALUE);
    }

    @Override // L4.y
    public z b() {
        return this.f3971c.b();
    }

    @Override // L4.g
    public String b0() {
        return y(Long.MAX_VALUE);
    }

    public long c(byte b6, long j5, long j6) {
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        if (0 > j5 || j6 < j5) {
            throw new IllegalArgumentException(("fromIndex=" + j5 + " toIndex=" + j6).toString());
        }
        long jMax = j5;
        while (jMax < j6) {
            byte b7 = b6;
            long j7 = j6;
            long jC = this.f3969a.C(b7, jMax, j7);
            if (jC != -1) {
                return jC;
            }
            long size = this.f3969a.size();
            if (size >= j7 || this.f3971c.e(this.f3969a, 8192) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b6 = b7;
            j6 = j7;
        }
        return -1L;
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f3970b) {
            return;
        }
        this.f3970b = true;
        this.f3971c.close();
        this.f3969a.u();
    }

    @Override // L4.y
    public long e(e eVar, long j5) {
        j4.k.h(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        if (this.f3969a.size() == 0 && this.f3971c.e(this.f3969a, 8192) == -1) {
            return -1L;
        }
        return this.f3969a.e(eVar, Math.min(j5, this.f3969a.size()));
    }

    @Override // L4.g
    public long e0(w wVar) {
        j4.k.h(wVar, "sink");
        long j5 = 0;
        while (this.f3971c.e(this.f3969a, 8192) != -1) {
            long jW = this.f3969a.w();
            if (jW > 0) {
                j5 += jW;
                wVar.y0(this.f3969a, jW);
            }
        }
        if (this.f3969a.size() <= 0) {
            return j5;
        }
        long size = j5 + this.f3969a.size();
        e eVar = this.f3969a;
        wVar.y0(eVar, eVar.size());
        return size;
    }

    public int f() throws EOFException {
        q0(4L);
        return this.f3969a.I();
    }

    @Override // L4.g
    public byte[] g0(long j5) throws EOFException {
        q0(j5);
        return this.f3969a.g0(j5);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3970b;
    }

    @Override // L4.g
    public h j(long j5) throws EOFException {
        q0(j5);
        return this.f3969a.j(j5);
    }

    public short m() throws EOFException {
        q0(2L);
        return this.f3969a.L();
    }

    public boolean o(long j5) {
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        while (this.f3969a.size() < j5) {
            if (this.f3971c.e(this.f3969a, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // L4.g
    public void q0(long j5) throws EOFException {
        if (!o(j5)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        j4.k.h(byteBuffer, "sink");
        if (this.f3969a.size() == 0 && this.f3971c.e(this.f3969a, 8192) == -1) {
            return -1;
        }
        return this.f3969a.read(byteBuffer);
    }

    @Override // L4.g
    public byte readByte() throws EOFException {
        q0(1L);
        return this.f3969a.readByte();
    }

    @Override // L4.g
    public void readFully(byte[] bArr) throws EOFException {
        j4.k.h(bArr, "sink");
        try {
            q0(bArr.length);
            this.f3969a.readFully(bArr);
        } catch (EOFException e6) {
            int i5 = 0;
            while (this.f3969a.size() > 0) {
                e eVar = this.f3969a;
                int i6 = eVar.read(bArr, i5, (int) eVar.size());
                if (i6 == -1) {
                    throw new AssertionError();
                }
                i5 += i6;
            }
            throw e6;
        }
    }

    @Override // L4.g
    public int readInt() throws EOFException {
        q0(4L);
        return this.f3969a.readInt();
    }

    @Override // L4.g
    public short readShort() throws EOFException {
        q0(2L);
        return this.f3969a.readShort();
    }

    @Override // L4.g
    public e s() {
        return this.f3969a;
    }

    @Override // L4.g
    public void skip(long j5) throws EOFException {
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        while (j5 > 0) {
            if (this.f3969a.size() == 0 && this.f3971c.e(this.f3969a, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j5, this.f3969a.size());
            this.f3969a.skip(jMin);
            j5 -= jMin;
        }
    }

    @Override // L4.g
    public boolean t() {
        if (this.f3970b) {
            throw new IllegalStateException("closed");
        }
        return this.f3969a.t() && this.f3971c.e(this.f3969a, (long) 8192) == -1;
    }

    public String toString() {
        return "buffer(" + this.f3971c + ')';
    }

    @Override // L4.g
    public long v0() throws EOFException {
        byte bA;
        q0(1L);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (!o(i6)) {
                break;
            }
            bA = this.f3969a.A(i5);
            if ((bA < ((byte) 48) || bA > ((byte) 57)) && ((bA < ((byte) 97) || bA > ((byte) 102)) && (bA < ((byte) 65) || bA > ((byte) 70)))) {
                break;
            }
            i5 = i6;
        }
        if (i5 == 0) {
            j4.y yVar = j4.y.f17839a;
            String str = String.format("Expected leading [0-9a-fA-F] character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(bA)}, 1));
            j4.k.c(str, "java.lang.String.format(format, *args)");
            throw new NumberFormatException(str);
        }
        return this.f3969a.v0();
    }

    @Override // L4.g
    public InputStream x0() {
        return new a();
    }

    @Override // L4.g
    public String y(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j5).toString());
        }
        long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
        byte b6 = (byte) 10;
        long jC = c(b6, 0L, j6);
        if (jC != -1) {
            return this.f3969a.T(jC);
        }
        if (j6 < Long.MAX_VALUE && o(j6) && this.f3969a.A(j6 - 1) == ((byte) 13) && o(j6 + 1) && this.f3969a.A(j6) == b6) {
            return this.f3969a.T(j6);
        }
        e eVar = new e();
        e eVar2 = this.f3969a;
        eVar2.x(eVar, 0L, Math.min(32, eVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3969a.size(), j5) + " content=" + eVar.G().n() + "…");
    }

    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            s sVar = s.this;
            if (sVar.f3970b) {
                throw new IOException("closed");
            }
            return (int) Math.min(sVar.f3969a.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            s.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            s sVar = s.this;
            if (sVar.f3970b) {
                throw new IOException("closed");
            }
            if (sVar.f3969a.size() == 0) {
                s sVar2 = s.this;
                if (sVar2.f3971c.e(sVar2.f3969a, 8192) == -1) {
                    return -1;
                }
            }
            return s.this.f3969a.readByte() & 255;
        }

        public String toString() {
            return s.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) throws IOException {
            j4.k.h(bArr, "data");
            if (!s.this.f3970b) {
                c.b(bArr.length, i5, i6);
                if (s.this.f3969a.size() == 0) {
                    s sVar = s.this;
                    if (sVar.f3971c.e(sVar.f3969a, 8192) == -1) {
                        return -1;
                    }
                }
                return s.this.f3969a.read(bArr, i5, i6);
            }
            throw new IOException("closed");
        }
    }
}
