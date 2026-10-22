package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/k;", "", "", "taskId", "envId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getEnvId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.net.k, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WecomStatusBody {

    @SerializedName("env_id")
    private final String envId;

    @SerializedName("task_id")
    private final String taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public WecomStatusBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WecomStatusBody)) {
            return false;
        }
        WecomStatusBody wecomStatusBody = (WecomStatusBody) other;
        return p.d(this.taskId, wecomStatusBody.taskId) && p.d(this.envId, wecomStatusBody.envId);
    }

    public int hashCode() {
        return (this.taskId.hashCode() * 31) + this.envId.hashCode();
    }

    public String toString() {
        return "WecomStatusBody(taskId=" + this.taskId + ", envId=" + this.envId + ")";
    }

    public WecomStatusBody(String taskId, String envId) {
        p.i(taskId, "taskId");
        p.i(envId, "envId");
        this.taskId = taskId;
        this.envId = envId;
    }

    public /* synthetic */ WecomStatusBody(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }
}
