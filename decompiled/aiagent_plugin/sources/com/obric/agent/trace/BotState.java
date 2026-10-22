package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: BotState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BotState {

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName("agent_name")
    private final String agentName;

    @SerializedName("awaiting")
    private final String awaitingId;

    @SerializedName("backwards")
    private final List<String> backwards;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("bot_name")
    private final String botName;

    @SerializedName("bot_version")
    private final String botVersion;

    @SerializedName(KnowledgeActivity.KEY_TASK_ID)
    private final String taskId;

    @SerializedName("thread_id")
    private final String threadId;

    public BotState() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ BotState copy$default(BotState r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, List r20, int r21, Object r22) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r3 = r11.botId;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = r11.botName;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = r11.taskId;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = r11.agentName;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r7 = r11.agentId;
    L23:
        if ((r21 & 32) == 0) goto L25;
        String r8 = r11.awaitingId;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r9 = r11.botVersion;
    L31:
        if ((r21 & 128) == 0) goto L33;
        String r10 = r11.threadId;
    L35:
        if ((r21 & 256) == 0) goto L37;
        List<String> r1 = r11.backwards;
    L39:
        return r11.copy(r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L37:
        r1 = r2;
        goto L39
    L33:
        r10 = r19;
        goto L35
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
        r3 = r12;
        goto L7
    }

    public final String component1() {
        return this.botId;
    }

    public final String component2() {
        return this.botName;
    }

    public final String component3() {
        return this.taskId;
    }

    public final String component4() {
        return this.agentName;
    }

    public final String component5() {
        return this.agentId;
    }

    public final String component6() {
        return this.awaitingId;
    }

    public final String component7() {
        return this.botVersion;
    }

    public final String component8() {
        return this.threadId;
    }

    public final List<String> component9() {
        return this.backwards;
    }

    public final BotState copy(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, List<String> r20) {
        return new BotState(r12, r13, r14, r15, r16, r17, r18, r19, (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BotState.class) == true) goto L8;
        return false;
    L8:
        BotState r6 = (BotState) ZeusTransformUtils.preCheckCast(r5, BotState.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.botId, r6.botId) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.botName, r6.botName) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.taskId, r6.taskId) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.agentName, r6.agentName) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.agentId, r6.agentId) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.awaitingId, r6.awaitingId) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.botVersion, r6.botVersion) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.threadId, r6.threadId) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.backwards, r6.backwards) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.botName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.taskId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.agentName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.agentId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.awaitingId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.botVersion;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.threadId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.backwards;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "BotState(botId=" + this.botId + ", botName=" + this.botName + ", taskId=" + this.taskId + ", agentName=" + this.agentName + ", agentId=" + this.agentId + ", awaitingId=" + this.awaitingId + ", botVersion=" + this.botVersion + ", threadId=" + this.threadId + ", backwards=" + this.backwards + ')';
    }

    public BotState(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, List<String> r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        this.botId = r3;
        this.botName = r4;
        this.taskId = r5;
        this.agentName = r6;
        this.agentId = r7;
        this.awaitingId = r8;
        this.botVersion = r9;
        this.threadId = r10;
        this.backwards = r12;
    }

    public /* synthetic */ BotState(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, List r20, int r21, d.h.b.h r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r21 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r21 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r21 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r21 & 256) == 0) goto L37;
        r1 = null;
    L37:
        this(r2, r4, r5, r6, r7, r8, r9, r10, r1);
        return;
    L33:
        r10 = r19;
        goto L35
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

    public final String getBotId() {
        return this.botId;
    }

    public final String getBotName() {
        return this.botName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAwaitingId() {
        return this.awaitingId;
    }

    public final String getBotVersion() {
        return this.botVersion;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final List<String> getBackwards() {
        return this.backwards;
    }
}
