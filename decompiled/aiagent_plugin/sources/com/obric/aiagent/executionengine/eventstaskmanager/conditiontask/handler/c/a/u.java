package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f17164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17166c = 0.0f;

    private u() {
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
        f17164a = new u();
        f17165b = "oscillation_count";
        f17166c = 2.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17165b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17166c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r3) {
        d.h.b.o.e(r3, "window");
        List<n> r2 = r3.g();
        if (r2.size() >= 2) goto L7;
        return null;
    L7:
        return Float.valueOf(m.a(r2, r3));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r3, ae r4) {
        d.h.b.o.e(r4, "window");
        Integer r2 = Integer.valueOf(r4.g().size());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L15;
        int r6 = r2.intValue();
        if (r3 != null) goto L14;
        return null;
    L14:
        return Float.valueOf(d.l.n.a((((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).floatValue() - 1.0f) / r6, 0.0f, 1.0f));
    L15:
        return null;
    L5:
        r5 = false;
        goto L7
    }
}
