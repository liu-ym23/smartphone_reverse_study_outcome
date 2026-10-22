package com.obric.event.task.base.report;

import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ConditionMobHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PeriodicPolicy f32770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Condition> f32771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f32772c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f32770a, r6.f32770a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f32771b, r6.f32771b) == true) goto L15;
        return false;
    L15:
        if (this.f32772c == r6.f32772c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        PeriodicPolicy r0 = this.f32770a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.f32771b.hashCode()) * 31) + Boolean.hashCode(this.f32772c);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ConditionTaskReportInfo(periodicPolicy=" + this.f32770a + ", conditionList=" + this.f32771b + ", hasKnowledge=" + this.f32772c + ')';
    }

    public f(PeriodicPolicy r3, List<? extends Condition> r4, boolean r5) {
        List<Condition> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "conditionList");
        this.f32770a = r3;
        this.f32771b = r6;
        this.f32772c = r5;
    }

    public final PeriodicPolicy a() {
        return this.f32770a;
    }

    public final List<Condition> b() {
        return this.f32771b;
    }

    public final boolean c() {
        return this.f32772c;
    }
}
