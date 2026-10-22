package com.fasterxml.jackson.databind.l;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: BeanUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static Object a(com.fasterxml.jackson.databind.k r3) {
        Class<?> r0 = r3.e();
        Class<?> r1 = h.k(r0);
        if (r1 == null) goto L7;
        return h.i(r1);
    L7:
        if (r3.q() == true) goto L26;
        if (r3.a() == true) goto L26;
        if (r0 != String.class) goto L16;
        return "";
    L16:
        if (r3.b(Date.class) == false) goto L20;
        return new Date(0);
    L20:
        if (r3.b(Calendar.class) == false) goto L23;
        GregorianCalendar r4 = new GregorianCalendar();
        r4.setTimeInMillis(0);
        return r4;
    L23:
        return null;
    L26:
        return JsonInclude.Include.NON_EMPTY;
    }

    public static String b(com.fasterxml.jackson.databind.k r4) {
        String r0 = r4.e().getName();
        if (a(r0) == false) goto L9;
        if (r0.indexOf(46, 10) < 0) goto L7;
        return null;
    L7:
        String r1 = "Java 8 date/time";
        String r2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
    L12:
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", new Object[]{r1, h.b(r4), r2});
    L9:
        if (b(r0) == false) goto L13;
        r1 = "Joda date/time";
        r2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        goto L12
    L13:
        return null;
    }

    private static boolean a(String r1) {
        return r1.startsWith("java.time.");
    }

    private static boolean b(String r1) {
        return r1.startsWith("org.joda.time.");
    }
}
