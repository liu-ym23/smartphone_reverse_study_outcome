package aua;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static boolean a(Context r100) {
        AppOpsManager r101 = (AppOpsManager) r100.getSystemService("appops");
        Class<?> r102 = r101.getClass();     // Catch: Exception -> L6
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L6
        if (((Integer) r102.getDeclaredMethod("checkOp", new Class[]{r103, r103, String.class}).invoke(r101, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), r100.getPackageName()})).intValue() != 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void b(Application r100) {
        Intent r101 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r101.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        r101.putExtra("extra_pkgname", r100.getPackageName());
        r101.setFlags(268435456);
        PackageManager r102 = r100.getPackageManager();
        boolean r103 = false;
        if (r102 == null) goto L10;
        List<ResolveInfo> r104 = r102.queryIntentActivities(r101, 65536);
        if (r104 == null) goto L10;
        if (r104.size() <= 0) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L12;
        r100.startActivity(r101);
        return;
    L12:
        Log.e("MiuiFloatPermmision", "permission setting page not found");
        Intent r105 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r105.setData(Uri.fromParts("package", r100.getPackageName(), null));
        r105.setFlags(268435456);
        r100.startActivity(r105);
    }
}
