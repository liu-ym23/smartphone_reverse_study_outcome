package k3;

import androidx.room.AbstractC0351g;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public final class q implements InterfaceC0680B {

    /* renamed from: a, reason: collision with root package name */
    public byte f13366a;

    /* renamed from: b, reason: collision with root package name */
    public final v f13367b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f13368c;

    /* renamed from: d, reason: collision with root package name */
    public final r f13369d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f13370e;

    public q(InterfaceC0680B source) {
        Intrinsics.checkNotNullParameter(source, "source");
        v vVar = new v(source);
        this.f13367b = vVar;
        Inflater inflater = new Inflater(true);
        this.f13368c = inflater;
        this.f13369d = new r(vVar, inflater);
        this.f13370e = new CRC32();
    }

    public static void a(int i4, int i5, String str) throws IOException {
        if (i5 == i4) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    public final void b(long j4, C0694i c0694i, long j5) {
        w wVar = c0694i.f13356a;
        Intrinsics.checkNotNull(wVar);
        while (true) {
            int i4 = wVar.f13387c;
            int i5 = wVar.f13386b;
            if (j4 < i4 - i5) {
                break;
            }
            j4 -= i4 - i5;
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
        }
        while (j5 > 0) {
            int iMin = (int) Math.min(wVar.f13387c - r5, j5);
            this.f13370e.update(wVar.f13385a, (int) (wVar.f13386b + j4), iMin);
            j5 -= iMin;
            wVar = wVar.f13390f;
            Intrinsics.checkNotNull(wVar);
            j4 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f13369d.close();
    }

    @Override // k3.InterfaceC0680B
    public final long read(C0694i sink, long j4) throws DataFormatException, IOException {
        v vVar;
        C0694i c0694i;
        long j5;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("byteCount < 0: ", j4).toString());
        }
        if (j4 == 0) {
            return 0L;
        }
        byte b4 = this.f13366a;
        CRC32 crc32 = this.f13370e;
        v vVar2 = this.f13367b;
        if (b4 == 0) {
            vVar2.E(10L);
            C0694i c0694i2 = vVar2.f13383b;
            byte bL = c0694i2.l(3L);
            boolean z4 = ((bL >> 1) & 1) == 1;
            if (z4) {
                b(0L, vVar2.f13383b, 10L);
            }
            a(8075, vVar2.readShort(), "ID1ID2");
            vVar2.j(8L);
            if (((bL >> 2) & 1) == 1) {
                vVar2.E(2L);
                if (z4) {
                    b(0L, vVar2.f13383b, 2L);
                }
                short s4 = c0694i2.readShort();
                long j6 = (short) (((s4 & 255) << 8) | ((s4 & 65280) >>> 8));
                vVar2.E(j6);
                if (z4) {
                    b(0L, vVar2.f13383b, j6);
                    j5 = j6;
                } else {
                    j5 = j6;
                }
                vVar2.j(j5);
            }
            if (((bL >> 3) & 1) == 1) {
                c0694i = c0694i2;
                long jA = vVar2.a((byte) 0, 0L, LongCompanionObject.MAX_VALUE);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    vVar = vVar2;
                    b(0L, vVar2.f13383b, jA + 1);
                } else {
                    vVar = vVar2;
                }
                vVar.j(jA + 1);
            } else {
                c0694i = c0694i2;
                vVar = vVar2;
            }
            if (((bL >> 4) & 1) == 1) {
                long jA2 = vVar.a((byte) 0, 0L, LongCompanionObject.MAX_VALUE);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    b(0L, vVar.f13383b, jA2 + 1);
                }
                vVar.j(jA2 + 1);
            }
            if (z4) {
                vVar.E(2L);
                short s5 = c0694i.readShort();
                a((short) (((s5 & 255) << 8) | ((s5 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            this.f13366a = (byte) 1;
        } else {
            vVar = vVar2;
        }
        if (this.f13366a == 1) {
            long j7 = sink.f13357b;
            long j8 = this.f13369d.read(sink, j4);
            if (j8 != -1) {
                b(j7, sink, j8);
                return j8;
            }
            this.f13366a = (byte) 2;
        }
        if (this.f13366a != 2) {
            return -1L;
        }
        a(vVar.d(), (int) crc32.getValue(), "CRC");
        a(vVar.d(), (int) this.f13368c.getBytesWritten(), "ISIZE");
        this.f13366a = (byte) 3;
        if (vVar.s()) {
            return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
    }

    @Override // k3.InterfaceC0680B
    public final C0683E timeout() {
        return this.f13367b.f13382a.timeout();
    }
}
