package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZipEncodingHelper {
    static final String UTF8 = "UTF8";
    static final ZipEncoding UTF8_ZIP_ENCODING = null;

    public ZipEncodingHelper() {
    }

    static {
        UTF8_ZIP_ENCODING = getZipEncoding(UTF8);
    }

    public static ZipEncoding getZipEncoding(String name) {
        Charset cs = Charset.defaultCharset();
        if (name != null) goto L9;
    L7:
        boolean useReplacement = isUTF8(cs.name());
        return new NioZipEncoding(cs, useReplacement);
    L9:
        cs = Charset.forName(name);     // Catch: UnsupportedCharsetException -> L6
        goto L7
    }

    static boolean isUTF8(String charsetName) {
        if (charsetName != null) goto L5;
        charsetName = Charset.defaultCharset().name();
    L5:
        if (StandardCharsets.UTF_8.name().equalsIgnoreCase(charsetName) == false) goto L7;
        return true;
    L7:
        Iterator<String> r0 = StandardCharsets.UTF_8.aliases().iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        String alias = r0.next();
        if (alias.equalsIgnoreCase(charsetName) == false) goto L9;
        return true;
    L14:
        return false;
    }

    static ByteBuffer growBufferBy(ByteBuffer buffer, int increment) {
        buffer.limit(buffer.position());
        buffer.rewind();
        ByteBuffer on = ByteBuffer.allocate(buffer.capacity() + increment);
        on.put(buffer);
        return on;
    }
}
