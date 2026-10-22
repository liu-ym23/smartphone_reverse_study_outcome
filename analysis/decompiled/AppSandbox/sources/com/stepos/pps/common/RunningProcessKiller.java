package com.stepos.pps.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.reflect.ActivityManagerStepOS;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RunningProcessKiller {
    private static final String TAG = "RunningProcessKiller";

    private boolean isSystemUid(int i) {
        return i >= 0 && i < 10000;
    }

    public void forceStopAllRunningApps(Context context, ArrayList<String> arrayList, boolean z) {
        Log.d(TAG, "forceStopAllRunningApps ");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        int size = runningAppProcesses != null ? runningAppProcesses.size() : 0;
        String defaultInputMethodPackage = getDefaultInputMethodPackage(context);
        for (int i = 0; i < size; i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (!isSystemUid(runningAppProcessInfo.uid) && !isSystemApp(context.getPackageManager(), runningAppProcessInfo.pkgList) && (runningAppProcessInfo.importance != 100 || z)) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if ((arrayList == null || !arrayList.contains(str)) && !isInputMethodPackage(str, defaultInputMethodPackage)) {
                        Log.w(TAG, "forceStopAllRunningApps " + str);
                        ActivityManagerStepOS.forceStopPackage(context, str);
                    }
                }
            }
        }
    }

    private String getDefaultInputMethodPackage(Context context) {
        String[] strArrSplit;
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        if (!TextUtils.isEmpty(string) && (strArrSplit = string.split("/")) != null && strArrSplit.length > 0) {
            return strArrSplit[0];
        }
        return "";
    }

    private boolean isInputMethodPackage(String str, String str2) {
        return str.equalsIgnoreCase(str2);
    }

    private boolean isSystemApp(PackageManager packageManager, String[] strArr) {
        for (String str : strArr) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Package not found: " + str, e);
            }
            if ((packageManager.getApplicationInfo(str, 0).flags & 1) != 0) {
                return true;
            }
        }
        return false;
    }
}
