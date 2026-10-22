package org.apache.http.protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class HttpDateGenerator {
    public static final TimeZone GMT = null;
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private long dateAsLong;
    private String dateAsText;
    private final DateFormat dateformat;

    static {
        GMT = TimeZone.getTimeZone("GMT");
    }

    public HttpDateGenerator() {
        this.dateAsLong = 0;
        this.dateAsText = null;
        SimpleDateFormat r10 = new SimpleDateFormat(PATTERN_RFC1123, Locale.US);
        this.dateformat = r10;
        r10.setTimeZone(GMT);
    }

    public synchronized String getCurrentDate() {
        monitor-enter(this);
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L6
        if ((r10 - this.dateAsLong) <= 1000) goto L8;
        this.dateAsText = this.dateformat.format(new Date(r10));     // Catch: Throwable -> L6
        this.dateAsLong = r10;     // Catch: Throwable -> L6
    L8:
        String r11 = this.dateAsText;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
