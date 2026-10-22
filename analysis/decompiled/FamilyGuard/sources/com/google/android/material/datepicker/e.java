package com.google.android.material.datepicker;

import a1.C0416i;
import android.content.Context;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
class e {
    static String a(Context context, long j5, boolean z5, boolean z6, boolean z7) {
        String strD = d(j5);
        if (z5) {
            strD = String.format(context.getString(C0416i.f6901q), strD);
        }
        return z6 ? String.format(context.getString(C0416i.f6900p), strD) : z7 ? String.format(context.getString(C0416i.f6897m), strD) : strD;
    }

    static String b(long j5) {
        return c(j5, Locale.getDefault());
    }

    static String c(long j5, Locale locale) {
        return w.d(locale).format(new Date(j5));
    }

    static String d(long j5) {
        return i(j5) ? b(j5) : g(j5);
    }

    static String e(Context context, int i5) {
        return w.g().get(1) == i5 ? String.format(context.getString(C0416i.f6898n), Integer.valueOf(i5)) : String.format(context.getString(C0416i.f6899o), Integer.valueOf(i5));
    }

    static String f(long j5) {
        return w.k(Locale.getDefault()).format(new Date(j5));
    }

    static String g(long j5) {
        return h(j5, Locale.getDefault());
    }

    static String h(long j5, Locale locale) {
        return w.l(locale).format(new Date(j5));
    }

    private static boolean i(long j5) {
        Calendar calendarG = w.g();
        Calendar calendarI = w.i();
        calendarI.setTimeInMillis(j5);
        return calendarG.get(1) == calendarI.get(1);
    }
}
