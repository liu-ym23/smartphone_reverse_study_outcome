package I4;

import I4.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class j implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final Logger f3135g = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final L4.f f3136a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3137b;

    /* renamed from: c, reason: collision with root package name */
    private final L4.e f3138c;

    /* renamed from: d, reason: collision with root package name */
    private int f3139d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3140e;

    /* renamed from: f, reason: collision with root package name */
    final d.b f3141f;

    j(L4.f fVar, boolean z5) {
        this.f3136a = fVar;
        this.f3137b = z5;
        L4.e eVar = new L4.e();
        this.f3138c = eVar;
        this.f3141f = new d.b(eVar);
        this.f3139d = 16384;
    }

    private void E(int i5, long j5) {
        while (j5 > 0) {
            int iMin = (int) Math.min(this.f3139d, j5);
            long j6 = iMin;
            j5 -= j6;
            o(i5, iMin, (byte) 9, j5 == 0 ? (byte) 4 : (byte) 0);
            this.f3136a.y0(this.f3138c, j6);
        }
    }

    private static void G(L4.f fVar, int i5) {
        fVar.writeByte((i5 >>> 16) & 255);
        fVar.writeByte((i5 >>> 8) & 255);
        fVar.writeByte(i5 & 255);
    }

    public synchronized void A(int i5, b bVar) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        if (bVar.f2987a == -1) {
            throw new IllegalArgumentException();
        }
        o(i5, 4, (byte) 3, (byte) 0);
        this.f3136a.writeInt(bVar.f2987a);
        this.f3136a.flush();
    }

    public synchronized void C(m mVar) {
        try {
            if (this.f3140e) {
                throw new IOException("closed");
            }
            int i5 = 0;
            o(0, mVar.j() * 6, (byte) 4, (byte) 0);
            while (i5 < 10) {
                if (mVar.g(i5)) {
                    this.f3136a.writeShort(i5 == 4 ? 3 : i5 == 7 ? 4 : i5);
                    this.f3136a.writeInt(mVar.b(i5));
                }
                i5++;
            }
            this.f3136a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void D(int i5, long j5) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        if (j5 == 0 || j5 > 2147483647L) {
            throw e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j5));
        }
        o(i5, 4, (byte) 8, (byte) 0);
        this.f3136a.writeInt((int) j5);
        this.f3136a.flush();
    }

    public synchronized void a(m mVar) {
        try {
            if (this.f3140e) {
                throw new IOException("closed");
            }
            this.f3139d = mVar.f(this.f3139d);
            if (mVar.c() != -1) {
                this.f3141f.e(mVar.c());
            }
            o(0, 0, (byte) 4, (byte) 1);
            this.f3136a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() {
        try {
            if (this.f3140e) {
                throw new IOException("closed");
            }
            if (this.f3137b) {
                Logger logger = f3135g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(D4.e.q(">> CONNECTION %s", e.f3017a.n()));
                }
                this.f3136a.write(e.f3017a.z());
                this.f3136a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f3140e = true;
        this.f3136a.close();
    }

    public synchronized void f(boolean z5, int i5, L4.e eVar, int i6) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        m(i5, z5 ? (byte) 1 : (byte) 0, eVar, i6);
    }

    public synchronized void flush() {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        this.f3136a.flush();
    }

    void m(int i5, byte b6, L4.e eVar, int i6) {
        o(i5, i6, (byte) 0, b6);
        if (i6 > 0) {
            this.f3136a.y0(eVar, i6);
        }
    }

    public void o(int i5, int i6, byte b6, byte b7) {
        Logger logger = f3135g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.b(false, i5, i6, b6, b7));
        }
        int i7 = this.f3139d;
        if (i6 > i7) {
            throw e.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
        }
        if ((Integer.MIN_VALUE & i5) != 0) {
            throw e.c("reserved bit set: %s", Integer.valueOf(i5));
        }
        G(this.f3136a, i6);
        this.f3136a.writeByte(b6 & 255);
        this.f3136a.writeByte(b7 & 255);
        this.f3136a.writeInt(i5 & Integer.MAX_VALUE);
    }

    public synchronized void r(int i5, b bVar, byte[] bArr) {
        try {
            if (this.f3140e) {
                throw new IOException("closed");
            }
            if (bVar.f2987a == -1) {
                throw e.c("errorCode.httpCode == -1", new Object[0]);
            }
            o(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f3136a.writeInt(i5);
            this.f3136a.writeInt(bVar.f2987a);
            if (bArr.length > 0) {
                this.f3136a.write(bArr);
            }
            this.f3136a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u(boolean z5, int i5, List<c> list) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        this.f3141f.g(list);
        long size = this.f3138c.size();
        int iMin = (int) Math.min(this.f3139d, size);
        long j5 = iMin;
        byte b6 = size == j5 ? (byte) 4 : (byte) 0;
        if (z5) {
            b6 = (byte) (b6 | 1);
        }
        o(i5, iMin, (byte) 1, b6);
        this.f3136a.y0(this.f3138c, j5);
        if (size > j5) {
            E(i5, size - j5);
        }
    }

    public int v() {
        return this.f3139d;
    }

    public synchronized void w(boolean z5, int i5, int i6) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        o(0, 8, (byte) 6, z5 ? (byte) 1 : (byte) 0);
        this.f3136a.writeInt(i5);
        this.f3136a.writeInt(i6);
        this.f3136a.flush();
    }

    public synchronized void x(int i5, int i6, List<c> list) {
        if (this.f3140e) {
            throw new IOException("closed");
        }
        this.f3141f.g(list);
        long size = this.f3138c.size();
        int iMin = (int) Math.min(this.f3139d - 4, size);
        long j5 = iMin;
        o(i5, iMin + 4, (byte) 5, size == j5 ? (byte) 4 : (byte) 0);
        this.f3136a.writeInt(i6 & Integer.MAX_VALUE);
        this.f3136a.y0(this.f3138c, j5);
        if (size > j5) {
            E(i5, size - j5);
        }
    }
}
