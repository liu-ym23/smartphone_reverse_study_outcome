package m2;

import android.content.Context;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import java.lang.reflect.Method;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0770a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f13561a;

    public static float a(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "current_launcher_icon_corner_size");
        if (TextUtils.isEmpty(string)) {
            return 0.2f;
        }
        string.getClass();
        switch (string) {
        }
        return 0.2f;
    }

    public static boolean b() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }

    public static void c(View view) {
        if (view == null) {
            return;
        }
        view.setForceDarkAllowed(false);
    }
}
