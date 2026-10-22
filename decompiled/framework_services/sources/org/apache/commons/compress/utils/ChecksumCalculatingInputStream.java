package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
public class ChecksumCalculatingInputStream extends InputStream {
    private final Checksum checksum;
    private final InputStream in;

    public ChecksumCalculatingInputStream(Checksum checksum, InputStream in) {
        if (checksum == null) goto L10;
        if (in == null) goto L8;
        this.checksum = checksum;
        this.in = in;
        return;
    L8:
        throw new NullPointerException("Parameter in must not be null");
    L10:
        throw new NullPointerException("Parameter checksum must not be null");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = this.in.read();
        if (ret < 0) goto L5;
        this.checksum.update(ret);
    L5:
        return ret;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = this.in.read(b, off, len);
        if (ret < 0) goto L5;
        this.checksum.update(b, off, ret);
    L5:
        return ret;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (read() < 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public long getValue() {
        return this.checksum.getValue();
    }
}
