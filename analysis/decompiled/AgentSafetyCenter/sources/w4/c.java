package w4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends FileOutputStream {

    /* renamed from: c, reason: collision with root package name */
    public OutputStream f15217c;

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f15217c.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f15217c.flush();
    }

    @Override // java.io.FileOutputStream
    public final FileChannel getChannel() {
        throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f15217c.write(bArr);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f15217c.write(i);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) throws IOException {
        this.f15217c.write(bArr, i, i3);
    }
}
