package hb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ob.k0;
import ob.m0;

/* loaded from: classes.dex */
public final class s implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final ob.j f4343f;

    /* renamed from: g, reason: collision with root package name */
    public int f4344g;

    /* renamed from: h, reason: collision with root package name */
    public int f4345h;

    /* renamed from: i, reason: collision with root package name */
    public int f4346i;

    /* renamed from: j, reason: collision with root package name */
    public int f4347j;

    /* renamed from: k, reason: collision with root package name */
    public int f4348k;

    public s(ob.j jVar) {
        q7.k.e(jVar, "source");
        this.f4343f = jVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // ob.k0
    public final long read(ob.h hVar, long j2) throws IOException {
        int i2;
        int i10;
        q7.k.e(hVar, "sink");
        do {
            int i11 = this.f4347j;
            ob.j jVar = this.f4343f;
            if (i11 == 0) {
                jVar.skip(this.f4348k);
                this.f4348k = 0;
                if ((this.f4345h & 4) == 0) {
                    i2 = this.f4346i;
                    int iT = bb.b.t(jVar);
                    this.f4347j = iT;
                    this.f4344g = iT;
                    int i12 = jVar.readByte() & 255;
                    this.f4345h = jVar.readByte() & 255;
                    Logger logger = t.f4349i;
                    if (logger.isLoggable(Level.FINE)) {
                        ob.k kVar = f.f4285a;
                        logger.fine(f.a(true, this.f4346i, this.f4344g, i12, this.f4345h));
                    }
                    i10 = jVar.readInt() & Integer.MAX_VALUE;
                    this.f4346i = i10;
                    if (i12 != 9) {
                        throw new IOException(i12 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long j4 = jVar.read(hVar, Math.min(j2, i11));
                if (j4 != -1) {
                    this.f4347j -= (int) j4;
                    return j4;
                }
            }
            return -1L;
        } while (i10 == i2);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f4343f.timeout();
    }
}
