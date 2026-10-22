package com.obric.autogui.common.api.cocreation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IOmniLabelingDataSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingUserStopRecord {
    private final long createdAt;
    private final long finishTimeMillis;
    private final String reason;
    private final String recordId;
    private final String taskTriggerType;
    private final String userQuery;

    public static /* synthetic */ OmniLabelingUserStopRecord copy$default(OmniLabelingUserStopRecord r9, String r10, long r11, String r13, long r14, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.recordId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r2 = r9.createdAt;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.userQuery;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = r9.finishTimeMillis;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r7 = r9.reason;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r8 = r9.taskTriggerType;
    L27:
        return r9.copy(r1, r2, r4, r5, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.recordId;
    }

    public final long component2() {
        return this.createdAt;
    }

    public final String component3() {
        return this.userQuery;
    }

    public final long component4() {
        return this.finishTimeMillis;
    }

    public final String component5() {
        return this.reason;
    }

    public final String component6() {
        return this.taskTriggerType;
    }

    public final OmniLabelingUserStopRecord copy(String r11, long r12, String r14, long r15, String r17, String r18) {
        o.e(r11, "recordId");
        o.e(r14, "userQuery");
        o.e(r17, "reason");
        o.e(r18, "taskTriggerType");
        return new OmniLabelingUserStopRecord(r11, r12, r14, r15, r17, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OmniLabelingUserStopRecord.class) == true) goto L8;
        return false;
    L8:
        OmniLabelingUserStopRecord r10 = (OmniLabelingUserStopRecord) ZeusTransformUtils.preCheckCast(r9, OmniLabelingUserStopRecord.class, "com.obric.aiagent.plugin");
        if (o.a(this.recordId, r10.recordId) == true) goto L12;
        return false;
    L12:
        if (this.createdAt == r10.createdAt) goto L15;
        return false;
    L15:
        if (o.a(this.userQuery, r10.userQuery) == true) goto L18;
        return false;
    L18:
        if (this.finishTimeMillis == r10.finishTimeMillis) goto L21;
        return false;
    L21:
        if (o.a(this.reason, r10.reason) == true) goto L24;
        return false;
    L24:
        if (o.a(this.taskTriggerType, r10.taskTriggerType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.recordId.hashCode() * 31) + Long.hashCode(this.createdAt)) * 31) + this.userQuery.hashCode()) * 31) + Long.hashCode(this.finishTimeMillis)) * 31) + this.reason.hashCode()) * 31) + this.taskTriggerType.hashCode();
    }

    public String toString() {
        return "OmniLabelingUserStopRecord(recordId=" + this.recordId + ", createdAt=" + this.createdAt + ", userQuery=" + this.userQuery + ", finishTimeMillis=" + this.finishTimeMillis + ", reason=" + this.reason + ", taskTriggerType=" + this.taskTriggerType + ')';
    }

    public OmniLabelingUserStopRecord(String r2, long r3, String r5, long r6, String r8, String r9) {
        o.e(r2, "recordId");
        o.e(r5, "userQuery");
        o.e(r8, "reason");
        o.e(r9, "taskTriggerType");
        this.recordId = r2;
        this.createdAt = r3;
        this.userQuery = r5;
        this.finishTimeMillis = r6;
        this.reason = r8;
        this.taskTriggerType = r9;
    }

    public /* synthetic */ OmniLabelingUserStopRecord(String r11, long r12, String r14, long r15, String r17, String r18, int r19, h r20) {
        if ((r19 & 32) == 0) goto L5;
        String r9 = OmniLabelingTaskTriggerTypes.PROACTIVE;
    L6:
        this(r11, r12, r14, r15, r17, r9);
        return;
    L5:
        r9 = r18;
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

    public final long getFinishTimeMillis() {
        return this.finishTimeMillis;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getTaskTriggerType() {
        return this.taskTriggerType;
    }
}
