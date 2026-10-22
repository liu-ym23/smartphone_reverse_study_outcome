package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;

/* JADX INFO: compiled from: AbstractIntervalTriggerPredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements e {
    public a() {
    }

    public final ZonedDateTime a(ZonedDateTime r5, h r6) {
        o.e(r5, "candidate");
        o.e(r6, AutoTestConstant.PARAM);
        int r0 = r6.b().getInterval() / 1000;
        if (r6.b().getInterval() >= 1800000) goto L6;
        return r5;
    L6:
        if (r6.f() == null) goto L11;
        if (r6.e().plusSeconds(r0).isAfter(r6.f()) == false) goto L11;
        return r5;
    L11:
        if (r5.isAfter((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r6.a(), ChronoZonedDateTime.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return r5;
    L14:
        if (r6.f() == null) goto L19;
        if (r6.a().toLocalTime().isBefore(r6.f()) == true) goto L19;
        return r5;
    L19:
        if (r5.toLocalDate().isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.a().toLocalDate(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == true) goto L22;
        return r5;
    L22:
        return b(r5, r6);
    }

    private final ZonedDateTime b(ZonedDateTime r8, h r9) {
        int r7 = r9.b().getInterval() / 1000;
        ZonedDateTime r0 = r9.a().withNano(0);
        long r1 = r7;
        ZonedDateTime r10 = r0.plusSeconds(r1 - ((r0.toEpochSecond() - r8.toEpochSecond()) % r1));
        if (r10.toLocalDate().isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r9.a().toLocalDate(), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return r8;
    L6:
        if (r9.f() != null) goto L8;
    L10:
        o.a(r10);
        return r10;
    L8:
        if (r10.toLocalTime().isAfter(r9.f()) == false) goto L10;
        return r8;
    }
}
