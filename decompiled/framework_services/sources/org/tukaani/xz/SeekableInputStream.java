package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SeekableInputStream extends InputStream {
    public abstract long length() throws IOException;

    public abstract long position() throws IOException;

    public abstract void seek(long r1) throws IOException;

    public SeekableInputStream() {
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (n > 0) goto L5;
        return 0;
    L5:
        long size = length();
        long pos = position();
        if (pos < size) goto L9;
        return 0;
    L9:
        if ((size - pos) >= n) goto L11;
        n = size - pos;
    L11:
        seek(pos + n);
        return n;
    }
}
