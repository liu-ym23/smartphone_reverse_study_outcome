package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionTaskSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ConditionTaskSpec extends EventTaskSpec {
    private final List<ConditionTaskAction> actions;
    private final ConditionGroup conditions;
    private Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private String omniModel;
    private final PeriodicPolicy periodicPolicy;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final TriggerControlPolicy triggerControlPolicy;

    public /* synthetic */ ConditionTaskSpec(String r13, Integer r14, TaskKnowledge r15, String r16, String r17, Integer r18, Integer r19, Map r20, List r21, ConditionGroup r22, PeriodicPolicy r23, TriggerControlPolicy r24, int r25, h r26) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        TriggerControlPolicy r4 = null;
        if ((r25 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r25 & 4) == 0) goto L9;
        TaskKnowledge r5 = null;
    L11:
        if ((r25 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r25 & 16) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r25 & 32) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r25 & 64) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r25 & 128) == 0) goto L30;
        r1 = null;
    L30:
        if ((r25 & 256) == 0) goto L33;
        r2 = null;
    L33:
        if ((r25 & 512) == 0) goto L35;
        ConditionGroup r10 = null;
    L37:
        if ((r25 & 1024) == 0) goto L39;
        PeriodicPolicy r11 = null;
    L41:
        if ((r25 & 2048) != 0) goto L44;
        r4 = r24;
    L44:
        this(r13, r3, r5, r6, r7, r8, r9, r1, r2, r10, r11, r4);
        return;
    L39:
        r11 = r23;
        goto L41
    L35:
        r10 = r22;
        goto L37
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public String getName() {
        return this.name;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public Integer getTaskMode() {
        return this.taskMode;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public String getTemplateId() {
        return this.templateId;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public String getOmniModel() {
        return this.omniModel;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public void setOmniModel(String r1) {
        this.omniModel = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(Integer r1) {
        this.enableStatus = r1;
    }

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public Map<String, String> getExt() {
        return this.ext;
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    public ConditionTaskSpec(String r14, Integer r15, TaskKnowledge r16, String r17, String r18, Integer r19, Integer r20, Map<String, String> r21, List<ConditionTaskAction> r22, ConditionGroup r23, PeriodicPolicy r24, TriggerControlPolicy r25) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        List<ConditionTaskAction> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        super(2, r14, r15, r16, r17, r18, r19, r20, r11);
        this.name = r14;
        this.taskMode = r15;
        this.taskKnowledge = r16;
        this.templateId = r17;
        this.omniModel = r18;
        this.taskStatus = r19;
        this.enableStatus = r20;
        this.ext = r11;
        this.actions = r12;
        this.conditions = r23;
        this.periodicPolicy = r24;
        this.triggerControlPolicy = r25;
    }
}
