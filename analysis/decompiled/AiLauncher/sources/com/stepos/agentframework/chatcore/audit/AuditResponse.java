package com.stepos.agentframework.chatcore.audit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/f;", "", "", "code", "", "message", "Lcom/stepos/agentframework/chatcore/audit/a;", "data", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/audit/a;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getMessage", "Lcom/stepos/agentframework/chatcore/audit/a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/audit/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.audit.f, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AuditResponse {
    private final Integer code;
    private final AuditData data;
    private final String message;

    public AuditResponse() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final AuditData getData() {
        return this.data;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditResponse)) {
            return false;
        }
        AuditResponse auditResponse = (AuditResponse) other;
        return p.d(this.code, auditResponse.code) && p.d(this.message, auditResponse.message) && p.d(this.data, auditResponse.data);
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        AuditData auditData = this.data;
        return iHashCode2 + (auditData != null ? auditData.hashCode() : 0);
    }

    public String toString() {
        return "AuditResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public AuditResponse(Integer num, String str, AuditData auditData) {
        this.code = num;
        this.message = str;
        this.data = auditData;
    }

    public /* synthetic */ AuditResponse(Integer num, String str, AuditData auditData, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : auditData);
    }
}
