package C2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class m {
    public static void a(Context context, String str, int i5, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i5 <= 0) {
            try {
                i5 = context.getPackageManager().getApplicationInfo(str, 0).uid;
            } catch (PackageManager.NameNotFoundException unused) {
                return;
            }
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", str);
        intent.putExtra("app_uid", i5);
        intent.putExtra("app_package", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(":settings:show_fragment_title", str2);
        }
        context.startActivity(intent);
    }
}
