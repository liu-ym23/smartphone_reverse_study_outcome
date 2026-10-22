package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f17159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17160b = null;

    private r() {
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
        f17159a = new r();
        f17160b = "median_distance_delta";
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17160b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r12) {
        d.h.b.o.e(r12, "window");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast(r12.g(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r14.next(), d.m.class, "com.obric.aiagent.plugin");
        n r2 = (n) ZeusTransformUtils.preCheckCast(r1.c(), n.class, "com.obric.aiagent.plugin");
        n r3 = (n) ZeusTransformUtils.preCheckCast(r1.d(), n.class, "com.obric.aiagent.plugin");
        r13.add(Float.valueOf(k.a(r2.d(), r2.e(), r3.d(), r3.e())));
        goto L4
    L7:
        return k.a((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));
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
