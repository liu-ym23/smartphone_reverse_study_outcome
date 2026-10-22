package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionGroupHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements e<ConditionGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<d.m.c<? extends Condition>, e<? extends Condition>> f17036a;

    public b(Map<d.m.c<? extends Condition>, ? extends e<? extends Condition>> r3) {
        Map<d.m.c<? extends Condition>, e<? extends Condition>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "handlers");
        this.f17036a = r4;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ a a(ConditionTask r3, Condition r4) {
        return a(r3, (ConditionGroup) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), ConditionGroup.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r3, List<ConditionGroup> r4, d.c.d<? super c> r5) {
        return e.a.a(this, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r3, List<ConditionGroup> r4, d.c.d<? super x> r5) {
        return e.a.b(this, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a a(ConditionTask r4, ConditionGroup r5) {
        o.e(r4, "task");
        o.e(r5, "condition");
        String r0 = r5.getType();
        if (o.a(r0, "and") == false) goto L12;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L28;
        a r1 = b(r4, (Condition) ZeusTransformUtils.preCheckCast(r6.next(), Condition.class, "com.obric.aiagent.plugin"));
        if (r1.a() == true) goto L6;
        return r1;
    L28:
        return a.f17016b;
    L12:
        if (o.a(r0, "or") == false) goto L21;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r7.hasNext() == false) goto L29;
        a r2 = b(r4, (Condition) ZeusTransformUtils.preCheckCast(r7.next(), Condition.class, "com.obric.aiagent.plugin"));
        if (r2.a() == false) goto L15;
        return r2;
    L29:
        return a.f17015a;
    L21:
        return a.f17015a;
    }

    private final a b(ConditionTask r3, Condition r4) {
        Condition r5 = (Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ConditionGroup.class) == true) goto L14;
        e<? extends Condition> r2 = this.f17036a.get(aa.b(r5.getClass()));
        if (ZeusTransformUtils.instanceOf(r2, e.class) == false) goto L8;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
    L9:
        if (r6 == null) goto L13;
        a r7 = r6.a(r3, r5);
        if (r7 == null) goto L13;
        return r7;
    L13:
        return a.f17015a;
    L8:
        r6 = null;
        goto L9
    L14:
        return a(r3, (ConditionGroup) ZeusTransformUtils.preCheckCast(r5, ConditionGroup.class, "com.obric.aiagent.plugin"));
    }
}
