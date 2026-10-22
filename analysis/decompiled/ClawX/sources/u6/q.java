package u6;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q implements c7.v {

    /* renamed from: a, reason: collision with root package name */
    public final c7.h f5743a;

    /* renamed from: b, reason: collision with root package name */
    public int f5744b;

    /* renamed from: c, reason: collision with root package name */
    public int f5745c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f5746e;

    /* renamed from: f, reason: collision with root package name */
    public int f5747f;

    public q(c7.h source) {
        kotlin.jvm.internal.p.e(source, "source");
        this.f5743a = source;
    }

    @Override // c7.v, c7.t
    public final c7.x d() {
        return this.f5743a.d();
    }

    @Override // c7.v
    public final long h(long j4, c7.f fVar) throws IOException {
        int i8;
        int i9;
        do {
            int i10 = this.f5746e;
            c7.h hVar = this.f5743a;
            if (i10 == 0) {
                hVar.skip(this.f5747f);
                this.f5747f = 0;
                if ((this.f5745c & 4) == 0) {
                    i8 = this.d;
                    int iL = o6.d.l(hVar);
                    this.f5746e = iL;
                    this.f5744b = iL;
                    int i11 = hVar.readByte() & 255;
                    this.f5745c = hVar.readByte() & 255;
                    Logger logger = r.d;
                    if (logger.isLoggable(Level.FINE)) {
                        c7.i iVar = h.f5702a;
                        logger.fine(h.b(true, this.d, this.f5744b, i11, this.f5745c));
                    }
                    i9 = hVar.readInt() & Integer.MAX_VALUE;
                    this.d = i9;
                    if (i11 != 9) {
                        throw new IOException(i11 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jH = hVar.h(Math.min(8192L, i10), fVar);
                if (jH != -1) {
                    this.f5746e -= (int) jH;
                    return jH;
                }
            }
            return -1L;
        } while (i9 == i8);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
