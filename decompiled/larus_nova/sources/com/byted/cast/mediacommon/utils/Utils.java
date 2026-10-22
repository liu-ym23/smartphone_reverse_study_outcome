package com.byted.cast.mediacommon.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.os.Process;
import android.util.Size;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: classes39.dex */
public class Utils {
    private static final String TAG = null;

    public Utils() {
    }

    public static int Alias8(int r100) {
        if ((r100 & 7) != 0) goto L6;
        return r100;
    L6:
        return (r100 + 8) & (-8);
    }

    static {
        TAG = "Utils";
    }

    private static String deviceId() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    public static Boolean ignoreDevice() {
        String[] r100 = {"AN00", "PD2323"};
        String r101 = getProperty("ro.product.name", "non");
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L11;
        if (r101.contains(r100[r102]) == true) goto L8;
        r102 = r102 + 1;
        goto L4
    L8:
        return Boolean.TRUE;
    L11:
        return Boolean.FALSE;
    }

    public static String osVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppName(Context r100) {
        ApplicationInfo r101 = r100.getApplicationInfo();
        int r102 = r101.labelRes;
        if (r102 != 0) goto L6;
        return r101.nonLocalizedLabel.toString();
    L6:
        return r100.getString(r102);
    }

    public static String getAppVersion(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;
    L4:
        return "";
    }

    public static int getDeviceDefaultOrientation(Context r100) {
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Configuration r102 = r100.getResources().getConfiguration();
        int r103 = r101.getDefaultDisplay().getRotation();
        if (r103 == 0) goto L13;
        if (r103 == 1) goto L10;
        if (r103 == 2) goto L13;
        if (r103 == 3) goto L10;
    L15:
        return 1;
    L10:
        if (r102.orientation != 1) goto L15;
        return 2;
    L13:
        if (r102.orientation != 2) goto L15;
        return 2;
    }

    public static int getDeviceRotationDegree(Context r100) {
        int r101 = getDisplayDefaultRotation(r100);
        if (r101 != 1) goto L5;
        return 90;
    L5:
        if (r101 != 2) goto L7;
        return 180;
    L7:
        if (r101 == 3) goto L10;
        return 0;
    L10:
        return 270;
    }

    public static int getDisplayDefaultRotation(Context r100) {
        return ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
    }

    public static String getPackageName(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).packageName;
    L4:
        return "";
    }

    public static Point getScreenSize(Context r100) {
        Point r101 = new Point();
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealSize(r101);
        return r101;
    }

    public static boolean isLandscape(Context r100) {
        Point r101 = getScreenSize(r100);
        if (r101.x <= r101.y) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isSystemApp(Context r100) {
        if ((r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).applicationInfo.flags & 1) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static String getProperty(String r100, String r101) {
        String r102 = (String) ReflectMethods.invokeStaticMethod("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{r100, r101});
        Logger.i(TAG, "getProp, version is: " + Build.VERSION.SDK_INT + " platform: " + r102);
        return r102;
    }

    public static boolean hasPermission(Context r100, String r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (com_byted_cast_mediacommon_utils_Utils_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid()) != 0) goto L6;
        return true;
    }

    public static Size computeVideoSize(int r100, int r101, int r102) {
        int r103 = r100 & (-8);
        int r104 = r101 & (-8);
        if (r102 <= 0) goto L23;
        if (r104 <= r103) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        int r106 = r104;
    L10:
        if (r105 == true) goto L13;
        r103 = r104;
    L13:
        if (r106 <= r102) goto L15;
        r103 = (((r103 * r102) / r106) + 4) & (-8);
    L16:
        if (r105 == false) goto L18;
        int r107 = r103;
    L19:
        if (r105 == false) goto L21;
        r103 = r102;
    L21:
        int r108 = r107;
        r104 = r103;
        r103 = r108;
        goto L23
    L18:
        r107 = r102;
        goto L19
    L15:
        r102 = r106;
        goto L16
    L9:
        r106 = r103;
        goto L10
    L6:
        r105 = false;
    L23:
        return new Size(r103, r104);
    }

    private static int com_byted_cast_mediacommon_utils_Utils_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        b r112 = new b("auto_cert_com_byted_cast_mediacommon_utils_Utils_android_content_Context_checkPermission");
        a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Size computeVideoSize(int r100, int r101, int r102, int r103) {
        if (r102 <= 0) goto L11;
        if (r103 <= 0) goto L11;
        float r104 = (float) ((((double) r103) * 1.0d) / ((double) r101));
        float r105 = (float) ((((double) r102) * 1.0d) / ((double) r100));
        if (r104 <= r105) goto L8;
        r104 = r105;
    L8:
        if ((r104 - 1.0f) >= 1.0E-5d) goto L11;
        r100 = Alias8((int) (r100 * r104));
        r101 = Alias8((int) (r101 * r104));
    L11:
        return new Size(r100, r101);
    }
}
