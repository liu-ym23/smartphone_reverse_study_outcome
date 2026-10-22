package G;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale[] f462a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    @DoNotInline
    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    @DoNotInline
    public static boolean b(@NonNull Locale locale, @NonNull Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f462a;
        int length = localeArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                for (Locale locale3 : localeArr) {
                    if (!locale3.equals(locale2)) {
                    }
                }
                String strC = I.c.c(I.c.a(I.c.b(locale)));
                if (!strC.isEmpty()) {
                    return strC.equals(I.c.c(I.c.a(I.c.b(locale2))));
                }
                String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            if (localeArr[i4].equals(locale)) {
                break;
            }
            i4++;
        }
        return false;
    }
}
