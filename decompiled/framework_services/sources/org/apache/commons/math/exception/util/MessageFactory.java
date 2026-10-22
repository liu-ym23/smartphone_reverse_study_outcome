package org.apache.commons.math.exception.util;

import java.text.MessageFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MessageFactory {
    private MessageFactory() {
    }

    public static String buildMessage(Locale locale, Localizable pattern, Object... arguments) {
        return buildMessage(locale, null, pattern, arguments);
    }

    public static String buildMessage(Locale locale, Localizable specific, Localizable general, Object... arguments) {
        StringBuilder sb = new StringBuilder();
        if (general == null) goto L5;
        MessageFormat fmt = new MessageFormat(general.getLocalizedString(locale), locale);
        sb.append(fmt.format(arguments));
    L5:
        if (specific == null) goto L10;
        if (general == null) goto L8;
        sb.append(": ");
    L8:
        MessageFormat fmt2 = new MessageFormat(specific.getLocalizedString(locale), locale);
        sb.append(fmt2.format(arguments));
    L10:
        return sb.toString();
    }
}
