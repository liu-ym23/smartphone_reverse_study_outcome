package com.obric.agent.card.weather;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final boolean a(Date r4) {
        o.e(r4, "<this>");
        Calendar r0 = Calendar.getInstance();
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r4);
        if (r0.get(1) == r1.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r0.get(6) != r1.get(6)) goto L7;
        return true;
    }

    public static final boolean b(Date r5) {
        o.e(r5, "<this>");
        Calendar r0 = Calendar.getInstance();
        r0.add(6, 1);
        Calendar r3 = Calendar.getInstance();
        r3.setTime(r5);
        if (r0.get(1) == r3.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r0.get(6) != r3.get(6)) goto L7;
        return true;
    }

    public static final int c(Date r1) {
        o.e(r1, "<this>");
        Calendar r0 = Calendar.getInstance();
        r0.setTime(r1);
        return r0.get(7);
    }

    public static final boolean a(Date r3, Date r4) {
        o.e(r3, "date1");
        o.e(r4, "date2");
        Calendar r0 = Calendar.getInstance();
        r0.setTime(r3);
        Calendar r5 = Calendar.getInstance();
        r5.setTime(r4);
        if (r0.get(1) == r5.get(1)) goto L5;
    L9:
        return false;
    L5:
        if (r0.get(2) != r5.get(2)) goto L9;
        if (r0.get(5) != r5.get(5)) goto L9;
        return true;
    }

    public static final boolean a(Date r1, Date r2, Date r3) {
        o.e(r1, "target");
        o.e(r2, "start");
        o.e(r3, "end");
        Date r4 = d(r1);
        Date r5 = d(r2);
        Date r6 = d(r3);
        if (r4.compareTo(r5) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r4.compareTo(r6) > 0) goto L7;
        return true;
    }

    private static final Date d(Date r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTime(r2);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        Date r3 = r0.getTime();
        o.c(r3, "getTime(...)");
        return r3;
    }

    public static final String a(Date r4, String r5) {
        o.e(r4, "date");
        o.e(r5, "timeZone");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        Object r1 = new SimpleDateFormat("MM/dd", Locale.getDefault()).clone();
        o.a(r1, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        SimpleDateFormat r2 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(r1, SimpleDateFormat.class, "com.obric.aiagent.plugin");
        r2.setTimeZone(TimeZone.getTimeZone(r5));
        String r6 = r2.format(r4);
        o.c(r6, "format(...)");
        return r6;
    L10:
        throw new IllegalArgumentException("timeZone is empty");
    L5:
        r0 = false;
        goto L6
    }
}
