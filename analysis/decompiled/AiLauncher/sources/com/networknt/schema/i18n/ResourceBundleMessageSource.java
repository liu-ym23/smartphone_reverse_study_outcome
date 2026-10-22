package com.networknt.schema.i18n;

import R3.e;
import com.networknt.schema.i18n.ResourceBundleMessageSource;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class ResourceBundleMessageSource implements MessageSource {
    private final List<String> baseNames;
    private final Map<String, Map<Locale, ResourceBundle>> resourceBundleMap = new ConcurrentHashMap();
    private final Map<Locale, Map<String, String>> messageMap = new ConcurrentHashMap();
    private final Map<Locale, Map<String, MessageFormat>> messageFormatMap = new ConcurrentHashMap();

    public ResourceBundleMessageSource(String... strArr) {
        this.baseNames = Arrays.asList(strArr);
    }

    public static /* synthetic */ Map a(Locale locale) {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ MessageFormat d(Locale locale, String str) {
        return new MessageFormat(str, locale);
    }

    public static /* synthetic */ Map e(String str) {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ ResourceBundle f(String str, Locale locale) {
        try {
            return ResourceBundle.getBundle(str, locale);
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static /* synthetic */ Map g(Locale locale) {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ String h(String str, ResourceBundle resourceBundle) {
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    @Override // com.networknt.schema.i18n.MessageSource
    public String getMessage(String str, Supplier<String> supplier, Locale locale, Object... objArr) {
        String string;
        String messageFromCache = getMessageFromCache(locale, str);
        if (messageFromCache.isEmpty() && supplier != null) {
            messageFromCache = supplier.get();
        }
        if (!messageFromCache.isEmpty()) {
            str = messageFromCache;
        }
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        MessageFormat messageFormat = getMessageFormat(locale, str);
        synchronized (messageFormat) {
            string = messageFormat.format(objArr, new StringBuffer(), (FieldPosition) null).toString();
        }
        return string;
    }

    public MessageFormat getMessageFormat(final Locale locale, String str) {
        return this.messageFormatMap.computeIfAbsent(locale, new Function() { // from class: R3.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.a((Locale) obj);
            }
        }).computeIfAbsent(str, new Function() { // from class: R3.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.d(locale, (String) obj);
            }
        });
    }

    public String getMessageFromCache(final Locale locale, String str) {
        return this.messageMap.computeIfAbsent(locale, new Function() { // from class: R3.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.g((Locale) obj);
            }
        }).computeIfAbsent(str, new Function() { // from class: R3.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f5537a.resolveMessage(locale, (String) obj);
            }
        });
    }

    public Map<Locale, ResourceBundle> getResourceBundle(String str) {
        return this.resourceBundleMap.computeIfAbsent(str, new Function() { // from class: R3.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.e((String) obj);
            }
        });
    }

    public String resolveMessage(final Locale locale, final String str) {
        return (String) this.baseNames.stream().map(new Function() { // from class: R3.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f5532a.getResourceBundle((String) obj, locale);
            }
        }).filter(new Predicate() { // from class: R3.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((ResourceBundle) obj);
            }
        }).map(new Function() { // from class: R3.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.h(str, (ResourceBundle) obj);
            }
        }).filter(new e()).findFirst().orElse("");
    }

    public ResourceBundle getResourceBundle(final String str, Locale locale) {
        return getResourceBundle(str).computeIfAbsent(locale, new Function() { // from class: R3.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ResourceBundleMessageSource.f(str, (Locale) obj);
            }
        });
    }
}
