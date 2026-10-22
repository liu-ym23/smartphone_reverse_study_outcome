package v5;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    public InputStream f14793c;

    /* renamed from: f, reason: collision with root package name */
    public int f14794f;

    @Override // java.io.InputStream
    public final int available() {
        return this.f14794f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f14793c.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.f14793c.read();
        if (i == -1) {
            this.f14794f = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j10) {
        return this.f14793c.skip(j10);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.f14793c.read(bArr);
        if (i == -1) {
            this.f14794f = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) throws IOException {
        int i10 = this.f14793c.read(bArr, i, i3);
        if (i10 == -1) {
            this.f14794f = 0;
        }
        return i10;
    }
}
