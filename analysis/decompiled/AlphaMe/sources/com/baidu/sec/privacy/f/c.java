package com.baidu.sec.privacy.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f9445a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f9446b = false;

    /* renamed from: c, reason: collision with root package name */
    public static long f9447c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9448d = false;

    public static void a(Throwable th) {
    }

    public static boolean b(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            if (!e.a(context, new String[]{"android.permission.GET_TASKS"})) {
                return true;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
            if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                return false;
            }
            return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean d(Context context) {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
        } catch (Throwable th) {
            a(th);
        }
        if (jCurrentTimeMillis - f9447c < 1000) {
            return f9448d;
        }
        f9448d = c(context) && a(context);
        f9447c = jCurrentTimeMillis;
        return f9448d;
    }

    public static boolean a(Context context) {
        String[] strArr;
        try {
            if (f9445a) {
                return f9446b;
            }
            if (context == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static void a(boolean z4) {
        f9445a = true;
        f9446b = z4;
    }
}
