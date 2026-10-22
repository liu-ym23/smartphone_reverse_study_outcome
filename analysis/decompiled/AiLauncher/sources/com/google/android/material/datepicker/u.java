package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class u {

    /* renamed from: c, reason: collision with root package name */
    public static final u f20859c = new u(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f20860a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f20861b;

    public u(Long l10, TimeZone timeZone) {
        this.f20860a = l10;
        this.f20861b = timeZone;
    }

    public static u c() {
        return f20859c;
    }

    public Calendar a() {
        return b(this.f20861b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.f20860a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
