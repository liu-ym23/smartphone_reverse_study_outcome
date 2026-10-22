package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NextTriggerTimePredictorManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f16734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f16735b = null;

    private g() {
    }

    static {
        f16734a = new g();
        f16735b = p.b(new a[]{new b(), new i(), new f(), new j(), new c(), new d()});
    }

    public final long a(TimeCondition r11, PeriodicPolicy r12, long r13) {
        o.e(r11, "condition");
        o.e(r12, "policy");
        String r10 = r11.getStart();
        ZoneId r0 = ZoneId.systemDefault();
        long r14 = r13 * ((long) 1000000);
        ZonedDateTime r1 = ZonedDateTime.now(r0).minusNanos(r14);
        if (r12.getStartDate() == null) goto L8;
        LocalDate r2 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r12.getStartDate(), CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (r2.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r1.toLocalDate(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == true) goto L9;
        r2 = r1.toLocalDate();
    L9:
        DateTimeFormatter r3 = DateTimeFormatter.ofPattern("H:mm");
        LocalTime r7 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), r3);
        ZonedDateTime r15 = ZonedDateTime.of(r2, r7, r0);
        o.a(r1);
        o.a(r15);
        o.a(r7);
        String r4 = r11.getEnd();
        if (r4 == null) goto L12;
        LocalTime r5 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), r3);
    L13:
        h r6 = new h(r1, r11, r12, r15, r7, r5);
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<a> r9 = f16735b.iterator();
    L15:
        if (r9.hasNext() == false) goto L23;
        a r16 = (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.aiagent.plugin");
        if (r16.a(r11, r12) == false) goto L15;
        ZonedDateTime r17 = r16.a(r6);
        if (r17 == null) goto L15;
        r8.add(r17);
        goto L15
    L23:
        if (r8.isEmpty() == true) goto L25;
        Comparable r18 = p.w((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"));
        o.a(r18);
        return ((ZonedDateTime) ZeusTransformUtils.preCheckCast(r18, ZonedDateTime.class, "com.obric.aiagent.plugin")).plusNanos(r14).toInstant().toEpochMilli();
    L25:
        if (r1.compareTo((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r15, ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) < 0) goto L38;
        r15 = r15.plusDays(1);
    L38:
        return r15.plusNanos(r14).toInstant().toEpochMilli();
    L12:
        r5 = null;
        goto L13
    L8:
        r2 = r1.toLocalDate();
        goto L9
    }
}
