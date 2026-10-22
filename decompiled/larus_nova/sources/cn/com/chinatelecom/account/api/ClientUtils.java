package cn.com.chinatelecom.account.api;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.com.chinatelecom.account.i;
import cn.com.chinatelecom.account.r;
import cn.com.chinatelecom.account.v;
import cn.com.chinatelecom.account.z;
import java.io.FileInputStream;
import java.security.interfaces.RSAPublicKey;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientUtils {
    private static final String TAG = "ClientUtils";
    public static final int TYPE_SDK_API = 0;
    public static final int TYPE_SDK_BIO = 2;
    public static final int TYPE_SDK_HY = 1;
    private static int sdkType;

    public ClientUtils() {
    }

    public static String enrdata(String r100, String r101) {
        return v.a(r100, (RSAPublicKey) v.a(r101));
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getApiVersion() {
        return "3.0";
    }

    public static String getAppName(Context r100) {
        int r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).applicationInfo.labelRes;     // Catch: Exception -> L4
        return r100.getResources().getString(r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getCurrentNetworkType(Context r100) {
        return r.c(r100);
    }

    public static boolean getHealthy(Context r100) {
        return i.g(r100);
    L4:
        th = move-exception;
        CtAuth.warn(TAG, "getHealthy error ：" + th.getMessage(), th);
        return false;
    }

    public static boolean getMacData() {
        return i.c();
    L4:
        th = move-exception;
        CtAuth.warn(TAG, "getMacData error ：" + th.getMessage(), th);
        return false;
    }

    public static String getMobileBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static boolean getNetSafe(Context r100) {
        return i.h(r100);
    L4:
        th = move-exception;
        CtAuth.warn(TAG, "getNetSafe error ：" + th.getMessage(), th);
        return false;
    }

    public static String getOnlineType(Context r100) {
        return r.e(r100);
    }

    public static String getOperatorType(Context r100) {
        return r.i(r100);
    }

    public static String getOs() {
        return getMobileBrand() + "-" + getModel() + "-A:" + Build.VERSION.RELEASE;
    }

    public static String getPID() {
        String r100 = "";
        String r101 = Thread.currentThread().getId() + "" + Process.myPid();     // Catch: Exception -> L8
        if (r101.length() <= 6) goto L6;
        r100 = r101.substring(0, 6);     // Catch: Exception -> L8
        return r100;
    L6:
        return "ctacco";
    L8:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static int getSdkType() {
        return sdkType;
    }

    public static String getSdkVersion() {
        int r100 = sdkType;
        if (r100 != 1) goto L7;
        return "SDK-HY-v4.6.0";
    L7:
        if (r100 != 2) goto L10;
        return "SDK-BIOM-v4.6.0";
    L10:
        return "SDK-API-v4.6.0";
    }

    public static boolean getTimePass(Context r100) {
    L9:
        th = move-exception;
        CtAuth.warn(TAG, "getTimePass error ：" + th.getMessage(), th);
        return false;
    L4:
        if (i.i(r100) == true) goto L7;
        if (i.d() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static long getTp() {
        return System.currentTimeMillis();
    }

    public static String hashEncryption(FileInputStream r100) {
        return z.a(r100);
    }

    public static String hashEncryption(String r100) {
        return z.a(r100);
    }

    public static String hmacHashEncryption(String r100, String r101) {
        return z.a(r100, r101);
    }

    public static boolean isJY() {
        return true;
    }

    public static boolean objChange(Object r100, String r101) {
        return i.a(r100, r101);
    L4:
        th = move-exception;
        CtAuth.warn(TAG, "objChange error ：" + th.getMessage(), th);
        return false;
    }

    public static void setSdkType(int r100) {
        sdkType = r100;
    }

    public static String strBuf() {
        return i.a().toString();
    L4:
        th = move-exception;
        CtAuth.warn(TAG, "strBuf error ：" + th.getMessage(), th);
        return "";
    }
}
