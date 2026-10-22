package W2;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class b {
    public static byte[] a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            throw new Error("HttpClient requires ASCII support");
        }
    }
}
