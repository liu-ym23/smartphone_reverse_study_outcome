package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class IdentityOutputStream extends OutputStream {
    private boolean closed;
    private final SessionOutputBuffer out;

    public IdentityOutputStream(SessionOutputBuffer r10) {
        this.closed = false;
        this.out = (SessionOutputBuffer) Args.notNull(r10, "Session output buffer");
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
        if (this.closed == true) goto L7;
        this.out.write(r10, r11, r12);
        return;
    L7:
        throw new IOException("Attempted write to closed stream.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10) throws IOException {
        write(r10, 0, r10.length);
    }

    @Override // java.io.OutputStream
    public void write(int r10) throws IOException {
        if (this.closed == true) goto L7;
        this.out.write(r10);
        return;
    L7:
        throw new IOException("Attempted write to closed stream.");
    }
}
