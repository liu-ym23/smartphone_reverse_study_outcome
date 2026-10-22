package com.stepos.agentframework.chatcore.audit;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/e;", "", "", "id", "decision", "", "Lcom/stepos/agentframework/chatcore/audit/b;", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getDecision", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.audit.e, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AuditResourceResult {
    private final String decision;
    private final String id;
    private final List<AuditReason> reason;

    public AuditResourceResult() {
        this(null, null, null, 7, null);
    }

    public final List<AuditReason> a() {
        return this.reason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditResourceResult)) {
            return false;
        }
        AuditResourceResult auditResourceResult = (AuditResourceResult) other;
        return p.d(this.id, auditResourceResult.id) && p.d(this.decision, auditResourceResult.decision) && p.d(this.reason, auditResourceResult.reason);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.decision;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<AuditReason> list = this.reason;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AuditResourceResult(id=" + this.id + ", decision=" + this.decision + ", reason=" + this.reason + ")";
    }

    public AuditResourceResult(String str, String str2, List<AuditReason> list) {
        this.id = str;
        this.decision = str2;
        this.reason = list;
    }

    public /* synthetic */ AuditResourceResult(String str, String str2, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : list);
    }
}
