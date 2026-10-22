package o0;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f22462a = 2;

    static {
    }

    public static void a(String r10) {
        if (f22462a > 3) goto L6;
        Log.d("MediaSDK", r10);
        return;
    }

    public static void b(String r10) {
        if (f22462a > 5) goto L6;
        Log.e("MediaSDK", r10);
        return;
    }

    public static void c(String r10) {
        if (f22462a > 2) goto L6;
        Log.i("MediaSDK", r10);
        return;
    }

    public static void d(String r10) {
        if (f22462a > 4) goto L6;
        Log.w("MediaSDK", r10);
        return;
    }
}
