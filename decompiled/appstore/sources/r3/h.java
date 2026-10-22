package r3;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f23729a;

    static {
        f23729a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r10) {
        f23729a.post(r10);
    }

    public static byte[] b(String r10) {
        if (r10 != null) goto L10;
    L8:
        return null;
    L10:
        if (r10.length() <= 0) goto L8;
        return r10.getBytes("UTF-8");
    L12:
        return r10.getBytes();
    }
}
