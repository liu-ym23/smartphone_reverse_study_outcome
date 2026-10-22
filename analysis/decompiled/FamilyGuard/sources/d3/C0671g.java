package d3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import g3.C0742e;
import h3.C0752c;
import java.util.Locale;
import org.libpag.BuildConfig;

/* renamed from: d3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0671g {

    /* renamed from: a, reason: collision with root package name */
    private static String f16617a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f16618b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f16619c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f16620d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f16621e = "";

    /* renamed from: f, reason: collision with root package name */
    private static String f16622f = "";

    /* renamed from: g, reason: collision with root package name */
    private static int f16623g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f16624h = null;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f16625i = false;

    public static boolean a(Context context) {
        if (f16625i) {
            return true;
        }
        boolean z5 = Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) == 1;
        f16625i = z5;
        return z5;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f16619c)) {
            return f16619c;
        }
        String strB = C0752c.b("ro.product.other.brand", "unknown");
        if ("unknown".equals(strB)) {
            f16619c = Build.BRAND;
        } else {
            f16619c = strB;
        }
        return f16619c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f16617a)) {
            f16617a = C0752c.a("ro.build.mask.id");
        }
        return f16617a;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(f16620d)) {
            return f16620d;
        }
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            if (context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
                f16620d = context.getResources().getConfiguration().locale.getCountry();
            }
        } catch (Exception e6) {
            C0742e.d("StepOSUtils", "Exception: " + e6.getMessage() + " - Cause: " + e6.getCause());
        }
        return f16620d;
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(f16618b)) {
            return f16618b;
        }
        try {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null) {
                Point point = new Point();
                display.getRealSize(point);
                int i5 = point.x;
                int i6 = point.y;
                if (i5 > 0 && i6 > 0) {
                    f16618b = i5 + "." + i6;
                }
            }
        } catch (Exception e6) {
            C0742e.d("StepOSUtils", "getDisplaySize error, " + e6.getMessage());
        }
        return f16618b;
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(f16621e)) {
            return f16621e;
        }
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language == null) {
            language = BuildConfig.FLAVOR;
        }
        if (country == null) {
            country = BuildConfig.FLAVOR;
        }
        String str = language + "_" + country;
        f16621e = str;
        return str;
    }

    public static int g(String str, Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        int i5 = f16623g;
        if (i5 != 0) {
            return i5;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return 0;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e6) {
            C0742e.l("StepOSUtils", "Exception: " + e6.getMessage() + " - Cause: " + e6.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f16623g = packageInfo.versionCode;
        }
        return f16623g;
    }

    public static String h(String str, Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!TextUtils.isEmpty(f16622f)) {
            return f16622f;
        }
        if (TextUtils.isEmpty(str) || context == null || (packageManager = context.getPackageManager()) == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e6) {
            C0742e.l("StepOSUtils", "Exception: " + e6.getMessage() + " - Cause: " + e6.getCause());
            packageInfo = null;
        }
        if (packageInfo != null) {
            f16622f = packageInfo.versionName;
        }
        return f16622f;
    }

    public static String i() {
        return Build.MODEL;
    }

    public static boolean j(Context context) {
        return false;
    }

    public static boolean k() {
        if (f16624h == null) {
            try {
                f16624h = Boolean.valueOf(("zh".equalsIgnoreCase(C0752c.a("ro.product.locale.language")) && "CN".equalsIgnoreCase(C0752c.a("ro.product.locale.region")) && !"zh-CN".equalsIgnoreCase(C0752c.a("ro.product.locale"))) ? false : true);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return f16624h.booleanValue();
        }
        C0742e.c("StepOSUtils", "isInternational = " + f16624h);
        return f16624h.booleanValue();
    }

    public static boolean l(Context context) {
        try {
            int i5 = Settings.System.getInt(context.getContentResolver(), "stepos_data_collection", 0);
            C0742e.c("StepOSUtils", "get system data collection enable: " + i5);
            return i5 != 0;
        } catch (Exception e6) {
            C0742e.d("StepOSUtils", "get system data collection enable error, " + e6.getMessage());
            return true;
        }
    }

    public static boolean m() {
        return false;
    }

    public static boolean n() {
        return false;
    }
}
