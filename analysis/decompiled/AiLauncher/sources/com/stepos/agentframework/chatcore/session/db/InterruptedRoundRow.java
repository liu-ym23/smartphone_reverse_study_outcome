package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/B0;", "", "", "messageId", "sessionId", "", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "J", UxipConstants.f30686y, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.db.B0, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class InterruptedRoundRow {
    private final String messageId;
    private final String sessionId;
    private final long time;

    public InterruptedRoundRow(String messageId, String sessionId, long j10) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.time = j10;
    }

    /* renamed from: a, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: b, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterruptedRoundRow)) {
            return false;
        }
        InterruptedRoundRow interruptedRoundRow = (InterruptedRoundRow) other;
        return kotlin.jvm.internal.p.d(this.messageId, interruptedRoundRow.messageId) && kotlin.jvm.internal.p.d(this.sessionId, interruptedRoundRow.sessionId) && this.time == interruptedRoundRow.time;
    }

    public int hashCode() {
        return (((this.messageId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "InterruptedRoundRow(messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", time=" + this.time + ")";
    }
}
