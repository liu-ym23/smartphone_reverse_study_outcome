package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f17176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17178c = 0.0f;

    private z() {
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
        f17176a = new z();
        f17177b = "pre_meet_trigger_count";
        f17178c = 1.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17177b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float d() {
        return f17178c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r6) {
        d.h.b.o.e(r6, "window");
        List<n> r5 = r6.d();
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Boolean r3 = k.c(r6.b(), (n) ZeusTransformUtils.preCheckCast(r8.next(), n.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L7;
        r0.add(r3);
        goto L7
    L11:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == false) goto L14;
        return null;
    L14:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L17;
    L19:
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L28;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.next(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
        r1 = r1 + 1;
        if (r1 >= 0) goto L21;
        d.a.p.d();
    L28:
        return Float.valueOf(r1 / r9.size());
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
        goto L19
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        if (r1 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(d.l.n.a(r1.floatValue(), 0.0f, 1.0f));
    }
}
