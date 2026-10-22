package m2;

import android.os.SystemProperties;

/* loaded from: classes.dex */
public abstract class p {
    public static boolean a() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }
}
