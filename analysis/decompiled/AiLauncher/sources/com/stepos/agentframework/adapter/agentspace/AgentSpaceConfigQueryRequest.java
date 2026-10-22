package com.stepos.agentframework.adapter.agentspace;

import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/c;", "", "", "pkgName", "appVersion", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPkgName", "getAppVersion", "getKey", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentspace.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentSpaceConfigQueryRequest {
    private final String appVersion;
    private final String key;
    private final String pkgName;

    public AgentSpaceConfigQueryRequest(String pkgName, String appVersion, String key) {
        p.i(pkgName, "pkgName");
        p.i(appVersion, "appVersion");
        p.i(key, "key");
        this.pkgName = pkgName;
        this.appVersion = appVersion;
        this.key = key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceConfigQueryRequest)) {
            return false;
        }
        AgentSpaceConfigQueryRequest agentSpaceConfigQueryRequest = (AgentSpaceConfigQueryRequest) other;
        return p.d(this.pkgName, agentSpaceConfigQueryRequest.pkgName) && p.d(this.appVersion, agentSpaceConfigQueryRequest.appVersion) && p.d(this.key, agentSpaceConfigQueryRequest.key);
    }

    public int hashCode() {
        return (((this.pkgName.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.key.hashCode();
    }

    public String toString() {
        return "AgentSpaceConfigQueryRequest(pkgName=" + this.pkgName + ", appVersion=" + this.appVersion + ", key=" + this.key + ")";
    }

    public /* synthetic */ AgentSpaceConfigQueryRequest(String str, String str2, String str3, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "feedback_options" : str3);
    }
}
