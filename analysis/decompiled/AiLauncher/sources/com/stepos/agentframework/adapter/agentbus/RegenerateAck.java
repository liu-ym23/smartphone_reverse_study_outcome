package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0015\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/H;", "", "", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "()Z", w4.h.STATUS_STARTED, "Companion", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.H, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class RegenerateAck {
    public static final String STATUS_REGENERATING = "regenerating";
    private final String runId;
    private final String status;

    public RegenerateAck(String runId, String status) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(status, "status");
        this.runId = runId;
        this.status = status;
    }

    /* renamed from: a, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    public final boolean b() {
        return kotlin.jvm.internal.p.d(this.status, STATUS_REGENERATING);
    }

    /* renamed from: c, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegenerateAck)) {
            return false;
        }
        RegenerateAck regenerateAck = (RegenerateAck) other;
        return kotlin.jvm.internal.p.d(this.runId, regenerateAck.runId) && kotlin.jvm.internal.p.d(this.status, regenerateAck.status);
    }

    public int hashCode() {
        return (this.runId.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "RegenerateAck(runId=" + this.runId + ", status=" + this.status + ")";
    }
}
