package w4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends FileInputStream {

    /* renamed from: c, reason: collision with root package name */
    public InputStream f15215c;

    /* renamed from: f, reason: collision with root package name */
    public Object f15216f;

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int available() {
        return this.f15215c.available();
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f15215c.close();
    }

    @Override // java.io.FileInputStream
    public final FileChannel getChannel() {
        throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        synchronized (this.f15216f) {
            this.f15215c.mark(i);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f15215c.markSupported();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read() {
        return this.f15215c.read();
    }

    @Override // java.io.InputStream
    public final void reset() {
        synchronized (this.f15216f) {
            this.f15215c.reset();
        }
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final long skip(long j10) {
        return this.f15215c.skip(j10);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return this.f15215c.read(bArr);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) {
        return this.f15215c.read(bArr, i, i3);
    }
}
