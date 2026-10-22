package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DeltaInputStream extends InputStream {
    public static final int DISTANCE_MAX = 256;
    public static final int DISTANCE_MIN = 1;
    private final org.tukaani.xz.delta.DeltaDecoder delta;
    private IOException exception;
    private InputStream in;
    private final byte[] tempBuf;

    public DeltaInputStream(InputStream in, int distance) {
        this.exception = null;
        this.tempBuf = new byte[1];
        if (in == null) goto L7;
        this.in = in;
        this.delta = new org.tukaani.xz.delta.DeltaDecoder(distance);
        return;
    L7:
        throw new NullPointerException();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.tempBuf[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        if (len != 0) goto L6;
        return 0;
    L6:
        if (this.in == null) goto L21;
        if (this.exception != null) goto L19;
        int size = this.in.read(buf, off, len);     // Catch: IOException -> L15
        if (size != (-1)) goto L13;
        return -1;
    L13:
        this.delta.decode(buf, off, size);
        return size;
    L15:
        e = move-exception;
        this.exception = e;
        throw e;
    L19:
        throw this.exception;
    L21:
        throw new XZIOException("Stream closed");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L11;
        if (this.exception != null) goto L9;
        return this.in.available();
    L9:
        throw this.exception;
    L11:
        throw new XZIOException("Stream closed");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.in != null) goto L11;
        return;
    L11:
        this.in.close();     // Catch: Throwable -> L7
        this.in = null;
        return;
    L7:
        th = move-exception;
        this.in = null;
        throw th;
    }
}
