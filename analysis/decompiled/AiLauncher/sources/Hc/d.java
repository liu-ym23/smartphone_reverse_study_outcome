package Hc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

/* loaded from: classes5.dex */
public class d {
    public static boolean a(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static void b(Context context) {
        if (Settings.canDrawOverlays(context)) {
            Toast.makeText(context, "悬浮窗权限已拥有", 0).show();
            return;
        }
        context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName())));
    }
}
