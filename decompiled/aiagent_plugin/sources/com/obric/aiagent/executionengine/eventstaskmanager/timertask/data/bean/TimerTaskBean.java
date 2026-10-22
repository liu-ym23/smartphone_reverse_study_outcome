package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean;

import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: TimerTaskBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TimerTaskBean {
    public static final a Companion = null;
    public static final int STATE_ACTIONING = 1;
    public static final int STATE_CLOSE = 2;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_DELETE = 3;
    public static final int STATE_DISABLED = 1;
    public static final int STATE_ENABLED = 0;
    public static final int STATE_FAILED = 3;
    public static final int STATE_PENDING = 0;
    private final String action;
    private final Long createTime;
    private final String cronTime;
    private final int enableStatus;
    private final String ext;
    private final String intent;
    private final boolean isRepeat;
    private final String name;
    private final Long nextScheduleTime;
    private final String sourceFrom;
    private final int taskId;
    private final int taskStatus;

    /* JADX INFO: compiled from: TimerTaskBean.kt */
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

    public static /* synthetic */ TimerTaskBean copy$default(TimerTaskBean r13, String r14, boolean r15, String r16, String r17, String r18, int r19, String r20, int r21, int r22, Long r23, Long r24, String r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.cronTime;
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r3 = r13.isRepeat;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.name;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.action;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.intent;
    L23:
        if ((r26 & 32) == 0) goto L25;
        int r7 = r13.taskId;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.sourceFrom;
    L31:
        if ((r26 & 128) == 0) goto L33;
        int r9 = r13.taskStatus;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r10 = r13.enableStatus;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Long r11 = r13.nextScheduleTime;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        Long r12 = r13.createTime;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        String r1 = r13.ext;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.cronTime;
    }

    public final Long component10() {
        return this.nextScheduleTime;
    }

    public final Long component11() {
        return this.createTime;
    }

    public final String component12() {
        return this.ext;
    }

    public final boolean component2() {
        return this.isRepeat;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.action;
    }

    public final String component5() {
        return this.intent;
    }

    public final int component6() {
        return this.taskId;
    }

    public final String component7() {
        return this.sourceFrom;
    }

    public final int component8() {
        return this.taskStatus;
    }

    public final int component9() {
        return this.enableStatus;
    }

    public final TimerTaskBean copy(String r15, boolean r16, String r17, String r18, String r19, int r20, String r21, int r22, int r23, Long r24, Long r25, String r26) {
        o.e(r15, "cronTime");
        o.e(r21, "sourceFrom");
        return new TimerTaskBean(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("TimerTaskBean(cronTime=").append(this.cronTime).append(", isRepeat=").append(this.isRepeat).append(", name=").append(this.name).append(", action=").append(this.action).append(", intent=").append(this.intent).append(", taskId=").append(this.taskId).append(", sourceFrom=").append(this.sourceFrom).append(", taskStatus=").append(this.taskStatus).append(", enableStatus=").append(this.enableStatus).append(", nextScheduleTime=").append(this.nextScheduleTime).append(", createTime=").append(this.createTime).append(", ext=");
        r0.append(this.ext).append(')');
        return r0.toString();
    }

    public TimerTaskBean(String r2, boolean r3, String r4, String r5, String r6, int r7, String r8, int r9, int r10, Long r11, Long r12, String r13) {
        o.e(r2, "cronTime");
        o.e(r8, "sourceFrom");
        this.cronTime = r2;
        this.isRepeat = r3;
        this.name = r4;
        this.action = r5;
        this.intent = r6;
        this.taskId = r7;
        this.sourceFrom = r8;
        this.taskStatus = r9;
        this.enableStatus = r10;
        this.nextScheduleTime = r11;
        this.createTime = r12;
        this.ext = r13;
    }

    public /* synthetic */ TimerTaskBean(String r17, boolean r18, String r19, String r20, String r21, int r22, String r23, int r24, int r25, Long r26, Long r27, String r28, int r29, h r30) {
        if ((r29 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r29 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r29 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r29 & 32) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r29 & 128) == 0) goto L21;
        int r11 = 0;
    L23:
        if ((r29 & 256) == 0) goto L25;
        int r12 = 0;
    L27:
        if ((r29 & 512) == 0) goto L29;
        Long r13 = null;
    L31:
        if ((r29 & 1024) == 0) goto L33;
        Long r14 = null;
    L35:
        if ((r29 & 2048) == 0) goto L37;
        String r15 = null;
    L38:
        this(r17, r18, r6, r7, r8, r9, r23, r11, r12, r13, r14, r15);
        return;
    L37:
        r15 = r28;
        goto L38
    L33:
        r14 = r27;
        goto L35
    L29:
        r13 = r26;
        goto L31
    L25:
        r12 = r25;
        goto L27
    L21:
        r11 = r24;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r8 = r21;
        goto L15
    L9:
        r7 = r20;
        goto L11
    L5:
        r6 = r19;
        goto L7
    }

    public final String getCronTime() {
        return this.cronTime;
    }

    public final boolean isRepeat() {
        return this.isRepeat;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final int getEnableStatus() {
        return this.enableStatus;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getExt() {
        return this.ext;
    }

    public final boolean isEnable() {
        if (this.enableStatus != 0) goto L5;
        return true;
    L5:
        return false;
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
        o.a(r7, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean");
        TimerTaskBean r4 = (TimerTaskBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskBean.class, "com.obric.aiagent.plugin");
        if (this.taskId == ((TimerTaskBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskBean.class, "com.obric.aiagent.plugin")).taskId) goto L16;
        return false;
    L16:
        if (o.a(this.cronTime, ((TimerTaskBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskBean.class, "com.obric.aiagent.plugin")).cronTime) == false) goto L21;
        if (o.a(this.sourceFrom, ((TimerTaskBean) ZeusTransformUtils.preCheckCast(r7, TimerTaskBean.class, "com.obric.aiagent.plugin")).sourceFrom) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.taskId), this.sourceFrom, this.cronTime});
    }

    public final TimerTask toTimerTask() {
        Type r0 = new TimerTaskBean$toTimerTask$type$1().getType();
        int r1 = this.taskId;
        String r3 = this.cronTime;
        String r4 = this.name;
        String r5 = b.a().toJson(new TimerTaskAction(this.action, this.intent));
        o.c(r5, "toJson(...)");
        Long r7 = this.nextScheduleTime;
        int r2 = this.taskStatus;
        int r6 = this.enableStatus;
        Long r10 = this.createTime;
        String r12 = this.ext;
        if (r12 == null) goto L5;
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(b.a().fromJson(r12, r0), Map.class, "com.obric.aiagent.plugin");
    L6:
        Integer r8 = Integer.valueOf(r1);
        Integer r9 = Integer.valueOf(r2);
        Integer r11 = Integer.valueOf(r6);
        return new TimerTask(r3, r4, r5, r8, r7, r9, r11, r10, r13);
    L5:
        r13 = null;
        goto L6
    }
}
