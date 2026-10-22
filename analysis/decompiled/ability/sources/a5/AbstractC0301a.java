package a5;

import android.content.Context;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* renamed from: a5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0301a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f1637a;

    public static float a(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "current_launcher_icon_corner_size");
        if (TextUtils.isEmpty(string)) {
            return 0.2f;
        }
        string.getClass();
        switch (string) {
            case "corner_size_2":
                return 0.26f;
            case "corner_size_3":
                return 0.33f;
            case "corner_size_4":
                return 0.4f;
            case "corner_size_5":
                return 0.5f;
            default:
                return 0.2f;
        }
    }

    public static boolean b() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }
}
