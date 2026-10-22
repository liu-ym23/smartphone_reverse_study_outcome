package org.apache.commons.compress.compressors.deflate64;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class Deflate64CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private long compressedBytesRead;
    private HuffmanDecoder decoder;
    private final byte[] oneByte;
    private InputStream originalStream;

    public Deflate64CompressorInputStream(InputStream in) {
        this(new HuffmanDecoder(in));
        this.originalStream = in;
    }

    Deflate64CompressorInputStream(HuffmanDecoder decoder) {
        this.oneByte = new byte[1];
        this.decoder = decoder;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
    L2:
        int r = read(this.oneByte);
        switch(r) {
            case -1: goto L9;
            case 0: goto L2;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Invalid return value from read: " + r);
    L7:
        return this.oneByte[0] & CecDeviceType.INACTIVE;
    L9:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int read = -1;
        if (this.decoder == null) goto L7;
        read = this.decoder.decode(b, off, len);
        this.compressedBytesRead = this.decoder.getBytesRead();
        count(read);
        if (read != (-1)) goto L7;
        closeDecoder();
    L7:
        return read;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.decoder != null) goto L7;
        return 0;
    L7:
        return this.decoder.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeDecoder();     // Catch: Throwable -> L8
        if (this.originalStream == null) goto L15;
        this.originalStream.close();
        this.originalStream = null;
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.originalStream == null) goto L12;
        this.originalStream.close();
        this.originalStream = null;
    L12:
        throw th;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.compressedBytesRead;
    }

    private void closeDecoder() {
        IOUtils.closeQuietly(this.decoder);
        this.decoder = null;
    }
}
