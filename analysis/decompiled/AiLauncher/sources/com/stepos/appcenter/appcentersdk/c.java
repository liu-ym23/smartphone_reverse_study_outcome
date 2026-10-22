package com.stepos.appcenter.appcentersdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class c {
    public static String a() {
        String str = Build.BRAND;
        return "Nokia".equalsIgnoreCase(str) ? "com.fm.mstore.hmd" : "Sony".equalsIgnoreCase(str) ? "com.fm.mstore.sony" : "com.stepos.appstore";
    }

    public static int b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static boolean c(Context context) {
        String strA = a();
        int iB = b(context, strA);
        J6.c.b();
        boolean z10 = iB >= 10000;
        if (!z10) {
            Log.e(AppCenterSdk.TAG, "Not supported appcenter was found, packageName = [" + strA + "], versionCode = [" + iB + "]");
        }
        if (z10 || !J6.c.a(context)) {
            return z10;
        }
        return true;
    }

    public static boolean d(Context context, String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        launchIntentForPackage.addFlags(2097152);
        context.startActivity(launchIntentForPackage);
        return true;
    }
}
