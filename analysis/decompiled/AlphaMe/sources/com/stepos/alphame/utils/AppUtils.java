package com.stepos.alphame.utils;

import B0.g;
import android.app.ActivityManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.util.UTF8Decoder;
import com.stepos.alphame.AppData;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.reflect.SmsApplicationStepos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppUtils {
    private static final int APP_ICON_ID = -1;
    private static final boolean DEBUG = false;
    private static final int MAX_RECENT_TASKS = 100;
    private static final String RECENT_LOCK_SAVED_APPS = "recent_lock_apps";
    private static final String TAG = "AppUtils";
    private static final String WIDGET_COLUMN_NAME = "appWidgetProvider";
    private static final int WIDGET_TYPE = 4;
    private static final String WIDGET_URI = "content://com.android.launcher3.settings/favorites?notify=true";

    public static class AppPkgItem {
        public String pkgName;
        public String showName;

        public AppPkgItem(String str, String str2) {
            this.pkgName = g.m("", str);
            this.showName = g.m("", str2);
        }

        public JSONObject toJsonObject() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.showName);
                jSONObject.put("pkg", this.pkgName);
                return jSONObject;
            } catch (JSONException e4) {
                Log.e("AppeUtils", " AppPkgItem.toJsonObject() Excep:" + e4.toString());
                return null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append(this.showName);
            sb.append(",");
            return g.r(sb, this.pkgName, "}");
        }
    }

    public static String getAppName(Context context, int i4) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i4) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static String getAppVersion(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static String getCurrentInputMethod(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        if (string != null && string.length() > 0) {
            String[] strArrSplit = string.split("/");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return "";
    }

    public static String getCurrentLauncher(Context context) {
        ResolveInfo resolveInfoResolveActivity;
        String str;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null || (resolveInfoResolveActivity = packageManager.resolveActivity(intent, UTF8Decoder.Surrogate.UCS4_MIN)) == null || (str = resolveInfoResolveActivity.activityInfo.packageName) == null) ? "" : str;
    }

    public static String getCurrentSMS(Context context) {
        ComponentName defaultSmsApplication = SmsApplicationStepos.getDefaultSmsApplication(context, true);
        return defaultSmsApplication != null ? defaultSmsApplication.getPackageName() : "";
    }

    public static String getCurrentWallpaper(Context context) {
        try {
            WallpaperInfo wallpaperInfo = WallpaperManager.getInstance(context.getApplicationContext()).getWallpaperInfo();
            return wallpaperInfo == null ? "" : wallpaperInfo.getPackageName();
        } catch (Exception e4) {
            AbstractC0351g.B("isNetworkAvailable exception: ", e4, TAG);
            return "";
        }
    }

    public static List<ResolveInfo> getInstalledApps(Context context) {
        return LargeBinderTransactionHelper.getOnLauncherApplications(context.getPackageManager());
    }

    public static ArrayList<String> getInstalledPkgs(Context context) {
        ApplicationInfo applicationInfo;
        ArrayList<String> arrayList = new ArrayList<>();
        for (PackageInfo packageInfo : LargeBinderTransactionHelper.getInstalledOnLauncherPackages(context.getPackageManager(), 0)) {
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                arrayList.add(applicationInfo.packageName);
            }
        }
        return arrayList;
    }

    public static List<String> getMusicPlayingList(List<String> list, PackageManager packageManager, AppData appData) {
        return getWakeLockList(WakeLockUtils.WACK_LOCK_AUDIO_MIX, list, packageManager, appData);
    }

    public static String getPowerPackage(Context context) {
        return context.getPackageName();
    }

    public static List<String> getRecordingList(List<String> list, PackageManager packageManager, AppData appData) {
        return getWakeLockList(WakeLockUtils.WACK_LOCK_AUDIO_IN, list, packageManager, appData);
    }

    public static ArrayList<String> getRunningComponent(ActivityManager activityManager) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null) {
                    for (String str : runningAppProcessInfo.pkgList) {
                        if (!arrayList.contains(str) && !TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<String> getUsingGpsList(List<String> list, Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        try {
            if (!LocationUtils.isLocationEnable(context)) {
                return arrayList;
            }
            ArrayList arrayList2 = (ArrayList) LocationUtils.getActiveGpsUidSets();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && str.contains(AwarenessDataItem.USERID_SPLITTER)) {
                    str = str.split(AwarenessDataItem.USERID_SPLITTER)[0];
                }
                if (arrayList2 == null) {
                    return arrayList;
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                if (applicationInfo != null && arrayList2.contains(Integer.valueOf(applicationInfo.uid))) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e(TAG, "getUsingGpsList exception: " + e4);
            return arrayList;
        }
    }

    private static List<String> getWakeLockList(String str, List<String> list, PackageManager packageManager, AppData appData) throws PackageManager.NameNotFoundException {
        Set<Integer> set;
        ArrayList arrayList = new ArrayList();
        HashMap<String, Set<Integer>> wakeLockUidSets = WakeLockUtils.getWakeLockUidSets();
        if (wakeLockUidSets != null && (set = wakeLockUidSets.get(str)) != null && set.size() != 0) {
            for (String str2 : list) {
                if (!"null".equals(str2)) {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 0);
                        if (!TextUtils.isEmpty(str2) && str2.contains(AwarenessDataItem.USERID_SPLITTER)) {
                            str2 = str2.split(AwarenessDataItem.USERID_SPLITTER)[0];
                        }
                        if (applicationInfo != null) {
                            if (str == WakeLockUtils.WACK_LOCK_AUDIO_MIX && set.size() == 1 && set.contains(Integer.MAX_VALUE) && appData.isMusicTypeApp(str2)) {
                                arrayList.add(str2);
                            }
                            if (set.contains(Integer.valueOf(applicationInfo.uid))) {
                                arrayList.add(str2);
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e4) {
                        Log.e(TAG, "getWakeLockList packageName = " + str2 + " exception: " + e4);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean hasSameSignature(PackageManager packageManager, int i4) {
        try {
            int iCheckSignatures = packageManager.checkSignatures(Process.myUid(), i4);
            boolean z4 = iCheckSignatures == 0;
            AlphaMeLogger.dLog("checkPermission hasSameSignature uid = " + i4 + ", match = " + iCheckSignatures + ", same = " + z4);
            return z4;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("hasSameSignature?", e4);
            return false;
        }
    }

    public static boolean isAppExist(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i4 = 0; i4 < installedPackages.size(); i4++) {
            if (installedPackages.get(i4).packageName.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppExistAsUser(Context context, String str, int i4) {
        return PerfBinderHelper.isAppExistAsUser(str, i4, 128);
    }

    public static boolean isHoldWakeLock(String str, String str2, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        HashMap<String, Set<Integer>> wakeLockUidSets = WakeLockUtils.getWakeLockUidSets();
        if (wakeLockUidSets == null) {
            return false;
        }
        try {
            Set<Integer> set = wakeLockUidSets.get(str);
            if (set != null && set.size() != 0) {
                if (!TextUtils.isEmpty(str2) && str2.contains(AwarenessDataItem.USERID_SPLITTER)) {
                    str2 = str2.split(AwarenessDataItem.USERID_SPLITTER)[0];
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 0);
                if (applicationInfo == null) {
                    return false;
                }
                if (set.contains(Integer.valueOf(applicationInfo.uid))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e(TAG, "isHoldWakeLock exception: " + e4);
            return false;
        }
    }

    public static boolean isInteractive(PowerManager powerManager) {
        if (powerManager != null) {
            return powerManager.isInteractive();
        }
        return true;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e4) {
            AbstractC0351g.B("isNetworkAvailable exception: ", e4, TAG);
            return false;
        }
    }

    public static boolean isRecord(String str, PackageManager packageManager) {
        return isHoldWakeLock(WakeLockUtils.WACK_LOCK_AUDIO_IN, str, packageManager);
    }

    public static List<ResolveInfo> getInstalledApps(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : getInstalledApps(context)) {
            if (list.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    public static boolean isHoldWakeLock(String str, int i4) {
        HashMap<String, Set<Integer>> wakeLockUidSets = WakeLockUtils.getWakeLockUidSets();
        if (wakeLockUidSets == null) {
            return false;
        }
        try {
            Set<Integer> set = wakeLockUidSets.get(str);
            if (set != null && set.size() != 0) {
                return set.contains(Integer.valueOf(i4));
            }
            return false;
        } catch (Exception e4) {
            AbstractC0351g.B("isHoldWakeLock exception: ", e4, TAG);
            return false;
        }
    }
}
