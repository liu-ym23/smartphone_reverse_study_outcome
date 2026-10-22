package o8;

import java.io.InputStream;
import java.net.HttpURLConnection;
import p8.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void a(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        InputStream r11 = b(r10);
        if (r11 != null) goto L12;
        return;
    L12:
        r11.close();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        b.i("CommonHttpUtils", "close http connection inputstream exception : " + e.getMessage());
    }

    public static InputStream b(HttpURLConnection r10) {
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getInputStream();
    L8:
        return r10.getErrorStream();
    }
}
