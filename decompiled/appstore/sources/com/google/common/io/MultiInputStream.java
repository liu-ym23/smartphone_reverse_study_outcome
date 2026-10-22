package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class MultiInputStream extends InputStream {

    @NullableDecl
    private InputStream in;
    private Iterator<? extends ByteSource> it;

    public MultiInputStream(Iterator<? extends ByteSource> r10) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(r10);
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext() == false) goto L6;
        this.in = this.it.next().openStream();
        return;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream r10 = this.in;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r10 = this.in;
        if (r10 != null) goto L11;
        return;
    L11:
        r10.close();     // Catch: Throwable -> L7
        this.in = null;
        return;
    L7:
        th = move-exception;
        this.in = null;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
    L2:
        InputStream r10 = this.in;
        if (r10 == null) goto L8;
        int r11 = r10.read();
        if (r11 != (-1)) goto L6;
        advance();
        goto L2
    L6:
        return r11;
    L8:
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long r10) throws IOException {
        InputStream r11 = this.in;
        if (r11 != null) goto L5;
    L15:
        return 0;
    L5:
        if (r10 <= 0) goto L15;
        long r12 = r11.skip(r10);
        if (r12 == 0) goto L11;
        return r12;
    L11:
        if (read() != (-1)) goto L14;
        return 0;
    L14:
        return this.in.skip(r10 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(@NullableDecl byte[] r10, int r11, int r12) throws IOException {
    L2:
        InputStream r13 = this.in;
        if (r13 == null) goto L8;
        int r14 = r13.read(r10, r11, r12);
        if (r14 != (-1)) goto L6;
        advance();
        goto L2
    L6:
        return r14;
    L8:
        return -1;
    }
}
