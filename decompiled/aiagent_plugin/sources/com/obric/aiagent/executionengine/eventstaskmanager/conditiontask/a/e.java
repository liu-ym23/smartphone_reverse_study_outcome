package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a;

import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import java.time.ZonedDateTime;

/* JADX INFO: compiled from: INextTriggerTimePredictor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface e {
    ZonedDateTime a(h r1);

    boolean a(TimeCondition r1, PeriodicPolicy r2);
}
