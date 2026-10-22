package com.networknt.schema.i18n;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes2.dex */
public class Locales {
    public static final String[] SUPPORTED_LANGUAGE_TAGS;
    public static final List<Locale> SUPPORTED_LOCALES;

    static {
        String[] strArr = {"ar", "cs", "da", "de", "es", "fa", "fi", Const.SP_KEY_FIRSTLOC_RELOC, Const.SP_KEY_INFO_WRITE, "he", "hr", "hu", "it", "ja", "ko", "nb", "nl", "pl", "pt", "ro", "ru", "sk", "sv", "th", "tr", "uk", "vi", "zh-CN", "zh-TW"};
        SUPPORTED_LANGUAGE_TAGS = strArr;
        SUPPORTED_LOCALES = of(strArr);
    }

    public static Locale findSupported(String str) {
        return findSupported(str, getSupportedLocales());
    }

    public static List<Locale> getSupportedLocales() {
        return SUPPORTED_LOCALES;
    }

    public static List<Locale> of(String... strArr) {
        return (List) Arrays.asList(strArr).stream().map(new Function() { // from class: R3.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Locale.forLanguageTag((String) obj);
            }
        }).collect(Collectors.toList());
    }

    public static Locale findSupported(String str, Collection<Locale> collection) {
        return findSupported(Locale.LanguageRange.parse(str), collection, Locale.FilteringMode.AUTOSELECT_FILTERING);
    }

    public static Locale findSupported(List<Locale.LanguageRange> list, Collection<Locale> collection, Locale.FilteringMode filteringMode) {
        Locale localeLookup = Locale.lookup(list, collection);
        if (localeLookup != null) {
            return localeLookup;
        }
        List<Locale> listFilter = Locale.filter(list, collection, filteringMode);
        if (!listFilter.isEmpty()) {
            return listFilter.get(0);
        }
        return Locale.ROOT;
    }
}
