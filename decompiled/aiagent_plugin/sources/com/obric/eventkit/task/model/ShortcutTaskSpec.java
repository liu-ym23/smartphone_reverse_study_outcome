package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ShortcutTaskSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ShortcutTaskSpec extends EventTaskSpec {
    private final List<ShortcutTaskAction> actions;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final Boolean isShortInstructEnable;
    private final String name;
    private String omniModel;
    private final String shortInstruct;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;

    public static /* synthetic */ ShortcutTaskSpec copy$default(ShortcutTaskSpec r13, String r14, Integer r15, TaskKnowledge r16, String r17, String r18, Integer r19, Integer r20, Map r21, String r22, Boolean r23, List r24, int r25, Object r26) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        List<ShortcutTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        if ((r25 & 1) == 0) goto L5;
        String r4 = r13.name;
    L7:
        if ((r25 & 2) == 0) goto L9;
        Integer r5 = r13.taskMode;
    L11:
        if ((r25 & 4) == 0) goto L13;
        TaskKnowledge r6 = r13.taskKnowledge;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r7 = r13.templateId;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r8 = r13.omniModel;
    L23:
        if ((r25 & 32) == 0) goto L25;
        Integer r9 = r13.taskStatus;
    L27:
        if ((r25 & 64) == 0) goto L29;
        Integer r10 = r13.enableStatus;
    L31:
        if ((r25 & 128) == 0) goto L34;
        r2 = r13.ext;
    L34:
        if ((r25 & 256) == 0) goto L36;
        String r11 = r13.shortInstruct;
    L38:
        if ((r25 & 512) == 0) goto L40;
        Boolean r12 = r13.isShortInstructEnable;
    L42:
        if ((r25 & 1024) == 0) goto L45;
        r3 = r13.actions;
    L45:
        return r13.copy(r4, r5, r6, r7, r8, r9, r10, r2, r11, r12, r3);
    L40:
        r12 = r23;
        goto L42
    L36:
        r11 = r22;
        goto L38
    L29:
        r10 = r20;
        goto L31
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
        r4 = r14;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final Boolean component10() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> component11() {
        return this.actions;
    }

    public final Integer component2() {
        return this.taskMode;
    }

    public final TaskKnowledge component3() {
        return this.taskKnowledge;
    }

    public final String component4() {
        return this.templateId;
    }

    public final String component5() {
        return this.omniModel;
    }

    public final Integer component6() {
        return this.taskStatus;
    }

    public final Integer component7() {
        return this.enableStatus;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final String component9() {
        return this.shortInstruct;
    }

    public final ShortcutTaskSpec copy(String r15, Integer r16, TaskKnowledge r17, String r18, String r19, Integer r20, Integer r21, Map<String, String> r22, String r23, Boolean r24, List<ShortcutTaskAction> r25) {
        return new ShortcutTaskSpec(r15, r16, r17, r18, r19, r20, r21, (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin"), r23, r24, (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTaskSpec.class) == true) goto L8;
        return false;
    L8:
        ShortcutTaskSpec r6 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r5, ShortcutTaskSpec.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.taskMode, r6.taskMode) == true) goto L15;
        return false;
    L15:
        if (o.a(this.taskKnowledge, r6.taskKnowledge) == true) goto L18;
        return false;
    L18:
        if (o.a(this.templateId, r6.templateId) == true) goto L21;
        return false;
    L21:
        if (o.a(this.omniModel, r6.omniModel) == true) goto L24;
        return false;
    L24:
        if (o.a(this.taskStatus, r6.taskStatus) == true) goto L27;
        return false;
    L27:
        if (o.a(this.enableStatus, r6.enableStatus) == true) goto L30;
        return false;
    L30:
        if (o.a(this.ext, r6.ext) == true) goto L33;
        return false;
    L33:
        if (o.a(this.shortInstruct, r6.shortInstruct) == true) goto L36;
        return false;
    L36:
        if (o.a(this.isShortInstructEnable, r6.isShortInstructEnable) == true) goto L39;
        return false;
    L39:
        if (o.a(this.actions, r6.actions) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.taskMode;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        TaskKnowledge r7 = this.taskKnowledge;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.templateId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.omniModel;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.taskStatus;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.enableStatus;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, String> r22 = this.ext;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.shortInstruct;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.isShortInstructEnable;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<ShortcutTaskAction> r31 = this.actions;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ShortcutTaskSpec(name=").append(this.name).append(", taskMode=").append(this.taskMode).append(", taskKnowledge=").append(this.taskKnowledge).append(", templateId=").append(this.templateId).append(", omniModel=").append(this.omniModel).append(", taskStatus=").append(this.taskStatus).append(", enableStatus=").append(this.enableStatus).append(", ext=").append(this.ext).append(", shortInstruct=").append(this.shortInstruct).append(", isShortInstructEnable=").append(this.isShortInstructEnable).append(", actions=").append(this.actions).append(')');
        return r0.toString();
    }

    public /* synthetic */ ShortcutTaskSpec(String r13, Integer r14, TaskKnowledge r15, String r16, String r17, Integer r18, Integer r19, Map r20, String r21, Boolean r22, List r23, int r24, h r25) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        if ((r24 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r24 & 4) == 0) goto L9;
        TaskKnowledge r5 = null;
    L11:
        if ((r24 & 8) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r24 & 16) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r24 & 32) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r24 & 64) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r24 & 128) == 0) goto L30;
        r1 = null;
    L30:
        if ((r24 & 256) == 0) goto L32;
        String r10 = null;
    L34:
        if ((r24 & 512) == 0) goto L36;
        Boolean r11 = null;
    L38:
        if ((r24 & 1024) == 0) goto L40;
        r2 = null;
    L40:
        this(r13, r3, r5, r6, r7, r8, r9, r1, r10, r11, r2);
        return;
    L36:
        r11 = r22;
        goto L38
    L32:
        r10 = r21;
        goto L34
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

    @Override // com.obric.eventkit.task.model.EventTaskSpec
    public Map<String, String> getExt() {
        return this.ext;
    }

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    public final Boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
    }

    public ShortcutTaskSpec(String r14, Integer r15, TaskKnowledge r16, String r17, String r18, Integer r19, Integer r20, Map<String, String> r21, String r22, Boolean r23, List<ShortcutTaskAction> r24) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        List<ShortcutTaskAction> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        super(3, r14, r15, r16, r17, r18, r19, r20, r11);
        this.name = r14;
        this.taskMode = r15;
        this.taskKnowledge = r16;
        this.templateId = r17;
        this.omniModel = r18;
        this.taskStatus = r19;
        this.enableStatus = r20;
        this.ext = r11;
        this.shortInstruct = r22;
        this.isShortInstructEnable = r23;
        this.actions = r12;
    }
}
