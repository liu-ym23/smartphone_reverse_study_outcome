package org.tukaani.xz;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class DeltaOutputStream extends FinishableOutputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private final org.tukaani.xz.delta.DeltaEncoder delta;
    private IOException exception;
    private final byte[] filterBuf;
    private boolean finished;
    private FinishableOutputStream out;
    private final byte[] tempBuf;

    static int getMemoryUsage() {
        return 5;
    }

    DeltaOutputStream(FinishableOutputStream out, DeltaOptions options) {
        this.filterBuf = new byte[4096];
        this.finished = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.out = out;
        this.delta = new org.tukaani.xz.delta.DeltaEncoder(options.getDistance());
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.tempBuf[0] = (byte) b;
        write(this.tempBuf, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        if (off < 0) goto L26;
        if (len < 0) goto L26;
        if ((off + len) < 0) goto L26;
        if ((off + len) > buf.length) goto L26;
        if (this.exception != null) goto L24;
        if (this.finished == true) goto L22;
    L13:
        if (len <= 4096) goto L17;
        this.delta.encode(buf, off, 4096, this.filterBuf);     // Catch: IOException -> L15
        this.out.write(this.filterBuf);     // Catch: IOException -> L15
        off = off + 4096;     // Catch: IOException -> L15
        len = len - 4096;     // Catch: IOException -> L15
    L15:
        e = move-exception;
        this.exception = e;
        throw e;
    L17:
        this.delta.encode(buf, off, len, this.filterBuf);     // Catch: IOException -> L15
        this.out.write(this.filterBuf, 0, len);     // Catch: IOException -> L15
        return;
    L22:
        throw new XZIOException("Stream finished");
    L24:
        throw this.exception;
    L26:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.exception != null) goto L14;
        if (this.finished == true) goto L12;
        this.out.flush();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        this.exception = e;
        throw e;
    L12:
        throw new XZIOException("Stream finished or closed");
    L14:
        throw this.exception;
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished == false) goto L5;
        return;
    L5:
        if (this.exception != null) goto L12;
        this.out.finish();     // Catch: IOException -> L8
        this.finished = true;
        return;
    L8:
        e = move-exception;
        this.exception = e;
        throw e;
    L12:
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out == null) goto L12;
        this.out.close();     // Catch: IOException -> L6
    L10:
        this.out = null;
    L6:
        e = move-exception;
        if (this.exception != null) goto L10;
        this.exception = e;
    L12:
        if (this.exception != null) goto L15;
        return;
    L15:
        throw this.exception;
    }
}
