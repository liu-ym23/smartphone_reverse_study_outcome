package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.utils.CronHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new TimerTaskV2$Companion$CREATOR$1();
    }

    public TimerTaskV2(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, Parcel r22) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        o.e(r22, "parcel");
        if (r18 != null) goto L6;
    L8:
        Integer r3 = r18;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r4 = r19;
    L16:
        if (r20 != null) goto L19;
    L21:
        Long r5 = r20;
    L22:
        String r9 = b.a(r22);
        String r12 = b.a(r22);
        Long r0 = Long.valueOf(r22.readLong());
        if (r0.longValue() == (-1)) goto L25;
        boolean r2 = true;
    L26:
        if (r2 == false) goto L28;
        Long r14 = r0;
    L29:
        this(r16, r17, r3, r4, r5, r6, r9, r12, r14);
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
    L28:
        r14 = null;
        goto L29
    L25:
        r2 = false;
        goto L26
    L19:
        if (r20.longValue() != (-1)) goto L21;
        r5 = null;
        goto L22
    L12:
        if (r19.intValue() != (-1)) goto L14;
        r4 = null;
        goto L16
    L6:
        if (r18.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
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

    public static /* synthetic */ TimerTaskV2 copy$default(TimerTaskV2 r10, String r11, String r12, Integer r13, Integer r14, Long r15, Map r16, String r17, String r18, Long r19, int r20, Object r21) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        String r3 = r10.getId();
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = r10.getName();
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r5 = r10.getTaskStatus();
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r6 = r10.getEnableStatus();
    L19:
        if ((r20 & 16) == 0) goto L21;
        Long r7 = r10.getCreateTime();
    L23:
        if ((r20 & 32) == 0) goto L26;
        r2 = r10.getExt();
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
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final Integer component3() {
        return getTaskStatus();
    }

    public final Integer component4() {
        return getEnableStatus();
    }

    public final Long component5() {
        return getCreateTime();
    }

    public final Map<String, String> component6() {
        return getExt();
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
        if (o.a(getId(), r6.getId()) == true) goto L12;
        return false;
    L12:
        if (o.a(getName(), r6.getName()) == true) goto L15;
        return false;
    L15:
        if (o.a(getTaskStatus(), r6.getTaskStatus()) == true) goto L18;
        return false;
    L18:
        if (o.a(getEnableStatus(), r6.getEnableStatus()) == true) goto L21;
        return false;
    L21:
        if (o.a(getCreateTime(), r6.getCreateTime()) == true) goto L24;
        return false;
    L24:
        if (o.a(getExt(), r6.getExt()) == true) goto L27;
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

    public final String getAction() {
        return this.action;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Long getCreateTime() {
        return this.createTime;
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getId() {
        return this.id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getName() {
        return this.name;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        int r1 = 0;
        if (getId() != null) goto L5;
        int r0 = 0;
    L6:
        int r2 = r0 * 31;
        if (getName() != null) goto L9;
        int r3 = 0;
    L10:
        int r4 = (r2 + r3) * 31;
        if (getTaskStatus() != null) goto L13;
        int r5 = 0;
    L14:
        int r6 = (r4 + r5) * 31;
        if (getEnableStatus() != null) goto L17;
        int r7 = 0;
    L18:
        int r8 = (r6 + r7) * 31;
        if (getCreateTime() != null) goto L21;
        int r9 = 0;
    L22:
        int r10 = (r8 + r9) * 31;
        if (getExt() != null) goto L25;
        int r11 = 0;
    L26:
        int r12 = (((((r10 + r11) * 31) + this.cronExpr.hashCode()) * 31) + this.action.hashCode()) * 31;
        Long r13 = this.nextScheduleTime;
        if (r13 == null) goto L31;
        r1 = r13.hashCode();
    L31:
        return r12 + r1;
    L25:
        r11 = getExt().hashCode();
        goto L26
    L21:
        r9 = getCreateTime().hashCode();
        goto L22
    L17:
        r7 = getEnableStatus().hashCode();
        goto L18
    L13:
        r5 = getTaskStatus().hashCode();
        goto L14
    L9:
        r3 = getName().hashCode();
        goto L10
    L5:
        r0 = getId().hashCode();
        goto L6
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setId(String r1) {
        this.id = r1;
    }

    public final void setNextScheduleTime(Long r1) {
        this.nextScheduleTime = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public String toString() {
        return "TimerTaskV2(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", cronExpr=" + this.cronExpr + ", action=" + this.action + ", nextScheduleTime=" + this.nextScheduleTime + ')';
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

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        o.e(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
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
        writeExtensionFieldToParcel$eventstaskkit_release(r3);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r3);
        return;
    L5:
        r0 = -1;
        goto L6
    }
}
