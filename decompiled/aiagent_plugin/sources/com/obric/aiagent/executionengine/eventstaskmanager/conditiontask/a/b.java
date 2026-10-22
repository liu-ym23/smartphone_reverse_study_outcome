package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

/* JADX INFO: compiled from: DailyTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public b() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public boolean a(TimeCondition r1, PeriodicPolicy r2) {
        o.e(r1, "condition");
        o.e(r2, "policy");
        return r2.getDaily();
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a.e
    public ZonedDateTime a(h r5) {
        o.e(r5, AutoTestConstant.PARAM);
        if (r5.a().compareTo((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5.d(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) < 0) goto L5;
        ZonedDateTime r4 = a(r5.d(), r5);
        if (r4.compareTo((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r5.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) >= 0) goto L10;
        ZonedDateTime r6 = r5.d().plusDays(1);
        o.a(r6);
        return r6;
    L10:
        return r4;
    L5:
        return r5.d();
    }
}
