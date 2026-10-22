package hd;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import od.b0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    public static final Logger f5579j = Logger.getLogger(f.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public b0 f5580c;

    /* renamed from: f, reason: collision with root package name */
    public od.i f5581f;

    /* renamed from: g, reason: collision with root package name */
    public int f5582g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5583h;
    public d i;

    public final synchronized void A(int i, long j10) {
        if (this.f5583h) {
            throw new IOException("closed");
        }
        if (j10 == 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
        }
        g(i, 4, 8, 0);
        this.f5580c.e((int) j10);
        this.f5580c.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f5583h = true;
        this.f5580c.close();
    }

    public final synchronized void d(z zVar) {
        try {
            zVar.getClass();
            if (this.f5583h) {
                throw new IOException("closed");
            }
            int i = this.f5582g;
            int i3 = zVar.f5588a;
            if ((i3 & 32) != 0) {
                i = zVar.f5589b[5];
            }
            this.f5582g = i;
            if (((i3 & 2) != 0 ? zVar.f5589b[1] : -1) != -1) {
                d dVar = this.i;
                int i10 = (i3 & 2) != 0 ? zVar.f5589b[1] : -1;
                dVar.getClass();
                int iMin = Math.min(i10, 16384);
                int i11 = dVar.f5486d;
                if (i11 != iMin) {
                    if (iMin < i11) {
                        dVar.f5484b = Math.min(dVar.f5484b, iMin);
                    }
                    dVar.f5485c = true;
                    dVar.f5486d = iMin;
                    int i12 = dVar.f5490h;
                    if (iMin < i12) {
                        if (iMin == 0) {
                            b[] bVarArr = dVar.f5487e;
                            kb.k.m0(null, 0, bVarArr, bVarArr.length);
                            dVar.f5488f = dVar.f5487e.length - 1;
                            dVar.f5489g = 0;
                            dVar.f5490h = 0;
                        } else {
                            dVar.a(i12 - iMin);
                        }
                    }
                }
            }
            g(0, 0, 4, 1);
            this.f5580c.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e(boolean z10, int i, od.i iVar, int i3) {
        if (this.f5583h) {
            throw new IOException("closed");
        }
        g(i, i3, 0, z10 ? 1 : 0);
        if (i3 > 0) {
            b0 b0Var = this.f5580c;
            iVar.getClass();
            b0Var.f(iVar, i3);
        }
    }

    public final synchronized void flush() {
        if (this.f5583h) {
            throw new IOException("closed");
        }
        this.f5580c.flush();
    }

    public final void g(int i, int i3, int i10, int i11) {
        b0 b0Var = this.f5580c;
        Level level = Level.FINE;
        Logger logger = f5579j;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(false, i, i3, i10, i11));
        }
        if (i3 > this.f5582g) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f5582g + ": " + i3).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            od.f.c(k0.a.j(i, "reserved bit set: "));
            return;
        }
        byte[] bArr = bd.b.f2074a;
        b0Var.getClass();
        b0Var.writeByte((i3 >>> 16) & 255);
        b0Var.writeByte((i3 >>> 8) & 255);
        b0Var.writeByte(i3 & 255);
        b0Var.writeByte(i10 & 255);
        b0Var.writeByte(i11 & 255);
        b0Var.e(Integer.MAX_VALUE & i);
    }

    public final synchronized void i(int i, int i3, byte[] bArr) {
        if (i3 == 0) {
            throw null;
        }
        if (this.f5583h) {
            throw new IOException("closed");
        }
        if (s.f.c(i3) == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        g(0, bArr.length + 8, 7, 0);
        this.f5580c.e(i);
        this.f5580c.e(s.f.c(i3));
        if (bArr.length != 0) {
            this.f5580c.write(bArr);
        }
        this.f5580c.flush();
    }

    public final synchronized void n(boolean z10, int i, ArrayList arrayList) {
        if (this.f5583h) {
            throw new IOException("closed");
        }
        this.i.d(arrayList);
        long j10 = this.f5581f.f9454f;
        long jMin = Math.min(this.f5582g, j10);
        int i3 = j10 == jMin ? 4 : 0;
        if (z10) {
            i3 |= 1;
        }
        g(i, (int) jMin, 1, i3);
        this.f5580c.f(this.f5581f, jMin);
        if (j10 > jMin) {
            long j11 = j10 - jMin;
            while (j11 > 0) {
                long jMin2 = Math.min(this.f5582g, j11);
                j11 -= jMin2;
                g(i, (int) jMin2, 9, j11 == 0 ? 4 : 0);
                this.f5580c.f(this.f5581f, jMin2);
            }
        }
    }

    public final synchronized void o(int i, int i3, boolean z10) {
        if (this.f5583h) {
            throw new IOException("closed");
        }
        g(0, 8, 6, z10 ? 1 : 0);
        this.f5580c.e(i);
        this.f5580c.e(i3);
        this.f5580c.flush();
    }

    public final synchronized void r(int i, int i3) {
        if (i3 == 0) {
            throw null;
        }
        if (this.f5583h) {
            throw new IOException("closed");
        }
        if (s.f.c(i3) == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        g(i, 4, 3, 0);
        this.f5580c.e(s.f.c(i3));
        this.f5580c.flush();
    }
}
