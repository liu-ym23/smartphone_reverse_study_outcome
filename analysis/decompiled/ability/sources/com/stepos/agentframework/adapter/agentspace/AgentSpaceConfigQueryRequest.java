package com.stepos.agentframework.adapter.agentspace;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceConfigQueryRequest;", "", "appId", "", "key", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentSpaceConfigQueryRequest {
    private final String appId;
    private final String key;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentSpaceConfigQueryRequest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AgentSpaceConfigQueryRequest copy$default(AgentSpaceConfigQueryRequest agentSpaceConfigQueryRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentSpaceConfigQueryRequest.appId;
        }
        if ((i & 2) != 0) {
            str2 = agentSpaceConfigQueryRequest.key;
        }
        return agentSpaceConfigQueryRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final AgentSpaceConfigQueryRequest copy(String appId, String key) {
        k.f(appId, "appId");
        k.f(key, "key");
        return new AgentSpaceConfigQueryRequest(appId, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceConfigQueryRequest)) {
            return false;
        }
        AgentSpaceConfigQueryRequest agentSpaceConfigQueryRequest = (AgentSpaceConfigQueryRequest) other;
        return k.b(this.appId, agentSpaceConfigQueryRequest.appId) && k.b(this.key, agentSpaceConfigQueryRequest.key);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode() + (this.appId.hashCode() * 31);
    }

    public String toString() {
        return a.m("AgentSpaceConfigQueryRequest(appId=", this.appId, ", key=", this.key, ")");
    }

    public AgentSpaceConfigQueryRequest(String appId, String key) {
        k.f(appId, "appId");
        k.f(key, "key");
        this.appId = appId;
        this.key = key;
    }

    public /* synthetic */ AgentSpaceConfigQueryRequest(String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? "agentframework-app" : str, (i & 2) != 0 ? "feedback_options" : str2);
    }
}
