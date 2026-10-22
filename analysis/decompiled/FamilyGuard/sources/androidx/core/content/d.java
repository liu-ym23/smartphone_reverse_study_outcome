package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;

/* loaded from: classes.dex */
public final class d {
    public static int a(Context context, String str) {
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int b(Context context, String str, int i5, int i6, String str2) {
        if (context.checkPermission(str, i5, i6) == -1) {
            return -1;
        }
        String strC = androidx.core.app.e.c(str);
        if (strC == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i6);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i6 || !D.c.a(context.getPackageName(), str2)) ? androidx.core.app.e.b(context, strC, str2) : androidx.core.app.e.a(context, i6, strC, str2)) == 0 ? 0 : -2;
    }

    public static int c(Context context, String str) {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
