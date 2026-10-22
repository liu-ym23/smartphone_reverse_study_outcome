package P3;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.migu.music.ipc.dialog.MusicIpcCheckDialog;

/* loaded from: classes2.dex */
public final class b {
    public static int a(Context context) throws PackageManager.NameNotFoundException {
        if (context != null && !TextUtils.isEmpty("cmccwm.mobilemusic")) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo("cmccwm.mobilemusic", 0);
                Log.d("MusicIpcSdkUtils", "getPackageVersionCode: versionCode=" + packageInfo.versionCode);
                return packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean b(Context context) {
        return c(context, "cmccwm.mobilemusic");
    }

    public static boolean c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getApplicationContext().getPackageManager().getPackageInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static void d(Activity activity) {
        if (activity == null || b(activity)) {
            return;
        }
        com.migu.music.ipc.dialog.a.d(activity, MusicIpcCheckDialog.DialogType.INSTALL);
    }

    public static void e(Activity activity, boolean z10) {
        if (activity == null || z10) {
            return;
        }
        com.migu.music.ipc.dialog.a.d(activity, b(activity) ? MusicIpcCheckDialog.DialogType.LOGIN : MusicIpcCheckDialog.DialogType.INSTALL);
    }

    public static void f(Activity activity) {
        if (activity == null) {
            return;
        }
        com.migu.music.ipc.dialog.a.d(activity, b(activity) ? MusicIpcCheckDialog.DialogType.OPEN_APP : MusicIpcCheckDialog.DialogType.INSTALL);
    }

    public static void g(Activity activity) {
        MusicIpcCheckDialog.DialogType dialogType;
        if (activity == null) {
            return;
        }
        if (!b(activity)) {
            dialogType = MusicIpcCheckDialog.DialogType.INSTALL;
        } else if (a(activity) >= 533) {
            return;
        } else {
            dialogType = MusicIpcCheckDialog.DialogType.UPDATE;
        }
        com.migu.music.ipc.dialog.a.d(activity, dialogType);
    }
}
