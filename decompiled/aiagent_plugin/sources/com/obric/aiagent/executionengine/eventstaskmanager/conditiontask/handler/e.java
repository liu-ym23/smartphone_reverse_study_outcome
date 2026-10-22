package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: IConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface e<C extends Condition> {

    /* JADX INFO: compiled from: IConditionHandler.kt */
    public static final class a {
        public static <C extends Condition> Object a(e<C> r1, ConditionTask r2, List<? extends C> r3, d.c.d<? super c> r4) {
            e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return c.a.a(c.f17052a, 0, 1, null);
        }

        public static <C extends Condition> Object b(e<C> r1, ConditionTask r2, List<? extends C> r3, d.c.d<? super x> r4) {
            e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r1, e.class, "com.obric.aiagent.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return x.f38692a;
        }
    }

    com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r1, C r2);

    Object a(ConditionTask r1, List<? extends C> r2, d.c.d<? super c> r3);

    Object b(ConditionTask r1, List<? extends C> r2, d.c.d<? super x> r3);
}
