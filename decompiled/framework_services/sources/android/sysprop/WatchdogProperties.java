package android.sysprop;

import android.os.SystemProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class WatchdogProperties {
    private WatchdogProperties() {
    }

    private static Boolean tryParseBoolean(String str) {
        if (str != null) goto L5;
        return null;
    L5:
        String r1 = str.toLowerCase(Locale.US);
        switch(r1.hashCode()) {
            case 48: goto L18;
            case 49: goto L15;
            case 3569038: goto L12;
            case 97196323: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        return null;
    L24:
        return Boolean.FALSE;
    L26:
        return Boolean.TRUE;
    L9:
        if (r1.equals("false") == false) goto L20;
        r2 = 3;
        goto L21
    L12:
        if (r1.equals("true") == false) goto L20;
        r2 = 1;
        goto L21
    L15:
        if (r1.equals("1") == false) goto L20;
        r2 = 0;
        goto L21
    L18:
        if (r1.equals("0") == false) goto L20;
        r2 = 2;
        goto L21
    }

    private static Integer tryParseInteger(String str) {
        return Integer.valueOf(str);
    L5:
        return null;
    }

    private static Integer tryParseUInt(String str) {
        return Integer.valueOf(Integer.parseUnsignedInt(str));
    L5:
        return null;
    }

    private static Long tryParseLong(String str) {
        return Long.valueOf(str);
    L5:
        return null;
    }

    private static Long tryParseULong(String str) {
        return Long.valueOf(Long.parseUnsignedLong(str));
    L5:
        return null;
    }

    private static Double tryParseDouble(String str) {
        return Double.valueOf(str);
    L5:
        return null;
    }

    private static String tryParseString(String str) {
        if ("".equals(str) == false) goto L6;
        return null;
    L6:
        return str;
    }

    private static <T extends Enum<T>> T tryParseEnum(Class<T> r2, String r3) {
        return (T) Enum.valueOf(r2, r3.toUpperCase(Locale.US));
    L5:
        return null;
    }

    private static <T> List<T> tryParseList(Function<String, T> elementParser, String str) {
        if ("".equals(str) == true) goto L5;
        List<T> ret = new ArrayList();
        int p = 0;
    L7:
        StringBuilder sb = new StringBuilder();
    L9:
        if (p >= str.length()) goto L19;
        if (str.charAt(p) == ',') goto L19;
        if (str.charAt(p) != '\\') goto L16;
        p = p + 1;
    L16:
        if (p == str.length()) goto L19;
        int p2 = p + 1;
        sb.append(str.charAt(p));
        p = p2;
    L19:
        ret.add(elementParser.apply(sb.toString()));
        if (p == str.length()) goto L21;
        p = p + 1;
        goto L7
    L21:
        return ret;
    L5:
        return new ArrayList();
    }

    private static <T extends Enum<T>> List<T> tryParseEnumList(Class<T> enumType, String str) {
        if ("".equals(str) == true) goto L5;
        ArrayList r0 = new ArrayList();
        String[] r1 = str.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        String element = r1[r3];
        r0.add(tryParseEnum(enumType, element));
        r3 = r3 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return new ArrayList();
    }

    private static String escape(String str) {
        return str.replaceAll("([\\\\,])", "\\\\$1");
    }

    private static <T> String formatList(List<T> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<T> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(element.toString());
        goto L9
    L11:
        return joiner.toString();
    }

    private static String formatUIntList(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<Integer> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Integer element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(Integer.toUnsignedString(element.intValue()));
        goto L9
    L11:
        return joiner.toString();
    }

    private static String formatULongList(List<Long> list) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<Long> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Long element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = escape(Long.toUnsignedString(element.longValue()));
        goto L9
    L11:
        return joiner.toString();
    }

    private static <T extends Enum<T>> String formatEnumList(List<T> list, Function<T, String> elementFormatter) {
        StringJoiner joiner = new StringJoiner(",");
        Iterator<T> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T element = r1.next();
        if (element != null) goto L8;
        String r3 = "";
    L9:
        joiner.add(r3);
        goto L4
    L8:
        r3 = elementFormatter.apply(element);
        goto L9
    L11:
        return joiner.toString();
    }

    public static Optional<Integer> fatal_count() {
        String value = SystemProperties.get("framework_watchdog.fatal_count");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Integer> fatal_window_seconds() {
        String value = SystemProperties.get("framework_watchdog.fatal_window.second");
        return Optional.ofNullable(tryParseInteger(value));
    }

    public static Optional<Boolean> should_ignore_fatal_count() {
        String value = SystemProperties.get("persist.debug.framework_watchdog.fatal_ignore");
        return Optional.ofNullable(tryParseBoolean(value));
    }
}
