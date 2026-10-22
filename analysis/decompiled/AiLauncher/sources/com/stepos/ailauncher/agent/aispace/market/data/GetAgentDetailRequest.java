package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/i;", "", "", "agentId", "version", "", "needReadme", "", "testing", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAgentId", "getVersion", "Z", "getNeedReadme", "()Z", "I", "getTesting", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetAgentDetailRequest {

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName("need_readme")
    private final boolean needReadme;

    @SerializedName("testing")
    private final int testing;

    @SerializedName("version")
    private final String version;

    public GetAgentDetailRequest(String agentId, String version, boolean z10, int i10) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(version, "version");
        this.agentId = agentId;
        this.version = version;
        this.needReadme = z10;
        this.testing = i10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAgentDetailRequest)) {
            return false;
        }
        GetAgentDetailRequest getAgentDetailRequest = (GetAgentDetailRequest) other;
        return kotlin.jvm.internal.p.d(this.agentId, getAgentDetailRequest.agentId) && kotlin.jvm.internal.p.d(this.version, getAgentDetailRequest.version) && this.needReadme == getAgentDetailRequest.needReadme && this.testing == getAgentDetailRequest.testing;
    }

    public int hashCode() {
        return (((((this.agentId.hashCode() * 31) + this.version.hashCode()) * 31) + Boolean.hashCode(this.needReadme)) * 31) + Integer.hashCode(this.testing);
    }

    public String toString() {
        return "GetAgentDetailRequest(agentId=" + this.agentId + ", version=" + this.version + ", needReadme=" + this.needReadme + ", testing=" + this.testing + ")";
    }
}
