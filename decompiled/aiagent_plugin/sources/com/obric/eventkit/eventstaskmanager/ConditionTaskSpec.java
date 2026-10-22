package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ConditionTaskSpec> CREATOR = null;
    public static final a Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ConditionTaskAction> actions;
    private final ConditionGroup conditions;
    private Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final PeriodicPolicy periodicPolicy;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final TriggerControlPolicy triggerControlPolicy;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new ConditionTaskSpec$Companion$CREATOR$1();
    }

    public ConditionTaskSpec(String r15, Integer r16, TaskKnowledge r17, String r18, Integer r19, Integer r20, Map<String, String> r21, Parcel r22) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        o.e(r22, "parcel");
        if (r16 != null) goto L6;
    L8:
        Integer r3 = r16;
    L9:
        if (r19 != null) goto L12;
    L14:
        Integer r5 = r19;
    L15:
        if (r20 != null) goto L18;
    L20:
        Integer r6 = r20;
    L21:
        this(r15, r3, r17, r18, r5, r6, r7, r22.createTypedArrayList(ConditionTaskAction.CREATOR), (ConditionGroup) ZeusTransformUtils.preCheckCast(r22.readParcelable(ConditionGroup.class.getClassLoader()), ConditionGroup.class, "com.obric.aiagent.plugin"), (PeriodicPolicy) ZeusTransformUtils.preCheckCast(r22.readParcelable(PeriodicPolicy.class.getClassLoader()), PeriodicPolicy.class, "com.obric.aiagent.plugin"), (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(r22.readParcelable(TriggerControlPolicy.class.getClassLoader()), TriggerControlPolicy.class, "com.obric.aiagent.plugin"));
        readExtensionFieldFromParcel$eventstaskkit_release(r22);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r22, 0);
        return;
    L18:
        if (r20.intValue() != (-1)) goto L20;
        r6 = null;
        goto L21
    L12:
        if (r19.intValue() != (-1)) goto L14;
        r5 = null;
        goto L15
    L6:
        if (r16.intValue() != (-1)) goto L8;
        r3 = null;
        goto L9
    }

    public ConditionTaskSpec(String r13, Integer r14, TaskKnowledge r15, String r16, Integer r17, Integer r18, Map<String, String> r19, List<ConditionTaskAction> r20, ConditionGroup r21, PeriodicPolicy r22, TriggerControlPolicy r23) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        List<ConditionTaskAction> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        super(2, r13, r14, r15, r16, r17, r18, r10);
        this.name = r13;
        this.taskMode = r14;
        this.taskKnowledge = r15;
        this.templateId = r16;
        this.taskStatus = r17;
        this.enableStatus = r18;
        this.ext = r10;
        this.actions = r11;
        this.conditions = r21;
        this.periodicPolicy = r22;
        this.triggerControlPolicy = r23;
    }

    public /* synthetic */ ConditionTaskSpec(String r12, Integer r13, TaskKnowledge r14, String r15, Integer r16, Integer r17, Map r18, List r19, ConditionGroup r20, PeriodicPolicy r21, TriggerControlPolicy r22, int r23, h r24) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        TriggerControlPolicy r4 = null;
        if ((r23 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        TaskKnowledge r5 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        Integer r7 = null;
    L19:
        if ((r23 & 32) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r23 & 64) == 0) goto L26;
        r1 = null;
    L26:
        if ((r23 & 128) == 0) goto L29;
        r2 = null;
    L29:
        if ((r23 & 256) == 0) goto L31;
        ConditionGroup r9 = null;
    L33:
        if ((r23 & 512) == 0) goto L35;
        PeriodicPolicy r10 = null;
    L37:
        if ((r23 & 1024) != 0) goto L40;
        r4 = r22;
    L40:
        this(r12, r3, r5, r6, r7, r8, r1, r2, r9, r10, r4);
        return;
    L35:
        r10 = r21;
        goto L37
    L31:
        r9 = r20;
        goto L33
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getName() {
        return this.name;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskMode() {
        return this.taskMode;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getTemplateId() {
        return this.templateId;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r1) {
        o.e(r1, "parcel");
        r1.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeTypedList(this.actions);
        r2.writeParcelable(this.conditions, r3);
        r2.writeParcelable(this.periodicPolicy, r3);
        r2.writeParcelable(this.triggerControlPolicy, r3);
        writeExtensionFieldToParcel$eventstaskkit_release(r2);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r2);
    }
}
