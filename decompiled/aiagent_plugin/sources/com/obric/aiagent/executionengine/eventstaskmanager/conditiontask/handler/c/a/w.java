package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f17169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17170b = null;

    private w() {
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
        f17169a = new w();
        f17170b = "pre_average_goal_path_speed";
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17170b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r9) {
        d.h.b.o.e(r9, "window");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast(r9.h(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        d.m r2 = (d.m) ZeusTransformUtils.preCheckCast(r10.next(), d.m.class, "com.obric.aiagent.plugin");
        n r3 = (n) ZeusTransformUtils.preCheckCast(r2.c(), n.class, "com.obric.aiagent.plugin");
        n r4 = (n) ZeusTransformUtils.preCheckCast(r2.d(), n.class, "com.obric.aiagent.plugin");
        Float r5 = Float.valueOf((r4.a() - r3.a()) / 1000.0f);
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L8;
        boolean r6 = true;
    L9:
        Float r7 = null;
        if (r6 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L19;
        float r11 = r5.floatValue();
        Float r12 = k.a(r9.b(), r3);
        if (r12 == null) goto L19;
        float r13 = r12.floatValue();
        Float r14 = k.a(r9.b(), r4);
        if (r14 == null) goto L19;
        r7 = Float.valueOf(Math.abs(r13 - r14.floatValue()) / r11);
    L19:
        if (r7 == null) goto L4;
        r0.add(r7);
        goto L4
    L8:
        r6 = false;
        goto L9
    L22:
        return k.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.b(r1, 0.5f);
    }
}
