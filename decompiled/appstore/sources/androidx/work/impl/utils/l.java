package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5833a = null;

    static {
        f5833a = androidx.work.i.i("PackageManagerHelper");
    }

    public static void a(Context r10, Class r11, boolean r12) {
        String r13 = "disabled";
        PackageManager r14 = r10.getPackageManager();     // Catch: Exception -> L13
        ComponentName r15 = new ComponentName(r10, r11.getName());     // Catch: Exception -> L13
        if (r12 == false) goto L6;
        int r16 = 1;
    L7:
        r14.setComponentEnabledSetting(r15, r16, 1);     // Catch: Exception -> L13
        androidx.work.i r17 = androidx.work.i.e();     // Catch: Exception -> L13
        String r18 = f5833a;     // Catch: Exception -> L13
        StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L13
        r19.append(r11.getName());     // Catch: Exception -> L13
        r19.append(" ");     // Catch: Exception -> L13
        if (r12 == false) goto L10;
        String r20 = "enabled";
    L11:
        r19.append(r20);     // Catch: Exception -> L13
        r17.a(r18, r19.toString());     // Catch: Exception -> L13
        return;
    L10:
        r20 = "disabled";
        goto L11
    L6:
        r16 = 2;
    L13:
        e = move-exception;
        androidx.work.i r21 = androidx.work.i.e();
        String r22 = f5833a;
        StringBuilder r23 = new StringBuilder();
        r23.append(r11.getName());
        r23.append("could not be ");
        if (r12 == false) goto L17;
        r13 = "enabled";
    L17:
        r23.append(r13);
        r21.b(r22, r23.toString(), e);
    }
}
