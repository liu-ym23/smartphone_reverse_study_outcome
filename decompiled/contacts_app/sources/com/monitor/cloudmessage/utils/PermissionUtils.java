package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionUtils {
    public PermissionUtils() {
    }

    public static boolean checkSelfPermission(Context r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return false;
    L8:
        if (r3.checkPermission(r4, Process.myPid(), Process.myUid()) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isGrantSDCardWritePermission(Context r1) {
        return checkSelfPermission(r1, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
