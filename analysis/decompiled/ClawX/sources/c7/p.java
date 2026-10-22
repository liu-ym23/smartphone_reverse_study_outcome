package c7;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p implements h {

    /* renamed from: a, reason: collision with root package name */
    public final v f1184a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1185b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1186c;

    public p(v source) {
        kotlin.jvm.internal.p.e(source, "source");
        this.f1184a = source;
        this.f1185b = new f();
    }

    @Override // c7.h
    public final void D(long j4, f fVar) throws EOFException {
        f fVar2 = this.f1185b;
        try {
            f(j4);
            fVar2.D(j4, fVar);
        } catch (EOFException e9) {
            fVar.z(fVar2);
            throw e9;
        }
    }

    public final long a(byte b9, long j4, long j8) {
        if (this.f1186c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j8) {
            throw new IllegalArgumentException(a8.b.l(j8, "fromIndex=0 toIndex=").toString());
        }
        long jMax = 0;
        while (jMax < j8) {
            f fVar = this.f1185b;
            byte b10 = b9;
            long j9 = j8;
            long jE = fVar.e(b10, jMax, j9);
            if (jE != -1) {
                return jE;
            }
            long j10 = fVar.f1164b;
            if (j10 >= j9 || this.f1184a.h(8192L, fVar) == -1) {
                break;
            }
            jMax = Math.max(jMax, j10);
            b9 = b10;
            j8 = j9;
        }
        return -1L;
    }

    public final int b() throws EOFException {
        f(4L);
        int i8 = this.f1185b.readInt();
        return ((i8 & 255) << 24) | (((-16777216) & i8) >>> 24) | ((16711680 & i8) >>> 8) | ((65280 & i8) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f1186c) {
            return;
        }
        this.f1186c = true;
        this.f1184a.close();
        f fVar = this.f1185b;
        fVar.skip(fVar.f1164b);
    }

    @Override // c7.v, c7.t
    public final x d() {
        return this.f1184a.d();
    }

    @Override // c7.h
    public final void f(long j4) throws EOFException {
        if (!k(j4)) {
            throw new EOFException();
        }
    }

    @Override // c7.v
    public final long h(long j4, f sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount < 0: ").toString());
        }
        if (this.f1186c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f1185b;
        if (fVar.f1164b == 0) {
            if (j4 == 0) {
                return 0L;
            }
            if (this.f1184a.h(8192L, fVar) == -1) {
                return -1L;
            }
        }
        return fVar.h(Math.min(j4, fVar.f1164b), sink);
    }

    @Override // c7.h
    public final i i(long j4) throws EOFException {
        f(j4);
        return this.f1185b.i(j4);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f1186c;
    }

    public final boolean k(long j4) {
        f fVar;
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount < 0: ").toString());
        }
        if (this.f1186c) {
            throw new IllegalStateException("closed");
        }
        do {
            fVar = this.f1185b;
            if (fVar.f1164b >= j4) {
                return true;
            }
        } while (this.f1184a.h(8192L, fVar) != -1);
        return false;
    }

    public final boolean q() {
        if (this.f1186c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f1185b;
        return fVar.q() && this.f1184a.h(8192L, fVar) == -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        f fVar = this.f1185b;
        if (fVar.f1164b == 0 && this.f1184a.h(8192L, fVar) == -1) {
            return -1;
        }
        return fVar.read(sink);
    }

    @Override // c7.h
    public final byte readByte() throws EOFException {
        f(1L);
        return this.f1185b.readByte();
    }

    @Override // c7.h
    public final void readFully(byte[] sink) throws EOFException {
        f fVar = this.f1185b;
        kotlin.jvm.internal.p.e(sink, "sink");
        try {
            f(sink.length);
            fVar.readFully(sink);
        } catch (EOFException e9) {
            int i8 = 0;
            while (true) {
                long j4 = fVar.f1164b;
                if (j4 <= 0) {
                    throw e9;
                }
                int i9 = fVar.read(sink, i8, (int) j4);
                if (i9 == -1) {
                    throw new AssertionError();
                }
                i8 += i9;
            }
        }
    }

    @Override // c7.h
    public final int readInt() throws EOFException {
        f(4L);
        return this.f1185b.readInt();
    }

    @Override // c7.h
    public final long readLong() throws EOFException {
        f(8L);
        return this.f1185b.readLong();
    }

    @Override // c7.h
    public final short readShort() throws EOFException {
        f(2L);
        return this.f1185b.readShort();
    }

    @Override // c7.h
    public final void skip(long j4) throws EOFException {
        if (this.f1186c) {
            throw new IllegalStateException("closed");
        }
        while (j4 > 0) {
            f fVar = this.f1185b;
            if (fVar.f1164b == 0 && this.f1184a.h(8192L, fVar) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j4, fVar.f1164b);
            fVar.skip(jMin);
            j4 -= jMin;
        }
    }

    public final String toString() {
        return "buffer(" + this.f1184a + ')';
    }

    @Override // c7.h
    public final String w(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "limit < 0: ").toString());
        }
        long j8 = j4 == Util.VLI_MAX ? Long.MAX_VALUE : j4 + 1;
        long jA = a((byte) 10, 0L, j8);
        f fVar = this.f1185b;
        if (jA != -1) {
            return d7.a.b(jA, fVar);
        }
        if (j8 < Util.VLI_MAX && k(j8) && fVar.b(j8 - 1) == 13 && k(j8 + 1) && fVar.b(j8) == 10) {
            return d7.a.b(j8, fVar);
        }
        f fVar2 = new f();
        fVar.a(fVar2, 0L, Math.min(32, fVar.f1164b));
        throw new EOFException("\\n not found: limit=" + Math.min(fVar.f1164b, j4) + " content=" + fVar2.i(fVar2.f1164b).d() + (char) 8230);
    }
}
