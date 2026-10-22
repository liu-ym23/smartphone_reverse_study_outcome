package com.slardaros.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SlardarUtil {
    public static final String COUNT = "count";
    public static final String TIME_START = "time_start";
    private static boolean sIsMainProcess = false;
    private static Boolean sIsTargetDevice;

    static {
    }

    public SlardarUtil() {
    }

    public static boolean isTargetDevice(Context r5) {
        Boolean r0 = sIsTargetDevice;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        Intent r2 = new Intent(Constants.SLARDAR_SERVICE_ACTION);
        List<ResolveInfo> r3 = null;
        if (r5 == null) goto L11;
        PackageManager r6 = r5.getPackageManager();
    L13:
        if (r6 == null) goto L15;
        r3 = r6.queryIntentServices(r2, 0);
    L16:
        if (r3 != null) goto L18;
    L20:
        OLog.d(Constants.TAG, "resolveInfoList is null or empty");
    L21:
        if (r3 != null) goto L23;
    L25:
        r1 = false;
    L26:
        Boolean r7 = Boolean.valueOf(r1);
        sIsTargetDevice = r7;
        return r7.booleanValue();
    L23:
        if (r3.size() != 1) goto L25;
    L18:
        if (r3.size() < 1) goto L20;
        OLog.d(Constants.TAG, "resolveInfoList size: " + r3.size() + " first name: " + r3.get(0).serviceInfo.packageName);
        goto L21
    L15:
        OLog.d(Constants.TAG, "packageManager is null");
        goto L16
    L11:
        r6 = null;
        goto L13
    L5:
        if (r0.booleanValue() != true) goto L8;
        return sIsTargetDevice.booleanValue();
    }

    public static String getProperty(String r7) {
        Method r1 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
        return (String) r1.invoke(null, new Object[]{r7});
    L5:
        e = move-exception;
        OLog.e(Constants.TAG, "getProperty failed!", e);
        return null;
    }

    public static int getPropertyInt(String r7, int r8) {
        Method r0 = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return ((Integer) r0.invoke(null, new Object[]{r7, Integer.valueOf(r8)})).intValue();
    L4:
        e = move-exception;
        OLog.e(Constants.TAG, "getPropertyInt failed!", e);
        return r8;
    }

    public static boolean checkArgsNotEmpty(String... r3) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (TextUtils.isEmpty(r3[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean checkReachLimit(Context r8, String r9) {
        SharedPreferences r10 = r8.getSharedPreferences(r9, 0);     // Catch: Exception -> L12
        long r4 = r10.getLong(TIME_START, 0);     // Catch: Exception -> L12
        int r11 = r10.getInt("count", 0);     // Catch: Exception -> L12
        if ((System.currentTimeMillis() - r4) <= 300000) goto L8;
        r10.edit().putLong(TIME_START, System.currentTimeMillis()).putInt("count", 1).apply();     // Catch: Exception -> L12
        return false;
    L8:
        if (r11 < 5) goto L10;
        return true;
    L10:
        r10.edit().putInt("count", r11 + 1).apply();     // Catch: Exception -> L12
        return false;
    L12:
        return true;
    }

    public static boolean isSystemDebuggable() {
        if (getPropertyInt("ro.debuggable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isAppInForeground(Context r4) {
        List<ActivityManager.RunningTaskInfo> r0 = ((ActivityManager) r4.getSystemService("activity")).getRunningTasks(1);
        if (r0.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.get(0).topActivity.getPackageName().equals(r4.getPackageName()) == false) goto L7;
        return true;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r3 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L16
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r5 = r4.read();     // Catch: Throwable -> L14
        if (r5 <= 0) goto L8;
        r2.append((char) r5);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r6 = r2.toString();     // Catch: Throwable -> L14
        r4.close();     // Catch: Exception -> L11
    L13:
        return r6;
    L11:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
    L14:
        th = th;
        r3 = r4;
    L38:
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + th.getMessage());     // Catch: Throwable -> L25
        if (r3 == null) goto L45;
        r3.close();     // Catch: Exception -> L21
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L21:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L45:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L25:
        th = move-exception;
        if (r3 != null) goto L36;
    L31:
        throw th;
    L36:
        r3.close();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        OLog.e(Constants.TAG, "getCurProcessNameFromProc: " + e.getMessage());
    L16:
        th = th;
        goto L38
    }

    public static boolean isMainProcess() {
        if (sIsMainProcess == false) goto L6;
        return true;
    L6:
        Context r0 = SlardarAgent.getContext();
        if (r0 == null) goto L9;
        String r1 = getCurProcessNameFromProc();
        if (r1.contains(SimContactsConstants.ANR_SEP) == false) goto L13;
        sIsMainProcess = false;
    L15:
        return sIsMainProcess;
    L13:
        sIsMainProcess = r1.equals(r0.getPackageName());
        goto L15
    L9:
        return isMainProcessSimple();
    }

    public static boolean isMainProcessSimple() {
        if (sIsMainProcess == false) goto L6;
        return true;
    L6:
        return !getCurProcessNameFromProc().contains(SimContactsConstants.ANR_SEP);
    }

    public static String getVersionCode(Context r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode + "";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
