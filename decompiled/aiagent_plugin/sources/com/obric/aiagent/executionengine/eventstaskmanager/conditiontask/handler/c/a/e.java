package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f17111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17112b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17113c = 0.0f;

    private e() {
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
        f17111a = new e();
        f17112b = "after_oscillation_count";
        f17113c = 3.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17112b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17113c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r3) {
        d.h.b.o.e(r3, "window");
        List<n> r2 = r3.i();
        if (r2.size() >= 2) goto L7;
        return null;
    L7:
        return Float.valueOf(m.a(r2, r3));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        if (r1 == null) goto L9;
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue();
        float r3 = 1.0f;
        if (r0 > 1.0f) goto L11;
        r3 = d.l.n.a(r0, 0.0f);
    L11:
        return Float.valueOf(r3);
    L9:
        return null;
    }
}
