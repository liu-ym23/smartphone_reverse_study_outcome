package h;

import android.content.res.Configuration;
import android.os.LocaleList;
import java.lang.invoke.VarHandle;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class w {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static j3.c b(Configuration configuration) {
        String languageTags = configuration.getLocales().toLanguageTags();
        if (languageTags != null) {
            j3.c cVar = j3.c.f6549b;
            if (!languageTags.isEmpty()) {
                String[] strArrSplit = languageTags.split(",", -1);
                int length = strArrSplit.length;
                Locale[] localeArr = new Locale[length];
                for (int i = 0; i < length; i++) {
                    localeArr[i] = Locale.forLanguageTag(strArrSplit[i]);
                }
                LocaleList localeList = new LocaleList(localeArr);
                j3.d dVar = new j3.d();
                dVar.f6551a = localeList;
                VarHandle.storeStoreFence();
                j3.c cVar2 = new j3.c();
                cVar2.f6550a = dVar;
                VarHandle.storeStoreFence();
                return cVar2;
            }
        }
        return j3.c.f6549b;
    }

    public static void c(j3.c cVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(cVar.f6550a.f6551a.toLanguageTags()));
    }

    public static void d(Configuration configuration, j3.c cVar) {
        configuration.setLocales(LocaleList.forLanguageTags(cVar.f6550a.f6551a.toLanguageTags()));
    }
}
