package V9;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class e extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1416a;
    public final /* synthetic */ i b;

    public /* synthetic */ e(i iVar, int i) {
        this.f1416a = i;
        this.b = iVar;
    }

    private final void b() {
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.f1416a) {
            case 0:
                jMin = Math.min(((g) this.b).b, Integer.MAX_VALUE);
                break;
            default:
                r rVar = (r) this.b;
                if (!rVar.c) {
                    jMin = Math.min(rVar.b.b, Integer.MAX_VALUE);
                    break;
                } else {
                    throw new IOException("closed");
                }
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f1416a) {
            case 0:
                break;
            default:
                ((r) this.b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f1416a) {
            case 0:
                g gVar = (g) this.b;
                if (gVar.b > 0) {
                    return gVar.readByte() & 255;
                }
                return -1;
            default:
                r rVar = (r) this.b;
                g gVar2 = rVar.b;
                if (rVar.c) {
                    throw new IOException("closed");
                }
                if (gVar2.b == 0 && rVar.f1425a.e(gVar2, 8192L) == -1) {
                    return -1;
                }
                return gVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f1416a) {
            case 0:
                return ((g) this.b) + ".inputStream()";
            default:
                return ((r) this.b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i, int i6) throws IOException {
        switch (this.f1416a) {
            case 0:
                kotlin.jvm.internal.k.f(sink, "sink");
                return ((g) this.b).read(sink, i, i6);
            default:
                kotlin.jvm.internal.k.f(sink, "data");
                r rVar = (r) this.b;
                g gVar = rVar.b;
                if (!rVar.c) {
                    H4.o.t(sink.length, i, i6);
                    if (gVar.b == 0 && rVar.f1425a.e(gVar, 8192L) == -1) {
                        return -1;
                    }
                    return gVar.read(sink, i, i6);
                }
                throw new IOException("closed");
        }
    }
}
