package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: YearlyTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends a {
    public j() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public boolean a(TimeCondition r1, PeriodicPolicy r2) {
        o.e(r1, "condition");
        o.e(r2, "policy");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getYearly(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public ZonedDateTime a(h r8) {
        o.e(r8, AutoTestConstant.PARAM);
        MonthDay r2 = MonthDay.parse((CharSequence) ZeusTransformUtils.preCheckCast(r8.c().getYearly(), CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ofPattern("MM-dd"));     // Catch: Exception -> L32
        int r3 = r8.a().getYear();     // Catch: Exception -> L32
        if (r2.getMonthValue() == 2) goto L6;
    L20:
        ZonedDateTime r4 = r8.d().withMonth(r2.getMonthValue()).withDayOfMonth(r2.getDayOfMonth());     // Catch: Exception -> L32
        o.c(r4, "withDayOfMonth(...)");     // Catch: Exception -> L32
        ZonedDateTime r7 = a(r4, r8);     // Catch: Exception -> L32
        if (r7.isAfter((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r8.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == true) goto L23;
    L24:
        r3 = r3 + 1;     // Catch: Exception -> L32
    L25:
        LocalDate r0 = LocalDate.of(r3, r2.getMonthValue(), r2.getDayOfMonth());     // Catch: Exception -> L32
        if (r7 == null) goto L29;
        LocalTime r9 = r7.toLocalTime();     // Catch: Exception -> L32
        if (r9 == null) goto L29;
    L30:
        return ZonedDateTime.of(r0, r9, r8.d().getZone());
    L29:
        r9 = r8.e();     // Catch: Exception -> L32
        goto L30
    L23:
        if (r7.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r8.d(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L25;
    L6:
        if (r2.getDayOfMonth() != 29) goto L20;
        if (a(r3) == false) goto L13;
        ZonedDateTime r5 = r8.d().withMonth(2).withDayOfMonth(29);     // Catch: Exception -> L32
        o.a(r5);     // Catch: Exception -> L32
        r7 = a(r5, r8);     // Catch: Exception -> L32
        if (r7.isAfter((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r8.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L13;
        if (r7.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r8.d(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == true) goto L13;
    L15:
        if (a(r3) == false) goto L17;
        if (r7 != null) goto L25;
    L17:
        r3 = r3 + 1;     // Catch: Exception -> L32
        if (a(r3) == false) goto L17;
    L13:
        r7 = null;
    L32:
        return null;
    }

    private static final boolean a(int r2) {
        return Year.isLeap(r2);
    }
}
