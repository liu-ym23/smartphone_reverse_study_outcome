package p0;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static String a(Context r10) {
        String r11 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return "unknown";
    L11:
        return r11;
    L4:
        r11 = null;
        goto L6
    }
}
