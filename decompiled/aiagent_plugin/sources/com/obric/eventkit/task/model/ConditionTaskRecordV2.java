package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTaskRecordV2.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskRecordV2 extends EventTaskRecord {
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static /* synthetic */ ConditionTaskRecordV2 copy$default(ConditionTaskRecordV2 r8, long r9, String r11, long r12, String r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.id;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.taskId;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r4 = r8.triggerTime;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r6 = r8.sourceFrom;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r7 = r8.result;
    L23:
        return r8.copy(r1, r3, r4, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.taskId;
    }

    public final long component3() {
        return this.triggerTime;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final int component5() {
        return this.result;
    }

    public final ConditionTaskRecordV2 copy(long r9, String r11, long r12, String r14, int r15) {
        return new ConditionTaskRecordV2(r9, r11, r12, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ConditionTaskRecordV2.class) == true) goto L8;
        return false;
    L8:
        ConditionTaskRecordV2 r10 = (ConditionTaskRecordV2) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordV2.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (o.a(this.taskId, r10.taskId) == true) goto L15;
        return false;
    L15:
        if (this.triggerTime == r10.triggerTime) goto L18;
        return false;
    L18:
        if (o.a(this.sourceFrom, r10.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (this.result == r10.result) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        String r1 = this.taskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.triggerTime)) * 31;
        String r5 = this.sourceFrom;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Integer.hashCode(this.result);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ConditionTaskRecordV2(id=" + this.id + ", taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", sourceFrom=" + this.sourceFrom + ", result=" + this.result + ')';
    }

    @Override // com.obric.eventkit.task.model.EventTaskRecord
    public long getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.task.model.EventTaskRecord
    public String getTaskId() {
        return this.taskId;
    }

    @Override // com.obric.eventkit.task.model.EventTaskRecord
    public long getTriggerTime() {
        return this.triggerTime;
    }

    @Override // com.obric.eventkit.task.model.EventTaskRecord
    public String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.eventkit.task.model.EventTaskRecord
    public int getResult() {
        return this.result;
    }

    public ConditionTaskRecordV2(long r11, String r13, long r14, String r16, int r17) {
        super(2, r11, r13, r14, r16, r17);
        this.id = r11;
        this.taskId = r13;
        this.triggerTime = r14;
        this.sourceFrom = r16;
        this.result = r17;
    }
}
