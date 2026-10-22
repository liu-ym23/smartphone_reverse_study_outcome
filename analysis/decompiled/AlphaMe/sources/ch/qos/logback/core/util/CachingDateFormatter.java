package ch.qos.logback.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class CachingDateFormatter {
    final SimpleDateFormat sdf;
    long lastTimestamp = -1;
    String cachedStr = null;

    public CachingDateFormatter(String str) {
        this.sdf = new SimpleDateFormat(str);
    }

    public final String format(long j4) {
        String str;
        synchronized (this) {
            try {
                if (j4 != this.lastTimestamp) {
                    this.lastTimestamp = j4;
                    this.cachedStr = this.sdf.format(new Date(j4));
                }
                str = this.cachedStr;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.sdf.setTimeZone(timeZone);
    }
}
