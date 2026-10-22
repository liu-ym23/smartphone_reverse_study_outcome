package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: loaded from: classes5.dex */
final class SimpleDateTimeFormatStyleProvider extends DateTimeFormatStyleProvider {
    private static final ConcurrentMap<String, Object> FORMATTER_CACHE = null;

    SimpleDateTimeFormatStyleProvider() {
    }

    static {
        FORMATTER_CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    }

    @Override // org.threeten.bp.format.DateTimeFormatStyleProvider
    public Locale[] getAvailableLocales() {
        return DateFormat.getAvailableLocales();
    }

    @Override // org.threeten.bp.format.DateTimeFormatStyleProvider
    public DateTimeFormatter getFormatter(FormatStyle r6, FormatStyle r7, Chronology r8, Locale r9) {
        if (r6 != null) goto L7;
        if (r7 != null) goto L7;
        throw new IllegalArgumentException("Date and Time style must not both be null");
    L7:
        String r10 = r8.getId() + '|' + r9.toString() + '|' + r6 + r7;
        ConcurrentMap<String, Object> r0 = FORMATTER_CACHE;
        Object r1 = r0.get(r10);
        if (r1 != null) goto L10;
        if (r6 == null) goto L19;
        if (r7 == null) goto L18;
        DateFormat r5 = DateFormat.getDateTimeInstance(convertStyle(r6), convertStyle(r7), r9);
    L21:
        if (ZeusTransformUtils.instanceOf(r5, SimpleDateFormat.class) == false) goto L24;
        DateTimeFormatter r11 = new DateTimeFormatterBuilder().appendPattern(((SimpleDateFormat) ZeusTransformUtils.preCheckCast(r5, SimpleDateFormat.class, "com.obric.aiagent.plugin")).toPattern()).toFormatter(r9);
        r0.putIfAbsent(r10, r11);
        return r11;
    L24:
        r0.putIfAbsent(r10, "");
        throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
    L18:
        r5 = DateFormat.getDateInstance(convertStyle(r6), r9);
        goto L21
    L19:
        r5 = DateFormat.getTimeInstance(convertStyle(r7), r9);
        goto L21
    L10:
        if (r1.equals("") == true) goto L14;
        return (DateTimeFormatter) ZeusTransformUtils.preCheckCast(r1, DateTimeFormatter.class, "com.obric.aiagent.plugin");
    L14:
        throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
    }

    private int convertStyle(FormatStyle r1) {
        return r1.ordinal();
    }
}
