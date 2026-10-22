package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public class CharsetUtils {
    public CharsetUtils() {
    }

    public static Charset get(String r10) throws UnsupportedEncodingException {
        if (r10 != null) goto L9;
        return null;
    L9:
        return Charset.forName(r10);
    L8:
        throw new UnsupportedEncodingException(r10);
    }

    public static Charset lookup(String r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return Charset.forName(r10);
    L7:
        return null;
    }
}
