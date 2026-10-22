package org.bouncycastle.asn1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.util.Longs;

/* loaded from: classes.dex */
public class LocaleUtil {
    private static final Map localeCache = new HashMap();
    public static Locale EN_Locale = forEN();

    public static Date epochAdjust(Date date) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = localeCache;
        synchronized (map) {
            try {
                Long lLongValueOf = (Long) map.get(locale);
                if (lLongValueOf == null) {
                    lLongValueOf = longValueOf(new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime());
                    map.put(locale, lLongValueOf);
                }
                if (lLongValueOf.longValue() == 0) {
                    return date;
                }
                return new Date(date.getTime() - lLongValueOf.longValue());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Locale forEN() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i8 = 0; i8 != availableLocales.length; i8++) {
            if ("en".equalsIgnoreCase(availableLocales[i8].getLanguage())) {
                return availableLocales[i8];
            }
        }
        return Locale.getDefault();
    }

    private static Long longValueOf(long j4) {
        return Longs.valueOf(j4);
    }
}
