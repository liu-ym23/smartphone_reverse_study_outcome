package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f17171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17172b = null;

    private x() {
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
        f17171a = new x();
        f17172b = "pre_average_move_speed";
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17172b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r12) {
        d.h.b.o.e(r12, "window");
        List<n> r11 = r12.h();
        Float r13 = k.b(r11);
        if (r13 == null) goto L6;
        float r14 = r13.floatValue();
        return Float.valueOf(Math.abs(k.a(((n) ZeusTransformUtils.preCheckCast(d.a.p.k(r11), n.class, "com.obric.aiagent.plugin")).d(), ((n) ZeusTransformUtils.preCheckCast(d.a.p.k(r11), n.class, "com.obric.aiagent.plugin")).e(), ((n) ZeusTransformUtils.preCheckCast(d.a.p.m(r11), n.class, "com.obric.aiagent.plugin")).d(), ((n) ZeusTransformUtils.preCheckCast(d.a.p.m(r11), n.class, "com.obric.aiagent.plugin")).e()) / r14));
    L6:
        return null;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.b(r1, 0.5f);
    }
}
