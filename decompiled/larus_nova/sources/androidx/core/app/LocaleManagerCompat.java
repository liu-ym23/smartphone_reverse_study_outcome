package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class LocaleManagerCompat {

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static String toLanguageTag(Locale r100) {
            return r100.toLanguageTag();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static LocaleListCompat getLocales(Configuration r100) {
            return LocaleListCompat.forLanguageTags(r100.getLocales().toLanguageTags());
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        public static LocaleList localeManagerGetApplicationLocales(Object r100) {
            return ((LocaleManager) r100).getApplicationLocales();
        }

        public static LocaleList localeManagerGetSystemLocales(Object r100) {
            return ((LocaleManager) r100).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    public static LocaleListCompat getApplicationLocales(Context r100) {
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Object r101 = getLocaleManagerForApplication(r100);
        if (r101 == null) goto L9;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r101));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    L11:
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r100));
    }

    public static LocaleListCompat getConfigurationLocales(Configuration r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.getLocales(r100);
    L7:
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r100.locale));
    }

    private static Object getLocaleManagerForApplication(Context r100) {
        return r100.getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context r100) {
        LocaleListCompat r101 = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r102 = getLocaleManagerForApplication(r100);
        if (r102 != null) goto L10;
        return r101;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r102));
    L8:
        return getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}
