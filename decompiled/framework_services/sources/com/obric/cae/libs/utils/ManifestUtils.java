package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r4, Class<?> r5) {
        ServiceInfo r6 = r4.getPackageManager().getServiceInfo(new ComponentName(r4, r5), 0);     // Catch: ReflectiveOperationException -> L7 PackageManager.NameNotFoundException -> L9
        int r7 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: ReflectiveOperationException -> L7 PackageManager.NameNotFoundException -> L9 NoSuchFieldException -> L11
    L13:
    L15:
        if ((r6.flags & r7) == 0) goto L22;
        return true;
    L22:
        return false;
    L12:
        r7 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: ReflectiveOperationException -> L7 PackageManager.NameNotFoundException -> L9
    L24:
        return false;
    L23:
        return false;
    }
}
