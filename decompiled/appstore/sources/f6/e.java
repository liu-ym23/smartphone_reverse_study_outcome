package f6;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19527a = 4;

    static {
    }

    public static void a(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f19527a > 3) goto L8;
        Log.d(r10, r11);
        return;
    }

    public static void b(int r10) {
        f19527a = r10;
    }
}
