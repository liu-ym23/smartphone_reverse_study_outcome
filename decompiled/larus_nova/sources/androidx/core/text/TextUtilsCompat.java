package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
public final class TextUtilsCompat {
    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(Locale r100) {
        return TextUtils.getLayoutDirectionFromLocale(r100);
    }

    public static String htmlEncode(String r100) {
        return TextUtils.htmlEncode(r100);
    }
}
