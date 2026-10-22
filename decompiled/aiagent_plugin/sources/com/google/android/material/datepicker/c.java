package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    static String a(long r2) {
        return DateUtils.formatDateTime(null, r2, 8228);
    }

    static String b(long r1) {
        return a(r1, Locale.getDefault());
    }

    static String a(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return i.a(r4).format(new Date(r2));
    L7:
        return i.e(r4).format(new Date(r2));
    }

    static String c(long r1) {
        return b(r1, Locale.getDefault());
    }

    static String b(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return i.b(r4).format(new Date(r2));
    L7:
        return i.f(r4).format(new Date(r2));
    }

    static String d(long r1) {
        return c(r1, Locale.getDefault());
    }

    static String c(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return i.c(r4).format(new Date(r2));
    L7:
        return i.g(r4).format(new Date(r2));
    }

    static String e(long r1) {
        return d(r1, Locale.getDefault());
    }

    static String d(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return i.d(r4).format(new Date(r2));
    L7:
        return i.g(r4).format(new Date(r2));
    }

    static String f(long r1) {
        return a(r1, null);
    }

    static String a(long r2, SimpleDateFormat r4) {
        Calendar r0 = i.b();
        Calendar r1 = i.c();
        r1.setTimeInMillis(r2);
        if (r4 == null) goto L7;
        return r4.format(new Date(r2));
    L7:
        if (r0.get(1) != r1.get(1)) goto L11;
        return c(r2);
    L11:
        return b(r2);
    }

    static androidx.core.util.e<String, String> a(Long r1, Long r2) {
        return a(r1, r2, null);
    }

    static androidx.core.util.e<String, String> a(Long r5, Long r6, SimpleDateFormat r7) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return androidx.core.util.e.a(null, null);
    L7:
        if (r5 == null) goto L9;
        if (r6 == null) goto L12;
        Calendar r0 = i.b();
        Calendar r1 = i.c();
        r1.setTimeInMillis(r5.longValue());
        Calendar r2 = i.c();
        r2.setTimeInMillis(r6.longValue());
        if (r7 == null) goto L18;
        Date r3 = new Date(r5.longValue());
        Date r8 = new Date(r6.longValue());
        return androidx.core.util.e.a(r7.format(r3), r7.format(r8));
    L18:
        if (r1.get(1) != r2.get(1)) goto L26;
        if (r1.get(1) != r0.get(1)) goto L24;
        return androidx.core.util.e.a(b(r5.longValue(), Locale.getDefault()), b(r6.longValue(), Locale.getDefault()));
    L24:
        return androidx.core.util.e.a(b(r5.longValue(), Locale.getDefault()), a(r6.longValue(), Locale.getDefault()));
    L26:
        return androidx.core.util.e.a(a(r5.longValue(), Locale.getDefault()), a(r6.longValue(), Locale.getDefault()));
    L12:
        return androidx.core.util.e.a(a(r5.longValue(), r7), null);
    L9:
        return androidx.core.util.e.a(null, a(r6.longValue(), r7));
    }
}
