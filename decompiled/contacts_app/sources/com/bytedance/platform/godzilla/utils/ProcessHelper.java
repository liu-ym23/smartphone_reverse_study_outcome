package com.bytedance.platform.godzilla.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessHelper {
    private static String sCurrentProcessName;

    private ProcessHelper() {
    }

    public static String getCurrentProcessName(Context r3) {
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L5;
        int r0 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L8:
        if (r4.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();     // Catch: Exception -> L13
        if (r1.pid != r0) goto L8;
        sCurrentProcessName = r1.processName;     // Catch: Exception -> L13
        return r1.processName;
    L15:
        String r5 = getCurProcessNameFromProc();
        sCurrentProcessName = r5;
        return r5;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return sCurrentProcessName;
    }

    public static boolean isMainProcess(Context r3) {
        String r0 = getCurrentProcessName(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(SimContactsConstants.ANR_SEP) == false) goto L7;
        return false;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r0.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r1 = r0.toString();     // Catch: Throwable -> L16
        r2.close();     // Catch: Exception -> L15
    L10:
        return r1;
    L12:
        if (r2 != null) goto L22;
    L14:
        return null;
    L22:
        r2.close();     // Catch: Exception -> L17
    L11:
        r2 = null;
        goto L12
    }
}
