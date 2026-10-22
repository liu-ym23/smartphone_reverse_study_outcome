package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = null;

    @Nullable
    private final Long fixedTimeMs;

    @Nullable
    private final TimeZone fixedTimeZone;

    static {
        SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    }

    private TimeSource(@Nullable Long r10, @Nullable TimeZone r11) {
        this.fixedTimeMs = r10;
        this.fixedTimeZone = r11;
    }

    public static TimeSource fixed(long r10, @Nullable TimeZone r11) {
        return new TimeSource(Long.valueOf(r10), r11);
    }

    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    public static TimeSource fixed(long r10) {
        return new TimeSource(Long.valueOf(r10), null);
    }

    public Calendar now(@Nullable TimeZone r10) {
        if (r10 != null) goto L4;
        Calendar r11 = Calendar.getInstance();
    L5:
        Long r12 = this.fixedTimeMs;
        if (r12 == null) goto L8;
        r11.setTimeInMillis(r12.longValue());
    L8:
        return r11;
    L4:
        r11 = Calendar.getInstance(r10);
        goto L5
    }
}
