package org.apache.http.impl.io;

import com.bytedanceos.common.ad.param.AdReportParam;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ChunkedOutputStream extends OutputStream {
    private final byte[] cache;
    private int cachePosition;
    private boolean closed;
    private final SessionOutputBuffer out;
    private boolean wroteLastChunk;

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer r10, int r11) throws IOException {
        this(r11, r10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L6;
        this.closed = true;
        finish();
        this.out.flush();
        return;
    }

    public void finish() throws IOException {
        if (this.wroteLastChunk == true) goto L6;
        flushCache();
        writeClosingChunk();
        this.wroteLastChunk = true;
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushCache();
        this.out.flush();
    }

    public void flushCache() throws IOException {
        int r10 = this.cachePosition;
        if (r10 <= 0) goto L6;
        this.out.writeLine(Integer.toHexString(r10));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.writeLine("");
        this.cachePosition = 0;
        return;
    }

    public void flushCacheWithAppend(byte[] r10, int r11, int r12) throws IOException {
        this.out.writeLine(Integer.toHexString(this.cachePosition + r12));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(r10, r11, r12);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    @Override // java.io.OutputStream
    public void write(int r10) throws IOException {
        if (this.closed == true) goto L9;
        byte[] r11 = this.cache;
        int r12 = this.cachePosition;
        r11[r12] = (byte) r10;
        int r13 = r12 + 1;
        this.cachePosition = r13;
        if (r13 != r11.length) goto L10;
        flushCache();
        return;
    L10:
        return;
    L9:
        throw new IOException("Attempted write to closed stream.");
    }

    public void writeClosingChunk() throws IOException {
        this.out.writeLine(AdReportParam.ClickPosType.SKIP);
        this.out.writeLine("");
    }

    @Deprecated
    public ChunkedOutputStream(SessionOutputBuffer r10) throws IOException {
        this(2048, r10);
    }

    public ChunkedOutputStream(int r10, SessionOutputBuffer r11) {
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.closed = false;
        this.cache = new byte[r10];
        this.out = r11;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10) throws IOException {
        write(r10, 0, r10.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == true) goto L10;
        byte[] r13 = this.cache;
        int r14 = r13.length;
        int r15 = this.cachePosition;
        if (r12 < (r14 - r15)) goto L7;
        flushCacheWithAppend(r10, r11, r12);
        return;
    L7:
        System.arraycopy(r10, r11, r13, r15, r12);
        this.cachePosition += r12;
        return;
    L10:
        throw new IOException("Attempted write to closed stream.");
    }
}
