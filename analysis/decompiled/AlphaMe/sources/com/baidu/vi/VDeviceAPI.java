package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.utils.Property;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class VDeviceAPI {

    /* renamed from: a, reason: collision with root package name */
    private static BroadcastReceiver f9483a;

    public static class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VDeviceAPI.onNetworkStateChanged();
        }
    }

    public static String getAppVersion() {
        try {
            return VIContext.getContext().getPackageManager().getPackageInfo(VIContext.getContext().getApplicationInfo().packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static long getAvailableMemory() {
        ActivityManager activityManager = (ActivityManager) VIContext.getContext().getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCellId() {
        return "";
    }

    public static String getCuid() {
        return SyncSysInfo.getCid();
    }

    public static int getCurrentNetworkType() {
        try {
            return Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static String getImei() {
        return null;
    }

    public static String getImsi() {
        return null;
    }

    public static String getLac() {
        return "";
    }

    public static String getModuleFileName() {
        return VIContext.getContext().getFilesDir().getAbsolutePath();
    }

    public static VNetworkInfo getNetworkInfo(int i4) {
        ConnectivityManager connectivityManager = (ConnectivityManager) VIContext.getContext().getSystemService("connectivity");
        NetworkInfo networkInfo = i4 != 2 ? i4 != 3 ? null : connectivityManager.getNetworkInfo(0) : connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            return new VNetworkInfo(networkInfo);
        }
        return null;
    }

    public static String getOsVersion() {
        return "android";
    }

    @TargetApi(8)
    public static int getScreenBrightness() {
        ContentResolver contentResolver = VIContext.getContext().getContentResolver();
        try {
            if (Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1) {
                return -1;
            }
        } catch (Exception unused) {
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException unused2) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        if (VIContext.getContext() == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.density;
    }

    public static int getScreenDensityDpi() {
        if (VIContext.getContext() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null && windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    public static long getSdcardFreeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static String getSdcardPath() {
        return SysOSUtil.getInstance().getCompatibleSdcardPath();
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static float getSystemMetricsX() {
        if (VIContext.getContext() == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (VIContext.getContext() == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getTelecomInfo() {
        return -1;
    }

    public static long getTotalMemory() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            jIntValue = bufferedReader.readLine() != null ? Integer.valueOf(r3.split("\\s+")[1]).intValue() : 0L;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return jIntValue;
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
    }

    public static ScanResult[] getWifiHotpot() {
        return null;
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void makeCall(String str) {
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        VIContext.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        return 0;
    }

    public static void sendSMS(String str, String str2) {
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        f9483a = new a();
        VIContext.getContext().registerReceiver(f9483a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void setScreenAlwaysOn(boolean z4) {
    }

    public static void unsetNetworkChangedCallback() {
        if (f9483a != null) {
            VIContext.getContext().unregisterReceiver(f9483a);
            f9483a = null;
        }
    }
}
