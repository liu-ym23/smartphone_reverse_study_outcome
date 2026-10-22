package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class ConfigurationCompat {

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static LocaleList getLocales(Configuration r100) {
            return r100.getLocales();
        }

        public static void setLocales(Configuration r100, LocaleListCompat r101) {
            r100.setLocales((LocaleList) r101.unwrap());
        }
    }

    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return LocaleListCompat.wrap(Api24Impl.getLocales(r100));
    L7:
        return LocaleListCompat.create(new Locale[]{r100.locale});
    }

    public static void setLocales(Configuration r100, LocaleListCompat r101) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.setLocales(r100, r101);
        return;
    L6:
        if (r101.isEmpty() == true) goto L10;
        r100.setLocale(r101.get(0));
        return;
    }
}
