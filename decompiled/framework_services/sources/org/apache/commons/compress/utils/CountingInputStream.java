package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class CountingInputStream extends FilterInputStream {
    private long bytesRead;

    public CountingInputStream(InputStream in) {
        super(in);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r = ((FilterInputStream) this).in.read();
        if (r < 0) goto L5;
        count(1);
    L5:
        return r;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int r = ((FilterInputStream) this).in.read(b, off, len);
        if (r < 0) goto L5;
        count(r);
    L5:
        return r;
    }

    protected final void count(long read) {
        if (read == (-1)) goto L6;
        this.bytesRead += read;
        return;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }
}
