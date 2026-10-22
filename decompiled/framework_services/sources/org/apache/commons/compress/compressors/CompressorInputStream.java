package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CompressorInputStream extends InputStream {
    private long bytesRead;

    public CompressorInputStream() {
        this.bytesRead = 0;
    }

    protected void count(int read) {
        count(read);
    }

    protected void count(long read) {
        if (read == (-1)) goto L6;
        this.bytesRead += read;
        return;
    }

    protected void pushedBackBytes(long pushedBack) {
        this.bytesRead -= pushedBack;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }
}
