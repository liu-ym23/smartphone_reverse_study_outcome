package androidx.appcompat.app;

import android.os.PowerManager;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class v {
    @DoNotInline
    public static boolean a(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }

    @DoNotInline
    public static String b(Locale locale) {
        return locale.toLanguageTag();
    }
}
