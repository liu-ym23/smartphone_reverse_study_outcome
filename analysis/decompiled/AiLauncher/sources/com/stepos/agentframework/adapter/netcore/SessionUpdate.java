package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/v;", "", "", "sessionId", "label", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", c.a.COL_SEQ, "ts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "getTs", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.v, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionUpdate {
    private final String label;
    private final String runId;
    private final Long seq;
    private final String sessionId;
    private final Long ts;

    public SessionUpdate(String sessionId, String label, String str, Long l10, Long l11) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(label, "label");
        this.sessionId = sessionId;
        this.label = label;
        this.runId = str;
        this.seq = l10;
        this.ts = l11;
    }

    /* renamed from: a, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: b, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: c, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionUpdate)) {
            return false;
        }
        SessionUpdate sessionUpdate = (SessionUpdate) other;
        return kotlin.jvm.internal.p.d(this.sessionId, sessionUpdate.sessionId) && kotlin.jvm.internal.p.d(this.label, sessionUpdate.label) && kotlin.jvm.internal.p.d(this.runId, sessionUpdate.runId) && kotlin.jvm.internal.p.d(this.seq, sessionUpdate.seq) && kotlin.jvm.internal.p.d(this.ts, sessionUpdate.ts);
    }

    public int hashCode() {
        int iHashCode = ((this.sessionId.hashCode() * 31) + this.label.hashCode()) * 31;
        String str = this.runId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.seq;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.ts;
        return iHashCode3 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        return "SessionUpdate(sessionId=" + this.sessionId + ", label=" + this.label + ", runId=" + this.runId + ", seq=" + this.seq + ", ts=" + this.ts + ")";
    }
}
