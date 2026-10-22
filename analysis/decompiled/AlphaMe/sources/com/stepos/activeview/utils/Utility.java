package com.stepos.activeview.utils;

import B0.g;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.BuildExt;
import android.os.Bundle;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import kotlin.text.Typography;
import stepos.telephony.StepOSTelephonyManager;

/* loaded from: classes.dex */
public class Utility {
    private static String sImei;
    private static String sMacAddr;
    private static String sModel;
    private static String sPhoneSn;
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Boolean sIsInternational = null;
    private static Boolean sSystemIndependent = null;
    private static Boolean sIsShopDemo = null;
    private static Boolean sIsMacDevice = null;
    private static Integer sUnitType = null;

    public static String FormatFileSizeEx(double d4) {
        if (d4 < 1024.0d) {
            return String.format("%dB", Integer.valueOf(d4 > 0.0d ? (int) d4 : 0));
        }
        return (d4 < 1024.0d || d4 >= 10240.0d) ? (d4 < 10240.0d || d4 >= 102400.0d) ? (d4 < 102400.0d || d4 >= 1048576.0d) ? (d4 < 1048576.0d || d4 >= 1.048576E8d) ? (d4 < 1.048576E8d || d4 >= 1.073741824E9d) ? (d4 < 1.073741824E9d || d4 >= 1.073741824E10d) ? (d4 < 1.073741824E10d || d4 >= 1.073741824E11d) ? String.format("%dGB", Integer.valueOf((int) (d4 / 1.073741824E9d))) : String.format("%.1fGB", Double.valueOf(d4 / 1.073741824E9d)) : String.format("%.2fGB", Double.valueOf(d4 / 1.073741824E9d)) : String.format("%.1fMB", Double.valueOf(d4 / 1048576.0d)) : String.format("%.2fMB", Double.valueOf(d4 / 1048576.0d)) : String.format("%dKB", Integer.valueOf((int) (d4 / 1024.0d))) : String.format("%dKB", Integer.valueOf((int) (d4 / 1024.0d))) : String.format("%dKB", Integer.valueOf((int) (d4 / 1024.0d)));
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = hexDigits;
            cArr[i4] = cArr2[(b4 & 240) >>> 4];
            i4 += 2;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static byte[] encodePostParameters(List<Pair<String, String>> list, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (Pair<String, String> pair : list) {
                        sb.append(URLEncoder.encode((String) pair.first, str));
                        sb.append('=');
                        sb.append(URLEncoder.encode((String) pair.second, str));
                        sb.append(Typography.amp);
                    }
                }
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException(g.m("Encoding not supported: ", str), e4);
            }
        }
        return sb.toString().getBytes(str);
    }

    public static final String getAndroidVersion(Context context) {
        return Build.VERSION.RELEASE;
    }

    public static final Bitmap getAppIcon(String str, Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Drawable drawableLoadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
            if (drawableLoadIcon != null) {
                return drawableToBitmap(drawableLoadIcon);
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static final int getAppIconRes(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).applicationInfo.icon;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static Bundle getAppMetaDataBundle(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e4) {
            LogUtil.e(e4.getMessage());
            return null;
        }
    }

    public static String getAppPackageName(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static int getAppVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getAppVersionString(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static final String getApplicationName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int getBatteryCapacity(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
        if (intentRegisterReceiver == null) {
            return 0;
        }
        return (intentRegisterReceiver.getIntExtra("level", -1) * 100) / intentRegisterReceiver.getIntExtra("scale", -1);
    }

    public static String getDefaultImei(Context context) {
        if (TextUtils.isEmpty(sImei)) {
            String deviceId = StepOSTelephonyManager.getDeviceId();
            sImei = deviceId;
            if (TextUtils.isEmpty(deviceId)) {
                sImei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            }
        }
        return sImei;
    }

    public static String getDeviceId(Context context) {
        return isMacDevice(context) ? getMacAddress(context) : getIMEI(context);
    }

    public static final String getDeviceModel(Context context) {
        return isSystemIndependent(context) ? "All" : getDeviceModel();
    }

    public static final long getFileLength(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return file.length();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static final PackageInfo getFilePackageInfo(Context context, String str) {
        try {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                return context.getPackageManager().getPackageArchiveInfo(str, 0);
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static final String getFilePackageName(Context context, String str) {
        PackageInfo filePackageInfo = getFilePackageInfo(context, str);
        if (filePackageInfo != null) {
            return filePackageInfo.packageName;
        }
        return null;
    }

    public static final String getIMEI(Context context) {
        return getDefaultImei(context);
    }

    public static String getMacAddress(Context context) throws IOException {
        String macAddressWithIfName;
        if (!TextUtils.isEmpty(sMacAddr)) {
            return sMacAddr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            macAddressWithIfName = getMacAddressWithIfName("wlan0");
            if (TextUtils.isEmpty(macAddressWithIfName)) {
                macAddressWithIfName = getMacAddressWithIfName("eth0");
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            macAddressWithIfName = activeNetworkInfo.getType() == 1 ? getMacAddressWithIfName("wlan0") : activeNetworkInfo.getType() == 9 ? getMacAddressWithIfName("eth0") : null;
        }
        sMacAddr = macAddressWithIfName;
        return macAddressWithIfName;
    }

    private static String getMacAddressWithIfName(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            strTrim = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
            fileInputStream.close();
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return strTrim;
    }

    public static final String getSN(Context context) {
        if (sPhoneSn == null) {
            sPhoneSn = getSystemProperties("ro.serialno", null);
        }
        return sPhoneSn;
    }

    public static String getSimOpCode(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperator() : "";
    }

    public static String getSubmitAppVersionString(Context context) {
        return getSubmitAppVersionString(context, context.getPackageName());
    }

    private static String getSystemProperties(String str, String str2) {
        try {
            return (String) ReflectHelper.invokeStatic("android.os.SystemProperties", "get", new Object[]{str});
        } catch (Exception e4) {
            e4.printStackTrace();
            return str2;
        }
    }

    public static final String getSystemVersion(Context context) {
        String systemProperties;
        try {
            systemProperties = getSystemProperties("ro.build.mask.id", "");
        } catch (Exception e4) {
            e4.printStackTrace();
            systemProperties = null;
        }
        return TextUtils.isEmpty(systemProperties) ? Build.DISPLAY : systemProperties;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getUnitType(android.content.Context r2) {
        /*
            r2 = 0
            java.lang.Integer r0 = com.stepos.activeview.utils.Utility.sUnitType     // Catch: java.lang.Exception -> La
            if (r0 == 0) goto Lc
            int r2 = r0.intValue()     // Catch: java.lang.Exception -> La
            return r2
        La:
            r0 = move-exception
            goto L35
        Lc:
            java.lang.String r0 = "ro.target.product"
            r1 = 0
            java.lang.String r0 = getSystemProperties(r0, r1)     // Catch: java.lang.Exception -> La
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> La
            if (r1 != 0) goto L2d
            java.lang.String r1 = "tablet"
            boolean r1 = r1.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> La
            if (r1 == 0) goto L23
            r0 = 2
            goto L2e
        L23:
            java.lang.String r1 = "box"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch: java.lang.Exception -> La
            if (r0 == 0) goto L2d
            r0 = 1
            goto L2e
        L2d:
            r0 = r2
        L2e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> La
            com.stepos.activeview.utils.Utility.sUnitType = r1     // Catch: java.lang.Exception -> La
            return r0
        L35:
            r0.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.utils.Utility.getUnitType(android.content.Context):int");
    }

    public static boolean isInternational() {
        Boolean bool = sIsInternational;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(BuildExt.isProductInternational());
        sIsInternational = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean isMacDevice(Context context) {
        try {
            Boolean bool = sIsMacDevice;
            if (bool != null) {
                return bool.booleanValue();
            }
            String systemProperties = getSystemProperties("ro.target.product", null);
            boolean z4 = !TextUtils.isEmpty(systemProperties) && (Constants.DEVCIE_TABLET.equalsIgnoreCase(systemProperties) || Constants.DEVICE_TV.equalsIgnoreCase(systemProperties));
            sIsMacDevice = Boolean.valueOf(z4);
            return z4;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static final boolean isPackageValue(Context context, String str) {
        try {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                return context.getPackageManager().getPackageArchiveInfo(str, 0) != null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    public static boolean isShopDemo() {
        Boolean bool = sIsShopDemo;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean bool2 = Boolean.TRUE;
        sIsShopDemo = bool2;
        return bool2.booleanValue();
    }

    public static boolean isStepOSRom() {
        try {
            return SystemProperties.getBoolean("ro.stepos.rom.config", false);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSystemApp(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                return false;
            }
            int i4 = applicationInfo.flags;
            return ((i4 & 1) == 0 && (i4 & 128) == 0) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean isSystemIndependent(Context context) {
        if (sSystemIndependent == null) {
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle != null) {
                    sSystemIndependent = Boolean.valueOf(bundle.getBoolean("system_independent", false));
                    Log.d("StepOSUpdateComponent", "sSystemIndependent : " + sSystemIndependent);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (sSystemIndependent == null) {
                sSystemIndependent = Boolean.FALSE;
            }
        }
        return sSystemIndependent.booleanValue();
    }

    public static boolean isUpdateVersionValid(Context context, int i4) {
        return i4 < 0 || getAppVersionCode(context) < i4;
    }

    public static boolean isWifiActive(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    public static String md5sum(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            return encodeHex(messageDigest.digest());
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getSubmitAppVersionString(Context context, String str) {
        return getAppVersionString(context, str);
    }

    public static int getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String getDeviceModel() {
        if (TextUtils.isEmpty(sModel)) {
            sModel = Build.MODEL;
        }
        return sModel;
    }
}
