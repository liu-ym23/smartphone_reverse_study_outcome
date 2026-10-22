package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.MemoryLimitException;

/* JADX INFO: loaded from: classes3.dex */
public class LZMACompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        CountingInputStream r1 = new CountingInputStream(inputStream);
        this.countingStream = r1;
        this.in = new LZMAInputStream(r1, -1);
    }

    public LZMACompressorInputStream(InputStream inputStream, int memoryLimitInKb) throws IOException {
        CountingInputStream r1 = new CountingInputStream(inputStream);     // Catch: MemoryLimitException -> L5
        this.countingStream = r1;     // Catch: MemoryLimitException -> L5
        this.in = new LZMAInputStream(r1, memoryLimitInKb);     // Catch: MemoryLimitException -> L5
        return;
    L5:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.in.read();
        if (ret != (-1)) goto L5;
        int r1 = 0;
    L6:
        count(r1);
        return ret;
    L5:
        r1 = 1;
        goto L6
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int ret = this.in.read(buf, off, len);
        count(ret);
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return IOUtils.skip(this.in, n);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public static boolean matches(byte[] signature, int length) {
        if (signature != null) goto L5;
        return false;
    L5:
        if (length >= 3) goto L7;
        return false;
    L7:
        if (signature[0] == 93) goto L9;
        return false;
    L9:
        if (signature[1] == 0) goto L11;
        return false;
    L11:
        if (signature[2] == 0) goto L13;
        return false;
    L13:
        return true;
    }
}
