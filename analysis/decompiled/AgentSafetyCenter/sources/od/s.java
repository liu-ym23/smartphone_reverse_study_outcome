package od;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public byte f9482c;

    /* renamed from: f, reason: collision with root package name */
    public final c0 f9483f;

    /* renamed from: g, reason: collision with root package name */
    public final Inflater f9484g;

    /* renamed from: h, reason: collision with root package name */
    public final t f9485h;
    public final CRC32 i;

    public s(i0 i0Var) {
        i0Var.getClass();
        c0 c0Var = new c0(i0Var);
        this.f9483f = c0Var;
        Inflater inflater = new Inflater(true);
        this.f9484g = inflater;
        this.f9485h = new t(c0Var, inflater);
        this.i = new CRC32();
    }

    public static void d(int i, int i3, String str) throws IOException {
        if (i3 == i) {
            return;
        }
        StringBuilder sbV = k0.a.v(str, ": actual 0x");
        sbV.append(hc.h.j0(8, a.a.X(i3)));
        sbV.append(" != expected 0x");
        sbV.append(hc.h.j0(8, a.a.X(i)));
        throw new IOException(sbV.toString());
    }

    @Override // od.i0
    public final k0 b() {
        return this.f9483f.f9427c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9485h.close();
    }

    public final void e(i iVar, long j10, long j11) {
        d0 d0Var = iVar.f9453c;
        d0Var.getClass();
        while (true) {
            int i = d0Var.f9439c;
            int i3 = d0Var.f9438b;
            if (j10 < i - i3) {
                break;
            }
            j10 -= i - i3;
            d0Var = d0Var.f9442f;
            d0Var.getClass();
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(d0Var.f9439c - r6, j11);
            this.i.update(d0Var.f9437a, (int) (d0Var.f9438b + j10), iMin);
            j11 -= iMin;
            d0Var = d0Var.f9442f;
            d0Var.getClass();
            j10 = 0;
        }
    }

    @Override // od.i0
    public final long l(i iVar, long j10) throws DataFormatException, IOException {
        s sVar = this;
        iVar.getClass();
        if (j10 < 0) {
            f.c(k0.a.m("byteCount < 0: ", j10));
            return 0L;
        }
        if (j10 == 0) {
            return 0L;
        }
        byte b10 = sVar.f9482c;
        CRC32 crc32 = sVar.i;
        c0 c0Var = sVar.f9483f;
        if (b10 == 0) {
            c0Var.H(10L);
            i iVar2 = c0Var.f9428f;
            byte bC = iVar2.C(3L);
            boolean z10 = ((bC >> 1) & 1) == 1;
            if (z10) {
                sVar.e(iVar2, 0L, 10L);
            }
            d(8075, c0Var.A(), "ID1ID2");
            c0Var.M(8L);
            if (((bC >> 2) & 1) == 1) {
                c0Var.H(2L);
                if (z10) {
                    e(iVar2, 0L, 2L);
                }
                long jS = iVar2.S() & 65535;
                c0Var.H(jS);
                if (z10) {
                    e(iVar2, 0L, jS);
                }
                c0Var.M(jS);
            }
            if (((bC >> 3) & 1) == 1) {
                long jE = c0Var.e((byte) 0, 0L, Long.MAX_VALUE);
                if (jE == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    e(iVar2, 0L, jE + 1);
                }
                c0Var.M(jE + 1);
            }
            if (((bC >> 4) & 1) == 1) {
                long jE2 = c0Var.e((byte) 0, 0L, Long.MAX_VALUE);
                if (jE2 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    sVar = this;
                    sVar.e(iVar2, 0L, jE2 + 1);
                } else {
                    sVar = this;
                }
                c0Var.M(jE2 + 1);
            } else {
                sVar = this;
            }
            if (z10) {
                d(c0Var.C(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            sVar.f9482c = (byte) 1;
        }
        if (sVar.f9482c == 1) {
            long j11 = iVar.f9454f;
            long jL = sVar.f9485h.l(iVar, j10);
            if (jL != -1) {
                sVar.e(iVar, j11, jL);
                return jL;
            }
            sVar.f9482c = (byte) 2;
        }
        if (sVar.f9482c == 2) {
            d(c0Var.o(), (int) crc32.getValue(), "CRC");
            d(c0Var.o(), (int) sVar.f9484g.getBytesWritten(), "ISIZE");
            sVar.f9482c = (byte) 3;
            if (!c0Var.d()) {
                f.l("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }
}
