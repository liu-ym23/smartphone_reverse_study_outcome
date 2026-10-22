package com.bytedance.android.livesdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class s {
    public static boolean a(Context r100) {
        if (r100 != null) goto L23;
        return false;
    L23:
        String r101 = r100.getPackageName();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r101) == true) goto L28;
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Throwable -> L22
    L10:
        if (r102.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();     // Catch: Throwable -> L22
        if (r101.equals(r103.processName) == false) goto L10;
        if (r103.importance != 100) goto L29;
        int r104 = r103.importanceReasonCode;     // Catch: Throwable -> L22
        if (r104 != 2) goto L19;
        return false;
    L19:
        if (r104 == 1) goto L31;
        return true;
    L31:
        return false;
    L29:
        return false;
    L33:
        return false;
    L28:
        return false;
    L32:
        return false;
    }
}
