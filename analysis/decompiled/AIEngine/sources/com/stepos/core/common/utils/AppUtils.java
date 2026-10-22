package com.stepos.core.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import l7.a;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppUtils {
    public static final AppUtils INSTANCE = new AppUtils();
    private static final String TAG = "AppUtils";

    private AppUtils() {
    }

    public final String getCallerPackage() {
        return getCallerPackage(Binder.getCallingUid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isCallerForeground(int i10) {
        try {
            Context context = a.f10344a;
            if (context == null) {
                throw new IllegalStateException("ContextHolder must be initialized before use!");
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = null;
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
            if (runningAppProcesses != null) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((ActivityManager.RunningAppProcessInfo) next).uid == i10) {
                        runningAppProcessInfo = next;
                        break;
                    }
                }
                runningAppProcessInfo = runningAppProcessInfo;
            }
            return runningAppProcessInfo != null && runningAppProcessInfo.importance <= 200;
        } catch (Exception e10) {
            Log.w(TAG, "isCallerForeground failed: " + e10.getMessage(), e10);
            return false;
        }
    }

    public final String getCallerPackage(int i10) {
        String str;
        try {
            Context context = a.f10344a;
            if (context == null) {
                throw new IllegalStateException("ContextHolder must be initialized before use!");
            }
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i10);
            return (packagesForUid == null || (str = (String) l.e0(packagesForUid)) == null) ? "unknown" : str;
        } catch (Exception e10) {
            Log.w(TAG, "getCallerPackage failed: " + e10.getMessage(), e10);
            return "unknown";
        }
    }

    public final boolean isCallerForeground() {
        return isCallerForeground(Binder.getCallingUid());
    }
}
