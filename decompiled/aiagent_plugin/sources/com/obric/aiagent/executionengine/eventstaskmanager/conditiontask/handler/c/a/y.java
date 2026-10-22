package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f17173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17174b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17175c = 0.0f;

    private y() {
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
        f17173a = new y();
        f17174b = "pre_average_path_speed";
        f17175c = 2.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17174b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17175c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r13) {
        d.h.b.o.e(r13, "window");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.x((Iterable) ZeusTransformUtils.preCheckCast(r13.h(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L18;
        d.m r1 = (d.m) ZeusTransformUtils.preCheckCast(r15.next(), d.m.class, "com.obric.aiagent.plugin");
        n r2 = (n) ZeusTransformUtils.preCheckCast(r1.c(), n.class, "com.obric.aiagent.plugin");
        n r3 = (n) ZeusTransformUtils.preCheckCast(r1.d(), n.class, "com.obric.aiagent.plugin");
        Float r4 = Float.valueOf((r3.a() - r2.a()) / 1000.0f);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L8;
        boolean r5 = true;
    L9:
        Float r6 = null;
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        r6 = Float.valueOf(Math.abs(k.a(r2.d(), r2.e(), r3.d(), r3.e()) / r4.floatValue()));
    L15:
        if (r6 == null) goto L4;
        r14.add(r6);
        goto L4
    L8:
        r5 = false;
        goto L9
    L18:
        return k.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.b(r1, 1.0f);
    }
}
