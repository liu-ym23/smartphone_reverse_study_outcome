package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private static final d f9671b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final e f9672a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f9673a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f9673a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = androidx.core.text.c.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(androidx.core.text.c.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private d(e eVar) {
        this.f9672a = eVar;
    }

    public static d a(Locale... localeArr) {
        return f(b.a(localeArr));
    }

    public static d b(String str) {
        if (str == null || str.isEmpty()) {
            return c();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i5 = 0; i5 < length; i5++) {
            localeArr[i5] = a.a(strArrSplit[i5]);
        }
        return a(localeArr);
    }

    public static d c() {
        return f9671b;
    }

    public static d f(LocaleList localeList) {
        return new d(new f(localeList));
    }

    public boolean d() {
        return this.f9672a.isEmpty();
    }

    public String e() {
        return this.f9672a.a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && this.f9672a.equals(((d) obj).f9672a);
    }

    public int hashCode() {
        return this.f9672a.hashCode();
    }

    public String toString() {
        return this.f9672a.toString();
    }
}
