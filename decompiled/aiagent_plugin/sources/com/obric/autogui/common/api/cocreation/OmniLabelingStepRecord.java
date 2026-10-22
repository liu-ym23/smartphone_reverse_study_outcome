package com.obric.autogui.common.api.cocreation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IOmniLabelingDataSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingStepRecord {
    private final long createdAt;
    private final long finishTimeMillis;
    private final boolean isLastStep;
    private final boolean isSuccess;
    private final String modelReply;
    private final String recordId;
    private final String stepDescription;
    private final int stepIndex;
    private final String taskTriggerType;
    private final String userQuery;

    public static /* synthetic */ OmniLabelingStepRecord copy$default(OmniLabelingStepRecord r13, String r14, long r15, String r17, int r18, String r19, String r20, boolean r21, boolean r22, long r23, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.recordId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r3 = r13.createdAt;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r5 = r13.userQuery;
    L15:
        if ((r26 & 8) == 0) goto L17;
        int r6 = r13.stepIndex;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r7 = r13.stepDescription;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r8 = r13.modelReply;
    L27:
        if ((r26 & 64) == 0) goto L29;
        boolean r9 = r13.isLastStep;
    L31:
        if ((r26 & 128) == 0) goto L33;
        boolean r10 = r13.isSuccess;
    L35:
        if ((r26 & 256) == 0) goto L37;
        long r11 = r13.finishTimeMillis;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r1 = r13.taskTriggerType;
    L43:
        return r13.copy(r2, r3, r5, r6, r7, r8, r9, r10, r11, r1);
    L41:
        r1 = r25;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.recordId;
    }

    public final String component10() {
        return this.taskTriggerType;
    }

    public final long component2() {
        return this.createdAt;
    }

    public final String component3() {
        return this.userQuery;
    }

    public final int component4() {
        return this.stepIndex;
    }

    public final String component5() {
        return this.stepDescription;
    }

    public final String component6() {
        return this.modelReply;
    }

    public final boolean component7() {
        return this.isLastStep;
    }

    public final boolean component8() {
        return this.isSuccess;
    }

    public final long component9() {
        return this.finishTimeMillis;
    }

    public final OmniLabelingStepRecord copy(String r15, long r16, String r18, int r19, String r20, String r21, boolean r22, boolean r23, long r24, String r26) {
        o.e(r15, "recordId");
        o.e(r18, "userQuery");
        o.e(r20, "stepDescription");
        o.e(r21, "modelReply");
        o.e(r26, "taskTriggerType");
        return new OmniLabelingStepRecord(r15, r16, r18, r19, r20, r21, r22, r23, r24, r26);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OmniLabelingStepRecord.class) == true) goto L8;
        return false;
    L8:
        OmniLabelingStepRecord r10 = (OmniLabelingStepRecord) ZeusTransformUtils.preCheckCast(r9, OmniLabelingStepRecord.class, "com.obric.aiagent.plugin");
        if (o.a(this.recordId, r10.recordId) == true) goto L12;
        return false;
    L12:
        if (this.createdAt == r10.createdAt) goto L15;
        return false;
    L15:
        if (o.a(this.userQuery, r10.userQuery) == true) goto L18;
        return false;
    L18:
        if (this.stepIndex == r10.stepIndex) goto L21;
        return false;
    L21:
        if (o.a(this.stepDescription, r10.stepDescription) == true) goto L24;
        return false;
    L24:
        if (o.a(this.modelReply, r10.modelReply) == true) goto L27;
        return false;
    L27:
        if (this.isLastStep == r10.isLastStep) goto L30;
        return false;
    L30:
        if (this.isSuccess == r10.isSuccess) goto L33;
        return false;
    L33:
        if (this.finishTimeMillis == r10.finishTimeMillis) goto L36;
        return false;
    L36:
        if (o.a(this.taskTriggerType, r10.taskTriggerType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((this.recordId.hashCode() * 31) + Long.hashCode(this.createdAt)) * 31) + this.userQuery.hashCode()) * 31) + Integer.hashCode(this.stepIndex)) * 31) + this.stepDescription.hashCode()) * 31) + this.modelReply.hashCode()) * 31) + Boolean.hashCode(this.isLastStep)) * 31) + Boolean.hashCode(this.isSuccess)) * 31) + Long.hashCode(this.finishTimeMillis)) * 31) + this.taskTriggerType.hashCode();
    }

    public String toString() {
        return "OmniLabelingStepRecord(recordId=" + this.recordId + ", createdAt=" + this.createdAt + ", userQuery=" + this.userQuery + ", stepIndex=" + this.stepIndex + ", stepDescription=" + this.stepDescription + ", modelReply=" + this.modelReply + ", isLastStep=" + this.isLastStep + ", isSuccess=" + this.isSuccess + ", finishTimeMillis=" + this.finishTimeMillis + ", taskTriggerType=" + this.taskTriggerType + ')';
    }

    public OmniLabelingStepRecord(String r2, long r3, String r5, int r6, String r7, String r8, boolean r9, boolean r10, long r11, String r13) {
        o.e(r2, "recordId");
        o.e(r5, "userQuery");
        o.e(r7, "stepDescription");
        o.e(r8, "modelReply");
        o.e(r13, "taskTriggerType");
        this.recordId = r2;
        this.createdAt = r3;
        this.userQuery = r5;
        this.stepIndex = r6;
        this.stepDescription = r7;
        this.modelReply = r8;
        this.isLastStep = r9;
        this.isSuccess = r10;
        this.finishTimeMillis = r11;
        this.taskTriggerType = r13;
    }

    public /* synthetic */ OmniLabelingStepRecord(String r15, long r16, String r18, int r19, String r20, String r21, boolean r22, boolean r23, long r24, String r26, int r27, h r28) {
        if ((r27 & 512) == 0) goto L5;
        String r13 = OmniLabelingTaskTriggerTypes.PROACTIVE;
    L6:
        this(r15, r16, r18, r19, r20, r21, r22, r23, r24, r13);
        return;
    L5:
        r13 = r26;
        goto L6
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getUserQuery() {
        return this.userQuery;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final String getStepDescription() {
        return this.stepDescription;
    }

    public final String getModelReply() {
        return this.modelReply;
    }

    public final boolean isLastStep() {
        return this.isLastStep;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final long getFinishTimeMillis() {
        return this.finishTimeMillis;
    }

    public final String getTaskTriggerType() {
        return this.taskTriggerType;
    }
}
