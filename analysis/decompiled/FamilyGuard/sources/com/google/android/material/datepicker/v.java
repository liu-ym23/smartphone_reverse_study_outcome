package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
class v {

    /* renamed from: c, reason: collision with root package name */
    private static final v f12793c = new v(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Long f12794a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f12795b;

    private v(Long l5, TimeZone timeZone) {
        this.f12794a = l5;
        this.f12795b = timeZone;
    }

    static v c() {
        return f12793c;
    }

    Calendar a() {
        return b(this.f12795b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l5 = this.f12794a;
        if (l5 != null) {
            calendar.setTimeInMillis(l5.longValue());
        }
        return calendar;
    }
}
