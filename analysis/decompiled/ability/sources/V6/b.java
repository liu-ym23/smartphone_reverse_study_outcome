package V6;

import com.volcengine.tos.TosClientException;
import com.volcengine.tos.model.object.TosObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
public final class b extends TosObjectInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f1387a;
    public final FileInputStream b;
    public long c;

    public b(FileInputStream fileInputStream, int i) {
        super(fileInputStream);
        this.c = 0L;
        this.b = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f1387a = channel;
        try {
            this.c = channel.position();
        } catch (IOException e) {
            throw new TosClientException("tos: failed to get file position", e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return this.b.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        try {
            this.c = this.f1387a.position();
        } catch (IOException e) {
            throw new TosClientException("tos: failed to mark the file position", e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        return this.b.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        this.f1387a.position(this.c);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) {
        return this.b.skip(j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return this.b.read(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        return this.b.read(bArr, i, i6);
    }
}
