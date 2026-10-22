package M9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class r implements V9.w {

    /* renamed from: a, reason: collision with root package name */
    public final V9.i f994a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public r(V9.i source) {
        kotlin.jvm.internal.k.f(source, "source");
        this.f994a = source;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // V9.w
    public final long e(V9.g sink, long j5) throws IOException {
        int i;
        int i6;
        kotlin.jvm.internal.k.f(sink, "sink");
        do {
            int i10 = this.e;
            V9.i iVar = this.f994a;
            if (i10 == 0) {
                iVar.skip(this.f);
                this.f = 0;
                if ((this.c & 4) == 0) {
                    i = this.d;
                    int iS = G9.b.s(iVar);
                    this.e = iS;
                    this.b = iS;
                    int i11 = iVar.readByte() & 255;
                    this.c = iVar.readByte() & 255;
                    Logger logger = s.d;
                    if (logger.isLoggable(Level.FINE)) {
                        ByteString byteString = e.f980a;
                        logger.fine(e.a(true, this.d, this.b, i11, this.c));
                    }
                    i6 = iVar.readInt() & Integer.MAX_VALUE;
                    this.d = i6;
                    if (i11 != 9) {
                        throw new IOException(i11 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jE = iVar.e(sink, Math.min(8192L, i10));
                if (jE != -1) {
                    this.e -= (int) jE;
                    return jE;
                }
            }
            return -1L;
        } while (i6 == i);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // V9.w
    public final V9.y timeout() {
        return this.f994a.timeout();
    }
}
