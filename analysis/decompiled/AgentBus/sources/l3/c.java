package l3;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class c extends FileOutputStream {

    /* renamed from: f, reason: collision with root package name */
    public final OutputStream f5832f;

    public c(FileDescriptor fileDescriptor, OutputStream outputStream) {
        super(fileDescriptor);
        this.f5832f = outputStream;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f5832f.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f5832f.flush();
    }

    @Override // java.io.FileOutputStream
    public final FileChannel getChannel() {
        throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f5832f.write(bArr);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(int i2) throws IOException {
        this.f5832f.write(i2);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i10) throws IOException {
        this.f5832f.write(bArr, i2, i10);
    }
}
