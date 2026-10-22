package org.tukaani.xz;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
class CountingInputStream extends CloseIgnoringInputStream {
    private long size;

    public CountingInputStream(InputStream in) {
        super(in);
        this.size = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int ret = ((FilterInputStream) this).in.read();
        if (ret != (-1)) goto L5;
    L7:
        return ret;
    L5:
        if (this.size < 0) goto L7;
        this.size++;
        goto L7
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = ((FilterInputStream) this).in.read(b, off, len);
        if (ret > 0) goto L5;
    L7:
        return ret;
    L5:
        if (this.size < 0) goto L7;
        this.size += (long) ret;
        goto L7
    }

    public long getSize() {
        return this.size;
    }
}
