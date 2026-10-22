package M9;

import androidx.collection.SieveCacheKt;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class x implements Closeable {
    public static final Logger f = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final V9.h f1000a;
    public final V9.g b;
    public int c;
    public boolean d;
    public final c e;

    public x(V9.q sink) {
        kotlin.jvm.internal.k.f(sink, "sink");
        this.f1000a = sink;
        V9.g gVar = new V9.g();
        this.b = gVar;
        this.c = 16384;
        this.e = new c(gVar);
    }

    public final synchronized void b(B peerSettings) {
        try {
            kotlin.jvm.internal.k.f(peerSettings, "peerSettings");
            if (this.d) {
                throw new IOException("closed");
            }
            int i = this.c;
            int i6 = peerSettings.f975a;
            if ((i6 & 32) != 0) {
                i = peerSettings.b[5];
            }
            this.c = i;
            if (((i6 & 2) != 0 ? peerSettings.b[1] : -1) != -1) {
                c cVar = this.e;
                int i10 = (i6 & 2) != 0 ? peerSettings.b[1] : -1;
                cVar.getClass();
                int iMin = Math.min(i10, 16384);
                int i11 = cVar.d;
                if (i11 != iMin) {
                    if (iMin < i11) {
                        cVar.b = Math.min(cVar.b, iMin);
                    }
                    cVar.c = true;
                    cVar.d = iMin;
                    int i12 = cVar.h;
                    if (iMin < i12) {
                        if (iMin == 0) {
                            C0247a[] c0247aArr = cVar.e;
                            D7.q.f0(null, 0, c0247aArr, c0247aArr.length);
                            cVar.f = cVar.e.length - 1;
                            cVar.g = 0;
                            cVar.h = 0;
                        } else {
                            cVar.a(i12 - iMin);
                        }
                    }
                }
            }
            f(0, 0, 4, 1);
            this.f1000a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(boolean z10, int i, V9.g gVar, int i6) {
        if (this.d) {
            throw new IOException("closed");
        }
        f(i, i6, 0, z10 ? 1 : 0);
        if (i6 > 0) {
            V9.h hVar = this.f1000a;
            kotlin.jvm.internal.k.c(gVar);
            hVar.write(gVar, i6);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.d = true;
        this.f1000a.close();
    }

    public final void f(int i, int i6, int i10, int i11) {
        Level level = Level.FINE;
        Logger logger = f;
        if (logger.isLoggable(level)) {
            logger.fine(e.a(false, i, i6, i10, i11));
        }
        if (i6 > this.c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.c + ": " + i6).toString());
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw new IllegalArgumentException(B7.a.h(i, "reserved bit set: ").toString());
        }
        byte[] bArr = G9.b.f704a;
        V9.h hVar = this.f1000a;
        kotlin.jvm.internal.k.f(hVar, "<this>");
        hVar.writeByte((i6 >>> 16) & 255);
        hVar.writeByte((i6 >>> 8) & 255);
        hVar.writeByte(i6 & 255);
        hVar.writeByte(i10 & 255);
        hVar.writeByte(i11 & 255);
        hVar.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void flush() {
        if (this.d) {
            throw new IOException("closed");
        }
        this.f1000a.flush();
    }

    public final synchronized void g(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.d) {
            throw new IOException("closed");
        }
        if (errorCode.f5473a == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        f(0, bArr.length + 8, 7, 0);
        this.f1000a.writeInt(i);
        this.f1000a.writeInt(errorCode.f5473a);
        if (bArr.length != 0) {
            this.f1000a.write(bArr);
        }
        this.f1000a.flush();
    }

    public final synchronized void i(ArrayList arrayList, int i, boolean z10) {
        if (this.d) {
            throw new IOException("closed");
        }
        this.e.d(arrayList);
        long j5 = this.b.b;
        long jMin = Math.min(this.c, j5);
        int i6 = j5 == jMin ? 4 : 0;
        if (z10) {
            i6 |= 1;
        }
        f(i, (int) jMin, 1, i6);
        this.f1000a.write(this.b, jMin);
        if (j5 > jMin) {
            long j6 = j5 - jMin;
            while (j6 > 0) {
                long jMin2 = Math.min(this.c, j6);
                j6 -= jMin2;
                f(i, (int) jMin2, 9, j6 == 0 ? 4 : 0);
                this.f1000a.write(this.b, jMin2);
            }
        }
    }

    public final synchronized void k(int i, int i6, boolean z10) {
        if (this.d) {
            throw new IOException("closed");
        }
        f(0, 8, 6, z10 ? 1 : 0);
        this.f1000a.writeInt(i);
        this.f1000a.writeInt(i6);
        this.f1000a.flush();
    }

    public final synchronized void l(int i, ErrorCode errorCode) {
        if (this.d) {
            throw new IOException("closed");
        }
        if (errorCode.f5473a == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        f(i, 4, 3, 0);
        this.f1000a.writeInt(errorCode.f5473a);
        this.f1000a.flush();
    }

    public final synchronized void n(int i, long j5) {
        if (this.d) {
            throw new IOException("closed");
        }
        if (j5 == 0 || j5 > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j5).toString());
        }
        f(i, 4, 8, 0);
        this.f1000a.writeInt((int) j5);
        this.f1000a.flush();
    }
}
