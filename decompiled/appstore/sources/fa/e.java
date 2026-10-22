package fa;

import android.app.Application;
import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static String a() {
        return Application.getProcessName();
    }

    public static boolean b(Context r10) {
        String r11 = a();
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.contains(":") == false) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r11.equals(r10.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
