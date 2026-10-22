package C2;

import N1.h;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f607a = {4, 6, 0, 24, 57, 75, 76, 13, 68};

    public static boolean a(Context context) {
        return !context.getPackageManager().queryIntentActivities(new Intent().setClassName("com.android.packageinstaller", "com.stepos.safe.newpermission.ui.ManagePermissionsActivity"), 0).isEmpty();
    }

    private static void b(Context context, int i5) throws PackageManager.NameNotFoundException {
        if (i5 != 24) {
            String str = "com.stepos.familyguard_op_" + i5;
            int i6 = Settings.Secure.getInt(context.getContentResolver(), str, 0);
            Log.d("PermissionUtil", "requestPermission opName = " + str + " result = " + i6);
            if (i6 != 4) {
                Settings.Secure.putInt(context.getContentResolver(), str, 4);
            }
            Log.d("PermissionUtil", "requestPermission opName = " + str + " after set result = " + Settings.Secure.getInt(context.getContentResolver(), str, 0));
            return;
        }
        Log.d("PermissionUtil", "requestPermission permission = " + i5);
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.stepos.familyguard", 0);
            if (applicationInfo == null) {
                Log.d("PermissionUtil", "ai == null");
                return;
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            int iCheckOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", applicationInfo.uid, "com.stepos.familyguard");
            Log.d("PermissionUtil", " value == " + iCheckOpNoThrow);
            if (iCheckOpNoThrow != 0) {
                h.g gVarA = N1.h.a(AppOpsManager.class);
                Class cls = Integer.TYPE;
                gVarA.a("setMode", cls, cls, String.class, cls).a(appOpsManager, 24, Integer.valueOf(applicationInfo.uid), "com.stepos.familyguard", 0);
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e6) {
            e6.printStackTrace();
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
        } catch (InvocationTargetException e9) {
            e9.printStackTrace();
        }
    }

    public static void c(Context context) throws PackageManager.NameNotFoundException {
        boolean zA = a(context);
        Log.d("PermissionUtil", "isPermMoveToInstaller = " + zA);
        if (zA) {
            return;
        }
        for (int i5 : f607a) {
            b(context, i5);
        }
    }
}
