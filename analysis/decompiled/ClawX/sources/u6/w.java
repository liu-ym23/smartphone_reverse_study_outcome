package u6;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f5772f = Logger.getLogger(h.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final c7.g f5773a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.f f5774b;

    /* renamed from: c, reason: collision with root package name */
    public int f5775c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final f f5776e;

    public w(c7.o sink) {
        kotlin.jvm.internal.p.e(sink, "sink");
        this.f5773a = sink;
        c7.f fVar = new c7.f();
        this.f5774b = fVar;
        this.f5775c = ReaderJsonLexerKt.BATCH_SIZE;
        this.f5776e = new f(fVar);
    }

    public final void a(z peerSettings) {
        kotlin.jvm.internal.p.e(peerSettings, "peerSettings");
        synchronized (this) {
            try {
                if (this.d) {
                    throw new IOException("closed");
                }
                int i8 = this.f5775c;
                int i9 = peerSettings.f5781a;
                if ((i9 & 32) != 0) {
                    i8 = peerSettings.f5782b[5];
                }
                this.f5775c = i8;
                if (((i9 & 2) != 0 ? peerSettings.f5782b[1] : -1) != -1) {
                    f fVar = this.f5776e;
                    int i10 = (i9 & 2) != 0 ? peerSettings.f5782b[1] : -1;
                    fVar.getClass();
                    int iMin = Math.min(i10, ReaderJsonLexerKt.BATCH_SIZE);
                    int i11 = fVar.d;
                    if (i11 != iMin) {
                        if (iMin < i11) {
                            fVar.f5694b = Math.min(fVar.f5694b, iMin);
                        }
                        fVar.f5695c = true;
                        fVar.d = iMin;
                        int i12 = fVar.f5699h;
                        if (iMin < i12) {
                            if (iMin == 0) {
                                d[] dVarArr = fVar.f5696e;
                                c5.l.c0(dVarArr, 0, dVarArr.length);
                                fVar.f5697f = fVar.f5696e.length - 1;
                                fVar.f5698g = 0;
                                fVar.f5699h = 0;
                            } else {
                                fVar.a(i12 - iMin);
                            }
                        }
                    }
                }
                e(0, 0, 4, 1);
                this.f5773a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(boolean z, int i8, c7.f fVar, int i9) {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            e(i8, i9, 0, z ? 1 : 0);
            if (i9 > 0) {
                c7.g gVar = this.f5773a;
                kotlin.jvm.internal.p.b(fVar);
                gVar.x(i9, fVar);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            this.d = true;
            this.f5773a.close();
        }
    }

    public final void e(int i8, int i9, int i10, int i11) {
        if (i10 != 8) {
            Level level = Level.FINE;
            Logger logger = f5772f;
            if (logger.isLoggable(level)) {
                logger.fine(h.b(false, i8, i9, i10, i11));
            }
        }
        if (i9 > this.f5775c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f5775c + ": " + i9).toString());
        }
        if ((Integer.MIN_VALUE & i8) != 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "reserved bit set: ").toString());
        }
        byte[] bArr = o6.d.f4327a;
        c7.g gVar = this.f5773a;
        kotlin.jvm.internal.p.e(gVar, "<this>");
        gVar.writeByte((i9 >>> 16) & 255);
        gVar.writeByte((i9 >>> 8) & 255);
        gVar.writeByte(i9 & 255);
        gVar.writeByte(i10 & 255);
        gVar.writeByte(i11 & 255);
        gVar.writeInt(i8 & Integer.MAX_VALUE);
    }

    public final void flush() {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            this.f5773a.flush();
        }
    }

    public final void g(int i8, b bVar, byte[] bArr) {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            if (bVar.f5677a == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            e(0, bArr.length + 8, 7, 0);
            this.f5773a.writeInt(i8);
            this.f5773a.writeInt(bVar.f5677a);
            if (bArr.length != 0) {
                this.f5773a.write(bArr);
            }
            this.f5773a.flush();
        }
    }

    public final void j(boolean z, int i8, ArrayList arrayList) {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            this.f5776e.d(arrayList);
            long j4 = this.f5774b.f1164b;
            long jMin = Math.min(this.f5775c, j4);
            int i9 = j4 == jMin ? 4 : 0;
            if (z) {
                i9 |= 1;
            }
            e(i8, (int) jMin, 1, i9);
            this.f5773a.x(jMin, this.f5774b);
            if (j4 > jMin) {
                long j8 = j4 - jMin;
                while (j8 > 0) {
                    long jMin2 = Math.min(this.f5775c, j8);
                    j8 -= jMin2;
                    e(i8, (int) jMin2, 9, j8 == 0 ? 4 : 0);
                    this.f5773a.x(jMin2, this.f5774b);
                }
            }
        }
    }

    public final void l(int i8, int i9, boolean z) {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            e(0, 8, 6, z ? 1 : 0);
            this.f5773a.writeInt(i8);
            this.f5773a.writeInt(i9);
            this.f5773a.flush();
        }
    }

    public final void n(int i8, b bVar) {
        synchronized (this) {
            if (this.d) {
                throw new IOException("closed");
            }
            if (bVar.f5677a == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            e(i8, 4, 3, 0);
            this.f5773a.writeInt(bVar.f5677a);
            this.f5773a.flush();
        }
    }

    public final void o(int i8, long j4) {
        synchronized (this) {
            try {
                if (this.d) {
                    throw new IOException("closed");
                }
                if (j4 == 0 || j4 > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j4).toString());
                }
                Logger logger = f5772f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(h.c(false, i8, 4, j4));
                }
                e(i8, 4, 8, 0);
                this.f5773a.writeInt((int) j4);
                this.f5773a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
