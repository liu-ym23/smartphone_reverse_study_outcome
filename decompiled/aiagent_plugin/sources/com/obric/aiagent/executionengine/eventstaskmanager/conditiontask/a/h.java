package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalTime;
import java.time.ZonedDateTime;

/* JADX INFO: compiled from: INextTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ZonedDateTime f16736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeCondition f16737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PeriodicPolicy f16738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZonedDateTime f16739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LocalTime f16740e;
    private final LocalTime f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16736a, r6.f16736a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f16737b, r6.f16737b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16738c, r6.f16738c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f16739d, r6.f16739d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f16740e, r6.f16740e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f16736a.hashCode() * 31) + this.f16737b.hashCode()) * 31) + this.f16738c.hashCode()) * 31) + this.f16739d.hashCode()) * 31) + this.f16740e.hashCode()) * 31;
        LocalTime r2 = this.f;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "TriggerTimePredictParam(now=" + this.f16736a + ", condition=" + this.f16737b + ", policy=" + this.f16738c + ", startDateTime=" + this.f16739d + ", startTime=" + this.f16740e + ", endTime=" + this.f + ')';
    }

    public h(ZonedDateTime r2, TimeCondition r3, PeriodicPolicy r4, ZonedDateTime r5, LocalTime r6, LocalTime r7) {
        o.e(r2, "now");
        o.e(r3, "condition");
        o.e(r4, "policy");
        o.e(r5, "startDateTime");
        o.e(r6, "startTime");
        this.f16736a = r2;
        this.f16737b = r3;
        this.f16738c = r4;
        this.f16739d = r5;
        this.f16740e = r6;
        this.f = r7;
    }

    public final ZonedDateTime a() {
        return this.f16736a;
    }

    public final TimeCondition b() {
        return this.f16737b;
    }

    public final PeriodicPolicy c() {
        return this.f16738c;
    }

    public final ZonedDateTime d() {
        return this.f16739d;
    }

    public final LocalTime e() {
        return this.f16740e;
    }

    public final LocalTime f() {
        return this.f;
    }
}
