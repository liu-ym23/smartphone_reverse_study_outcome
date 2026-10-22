package com.obric.eventkit.task.api;

import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskRecord;
import com.obric.eventkit.task.model.TimerTaskResult;
import d.c.d;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskApis.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ILegacyTimerApi {
    Object addTimerTask(TimerTask r1, d<? super TimerTaskResult> r2);

    Object getAllTimerTaskRecords(long r1, long r3, d<? super List<TimerTaskRecord>> r5);

    Object getAllTimerTasks(d<? super List<TimerTask>> r1);

    Object getNextScheduleTimestamp(int r1, d<? super Long> r2);

    Object getTimerTaskByTaskId(int r1, d<? super TimerTask> r2);

    Object getTimerTaskRecordsByTaskId(long r1, long r3, int r5, d<? super List<TimerTaskRecord>> r6);

    Object getTimerTasks(Map<Object, ? extends Object> r1, d<? super List<TimerTask>> r2);

    Object registerTimerTaskChangeListener(a r1, d<? super x> r2);

    Object removeAllTimerTaskRecords(d<? super Integer> r1);

    Object removeTimerTask(Map<Object, ? extends Object> r1, d<? super TimerTaskResult> r2);

    Object removeTimerTaskRecordsById(int[] r1, d<? super Integer> r2);

    Object removeTimerTasksByTaskId(List<Integer> r1, d<? super TimerTaskResult> r2);

    Object skipTimerTasksByTaskId(int r1, long[] r2, d<? super TimerTaskResult> r3);

    Object unregisterTimerTaskChangeListener(a r1, d<? super x> r2);

    Object updateTimerTask(TimerTask r1, d<? super TimerTaskResult> r2);
}
