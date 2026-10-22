package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class UncompressedLZMA2OutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private boolean dictResetNeeded;
    private IOException exception;
    private boolean finished;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private final byte[] tempBuf;
    private final byte[] uncompBuf;
    private int uncompPos;

    static int getMemoryUsage() {
        return 70;
    }

    UncompressedLZMA2OutputStream(FinishableOutputStream out, ArrayCache arrayCache) {
        this.uncompPos = 0;
        this.dictResetNeeded = true;
        this.finished = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        if (out == null) goto L7;
        this.out = out;
        this.outData = new DataOutputStream(out);
        this.arrayCache = arrayCache;
        this.uncompBuf = arrayCache.getByteArray(65536, false);
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
        if (off < 0) goto L29;
        if (len < 0) goto L29;
        if ((off + len) < 0) goto L29;
        if ((off + len) > buf.length) goto L29;
        if (this.exception != null) goto L27;
        if (this.finished == true) goto L25;
    L12:
        if (len <= 0) goto L23;
        int copySize = Math.min(65536 - this.uncompPos, len);     // Catch: IOException -> L17
        System.arraycopy(buf, off, this.uncompBuf, this.uncompPos, copySize);     // Catch: IOException -> L17
        len = len - copySize;     // Catch: IOException -> L17
        this.uncompPos += copySize;     // Catch: IOException -> L17
        if (this.uncompPos != 65536) goto L12;
        writeChunk();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        this.exception = e;
        throw e;
    L23:
        return;
    L25:
        throw new XZIOException("Stream finished or closed");
    L27:
        throw this.exception;
    L29:
        throw new IndexOutOfBoundsException();
    }

    private void writeChunk() throws IOException {
        DataOutputStream r0 = this.outData;
        if (this.dictResetNeeded == false) goto L5;
        int r1 = 1;
    L6:
        r0.writeByte(r1);
        this.outData.writeShort(this.uncompPos - 1);
        this.outData.write(this.uncompBuf, 0, this.uncompPos);
        this.uncompPos = 0;
        this.dictResetNeeded = false;
        return;
    L5:
        r1 = 2;
        goto L6
    }

    private void writeEndMarker() throws IOException {
        if (this.exception != null) goto L19;
        if (this.finished == true) goto L17;
    L9:
        e = move-exception;
        this.exception = e;
        throw e;
    L7:
        if (this.uncompPos <= 0) goto L11;
        writeChunk();     // Catch: IOException -> L9
    L11:
        this.out.write(0);     // Catch: IOException -> L9
        this.finished = true;
        this.arrayCache.putArray(this.uncompBuf);
        return;
    L17:
        throw new XZIOException("Stream finished or closed");
    L19:
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.exception != null) goto L18;
        if (this.finished == true) goto L16;
    L9:
        e = move-exception;
        this.exception = e;
        throw e;
    L7:
        if (this.uncompPos <= 0) goto L11;
        writeChunk();     // Catch: IOException -> L9
    L11:
        this.out.flush();     // Catch: IOException -> L9
        return;
    L16:
        throw new XZIOException("Stream finished or closed");
    L18:
        throw this.exception;
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L10;
        writeEndMarker();
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
        writeEndMarker();     // Catch: IOException -> L8
    L18:
        if (this.exception != null) goto L21;
        return;
    L21:
        throw this.exception;
    }
}
