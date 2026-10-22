package ob;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b0 extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c0 f7953f;

    public b0(c0 c0Var) {
        this.f7953f = c0Var;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.f7953f.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        c0 c0Var = this.f7953f;
        if (c0Var.f7956h) {
            return;
        }
        c0Var.flush();
    }

    public final String toString() {
        return this.f7953f + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        c0 c0Var = this.f7953f;
        if (c0Var.f7956h) {
            throw new IOException("closed");
        }
        c0Var.f7955g.Q((byte) i2);
        c0Var.a();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i10) throws IOException {
        q7.k.e(bArr, "data");
        c0 c0Var = this.f7953f;
        if (!c0Var.f7956h) {
            c0Var.f7955g.write(bArr, i2, i10);
            c0Var.a();
            return;
        }
        throw new IOException("closed");
    }
}
