package okhttp3.internal.http2;

import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import sd.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Closeable {
    public static final Logger h = Logger.getLogger(hd.b.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final g f11248a;

    /* renamed from: b, reason: collision with root package name */
    public final sd.e f11249b;

    /* renamed from: c, reason: collision with root package name */
    public int f11250c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11251d;

    /* renamed from: e, reason: collision with root package name */
    public final b.C0122b f11252e;

    public f(g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        this.f11248a = sink;
        sd.e eVar = new sd.e();
        this.f11249b = eVar;
        this.f11250c = 16384;
        this.f11252e = new b.C0122b(eVar);
    }

    public final synchronized void C(int i10, ErrorCode errorCode, byte[] bArr) {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        if (errorCode.f11128a == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        w(0, bArr.length + 8, 7, 0);
        this.f11248a.writeInt(i10);
        this.f11248a.writeInt(errorCode.f11128a);
        if (bArr.length != 0) {
            this.f11248a.write(bArr);
        }
        this.f11248a.flush();
    }

    public final synchronized void K(boolean z, int i10, ArrayList arrayList) {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        this.f11252e.d(arrayList);
        long j10 = this.f11249b.f11926b;
        long jMin = Math.min(this.f11250c, j10);
        int i11 = j10 == jMin ? 4 : 0;
        if (z) {
            i11 |= 1;
        }
        w(i10, (int) jMin, 1, i11);
        this.f11248a.j0(this.f11249b, jMin);
        if (j10 > jMin) {
            long j11 = j10 - jMin;
            while (j11 > 0) {
                long jMin2 = Math.min(this.f11250c, j11);
                j11 -= jMin2;
                w(i10, (int) jMin2, 9, j11 == 0 ? 4 : 0);
                this.f11248a.j0(this.f11249b, jMin2);
            }
        }
    }

    public final synchronized void P(int i10, int i11, boolean z) {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        w(0, 8, 6, z ? 1 : 0);
        this.f11248a.writeInt(i10);
        this.f11248a.writeInt(i11);
        this.f11248a.flush();
    }

    public final synchronized void Q(int i10, ErrorCode errorCode) {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        if (errorCode.f11128a == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        w(i10, 4, 3, 0);
        this.f11248a.writeInt(errorCode.f11128a);
        this.f11248a.flush();
    }

    public final synchronized void S(int i10, long j10) {
        try {
            if (this.f11251d) {
                throw new IOException("closed");
            }
            if (j10 == 0 || j10 > 2147483647L) {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
            }
            Logger logger = h;
            if (logger.isLoggable(Level.FINE)) {
                hd.b.f9414a.getClass();
                logger.fine(hd.b.c(false, i10, 4, j10));
            }
            w(i10, 4, 8, 0);
            this.f11248a.writeInt((int) j10);
            this.f11248a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(hd.e peerSettings) {
        try {
            kotlin.jvm.internal.g.f(peerSettings, "peerSettings");
            if (this.f11251d) {
                throw new IOException("closed");
            }
            int i10 = this.f11250c;
            int i11 = peerSettings.f9426a;
            if ((i11 & 32) != 0) {
                i10 = peerSettings.f9427b[5];
            }
            this.f11250c = i10;
            if (((i11 & 2) != 0 ? peerSettings.f9427b[1] : -1) != -1) {
                b.C0122b c0122b = this.f11252e;
                int i12 = (i11 & 2) != 0 ? peerSettings.f9427b[1] : -1;
                c0122b.getClass();
                int iMin = Math.min(i12, 16384);
                int i13 = c0122b.f11205d;
                if (i13 != iMin) {
                    if (iMin < i13) {
                        c0122b.f11203b = Math.min(c0122b.f11203b, iMin);
                    }
                    c0122b.f11204c = true;
                    c0122b.f11205d = iMin;
                    int i14 = c0122b.h;
                    if (iMin < i14) {
                        if (iMin == 0) {
                            hd.a[] aVarArr = c0122b.f11206e;
                            b1.G(null, aVarArr, 0, aVarArr.length);
                            c0122b.f11207f = c0122b.f11206e.length - 1;
                            c0122b.f11208g = 0;
                            c0122b.h = 0;
                        } else {
                            c0122b.a(i14 - iMin);
                        }
                    }
                }
            }
            w(0, 0, 4, 1);
            this.f11248a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f11251d = true;
        this.f11248a.close();
    }

    public final synchronized void flush() {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        this.f11248a.flush();
    }

    public final synchronized void o(boolean z, int i10, sd.e eVar, int i11) {
        if (this.f11251d) {
            throw new IOException("closed");
        }
        w(i10, i11, 0, z ? 1 : 0);
        if (i11 > 0) {
            g gVar = this.f11248a;
            kotlin.jvm.internal.g.c(eVar);
            gVar.j0(eVar, i11);
        }
    }

    public final void w(int i10, int i11, int i12, int i13) {
        if (i12 != 8) {
            Level level = Level.FINE;
            Logger logger = h;
            if (logger.isLoggable(level)) {
                hd.b.f9414a.getClass();
                logger.fine(hd.b.b(i10, i11, i12, i13, false));
            }
        }
        if (i11 > this.f11250c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f11250c + ": " + i11).toString());
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "reserved bit set: ").toString());
        }
        byte[] bArr = i.f3230a;
        g gVar = this.f11248a;
        kotlin.jvm.internal.g.f(gVar, "<this>");
        gVar.writeByte((i11 >>> 16) & 255);
        gVar.writeByte((i11 >>> 8) & 255);
        gVar.writeByte(i11 & 255);
        gVar.writeByte(i12 & 255);
        gVar.writeByte(i13 & 255);
        gVar.writeInt(i10 & Integer.MAX_VALUE);
    }
}
