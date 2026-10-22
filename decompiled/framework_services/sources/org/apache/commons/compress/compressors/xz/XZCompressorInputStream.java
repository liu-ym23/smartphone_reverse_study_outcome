package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public static boolean matches(byte[] signature, int length) {
        if (length >= XZ.HEADER_MAGIC.length) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= XZ.HEADER_MAGIC.length) goto L12;
        if (signature[i] != XZ.HEADER_MAGIC[i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean decompressConcatenated) throws IOException {
        this(inputStream, decompressConcatenated, -1);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean decompressConcatenated, int memoryLimitInKb) throws IOException {
        this.countingStream = new CountingInputStream(inputStream);
        if (decompressConcatenated == false) goto L5;
        this.in = new XZInputStream(this.countingStream, memoryLimitInKb);
        return;
    L5:
        this.in = new SingleXZInputStream(this.countingStream, memoryLimitInKb);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.in.read();     // Catch: MemoryLimitException -> L8
        int r1 = -1;
        if (ret == (-1)) goto L6;
        r1 = 1;
    L6:
        count(r1);     // Catch: MemoryLimitException -> L8
        return ret;
    L8:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int ret = this.in.read(buf, off, len);     // Catch: MemoryLimitException -> L4
        count(ret);     // Catch: MemoryLimitException -> L4
        return ret;
    L4:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return IOUtils.skip(this.in, n);
    L4:
        e = move-exception;
        throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
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
}
