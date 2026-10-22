package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {
    public static u0.b<String, String> a(Long l10, Long l11) {
        if (l10 == null && l11 == null) {
            return new u0.b<>(null, null);
        }
        if (l10 == null) {
            return new u0.b<>(null, b(l11.longValue()));
        }
        if (l11 == null) {
            return new u0.b<>(b(l10.longValue()), null);
        }
        Calendar calendarF = s.f();
        Calendar calendarG = s.g(null);
        calendarG.setTimeInMillis(l10.longValue());
        Calendar calendarG2 = s.g(null);
        calendarG2.setTimeInMillis(l11.longValue());
        return calendarG.get(1) == calendarG2.get(1) ? calendarG.get(1) == calendarF.get(1) ? new u0.b<>(c(l10.longValue(), Locale.getDefault()), c(l11.longValue(), Locale.getDefault())) : new u0.b<>(c(l10.longValue(), Locale.getDefault()), d(l11.longValue(), Locale.getDefault())) : new u0.b<>(d(l10.longValue(), Locale.getDefault()), d(l11.longValue(), Locale.getDefault()));
    }

    public static String b(long j10) {
        Calendar calendarF = s.f();
        Calendar calendarG = s.g(null);
        calendarG.setTimeInMillis(j10);
        return calendarF.get(1) == calendarG.get(1) ? c(j10, Locale.getDefault()) : d(j10, Locale.getDefault());
    }

    public static String c(long j10, Locale locale) {
        return s.b("MMMd", locale).format(new Date(j10));
    }

    public static String d(long j10, Locale locale) {
        return s.b("yMMMd", locale).format(new Date(j10));
    }
}
