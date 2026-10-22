package c7;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.bouncycastle.crypto.hpke.HPKE;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements v {

    /* renamed from: a, reason: collision with root package name */
    public byte f1172a;

    /* renamed from: b, reason: collision with root package name */
    public final p f1173b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f1174c;
    public final m d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f1175e;

    public l(h source) {
        kotlin.jvm.internal.p.e(source, "source");
        p pVar = new p(source);
        this.f1173b = pVar;
        Inflater inflater = new Inflater(true);
        this.f1174c = inflater;
        this.d = new m(pVar, inflater);
        this.f1175e = new CRC32();
    }

    public static void a(int i8, int i9, String str) throws IOException {
        if (i9 == i8) {
            return;
        }
        throw new IOException(str + ": actual 0x" + x5.n.z1(8, b.e(i9)) + " != expected 0x" + x5.n.z1(8, b.e(i8)));
    }

    public final void b(f fVar, long j4, long j8) {
        q qVar = fVar.f1163a;
        kotlin.jvm.internal.p.b(qVar);
        while (true) {
            int i8 = qVar.f1189c;
            int i9 = qVar.f1188b;
            if (j4 < i8 - i9) {
                break;
            }
            j4 -= i8 - i9;
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
        }
        while (j8 > 0) {
            int iMin = (int) Math.min(qVar.f1189c - r6, j8);
            this.f1175e.update(qVar.f1187a, (int) (qVar.f1188b + j4), iMin);
            j8 -= iMin;
            qVar = qVar.f1191f;
            kotlin.jvm.internal.p.b(qVar);
            j4 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.d.close();
    }

    @Override // c7.v, c7.t
    public final x d() {
        return this.f1173b.f1184a.d();
    }

    @Override // c7.v
    public final long h(long j4, f fVar) throws DataFormatException, IOException {
        long j8;
        l lVar = this;
        byte b9 = lVar.f1172a;
        CRC32 crc32 = lVar.f1175e;
        p pVar = lVar.f1173b;
        if (b9 == 0) {
            pVar.f(10L);
            f fVar2 = pVar.f1185b;
            byte b10 = fVar2.b(3L);
            boolean z = ((b10 >> 1) & 1) == 1;
            if (z) {
                lVar.b(fVar2, 0L, 10L);
            }
            a(8075, pVar.readShort(), "ID1ID2");
            pVar.skip(8L);
            if (((b10 >> 2) & 1) == 1) {
                pVar.f(2L);
                if (z) {
                    b(fVar2, 0L, 2L);
                }
                short s8 = fVar2.readShort();
                long j9 = ((short) (((s8 & 255) << 8) | ((s8 & 65280) >>> 8))) & HPKE.aead_EXPORT_ONLY;
                pVar.f(j9);
                if (z) {
                    b(fVar2, 0L, j9);
                }
                pVar.skip(j9);
            }
            if (((b10 >> 3) & 1) == 1) {
                long jA = pVar.a((byte) 0, 0L, Util.VLI_MAX);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j8 = 2;
                    b(fVar2, 0L, jA + 1);
                } else {
                    j8 = 2;
                }
                pVar.skip(jA + 1);
            } else {
                j8 = 2;
            }
            if (((b10 >> 4) & 1) == 1) {
                long j10 = j8;
                long jA2 = pVar.a((byte) 0, 0L, Util.VLI_MAX);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j8 = j10;
                    lVar = this;
                    lVar.b(fVar2, 0L, jA2 + 1);
                } else {
                    lVar = this;
                    j8 = j10;
                }
                pVar.skip(jA2 + 1);
            } else {
                lVar = this;
            }
            if (z) {
                pVar.f(j8);
                short s9 = fVar2.readShort();
                a((short) (((s9 & 255) << 8) | ((s9 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            lVar.f1172a = (byte) 1;
        }
        if (lVar.f1172a == 1) {
            long j11 = fVar.f1164b;
            long jH = lVar.d.h(8192L, fVar);
            if (jH != -1) {
                lVar.b(fVar, j11, jH);
                return jH;
            }
            lVar.f1172a = (byte) 2;
        }
        if (lVar.f1172a == 2) {
            a(pVar.b(), (int) crc32.getValue(), "CRC");
            a(pVar.b(), (int) lVar.f1174c.getBytesWritten(), "ISIZE");
            lVar.f1172a = (byte) 3;
            if (!pVar.q()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
