package T1;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f5396a = new HashSet();

    public static boolean a() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        return "zh".equals(language) || "CN".equals(country) || "TW".equals(country) || "HK".equals(country) || "MO".equals(country);
    }
}
