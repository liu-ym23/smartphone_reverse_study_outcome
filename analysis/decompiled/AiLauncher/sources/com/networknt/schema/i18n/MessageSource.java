package com.networknt.schema.i18n;

import com.networknt.schema.b;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface MessageSource {
    default String getMessage(String str, String str2, Locale locale, Object... objArr) {
        Objects.requireNonNull(str2);
        return getMessage(str, new b(str2), locale, objArr);
    }

    String getMessage(String str, Supplier<String> supplier, Locale locale, Object... objArr);

    default String getMessage(String str, Locale locale, Object... objArr) {
        return getMessage(str, (Supplier<String>) null, locale, objArr);
    }
}
