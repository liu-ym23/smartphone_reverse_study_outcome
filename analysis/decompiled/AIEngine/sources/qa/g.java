package qa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static String f11637a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f11638b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f11639c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f11640d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f11641e = "";

    /* renamed from: f, reason: collision with root package name */
    public static String f11642f = "";

    /* renamed from: g, reason: collision with root package name */
    public static int f11643g = 0;
    public static Boolean h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f11644i = false;

    public static int a(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i10 = f11643g;
        if (i10 != 0) {
            return i10;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            ta.c.f("StepOSUtils", "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f11643g = packageInfo.versionCode;
        }
        return f11643g;
    }

    public static String b(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(f11642f)) {
            return f11642f;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            ta.c.f("StepOSUtils", "Exception: " + e10.getMessage() + " - Cause: " + e10.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f11642f = packageInfo.versionName;
        }
        return f11642f;
    }
}
