package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FilterOptions implements Cloneable {
    public abstract int getDecoderMemoryUsage();

    public abstract int getEncoderMemoryUsage();

    abstract FilterEncoder getFilterEncoder();

    public abstract InputStream getInputStream(InputStream r1, ArrayCache r2) throws IOException;

    public abstract FinishableOutputStream getOutputStream(FinishableOutputStream r1, ArrayCache r2);

    public static int getEncoderMemoryUsage(FilterOptions[] options) {
        int m = 0;
        int i = 0;
    L4:
        if (i >= options.length) goto L7;
        m = m + options[i].getEncoderMemoryUsage();
        i = i + 1;
        goto L4
    L7:
        return m;
    }

    public static int getDecoderMemoryUsage(FilterOptions[] options) {
        int m = 0;
        int i = 0;
    L4:
        if (i >= options.length) goto L7;
        m = m + options[i].getDecoderMemoryUsage();
        i = i + 1;
        goto L4
    L7:
        return m;
    }

    public FinishableOutputStream getOutputStream(FinishableOutputStream out) {
        return getOutputStream(out, ArrayCache.getDefaultCache());
    }

    public InputStream getInputStream(InputStream in) throws IOException {
        return getInputStream(in, ArrayCache.getDefaultCache());
    }

    FilterOptions() {
    }
}
