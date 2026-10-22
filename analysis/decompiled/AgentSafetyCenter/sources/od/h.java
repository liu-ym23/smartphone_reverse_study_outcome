package od;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends OutputStream {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9450c = 1;

    /* renamed from: f, reason: collision with root package name */
    public Object f9451f;

    public h(i iVar) {
        this.f9451f = iVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.f9450c;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f9450c) {
            case 0:
                break;
            default:
                ((FileOutputStream) this.f9451f).flush();
                break;
        }
    }

    public String toString() {
        switch (this.f9450c) {
            case 0:
                return ((i) this.f9451f) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) throws IOException {
        int i10 = this.f9450c;
        bArr.getClass();
        switch (i10) {
            case 0:
                ((i) this.f9451f).write(bArr, i, i3);
                break;
            default:
                ((FileOutputStream) this.f9451f).write(bArr, i, i3);
                break;
        }
    }

    public /* synthetic */ h() {
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void g() {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        switch (this.f9450c) {
            case 1:
                bArr.getClass();
                ((FileOutputStream) this.f9451f).write(bArr);
                break;
            default:
                super.write(bArr);
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        switch (this.f9450c) {
            case 0:
                ((i) this.f9451f).b0(i);
                break;
            default:
                ((FileOutputStream) this.f9451f).write(i);
                break;
        }
    }
}
