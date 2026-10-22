package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtils {
    private static String sCurProcessName;

    static {
    }

    public ProcessUtils() {
    }

    public static String getCurProcessName(Context r1) {
        String r2 = sCurProcessName;
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        String r3 = getCurProcessNameFromProc();
        sCurProcessName = r3;
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder(32);     // Catch: Throwable -> L14
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L8;
        r0.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r1 = r0.toString();     // Catch: Throwable -> L14
        IoUtil.safeClose(r2);
        return r1;
    L12:
        IoUtil.safeClose(r2);
        return null;
    L11:
        r2 = null;
        goto L12
    }
}
