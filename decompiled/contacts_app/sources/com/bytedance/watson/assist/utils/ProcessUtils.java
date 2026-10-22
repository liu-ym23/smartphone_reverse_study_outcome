package com.bytedance.watson.assist.utils;

import android.os.Process;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtils {
    public static int MAIN_THREAD_ID = -1;

    static {
    }

    public ProcessUtils() {
    }

    private static ArrayList<Long> numericFolderItems(String r5) {
        ArrayList<Long> r0 = new ArrayList();
        File[] r6 = new File(r5).listFiles(new AnonymousClass1());
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(Long.valueOf(Long.parseLong(r6[r2].getName())));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static ArrayList<Long> threadListFromProcFs() {
        return numericFolderItems("/proc/self/task/");
    }

    public static int getMainThreadId() {
        if (MAIN_THREAD_ID != (-1)) goto L6;
        MAIN_THREAD_ID = Process.myPid();
    L6:
        return MAIN_THREAD_ID;
    }
}
