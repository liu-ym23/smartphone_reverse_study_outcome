package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class DeflateCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private static final int MAGIC_1 = 120;
    private static final int MAGIC_2a = 1;
    private static final int MAGIC_2b = 94;
    private static final int MAGIC_2c = 156;
    private static final int MAGIC_2d = 218;
    private final CountingInputStream countingStream;
    private final InputStream in;
    private final Inflater inflater;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
    }

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters parameters) {
        this.inflater = new Inflater(!parameters.withZlibHeader());
        CountingInputStream r1 = new CountingInputStream(inputStream);
        this.countingStream = r1;
        this.in = new InflaterInputStream(r1, this.inflater);
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
        this.in.close();     // Catch: Throwable -> L5
        this.inflater.end();
        return;
    L5:
        th = move-exception;
        this.inflater.end();
        throw th;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public static boolean matches(byte[] signature, int length) {
        if (length > 3) goto L5;
        return false;
    L5:
        if (signature[0] == 120) goto L7;
        return false;
    L7:
        if (signature[1] == 1) goto L15;
        if (signature[1] == 94) goto L15;
        if (signature[1] == (-100)) goto L15;
        if (signature[1] == (-38)) goto L15;
        return false;
    L15:
        return true;
    }
}
