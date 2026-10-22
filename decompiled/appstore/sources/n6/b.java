package n6;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22421a = "ttnet_debug_setting";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f22422b = "log_switcher";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f22423c = "x86_support";

    static {
    }

    public static String a(Context r10, String r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getSharedPreferences(f22421a, 0).getString(r11, null);
    }

    public static boolean b(Context r10) {
        return "true".equals(a(r10, f22422b));
    }

    public static boolean c(Context r10) {
        return "true".equals(a(r10, f22423c));
    }
}
