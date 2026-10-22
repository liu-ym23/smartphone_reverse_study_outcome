package com.bytedanceos.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.BaseApplication;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionUtil {
    private static final String TAG = "PermissionUtil";

    public PermissionUtil() {
    }

    public static boolean checkNetWork() {
        String r10 = BaseApplication.c().getPackageName();     // Catch: Exception -> L15
        ApplicationInfo r11 = BaseApplication.c().getPackageManager().getApplicationInfo(r10, 0);     // Catch: Exception -> L15
        Class<?> r12 = Class.forName("bytedanceos.api.SmtOpsManagerSmt");     // Catch: Exception -> L15
        Method r13 = r12.getDeclaredMethod("getInstance", null);     // Catch: Exception -> L15
        int r14 = r12.getDeclaredField("OP_NET_MOBILE").getInt(null);     // Catch: Exception -> L15
        int r15 = r12.getDeclaredField("OP_NET_WIFI").getInt(null);     // Catch: Exception -> L15
        Class r16 = Integer.TYPE;     // Catch: Exception -> L15
        Method r17 = r12.getDeclaredMethod("checkOp", new Class[]{Context.class, r16, r16, String.class});     // Catch: Exception -> L15
        int r18 = ((Integer) r17.invoke(r13, new Object[]{BaseApplication.c(), Integer.valueOf(r14), Integer.valueOf(r11.uid), r10})).intValue();     // Catch: Exception -> L15
        int r19 = ((Integer) r17.invoke(r13, new Object[]{BaseApplication.c(), Integer.valueOf(r15), Integer.valueOf(r11.uid), r10})).intValue();     // Catch: Exception -> L15
        if (r18 != 0) goto L6;
        boolean r20 = true;
    L7:
        if (r19 != 0) goto L9;
        boolean r21 = true;
    L10:
        if (r20 == true) goto L20;
        if (r21 == false) goto L14;
        return true;
    L14:
        return false;
    L20:
        return true;
    L9:
        r21 = false;
        goto L10
    L6:
        r20 = false;
    L15:
        e = move-exception;
        e.printStackTrace();
        com.bytedanceos.common.toolbox.j.b("checkNetworkSelfPermission ex=" + e.getMessage());
        return true;
    }

    public static void enableNotification(Context r10) {
    }

    public static void requestNotificationPermission(Activity r10) {
        if (Build.VERSION.SDK_INT < 33) goto L11;
        if (ContextCompat.a(r10, "android.permission.POST_NOTIFICATIONS") == (-1)) goto L7;
        return;
    L7:
        if (ActivityCompat.t(r10, "android.permission.POST_NOTIFICATIONS") == true) goto L9;
        enableNotification(r10);
        return;
    L9:
        ActivityCompat.q(r10, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
        return;
    L11:
        if (NotificationManagerCompat.b(r10).a() == true) goto L17;
        enableNotification(r10);
        return;
    }
}
