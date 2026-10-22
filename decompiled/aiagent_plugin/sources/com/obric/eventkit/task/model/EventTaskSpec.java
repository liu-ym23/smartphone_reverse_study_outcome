package com.obric.eventkit.task.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public class EventTaskSpec {
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private String omniModel;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final int type;

    public EventTaskSpec(int r3, String r4, Integer r5, TaskKnowledge r6, String r7, String r8, Integer r9, Integer r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        this.type = r3;
        this.name = r4;
        this.taskMode = r5;
        this.taskKnowledge = r6;
        this.templateId = r7;
        this.omniModel = r8;
        this.taskStatus = r9;
        this.enableStatus = r10;
        this.ext = r12;
    }

    public /* synthetic */ EventTaskSpec(int r11, String r12, Integer r13, TaskKnowledge r14, String r15, String r16, Integer r17, Integer r18, Map r19, int r20, h r21) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        if ((r20 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r20 & 8) == 0) goto L13;
        TaskKnowledge r5 = null;
    L15:
        if ((r20 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r20 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r20 & 64) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r20 & 128) == 0) goto L29;
        Integer r9 = null;
    L31:
        if ((r20 & 256) == 0) goto L33;
        r1 = null;
    L33:
        this(r11, r2, r4, r5, r6, r7, r8, r9, r1);
        return;
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
        r2 = r12;
        goto L7
    }

    public final int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Integer getTaskMode() {
        return this.taskMode;
    }

    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getOmniModel() {
        return this.omniModel;
    }

    public void setOmniModel(String r1) {
        this.omniModel = r1;
    }

    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public Map<String, String> getExt() {
        return this.ext;
    }
}
