package b67;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static boolean a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        PackageInfo r102 = null;
    L11:
        if (r102 != null) goto L13;
        return false;
    L13:
        if (r102.applicationInfo.enabled == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: Exception -> L9
    L9:
        return false;
    }
}
