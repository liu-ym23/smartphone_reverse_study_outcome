package stepai.aios.guiagent.api;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lstepai/aios/guiagent/api/TaskResult;", "", "success", "", "message", "", "sessionId", "takeover", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;Z)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getSessionId", "getTakeover", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TaskResult {
    private final String message;
    private final String sessionId;
    private final boolean success;
    private final boolean takeover;

    public TaskResult() {
        this(false, null, null, false, 15, null);
    }

    public static /* synthetic */ TaskResult copy$default(TaskResult taskResult, boolean z10, String str, String str2, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = taskResult.success;
        }
        if ((i & 2) != 0) {
            str = taskResult.message;
        }
        if ((i & 4) != 0) {
            str2 = taskResult.sessionId;
        }
        if ((i & 8) != 0) {
            z11 = taskResult.takeover;
        }
        return taskResult.copy(z10, str, str2, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTakeover() {
        return this.takeover;
    }

    public final TaskResult copy(boolean success, String message, String sessionId, boolean takeover) {
        k.f(message, "message");
        k.f(sessionId, "sessionId");
        return new TaskResult(success, message, sessionId, takeover);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResult)) {
            return false;
        }
        TaskResult taskResult = (TaskResult) other;
        return this.success == taskResult.success && k.b(this.message, taskResult.message) && k.b(this.sessionId, taskResult.sessionId) && this.takeover == taskResult.takeover;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final boolean getTakeover() {
        return this.takeover;
    }

    public int hashCode() {
        return Boolean.hashCode(this.takeover) + a.c(a.c(Boolean.hashCode(this.success) * 31, 31, this.message), 31, this.sessionId);
    }

    public String toString() {
        return "TaskResult(success=" + this.success + ", message=" + this.message + ", sessionId=" + this.sessionId + ", takeover=" + this.takeover + ")";
    }

    public TaskResult(boolean z10, String message, String sessionId, boolean z11) {
        k.f(message, "message");
        k.f(sessionId, "sessionId");
        this.success = z10;
        this.message = message;
        this.sessionId = sessionId;
        this.takeover = z11;
    }

    public /* synthetic */ TaskResult(boolean z10, String str, String str2, boolean z11, int i, e eVar) {
        this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? false : z11);
    }
}
