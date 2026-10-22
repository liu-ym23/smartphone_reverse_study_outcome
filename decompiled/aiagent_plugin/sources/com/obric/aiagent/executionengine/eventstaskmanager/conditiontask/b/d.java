package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: ConditionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final <T extends Condition> boolean a(ConditionGroup r4, d.m.c<T> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r5, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r6, "type");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(a(r4), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (r6.a((Condition) ZeusTransformUtils.preCheckCast(r8.next(), Condition.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public static final <T extends Condition> boolean b(ConditionGroup r4, d.m.c<T> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r5, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r6, "type");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(a(r4), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        if (r6.a((Condition) ZeusTransformUtils.preCheckCast(r8.next(), Condition.class, "com.obric.aiagent.plugin")) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    public static final List<Condition> a(ConditionGroup r1) {
        o.e(r1, "<this>");
        return c(r1, aa.b(Condition.class));
    }

    public static final <T extends Condition> List<T> c(ConditionGroup r4, d.m.c<T> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r5, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        o.e(r6, "type");
        ArrayList r0 = new ArrayList();
        LinkedList r2 = new LinkedList((Collection) ZeusTransformUtils.preCheckCast(p.a(r4), Collection.class, "com.obric.aiagent.plugin"));
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L13;
        Condition r7 = (Condition) ZeusTransformUtils.preCheckCast(r2.poll(), Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ConditionGroup.class) == true) goto L7;
        if (r7 == null) goto L4;
        if (r6.a(r7) == false) goto L4;
        r0.add(r7);
        goto L4
    L7:
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(((ConditionGroup) ZeusTransformUtils.preCheckCast(r7, ConditionGroup.class, "com.obric.aiagent.plugin")).getConditions(), Collection.class, "com.obric.aiagent.plugin"));
        goto L4
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }
}
