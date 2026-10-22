package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean;

import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ConditionTaskBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConditionTaskBean {
    private List<ConditionTaskAction> actions;
    private ConditionGroup conditions;
    private long createTime;
    private long displayOrder;
    private int enableStatus;
    private Map<String, String> ext;
    private String name;
    private String omniModel;
    private PeriodicPolicy periodicPolicy;
    private String sourceFrom;
    private String taskId;
    private TaskKnowledge taskKnowledge;
    private Integer taskMode;
    private int taskStatus;
    private String templateId;
    private TriggerControlPolicy triggerControlPolicy;

    public static /* synthetic */ ConditionTaskBean copy$default(ConditionTaskBean r17, String r18, List r19, String r20, ConditionGroup r21, PeriodicPolicy r22, TriggerControlPolicy r23, String r24, int r25, int r26, long r27, long r29, Map r31, Integer r32, TaskKnowledge r33, String r34, String r35, int r36, Object r37) {
        List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        if ((r36 & 1) == 0) goto L5;
        String r4 = r17.taskId;
    L7:
        if ((r36 & 2) == 0) goto L10;
        r2 = r17.actions;
    L10:
        if ((r36 & 4) == 0) goto L12;
        String r5 = r17.name;
    L14:
        if ((r36 & 8) == 0) goto L16;
        ConditionGroup r6 = r17.conditions;
    L18:
        if ((r36 & 16) == 0) goto L20;
        PeriodicPolicy r7 = r17.periodicPolicy;
    L22:
        if ((r36 & 32) == 0) goto L24;
        TriggerControlPolicy r8 = r17.triggerControlPolicy;
    L26:
        if ((r36 & 64) == 0) goto L28;
        String r9 = r17.sourceFrom;
    L30:
        if ((r36 & 128) == 0) goto L32;
        int r10 = r17.taskStatus;
    L34:
        if ((r36 & 256) == 0) goto L36;
        int r11 = r17.enableStatus;
    L38:
        if ((r36 & 512) == 0) goto L40;
        long r12 = r17.createTime;
    L42:
        if ((r36 & 1024) == 0) goto L44;
        long r14 = r17.displayOrder;
    L46:
        if ((r36 & 2048) == 0) goto L48;
        Map<String, String> r13 = r17.ext;
    L49:
        Map<String, String> r38 = r13;
        if ((r36 & 4096) == 0) goto L52;
        Integer r15 = r17.taskMode;
    L53:
        Integer r39 = r15;
        if ((r36 & 8192) == 0) goto L56;
        TaskKnowledge r16 = r17.taskKnowledge;
    L57:
        TaskKnowledge r310 = r16;
        if ((r36 & 16384) == 0) goto L60;
        String r28 = r17.templateId;
    L62:
        if ((r36 & 32768) == 0) goto L64;
        String r1 = r17.omniModel;
    L66:
        return r17.copy(r4, r2, r5, r6, r7, r8, r9, r10, r11, r12, r14, r38, r39, r310, r28, r1);
    L64:
        r1 = r35;
        goto L66
    L60:
        r28 = r34;
        goto L62
    L56:
        r16 = r33;
        goto L57
    L52:
        r15 = r32;
        goto L53
    L48:
        r13 = r3;
        goto L49
    L44:
        r14 = r29;
        goto L46
    L40:
        r12 = r27;
        goto L42
    L36:
        r11 = r26;
        goto L38
    L32:
        r10 = r25;
        goto L34
    L28:
        r9 = r24;
        goto L30
    L24:
        r8 = r23;
        goto L26
    L20:
        r7 = r22;
        goto L22
    L16:
        r6 = r21;
        goto L18
    L12:
        r5 = r20;
        goto L14
    L5:
        r4 = r18;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final long component10() {
        return this.createTime;
    }

    public final long component11() {
        return this.displayOrder;
    }

    public final Map<String, String> component12() {
        return this.ext;
    }

    public final Integer component13() {
        return this.taskMode;
    }

    public final TaskKnowledge component14() {
        return this.taskKnowledge;
    }

    public final String component15() {
        return this.templateId;
    }

    public final String component16() {
        return this.omniModel;
    }

    public final List<ConditionTaskAction> component2() {
        return this.actions;
    }

    public final String component3() {
        return this.name;
    }

    public final ConditionGroup component4() {
        return this.conditions;
    }

    public final PeriodicPolicy component5() {
        return this.periodicPolicy;
    }

    public final TriggerControlPolicy component6() {
        return this.triggerControlPolicy;
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

    public final ConditionTaskBean copy(String r21, List<ConditionTaskAction> r22, String r23, ConditionGroup r24, PeriodicPolicy r25, TriggerControlPolicy r26, String r27, int r28, int r29, long r30, long r32, Map<String, String> r34, Integer r35, TaskKnowledge r36, String r37, String r38) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.aiagent.plugin");
        o.e(r21, DBDefinition.TASK_ID);
        o.e(r0, "actions");
        o.e(r24, "conditions");
        o.e(r25, "periodicPolicy");
        o.e(r27, "sourceFrom");
        return new ConditionTaskBean(r21, r0, r23, r24, r25, r26, r27, r28, r29, r30, r32, r14, r35, r36, r37, r38);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ConditionTaskBean(taskId=").append(this.taskId).append(", actions=").append(this.actions).append(", name=").append(this.name).append(", conditions=").append(this.conditions).append(", periodicPolicy=").append(this.periodicPolicy).append(", triggerControlPolicy=").append(this.triggerControlPolicy).append(", sourceFrom=").append(this.sourceFrom).append(", taskStatus=").append(this.taskStatus).append(", enableStatus=").append(this.enableStatus).append(", createTime=").append(this.createTime).append(", displayOrder=").append(this.displayOrder).append(", ext=");
        r0.append(this.ext).append(", taskMode=").append(this.taskMode).append(", taskKnowledge=").append(this.taskKnowledge).append(", templateId=").append(this.templateId).append(", omniModel=").append(this.omniModel).append(')');
        return r0.toString();
    }

    public ConditionTaskBean(String r10, List<ConditionTaskAction> r11, String r12, ConditionGroup r13, PeriodicPolicy r14, TriggerControlPolicy r15, String r16, int r17, int r18, long r19, long r21, Map<String, String> r23, Integer r24, TaskKnowledge r25, String r26, String r27) {
        List<ConditionTaskAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r10, DBDefinition.TASK_ID);
        o.e(r5, "actions");
        o.e(r13, "conditions");
        o.e(r14, "periodicPolicy");
        o.e(r16, "sourceFrom");
        this.taskId = r10;
        this.actions = r5;
        this.name = r12;
        this.conditions = r13;
        this.periodicPolicy = r14;
        this.triggerControlPolicy = r15;
        this.sourceFrom = r16;
        this.taskStatus = r17;
        this.enableStatus = r18;
        this.createTime = r19;
        this.displayOrder = r21;
        this.ext = r6;
        this.taskMode = r24;
        this.taskKnowledge = r25;
        this.templateId = r26;
        this.omniModel = r27;
    }

    public /* synthetic */ ConditionTaskBean(String r23, List r24, String r25, ConditionGroup r26, PeriodicPolicy r27, TriggerControlPolicy r28, String r29, int r30, int r31, long r32, long r34, Map r36, Integer r37, TaskKnowledge r38, String r39, String r40, int r41, h r42) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        if ((r41 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r41 & 32) == 0) goto L9;
        TriggerControlPolicy r9 = null;
    L11:
        if ((r41 & 128) == 0) goto L13;
        int r11 = 0;
    L15:
        if ((r41 & 256) == 0) goto L17;
        int r12 = 0;
    L19:
        if ((r41 & 1024) == 0) goto L21;
        long r15 = r32;
    L23:
        if ((r41 & 2048) == 0) goto L25;
        Map r17 = null;
    L27:
        if ((r41 & 4096) == 0) goto L29;
        Integer r18 = null;
    L31:
        if ((r41 & 8192) == 0) goto L33;
        TaskKnowledge r19 = null;
    L35:
        if ((r41 & 16384) == 0) goto L37;
        String r20 = null;
    L39:
        if ((r41 & 32768) == 0) goto L41;
        String r21 = null;
    L42:
        this(r23, r5, r6, r26, r27, r9, r29, r11, r12, r32, r15, r17, r18, r19, r20, r21);
        return;
    L41:
        r21 = r40;
        goto L42
    L37:
        r20 = r39;
        goto L39
    L33:
        r19 = r38;
        goto L35
    L29:
        r18 = r37;
        goto L31
    L25:
        r17 = r1;
        goto L27
    L21:
        r15 = r34;
        goto L23
    L17:
        r12 = r31;
        goto L19
    L13:
        r11 = r30;
        goto L15
    L9:
        r9 = r28;
        goto L11
    L5:
        r6 = r25;
        goto L7
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String r2) {
        o.e(r2, "<set-?>");
        this.taskId = r2;
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final void setActions(List<ConditionTaskAction> r3) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.actions = r4;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    public final void setConditions(ConditionGroup r2) {
        o.e(r2, "<set-?>");
        this.conditions = r2;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    public final void setPeriodicPolicy(PeriodicPolicy r2) {
        o.e(r2, "<set-?>");
        this.periodicPolicy = r2;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    public final void setTriggerControlPolicy(TriggerControlPolicy r1) {
        this.triggerControlPolicy = r1;
    }

    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final void setSourceFrom(String r2) {
        o.e(r2, "<set-?>");
        this.sourceFrom = r2;
    }

    public final int getTaskStatus() {
        return this.taskStatus;
    }

    public final void setTaskStatus(int r1) {
        this.taskStatus = r1;
    }

    public final int getEnableStatus() {
        return this.enableStatus;
    }

    public final void setEnableStatus(int r1) {
        this.enableStatus = r1;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final long getDisplayOrder() {
        return this.displayOrder;
    }

    public final void setDisplayOrder(long r1) {
        this.displayOrder = r1;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public final Integer getTaskMode() {
        return this.taskMode;
    }

    public final void setTaskMode(Integer r1) {
        this.taskMode = r1;
    }

    public final TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public final void setTaskKnowledge(TaskKnowledge r1) {
        this.taskKnowledge = r1;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String r1) {
        this.templateId = r1;
    }

    public final String getOmniModel() {
        return this.omniModel;
    }

    public final void setOmniModel(String r1) {
        this.omniModel = r1;
    }

    public final boolean isEnable() {
        if (this.enableStatus != 0) goto L5;
        return true;
    L5:
        return false;
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
        o.a(r4, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean");
        ConditionTaskBean r3 = (ConditionTaskBean) ZeusTransformUtils.preCheckCast(r4, ConditionTaskBean.class, "com.obric.aiagent.plugin");
        return o.a(this.taskId, ((ConditionTaskBean) ZeusTransformUtils.preCheckCast(r4, ConditionTaskBean.class, "com.obric.aiagent.plugin")).taskId);
    L9:
        r2 = null;
        goto L11
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.taskId});
    }
}
