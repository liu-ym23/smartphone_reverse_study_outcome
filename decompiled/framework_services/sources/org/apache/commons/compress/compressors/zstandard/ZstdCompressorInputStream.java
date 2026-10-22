package org.apache.commons.compress.compressors.zstandard;

import com.github.luben.zstd.ZstdInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final ZstdInputStream decIS;

    public ZstdCompressorInputStream(InputStream in) throws IOException {
        CountingInputStream r1 = new CountingInputStream(in);
        this.countingStream = r1;
        this.decIS = new ZstdInputStream(r1);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.decIS.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.decIS.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return this.decIS.read(b);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        return IOUtils.skip(this.decIS, n);
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.decIS.mark(readlimit);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.decIS.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.decIS.read();
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
        int ret = this.decIS.read(buf, off, len);
        count(ret);
        return ret;
    }

    public String toString() {
        return this.decIS.toString();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.decIS.reset();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }
}
