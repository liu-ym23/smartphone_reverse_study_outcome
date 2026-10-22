package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class w {
    @DoNotInline
    public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    @DoNotInline
    public static G.g b(Configuration configuration) {
        String languageTags = configuration.getLocales().toLanguageTags();
        if (languageTags != null) {
            G.g gVar = G.g.f463b;
            if (!languageTags.isEmpty()) {
                String[] strArrSplit = languageTags.split(",", -1);
                int length = strArrSplit.length;
                Locale[] localeArr = new Locale[length];
                for (int i4 = 0; i4 < length; i4++) {
                    localeArr[i4] = G.e.a(strArrSplit[i4]);
                }
                return new G.g(new G.i(G.f.a(localeArr)));
            }
        }
        return G.g.f463b;
    }

    @DoNotInline
    public static void c(G.g gVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(((G.i) gVar.f464a).f465a.toLanguageTags()));
    }

    @DoNotInline
    public static void d(Configuration configuration, G.g gVar) {
        configuration.setLocales(LocaleList.forLanguageTags(((G.i) gVar.f464a).f465a.toLanguageTags()));
    }
}
