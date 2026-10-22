package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean;

import com.obric.eventkit.task.model.TimerTaskRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: TimerTaskRecordBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimerTaskRecordBean {
    public static final a Companion = null;
    public static final int STATE_ACTIONING = 1;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_FAILED = 3;
    public static final int STATE_PENDING = 0;
    private final int id;
    private final Long realActionTime;
    private final String sourceFrom;
    private final String targetPackage;
    private final int taskId;
    private final int taskStatus;
    private final long triggerTime;

    /* JADX INFO: compiled from: TimerTaskRecordBean.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ TimerTaskRecordBean copy$default(TimerTaskRecordBean r9, int r10, long r11, Long r13, String r14, String r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r1 = r9.taskId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r2 = r9.triggerTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Long r4 = r9.realActionTime;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.sourceFrom;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.targetPackage;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.id;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.taskStatus;
    L31:
        return r9.copy(r1, r2, r4, r5, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
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

    public final int component1() {
        return this.taskId;
    }

    public final long component2() {
        return this.triggerTime;
    }

    public final Long component3() {
        return this.realActionTime;
    }

    public final String component4() {
        return this.sourceFrom;
    }

    public final String component5() {
        return this.targetPackage;
    }

    public final int component6() {
        return this.id;
    }

    public final int component7() {
        return this.taskStatus;
    }

    public final TimerTaskRecordBean copy(int r11, long r12, Long r14, String r15, String r16, int r17, int r18) {
        o.e(r15, "sourceFrom");
        o.e(r16, "targetPackage");
        return new TimerTaskRecordBean(r11, r12, r14, r15, r16, r17, r18);
    }

    public String toString() {
        return "TimerTaskRecordBean(taskId=" + this.taskId + ", triggerTime=" + this.triggerTime + ", realActionTime=" + this.realActionTime + ", sourceFrom=" + this.sourceFrom + ", targetPackage=" + this.targetPackage + ", id=" + this.id + ", taskStatus=" + this.taskStatus + ')';
    }

    public TimerTaskRecordBean(int r2, long r3, Long r5, String r6, String r7, int r8, int r9) {
        o.e(r6, "sourceFrom");
        o.e(r7, "targetPackage");
        this.taskId = r2;
        this.triggerTime = r3;
        this.realActionTime = r5;
        this.sourceFrom = r6;
        this.targetPackage = r7;
        this.id = r8;
        this.taskStatus = r9;
    }

    public /* synthetic */ TimerTaskRecordBean(int r11, long r12, Long r14, String r15, String r16, int r17, int r18, int r19, h r20) {
        if ((r19 & 4) == 0) goto L5;
        Long r5 = null;
    L7:
        if ((r19 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r19 & 64) == 0) goto L13;
        int r9 = 0;
    L14:
        this(r11, r12, r5, r15, r16, r8, r9);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = r17;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final long getTriggerTime() {
        return this.triggerTime;
    }

    public final Long getRealActionTime() {
        return this.realActionTime;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r7, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean");
        TimerTaskRecordBean r4 = (TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskRecordBean.class, "com.obric.aiagent.plugin");
        if (this.id == ((TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskRecordBean.class, "com.obric.aiagent.plugin")).id) goto L16;
        return false;
    L16:
        if (this.taskId != ((TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskRecordBean.class, "com.obric.aiagent.plugin")).taskId) goto L21;
        if (o.a(this.sourceFrom, ((TimerTaskRecordBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskRecordBean.class, "com.obric.aiagent.plugin")).sourceFrom) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.id), this.sourceFrom});
    }

    public final TimerTaskRecord toTimerTaskRecord() {
        String r3 = String.valueOf(this.taskId);
        long r4 = this.triggerTime;
        Long r6 = this.realActionTime;
        String r7 = this.sourceFrom;
        return new TimerTaskRecord(this.id, r3, r4, r6, r7, this.taskStatus);
    }
}
