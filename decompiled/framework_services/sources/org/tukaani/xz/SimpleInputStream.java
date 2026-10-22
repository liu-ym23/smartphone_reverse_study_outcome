package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.simple.SimpleFilter;

/* JADX INFO: loaded from: classes3.dex */
class SimpleInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FILTER_BUF_SIZE = 4096;
    private boolean endReached;
    private IOException exception;
    private final byte[] filterBuf;
    private int filtered;
    private InputStream in;
    private int pos;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf;
    private int unfiltered;

    static {
    }

    static int getMemoryUsage() {
        return 5;
    }

    SimpleInputStream(InputStream in, SimpleFilter simpleFilter) {
        this.filterBuf = new byte[4096];
        this.pos = 0;
        this.filtered = 0;
        this.unfiltered = 0;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        if (in == null) goto L7;
        this.in = in;
        this.simpleFilter = simpleFilter;
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
        if (off < 0) goto L41;
        if (len < 0) goto L41;
        if ((off + len) < 0) goto L41;
        if ((off + len) > buf.length) goto L41;
        if (len != 0) goto L12;
        return 0;
    L12:
        if (this.in == null) goto L39;
        if (this.exception != null) goto L37;
        int size = 0;
    L42:
        int copySize = Math.min(this.filtered, len);     // Catch: IOException -> L19
        System.arraycopy(this.filterBuf, this.pos, buf, off, copySize);     // Catch: IOException -> L19
        this.pos += copySize;     // Catch: IOException -> L19
        this.filtered -= copySize;     // Catch: IOException -> L19
        off = off + copySize;     // Catch: IOException -> L19
        len = len - copySize;     // Catch: IOException -> L19
        size = size + copySize;     // Catch: IOException -> L19
        if (((this.pos + this.filtered) + this.unfiltered) != 4096) goto L22;
        System.arraycopy(this.filterBuf, this.pos, this.filterBuf, 0, this.filtered + this.unfiltered);     // Catch: IOException -> L19
        this.pos = 0;     // Catch: IOException -> L19
    L22:
        if (len == 0) goto L31;
        if (this.endReached == true) goto L31;
        int inSize = this.in.read(this.filterBuf, (this.pos + this.filtered) + this.unfiltered, 4096 - ((this.pos + this.filtered) + this.unfiltered));     // Catch: IOException -> L19
        if (inSize == (-1)) goto L28;
        this.unfiltered += inSize;     // Catch: IOException -> L19
        this.filtered = this.simpleFilter.code(this.filterBuf, this.pos, this.unfiltered);     // Catch: IOException -> L19
        this.unfiltered -= this.filtered;     // Catch: IOException -> L19
        goto L42
    L28:
        this.endReached = true;     // Catch: IOException -> L19
        this.filtered = this.unfiltered;     // Catch: IOException -> L19
        this.unfiltered = 0;     // Catch: IOException -> L19
    L31:
        if (size > 0) goto L33;
        return -1;
    L33:
        return size;
    L19:
        e = move-exception;
        this.exception = e;
        throw e;
    L37:
        throw this.exception;
    L39:
        throw new XZIOException("Stream closed");
    L41:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L11;
        if (this.exception != null) goto L9;
        return this.filtered;
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
