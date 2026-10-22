package a5;

import android.os.SystemProperties;

/* loaded from: classes3.dex */
public abstract class m {
    public static boolean a() {
        return SystemProperties.getBoolean("ro.stepos.shell_hapticfeedback_motor", true);
    }
}
