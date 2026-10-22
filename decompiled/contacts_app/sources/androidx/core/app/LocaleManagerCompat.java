package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import com.android.common.speech.LoggingEvents;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleManagerCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static String toLanguageTag(Locale r0) {
            return r0.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleListCompat getLocales(Configuration r0) {
            return LocaleListCompat.forLanguageTags(r0.getLocales().toLanguageTags());
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList localeManagerGetSystemLocales(Object r0) {
            return ((LocaleManager) r0).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    public static LocaleListCompat getSystemLocales(Context r2) {
        LocaleListCompat r0 = LocaleListCompat.getEmptyLocaleList();
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r3 = getLocaleManagerForApplication(r2);
        if (r3 != null) goto L10;
        return r0;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r3));
    L8:
        return getConfigurationLocales(r2.getApplicationContext().getResources().getConfiguration());
    }

    private static Object getLocaleManagerForApplication(Context r1) {
        return r1.getSystemService(LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
    }

    static LocaleListCompat getConfigurationLocales(Configuration r0) {
        return Api24Impl.getLocales(r0);
    }
}
