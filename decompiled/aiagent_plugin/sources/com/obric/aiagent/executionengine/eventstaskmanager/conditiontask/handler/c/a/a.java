package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LocationMonitorMetricCalculators.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17087b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17088c = 0.0f;

    private a() {
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
        f17086a = new a();
        f17087b = "accuracy_mid";
        f17088c = 1.0f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public String a() {
        return f17087b;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public float b() {
        return f17088c;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(ae r4) {
        d.h.b.o.e(r4, "window");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r4.g(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Float r1 = k.a(Float.valueOf(((n) ZeusTransformUtils.preCheckCast(r6.next(), n.class, "com.obric.aiagent.plugin")).c()));
        if (r1 == null) goto L4;
        r5.add(r1);
        goto L4
    L9:
        return k.a((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.l
    public Float a(Float r1, ae r2) {
        d.h.b.o.e(r2, "window");
        return k.a(r1, 100.0f);
    }
}
