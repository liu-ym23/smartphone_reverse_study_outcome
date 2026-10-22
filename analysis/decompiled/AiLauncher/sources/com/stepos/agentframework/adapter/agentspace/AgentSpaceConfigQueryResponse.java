package com.stepos.agentframework.adapter.agentspace;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/d;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "code", "I", Const.INTENT_KEY_APIKEY, "msg", "Ljava/lang/String;", "c", "Lcom/stepos/agentframework/adapter/agentspace/b;", "data", "Lcom/stepos/agentframework/adapter/agentspace/b;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/agentspace/b;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentspace.d, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentSpaceConfigQueryResponse {
    private final int code;
    private final AgentSpaceConfigItem data;
    private final String msg;

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final AgentSpaceConfigItem getData() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceConfigQueryResponse)) {
            return false;
        }
        AgentSpaceConfigQueryResponse agentSpaceConfigQueryResponse = (AgentSpaceConfigQueryResponse) other;
        return this.code == agentSpaceConfigQueryResponse.code && p.d(this.msg, agentSpaceConfigQueryResponse.msg) && p.d(this.data, agentSpaceConfigQueryResponse.data);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "AgentSpaceConfigQueryResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }
}
