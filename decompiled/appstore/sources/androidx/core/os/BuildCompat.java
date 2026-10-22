package androidx.core.os;

import android.os.Build;
import androidx.annotation.RequiresOptIn;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuildCompat {

    @RequiresOptIn
    public @interface PrereleaseSdkCheck {
    }

    public static boolean a(String r10, String r11) {
        if ("REL".equals(r11) == false) goto L5;
        return false;
    L5:
        Locale r12 = Locale.ROOT;
        if (r11.toUpperCase(r12).compareTo(r10.toUpperCase(r12)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 33) goto L5;
    L10:
        return true;
    L5:
        if (r10 >= 32) goto L7;
    L9:
        return false;
    L7:
        if (a("Tiramisu", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }
}
