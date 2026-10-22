package hd;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import od.c0;
import od.i0;
import od.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public c0 f5547c;

    /* renamed from: f, reason: collision with root package name */
    public int f5548f;

    /* renamed from: g, reason: collision with root package name */
    public int f5549g;

    /* renamed from: h, reason: collision with root package name */
    public int f5550h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f5551j;

    @Override // od.i0
    public final k0 b() {
        return this.f5547c.f9427c.b();
    }

    @Override // od.i0
    public final long l(od.i iVar, long j10) throws IOException {
        int i;
        int iN;
        c0 c0Var = this.f5547c;
        iVar.getClass();
        do {
            int i3 = this.i;
            if (i3 == 0) {
                c0Var.M(this.f5551j);
                this.f5551j = 0;
                if ((this.f5549g & 4) == 0) {
                    i = this.f5550h;
                    int iT = bd.b.t(c0Var);
                    this.i = iT;
                    this.f5548f = iT;
                    int iG = c0Var.g() & 255;
                    this.f5549g = c0Var.g() & 255;
                    Logger logger = r.f5552h;
                    if (logger.isLoggable(Level.FINE)) {
                        od.l lVar = f.f5493a;
                        logger.fine(f.a(true, this.f5550h, this.f5548f, iG, this.f5549g));
                    }
                    iN = c0Var.n() & Reader.READ_DONE;
                    this.f5550h = iN;
                    if (iG != 9) {
                        throw new IOException(iG + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jL = c0Var.l(iVar, Math.min(j10, i3));
                if (jL != -1) {
                    this.i -= (int) jL;
                    return jL;
                }
            }
            return -1L;
        } while (iN == i);
        od.f.l("TYPE_CONTINUATION streamId changed");
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
