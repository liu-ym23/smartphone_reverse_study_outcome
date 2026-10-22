package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeTerminalFields;", "", "approvalId", "", "sessionKey", "expectedVersion", "", "decision", "executionGrant", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getApprovalId", "()Ljava/lang/String;", "getSessionKey", "getExpectedVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDecision", "getExecutionGrant", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/stepos/ability/agentbusclient/ResumeTerminalFields;", "equals", "", "other", "hashCode", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ResumeTerminalFields {
    private final String approvalId;
    private final String decision;
    private final Map<String, Object> executionGrant;
    private final Integer expectedVersion;
    private final String sessionKey;

    public ResumeTerminalFields(String str, String str2, Integer num, String decision, Map<String, ? extends Object> map) {
        k.f(decision, "decision");
        this.approvalId = str;
        this.sessionKey = str2;
        this.expectedVersion = num;
        this.decision = decision;
        this.executionGrant = map;
    }

    public static /* synthetic */ ResumeTerminalFields copy$default(ResumeTerminalFields resumeTerminalFields, String str, String str2, Integer num, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resumeTerminalFields.approvalId;
        }
        if ((i & 2) != 0) {
            str2 = resumeTerminalFields.sessionKey;
        }
        if ((i & 4) != 0) {
            num = resumeTerminalFields.expectedVersion;
        }
        if ((i & 8) != 0) {
            str3 = resumeTerminalFields.decision;
        }
        if ((i & 16) != 0) {
            map = resumeTerminalFields.executionGrant;
        }
        Map map2 = map;
        Integer num2 = num;
        return resumeTerminalFields.copy(str, str2, num2, str3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getApprovalId() {
        return this.approvalId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getExpectedVersion() {
        return this.expectedVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    public final Map<String, Object> component5() {
        return this.executionGrant;
    }

    public final ResumeTerminalFields copy(String approvalId, String sessionKey, Integer expectedVersion, String decision, Map<String, ? extends Object> executionGrant) {
        k.f(decision, "decision");
        return new ResumeTerminalFields(approvalId, sessionKey, expectedVersion, decision, executionGrant);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResumeTerminalFields)) {
            return false;
        }
        ResumeTerminalFields resumeTerminalFields = (ResumeTerminalFields) other;
        return k.b(this.approvalId, resumeTerminalFields.approvalId) && k.b(this.sessionKey, resumeTerminalFields.sessionKey) && k.b(this.expectedVersion, resumeTerminalFields.expectedVersion) && k.b(this.decision, resumeTerminalFields.decision) && k.b(this.executionGrant, resumeTerminalFields.executionGrant);
    }

    public final String getApprovalId() {
        return this.approvalId;
    }

    public final String getDecision() {
        return this.decision;
    }

    public final Map<String, Object> getExecutionGrant() {
        return this.executionGrant;
    }

    public final Integer getExpectedVersion() {
        return this.expectedVersion;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public int hashCode() {
        String str = this.approvalId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sessionKey;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.expectedVersion;
        int iC = B7.a.c((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31, 31, this.decision);
        Map<String, Object> map = this.executionGrant;
        return iC + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        String str = this.approvalId;
        String str2 = this.sessionKey;
        Integer num = this.expectedVersion;
        String str3 = this.decision;
        Map<String, Object> map = this.executionGrant;
        StringBuilder sbW = B7.a.w("ResumeTerminalFields(approvalId=", str, ", sessionKey=", str2, ", expectedVersion=");
        sbW.append(num);
        sbW.append(", decision=");
        sbW.append(str3);
        sbW.append(", executionGrant=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }
}
