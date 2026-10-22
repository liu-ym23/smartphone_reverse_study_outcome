package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class IdentityInputStream extends InputStream {
    private boolean closed;
    private final SessionInputBuffer in;

    public IdentityInputStream(SessionInputBuffer r10) {
        this.closed = false;
        this.in = (SessionInputBuffer) Args.notNull(r10, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r10 = this.in;
        if ((r10 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return ((BufferInfo) r10).length();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == false) goto L6;
        return -1;
    L6:
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == false) goto L6;
        return -1;
    L6:
        return this.in.read(r10, r11, r12);
    }
}
