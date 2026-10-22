package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f17161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17162b = null;

    private s() {
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
        f17161a = new s();
        f17162b = "median_distance_to_center";
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17162b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r5) {
        d.h.b.o.e(r5, "window");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r5.g(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        n r2 = (n) ZeusTransformUtils.preCheckCast(r6.next(), n.class, "com.obric.aiagent.plugin");
        Float r3 = k.a(r5.b(), r2);
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L9:
        return k.a((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"));
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
