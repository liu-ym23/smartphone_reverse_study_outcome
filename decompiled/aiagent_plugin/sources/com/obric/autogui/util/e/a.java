package com.obric.autogui.util.e;

import d.h.b.o;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/* JADX INFO: compiled from: TimeHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f31544a = null;

    public static final long a() {
        return System.currentTimeMillis();
    }

    public static final LocalDateTime a(long r2) {
        if (r2 != 0) goto L6;
        LocalDateTime r3 = LocalDateTime.MIN;
        o.c(r3, "MIN");
        return r3;
    L6:
        LocalDateTime r4 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r2), ZoneId.systemDefault());
        o.c(r4, "ofInstant(...)");
        return r4;
    }

    static {
        f31544a = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public static final long b(long r3) {
        Calendar r0 = Calendar.getInstance();
        long r1 = 1000;
        r0.setTimeInMillis(r3 * r1);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis() / r1;
    }
}
