package l3;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class b extends FileInputStream {

    /* renamed from: f, reason: collision with root package name */
    public final InputStream f5830f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f5831g;

    public b(FileDescriptor fileDescriptor, InputStream inputStream) {
        super(fileDescriptor);
        this.f5831g = new Object();
        this.f5830f = inputStream;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int available() {
        return this.f5830f.available();
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f5830f.close();
    }

    @Override // java.io.FileInputStream
    public final FileChannel getChannel() {
        throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        synchronized (this.f5831g) {
            this.f5830f.mark(i2);
        }
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f5830f.markSupported();
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read() {
        return this.f5830f.read();
    }

    @Override // java.io.InputStream
    public final void reset() {
        synchronized (this.f5831g) {
            this.f5830f.reset();
        }
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final long skip(long j2) {
        return this.f5830f.skip(j2);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return this.f5830f.read(bArr);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i10) {
        return this.f5830f.read(bArr, i2, i10);
    }
}
