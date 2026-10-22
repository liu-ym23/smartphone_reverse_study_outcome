package com.stepos.pps.reflect;

import android.app.ActivityManager;
import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityManagerStepOS {
    private static final String TAG = "ActivityManagerStepOS";

    public static void forceKillProcess(int i) {
        try {
            Object iStepOSPermissionService = ReflectUtils.getIStepOSPermissionService();
            if (iStepOSPermissionService == null) {
                return;
            }
            ReflectCache.on(iStepOSPermissionService, "forceKillProcess", (Class<?>[]) new Class[]{Integer.TYPE}).invoke(Integer.valueOf(i));
            Log.d(TAG, "forceKillProcess pid: " + i);
        } catch (Exception e) {
            Log.e(TAG, "forceKillProcess exception: " + e);
        }
    }

    public static void addSuperWhitePkg(String str) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "addSuperWhitePkg", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            Log.w(TAG, "addSuperWhitePkg exception: ", e);
        }
    }

    public static void setActionIncludePkg(String str, String[] strArr) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "setActionIncludePkg", (Class<?>[]) new Class[]{String.class, String[].class}).invoke(str, strArr);
        } catch (Exception e) {
            Log.w(TAG, "setActionIncludePkg exception: ", e);
        }
    }

    public static void addExcludeAction(String str) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "addExcludeAction", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            Log.w(TAG, "addExcludeAction exception: ", e);
        }
    }

    public static void setActionExcludePkgToPkg(String str, String str2, String str3) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "setActionExcludePkgToPkg", (Class<?>[]) new Class[]{String.class, String.class, String.class}).invoke(str, str2, str3);
        } catch (Exception e) {
            Log.w(TAG, "setActionExcludePkgToPkg exception: ", e);
        }
    }

    public static void relaunchPackageBackground(String str, int i, boolean z) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "relaunchPackageBackground", (Class<?>[]) new Class[]{String.class, Integer.TYPE, Boolean.TYPE}).invoke(str, Integer.valueOf(i), Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w(TAG, "relaunchPackageBackground exception: ", e);
        }
    }

    public static void removeTask(int i) {
        try {
            Object iActivityManager = ReflectUtils.getIActivityManager();
            if (iActivityManager == null) {
                return;
            }
            ReflectCache.on(iActivityManager, "removeTask", (Class<?>[]) new Class[]{Integer.TYPE}).invoke(Integer.valueOf(i));
        } catch (Exception e) {
            Log.w(TAG, "removeTask exception: ", e);
        }
    }

    public static void forceStopPackage(Context context, String str) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceStopPackage", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            Log.e(TAG, "forceStopPackage exception: " + e);
        }
    }

    public static void forceStopPackage(Context context, String str, int i) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceStopPackageWithCloneID", (Class<?>[]) new Class[]{String.class, Integer.TYPE, Integer.TYPE}).invoke(str, Integer.valueOf(UserHandleStepOS.USER_CURRENT), Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "forceStopPackage exception: " + e);
        }
    }

    public static void forceStopPackageAsUser(Context context, String str, int i) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceStopPackageAsUser", (Class<?>[]) new Class[]{String.class, Integer.TYPE}).invoke(str, Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "forceStopPackageAsUser exception: " + e);
        }
    }

    public static void forceFreezePackage(Context context, String str) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceFreezePackage", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            Log.e(TAG, "forceFreezePackage exception: " + e);
        }
    }

    public static void forceFreeze(Context context, int i, int[] iArr, String str, String str2) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceFreeze", (Class<?>[]) new Class[]{Integer.TYPE, int[].class, String.class, String.class}).invoke(Integer.valueOf(i), iArr, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "forceFreeze exception: " + e);
        }
    }

    public static void forceUnfreeze(Context context, int i, int[] iArr, String str, String str2) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceUnfreeze", (Class<?>[]) new Class[]{Integer.TYPE, int[].class, String.class, String.class}).invoke(Integer.valueOf(i), iArr, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "forceUnfreeze exception: " + e);
        }
    }

    public static void forceFreezePackageAsUser(Context context, String str, int i) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceFreezePackageAsUser", (Class<?>[]) new Class[]{String.class, Integer.TYPE}).invoke(str, Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "forceFreezePackageAsUser exception: " + e);
        }
    }

    public static void forceUnfreezePackage(Context context, String str) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceUnfreezePackage", (Class<?>[]) new Class[]{String.class}).invoke(str);
        } catch (Exception e) {
            Log.e(TAG, "forceUnfreezePackage exception: " + e);
        }
    }

    public static boolean isUidRunning(Context context, int i) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            int size = runningAppProcesses != null ? runningAppProcesses.size() : 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (runningAppProcesses.get(i2).uid == i) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "isUidRunning exception: " + e);
        }
        return false;
    }

    public static void forceUnfreezePackageAsUser(Context context, String str, int i) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "forceUnfreezePackageAsUser", (Class<?>[]) new Class[]{String.class, Integer.TYPE}).invoke(str, Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "forceUnfreezePackageAsUser exception: " + e);
        }
    }

    public static void setPPSParameter(Context context, int i, String str, int i2) {
        try {
            ReflectCache.on((ActivityManager) context.getSystemService("activity"), "setPPSParameter", (Class<?>[]) new Class[]{Integer.TYPE, String.class, Integer.TYPE}).invoke(Integer.valueOf(i), str, Integer.valueOf(i2));
        } catch (Exception e) {
            Log.w(TAG, "setParameter exception: " + e);
        }
    }

    public static void configAalParameters(ActivityManager activityManager, int i, ArrayMap<String, Integer> arrayMap) {
        try {
            ReflectCache.on(activityManager, "configAalParameters", (Class<?>[]) new Class[]{Integer.TYPE, ArrayMap.class}).invoke(Integer.valueOf(i), arrayMap);
        } catch (Exception e) {
            Log.e(TAG, "configAalParameters exception: " + e);
        }
    }

    public static boolean isGuestMode() {
        Object objInvoke;
        Object objInvoke2;
        try {
            objInvoke = ReflectCache.on("android.app.ActivityManagerNative", "getDefault", (Class<?>[]) new Class[0]).invoke(new Object[0]);
        } catch (Exception e) {
            Log.e(TAG, "isGuestMode" + e.toString());
        }
        if (objInvoke == null || (objInvoke2 = ReflectCache.on(objInvoke, "getCurrentUser", (Class<?>[]) new Class[0]).invoke(new Object[0])) == null) {
            return false;
        }
        return ((Boolean) ReflectCache.on(objInvoke2, "isGuest", (Class<?>[]) new Class[0]).invoke(new Object[0])).booleanValue();
    }

    public static void setProcessLimit(int i) {
        try {
            Object objInvoke = ReflectCache.on("android.app.ActivityManagerNative", "getDefault", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            if (objInvoke == null) {
                return;
            }
            ReflectCache.on(objInvoke, "setProcessLimit", (Class<?>[]) new Class[]{Integer.TYPE}).invoke(Integer.valueOf(i));
        } catch (Exception e) {
            Log.e(TAG, "setProcessLimit exception " + e.toString());
        }
    }

    public static int getProcessLimit() {
        try {
            Object objInvoke = ReflectCache.on("android.app.ActivityManagerNative", "getDefault", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            if (objInvoke == null) {
                return -1;
            }
            return ((Integer) ReflectCache.on(objInvoke, "getProcessLimit", (Class<?>[]) new Class[0]).invoke(new Object[0])).intValue();
        } catch (Exception e) {
            Log.e(TAG, "getProcessLimit exception " + e.toString());
            return -1;
        }
    }

    public static void dismissSplitScreenMode() {
        try {
            ReflectCache.on(ReflectCache.on("android.app.ActivityManager", "getTaskService", (Class<?>[]) new Class[0]).invoke(new Object[0]), "dismissSplitScreenMode", (Class<?>[]) new Class[]{Boolean.TYPE}).invoke(false);
        } catch (Exception e) {
            Log.i(TAG, "getService: " + e);
        }
    }
}
