package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: ConditionTaskRecordBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConditionTaskRecordBean {
    private final long createTime;
    private final long id;
    private final int result;
    private final String sourceFrom;
    private final String taskId;
    private final long triggerTime;

    public static /* synthetic */ ConditionTaskRecordBean copy$default(ConditionTaskRecordBean r10, String r11, long r12, String r14, int r15, long r16, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.taskId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r2 = r10.triggerTime;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.sourceFrom;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r5 = r10.result;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r6 = r10.createTime;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r8 = r10.id;
    L27:
        return r10.copy(r1, r2, r4, r5, r6, r8);
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final long component2() {
        return this.triggerTime;
    }

    public final String component3() {
        return this.sourceFrom;
    }

    public final int component4() {
        return this.result;
    }

    public final long component5() {
        return this.createTime;
    }

    public final long component6() {
        return this.id;
    }

    public final ConditionTaskRecordBean copy(String r12, long r13, String r15, int r16, long r17, long r19) {
        o.e(r12, DBDefinition.TASK_ID);
        return new ConditionTaskRecordBean(r12, r13, r15, r16, r17, r19);
    }

    public String toString() {
        return "ConditionTaskRecordBean(taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", sourceFrom=" + this.sourceFrom + ", result=" + this.result + ", createTime=" + this.createTime + ", id=" + this.id + ')';
    }

    public ConditionTaskRecordBean(String r2, long r3, String r5, int r6, long r7, long r9) {
        o.e(r2, DBDefinition.TASK_ID);
        this.taskId = r2;
        this.triggerTime = r3;
        this.sourceFrom = r5;
        this.result = r6;
        this.createTime = r7;
        this.id = r9;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final int getResult() {
        return this.result;
    }

    public /* synthetic */ ConditionTaskRecordBean(String r13, long r14, String r16, int r17, long r18, long r20, int r22, h r23) {
        if ((r22 & 16) == 0) goto L5;
        long r8 = System.currentTimeMillis();
    L7:
        if ((r22 & 32) == 0) goto L9;
        long r10 = 0;
    L10:
        this(r13, r14, r16, r17, r8, r10);
        return;
    L9:
        r10 = r20;
        goto L10
    L5:
        r8 = r18;
        goto L7
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getId() {
        return this.id;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r9 == null) goto L8;
        Class<?> r3 = r9.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r9, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskRecordBean");
        ConditionTaskRecordBean r4 = (ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordBean.class, "com.obric.aiagent.plugin");
        if (this.id == ((ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordBean.class, "com.obric.aiagent.plugin")).id) goto L16;
        return false;
    L16:
        if (o.a(this.taskId, ((ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordBean.class, "com.obric.aiagent.plugin")).taskId) == false) goto L21;
        if (o.a(this.sourceFrom, ((ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r9, ConditionTaskRecordBean.class, "com.obric.aiagent.plugin")).sourceFrom) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.id), this.sourceFrom});
    }
}
