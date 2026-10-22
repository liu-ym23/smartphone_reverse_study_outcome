package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: TextUtilsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Locale f1370a = null;

    /* JADX INFO: compiled from: TextUtilsCompat.java */
    static class a {
        static int a(Locale r0) {
            return TextUtils.getLayoutDirectionFromLocale(r0);
        }
    }

    static {
        f1370a = new Locale("", "");
    }

    public static int a(Locale r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        if (r2 != null) goto L8;
        return 0;
    L8:
        if (r2.equals(f1370a) == true) goto L22;
        String r0 = c.a(r2);
        if (r0 != null) goto L14;
        return b(r2);
    L14:
        if (r0.equalsIgnoreCase("Arab") == false) goto L16;
        return 1;
    L16:
        if (r0.equalsIgnoreCase("Hebr") == false) goto L23;
        return 1;
    L23:
        return 0;
    L22:
        return 0;
    L5:
        return a.a(r2);
    }

    private static int b(Locale r3) {
        byte r4 = Character.getDirectionality(r3.getDisplayName(r3).charAt(0));
        if (r4 != 1) goto L5;
    L7:
        return 1;
    L5:
        if (r4 == 2) goto L7;
        return 0;
    }
}
