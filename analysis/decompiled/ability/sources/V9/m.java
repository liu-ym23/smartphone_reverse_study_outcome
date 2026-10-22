package V9;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public final class m implements w {

    /* renamed from: a, reason: collision with root package name */
    public byte f1420a;
    public final r b;
    public final Inflater c;
    public final n d;
    public final CRC32 e;

    public m(w source) {
        kotlin.jvm.internal.k.f(source, "source");
        r rVar = new r(source);
        this.b = rVar;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new n(rVar, inflater);
        this.e = new CRC32();
    }

    public static void b(int i, int i6, String str) throws IOException {
        if (i6 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i)}, 3)));
        }
    }

    public final void c(g gVar, long j5, long j6) {
        s sVar = gVar.f1418a;
        kotlin.jvm.internal.k.c(sVar);
        while (true) {
            int i = sVar.c;
            int i6 = sVar.b;
            if (j5 < i - i6) {
                break;
            }
            j5 -= i - i6;
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
        }
        while (j6 > 0) {
            int iMin = (int) Math.min(sVar.c - r6, j6);
            this.e.update(sVar.f1426a, (int) (sVar.b + j5), iMin);
            j6 -= iMin;
            sVar = sVar.f;
            kotlin.jvm.internal.k.c(sVar);
            j5 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.d.close();
    }

    @Override // V9.w
    public final long e(g sink, long j5) throws DataFormatException, IOException {
        long j6;
        m mVar = this;
        kotlin.jvm.internal.k.f(sink, "sink");
        byte b = mVar.f1420a;
        CRC32 crc32 = mVar.e;
        r rVar = mVar.b;
        if (b == 0) {
            rVar.t(10L);
            g gVar = rVar.b;
            byte bR = gVar.r(3L);
            boolean z10 = ((bR >> 1) & 1) == 1;
            if (z10) {
                mVar.c(gVar, 0L, 10L);
            }
            b(8075, rVar.readShort(), "ID1ID2");
            rVar.skip(8L);
            if (((bR >> 2) & 1) == 1) {
                rVar.t(2L);
                if (z10) {
                    c(gVar, 0L, 2L);
                }
                short s5 = gVar.readShort();
                long j10 = ((short) (((s5 & 255) << 8) | ((s5 & 65280) >>> 8))) & 65535;
                rVar.t(j10);
                if (z10) {
                    c(gVar, 0L, j10);
                }
                rVar.skip(j10);
            }
            if (((bR >> 3) & 1) == 1) {
                long jC = rVar.c((byte) 0, 0L, Long.MAX_VALUE);
                if (jC == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    j6 = 2;
                    c(gVar, 0L, jC + 1);
                } else {
                    j6 = 2;
                }
                rVar.skip(jC + 1);
            } else {
                j6 = 2;
            }
            if (((bR >> 4) & 1) == 1) {
                long j11 = j6;
                long jC2 = rVar.c((byte) 0, 0L, Long.MAX_VALUE);
                if (jC2 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    j6 = j11;
                    mVar = this;
                    mVar.c(gVar, 0L, jC2 + 1);
                } else {
                    mVar = this;
                    j6 = j11;
                }
                rVar.skip(jC2 + 1);
            } else {
                mVar = this;
            }
            if (z10) {
                rVar.t(j6);
                short s10 = gVar.readShort();
                b((short) (((s10 & 255) << 8) | ((s10 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            mVar.f1420a = (byte) 1;
        }
        if (mVar.f1420a == 1) {
            long j12 = sink.b;
            long jE = mVar.d.e(sink, 8192L);
            if (jE != -1) {
                mVar.c(sink, j12, jE);
                return jE;
            }
            mVar.f1420a = (byte) 2;
        }
        if (mVar.f1420a == 2) {
            b(rVar.f(), (int) crc32.getValue(), "CRC");
            b(rVar.f(), (int) mVar.c.getBytesWritten(), "ISIZE");
            mVar.f1420a = (byte) 3;
            if (!rVar.b()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // V9.w
    public final y timeout() {
        return this.b.f1425a.timeout();
    }
}
