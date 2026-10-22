package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class MultiInputStream extends InputStream {
    private InputStream in;
    private Iterator<? extends ByteSource> it;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> r1) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(r1);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r0 = this.in;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.close();     // Catch: Throwable -> L7
        this.in = null;
        return;
    L7:
        th = move-exception;
        this.in = null;
        throw th;
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext() == false) goto L6;
        this.in = this.it.next().openStream();
        return;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream r0 = this.in;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream r0 = this.in;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r1 = r0.read();
        if (r1 != (-1)) goto L9;
        advance();
        return read();
    L9:
        return r1;
    }

    @Override // java.io.InputStream
    public int read(@Nullable byte[] r3, int r4, int r5) throws IOException {
        InputStream r0 = this.in;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r1 = r0.read(r3, r4, r5);
        if (r1 != (-1)) goto L9;
        advance();
        return read(r3, r4, r5);
    L9:
        return r1;
    }

    @Override // java.io.InputStream
    public long skip(long r6) throws IOException {
        InputStream r0 = this.in;
        if (r0 != null) goto L5;
    L15:
        return 0;
    L5:
        if (r6 <= 0) goto L15;
        long r3 = r0.skip(r6);
        if (r3 == 0) goto L11;
        return r3;
    L11:
        if (read() != (-1)) goto L14;
        return 0;
    L14:
        return this.in.skip(r6 - 1) + 1;
    }
}
