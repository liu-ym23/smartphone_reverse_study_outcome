package com.obric.eventkit.task.api;

import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import d.c.d;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskApis.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventTaskApi {
    Object addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map<String, String> r6, d<? super ConditionTaskResult> r7);

    Object addEventTask(EventTaskSpec r1, d<? super EventTaskResult> r2);

    Object getAllEventTasks(d<? super List<? extends EventTask>> r1);

    Object getConditionTask(String r1, d<? super ConditionTask> r2);

    Object getEventTask(String r1, d<? super EventTask> r2);

    Object getEventTasksByType(int r1, int r2, int r3, d<? super List<? extends EventTask>> r4);

    Object getKnowledgeSessionIdNotNullEventTasks(d<? super List<? extends EventTask>> r1);

    Object getShortInstructNotNullShortcutTasks(d<? super List<ShortcutTask>> r1);

    Object getTemplateIdNotNullEventTasks(d<? super List<? extends EventTask>> r1);

    Object removeConditionTask(String[] r1, d<? super ConditionTaskResult> r2);

    Object removeEventTask(String[] r1, d<? super EventTaskResult> r2);

    Object updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map<String, String> r8, d<? super ConditionTaskResult> r9);

    Object updateEventTask(String r1, EventTaskSpec r2, d<? super EventTaskResult> r3);

    Object updateEventTaskDisplayOrder(int r1, List<String> r2, d<? super Boolean> r3);
}
