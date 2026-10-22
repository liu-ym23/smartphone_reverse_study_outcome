package com.stepos.ailauncher.agent.aispace.market.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/v;", "", "", "taskId", "", "commands", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getCommands", "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.v, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstallOrUpdateAgentData {

    @SerializedName("commands")
    private final List<Object> commands;

    @SerializedName(alternate = {"task_id"}, value = "taskId")
    private final String taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public InstallOrUpdateAgentData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallOrUpdateAgentData)) {
            return false;
        }
        InstallOrUpdateAgentData installOrUpdateAgentData = (InstallOrUpdateAgentData) other;
        return kotlin.jvm.internal.p.d(this.taskId, installOrUpdateAgentData.taskId) && kotlin.jvm.internal.p.d(this.commands, installOrUpdateAgentData.commands);
    }

    public int hashCode() {
        String str = this.taskId;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.commands.hashCode();
    }

    public String toString() {
        return "InstallOrUpdateAgentData(taskId=" + this.taskId + ", commands=" + this.commands + ")";
    }

    public InstallOrUpdateAgentData(String str, List<Object> commands) {
        kotlin.jvm.internal.p.i(commands, "commands");
        this.taskId = str;
        this.commands = commands;
    }

    public /* synthetic */ InstallOrUpdateAgentData(String str, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}
