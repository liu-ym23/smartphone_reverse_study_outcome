package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ShortcutTask extends EventTask {
    public static final Parcelable.Creator<ShortcutTask> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ShortcutTaskAction> actions;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;
    private String id;
    private final boolean isShortInstructEnable;
    private final String name;
    private final String shortInstruct;
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
        CREATOR = new ShortcutTask$Companion$CREATOR$1();
    }

    public ShortcutTask(String r15, String r16, Integer r17, Integer r18, Long r19, Map<String, String> r20, Parcel r21) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        o.e(r21, "parcel");
        if (r17 != null) goto L6;
    L8:
        Integer r3 = r17;
    L9:
        if (r18 != null) goto L12;
    L14:
        Integer r4 = r18;
    L16:
        if (r19 != null) goto L19;
    L21:
        Long r5 = r19;
    L22:
        String r7 = r21.readString();
        if (r21.readInt() == 0) goto L25;
        boolean r8 = true;
    L26:
        List r0 = r21.createTypedArrayList(ShortcutTaskAction.CREATOR);
        if (r0 != null) goto L29;
        r0 = p.b();
    L29:
        this(r15, r16, r3, r4, r5, r6, r7, r8, r0);
        readExtensionFieldFromParcel$eventstaskkit_release(r21);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r21, 0);
        return;
    L25:
        r8 = false;
        goto L26
    L19:
        if (r19.longValue() != (-1)) goto L21;
        r5 = null;
        goto L22
    L12:
        if (r18.intValue() != (-1)) goto L14;
        r4 = null;
        goto L16
    L6:
        if (r17.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public ShortcutTask(String r12, String r13, Integer r14, Integer r15, Long r16, Map<String, String> r17, String r18, boolean r19, List<ShortcutTaskAction> r20) {
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        List<ShortcutTaskAction> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "actions");
        super(3, r12, r13, r14, r15, r16, r9);
        this.id = r12;
        this.name = r13;
        this.taskStatus = r14;
        this.enableStatus = r15;
        this.createTime = r16;
        this.ext = r9;
        this.shortInstruct = r18;
        this.isShortInstructEnable = r19;
        this.actions = r10;
    }

    public /* synthetic */ ShortcutTask(String r14, String r15, Integer r16, Integer r17, Long r18, Map r19, String r20, boolean r21, List r22, int r23, h r24) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        if ((r23 & 32) == 0) goto L5;
        Map r9 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r23 & 128) == 0) goto L13;
        boolean r11 = false;
    L14:
        this(r14, r15, r16, r17, r18, r9, r10, r11, r12);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r1;
        goto L7
    }

    public static /* synthetic */ ShortcutTask copy$default(ShortcutTask r11, String r12, String r13, Integer r14, Integer r15, Long r16, Map r17, String r18, boolean r19, List r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        List<ShortcutTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r4 = r11.getId();
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r5 = r11.getName();
    L11:
        if ((r21 & 4) == 0) goto L13;
        Integer r6 = r11.getTaskStatus();
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r7 = r11.getEnableStatus();
    L19:
        if ((r21 & 16) == 0) goto L21;
        Long r8 = r11.getCreateTime();
    L23:
        if ((r21 & 32) == 0) goto L26;
        r2 = r11.getExt();
    L26:
        if ((r21 & 64) == 0) goto L28;
        String r9 = r11.shortInstruct;
    L30:
        if ((r21 & 128) == 0) goto L32;
        boolean r10 = r11.isShortInstructEnable;
    L34:
        if ((r21 & 256) == 0) goto L36;
        List<ShortcutTaskAction> r1 = r11.actions;
    L38:
        return r11.copy(r4, r5, r6, r7, r8, r2, r9, r10, r1);
    L36:
        r1 = r3;
        goto L38
    L32:
        r10 = r19;
        goto L34
    L28:
        r9 = r18;
        goto L30
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
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
        return this.shortInstruct;
    }

    public final boolean component8() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> component9() {
        return this.actions;
    }

    public final ShortcutTask copy(String r13, String r14, Integer r15, Integer r16, Long r17, Map<String, String> r18, String r19, boolean r20, List<ShortcutTaskAction> r21) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "actions");
        return new ShortcutTask(r13, r14, r15, r16, r17, r8, r19, r20, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (o.a(ShortcutTask.class, r1) == true) goto L13;
        return false;
    L13:
        o.a(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTask");
        ShortcutTask r4 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin");
        return o.a(getId(), r4.getId());
    L8:
        r1 = null;
        goto L10
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Long getCreateTime() {
        return this.createTime;
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

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        String r0 = getId();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
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

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r1) {
        this.taskStatus = r1;
    }

    public String toString() {
        return "ShortcutTask(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        o.e(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.shortInstruct);
        r2.writeInt(this.isShortInstructEnable ? 1 : 0);
        r2.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
