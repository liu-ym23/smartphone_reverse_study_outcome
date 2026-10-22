package com.obric.eventkit.utils;

import android.os.Build;
import com.a.c.a.d;
import com.a.c.c;
import com.a.c.c.b;
import com.obric.eventkit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.x;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CronHelper {
    public static final CronHelper INSTANCE = null;
    private static final String TAG = "CronHelper";
    private static final f cronParser$delegate = null;

    public static final class a extends p implements d.h.a.a<com.a.d.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33228a = null;

        static {
            f33228a = new a();
        }

        public a() {
            super(0);
        }

        @Override // d.h.a.a
        public com.a.d.a invoke() {
            return new com.a.d.a(d.a(c.f3139b));
        }
    }

    static {
        INSTANCE = new CronHelper();
        cronParser$delegate = g.a(a.f33228a);
    }

    private CronHelper() {
    }

    private final com.a.d.a getCronParser() {
        return (com.a.d.a) ZeusTransformUtils.preCheckCast(cronParser$delegate.b(), com.a.d.a.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Long getNextScheduleTime$default(CronHelper r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getNextScheduleTime(r1, r2);
    }

    public final Long getNextScheduleTime(String r5, Long r6) {
        o.e(r5, "cron");
        b r0 = b.a(INSTANCE.getCronParser().a(r5));     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r6 == null) goto L7;
        ZonedDateTime r1 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(r6.longValue()), ZoneId.systemDefault());     // Catch: Throwable -> L14
    L8:
        ZonedDateTime r2 = (ZonedDateTime) ZeusTransformUtils.preCheckCast(r0.a(r1).orElse(null), ZonedDateTime.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        o.c(r2, "orElse(null)");     // Catch: Throwable -> L14
        return Long.valueOf(r2.toInstant().toEpochMilli());
    L7:
        r1 = ZonedDateTime.now();     // Catch: Throwable -> L14
    L12:
        Object r3 = n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r4 = n.c(r3);
        if (r4 == null) goto L19;
        Logger.INSTANCE.i(TAG, "getNextScheduleTime fail cron = " + r5 + ", fromTimestamp = " + r6 + ' ' + r4);
    L19:
        return null;
    L14:
        th = move-exception;
        r3 = n.f(d.o.a(th));
        goto L16
    }

    public final boolean isTimeRecurring(String r7) {
        o.e(r7, "cron");
        List r6 = d.o.o.b(r7, new String[]{" "}, false, 0, 6, null);
        if (r6.size() == 6) goto L8;
        if (r6.size() == 7) goto L8;
        return false;
    L8:
        if (d.o.o.c(r7, "*", false, 2, null) == false) goto L10;
    L15:
        return true;
    L10:
        if (d.o.o.c(r7, "-", false, 2, null) == true) goto L15;
        if (d.o.o.c(r7, "/", false, 2, null) == true) goto L15;
        if (d.o.o.c(r7, ",", false, 2, null) == true) goto L15;
        return false;
    }

    public final boolean isValidCron(String r4) {
        o.e(r4, "cron");
        INSTANCE.isValidCronException(r4);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        Throwable r3 = n.c(n.f(d.o.a(th)));
        if (r3 == null) goto L14;
        Logger.INSTANCE.i(TAG, "isValidCron fail cron = " + r4 + ", " + r3);
        return false;
    L14:
        return false;
    }

    public final void isValidCronException(String r2) {
        o.e(r2, "cron");
        getCronParser().a(r2).d();
    }
}
