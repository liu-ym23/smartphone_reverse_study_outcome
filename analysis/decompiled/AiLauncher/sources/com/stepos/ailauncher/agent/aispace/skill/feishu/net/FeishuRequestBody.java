package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/l;", "", "", "action", "taskId", "envId", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAction", "getTaskId", "getEnvId", "getReason", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.l, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeishuRequestBody {

    @SerializedName("action")
    private final String action;

    @SerializedName("envId")
    private final String envId;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("taskId")
    private final String taskId;

    public FeishuRequestBody() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeishuRequestBody)) {
            return false;
        }
        FeishuRequestBody feishuRequestBody = (FeishuRequestBody) other;
        return kotlin.jvm.internal.p.d(this.action, feishuRequestBody.action) && kotlin.jvm.internal.p.d(this.taskId, feishuRequestBody.taskId) && kotlin.jvm.internal.p.d(this.envId, feishuRequestBody.envId) && kotlin.jvm.internal.p.d(this.reason, feishuRequestBody.reason);
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.envId.hashCode()) * 31) + this.reason.hashCode();
    }

    public String toString() {
        return "FeishuRequestBody(action=" + this.action + ", taskId=" + this.taskId + ", envId=" + this.envId + ", reason=" + this.reason + ")";
    }

    public FeishuRequestBody(String action, String taskId, String envId, String reason) {
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(envId, "envId");
        kotlin.jvm.internal.p.i(reason, "reason");
        this.action = action;
        this.taskId = taskId;
        this.envId = envId;
        this.reason = reason;
    }

    public /* synthetic */ FeishuRequestBody(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
