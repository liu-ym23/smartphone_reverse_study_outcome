package n6;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import f6.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22420a = "ttnet_debug_mode";

    static {
    }

    public static boolean a() {
        if (TTNetInit.ENV.RELEASE == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(Context r10) {
        if (a() == true) goto L6;
        Logger.d(f22420a, "debug_mode close");
        return;
    L6:
        d(r10);
    }

    public static void c() {
        Logger.setLogLevel(2);
        e.b(Logger.getLogLevel());
    }

    public static void d(Context r10) {
        Logger.d(f22420a, "debug_mode open");
        if (b.b(r10) == false) goto L6;
        c();
        return;
    }

    public static boolean e() {
        if (a() == true) goto L7;
        return false;
    L7:
        return b.c(TTNetInit.getTTNetDepend().getContext());
    }
}
