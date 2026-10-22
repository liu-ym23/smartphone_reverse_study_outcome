package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class SkipShieldingInputStream extends FilterInputStream {
    private static final byte[] SKIP_BUFFER = null;
    private static final int SKIP_BUFFER_SIZE = 8192;

    static {
        SKIP_BUFFER = new byte[8192];
    }

    public SkipShieldingInputStream(InputStream in) {
        super(in);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) throws IOException {
        if (n >= 0) goto L6;
        return 0;
    L6:
        return read(SKIP_BUFFER, 0, (int) Math.min(n, 8192));
    }
}
