package com.obric.eventkit.task.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TimerTaskRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskRecord {
    private final int id;
    private Long realActionTime;
    private final String sourceFrom;
    private final String taskId;
    private final int taskStatus;
    private final long triggerTime;

    public static /* synthetic */ TimerTaskRecord copy$default(TimerTaskRecord r5, int r6, String r7, long r8, Long r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.taskId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.triggerTime;
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.realActionTime;
    L14:
        Long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.sourceFrom;
    L17:
        String r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.taskStatus;
    L20:
        int r9 = r6;
        return r5.copy(r9, r15, r0, r2, r3, r12);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final Long component4() {
        return this.realActionTime;
    }

    public final String component5() {
        return this.sourceFrom;
    }

    public final int component6() {
        return this.taskStatus;
    }

    public final TimerTaskRecord copy(int r9, String r10, long r11, Long r13, String r14, int r15) {
        o.e(r10, DBDefinition.TASK_ID);
        o.e(r14, "sourceFrom");
        return new TimerTaskRecord(r9, r10, r11, r13, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerTaskRecord.class) == true) goto L8;
        return false;
    L8:
        TimerTaskRecord r10 = (TimerTaskRecord) ZeusTransformUtils.preCheckCast(r9, TimerTaskRecord.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r10.triggerTime) goto L18;
        return false;
    L18:
        if (o.a(this.realActionTime, r10.realActionTime) == true) goto L21;
        return false;
    L21:
        if (o.a(this.sourceFrom, r10.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (this.taskStatus == r10.taskStatus) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.id) * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.triggerTime)) * 31;
        Long r1 = this.realActionTime;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.sourceFrom.hashCode()) * 31) + Integer.hashCode(this.taskStatus);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TimerTaskRecord(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", realActionTime=" + this.realActionTime + ", sourceFrom=" + this.sourceFrom + ", taskStatus=" + this.taskStatus + ')';
    }

    public TimerTaskRecord(int r2, String r3, long r4, Long r6, String r7, int r8) {
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r7, "sourceFrom");
        this.id = r2;
        this.taskId = r3;
        this.triggerTime = r4;
        this.realActionTime = r6;
        this.sourceFrom = r7;
        this.taskStatus = r8;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public final Long getRealActionTime() {
        return this.realActionTime;
    }

    public final void setRealActionTime(Long r1) {
        this.realActionTime = r1;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }
}
