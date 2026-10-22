package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

/* JADX INFO: compiled from: MonthlyTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends a {
    public f() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public boolean a(TimeCondition r2, PeriodicPolicy r3) {
        o.e(r2, "condition");
        o.e(r3, "policy");
        int r1 = r3.getMonthly();
        if (1 <= r1) goto L5;
        return false;
    L5:
        if (r1 < 32) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public ZonedDateTime a(h r5) {
        o.e(r5, AutoTestConstant.PARAM);
        int r0 = r5.c().getMonthly();
        ZonedDateTime r1 = r5.d().withDayOfMonth(1);
        int r2 = r1.toLocalDate().lengthOfMonth();
        if (r0 > r2) goto L6;
        r2 = r0;
    L6:
        ZonedDateTime r3 = r1.withDayOfMonth(r2);
        o.a(r3);
        ZonedDateTime r4 = a(r3, r5);
        if (r4.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5.d(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L9;
    L10:
        ZonedDateTime r6 = r4.plusMonths(1);
        int r7 = r6.toLocalDate().lengthOfMonth();
        if (r0 <= r7) goto L13;
        r0 = r7;
    L13:
        r4 = r6.withDayOfMonth(r0);
    L14:
        o.a(r4);
        return r4;
    L9:
        if (r4.isAfter((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == true) goto L14;
        goto L10
    }
}
