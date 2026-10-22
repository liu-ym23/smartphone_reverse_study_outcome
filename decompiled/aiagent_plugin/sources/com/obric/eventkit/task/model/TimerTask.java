package com.obric.eventkit.task.model;

import com.obric.eventkit.task.utils.CronHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: TimerTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerTask {
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;
    private Integer id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    public static /* synthetic */ TimerTask copy$default(TimerTask r11, String r12, String r13, String r14, Integer r15, Long r16, Integer r17, Integer r18, Long r19, Map r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r3 = r11.cronExpr;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = r11.name;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = r11.action;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r6 = r11.id;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Long r7 = r11.nextScheduleTime;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r8 = r11.taskStatus;
    L27:
        if ((r21 & 64) == 0) goto L29;
        Integer r9 = r11.enableStatus;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Long r10 = r11.createTime;
    L35:
        if ((r21 & 256) == 0) goto L37;
        Map<String, String> r1 = r11.ext;
    L39:
        return r11.copy(r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L37:
        r1 = r2;
        goto L39
    L33:
        r10 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final String component1() {
        return this.cronExpr;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.action;
    }

    public final Integer component4() {
        return this.id;
    }

    public final Long component5() {
        return this.nextScheduleTime;
    }

    public final Integer component6() {
        return this.taskStatus;
    }

    public final Integer component7() {
        return this.enableStatus;
    }

    public final Long component8() {
        return this.createTime;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final TimerTask copy(String r12, String r13, String r14, Integer r15, Long r16, Integer r17, Integer r18, Long r19, Map<String, String> r20) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        o.e(r12, "cronExpr");
        o.e(r14, "action");
        return new TimerTask(r12, r13, r14, r15, r16, r17, r18, r19, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerTask.class) == true) goto L8;
        return false;
    L8:
        TimerTask r6 = (TimerTask) ZeusTransformUtils.preCheckCast(r5, TimerTask.class, "com.obric.aiagent.plugin");
        if (o.a(this.cronExpr, r6.cronExpr) == true) goto L12;
        return false;
    L12:
        if (o.a(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (o.a(this.action, r6.action) == true) goto L18;
        return false;
    L18:
        if (o.a(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (o.a(this.nextScheduleTime, r6.nextScheduleTime) == true) goto L24;
        return false;
    L24:
        if (o.a(this.taskStatus, r6.taskStatus) == true) goto L27;
        return false;
    L27:
        if (o.a(this.enableStatus, r6.enableStatus) == true) goto L30;
        return false;
    L30:
        if (o.a(this.createTime, r6.createTime) == true) goto L33;
        return false;
    L33:
        if (o.a(this.ext, r6.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.cronExpr.hashCode() * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.action.hashCode()) * 31;
        Integer r5 = this.id;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.nextScheduleTime;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.taskStatus;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.enableStatus;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.createTime;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Map<String, String> r20 = this.ext;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
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
        return "TimerTask(cronExpr=" + this.cronExpr + ", name=" + this.name + ", action=" + this.action + ", id=" + this.id + ", nextScheduleTime=" + this.nextScheduleTime + ", taskStatus=" + this.taskStatus + ", enableStatus=" + this.enableStatus + ", createTime=" + this.createTime + ", ext=" + this.ext + ')';
    }

    public TimerTask(String r3, String r4, String r5, Integer r6, Long r7, Integer r8, Integer r9, Long r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "cronExpr");
        o.e(r5, "action");
        this.cronExpr = r3;
        this.name = r4;
        this.action = r5;
        this.id = r6;
        this.nextScheduleTime = r7;
        this.taskStatus = r8;
        this.enableStatus = r9;
        this.createTime = r10;
        this.ext = r12;
    }

    public /* synthetic */ TimerTask(String r15, String r16, String r17, Integer r18, Long r19, Integer r20, Integer r21, Long r22, Map r23, int r24, h r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 2) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r24 & 8) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r24 & 16) == 0) goto L13;
        Long r9 = null;
    L15:
        if ((r24 & 32) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r24 & 64) == 0) goto L21;
        Integer r11 = null;
    L23:
        if ((r24 & 128) == 0) goto L25;
        Long r12 = null;
    L27:
        if ((r24 & 256) == 0) goto L29;
        Map r13 = null;
    L30:
        this(r15, r6, r17, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r1;
        goto L30
    L25:
        r12 = r22;
        goto L27
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAction() {
        return this.action;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer r1) {
        this.id = r1;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public final void setNextScheduleTime(Long r1) {
        this.nextScheduleTime = r1;
    }

    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public final Integer getEnableStatus() {
        return this.enableStatus;
    }

    public final void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    public final TimerTaskV2 toTimerTaskV2() {
        Integer r0 = this.id;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L7:
        return new TimerTaskV2(r1, this.name, this.taskStatus, this.enableStatus, this.createTime, this.ext, this.cronExpr, this.action, this.nextScheduleTime);
    L5:
        r1 = null;
        goto L7
    }
}
