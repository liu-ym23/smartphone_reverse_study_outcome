package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ad implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad f17096a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17097b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17098c = 0.0f;

    private ad() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return l.a.b(this);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String c() {
        return l.a.a(this);
    }

    static {
        f17096a = new ad();
        f17097b = "trigger_boundary_distance";
        f17098c = 1.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17097b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float d() {
        return f17098c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r2) {
        d.h.b.o.e(r2, "window");
        Float r1 = k.b(r2.b(), r2.c());
        if (r1 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(Math.abs(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue()));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r2, ae r3) {
        d.h.b.o.e(r3, "window");
        if (r2 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(d.l.n.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).floatValue() / k.a(r3.b()), 0.0f, 1.0f));
    }
}
