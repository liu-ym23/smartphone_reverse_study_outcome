package androidx.core.text;

import android.icu.util.ULocale;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public static class a {
        @DoNotInline
        public static ULocale a(Object r10) {
            return ULocale.addLikelySubtags((ULocale) r10);
        }

        @DoNotInline
        public static ULocale b(Locale r10) {
            return ULocale.forLocale(r10);
        }

        @DoNotInline
        public static String c(Object r10) {
            return ((ULocale) r10).getScript();
        }
    }

    static {
    }

    public static String a(Locale r10) {
        return a.c(a.a(a.b(r10)));
    }
}
