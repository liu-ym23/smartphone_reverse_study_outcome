package L4;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class l implements y {

    /* renamed from: a, reason: collision with root package name */
    private byte f3950a;

    /* renamed from: b, reason: collision with root package name */
    private final s f3951b;

    /* renamed from: c, reason: collision with root package name */
    private final Inflater f3952c;

    /* renamed from: d, reason: collision with root package name */
    private final m f3953d;

    /* renamed from: e, reason: collision with root package name */
    private final CRC32 f3954e;

    public l(y yVar) {
        j4.k.h(yVar, "source");
        s sVar = new s(yVar);
        this.f3951b = sVar;
        Inflater inflater = new Inflater(true);
        this.f3952c = inflater;
        this.f3953d = new m(sVar, inflater);
        this.f3954e = new CRC32();
    }

    private final void a(String str, int i5, int i6) throws IOException {
        if (i6 == i5) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i5)}, 3));
        j4.k.c(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    private final void c() throws IOException {
        this.f3951b.q0(10L);
        byte bA = this.f3951b.f3969a.A(3L);
        boolean z5 = ((bA >> 1) & 1) == 1;
        if (z5) {
            m(this.f3951b.f3969a, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f3951b.readShort());
        this.f3951b.skip(8L);
        if (((bA >> 2) & 1) == 1) {
            this.f3951b.q0(2L);
            if (z5) {
                m(this.f3951b.f3969a, 0L, 2L);
            }
            long jL = this.f3951b.f3969a.L();
            this.f3951b.q0(jL);
            if (z5) {
                m(this.f3951b.f3969a, 0L, jL);
            }
            this.f3951b.skip(jL);
        }
        if (((bA >> 3) & 1) == 1) {
            long jA = this.f3951b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z5) {
                m(this.f3951b.f3969a, 0L, jA + 1);
            }
            this.f3951b.skip(jA + 1);
        }
        if (((bA >> 4) & 1) == 1) {
            long jA2 = this.f3951b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z5) {
                m(this.f3951b.f3969a, 0L, jA2 + 1);
            }
            this.f3951b.skip(jA2 + 1);
        }
        if (z5) {
            a("FHCRC", this.f3951b.m(), (short) this.f3954e.getValue());
            this.f3954e.reset();
        }
    }

    private final void f() throws IOException {
        a("CRC", this.f3951b.f(), (int) this.f3954e.getValue());
        a("ISIZE", this.f3951b.f(), (int) this.f3952c.getBytesWritten());
    }

    private final void m(e eVar, long j5, long j6) {
        t tVar = eVar.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        while (true) {
            int i5 = tVar.f3976c;
            int i6 = tVar.f3975b;
            if (j5 < i5 - i6) {
                break;
            }
            j5 -= i5 - i6;
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
        }
        while (j6 > 0) {
            int iMin = (int) Math.min(tVar.f3976c - r6, j6);
            this.f3954e.update(tVar.f3974a, (int) (tVar.f3975b + j5), iMin);
            j6 -= iMin;
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
            j5 = 0;
        }
    }

    @Override // L4.y
    public z b() {
        return this.f3951b.b();
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3953d.close();
    }

    @Override // L4.y
    public long e(e eVar, long j5) throws DataFormatException, IOException {
        l lVar;
        j4.k.h(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        if (j5 == 0) {
            return 0L;
        }
        if (this.f3950a == 0) {
            c();
            this.f3950a = (byte) 1;
        }
        if (this.f3950a == 1) {
            long size = eVar.size();
            long jE = this.f3953d.e(eVar, j5);
            if (jE != -1) {
                m(eVar, size, jE);
                return jE;
            }
            lVar = this;
            lVar.f3950a = (byte) 2;
        } else {
            lVar = this;
        }
        if (lVar.f3950a == 2) {
            lVar.f();
            lVar.f3950a = (byte) 3;
            if (!lVar.f3951b.t()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
