package org.tukaani.xz;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SeekableFileInputStream extends SeekableInputStream {
    protected RandomAccessFile randomAccessFile;

    public SeekableFileInputStream(File file) {
        this.randomAccessFile = new RandomAccessFile(file, "r");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long length() {
        return this.randomAccessFile.length();
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long position() {
        return this.randomAccessFile.getFilePointer();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.randomAccessFile.read();
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public void seek(long j4) throws IOException {
        this.randomAccessFile.seek(j4);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.randomAccessFile.read(bArr);
    }

    public SeekableFileInputStream(String str) {
        this.randomAccessFile = new RandomAccessFile(str, "r");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) {
        return this.randomAccessFile.read(bArr, i8, i9);
    }

    public SeekableFileInputStream(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }
}
