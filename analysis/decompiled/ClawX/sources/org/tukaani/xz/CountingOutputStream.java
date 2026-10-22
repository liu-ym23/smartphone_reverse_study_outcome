package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class CountingOutputStream extends FinishableOutputStream {
    private final OutputStream out;
    private long size = 0;

    public CountingOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        this.out.write(i8);
        long j4 = this.size;
        if (j4 >= 0) {
            this.size = j4 + 1;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        this.out.write(bArr, i8, i9);
        long j4 = this.size;
        if (j4 >= 0) {
            this.size = j4 + i9;
        }
    }
}
