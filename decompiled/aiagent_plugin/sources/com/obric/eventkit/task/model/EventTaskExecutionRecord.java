package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskExecutionRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskExecutionRecord {
    private final String complexTaskModel;
    private final long duration;
    private final Map<String, String> ext;
    private final long id;
    private final String query;
    private final int resultCode;
    private final String resultMessage;
    private final String taskId;
    private final int taskMode;
    private final int taskType;
    private final long triggerTime;

    public static /* synthetic */ EventTaskExecutionRecord copy$default(EventTaskExecutionRecord r16, long r17, int r19, int r20, String r21, String r22, long r23, long r25, int r27, String r28, Map r29, String r30, int r31, Object r32) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin");
        if ((r31 & 1) == 0) goto L5;
        long r3 = r16.id;
    L7:
        if ((r31 & 2) == 0) goto L9;
        int r5 = r16.taskType;
    L11:
        if ((r31 & 4) == 0) goto L13;
        int r6 = r16.taskMode;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r7 = r16.taskId;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r8 = r16.query;
    L23:
        if ((r31 & 32) == 0) goto L25;
        long r9 = r16.triggerTime;
    L27:
        if ((r31 & 64) == 0) goto L29;
        long r11 = r16.duration;
    L31:
        if ((r31 & 128) == 0) goto L33;
        int r13 = r16.resultCode;
    L35:
        if ((r31 & 256) == 0) goto L37;
        String r14 = r16.resultMessage;
    L39:
        if ((r31 & 512) == 0) goto L42;
        r2 = r16.ext;
    L42:
        if ((r31 & 1024) == 0) goto L44;
        String r1 = r16.complexTaskModel;
    L46:
        return r16.copy(r3, r5, r6, r7, r8, r9, r11, r13, r14, r2, r1);
    L44:
        r1 = r30;
        goto L46
    L37:
        r14 = r28;
        goto L39
    L33:
        r13 = r27;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component11() {
        return this.complexTaskModel;
    }

    public final int component2() {
        return this.taskType;
    }

    public final int component3() {
        return this.taskMode;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.query;
    }

    public final long component6() {
        return this.triggerTime;
    }

    public final long component7() {
        return this.duration;
    }

    public final int component8() {
        return this.resultCode;
    }

    public final String component9() {
        return this.resultMessage;
    }

    public final EventTaskExecutionRecord copy(long r17, int r19, int r20, String r21, String r22, long r23, long r25, int r27, String r28, Map<String, String> r29, String r30) {
        return new EventTaskExecutionRecord(r17, r19, r20, r21, r22, r23, r25, r27, r28, (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.aiagent.plugin"), r30);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EventTaskExecutionRecord.class) == true) goto L8;
        return false;
    L8:
        EventTaskExecutionRecord r10 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r9, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.taskType == r10.taskType) goto L15;
        return false;
    L15:
        if (this.taskMode == r10.taskMode) goto L18;
        return false;
    L18:
        if (o.a(this.taskId, r10.taskId) == true) goto L21;
        return false;
    L21:
        if (o.a(this.query, r10.query) == true) goto L24;
        return false;
    L24:
        if (this.triggerTime == r10.triggerTime) goto L27;
        return false;
    L27:
        if (this.duration == r10.duration) goto L30;
        return false;
    L30:
        if (this.resultCode == r10.resultCode) goto L33;
        return false;
    L33:
        if (o.a(this.resultMessage, r10.resultMessage) == true) goto L36;
        return false;
    L36:
        if (o.a(this.ext, r10.ext) == true) goto L39;
        return false;
    L39:
        if (o.a(this.complexTaskModel, r10.complexTaskModel) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.taskMode)) * 31;
        String r1 = this.taskId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.query;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + Long.hashCode(this.triggerTime)) * 31) + Long.hashCode(this.duration)) * 31) + Integer.hashCode(this.resultCode)) * 31;
        String r8 = this.resultMessage;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.complexTaskModel;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EventTaskExecutionRecord(id=").append(this.id).append(", taskType=").append(this.taskType).append(", taskMode=").append(this.taskMode).append(", taskId=").append(this.taskId).append(", query=").append(this.query).append(", triggerTime=").append(this.triggerTime).append(", duration=").append(this.duration).append(", resultCode=").append(this.resultCode).append(", resultMessage=").append(this.resultMessage).append(", ext=").append(this.ext).append(", complexTaskModel=").append(this.complexTaskModel).append(')');
        return r0.toString();
    }

    public EventTaskExecutionRecord(long r5, int r7, int r8, String r9, String r10, long r11, long r13, int r15, String r16, Map<String, String> r17, String r18) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        this.id = r5;
        this.taskType = r7;
        this.taskMode = r8;
        this.taskId = r9;
        this.query = r10;
        this.triggerTime = r11;
        this.duration = r13;
        this.resultCode = r15;
        this.resultMessage = r16;
        this.ext = r1;
        this.complexTaskModel = r18;
    }

    public /* synthetic */ EventTaskExecutionRecord(long r18, int r20, int r21, String r22, String r23, long r24, long r26, int r28, String r29, Map r30, String r31, int r32, h r33) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r32 & 1024) == 0) goto L9;
        String r16 = null;
    L10:
        this(r3, r20, r21, r22, r23, r24, r26, r28, r29, r15, r16);
        return;
    L9:
        r16 = r31;
        goto L10
    L5:
        r3 = r18;
        goto L7
    }

    public final long getId() {
        return this.id;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getQuery() {
        return this.query;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getComplexTaskModel() {
        return this.complexTaskModel;
    }
}
