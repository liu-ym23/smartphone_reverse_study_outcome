package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.simple.SimpleFilter;

/* JADX INFO: loaded from: classes3.dex */
class SimpleOutputStream extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FILTER_BUF_SIZE = 4096;
    private IOException exception;
    private final byte[] filterBuf;
    private boolean finished;
    private FinishableOutputStream out;
    private int pos;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf;
    private int unfiltered;

    static {
    }

    static int getMemoryUsage() {
        return 5;
    }

    SimpleOutputStream(FinishableOutputStream out, SimpleFilter simpleFilter) {
        this.filterBuf = new byte[4096];
        this.pos = 0;
        this.unfiltered = 0;
        this.exception = null;
        this.finished = false;
        this.tempBuf = new byte[1];
        if (out == null) goto L7;
        this.out = out;
        this.simpleFilter = simpleFilter;
        return;
    L7:
        throw new NullPointerException();
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0) goto L28;
        if (len < 0) goto L28;
        if ((off + len) < 0) goto L28;
        if ((off + len) > buf.length) goto L28;
        if (this.exception != null) goto L26;
        if (this.finished == true) goto L24;
    L12:
        if (len <= 0) goto L22;
        int copySize = Math.min(len, 4096 - (this.pos + this.unfiltered));
        System.arraycopy(buf, off, this.filterBuf, this.pos + this.unfiltered, copySize);
        off = off + copySize;
        len = len - copySize;
        this.unfiltered += copySize;
        int filtered = this.simpleFilter.code(this.filterBuf, this.pos, this.unfiltered);
        this.unfiltered -= filtered;
        this.out.write(this.filterBuf, this.pos, filtered);     // Catch: IOException -> L19
        this.pos += filtered;
        if ((this.pos + this.unfiltered) != 4096) goto L12;
        System.arraycopy(this.filterBuf, this.pos, this.filterBuf, 0, this.unfiltered);
        this.pos = 0;
    L19:
        e = move-exception;
        this.exception = e;
        throw e;
    L22:
        return;
    L24:
        throw new XZIOException("Stream finished or closed");
    L26:
        throw this.exception;
    L28:
        throw new IndexOutOfBoundsException();
    }

    private void writePending() throws IOException {
        if (this.exception != null) goto L11;
        this.out.write(this.filterBuf, this.pos, this.unfiltered);     // Catch: IOException -> L7
        this.finished = true;
        return;
    L7:
        e = move-exception;
        this.exception = e;
        throw e;
    L11:
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw new UnsupportedOptionsException("Flushing is not supported");
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L10;
        writePending();
        this.out.finish();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.exception = e;
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out == null) goto L18;
        if (this.finished == false) goto L24;
    L22:
        this.out.close();     // Catch: IOException -> L12
    L16:
        this.out = null;
    L12:
        e = move-exception;
        if (this.exception != null) goto L16;
        this.exception = e;
        goto L16
    L24:
        writePending();     // Catch: IOException -> L8
    L18:
        if (this.exception != null) goto L21;
        return;
    L21:
        throw this.exception;
    }
}
