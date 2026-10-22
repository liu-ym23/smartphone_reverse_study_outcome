package o1;

import android.os.Handler;
import android.os.Looper;
import java.io.UnsupportedEncodingException;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1755a {
    static {
        new Handler(Looper.getMainLooper());
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() > 0) {
                return str.getBytes("UTF-8");
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }
}
