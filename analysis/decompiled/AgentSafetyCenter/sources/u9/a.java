package u9;

import android.content.Context;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Method f14259a;

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
