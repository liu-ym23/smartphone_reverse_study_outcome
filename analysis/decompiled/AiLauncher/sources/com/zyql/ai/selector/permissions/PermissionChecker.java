package com.zyql.ai.selector.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.a;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes4.dex */
public class PermissionChecker {
    public static boolean checkSelfPermission(Context context, String str) {
        return a.a(context.getApplicationContext(), str) == 0;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void launchAppDetailsSettings(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (isIntentAvailable(context, intent)) {
            applicationContext.startActivity(intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i10) {
        androidx.core.app.a.r(activity, strArr, i10);
    }
}
