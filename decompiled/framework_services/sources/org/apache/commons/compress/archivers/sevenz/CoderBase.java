package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
abstract class CoderBase {
    private static final byte[] NONE = null;
    private final Class<?>[] acceptableOptions;

    abstract InputStream decode(String r1, InputStream r2, long r3, Coder r5, byte[] r6) throws IOException;

    static {
        NONE = new byte[0];
    }

    protected CoderBase(Class<?>... acceptableOptions) {
        this.acceptableOptions = acceptableOptions;
    }

    boolean canAcceptOptions(Object opts) {
        Class<?>[] r0 = this.acceptableOptions;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        Class<?> c = r0[r3];
        if (c.isInstance(opts) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    byte[] getOptionsAsProperties(Object options) throws IOException {
        return NONE;
    }

    Object getOptionsFromCoder(Coder coder, InputStream in) throws IOException {
        return null;
    }

    OutputStream encode(OutputStream out, Object options) throws IOException {
        throw new UnsupportedOperationException("method doesn't support writing");
    }

    protected static int numberOptionOrDefault(Object options, int defaultValue) {
        if ((options instanceof Number) == false) goto L6;
        return ((Number) options).intValue();
    L6:
        return defaultValue;
    }
}
