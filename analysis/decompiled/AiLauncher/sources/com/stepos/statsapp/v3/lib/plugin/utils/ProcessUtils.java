package com.stepos.statsapp.v3.lib.plugin.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ProcessUtils {
    public static String sCurrentProcessName;

    public static String getCurrentProcessName(Context context) throws Throwable {
        if (!TextUtils.isEmpty(sCurrentProcessName)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        sCurrentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        sCurrentProcessName = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByProcFile = getCurrentProcessNameByProcFile();
        sCurrentProcessName = currentProcessNameByProcFile;
        if (!TextUtils.isEmpty(currentProcessNameByProcFile)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        sCurrentProcessName = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    private static String getCurrentProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    private static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameByApplication() {
        return Application.getProcessName();
    }

    private static String getCurrentProcessNameByProcFile() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String str;
        IOException e10;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + Process.myPid() + "/cmdline"))));
            } catch (Exception e11) {
                e = e11;
                str = null;
            }
        } catch (Throwable th2) {
            bufferedReader = bufferedReader2;
            th = th2;
        }
        try {
            line = bufferedReader.readLine();
            if (line != null) {
                line = line.trim();
            }
            try {
                bufferedReader.close();
                return line;
            } catch (IOException e12) {
                e10 = e12;
                e10.printStackTrace();
                return line;
            }
        } catch (Exception e13) {
            e = e13;
            str = null;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 == null) {
                return str;
            }
            try {
                bufferedReader2.close();
                return str;
            } catch (IOException e14) {
                String str2 = str;
                e10 = e14;
                line = str2;
                e10.printStackTrace();
                return line;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            throw th;
        }
    }
}
