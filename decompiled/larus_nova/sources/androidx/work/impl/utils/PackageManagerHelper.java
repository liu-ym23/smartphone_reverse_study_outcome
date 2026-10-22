package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class PackageManagerHelper {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("PackageManagerHelper");
    }

    private PackageManagerHelper() {
    }

    public static boolean isComponentExplicitlyEnabled(Context r100, String r101) {
        if (r100.getPackageManager().getComponentEnabledSetting(new ComponentName(r100, r101)) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isComponentExplicitlyEnabled(Context r100, Class<?> r101) {
        return isComponentExplicitlyEnabled(r100, r101.getName());
    }

    public static void setComponentEnabled(Context r100, Class<?> r110, boolean r111) {
        String r101 = "enabled";
        PackageManager r102 = r100.getPackageManager();     // Catch: Exception -> L13
        ComponentName r103 = new ComponentName(r100, r110.getName());     // Catch: Exception -> L13
        if (r111 == false) goto L6;
        int r104 = 1;
    L7:
        r102.setComponentEnabledSetting(r103, r104, 1);     // Catch: Exception -> L13
        Logger r105 = Logger.get();     // Catch: Exception -> L13
        String r106 = TAG;     // Catch: Exception -> L13
        Object[] r107 = new Object[2];     // Catch: Exception -> L13
        r107[0] = r110.getName();     // Catch: Exception -> L13
        if (r111 == false) goto L10;
        Object r108 = "enabled";
    L11:
        r107[1] = r108;     // Catch: Exception -> L13
        r105.debug(r106, String.format("%s %s", r107), new Throwable[0]);     // Catch: Exception -> L13
        return;
    L10:
        r108 = "disabled";
        goto L11
    L6:
        r104 = 2;
    L13:
        e = move-exception;
        Logger r109 = Logger.get();
        String r112 = TAG;
        Object[] r113 = new Object[2];
        r113[0] = r110.getName();
        if (r111 == true) goto L18;
        r101 = "disabled";
    L18:
        r113[1] = r101;
        r109.debug(r112, String.format("%s could not be %s", r113), new Throwable[]{e});
    }
}
