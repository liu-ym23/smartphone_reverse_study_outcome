package ob;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class s implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public byte f8025f;

    /* renamed from: g, reason: collision with root package name */
    public final e0 f8026g;

    /* renamed from: h, reason: collision with root package name */
    public final Inflater f8027h;

    /* renamed from: i, reason: collision with root package name */
    public final t f8028i;

    /* renamed from: j, reason: collision with root package name */
    public final CRC32 f8029j;

    public s(k0 k0Var) {
        q7.k.e(k0Var, "source");
        e0 e0Var = new e0(k0Var);
        this.f8026g = e0Var;
        Inflater inflater = new Inflater(true);
        this.f8027h = inflater;
        this.f8028i = new t(e0Var, inflater);
        this.f8029j = new CRC32();
    }

    public static void a(String str, int i2, int i10) throws IOException {
        if (i10 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10), Integer.valueOf(i2)}, 3)));
        }
    }

    public final void b(h hVar, long j2, long j4) {
        f0 f0Var = hVar.f7992f;
        q7.k.b(f0Var);
        while (true) {
            int i2 = f0Var.f7977c;
            int i10 = f0Var.f7976b;
            if (j2 < i2 - i10) {
                break;
            }
            j2 -= i2 - i10;
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
        }
        while (j4 > 0) {
            int iMin = (int) Math.min(f0Var.f7977c - r6, j4);
            this.f8029j.update(f0Var.f7975a, (int) (f0Var.f7976b + j2), iMin);
            j4 -= iMin;
            f0Var = f0Var.f7980f;
            q7.k.b(f0Var);
            j2 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8028i.close();
    }

    @Override // ob.k0
    public final long read(h hVar, long j2) throws DataFormatException, IOException {
        s sVar = this;
        q7.k.e(hVar, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(a1.a.h("byteCount < 0: ", j2).toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        byte b10 = sVar.f8025f;
        CRC32 crc32 = sVar.f8029j;
        e0 e0Var = sVar.f8026g;
        if (b10 == 0) {
            e0Var.L(10L);
            h hVar2 = e0Var.f7965g;
            byte bG = hVar2.g(3L);
            boolean z4 = ((bG >> 1) & 1) == 1;
            if (z4) {
                sVar.b(hVar2, 0L, 10L);
            }
            a("ID1ID2", 8075, e0Var.readShort());
            e0Var.skip(8L);
            if (((bG >> 2) & 1) == 1) {
                e0Var.L(2L);
                if (z4) {
                    b(hVar2, 0L, 2L);
                }
                long jS = hVar2.s() & 65535;
                e0Var.L(jS);
                if (z4) {
                    b(hVar2, 0L, jS);
                }
                e0Var.skip(jS);
            }
            if (((bG >> 3) & 1) == 1) {
                long jB = e0Var.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    b(hVar2, 0L, jB + 1);
                }
                e0Var.skip(jB + 1);
            }
            if (((bG >> 4) & 1) == 1) {
                long jB2 = e0Var.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB2 == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    sVar = this;
                    sVar.b(hVar2, 0L, jB2 + 1);
                } else {
                    sVar = this;
                }
                e0Var.skip(jB2 + 1);
            } else {
                sVar = this;
            }
            if (z4) {
                a("FHCRC", e0Var.g(), (short) crc32.getValue());
                crc32.reset();
            }
            sVar.f8025f = (byte) 1;
        }
        if (sVar.f8025f == 1) {
            long j4 = hVar.f7993g;
            long j10 = sVar.f8028i.read(hVar, j2);
            if (j10 != -1) {
                sVar.b(hVar, j4, j10);
                return j10;
            }
            sVar.f8025f = (byte) 2;
        }
        if (sVar.f8025f == 2) {
            a("CRC", e0Var.d(), (int) crc32.getValue());
            a("ISIZE", e0Var.d(), (int) sVar.f8027h.getBytesWritten());
            sVar.f8025f = (byte) 3;
            if (!e0Var.a()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f8026g.f7964f.timeout();
    }
}
