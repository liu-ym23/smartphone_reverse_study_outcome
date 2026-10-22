package od;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9448c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f9449f;

    public /* synthetic */ g(k kVar, int i) {
        this.f9448c = i;
        this.f9449f = kVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        switch (this.f9448c) {
            case 0:
                return (int) Math.min(((i) this.f9449f).f9454f, Reader.READ_DONE);
            default:
                c0 c0Var = (c0) this.f9449f;
                if (!c0Var.f9429g) {
                    return (int) Math.min(c0Var.f9428f.f9454f, Reader.READ_DONE);
                }
                f.l("closed");
                return 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f9448c) {
            case 0:
                break;
            default:
                ((c0) this.f9449f).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f9448c) {
            case 0:
                i iVar = (i) this.f9449f;
                if (iVar.f9454f > 0) {
                    return iVar.N() & 255;
                }
                return -1;
            default:
                c0 c0Var = (c0) this.f9449f;
                i iVar2 = c0Var.f9428f;
                if (c0Var.f9429g) {
                    f.l("closed");
                    return 0;
                }
                if (iVar2.f9454f == 0 && c0Var.f9427c.l(iVar2, 8192L) == -1) {
                    return -1;
                }
                return iVar2.N() & 255;
        }
    }

    public final String toString() {
        switch (this.f9448c) {
            case 0:
                return ((i) this.f9449f) + ".inputStream()";
            default:
                return ((c0) this.f9449f) + ".inputStream()";
        }
    }

    private final void d() {
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        int i10 = this.f9448c;
        bArr.getClass();
        switch (i10) {
            case 0:
                return ((i) this.f9449f).read(bArr, i, i3);
            default:
                c0 c0Var = (c0) this.f9449f;
                i iVar = c0Var.f9428f;
                if (!c0Var.f9429g) {
                    a.a.m(bArr.length, i, i3);
                    if (iVar.f9454f == 0 && c0Var.f9427c.l(iVar, 8192L) == -1) {
                        return -1;
                    }
                    return iVar.read(bArr, i, i3);
                }
                f.l("closed");
                return 0;
        }
    }
}
