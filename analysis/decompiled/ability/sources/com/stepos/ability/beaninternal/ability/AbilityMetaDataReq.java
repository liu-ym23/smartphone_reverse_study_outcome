package com.stepos.ability.beaninternal.ability;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;", "", "abilityId", "", "toolName", "", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAbilityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getToolName", "()Ljava/lang/String;", "getTraceId", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataReq;", "equals", "", "other", "hashCode", "", "toString", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityMetaDataReq {
    private final Long abilityId;
    private final String toolName;
    private final String traceId;

    public AbilityMetaDataReq() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AbilityMetaDataReq copy$default(AbilityMetaDataReq abilityMetaDataReq, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = abilityMetaDataReq.abilityId;
        }
        if ((i & 2) != 0) {
            str = abilityMetaDataReq.toolName;
        }
        if ((i & 4) != 0) {
            str2 = abilityMetaDataReq.traceId;
        }
        return abilityMetaDataReq.copy(l, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final AbilityMetaDataReq copy(Long abilityId, String toolName, String traceId) {
        return new AbilityMetaDataReq(abilityId, toolName, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetaDataReq)) {
            return false;
        }
        AbilityMetaDataReq abilityMetaDataReq = (AbilityMetaDataReq) other;
        return k.b(this.abilityId, abilityMetaDataReq.abilityId) && k.b(this.toolName, abilityMetaDataReq.toolName) && k.b(this.traceId, abilityMetaDataReq.traceId);
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        Long l = this.abilityId;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.toolName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        Long l = this.abilityId;
        String str = this.toolName;
        String str2 = this.traceId;
        StringBuilder sb = new StringBuilder("AbilityMetaDataReq(abilityId=");
        sb.append(l);
        sb.append(", toolName=");
        sb.append(str);
        sb.append(", traceId=");
        return a.q(sb, str2, ")");
    }

    public AbilityMetaDataReq(Long l, String str, String str2) {
        this.abilityId = l;
        this.toolName = str;
        this.traceId = str2;
    }

    public /* synthetic */ AbilityMetaDataReq(Long l, String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2);
    }
}
