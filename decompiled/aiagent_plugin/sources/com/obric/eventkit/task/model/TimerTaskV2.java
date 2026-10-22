package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.task.utils.CronHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: TimerTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimerTaskV2 extends EventTask {
    public static final Parcelable.Creator<TimerTaskV2> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    /* JADX INFO: compiled from: TimerTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ TimerTaskV2 copy$default(TimerTaskV2 r10, String r11, String r12, Integer r13, Integer r14, Long r15, Map r16, String r17, String r18, Long r19, int r20, Object r21) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        String r3 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r5 = r10.taskStatus;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r6 = r10.enableStatus;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r7 = r10.createTime;
    L23:
        if ((r20 & 32) == 0) goto L26;
        r2 = r10.ext;
    L26:
        if ((r20 & 64) == 0) goto L28;
        String r8 = r10.cronExpr;
    L30:
        if ((r20 & 128) == 0) goto L32;
        String r9 = r10.action;
    L34:
        if ((r20 & 256) == 0) goto L36;
        Long r1 = r10.nextScheduleTime;
    L38:
        return r10.copy(r3, r4, r5, r6, r7, r2, r8, r9, r1);
    L36:
        r1 = r19;
        goto L38
    L32:
        r9 = r18;
        goto L34
    L28:
        r8 = r17;
        goto L30
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.taskStatus;
    }

    public final Integer component4() {
        return this.enableStatus;
    }

    public final Long component5() {
        return this.createTime;
    }

    public final Map<String, String> component6() {
        return this.ext;
    }

    public final String component7() {
        return this.cronExpr;
    }

    public final String component8() {
        return this.action;
    }

    public final Long component9() {
        return this.nextScheduleTime;
    }

    public final TimerTaskV2 copy(String r12, String r13, Integer r14, Integer r15, Long r16, Map<String, String> r17, String r18, String r19, Long r20) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        o.e(r18, "cronExpr");
        o.e(r19, "action");
        return new TimerTaskV2(r12, r13, r14, r15, r16, r7, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TimerTaskV2.class) == true) goto L8;
        return false;
    L8:
        TimerTaskV2 r6 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r5, TimerTaskV2.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (o.a(this.taskStatus, r6.taskStatus) == true) goto L18;
        return false;
    L18:
        if (o.a(this.enableStatus, r6.enableStatus) == true) goto L21;
        return false;
    L21:
        if (o.a(this.createTime, r6.createTime) == true) goto L24;
        return false;
    L24:
        if (o.a(this.ext, r6.ext) == true) goto L27;
        return false;
    L27:
        if (o.a(this.cronExpr, r6.cronExpr) == true) goto L30;
        return false;
    L30:
        if (o.a(this.action, r6.action) == true) goto L33;
        return false;
    L33:
        if (o.a(this.nextScheduleTime, r6.nextScheduleTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.taskStatus;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.enableStatus;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.createTime;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.ext;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((r15 + r17) * 31) + this.cronExpr.hashCode()) * 31) + this.action.hashCode()) * 31;
        Long r19 = this.nextScheduleTime;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
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

    @Override // com.obric.eventkit.task.model.EventTask
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public String toString() {
        return "TimerTaskV2(id=" + this.id + ", name=" + this.name + ", taskStatus=" + this.taskStatus + ", enableStatus=" + this.enableStatus + ", createTime=" + this.createTime + ", ext=" + this.ext + ", cronExpr=" + this.cronExpr + ", action=" + this.action + ", nextScheduleTime=" + this.nextScheduleTime + ')';
    }

    public /* synthetic */ TimerTaskV2(String r15, String r16, Integer r17, Integer r18, Long r19, Map r20, String r21, String r22, Long r23, int r24, h r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r8 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Long r9 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Map r10 = null;
    L27:
        if ((r24 & 256) == 0) goto L29;
        Long r13 = null;
    L30:
        this(r5, r6, r7, r8, r9, r10, r21, r22, r13);
        return;
    L29:
        r13 = r23;
        goto L30
    L25:
        r10 = r1;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public String getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public void setId(String r1) {
        this.id = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public String getName() {
        return this.name;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public Long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.task.model.EventTask
    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public final void setNextScheduleTime(Long r1) {
        this.nextScheduleTime = r1;
    }

    public TimerTaskV2(String r13, String r14, Integer r15, Integer r16, Long r17, Map<String, String> r18, String r19, String r20, Long r21) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        o.e(r19, "cronExpr");
        o.e(r20, "action");
        super(1, r13, r14, r15, r16, r17, r11);
        this.id = r13;
        this.name = r14;
        this.taskStatus = r15;
        this.enableStatus = r16;
        this.createTime = r17;
        this.ext = r11;
        this.cronExpr = r19;
        this.action = r20;
        this.nextScheduleTime = r21;
    }

    public TimerTaskV2(String r18, String r19, Integer r20, Integer r21, Long r22, Map<String, String> r23, Parcel r24) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r24, "parcel");
        boolean r2 = true;
        if (r20 != null) goto L6;
    L8:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L12;
        Integer r4 = r20;
    L13:
        if (r21 != null) goto L16;
    L18:
        boolean r0 = false;
    L19:
        if (r0 == true) goto L21;
        Integer r5 = r21;
    L23:
        if (r22 != null) goto L26;
    L28:
        boolean r1 = false;
    L29:
        if (r1 == true) goto L31;
        Long r9 = r22;
    L32:
        String r13 = b.a(r24);
        String r14 = b.a(r24);
        Long r7 = Long.valueOf(r24.readLong());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).longValue() == (-1)) goto L36;
        r2 = false;
    L36:
        if (r2 == true) goto L38;
        Long r15 = r7;
    L39:
        this(r18, r19, r4, r5, r9, r6, r13, r14, r15);
        readExtensionFieldFromParcel$manager_api_release(r24);
        readSubClassExtensionFieldFromParcel$manager_api_release(r24, 0);
        return;
    L38:
        r15 = null;
        goto L39
    L31:
        r9 = null;
        goto L32
    L26:
        if (r22.longValue() != (-1)) goto L28;
        r1 = true;
        goto L29
    L21:
        r5 = null;
        goto L23
    L16:
        if (r21.intValue() != (-1)) goto L18;
        r0 = true;
        goto L19
    L12:
        r4 = null;
        goto L13
    L6:
        if (r20.intValue() != (-1)) goto L8;
        r3 = true;
        goto L10
    }

    @Override // com.obric.eventkit.task.model.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        super.writeToParcel(r3, r4);
        r3.writeString(this.cronExpr);
        r3.writeString(this.action);
        Long r5 = this.nextScheduleTime;
        if (r5 == null) goto L5;
        long r0 = r5.longValue();
    L6:
        r3.writeLong(r0);
        writeExtensionFieldToParcel$manager_api_release(r3);
        r3.writeInt(0);
        return;
    L5:
        r0 = -1;
        goto L6
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new TimerTaskV2$Companion$CREATOR$1(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    public final TimerTask toTimerTask() {
        String r1 = this.cronExpr;
        String r2 = getName();
        String r3 = this.action;
        String r0 = getId();
        if (r0 == null) goto L5;
        Integer r4 = d.o.o.d(r0);
    L7:
        return new TimerTask(r1, r2, r3, r4, this.nextScheduleTime, getTaskStatus(), getEnableStatus(), getCreateTime(), getExt());
    L5:
        r4 = null;
        goto L7
    }
}
