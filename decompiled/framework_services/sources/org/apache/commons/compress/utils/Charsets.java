package org.apache.commons.compress.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class Charsets {
    public static final Charset ISO_8859_1 = null;
    public static final Charset US_ASCII = null;
    public static final Charset UTF_16 = null;
    public static final Charset UTF_16BE = null;
    public static final Charset UTF_16LE = null;
    public static final Charset UTF_8 = null;

    public Charsets() {
    }

    public static Charset toCharset(Charset charset) {
        if (charset != null) goto L5;
        return Charset.defaultCharset();
    L5:
        return charset;
    }

    public static Charset toCharset(String charset) {
        if (charset != null) goto L5;
        return Charset.defaultCharset();
    L5:
        return Charset.forName(charset);
    }

    static {
        ISO_8859_1 = StandardCharsets.ISO_8859_1;
        US_ASCII = StandardCharsets.US_ASCII;
        UTF_16 = StandardCharsets.UTF_16;
        UTF_16BE = StandardCharsets.UTF_16BE;
        UTF_16LE = StandardCharsets.UTF_16LE;
        UTF_8 = StandardCharsets.UTF_8;
    }
}
