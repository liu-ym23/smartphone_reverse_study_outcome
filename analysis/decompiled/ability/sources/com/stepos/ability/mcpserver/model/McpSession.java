package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpSession;", "", "sessionId", "", "createdAt", "", "lastActiveAt", AppAgent.CONSTRUCT, "(Ljava/lang/String;JJ)V", "getSessionId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getLastActiveAt", "setLastActiveAt", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McpSession {
    private final long createdAt;
    private long lastActiveAt;
    private final String sessionId;

    public McpSession(String sessionId, long j5, long j6) {
        k.f(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.createdAt = j5;
        this.lastActiveAt = j6;
    }

    public static /* synthetic */ McpSession copy$default(McpSession mcpSession, String str, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mcpSession.sessionId;
        }
        if ((i & 2) != 0) {
            j5 = mcpSession.createdAt;
        }
        if ((i & 4) != 0) {
            j6 = mcpSession.lastActiveAt;
        }
        return mcpSession.copy(str, j5, j6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastActiveAt() {
        return this.lastActiveAt;
    }

    public final McpSession copy(String sessionId, long createdAt, long lastActiveAt) {
        k.f(sessionId, "sessionId");
        return new McpSession(sessionId, createdAt, lastActiveAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpSession)) {
            return false;
        }
        McpSession mcpSession = (McpSession) other;
        return k.b(this.sessionId, mcpSession.sessionId) && this.createdAt == mcpSession.createdAt && this.lastActiveAt == mcpSession.lastActiveAt;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getLastActiveAt() {
        return this.lastActiveAt;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return Long.hashCode(this.lastActiveAt) + a.c(this.sessionId.hashCode() * 31, 31, this.createdAt);
    }

    public final void setLastActiveAt(long j5) {
        this.lastActiveAt = j5;
    }

    public String toString() {
        return "McpSession(sessionId=" + this.sessionId + ", createdAt=" + this.createdAt + ", lastActiveAt=" + this.lastActiveAt + ")";
    }
}
