package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
class InflaterInputStreamWithStatistics extends InflaterInputStream implements InputStreamStatistics {
    private long compressedCount;
    private long uncompressedCount;

    public InflaterInputStreamWithStatistics(InputStream in) {
        super(in);
        this.compressedCount = 0;
        this.uncompressedCount = 0;
    }

    public InflaterInputStreamWithStatistics(InputStream in, Inflater inf) {
        super(in, inf);
        this.compressedCount = 0;
        this.uncompressedCount = 0;
    }

    public InflaterInputStreamWithStatistics(InputStream in, Inflater inf, int size) {
        super(in, inf, size);
        this.compressedCount = 0;
        this.uncompressedCount = 0;
    }

    @Override // java.util.zip.InflaterInputStream
    protected void fill() throws IOException {
        super.fill();
        this.compressedCount += (long) ((InflaterInputStream) this).inf.getRemaining();
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int b = super.read();
        if (b <= (-1)) goto L5;
        this.uncompressedCount++;
    L5:
        return b;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int bytes = super.read(b, off, len);
        if (bytes <= (-1)) goto L5;
        this.uncompressedCount += (long) bytes;
    L5:
        return bytes;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.compressedCount;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }
}
