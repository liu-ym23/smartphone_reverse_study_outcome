package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class h {
    public static B0.d<String, String> a(Long l10, Long l11) {
        return b(l10, l11, null);
    }

    public static B0.d<String, String> b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return B0.d.a(null, null);
        }
        if (l10 == null) {
            return B0.d.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return B0.d.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar calendarL = v.l();
        Calendar calendarN = v.n();
        calendarN.setTimeInMillis(l10.longValue());
        Calendar calendarN2 = v.n();
        calendarN2.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return B0.d.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        return calendarN.get(1) == calendarN2.get(1) ? calendarN.get(1) == calendarL.get(1) ? B0.d.a(g(l10.longValue(), Locale.getDefault()), g(l11.longValue(), Locale.getDefault())) : B0.d.a(g(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault())) : B0.d.a(n(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
    }

    public static String c(long j10) {
        return d(j10, null);
    }

    public static String d(long j10, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j10)) : q(j10) ? f(j10) : m(j10);
    }

    public static String e(Context context, long j10, boolean z10, boolean z11, boolean z12) {
        String strJ = j(j10);
        if (z10) {
            strJ = String.format(context.getString(R$string.mtrl_picker_today_description), strJ);
        }
        return z11 ? String.format(context.getString(R$string.mtrl_picker_start_date_description), strJ) : z12 ? String.format(context.getString(R$string.mtrl_picker_end_date_description), strJ) : strJ;
    }

    public static String f(long j10) {
        return g(j10, Locale.getDefault());
    }

    public static String g(long j10, Locale locale) {
        return v.b(locale).format(new Date(j10));
    }

    public static String h(long j10) {
        return i(j10, Locale.getDefault());
    }

    public static String i(long j10, Locale locale) {
        return v.h(locale).format(new Date(j10));
    }

    public static String j(long j10) {
        return q(j10) ? h(j10) : o(j10);
    }

    public static String k(Context context, int i10) {
        return v.l().get(1) == i10 ? String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i10)) : String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i10));
    }

    public static String l(long j10) {
        return v.q(Locale.getDefault()).format(new Date(j10));
    }

    public static String m(long j10) {
        return n(j10, Locale.getDefault());
    }

    public static String n(long j10, Locale locale) {
        return v.p(locale).format(new Date(j10));
    }

    public static String o(long j10) {
        return p(j10, Locale.getDefault());
    }

    public static String p(long j10, Locale locale) {
        return v.r(locale).format(new Date(j10));
    }

    public static boolean q(long j10) {
        Calendar calendarL = v.l();
        Calendar calendarN = v.n();
        calendarN.setTimeInMillis(j10);
        return calendarL.get(1) == calendarN.get(1);
    }
}
