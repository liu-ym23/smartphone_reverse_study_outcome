package stepai.aios.guiagent.config;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lstepai/aios/guiagent/config/SessionConfig;", "", "maxHistoryActions", "", "maxSessions", "sessionTimeoutMinutes", "autoSaveInterval", "", AppAgent.CONSTRUCT, "(IIIJ)V", "getMaxHistoryActions", "()I", "getMaxSessions", "getSessionTimeoutMinutes", "getAutoSaveInterval", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SessionConfig {
    private final long autoSaveInterval;
    private final int maxHistoryActions;
    private final int maxSessions;
    private final int sessionTimeoutMinutes;

    public SessionConfig() {
        this(0, 0, 0, 0L, 15, null);
    }

    public static /* synthetic */ SessionConfig copy$default(SessionConfig sessionConfig, int i, int i6, int i10, long j5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = sessionConfig.maxHistoryActions;
        }
        if ((i11 & 2) != 0) {
            i6 = sessionConfig.maxSessions;
        }
        if ((i11 & 4) != 0) {
            i10 = sessionConfig.sessionTimeoutMinutes;
        }
        if ((i11 & 8) != 0) {
            j5 = sessionConfig.autoSaveInterval;
        }
        int i12 = i10;
        return sessionConfig.copy(i, i6, i12, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxHistoryActions() {
        return this.maxHistoryActions;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxSessions() {
        return this.maxSessions;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSessionTimeoutMinutes() {
        return this.sessionTimeoutMinutes;
    }

    /* renamed from: component4, reason: from getter */
    public final long getAutoSaveInterval() {
        return this.autoSaveInterval;
    }

    public final SessionConfig copy(int maxHistoryActions, int maxSessions, int sessionTimeoutMinutes, long autoSaveInterval) {
        return new SessionConfig(maxHistoryActions, maxSessions, sessionTimeoutMinutes, autoSaveInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfig)) {
            return false;
        }
        SessionConfig sessionConfig = (SessionConfig) other;
        return this.maxHistoryActions == sessionConfig.maxHistoryActions && this.maxSessions == sessionConfig.maxSessions && this.sessionTimeoutMinutes == sessionConfig.sessionTimeoutMinutes && this.autoSaveInterval == sessionConfig.autoSaveInterval;
    }

    public final long getAutoSaveInterval() {
        return this.autoSaveInterval;
    }

    public final int getMaxHistoryActions() {
        return this.maxHistoryActions;
    }

    public final int getMaxSessions() {
        return this.maxSessions;
    }

    public final int getSessionTimeoutMinutes() {
        return this.sessionTimeoutMinutes;
    }

    public int hashCode() {
        return Long.hashCode(this.autoSaveInterval) + a.a(this.sessionTimeoutMinutes, a.a(this.maxSessions, Integer.hashCode(this.maxHistoryActions) * 31, 31), 31);
    }

    public String toString() {
        int i = this.maxHistoryActions;
        int i6 = this.maxSessions;
        int i10 = this.sessionTimeoutMinutes;
        long j5 = this.autoSaveInterval;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "SessionConfig(maxHistoryActions=", i6, ", maxSessions=", ", sessionTimeoutMinutes=");
        sbS.append(i10);
        sbS.append(", autoSaveInterval=");
        sbS.append(j5);
        sbS.append(")");
        return sbS.toString();
    }

    public SessionConfig(int i, int i6, int i10, long j5) {
        this.maxHistoryActions = i;
        this.maxSessions = i6;
        this.sessionTimeoutMinutes = i10;
        this.autoSaveInterval = j5;
    }

    public /* synthetic */ SessionConfig(int i, int i6, int i10, long j5, int i11, e eVar) {
        this((i11 & 1) != 0 ? 50 : i, (i11 & 2) != 0 ? 100 : i6, (i11 & 4) != 0 ? 30 : i10, (i11 & 8) != 0 ? 60000L : j5);
    }
}
