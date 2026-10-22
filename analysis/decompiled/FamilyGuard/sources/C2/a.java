package C2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class a {
    public static boolean a(Activity activity, String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TextUtils.equals(activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).taskAffinity, str);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
