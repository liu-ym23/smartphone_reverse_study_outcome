package hb;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class y implements Closeable {

    /* renamed from: k, reason: collision with root package name */
    public static final Logger f4378k = Logger.getLogger(f.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public final ob.i f4379f;

    /* renamed from: g, reason: collision with root package name */
    public final ob.h f4380g;

    /* renamed from: h, reason: collision with root package name */
    public int f4381h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4382i;

    /* renamed from: j, reason: collision with root package name */
    public final d f4383j;

    public y(ob.c0 c0Var) {
        q7.k.e(c0Var, "sink");
        this.f4379f = c0Var;
        ob.h hVar = new ob.h();
        this.f4380g = hVar;
        this.f4381h = 16384;
        this.f4383j = new d(hVar);
    }

    public final synchronized void a(b0 b0Var) {
        try {
            q7.k.e(b0Var, "peerSettings");
            if (this.f4382i) {
                throw new IOException("closed");
            }
            int i2 = this.f4381h;
            int i10 = b0Var.f4265a;
            if ((i10 & 32) != 0) {
                i2 = b0Var.f4266b[5];
            }
            this.f4381h = i2;
            if (((i10 & 2) != 0 ? b0Var.f4266b[1] : -1) != -1) {
                d dVar = this.f4383j;
                int i11 = (i10 & 2) != 0 ? b0Var.f4266b[1] : -1;
                dVar.getClass();
                int iMin = Math.min(i11, 16384);
                int i12 = dVar.f4278d;
                if (i12 != iMin) {
                    if (iMin < i12) {
                        dVar.f4276b = Math.min(dVar.f4276b, iMin);
                    }
                    dVar.f4277c = true;
                    dVar.f4278d = iMin;
                    int i13 = dVar.f4282h;
                    if (iMin < i13) {
                        if (iMin == 0) {
                            b[] bVarArr = dVar.f4279e;
                            d7.n.d0(bVarArr, 0, bVarArr.length);
                            dVar.f4280f = dVar.f4279e.length - 1;
                            dVar.f4281g = 0;
                            dVar.f4282h = 0;
                        } else {
                            dVar.a(i13 - iMin);
                        }
                    }
                }
            }
            d(0, 0, 4, 1);
            this.f4379f.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(boolean z4, int i2, ob.h hVar, int i10) {
        if (this.f4382i) {
            throw new IOException("closed");
        }
        d(i2, i10, 0, z4 ? 1 : 0);
        if (i10 > 0) {
            ob.i iVar = this.f4379f;
            q7.k.b(hVar);
            iVar.write(hVar, i10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f4382i = true;
        this.f4379f.close();
    }

    public final void d(int i2, int i10, int i11, int i12) {
        Level level = Level.FINE;
        Logger logger = f4378k;
        if (logger.isLoggable(level)) {
            logger.fine(f.a(false, i2, i10, i11, i12));
        }
        if (i10 > this.f4381h) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f4381h + ": " + i10).toString());
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            throw new IllegalArgumentException(n.f.c(i2, "reserved bit set: ").toString());
        }
        byte[] bArr = bb.b.f1659a;
        ob.i iVar = this.f4379f;
        q7.k.e(iVar, "<this>");
        iVar.writeByte((i10 >>> 16) & 255);
        iVar.writeByte((i10 >>> 8) & 255);
        iVar.writeByte(i10 & 255);
        iVar.writeByte(i11 & 255);
        iVar.writeByte(i12 & 255);
        iVar.writeInt(i2 & Integer.MAX_VALUE);
    }

    public final synchronized void e(byte[] bArr, int i2, int i10) {
        m.x.t(i10, "errorCode");
        if (this.f4382i) {
            throw new IOException("closed");
        }
        if (n.f.d(i10) == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        d(0, bArr.length + 8, 7, 0);
        this.f4379f.writeInt(i2);
        this.f4379f.writeInt(n.f.d(i10));
        if (bArr.length != 0) {
            this.f4379f.write(bArr);
        }
        this.f4379f.flush();
    }

    public final synchronized void flush() {
        if (this.f4382i) {
            throw new IOException("closed");
        }
        this.f4379f.flush();
    }

    public final synchronized void g(boolean z4, int i2, ArrayList arrayList) {
        if (this.f4382i) {
            throw new IOException("closed");
        }
        this.f4383j.d(arrayList);
        long j2 = this.f4380g.f7993g;
        long jMin = Math.min(this.f4381h, j2);
        int i10 = j2 == jMin ? 4 : 0;
        if (z4) {
            i10 |= 1;
        }
        d(i2, (int) jMin, 1, i10);
        this.f4379f.write(this.f4380g, jMin);
        if (j2 > jMin) {
            long j4 = j2 - jMin;
            while (j4 > 0) {
                long jMin2 = Math.min(this.f4381h, j4);
                j4 -= jMin2;
                d(i2, (int) jMin2, 9, j4 == 0 ? 4 : 0);
                this.f4379f.write(this.f4380g, jMin2);
            }
        }
    }

    public final synchronized void i(int i2, int i10, boolean z4) {
        if (this.f4382i) {
            throw new IOException("closed");
        }
        d(0, 8, 6, z4 ? 1 : 0);
        this.f4379f.writeInt(i2);
        this.f4379f.writeInt(i10);
        this.f4379f.flush();
    }

    public final synchronized void k(int i2, int i10) {
        m.x.t(i10, "errorCode");
        if (this.f4382i) {
            throw new IOException("closed");
        }
        if (n.f.d(i10) == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        d(i2, 4, 3, 0);
        this.f4379f.writeInt(n.f.d(i10));
        this.f4379f.flush();
    }

    public final synchronized void n(int i2, long j2) {
        if (this.f4382i) {
            throw new IOException("closed");
        }
        if (j2 == 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j2).toString());
        }
        d(i2, 4, 8, 0);
        this.f4379f.writeInt((int) j2);
        this.f4379f.flush();
    }
}
