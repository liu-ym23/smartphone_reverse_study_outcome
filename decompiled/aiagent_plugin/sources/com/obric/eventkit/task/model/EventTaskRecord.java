package com.obric.eventkit.task.model;

/* JADX INFO: compiled from: EventTaskRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
public class EventTaskRecord {
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;
    private final int type;

    public EventTaskRecord(int r1, long r2, String r4, long r5, String r7, int r8) {
        this.type = r1;
        this.id = r2;
        this.taskId = r4;
        this.triggerTime = r5;
        this.sourceFrom = r7;
        this.result = r8;
    }

    public final int getType() {
        return this.type;
    }

    public long getId() {
        return this.id;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public String getSourceFrom() {
        return this.sourceFrom;
    }

    public int getResult() {
        return this.result;
    }
}
