package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ac implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f17093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17094b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17095c = 0.0f;

    private ac() {
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
        f17093a = new ac();
        f17094b = "trigger_accuracy";
        f17095c = 1.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17094b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17095c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r1) {
        d.h.b.o.e(r1, "window");
        return k.a(Float.valueOf(r1.c().c()));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.a(r1, 100.0f);
    }
}
