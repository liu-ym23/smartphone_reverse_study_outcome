package com.obric.eventkit.task.api;

import com.obric.eventkit.task.model.ConditionTaskRecord;
import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.EventTaskRecord;
import d.c.d;
import java.util.List;

/* JADX INFO: compiled from: EventTaskApis.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventTaskRecordApi {
    Object addExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1, d<? super List<EventTaskExecutionDetailRecord>> r2);

    Object addExecutionRecords(List<EventTaskExecutionRecord> r1, d<? super List<EventTaskExecutionRecord>> r2);

    Object getAllConditionTaskRecords(long r1, long r3, d<? super List<ConditionTaskRecord>> r5);

    Object getAllEventTaskRecords(long r1, long r3, int r5, d<? super List<? extends EventTaskRecord>> r6);

    Object getConditionTaskRecordsByTaskId(long r1, long r3, String r5, d<? super List<ConditionTaskRecord>> r6);

    Object getEventTaskRecordsByTaskId(long r1, long r3, String r5, d<? super List<? extends EventTaskRecord>> r6);

    Object getExecutionDetailRecordById(long r1, d<? super EventTaskExecutionDetailRecord> r3);

    Object getExecutionDetailRecords(int r1, int r2, d<? super List<EventTaskExecutionDetailRecord>> r3);

    Object getExecutionDetailRecordsBySessionId(String r1, int r2, int r3, d<? super List<EventTaskExecutionDetailRecord>> r4);

    Object getExecutionRecordById(long r1, d<? super EventTaskExecutionRecord> r3);

    Object getExecutionRecords(int r1, int r2, d<? super List<EventTaskExecutionRecord>> r3);

    Object getExecutionRecordsByTaskId(String r1, int r2, int r3, d<? super List<EventTaskExecutionRecord>> r4);

    Object removeAllConditionTaskRecords(d<? super Integer> r1);

    Object removeAllEventTaskRecords(int r1, d<? super Integer> r2);

    Object removeConditionTaskRecordsById(long[] r1, d<? super Integer> r2);

    Object removeEventTaskRecordsById(int r1, long[] r2, d<? super Integer> r3);

    Object removeExecutionDetailRecordsById(long[] r1, d<? super Integer> r2);

    Object removeExecutionDetailRecordsBySessionId(String r1, d<? super Integer> r2);

    Object removeExecutionRecordsById(long[] r1, d<? super Integer> r2);

    Object removeExecutionRecordsByTaskId(String r1, d<? super Integer> r2);

    Object updateExecutionDetailRecord(EventTaskExecutionDetailRecord r1, d<? super EventTaskExecutionDetailRecord> r2);

    Object updateExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1, d<? super Integer> r2);

    Object updateExecutionRecord(EventTaskExecutionRecord r1, d<? super EventTaskExecutionRecord> r2);

    Object updateExecutionRecords(List<EventTaskExecutionRecord> r1, d<? super Integer> r2);
}
