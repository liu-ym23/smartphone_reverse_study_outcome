package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;
import org.apache.http.protocol.HttpDateGenerator;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpDate {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 253402300799999L;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = null;

    static {
        STANDARD_DATE_FORMAT = new AnonymousClass1();
        String[] r10 = {HttpDateGenerator.PATTERN_RFC1123, "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = r10;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[r10.length];
    }

    private HttpDate() {
    }

    public static String format(Date r10) {
        return STANDARD_DATE_FORMAT.get().format(r10);
    }

    public static Date parse(String r10) {
        if (r10.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r11 = new ParsePosition(0);
        Date r12 = STANDARD_DATE_FORMAT.get().parse(r10, r11);
        if (r11.getIndex() != r10.length()) goto L8;
        return r12;
    L8:
        String[] r13 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        monitor-enter(r13);
        int r14 = r13.length;     // Catch: Throwable -> L15
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L22;
        DateFormat[] r16 = BROWSER_COMPATIBLE_DATE_FORMATS;     // Catch: Throwable -> L15
        DateFormat r17 = r16[r15];     // Catch: Throwable -> L15
        if (r17 != null) goto L17;
        r17 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[r15], Locale.US);     // Catch: Throwable -> L15
        r17.setTimeZone(Util.UTC);     // Catch: Throwable -> L15
        r16[r15] = r17;     // Catch: Throwable -> L15
    L17:
        r11.setIndex(0);     // Catch: Throwable -> L15
        Date r18 = r17.parse(r10, r11);     // Catch: Throwable -> L15
        if (r11.getIndex() != 0) goto L19;
        r15 = r15 + 1;     // Catch: Throwable -> L15
        goto L11
    L19:
        monitor-exit(r13);     // Catch: Throwable -> L15
        return r18;
    L22:
        monitor-exit(r13);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
