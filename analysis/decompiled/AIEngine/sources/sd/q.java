package sd;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public byte f11968a;

    /* renamed from: b, reason: collision with root package name */
    public final z f11969b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f11970c;

    /* renamed from: d, reason: collision with root package name */
    public final r f11971d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f11972e;

    public q(e0 source) {
        kotlin.jvm.internal.g.f(source, "source");
        z zVar = new z(source);
        this.f11969b = zVar;
        Inflater inflater = new Inflater(true);
        this.f11970c = inflater;
        this.f11971d = new r(zVar, inflater);
        this.f11972e = new CRC32();
    }

    public static void a(int i10, int i11, String str) throws IOException {
        if (i11 == i10) {
            return;
        }
        StringBuilder sbP = a0.a.p(str, ": actual 0x");
        sbP.append(gc.q.x0(8, a.e(i11)));
        sbP.append(" != expected 0x");
        sbP.append(gc.q.x0(8, a.e(i10)));
        throw new IOException(sbP.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11971d.close();
    }

    public final void o(e eVar, long j10, long j11) {
        a0 a0Var = eVar.f11925a;
        kotlin.jvm.internal.g.c(a0Var);
        while (true) {
            int i10 = a0Var.f11903c;
            int i11 = a0Var.f11902b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(a0Var.f11903c - r6, j11);
            this.f11972e.update(a0Var.f11901a, (int) (a0Var.f11902b + j10), iMin);
            j11 -= iMin;
            a0Var = a0Var.f11906f;
            kotlin.jvm.internal.g.c(a0Var);
            j10 = 0;
        }
    }

    @Override // sd.e0
    public final long read(e sink, long j10) throws DataFormatException, IOException {
        q qVar = this;
        kotlin.jvm.internal.g.f(sink, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(j10, "byteCount < 0: ").toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        byte b10 = qVar.f11968a;
        CRC32 crc32 = qVar.f11972e;
        z zVar = qVar.f11969b;
        if (b10 == 0) {
            zVar.T(10L);
            e eVar = zVar.f11987b;
            byte bS = eVar.S(3L);
            boolean z = ((bS >> 1) & 1) == 1;
            if (z) {
                qVar.o(zVar.f11987b, 0L, 10L);
            }
            a(8075, zVar.readShort(), "ID1ID2");
            zVar.skip(8L);
            if (((bS >> 2) & 1) == 1) {
                zVar.T(2L);
                if (z) {
                    o(zVar.f11987b, 0L, 2L);
                }
                long jH0 = eVar.H0() & 65535;
                zVar.T(jH0);
                if (z) {
                    o(zVar.f11987b, 0L, jH0);
                }
                zVar.skip(jH0);
            }
            if (((bS >> 3) & 1) == 1) {
                long jA = zVar.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z) {
                    o(zVar.f11987b, 0L, jA + 1);
                }
                zVar.skip(jA + 1);
            }
            if (((bS >> 4) & 1) == 1) {
                long jA2 = zVar.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    qVar = this;
                    qVar.o(zVar.f11987b, 0L, jA2 + 1);
                } else {
                    qVar = this;
                }
                zVar.skip(jA2 + 1);
            } else {
                qVar = this;
            }
            if (z) {
                a(zVar.C(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            qVar.f11968a = (byte) 1;
        }
        if (qVar.f11968a == 1) {
            long j11 = sink.f11926b;
            long j12 = qVar.f11971d.read(sink, j10);
            if (j12 != -1) {
                qVar.o(sink, j11, j12);
                return j12;
            }
            qVar.f11968a = (byte) 2;
        }
        if (qVar.f11968a == 2) {
            a(zVar.o(), (int) crc32.getValue(), "CRC");
            a(zVar.o(), (int) qVar.f11970c.getBytesWritten(), "ISIZE");
            qVar.f11968a = (byte) 3;
            if (!zVar.f0()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // sd.e0
    public final f0 timeout() {
        return this.f11969b.f11986a.timeout();
    }
}
