package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ShortcutTask.kt */
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

    /* JADX INFO: compiled from: ShortcutTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public static /* synthetic */ ShortcutTask copy$default(ShortcutTask r11, String r12, String r13, Integer r14, Integer r15, Long r16, Map r17, String r18, boolean r19, List r20, int r21, Object r22) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        List<ShortcutTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r4 = r11.id;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r5 = r11.name;
    L11:
        if ((r21 & 4) == 0) goto L13;
        Integer r6 = r11.taskStatus;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r7 = r11.enableStatus;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Long r8 = r11.createTime;
    L23:
        if ((r21 & 32) == 0) goto L26;
        r2 = r11.ext;
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

    @Override // com.obric.eventkit.task.model.EventTask
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public String toString() {
        return "ShortcutTask(id=" + this.id + ", name=" + this.name + ", taskStatus=" + this.taskStatus + ", enableStatus=" + this.enableStatus + ", createTime=" + this.createTime + ", ext=" + this.ext + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
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

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
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

    public ShortcutTask(String r16, String r17, Integer r18, Integer r19, Long r20, Map<String, String> r21, Parcel r22) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        o.e(r22, "parcel");
        if (r18 != null) goto L6;
    L8:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L12;
        Integer r4 = r18;
    L13:
        if (r19 != null) goto L16;
    L18:
        boolean r0 = false;
    L19:
        if (r0 == true) goto L21;
        Integer r5 = r19;
    L23:
        if (r20 != null) goto L26;
    L28:
        boolean r1 = false;
    L29:
        if (r1 == true) goto L31;
        Long r7 = r20;
    L32:
        String r8 = r22.readString();
        if (r22.readInt() == 0) goto L35;
        boolean r9 = true;
    L36:
        ArrayList r2 = r22.createTypedArrayList(ShortcutTaskAction.CREATOR);
        if (r2 == null) goto L39;
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L40:
        this(r16, r17, r4, r5, r7, r6, r8, r9, r10);
        readExtensionFieldFromParcel$manager_api_release(r22);
        readSubClassExtensionFieldFromParcel$manager_api_release(r22, 0);
        return;
    L39:
        r10 = p.b();
        goto L40
    L35:
        r9 = false;
        goto L36
    L31:
        r7 = null;
        goto L32
    L26:
        if (r20.longValue() != (-1)) goto L28;
        r1 = true;
        goto L29
    L21:
        r5 = null;
        goto L23
    L16:
        if (r19.intValue() != (-1)) goto L18;
        r0 = true;
        goto L19
    L12:
        r4 = null;
        goto L13
    L6:
        if (r18.intValue() != (-1)) goto L8;
        r3 = true;
        goto L10
    }

    @Override // com.obric.eventkit.task.model.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.shortInstruct);
        r2.writeInt(this.isShortInstructEnable ? 1 : 0);
        r2.writeTypedList(this.actions);
        writeExtensionFieldToParcel$manager_api_release(r2);
        r2.writeInt(0);
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new ShortcutTask$Companion$CREATOR$1(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        Class<?> r1 = getClass();
        if (r4 == null) goto L9;
        Class<?> r2 = r4.getClass();
    L11:
        if (o.a(r1, r2) == true) goto L14;
        return false;
    L14:
        o.a(r4, "null cannot be cast to non-null type com.obric.eventkit.task.model.ShortcutTask");
        ShortcutTask r3 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin");
        return o.a(getId(), ((ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin")).getId());
    L9:
        r2 = null;
        goto L11
    }

    public int hashCode() {
        String r0 = getId();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }
}
