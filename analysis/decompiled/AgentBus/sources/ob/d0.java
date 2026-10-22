package ob;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class d0 extends InputStream {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e0 f7960f;

    public d0(e0 e0Var) {
        this.f7960f = e0Var;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        e0 e0Var = this.f7960f;
        if (e0Var.f7966h) {
            throw new IOException("closed");
        }
        return (int) Math.min(e0Var.f7965g.f7993g, Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f7960f.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        e0 e0Var = this.f7960f;
        h hVar = e0Var.f7965g;
        if (e0Var.f7966h) {
            throw new IOException("closed");
        }
        if (hVar.f7993g == 0 && e0Var.f7964f.read(hVar, 8192L) == -1) {
            return -1;
        }
        return hVar.readByte() & 255;
    }

    public final String toString() {
        return this.f7960f + ".inputStream()";
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i10) throws IOException {
        q7.k.e(bArr, "data");
        e0 e0Var = this.f7960f;
        h hVar = e0Var.f7965g;
        if (!e0Var.f7966h) {
            b.e(bArr.length, i2, i10);
            if (hVar.f7993g == 0 && e0Var.f7964f.read(hVar, 8192L) == -1) {
                return -1;
            }
            return hVar.read(bArr, i2, i10);
        }
        throw new IOException("closed");
    }
}
