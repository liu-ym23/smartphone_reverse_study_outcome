package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class aa implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f17089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17091c = 0.0f;

    private aa() {
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
        f17089a = new aa();
        f17090b = "pre_move_trend";
        f17091c = 2.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17090b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17091c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r1) {
        d.h.b.o.e(r1, "window");
        return m.a(r1.h(), r1.b());
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.b(r1);
    }
}
