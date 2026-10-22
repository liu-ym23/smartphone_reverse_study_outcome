package com.autonavi.aps.amapapi.utils;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class DateUtil {
    private static long a(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long getCorrectedGpsTime(long j10, long j11, int i10) {
        if (i10 > 0) {
            try {
                if (Math.abs(j10 - j11) > i10 * Const.YEAR_IN_MILLIS) {
                    long jA = a(j11) + (j10 - a(j10));
                    long jAbs = Math.abs(jA - j11);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(jA));
                    int i11 = calendar.get(11);
                    if (i11 == 23 && jAbs >= 82800000) {
                        jA -= 86400000;
                    }
                    return (i11 != 0 || jAbs < 82800000) ? jA : jA + 86400000;
                }
            } catch (Throwable unused) {
            }
        }
        return j10;
    }
}
