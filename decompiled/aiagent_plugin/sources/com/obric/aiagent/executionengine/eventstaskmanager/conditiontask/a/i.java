package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.temporal.TemporalAdjusters;

/* JADX INFO: compiled from: WeeklyTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends a {
    public i() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public boolean a(TimeCondition r1, PeriodicPolicy r2) {
        o.e(r1, "condition");
        o.e(r2, "policy");
        if (r2.getWeekly() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public ZonedDateTime a(h r10) {
        o.e(r10, AutoTestConstant.PARAM);
        int[] r0 = r10.c().getWeekly();
        ZonedDateTime r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = r0.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L24;
        int r5 = r0[r4];
        boolean r6 = true;
        if (1 <= r5) goto L10;
    L12:
        r6 = false;
    L13:
        if (r6 == false) goto L23;
        ZonedDateTime r7 = r10.d().with(TemporalAdjusters.nextOrSame(DayOfWeek.of(r5)));
        o.a(r7);
        ZonedDateTime r8 = a(r7, r10);
        if (r8.isAfter((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r10.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == true) goto L17;
    L18:
        r8 = r8.plusWeeks(1);
    L19:
        if (r1 != null) goto L21;
    L22:
        r1 = r8;
        goto L23
    L21:
        if (r8.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r1, ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L23;
    L17:
        if (r8.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r10.d(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L19;
    L23:
        r4 = r4 + 1;
        goto L6
    L10:
        if (r5 >= 8) goto L12;
    L24:
        return r1;
    }
}
