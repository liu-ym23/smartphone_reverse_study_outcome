package com.obric.eventkit.task.utils;

import android.os.Build;
import com.a.c.a.d;
import com.a.c.c;
import com.a.c.c.b;
import com.a.d.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.n;
import d.x;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/* JADX INFO: compiled from: CronHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CronHelper {
    public static final CronHelper INSTANCE = null;
    private static final String TAG = "CronHelper";
    private static final f cronParser$delegate = null;

    public static /* synthetic */ a lambda$BK4hgYGXuXiLSY0YtJW0AnOyryE() {
        return cronParser_delegate$lambda$0();
    }

    private CronHelper() {
    }

    static {
        INSTANCE = new CronHelper();
        cronParser$delegate = g.a($$Lambda$CronHelper$BK4hgYGXuXiLSY0YtJW0AnOyryE.INSTANCE);
    }

    private final a getCronParser() {
        return (a) ZeusTransformUtils.preCheckCast(cronParser$delegate.b(), a.class, "com.obric.aiagent.plugin");
    }

    private static final a cronParser_delegate$lambda$0() {
        return new a(d.a(c.f3139b));
    }

    public final boolean isTimeRecurring(String r8) {
        o.e(r8, "cron");
        List r7 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{" "}, false, 0, 6, null);
        if (r7.size() == 6) goto L8;
        if (r7.size() == 7) goto L8;
        return false;
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L10;
    L15:
        return true;
    L10:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("-", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L15;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L15;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L15;
        return false;
    }

    public static /* synthetic */ Long getNextScheduleTime$default(CronHelper r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getNextScheduleTime(r1, r2);
    }

    public final Long getNextScheduleTime(String r3, Long r4) {
        o.e(r3, "cron");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L14
        b r5 = b.a(INSTANCE.getCronParser().a(r3));     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (r4 == null) goto L7;
        ZonedDateTime r6 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(r4.longValue()), ZoneId.systemDefault());     // Catch: Throwable -> L14
    L8:
        ZonedDateTime r7 = (ZonedDateTime) ZeusTransformUtils.preCheckCast(r5.a(r6).orElse(null), ZonedDateTime.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r7 == null) goto L12;
        return Long.valueOf(r7.toInstant().toEpochMilli());
    L7:
        r6 = ZonedDateTime.now();     // Catch: Throwable -> L14
    L12:
        n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        return null;
    L14:
        th = move-exception;
        n.a r8 = n.f38560a;
        n.f(d.o.a(th));
        goto L16
    }

    public final boolean isValidCron(String r1) {
        o.e(r1, "cron");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L6
        INSTANCE.isValidCronException(r1);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        n.a r2 = n.f38560a;
        n.f(d.o.a(th));
        return false;
    }

    public final void isValidCronException(String r2) {
        o.e(r2, "cron");
        getCronParser().a(r2).d();
    }
}
