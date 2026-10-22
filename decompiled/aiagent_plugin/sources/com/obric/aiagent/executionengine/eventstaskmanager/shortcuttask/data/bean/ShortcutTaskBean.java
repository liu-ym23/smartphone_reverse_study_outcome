package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean;

import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ShortcutTaskBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutTaskBean {
    private List<ShortcutTaskAction> actions;
    private long createTime;
    private long displayOrder;
    private int enableStatus;
    private Map<String, String> ext;
    private boolean isShortInstructEnable;
    private String name;
    private String omniModel;
    private String shortInstruct;
    private String sourceFrom;
    private String taskId;
    private TaskKnowledge taskKnowledge;
    private int taskMode;
    private int taskStatus;
    private final String templateId;

    public static /* synthetic */ ShortcutTaskBean copy$default(ShortcutTaskBean r16, String r17, List r18, String r19, int r20, TaskKnowledge r21, String r22, String r23, boolean r24, String r25, int r26, int r27, long r28, long r30, Map r32, String r33, int r34, Object r35) {
        List<ShortcutTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        if ((r34 & 1) == 0) goto L5;
        String r4 = r16.taskId;
    L7:
        if ((r34 & 2) == 0) goto L10;
        r2 = r16.actions;
    L10:
        if ((r34 & 4) == 0) goto L12;
        String r5 = r16.name;
    L14:
        if ((r34 & 8) == 0) goto L16;
        int r6 = r16.taskMode;
    L18:
        if ((r34 & 16) == 0) goto L20;
        TaskKnowledge r7 = r16.taskKnowledge;
    L22:
        if ((r34 & 32) == 0) goto L24;
        String r8 = r16.templateId;
    L26:
        if ((r34 & 64) == 0) goto L28;
        String r9 = r16.shortInstruct;
    L30:
        if ((r34 & 128) == 0) goto L32;
        boolean r10 = r16.isShortInstructEnable;
    L34:
        if ((r34 & 256) == 0) goto L36;
        String r11 = r16.sourceFrom;
    L38:
        if ((r34 & 512) == 0) goto L40;
        int r12 = r16.taskStatus;
    L42:
        if ((r34 & 1024) == 0) goto L44;
        int r13 = r16.enableStatus;
    L46:
        if ((r34 & 2048) == 0) goto L48;
        long r14 = r16.createTime;
    L49:
        long r29 = r14;
        if ((r34 & 4096) == 0) goto L52;
        long r15 = r16.displayOrder;
    L54:
        if ((r34 & 8192) == 0) goto L56;
        Map<String, String> r31 = r16.ext;
    L58:
        if ((r34 & 16384) == 0) goto L60;
        String r1 = r16.omniModel;
    L62:
        return r16.copy(r4, r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r29, r15, r31, r1);
    L60:
        r1 = r33;
        goto L62
    L56:
        r31 = r3;
        goto L58
    L52:
        r15 = r30;
        goto L54
    L48:
        r14 = r28;
        goto L49
    L44:
        r13 = r27;
        goto L46
    L40:
        r12 = r26;
        goto L42
    L36:
        r11 = r25;
        goto L38
    L32:
        r10 = r24;
        goto L34
    L28:
        r9 = r23;
        goto L30
    L24:
        r8 = r22;
        goto L26
    L20:
        r7 = r21;
        goto L22
    L16:
        r6 = r20;
        goto L18
    L12:
        r5 = r19;
        goto L14
    L5:
        r4 = r17;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component10() {
        return this.taskStatus;
    }

    public final int component11() {
        return this.enableStatus;
    }

    public final long component12() {
        return this.createTime;
    }

    public final long component13() {
        return this.displayOrder;
    }

    public final Map<String, String> component14() {
        return this.ext;
    }

    public final String component15() {
        return this.omniModel;
    }

    public final List<ShortcutTaskAction> component2() {
        return this.actions;
    }

    public final String component3() {
        return this.name;
    }

    public final int component4() {
        return this.taskMode;
    }

    public final TaskKnowledge component5() {
        return this.taskKnowledge;
    }

    public final String component6() {
        return this.templateId;
    }

    public final String component7() {
        return this.shortInstruct;
    }

    public final boolean component8() {
        return this.isShortInstructEnable;
    }

    public final String component9() {
        return this.sourceFrom;
    }

    public final ShortcutTaskBean copy(String r20, List<ShortcutTaskAction> r21, String r22, int r23, TaskKnowledge r24, String r25, String r26, boolean r27, String r28, int r29, int r30, long r31, long r33, Map<String, String> r35, String r36) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        o.e(r20, DBDefinition.TASK_ID);
        o.e(r0, "actions");
        o.e(r28, "sourceFrom");
        return new ShortcutTaskBean(r20, r0, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r16, r36);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ShortcutTaskBean(taskId=").append(this.taskId).append(", actions=").append(this.actions).append(", name=").append(this.name).append(", taskMode=").append(this.taskMode).append(", taskKnowledge=").append(this.taskKnowledge).append(", templateId=").append(this.templateId).append(", shortInstruct=").append(this.shortInstruct).append(", isShortInstructEnable=").append(this.isShortInstructEnable).append(", sourceFrom=").append(this.sourceFrom).append(", taskStatus=").append(this.taskStatus).append(", enableStatus=").append(this.enableStatus).append(", createTime=");
        r0.append(this.createTime).append(", displayOrder=").append(this.displayOrder).append(", ext=").append(this.ext).append(", omniModel=").append(this.omniModel).append(')');
        return r0.toString();
    }

    public ShortcutTaskBean(String r8, List<ShortcutTaskAction> r9, String r10, int r11, TaskKnowledge r12, String r13, String r14, boolean r15, String r16, int r17, int r18, long r19, long r21, Map<String, String> r23, String r24) {
        List<ShortcutTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, DBDefinition.TASK_ID);
        o.e(r3, "actions");
        o.e(r16, "sourceFrom");
        this.taskId = r8;
        this.actions = r3;
        this.name = r10;
        this.taskMode = r11;
        this.taskKnowledge = r12;
        this.templateId = r13;
        this.shortInstruct = r14;
        this.isShortInstructEnable = r15;
        this.sourceFrom = r16;
        this.taskStatus = r17;
        this.enableStatus = r18;
        this.createTime = r19;
        this.displayOrder = r21;
        this.ext = r4;
        this.omniModel = r24;
    }

    public /* synthetic */ ShortcutTaskBean(String r22, List r23, String r24, int r25, TaskKnowledge r26, String r27, String r28, boolean r29, String r30, int r31, int r32, long r33, long r35, Map r37, String r38, int r39, h r40) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r37, Map.class, "com.obric.aiagent.plugin");
        if ((r39 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r39 & 8) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r39 & 16) == 0) goto L13;
        TaskKnowledge r8 = null;
    L15:
        if ((r39 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r39 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r39 & 128) == 0) goto L25;
        boolean r11 = false;
    L27:
        if ((r39 & 512) == 0) goto L29;
        int r13 = 0;
    L31:
        if ((r39 & 1024) == 0) goto L33;
        int r14 = 0;
    L35:
        if ((r39 & 4096) == 0) goto L37;
        long r17 = r33;
    L39:
        if ((r39 & 8192) == 0) goto L41;
        Map r19 = null;
    L43:
        if ((r39 & 16384) == 0) goto L45;
        String r20 = null;
    L46:
        this(r22, r5, r6, r7, r8, r9, r10, r11, r30, r13, r14, r33, r17, r19, r20);
        return;
    L45:
        r20 = r38;
        goto L46
    L41:
        r19 = r1;
        goto L43
    L37:
        r17 = r35;
        goto L39
    L33:
        r14 = r32;
        goto L35
    L29:
        r13 = r31;
        goto L31
    L25:
        r11 = r29;
        goto L27
    L21:
        r10 = r28;
        goto L23
    L17:
        r9 = r27;
        goto L19
    L13:
        r8 = r26;
        goto L15
    L9:
        r7 = r25;
        goto L11
    L5:
        r6 = r24;
        goto L7
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String r2) {
        o.e(r2, "<set-?>");
        this.taskId = r2;
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
    }

    public final void setActions(List<ShortcutTaskAction> r3) {
        List<ShortcutTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.actions = r4;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final int getTaskMode() {
        return this.taskMode;
    }

    public final void setTaskMode(int r1) {
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

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    public final void setShortInstruct(String r1) {
        this.shortInstruct = r1;
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public final void setShortInstructEnable(boolean r1) {
        this.isShortInstructEnable = r1;
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
        o.a(r4, "null cannot be cast to non-null type com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskBean");
        ShortcutTaskBean r3 = (ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r4, ShortcutTaskBean.class, "com.obric.aiagent.plugin");
        return o.a(this.taskId, ((ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r4, ShortcutTaskBean.class, "com.obric.aiagent.plugin")).taskId);
    L9:
        r2 = null;
        goto L11
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.taskId});
    }
}
