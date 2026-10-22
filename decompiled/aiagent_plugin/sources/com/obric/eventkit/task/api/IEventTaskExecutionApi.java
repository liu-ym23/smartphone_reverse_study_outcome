package com.obric.eventkit.task.api;

import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import d.c.d;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: EventTaskApis.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventTaskExecutionApi {
    Object scheduleShortcutTask(String r1, String r2, d<? super x> r3);

    Object skipConditionTaskSchedule(String r1, d<? super x> r2);

    Object tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5, d<? super x> r6);
}
