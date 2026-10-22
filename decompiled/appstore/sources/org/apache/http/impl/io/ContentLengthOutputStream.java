package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class ContentLengthOutputStream extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStream(SessionOutputBuffer r10, long r11) {
        this.out = (SessionOutputBuffer) Args.notNull(r10, "Session output buffer");
        this.contentLength = Args.notNegative(r11, "Content length");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L6;
        this.closed = true;
        this.out.flush();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == true) goto L12;
        long r13 = this.total;
        long r14 = this.contentLength;
        if (r13 >= r14) goto L13;
        long r15 = r14 - r13;
        if (r12 <= r15) goto L9;
        r12 = (int) r15;
    L9:
        this.out.write(r10, r11, r12);
        this.total += (long) r12;
        return;
    L13:
        return;
    L12:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10) throws IOException {
        write(r10, 0, r10.length);
    }

    @Override // java.io.OutputStream
    public void write(int r10) throws IOException {
        if (this.closed == true) goto L9;
        if (this.total >= this.contentLength) goto L10;
        this.out.write(r10);
        this.total++;
        return;
    L10:
        return;
    L9:
        throw new IOException("Attempted write to closed stream.");
    }
}
