package T1;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import b.C0551a;
import h3.C0752c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f5390a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f5391b = null;

    /* renamed from: c, reason: collision with root package name */
    public static int f5392c = -1;

    public static void a(Context context, String str, File file) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i5 = inputStreamOpen.read(bArr);
                if (i5 <= 0) {
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i5);
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static String b() {
        Application applicationA = P1.a.a();
        if (TextUtils.isEmpty(f5391b)) {
            f5391b = C0551a.a(applicationA).b(0);
        }
        if (TextUtils.isEmpty(f5391b)) {
            Log.e("AndroidUtils", "getDeviceId is empty, use default development device id");
            f5391b = "860000000000000";
        }
        return f5391b;
    }

    public static Integer c() {
        return C0752c.c("ro.build.stepos.version", 0);
    }

    public static int d() {
        if (f5390a == 0) {
            f5390a = e(P1.a.a().getPackageName());
        }
        return f5390a;
    }

    public static int e(String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = P1.a.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static boolean f(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        return runningAppProcesses != null && runningAppProcesses.size() > 0 && TextUtils.equals(activityManager.getRunningAppProcesses().get(0).processName, context.getPackageName()) && activityManager.getRunningAppProcesses().get(0).importance == 100;
    }

    public static boolean g(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "stepos_easy_mode", 0) == 1;
    }

    public static boolean h() {
        return ActivityManager.isUserAMonkey();
    }

    public static boolean i(Context context) {
        if (f5392c < 0) {
            f5392c = C0752c.b("ro.stepos.build.channel", BuildConfig.FLAVOR).equals("fawhq") ? 1 : 0;
        }
        return f5392c == 1;
    }

    public static boolean j(Context context) {
        return e("com.zyql.safe") >= 11000031;
    }

    public static void k() {
        Process.killProcess(Process.myPid());
    }

    public static void l(ContentResolver contentResolver, int i5) {
        Log.i("AndroidUtils", "putDWAuthoredToSetting hasGuarded = " + i5);
        Settings.Global.putInt(contentResolver, "com.stepos.familyguard.guarded", i5);
        if (i5 == 1) {
            Settings.Global.putInt(contentResolver, "auto_time", 1);
            Settings.Global.putInt(contentResolver, "auto_time_zone", 1);
        }
    }

    public static void m(ContentResolver contentResolver, boolean z5) {
        Settings.Secure.putInt(contentResolver, "family_guard_uninstall", !z5 ? 1 : 0);
    }

    public static void n(ContentResolver contentResolver, int i5) {
        Settings.Global.putInt(contentResolver, "com.stepos.familyguard.family.guarded", i5);
    }

    public static void o(ContentResolver contentResolver, boolean z5) {
        m(contentResolver, z5);
    }
}
