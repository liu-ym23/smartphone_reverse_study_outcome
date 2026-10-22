package com.stepos.agentframework.chatcore.audit;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001f\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/c;", "", "Lcom/stepos/agentframework/chatcore/audit/i;", "userInfo", "", "packageId", "", "async", "bizType", "onlyMachineAudit", "", "Lcom/stepos/agentframework/chatcore/audit/d;", "resources", "<init>", "(Lcom/stepos/agentframework/chatcore/audit/i;Ljava/lang/String;ZLjava/lang/String;ZLjava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/audit/i;", "getUserInfo", "()Lcom/stepos/agentframework/chatcore/audit/i;", "Ljava/lang/String;", "getPackageId", "Z", "getAsync", "()Z", "getBizType", "getOnlyMachineAudit", "Ljava/util/List;", "getResources", "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.audit.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AuditRequest {
    private final boolean async;
    private final String bizType;
    private final boolean onlyMachineAudit;
    private final String packageId;
    private final List<AuditResource> resources;
    private final AuditUserInfo userInfo;

    public AuditRequest(AuditUserInfo userInfo, String packageId, boolean z10, String bizType, boolean z11, List<AuditResource> resources) {
        p.i(userInfo, "userInfo");
        p.i(packageId, "packageId");
        p.i(bizType, "bizType");
        p.i(resources, "resources");
        this.userInfo = userInfo;
        this.packageId = packageId;
        this.async = z10;
        this.bizType = bizType;
        this.onlyMachineAudit = z11;
        this.resources = resources;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditRequest)) {
            return false;
        }
        AuditRequest auditRequest = (AuditRequest) other;
        return p.d(this.userInfo, auditRequest.userInfo) && p.d(this.packageId, auditRequest.packageId) && this.async == auditRequest.async && p.d(this.bizType, auditRequest.bizType) && this.onlyMachineAudit == auditRequest.onlyMachineAudit && p.d(this.resources, auditRequest.resources);
    }

    public int hashCode() {
        return (((((((((this.userInfo.hashCode() * 31) + this.packageId.hashCode()) * 31) + Boolean.hashCode(this.async)) * 31) + this.bizType.hashCode()) * 31) + Boolean.hashCode(this.onlyMachineAudit)) * 31) + this.resources.hashCode();
    }

    public String toString() {
        return "AuditRequest(userInfo=" + this.userInfo + ", packageId=" + this.packageId + ", async=" + this.async + ", bizType=" + this.bizType + ", onlyMachineAudit=" + this.onlyMachineAudit + ", resources=" + this.resources + ")";
    }
}
