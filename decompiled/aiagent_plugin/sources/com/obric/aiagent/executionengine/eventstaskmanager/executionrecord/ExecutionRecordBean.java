package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ExecutionRecordBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExecutionRecordBean {
    private final String complexTaskModel;
    private final long createTime;
    private final long duration;
    private final Map<String, String> ext;
    private final long id;
    private final String query;
    private final int resultCode;
    private final String resultMessage;
    private final String sourceFrom;
    private final String taskId;
    private final int taskMode;
    private final int taskType;
    private final long triggerTime;

    public static /* synthetic */ ExecutionRecordBean copy$default(ExecutionRecordBean r16, String r17, int r18, int r19, String r20, long r21, long r23, int r25, String r26, String r27, Map r28, String r29, long r30, long r32, int r34, Object r35) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.aiagent.plugin");
        if ((r34 & 1) == 0) goto L5;
        String r3 = r16.taskId;
    L7:
        if ((r34 & 2) == 0) goto L9;
        int r4 = r16.taskType;
    L11:
        if ((r34 & 4) == 0) goto L13;
        int r5 = r16.taskMode;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r6 = r16.query;
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r7 = r16.triggerTime;
    L23:
        if ((r34 & 32) == 0) goto L25;
        long r9 = r16.duration;
    L27:
        if ((r34 & 64) == 0) goto L29;
        int r11 = r16.resultCode;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r12 = r16.resultMessage;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r13 = r16.complexTaskModel;
    L39:
        if ((r34 & 512) == 0) goto L42;
        r2 = r16.ext;
    L42:
        if ((r34 & 1024) == 0) goto L44;
        String r14 = r16.sourceFrom;
    L45:
        String r210 = r14;
        if ((r34 & 2048) == 0) goto L48;
        long r15 = r16.createTime;
    L49:
        long r31 = r15;
        if ((r34 & 4096) == 0) goto L52;
        long r110 = r16.id;
    L54:
        return r16.copy(r3, r4, r5, r6, r7, r9, r11, r12, r13, r2, r210, r31, r110);
    L52:
        r110 = r32;
        goto L54
    L48:
        r15 = r30;
        goto L49
    L44:
        r14 = r29;
        goto L45
    L37:
        r13 = r27;
        goto L39
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component11() {
        return this.sourceFrom;
    }

    public final long component12() {
        return this.createTime;
    }

    public final long component13() {
        return this.id;
    }

    public final int component2() {
        return this.taskType;
    }

    public final int component3() {
        return this.taskMode;
    }

    public final String component4() {
        return this.query;
    }

    public final long component5() {
        return this.triggerTime;
    }

    public final long component6() {
        return this.duration;
    }

    public final int component7() {
        return this.resultCode;
    }

    public final String component8() {
        return this.resultMessage;
    }

    public final String component9() {
        return this.complexTaskModel;
    }

    public final ExecutionRecordBean copy(String r20, int r21, int r22, String r23, long r24, long r26, int r28, String r29, String r30, Map<String, String> r31, String r32, long r33, long r35) {
        return new ExecutionRecordBean(r20, r21, r22, r23, r24, r26, r28, r29, r30, (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin"), r32, r33, r35);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ExecutionRecordBean.class) == true) goto L8;
        return false;
    L8:
        ExecutionRecordBean r10 = (ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r9, ExecutionRecordBean.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r10.taskId) == true) goto L12;
        return false;
    L12:
        if (this.taskType == r10.taskType) goto L15;
        return false;
    L15:
        if (this.taskMode == r10.taskMode) goto L18;
        return false;
    L18:
        if (o.a(this.query, r10.query) == true) goto L21;
        return false;
    L21:
        if (this.triggerTime == r10.triggerTime) goto L24;
        return false;
    L24:
        if (this.duration == r10.duration) goto L27;
        return false;
    L27:
        if (this.resultCode == r10.resultCode) goto L30;
        return false;
    L30:
        if (o.a(this.resultMessage, r10.resultMessage) == true) goto L33;
        return false;
    L33:
        if (o.a(this.complexTaskModel, r10.complexTaskModel) == true) goto L36;
        return false;
    L36:
        if (o.a(this.ext, r10.ext) == true) goto L39;
        return false;
    L39:
        if (o.a(this.sourceFrom, r10.sourceFrom) == true) goto L42;
        return false;
    L42:
        if (this.createTime == r10.createTime) goto L45;
        return false;
    L45:
        if (this.id == r10.id) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.taskMode)) * 31;
        String r4 = this.query;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((r3 + r5) * 31) + Long.hashCode(this.triggerTime)) * 31) + Long.hashCode(this.duration)) * 31) + Integer.hashCode(this.resultCode)) * 31;
        String r7 = this.resultMessage;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.complexTaskModel;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.ext;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.sourceFrom;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return ((((r15 + r1) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.id);
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ExecutionRecordBean(taskId=").append(this.taskId).append(", taskType=").append(this.taskType).append(", taskMode=").append(this.taskMode).append(", query=").append(this.query).append(", triggerTime=").append(this.triggerTime).append(", duration=").append(this.duration).append(", resultCode=").append(this.resultCode).append(", resultMessage=").append(this.resultMessage).append(", complexTaskModel=").append(this.complexTaskModel).append(", ext=").append(this.ext).append(", sourceFrom=").append(this.sourceFrom).append(", createTime=");
        r0.append(this.createTime).append(", id=").append(this.id).append(')');
        return r0.toString();
    }

    public ExecutionRecordBean(String r5, int r6, int r7, String r8, long r9, long r11, int r13, String r14, String r15, Map<String, String> r16, String r17, long r18, long r20) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        this.taskId = r5;
        this.taskType = r6;
        this.taskMode = r7;
        this.query = r8;
        this.triggerTime = r9;
        this.duration = r11;
        this.resultCode = r13;
        this.resultMessage = r14;
        this.complexTaskModel = r15;
        this.ext = r1;
        this.sourceFrom = r17;
        this.createTime = r18;
        this.id = r20;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final int getTaskMode() {
        return this.taskMode;
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

    public final String getComplexTaskModel() {
        return this.complexTaskModel;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public /* synthetic */ ExecutionRecordBean(String r21, int r22, int r23, String r24, long r25, long r27, int r29, String r30, String r31, Map r32, String r33, long r34, long r36, int r38, h r39) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        if ((r38 & 2048) == 0) goto L5;
        long r16 = System.currentTimeMillis();
    L7:
        if ((r38 & 4096) == 0) goto L9;
        long r18 = 0;
    L10:
        this(r21, r22, r23, r24, r25, r27, r29, r30, r31, r14, r33, r16, r18);
        return;
    L9:
        r18 = r36;
        goto L10
    L5:
        r16 = r34;
        goto L7
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getId() {
        return this.id;
    }
}
