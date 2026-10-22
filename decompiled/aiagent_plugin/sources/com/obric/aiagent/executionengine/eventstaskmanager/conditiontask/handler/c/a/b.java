package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17105b = null;

    private b() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return l.a.b(this);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String c() {
        return l.a.a(this);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float d() {
        return l.a.c(this);
    }

    static {
        f17104a = new b();
        f17105b = "after_average_goal_move_speed";
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17105b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r7) {
        d.h.b.o.e(r7, "window");
        List<n> r6 = r7.i();
        Float r0 = k.b(r6);
        if (r0 == null) goto L10;
        float r1 = r0.floatValue();
        Float r2 = k.a(r7.b(), (n) ZeusTransformUtils.preCheckCast(d.a.p.k(r6), n.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L10;
        float r3 = r2.floatValue();
        Float r8 = k.a(r7.b(), (n) ZeusTransformUtils.preCheckCast(d.a.p.m(r6), n.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L10;
        return Float.valueOf(Math.abs(r8.floatValue() - r3) / r1);
    L10:
        return null;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.b(r1, 0.1f);
    }
}
